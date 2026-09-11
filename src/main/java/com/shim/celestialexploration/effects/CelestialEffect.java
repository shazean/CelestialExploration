package com.shim.celestialexploration.effects;

import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestialexploration.capabilities.OxygenHandler;
import com.shim.celestialexploration.registry.CelestialCapabilities;
import com.shim.celestialexploration.registry.CelestialEffects;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import org.jetbrains.annotations.Nullable;

public class CelestialEffect extends MobEffect {
    public CelestialEffect(MobEffectCategory p_19451_, int color) {
        super(p_19451_, color);
    }


//    @Override
//    public void applyEffectTick(LivingEntity p_19467_, int p_19468_) {
////        CelestialExploration.LOGGER.debug("applyEffectTick: " + this);
//        if (this == CelestialEffects.INSTANT_OXYGEN_EFFECT.get()) {
//            CelestialExploration.LOGGER.debug("applyInstantEffect, should be instant oxygen. passing in: {}", p_19468_);
//            if (p_19467_ instanceof Player player) {
//                OxygenHandler handler = CelestialExploration.getCapability(player, CelestialCapabilities.OXYGEN_CAPABILITY);
//                if (handler != null) {
//                    handler.addOxygen(p_19468_); //FIXME check this is the right value to pass in?
//                }
//            }
//        }
//        super.applyEffectTick(p_19467_, p_19468_);
//    }
//
//    @Override
//    public void applyInstantenousEffect(@Nullable Entity p_19462_, @Nullable Entity p_19463_, LivingEntity p_19464_, int p_19465_, double p_19466_) {
//        CelestialExploration.LOGGER.debug("applyInstantEffect: " + this);
//        if (this == CelestialEffects.INSTANT_OXYGEN_EFFECT.get()) {
//            CelestialExploration.LOGGER.debug("applyInstantEffect, should be instant oxygen. passing in: {} (as opposed to {})", p_19465_, p_19466_);
//            if (p_19464_ instanceof Player player) {
//                OxygenHandler handler = CelestialExploration.getCapability(player, CelestialCapabilities.OXYGEN_CAPABILITY);
//                if (handler != null) {
//                    handler.addOxygen(p_19465_); //FIXME check this is the right value to pass in?
//                }
//            }
//        }
//        super.applyInstantenousEffect(p_19462_, p_19463_, p_19464_, p_19465_, p_19466_);
//    }

    @Override
    public boolean isDurationEffectTick(int p_19455_, int p_19456_) {
        if (this == CelestialEffects.INSTANT_OXYGEN_EFFECT.get()) {
            return false;
        }
        return true;
    }
}