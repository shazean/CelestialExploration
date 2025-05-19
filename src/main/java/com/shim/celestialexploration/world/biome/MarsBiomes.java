package com.shim.celestialexploration.world.biome;

import com.shim.celestialexploration.registry.EntityRegistry;
import com.shim.celestialexploration.world.features.placement.CelestialFeaturePlacements;
import com.shim.celestialexploration.world.features.placement.SurfacePlacements;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.levelgen.GenerationStep;

public class MarsBiomes extends CelestialBiomes {

    public static Biome desert() {
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();
        BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder();

        CelestialBiomes.addCarversAndLakes(biomeBuilder);
        biomeBuilder.addFeature(GenerationStep.Decoration.LAKES, CelestialFeaturePlacements.MARS_LAVA_LAKE_UNDERGROUND);

        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, CelestialFeaturePlacements.DISK_MARS_SAND);
        addMarsOres(biomeBuilder);

        generalMonsters(spawnBuilder, 100, 100, 0);
        spawnBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityRegistry.RUST_SLIME.get(), 100, 4, 4))
                .addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityRegistry.MARS_MALLOW.get(), 40, 4, 4))
                .addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityRegistry.GUST.get(), 100, 4, 4))
                .addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityRegistry.ROVER.get(), 10, 1, 1)).build();

        float temp = -0.75F;

        return CelestialBiomes.biome(Biome.Precipitation.NONE, Biome.BiomeCategory.NONE, prettyCold, 0F, celestialBody.MARS.skyColor, celestialBody.MARS.skyFogColor, celestialBody.MARS.waterColor, celestialBody.MARS.waterFogColor, spawnBuilder, biomeBuilder, NORMAL_MUSIC);
    }

    public static Biome craters() {
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();
        BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder();

        CelestialBiomes.addCarversAndLakes(biomeBuilder);
        biomeBuilder.addFeature(GenerationStep.Decoration.LAKES, CelestialFeaturePlacements.MARS_LAVA_LAKE_UNDERGROUND);

        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, CelestialFeaturePlacements.DISK_MARS_SAND);
        addMarsOres(biomeBuilder);

        generalMonsters(spawnBuilder, 100, 100, 0);
        spawnBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityRegistry.RUST_SLIME.get(), 100, 4, 4))
                .addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityRegistry.MARS_MALLOW.get(), 40, 4, 4))
                .addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityRegistry.GUST.get(), 100, 4, 4))
                .addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityRegistry.ROVER.get(), 40, 1, 1))
                .addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityRegistry.DRONE.get(), 30, 1, 2))
                .build();


        return CelestialBiomes.biome(Biome.Precipitation.NONE, Biome.BiomeCategory.NONE, prettyCold, 0F, celestialBody.MARS.skyColor, celestialBody.MARS.skyFogColor, celestialBody.MARS.waterColor, celestialBody.MARS.waterFogColor, spawnBuilder, biomeBuilder, NORMAL_MUSIC);
    }

    public static Biome flats(boolean dryIcy) {
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();
        BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder();

        CelestialBiomes.addCarversAndLakes(biomeBuilder);
        biomeBuilder.addFeature(GenerationStep.Decoration.LAKES, CelestialFeaturePlacements.MARS_LAVA_LAKE_UNDERGROUND);

        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, CelestialFeaturePlacements.DISK_MARS_SAND);
        addMarsOres(biomeBuilder);

        generalMonsters(spawnBuilder, 100, 80, 0);
        spawnBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityRegistry.RUST_SLIME.get(), 120, 4, 4))
                .addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityRegistry.MARS_MALLOW.get(), 80, 4, 4))
                .addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityRegistry.GUST.get(), 100, 4, 4))
                .addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityRegistry.ROVER.get(), 40, 1, 1))
                .addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityRegistry.DRONE.get(), 30, 1, 2))
                .build();


        float temperature = dryIcy ? -1.0F : -0.75F;

        return CelestialBiomes.biome(Biome.Precipitation.NONE, Biome.BiomeCategory.NONE, temperature, 0F, celestialBody.MARS.skyColor, celestialBody.MARS.skyFogColor, celestialBody.MARS.waterColor, celestialBody.MARS.waterFogColor, spawnBuilder, biomeBuilder, NORMAL_MUSIC);
    }

    public static Biome dunes() {
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();
        BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder();

        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, CelestialFeaturePlacements.DISK_MARS_SAND);
        addMarsOres(biomeBuilder);

        generalMonsters(spawnBuilder, 80, 100, 0);

        spawnBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityRegistry.RUST_SLIME.get(), 30, 4, 4))
                .addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityRegistry.MARS_MALLOW.get(), 10, 4, 4))
                .addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityRegistry.GUST.get(), 100, 4, 4))
                .addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityRegistry.ROVER.get(), 40, 1, 1))
                .addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityRegistry.DRONE.get(), 30, 1, 2))
                .build();

        float temp = -0.75F;

        return CelestialBiomes.biome(Biome.Precipitation.NONE, Biome.BiomeCategory.NONE, prettyCold, 0F, celestialBody.MARS.skyColor, celestialBody.MARS.skyFogColor, celestialBody.MARS.waterColor, celestialBody.MARS.waterFogColor, spawnBuilder, biomeBuilder, NORMAL_MUSIC);
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