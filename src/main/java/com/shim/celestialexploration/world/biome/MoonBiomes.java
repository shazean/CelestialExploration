package com.shim.celestialexploration.world.biome;

import com.shim.celestialexploration.registry.CelestialEntities;
import com.shim.celestialexploration.world.features.placement.CelestialFeaturePlacements;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.levelgen.GenerationStep;

public class MoonBiomes extends CelestialBiomeFeatures {

    public static Biome desert(boolean isGanymede) {
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();
        BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder();

        CelestialBiomeFeatures.addCarversAndLakes(biomeBuilder);

        biomeBuilder.addFeature(GenerationStep.Decoration.LAKES, CelestialFeaturePlacements.MOON_LAVA_LAKE_UNDERGROUND);
        if (isGanymede) {
            biomeBuilder.addFeature(GenerationStep.Decoration.LAKES, CelestialFeaturePlacements.GANYMEDE_WATER_LAKE_UNDERGROUND);
        }

        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, CelestialFeaturePlacements.DISK_MOON_SAND);
        addMoonOres(biomeBuilder);

        generalMonsters(spawnBuilder, 100, 100, 100);
        spawnBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(CelestialEntities.LUNAR_SLIME.get(), 100, 4, 4))
                .addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(CelestialEntities.ROVER.get(), 40, 1, 1))
                .addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(CelestialEntities.DRONE.get(), 30, 1, 2))
                .build();

        return CelestialBiomeFeatures.biome(Biome.Precipitation.NONE, Biome.BiomeCategory.NONE, prettyCold, 0F, CelestialBody.MOON.skyColor, CelestialBody.MOON.skyFogColor, CelestialBody.MOON.waterColor, CelestialBody.MOON.waterFogColor, spawnBuilder, biomeBuilder, NORMAL_MUSIC);
    }

    public static Biome craters(boolean isGanymede) {
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();
        BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder();

        CelestialBiomeFeatures.addCarversAndLakes(biomeBuilder);
        biomeBuilder.addFeature(GenerationStep.Decoration.LAKES, CelestialFeaturePlacements.MOON_LAVA_LAKE_UNDERGROUND);
        if (isGanymede) {
            biomeBuilder.addFeature(GenerationStep.Decoration.LAKES, CelestialFeaturePlacements.GANYMEDE_WATER_LAKE_UNDERGROUND);
        }

        addMoonOres(biomeBuilder);

        generalMonsters(spawnBuilder, 100, 100, 100);
        spawnBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(CelestialEntities.LUNAR_SLIME.get(), 100, 4, 4))
                .addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(CelestialEntities.METEOR_CRAWLER.get(), 100, 4, 4))
                .addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(CelestialEntities.ROVER.get(), 40, 1, 1))
                .addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(CelestialEntities.DRONE.get(), 30, 1, 2))
                .build();

        //        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, CelestialFeaturePlacements.DISK_MOON_SAND);

        return CelestialBiomeFeatures.biome(Biome.Precipitation.NONE, Biome.BiomeCategory.NONE, prettyCold, 0F, CelestialBody.MOON.skyColor, CelestialBody.MOON.skyFogColor, CelestialBody.MOON.waterColor, CelestialBody.MOON.waterFogColor, spawnBuilder, biomeBuilder, NORMAL_MUSIC);
    }

    public static Biome lavaFlats(boolean isGanymede) {
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();
        BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder();

        CelestialBiomeFeatures.addCarversAndLakes(biomeBuilder);
        biomeBuilder.addFeature(GenerationStep.Decoration.LAKES, CelestialFeaturePlacements.MOON_LAVA_LAKE_UNDERGROUND);
        if (isGanymede) {
            biomeBuilder.addFeature(GenerationStep.Decoration.LAKES, CelestialFeaturePlacements.GANYMEDE_WATER_LAKE_UNDERGROUND);
        }

        biomeBuilder.addFeature(GenerationStep.Decoration.LAKES, CelestialFeaturePlacements.OBSIDIAN_LAKE);

//        biomeBuilder.addFeature(GenerationStep.Decoration.LAKES, CelestialFeaturePlacements.OBSIDIAN_LAKE);
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, CelestialFeaturePlacements.DISK_MOON_SAND);
        addMoonOres(biomeBuilder);

        generalMonsters(spawnBuilder, 100, 80, 100);
        spawnBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(CelestialEntities.LUNAR_SLIME.get(), 120, 4, 4))
                .addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(CelestialEntities.ROVER.get(), 40, 1, 1))
                .addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(CelestialEntities.DRONE.get(), 30, 1, 2)).build();

        return CelestialBiomeFeatures.biome(Biome.Precipitation.NONE, Biome.BiomeCategory.NONE, prettyCold, 0F, CelestialBody.MOON.skyColor, CelestialBody.MOON.skyFogColor, CelestialBody.MOON.waterColor, CelestialBody.MOON.waterFogColor, spawnBuilder, biomeBuilder, NORMAL_MUSIC);
    }

    public static Biome plains() {
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();
        BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder();

        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, CelestialFeaturePlacements.DISK_MOON_SAND);
        addMoonOres(biomeBuilder);

        generalMonsters(spawnBuilder, 80, 100, 100);
        spawnBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(CelestialEntities.LUNAR_SLIME.get(), 30, 4, 4))
                .addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(CelestialEntities.ROVER.get(), 40, 1, 1))
                .addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(CelestialEntities.DRONE.get(), 30, 1, 2)).build();

        return CelestialBiomeFeatures.biome(Biome.Precipitation.NONE, Biome.BiomeCategory.NONE, prettyCold, 0F, CelestialBody.MOON.skyColor, CelestialBody.MOON.skyFogColor, CelestialBody.MOON.waterColor, CelestialBody.MOON.waterFogColor, spawnBuilder, biomeBuilder, NORMAL_MUSIC);
    }

    public static Biome ocean() {
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();
        BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder();

        addMoonOres(biomeBuilder);

        spawnBuilder.addSpawn(MobCategory.WATER_AMBIENT, new MobSpawnSettings.SpawnerData(CelestialEntities.EUREKA.get(), 30, 4, 4))
                .addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(CelestialEntities.ROVER.get(), 40, 1, 1)).build();

        return CelestialBiomeFeatures.biome(Biome.Precipitation.NONE, Biome.BiomeCategory.NONE, -0.75F, 0F, CelestialBody.MOON.skyColor, CelestialBody.MOON.skyFogColor, CelestialBody.MOON.waterColor, CelestialBody.MOON.waterFogColor, spawnBuilder, biomeBuilder, NORMAL_MUSIC);
    }

    public static Biome river() {
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();
        BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder();

        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, CelestialFeaturePlacements.DISK_MOON_SAND);
        addMoonOres(biomeBuilder);

        return CelestialBiomeFeatures.biome(Biome.Precipitation.NONE, Biome.BiomeCategory.NONE, -0.75F, 0F, CelestialBody.MOON.skyColor, CelestialBody.MOON.skyFogColor, CelestialBody.MOON.waterColor, CelestialBody.MOON.waterFogColor, spawnBuilder, biomeBuilder, NORMAL_MUSIC);
    }


    public static void addMoonOres(BiomeGenerationSettings.Builder biomeBuilder) {
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, CelestialFeaturePlacements.MOON_IRON_ORE_UPPER);
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, CelestialFeaturePlacements.MOON_IRON_ORE_MIDDLE);
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, CelestialFeaturePlacements.MOON_IRON_ORE_SMALL);
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, CelestialFeaturePlacements.MOON_REDSTONE_ORE);
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, CelestialFeaturePlacements.MOON_REDSTONE_ORE_LOWER);
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, CelestialFeaturePlacements.MOON_BAUXITE_ORE);
    }
}