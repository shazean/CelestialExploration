package com.shim.celestialexploration.blocks.blockentities;

import com.shim.celestialexploration.blocks.LoxTankBlock;
import com.shim.celestialexploration.blocks.MetallicHydrogenTankBlock;
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
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nonnull;

public class MetallicHydrogenTankBlockEntity extends BlockEntity {

    public MetallicHydrogenTankBlockEntity(BlockPos worldPosition, BlockState blockState) {
        super(CelestialBlockEntities.METALLIC_HYDROGEN_TANK_BLOCK_ENTITY.get(), worldPosition, blockState);
        setChanged();
    }

    private final FuelTankHandler hydroTankHandler = new FuelTankHandler(FuelUtil.HYDRO_FUEL_SPEED, FuelUtil.HYDRO_CAPACITY_MODIFIER) {};
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
        lazyTankHandler = LazyOptional.of(() -> this.hydroTankHandler);
    }

    @Override
    public void invalidateCaps() {
        super.invalidateCaps();
        lazyTankHandler.invalidate();
    }

    @Override
    protected void saveAdditional(@NotNull CompoundTag tag) {
        tag.put("FuelData", this.hydroTankHandler.getFuelData());
        super.saveAdditional(tag);
    }

    @Override
    public void load(CompoundTag nbt) {
        super.load(nbt);
        this.hydroTankHandler.setFuelData(nbt.getCompound("FuelData"));
    }

    public static void tick(Level level, BlockPos pos, BlockState state, MetallicHydrogenTankBlockEntity blockEntity) {
        if (!level.isClientSide){
            state = state.setValue(MetallicHydrogenTankBlock.FULLNESS, blockEntity.hydroTankHandler.getFullness());
            level.setBlock(pos, state, 3);
            setChanged(level, pos, state);
        }
    }
}