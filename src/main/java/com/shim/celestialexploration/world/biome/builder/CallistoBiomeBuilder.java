package com.shim.celestialexploration.world.biome.builder;

import com.shim.celestialexploration.world.biome.CelestialBiomeKeys;
import com.shim.celestiallib.api.world.biome.builder.AbstractSimplerBiomeBuilder;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Climate;

public class CallistoBiomeBuilder extends AbstractSimplerBiomeBuilder {
    private final ResourceKey<Biome>[][] OCEANS = new ResourceKey[][]{
            {CelestialBiomeKeys.CALLISTO_LOWER_PLAINS, CelestialBiomeKeys.CALLISTO_LOWER_PLAINS, CelestialBiomeKeys.CALLISTO_LOWER_PLAINS, CelestialBiomeKeys.CALLISTO_LOWER_PLAINS, CelestialBiomeKeys.CALLISTO_LOWER_PLAINS},
            {CelestialBiomeKeys.CALLISTO_LOWER_PLAINS, CelestialBiomeKeys.CALLISTO_LOWER_PLAINS, CelestialBiomeKeys.CALLISTO_LOWER_PLAINS, CelestialBiomeKeys.CALLISTO_LOWER_PLAINS, CelestialBiomeKeys.CALLISTO_LOWER_PLAINS}};
    private final ResourceKey<Biome>[][] MIDDLE_BIOMES = new ResourceKey[][]{
            {CelestialBiomeKeys.CALLISTO_PLAINS, CelestialBiomeKeys.CALLISTO_PLAINS, CelestialBiomeKeys.CALLISTO_PLAINS, CelestialBiomeKeys.CALLISTO_PLAINS, CelestialBiomeKeys.CALLISTO_CRATERED_PLAINS},
            {CelestialBiomeKeys.CALLISTO_PLAINS, CelestialBiomeKeys.CALLISTO_PLAINS, CelestialBiomeKeys.CALLISTO_CRATERED_PLAINS, CelestialBiomeKeys.CALLISTO_PLAINS, CelestialBiomeKeys.CALLISTO_CRATERED_PLAINS},
            {CelestialBiomeKeys.CALLISTO_PLAINS, CelestialBiomeKeys.CALLISTO_CRATERED_PLAINS, CelestialBiomeKeys.CALLISTO_CRATERED_PLAINS, CelestialBiomeKeys.CALLISTO_PLAINS, CelestialBiomeKeys.CALLISTO_CRATERED_PLAINS},
            {CelestialBiomeKeys.CALLISTO_CRATERED_PLAINS, CelestialBiomeKeys.CALLISTO_CRATERED_PLAINS, CelestialBiomeKeys.CALLISTO_CRATERED_PLAINS, CelestialBiomeKeys.CALLISTO_CRATERED_PLAINS, CelestialBiomeKeys.CALLISTO_CRATERED_PLAINS},
            {CelestialBiomeKeys.CALLISTO_DESERT, CelestialBiomeKeys.CALLISTO_DESERT, CelestialBiomeKeys.CALLISTO_DESERT, CelestialBiomeKeys.CALLISTO_DESERT, CelestialBiomeKeys.CALLISTO_DESERT}};
    private final ResourceKey<Biome>[][] MIDDLE_BIOMES_VARIANT = new ResourceKey[][]{
            {null, null, CelestialBiomeKeys.CALLISTO_CRATERED_PLAINS, CelestialBiomeKeys.CALLISTO_CRATERED_PLAINS, CelestialBiomeKeys.CALLISTO_PLAINS},
            {null, CelestialBiomeKeys.CALLISTO_CRATERED_PLAINS, CelestialBiomeKeys.CALLISTO_PLAINS, CelestialBiomeKeys.CALLISTO_CRATERED_PLAINS, CelestialBiomeKeys.CALLISTO_PLAINS},
            {CelestialBiomeKeys.CALLISTO_CRATERED_PLAINS, CelestialBiomeKeys.CALLISTO_PLAINS, CelestialBiomeKeys.CALLISTO_PLAINS, CelestialBiomeKeys.CALLISTO_CRATERED_PLAINS, CelestialBiomeKeys.CALLISTO_CRATERED_PLAINS},
            {CelestialBiomeKeys.CALLISTO_PLAINS, CelestialBiomeKeys.CALLISTO_PLAINS, CelestialBiomeKeys.CALLISTO_PLAINS, null, null},
            {CelestialBiomeKeys.CALLISTO_DESERT, null, null, null, CelestialBiomeKeys.CALLISTO_DESERT}};
    private final ResourceKey<Biome>[][] PLATEAU_BIOMES = new ResourceKey[][]{
            {CelestialBiomeKeys.CALLISTO_PLAINS, CelestialBiomeKeys.CALLISTO_PLAINS, CelestialBiomeKeys.CALLISTO_PLAINS, CelestialBiomeKeys.CALLISTO_PLAINS, CelestialBiomeKeys.CALLISTO_PLAINS},
            {CelestialBiomeKeys.CALLISTO_PLAINS, CelestialBiomeKeys.CALLISTO_PLAINS, CelestialBiomeKeys.CALLISTO_PLAINS, CelestialBiomeKeys.CALLISTO_PLAINS, CelestialBiomeKeys.CALLISTO_DESERT},
            {CelestialBiomeKeys.CALLISTO_PLAINS, CelestialBiomeKeys.CALLISTO_PLAINS, CelestialBiomeKeys.CALLISTO_PLAINS, CelestialBiomeKeys.CALLISTO_DESERT, CelestialBiomeKeys.CALLISTO_DESERT},
            {CelestialBiomeKeys.CALLISTO_PLAINS, CelestialBiomeKeys.CALLISTO_PLAINS, CelestialBiomeKeys.CALLISTO_DESERT, CelestialBiomeKeys.CALLISTO_DESERT, CelestialBiomeKeys.CALLISTO_DESERT},
            {CelestialBiomeKeys.CALLISTO_DESERT, CelestialBiomeKeys.CALLISTO_DESERT, CelestialBiomeKeys.CALLISTO_DESERT, CelestialBiomeKeys.CALLISTO_DESERT, CelestialBiomeKeys.CALLISTO_DESERT}};
    private final ResourceKey<Biome>[][] PLATEAU_BIOMES_VARIANT = new ResourceKey[][]{
            {null, CelestialBiomeKeys.CALLISTO_CRATERED_PLAINS, null, null, null},
            {null, null, null, CelestialBiomeKeys.CALLISTO_CRATERED_PLAINS, null},
            {null, CelestialBiomeKeys.CALLISTO_CRATERED_PLAINS, null, null, null},
            {CelestialBiomeKeys.CALLISTO_CRATERED_PLAINS, null, null, null, null},
            {null, null, null, CelestialBiomeKeys.CALLISTO_DESERT, null}};
    private final ResourceKey<Biome>[][] SHATTERED_BIOMES = new ResourceKey[][]{
            {null, null, null, null, null},
            {null, null, null, null, null},
            {CelestialBiomeKeys.CALLISTO_DESERT, CelestialBiomeKeys.CALLISTO_DESERT, CelestialBiomeKeys.CALLISTO_DESERT, CelestialBiomeKeys.CALLISTO_DESERT, CelestialBiomeKeys.CALLISTO_DESERT},
            {CelestialBiomeKeys.CALLISTO_DESERT, CelestialBiomeKeys.CALLISTO_DESERT, CelestialBiomeKeys.CALLISTO_DESERT, CelestialBiomeKeys.CALLISTO_DESERT, CelestialBiomeKeys.CALLISTO_DESERT},
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
        return CelestialBiomeKeys.CALLISTO_DESERT;
    }

    @Override
    public ResourceKey<Biome> getFrozenRiverBiome() {
        return CelestialBiomeKeys.CALLISTO_DESERT;
    }

    @Override
    public ResourceKey<Biome> pickBadlandsBiome(int humditiy, Climate.Parameter weirdness) {
        return CelestialBiomeKeys.CALLISTO_DESERT;
    }
}