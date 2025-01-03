package com.shim.celestialexploration.world.biome;

import com.shim.celestialexploration.registry.EntityRegistry;
import com.shim.celestialexploration.world.features.placement.CelestialFeaturePlacements;
import com.shim.celestialexploration.world.features.placement.SurfacePlacements;
import net.minecraft.data.worldgen.Carvers;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.levelgen.GenerationStep;

public class VenusBiomes extends CelestialBiomes {

    public static Biome desert() {
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();
        BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder();

        CelestialBiomes.addCarversAndLakes(biomeBuilder);
        biomeBuilder.addFeature(GenerationStep.Decoration.LAKES, CelestialFeaturePlacements.VENUS_LAVA_LAKE_UNDERGROUND);

        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, CelestialFeaturePlacements.DISK_VENUS_SAND);
//        biomeBuilder.addFeature(GenerationStep.Decoration.TOP_LAYER_MODIFICATION, GeyserPlacement.GEYSER);

        addVenusOres(biomeBuilder);

        generalMonsters(spawnBuilder, 0, 20, 0);

        return CelestialBiomes.biome(Biome.Precipitation.RAIN, Biome.BiomeCategory.NONE, 2F, 0F, celestialBody.VENUS.skyColor, celestialBody.VENUS.skyFogColor, celestialBody.VENUS.waterColor, celestialBody.VENUS.waterFogColor, spawnBuilder, biomeBuilder, NORMAL_MUSIC);
    }

    public static Biome plains() {
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();
        BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder();

        CelestialBiomes.addCarversAndLakes(biomeBuilder);
        biomeBuilder.addFeature(GenerationStep.Decoration.LAKES, CelestialFeaturePlacements.VENUS_LAVA_LAKE_UNDERGROUND);

        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, CelestialFeaturePlacements.DISK_VENUS_SAND);
//        biomeBuilder.addFeature(GenerationStep.Decoration.TOP_LAYER_MODIFICATION, GeyserPlacement.GEYSER);

        addVenusOres(biomeBuilder);

        generalMonsters(spawnBuilder, 0, 20, 0);
        spawnBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityRegistry.SULFUR_CUBE.get(), 120, 4, 4))
                .addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityRegistry.VOIDED_PIGLIN.get(), 100, 4, 4))
                .addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityRegistry.ASTRAL_PIGLIN.get(), 15, 4, 4))
                .addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityRegistry.ASTRAL_HOGLIN.get(), 9, 3, 4))
                .addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityRegistry.ROVER.get(), 40, 1, 1)).build();

        return CelestialBiomes.biome(Biome.Precipitation.RAIN, Biome.BiomeCategory.NONE, 2F, 0F, celestialBody.VENUS.skyColor, celestialBody.VENUS.skyFogColor, celestialBody.VENUS.waterColor, celestialBody.VENUS.waterFogColor, spawnBuilder, biomeBuilder, NORMAL_MUSIC);
    }

    public static Biome ocean() {
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();
        BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder();

        biomeBuilder.addCarver(GenerationStep.Carving.AIR, Carvers.CAVE);
        biomeBuilder.addCarver(GenerationStep.Carving.AIR, Carvers.CAVE_EXTRA_UNDERGROUND);
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, CelestialFeaturePlacements.DISK_VENUS_SAND);
//        biomeBuilder.addFeature(GenerationStep.Decoration.TOP_LAYER_MODIFICATION, GeyserPlacement.GEYSER);
        addVenusOres(biomeBuilder);

        spawnBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityRegistry.SULFUR_CUBE.get(), 100, 2, 5)).build();


        return CelestialBiomes.biome(Biome.Precipitation.RAIN, Biome.BiomeCategory.NONE, 2F, 0F, celestialBody.VENUS.skyColor, celestialBody.VENUS.skyFogColor, celestialBody.VENUS.waterColor, celestialBody.VENUS.waterFogColor, spawnBuilder, biomeBuilder, NORMAL_MUSIC);
    }

    public static Biome river() {
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();
        BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder();

        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, CelestialFeaturePlacements.DISK_VENUS_SAND);
        addVenusOres(biomeBuilder);

        spawnBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityRegistry.SULFUR_CUBE.get(), 100, 2, 5)).build();

        return CelestialBiomes.biome(Biome.Precipitation.RAIN, Biome.BiomeCategory.NONE, 2F, 0F, celestialBody.VENUS.skyColor, celestialBody.VENUS.skyFogColor, celestialBody.VENUS.waterColor, celestialBody.VENUS.waterFogColor, spawnBuilder, biomeBuilder, NORMAL_MUSIC);
    }

    public static void addVenusOres(BiomeGenerationSettings.Builder biomeBuilder) {
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, CelestialFeaturePlacements.VENUS_IRON_ORE_UPPER);
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, CelestialFeaturePlacements.VENUS_IRON_ORE_MIDDLE);
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, CelestialFeaturePlacements.VENUS_IRON_ORE_SMALL);
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, CelestialFeaturePlacements.VENUS_REDSTONE_ORE);
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, CelestialFeaturePlacements.VENUS_REDSTONE_ORE_LOWER);
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, CelestialFeaturePlacements.VENUS_LAPIS_ORE);
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, CelestialFeaturePlacements.VENUS_LAPIS_ORE_BURIED);
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, CelestialFeaturePlacements.VENUS_BAUXITE_ORE);
    }
}
