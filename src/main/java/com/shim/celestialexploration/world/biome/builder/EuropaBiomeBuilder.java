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

public class EuropaBiomeBuilder extends AbstractSimplerBiomeBuilder {
    private final ResourceKey<Biome>[][] OCEANS = new ResourceKey[][]{
            {CelestialBiomeKeys.EUROPA_OCEAN, CelestialBiomeKeys.EUROPA_OCEAN, CelestialBiomeKeys.EUROPA_OCEAN, CelestialBiomeKeys.EUROPA_OCEAN, CelestialBiomeKeys.EUROPA_OCEAN},
            {CelestialBiomeKeys.EUROPA_OCEAN, CelestialBiomeKeys.EUROPA_OCEAN, CelestialBiomeKeys.EUROPA_OCEAN, CelestialBiomeKeys.EUROPA_OCEAN, CelestialBiomeKeys.EUROPA_OCEAN}};
    private final ResourceKey<Biome>[][] MIDDLE_BIOMES = new ResourceKey[][]{
            {CelestialBiomeKeys.EUROPA_JAGGED_PLAINS, CelestialBiomeKeys.EUROPA_JAGGED_PLAINS, CelestialBiomeKeys.EUROPA_JAGGED_PLAINS, CelestialBiomeKeys.EUROPA_PLAINS, CelestialBiomeKeys.EUROPA_PLAINS},
            {CelestialBiomeKeys.EUROPA_JAGGED_PLAINS, CelestialBiomeKeys.EUROPA_PLAINS, CelestialBiomeKeys.EUROPA_PLAINS, CelestialBiomeKeys.EUROPA_PLAINS, CelestialBiomeKeys.EUROPA_PLAINS},
            {CelestialBiomeKeys.EUROPA_JAGGED_PLAINS, CelestialBiomeKeys.EUROPA_PLAINS, CelestialBiomeKeys.EUROPA_PLAINS, CelestialBiomeKeys.EUROPA_PLAINS, CelestialBiomeKeys.EUROPA_PLAINS},
            {CelestialBiomeKeys.EUROPA_JAGGED_PLAINS, CelestialBiomeKeys.EUROPA_PLAINS, CelestialBiomeKeys.EUROPA_PLAINS, CelestialBiomeKeys.EUROPA_PLAINS, CelestialBiomeKeys.EUROPA_PLAINS},
            {CelestialBiomeKeys.EUROPA_DESERT, CelestialBiomeKeys.EUROPA_DESERT, CelestialBiomeKeys.EUROPA_DESERT, CelestialBiomeKeys.EUROPA_DESERT, CelestialBiomeKeys.EUROPA_DESERT}};
    private final ResourceKey<Biome>[][] MIDDLE_BIOMES_VARIANT = new ResourceKey[][]{
            {null, null, CelestialBiomeKeys.EUROPA_PLAINS, CelestialBiomeKeys.EUROPA_PLAINS, CelestialBiomeKeys.EUROPA_PLAINS},
            {null, CelestialBiomeKeys.EUROPA_PLAINS, CelestialBiomeKeys.EUROPA_PLAINS, CelestialBiomeKeys.EUROPA_PLAINS, CelestialBiomeKeys.EUROPA_PLAINS},
            {CelestialBiomeKeys.EUROPA_PLAINS, CelestialBiomeKeys.EUROPA_PLAINS, CelestialBiomeKeys.EUROPA_PLAINS, CelestialBiomeKeys.EUROPA_PLAINS, CelestialBiomeKeys.EUROPA_PLAINS},
            {CelestialBiomeKeys.EUROPA_PLAINS, CelestialBiomeKeys.EUROPA_PLAINS, CelestialBiomeKeys.EUROPA_PLAINS, null, CelestialBiomeKeys.EUROPA_JAGGED_PLAINS},
            {CelestialBiomeKeys.EUROPA_DESERT, CelestialBiomeKeys.EUROPA_JAGGED_PLAINS, CelestialBiomeKeys.EUROPA_JAGGED_PLAINS, null, CelestialBiomeKeys.EUROPA_DESERT}};
    private final ResourceKey<Biome>[][] PLATEAU_BIOMES = new ResourceKey[][]{
            {CelestialBiomeKeys.EUROPA_PLAINS, CelestialBiomeKeys.EUROPA_PLAINS, CelestialBiomeKeys.EUROPA_PLAINS, CelestialBiomeKeys.EUROPA_PLAINS, CelestialBiomeKeys.EUROPA_PLAINS},
            {CelestialBiomeKeys.EUROPA_PLAINS, CelestialBiomeKeys.EUROPA_PLAINS, CelestialBiomeKeys.EUROPA_PLAINS, CelestialBiomeKeys.EUROPA_PLAINS, CelestialBiomeKeys.EUROPA_DESERT},
            {CelestialBiomeKeys.EUROPA_PLAINS, CelestialBiomeKeys.EUROPA_PLAINS, CelestialBiomeKeys.EUROPA_PLAINS, CelestialBiomeKeys.EUROPA_DESERT, CelestialBiomeKeys.EUROPA_DESERT},
            {CelestialBiomeKeys.EUROPA_PLAINS, CelestialBiomeKeys.EUROPA_PLAINS, CelestialBiomeKeys.EUROPA_DESERT, CelestialBiomeKeys.EUROPA_DESERT, CelestialBiomeKeys.EUROPA_DESERT},
            {CelestialBiomeKeys.EUROPA_DESERT, CelestialBiomeKeys.EUROPA_DESERT, CelestialBiomeKeys.EUROPA_DESERT, CelestialBiomeKeys.EUROPA_DESERT, CelestialBiomeKeys.EUROPA_DESERT}};
    private final ResourceKey<Biome>[][] PLATEAU_BIOMES_VARIANT = new ResourceKey[][]{
            {null, CelestialBiomeKeys.EUROPA_PLAINS, null, null, null},
            {CelestialBiomeKeys.EUROPA_JAGGED_PLAINS, null, null, CelestialBiomeKeys.EUROPA_PLAINS, null},
            {null, CelestialBiomeKeys.EUROPA_PLAINS, null, CelestialBiomeKeys.EUROPA_JAGGED_PLAINS, null},
            {CelestialBiomeKeys.EUROPA_PLAINS, null, null, null, null},
            {CelestialBiomeKeys.EUROPA_JAGGED_PLAINS, null, null, CelestialBiomeKeys.EUROPA_DESERT, null}};
    private final ResourceKey<Biome>[][] SHATTERED_BIOMES = new ResourceKey[][]{
            {null, null, null, CelestialBiomeKeys.EUROPA_JAGGED_PLAINS, null},
            {null, CelestialBiomeKeys.EUROPA_JAGGED_PLAINS, null, CelestialBiomeKeys.EUROPA_JAGGED_PLAINS, null},
            {CelestialBiomeKeys.EUROPA_DESERT, CelestialBiomeKeys.EUROPA_JAGGED_PLAINS, CelestialBiomeKeys.EUROPA_DESERT, CelestialBiomeKeys.EUROPA_DESERT, CelestialBiomeKeys.EUROPA_DESERT},
            {CelestialBiomeKeys.EUROPA_DESERT, CelestialBiomeKeys.EUROPA_DESERT, CelestialBiomeKeys.EUROPA_DESERT, CelestialBiomeKeys.EUROPA_DESERT, CelestialBiomeKeys.EUROPA_DESERT},
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
        return CelestialBiomeKeys.EUROPA_DESERT;
    }

    @Override
    public ResourceKey<Biome> getFrozenRiverBiome() {
        return CelestialBiomeKeys.EUROPA_DESERT;
    }

    @Override
    public ResourceKey<Biome> pickBadlandsBiome(int humditiy, Climate.Parameter weirdness) {
        return CelestialBiomeKeys.EUROPA_DESERT;
    }
}
