package com.shim.celestialexploration.world.gen;

import com.shim.celestialexploration.registry.BiomeRegistry;
import com.shim.celestialexploration.registry.TagRegistry;
import com.shim.celestialexploration.world.features.placement.CelestialFeaturePlacements;
import com.shim.celestialexploration.world.features.placement.SurfacePlacements;
import it.unimi.dsi.fastutil.objects.Object2ObjectArrayMap;
import net.minecraft.Util;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.registries.RegistryObject;

import java.util.ArrayList;
import java.util.List;

public class CelestialGeneration {
    public static void generateFeatures(final BiomeLoadingEvent event) {
        List<Holder<PlacedFeature>> surface = event.getGeneration().getFeatures(GenerationStep.Decoration.SURFACE_STRUCTURES);

        List<Holder<PlacedFeature>> ores = event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES);

        ores.add(CelestialFeaturePlacements.BAUXITE_ORE);

        List<Holder<PlacedFeature>> topLayer = event.getGeneration().getFeatures(GenerationStep.Decoration.TOP_LAYER_MODIFICATION);

        topLayer.add(SurfacePlacements.GEYSER);

        ResourceLocation eventName = event.getName();
        if (eventName != null) {

            generateInBiome(BiomeRegistry.EUROPA_JAGGED_PLAINS, eventName, topLayer, SurfacePlacements.PENITENTE);
            generateInBiome(BiomeRegistry.EUROPA_PLAINS, eventName, topLayer, SurfacePlacements.SPARSE_PENITENTE);
            generateInBiome(BiomeRegistry.EUROPA_OCEAN, eventName, topLayer, SurfacePlacements.FROZEN_OCEAN);

            generateInBiome(BiomeRegistry.EUROPA_RIVER, eventName, topLayer, SurfacePlacements.FROZEN_OCEAN);
            generateInBiome(BiomeRegistry.EUROPA_DESERT, eventName, topLayer, SurfacePlacements.FROZEN_OCEAN);
            generateInBiome(BiomeRegistry.EUROPA_JAGGED_PLAINS, eventName, topLayer, SurfacePlacements.FROZEN_OCEAN);
            generateInBiome(BiomeRegistry.EUROPA_PLAINS, eventName, topLayer, SurfacePlacements.FROZEN_OCEAN);
            generateInBiome(BiomeRegistry.EUROPA_LOWER_PLAINS, eventName, topLayer, SurfacePlacements.FROZEN_OCEAN);
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