package com.shim.celestialexploration.registry;

import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestialexploration.datagen.ModBlockTags;
import com.shim.celestialexploration.world.features.CelestialOreFeatures;
import com.shim.celestialexploration.world.features.CelestialOrePlacement;
import com.shim.celestialexploration.world.features.GlowingSandFeature;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;

public class FeatureRegistry {


    public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(ForgeRegistries.FEATURES, CelestialExploration.MODID);
    public static final DeferredRegister<PlacedFeature> PLACED_FEATURES = DeferredRegister.create(Registry.PLACED_FEATURE_REGISTRY, CelestialExploration.MODID);

    public static final RegistryObject<Feature<NoneFeatureConfiguration>> GLOWING_SAND = FEATURES.register("glowing_sand", () -> new GlowingSandFeature(NoneFeatureConfiguration.CODEC));

    public static void register(IEventBus eventbus) {
        FEATURES.register(eventbus);
        PLACED_FEATURES.register(eventbus);
    }

    public static final Holder<PlacedFeature> MARS_IRON_ORE_PLACED = PlacementUtils.register("mars_iron_ore_placed",
            CelestialOreFeatures.MARS_IRON_ORE, CelestialOrePlacement.commonOrePlacement(7, // VeinsPerChunk
                    HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-80), VerticalAnchor.aboveBottom(120))));
    public static final Holder<PlacedFeature> MARS_REDSTONE_ORE_PLACED = PlacementUtils.register("mars_redstone_ore_placed",
            CelestialOreFeatures.MARS_IRON_ORE, CelestialOrePlacement.commonOrePlacement(2, // VeinsPerChunk
                    HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-80), VerticalAnchor.aboveBottom(80))));
    public static final Holder<PlacedFeature> MOON_IRON_ORE_PLACED = PlacementUtils.register("moon_iron_ore_placed",
            CelestialOreFeatures.MARS_IRON_ORE, CelestialOrePlacement.commonOrePlacement(4, // VeinsPerChunk
                    HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-80), VerticalAnchor.aboveBottom(90))));
    public static final Holder<PlacedFeature> MOON_REDSTONE_ORE_PLACED = PlacementUtils.register("moon_redstone_ore_placed",
            CelestialOreFeatures.MARS_IRON_ORE, CelestialOrePlacement.commonOrePlacement(2, // VeinsPerChunk
                    HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-80), VerticalAnchor.aboveBottom(80))));


}
