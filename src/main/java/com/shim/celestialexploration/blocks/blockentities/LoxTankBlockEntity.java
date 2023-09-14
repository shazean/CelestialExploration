package com.shim.celestialexploration.blocks.blockentities;

import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestialexploration.blocks.LoxTankBlock;
import com.shim.celestialexploration.capabilities.LoxTankCapability;
import com.shim.celestialexploration.registry.BlockEntityRegistry;
import com.shim.celestialexploration.registry.CapabilityRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

public class LoxTankBlockEntity extends BlockEntity {
    LoxTankCapability.ILoxTank loxTank;
    int fullness;
//    private final ItemStackHandler itemHandler = new ItemStackHandler(4) {
//        @Override
//        protected void onContentsChanged(int slot) {
//            setChanged();
//        }
//    };

//    private LazyOptional<IItemHandler> lazyItemHandler = LazyOptional.empty();

//    public void setLox(BlockEntity entity, int amount) {
//        LoxTankCapability.ILoxTank loxTank = CelestialExploration.getCapability(entity, CapabilityRegistry.LOX_TANK_CAPABILITY);
//        loxTank.setAmount(amount);
//    }
//
//    public boolean increaseLox(BlockEntity entity) {
//        LoxTankCapability.ILoxTank loxTank = CelestialExploration.getCapability(entity, CapabilityRegistry.LOX_TANK_CAPABILITY);
//        return loxTank.incrementAmount();
//    }
//
//    public boolean decreaseLox(BlockEntity entity) {
//        LoxTankCapability.ILoxTank loxTank = CelestialExploration.getCapability(entity, CapabilityRegistry.LOX_TANK_CAPABILITY);
//        return loxTank.decrementAmount();
//    }
//
//    public int getLox(BlockEntity entity) {
//        LoxTankCapability.ILoxTank loxTank = CelestialExploration.getCapability(entity, CapabilityRegistry.LOX_TANK_CAPABILITY);
//        return loxTank.getAmount();
//    }

    public LoxTankBlockEntity(BlockPos worldPosition, BlockState blockState) {
        super(BlockEntityRegistry.LOX_TANK_BLOCK_ENTITY.get(), worldPosition, blockState);
    }

//    @Nonnull
//    @Override
//    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @javax.annotation.Nullable Direction side) {
////        if (cap == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {
////            return lazyItemHandler.cast();
////        }
////            return cap == loxTank ? loxTank.cast() : super.getCapability(cap, side);
//
//
//        if (cap == CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY) {
//            return loxTank.cast();
//        }
//
//        return super.getCapability(cap, side);
//    }

//    public void setFullness(int fullness) {
//        this.fullness = fullness;
//    }

    @Override
    public void onLoad() {
        super.onLoad();

    }

    @Override
    public void invalidateCaps() {
        super.invalidateCaps();
//        loxTank.invalidate();
    }

    @Override
    protected void saveAdditional(@NotNull CompoundTag tag) {
        super.saveAdditional(tag);
    }

    @Override
    public void load(CompoundTag nbt) {
        super.load(nbt);
    }

//    @Override
//    public void saveSynced(CompoundTag tag) {
//        super.saveSynced(tag);
//        // want tank on the client on world load
////        if (!tank.isEmpty()) {
////            tag.put(NBTTags.TANK, tank.writeToNBT(new CompoundTag()));
////        }
//    }

//    /** Interface for blocks to return their capacity */
//    public interface ITankBlock {
//        /** Gets the capacity for this tank */
//        int getCapacity();
//    }


//    public void drops() {
//        SimpleContainer inventory = new SimpleContainer(itemHandler.getSlots());
//        for (int i = 0; i < itemHandler.getSlots(); i++) {
//            inventory.setItem(i, itemHandler.getStackInSlot(i));
//        }
//        Containers.dropContents(this.level, this.worldPosition, inventory);
//    }

    public static void tick(Level level, BlockPos pos, BlockState state, LoxTankBlockEntity blockEntity) {
        blockEntity.loxTank = CelestialExploration.getCapability(blockEntity, CapabilityRegistry.LOX_TANK_CAPABILITY);
        boolean isChanged = false;
        if (blockEntity.loxTank != null) {
            state = state.setValue(LoxTankBlock.FULLNESS, blockEntity.loxTank.getFullness());
            level.setBlock(pos, state, 3);
            isChanged = true;
//            CelestialExploration.LOGGER.debug("Capability fullness is: " + blockEntity.loxTank.getFullness() + " & Block fullness is: " + state.getValue(LoxTankBlock.FULLNESS));
        } else {
//            CelestialExploration.LOGGER.debug("Capability is null!");
        }
        if (isChanged) {
//            CelestialExploration.LOGGER.debug("isChanged! Setting change now!");
            setChanged(level, pos, state);
        }
    }
}