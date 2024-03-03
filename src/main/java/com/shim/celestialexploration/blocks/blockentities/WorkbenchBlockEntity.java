package com.shim.celestialexploration.blocks.blockentities;

import com.google.common.collect.Lists;
import com.shim.celestialexploration.blocks.WorkbenchBlock;
import com.shim.celestialexploration.inventory.SimpleFluidContainerData;
import com.shim.celestialexploration.inventory.menus.WorkbenchMenu;
import com.shim.celestialexploration.recipes.WorkbenchSmeltingRecipe;
import com.shim.celestialexploration.registry.BlockEntityRegistry;
import com.shim.celestialexploration.registry.FluidRegistry;
import com.shim.celestialexploration.util.CelestialUtil;
import it.unimi.dsi.fastutil.objects.Object2IntMap;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.Mth;
import net.minecraft.world.Containers;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.ExperienceOrb;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.Vec3;
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

import javax.annotation.Nonnull;
import java.util.List;
import java.util.Optional;

public class WorkbenchBlockEntity extends BlockEntity implements MenuProvider {
    protected final ContainerData data;
    private int progress = 0;
    private int maxProgress = 100;
    private int fuelBurnTime = 0;
    private int maxFuelBurnTime;
    private int fluidLevel;
    public static int maxFluidLevel = FluidAttributes.BUCKET_VOLUME * 4;
    private int fluidType;

    private final ItemStackHandler itemHandler = new ItemStackHandler(12) {
        @Override
        protected void onContentsChanged(int slot) {
            setChanged();
        }
    };

    protected FluidTank fluidHandler = new FluidTank(maxFluidLevel) {
        @Override
        protected void onContentsChanged() {
            setChanged();
        }
    };

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
                    case 5 -> maxFluidLevel;
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
                    case 5 -> {}
                    case 6 -> WorkbenchBlockEntity.this.fluidType = value;
                }
            }
            public int getCount() {
                return 8;
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

        if (smeltItem.getItem() instanceof BucketItem bucket && hasRecipe(blockEntity)) {
            if (canAddFluid(blockEntity, new FluidStack(bucket.getFluid(), FluidAttributes.BUCKET_VOLUME))) {
                smeltItem(blockEntity);
                blockEntity.itemHandler.setStackInSlot(0, new ItemStack(Items.BUCKET, 1));
            }
        }

        if (blockEntity.isLit() || (!fuelItem.isEmpty() && !smeltItem.isEmpty())) {
//           Optional<WorkbenchSmeltingRecipe> recipe = level.getRecipeManager().getRecipeFor(WorkbenchSmeltingRecipe.Type.INSTANCE, inventory, level);
//           FluidStack fluid = recipe.get().getResultFluid();

            if (!blockEntity.isLit() && hasRecipe(blockEntity)) {
                Optional<WorkbenchSmeltingRecipe> recipe = level.getRecipeManager().getRecipeFor(WorkbenchSmeltingRecipe.Type.INSTANCE, inventory, level);
                if (recipe.isPresent() && canAddFluid(blockEntity, recipe.get().getResultFluid())) {

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
                if (recipe.isPresent() && canAddFluid(blockEntity, recipe.get().getResultFluid()) && hasRoomForFluid(blockEntity, recipe.get())) {
                    blockEntity.maxProgress = recipe.get().getCookingTime();

                    blockEntity.progress++;
                    if (blockEntity.progress == blockEntity.maxProgress) {

                        blockEntity.progress = 0;
                        blockEntity.maxProgress = recipe.get().getCookingTime();
                        smeltItem(blockEntity);
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
            state = state.setValue(WorkbenchBlock.LIT, blockEntity.isLit());
            level.setBlock(pos, state, 3);
        }

        if (changed) {
            setChanged(level, pos, state);
        }
    }

    private boolean isLit() {
        return this.fuelBurnTime > 0;
    }

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

        if (recipe.isPresent()) {
            entity.itemHandler.extractItem(0, 1, false);

            FluidStack fluid = recipe.get().getResultFluid();

            fluid.setAmount((int) ((float) FluidAttributes.BUCKET_VOLUME * recipe.get().getBuckets()));
            entity.fluidHandler.fill(fluid, IFluidHandler.FluidAction.EXECUTE);
            entity.fluidLevel = entity.fluidHandler.getFluidAmount();
            entity.fluidType = CelestialUtil.getIdFromFluid(entity.fluidHandler.getFluid());
        }
    }

    private static boolean canAddFluid(WorkbenchBlockEntity blockEntity, FluidStack result) {
        if (!blockEntity.fluidHandler.isFluidValid(result)) {
            return false;
        } else return blockEntity.fluidHandler.getSpace() != 0;
    }

    private static boolean hasRoomForFluid(WorkbenchBlockEntity blockEntity, WorkbenchSmeltingRecipe recipe) {
        return blockEntity.fluidHandler.getSpace() >= (int) (recipe.getBuckets() * (float) FluidAttributes.BUCKET_VOLUME);
    }
}