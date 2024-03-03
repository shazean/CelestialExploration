package com.shim.celestialexploration.entity.mob;

import net.minecraft.core.BlockPos;
import net.minecraft.world.Difficulty;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Ghast;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;

import java.util.Random;

public class Gust extends Ghast {
    public Gust(EntityType<? extends Ghast> p_32725_, Level p_32726_) {
        super(p_32725_, p_32726_);
    }

    public static AttributeSupplier setAttributes() {
        return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 10.0D).add(Attributes.FOLLOW_RANGE, 100.0D).build();
    }

    public static boolean checkGustSpawnRules(EntityType<Gust> p_32735_, LevelAccessor p_32736_, MobSpawnType p_32737_, BlockPos p_32738_, Random p_32739_) {
        return p_32736_.getDifficulty() != Difficulty.PEACEFUL && p_32739_.nextInt(30) == 0 && checkMobSpawnRules(p_32735_, p_32736_, p_32737_, p_32738_, p_32739_);
    }
}