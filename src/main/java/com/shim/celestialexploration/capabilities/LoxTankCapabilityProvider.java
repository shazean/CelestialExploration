package com.shim.celestialexploration.capabilities;

import com.shim.celestialexploration.registry.CelestialCapabilities;
import com.shim.celestialexploration.util.FuelUtil;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraftforge.common.capabilities.*;
import net.minecraftforge.common.util.LazyOptional;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.annotation.Nonnull;

public class LoxTankCapabilityProvider implements ICapabilityProvider, ICapabilitySerializable<CompoundTag> {

    public static Capability<FuelTankHandler> LOX_TANK = CapabilityManager.get(new CapabilityToken<>() {});
    private FuelTankHandler fuelTankHandler = null;
    private final LazyOptional<FuelTankHandler> lazyFuelTank = LazyOptional.of(this::createFuelHandler);

    @Nonnull
    private FuelTankHandler createFuelHandler() {
        if (fuelTankHandler == null) {
            fuelTankHandler = new FuelTankHandler(FuelUtil.LOX_FUEL_SPEED, FuelUtil.LOX_CAPACITY_MODIFIER);
        }
        return fuelTankHandler;
    }

    @NotNull
    @Override
    public <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        return CelestialCapabilities.FUEL_TANK_CAPABILITY.orEmpty(cap, lazyFuelTank.cast());
    }

    @Override
    public CompoundTag serializeNBT() {
        return lazyFuelTank.orElseThrow(NullPointerException::new).getFuelData();
    }

    @Override
    public void deserializeNBT(CompoundTag nbt) {
        lazyFuelTank.orElseThrow(NullPointerException::new).setFuelData(nbt);
    }
}
