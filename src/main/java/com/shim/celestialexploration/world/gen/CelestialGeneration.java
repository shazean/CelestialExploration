package com.shim.celestialexploration.world.gen;

import com.shim.celestialexploration.registry.BiomeRegistry;
import com.shim.celestialexploration.registry.TagRegistry;
import com.shim.celestialexploration.world.features.placement.CelestialFeaturePlacements;
import com.shim.celestialexploration.world.features.placement.SurfacePlacements;
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

import java.util.List;

public class CelestialGeneration {
    public static void generateFeatures(final BiomeLoadingEvent event) {
        List<Holder<PlacedFeature>> surface = event.getGeneration().getFeatures(GenerationStep.Decoration.SURFACE_STRUCTURES);

//        Holder<Biome> biomes = BiomeRegistry.JUPITER_ETHER.getHolder().get();
//        if (event.getName() != null) {
//            TagKey<Biome> biomeTag = TagRegistry.Biomes.JUPITER_BIOMES;
//            if (biomes.is(event.getName())) {
//                surface.add(SurfacePlacements.JUPITER_CLOUD);
//            }
//        }

        List<Holder<PlacedFeature>> ores = event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES);

        ores.add(CelestialFeaturePlacements.BAUXITE_ORE);


        List<Holder<PlacedFeature>> topLayer = event.getGeneration().getFeatures(GenerationStep.Decoration.TOP_LAYER_MODIFICATION);

        topLayer.add(SurfacePlacements.GEYSER);

        Holder<Biome> europaBiome = BiomeRegistry.EUROPA_JAGGED_PLAINS.getHolder().get();
        if (event.getName() != null) {
            if (europaBiome.is(event.getName())) {
//                topLayer.add(SurfacePlacements.HYDRATE);
                topLayer.add(SurfacePlacements.PENITENTE);
            }
        }
        europaBiome = BiomeRegistry.EUROPA_PLAINS.getHolder().get();
        if (event.getName() != null) {
            if (europaBiome.is(event.getName())) {
                topLayer.add(SurfacePlacements.SPARSE_PENITENTE);
            }
        }
        europaBiome = BiomeRegistry.EUROPA_OCEAN.getHolder().get();
        if (event.getName() != null) {
            if (europaBiome.is(event.getName())) {
                topLayer.add(SurfacePlacements.FROZEN_OCEAN);
            }
        }
        europaBiome = BiomeRegistry.EUROPA_RIVER.getHolder().get();
        if (event.getName() != null) {
            if (europaBiome.is(event.getName())) {
                topLayer.add(SurfacePlacements.FROZEN_OCEAN);
            }
        }
    }
}