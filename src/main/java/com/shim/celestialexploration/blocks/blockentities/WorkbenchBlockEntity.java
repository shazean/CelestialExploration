package com.shim.celestialexploration.blocks.blockentities;

import com.ibm.icu.text.AlphabeticIndex;
import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestialexploration.inventory.menus.WorkbenchMenu;
import com.shim.celestialexploration.recipes.WorkbenchSmeltingRecipe;
import com.shim.celestialexploration.registry.BlockEntityRegistry;
import com.shim.celestialexploration.registry.FluidRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.util.Mth;
import net.minecraft.world.Containers;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.AbstractFurnaceBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluids;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.fluids.FluidAttributes;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.capability.CapabilityFluidHandler;
import net.minecraftforge.fluids.capability.IFluidHandler;
import net.minecraftforge.fluids.capability.templates.FluidTank;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.lwjgl.system.CallbackI;

import javax.annotation.Nonnull;
import java.util.Optional;

public class WorkbenchBlockEntity extends BlockEntity implements MenuProvider {
    protected final ContainerData data;
    private int progress = 0;
    private int maxProgress = 100;
    private int fuelBurnTime = 0;
    private int maxFuelBurnTime;
    private int fluidLevel;
    private int maxFluidLevel = FluidAttributes.BUCKET_VOLUME * 8;
    private int fluidType;

    private final ItemStackHandler itemHandler = new ItemStackHandler(12) {
        @Override
        protected void onContentsChanged(int slot) {
            setChanged();
        }
    };

    protected FluidTank fluidHandler = new FluidTank(maxFluidLevel);

    private LazyOptional<IFluidHandler> lazyFluidHandler = LazyOptional.of(() -> fluidHandler);
    private LazyOptional<IItemHandler> lazyItemHandler = LazyOptional.empty();

    public WorkbenchBlockEntity(BlockPos worldPosition, BlockState blockState) {
        super(BlockEntityRegistry.WORKBENCH_BLOCK_ENTITY.get(), worldPosition, blockState);
        this.data = new ContainerData() {
            public int get(int index) {
                return switch (index) {
                    case 0 -> WorkbenchBlockEntity.this.progress;
                    case 1 -> WorkbenchBlockEntity.this.maxProgress;
                    case 2 -> WorkbenchBlockEntity.this.fuelBurnTime;
                    case 3 -> WorkbenchBlockEntity.this.maxFuelBurnTime;
                    case 4 -> WorkbenchBlockEntity.this.fluidLevel;
                    case 5 -> WorkbenchBlockEntity.this.maxFluidLevel;
                    case 6 -> WorkbenchBlockEntity.this.fluidType;
                    default -> 0;
                };
            }
            public void set(int index, int value) {
                switch (index) {
                    case 0 -> WorkbenchBlockEntity.this.progress = value;
                    case 1 -> WorkbenchBlockEntity.this.maxProgress = value;
                    case 2 -> WorkbenchBlockEntity.this.fuelBurnTime = value;
                    case 3 -> WorkbenchBlockEntity.this.maxFuelBurnTime = value;
                    case 4 -> WorkbenchBlockEntity.this.fluidLevel = value;
                    case 5 -> WorkbenchBlockEntity.this.maxFluidLevel = value;
                    case 6 -> WorkbenchBlockEntity.this.fluidType = value;
                }
            }
            public int getCount() {
                return 7;
            }
        };

    }

    public FluidTank getFluidTank() {
        return fluidHandler;
    }

    @Override
    public @NotNull Component getDisplayName() {
        return new TextComponent("Workbench");
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int containerId, Inventory inventory, Player player) {
        return new WorkbenchMenu(containerId, inventory, this, this.data, ContainerLevelAccess.create(player.getLevel(), this.getBlockPos()));
    }

    @Nonnull
    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @javax.annotation.Nullable Direction side) {
        if (cap == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {
            return lazyItemHandler.cast();
        }
        if (cap == CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY) {
            return lazyFluidHandler.cast();
        }
        return super.getCapability(cap, side);
    }

    @Override
    public void onLoad() {
        super.onLoad();
        lazyItemHandler = LazyOptional.of(() -> itemHandler);
        lazyFluidHandler = LazyOptional.of(() -> fluidHandler);
    }

    @Override
    public void invalidateCaps() {
        super.invalidateCaps();
        lazyItemHandler.invalidate();
        lazyFluidHandler.invalidate();
    }

    @Override
    protected void saveAdditional(@NotNull CompoundTag tag) {
        tag.put("inventory", itemHandler.serializeNBT());
        tag.putInt("workbench_smelting.progress", progress);
        tag.putInt("workbench_smelting.fuelBurnTime", fuelBurnTime);
        tag.putInt("workbench_smelting.fluidLevel", fluidLevel);
        tag.putInt("workbench_smelting.fluidType", fluidType);

        fluidHandler.writeToNBT(tag);
        super.saveAdditional(tag);
    }

    @Override
    public void load(@NotNull CompoundTag nbt) {
        super.load(nbt);
        fluidHandler.readFromNBT(nbt);
        itemHandler.deserializeNBT(nbt.getCompound("inventory"));
        progress = nbt.getInt("workbench_smelting.progress");
        fuelBurnTime = nbt.getInt("workbench_smelting.fuelBurnTime");
        fluidLevel = nbt.getInt("workbench_smelting.fluidLevel");
        fluidType = nbt.getInt("workbench_smelting.fluidType");
//        fluidHandler.setFluid(getFluidTypeFromIndex(fluidType, fluidLevel));
    }

    public void drops() {
        SimpleContainer inventory = new SimpleContainer(itemHandler.getSlots());
        for (int i = 0; i < itemHandler.getSlots(); i++) {
            inventory.setItem(i, itemHandler.getStackInSlot(i));
        }

        assert this.level != null;
        Containers.dropContents(this.level, this.worldPosition, inventory);
    }

    public static void tick(Level level, BlockPos pos, BlockState state, WorkbenchBlockEntity blockEntity) {
       boolean lit = blockEntity.isLit();
       boolean changed = false;
        SimpleContainer inventory = new SimpleContainer(blockEntity.itemHandler.getSlots());

        if (blockEntity.fluidHandler.getFluidAmount() <= 100) {
            blockEntity.fluidHandler.drain(blockEntity.fluidHandler.getFluid(), IFluidHandler.FluidAction.EXECUTE);
            blockEntity.fluidLevel = 0;
        }

        for (int i = 0; i < blockEntity.itemHandler.getSlots(); i++) {
            inventory.setItem(i, blockEntity.itemHandler.getStackInSlot(i));
        }

       if (lit) {
           blockEntity.fuelBurnTime--;
       }

       ItemStack fuelItem = blockEntity.itemHandler.getStackInSlot(1);
       ItemStack smeltItem = blockEntity.itemHandler.getStackInSlot(0);

       if (smeltItem.getItem() instanceof BucketItem && hasRecipe(blockEntity)) {
           smeltItem(blockEntity);
           blockEntity.itemHandler.setStackInSlot(0, new ItemStack(Items.BUCKET, 1));
       }

       if (blockEntity.isLit() || (!fuelItem.isEmpty() && !smeltItem.isEmpty())) {
//           Optional<WorkbenchSmeltingRecipe> recipe = level.getRecipeManager().getRecipeFor(WorkbenchSmeltingRecipe.Type.INSTANCE, inventory, level);
//           FluidStack fluid = recipe.get().getResultFluid();

           if (!blockEntity.isLit() && hasRecipe(blockEntity)) {
               Optional<WorkbenchSmeltingRecipe> recipe = level.getRecipeManager().getRecipeFor(WorkbenchSmeltingRecipe.Type.INSTANCE, inventory, level);
               if (canAddFluid(blockEntity, recipe.get().getResultFluid())) {

                   blockEntity.fuelBurnTime = net.minecraftforge.common.ForgeHooks.getBurnTime(fuelItem, RecipeType.SMELTING);
                   blockEntity.maxFuelBurnTime = blockEntity.fuelBurnTime;

                   if (blockEntity.isLit()) {
                       changed = true;

                       if (fuelItem.hasContainerItem())
                           blockEntity.itemHandler.setStackInSlot(1, fuelItem.getContainerItem());
                       else if (!fuelItem.isEmpty()) {
                           fuelItem.shrink(1);
                           if (fuelItem.isEmpty()) {
                               blockEntity.itemHandler.setStackInSlot(1, fuelItem.getContainerItem());
                           }
                       }
                   }
               }
           }
           if (blockEntity.isLit() && hasRecipe(blockEntity)) {
               Optional<WorkbenchSmeltingRecipe> recipe = level.getRecipeManager().getRecipeFor(WorkbenchSmeltingRecipe.Type.INSTANCE, inventory, level);
               if (canAddFluid(blockEntity, recipe.get().getResultFluid()) && hasRoomForFluid(blockEntity, recipe.get())) {
                   blockEntity.maxProgress = recipe.get().getCookingTime();

                   blockEntity.progress++;
                   if (blockEntity.progress == blockEntity.maxProgress) {

                       blockEntity.progress = 0;
                       blockEntity.maxProgress = recipe.get().getCookingTime();
                       smeltItem(blockEntity);
                       //TODO reward XP?
                       changed = true;
                   }
               }
           } else {
               blockEntity.progress = 0;
           }
        } else if (!blockEntity.isLit() && blockEntity.progress > 0) {
           blockEntity.progress = Mth.clamp(blockEntity.progress - 2, 0, blockEntity.maxProgress);
       }

       if (lit != blockEntity.isLit()) {
           changed = true;
           state = state.setValue(AbstractFurnaceBlock.LIT, blockEntity.isLit());
           level.setBlock(pos, state, 3);
       }

       if (changed) {
           setChanged(level, pos, state);
       }
    }

    private boolean isLit() {
        return this.fuelBurnTime > 0;
    }

//
//    public static void serverTick(Level level, BlockPos pos, BlockState blockState, WorkbenchBlockEntity blockEntity) {
//        boolean lit = blockEntity.isLit();
//        boolean changed = false;
//        if (blockEntity.isLit()) {
//            --blockEntity.fuelBurnTime;
//        }
//        SimpleContainer inventory = new SimpleContainer(blockEntity.itemHandler.getSlots());
//        for (int i = 0; i < blockEntity.itemHandler.getSlots(); i++) {
//            inventory.setItem(i, blockEntity.itemHandler.getStackInSlot(i));
//        }
//
//        ItemStack fuelItem = blockEntity.itemHandler.getStackInSlot(1);
//        if (blockEntity.isLit() || !fuelItem.isEmpty() && !blockEntity.itemHandler.getStackInSlot(0).isEmpty()) {
//            Optional<WorkbenchSmeltingRecipe> recipe = level.getRecipeManager().getRecipeFor(WorkbenchSmeltingRecipe.Type.INSTANCE, inventory, level);
//            int maxStackSize = 64; //?
//            if (!blockEntity.isLit() && blockEntity.canBurn(recipe, blockEntity.itemHandler, maxStackSize)) {
//                blockEntity.fuelBurnTime = net.minecraftforge.common.ForgeHooks.getBurnTime(fuelItem, RecipeType.SMELTING);
//                blockEntity.maxFuelBurnTime = blockEntity.fuelBurnTime;
//                if (blockEntity.isLit()) {
//                    changed = true;
//                    if (fuelItem.hasContainerItem())
//                        blockEntity.itemHandler.setStackInSlot(1, fuelItem.getContainerItem());
//                    else if (!fuelItem.isEmpty()) {
//                        Item item = fuelItem.getItem();
//                        fuelItem.shrink(1);
//                        if (fuelItem.isEmpty()) {
//                            blockEntity.itemHandler.setStackInSlot(1, fuelItem.getContainerItem());
//                        }
//                    }
//                }
//            }
//
//            if (blockEntity.isLit() && blockEntity.canBurn(recipe, blockEntity.itemHandler, maxStackSize)) {
//                ++blockEntity.progress;
//                if (blockEntity.progress == blockEntity.maxProgress) {
//                    blockEntity.progress = 0;
//                    blockEntity.maxProgress = getTotalCookTime(level, blockEntity.recipeType, blockEntity);
//                    if (blockEntity.burn(recipe, blockEntity.itemHandler, maxStackSize)) {
//                        blockEntity.setRecipeUsed(recipe);
//                    }
//
//                    changed = true;
//                }
//            } else {
//                blockEntity.progress = 0;
//            }
//        } else if (!blockEntity.isLit() && blockEntity.progress > 0) {
//            blockEntity.progress = Mth.clamp(blockEntity.progress - 2, 0, blockEntity.maxProgress);
//        }
//
//        if (lit != blockEntity.isLit()) {
//            changed = true;
//            blockState = blockState.setValue(AbstractFurnaceBlock.LIT, blockEntity.isLit());
//            level.setBlock(pos, blockState, 3);
//        }
//
//        if (changed) {
//            setChanged(level, pos, blockState);
//        }
//
//    }
//
//    private boolean canBurn(@javax.annotation.Nullable Recipe<?> p_155006_, NonNullList<ItemStack> p_155007_, int p_155008_) {
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

    private static boolean hasRecipe(WorkbenchBlockEntity entity) {
        Level level = entity.level;
        SimpleContainer inventory = new SimpleContainer(entity.itemHandler.getSlots());
        for (int i = 0; i < entity.itemHandler.getSlots(); i++) {
            inventory.setItem(i, entity.itemHandler.getStackInSlot(i));
        }

        assert level != null;
        Optional<WorkbenchSmeltingRecipe> match = level.getRecipeManager().getRecipeFor(WorkbenchSmeltingRecipe.Type.INSTANCE, inventory, level);

        return match.isPresent();
    }


    private static void smeltItem(WorkbenchBlockEntity entity) {
        Level level = entity.level;
        SimpleContainer inventory = new SimpleContainer(entity.itemHandler.getSlots());
        for (int i = 0; i < entity.itemHandler.getSlots(); i++) {
            inventory.setItem(i, entity.itemHandler.getStackInSlot(i));
        }

        assert level != null;
        Optional<WorkbenchSmeltingRecipe> recipe = level.getRecipeManager().getRecipeFor(WorkbenchSmeltingRecipe.Type.INSTANCE, inventory, level);

        if(recipe.isPresent()) {
            entity.itemHandler.extractItem(0,1, false);

            FluidStack fluid = recipe.get().getResultFluid();

            fluid.setAmount((int) ((float)FluidAttributes.BUCKET_VOLUME * recipe.get().getBuckets()));
            entity.fluidHandler.fill(fluid, IFluidHandler.FluidAction.EXECUTE);
            entity.fluidLevel = entity.fluidHandler.getFluidAmount();
            setFluidType(entity);

        }
    }

    private static void setFluidType(WorkbenchBlockEntity blockEntity) {
        if (blockEntity.fluidHandler.getFluid().getFluid().isSame(Fluids.WATER)) {
            blockEntity.fluidType = 1;
        } else if (blockEntity.fluidHandler.getFluid().getFluid().isSame(Fluids.LAVA)) {
            blockEntity.fluidType = 2;
        } else if (blockEntity.fluidHandler.getFluid().getFluid().isSame(FluidRegistry.MOLTEN_IRON.get())) {
            blockEntity.fluidType = 3;
        } else if (blockEntity.fluidHandler.getFluid().getFluid().isSame(FluidRegistry.MOLTEN_STEEL.get())) {
            blockEntity.fluidType = 4;
        } else if (blockEntity.fluidHandler.getFluid().getFluid().isSame(FluidRegistry.MOLTEN_COPPER.get())) {
            blockEntity.fluidType = 5;
        } else if (blockEntity.fluidHandler.getFluid().getFluid().isSame(FluidRegistry.MOLTEN_GOLD.get())) {
            blockEntity.fluidType = 6;
//        } else if (blockEntity.fluidHandler.getFluid().getFluid().isSame(FluidRegistry.MOLTEN_NETHERITE.get())) {
//            blockEntity.fluidType = 7;
        }
    }

    private static FluidStack getFluidTypeFromIndex(int index, int amount) {
        return switch (index) {
            case 1 -> new FluidStack(Fluids.WATER, amount);
            case 2 -> new FluidStack(Fluids.LAVA, amount);
            case 3 -> new FluidStack(FluidRegistry.MOLTEN_IRON.get(), amount);
            case 4 -> new FluidStack(FluidRegistry.MOLTEN_STEEL.get(), amount);
            case 5 -> new FluidStack(FluidRegistry.MOLTEN_COPPER.get(), amount);
            case 6 -> new FluidStack(FluidRegistry.MOLTEN_GOLD.get(), amount);
//            case 7 -> new FluidStack(FluidRegistry.MOLTEN_NETHERITE.get(), amount);
            default -> throw new IllegalStateException("Unexpected value: " + index);
        };
    }

    private void resetProgress() {
        this.progress = 0;
    }

    private static boolean canAddFluid(WorkbenchBlockEntity blockEntity, FluidStack result) {
        if (!blockEntity.fluidHandler.isFluidValid(result)) {
            return false;
        } else if (blockEntity.fluidHandler.getSpace() == 0) {
            return false;
        }
        return true;
    }

    private static boolean hasRoomForFluid(WorkbenchBlockEntity blockEntity, WorkbenchSmeltingRecipe recipe) {
        return blockEntity.fluidHandler.getSpace() >= (int) (recipe.getBuckets() * (float) FluidAttributes.BUCKET_VOLUME);
    }

//    private static boolean canInsertItemIntoResultSlot(SimpleContainer inventory, ItemStack result) {
//        return inventory.getItem(10).getItem() == result.getItem() || inventory.getItem(10).isEmpty();
//    }
//
//    private static boolean canInsertAmountIntoResultSlot(SimpleContainer inventory) {
//        return inventory.getItem(10).getMaxStackSize() > inventory.getItem(10).getCount();
//    }
}