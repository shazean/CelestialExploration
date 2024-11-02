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


        Holder<Biome> biomes = BiomeRegistry.JUPITER_ETHER.getHolder().get();
        if (event.getName() != null) {

            TagKey<Biome> biomeTag = TagRegistry.Biomes.JUPITER_BIOMES;


            if (biomes.is(event.getName())) {
//                surface.add(SurfacePlacements.JUPITER_CLOUD);

            }
        }

        List<Holder<PlacedFeature>> ores = event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES);

        ores.add(CelestialFeaturePlacements.BAUXITE_ORE);


        List<Holder<PlacedFeature>> topLayer = event.getGeneration().getFeatures(GenerationStep.Decoration.TOP_LAYER_MODIFICATION);

        topLayer.add(SurfacePlacements.GEYSER);

    }
}