package com.shim.celestialexploration.world.features;

import com.mojang.serialization.Codec;
import com.shim.celestialexploration.registry.CelestialBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraft.world.level.material.Fluids;

import java.util.List;

public class LinedCraterFeature extends Feature<NoneFeatureConfiguration> {
    private final int lowerSize;
    private final int upperSize;
    private final BlockState LINER;
    private static final BlockState AIR = Blocks.AIR.defaultBlockState();
    private static final BlockState SLIME = CelestialBlocks.MERCURY_SLIME_BLOCK.get().defaultBlockState();

    public LinedCraterFeature(Codec<NoneFeatureConfiguration> codec, int lowerSize, int upperSize, Block linerBlock) {
        super(codec);
        this.lowerSize = lowerSize;
        this.upperSize = upperSize;
        this.LINER = linerBlock.defaultBlockState();
    }

    @Override
    public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> context) {

        int radius = Mth.clamp(context.random().nextInt(this.upperSize - this.lowerSize) + this.lowerSize, 5, 16);
        int x;
        int y;
        int z;
        int point;
        WorldGenLevel level = context.level();
        BlockPos pos = context.origin();
        int radiusSq = radius * radius;

        if (level.getFluidState(pos).is(Fluids.WATER))
            return false;

       for (int row = radius * 2 + 1; row > 0; row--) {
            for (int col = radius * 2 + 1; col > 0; col--) {
                for (int height = radius * 2 + 1; height > 0; height--) {

                    x = radius - row;
                    y = radius - height;
                    z = radius - col;

                    point = x * x + z * z + y * y;

                    if (point <= radiusSq + 1) {
                        BlockState stateBelow = level.getBlockState(pos.offset(x, y, z).below());
                        if (!stateBelow.is(Blocks.AIR) && !stateBelow.is(LINER.getBlock()))
                            level.setBlock(pos.offset(x, y, z), LINER, 2);
                        else
                            level.setBlock(pos.offset(x, y, z), AIR, 2);
                    }
                }
            }
        }

        return true;
    }
}