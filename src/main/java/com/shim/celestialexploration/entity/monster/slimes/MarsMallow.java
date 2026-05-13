package com.shim.celestialexploration.entity.monster.slimes;

import com.shim.celestialexploration.registry.CelestialParticles;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.Slime;
import net.minecraft.world.level.*;

public class MarsMallow extends AbstractCelestialSlime {
    public MarsMallow(EntityType<? extends Slime> slime, Level level) {
        super(slime, level, CelestialParticles.MARS_MALLOW_SLIME_PARTICLES.get());
    }
}