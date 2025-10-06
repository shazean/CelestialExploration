package com.shim.celestialexploration.world.features;

import com.shim.celestialexploration.registry.CelestialBlocks;
import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;

import java.util.List;

public class CelestialOreFeatures {

    public static final RuleTest MOON_ORE_REPLACEABLES = new BlockMatchTest(CelestialBlocks.MOON_STONE.get());
    public static final RuleTest MOON_DEEPSLATE_ORE_REPLACEABLES = new BlockMatchTest(CelestialBlocks.MOON_DEEPSLATE.get());
    public static final RuleTest MARS_ORE_REPLACEABLES = new BlockMatchTest(CelestialBlocks.MARS_STONE.get());
    public static final RuleTest MARS_DEEPSLATE_ORE_REPLACEABLES = new BlockMatchTest(CelestialBlocks.MARS_DEEPSLATE.get());
    public static final RuleTest METEOR_REPLACEABLES = new BlockMatchTest(CelestialBlocks.METEOR.get());
    public static final RuleTest VENUS_ORE_REPLACEABLES = new BlockMatchTest(CelestialBlocks.VENUS_STONE.get());
    public static final RuleTest VENUS_DEEPSLATE_ORE_REPLACEABLES = new BlockMatchTest(CelestialBlocks.VENUS_DEEPSLATE.get());
    public static final RuleTest MERCURY_ORE_REPLACEABLES = new BlockMatchTest(CelestialBlocks.MERCURY_STONE.get());
    public static final RuleTest MERCURY_DEEPSLATE_ORE_REPLACEABLES = new BlockMatchTest(CelestialBlocks.MERCURY_DEEPSLATE.get());
    public static final RuleTest IO_ORE_REPLACEABLES = new BlockMatchTest(CelestialBlocks.IO_STONE.get());
    public static final RuleTest IO_DEEPSLATE_ORE_REPLACEABLES = new BlockMatchTest(CelestialBlocks.IO_DEEPSLATE.get());


    public static final List<OreConfiguration.TargetBlockState> MOON_IRON_ORES = List.of(
            OreConfiguration.target(MOON_ORE_REPLACEABLES, CelestialBlocks.MOON_IRON_ORE.get().defaultBlockState()),
            OreConfiguration.target(MOON_DEEPSLATE_ORE_REPLACEABLES, CelestialBlocks.MOON_DEEPSLATE_IRON_ORE.get().defaultBlockState()));

    public static final List<OreConfiguration.TargetBlockState> MOON_REDSTONE_ORES = List.of(
            OreConfiguration.target(MOON_ORE_REPLACEABLES, CelestialBlocks.MOON_REDSTONE_ORE.get().defaultBlockState()),
            OreConfiguration.target(MOON_ORE_REPLACEABLES, CelestialBlocks.MOON_DEEPSLATE_REDSTONE_ORE.get().defaultBlockState()));

    public static final List<OreConfiguration.TargetBlockState> MOON_BAUXITE_ORES = List.of(
            OreConfiguration.target(MOON_ORE_REPLACEABLES, CelestialBlocks.MOON_BAUXITE_ORE.get().defaultBlockState()));


    public static final List<OreConfiguration.TargetBlockState> MARS_IRON_ORES = List.of(
            OreConfiguration.target(MARS_ORE_REPLACEABLES, CelestialBlocks.MARS_IRON_ORE.get().defaultBlockState()),
            OreConfiguration.target(MARS_DEEPSLATE_ORE_REPLACEABLES, CelestialBlocks.MARS_DEEPSLATE_IRON_ORE.get().defaultBlockState()));

    public static final List<OreConfiguration.TargetBlockState> MARS_REDSTONE_ORES = List.of(
            OreConfiguration.target(MARS_ORE_REPLACEABLES, CelestialBlocks.MARS_REDSTONE_ORE.get().defaultBlockState()),
            OreConfiguration.target(MARS_ORE_REPLACEABLES, CelestialBlocks.MARS_DEEPSLATE_REDSTONE_ORE.get().defaultBlockState()));

    public static final List<OreConfiguration.TargetBlockState> VENUS_IRON_ORES = List.of(
            OreConfiguration.target(VENUS_ORE_REPLACEABLES, CelestialBlocks.VENUS_IRON_ORE.get().defaultBlockState()),
            OreConfiguration.target(VENUS_DEEPSLATE_ORE_REPLACEABLES, CelestialBlocks.VENUS_DEEPSLATE_IRON_ORE.get().defaultBlockState()));

    public static final List<OreConfiguration.TargetBlockState> VENUS_REDSTONE_ORES = List.of(
            OreConfiguration.target(VENUS_ORE_REPLACEABLES, CelestialBlocks.VENUS_REDSTONE_ORE.get().defaultBlockState()),
            OreConfiguration.target(VENUS_ORE_REPLACEABLES, CelestialBlocks.VENUS_DEEPSLATE_REDSTONE_ORE.get().defaultBlockState()));

    public static final List<OreConfiguration.TargetBlockState> VENUS_LAPIS_ORES = List.of(
            OreConfiguration.target(VENUS_ORE_REPLACEABLES, CelestialBlocks.VENUS_LAPIS_ORE.get().defaultBlockState()),
            OreConfiguration.target(VENUS_DEEPSLATE_ORE_REPLACEABLES, CelestialBlocks.VENUS_DEEPSLATE_LAPIS_ORE.get().defaultBlockState()));


    public static final List<OreConfiguration.TargetBlockState> MARS_BAUXITE_ORES = List.of(
            OreConfiguration.target(MARS_ORE_REPLACEABLES, CelestialBlocks.MARS_BAUXITE_ORE.get().defaultBlockState()));

    public static final List<OreConfiguration.TargetBlockState> VENUS_BAUXITE_ORES = List.of(
            OreConfiguration.target(VENUS_ORE_REPLACEABLES, CelestialBlocks.VENUS_BAUXITE_ORE.get().defaultBlockState()));

    public static final List<OreConfiguration.TargetBlockState> BAUXITE_ORES = List.of(
            OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, CelestialBlocks.BAUXITE_ORE.get().defaultBlockState()));

    public static final List<OreConfiguration.TargetBlockState> MERCURY_IRON_ORES = List.of(
            OreConfiguration.target(MERCURY_DEEPSLATE_ORE_REPLACEABLES, CelestialBlocks.MERCURY_DEEPSLATE_IRON_ORE.get().defaultBlockState()));

    public static final List<OreConfiguration.TargetBlockState> MERCURY_REDSTONE_ORES = List.of(
            OreConfiguration.target(MERCURY_ORE_REPLACEABLES, CelestialBlocks.MERCURY_DEEPSLATE_REDSTONE_ORE.get().defaultBlockState()));

    public static final List<OreConfiguration.TargetBlockState> MERCURY_BAUXITE_ORES = List.of(
            OreConfiguration.target(MERCURY_ORE_REPLACEABLES, CelestialBlocks.MERCURY_BAUXITE_ORE.get().defaultBlockState()));

    public static final List<OreConfiguration.TargetBlockState> MERCURY_COAL_ORES = List.of(
            OreConfiguration.target(MERCURY_ORE_REPLACEABLES, CelestialBlocks.MERCURY_COAL_ORE.get().defaultBlockState()),
            OreConfiguration.target(MERCURY_DEEPSLATE_ORE_REPLACEABLES, CelestialBlocks.MERCURY_DEEPSLATE_COAL_ORE.get().defaultBlockState()));

    public static final List<OreConfiguration.TargetBlockState> MERCURY_SULFUR_ORES = List.of(
            OreConfiguration.target(MERCURY_ORE_REPLACEABLES, CelestialBlocks.MERCURY_SULFUR_ORE.get().defaultBlockState()));

    public static final List<OreConfiguration.TargetBlockState> MERCURY_DIAMOND_ORES = List.of(
            OreConfiguration.target(MERCURY_ORE_REPLACEABLES, CelestialBlocks.MERCURY_DIAMOND_ORE.get().defaultBlockState()),
            OreConfiguration.target(MERCURY_DEEPSLATE_ORE_REPLACEABLES, CelestialBlocks.MERCURY_DEEPSLATE_DIAMOND_ORE.get().defaultBlockState()));


    public static final List<OreConfiguration.TargetBlockState> IO_IRON_ORES = List.of(
            OreConfiguration.target(IO_DEEPSLATE_ORE_REPLACEABLES, CelestialBlocks.IO_DEEPSLATE_IRON_ORE.get().defaultBlockState()));

    public static final List<OreConfiguration.TargetBlockState> IO_LAPIS_ORES = List.of(
            OreConfiguration.target(IO_ORE_REPLACEABLES, CelestialBlocks.IO_LAPIS_ORE.get().defaultBlockState()),
            OreConfiguration.target(IO_ORE_REPLACEABLES, CelestialBlocks.IO_DEEPSLATE_LAPIS_ORE.get().defaultBlockState()));

    public static final List<OreConfiguration.TargetBlockState> IO_SULFUR_ORES = List.of(
            OreConfiguration.target(IO_ORE_REPLACEABLES, CelestialBlocks.IO_SULFUR_ORE.get().defaultBlockState()));



    public static final Holder<ConfiguredFeature<OreConfiguration, ?>> MOON_IRON_ORE = FeatureUtils.register("moon_iron_ore", Feature.ORE, new OreConfiguration(MOON_IRON_ORES, 7));
    public static final Holder<ConfiguredFeature<OreConfiguration, ?>> MOON_IRON_ORE_SMALL = FeatureUtils.register("moon_iron_ore_small", Feature.ORE, new OreConfiguration(MOON_IRON_ORES, 4));
    public static final Holder<ConfiguredFeature<OreConfiguration, ?>> MOON_REDSTONE_ORE = FeatureUtils.register("moon_redstone_ore", Feature.ORE, new OreConfiguration(MOON_REDSTONE_ORES, 8));
    public static final Holder<ConfiguredFeature<OreConfiguration, ?>> MOON_BAUXITE_ORE = FeatureUtils.register("moon_bauxite_ore", Feature.ORE, new OreConfiguration(MOON_BAUXITE_ORES, 8));

    public static final Holder<ConfiguredFeature<OreConfiguration, ?>> MARS_IRON_ORE = FeatureUtils.register("mars_iron_ore", Feature.ORE, new OreConfiguration(MARS_IRON_ORES, 12));
    public static final Holder<ConfiguredFeature<OreConfiguration, ?>> MARS_IRON_ORE_SMALL = FeatureUtils.register("mars_iron_ore_small", Feature.ORE, new OreConfiguration(MARS_IRON_ORES, 4));
    public static final Holder<ConfiguredFeature<OreConfiguration, ?>> MARS_REDSTONE_ORE = FeatureUtils.register("mars_redstone_ore", Feature.ORE, new OreConfiguration(MARS_REDSTONE_ORES, 8));
    public static final Holder<ConfiguredFeature<OreConfiguration, ?>> MARS_BAUXITE_ORE = FeatureUtils.register("mars_bauxite_ore", Feature.ORE, new OreConfiguration(MARS_BAUXITE_ORES, 8));

    public static final Holder<ConfiguredFeature<OreConfiguration, ?>> VENUS_IRON_ORE = FeatureUtils.register("venus_iron_ore", Feature.ORE, new OreConfiguration(VENUS_IRON_ORES, 7));
    public static final Holder<ConfiguredFeature<OreConfiguration, ?>> VENUS_IRON_ORE_SMALL = FeatureUtils.register("venus_iron_ore_small", Feature.ORE, new OreConfiguration(VENUS_IRON_ORES, 4));
    public static final Holder<ConfiguredFeature<OreConfiguration, ?>> VENUS_REDSTONE_ORE = FeatureUtils.register("venus_redstone_ore", Feature.ORE, new OreConfiguration(VENUS_REDSTONE_ORES, 8));
    public static final Holder<ConfiguredFeature<OreConfiguration, ?>> VENUS_LAPIS_ORE = FeatureUtils.register("venus_lapis_ore", Feature.ORE, new OreConfiguration(VENUS_LAPIS_ORES, 7));
    public static final Holder<ConfiguredFeature<OreConfiguration, ?>> VENUS_LAPIS_ORE_BURIED = FeatureUtils.register("venus_lapis_ore_buried", Feature.ORE, new OreConfiguration(VENUS_LAPIS_ORES, 7, 1.0F));

    public static final Holder<ConfiguredFeature<OreConfiguration, ?>> VENUS_BAUXITE_ORE = FeatureUtils.register("venus_bauxite_ore", Feature.ORE, new OreConfiguration(VENUS_BAUXITE_ORES, 8));

    public static final Holder<ConfiguredFeature<OreConfiguration, ?>> MERCURY_IRON_ORE = FeatureUtils.register("mercury_iron_ore", Feature.ORE, new OreConfiguration(MERCURY_IRON_ORES, 8));
    public static final Holder<ConfiguredFeature<OreConfiguration, ?>> MERCURY_IRON_ORE_SMALL = FeatureUtils.register("mercury_iron_ore_small", Feature.ORE, new OreConfiguration(MERCURY_IRON_ORES, 5));
    public static final Holder<ConfiguredFeature<OreConfiguration, ?>> MERCURY_REDSTONE_ORE = FeatureUtils.register("mercury_redstone_ore", Feature.ORE, new OreConfiguration(MERCURY_REDSTONE_ORES, 9));
    public static final Holder<ConfiguredFeature<OreConfiguration, ?>> MERCURY_SULFUR_ORE = FeatureUtils.register("mercury_sulfur_ore", Feature.ORE, new OreConfiguration(MERCURY_SULFUR_ORES, 4));
    public static final Holder<ConfiguredFeature<OreConfiguration, ?>> MERCURY_BAUXITE_ORE = FeatureUtils.register("mercury_bauxite_ore", Feature.ORE, new OreConfiguration(MERCURY_BAUXITE_ORES, 6));
    public static final Holder<ConfiguredFeature<OreConfiguration, ?>> MERCURY_COAL_ORE = FeatureUtils.register("mercury_coal_ore", Feature.ORE, new OreConfiguration(MERCURY_COAL_ORES, 18));
    public static final Holder<ConfiguredFeature<OreConfiguration, ?>> MERCURY_COAL_ORE_LOWER = FeatureUtils.register("mercury_coal_ore_lower", Feature.ORE, new OreConfiguration(MERCURY_COAL_ORES, 18, 0.5F));
    public static final Holder<ConfiguredFeature<OreConfiguration, ?>> MERCURY_DIAMOND_ORE = FeatureUtils.register("mercury_diamond_ore", Feature.ORE, new OreConfiguration(MERCURY_DIAMOND_ORES, 9, 0.5F));

    public static final Holder<ConfiguredFeature<OreConfiguration, ?>> BAUXITE_ORE = FeatureUtils.register("bauxite_ore", Feature.ORE, new OreConfiguration(BAUXITE_ORES, 17));

    public static final Holder<ConfiguredFeature<OreConfiguration, ?>> IO_IRON_ORE = FeatureUtils.register("io_iron_ore", Feature.ORE, new OreConfiguration(IO_IRON_ORES, 7));
    public static final Holder<ConfiguredFeature<OreConfiguration, ?>> IO_IRON_ORE_SMALL = FeatureUtils.register("io_iron_ore_small", Feature.ORE, new OreConfiguration(IO_IRON_ORES, 4));
    public static final Holder<ConfiguredFeature<OreConfiguration, ?>> IO_LAPIS_ORE = FeatureUtils.register("io_lapis_ore", Feature.ORE, new OreConfiguration(IO_LAPIS_ORES, 7));
    public static final Holder<ConfiguredFeature<OreConfiguration, ?>> IO_LAPIS_ORE_BURIED = FeatureUtils.register("io_lapis_ore_buried", Feature.ORE, new OreConfiguration(IO_LAPIS_ORES, 7, 1.0F));
    public static final Holder<ConfiguredFeature<OreConfiguration, ?>> IO_SULFUR_ORE = FeatureUtils.register("io_sulfur_ore", Feature.ORE, new OreConfiguration(IO_SULFUR_ORES, 4));



}