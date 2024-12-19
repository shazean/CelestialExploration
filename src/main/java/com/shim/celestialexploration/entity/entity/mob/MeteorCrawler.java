package com.shim.celestialexploration.entity.entity.mob;

import com.shim.celestialexploration.registry.BlockRegistry;
import com.shim.celestialexploration.registry.TagRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.world.Difficulty;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.Spider;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;

import java.util.Random;

public class MeteorCrawler extends Spider {
    public MeteorCrawler(EntityType<? extends Spider> p_33786_, Level p_33787_) {
        super(p_33786_, p_33787_);
    }

    public static <T extends Mob> boolean checkMeteorCrawlerSpawnRules(EntityType<T> entityType, ServerLevelAccessor serverLevelAccessor, MobSpawnType spawnType, BlockPos pos, Random random) {
        return serverLevelAccessor.getDifficulty() != Difficulty.PEACEFUL &&
                isDarkEnoughToSpawn(serverLevelAccessor, pos, random) &&
                checkMobSpawnRules(entityType, serverLevelAccessor, spawnType, pos, random) &&
                serverLevelAccessor.getBlockState(pos).is(TagRegistry.Blocks.METEOR);

    }
}
