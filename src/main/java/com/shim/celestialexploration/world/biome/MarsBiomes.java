package com.shim.celestialexploration.world.biome;

import com.shim.celestialexploration.registry.CelestialEntities;
import com.shim.celestialexploration.world.features.placement.CelestialFeaturePlacements;
import net.minecraft.sounds.Music;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.*;
import net.minecraft.world.level.levelgen.GenerationStep;

import javax.annotation.Nullable;

public class MarsBiomes extends CelestialBiomeFeatures {

    public static Biome desert() {
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();
        BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder();

        CelestialBiomeFeatures.addCarversAndLakes(biomeBuilder);
        biomeBuilder.addFeature(GenerationStep.Decoration.LAKES, CelestialFeaturePlacements.MARS_LAVA_LAKE_UNDERGROUND);

        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, CelestialFeaturePlacements.DISK_MARS_SAND);
        addMarsOres(biomeBuilder);

        generalMonsters(spawnBuilder, 100, 100, 0);
        spawnBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(CelestialEntities.RUST_SLIME.get(), 100, 4, 4))
                .addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(CelestialEntities.MARS_MALLOW.get(), 40, 4, 4))
                .addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(CelestialEntities.GUST.get(), 100, 4, 4))
                .addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(CelestialEntities.ROVER.get(), 10, 1, 1)).build();

        float temp = -0.75F;

        return mars(Biome.Precipitation.NONE, prettyCold, 0F, spawnBuilder, biomeBuilder);
    }

    public static Biome craters() {
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();
        BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder();

        CelestialBiomeFeatures.addCarversAndLakes(biomeBuilder);
        biomeBuilder.addFeature(GenerationStep.Decoration.LAKES, CelestialFeaturePlacements.MARS_LAVA_LAKE_UNDERGROUND);

        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, CelestialFeaturePlacements.DISK_MARS_SAND);
        addMarsOres(biomeBuilder);

        generalMonsters(spawnBuilder, 100, 100, 0);
        spawnBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(CelestialEntities.RUST_SLIME.get(), 100, 4, 4))
                .addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(CelestialEntities.MARS_MALLOW.get(), 40, 4, 4))
                .addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(CelestialEntities.GUST.get(), 100, 4, 4))
                .addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(CelestialEntities.ROVER.get(), 40, 1, 1))
                .addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(CelestialEntities.DRONE.get(), 30, 1, 2))
                .build();


        return mars(Biome.Precipitation.NONE, prettyCold, 0F, spawnBuilder, biomeBuilder);
    }

    public static Biome flats(boolean dryIcy) {
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();
        BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder();

        CelestialBiomeFeatures.addCarversAndLakes(biomeBuilder);
        biomeBuilder.addFeature(GenerationStep.Decoration.LAKES, CelestialFeaturePlacements.MARS_LAVA_LAKE_UNDERGROUND);

        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, CelestialFeaturePlacements.DISK_MARS_SAND);
        addMarsOres(biomeBuilder);

        generalMonsters(spawnBuilder, 100, 80, 0);
        spawnBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(CelestialEntities.RUST_SLIME.get(), 120, 4, 4))
                .addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(CelestialEntities.MARS_MALLOW.get(), 80, 4, 4))
                .addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(CelestialEntities.GUST.get(), 100, 4, 4))
                .addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(CelestialEntities.ROVER.get(), 40, 1, 1))
                .addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(CelestialEntities.DRONE.get(), 30, 1, 2))
                .build();


        float temperature = dryIcy ? -1.0F : -0.75F;

        return mars(Biome.Precipitation.NONE, temperature, 0F, spawnBuilder, biomeBuilder);
    }

    public static Biome dunes() {
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();
        BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder();

        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, CelestialFeaturePlacements.DISK_MARS_SAND);
        addMarsOres(biomeBuilder);

        generalMonsters(spawnBuilder, 80, 100, 0);

        spawnBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(CelestialEntities.RUST_SLIME.get(), 30, 4, 4))
                .addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(CelestialEntities.MARS_MALLOW.get(), 10, 4, 4))
                .addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(CelestialEntities.GUST.get(), 100, 4, 4))
                .addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(CelestialEntities.ROVER.get(), 40, 1, 1))
                .addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(CelestialEntities.DRONE.get(), 30, 1, 2))
                .build();

        float temp = -0.75F;

        return mars(Biome.Precipitation.NONE, prettyCold, 0F, spawnBuilder, biomeBuilder);
    }

    protected static Biome mars(Biome.Precipitation precipitation, float temperature, float downfall, MobSpawnSettings.Builder spawnBuilder, BiomeGenerationSettings.Builder biomeBuilder) {
        return (new Biome.BiomeBuilder()).precipitation(precipitation).biomeCategory(Biome.BiomeCategory.NONE).temperature(temperature).downfall(downfall)
                .specialEffects((new BiomeSpecialEffects.Builder()).waterColor(CelestialBody.MARS.waterColor).waterFogColor(CelestialBody.MARS.waterFogColor).fogColor(CelestialBody.MARS.skyFogColor)
                        .skyColor(CelestialBody.MARS.skyColor).grassColorOverride(CelestialBody.MARS.grassFoliageColor).foliageColorOverride(CelestialBody.MARS.grassFoliageColor)
                        .ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS).backgroundMusic(NORMAL_MUSIC).build()).mobSpawnSettings(spawnBuilder.build()).generationSettings(biomeBuilder.build()).build();
    }

    public static void addMarsOres(BiomeGenerationSettings.Builder biomeBuilder) {
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, CelestialFeaturePlacements.MARS_IRON_ORE_UPPER);
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, CelestialFeaturePlacements.MARS_IRON_ORE_MIDDLE);
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, CelestialFeaturePlacements.MARS_IRON_ORE_SMALL);
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, CelestialFeaturePlacements.MARS_REDSTONE_ORE);
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, CelestialFeaturePlacements.MARS_REDSTONE_ORE_LOWER);
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, CelestialFeaturePlacements.MARS_BAUXITE_ORE);
    }
}