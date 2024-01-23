package com.shim.celestialexploration.world.features;

import com.mojang.serialization.Codec;
import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestialexploration.registry.BlockRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

import java.util.Random;

public class GeyserFeature extends Feature<NoneFeatureConfiguration> {
    public GeyserFeature(Codec<NoneFeatureConfiguration> p_65786_) {
        super(p_65786_);
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

            if (state.is(BlockRegistry.VENUS_STONE.get()) || state.is(BlockRegistry.VENUS_SAND.get()) && stateAbove.isAir()) {
                this.setBlock(worldgenlevel, newPos, BlockRegistry.GEYSER.get().defaultBlockState());
            } else if (stateBelow.is(BlockRegistry.VENUS_STONE.get()) || state.is(BlockRegistry.VENUS_SAND.get()) && state.isAir()) {
                this.setBlock(worldgenlevel, newPos.below(), BlockRegistry.GEYSER.get().defaultBlockState());
            } else if (state2Below.is(BlockRegistry.VENUS_STONE.get()) || state.is(BlockRegistry.VENUS_SAND.get()) && stateBelow.isAir()) {
                this.setBlock(worldgenlevel, newPos.below(2), BlockRegistry.GEYSER.get().defaultBlockState());
            } else if (stateAbove.is(BlockRegistry.VENUS_STONE.get()) || state.is(BlockRegistry.VENUS_SAND.get()) && state2Above.isAir()) {
                this.setBlock(worldgenlevel, newPos.above(), BlockRegistry.GEYSER.get().defaultBlockState());
            }
        }
        return true;
    }
}
