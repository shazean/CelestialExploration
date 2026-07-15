package com.shim.celestialexploration.blocks.blockentities;

import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestialexploration.blocks.AbstractFuelTankBlock;
import com.shim.celestialexploration.blocks.LoxTankBlock;
import com.shim.celestialexploration.capabilities.FuelTankHandler;
import com.shim.celestialexploration.capabilities.IFuelTank;
import com.shim.celestialexploration.registry.CelestialBlockEntities;
import com.shim.celestialexploration.registry.CelestialCapabilities;
import com.shim.celestialexploration.util.FuelUtil;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nonnull;

public abstract class AbstractFuelTankBlockEntity extends BlockEntity {

    public AbstractFuelTankBlockEntity(BlockEntityType blockEntity, BlockPos worldPosition, BlockState blockState) {
        super(blockEntity, worldPosition, blockState);
        setChanged();
    }

    protected FuelTankHandler getTankHandler() {
        return loxTankHandler;
    }

    private final FuelTankHandler loxTankHandler = new FuelTankHandler(FuelUtil.LOX_FUEL_SPEED, FuelUtil.LOX_CAPACITY_MODIFIER) {};
    private LazyOptional<IFuelTank> lazyTankHandler = LazyOptional.empty();

    @Nonnull
    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @javax.annotation.Nullable Direction side) {
        if (cap == CelestialCapabilities.FUEL_TANK_CAPABILITY) {
            return lazyTankHandler.cast();
        }
        return super.getCapability(cap, side);
    }

    @Override
    public void onLoad() {
        super.onLoad();
        lazyTankHandler = LazyOptional.of(this::getTankHandler);
    }

    @Override
    public void invalidateCaps() {
        super.invalidateCaps();
        lazyTankHandler.invalidate();
    }

    @Override
    protected void saveAdditional(@NotNull CompoundTag tag) {
        tag.put("FuelData", this.getTankHandler().getFuelData());
        super.saveAdditional(tag);
    }

    @Override
    public void load(CompoundTag nbt) {
        super.load(nbt);
        this.getTankHandler().setFuelData(nbt.getCompound("FuelData"));
    }
}