package com.shim.celestialexploration.world.biome;

import com.shim.celestialexploration.registry.CelestialCarvers;
import com.shim.celestialexploration.registry.CelestialEntities;
import com.shim.celestialexploration.world.features.placement.CelestialFeaturePlacements;
import com.shim.celestialexploration.world.features.placement.CraterPlacements;
import com.shim.celestialexploration.world.features.placement.SurfacePlacements;
import net.minecraft.data.worldgen.Carvers;
import net.minecraft.data.worldgen.placement.CavePlacements;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.*;
import net.minecraft.world.level.levelgen.GenerationStep;

public class MercuryBiomes extends CelestialBiomeFeatures {

    public static Biome desert() {
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();
        BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder();

        CelestialBiomeFeatures.addCarversAndLakes(biomeBuilder);
//        biomeBuilder.addCarver(GenerationStep.Carving.AIR, CelestialCarvers.CRATER.get());

        biomeBuilder.addFeature(GenerationStep.Decoration.LAKES, CelestialFeaturePlacements.MERCURY_LAVA_LAKE_UNDERGROUND);

        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, CelestialFeaturePlacements.DISK_MERCURY_SAND);
        biomeBuilder.addFeature(GenerationStep.Decoration.LOCAL_MODIFICATIONS, CelestialFeaturePlacements.DIAMOND_GEODE);
//        biomeBuilder.addFeature(GenerationStep.Decoration.LOCAL_MODIFICATIONS, CraterPlacements.CRATER);

        addMercuryOres(biomeBuilder);

        generalNoCaveMonsters(spawnBuilder, 50, 50, 50);
        addMercuryMobs(spawnBuilder, 30, 0, 40, 30);

        return mercury(Biome.Precipitation.NONE, prettyCold, 0F, spawnBuilder, biomeBuilder);
    }

    public static Biome craters() {
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();
        BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder();

        CelestialBiomeFeatures.addCarversAndLakes(biomeBuilder);
        biomeBuilder.addFeature(GenerationStep.Decoration.LAKES, CelestialFeaturePlacements.MERCURY_LAVA_LAKE_UNDERGROUND);

        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, CelestialFeaturePlacements.DISK_MERCURY_SAND);
        biomeBuilder.addFeature(GenerationStep.Decoration.LOCAL_MODIFICATIONS, CelestialFeaturePlacements.DIAMOND_GEODE);

        addMercuryOres(biomeBuilder);

        generalNoCaveMonsters(spawnBuilder, 50, 50, 50);
        addMercuryMobs(spawnBuilder, 30, 50, 40, 30);

        return mercury(Biome.Precipitation.NONE, prettyCold, 0F, spawnBuilder, biomeBuilder);
    }

    public static Biome plains() {
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();
        BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder();

        CelestialBiomeFeatures.addCarversAndLakes(biomeBuilder);
        biomeBuilder.addFeature(GenerationStep.Decoration.LAKES, CelestialFeaturePlacements.MERCURY_LAVA_LAKE_UNDERGROUND);

        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, CelestialFeaturePlacements.DISK_MERCURY_SAND);
        biomeBuilder.addFeature(GenerationStep.Decoration.LOCAL_MODIFICATIONS, CelestialFeaturePlacements.DIAMOND_GEODE);

        addMercuryOres(biomeBuilder);

        generalNoCaveMonsters(spawnBuilder, 50, 50, 50);
        addMercuryMobs(spawnBuilder, 30, 0, 40, 30);

        return mercury(Biome.Precipitation.NONE, prettyCold, 0F, spawnBuilder, biomeBuilder);
    }

    public static Biome ridges() {
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();
        BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder();

        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, CelestialFeaturePlacements.DISK_MERCURY_SAND);
        biomeBuilder.addFeature(GenerationStep.Decoration.LOCAL_MODIFICATIONS, CelestialFeaturePlacements.DIAMOND_GEODE);

        addMercuryOres(biomeBuilder);

        generalNoCaveMonsters(spawnBuilder, 50, 50, 50);

        return mercury(Biome.Precipitation.NONE, prettyCold, 0F, spawnBuilder, biomeBuilder);
    }

    protected static Biome mercury(Biome.Precipitation precipitation, float temperature, float downfall, MobSpawnSettings.Builder spawnBuilder, BiomeGenerationSettings.Builder biomeBuilder) {
        return (new Biome.BiomeBuilder()).precipitation(precipitation).biomeCategory(Biome.BiomeCategory.NONE).temperature(temperature).downfall(downfall)
                .specialEffects((new BiomeSpecialEffects.Builder()).waterColor(CelestialBody.MERCURY.waterColor).waterFogColor(CelestialBody.MERCURY.waterFogColor).fogColor(CelestialBody.MERCURY.skyFogColor)
                        .skyColor(CelestialBody.MERCURY.skyColor).grassColorOverride(CelestialBody.MERCURY.grassFoliageColor).foliageColorOverride(CelestialBody.MERCURY.grassFoliageColor)
                        .ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS).backgroundMusic(NORMAL_MUSIC).build()).mobSpawnSettings(spawnBuilder.build()).generationSettings(biomeBuilder.build()).build();
    }

    protected static void addMercuryMobs(MobSpawnSettings.Builder spawnBuilder, int slimeWeight, int meteorCrawlerWeight, int roverWeight, int droneWeight) {
        spawnBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(CelestialEntities.QUICKSILVER_SLIME.get(), slimeWeight, 0, 3))
                .addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(CelestialEntities.VISCOUS_SLIME.get(), slimeWeight, 0, 3))
                .addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(CelestialEntities.METEOR_CRAWLER.get(), meteorCrawlerWeight, 0, 2))
                .addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(CelestialEntities.ROVER.get(), roverWeight, 0, 1))
                .addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(CelestialEntities.DRONE.get(), droneWeight, 0, 2));
    }

    public static void addMercuryOres(BiomeGenerationSettings.Builder biomeBuilder) {
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, CelestialFeaturePlacements.MERCURY_IRON_ORE_UPPER);
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, CelestialFeaturePlacements.MERCURY_IRON_ORE_MIDDLE);
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, CelestialFeaturePlacements.MERCURY_IRON_ORE_SMALL);
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, CelestialFeaturePlacements.MERCURY_REDSTONE_ORE);
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, CelestialFeaturePlacements.MERCURY_REDSTONE_ORE_LOWER);
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, CelestialFeaturePlacements.MERCURY_BAUXITE_ORE);
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, CelestialFeaturePlacements.MERCURY_COAL_ORE_UPPER);
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, CelestialFeaturePlacements.MERCURY_COAL_ORE_LOWER);
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, CelestialFeaturePlacements.MERCURY_DIAMOND_ORE);
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, CelestialFeaturePlacements.MERCURY_SULFUR_ORE);
    }

}
