package com.shim.celestialexploration.world.features;

import com.shim.celestialexploration.registry.BlockRegistry;
import com.shim.celestialexploration.registry.FeatureRegistry;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderSet;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.LakeFeature;
import net.minecraft.world.level.levelgen.feature.configurations.*;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.placement.EnvironmentScanPlacement;
import net.minecraft.world.level.levelgen.placement.RandomOffsetPlacement;
import net.minecraft.world.level.material.Fluids;

import java.util.List;

public class CelestialFeatures {

    public static final Holder<ConfiguredFeature<DiskConfiguration, ?>> DISK_MARS_SAND = FeatureUtils.register("disk_mars_sand", Feature.DISK, new DiskConfiguration(BlockRegistry.MARS_SAND.get().defaultBlockState(), UniformInt.of(2, 6), 2, List.of(BlockRegistry.MARS_STONE.get().defaultBlockState())));
    public static final Holder<ConfiguredFeature<DiskConfiguration, ?>> DISK_MOON_SAND = FeatureUtils.register("disk_moon_sand", Feature.DISK, new DiskConfiguration(BlockRegistry.MOON_SAND.get().defaultBlockState(), UniformInt.of(2, 6), 2, List.of(BlockRegistry.MOON_STONE.get().defaultBlockState())));
    public static final Holder<ConfiguredFeature<DiskConfiguration, ?>> DISK_VENUS_SAND = FeatureUtils.register("disk_venus_sand", Feature.DISK, new DiskConfiguration(BlockRegistry.VENUS_SAND.get().defaultBlockState(), UniformInt.of(2, 6), 2, List.of(BlockRegistry.VENUS_STONE.get().defaultBlockState())));
    public static final Holder<ConfiguredFeature<DiskConfiguration, ?>> DISK_MERCURY_SAND = FeatureUtils.register("disk_mercury_sand", Feature.DISK, new DiskConfiguration(BlockRegistry.MERCURY_SAND.get().defaultBlockState(), UniformInt.of(2, 6), 2, List.of(BlockRegistry.MERCURY_STONE.get().defaultBlockState())));
//    public static final Holder<ConfiguredFeature<DiskConfiguration, ?>> DISK_IO_SAND = FeatureUtils.register("disk_io_sand", Feature.DISK, new DiskConfiguration(BlockRegistry.IO_SAND.get().defaultBlockState(), UniformInt.of(2, 6), 2, List.of(BlockRegistry.IO_STONE.get().defaultBlockState())));

    public static final Holder<ConfiguredFeature<LakeFeature.Configuration, ?>> OBSIDIAN_LAKE = FeatureUtils.register("obsidian_lake", Feature.LAKE, new LakeFeature.Configuration(BlockStateProvider.simple(Blocks.OBSIDIAN.defaultBlockState()), BlockStateProvider.simple(BlockRegistry.MOON_STONE.get().defaultBlockState())));

}