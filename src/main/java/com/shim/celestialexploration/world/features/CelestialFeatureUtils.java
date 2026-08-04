package com.shim.celestialexploration.world.features;

import com.shim.celestialexploration.registry.CelestialFeatures;
import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

public class CelestialFeatureUtils {


//    public static final Holder<ConfiguredFeature<NoneFeatureConfiguration, ?>> CRATER_TEST = FeatureUtils.register("crater_util", CelestialFeatures.CRATER.get(), new NoneFeatureConfiguration());


    public static final Holder<ConfiguredFeature<NoneFeatureConfiguration, ?>> GEYSER = FeatureUtils.register("geyser", CelestialFeatures.GEYSER.get(), new NoneFeatureConfiguration());
    public static final Holder<ConfiguredFeature<NoneFeatureConfiguration, ?>> IO_GEYSER = FeatureUtils.register("io_geyser", CelestialFeatures.IO_GEYSER.get(), new NoneFeatureConfiguration());

    public static final Holder<ConfiguredFeature<NoneFeatureConfiguration, ?>> JUPITER_CLOUD = FeatureUtils.register("jupiter_cloud", CelestialFeatures.JUPITER_CLOUD_FEATURE.get(), new NoneFeatureConfiguration());

    public static final Holder<ConfiguredFeature<NoneFeatureConfiguration, ?>> PENITENTE = FeatureUtils.register("penitente", CelestialFeatures.PENITENTE.get(), new NoneFeatureConfiguration());
    public static final Holder<ConfiguredFeature<NoneFeatureConfiguration, ?>> HYDRATE = FeatureUtils.register("hydrate", CelestialFeatures.HYDRATE.get(), new NoneFeatureConfiguration());
    public static final Holder<ConfiguredFeature<NoneFeatureConfiguration, ?>> FROZEN_OCEAN = FeatureUtils.register("frozen_ocean", CelestialFeatures.FROZEN_OCEAN.get(), new NoneFeatureConfiguration());

    public static final Holder<ConfiguredFeature<NoneFeatureConfiguration, ?>> SMALL_CRATER = FeatureUtils.register("small_crater", CelestialFeatures.SMALL_CRATER.get(), new NoneFeatureConfiguration());
    public static final Holder<ConfiguredFeature<NoneFeatureConfiguration, ?>> MEDIUM_CRATER = FeatureUtils.register("medium_crater", CelestialFeatures.SMALL_CRATER.get(), new NoneFeatureConfiguration());
    public static final Holder<ConfiguredFeature<NoneFeatureConfiguration, ?>> LARGE_CRATER = FeatureUtils.register("large_crater", CelestialFeatures.SMALL_CRATER.get(), new NoneFeatureConfiguration());

    public static final Holder<ConfiguredFeature<NoneFeatureConfiguration, ?>> SMALL_METEOR = FeatureUtils.register("small_meteor", CelestialFeatures.SMALL_METEOR.get(), new NoneFeatureConfiguration());
    public static final Holder<ConfiguredFeature<NoneFeatureConfiguration, ?>> MEDIUM_METEOR = FeatureUtils.register("medium_meteor", CelestialFeatures.SMALL_METEOR.get(), new NoneFeatureConfiguration());
    public static final Holder<ConfiguredFeature<NoneFeatureConfiguration, ?>> LARGE_METEOR = FeatureUtils.register("large_meteor", CelestialFeatures.SMALL_METEOR.get(), new NoneFeatureConfiguration());



}