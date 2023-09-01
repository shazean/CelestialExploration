package com.shim.celestialexploration.world.features;

import com.mojang.serialization.Codec;
import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestialexploration.registry.BlockRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import org.apache.logging.log4j.Level;

import java.util.Random;

public class GlowingSandFeature extends Feature<NoneFeatureConfiguration> {

    public GlowingSandFeature(Codec<NoneFeatureConfiguration> p_65865_) {
        super(p_65865_);
    }

    public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> p_159861_) {

        WorldGenLevel worldgenlevel = p_159861_.level();
        BlockPos blockpos = p_159861_.origin();
        Random random = p_159861_.random();
        if (!worldgenlevel.isEmptyBlock(blockpos)) {
            return false;
        } else {
            BlockState blockstate = worldgenlevel.getBlockState(blockpos.below());
            if (!blockstate.is(BlockRegistry.MOON_SAND.get())) {
                return false;
            } else {
                worldgenlevel.setBlock(blockpos, BlockRegistry.GLOWING_MOON_SAND.get().defaultBlockState(), 1);

                for(int i = 0; i < 1500; ++i) {
                    BlockPos blockpos1 = blockpos.offset(random.nextInt(8) - random.nextInt(8), -random.nextInt(12), random.nextInt(8) - random.nextInt(12));
                    if (worldgenlevel.getBlockState(blockpos1).isAir()) {
                        int j = 0;

                        for(Direction direction : Direction.values()) {
                            if (worldgenlevel.getBlockState(blockpos1.relative(direction)).is(BlockRegistry.GLOWING_MOON_SAND.get())) {
                                ++j;
                            }

                            if (j > 1) {
                                break;
                            }
                        }

                        if (j == 1) {
                            worldgenlevel.setBlock(blockpos1, BlockRegistry.GLOWING_MOON_SAND.get().defaultBlockState(), 2);
                        }
                    }
                }

                return true;
            }
        }
    }
}