package com.shim.celestialexploration.world.biome;

import com.shim.celestialexploration.registry.CelestialEntities;
import com.shim.celestiallib.api.world.biome.CLibBiomeFeatures;
import net.minecraft.data.worldgen.Carvers;
import net.minecraft.sounds.Music;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.*;
import net.minecraft.world.level.levelgen.GenerationStep;

import javax.annotation.Nullable;

public class CelestialBiomes extends CLibBiomeFeatures {

    protected static float prettyCold = -0.75F;

    public static Biome space() {
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();
        BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder();

        spawnBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(CelestialEntities.VOIDFELLOW.get(), 30, 0, 1))
                .addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(CelestialEntities.LURKER.get(), 5, 0, 1)).build();

        return biome(Biome.Precipitation.NONE, Biome.BiomeCategory.NONE, prettyCold, 0, CelestialBody.SPACE.skyColor, CelestialBody.SPACE.skyFogColor, CelestialBody.SPACE.waterColor, CelestialBody.SPACE.waterFogColor, spawnBuilder, biomeBuilder, NORMAL_MUSIC);
    }

    protected static void generalMonsters(MobSpawnSettings.Builder spawnBuilder, int voidedCount, int skeletonCount, int lurkerCount) {
        spawnBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(CelestialEntities.VOIDED.get(), voidedCount, 4, 4));
        spawnBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SKELETON, skeletonCount, 4, 4));
        spawnBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(CelestialEntities.LURKER.get(), lurkerCount, 4, 4));
        spawnBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(CelestialEntities.VOIDFELLOW.get(), 10, 1, 4));
    }

    public enum CelestialBody {
        SPACE(0, 0, 90, 329011),
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

        CelestialBody(int skyColor, int skyFogColor, int waterColor, int waterFogColor) {
            this.skyColor = skyColor;
            this.skyFogColor = skyFogColor;
            this.waterColor = waterColor;
            this.waterFogColor = waterFogColor;
        }
    }
}