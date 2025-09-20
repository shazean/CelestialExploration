package com.shim.celestialexploration.world.biome.builder;

import com.mojang.datafixers.util.Pair;
import com.shim.celestialexploration.world.biome.CelestialBiomeKeys;
import com.shim.celestiallib.api.world.biome.builder.AbstractSimplerBiomeBuilder;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Climate;
import net.minecraft.world.level.biome.TerrainShaper;

import java.util.List;
import java.util.Random;
import java.util.function.Consumer;

public class MarsBiomeBuilder extends AbstractSimplerBiomeBuilder {
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
    public ResourceKey<Biome>[][] getOceans() {
        return OCEANS;
    }

    @Override
    public ResourceKey<Biome>[][] getMiddleBiomes() {
        return MIDDLE_BIOMES;
    }

    @Override
    public ResourceKey<Biome>[][] getMiddleBiomeVariants() {
        return MIDDLE_BIOMES_VARIANT;
    }

    @Override
    public ResourceKey<Biome>[][] getPlateauBiomes() {
        return PLATEAU_BIOMES;
    }

    @Override
    public ResourceKey<Biome>[][] getPlateauBiomeVariants() {
        return PLATEAU_BIOMES_VARIANT;
    }

    @Override
    public ResourceKey<Biome>[][] getShatteredBiomes() {
        return SHATTERED_BIOMES;
    }

    @Override
    public ResourceKey<Biome>[] getBeachBiomes() {
        return SHATTERED_BIOMES[3];
    }

    @Override
    public ResourceKey<Biome> getRiverBiome() {
        return CelestialBiomeKeys.MARS_DESERT;
    }

    @Override
    public ResourceKey<Biome> getFrozenRiverBiome() {
        return CelestialBiomeKeys.MARS_DESERT;
    }

    @Override
    public ResourceKey<Biome> pickBadlandsBiome(int humditiy, Climate.Parameter weirdness) {
        return CelestialBiomeKeys.MARS_DESERT;
    }
}
