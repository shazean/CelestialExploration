package com.shim.celestialexploration.world.features;

import com.shim.celestialexploration.registry.BlockRegistry;
import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

import java.util.List;

public class CelestialOreFeatures {

    public static final RuleTest MOON_ORE_REPLACEABLES = new TagMatchTest(BlockRegistry.MOON_STONE_TAG);
    public static final RuleTest MOON_DEEPSLATE_ORE_REPLACEABLES = new TagMatchTest(BlockRegistry.MOON_DEEPSLATE_TAG);
    public static final RuleTest MARS_ORE_REPLACEABLES = new TagMatchTest(BlockRegistry.MARS_STONE_TAG);
    public static final RuleTest MARS_DEEPSLATE_ORE_REPLACEABLES = new TagMatchTest(BlockRegistry.MARS_DEEPSLATE_TAG);

    public static final List<OreConfiguration.TargetBlockState> MOON_IRON_ORES = List.of(
            OreConfiguration.target(MOON_ORE_REPLACEABLES, BlockRegistry.MOON_IRON_ORE.get().defaultBlockState()),
            OreConfiguration.target(MOON_DEEPSLATE_ORE_REPLACEABLES, BlockRegistry.MOON_DEEPSLATE_IRON_ORE.get().defaultBlockState()));

    public static final List<OreConfiguration.TargetBlockState> MOON_REDSTONE_ORES = List.of(
            OreConfiguration.target(MOON_ORE_REPLACEABLES, BlockRegistry.MOON_REDSTONE_ORE.get().defaultBlockState()),
            OreConfiguration.target(MOON_ORE_REPLACEABLES, BlockRegistry.MOON_DEEPSLATE_REDSTONE_ORE.get().defaultBlockState()));

    public static final List<OreConfiguration.TargetBlockState> MARS_IRON_ORES = List.of(
            OreConfiguration.target(MARS_ORE_REPLACEABLES, BlockRegistry.MARS_IRON_ORE.get().defaultBlockState()),
            OreConfiguration.target(MARS_DEEPSLATE_ORE_REPLACEABLES, BlockRegistry.MARS_DEEPSLATE_IRON_ORE.get().defaultBlockState()));

    public static final List<OreConfiguration.TargetBlockState> MARS_REDSTONE_ORES = List.of(
            OreConfiguration.target(MARS_ORE_REPLACEABLES, BlockRegistry.MARS_REDSTONE_ORE.get().defaultBlockState()),
            OreConfiguration.target(MARS_ORE_REPLACEABLES, BlockRegistry.MARS_DEEPSLATE_REDSTONE_ORE.get().defaultBlockState()));


    public static final Holder<ConfiguredFeature<OreConfiguration, ?>> MOON_IRON_ORE = FeatureUtils.register("moon_iron_ore", Feature.ORE, new OreConfiguration(MOON_IRON_ORES, 10));
    public static final Holder<ConfiguredFeature<OreConfiguration, ?>> MOON_REDSTONE_ORE = FeatureUtils.register("moon_redstone_ore", Feature.ORE, new OreConfiguration(MOON_REDSTONE_ORES, 8));

    public static final Holder<ConfiguredFeature<OreConfiguration, ?>> MARS_IRON_ORE = FeatureUtils.register("mars_iron_ore", Feature.ORE, new OreConfiguration(MARS_IRON_ORES, 12));
    public static final Holder<ConfiguredFeature<OreConfiguration, ?>> MARS_REDSTONE_ORE = FeatureUtils.register("mars_redstone_ore", Feature.ORE, new OreConfiguration(MARS_REDSTONE_ORES, 8));

}