package com.shim.celestialexploration.world.features;

import com.mojang.serialization.Codec;
import com.shim.celestialexploration.registry.BlockRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

import java.util.Random;

public class AsteroidFeature extends Feature<NoneFeatureConfiguration> {
    public AsteroidFeature(Codec<NoneFeatureConfiguration> p_65701_) {
        super(p_65701_);
    }

    public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> p_159717_) {
        WorldGenLevel worldgenlevel = p_159717_.level();
        Random random = p_159717_.random();
        BlockPos blockpos = p_159717_.origin();
        float f = (float) random.nextInt(3) + 4.0F;

        for (int i = 0; f > 0.5F; --i) {
            for (int j = Mth.floor(-f); j <= Mth.ceil(f); ++j) {
                for (int k = Mth.floor(-f); k <= Mth.ceil(f); ++k) {
                    if ((float) (j * j + k * k) <= (f + 1.0F) * (f + 1.0F)) {
                        this.setBlock(worldgenlevel, blockpos.offset(j, i, k), BlockRegistry.METEOR.get().defaultBlockState());
                    }
                }
            }

            f -= (float) random.nextInt(2) + 0.5F;
        }

        return true;
    }
}

