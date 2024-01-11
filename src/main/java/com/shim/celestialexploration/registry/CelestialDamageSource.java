package com.shim.celestialexploration.registry;

import com.shim.celestialexploration.CelestialExploration;
import net.minecraft.world.damagesource.DamageSource;

public class CelestialDamageSource {
    public static final DamageSource TOUCHED_SUN = modDamageSource("touchedSun").setIsFire();


    public static DamageSource modDamageSource(String source) {
        return new DamageSource(CelestialExploration.MODID + "." + source);
    }
}
