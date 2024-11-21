package com.shim.celestialexploration.world.biome;

import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.data.worldgen.placement.AquaticPlacements;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.levelgen.GenerationStep;

public class PresetBiomes extends CelestialBiomes {

    public static Biome desert(boolean wet, boolean icy) {
        MobSpawnSettings.Builder mobspawnsettings$builder = new MobSpawnSettings.Builder();

        BiomeDefaultFeatures.desertSpawns(mobspawnsettings$builder);
        BiomeGenerationSettings.Builder biomegenerationsettings$builder = new BiomeGenerationSettings.Builder();
        BiomeDefaultFeatures.addFossilDecoration(biomegenerationsettings$builder);
        globalOverworldGeneration(biomegenerationsettings$builder);
        BiomeDefaultFeatures.addDefaultOres(biomegenerationsettings$builder);
        BiomeDefaultFeatures.addDefaultSoftDisks(biomegenerationsettings$builder);
        BiomeDefaultFeatures.addDefaultFlowers(biomegenerationsettings$builder);
        BiomeDefaultFeatures.addDefaultGrass(biomegenerationsettings$builder);
        BiomeDefaultFeatures.addDesertVegetation(biomegenerationsettings$builder);
        BiomeDefaultFeatures.addDefaultMushrooms(biomegenerationsettings$builder);
        BiomeDefaultFeatures.addDesertExtraVegetation(biomegenerationsettings$builder);
        BiomeDefaultFeatures.addDesertExtraDecoration(biomegenerationsettings$builder);


        Biome.Precipitation precipitation;
        if (wet && !icy) {
            precipitation = Biome.Precipitation.RAIN;
        } else if (icy) {
            precipitation = Biome.Precipitation.SNOW;
        } else {
            precipitation = Biome.Precipitation.NONE;
        }

        float downfall = wet || icy ? 0.1F : 0.0F;
        float temp = icy ? -0.3F : 2.0F;

        return CelestialBiomes.biome(precipitation, Biome.BiomeCategory.DESERT, temp, downfall, 4159204, 329011, mobspawnsettings$builder, biomegenerationsettings$builder, NORMAL_MUSIC);
    }

    public static Biome ocean() {
        MobSpawnSettings.Builder mobspawnsettings$builder = new MobSpawnSettings.Builder();
        BiomeDefaultFeatures.oceanSpawns(mobspawnsettings$builder, 10, 2, 15);

        mobspawnsettings$builder.addSpawn(MobCategory.WATER_AMBIENT, new MobSpawnSettings.SpawnerData(EntityType.PUFFERFISH, 5, 1, 3)).addSpawn(MobCategory.WATER_AMBIENT, new MobSpawnSettings.SpawnerData(EntityType.TROPICAL_FISH, 25, 8, 8)).addSpawn(MobCategory.WATER_CREATURE, new MobSpawnSettings.SpawnerData(EntityType.DOLPHIN, 2, 1, 2));
        BiomeGenerationSettings.Builder biomegenerationsettings$builder = new BiomeGenerationSettings.Builder();
        globalOverworldGeneration(biomegenerationsettings$builder);
        BiomeDefaultFeatures.addDefaultOres(biomegenerationsettings$builder);
        BiomeDefaultFeatures.addDefaultSoftDisks(biomegenerationsettings$builder);
        BiomeDefaultFeatures.addWaterTrees(biomegenerationsettings$builder);
        BiomeDefaultFeatures.addDefaultFlowers(biomegenerationsettings$builder);
        BiomeDefaultFeatures.addDefaultGrass(biomegenerationsettings$builder);
        BiomeDefaultFeatures.addDefaultMushrooms(biomegenerationsettings$builder);
        BiomeDefaultFeatures.addDefaultExtraVegetation(biomegenerationsettings$builder);
        biomegenerationsettings$builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, AquaticPlacements.SEAGRASS_WARM);

        BiomeDefaultFeatures.addLukeWarmKelp(biomegenerationsettings$builder);

//        MobSpawnSettings.Builder mobspawnsettings$builder = new MobSpawnSettings.Builder();
//        BiomeDefaultFeatures.oceanSpawns(mobspawnsettings$builder, 10, 2, 15);
//
//        mobspawnsettings$builder.addSpawn(MobCategory.WATER_AMBIENT, new MobSpawnSettings.SpawnerData(EntityType.PUFFERFISH, 5, 1, 3)).addSpawn(MobCategory.WATER_AMBIENT, new MobSpawnSettings.SpawnerData(EntityType.TROPICAL_FISH, 25, 8, 8)).addSpawn(MobCategory.WATER_CREATURE, new MobSpawnSettings.SpawnerData(EntityType.DOLPHIN, 2, 1, 2));
//        BiomeGenerationSettings.Builder biomegenerationsettings$builder = new BiomeGenerationSettings.Builder();
//        biomegenerationsettings$builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, AquaticPlacements.SEAGRASS_WARM);
//
//        globalOverworldGeneration(biomegenerationsettings$builder);
//        BiomeDefaultFeatures.addDefaultOres(biomegenerationsettings$builder);
//        BiomeDefaultFeatures.addDefaultSoftDisks(biomegenerationsettings$builder);
//        BiomeDefaultFeatures.addWaterTrees(biomegenerationsettings$builder);
//        BiomeDefaultFeatures.addDefaultFlowers(biomegenerationsettings$builder);
//        BiomeDefaultFeatures.addDefaultGrass(biomegenerationsettings$builder);
//        BiomeDefaultFeatures.addDefaultMushrooms(biomegenerationsettings$builder);
//        BiomeDefaultFeatures.addDefaultExtraVegetation(biomegenerationsettings$builder);
//
//        BiomeDefaultFeatures.addLukeWarmKelp(biomegenerationsettings$builder);

        return CelestialBiomes.biome(Biome.Precipitation.RAIN, Biome.BiomeCategory.OCEAN, 0.5F, 0.5F, 4566514, 267827, mobspawnsettings$builder, biomegenerationsettings$builder, NORMAL_MUSIC);
    }

    public static Biome island() {
        MobSpawnSettings.Builder mobspawnsettings$builder = new MobSpawnSettings.Builder();
        mobspawnsettings$builder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.TURTLE, 5, 2, 5));

        BiomeDefaultFeatures.commonSpawns(mobspawnsettings$builder);
        BiomeGenerationSettings.Builder biomegenerationsettings$builder = new BiomeGenerationSettings.Builder();
        globalOverworldGeneration(biomegenerationsettings$builder);
        BiomeDefaultFeatures.addDefaultOres(biomegenerationsettings$builder);
        BiomeDefaultFeatures.addDefaultSoftDisks(biomegenerationsettings$builder);
        BiomeDefaultFeatures.addDefaultFlowers(biomegenerationsettings$builder);
        BiomeDefaultFeatures.addDefaultGrass(biomegenerationsettings$builder);
        BiomeDefaultFeatures.addDefaultMushrooms(biomegenerationsettings$builder);
        BiomeDefaultFeatures.addDefaultExtraVegetation(biomegenerationsettings$builder);
        float f;
        f = 0.8F;

        return biome(Biome.Precipitation.RAIN, Biome.BiomeCategory.BEACH, f, 0.4F, 4159204, 329011, mobspawnsettings$builder, biomegenerationsettings$builder, NORMAL_MUSIC);
    }

    private static void globalOverworldGeneration(BiomeGenerationSettings.Builder p_194870_) {
        BiomeDefaultFeatures.addDefaultCarversAndLakes(p_194870_);
        BiomeDefaultFeatures.addDefaultCrystalFormations(p_194870_);
        BiomeDefaultFeatures.addDefaultMonsterRoom(p_194870_);
        BiomeDefaultFeatures.addDefaultUndergroundVariety(p_194870_);
        BiomeDefaultFeatures.addDefaultSprings(p_194870_);
        BiomeDefaultFeatures.addSurfaceFreezing(p_194870_);
    }


}