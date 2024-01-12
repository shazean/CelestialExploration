package com.shim.celestialexploration.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.world.Difficulty;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.ZombifiedPiglin;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;

import java.util.Random;

public class VoidedPiglin extends ZombifiedPiglin {
    public VoidedPiglin(EntityType<? extends ZombifiedPiglin> p_34427_, Level p_34428_) {
        super(p_34427_, p_34428_);
    }

    public static AttributeSupplier setAttributes() {
        return Voided.createAttributes().add(Attributes.SPAWN_REINFORCEMENTS_CHANCE, 0.0D).add(Attributes.MOVEMENT_SPEED, (double)0.23F).add(Attributes.ATTACK_DAMAGE, 5.0D).build();
    }

    public static boolean checkVoidedPiglinSpawnRules(EntityType<VoidedPiglin> entityType, LevelAccessor level, MobSpawnType p_34452_, BlockPos pos, Random rand) {
        return level.getDifficulty() != Difficulty.PEACEFUL;
    }
}
