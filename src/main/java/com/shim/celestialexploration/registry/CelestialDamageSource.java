package com.shim.celestialexploration.registry;

import com.shim.celestialexploration.CelestialExploration;
import net.minecraft.world.damagesource.DamageSource;

public class CelestialDamageSource {
    public static final DamageSource TOUCHED_SUN = modDamageSource("touched_sun").setIsFire();
    public static final DamageSource SULFUR = modDamageSource("sulfur").setIsFire();
    public static final DamageSource METALLIC_HYDROGEN = modDamageSource("metallic_hydrogen");
    public static final DamageSource COLD_FLOOR = modDamageSource("cold_floor");
    public static final DamageSource DUST_STORM = modDamageSource("dust_storm");
    public static final DamageSource SUFFOCATE = modDamageSource("suffocate").bypassArmor();

    public static DamageSource modDamageSource(String source) {
        return new DamageSource(CelestialExploration.MODID + "." + source);
    }
}