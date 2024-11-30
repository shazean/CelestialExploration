package com.shim.celestialexploration.world.features;

import com.shim.celestialexploration.registry.BlockRegistry;
import com.shim.celestialexploration.registry.FeatureRegistry;
import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.LakeFeature;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.RandomFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.RandomPatchConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;

public class CelestialFeatureUtils {

    public static final Holder<ConfiguredFeature<NoneFeatureConfiguration, ?>> GEYSER = FeatureUtils.register("geyser", FeatureRegistry.GEYSER.get(), new NoneFeatureConfiguration());

    public static final Holder<ConfiguredFeature<NoneFeatureConfiguration, ?>> JUPITER_CLOUD = FeatureUtils.register("jupiter_cloud", FeatureRegistry.JUPITER_CLOUD_FEATURE.get(), new NoneFeatureConfiguration());

    public static final Holder<ConfiguredFeature<NoneFeatureConfiguration, ?>> PENITENTE = FeatureUtils.register("penitente", FeatureRegistry.PENITENTE.get(), new NoneFeatureConfiguration());
    public static final Holder<ConfiguredFeature<NoneFeatureConfiguration, ?>> HYDRATE = FeatureUtils.register("hydrate", FeatureRegistry.HYDRATE.get(), new NoneFeatureConfiguration());
    public static final Holder<ConfiguredFeature<NoneFeatureConfiguration, ?>> FROZEN_OCEAN = FeatureUtils.register("frozen_ocean", FeatureRegistry.FROZEN_OCEAN.get(), new NoneFeatureConfiguration());



}