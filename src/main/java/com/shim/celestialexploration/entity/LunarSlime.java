package com.shim.celestialexploration.entity;

import com.shim.celestialexploration.registry.ParticleRegistry;
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

public class LunarSlime extends Slime {

    public LunarSlime(EntityType<? extends Slime> p_33588_, Level p_33589_) {
        super(p_33588_, p_33589_);
    }

    public static AttributeSupplier setAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.ATTACK_DAMAGE, 3.0f).build();
    }

    @Override
    protected ParticleOptions getParticleType() {
        return ParticleRegistry.LUNAR_SLIME_PARTICLES.get();
    }

    public static boolean checkLunarSlimeSpawnRules(EntityType<LunarSlime> slime, LevelAccessor level, MobSpawnType spawnType, BlockPos pos, Random random) {
        if (level.getDifficulty() == Difficulty.PEACEFUL || pos.getY() > 64) {
            return false;
        }
        return isDarkEnoughToSpawn((ServerLevelAccessor) level, pos, random) && checkMobSpawnRules(slime, level, spawnType, pos, random);
    }

}