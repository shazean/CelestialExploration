package com.shim.celestialexploration.world.features;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

import java.util.Random;

public class GeyserFeature extends Feature<NoneFeatureConfiguration> {
    final Block geyser;
    final Block stone;
    final Block sand;

    public GeyserFeature(Codec<NoneFeatureConfiguration> p_65786_, Block geyser, Block stone, Block sand) {
        super(p_65786_);
        this.geyser = geyser;
        this.stone = stone;
        this.sand = sand;
    }

    @Override
    public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> context) {
        WorldGenLevel worldgenlevel = context.level();
        Random random = context.random();
        BlockPos blockpos = context.origin();
        int quantity = random.nextInt(6) + 5;
//        CelestialExploration.LOGGER.debug("Placed! At: " + blockpos);

        for (int i = 0; i < quantity; i++) {
            int x = random.nextInt(14) - 7;
//            int y = blockpos.getY();
            int z = random.nextInt(14) - 7;
            BlockPos newPos = new BlockPos(blockpos.offset(x, 0, z));
            BlockState state = context.level().getBlockState(newPos);
            BlockState stateAbove = context.level().getBlockState(newPos.above());
            BlockState stateBelow = context.level().getBlockState(newPos.below());
            BlockState state2Above = context.level().getBlockState(newPos.above(2));
            BlockState state2Below = context.level().getBlockState(newPos.below(2));

            if ((state.is(stone) || state.is(sand)) && stateAbove.isAir()) {
                this.setBlock(worldgenlevel, newPos, geyser.defaultBlockState());
            } else if ((stateBelow.is(stone) || state.is(sand)) && state.isAir()) {
                this.setBlock(worldgenlevel, newPos.below(), geyser.defaultBlockState());
            } else if ((state2Below.is(stone) || state.is(sand)) && stateBelow.isAir()) {
                this.setBlock(worldgenlevel, newPos.below(2), geyser.defaultBlockState());
            } else if ((stateAbove.is(stone) || state.is(sand)) && state2Above.isAir()) {
                this.setBlock(worldgenlevel, newPos.above(), geyser.defaultBlockState());
            }
        }
        return true;
    }
}
