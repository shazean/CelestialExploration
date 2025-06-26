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

public class MercuryBiomeBuilder extends AbstractBiomeBuilder {
    
    protected final ResourceKey<Biome>[][] OCEANS = new ResourceKey[][]{
            {CelestialBiomeKeys.MERCURY_DEEP_CRATERED_PLAINS, CelestialBiomeKeys.MERCURY_DEEP_CRATERED_PLAINS, CelestialBiomeKeys.MERCURY_DEEP_CRATERED_PLAINS, CelestialBiomeKeys.MERCURY_DEEP_CRATERED_PLAINS, CelestialBiomeKeys.MERCURY_DEEP_CRATERED_PLAINS},
            {CelestialBiomeKeys.MERCURY_DEEP_CRATERED_PLAINS, CelestialBiomeKeys.MERCURY_DEEP_CRATERED_PLAINS, CelestialBiomeKeys.MERCURY_DEEP_CRATERED_PLAINS, CelestialBiomeKeys.MERCURY_DEEP_CRATERED_PLAINS, CelestialBiomeKeys.MERCURY_DEEP_CRATERED_PLAINS}};
    protected final ResourceKey<Biome>[][] MIDDLE_BIOMES = new ResourceKey[][]{
            {CelestialBiomeKeys.MERCURY_PLAINS, CelestialBiomeKeys.MERCURY_PLAINS, CelestialBiomeKeys.MERCURY_PLAINS, CelestialBiomeKeys.MERCURY_PLAINS, CelestialBiomeKeys.MERCURY_CRATERED_PLAINS},
            {CelestialBiomeKeys.MERCURY_PLAINS, CelestialBiomeKeys.MERCURY_PLAINS, CelestialBiomeKeys.MERCURY_CRATERED_PLAINS, CelestialBiomeKeys.MERCURY_PLAINS, CelestialBiomeKeys.MERCURY_CRATERED_PLAINS},
            {CelestialBiomeKeys.MERCURY_PLAINS, CelestialBiomeKeys.MERCURY_CRATERED_PLAINS, CelestialBiomeKeys.MERCURY_CRATERED_PLAINS, CelestialBiomeKeys.MERCURY_PLAINS, CelestialBiomeKeys.MERCURY_CRATERED_PLAINS},
            {CelestialBiomeKeys.MERCURY_CRATERED_PLAINS, CelestialBiomeKeys.MERCURY_CRATERED_PLAINS, CelestialBiomeKeys.MERCURY_CRATERED_PLAINS, CelestialBiomeKeys.MERCURY_CRATERED_PLAINS, CelestialBiomeKeys.MERCURY_CRATERED_PLAINS},
            {CelestialBiomeKeys.MERCURY_DESERT, CelestialBiomeKeys.MERCURY_DESERT, CelestialBiomeKeys.MERCURY_DESERT, CelestialBiomeKeys.MERCURY_DESERT, CelestialBiomeKeys.MERCURY_DESERT}};
    protected final ResourceKey<Biome>[][] MIDDLE_BIOMES_VARIANT = new ResourceKey[][]{
            {null, null, CelestialBiomeKeys.MERCURY_CRATERED_PLAINS, CelestialBiomeKeys.MERCURY_CRATERED_PLAINS, CelestialBiomeKeys.MERCURY_PLAINS},
            {null, CelestialBiomeKeys.MERCURY_CRATERED_PLAINS, CelestialBiomeKeys.MERCURY_PLAINS, CelestialBiomeKeys.MERCURY_CRATERED_PLAINS, CelestialBiomeKeys.MERCURY_PLAINS},
            {CelestialBiomeKeys.MERCURY_CRATERED_PLAINS, CelestialBiomeKeys.MERCURY_PLAINS, CelestialBiomeKeys.MERCURY_PLAINS, CelestialBiomeKeys.MERCURY_CRATERED_PLAINS, CelestialBiomeKeys.MERCURY_CRATERED_PLAINS},
            {CelestialBiomeKeys.MERCURY_PLAINS, CelestialBiomeKeys.MERCURY_PLAINS, CelestialBiomeKeys.MERCURY_PLAINS, null, null},
            {CelestialBiomeKeys.MERCURY_DESERT, null, null, null, CelestialBiomeKeys.MERCURY_DESERT}};
    protected final ResourceKey<Biome>[][] PLATEAU_BIOMES = new ResourceKey[][]{
            {CelestialBiomeKeys.MERCURY_PLAINS, CelestialBiomeKeys.MERCURY_PLAINS, CelestialBiomeKeys.MERCURY_PLAINS, CelestialBiomeKeys.MERCURY_PLAINS, CelestialBiomeKeys.MERCURY_PLAINS},
            {CelestialBiomeKeys.MERCURY_PLAINS, CelestialBiomeKeys.MERCURY_PLAINS, CelestialBiomeKeys.MERCURY_PLAINS, CelestialBiomeKeys.MERCURY_PLAINS, CelestialBiomeKeys.MERCURY_DESERT},
            {CelestialBiomeKeys.MERCURY_PLAINS, CelestialBiomeKeys.MERCURY_PLAINS, CelestialBiomeKeys.MERCURY_PLAINS, CelestialBiomeKeys.MERCURY_DESERT, CelestialBiomeKeys.MERCURY_DESERT},
            {CelestialBiomeKeys.MERCURY_PLAINS, CelestialBiomeKeys.MERCURY_PLAINS, CelestialBiomeKeys.MERCURY_DESERT, CelestialBiomeKeys.MERCURY_DESERT, CelestialBiomeKeys.MERCURY_DESERT},
            {CelestialBiomeKeys.MERCURY_DESERT, CelestialBiomeKeys.MERCURY_DESERT, CelestialBiomeKeys.MERCURY_DESERT, CelestialBiomeKeys.MERCURY_DESERT, CelestialBiomeKeys.MERCURY_DESERT}};
    protected final ResourceKey<Biome>[][] PLATEAU_BIOMES_VARIANT = new ResourceKey[][]{
            {null, CelestialBiomeKeys.MERCURY_CRATERED_PLAINS, null, null, null},
            {CelestialBiomeKeys.MERCURY_CRATERED_PLAINS, null, null, CelestialBiomeKeys.MERCURY_CRATERED_PLAINS, null},
            {null, CelestialBiomeKeys.MERCURY_CRATERED_PLAINS, null, CelestialBiomeKeys.MERCURY_CRATERED_PLAINS, CelestialBiomeKeys.MERCURY_CRATERED_PLAINS},
            {CelestialBiomeKeys.MERCURY_CRATERED_PLAINS, null, CelestialBiomeKeys.MERCURY_CRATERED_PLAINS, CelestialBiomeKeys.MERCURY_CRATERED_PLAINS, null},
            {null, null, null, CelestialBiomeKeys.MERCURY_DESERT, null}};
    protected final ResourceKey<Biome>[][] SHATTERED_BIOMES = new ResourceKey[][]{
            {null, null, null, null, null},
            {null, null, null, null, null},
            {CelestialBiomeKeys.MERCURY_RIDGES, CelestialBiomeKeys.MERCURY_RIDGES, CelestialBiomeKeys.MERCURY_RIDGES, CelestialBiomeKeys.MERCURY_RIDGES, CelestialBiomeKeys.MERCURY_RIDGES},
            {CelestialBiomeKeys.MERCURY_RIDGES, CelestialBiomeKeys.MERCURY_RIDGES, CelestialBiomeKeys.MERCURY_RIDGES, CelestialBiomeKeys.MERCURY_RIDGES, CelestialBiomeKeys.MERCURY_RIDGES},
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
        return CelestialBiomeKeys.MERCURY_DESERT;
    }

    @Override
    protected ResourceKey<Biome> pickBeachBiome(int temp, int humidity) {
        return CelestialBiomeKeys.MERCURY_DESERT;
    }


    @Override
    protected ResourceKey<Biome> pickPeakBiome(int temp, int humidity, Climate.Parameter p_187243_) {
        return CelestialBiomeKeys.MERCURY_RIDGES;
    }
}
