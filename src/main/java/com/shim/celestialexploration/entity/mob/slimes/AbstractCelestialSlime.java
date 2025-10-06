package com.shim.celestialexploration.entity.mob.slimes;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.Difficulty;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Slime;
import net.minecraft.world.level.*;
import org.jetbrains.annotations.Nullable;

import java.util.Random;

import static net.minecraft.world.entity.monster.Monster.isDarkEnoughToSpawn;

public abstract class AbstractCelestialSlime extends Slime {
    final ParticleOptions slimeParticles;

    public AbstractCelestialSlime(EntityType<? extends Slime> entityType, Level level, ParticleOptions slimeParticles) {
        super(entityType, level);
        this.slimeParticles = slimeParticles;
    }

    public static AttributeSupplier setAttributes() {
        return Mob.createMobAttributes().add(Attributes.ATTACK_DAMAGE, 3.0f).build();
    }

    @Override
    protected ParticleOptions getParticleType() {
        return this.slimeParticles;
    }

    @Override
    public @Nullable SpawnGroupData finalizeSpawn(ServerLevelAccessor p_33601_, DifficultyInstance p_33602_, MobSpawnType p_33603_, @Nullable SpawnGroupData p_33604_, @Nullable CompoundTag p_33605_) {
        return super.finalizeSpawn(p_33601_, p_33602_, p_33603_, p_33604_, p_33605_);
    }

    public static boolean checkCelestialSlimeSpawnRules(EntityType<? extends AbstractCelestialSlime> slime, LevelAccessor level, MobSpawnType spawnType, BlockPos pos, Random random) {
        if (level.getDifficulty() == Difficulty.PEACEFUL) return false;
        if (random.nextInt() > 5) return false;

        if (level.getBrightness(LightLayer.BLOCK, pos) > 0) {
            return false;
        }

//        if (pos.getY() > 50 && pos.getY() < 70 && random.nextFloat() < 0.5F && random.nextFloat() < level.getMoonBrightness() && level.getMaxLocalRawBrightness(pos) <= random.nextInt(8)) {
        return checkMobSpawnRules(slime, level, spawnType, pos, random);
//        }

//        return false;
    }
}
