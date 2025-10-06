package com.shim.celestialexploration.world.biome;

import com.shim.celestialexploration.registry.CelestialEntities;
import com.shim.celestialexploration.world.features.placement.CelestialFeaturePlacements;
import net.minecraft.data.worldgen.Carvers;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.*;
import net.minecraft.world.level.levelgen.GenerationStep;

public class VenusBiomes extends CelestialBiomeFeatures {

    public static Biome desert() {
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();
        BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder();

        CelestialBiomeFeatures.addCarversAndLakes(biomeBuilder);
        biomeBuilder.addFeature(GenerationStep.Decoration.LAKES, CelestialFeaturePlacements.VENUS_LAVA_LAKE_UNDERGROUND);

        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, CelestialFeaturePlacements.DISK_VENUS_SAND);
//        biomeBuilder.addFeature(GenerationStep.Decoration.TOP_LAYER_MODIFICATION, GeyserPlacement.GEYSER);

        addVenusOres(biomeBuilder);

        generalMonsters(spawnBuilder, 0, 20, 0);

        return venus(Biome.Precipitation.RAIN, 2F, 0F, spawnBuilder, biomeBuilder);
    }

    public static Biome plains() {
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();
        BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder();

        CelestialBiomeFeatures.addCarversAndLakes(biomeBuilder);
        biomeBuilder.addFeature(GenerationStep.Decoration.LAKES, CelestialFeaturePlacements.VENUS_LAVA_LAKE_UNDERGROUND);

        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, CelestialFeaturePlacements.DISK_VENUS_SAND);
//        biomeBuilder.addFeature(GenerationStep.Decoration.TOP_LAYER_MODIFICATION, GeyserPlacement.GEYSER);

        addVenusOres(biomeBuilder);

        generalMonsters(spawnBuilder, 0, 20, 0);
        spawnBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(CelestialEntities.SULFUR_CUBE.get(), 120, 4, 4))
                .addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(CelestialEntities.VOIDED_PIGLIN.get(), 100, 4, 4))
                .addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(CelestialEntities.CYBORG_PIGLIN.get(), 50, 4, 4))
                .addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(CelestialEntities.ASTRAL_PIGLIN.get(), 15, 4, 4))
                .addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(CelestialEntities.ASTRAL_HOGLIN.get(), 9, 3, 4))
                .addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(CelestialEntities.ROVER.get(), 40, 1, 1)).build();

        return venus(Biome.Precipitation.RAIN,2F, 0F, spawnBuilder, biomeBuilder);
    }

    public static Biome ocean() {
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();
        BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder();

        biomeBuilder.addCarver(GenerationStep.Carving.AIR, Carvers.CAVE);
        biomeBuilder.addCarver(GenerationStep.Carving.AIR, Carvers.CAVE_EXTRA_UNDERGROUND);
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, CelestialFeaturePlacements.DISK_VENUS_SAND);
//        biomeBuilder.addFeature(GenerationStep.Decoration.TOP_LAYER_MODIFICATION, GeyserPlacement.GEYSER);
        addVenusOres(biomeBuilder);

        spawnBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(CelestialEntities.SULFUR_CUBE.get(), 100, 2, 5)).build();


        return venus(Biome.Precipitation.RAIN, 2F, 0F, spawnBuilder, biomeBuilder);
    }

    public static Biome river() {
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();
        BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder();

        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, CelestialFeaturePlacements.DISK_VENUS_SAND);
        addVenusOres(biomeBuilder);

        spawnBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(CelestialEntities.SULFUR_CUBE.get(), 100, 2, 5)).build();

        return venus(Biome.Precipitation.RAIN, 2F, 0F, spawnBuilder, biomeBuilder);
    }

    protected static Biome venus(Biome.Precipitation precipitation, float temperature, float downfall, MobSpawnSettings.Builder spawnBuilder, BiomeGenerationSettings.Builder biomeBuilder) {
        return (new Biome.BiomeBuilder()).precipitation(precipitation).biomeCategory(Biome.BiomeCategory.NONE).temperature(temperature).downfall(downfall)
                .specialEffects((new BiomeSpecialEffects.Builder()).waterColor(CelestialBody.VENUS.waterColor).waterFogColor(CelestialBody.VENUS.waterFogColor).fogColor(CelestialBody.VENUS.skyFogColor)
                        .skyColor(CelestialBody.VENUS.skyColor).grassColorOverride(CelestialBody.VENUS.grassFoliageColor).foliageColorOverride(CelestialBody.IO.grassFoliageColor)
                        .ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS).backgroundMusic(NORMAL_MUSIC).build()).mobSpawnSettings(spawnBuilder.build()).generationSettings(biomeBuilder.build()).build();
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
