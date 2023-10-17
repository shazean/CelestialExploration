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
            CelestialOreFeatures.MOON_IRON_ORE, CelestialOrePlacement.commonOrePlacement(8, // VeinsPerChunk
                    HeightRangePlacement.triangle(VerticalAnchor.absolute(-64), VerticalAnchor.belowTop(128))));

    public static final Holder<PlacedFeature> MOON_REDSTONE_ORE_PLACED = PlacementUtils.register("moon_redstone_ore_placed",
            CelestialOreFeatures.MOON_REDSTONE_ORE, CelestialOrePlacement.commonOrePlacement(6, // VeinsPerChunk
                    HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-64), VerticalAnchor.belowTop(64))));

    public static final Holder<PlacedFeature> MARS_IRON_ORE_PLACED = PlacementUtils.register("mars_iron_ore_placed",
            CelestialOreFeatures.MARS_IRON_ORE, CelestialOrePlacement.commonOrePlacement(10, // VeinsPerChunk
                    HeightRangePlacement.triangle(VerticalAnchor.absolute(-64), VerticalAnchor.belowTop(128))));

    public static final Holder<PlacedFeature> MARS_REDSTONE_ORE_PLACED = PlacementUtils.register("mars_redstone_ore_placed",
            CelestialOreFeatures.MARS_REDSTONE_ORE, CelestialOrePlacement.commonOrePlacement(6, // VeinsPerChunk
                    HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-64), VerticalAnchor.belowTop(64))));

}
