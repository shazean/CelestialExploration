package com.shim.celestialexploration.world.features;

import com.shim.celestialexploration.registry.CelestialBlocks;
import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.*;

import java.util.List;

public class CelestialFeatures {

    public static final Holder<ConfiguredFeature<DiskConfiguration, ?>> DISK_MARS_SAND = FeatureUtils.register("disk_mars_sand", Feature.DISK, new DiskConfiguration(CelestialBlocks.MARS_SAND.get().defaultBlockState(), UniformInt.of(2, 6), 2, List.of(CelestialBlocks.MARS_STONE.get().defaultBlockState())));
    public static final Holder<ConfiguredFeature<DiskConfiguration, ?>> DISK_MOON_SAND = FeatureUtils.register("disk_moon_sand", Feature.DISK, new DiskConfiguration(CelestialBlocks.MOON_SAND.get().defaultBlockState(), UniformInt.of(2, 6), 2, List.of(CelestialBlocks.MOON_STONE.get().defaultBlockState())));
    public static final Holder<ConfiguredFeature<DiskConfiguration, ?>> DISK_VENUS_SAND = FeatureUtils.register("disk_venus_sand", Feature.DISK, new DiskConfiguration(CelestialBlocks.VENUS_SAND.get().defaultBlockState(), UniformInt.of(2, 6), 2, List.of(CelestialBlocks.VENUS_STONE.get().defaultBlockState())));
    public static final Holder<ConfiguredFeature<DiskConfiguration, ?>> DISK_MERCURY_SAND = FeatureUtils.register("disk_mercury_sand", Feature.DISK, new DiskConfiguration(CelestialBlocks.MERCURY_SAND.get().defaultBlockState(), UniformInt.of(2, 6), 2, List.of(CelestialBlocks.MERCURY_STONE.get().defaultBlockState())));
    public static final Holder<ConfiguredFeature<DiskConfiguration, ?>> DISK_IO_SAND = FeatureUtils.register("disk_io_sand", Feature.DISK, new DiskConfiguration(CelestialBlocks.IO_SAND.get().defaultBlockState(), UniformInt.of(2, 6), 2, List.of(CelestialBlocks.IO_STONE.get().defaultBlockState())));


}