package com.shim.celestialexploration.entity.entity.friendlies;

import net.minecraft.core.BlockPos;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.Cat;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;

import java.util.Random;

public class CelestialCat extends Cat {
    public CelestialCat(EntityType<? extends Cat> p_28114_, Level p_28115_) {
        super(p_28114_, p_28115_);
    }


    public static boolean checkCatSpawnRules(EntityType<? extends Animal> p_27578_, LevelAccessor p_27579_, MobSpawnType p_27580_, BlockPos p_27581_, Random p_27582_) {
//        return p_27579_.getBlockState(p_27581_.below()).is(BlockTags.ANIMALS_SPAWNABLE_ON) && isBrightEnoughToSpawn(p_27579_, p_27581_);
        return isBrightEnoughToSpawn(p_27579_, p_27581_);
    }
}