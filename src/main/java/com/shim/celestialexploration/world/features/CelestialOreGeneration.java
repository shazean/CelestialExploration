package com.shim.celestialexploration.world.features;

import com.shim.celestialexploration.registry.PlacedFeatureRegistry;
import net.minecraft.core.Holder;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.event.world.BiomeLoadingEvent;

import java.util.List;

public class CelestialOreGeneration {
    public static void generateOres(final BiomeLoadingEvent event) {
        List<Holder<PlacedFeature>> base =
                event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES);

        base.add(PlacedFeatureRegistry.MARS_IRON_ORE_PLACED);
        base.add(PlacedFeatureRegistry.MARS_REDSTONE_ORE_PLACED);
        base.add(PlacedFeatureRegistry.MOON_IRON_ORE_PLACED);
        base.add(PlacedFeatureRegistry.MOON_REDSTONE_ORE_PLACED);
    }
}