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

public class IoBiomeBuilder extends AbstractBiomeBuilder {
    private final ResourceKey<Biome>[][] OCEANS = new ResourceKey[][]{
            {CelestialBiomeKeys.IO_LOWER_PLAINS, CelestialBiomeKeys.IO_LOWER_PLAINS, CelestialBiomeKeys.IO_LOWER_PLAINS, CelestialBiomeKeys.IO_LOWER_PLAINS, CelestialBiomeKeys.IO_LOWER_PLAINS},
            {CelestialBiomeKeys.IO_LOWER_PLAINS, CelestialBiomeKeys.IO_LOWER_PLAINS, CelestialBiomeKeys.IO_LOWER_PLAINS, CelestialBiomeKeys.IO_LOWER_PLAINS, CelestialBiomeKeys.IO_LOWER_PLAINS}};
    private final ResourceKey<Biome>[][] MIDDLE_BIOMES = new ResourceKey[][]{
            {CelestialBiomeKeys.IO_PLAINS, CelestialBiomeKeys.IO_PLAINS, CelestialBiomeKeys.IO_PLAINS, CelestialBiomeKeys.IO_PLAINS, CelestialBiomeKeys.IO_SULFUR_FLATS},
            {CelestialBiomeKeys.IO_PLAINS, CelestialBiomeKeys.IO_PLAINS, CelestialBiomeKeys.IO_PLAINS, CelestialBiomeKeys.IO_PLAINS, CelestialBiomeKeys.IO_SULFUR_FLATS},
            {CelestialBiomeKeys.IO_PLAINS, CelestialBiomeKeys.IO_PLAINS, CelestialBiomeKeys.IO_PLAINS, CelestialBiomeKeys.IO_PLAINS, CelestialBiomeKeys.IO_SULFUR_FLATS},
            {CelestialBiomeKeys.IO_PLAINS, CelestialBiomeKeys.IO_PLAINS, CelestialBiomeKeys.IO_PLAINS, CelestialBiomeKeys.IO_SULFUR_FLATS, CelestialBiomeKeys.IO_SULFUR_FLATS},
            {CelestialBiomeKeys.IO_DESERT, CelestialBiomeKeys.IO_DESERT, CelestialBiomeKeys.IO_DESERT, CelestialBiomeKeys.IO_DESERT, CelestialBiomeKeys.IO_DESERT}};
    private final ResourceKey<Biome>[][] MIDDLE_BIOMES_VARIANT = new ResourceKey[][]{
            {null, null, CelestialBiomeKeys.IO_PLAINS, CelestialBiomeKeys.IO_PLAINS, CelestialBiomeKeys.IO_PLAINS},
            {null, CelestialBiomeKeys.IO_PLAINS, CelestialBiomeKeys.IO_PLAINS, CelestialBiomeKeys.IO_PLAINS, CelestialBiomeKeys.IO_PLAINS},
            {CelestialBiomeKeys.IO_PLAINS, CelestialBiomeKeys.IO_PLAINS, CelestialBiomeKeys.IO_PLAINS, CelestialBiomeKeys.IO_PLAINS, CelestialBiomeKeys.IO_PLAINS},
            {CelestialBiomeKeys.IO_PLAINS, CelestialBiomeKeys.IO_PLAINS, CelestialBiomeKeys.IO_PLAINS, null, null},
            {CelestialBiomeKeys.IO_DESERT, null, null, null, CelestialBiomeKeys.IO_DESERT}};
    private final ResourceKey<Biome>[][] PLATEAU_BIOMES = new ResourceKey[][]{
            {CelestialBiomeKeys.IO_PLAINS, CelestialBiomeKeys.IO_PLAINS, CelestialBiomeKeys.IO_PLAINS, CelestialBiomeKeys.IO_PLAINS, CelestialBiomeKeys.IO_PLAINS},
            {CelestialBiomeKeys.IO_PLAINS, CelestialBiomeKeys.IO_PLAINS, CelestialBiomeKeys.IO_PLAINS, CelestialBiomeKeys.IO_PLAINS, CelestialBiomeKeys.IO_DESERT},
            {CelestialBiomeKeys.IO_PLAINS, CelestialBiomeKeys.IO_PLAINS, CelestialBiomeKeys.IO_PLAINS, CelestialBiomeKeys.IO_DESERT, CelestialBiomeKeys.IO_DESERT},
            {CelestialBiomeKeys.IO_PLAINS, CelestialBiomeKeys.IO_PLAINS, CelestialBiomeKeys.IO_DESERT, CelestialBiomeKeys.IO_DESERT, CelestialBiomeKeys.IO_DESERT},
            {CelestialBiomeKeys.IO_DESERT, CelestialBiomeKeys.IO_DESERT, CelestialBiomeKeys.IO_DESERT, CelestialBiomeKeys.IO_DESERT, CelestialBiomeKeys.IO_DESERT}};
    private final ResourceKey<Biome>[][] PLATEAU_BIOMES_VARIANT = new ResourceKey[][]{
            {null, CelestialBiomeKeys.IO_SULFUR_FLATS, null, null, null},
            {null, null, null, CelestialBiomeKeys.IO_SULFUR_FLATS, null},
            {null, CelestialBiomeKeys.IO_SULFUR_FLATS, null, null, null},
            {CelestialBiomeKeys.IO_SULFUR_FLATS, null, null, null, null},
            {null, null, null, CelestialBiomeKeys.IO_DESERT, null}};
    private final ResourceKey<Biome>[][] SHATTERED_BIOMES = new ResourceKey[][]{
            {null, null, null, null, null},
            {null, null, null, null, null},
            {CelestialBiomeKeys.IO_DESERT, CelestialBiomeKeys.IO_DESERT, CelestialBiomeKeys.IO_DESERT, CelestialBiomeKeys.IO_DESERT, CelestialBiomeKeys.IO_DESERT},
            {CelestialBiomeKeys.IO_DESERT, CelestialBiomeKeys.IO_DESERT, CelestialBiomeKeys.IO_DESERT, CelestialBiomeKeys.IO_DESERT, CelestialBiomeKeys.IO_DESERT},
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
        return CelestialBiomeKeys.IO_DESERT;
    }

    protected ResourceKey<Biome> pickBeachBiome(int temp, int humidity) {
        return CelestialBiomeKeys.IO_DESERT;
    }

    protected ResourceKey<Biome> pickPeakBiome(int temp, int humidity, Climate.Parameter p_187243_) {
        return CelestialBiomeKeys.IO_DESERT;
    }
}

