package com.shim.celestialexploration.entity.monster.slimes;

import com.shim.celestialexploration.registry.CelestialParticles;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.Slime;
import net.minecraft.world.level.Level;

public class LunarSlime extends AbstractCelestialSlime {
    public LunarSlime(EntityType<? extends Slime> p_33588_, Level p_33589_) {
        super(p_33588_, p_33589_, CelestialParticles.LUNAR_SLIME_PARTICLES.get());
    }
}