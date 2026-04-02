package com.shim.celestialexploration.world.biome;

import com.shim.celestialexploration.registry.CelestialEntities;
import com.shim.celestiallib.api.world.biome.CLibBiomeFeatures;
import net.minecraft.sounds.Music;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.*;

import javax.annotation.Nullable;

public class CelestialBiomeFeatures extends CLibBiomeFeatures {

    protected static float prettyCold = -0.75F;

    public static Biome space() {
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();
        BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder();

        spawnBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(CelestialEntities.VOIDFELLOW.get(), 30, 0, 1))
                .addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(CelestialEntities.LURKER.get(), 5, 0, 1)).build();

        return biome(Biome.Precipitation.NONE, Biome.BiomeCategory.NONE, prettyCold, 0, CelestialBody.SPACE.skyColor, CelestialBody.SPACE.skyFogColor, CelestialBody.SPACE.waterColor, CelestialBody.SPACE.waterFogColor, spawnBuilder, biomeBuilder, NORMAL_MUSIC);
    }

    protected static void generalMonsters(MobSpawnSettings.Builder spawnBuilder, int voidedWeight, int skeletonWeight, int lurkerWeight) {
        generalMonsters(spawnBuilder, voidedWeight, 4, 4, skeletonWeight, 4, 4, lurkerWeight, 4, 4);
    }

    protected static void generalNoCaveMonsters(MobSpawnSettings.Builder spawnBuilder, int voidedWeight, int skeletonWeight, int lurkerWeight) {
        generalMonsters(spawnBuilder, voidedWeight, 0, 2, skeletonWeight, 0, 2, lurkerWeight, 0, 1);
    }

    protected static void generalMonsters(MobSpawnSettings.Builder spawnBuilder, int voidedWeight, int minVoided, int maxVoided, int skeletonWeight, int minSkeletons, int maxSkeletons, int lurkerWeight, int minLurkers, int maxLurkers) {
        spawnBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(CelestialEntities.VOIDED.get(), voidedWeight, minVoided, maxVoided));
        spawnBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SKELETON, skeletonWeight, minSkeletons, maxSkeletons));
        spawnBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(CelestialEntities.LURKER.get(), lurkerWeight, minLurkers, maxLurkers));
        spawnBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(CelestialEntities.VOIDFELLOW.get(), 10, 1, 4));
    }

    public enum CelestialBody {
        SPACE(0, 0, 90, 329011, 4738363),
        MARS(15565857, 14591603, 335425, 3150848, 6571041),
        MOON(1807, 1549, 335425, 69408, 4738363),
        VENUS(14200929, 10715456, 4741209, 3160378, 5917209),
        MERCURY(1807, 1549, 335425, 69408, 5327408),
        JUPITER(12814693, 9985854, 10914167, 8546133, 6243872),
        IO(1807, 4144438, 1776152, 1052687, 4740617);

        final int skyColor;
        final int skyFogColor;
        final int waterColor;
        final int waterFogColor;
        final int grassFoliageColor;

        CelestialBody(int skyColor, int skyFogColor, int waterColor, int waterFogColor, int grassFoliageColor) {
            this.skyColor = skyColor;
            this.skyFogColor = skyFogColor;
            this.waterColor = waterColor;
            this.waterFogColor = waterFogColor;
            this.grassFoliageColor = grassFoliageColor;
        }
    }
}