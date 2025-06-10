package com.shim.celestialexploration.world.biome;

import com.shim.celestialexploration.registry.CelestialEntities;
import net.minecraft.data.worldgen.Carvers;
import net.minecraft.sounds.Music;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.*;
import net.minecraft.world.level.levelgen.GenerationStep;

import javax.annotation.Nullable;

public class CelestialBiomes {

    @Nullable
    protected static final Music NORMAL_MUSIC = null;
    protected static float prettyCold = -0.75F;

    protected static int calculateSkyColor(float p_194844_) {
        float $$1 = p_194844_ / 3.0F;
        $$1 = Mth.clamp($$1, -1.0F, 1.0F);
        return Mth.hsvToRgb(0.62222224F - $$1 * 0.05F, 0.5F + $$1 * 0.1F, 1.0F);
    }

    protected static Biome biome(Biome.Precipitation precipitation, Biome.BiomeCategory category, float temperature, float downfall, int waterColor, int waterFogColor, MobSpawnSettings.Builder spawnBuilder, BiomeGenerationSettings.Builder biomeBuilder, @Nullable Music music) {
        return (new Biome.BiomeBuilder()).precipitation(precipitation).biomeCategory(category).temperature(temperature).downfall(downfall)
                .specialEffects((new BiomeSpecialEffects.Builder()).waterColor(waterColor).waterFogColor(waterFogColor).fogColor(12638463).skyColor(calculateSkyColor(temperature))
                        .ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS).backgroundMusic(music).build()).mobSpawnSettings(spawnBuilder.build()).generationSettings(biomeBuilder.build()).build();
    }

    protected static Biome biome(Biome.Precipitation precipitation, Biome.BiomeCategory category, float temperature, float downfall,
                               int skyColor, int fogColor, int waterColor, int waterFogColor,
                               MobSpawnSettings.Builder spawnBuilder, BiomeGenerationSettings.Builder biomeBuilder, @Nullable Music music) {
        return (new Biome.BiomeBuilder()).precipitation(precipitation).biomeCategory(category).temperature(temperature).downfall(downfall)
                .specialEffects((new BiomeSpecialEffects.Builder()).waterColor(waterColor).waterFogColor(waterFogColor).fogColor(fogColor).skyColor(skyColor)
                        .ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS).backgroundMusic(music).build()).mobSpawnSettings(spawnBuilder.build()).generationSettings(biomeBuilder.build()).build();
    }

    protected static Biome biome(Biome.Precipitation precipitation, Biome.BiomeCategory category, float temperature, float downfall,
                                 int skyColor, int fogColor, int waterColor, int waterFogColor,
                                 MobSpawnSettings.Builder spawnBuilder, BiomeGenerationSettings.Builder biomeBuilder, @Nullable Music music, AmbientParticleSettings particle) {
        return (new Biome.BiomeBuilder()).precipitation(precipitation).biomeCategory(category).temperature(temperature).downfall(downfall)
                .specialEffects((new BiomeSpecialEffects.Builder()).waterColor(waterColor).waterFogColor(waterFogColor).fogColor(fogColor).skyColor(skyColor).ambientParticle(particle)
                        .ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS).backgroundMusic(music).build()).mobSpawnSettings(spawnBuilder.build()).generationSettings(biomeBuilder.build()).build();
    }

    public static Biome space() {
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();
        BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder();

        spawnBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(CelestialEntities.VOIDFELLOW.get(), 30, 0, 1))
                .addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(CelestialEntities.LURKER.get(), 5, 0, 1)).build();

        return biome(Biome.Precipitation.NONE, Biome.BiomeCategory.NONE, prettyCold, 0, celestialBody.SPACE.skyColor, celestialBody.SPACE.skyFogColor, celestialBody.SPACE.waterColor, celestialBody.SPACE.waterFogColor, spawnBuilder, biomeBuilder, NORMAL_MUSIC);
    }

    protected static void generalMonsters(MobSpawnSettings.Builder spawnBuilder, int voidedCount, int skeletonCount, int lurkerCount) {
        spawnBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(CelestialEntities.VOIDED.get(), voidedCount, 4, 4));
        spawnBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SKELETON, skeletonCount, 4, 4));
        spawnBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(CelestialEntities.LURKER.get(), lurkerCount, 4, 4));
        spawnBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(CelestialEntities.VOIDFELLOW.get(), 10, 1, 4));
    }

    public static void addCarversAndLakes(BiomeGenerationSettings.Builder biomeBuilder) {
        biomeBuilder.addCarver(GenerationStep.Carving.AIR, Carvers.CAVE);
        biomeBuilder.addCarver(GenerationStep.Carving.AIR, Carvers.CAVE_EXTRA_UNDERGROUND);
        biomeBuilder.addCarver(GenerationStep.Carving.AIR, Carvers.CANYON);
    }

    public enum celestialBody {
        SPACE(0, 0, 90, 329011), //0, 0
        MARS(15565857, 14591603, 335425, 3150848),
        MOON(1807, 1549, 335425, 69408),
        VENUS(14200929, 10715456, 4741209, 3160378),
        MERCURY(1807, 1549, 335425, 69408),
        JUPITER(12814693, 9985854, 10914167, 8546133),
        IO(1807, 4144438, 1776152, 1052687);

        final int skyColor;
        final int skyFogColor;
        final int waterColor;
        final int waterFogColor;

        celestialBody(int skyColor, int skyFogColor, int waterColor, int waterFogColor) {
            this.skyColor = skyColor;
            this.skyFogColor = skyFogColor;
            this.waterColor = waterColor;
            this.waterFogColor = waterFogColor;
        }
    }
}