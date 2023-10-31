package com.shim.celestialexploration.registry;

import com.shim.celestialexploration.world.features.CelestialOreFeatures;
import com.shim.celestialexploration.world.features.CelestialOrePlacement;
import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

public class PlacedFeatureRegistry {

    public static final Holder<PlacedFeature> MOON_IRON_ORE_PLACED = PlacementUtils.register("moon_iron_ore_placed",
            CelestialOreFeatures.MOON_IRON_ORE, CelestialOrePlacement.commonOrePlacement(6, // VeinsPerChunk
                    HeightRangePlacement.triangle(VerticalAnchor.absolute(-64), VerticalAnchor.belowTop(112))));

    public static final Holder<PlacedFeature> MOON_REDSTONE_ORE_PLACED = PlacementUtils.register("moon_redstone_ore_placed",
            CelestialOreFeatures.MOON_REDSTONE_ORE, CelestialOrePlacement.commonOrePlacement(4, // VeinsPerChunk
                    HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-64), VerticalAnchor.belowTop(64))));

    public static final Holder<PlacedFeature> MARS_IRON_ORE_PLACED = PlacementUtils.register("mars_iron_ore_placed",
            CelestialOreFeatures.MARS_IRON_ORE, CelestialOrePlacement.commonOrePlacement(8, // VeinsPerChunk
                    HeightRangePlacement.triangle(VerticalAnchor.absolute(-64), VerticalAnchor.belowTop(112))));

    public static final Holder<PlacedFeature> MARS_REDSTONE_ORE_PLACED = PlacementUtils.register("mars_redstone_ore_placed",
            CelestialOreFeatures.MARS_REDSTONE_ORE, CelestialOrePlacement.commonOrePlacement(4, // VeinsPerChunk
                    HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-64), VerticalAnchor.belowTop(64))));

    public static final Holder<PlacedFeature> METEOR_COAL_ORE_PLACED = PlacementUtils.register("meteor_coal_ore_placed",
            CelestialOreFeatures.METEOR_COAL_ORE, CelestialOrePlacement.commonOrePlacement(7, // VeinsPerChunk
                    HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-64), VerticalAnchor.belowTop(112))));

    public static final Holder<PlacedFeature> METEOR_COPPER_ORE_PLACED = PlacementUtils.register("meteor_copper_ore_placed",
            CelestialOreFeatures.METEOR_COPPER_ORE, CelestialOrePlacement.commonOrePlacement(3, // VeinsPerChunk
                    HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-64), VerticalAnchor.belowTop(112))));

    public static final Holder<PlacedFeature> METEOR_DIAMOND_ORE_PLACED = PlacementUtils.register("meteor_diamond_ore_placed",
            CelestialOreFeatures.METEOR_DIAMOND_ORE, CelestialOrePlacement.rareOrePlacement(2, // VeinsPerChunk
                    HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-96), VerticalAnchor.belowTop(32))));

    public static final Holder<PlacedFeature> METEOR_EMERALD_ORE_PLACED = PlacementUtils.register("meteor_emerald_ore_placed",
            CelestialOreFeatures.METEOR_EMERALD_ORE, CelestialOrePlacement.rareOrePlacement(1, // VeinsPerChunk
                    HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-64), VerticalAnchor.belowTop(32))));

    public static final Holder<PlacedFeature> METEOR_GOLD_ORE_PLACED = PlacementUtils.register("meteor_gold_ore_placed",
            CelestialOreFeatures.METEOR_GOLD_ORE, CelestialOrePlacement.rareOrePlacement(2, // VeinsPerChunk
                    HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-32), VerticalAnchor.belowTop(64))));

    public static final Holder<PlacedFeature> METEOR_IRON_ORE_PLACED = PlacementUtils.register("meteor_iron_ore_placed",
            CelestialOreFeatures.METEOR_IRON_ORE, CelestialOrePlacement.commonOrePlacement(5, // VeinsPerChunk
                    HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-64), VerticalAnchor.belowTop(112))));

    public static final Holder<PlacedFeature> METEOR_LAPIS_ORE_PLACED = PlacementUtils.register("meteor_lapis_ore_placed",
            CelestialOreFeatures.METEOR_LAPIS_ORE, CelestialOrePlacement.rareOrePlacement(2, // VeinsPerChunk
                    HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-32), VerticalAnchor.belowTop(96))));

    public static final Holder<PlacedFeature> METEOR_REDSTONE_ORE_PLACED = PlacementUtils.register("meteor_redstone_ore_placed",
            CelestialOreFeatures.METEOR_REDSTONE_ORE, CelestialOrePlacement.commonOrePlacement(3, // VeinsPerChunk
                    HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-32), VerticalAnchor.belowTop(96))));


}
