package com.shim.celestialexploration.world.gen;

import com.shim.celestialexploration.registry.CelestialBiomes;
import com.shim.celestialexploration.world.biome.CelestialBiomeKeys;
import com.shim.celestialexploration.world.features.placement.CelestialFeaturePlacements;
import com.shim.celestialexploration.world.features.placement.SurfacePlacements;
import net.minecraft.Util;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.registries.RegistryObject;

import java.util.*;

public class CelestialGeneration {
    static final List<Holder<PlacedFeature>> GEYSERS = new ArrayList<>(List.of(SurfacePlacements.GEYSER));
    static final List<Holder<PlacedFeature>> IO_GEYSERS = new ArrayList<>(List.of(SurfacePlacements.IO_GEYSER));
    static final List<Holder<PlacedFeature>> FROZEN_OCEAN = new ArrayList<>(List.of(SurfacePlacements.FROZEN_OCEAN));
    static final List<Holder<PlacedFeature>> RARE_CRATERS = new ArrayList<>(List.of(SurfacePlacements.UNCOMMON_MEDIUM_CRATER, SurfacePlacements.UNCOMMON_MEDIUM_METEOR, SurfacePlacements.UNCOMMON_LARGE_CRATER, SurfacePlacements.UNCOMMON_LARGE_METEOR));
    static final List<Holder<PlacedFeature>> OCCASIONAL_CRATERS = new ArrayList<>(List.of(SurfacePlacements.UNCOMMON_SMALL_CRATER, SurfacePlacements.UNCOMMON_MEDIUM_CRATER, SurfacePlacements.COMMON_SMALL_METEOR, SurfacePlacements.COMMON_MEDIUM_METEOR, SurfacePlacements.COMMON_LARGE_CRATER, SurfacePlacements.COMMON_LARGE_METEOR));
    static final List<Holder<PlacedFeature>> FREQUENT_CRATERS = new ArrayList<>(List.of(SurfacePlacements.UNCOMMON_SMALL_CRATER, SurfacePlacements.UNCOMMON_MEDIUM_CRATER, SurfacePlacements.UNCOMMON_LARGE_CRATER, SurfacePlacements.COMMON_SMALL_CRATER, SurfacePlacements.COMMON_SMALL_METEOR, SurfacePlacements.COMMON_MEDIUM_CRATER, SurfacePlacements.COMMON_MEDIUM_METEOR, SurfacePlacements.COMMON_LARGE_CRATER, SurfacePlacements.COMMON_LARGE_METEOR));
    static final List<Holder<PlacedFeature>> SLIME_CRATERS = new ArrayList<>(List.of(SurfacePlacements.UNCOMMON_SMALL_SLIME_CRATER, SurfacePlacements.UNCOMMON_MEDIUM_SLIME_CRATER, SurfacePlacements.UNCOMMON_LARGE_SLIME_CRATER));
    static final List<Holder<PlacedFeature>> ICE_CRATERS = new ArrayList<>(List.of(SurfacePlacements.UNCOMMON_SMALL_ICE_CRATER, SurfacePlacements.UNCOMMON_MEDIUM_ICE_CRATER, SurfacePlacements.UNCOMMON_LARGE_ICE_CRATER));

    private static final Map<ResourceLocation, List<Holder<PlacedFeature>>> SURFACE_STRUCTURE_FEATURES = Util.make(new HashMap<>(), (map) -> {
        map.put(CelestialBiomeKeys.MERCURY_CRATERED_PLAINS.location(), FREQUENT_CRATERS);
        map.put(CelestialBiomeKeys.MERCURY_DEEP_CRATERED_PLAINS.location(), FREQUENT_CRATERS);
        map.put(CelestialBiomeKeys.CALLISTO_CRATERED_PLAINS.location(), FREQUENT_CRATERS);

        map.put(CelestialBiomeKeys.MOON_CRATERS.location(), OCCASIONAL_CRATERS);
        map.put(CelestialBiomeKeys.MARS_CRATERS.location(), OCCASIONAL_CRATERS);
        map.put(CelestialBiomeKeys.MARS_DEEP_CRATERS.location(), OCCASIONAL_CRATERS);
        map.put(CelestialBiomeKeys.CALLISTO_LOWER_PLAINS.location(), OCCASIONAL_CRATERS);
        map.put(CelestialBiomeKeys.CALLISTO_PLAINS.location(), OCCASIONAL_CRATERS);
        map.put(CelestialBiomeKeys.MERCURY_PLAINS.location(), OCCASIONAL_CRATERS);
        map.put(CelestialBiomeKeys.GANYMEDE_CRATERED_PLAINS.location(), OCCASIONAL_CRATERS);

        map.put(CelestialBiomeKeys.MOON_PLAINS.location(), RARE_CRATERS);
        map.put(CelestialBiomeKeys.MARS_FLATS.location(), RARE_CRATERS);
        map.put(CelestialBiomeKeys.MERCURY_DESERT.location(), RARE_CRATERS);
        map.put(CelestialBiomeKeys.CALLISTO_DESERT.location(), RARE_CRATERS);
        map.put(CelestialBiomeKeys.GANYMEDE_PLAINS.location(), RARE_CRATERS);
        map.put(CelestialBiomeKeys.GANYMEDE_LOWER_PLAINS.location(), RARE_CRATERS);
        map.put(CelestialBiomeKeys.IO_PLAINS.location(), RARE_CRATERS);
        map.put(CelestialBiomeKeys.IO_LOWER_PLAINS.location(), RARE_CRATERS);

        map.put(CelestialBiomeKeys.MERCURY_CRATERED_PLAINS.location(), SLIME_CRATERS);
        map.put(CelestialBiomeKeys.MERCURY_DEEP_CRATERED_PLAINS.location(), SLIME_CRATERS);

        map.put(CelestialBiomeKeys.MERCURY_PLAINS.location(), SLIME_CRATERS);
        map.put(CelestialBiomeKeys.MERCURY_DESERT.location(), SLIME_CRATERS);

        map.put(CelestialBiomeKeys.CALLISTO_CRATERED_PLAINS.location(), ICE_CRATERS);
        map.put(CelestialBiomeKeys.CALLISTO_LOWER_PLAINS.location(), ICE_CRATERS);
        map.put(CelestialBiomeKeys.CALLISTO_PLAINS.location(), ICE_CRATERS);

        map.put(CelestialBiomeKeys.MILKY_WAY.location(), new ArrayList<>(List.of(SurfacePlacements.ASTEROID)));


    });

    private static final Map<ResourceLocation, List<Holder<PlacedFeature>>> TOP_LAYER_FEATURES = Util.make(new HashMap<>(), (map) -> {
        //VENUS
        map.put(CelestialBiomeKeys.VENUS_DESERT.location(), GEYSERS);
        map.put(CelestialBiomeKeys.VENUS_PLAINS.location(), GEYSERS);
        map.put(CelestialBiomeKeys.VENUS_LOWER_PLAINS.location(), GEYSERS);
        map.put(CelestialBiomeKeys.VENUS_SULFUR_FLATS.location(), GEYSERS);
        //EUROPA
        map.put(CelestialBiomeKeys.EUROPA_JAGGED_PLAINS.location(), new ArrayList<>(List.of(SurfacePlacements.PENITENTE, SurfacePlacements.FROZEN_OCEAN)));
        map.put(CelestialBiomeKeys.EUROPA_PLAINS.location(), new ArrayList<>(List.of(SurfacePlacements.SPARSE_PENITENTE, SurfacePlacements.FROZEN_OCEAN)));
        map.put(CelestialBiomeKeys.EUROPA_OCEAN.location(), FROZEN_OCEAN);
        map.put(CelestialBiomeKeys.EUROPA_RIVER.location(), FROZEN_OCEAN);
        map.put(CelestialBiomeKeys.EUROPA_DESERT.location(), FROZEN_OCEAN);
        map.put(CelestialBiomeKeys.EUROPA_LOWER_PLAINS.location(), FROZEN_OCEAN);
        //IO
        map.put(CelestialBiomeKeys.IO_DESERT.location(), IO_GEYSERS);
        map.put(CelestialBiomeKeys.IO_PLAINS.location(), IO_GEYSERS);
        map.put(CelestialBiomeKeys.IO_LOWER_PLAINS.location(), IO_GEYSERS);
        map.put(CelestialBiomeKeys.IO_SULFUR_FLATS.location(), IO_GEYSERS);
    });

    public static void generateFeatures(final BiomeLoadingEvent event) {
        List<Holder<PlacedFeature>> ores = event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES);

        ores.add(CelestialFeaturePlacements.BAUXITE_ORE);

        ResourceLocation eventName = event.getName();
        if (eventName != null) {
            if (SURFACE_STRUCTURE_FEATURES.containsKey(eventName)) {
                event.getGeneration().getFeatures(GenerationStep.Decoration.SURFACE_STRUCTURES).addAll(SURFACE_STRUCTURE_FEATURES.get(eventName));
            }
            if (TOP_LAYER_FEATURES.containsKey(eventName)) {
                event.getGeneration().getFeatures(GenerationStep.Decoration.TOP_LAYER_MODIFICATION).addAll(TOP_LAYER_FEATURES.get(eventName));
            }

        }
    }
}