package com.shim.celestialexploration.world.features;

import com.shim.celestialexploration.registry.FeatureRegistry;
import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

public class CelestialFeatureUtils {

    public static final Holder<ConfiguredFeature<NoneFeatureConfiguration, ?>> GEYSER = FeatureUtils.register("geyser", FeatureRegistry.GEYSER.get(), new NoneFeatureConfiguration());

    public static final Holder<ConfiguredFeature<NoneFeatureConfiguration, ?>> JUPITER_CLOUD = FeatureUtils.register("jupiter_cloud", FeatureRegistry.JUPITER_CLOUD_FEATURE.get(), new NoneFeatureConfiguration());

}