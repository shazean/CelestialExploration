package com.shim.celestialexploration.world.biome;

import com.shim.celestialexploration.registry.EntityRegistry;
import com.shim.celestialexploration.world.features.placement.CelestialFeaturePlacements;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.levelgen.GenerationStep;

public class JupiterBiomes extends CelestialBiomes {

    public static Biome desert() {
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();
        BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder();

        generalMonsters(spawnBuilder, 100, 100, 100);

        return CelestialBiomes.biome(Biome.Precipitation.NONE, Biome.BiomeCategory.NONE, -0.75F, 0F, celestialBody.JUPITER.skyColor, celestialBody.JUPITER.skyFogColor, celestialBody.JUPITER.waterColor, celestialBody.JUPITER.waterFogColor, spawnBuilder, biomeBuilder, NORMAL_MUSIC);
    }

    public static Biome craters() {
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();
        BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder();

        generalMonsters(spawnBuilder, 100, 100, 100);

        return CelestialBiomes.biome(Biome.Precipitation.NONE, Biome.BiomeCategory.NONE, -0.75F, 0F, celestialBody.JUPITER.skyColor, celestialBody.JUPITER.skyFogColor, celestialBody.JUPITER.waterColor, celestialBody.JUPITER.waterFogColor, spawnBuilder, biomeBuilder, NORMAL_MUSIC);
    }
}