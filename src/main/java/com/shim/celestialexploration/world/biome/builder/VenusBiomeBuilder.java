package com.shim.celestialexploration.world.biome.builder;

import com.mojang.datafixers.util.Pair;
import com.shim.celestialexploration.world.biome.CelestialBiomeKeys;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Climate;
import net.minecraft.world.level.biome.TerrainShaper;

import java.util.List;
import java.util.Random;
import java.util.function.Consumer;

public class VenusBiomeBuilder extends AbstractBiomeBuilder {
    private final ResourceKey<Biome>[][] OCEANS = new ResourceKey[][]{
            {CelestialBiomeKeys.SULFUR_OCEAN, CelestialBiomeKeys.SULFUR_OCEAN, CelestialBiomeKeys.SULFUR_OCEAN, CelestialBiomeKeys.SULFUR_OCEAN, CelestialBiomeKeys.SULFUR_OCEAN},
            {CelestialBiomeKeys.SULFUR_OCEAN, CelestialBiomeKeys.SULFUR_OCEAN, CelestialBiomeKeys.SULFUR_OCEAN, CelestialBiomeKeys.SULFUR_OCEAN, CelestialBiomeKeys.SULFUR_OCEAN}};
    private final ResourceKey<Biome>[][] MIDDLE_BIOMES = new ResourceKey[][]{
            {CelestialBiomeKeys.VENUS_LOWER_PLAINS, CelestialBiomeKeys.VENUS_LOWER_PLAINS, CelestialBiomeKeys.VENUS_LOWER_PLAINS, CelestialBiomeKeys.VENUS_LOWER_PLAINS, CelestialBiomeKeys.VENUS_LOWER_PLAINS},
            {CelestialBiomeKeys.VENUS_LOWER_PLAINS, CelestialBiomeKeys.VENUS_LOWER_PLAINS, CelestialBiomeKeys.VENUS_LOWER_PLAINS, CelestialBiomeKeys.VENUS_LOWER_PLAINS, CelestialBiomeKeys.VENUS_LOWER_PLAINS},
            {CelestialBiomeKeys.VENUS_LOWER_PLAINS, CelestialBiomeKeys.VENUS_LOWER_PLAINS, CelestialBiomeKeys.VENUS_LOWER_PLAINS, CelestialBiomeKeys.VENUS_LOWER_PLAINS, CelestialBiomeKeys.VENUS_DESERT},
            {CelestialBiomeKeys.VENUS_LOWER_PLAINS, CelestialBiomeKeys.VENUS_LOWER_PLAINS, CelestialBiomeKeys.VENUS_LOWER_PLAINS, CelestialBiomeKeys.VENUS_DESERT, CelestialBiomeKeys.VENUS_DESERT},
            {CelestialBiomeKeys.VENUS_DESERT, CelestialBiomeKeys.VENUS_DESERT, CelestialBiomeKeys.VENUS_DESERT, CelestialBiomeKeys.VENUS_DESERT, CelestialBiomeKeys.VENUS_DESERT}};
    private final ResourceKey<Biome>[][] MIDDLE_BIOMES_VARIANT = new ResourceKey[][]{
            {null, CelestialBiomeKeys.VENUS_PLAINS, CelestialBiomeKeys.VENUS_PLAINS, CelestialBiomeKeys.VENUS_PLAINS, CelestialBiomeKeys.VENUS_SULFUR_FLATS},
            {null, null, null, CelestialBiomeKeys.VENUS_PLAINS, null},
            {CelestialBiomeKeys.VENUS_PLAINS, null, CelestialBiomeKeys.VENUS_PLAINS, CelestialBiomeKeys.VENUS_PLAINS, CelestialBiomeKeys.VENUS_SULFUR_FLATS},
            {null, null, CelestialBiomeKeys.VENUS_PLAINS, CelestialBiomeKeys.VENUS_PLAINS, CelestialBiomeKeys.VENUS_SULFUR_FLATS},
            {CelestialBiomeKeys.VENUS_PLAINS, null, CelestialBiomeKeys.VENUS_SULFUR_FLATS, CelestialBiomeKeys.VENUS_SULFUR_FLATS, CelestialBiomeKeys.VENUS_SULFUR_FLATS}};
    private final ResourceKey<Biome>[][] PLATEAU_BIOMES = new ResourceKey[][]{
            {CelestialBiomeKeys.VENUS_PLAINS, CelestialBiomeKeys.VENUS_PLAINS, CelestialBiomeKeys.VENUS_PLAINS, CelestialBiomeKeys.VENUS_PLAINS, CelestialBiomeKeys.VENUS_PLAINS},
            {CelestialBiomeKeys.VENUS_PLAINS, CelestialBiomeKeys.VENUS_PLAINS, CelestialBiomeKeys.VENUS_PLAINS, CelestialBiomeKeys.VENUS_PLAINS, CelestialBiomeKeys.VENUS_DESERT},
            {CelestialBiomeKeys.VENUS_PLAINS, CelestialBiomeKeys.VENUS_PLAINS, CelestialBiomeKeys.VENUS_PLAINS, CelestialBiomeKeys.VENUS_DESERT, CelestialBiomeKeys.VENUS_DESERT},
            {CelestialBiomeKeys.VENUS_PLAINS, CelestialBiomeKeys.VENUS_PLAINS, CelestialBiomeKeys.VENUS_DESERT, CelestialBiomeKeys.VENUS_DESERT, CelestialBiomeKeys.VENUS_DESERT},
            {CelestialBiomeKeys.VENUS_DESERT, CelestialBiomeKeys.VENUS_DESERT, CelestialBiomeKeys.VENUS_DESERT, CelestialBiomeKeys.VENUS_DESERT, CelestialBiomeKeys.VENUS_DESERT}};
    private final ResourceKey<Biome>[][] PLATEAU_BIOMES_VARIANT = new ResourceKey[][]{
            {null, CelestialBiomeKeys.VENUS_SULFUR_FLATS, null, null, null},
            {null, null, null, CelestialBiomeKeys.VENUS_SULFUR_FLATS, null},
            {null, CelestialBiomeKeys.VENUS_SULFUR_FLATS, null, null, null},
            {CelestialBiomeKeys.VENUS_SULFUR_FLATS, null, null, null, null},
            {null, null, null, CelestialBiomeKeys.VENUS_DESERT, null}};
    private final ResourceKey<Biome>[][] SHATTERED_BIOMES = new ResourceKey[][]{
            {null, null, null, null, null},
            {null, null, null, null, null},
            {CelestialBiomeKeys.VENUS_DESERT, CelestialBiomeKeys.VENUS_DESERT, CelestialBiomeKeys.VENUS_DESERT, CelestialBiomeKeys.VENUS_DESERT, CelestialBiomeKeys.VENUS_DESERT},
            {CelestialBiomeKeys.VENUS_DESERT, CelestialBiomeKeys.VENUS_DESERT, CelestialBiomeKeys.VENUS_DESERT, CelestialBiomeKeys.VENUS_DESERT, CelestialBiomeKeys.VENUS_DESERT},
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
        return CelestialBiomeKeys.SULFUR_RIVER;
    }

    @Override
    protected ResourceKey<Biome> pickBeachBiome(int temp, int humidity) {
        return CelestialBiomeKeys.VENUS_DESERT;
    }

    @Override
    protected ResourceKey<Biome> pickPeakBiome(int temp, int humidity, Climate.Parameter p_187243_) {
        return CelestialBiomeKeys.VENUS_DESERT;
    }
}

