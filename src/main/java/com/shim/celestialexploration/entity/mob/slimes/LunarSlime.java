package com.shim.celestialexploration.entity.mob.slimes;

import com.shim.celestialexploration.registry.CelestialParticles;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.world.Difficulty;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Slime;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ServerLevelAccessor;

import java.util.Random;

import static net.minecraft.world.entity.monster.Monster.isDarkEnoughToSpawn;

public class LunarSlime extends AbstractCelestialSlime {
    public LunarSlime(EntityType<? extends Slime> p_33588_, Level p_33589_) {
        super(p_33588_, p_33589_, CelestialParticles.LUNAR_SLIME_PARTICLES.get());
    }
}