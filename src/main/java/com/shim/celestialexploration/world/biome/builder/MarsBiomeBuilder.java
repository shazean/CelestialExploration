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

public class MarsBiomeBuilder extends AbstractBiomeBuilder {
    protected final ResourceKey<Biome>[][] OCEANS = new ResourceKey[][]{
            {CelestialBiomeKeys.MARS_DEEP_CRATERS, CelestialBiomeKeys.MARS_DEEP_CRATERS, CelestialBiomeKeys.MARS_DEEP_CRATERS, CelestialBiomeKeys.MARS_DEEP_CRATERS, CelestialBiomeKeys.MARS_DEEP_CRATERS},
            {CelestialBiomeKeys.MARS_DEEP_CRATERS, CelestialBiomeKeys.MARS_DEEP_CRATERS, CelestialBiomeKeys.MARS_DEEP_CRATERS, CelestialBiomeKeys.MARS_DEEP_CRATERS, CelestialBiomeKeys.MARS_DEEP_CRATERS}};
    protected final ResourceKey<Biome>[][] MIDDLE_BIOMES = new ResourceKey[][]{
            {CelestialBiomeKeys.MARS_DRY_ICE_FLATS, CelestialBiomeKeys.MARS_DRY_ICE_FLATS, CelestialBiomeKeys.MARS_FLATS, CelestialBiomeKeys.MARS_FLATS, CelestialBiomeKeys.MARS_VOLCANO_FLATS},
            {CelestialBiomeKeys.MARS_DRY_ICE_FLATS, CelestialBiomeKeys.MARS_FLATS, CelestialBiomeKeys.MARS_CRATERS, CelestialBiomeKeys.MARS_FLATS, CelestialBiomeKeys.MARS_VOLCANO_FLATS},
            {CelestialBiomeKeys.MARS_FLATS, CelestialBiomeKeys.MARS_CRATERS, CelestialBiomeKeys.MARS_CRATERS, CelestialBiomeKeys.MARS_FLATS, CelestialBiomeKeys.MARS_VOLCANO_FLATS},
            {CelestialBiomeKeys.MARS_CRATERS, CelestialBiomeKeys.MARS_CRATERS, CelestialBiomeKeys.MARS_CRATERS, CelestialBiomeKeys.MARS_VOLCANO_FLATS, CelestialBiomeKeys.MARS_VOLCANO_FLATS},
            {CelestialBiomeKeys.MARS_DESERT, CelestialBiomeKeys.MARS_DESERT, CelestialBiomeKeys.MARS_DUNES, CelestialBiomeKeys.MARS_DUNES, CelestialBiomeKeys.MARS_DUNES}};
    protected final ResourceKey<Biome>[][] MIDDLE_BIOMES_VARIANT = new ResourceKey[][]{
            {null, null, CelestialBiomeKeys.MARS_CRATERS, CelestialBiomeKeys.MARS_CRATERS, CelestialBiomeKeys.MARS_FLATS},
            {null, CelestialBiomeKeys.MARS_CRATERS, CelestialBiomeKeys.MARS_FLATS, CelestialBiomeKeys.MARS_CRATERS, CelestialBiomeKeys.MARS_FLATS},
            {CelestialBiomeKeys.MARS_CRATERS, CelestialBiomeKeys.MARS_FLATS, CelestialBiomeKeys.MARS_FLATS, CelestialBiomeKeys.MARS_CRATERS, CelestialBiomeKeys.MARS_CRATERS},
            {CelestialBiomeKeys.MARS_FLATS, CelestialBiomeKeys.MARS_FLATS, CelestialBiomeKeys.MARS_FLATS, null, null},
            {CelestialBiomeKeys.MARS_DUNES, null, null, null, CelestialBiomeKeys.MARS_DESERT}};
    protected final ResourceKey<Biome>[][] PLATEAU_BIOMES = new ResourceKey[][]{
            {CelestialBiomeKeys.MARS_DRY_ICE_FLATS, CelestialBiomeKeys.MARS_FLATS, CelestialBiomeKeys.MARS_FLATS, CelestialBiomeKeys.MARS_FLATS, CelestialBiomeKeys.MARS_FLATS},
            {CelestialBiomeKeys.MARS_FLATS, CelestialBiomeKeys.MARS_FLATS, CelestialBiomeKeys.MARS_FLATS, CelestialBiomeKeys.MARS_FLATS, CelestialBiomeKeys.MARS_DESERT},
            {CelestialBiomeKeys.MARS_FLATS, CelestialBiomeKeys.MARS_FLATS, CelestialBiomeKeys.MARS_FLATS, CelestialBiomeKeys.MARS_DESERT, CelestialBiomeKeys.MARS_DESERT},
            {CelestialBiomeKeys.MARS_FLATS, CelestialBiomeKeys.MARS_FLATS, CelestialBiomeKeys.MARS_DESERT, CelestialBiomeKeys.MARS_DESERT, CelestialBiomeKeys.MARS_DESERT},
            {CelestialBiomeKeys.MARS_DESERT, CelestialBiomeKeys.MARS_DESERT, CelestialBiomeKeys.MARS_DESERT, CelestialBiomeKeys.MARS_DESERT, CelestialBiomeKeys.MARS_DESERT}};
    protected final ResourceKey<Biome>[][] PLATEAU_BIOMES_VARIANT = new ResourceKey[][]{
            {null, CelestialBiomeKeys.MARS_VOLCANO_FLATS, null, null, null},
            {null, null, null, CelestialBiomeKeys.MARS_VOLCANO_FLATS, null},
            {null, CelestialBiomeKeys.MARS_VOLCANO_FLATS, null, null, null},
            {CelestialBiomeKeys.MARS_VOLCANO_FLATS, null, null, null, null},
            {null, null, null, CelestialBiomeKeys.MARS_DUNES, null}};
    protected final ResourceKey<Biome>[][] SHATTERED_BIOMES = new ResourceKey[][]{
            {null, null, null, null, null},
            {null, null, null, null, null},
            {CelestialBiomeKeys.MARS_ERODED_FLATS, CelestialBiomeKeys.MARS_ERODED_FLATS, CelestialBiomeKeys.MARS_ERODED_FLATS, CelestialBiomeKeys.MARS_ERODED_FLATS, CelestialBiomeKeys.MARS_ERODED_FLATS},
            {CelestialBiomeKeys.MARS_ERODED_FLATS, CelestialBiomeKeys.MARS_ERODED_FLATS, CelestialBiomeKeys.MARS_ERODED_FLATS, CelestialBiomeKeys.MARS_ERODED_FLATS, CelestialBiomeKeys.MARS_ERODED_FLATS},
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
        return CelestialBiomeKeys.MARS_DESERT;
    }

    @Override
    protected ResourceKey<Biome> pickBeachBiome(int temp, int humidity) {
        return CelestialBiomeKeys.MARS_DESERT;
    }

    @Override
    protected ResourceKey<Biome> pickPeakBiome(int temp, int humidity, Climate.Parameter p_187243_) {
        return CelestialBiomeKeys.MARS_DRY_ICE_PEAKS;
    }
}
