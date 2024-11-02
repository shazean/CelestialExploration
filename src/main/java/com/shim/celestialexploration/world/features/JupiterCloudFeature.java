package com.shim.celestialexploration.world.features;

import com.mojang.serialization.Codec;
import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestialexploration.registry.BiomeRegistry;
import com.shim.celestialexploration.registry.BlockRegistry;
import com.shim.celestialexploration.registry.TagRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.QuartPos;
import net.minecraft.util.Mth;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.LegacyRandomSource;
import net.minecraft.world.level.levelgen.WorldgenRandom;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.MineshaftConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleRandomFeatureConfiguration;
import net.minecraft.world.level.levelgen.structure.pieces.PieceGeneratorSupplier;

import java.util.Random;

public class JupiterCloudFeature extends Feature<NoneFeatureConfiguration> {
    public JupiterCloudFeature(Codec<NoneFeatureConfiguration> p_65786_) {
        super(p_65786_);
    }

//    private static boolean checkLocation(PieceGeneratorSupplier.Context<NoneFeatureConfiguration> context) {
//        WorldgenRandom worldgenrandom = new WorldgenRandom(new LegacyRandomSource(0L));
//        worldgenrandom.setLargeFeatureSeed(context.seed(), context.chunkPos().x, context.chunkPos().z);
//
//
//
//        double d0 = 10.0F;
//        return !(worldgenrandom.nextDouble() >= d0) && context.validBiome().test(context.chunkGenerator().getNoiseBiome(QuartPos.fromBlock(context.chunkPos().getMiddleBlockX()), QuartPos.fromBlock(50),
//                QuartPos.fromBlock(context.chunkPos().getMiddleBlockZ())));
//    }

    @Override
    public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> context) {
        WorldGenLevel worldgenlevel = context.level();
        Random random = context.random();
        BlockPos blockpos = context.origin(); //.above(150 + random.nextInt(75));
//        int quantity = random.nextInt(6) + 5;
        int height = random.nextInt(3) + 1;
        int widthRadius = random.nextInt(3) + 2;
        int depthRadius = random.nextInt(5) + 3;

        if (!worldgenlevel.getBlockState(blockpos).isAir())
            return false;

//        Holder<Biome> emptyBiome = BiomeRegistry.JUPITER_ETHER.get();
//
//        emptyBiome.is(context.get)


        //        int i;
//        CelestialExploration.LOGGER.debug("Placed! At: " + blockpos);



//        float f = (float)random.nextInt(3) + 4.0F;

//        width = 6;
//        depth = 8;

//        height = 3;
//        widthRadius = 5;
//        depthRadius = 7;

        int xOffset = 0;
        int zOffset = 0;
        int zigzag = 0;

        for (int i = 0; i <= height; i++) {
            widthRadius = random.nextInt(5) == 0 ? widthRadius - 1 : widthRadius;

            for (int j = -widthRadius; j <= widthRadius; j++) {
                zigzag = random.nextInt(4) == 0 ? 1 : random.nextInt(4) == 1 ? -1 : 0;

                for (int k = -depthRadius; k <= depthRadius; k++) {
                    if (Math.abs(j * k) < ((float) (widthRadius) * (depthRadius) / 5.0 * 3.0))
                        this.setBlock(worldgenlevel, blockpos.offset(j + zOffset, i, k + xOffset + zigzag), BlockRegistry.JUPITER_ATMOSPHERE.get().defaultBlockState());

                }
            }
            xOffset += random.nextInt(3) + 1;
            zOffset = random.nextInt(4) == 0 ? zOffset + 1 : zOffset;
        }


//        for (int i = -height; i <= height; i++) {
//
//            for (int j = -widthRadius - Math.abs(i); j <= widthRadius - Math.abs(i); j++) {
//                for (int k = -depthRadius - Math.abs(i); k <= depthRadius - Math.abs(i); k++) {
//
//                    if (Math.abs(j * k) < ((float) ((widthRadius - Math.abs(i)) * (depthRadius - Math.abs(i))) / 5.0 * 3.0))
//                        this.setBlock(worldgenlevel, blockpos.xOffset(j, i, k), BlockRegistry.JUPITER_ATMOSPHERE.get().defaultBlockState());
//
//                }
//            }
//        }

//        for(int i = 0; f > 0.5F; --i) {
//            for(int j = Mth.floor(-f); j <= Mth.ceil(f); ++j) {
//                for(int k = Mth.floor(-f); k <= Mth.ceil(f + 4); ++k) {
//                    if ((float)(j * j + k * k) <= (f + 1.0F) * (f + 1.0F)) {
//                        this.setBlock(worldgenlevel, blockpos.xOffset(j, i, k), BlockRegistry.JUPITER_ATMOSPHERE.get().defaultBlockState());
//                    }
//                }
//            }
//
//            for(int j = Mth.ceil(f); j >= Mth.floor(f); --j) {
//                for(int k = Mth.ceil(f); k >= Mth.floor(f); --k) {
//                    if ((float)(j * j + k * k) <= (f + 1.0F) * (f + 1.0F)) {
//                        this.setBlock(worldgenlevel, blockpos.xOffset(j, i, k), BlockRegistry.JUPITER_DEEPSLATE.get().defaultBlockState());
//                    }
//                }
//            }
//
//            f -= (float)random.nextInt(2) + 0.5F;
//        }




//        BlockPos newPos = new BlockPos(blockpos.xOffset(j, 0, j));
//        this.setBlock(worldgenlevel,  blockpos, BlockRegistry.JUPITER_DEEPSLATE.get().defaultBlockState());
//        CelestialExploration.LOGGER.debug("cloud at: " + blockpos);


        //bottom layer
//        for (int j = 1; j < width - 1; j++) {
//            for (int k = 1; k < depth - 1; k++) {
//                if (j == (width - 2) && k == (depth - 2)) {
//                    break;
//                }
//
//                BlockPos newPos = new BlockPos(blockpos.xOffset(j, 0, k));
//                this.setBlock(worldgenlevel, newPos, BlockRegistry.JUPITER_ATMOSPHERE.get().defaultBlockState());
//            }
//        }
//
//        //middle layers
//        for (int i = 1; i < height - 2; i++) {
//            for (int j = 0; j < width; j++) {
//                for (int k = 0; k < depth; k++) {
//                    if (j == (width - 1) && k == (depth - 1)) {
//                        break;
//                    }
//
//                    BlockPos newPos = new BlockPos(blockpos.xOffset(j, i, k));
//                    this.setBlock(worldgenlevel, newPos, BlockRegistry.JUPITER_ATMOSPHERE.get().defaultBlockState());
//                }
//            }
//        }
//
//        //top layer
//        for (int j = 1; j < width - 1; j++) {
//            for (int k = 1; k < depth - 1; k++) {
//                if (j == (width - 2) && k == (depth - 2)) {
//                    break;
//                }
//
//                BlockPos newPos = new BlockPos(blockpos.xOffset(j, height, k));
//                this.setBlock(worldgenlevel, newPos, BlockRegistry.JUPITER_ATMOSPHERE.get().defaultBlockState());
//            }
//        }

        return true;
    }
}
