package com.shim.celestialexploration.world.biome.builder;

import com.shim.celestialexploration.world.biome.CelestialBiomeKeys;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Climate;

public class GanymedeBiomeBuilder extends AbstractBiomeBuilder {

    private final ResourceKey<Biome>[][] OCEANS = new ResourceKey[][]{
            {CelestialBiomeKeys.GANYMEDE_LOWER_PLAINS, CelestialBiomeKeys.GANYMEDE_LOWER_PLAINS, CelestialBiomeKeys.GANYMEDE_LOWER_PLAINS, CelestialBiomeKeys.GANYMEDE_LOWER_PLAINS, CelestialBiomeKeys.GANYMEDE_LOWER_PLAINS},
            {CelestialBiomeKeys.GANYMEDE_LOWER_PLAINS, CelestialBiomeKeys.GANYMEDE_LOWER_PLAINS, CelestialBiomeKeys.GANYMEDE_LOWER_PLAINS, CelestialBiomeKeys.GANYMEDE_LOWER_PLAINS, CelestialBiomeKeys.GANYMEDE_LOWER_PLAINS}};
    private final ResourceKey<Biome>[][] MIDDLE_BIOMES = new ResourceKey[][]{
            {CelestialBiomeKeys.GANYMEDE_PLAINS, CelestialBiomeKeys.GANYMEDE_PLAINS, CelestialBiomeKeys.GANYMEDE_PLAINS, CelestialBiomeKeys.GANYMEDE_PLAINS, CelestialBiomeKeys.GANYMEDE_CRATERED_PLAINS},
            {CelestialBiomeKeys.GANYMEDE_PLAINS, CelestialBiomeKeys.GANYMEDE_PLAINS, CelestialBiomeKeys.GANYMEDE_CRATERED_PLAINS, CelestialBiomeKeys.GANYMEDE_PLAINS, CelestialBiomeKeys.GANYMEDE_CRATERED_PLAINS},
            {CelestialBiomeKeys.GANYMEDE_PLAINS, CelestialBiomeKeys.GANYMEDE_CRATERED_PLAINS, CelestialBiomeKeys.GANYMEDE_CRATERED_PLAINS, CelestialBiomeKeys.GANYMEDE_PLAINS, CelestialBiomeKeys.GANYMEDE_CRATERED_PLAINS},
            {CelestialBiomeKeys.GANYMEDE_CRATERED_PLAINS, CelestialBiomeKeys.GANYMEDE_CRATERED_PLAINS, CelestialBiomeKeys.GANYMEDE_CRATERED_PLAINS, CelestialBiomeKeys.GANYMEDE_CRATERED_PLAINS, CelestialBiomeKeys.GANYMEDE_CRATERED_PLAINS},
            {CelestialBiomeKeys.GANYMEDE_DESERT, CelestialBiomeKeys.GANYMEDE_DESERT, CelestialBiomeKeys.GANYMEDE_DESERT, CelestialBiomeKeys.GANYMEDE_DESERT, CelestialBiomeKeys.GANYMEDE_DESERT}};
    private final ResourceKey<Biome>[][] MIDDLE_BIOMES_VARIANT = new ResourceKey[][]{
            {null, null, CelestialBiomeKeys.GANYMEDE_CRATERED_PLAINS, CelestialBiomeKeys.GANYMEDE_CRATERED_PLAINS, CelestialBiomeKeys.GANYMEDE_PLAINS},
            {null, CelestialBiomeKeys.GANYMEDE_CRATERED_PLAINS, CelestialBiomeKeys.GANYMEDE_PLAINS, CelestialBiomeKeys.GANYMEDE_CRATERED_PLAINS, CelestialBiomeKeys.GANYMEDE_PLAINS},
            {CelestialBiomeKeys.GANYMEDE_CRATERED_PLAINS, CelestialBiomeKeys.GANYMEDE_PLAINS, CelestialBiomeKeys.GANYMEDE_PLAINS, CelestialBiomeKeys.GANYMEDE_CRATERED_PLAINS, CelestialBiomeKeys.GANYMEDE_CRATERED_PLAINS},
            {CelestialBiomeKeys.GANYMEDE_PLAINS, CelestialBiomeKeys.GANYMEDE_PLAINS, CelestialBiomeKeys.GANYMEDE_PLAINS, null, null},
            {CelestialBiomeKeys.GANYMEDE_DESERT, null, null, null, CelestialBiomeKeys.GANYMEDE_DESERT}};
    private final ResourceKey<Biome>[][] PLATEAU_BIOMES = new ResourceKey[][]{
            {CelestialBiomeKeys.GANYMEDE_PLAINS, CelestialBiomeKeys.GANYMEDE_PLAINS, CelestialBiomeKeys.GANYMEDE_PLAINS, CelestialBiomeKeys.GANYMEDE_PLAINS, CelestialBiomeKeys.GANYMEDE_PLAINS},
            {CelestialBiomeKeys.GANYMEDE_PLAINS, CelestialBiomeKeys.GANYMEDE_PLAINS, CelestialBiomeKeys.GANYMEDE_PLAINS, CelestialBiomeKeys.GANYMEDE_PLAINS, CelestialBiomeKeys.GANYMEDE_DESERT},
            {CelestialBiomeKeys.GANYMEDE_PLAINS, CelestialBiomeKeys.GANYMEDE_PLAINS, CelestialBiomeKeys.GANYMEDE_PLAINS, CelestialBiomeKeys.GANYMEDE_DESERT, CelestialBiomeKeys.GANYMEDE_DESERT},
            {CelestialBiomeKeys.GANYMEDE_PLAINS, CelestialBiomeKeys.GANYMEDE_PLAINS, CelestialBiomeKeys.GANYMEDE_DESERT, CelestialBiomeKeys.GANYMEDE_DESERT, CelestialBiomeKeys.GANYMEDE_DESERT},
            {CelestialBiomeKeys.GANYMEDE_DESERT, CelestialBiomeKeys.GANYMEDE_DESERT, CelestialBiomeKeys.GANYMEDE_DESERT, CelestialBiomeKeys.GANYMEDE_DESERT, CelestialBiomeKeys.GANYMEDE_DESERT}};
    private final ResourceKey<Biome>[][] PLATEAU_BIOMES_VARIANT = new ResourceKey[][]{
            {null, CelestialBiomeKeys.GANYMEDE_CRATERED_PLAINS, null, null, null},
            {null, null, null, CelestialBiomeKeys.GANYMEDE_CRATERED_PLAINS, null},
            {null, CelestialBiomeKeys.GANYMEDE_CRATERED_PLAINS, null, null, null},
            {CelestialBiomeKeys.GANYMEDE_CRATERED_PLAINS, null, null, null, null},
            {null, null, null, CelestialBiomeKeys.GANYMEDE_DESERT, null}};
    private final ResourceKey<Biome>[][] SHATTERED_BIOMES = new ResourceKey[][]{
            {null, null, null, null, null},
            {null, null, null, null, null},
            {CelestialBiomeKeys.GANYMEDE_DESERT, CelestialBiomeKeys.GANYMEDE_DESERT, CelestialBiomeKeys.GANYMEDE_DESERT, CelestialBiomeKeys.GANYMEDE_DESERT, CelestialBiomeKeys.GANYMEDE_DESERT},
            {CelestialBiomeKeys.GANYMEDE_DESERT, CelestialBiomeKeys.GANYMEDE_DESERT, CelestialBiomeKeys.GANYMEDE_DESERT, CelestialBiomeKeys.GANYMEDE_DESERT, CelestialBiomeKeys.GANYMEDE_DESERT},
            {null, null, null, null, null}};


    @Override
    protected ResourceKey<Biome>[][] getOceans() {
        return this.OCEANS;
    }

    @Override
    protected ResourceKey<Biome>[][] getMiddleBiomes() {
        return this.MIDDLE_BIOMES;
    }

    @Override
    protected ResourceKey<Biome>[][] getMiddleBiomeVariants() {
        return this.MIDDLE_BIOMES_VARIANT;
    }

    @Override
    protected ResourceKey<Biome>[][] getPlateauBiomes() {
        return this.PLATEAU_BIOMES;
    }

    @Override
    protected ResourceKey<Biome>[][] getPlateauBiomeVariants() {
        return this.PLATEAU_BIOMES_VARIANT;
    }

    @Override
    protected ResourceKey<Biome>[][] getShatteredBiomes() {
        return this.SHATTERED_BIOMES;
    }

    @Override
    protected ResourceKey<Biome> getValleyBiome() {
        return CelestialBiomeKeys.GANYMEDE_DESERT;
    }

    @Override
    protected ResourceKey<Biome> pickBeachBiome(int temp, int humidity) {
        return CelestialBiomeKeys.GANYMEDE_DESERT;
    }

    @Override
    protected ResourceKey<Biome> pickPeakBiome(int temp, int humidity, Climate.Parameter p_187243_) {
        return CelestialBiomeKeys.GANYMEDE_DESERT;
    }
}