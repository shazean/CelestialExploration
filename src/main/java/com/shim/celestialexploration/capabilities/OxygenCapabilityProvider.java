package com.shim.celestialexploration.capabilities;

import com.shim.celestialexploration.registry.CelestialCapabilities;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraftforge.common.capabilities.*;
import net.minecraftforge.common.util.LazyOptional;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.annotation.Nonnull;

public class OxygenCapabilityProvider implements ICapabilityProvider, ICapabilitySerializable<CompoundTag> {

    public static Capability<OxygenHandler> OXYGEN = CapabilityManager.get(new CapabilityToken<>() {});
    private OxygenHandler oxygenHandler = null;
    private final LazyOptional<OxygenHandler> lazyFuelTank = LazyOptional.of(this::createFuelHandler);

    @Nonnull
    private OxygenHandler createFuelHandler() {
        if (oxygenHandler == null) {
            oxygenHandler = new OxygenHandler();
        }
        return oxygenHandler;
    }

    @NotNull
    @Override
    public <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        return CelestialCapabilities.OXYGEN_CAPABILITY.orEmpty(cap, lazyFuelTank.cast());
    }

    @Override
    public CompoundTag serializeNBT() {
        return lazyFuelTank.orElseThrow(NullPointerException::new).getData();
    }

    @Override
    public void deserializeNBT(CompoundTag nbt) {
        lazyFuelTank.orElseThrow(NullPointerException::new).setData(nbt);
    }
}
