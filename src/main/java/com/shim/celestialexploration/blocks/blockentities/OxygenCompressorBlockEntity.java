package com.shim.celestialexploration.blocks.blockentities;

import com.google.common.collect.Maps;
import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestialexploration.inventory.menus.OxygenCompressorMenu;
import com.shim.celestialexploration.registry.BlockEntityRegistry;
import com.shim.celestialexploration.registry.ItemRegistry;
import net.minecraft.SharedConstants;
import net.minecraft.Util;
import net.minecraft.core.*;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.Containers;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.WorldlyContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.annotation.Nonnull;
import java.util.Map;
import java.util.Random;

public class OxygenCompressorBlockEntity extends BlockEntity implements MenuProvider {
    int litTime;
    int burnTime = 250; //FIXME TEMP

    private final ItemStackHandler itemHandler = new ItemStackHandler(4) {
        @Override
        protected void onContentsChanged(int slot) {
            setChanged();
        }
    };

    private LazyOptional<IItemHandler> lazyItemHandler = LazyOptional.empty();

    public OxygenCompressorBlockEntity(BlockPos pWorldPosition, BlockState pBlockState) {
        super(BlockEntityRegistry.OXYGEN_COMPRESSOR_BLOCK_ENTITY.get(), pWorldPosition, pBlockState);
    }

    @Override
    public Component getDisplayName() {
        return new TextComponent("Oxygen Compressor");
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int containerId, Inventory inventory, Player player) {
        return new OxygenCompressorMenu(containerId, inventory, this);
    }

    @Nonnull
    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @javax.annotation.Nullable Direction side) {
        if (cap == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {
            return lazyItemHandler.cast();
        }

        return super.getCapability(cap, side);
    }

    @Override
    public void onLoad() {
        super.onLoad();
        lazyItemHandler = LazyOptional.of(() -> itemHandler);
    }

    @Override
    public void invalidateCaps() {
        super.invalidateCaps();
        lazyItemHandler.invalidate();
    }

    @Override
    protected void saveAdditional(@NotNull CompoundTag tag) {
        tag.put("inventory", itemHandler.serializeNBT());
        super.saveAdditional(tag);
    }

    @Override
    public void load(CompoundTag nbt) {
        super.load(nbt);
        itemHandler.deserializeNBT(nbt.getCompound("inventory"));
    }

    public void drops() {
        SimpleContainer inventory = new SimpleContainer(itemHandler.getSlots());
        for (int i = 0; i < itemHandler.getSlots(); i++) {
            inventory.setItem(i, itemHandler.getStackInSlot(i));
        }

        Containers.dropContents(this.level, this.worldPosition, inventory);
    }

    public boolean isLit() {
        return this.litTime > 0;
    }

    public int getLitProgress() {
        return this.litTime;
    }

    public int getBurnProgress() {
        return this.burnTime;
    }



//    private boolean canBurn(@Nullable Recipe<?> p_155006_, NonNullList<ItemStack> p_155007_, int p_155008_) {
//        if (!p_155007_.get(0).isEmpty() && p_155006_ != null) {
//            ItemStack itemstack = ((Recipe<WorldlyContainer>) p_155006_).assemble(this);
//            if (itemstack.isEmpty()) {
//                return false;
//            } else {
//                ItemStack itemstack1 = p_155007_.get(2);
//                if (itemstack1.isEmpty()) {
//                    return true;
//                } else if (!itemstack1.sameItem(itemstack)) {
//                    return false;
//                } else if (itemstack1.getCount() + itemstack.getCount() <= p_155008_ && itemstack1.getCount() + itemstack.getCount() <= itemstack1.getMaxStackSize()) { // Forge fix: make furnace respect stack sizes in furnace recipes
//                    return true;
//                } else {
//                    return itemstack1.getCount() + itemstack.getCount() <= itemstack.getMaxStackSize(); // Forge fix: make furnace respect stack sizes in furnace recipes
//                }
//            }
//        } else {
//            return false;
//        }
//    }

//    private boolean burn(@Nullable Recipe<?> p_155027_, NonNullList<ItemStack> p_155028_, int p_155029_) {
//        if (p_155027_ != null && this.canBurn(p_155027_, p_155028_, p_155029_)) {
//            ItemStack itemstack = p_155028_.get(0);
//            ItemStack itemstack1 = ((Recipe<WorldlyContainer>) p_155027_).assemble(this);
//            ItemStack itemstack2 = p_155028_.get(2);
//            if (itemstack2.isEmpty()) {
//                p_155028_.set(2, itemstack1.copy());
//            } else if (itemstack2.is(itemstack1.getItem())) {
//                itemstack2.grow(itemstack1.getCount());
//            }
//
////            if (itemstack.is(Blocks.WET_SPONGE.asItem()) && !p_155028_.get(1).isEmpty() && p_155028_.get(1).is(Items.BUCKET)) {
////                p_155028_.set(1, new ItemStack(Items.WATER_BUCKET));
////            }
//
//            itemstack.shrink(1);
//            return true;
//        } else {
//            return false;
//        }
//    }

//    protected int getBurnDuration(ItemStack p_58343_) {
//        if (p_58343_.isEmpty()) {
//            return 0;
//        } else {
//            Item item = p_58343_.getItem();
//            return net.minecraftforge.common.ForgeHooks.getBurnTime(p_58343_, this.recipeType);
//        }
//    }

    public static Map<Item, Integer> getFuel() {
        Map<Item, Integer> map = Maps.newLinkedHashMap();
        add(map, Items.LAVA_BUCKET, 20000);
        add(map, Blocks.COAL_BLOCK, 16000);
        add(map, Items.BLAZE_ROD, 2400);
        add(map, Items.COAL, 1600);
        add(map, Items.CHARCOAL, 1600);
        add(map, ItemTags.LOGS, 300);
        add(map, ItemTags.PLANKS, 300);
        add(map, ItemTags.WOODEN_STAIRS, 300);
        add(map, ItemTags.WOODEN_SLABS, 150);
        add(map, ItemTags.WOODEN_TRAPDOORS, 300);
        add(map, ItemTags.WOODEN_PRESSURE_PLATES, 300);
        add(map, Blocks.OAK_FENCE, 300);
        add(map, Blocks.BIRCH_FENCE, 300);
        add(map, Blocks.SPRUCE_FENCE, 300);
        add(map, Blocks.JUNGLE_FENCE, 300);
        add(map, Blocks.DARK_OAK_FENCE, 300);
        add(map, Blocks.ACACIA_FENCE, 300);
        add(map, Blocks.OAK_FENCE_GATE, 300);
        add(map, Blocks.BIRCH_FENCE_GATE, 300);
        add(map, Blocks.SPRUCE_FENCE_GATE, 300);
        add(map, Blocks.JUNGLE_FENCE_GATE, 300);
        add(map, Blocks.DARK_OAK_FENCE_GATE, 300);
        add(map, Blocks.ACACIA_FENCE_GATE, 300);
        add(map, Blocks.NOTE_BLOCK, 300);
        add(map, Blocks.BOOKSHELF, 300);
        add(map, Blocks.LECTERN, 300);
        add(map, Blocks.JUKEBOX, 300);
        add(map, Blocks.CHEST, 300);
        add(map, Blocks.TRAPPED_CHEST, 300);
        add(map, Blocks.CRAFTING_TABLE, 300);
        add(map, Blocks.DAYLIGHT_DETECTOR, 300);
        add(map, ItemTags.BANNERS, 300);
        add(map, Items.BOW, 300);
        add(map, Items.FISHING_ROD, 300);
        add(map, Blocks.LADDER, 300);
        add(map, ItemTags.SIGNS, 200);
        add(map, Items.WOODEN_SHOVEL, 200);
        add(map, Items.WOODEN_SWORD, 200);
        add(map, Items.WOODEN_HOE, 200);
        add(map, Items.WOODEN_AXE, 200);
        add(map, Items.WOODEN_PICKAXE, 200);
        add(map, ItemTags.WOODEN_DOORS, 200);
        add(map, ItemTags.BOATS, 1200);
        add(map, ItemTags.WOOL, 100);
        add(map, ItemTags.WOODEN_BUTTONS, 100);
        add(map, Items.STICK, 100);
        add(map, ItemTags.SAPLINGS, 100);
        add(map, Items.BOWL, 100);
        add(map, ItemTags.CARPETS, 67);
        add(map, Blocks.DRIED_KELP_BLOCK, 4001);
        add(map, Items.CROSSBOW, 300);
        add(map, Blocks.BAMBOO, 50);
        add(map, Blocks.DEAD_BUSH, 100);
        add(map, Blocks.SCAFFOLDING, 400);
        add(map, Blocks.LOOM, 300);
        add(map, Blocks.BARREL, 300);
        add(map, Blocks.CARTOGRAPHY_TABLE, 300);
        add(map, Blocks.FLETCHING_TABLE, 300);
        add(map, Blocks.SMITHING_TABLE, 300);
        add(map, Blocks.COMPOSTER, 300);
        add(map, Blocks.AZALEA, 100);
        add(map, Blocks.FLOWERING_AZALEA, 100);
        return map;
    }

    private boolean isBurnableFuel(Map<Item, Integer> fuelMap, Item item) {
        if (fuelMap.containsKey(item)) {
            return true;
        } else {
            return false;
        }
    }

    private static int getBurnDuration(Map<Item, Integer> fuelMap, Item item) {
        if (fuelMap.containsKey(item)) {
            return fuelMap.get(item);
        } else {
            return 0;
        }
    }

    private static boolean isNeverAFurnaceFuel(Item p_58398_) {
        return p_58398_.builtInRegistryHolder().is(ItemTags.NON_FLAMMABLE_WOOD);
    }

    private static void add(Map<Item, Integer> p_204303_, TagKey<Item> p_204304_, int p_204305_) {
        for (Holder<Item> holder : Registry.ITEM.getTagOrEmpty(p_204304_)) {
            if (!isNeverAFurnaceFuel(holder.value())) {
                p_204303_.put(holder.value(), p_204305_);
            }
        }
    }

    private static void add(Map<Item, Integer> p_58375_, ItemLike p_58376_, int p_58377_) {
        Item item = p_58376_.asItem();
        if (isNeverAFurnaceFuel(item)) {
            if (SharedConstants.IS_RUNNING_IN_IDE) {
                throw (IllegalStateException) Util.pauseInIde(new IllegalStateException("A developer tried to explicitly make fire resistant item " + item.getName((ItemStack) null).getString() + " a furnace fuel. That will not work!"));
            }
        } else {
            p_58375_.put(item, p_58377_);
        }
    }

    public static void tick(Level level, BlockPos pos, BlockState state, OxygenCompressorBlockEntity blockEntity) {

        boolean hasTankInSlot = blockEntity.itemHandler.getStackInSlot(1).getItem() == ItemRegistry.LOX_TANK.get();
        ItemStack fuelSlot = blockEntity.itemHandler.getStackInSlot(0);
        //FIXME don't use up current burn fuel item until a tank has been placed in slot

        if (blockEntity.litTime == 0) {
            if (!fuelSlot.isEmpty()) {
                if (blockEntity.isBurnableFuel(getFuel(), fuelSlot.getItem())) {
                    blockEntity.litTime = getBurnDuration(blockEntity.getFuel(), blockEntity.itemHandler.getStackInSlot(0).getItem());
                    blockEntity.itemHandler.extractItem(0, 1, false);
                }
            }
        } else { //litTime > 0

            if (hasTankInSlot) {
                --blockEntity.litTime;
                --blockEntity.burnTime;
                if (blockEntity.burnTime <= 0) {

                    blockEntity.itemHandler.setStackInSlot(1, new ItemStack(ItemRegistry.FILLED_LOX_TANK.get(), 1));
                    blockEntity.burnTime = 250;
                    //TODO add fullness to tank instead of replacing
                    //TODO add multiple slots
                }
            } else {
                --blockEntity.litTime;
            }
        }
//            if (!fuelSlot.isEmpty() && blockEntity.isBurnableFuel(getFuel(), fuelSlot.getItem())) {
//                CelestialExploration.LOGGER.debug("Fuel slot not empty, item is burnable!");
//
//                blockEntity.itemHandler.extractItem(0, 1, false);
////                if (blockEntity.itemHandler.getStackInSlot(0).getCount() > 0) {
////                    CelestialExploration.LOGGER.debug("item is greater than 0!");
//
//                blockEntity.burnDuration = getBurnDuration(blockEntity.getFuel(), blockEntity.itemHandler.getStackInSlot(0).getItem());
//                blockEntity.litTime =
////                }
//            }
//        }
//        if (blockEntity.burnDuration > 0 && blockEntity.isLit() && hasTankInSlot) { //TODO check if tank is not full //TODO add multiple slots to be filled one at a time
//            CelestialExploration.LOGGER.debug("Fuel slot not empty, fuel is burnable, is lit, has tank in slot!");
//
//            --blockEntity.litTime;
//            //TODO increase tank fullness by 1(?)
//            --blockEntity.burnTime; //FIXME TEMP
//            if (blockEntity.burnTime == 0) { //FIXME TEMP
//                CelestialExploration.LOGGER.debug("burn time is 0!");
//
//                blockEntity.itemHandler.setStackInSlot(1, new ItemStack(ItemRegistry.FILLED_LOX_TANK.get(), 1));
//                if (!fuelSlot.isEmpty()) {
//                    blockEntity.burnTime = 10;
//                }
//            }
//        }
//        if (blockEntity.burnDuration == 0) {
//            blockEntity.itemHandler.extractItem(0, 1, false);
//        }


//        if (blockEntity.litTime == 0) {
//            if (!fuelSlot.isEmpty() && blockEntity.isBurnableFuel(getFuel(), fuelSlot.getItem())) {
//                CelestialExploration.LOGGER.debug("Fuel slot not empty, item is burnable!");
//
//                blockEntity.itemHandler.extractItem(0, 1, false);
////                if (blockEntity.itemHandler.getStackInSlot(0).getCount() > 0) {
////                    CelestialExploration.LOGGER.debug("item is greater than 0!");
//
//                blockEntity.burnDuration = getBurnDuration(blockEntity.getFuel(), blockEntity.itemHandler.getStackInSlot(0).getItem());
//                blockEntity.litTime =
////                }
//            }
//        }
//        if (blockEntity.burnDuration > 0 && blockEntity.isLit() && hasTankInSlot) { //TODO check if tank is not full //TODO add multiple slots to be filled one at a time
//            CelestialExploration.LOGGER.debug("Fuel slot not empty, fuel is burnable, is lit, has tank in slot!");
//
//            --blockEntity.litTime;
//            //TODO increase tank fullness by 1(?)
//            --blockEntity.burnTime; //FIXME TEMP
//            if (blockEntity.burnTime == 0) { //FIXME TEMP
//                CelestialExploration.LOGGER.debug("burn time is 0!");
//
//                blockEntity.itemHandler.setStackInSlot(1, new ItemStack(ItemRegistry.FILLED_LOX_TANK.get(), 1));
//                if (!fuelSlot.isEmpty()) {
//                    blockEntity.burnTime = 10;
//                }
//            }
//        }
//        if (blockEntity.burnDuration == 0) {
//            blockEntity.itemHandler.extractItem(0, 1, false);
//        }


//        entity.itemHandler.extractItem(0, 1, false);
//        entity.itemHandler.extractItem(1, 1, false);
////        entity.itemHandler.getStackInSlot(1).hurt(1, new Random(), null);
//
////        entity.itemHandler.insertItem(2, new ItemStack(ItemRegistry.FILLED_LOX_TANK.get()), true);
//        entity.itemHandler.setStackInSlot(1, new ItemStack(ItemRegistry.FILLED_LOX_TANK.get(),
//                entity.itemHandler.getStackInSlot(1).getCount() + 1));
//    }


//        if (hasRecipe(blockEntity) && hasNotReachedStackLimit(blockEntity)) {
//            craftItem(blockEntity);
//        }
//
//
//        boolean lit = blockEntity.isLit();
//        boolean flag1 = false;
//        if (blockEntity.isLit()) {
//            --blockEntity.litTime;
//        }
////
//        ItemStack itemstack = blockEntity.items.get(1);
//        if (blockEntity.isLit() || !itemstack.isEmpty() && !blockEntity.items.get(0).isEmpty()) {
////            Recipe<?> recipe = level.getRecipeManager().getRecipeFor((RecipeType<AbstractCookingRecipe>)blockEntity.recipeType, blockEntity, level).orElse(null);
//            int i = blockEntity.getMaxStackSize();
//            if (!blockEntity.isLit() && blockEntity.canBurn(recipe, blockEntity.items, i)) {
//                blockEntity.litTime = blockEntity.getBurnDuration(itemstack);
//                blockEntity.litDuration = blockEntity.litTime;
//                if (blockEntity.isLit()) {
//                    flag1 = true;
//                    if (itemstack.hasContainerItem())
//                        blockEntity.items.set(1, itemstack.getContainerItem());
//                    else if (!itemstack.isEmpty()) {
//                        Item item = itemstack.getItem();
//                        itemstack.shrink(1);
//                        if (itemstack.isEmpty()) {
//                            blockEntity.items.set(1, itemstack.getContainerItem());
//                        }
//                    }
//                }
//            }
//
//
//            if (blockEntity.isLit() && blockEntity.canBurn(recipe, blockEntity.items, i)) {
//                ++blockEntity.cookingProgress;
//                if (blockEntity.cookingProgress == blockEntity.cookingTotalTime) {
//                    blockEntity.cookingProgress = 0;
//                    blockEntity.cookingTotalTime = getTotalCookTime(level, blockEntity.recipeType, blockEntity);
//                    if (blockEntity.burn(recipe, blockEntity.items, i)) {
//                        blockEntity.setRecipeUsed(recipe);
//                    }
//
//                    flag1 = true;
//                }
//            } else {
//                blockEntity.cookingProgress = 0;
//            }
//        } else if (!blockEntity.isLit() && blockEntity.cookingProgress > 0) {
//            blockEntity.cookingProgress = Mth.clamp(blockEntity.cookingProgress - 2, 0, blockEntity.cookingTotalTime);
//        }
//
//        if (flag != blockEntity.isLit()) {
//            flag1 = true;
//            state = state.setValue(OxygenCompressorBlock.LIT, Boolean.valueOf(blockEntity.isLit()));
//            level.setBlock(pos, state, 3);
//        }
//
//        if (flag1) {
//            setChanged(level, pos, state);
//        }


    }

    private static void craftItem(OxygenCompressorBlockEntity entity) { //FIXME
        entity.itemHandler.extractItem(0, 1, false);
        entity.itemHandler.extractItem(1, 1, false);
//        entity.itemHandler.getStackInSlot(1).hurt(1, new Random(), null);

//        entity.itemHandler.insertItem(2, new ItemStack(ItemRegistry.FILLED_LOX_TANK.get()), true);
        entity.itemHandler.setStackInSlot(1, new ItemStack(ItemRegistry.FILLED_LOX_TANK.get(),
                entity.itemHandler.getStackInSlot(1).getCount() + 1));
    }

    private static boolean hasRecipe(OxygenCompressorBlockEntity entity) { //FIXME
//        boolean hasItemInWaterSlot = PotionUtils.getPotion(entity.itemHandler.getStackInSlot(0)) == Potions.WATER;
        boolean hasItemInFirstSlot = entity.itemHandler.getStackInSlot(1).getItem() == ItemRegistry.LOX_TANK.get();
//        boolean hasItemInSecondSlot = entity.itemHandler.getStackInSlot(2).getItem() == ModItems.GEM_CUTTER_TOOL.get();

        return hasItemInFirstSlot;
//        return hasItemInWaterSlot && hasItemInFirstSlot;// && hasItemInSecondSlot;
    }

    private static boolean hasNotReachedStackLimit(OxygenCompressorBlockEntity entity) {
        return entity.itemHandler.getStackInSlot(2).getCount() < entity.itemHandler.getStackInSlot(2).getMaxStackSize();
    }
}


//        extends BaseContainerBlockEntity implements WorldlyContainer, RecipeHolder, StackedContentsCompatible {
//    protected static final int SLOT_INPUT = 0;
//    protected static final int SLOT_FUEL = 1;
//    protected static final int SLOT_RESULT = 2;
//    public static final int DATA_LIT_TIME = 0;
//    private static final int[] SLOTS_FOR_UP = new int[]{0};
//    private static final int[] SLOTS_FOR_DOWN = new int[]{2, 1};
//    private static final int[] SLOTS_FOR_SIDES = new int[]{1};
//    public static final int DATA_LIT_DURATION = 1;
//    public static final int DATA_COOKING_PROGRESS = 2;
//    public static final int DATA_COOKING_TOTAL_TIME = 3;
//    public static final int NUM_DATA_VALUES = 4;
//    public static final int BURN_TIME_STANDARD = 200;
//    public static final int BURN_COOL_SPEED = 2;
//    protected NonNullList<ItemStack> items = NonNullList.withSize(3, ItemStack.EMPTY);
//    int litTime;
//    int litDuration;
//    int cookingProgress;
//    int cookingTotalTime;
//    protected final ContainerData dataAccess = new ContainerData() {
//        public int get(int p_58431_) {
//            switch(p_58431_) {
//                case 0:
//                    return OxygenCompressorBlockEntity.this.litTime;
//                case 1:
//                    return OxygenCompressorBlockEntity.this.litDuration;
//                case 2:
//                    return OxygenCompressorBlockEntity.this.cookingProgress;
//                case 3:
//                    return OxygenCompressorBlockEntity.this.cookingTotalTime;
//                default:
//                    return 0;
//            }
//        }
//
//        public void set(int p_58433_, int p_58434_) {
//            switch(p_58433_) {
//                case 0:
//                    OxygenCompressorBlockEntity.this.litTime = p_58434_;
//                    break;
//                case 1:
//                    OxygenCompressorBlockEntity.this.litDuration = p_58434_;
//                    break;
//                case 2:
//                    OxygenCompressorBlockEntity.this.cookingProgress = p_58434_;
//                    break;
//                case 3:
//                    OxygenCompressorBlockEntity.this.cookingTotalTime = p_58434_;
//            }
//
//        }
//
//        public int getCount() {
//            return 4;
//        }
//    };
//    private final Object2IntOpenHashMap<ResourceLocation> recipesUsed = new Object2IntOpenHashMap<>();
//    private final RecipeType<? extends AbstractCookingRecipe> recipeType;
//
//    public OxygenCompressorBlockEntity(BlockEntityType<?> p_154991_, BlockPos p_154992_, BlockState p_154993_, RecipeType<? extends AbstractCookingRecipe> p_154994_) {
//        super(p_154991_, p_154992_, p_154993_);
//        this.recipeType = p_154994_;
//    }
//    public OxygenCompressorBlockEntity(BlockPos p_155545_, BlockState p_155546_) {
//        this(BlockEntityRegistry.OXYGEN_COMPRESSOR_BLOCK_ENTITY.get(), p_155545_, p_155546_, RecipeType.SMELTING);
//    }
//
//
//    /**@deprecated Forge: get burn times by calling ForgeHooks#getBurnTime(ItemStack)*/ @Deprecated
//    public static Map<Item, Integer> getFuel() {
//        Map<Item, Integer> map = Maps.newLinkedHashMap();
//        add(map, Items.LAVA_BUCKET, 20000);
//        add(map, Blocks.COAL_BLOCK, 16000);
//        add(map, Items.BLAZE_ROD, 2400);
//        add(map, Items.COAL, 1600);
//        add(map, Items.CHARCOAL, 1600);
//        add(map, ItemTags.LOGS, 300);
//        add(map, ItemTags.PLANKS, 300);
//        add(map, ItemTags.WOODEN_STAIRS, 300);
//        add(map, ItemTags.WOODEN_SLABS, 150);
//        add(map, ItemTags.WOODEN_TRAPDOORS, 300);
//        add(map, ItemTags.WOODEN_PRESSURE_PLATES, 300);
//        add(map, Blocks.OAK_FENCE, 300);
//        add(map, Blocks.BIRCH_FENCE, 300);
//        add(map, Blocks.SPRUCE_FENCE, 300);
//        add(map, Blocks.JUNGLE_FENCE, 300);
//        add(map, Blocks.DARK_OAK_FENCE, 300);
//        add(map, Blocks.ACACIA_FENCE, 300);
//        add(map, Blocks.OAK_FENCE_GATE, 300);
//        add(map, Blocks.BIRCH_FENCE_GATE, 300);
//        add(map, Blocks.SPRUCE_FENCE_GATE, 300);
//        add(map, Blocks.JUNGLE_FENCE_GATE, 300);
//        add(map, Blocks.DARK_OAK_FENCE_GATE, 300);
//        add(map, Blocks.ACACIA_FENCE_GATE, 300);
//        add(map, Blocks.NOTE_BLOCK, 300);
//        add(map, Blocks.BOOKSHELF, 300);
//        add(map, Blocks.LECTERN, 300);
//        add(map, Blocks.JUKEBOX, 300);
//        add(map, Blocks.CHEST, 300);
//        add(map, Blocks.TRAPPED_CHEST, 300);
//        add(map, Blocks.CRAFTING_TABLE, 300);
//        add(map, Blocks.DAYLIGHT_DETECTOR, 300);
//        add(map, ItemTags.BANNERS, 300);
//        add(map, Items.BOW, 300);
//        add(map, Items.FISHING_ROD, 300);
//        add(map, Blocks.LADDER, 300);
//        add(map, ItemTags.SIGNS, 200);
//        add(map, Items.WOODEN_SHOVEL, 200);
//        add(map, Items.WOODEN_SWORD, 200);
//        add(map, Items.WOODEN_HOE, 200);
//        add(map, Items.WOODEN_AXE, 200);
//        add(map, Items.WOODEN_PICKAXE, 200);
//        add(map, ItemTags.WOODEN_DOORS, 200);
//        add(map, ItemTags.BOATS, 1200);
//        add(map, ItemTags.WOOL, 100);
//        add(map, ItemTags.WOODEN_BUTTONS, 100);
//        add(map, Items.STICK, 100);
//        add(map, ItemTags.SAPLINGS, 100);
//        add(map, Items.BOWL, 100);
//        add(map, ItemTags.CARPETS, 67);
//        add(map, Blocks.DRIED_KELP_BLOCK, 4001);
//        add(map, Items.CROSSBOW, 300);
//        add(map, Blocks.BAMBOO, 50);
//        add(map, Blocks.DEAD_BUSH, 100);
//        add(map, Blocks.SCAFFOLDING, 400);
//        add(map, Blocks.LOOM, 300);
//        add(map, Blocks.BARREL, 300);
//        add(map, Blocks.CARTOGRAPHY_TABLE, 300);
//        add(map, Blocks.FLETCHING_TABLE, 300);
//        add(map, Blocks.SMITHING_TABLE, 300);
//        add(map, Blocks.COMPOSTER, 300);
//        add(map, Blocks.AZALEA, 100);
//        add(map, Blocks.FLOWERING_AZALEA, 100);
//        return map;
//    }
//
//    private static boolean isNeverAFurnaceFuel(Item p_58398_) {
//        return p_58398_.builtInRegistryHolder().is(ItemTags.NON_FLAMMABLE_WOOD);
//    }
//
//    private static void add(Map<Item, Integer> p_204303_, TagKey<Item> p_204304_, int p_204305_) {
//        for(Holder<Item> holder : Registry.ITEM.getTagOrEmpty(p_204304_)) {
//            if (!isNeverAFurnaceFuel(holder.value())) {
//                p_204303_.put(holder.value(), p_204305_);
//            }
//        }
//
//    }
//
//    private static void add(Map<Item, Integer> p_58375_, ItemLike p_58376_, int p_58377_) {
//        Item item = p_58376_.asItem();
//        if (isNeverAFurnaceFuel(item)) {
//            if (SharedConstants.IS_RUNNING_IN_IDE) {
//                throw (IllegalStateException) Util.pauseInIde(new IllegalStateException("A developer tried to explicitly make fire resistant item " + item.getName((ItemStack)null).getString() + " a furnace fuel. That will not work!"));
//            }
//        } else {
//            p_58375_.put(item, p_58377_);
//        }
//    }
//
//    private boolean isLit() {
//        return this.litTime > 0;
//    }
//
//    public void load(CompoundTag p_155025_) {
//        super.load(p_155025_);
//        this.items = NonNullList.withSize(this.getContainerSize(), ItemStack.EMPTY);
//        ContainerHelper.loadAllItems(p_155025_, this.items);
//        this.litTime = p_155025_.getInt("BurnTime");
//        this.cookingProgress = p_155025_.getInt("CookTime");
//        this.cookingTotalTime = p_155025_.getInt("CookTimeTotal");
//        this.litDuration = this.getBurnDuration(this.items.get(1));
//        CompoundTag compoundtag = p_155025_.getCompound("RecipesUsed");
//
//        for(String s : compoundtag.getAllKeys()) {
//            this.recipesUsed.put(new ResourceLocation(s), compoundtag.getInt(s));
//        }
//
//    }
//
//    protected void saveAdditional(CompoundTag p_187452_) {
//        super.saveAdditional(p_187452_);
//        p_187452_.putInt("BurnTime", this.litTime);
//        p_187452_.putInt("CookTime", this.cookingProgress);
//        p_187452_.putInt("CookTimeTotal", this.cookingTotalTime);
//        ContainerHelper.saveAllItems(p_187452_, this.items);
//        CompoundTag compoundtag = new CompoundTag();
//        this.recipesUsed.forEach((p_187449_, p_187450_) -> {
//            compoundtag.putInt(p_187449_.toString(), p_187450_);
//        });
//        p_187452_.put("RecipesUsed", compoundtag);
//    }
//
//    public static void serverTick(Level p_155014_, BlockPos p_155015_, BlockState p_155016_, OxygenCompressorBlockEntity p_155017_) {
//        boolean flag = p_155017_.isLit();
//        boolean flag1 = false;
//        if (p_155017_.isLit()) {
//            --p_155017_.litTime;
//        }
//
//        ItemStack itemstack = p_155017_.items.get(1);
//        if (p_155017_.isLit() || !itemstack.isEmpty() && !p_155017_.items.get(0).isEmpty()) {
//            Recipe<?> recipe = p_155014_.getRecipeManager().getRecipeFor((RecipeType<AbstractCookingRecipe>)p_155017_.recipeType, p_155017_, p_155014_).orElse(null);
//            int i = p_155017_.getMaxStackSize();
//            if (!p_155017_.isLit() && p_155017_.canBurn(recipe, p_155017_.items, i)) {
//                p_155017_.litTime = p_155017_.getBurnDuration(itemstack);
//                p_155017_.litDuration = p_155017_.litTime;
//                if (p_155017_.isLit()) {
//                    flag1 = true;
//                    if (itemstack.hasContainerItem())
//                        p_155017_.items.set(1, itemstack.getContainerItem());
//                    else
//                    if (!itemstack.isEmpty()) {
//                        Item item = itemstack.getItem();
//                        itemstack.shrink(1);
//                        if (itemstack.isEmpty()) {
//                            p_155017_.items.set(1, itemstack.getContainerItem());
//                        }
//                    }
//                }
//            }
//
//            if (p_155017_.isLit() && p_155017_.canBurn(recipe, p_155017_.items, i)) {
//                ++p_155017_.cookingProgress;
//                if (p_155017_.cookingProgress == p_155017_.cookingTotalTime) {
//                    p_155017_.cookingProgress = 0;
//                    p_155017_.cookingTotalTime = getTotalCookTime(p_155014_, p_155017_.recipeType, p_155017_);
//                    if (p_155017_.burn(recipe, p_155017_.items, i)) {
//                        p_155017_.setRecipeUsed(recipe);
//                    }
//
//                    flag1 = true;
//                }
//            } else {
//                p_155017_.cookingProgress = 0;
//            }
//        } else if (!p_155017_.isLit() && p_155017_.cookingProgress > 0) {
//            p_155017_.cookingProgress = Mth.clamp(p_155017_.cookingProgress - 2, 0, p_155017_.cookingTotalTime);
//        }
//
//        if (flag != p_155017_.isLit()) {
//            flag1 = true;
//            p_155016_ = p_155016_.setValue(OxygenCompressorBlock.LIT, Boolean.valueOf(p_155017_.isLit()));
//            p_155014_.setBlock(p_155015_, p_155016_, 3);
//        }
//
//        if (flag1) {
//            setChanged(p_155014_, p_155015_, p_155016_);
//        }
//
//    }
//
//    private boolean canBurn(@Nullable Recipe<?> p_155006_, NonNullList<ItemStack> p_155007_, int p_155008_) {
//        if (!p_155007_.get(0).isEmpty() && p_155006_ != null) {
//            ItemStack itemstack = ((Recipe<WorldlyContainer>) p_155006_).assemble(this);
//            if (itemstack.isEmpty()) {
//                return false;
//            } else {
//                ItemStack itemstack1 = p_155007_.get(2);
//                if (itemstack1.isEmpty()) {
//                    return true;
//                } else if (!itemstack1.sameItem(itemstack)) {
//                    return false;
//                } else if (itemstack1.getCount() + itemstack.getCount() <= p_155008_ && itemstack1.getCount() + itemstack.getCount() <= itemstack1.getMaxStackSize()) { // Forge fix: make furnace respect stack sizes in furnace recipes
//                    return true;
//                } else {
//                    return itemstack1.getCount() + itemstack.getCount() <= itemstack.getMaxStackSize(); // Forge fix: make furnace respect stack sizes in furnace recipes
//                }
//            }
//        } else {
//            return false;
//        }
//    }
//
//    private boolean burn(@Nullable Recipe<?> p_155027_, NonNullList<ItemStack> p_155028_, int p_155029_) {
//        if (p_155027_ != null && this.canBurn(p_155027_, p_155028_, p_155029_)) {
//            ItemStack itemstack = p_155028_.get(0);
//            ItemStack itemstack1 = ((Recipe<WorldlyContainer>) p_155027_).assemble(this);
//            ItemStack itemstack2 = p_155028_.get(2);
//            if (itemstack2.isEmpty()) {
//                p_155028_.set(2, itemstack1.copy());
//            } else if (itemstack2.is(itemstack1.getItem())) {
//                itemstack2.grow(itemstack1.getCount());
//            }
//
//            if (itemstack.is(Blocks.WET_SPONGE.asItem()) && !p_155028_.get(1).isEmpty() && p_155028_.get(1).is(Items.BUCKET)) {
//                p_155028_.set(1, new ItemStack(Items.WATER_BUCKET));
//            }
//
//            itemstack.shrink(1);
//            return true;
//        } else {
//            return false;
//        }
//    }
//
//    protected int getBurnDuration(ItemStack p_58343_) {
//        if (p_58343_.isEmpty()) {
//            return 0;
//        } else {
//            Item item = p_58343_.getItem();
//            return net.minecraftforge.common.ForgeHooks.getBurnTime(p_58343_, this.recipeType);
//        }
//    }
//
//    private static int getTotalCookTime(Level p_155010_, RecipeType<? extends AbstractCookingRecipe> p_155011_, Container p_155012_) {
//        return p_155010_.getRecipeManager().getRecipeFor((RecipeType<AbstractCookingRecipe>)p_155011_, p_155012_, p_155010_).map(AbstractCookingRecipe::getCookingTime).orElse(200);
//    }
//
//    public static boolean isFuel(ItemStack p_58400_) {
//        return net.minecraftforge.common.ForgeHooks.getBurnTime(p_58400_, null) > 0;
//    }
//
//    public int[] getSlotsForFace(Direction p_58363_) {
//        if (p_58363_ == Direction.DOWN) {
//            return SLOTS_FOR_DOWN;
//        } else {
//            return p_58363_ == Direction.UP ? SLOTS_FOR_UP : SLOTS_FOR_SIDES;
//        }
//    }
//
//    public boolean canPlaceItemThroughFace(int p_58336_, ItemStack p_58337_, @Nullable Direction p_58338_) {
//        return this.canPlaceItem(p_58336_, p_58337_);
//    }
//
//    public boolean canTakeItemThroughFace(int p_58392_, ItemStack p_58393_, Direction p_58394_) {
//        if (p_58394_ == Direction.DOWN && p_58392_ == 1) {
//            return p_58393_.is(Items.WATER_BUCKET) || p_58393_.is(Items.BUCKET);
//        } else {
//            return true;
//        }
//    }
//
//    public int getContainerSize() {
//        return this.items.size();
//    }
//
//    public boolean isEmpty() {
//        for(ItemStack itemstack : this.items) {
//            if (!itemstack.isEmpty()) {
//                return false;
//            }
//        }
//
//        return true;
//    }
//
//    public ItemStack getItem(int p_58328_) {
//        return this.items.get(p_58328_);
//    }
//
//    public ItemStack removeItem(int p_58330_, int p_58331_) {
//        return ContainerHelper.removeItem(this.items, p_58330_, p_58331_);
//    }
//
//    public ItemStack removeItemNoUpdate(int p_58387_) {
//        return ContainerHelper.takeItem(this.items, p_58387_);
//    }
//
//    public void setItem(int p_58333_, ItemStack p_58334_) {
//        ItemStack itemstack = this.items.get(p_58333_);
//        boolean flag = !p_58334_.isEmpty() && p_58334_.sameItem(itemstack) && ItemStack.tagMatches(p_58334_, itemstack);
//        this.items.set(p_58333_, p_58334_);
//        if (p_58334_.getCount() > this.getMaxStackSize()) {
//            p_58334_.setCount(this.getMaxStackSize());
//        }
//
//        if (p_58333_ == 0 && !flag) {
//            this.cookingTotalTime = getTotalCookTime(this.level, this.recipeType, this);
//            this.cookingProgress = 0;
//            this.setChanged();
//        }
//
//    }
//
//    public boolean stillValid(Player p_58340_) {
//        if (this.level.getBlockEntity(this.worldPosition) != this) {
//            return false;
//        } else {
//            return p_58340_.distanceToSqr((double)this.worldPosition.getX() + 0.5D, (double)this.worldPosition.getY() + 0.5D, (double)this.worldPosition.getZ() + 0.5D) <= 64.0D;
//        }
//    }
//
//    public boolean canPlaceItem(int p_58389_, ItemStack p_58390_) {
//        if (p_58389_ == 2) {
//            return false;
//        } else if (p_58389_ != 1) {
//            return true;
//        } else {
//            ItemStack itemstack = this.items.get(1);
//            return net.minecraftforge.common.ForgeHooks.getBurnTime(p_58390_, this.recipeType) > 0 || p_58390_.is(Items.BUCKET) && !itemstack.is(Items.BUCKET);
//        }
//    }
//
//    public void clearContent() {
//        this.items.clear();
//    }
//
//    public void setRecipeUsed(@Nullable Recipe<?> p_58345_) {
//        if (p_58345_ != null) {
//            ResourceLocation resourcelocation = p_58345_.getId();
//            this.recipesUsed.addTo(resourcelocation, 1);
//        }
//
//    }
//
//    @Nullable
//    public Recipe<?> getRecipeUsed() {
//        return null;
//    }
//
//    public void awardUsedRecipes(Player p_58396_) {
//    }
//
//    public void awardUsedRecipesAndPopExperience(ServerPlayer p_155004_) {
//        List<Recipe<?>> list = this.getRecipesToAwardAndPopExperience(p_155004_.getLevel(), p_155004_.position());
//        p_155004_.awardRecipes(list);
//        this.recipesUsed.clear();
//    }
//
//    public List<Recipe<?>> getRecipesToAwardAndPopExperience(ServerLevel p_154996_, Vec3 p_154997_) {
//        List<Recipe<?>> list = Lists.newArrayList();
//
//        for(Object2IntMap.Entry<ResourceLocation> entry : this.recipesUsed.object2IntEntrySet()) {
//            p_154996_.getRecipeManager().byKey(entry.getKey()).ifPresent((p_155023_) -> {
//                list.add(p_155023_);
//                createExperience(p_154996_, p_154997_, entry.getIntValue(), ((AbstractCookingRecipe)p_155023_).getExperience());
//            });
//        }
//
//        return list;
//    }
//
//    private static void createExperience(ServerLevel p_154999_, Vec3 p_155000_, int p_155001_, float p_155002_) {
//        int i = Mth.floor((float)p_155001_ * p_155002_);
//        float f = Mth.frac((float)p_155001_ * p_155002_);
//        if (f != 0.0F && Math.random() < (double)f) {
//            ++i;
//        }
//
//        ExperienceOrb.award(p_154999_, p_155000_, i);
//    }
//
//    public void fillStackedContents(StackedContents p_58342_) {
//        for(ItemStack itemstack : this.items) {
//            p_58342_.accountStack(itemstack);
//        }
//
//    }
//
//    net.minecraftforge.common.util.LazyOptional<? extends net.minecraftforge.items.IItemHandler>[] handlers =
//            net.minecraftforge.items.wrapper.SidedInvWrapper.create(this, Direction.UP, Direction.DOWN, Direction.NORTH);
//
//    @Override
//    public <T> net.minecraftforge.common.util.LazyOptional<T> getCapability(net.minecraftforge.common.capabilities.Capability<T> capability, @Nullable Direction facing) {
//        if (!this.remove && facing != null && capability == net.minecraftforge.items.CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {
//            if (facing == Direction.UP)
//                return handlers[0].cast();
//            else if (facing == Direction.DOWN)
//                return handlers[1].cast();
//            else
//                return handlers[2].cast();
//        }
//        return super.getCapability(capability, facing);
//    }
//
//    @Override
//    public void invalidateCaps() {
//        super.invalidateCaps();
//        for (int x = 0; x < handlers.length; x++)
//            handlers[x].invalidate();
//    }
//
//    @Override
//    public void reviveCaps() {
//        super.reviveCaps();
//        this.handlers = net.minecraftforge.items.wrapper.SidedInvWrapper.create(this, Direction.UP, Direction.DOWN, Direction.NORTH);
//    }
//
//    protected Component getDefaultName() {
//        return new TranslatableComponent("container.oxygen_compressor");
//    }
//
//    protected AbstractContainerMenu createMenu(int p_59293_, Inventory p_59294_) {
//        return new OxygenCompressorMenu(p_59293_, p_59294_, this, this.dataAccess);
//    }
//
//}
