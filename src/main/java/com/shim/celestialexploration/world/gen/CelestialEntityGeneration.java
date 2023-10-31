package com.shim.celestialexploration.world.gen;

import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestialexploration.registry.BiomeRegistry;
import com.shim.celestialexploration.registry.EntityRegistry;
import com.shim.celestialexploration.world.CelestialBiomes;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.event.world.BiomeLoadingEvent;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class CelestialEntityGeneration {

    public static void onEntitySpawn(final BiomeLoadingEvent event) {
        addEntityToMoonBiomes(event, EntityRegistry.LURKER.get(), 100, 1, 1);
        addEntityToMoonBiomes(event, EntityRegistry.LUNAR_SLIME.get(), 80, 0, 2);
        addEntityToMarsBiomes(event, EntityRegistry.MARS_MALLOW.get(), 30, 0, 2);
        addEntityToMarsBiomes(event, EntityRegistry.RUST_SLIME.get(), 80, 0, 2);
        addEntityToMarsBiomes(event, EntityRegistry.LURKER.get(), 100, 1, 1);
        addEntityToSpaceBiomes(event, EntityRegistry.LURKER.get(), 100, 1, 1);
    }


    private static void addEntityToMarsBiomes(BiomeLoadingEvent event, EntityType<?> type, int weight, int minCount, int maxCount) {
        boolean isBiomeSelected = event.getName().toString().equals(CelestialExploration.MODID + ":mars_craters") ||
                event.getName().toString().equals(CelestialExploration.MODID + ":mars_flats") ||
                event.getName().toString().equals(CelestialExploration.MODID + ":mars_dunes") ||
                event.getName().toString().equals(CelestialExploration.MODID + ":mars_eroded_flats") ||
                event.getName().toString().equals(CelestialExploration.MODID + ":mars_desert") ||
                event.getName().toString().equals(CelestialExploration.MODID + ":mars_dry_ice_peaks") ||
                event.getName().toString().equals(CelestialExploration.MODID + ":mars_dry_ice_flats") ||
                event.getName().toString().equals(CelestialExploration.MODID + ":mars_deep_craters");
        if (isBiomeSelected) {
            addEntityToAllBiomes(event, type, weight, minCount, maxCount);
        }
    }

    private static void addEntityToMoonBiomes(BiomeLoadingEvent event, EntityType<?> type, int weight, int minCount, int maxCount) {
        boolean isBiomeSelected = event.getName().toString().equals(CelestialExploration.MODID + ":moon_craters") ||
                event.getName().toString().equals(CelestialExploration.MODID + ":moon_desert") ||
                event.getName().toString().equals(CelestialExploration.MODID + ":moon_lava_flats") ||
                event.getName().toString().equals(CelestialExploration.MODID + ":moon_lower_plains") ||
                event.getName().toString().equals(CelestialExploration.MODID + ":moon_plains");
        if (isBiomeSelected) {
            addEntityToAllBiomes(event, type, weight, minCount, maxCount);
        }
    }

    private static void addEntityToSpaceBiomes(BiomeLoadingEvent event, EntityType<?> type, int weight, int minCount, int maxCount) {
        boolean isBiomeSelected = event.getName().toString().equals(CelestialExploration.MODID + ":asteroid_field") ||
                event.getName().toString().equals(CelestialExploration.MODID + ":large_asteroid") ||
                event.getName().toString().equals(CelestialExploration.MODID + ":sparse_asteroid_field");
        if (isBiomeSelected) {
            addEntityToAllBiomes(event, type, weight, minCount, maxCount);
        }
    }

    private static void addEntityToAllBiomesExceptThese(BiomeLoadingEvent event, EntityType<?> type, int weight, int minCount, int maxCount, ResourceKey<Biome>... biomes) {
        // Goes through each entry in the biomes and sees if it matches the current biome we are loading
        boolean isBiomeSelected = Arrays.stream(biomes).map(ResourceKey::location)
                .map(Object::toString).anyMatch(s -> s.equals(event.getName().toString()));

        if (!isBiomeSelected) {
            addEntityToAllBiomes(event, type, weight, minCount, maxCount);
        }
    }

    @SafeVarargs
    private static void addEntityToSpecificBiomes(BiomeLoadingEvent event, EntityType<?> type, int weight, int minCount, int maxCount, ResourceKey<Biome>... biomes) {
        // Goes through each entry in the biomes and sees if it matches the current biome we are loading
        boolean isBiomeSelected = Arrays.stream(biomes).map(ResourceKey::location)
                .map(Object::toString).anyMatch(s -> s.equals(event.getName().toString()));

        if (isBiomeSelected) {
            addEntityToAllBiomes(event, type, weight, minCount, maxCount);
        }
    }

    private static void addEntityToAllOverworldBiomes(BiomeLoadingEvent event, EntityType<?> type, int weight, int minCount, int maxCount) {
        if (!event.getCategory().equals(Biome.BiomeCategory.THEEND) && !event.getCategory().equals(Biome.BiomeCategory.NETHER)) {
            addEntityToAllBiomes(event, type, weight, minCount, maxCount);
        }
    }

    private static void addEntityToAllBiomesNoNether(BiomeLoadingEvent event, EntityType<?> type, int weight, int minCount, int maxCount) {
        if (!event.getCategory().equals(Biome.BiomeCategory.NETHER)) {
            List<MobSpawnSettings.SpawnerData> base = event.getSpawns().getSpawner(type.getCategory());
            base.add(new MobSpawnSettings.SpawnerData(type, weight, minCount, maxCount));
        }
    }

    private static void addEntityToAllBiomesNoEnd(BiomeLoadingEvent event, EntityType<?> type, int weight, int minCount, int maxCount) {
        if (!event.getCategory().equals(Biome.BiomeCategory.THEEND)) {
            List<MobSpawnSettings.SpawnerData> base = event.getSpawns().getSpawner(type.getCategory());
            base.add(new MobSpawnSettings.SpawnerData(type, weight, minCount, maxCount));
        }
    }

    private static void addEntityToAllBiomes(BiomeLoadingEvent event, EntityType<?> type, int weight, int minCount, int maxCount) {
        List<MobSpawnSettings.SpawnerData> base = event.getSpawns().getSpawner(type.getCategory());
        base.add(new MobSpawnSettings.SpawnerData(type, weight, minCount, maxCount));
    }
}