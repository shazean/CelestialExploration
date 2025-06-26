package com.shim.celestialexploration.world.features;

import com.mojang.serialization.Codec;
import com.shim.celestialexploration.registry.CelestialBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

import java.util.Random;

public class HydrateFeature extends Feature<NoneFeatureConfiguration> {
    public HydrateFeature(Codec<NoneFeatureConfiguration> p_65786_) {
        super(p_65786_);
    }

    @Override
    public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> context) {
        Random random = context.random();
//        Direction direction = random.nextInt(2) == 0 ? Direction.WEST : Direction.NORTH;
        BlockPos blockpos = context.origin();
        WorldGenLevel worldgenlevel = context.level();

        int height = worldgenlevel.getHeight(Heightmap.Types.WORLD_SURFACE, blockpos.getX(), blockpos.getZ());

        int length = random.nextInt(15) + 8;
        BlockPos pos = new BlockPos(blockpos.getX(), height, blockpos.getZ());

        int l = 0;
        int h = 0;
        int direction = random.nextInt(6);
        if (random.nextInt(2) == 0) {
            l = 1;
        } else {
            h = 1;
        }

//        int direction = random.nextInt(6);
//        if (direction == 0 || direction == 1) {
//            l = 1;
//        } else if (direction == 2 || direction == 3) {
//            h = 1;
//        } else if (direction == 4) {
//            l = 1;
//            h = 1;
//        } else {
//            l = -1;
//            h = 1;
//        }

//        for (int i = 0; i < 4; i++) {
        for (int j = 0; j < length; j++) {
//                if ((i == 0 || i == 3) && !(j == 0 || j == 1 || j == 2 || j == length - 1 || j == length - 2 || j == length - 3)) {
//                    pos.relative(direction, 1);

//                if (random.nextInt(5) == 0)
//                        pos.relative(direction.getClockWise(), 1);

//                if (random.nextInt(10) == 0) {
//                    if ((l == 1 || l == -1) && h == 0) {
//                        pos.west();
//                    } else if (h == 1 && l == 0) {
//                        pos.north();
//                    }
//                }
//                    pos.relative(direction.getClockWise(), j);
            pos = new BlockPos(pos.getX() + l, worldgenlevel.getHeight(Heightmap.Types.WORLD_SURFACE, pos.getX(), pos.getZ()), pos.getZ() + h);

            //TODO if sturdy face below
            worldgenlevel.setBlock(pos.below(), CelestialBlocks.EUROPA_HYDRATE.get().defaultBlockState(), 1);
//                }
        }

//        }
        return false;
    }
}