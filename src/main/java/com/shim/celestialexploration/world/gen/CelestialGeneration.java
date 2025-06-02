package com.shim.celestialexploration.world.gen;

import com.shim.celestialexploration.registry.CelestialBiomes;
import com.shim.celestialexploration.world.features.placement.CelestialFeaturePlacements;
import com.shim.celestialexploration.world.features.placement.SurfacePlacements;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;

public class CelestialGeneration {
    public static void generateFeatures(final BiomeLoadingEvent event) {
        List<Holder<PlacedFeature>> surface = event.getGeneration().getFeatures(GenerationStep.Decoration.SURFACE_STRUCTURES);

        List<Holder<PlacedFeature>> ores = event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES);

        ores.add(CelestialFeaturePlacements.BAUXITE_ORE);

        List<Holder<PlacedFeature>> topLayer = event.getGeneration().getFeatures(GenerationStep.Decoration.TOP_LAYER_MODIFICATION);

        topLayer.add(SurfacePlacements.GEYSER);
        topLayer.add(SurfacePlacements.IO_GEYSER);

        ResourceLocation eventName = event.getName();
        if (eventName != null) {

            generateInBiome(CelestialBiomes.EUROPA_JAGGED_PLAINS, eventName, topLayer, SurfacePlacements.PENITENTE);
            generateInBiome(CelestialBiomes.EUROPA_PLAINS, eventName, topLayer, SurfacePlacements.SPARSE_PENITENTE);

            generateInBiome(CelestialBiomes.EUROPA_OCEAN, eventName, topLayer, SurfacePlacements.FROZEN_OCEAN);
            generateInBiome(CelestialBiomes.EUROPA_RIVER, eventName, topLayer, SurfacePlacements.FROZEN_OCEAN);
            generateInBiome(CelestialBiomes.EUROPA_DESERT, eventName, topLayer, SurfacePlacements.FROZEN_OCEAN);
            generateInBiome(CelestialBiomes.EUROPA_JAGGED_PLAINS, eventName, topLayer, SurfacePlacements.FROZEN_OCEAN);
            generateInBiome(CelestialBiomes.EUROPA_PLAINS, eventName, topLayer, SurfacePlacements.FROZEN_OCEAN);
            generateInBiome(CelestialBiomes.EUROPA_LOWER_PLAINS, eventName, topLayer, SurfacePlacements.FROZEN_OCEAN);
        }
    }

    protected static void generateInBiome(RegistryObject<Biome> biome, ResourceLocation eventName, List<Holder<PlacedFeature>> featureGen, Holder<PlacedFeature> feature) {
        if (biome.getHolder().isPresent()) {
            if (biome.getHolder().get().is(eventName)) {
                featureGen.add(feature);
            }
        }
    }
}