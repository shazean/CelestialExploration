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

public class IoBiomeBuilder {
    private final Climate.Parameter FULL_RANGE = Climate.Parameter.span(-1.0F, 1.0F);
    private final Climate.Parameter[] temperatures = new Climate.Parameter[]{Climate.Parameter.span(-1.0F, -0.45F), Climate.Parameter.span(-0.45F, -0.15F), Climate.Parameter.span(-0.15F, 0.2F), Climate.Parameter.span(0.2F, 0.55F), Climate.Parameter.span(0.55F, 1.0F)};
    private final Climate.Parameter[] humidities = new Climate.Parameter[]{Climate.Parameter.span(-1.0F, -0.35F), Climate.Parameter.span(-0.35F, -0.1F), Climate.Parameter.span(-0.1F, 0.1F), Climate.Parameter.span(0.1F, 0.3F), Climate.Parameter.span(0.3F, 1.0F)};
    private final Climate.Parameter[] erosions = new Climate.Parameter[]{Climate.Parameter.span(-1.0F, -0.78F), Climate.Parameter.span(-0.78F, -0.375F), Climate.Parameter.span(-0.375F, -0.2225F), Climate.Parameter.span(-0.2225F, 0.05F), Climate.Parameter.span(0.05F, 0.45F), Climate.Parameter.span(0.45F, 0.55F), Climate.Parameter.span(0.55F, 1.0F)};
    private final Climate.Parameter FROZEN_RANGE = this.temperatures[0];
    private final Climate.Parameter UNFROZEN_RANGE = Climate.Parameter.span(this.temperatures[1], this.temperatures[4]);
    private final Climate.Parameter mushroomFieldsContinentalness = Climate.Parameter.span(-1.2F, -1.05F);
    private final Climate.Parameter deepOceanContinentalness = Climate.Parameter.span(-1.05F, -0.455F);
    private final Climate.Parameter oceanContinentalness = Climate.Parameter.span(-0.455F, -0.19F);
    private final Climate.Parameter coastContinentalness = Climate.Parameter.span(-0.19F, -0.11F);
    private final Climate.Parameter inlandContinentalness = Climate.Parameter.span(-0.11F, 0.55F);
    private final Climate.Parameter nearInlandContinentalness = Climate.Parameter.span(-0.11F, 0.03F);
    private final Climate.Parameter midInlandContinentalness = Climate.Parameter.span(0.03F, 0.3F);
    private final Climate.Parameter farInlandContinentalness = Climate.Parameter.span(0.3F, 1.0F);
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

    public List<Climate.ParameterPoint> spawnTarget() {
        Climate.Parameter climate$parameter = Climate.Parameter.point(0.0F);
        float f = 0.16F;
        return List.of(new Climate.ParameterPoint(this.FULL_RANGE, this.FULL_RANGE, Climate.Parameter.span(this.inlandContinentalness, this.FULL_RANGE), this.FULL_RANGE, climate$parameter, Climate.Parameter.span(-1.0F, -0.16F), 0L), new Climate.ParameterPoint(this.FULL_RANGE, this.FULL_RANGE, Climate.Parameter.span(this.inlandContinentalness, this.FULL_RANGE), this.FULL_RANGE, climate$parameter, Climate.Parameter.span(0.16F, 1.0F), 0L));
    }

    public void addBiomes(Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> p_187176_) {
//        if (SharedConstants.debugGenerateSquareTerrainWithoutNoise) {
//            TerrainProvider.overworld(false).addDebugBiomesToVisualizeSplinePoints(p_187176_);
//        } else {
        this.addOffCoastBiomes(p_187176_);
        this.addInlandBiomes(p_187176_);
        this.addUndergroundBiomes(p_187176_);
//        }
    }

    private void addOffCoastBiomes(Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> p_187196_) {
        for (int i = 0; i < this.temperatures.length; ++i) {
            Climate.Parameter climate$parameter = this.temperatures[i];
            this.addSurfaceBiome(p_187196_, climate$parameter, this.FULL_RANGE, this.deepOceanContinentalness, this.FULL_RANGE, this.FULL_RANGE, 0.0F, this.OCEANS[0][i]);
            this.addSurfaceBiome(p_187196_, climate$parameter, this.FULL_RANGE, this.oceanContinentalness, this.FULL_RANGE, this.FULL_RANGE, 0.0F, this.OCEANS[1][i]);
        }
    }

    private void addInlandBiomes(Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> p_187216_) {
        this.addMidSlice(p_187216_, Climate.Parameter.span(-1.0F, -0.93333334F));
        this.addHighSlice(p_187216_, Climate.Parameter.span(-0.93333334F, -0.7666667F));
        this.addPeaks(p_187216_, Climate.Parameter.span(-0.7666667F, -0.56666666F));
        this.addHighSlice(p_187216_, Climate.Parameter.span(-0.56666666F, -0.4F));
        this.addMidSlice(p_187216_, Climate.Parameter.span(-0.4F, -0.26666668F));
        this.addLowSlice(p_187216_, Climate.Parameter.span(-0.26666668F, -0.05F));
        this.addValleys(p_187216_, Climate.Parameter.span(-0.05F, 0.05F));
        this.addLowSlice(p_187216_, Climate.Parameter.span(0.05F, 0.26666668F));
        this.addMidSlice(p_187216_, Climate.Parameter.span(0.26666668F, 0.4F));
        this.addHighSlice(p_187216_, Climate.Parameter.span(0.4F, 0.56666666F));
        this.addPeaks(p_187216_, Climate.Parameter.span(0.56666666F, 0.7666667F));
        this.addHighSlice(p_187216_, Climate.Parameter.span(0.7666667F, 0.93333334F));
        this.addMidSlice(p_187216_, Climate.Parameter.span(0.93333334F, 1.0F));
    }

    private void addPeaks(Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> p_187178_, Climate.Parameter p_187179_) {
        for (int i = 0; i < this.temperatures.length; ++i) {
            Climate.Parameter climate$parameter = this.temperatures[i];

            for (int j = 0; j < this.humidities.length; ++j) {
                Climate.Parameter climate$parameter1 = this.humidities[j];
                ResourceKey<Biome> resourcekey = this.pickMiddleBiome(i, j, p_187179_);
                ResourceKey<Biome> resourcekey1 = this.pickMiddleBiomeOrBadlandsIfHot(i, j, p_187179_);
                ResourceKey<Biome> resourcekey2 = this.pickMiddleBiomeOrBadlandsIfHotOrSlopeIfCold(i, j, p_187179_);
                ResourceKey<Biome> resourcekey3 = this.pickPlateauBiome(i, j, p_187179_);
                ResourceKey<Biome> resourcekey4 = this.pickShatteredBiome(i, j, p_187179_);
//                ResourceKey<Biome> resourcekey5 = this.maybePickWindsweptSavannaBiome(i, j, p_187179_, resourcekey4);
                ResourceKey<Biome> resourcekey6 = this.pickPeakBiome(i, j, p_187179_);
                this.addSurfaceBiome(p_187178_, climate$parameter, climate$parameter1, Climate.Parameter.span(this.coastContinentalness, this.farInlandContinentalness), this.erosions[0], p_187179_, 0.0F, resourcekey6);
                this.addSurfaceBiome(p_187178_, climate$parameter, climate$parameter1, Climate.Parameter.span(this.coastContinentalness, this.nearInlandContinentalness), this.erosions[1], p_187179_, 0.0F, resourcekey2);
                this.addSurfaceBiome(p_187178_, climate$parameter, climate$parameter1, Climate.Parameter.span(this.midInlandContinentalness, this.farInlandContinentalness), this.erosions[1], p_187179_, 0.0F, resourcekey6);
                this.addSurfaceBiome(p_187178_, climate$parameter, climate$parameter1, Climate.Parameter.span(this.coastContinentalness, this.nearInlandContinentalness), Climate.Parameter.span(this.erosions[2], this.erosions[3]), p_187179_, 0.0F, resourcekey);
                this.addSurfaceBiome(p_187178_, climate$parameter, climate$parameter1, Climate.Parameter.span(this.midInlandContinentalness, this.farInlandContinentalness), this.erosions[2], p_187179_, 0.0F, resourcekey3);
                this.addSurfaceBiome(p_187178_, climate$parameter, climate$parameter1, this.midInlandContinentalness, this.erosions[3], p_187179_, 0.0F, resourcekey1);
                this.addSurfaceBiome(p_187178_, climate$parameter, climate$parameter1, this.farInlandContinentalness, this.erosions[3], p_187179_, 0.0F, resourcekey3);
                this.addSurfaceBiome(p_187178_, climate$parameter, climate$parameter1, Climate.Parameter.span(this.coastContinentalness, this.farInlandContinentalness), this.erosions[4], p_187179_, 0.0F, resourcekey);
//                this.addSurfaceBiome(p_187178_, climate$parameter, climate$parameter1, Climate.Parameter.span(this.coastContinentalness, this.nearInlandContinentalness), this.erosions[5], p_187179_, 0.0F, resourcekey5);
                this.addSurfaceBiome(p_187178_, climate$parameter, climate$parameter1, Climate.Parameter.span(this.midInlandContinentalness, this.farInlandContinentalness), this.erosions[5], p_187179_, 0.0F, resourcekey4);
                this.addSurfaceBiome(p_187178_, climate$parameter, climate$parameter1, Climate.Parameter.span(this.coastContinentalness, this.farInlandContinentalness), this.erosions[6], p_187179_, 0.0F, resourcekey);
            }
        }

    }

    private void addHighSlice(Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> p_187198_, Climate.Parameter p_187199_) {
        for (int i = 0; i < this.temperatures.length; ++i) {
            Climate.Parameter climate$parameter = this.temperatures[i];

            for (int j = 0; j < this.humidities.length; ++j) {
                Climate.Parameter climate$parameter1 = this.humidities[j];
                ResourceKey<Biome> middleBiome = this.pickMiddleBiome(i, j, p_187199_);
                ResourceKey<Biome> resourcekey1 = this.pickMiddleBiomeOrBadlandsIfHot(i, j, p_187199_);
                ResourceKey<Biome> resourcekey2 = this.pickMiddleBiomeOrBadlandsIfHotOrSlopeIfCold(i, j, p_187199_);
                ResourceKey<Biome> plateauBiome = this.pickPlateauBiome(i, j, p_187199_);
                ResourceKey<Biome> resourcekey4 = this.pickShatteredBiome(i, j, p_187199_);
//                ResourceKey<Biome> resourcekey5 = this.maybePickWindsweptSavannaBiome(i, j, p_187199_, middleBiome);
//                ResourceKey<Biome> resourcekey6 = this.pickSlopeBiome(i, j, p_187199_);
                ResourceKey<Biome> resourcekey7 = this.pickPeakBiome(i, j, p_187199_);
                this.addSurfaceBiome(p_187198_, climate$parameter, climate$parameter1, this.coastContinentalness, Climate.Parameter.span(this.erosions[0], this.erosions[1]), p_187199_, 0.0F, middleBiome);
//                this.addSurfaceBiome(p_187198_, climate$parameter, climate$parameter1, this.nearInlandContinentalness, this.erosions[0], p_187199_, 0.0F, resourcekey6);
                this.addSurfaceBiome(p_187198_, climate$parameter, climate$parameter1, Climate.Parameter.span(this.midInlandContinentalness, this.farInlandContinentalness), this.erosions[0], p_187199_, 0.0F, resourcekey7);
                this.addSurfaceBiome(p_187198_, climate$parameter, climate$parameter1, this.nearInlandContinentalness, this.erosions[1], p_187199_, 0.0F, resourcekey2);
//                this.addSurfaceBiome(p_187198_, climate$parameter, climate$parameter1, Climate.Parameter.span(this.midInlandContinentalness, this.farInlandContinentalness), this.erosions[1], p_187199_, 0.0F, resourcekey6);
                this.addSurfaceBiome(p_187198_, climate$parameter, climate$parameter1, Climate.Parameter.span(this.coastContinentalness, this.nearInlandContinentalness), Climate.Parameter.span(this.erosions[2], this.erosions[3]), p_187199_, 0.0F, middleBiome);
                this.addSurfaceBiome(p_187198_, climate$parameter, climate$parameter1, Climate.Parameter.span(this.midInlandContinentalness, this.farInlandContinentalness), this.erosions[2], p_187199_, 0.0F, plateauBiome);
                this.addSurfaceBiome(p_187198_, climate$parameter, climate$parameter1, this.midInlandContinentalness, this.erosions[3], p_187199_, 0.0F, resourcekey1);
                this.addSurfaceBiome(p_187198_, climate$parameter, climate$parameter1, this.farInlandContinentalness, this.erosions[3], p_187199_, 0.0F, plateauBiome);
                this.addSurfaceBiome(p_187198_, climate$parameter, climate$parameter1, Climate.Parameter.span(this.coastContinentalness, this.farInlandContinentalness), this.erosions[4], p_187199_, 0.0F, middleBiome);
//                this.addSurfaceBiome(p_187198_, climate$parameter, climate$parameter1, Climate.Parameter.span(this.coastContinentalness, this.nearInlandContinentalness), this.erosions[5], p_187199_, 0.0F, resourcekey5);
                this.addSurfaceBiome(p_187198_, climate$parameter, climate$parameter1, Climate.Parameter.span(this.midInlandContinentalness, this.farInlandContinentalness), this.erosions[5], p_187199_, 0.0F, resourcekey4);
                this.addSurfaceBiome(p_187198_, climate$parameter, climate$parameter1, Climate.Parameter.span(this.coastContinentalness, this.farInlandContinentalness), this.erosions[6], p_187199_, 0.0F, middleBiome);
            }
        }

    }

    private void addMidSlice(Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> p_187218_, Climate.Parameter p_187219_) {
//        this.addSurfaceBiome(p_187218_, this.FULL_RANGE, this.FULL_RANGE, this.coastContinentalness, Climate.Parameter.span(this.erosions[0], this.erosions[2]), p_187219_, 0.0F, ResourceKey<Biome>s.STONY_SHORE);
//        this.addSurfaceBiome(p_187218_, this.UNFROZEN_RANGE, this.FULL_RANGE, Climate.Parameter.span(this.nearInlandContinentalness, this.farInlandContinentalness), this.erosions[6], p_187219_, 0.0F, ResourceKey<Biome>s.SWAMP);

        for (int i = 0; i < this.temperatures.length; ++i) {
            Climate.Parameter climate$parameter = this.temperatures[i];

            for (int j = 0; j < this.humidities.length; ++j) {
                Climate.Parameter climate$parameter1 = this.humidities[j];
                ResourceKey<Biome> resourcekey = this.pickMiddleBiome(i, j, p_187219_);
                ResourceKey<Biome> resourcekey1 = this.pickMiddleBiomeOrBadlandsIfHot(i, j, p_187219_);
                ResourceKey<Biome> resourcekey2 = this.pickMiddleBiomeOrBadlandsIfHotOrSlopeIfCold(i, j, p_187219_);
                ResourceKey<Biome> resourcekey3 = this.pickShatteredBiome(i, j, p_187219_);
                ResourceKey<Biome> resourcekey4 = this.pickPlateauBiome(i, j, p_187219_);
                ResourceKey<Biome> resourcekey5 = this.pickBeachBiome(i, j);
//                ResourceKey<Biome> resourcekey6 = this.maybePickWindsweptSavannaBiome(i, j, p_187219_, resourcekey);
                ResourceKey<Biome> resourcekey7 = this.pickShatteredCoastBiome(i, j, p_187219_);
//                ResourceKey<Biome> resourcekey8 = this.pickSlopeBiome(i, j, p_187219_);
////                this.addSurfaceBiome(p_187218_, climate$parameter, climate$parameter1, Climate.Parameter.span(this.nearInlandContinentalness, this.farInlandContinentalness), this.erosions[0], p_187219_, 0.0F, resourcekey8);
                this.addSurfaceBiome(p_187218_, climate$parameter, climate$parameter1, Climate.Parameter.span(this.nearInlandContinentalness, this.midInlandContinentalness), this.erosions[1], p_187219_, 0.0F, resourcekey2);
                this.addSurfaceBiome(p_187218_, climate$parameter, climate$parameter1, this.farInlandContinentalness, this.erosions[1], p_187219_, 0.0F, resourcekey4); // i == 0 ? resourcekey8 : resourcekey4);
                this.addSurfaceBiome(p_187218_, climate$parameter, climate$parameter1, this.nearInlandContinentalness, this.erosions[2], p_187219_, 0.0F, resourcekey);
                this.addSurfaceBiome(p_187218_, climate$parameter, climate$parameter1, this.midInlandContinentalness, this.erosions[2], p_187219_, 0.0F, resourcekey1);
                this.addSurfaceBiome(p_187218_, climate$parameter, climate$parameter1, this.farInlandContinentalness, this.erosions[2], p_187219_, 0.0F, resourcekey4);
                this.addSurfaceBiome(p_187218_, climate$parameter, climate$parameter1, Climate.Parameter.span(this.coastContinentalness, this.nearInlandContinentalness), this.erosions[3], p_187219_, 0.0F, resourcekey);
                this.addSurfaceBiome(p_187218_, climate$parameter, climate$parameter1, Climate.Parameter.span(this.midInlandContinentalness, this.farInlandContinentalness), this.erosions[3], p_187219_, 0.0F, resourcekey1);
                if (p_187219_.max() < 0L) {
                    this.addSurfaceBiome(p_187218_, climate$parameter, climate$parameter1, this.coastContinentalness, this.erosions[4], p_187219_, 0.0F, resourcekey5);
                    this.addSurfaceBiome(p_187218_, climate$parameter, climate$parameter1, Climate.Parameter.span(this.nearInlandContinentalness, this.farInlandContinentalness), this.erosions[4], p_187219_, 0.0F, resourcekey);
                } else {
                    this.addSurfaceBiome(p_187218_, climate$parameter, climate$parameter1, Climate.Parameter.span(this.coastContinentalness, this.farInlandContinentalness), this.erosions[4], p_187219_, 0.0F, resourcekey);
                }

                this.addSurfaceBiome(p_187218_, climate$parameter, climate$parameter1, this.coastContinentalness, this.erosions[5], p_187219_, 0.0F, resourcekey7);
//                this.addSurfaceBiome(p_187218_, climate$parameter, climate$parameter1, this.nearInlandContinentalness, this.erosions[5], p_187219_, 0.0F, resourcekey6);
                this.addSurfaceBiome(p_187218_, climate$parameter, climate$parameter1, Climate.Parameter.span(this.midInlandContinentalness, this.farInlandContinentalness), this.erosions[5], p_187219_, 0.0F, resourcekey3);
                if (p_187219_.max() < 0L) {
                    this.addSurfaceBiome(p_187218_, climate$parameter, climate$parameter1, this.coastContinentalness, this.erosions[6], p_187219_, 0.0F, resourcekey5);
                } else {
                    this.addSurfaceBiome(p_187218_, climate$parameter, climate$parameter1, this.coastContinentalness, this.erosions[6], p_187219_, 0.0F, resourcekey);
                }

                if (i == 0) {
                    this.addSurfaceBiome(p_187218_, climate$parameter, climate$parameter1, Climate.Parameter.span(this.nearInlandContinentalness, this.farInlandContinentalness), this.erosions[6], p_187219_, 0.0F, resourcekey);
                }
            }
        }

    }

    private void addLowSlice(Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> p_187229_, Climate.Parameter p_187230_) {
//        this.addSurfaceBiome(p_187229_, this.FULL_RANGE, this.FULL_RANGE, this.coastContinentalness, Climate.Parameter.span(this.erosions[0], this.erosions[2]), p_187230_, 0.0F, Biomes.STONY_SHORE);
//        this.addSurfaceBiome(p_187229_, this.UNFROZEN_RANGE, this.FULL_RANGE, Climate.Parameter.span(this.nearInlandContinentalness, this.farInlandContinentalness), this.erosions[6], p_187230_, 0.0F, Biomes.SWAMP);

        for (int i = 0; i < this.temperatures.length; ++i) {
            Climate.Parameter climate$parameter = this.temperatures[i];

            for (int j = 0; j < this.humidities.length; ++j) {
                Climate.Parameter climate$parameter1 = this.humidities[j];
                ResourceKey<Biome> resourcekey = this.pickMiddleBiome(i, j, p_187230_);
                ResourceKey<Biome> resourcekey1 = this.pickMiddleBiomeOrBadlandsIfHot(i, j, p_187230_);
                ResourceKey<Biome> resourcekey2 = this.pickMiddleBiomeOrBadlandsIfHotOrSlopeIfCold(i, j, p_187230_);
                ResourceKey<Biome> resourcekey3 = this.pickBeachBiome(i, j);
//                ResourceKey<Biome> resourcekey4 = this.maybePickWindsweptSavannaBiome(i, j, p_187230_, resourcekey);
                ResourceKey<Biome> resourcekey5 = this.pickShatteredCoastBiome(i, j, p_187230_);
                this.addSurfaceBiome(p_187229_, climate$parameter, climate$parameter1, this.nearInlandContinentalness, Climate.Parameter.span(this.erosions[0], this.erosions[1]), p_187230_, 0.0F, resourcekey1);
                this.addSurfaceBiome(p_187229_, climate$parameter, climate$parameter1, Climate.Parameter.span(this.midInlandContinentalness, this.farInlandContinentalness), Climate.Parameter.span(this.erosions[0], this.erosions[1]), p_187230_, 0.0F, resourcekey2);
                this.addSurfaceBiome(p_187229_, climate$parameter, climate$parameter1, this.nearInlandContinentalness, Climate.Parameter.span(this.erosions[2], this.erosions[3]), p_187230_, 0.0F, resourcekey);
                this.addSurfaceBiome(p_187229_, climate$parameter, climate$parameter1, Climate.Parameter.span(this.midInlandContinentalness, this.farInlandContinentalness), Climate.Parameter.span(this.erosions[2], this.erosions[3]), p_187230_, 0.0F, resourcekey1);
                this.addSurfaceBiome(p_187229_, climate$parameter, climate$parameter1, this.coastContinentalness, Climate.Parameter.span(this.erosions[3], this.erosions[4]), p_187230_, 0.0F, resourcekey3);
                this.addSurfaceBiome(p_187229_, climate$parameter, climate$parameter1, Climate.Parameter.span(this.nearInlandContinentalness, this.farInlandContinentalness), this.erosions[4], p_187230_, 0.0F, resourcekey);
                this.addSurfaceBiome(p_187229_, climate$parameter, climate$parameter1, this.coastContinentalness, this.erosions[5], p_187230_, 0.0F, resourcekey5);
//                this.addSurfaceBiome(p_187229_, climate$parameter, climate$parameter1, this.nearInlandContinentalness, this.erosions[5], p_187230_, 0.0F, resourcekey4);
                this.addSurfaceBiome(p_187229_, climate$parameter, climate$parameter1, Climate.Parameter.span(this.midInlandContinentalness, this.farInlandContinentalness), this.erosions[5], p_187230_, 0.0F, resourcekey);
                this.addSurfaceBiome(p_187229_, climate$parameter, climate$parameter1, this.coastContinentalness, this.erosions[6], p_187230_, 0.0F, resourcekey3);
                if (i == 0) {
                    this.addSurfaceBiome(p_187229_, climate$parameter, climate$parameter1, Climate.Parameter.span(this.nearInlandContinentalness, this.farInlandContinentalness), this.erosions[6], p_187230_, 0.0F, resourcekey);
                }
            }
        }

    }

    private void addValleys(Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> p_187238_, Climate.Parameter weirdness) {
        this.addSurfaceBiome(p_187238_, this.FROZEN_RANGE, this.FULL_RANGE, this.coastContinentalness, Climate.Parameter.span(this.erosions[0], this.erosions[1]), weirdness, 0.0F, CelestialBiomeKeys.IO_DESERT);
        this.addSurfaceBiome(p_187238_, this.UNFROZEN_RANGE, this.humidities[0], this.coastContinentalness, Climate.Parameter.span(this.erosions[0], this.erosions[1]), weirdness, 0.0F, CelestialBiomeKeys.IO_DESERT);
        this.addSurfaceBiome(p_187238_, this.FROZEN_RANGE, this.humidities[0], this.nearInlandContinentalness, Climate.Parameter.span(this.erosions[0], this.erosions[1]), weirdness, 0.0F, CelestialBiomeKeys.IO_DESERT);
        this.addSurfaceBiome(p_187238_, this.UNFROZEN_RANGE, this.humidities[0], this.nearInlandContinentalness, Climate.Parameter.span(this.erosions[0], this.erosions[1]), weirdness, 0.0F, CelestialBiomeKeys.IO_DESERT);
        this.addSurfaceBiome(p_187238_, this.FROZEN_RANGE, this.humidities[0], Climate.Parameter.span(this.coastContinentalness, this.farInlandContinentalness), Climate.Parameter.span(this.erosions[2], this.erosions[5]), weirdness, 0.0F, CelestialBiomeKeys.IO_DESERT);
        this.addSurfaceBiome(p_187238_, this.UNFROZEN_RANGE, this.humidities[0], Climate.Parameter.span(this.coastContinentalness, this.farInlandContinentalness), Climate.Parameter.span(this.erosions[2], this.erosions[5]), weirdness, 0.0F, CelestialBiomeKeys.IO_DESERT);
        this.addSurfaceBiome(p_187238_, this.FROZEN_RANGE, this.humidities[0], this.coastContinentalness, this.erosions[6], weirdness, 0.0F, CelestialBiomeKeys.IO_DESERT);
        this.addSurfaceBiome(p_187238_, this.UNFROZEN_RANGE, this.humidities[0], this.coastContinentalness, this.erosions[6], weirdness, 0.0F, CelestialBiomeKeys.IO_DESERT);
        this.addSurfaceBiome(p_187238_, this.FROZEN_RANGE, this.humidities[0], Climate.Parameter.span(this.inlandContinentalness, this.farInlandContinentalness), this.erosions[6], weirdness, 0.0F, CelestialBiomeKeys.IO_DESERT);

        for (int i = 0; i < this.temperatures.length; ++i) {
            Climate.Parameter climate$parameter = this.temperatures[i];

            for (int j = 0; j < this.humidities.length; ++j) {
                Climate.Parameter climate$parameter1 = this.humidities[j];
                ResourceKey<Biome> resourcekey = this.pickMiddleBiomeOrBadlandsIfHot(i, j, weirdness);
                this.addSurfaceBiome(p_187238_, climate$parameter, climate$parameter1, Climate.Parameter.span(this.midInlandContinentalness, this.farInlandContinentalness), Climate.Parameter.span(this.erosions[0], this.erosions[1]), weirdness, 0.0F, resourcekey);
            }
        }

    }

    private void addUndergroundBiomes(Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> p_187227_) {
        Random rand = new Random();

//        this.addUndergroundBiome(p_187227_, this.FULL_RANGE, this.humidities[0], Climate.Parameter.span(0.8F, 1.0F), this.FULL_RANGE, this.FULL_RANGE, 0.0F, AGBiomeKeys.UMBRAL_CAVE);
//        this.addUndergroundBiome(p_187227_, this.FULL_RANGE, Climate.Parameter.span(this.humidities[1], this.humidities[2]), Climate.Parameter.span(0.8F, 1.0F), this.FULL_RANGE, this.FULL_RANGE, 0.0F, LUMINESCENT_CAVES[rand.nextInt(4)]);
//        this.addUndergroundBiome(p_187227_, this.FULL_RANGE, Climate.Parameter.span(this.humidities[3], this.humidities[4]), Climate.Parameter.span(0.8F, 1.0F), this.FULL_RANGE, this.FULL_RANGE, 0.0F, CRYSTALLINE_CAVES[rand.nextInt(4)]);
//
//        this.addUndergroundBiome(p_187227_, this.FULL_RANGE, Climate.Parameter.span(0.7F, 1.0F), this.FULL_RANGE, this.FULL_RANGE, this.FULL_RANGE, 0.0F, AGBiomeKeys.OVERGROWN_CAVE);
    }

    private ResourceKey<Biome> pickMiddleBiome(int temp, int humidity, Climate.Parameter p_187166_) {
        if (p_187166_.max() < 0L) {
            return this.MIDDLE_BIOMES[temp][humidity];
        } else {
            ResourceKey<Biome> resourcekey = this.MIDDLE_BIOMES_VARIANT[temp][humidity];
            return resourcekey == null ? this.MIDDLE_BIOMES[temp][humidity] : resourcekey;
        }
    }

    private ResourceKey<Biome> pickMiddleBiomeOrBadlandsIfHot(int temp, int humidity, Climate.Parameter p_187194_) {
        return this.pickMiddleBiome(temp, humidity, p_187194_);
//        return temp == 4 ? this.pickBadlandsBiome(humidity, p_187194_) : this.pickMiddleBiome(temp, humidity, p_187194_);
    }

    private ResourceKey<Biome> pickMiddleBiomeOrBadlandsIfHotOrSlopeIfCold(int temp, int humidity, Climate.Parameter p_187214_) {
        return this.pickMiddleBiomeOrBadlandsIfHot(temp, humidity, p_187214_);
//        return temp == 0 ? this.pickSlopeBiome(temp, humidity, p_187214_) : this.pickMiddleBiomeOrBadlandsIfHot(temp, humidity, p_187214_);
    }

//    private ResourceKey<Biome> maybePickWindsweptSavannaBiome(int temp, int humidity, Climate.Parameter p_201993_, ResourceKey<Biome> p_201994_) {
//        return temp > 1 && humidity < 4 && p_201993_.max() >= 0L ? ResourceKey<Biome>s.WINDSWEPT_SAVANNA : p_201994_;
//    }

    private ResourceKey<Biome> pickShatteredCoastBiome(int temp, int humidity, Climate.Parameter p_187225_) {
        return p_187225_.max() >= 0L ? this.pickMiddleBiome(temp, humidity, p_187225_) : this.pickBeachBiome(temp, humidity);
//        return this.maybePickWindsweptSavannaBiome(temp, humidity, p_187225_, resourcekey);
    }

    private ResourceKey<Biome> pickBeachBiome(int temp, int humidity) {
        return CelestialBiomeKeys.IO_DESERT;
    }



    private ResourceKey<Biome> pickPlateauBiome(int temp, int humidity, Climate.Parameter p_187236_) {
        if (p_187236_.max() < 0L) {
            return this.PLATEAU_BIOMES[temp][humidity];
        } else {
            ResourceKey<Biome> resourcekey = this.PLATEAU_BIOMES_VARIANT[temp][humidity];
            return resourcekey == null ? this.PLATEAU_BIOMES[temp][humidity] : resourcekey;
        }
    }

    private ResourceKey<Biome> pickPeakBiome(int temp, int humidity, Climate.Parameter p_187243_) {
//        if (temp <= 2) {
//            return p_187243_.max() < 0L ? Biomes.JAGGED_PEAKS : Biomes.FROZEN_PEAKS;
//        } else {
//            return temp == 3 ? Biomes.STONY_PEAKS : this.pickBadlandsBiome(humidity, p_187243_);
//        }
        return CelestialBiomeKeys.IO_DESERT;

    }

//    private Biome pickSlopeBiome(int temp, int humidity, Climate.Parameter p_187247_) {
//        if (temp >= 3) {
//            return this.pickPlateauBiome(temp, humidity, p_187247_);
//        } else {
//            return humidity <= 1 ? Biomes.SNOWY_SLOPES : Biomes.GROVE;
//        }
//    }

    private ResourceKey<Biome> pickShatteredBiome(int temp, int humidity, Climate.Parameter p_202004_) {
        ResourceKey<Biome> resourcekey = this.SHATTERED_BIOMES[temp][humidity];
        return resourcekey == null ? this.pickMiddleBiome(temp, humidity, p_202004_) : resourcekey;
//        return CelestialBiomeKeys.IO_PLAINS;
    }

    private void addSurfaceBiome(Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> p_187181_, Climate.Parameter temp, Climate.Parameter humidity, Climate.Parameter continentalness, Climate.Parameter erosion, Climate.Parameter weirdness, float offset, ResourceKey<Biome> biome) {
        p_187181_.accept(Pair.of(Climate.parameters(temp, humidity, continentalness, erosion, Climate.Parameter.point(0.0F), weirdness, offset), biome));
        p_187181_.accept(Pair.of(Climate.parameters(temp, humidity, continentalness, erosion, Climate.Parameter.point(1.0F), weirdness, offset), biome));
    }

    private void addUndergroundBiome(Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> p_187201_, Climate.Parameter temp, Climate.Parameter humidity, Climate.Parameter continentalness, Climate.Parameter erosion, Climate.Parameter weirdness, float offset, ResourceKey<Biome> p_187208_) {
        p_187201_.accept(Pair.of(Climate.parameters(temp, humidity, continentalness, erosion, Climate.Parameter.span(0.2F, 0.9F), weirdness, offset), p_187208_));
    }

    public static String getDebugStringForPeaksAndValleys(double p_187156_) {
        if (p_187156_ < (double) TerrainShaper.peaksAndValleys(0.05F)) {
            return "Valley";
        } else if (p_187156_ < (double) TerrainShaper.peaksAndValleys(0.26666668F)) {
            return "Low";
        } else if (p_187156_ < (double) TerrainShaper.peaksAndValleys(0.4F)) {
            return "Mid";
        } else {
            return p_187156_ < (double) TerrainShaper.peaksAndValleys(0.56666666F) ? "High" : "Peak";
        }
    }

    public String getDebugStringForContinentalness(double p_187190_) {
        double d0 = (double) Climate.quantizeCoord((float) p_187190_);
        if (d0 < (double) this.mushroomFieldsContinentalness.max()) {
            return "Mushroom fields";
        } else if (d0 < (double) this.deepOceanContinentalness.max()) {
            return "Deep ocean";
        } else if (d0 < (double) this.oceanContinentalness.max()) {
            return "Ocean";
        } else if (d0 < (double) this.coastContinentalness.max()) {
            return "Coast";
        } else if (d0 < (double) this.nearInlandContinentalness.max()) {
            return "Near inland";
        } else {
            return d0 < (double) this.midInlandContinentalness.max() ? "Mid inland" : "Far inland";
        }
    }
}

