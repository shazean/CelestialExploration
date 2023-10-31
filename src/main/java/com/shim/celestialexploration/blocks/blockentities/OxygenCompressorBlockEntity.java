package com.shim.celestialexploration.blocks.blockentities;

import com.google.common.collect.Maps;
import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestialexploration.blocks.LoxTankBlock;
import com.shim.celestialexploration.blocks.OxygenCompressorBlock;
import com.shim.celestialexploration.capabilities.LoxTankCapability;
import com.shim.celestialexploration.inventory.menus.OxygenCompressorMenu;
import com.shim.celestialexploration.registry.BlockEntityRegistry;
import com.shim.celestialexploration.registry.CapabilityRegistry;
import com.shim.celestialexploration.registry.ItemRegistry;
import net.minecraft.SharedConstants;
import net.minecraft.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.Containers;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.annotation.Nonnull;
import java.util.Map;

public class OxygenCompressorBlockEntity extends BlockEntity implements MenuProvider {
    int litTime;
    int litTotalTime;
    int burnTime = 250;
    int burnMaxTime = burnTime;

    private final ItemStackHandler itemHandler = new ItemStackHandler(7) {
        @Override
        protected void onContentsChanged(int slot) {
            setChanged();
        }
    };

    private LazyOptional<IItemHandler> lazyItemHandler = LazyOptional.empty();

    public OxygenCompressorBlockEntity(BlockPos worldPosition, BlockState blockState) {
        super(BlockEntityRegistry.OXYGEN_COMPRESSOR_BLOCK_ENTITY.get(), worldPosition, blockState);
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

//        tag.putInt("LitTime", this.litTime);
//        tag.putInt("LitTotalTime", this.litTotalTime);
//        tag.putInt("BurnTime", this.burnTime);

        super.saveAdditional(tag);
    }

    @Override
    public void load(CompoundTag nbt) {
        super.load(nbt);

//        this.litTime = nbt.getInt("LitTime");
//        this.litTotalTime = nbt.getInt("LitTotalTime");
//        this.burnTime = nbt.getInt("BurnTime");
//        int burnMaxTime = nbt.getInt("BurnMaxTime");

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

    public int getLitTotalTime() {
        return this.litTotalTime;
    }

    public int getBurnProgress() {
        return this.burnTime;
    }

    public int getBurnMaxTime() {
        return this.burnMaxTime;
    }

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

    private void resetBurnTime(OxygenCompressorBlockEntity entity) {
        entity.burnTime = 250;
    }

    public static void tick(Level level, BlockPos pos, BlockState state, OxygenCompressorBlockEntity blockEntity) {

            boolean hasTankInSlot = blockEntity.itemHandler.getStackInSlot(1).getItem() == ItemRegistry.LOX_TANK.get() || blockEntity.itemHandler.getStackInSlot(2).getItem() == ItemRegistry.LOX_TANK.get() || blockEntity.itemHandler.getStackInSlot(3).getItem() == ItemRegistry.LOX_TANK.get() || blockEntity.itemHandler.getStackInSlot(4).getItem() == ItemRegistry.LOX_TANK.get();
            ItemStack fuelItem = blockEntity.itemHandler.getStackInSlot(0);

            if (blockEntity.litTime == 0) {
                state = state.setValue(OxygenCompressorBlock.LIT, blockEntity.isLit());
                level.setBlock(pos, state, 3);
                blockEntity.resetBurnTime(blockEntity);

                blockEntity.litTotalTime = 0;
                if (!fuelItem.isEmpty() && hasTankInSlot) {
//                    if (blockEntity.isBurnableFuel(getFuel(), fuelSlot.getItem())) {
                        blockEntity.litTime = ForgeHooks.getBurnTime(fuelItem, RecipeType.SMELTING);
                        blockEntity.itemHandler.extractItem(0, 1, false);
                        blockEntity.litTotalTime = ForgeHooks.getBurnTime(fuelItem, RecipeType.SMELTING);
//                    }
                }
            } else { //litTime > 0
                state = state.setValue(OxygenCompressorBlock.LIT, blockEntity.isLit());
                level.setBlock(pos, state, 3);
                if (hasTankInSlot) {
                    --blockEntity.litTime;
                    --blockEntity.burnTime;
                    if (blockEntity.burnTime <= 0) {
                        ItemStack firstSlot = blockEntity.itemHandler.getStackInSlot(1);
                        ItemStack secondSlot = blockEntity.itemHandler.getStackInSlot(2);
                        ItemStack thirdSlot = blockEntity.itemHandler.getStackInSlot(3);
                        ItemStack fourthSlot = blockEntity.itemHandler.getStackInSlot(4);

                        LoxTankCapability.ILoxTank loxTank = CelestialExploration.getCapability(firstSlot, CapabilityRegistry.LOX_TANK_CAPABILITY);
                        LoxTankCapability.ILoxTank secondloxTank = CelestialExploration.getCapability(secondSlot, CapabilityRegistry.LOX_TANK_CAPABILITY);
                        LoxTankCapability.ILoxTank thirdloxTank = CelestialExploration.getCapability(thirdSlot, CapabilityRegistry.LOX_TANK_CAPABILITY);
                        LoxTankCapability.ILoxTank fourthloxTank = CelestialExploration.getCapability(fourthSlot, CapabilityRegistry.LOX_TANK_CAPABILITY);

                        if (loxTank != null && !loxTank.isFull()) {
                            loxTank.incrementAmount();
                            blockEntity.resetBurnTime(blockEntity);
                        } else if (secondloxTank != null && !secondloxTank.isFull()) {
                            secondloxTank.incrementAmount();
                            blockEntity.resetBurnTime(blockEntity);
                        } else if (thirdloxTank != null && !thirdloxTank.isFull()) {
                            thirdloxTank.incrementAmount();
                            blockEntity.resetBurnTime(blockEntity);
                        } else if (fourthloxTank != null && !fourthloxTank.isFull()) {
                            fourthloxTank.incrementAmount();
                            blockEntity.resetBurnTime(blockEntity);
                        }
                    }
                } else {
                    blockEntity.resetBurnTime(blockEntity);
                    --blockEntity.litTime;
                }
            }
            setChanged(level, pos, state);
    }
}