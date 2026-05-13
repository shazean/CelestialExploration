package com.shim.celestialexploration.entity.monster.slimes;

import com.shim.celestialexploration.registry.CelestialParticles;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.Slime;
import net.minecraft.world.level.*;

public class RustSlime extends AbstractCelestialSlime {

    public RustSlime(EntityType<? extends Slime> entityType, Level level) {
        super(entityType, level, CelestialParticles.RUST_SLIME_PARTICLES.get());
    }
}