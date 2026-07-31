package com.shim.celestialexploration.world.features;

import com.mojang.serialization.Codec;
import com.shim.celestialexploration.registry.CelestialBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.*;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

public class CraterFeature extends Feature<NoneFeatureConfiguration> {
    private static final Direction[] DIRECTIONS = Direction.values();

    public CraterFeature(Codec<NoneFeatureConfiguration> codec) {
        super(codec);
    }

    @Override
    public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> context) {

        int radius = 13 + context.random().nextInt(3); //get from config?
        int x;
        int y;
        int z;
        int point;
        WorldGenLevel level = context.level();
        BlockPos pos = context.origin();
//        int bottom = radius;
        int radiusSq = radius * radius;

        for (int row = 0; row < radius * 2 + 1; row++) {
            for (int col = 0; col < radius * 2 + 1; col++) {
                for (int height = 0; height < radius; height++) {
                    x = radius - row;
                    y = radius - height;
                    z = radius - col;

                    point = x * x + z * z + y * y;

                    if (point <= radiusSq + 1) {
                        level.setBlock(pos.offset(x, -y, z), Blocks.AIR.defaultBlockState(), 2);
                    }

//                    bottom = Math.min(y, bottom);
                }
            }
        }

        int meteorRadius = 4; //Math.max(radius / 5, 1);
        int meteorRadiusSQ = meteorRadius * meteorRadius;
        BlockPos meteorCorner = pos.offset(radius, radius + 3, radius);

        for (int row = 0; row < meteorRadius * 2 + 1; row++) {
            for (int col = 0; col < meteorRadius * 2 + 1; col++) {
                for (int height = 0; height < meteorRadius; height++) {
                    x = meteorRadius - row;
                    y = meteorRadius - height;
                    z = meteorRadius - col;
                    point = x * x + y * y + z * z;
                    if (point <= meteorRadiusSQ + 1) {

                        if (level.getBlockState(meteorCorner.offset(x, y, z)).isAir()) {

                            level.setBlock(pos.offset(x, y, z), CelestialBlocks.METEOR.get().defaultBlockState(), 2);
                        }
                    }
                }
            }
        }

        return true;
    }
}