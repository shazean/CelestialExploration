package com.shim.celestialexploration.effects;

import com.shim.celestialexploration.registry.CelestialEffects;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;

public class CelestialEffect extends MobEffect {
    public CelestialEffect(MobEffectCategory p_19451_, int color) {
        super(p_19451_, color);
    }

    @Override
    public boolean isDurationEffectTick(int p_19455_, int p_19456_) {
        if (this == CelestialEffects.INSTANT_OXYGEN_EFFECT.get()) {
            return false;
        }
        return true;
    }
}