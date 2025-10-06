package com.shim.celestialexploration.world.biome;

import com.shim.celestialexploration.registry.CelestialEntities;
import com.shim.celestialexploration.world.features.placement.CelestialFeaturePlacements;
import net.minecraft.sounds.Music;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.*;
import net.minecraft.world.level.levelgen.GenerationStep;

import javax.annotation.Nullable;

public class IoBiomes extends CelestialBiomeFeatures {

    public static Biome desert() {
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();
        BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder();

        CelestialBiomeFeatures.addCarversAndLakes(biomeBuilder);


        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, CelestialFeaturePlacements.DISK_IO_SAND);
        addIoOres(biomeBuilder);

        generalNoCaveMonsters(spawnBuilder, 50, 50, 50);
        spawnBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(CelestialEntities.LUNAR_SLIME.get(), 100, 4, 4)).build();

        return io(Biome.Precipitation.NONE,-0.75F, 0F, spawnBuilder, biomeBuilder);
    }


    public static Biome lavaFlats() {
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();
        BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder();



        CelestialBiomeFeatures.addCarversAndLakes(biomeBuilder);

//        biomeBuilder.addFeature(GenerationStep.Decoration.LAKES, CelestialFeaturePlacements.OBSIDIAN_LAKE);
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, CelestialFeaturePlacements.DISK_IO_SAND);
        addIoOres(biomeBuilder);

        generalNoCaveMonsters(spawnBuilder, 50, 50, 50);
        spawnBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(CelestialEntities.LUNAR_SLIME.get(), 120, 4, 4)).build();


        return io(Biome.Precipitation.NONE, -0.75F, 0F,spawnBuilder, biomeBuilder);
    }

    public static Biome plains() {
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();
        BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder();

        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, CelestialFeaturePlacements.DISK_IO_SAND);
        addIoOres(biomeBuilder);

        generalNoCaveMonsters(spawnBuilder, 50, 50, 50);
        spawnBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(CelestialEntities.LUNAR_SLIME.get(), 30, 4, 4)).build();

        spawnBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(CelestialEntities.SULFUR_CUBE.get(), 120, 4, 4))
                .addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(CelestialEntities.VOIDED_PIGLIN.get(), 100, 4, 4))
                .addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(CelestialEntities.CYBORG_PIGLIN.get(), 50, 4, 4))
                .addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(CelestialEntities.ASTRAL_PIGLIN.get(), 15, 4, 4))
                .addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(CelestialEntities.ASTRAL_HOGLIN.get(), 9, 3, 4)).build();


        return io(Biome.Precipitation.NONE, -0.75F, 0F, spawnBuilder, biomeBuilder);
    }

    protected static Biome io(Biome.Precipitation precipitation, float temperature, float downfall, MobSpawnSettings.Builder spawnBuilder, BiomeGenerationSettings.Builder biomeBuilder) {
        return (new Biome.BiomeBuilder()).precipitation(precipitation).biomeCategory(Biome.BiomeCategory.NONE).temperature(temperature).downfall(downfall)
                .specialEffects((new BiomeSpecialEffects.Builder()).waterColor(CelestialBody.IO.waterColor).waterFogColor(CelestialBody.IO.waterFogColor).fogColor(CelestialBody.IO.skyFogColor)
                        .skyColor(CelestialBody.IO.skyColor).grassColorOverride(CelestialBody.IO.grassFoliageColor).foliageColorOverride(CelestialBody.IO.grassFoliageColor)
                        .ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS).backgroundMusic(NORMAL_MUSIC).build()).mobSpawnSettings(spawnBuilder.build()).generationSettings(biomeBuilder.build()).build();
    }

    public static void addIoOres(BiomeGenerationSettings.Builder biomeBuilder) {
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, CelestialFeaturePlacements.IO_IRON_ORE_UPPER);
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, CelestialFeaturePlacements.IO_IRON_ORE_MIDDLE);
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, CelestialFeaturePlacements.IO_IRON_ORE_SMALL);
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, CelestialFeaturePlacements.IO_LAPIS_ORE);
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, CelestialFeaturePlacements.IO_LAPIS_ORE_BURIED);
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, CelestialFeaturePlacements.IO_SULFUR_ORE);
    }
}