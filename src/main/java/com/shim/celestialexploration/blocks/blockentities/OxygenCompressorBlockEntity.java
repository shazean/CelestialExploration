package com.shim.celestialexploration.blocks.blockentities;

import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestialexploration.blocks.OxygenCompressorBlock;
import com.shim.celestialexploration.capabilities.LoxTankCapability;
import com.shim.celestialexploration.inventory.menus.OxygenCompressorMenu;
import com.shim.celestialexploration.registry.BlockEntityRegistry;
import com.shim.celestialexploration.registry.CapabilityRegistry;
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
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
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

public class OxygenCompressorBlockEntity extends BlockEntity implements MenuProvider {
//    int litTime;
//    int litTotalTime;
//    int burnTime = 250;
//    int burnMaxTime = burnTime;
    protected final ContainerData data;
    private int progress = 0;
    private int maxProgress = 150;
    private int fuelBurnTime = 0;
    private int maxFuelBurnTime;

    private final ItemStackHandler itemHandler = new ItemStackHandler(7) {
        @Override
        protected void onContentsChanged(int slot) {
            setChanged();
        }
    };

    private LazyOptional<IItemHandler> lazyItemHandler = LazyOptional.empty();

    public OxygenCompressorBlockEntity(BlockPos worldPosition, BlockState blockState) {
        super(BlockEntityRegistry.OXYGEN_COMPRESSOR_BLOCK_ENTITY.get(), worldPosition, blockState);
        this.data = new ContainerData() {
            public int get(int index) {
                return switch (index) {
                    case 0 -> OxygenCompressorBlockEntity.this.progress;
                    case 1 -> OxygenCompressorBlockEntity.this.maxProgress;
                    case 2 -> OxygenCompressorBlockEntity.this.fuelBurnTime;
                    case 3 -> OxygenCompressorBlockEntity.this.maxFuelBurnTime;
                    default -> 0;
                };
            }
            public void set(int index, int value) {
                switch (index) {
                    case 0 -> OxygenCompressorBlockEntity.this.progress = value;
                    case 1 -> OxygenCompressorBlockEntity.this.maxProgress = value;
                    case 2 -> OxygenCompressorBlockEntity.this.fuelBurnTime = value;
                    case 3 -> OxygenCompressorBlockEntity.this.maxFuelBurnTime = value;
                }
            }
            public int getCount() {
                return 4;
            }
        };
    }

    @Override
    public Component getDisplayName() {
        return new TextComponent("Oxygen Compressor");
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int containerId, Inventory inventory, Player player) {
        return new OxygenCompressorMenu(containerId, inventory, this, this.data);
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
//        CelestialExploration.LOGGER.debug("saveAdditional: itemHandler slot 0: " + itemHandler.getStackInSlot(0));

        tag.put("inventory", itemHandler.serializeNBT());
        tag.putInt("oxygen_compressor.progress", progress);
        tag.putInt("oxygen_compressor.maxProgress", maxProgress);
        tag.putInt("oxygen_compressor.fuelBurnTime", fuelBurnTime);
        tag.putInt("oxygen_compressor.maxFuelBurnTime", maxFuelBurnTime);

        super.saveAdditional(tag);
    }

    @Override
    public void load(@NotNull CompoundTag nbt) {
        super.load(nbt);
        itemHandler.deserializeNBT(nbt.getCompound("inventory"));
//        CelestialExploration.LOGGER.debug("load: itemHandler slot 0: " + itemHandler.getStackInSlot(0));

        progress = nbt.getInt("oxygen_compressor.progress");
        maxProgress = nbt.getInt("oxygen_compressor.maxProgress");
        fuelBurnTime = nbt.getInt("oxygen_compressor.fuelBurnTime");
        maxFuelBurnTime = nbt.getInt("oxygen_compressor.maxFuelBurnTime");
    }

    public void drops() {
        SimpleContainer inventory = new SimpleContainer(itemHandler.getSlots());
        for (int i = 0; i < itemHandler.getSlots(); i++) {
            inventory.setItem(i, itemHandler.getStackInSlot(i));
        }
        assert this.level != null;
        Containers.dropContents(this.level, this.worldPosition, inventory);
    }

    public boolean isLit() {
        return this.fuelBurnTime > 0;
    }

    public static void tick(Level level, BlockPos pos, BlockState state, OxygenCompressorBlockEntity blockEntity) {

        boolean lit = blockEntity.isLit();
        boolean changed = false;
        SimpleContainer inventory = new SimpleContainer(blockEntity.itemHandler.getSlots());

//        CelestialExploration.LOGGER.debug("fuelBurnTime: " + blockEntity.fuelBurnTime + " maxFuelBurnTime: " + blockEntity.maxFuelBurnTime);

        if (lit) {
            blockEntity.fuelBurnTime--;
        }

        ItemStack fuelItem = blockEntity.itemHandler.getStackInSlot(0);
        ItemStack tankItemOne = blockEntity.itemHandler.getStackInSlot(1);
        ItemStack tankItemTwo = blockEntity.itemHandler.getStackInSlot(2);
        ItemStack tankItemThree = blockEntity.itemHandler.getStackInSlot(3);
        ItemStack tankItemFour = blockEntity.itemHandler.getStackInSlot(4);


        if (lit || !fuelItem.isEmpty() && (!tankItemOne.isEmpty() || !tankItemTwo.isEmpty() || !tankItemThree.isEmpty() || !tankItemFour.isEmpty())) {

//            Optional<WorkbenchSmeltingRecipe> recipe = level.getRecipeManager().getRecipeFor(WorkbenchSmeltingRecipe.Type.INSTANCE, inventory, level);

            if (!blockEntity.isLit() && hasRoomInTank(blockEntity)) {
                blockEntity.fuelBurnTime = net.minecraftforge.common.ForgeHooks.getBurnTime(fuelItem, RecipeType.SMELTING);
                blockEntity.maxFuelBurnTime = blockEntity.fuelBurnTime;
                if (blockEntity.isLit()) {
                    changed = true;

                    if (fuelItem.hasContainerItem())
                        blockEntity.itemHandler.setStackInSlot(0, fuelItem.getContainerItem());
                    else if (!fuelItem.isEmpty()) {
                        fuelItem.shrink(1);
                        if (fuelItem.isEmpty()) {
                            blockEntity.itemHandler.setStackInSlot(0, fuelItem.getContainerItem());
                        }
                    }
                }
            }

            if (blockEntity.isLit() && hasRoomInTank(blockEntity)) {
                blockEntity.progress++;
                if (blockEntity.progress == blockEntity.maxProgress) {

                    blockEntity.progress = 0;
                    blockEntity.maxProgress = 150; //recipe.get().getCookingTime();

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
//                            blockEntity.resetBurnTime(blockEntity);
                        } else if (secondloxTank != null && !secondloxTank.isFull()) {
                            secondloxTank.incrementAmount();
//                            blockEntity.resetBurnTime(blockEntity);
                        } else if (thirdloxTank != null && !thirdloxTank.isFull()) {
                            thirdloxTank.incrementAmount();
//                            blockEntity.resetBurnTime(blockEntity);
                        } else if (fourthloxTank != null && !fourthloxTank.isFull()) {
                            fourthloxTank.incrementAmount();
//                            blockEntity.resetBurnTime(blockEntity);
                        }

//                    smeltItem(blockEntity);
                    //TODO reward XP?
                    changed = true;
                }

            } else {
                blockEntity.progress = 0;
            }
        } else if (!blockEntity.isLit() && blockEntity.progress > 0) {
            blockEntity.progress = Mth.clamp(blockEntity.progress - 2, 0, blockEntity.maxProgress);
        }

        if (lit != blockEntity.isLit()) {
            changed = true;
            state = state.setValue(OxygenCompressorBlock.LIT, blockEntity.isLit());
            level.setBlock(pos, state, 3);
        }

        if (changed) {
            setChanged(level, pos, state);
        }
    }

    public static boolean hasRoomInTank(OxygenCompressorBlockEntity blockEntity) {
        ItemStack firstSlot = blockEntity.itemHandler.getStackInSlot(1);
        ItemStack secondSlot = blockEntity.itemHandler.getStackInSlot(2);
        ItemStack thirdSlot = blockEntity.itemHandler.getStackInSlot(3);
        ItemStack fourthSlot = blockEntity.itemHandler.getStackInSlot(4);

        LoxTankCapability.ILoxTank loxTank = CelestialExploration.getCapability(firstSlot, CapabilityRegistry.LOX_TANK_CAPABILITY);
        LoxTankCapability.ILoxTank secondLoxTank = CelestialExploration.getCapability(secondSlot, CapabilityRegistry.LOX_TANK_CAPABILITY);
        LoxTankCapability.ILoxTank thirdLoxTank = CelestialExploration.getCapability(thirdSlot, CapabilityRegistry.LOX_TANK_CAPABILITY);
        LoxTankCapability.ILoxTank fourthLoxTank = CelestialExploration.getCapability(fourthSlot, CapabilityRegistry.LOX_TANK_CAPABILITY);

        if (loxTank != null && !loxTank.isFull()) {
            return true;
        } else if (secondLoxTank != null && !secondLoxTank.isFull()) {
            return true;
        } else if (thirdLoxTank != null && !thirdLoxTank.isFull()) {
            return true;
        } else return fourthLoxTank != null && !fourthLoxTank.isFull();
    }


//        boolean hasTankInSlot = blockEntity.itemHandler.getStackInSlot(1).getItem() == ItemRegistry.LOX_TANK.get() || blockEntity.itemHandler.getStackInSlot(2).getItem() == ItemRegistry.LOX_TANK.get() || blockEntity.itemHandler.getStackInSlot(3).getItem() == ItemRegistry.LOX_TANK.get() || blockEntity.itemHandler.getStackInSlot(4).getItem() == ItemRegistry.LOX_TANK.get();
//            ItemStack fuelItem = blockEntity.itemHandler.getStackInSlot(0);
//
//            if (blockEntity.litTime == 0) {
//                state = state.setValue(OxygenCompressorBlock.LIT, blockEntity.isLit());
//                level.setBlock(pos, state, 3);
//                blockEntity.resetBurnTime(blockEntity);
//
//                blockEntity.litTotalTime = 0;
//                if (!fuelItem.isEmpty() && hasTankInSlot) {
////                    if (blockEntity.isBurnableFuel(getFuel(), fuelSlot.getItem())) {
//                        blockEntity.litTime = ForgeHooks.getBurnTime(fuelItem, RecipeType.SMELTING);
//                        blockEntity.itemHandler.extractItem(0, 1, false);
//                        blockEntity.litTotalTime = ForgeHooks.getBurnTime(fuelItem, RecipeType.SMELTING);
////                    }
//                }
//            } else { //litTime > 0
//                state = state.setValue(OxygenCompressorBlock.LIT, blockEntity.isLit());
//                level.setBlock(pos, state, 3);
//                if (hasTankInSlot) {
//                    --blockEntity.litTime;
//                    --blockEntity.burnTime;
//                    if (blockEntity.burnTime <= 0) {
//                        ItemStack firstSlot = blockEntity.itemHandler.getStackInSlot(1);
//                        ItemStack secondSlot = blockEntity.itemHandler.getStackInSlot(2);
//                        ItemStack thirdSlot = blockEntity.itemHandler.getStackInSlot(3);
//                        ItemStack fourthSlot = blockEntity.itemHandler.getStackInSlot(4);
//
//                        LoxTankCapability.ILoxTank loxTank = CelestialExploration.getCapability(firstSlot, CapabilityRegistry.LOX_TANK_CAPABILITY);
//                        LoxTankCapability.ILoxTank secondloxTank = CelestialExploration.getCapability(secondSlot, CapabilityRegistry.LOX_TANK_CAPABILITY);
//                        LoxTankCapability.ILoxTank thirdloxTank = CelestialExploration.getCapability(thirdSlot, CapabilityRegistry.LOX_TANK_CAPABILITY);
//                        LoxTankCapability.ILoxTank fourthloxTank = CelestialExploration.getCapability(fourthSlot, CapabilityRegistry.LOX_TANK_CAPABILITY);
//
//                        if (loxTank != null && !loxTank.isFull()) {
//                            loxTank.incrementAmount();
//                            blockEntity.resetBurnTime(blockEntity);
//                        } else if (secondloxTank != null && !secondloxTank.isFull()) {
//                            secondloxTank.incrementAmount();
//                            blockEntity.resetBurnTime(blockEntity);
//                        } else if (thirdloxTank != null && !thirdloxTank.isFull()) {
//                            thirdloxTank.incrementAmount();
//                            blockEntity.resetBurnTime(blockEntity);
//                        } else if (fourthloxTank != null && !fourthloxTank.isFull()) {
//                            fourthloxTank.incrementAmount();
//                            blockEntity.resetBurnTime(blockEntity);
//                        }
//                    }
//                } else {
//                    blockEntity.resetBurnTime(blockEntity);
//                    --blockEntity.litTime;
//                }
//            }
//            setChanged(level, pos, state);
//    }
}