package com.shim.celestialexploration.world.features;

import com.mojang.serialization.Codec;
import com.shim.celestialexploration.blocks.PenitenteBlock;
import com.shim.celestialexploration.registry.BlockRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.KelpBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.DripstoneThickness;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.RandomPatchFeature;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.RandomPatchConfiguration;

import java.util.Random;

public class PenitenteFeature extends Feature<NoneFeatureConfiguration> {
    public PenitenteFeature(Codec<NoneFeatureConfiguration> p_66605_) {
        super(p_66605_);
    }

    public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> context) {
        int i = 0;
        Random random = context.random();
        BlockPos blockpos = context.origin();
        WorldGenLevel worldgenlevel = context.level();

        int j = worldgenlevel.getHeight(Heightmap.Types.WORLD_SURFACE, blockpos.getX(), blockpos.getZ());
        BlockPos groundPos = new BlockPos(blockpos.getX(), j, blockpos.getZ());

        int k = random.nextInt(4) + 2;

        BlockState penitente = BlockRegistry.PENITENTE.get().defaultBlockState();
        groundPos.below();

        for(int l = 0; l <= k; ++l) {
            int rand = random.nextInt(12) + 6;
            int randNS = random.nextInt(8) -4;
            int randWE = random.nextInt(8) -4;

            groundPos = new BlockPos(blockpos.getX() + randNS, worldgenlevel.getHeight(Heightmap.Types.WORLD_SURFACE, blockpos.getX() + randNS, blockpos.getZ() + randWE), blockpos.getZ() + randWE);
//            groundPos = groundPos.north(randNS).west(randWE);

            for (int m = 0; m <= rand; m++) {
                if (m == 0) {
                    if (worldgenlevel.getBlockState(groundPos.below()).is(BlockRegistry.PENITENTE.get()))
                        break;
                    else if (!(worldgenlevel.getBlockState(groundPos.below()).is(BlockRegistry.MOON_SAND.get()) || (worldgenlevel.getBlockState(groundPos.below()).is(BlockRegistry.EUROPA_HYDRATE.get()))))
                        break;
                    worldgenlevel.setBlock(groundPos.above(m), penitente.setValue(PenitenteBlock.THICKNESS, DripstoneThickness.BASE), 1);
                } else if (m == rand) {
//                    if (worldgenlevel.getBlockState(groundPos).isFaceSturdy(worldgenlevel, groundPos, Direction.UP))
                        worldgenlevel.setBlock(groundPos.above(m), penitente.setValue(PenitenteBlock.THICKNESS, DripstoneThickness.TIP), 1);
                } else if (m == rand - 1) {
//                    if (worldgenlevel.getBlockState(groundPos).isFaceSturdy(worldgenlevel, groundPos, Direction.UP))
                        worldgenlevel.setBlock(groundPos.above(m), penitente.setValue(PenitenteBlock.THICKNESS, DripstoneThickness.FRUSTUM), 1);
                } else {
//                    if (worldgenlevel.getBlockState(groundPos).isFaceSturdy(worldgenlevel, groundPos, Direction.UP))
                        worldgenlevel.setBlock(groundPos.above(m), penitente.setValue(PenitenteBlock.THICKNESS, DripstoneThickness.MIDDLE), 1);
                }
            }
//            if (penitente.canSurvive(worldgenlevel, groundPos)) {
//                if (l == k) {
//                    worldgenlevel.setBlock(groundPos, penitente, 1);
//                    ++i;
//                } else {
//                    worldgenlevel.setBlock(groundPos, penitente, 1);
//                }
//            } else if (l > 0) {
//                BlockPos blockpos2 = groundPos.below();
//                if (penitente.canSurvive(worldgenlevel, blockpos2) && !worldgenlevel.getBlockState(blockpos2.below()).is(Blocks.KELP)) {
//                    worldgenlevel.setBlock(blockpos2, penitente, 1);
//                    ++i;
//                }
//                break;
//            }
//
//            groundPos = groundPos.above();
        }
        return true;
    }
}