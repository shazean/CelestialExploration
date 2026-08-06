package com.shim.celestialexploration.entity.monster.slimes;

import com.shim.celestialexploration.registry.CelestialBlocks;
import com.shim.celestialexploration.registry.CelestialParticles;
import net.minecraft.core.BlockPos;
import net.minecraft.world.Difficulty;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.monster.Slime;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LightLayer;

import java.util.Random;

public abstract class AbstractQuicksilverSlime extends AbstractCelestialSlime {
    protected static final int CONVERSION_TIME = 120; //180;
    protected int currentConversionTime = 300;

    public AbstractQuicksilverSlime(EntityType<? extends Slime> p_33588_, Level p_33589_) {
        super(p_33588_, p_33589_, CelestialParticles.QUICKSILVER_SLIME_PARTICLES.get());
    }

    public static boolean checkCelestialSlimeSpawnRules(EntityType<? extends AbstractCelestialSlime> slime, LevelAccessor level, MobSpawnType spawnType, BlockPos pos, Random random) {
        if (level.getDifficulty() == Difficulty.PEACEFUL) return false;

        if (level.getBlockState(pos.below()).is(CelestialBlocks.MERCURY_SLIME_BLOCK.get()))
            return true;
        else
            return AbstractCelestialSlime.checkCelestialSlimeSpawnRules(slime, level, spawnType, pos, random);
    }

    protected void setSize(int size) {
        super.setSize(size, true);
    }

    protected abstract void convertSlime();

}