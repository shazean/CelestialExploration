package com.shim.celestialexploration.world.biome;

import com.shim.celestialexploration.registry.EntityRegistry;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.AmbientParticleSettings;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.MobSpawnSettings;

public class JupiterBiomes extends CelestialBiomes {

    public static Biome ether() {
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();
        BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder();

//        biomeBuilder.addFeature(GenerationStep.Decoration.TOP_LAYER_MODIFICATION, CelestialFeaturePlacements.JUPITER_CLOUD);


        generalMonsters(spawnBuilder, 0, 100, 100);
        spawnBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityRegistry.GYST.get(), 30, 1, 1))
                .addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityRegistry.DRONE.get(), 30, 1, 2))
                .build();

        return CelestialBiomes.biome(Biome.Precipitation.NONE, Biome.BiomeCategory.NONE, prettyCold, 0F, celestialBody.JUPITER.skyColor, celestialBody.JUPITER.skyFogColor,
                celestialBody.JUPITER.waterColor, celestialBody.JUPITER.waterFogColor, spawnBuilder, biomeBuilder, NORMAL_MUSIC, new AmbientParticleSettings(ParticleTypes.CLOUD, 0.000625F));
    }
}