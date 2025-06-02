package com.shim.celestialexploration.capabilities;

import com.shim.celestialexploration.registry.CelestialCapabilities;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraftforge.common.capabilities.*;
import net.minecraftforge.common.util.LazyOptional;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class SpaceFlightCapabilityProvider implements ICapabilityProvider, ICapabilitySerializable<CompoundTag> {
    public static Capability<LoxTankCapability.LoxTankHandler> LOX_TANK = CapabilityManager.get(new CapabilityToken<>(){});

    private final LazyOptional<ISpaceFlight> lazySpaceshipFlight = LazyOptional.of(VehicleFlightHandler::new);

    @NotNull
    @Override
    public <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        return CelestialCapabilities.SPACE_FLIGHT_CAPABILITY.orEmpty(cap, lazySpaceshipFlight);
    }

    @Override
    public CompoundTag serializeNBT() {
        return lazySpaceshipFlight.orElseThrow(NullPointerException::new).getData();
    }

    @Override
    public void deserializeNBT(CompoundTag nbt) {
        lazySpaceshipFlight.orElseThrow(NullPointerException::new).setData(nbt);
    }
}