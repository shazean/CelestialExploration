package com.shim.celestialexploration.world.features;

import com.shim.celestialexploration.registry.BlockRegistry;
import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.OreFeature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

import java.util.List;

public class CelestialOreFeatures {

    public static final RuleTest MOON_ORE_REPLACEABLES = new TagMatchTest(BlockRegistry.MOON_STONE_TAG);
    public static final RuleTest MOON_DEEPSLATE_ORE_REPLACEABLES = new TagMatchTest(BlockRegistry.MOON_DEEPSLATE_TAG);
    public static final RuleTest MARS_ORE_REPLACEABLES = new TagMatchTest(BlockRegistry.MARS_STONE_TAG);
    public static final RuleTest MARS_DEEPSLATE_ORE_REPLACEABLES = new TagMatchTest(BlockRegistry.MARS_DEEPSLATE_TAG);
    public static final RuleTest METEOR_REPLACEABLES = new BlockMatchTest(BlockRegistry.METEOR.get());
    public static final RuleTest VENUS_ORE_REPLACEABLES = new TagMatchTest(BlockRegistry.VENUS_STONE_TAG);
    public static final RuleTest VENUS_DEEPSLATE_ORE_REPLACEABLES = new TagMatchTest(BlockRegistry.VENUS_DEEPSLATE_TAG);


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

    public static final List<OreConfiguration.TargetBlockState> VENUS_IRON_ORES = List.of(
            OreConfiguration.target(VENUS_ORE_REPLACEABLES, BlockRegistry.VENUS_IRON_ORE.get().defaultBlockState()),
            OreConfiguration.target(VENUS_DEEPSLATE_ORE_REPLACEABLES, BlockRegistry.VENUS_DEEPSLATE_IRON_ORE.get().defaultBlockState()));

    public static final List<OreConfiguration.TargetBlockState> VENUS_REDSTONE_ORES = List.of(
            OreConfiguration.target(VENUS_ORE_REPLACEABLES, BlockRegistry.VENUS_REDSTONE_ORE.get().defaultBlockState()),
            OreConfiguration.target(VENUS_ORE_REPLACEABLES, BlockRegistry.VENUS_DEEPSLATE_REDSTONE_ORE.get().defaultBlockState()));

    public static final List<OreConfiguration.TargetBlockState> VENUS_LAPIS_ORES = List.of(
            OreConfiguration.target(VENUS_ORE_REPLACEABLES, BlockRegistry.VENUS_LAPIS_ORE.get().defaultBlockState()),
            OreConfiguration.target(VENUS_DEEPSLATE_ORE_REPLACEABLES, BlockRegistry.VENUS_DEEPSLATE_LAPIS_ORE.get().defaultBlockState()));


    public static final List<OreConfiguration.TargetBlockState> MOON_BAUXITE_ORES = List.of(
            OreConfiguration.target(MOON_ORE_REPLACEABLES, BlockRegistry.MOON_BAUXITE_ORE.get().defaultBlockState()));

    public static final List<OreConfiguration.TargetBlockState> MARS_BAUXITE_ORES = List.of(
            OreConfiguration.target(MARS_ORE_REPLACEABLES, BlockRegistry.MARS_BAUXITE_ORE.get().defaultBlockState()));

    public static final List<OreConfiguration.TargetBlockState> VENUS_BAUXITE_ORES = List.of(
            OreConfiguration.target(VENUS_ORE_REPLACEABLES, BlockRegistry.VENUS_BAUXITE_ORE.get().defaultBlockState()));

    public static final List<OreConfiguration.TargetBlockState> BAUXITE_ORES = List.of(
            OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, BlockRegistry.BAUXITE_ORE.get().defaultBlockState()));


//    public static final List<OreConfiguration.TargetBlockState> METEOR_COAL_ORES = List.of(OreConfiguration.target(METEOR_REPLACEABLES, BlockRegistry.METEOR_COAL_ORE.get().defaultBlockState()));
//    public static final List<OreConfiguration.TargetBlockState> METEOR_COPPER_ORES = List.of(OreConfiguration.target(METEOR_REPLACEABLES, BlockRegistry.METEOR_COPPER_ORE.get().defaultBlockState()));
//    public static final List<OreConfiguration.TargetBlockState> METEOR_DIAMOND_ORES = List.of(OreConfiguration.target(METEOR_REPLACEABLES, BlockRegistry.METEOR_DIAMOND_ORE.get().defaultBlockState()));
//    public static final List<OreConfiguration.TargetBlockState> METEOR_EMERALD_ORES = List.of(OreConfiguration.target(METEOR_REPLACEABLES, BlockRegistry.METEOR_EMERALD_ORE.get().defaultBlockState()));
//    public static final List<OreConfiguration.TargetBlockState> METEOR_GOLD_ORES = List.of(OreConfiguration.target(METEOR_REPLACEABLES, BlockRegistry.METEOR_GOLD_ORE.get().defaultBlockState()));
//    public static final List<OreConfiguration.TargetBlockState> METEOR_IRON_ORES = List.of(OreConfiguration.target(METEOR_REPLACEABLES, BlockRegistry.METEOR_IRON_ORE.get().defaultBlockState()));
//    public static final List<OreConfiguration.TargetBlockState> METEOR_LAPIS_ORES = List.of(OreConfiguration.target(METEOR_REPLACEABLES, BlockRegistry.METEOR_LAPIS_ORE.get().defaultBlockState()));
//    public static final List<OreConfiguration.TargetBlockState> METEOR_REDSTONE_ORES = List.of(OreConfiguration.target(METEOR_REPLACEABLES, BlockRegistry.METEOR_REDSTONE_ORE.get().defaultBlockState()));

    public static final Holder<ConfiguredFeature<OreConfiguration, ?>> MOON_IRON_ORE = FeatureUtils.register("moon_iron_ore", Feature.ORE, new OreConfiguration(MOON_IRON_ORES, 7));
    public static final Holder<ConfiguredFeature<OreConfiguration, ?>> MOON_REDSTONE_ORE = FeatureUtils.register("moon_redstone_ore", Feature.ORE, new OreConfiguration(MOON_REDSTONE_ORES, 5));
    public static final Holder<ConfiguredFeature<OreConfiguration, ?>> MOON_BAUXITE_ORE = FeatureUtils.register("moon_bauxite_ore", Feature.ORE, new OreConfiguration(MOON_BAUXITE_ORES, 8));

    public static final Holder<ConfiguredFeature<OreConfiguration, ?>> MARS_IRON_ORE = FeatureUtils.register("mars_iron_ore", Feature.ORE, new OreConfiguration(MARS_IRON_ORES, 10));
    public static final Holder<ConfiguredFeature<OreConfiguration, ?>> MARS_REDSTONE_ORE = FeatureUtils.register("mars_redstone_ore", Feature.ORE, new OreConfiguration(MARS_REDSTONE_ORES, 5));
    public static final Holder<ConfiguredFeature<OreConfiguration, ?>> MARS_BAUXITE_ORE = FeatureUtils.register("mars_bauxite_ore", Feature.ORE, new OreConfiguration(MARS_BAUXITE_ORES, 8));

    public static final Holder<ConfiguredFeature<OreConfiguration, ?>> VENUS_IRON_ORE = FeatureUtils.register("venus_iron_ore", Feature.ORE, new OreConfiguration(VENUS_IRON_ORES, 3));
    public static final Holder<ConfiguredFeature<OreConfiguration, ?>> VENUS_REDSTONE_ORE = FeatureUtils.register("venus_redstone_ore", Feature.ORE, new OreConfiguration(VENUS_REDSTONE_ORES, 3));
    public static final Holder<ConfiguredFeature<OreConfiguration, ?>> VENUS_LAPIS_ORE = FeatureUtils.register("venus_lapis_ore", Feature.ORE, new OreConfiguration(VENUS_LAPIS_ORES, 4));
    public static final Holder<ConfiguredFeature<OreConfiguration, ?>> VENUS_BAUXITE_ORE = FeatureUtils.register("venus_bauxite_ore", Feature.ORE, new OreConfiguration(VENUS_BAUXITE_ORES, 8));

    public static final Holder<ConfiguredFeature<OreConfiguration, ?>> BAUXITE_ORE = FeatureUtils.register("bauxite_ore", Feature.ORE, new OreConfiguration(BAUXITE_ORES, 13));

//    public static final Holder<ConfiguredFeature<OreConfiguration, ?>> METEOR_COAL_ORE = FeatureUtils.register("meteor_coal_ore", Feature.ORE, new OreConfiguration(METEOR_COAL_ORES, 10));
//    public static final Holder<ConfiguredFeature<OreConfiguration, ?>> METEOR_COPPER_ORE = FeatureUtils.register("meteor_copper_ore", Feature.ORE, new OreConfiguration(METEOR_COPPER_ORES, 7));
//    public static final Holder<ConfiguredFeature<OreConfiguration, ?>> METEOR_DIAMOND_ORE = FeatureUtils.register("meteor_diamond_ore", Feature.ORE, new OreConfiguration(METEOR_DIAMOND_ORES, 2));
//    public static final Holder<ConfiguredFeature<OreConfiguration, ?>> METEOR_EMERALD_ORE = FeatureUtils.register("meteor_emerald_ore", Feature.ORE, new OreConfiguration(METEOR_EMERALD_ORES, 2));
//    public static final Holder<ConfiguredFeature<OreConfiguration, ?>> METEOR_GOLD_ORE = FeatureUtils.register("meteor_gold_ore", Feature.ORE, new OreConfiguration(METEOR_GOLD_ORES, 3));
//    public static final Holder<ConfiguredFeature<OreConfiguration, ?>> METEOR_IRON_ORE = FeatureUtils.register("meteor_iron_ore", Feature.ORE, new OreConfiguration(METEOR_IRON_ORES, 7));
//    public static final Holder<ConfiguredFeature<OreConfiguration, ?>> METEOR_LAPIS_ORE = FeatureUtils.register("meteor_lapis_ore", Feature.ORE, new OreConfiguration(METEOR_LAPIS_ORES, 5));
//    public static final Holder<ConfiguredFeature<OreConfiguration, ?>> METEOR_REDSTONE_ORE = FeatureUtils.register("meteor_redstone_ore", Feature.ORE, new OreConfiguration(METEOR_REDSTONE_ORES, 5));


}