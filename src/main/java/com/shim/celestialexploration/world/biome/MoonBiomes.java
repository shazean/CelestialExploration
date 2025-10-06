package com.shim.celestialexploration.world.biome;

import com.shim.celestialexploration.registry.CelestialEntities;
import com.shim.celestialexploration.world.features.placement.CelestialFeaturePlacements;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.*;
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

        generalNoCaveMonsters(spawnBuilder, 50, 50, 50);
        spawnBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(CelestialEntities.LUNAR_SLIME.get(), 100, 4, 4))
                .addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(CelestialEntities.ROVER.get(), 40, 1, 1))
                .addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(CelestialEntities.DRONE.get(), 30, 1, 2))
                .build();

        return moon(Biome.Precipitation.NONE, prettyCold, 0F, spawnBuilder, biomeBuilder);
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

        generalNoCaveMonsters(spawnBuilder, 50, 50, 50);
        spawnBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(CelestialEntities.LUNAR_SLIME.get(), 100, 4, 4))
                .addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(CelestialEntities.METEOR_CRAWLER.get(), 100, 4, 4))
                .addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(CelestialEntities.ROVER.get(), 40, 1, 1))
                .addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(CelestialEntities.DRONE.get(), 30, 1, 2))
                .build();

        //        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, CelestialFeaturePlacements.DISK_MOON_SAND);

        return moon(Biome.Precipitation.NONE, prettyCold, 0F, spawnBuilder, biomeBuilder);
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

        generalNoCaveMonsters(spawnBuilder, 50, 50, 50);
        spawnBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(CelestialEntities.LUNAR_SLIME.get(), 120, 4, 4))
                .addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(CelestialEntities.ROVER.get(), 40, 1, 1))
                .addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(CelestialEntities.DRONE.get(), 30, 1, 2)).build();

        return moon(Biome.Precipitation.NONE, prettyCold, 0F, spawnBuilder, biomeBuilder);
    }

    public static Biome plains() {
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();
        BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder();

        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, CelestialFeaturePlacements.DISK_MOON_SAND);
        addMoonOres(biomeBuilder);

        generalNoCaveMonsters(spawnBuilder, 50, 50, 50);
        spawnBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(CelestialEntities.LUNAR_SLIME.get(), 30, 4, 4))
                .addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(CelestialEntities.ROVER.get(), 40, 1, 1))
                .addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(CelestialEntities.DRONE.get(), 30, 1, 2)).build();

        return moon(Biome.Precipitation.NONE, prettyCold, 0F, spawnBuilder, biomeBuilder);
    }

    public static Biome ocean() {
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();
        BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder();

        addMoonOres(biomeBuilder);

        spawnBuilder.addSpawn(MobCategory.WATER_AMBIENT, new MobSpawnSettings.SpawnerData(CelestialEntities.EUREKA.get(), 30, 4, 4))
                .addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(CelestialEntities.ROVER.get(), 40, 1, 1)).build();

        return moon(Biome.Precipitation.NONE,-0.75F, 0F, spawnBuilder, biomeBuilder);
    }

    public static Biome river() {
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();
        BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder();

        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, CelestialFeaturePlacements.DISK_MOON_SAND);
        addMoonOres(biomeBuilder);

        return moon(Biome.Precipitation.NONE, -0.75F, 0F, spawnBuilder, biomeBuilder);
    }

    protected static Biome moon(Biome.Precipitation precipitation, float temperature, float downfall, MobSpawnSettings.Builder spawnBuilder, BiomeGenerationSettings.Builder biomeBuilder) {
        return (new Biome.BiomeBuilder()).precipitation(precipitation).biomeCategory(Biome.BiomeCategory.NONE).temperature(temperature).downfall(downfall)
                .specialEffects((new BiomeSpecialEffects.Builder()).waterColor(CelestialBody.MOON.waterColor).waterFogColor(CelestialBody.MOON.waterFogColor).fogColor(CelestialBody.MOON.skyFogColor)
                        .skyColor(CelestialBody.MOON.skyColor).grassColorOverride(CelestialBody.MOON.grassFoliageColor).foliageColorOverride(CelestialBody.IO.grassFoliageColor)
                        .ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS).backgroundMusic(NORMAL_MUSIC).build()).mobSpawnSettings(spawnBuilder.build()).generationSettings(biomeBuilder.build()).build();
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