package com.shim.celestialexploration.effects;

import com.shim.celestialexploration.registry.CelestialEffects;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;

public class CelestialEffect extends MobEffect {
    public CelestialEffect(MobEffectCategory p_19451_, int color) {
        super(p_19451_, color);
    }

    @Override
    public void applyEffectTick(LivingEntity entity, int p_19468_) {
        if (this == CelestialEffects.OXYGENATED_EFFECT.get()) {
            //TODO
        }
        super.applyEffectTick(entity, p_19468_);
    }

    @Override
    public boolean isDurationEffectTick(int p_19455_, int p_19456_) {
        return true;
    }
}