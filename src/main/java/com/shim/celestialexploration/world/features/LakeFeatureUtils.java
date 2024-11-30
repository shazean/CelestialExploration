package com.shim.celestialexploration.world.features;

import com.shim.celestialexploration.registry.BlockRegistry;
import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.LakeFeature;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;

public class LakeFeatureUtils {

    public static final Holder<ConfiguredFeature<LakeFeature.Configuration, ?>> MOON_LAVA_LAKE = FeatureUtils.register("moon_lava_lake", Feature.LAKE, new LakeFeature.Configuration(BlockStateProvider.simple(Blocks.LAVA.defaultBlockState()), BlockStateProvider.simple(BlockRegistry.MOON_STONE.get().defaultBlockState())));
    public static final Holder<ConfiguredFeature<LakeFeature.Configuration, ?>> MARS_LAVA_LAKE = FeatureUtils.register("mars_lava_lake", Feature.LAKE, new LakeFeature.Configuration(BlockStateProvider.simple(Blocks.LAVA.defaultBlockState()), BlockStateProvider.simple(BlockRegistry.MARS_STONE.get().defaultBlockState())));
    public static final Holder<ConfiguredFeature<LakeFeature.Configuration, ?>> VENUS_LAVA_LAKE = FeatureUtils.register("venus_lava_lake", Feature.LAKE, new LakeFeature.Configuration(BlockStateProvider.simple(Blocks.LAVA.defaultBlockState()), BlockStateProvider.simple(BlockRegistry.VENUS_STONE.get().defaultBlockState())));
    public static final Holder<ConfiguredFeature<LakeFeature.Configuration, ?>> MERCURY_LAVA_LAKE = FeatureUtils.register("mercury_lava_lake", Feature.LAKE, new LakeFeature.Configuration(BlockStateProvider.simple(Blocks.LAVA.defaultBlockState()), BlockStateProvider.simple(BlockRegistry.MERCURY_STONE.get().defaultBlockState())));

    public static final Holder<ConfiguredFeature<LakeFeature.Configuration, ?>> OBSIDIAN_LAKE = FeatureUtils.register("obsidian_lake", Feature.LAKE, new LakeFeature.Configuration(BlockStateProvider.simple(Blocks.OBSIDIAN.defaultBlockState()), BlockStateProvider.simple(BlockRegistry.MOON_STONE.get().defaultBlockState())));


}
