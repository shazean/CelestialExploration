package com.shim.celestialexploration.world.biome;

import com.shim.celestialexploration.registry.EntityRegistry;
import com.shim.celestialexploration.world.features.placement.CelestialFeaturePlacements;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.levelgen.GenerationStep;

public class MercuryBiomes extends CelestialBiomes {

    public static Biome desert() {
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();
        BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder();

        CelestialBiomes.addCarversAndLakes(biomeBuilder);
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, CelestialFeaturePlacements.DISK_MERCURY_SAND);
        addMercuryOres(biomeBuilder);

        generalMonsters(spawnBuilder, 100, 100, 100);
        spawnBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityRegistry.QUICKSILVER_SLIME.get(), 30, 4, 4))
                .addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityRegistry.VISCOUS_SLIME.get(), 30, 4, 4)).build();

        return CelestialBiomes.biome(Biome.Precipitation.NONE, Biome.BiomeCategory.NONE, prettyCold, 0F, celestialBody.MERCURY.skyColor, celestialBody.MERCURY.skyFogColor, celestialBody.MERCURY.waterColor, celestialBody.MERCURY.waterFogColor, spawnBuilder, biomeBuilder, NORMAL_MUSIC);
    }

    public static Biome craters() {
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();
        BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder();

        CelestialBiomes.addCarversAndLakes(biomeBuilder);
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, CelestialFeaturePlacements.DISK_MERCURY_SAND);
        addMercuryOres(biomeBuilder);

        generalMonsters(spawnBuilder, 100, 100, 100);
        spawnBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityRegistry.QUICKSILVER_SLIME.get(), 30, 4, 4))
                .addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityRegistry.VISCOUS_SLIME.get(), 30, 4, 4)).build();

        return CelestialBiomes.biome(Biome.Precipitation.NONE, Biome.BiomeCategory.NONE, prettyCold, 0F, celestialBody.MERCURY.skyColor, celestialBody.MERCURY.skyFogColor, celestialBody.MERCURY.waterColor, celestialBody.MERCURY.waterFogColor, spawnBuilder, biomeBuilder, NORMAL_MUSIC);
    }

    public static Biome plains() {
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();
        BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder();

        CelestialBiomes.addCarversAndLakes(biomeBuilder);
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, CelestialFeaturePlacements.DISK_MERCURY_SAND);
        addMercuryOres(biomeBuilder);

        generalMonsters(spawnBuilder, 100, 80, 100);
        spawnBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityRegistry.QUICKSILVER_SLIME.get(), 30, 4, 4))
                .addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityRegistry.VISCOUS_SLIME.get(), 30, 4, 4)).build();

        return CelestialBiomes.biome(Biome.Precipitation.NONE, Biome.BiomeCategory.NONE, prettyCold, 0F, celestialBody.MERCURY.skyColor, celestialBody.MERCURY.skyFogColor, celestialBody.MERCURY.waterColor, celestialBody.MERCURY.waterFogColor, spawnBuilder, biomeBuilder, NORMAL_MUSIC);
    }

    public static Biome ridges() {
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();
        BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder();

        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, CelestialFeaturePlacements.DISK_MERCURY_SAND);
        addMercuryOres(biomeBuilder);

        generalMonsters(spawnBuilder, 80, 100, 100);

        return CelestialBiomes.biome(Biome.Precipitation.NONE, Biome.BiomeCategory.NONE, prettyCold, 0F, celestialBody.MERCURY.skyColor, celestialBody.MERCURY.skyFogColor, celestialBody.MERCURY.waterColor, celestialBody.MERCURY.waterFogColor, spawnBuilder, biomeBuilder, NORMAL_MUSIC);
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
