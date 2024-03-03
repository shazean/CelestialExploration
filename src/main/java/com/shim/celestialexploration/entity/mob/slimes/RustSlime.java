package com.shim.celestialexploration.entity.mob.slimes;

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
import net.minecraft.world.level.*;

import java.util.Random;

import static net.minecraft.world.entity.monster.Monster.isDarkEnoughToSpawn;

public class RustSlime extends Slime {

    public RustSlime(EntityType<? extends Slime> p_33588_, Level p_33589_) {
        super(p_33588_, p_33589_);
    }

    public static AttributeSupplier setAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.ATTACK_DAMAGE, 3.0f).build();
    }

    @Override
    protected ParticleOptions getParticleType() {
        return ParticleRegistry.RUST_SLIME_PARTICLES.get();
    }

    public static boolean checkRustSlimeSpawnRules(EntityType<RustSlime> slime, LevelAccessor level, MobSpawnType spawnType, BlockPos pos, Random random) {
        if (level.getDifficulty() == Difficulty.PEACEFUL || pos.getY() > 64) {
            return false;
        }
        return isDarkEnoughToSpawn((ServerLevelAccessor) level, pos, random) && checkMobSpawnRules(slime, level, spawnType, pos, random);

//        if (p_33622_.getDifficulty() != Difficulty.PEACEFUL) {
//            if (p_33622_.getBiome(p_33624_).is(Biomes.SWAMP) && p_33624_.getY() > 50 && p_33624_.getY() < 70 && p_33625_.nextFloat() < 0.5F && p_33625_.nextFloat() < p_33622_.getMoonBrightness() && p_33622_.getMaxLocalRawBrightness(p_33624_) <= p_33625_.nextInt(8)) {
//                return checkMobSpawnRules(p_33621_, p_33622_, p_33623_, p_33624_, p_33625_);
//            }
//
//            if (!(p_33622_ instanceof WorldGenLevel)) {
//                return false;
//            }
//
//            ChunkPos chunkpos = new ChunkPos(p_33624_);
//            boolean flag = WorldgenRandom.seedSlimeChunk(chunkpos.x, chunkpos.z, ((WorldGenLevel)p_33622_).getSeed(), 987234911L).nextInt(10) == 0;
//            if (p_33625_.nextInt(10) == 0 && flag && p_33624_.getY() < 40) {
//                return checkMobSpawnRules(p_33621_, p_33622_, p_33623_, p_33624_, p_33625_);
//            }
//        }
//
//        return false;
    }
}