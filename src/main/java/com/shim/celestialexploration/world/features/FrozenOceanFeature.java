package com.shim.celestialexploration.world.features;

import com.mojang.serialization.Codec;
import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestialexploration.blocks.PenitenteBlock;
import com.shim.celestialexploration.registry.BlockRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.DripstoneThickness;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.feature.DiskReplaceFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.DiskConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

import java.util.Random;

public class FrozenOceanFeature extends Feature<NoneFeatureConfiguration> {
    public FrozenOceanFeature(Codec<NoneFeatureConfiguration> p_66605_) {
        super(p_66605_);
    }

    public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> context) {
        Random random = context.random();
        BlockPos blockpos = context.origin();
        WorldGenLevel worldgenlevel = context.level();

//        int height = worldgenlevel.getHeight(Heightmap.Types.WORLD_SURFACE, blockpos.getX(), blockpos.getZ());
        BlockPos groundPos = new BlockPos(blockpos.getX(), 57, blockpos.getZ());

        for (int i = -6; i <= 6; i++) {
            for (int j = -6; j <= 6; j++) {
//                CelestialExploration.LOGGER.debug("placing at: " + groundPos);

                for (int k = 0; k < 4; k++) {
//                    if (worldgenlevel.getBlockState(groundPos).is(Blocks.WATER)) {
//                        groundPos = new BlockPos(groundPos.getX() + 1, groundPos.getY(), groundPos.getZ() + 1);
                        worldgenlevel.setBlock(groundPos.offset(i, -k, j), Blocks.PACKED_ICE.defaultBlockState(), 1);
//                    }
                    groundPos.below();
                }

//                if (worldgenlevel.getBlockState(groundPos).is(Blocks.WATER)) {
                worldgenlevel.setBlock(groundPos.offset(i, -4, j), Blocks.ICE.defaultBlockState(), 1);

                worldgenlevel.setBlock(groundPos.offset(i, -5, j), Blocks.ICE.defaultBlockState(), 1);
//                }


            }
        }

        return true;
    }
}