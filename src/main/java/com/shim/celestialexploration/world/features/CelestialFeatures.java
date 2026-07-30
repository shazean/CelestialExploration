package com.shim.celestialexploration.world.features;

import com.shim.celestialexploration.registry.CelestialBlocks;
import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.GeodeBlockSettings;
import net.minecraft.world.level.levelgen.GeodeCrackSettings;
import net.minecraft.world.level.levelgen.GeodeLayerSettings;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.*;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;

import java.util.List;

public class CelestialFeatures {

    public static final Holder<ConfiguredFeature<DiskConfiguration, ?>> DISK_MARS_SAND = FeatureUtils.register("disk_mars_sand", Feature.DISK, new DiskConfiguration(CelestialBlocks.MARS_SAND.get().defaultBlockState(), UniformInt.of(2, 6), 2, List.of(CelestialBlocks.MARS_STONE.get().defaultBlockState())));
    public static final Holder<ConfiguredFeature<DiskConfiguration, ?>> DISK_MOON_SAND = FeatureUtils.register("disk_moon_sand", Feature.DISK, new DiskConfiguration(CelestialBlocks.MOON_SAND.get().defaultBlockState(), UniformInt.of(2, 6), 2, List.of(CelestialBlocks.MOON_STONE.get().defaultBlockState())));
    public static final Holder<ConfiguredFeature<DiskConfiguration, ?>> DISK_VENUS_SAND = FeatureUtils.register("disk_venus_sand", Feature.DISK, new DiskConfiguration(CelestialBlocks.VENUS_SAND.get().defaultBlockState(), UniformInt.of(2, 6), 2, List.of(CelestialBlocks.VENUS_STONE.get().defaultBlockState())));
    public static final Holder<ConfiguredFeature<DiskConfiguration, ?>> DISK_MERCURY_SAND = FeatureUtils.register("disk_mercury_sand", Feature.DISK, new DiskConfiguration(CelestialBlocks.MERCURY_SAND.get().defaultBlockState(), UniformInt.of(2, 6), 2, List.of(CelestialBlocks.MERCURY_STONE.get().defaultBlockState())));
    public static final Holder<ConfiguredFeature<DiskConfiguration, ?>> DISK_IO_SAND = FeatureUtils.register("disk_io_sand", Feature.DISK, new DiskConfiguration(CelestialBlocks.IO_SAND.get().defaultBlockState(), UniformInt.of(2, 6), 2, List.of(CelestialBlocks.IO_STONE.get().defaultBlockState())));

    public static final Holder<ConfiguredFeature<GeodeConfiguration, ?>> DIAMOND_GEODE = FeatureUtils.register("diamond_geode", Feature.GEODE, new GeodeConfiguration(
            new GeodeBlockSettings(BlockStateProvider.simple(Blocks.AIR), //filling provider
                    BlockStateProvider.simple(CelestialBlocks.DIAMOND_CHUNK.get()), //inner layer
                    BlockStateProvider.simple(CelestialBlocks.DIAMOND_CHUNK.get()), //alternate inner layer
                    BlockStateProvider.simple(Blocks.COAL_BLOCK), //middle layer
                    BlockStateProvider.simple(CelestialBlocks.MERCURY_DEEPSLATE.get()), //outer layer
                    List.of(CelestialBlocks.SMALL_DIAMOND_CRYSTAL.get().defaultBlockState(), CelestialBlocks.MEDIUM_DIAMOND_CRYSTAL.get().defaultBlockState(), CelestialBlocks.LARGE_DIAMOND_CRYSTAL.get().defaultBlockState(), CelestialBlocks.DIAMOND_CLUSTER.get().defaultBlockState()), //inner placements
                    BlockTags.FEATURES_CANNOT_REPLACE, BlockTags.GEODE_INVALID_BLOCKS), //cannot replace and invalid
            new GeodeLayerSettings(0.6D, 0.9D, 2.5D, 3.8D), //ranges: filling, inner, middle, outer 1.7, 2.2, 3.2, 4.2
            new GeodeCrackSettings(0.95D, 2.3D, 2), //chance, base size, point offset
            0.35D, //usePotentialPlacementsChance
            0.053D, //useAlternateLayer0Chance
            true, //placementsRequireLayer0Alternate
            UniformInt.of(4, 6), //outerWallDistance 4, 6
            UniformInt.of(3, 4), //distributionPoints
            UniformInt.of(1, 2), //pointOffset
            -16, //minGenOffset
            16, //maxGenOffset
            0.05D, //noiseMultiplier
            1)); //invalidBlocksThreshold



}