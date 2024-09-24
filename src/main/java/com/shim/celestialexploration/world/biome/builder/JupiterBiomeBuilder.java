package com.shim.celestialexploration.world.biome.builder;

import com.mojang.datafixers.util.Pair;
import com.shim.celestialexploration.world.biome.CelestialBiomeKeys;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Climate;

import java.util.function.Consumer;

public class JupiterBiomeBuilder {

    private final Climate.Parameter FULL_RANGE = Climate.Parameter.span(-1.0F, 1.0F);
    private final Climate.Parameter mushroomFieldsContinentalness = Climate.Parameter.span(-1.2F, -1.05F);
    private final Climate.Parameter midInlandContinentalness = Climate.Parameter.span(0.03F, 0.3F);
    private final Climate.Parameter farInlandContinentalness = Climate.Parameter.span(0.3F, 1.0F);

    public void addBiomes(Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> p_187176_) {
        this.addOffCoastBiomes(p_187176_);
        this.addPeakBiome(p_187176_);
        this.addOtherBiome(p_187176_);
    }

    private void addOffCoastBiomes(Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> p_187196_) {
        this.addSurfaceBiome(p_187196_, this.FULL_RANGE, this.FULL_RANGE, this.mushroomFieldsContinentalness, this.FULL_RANGE, this.FULL_RANGE, 0.0F, CelestialBiomeKeys.JUPITER_GREAT_STORM);
    }

    private void addPeakBiome(Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> p_187196_) {
        this.addSurfaceBiome(p_187196_, this.FULL_RANGE, this.FULL_RANGE, this.mushroomFieldsContinentalness, this.FULL_RANGE, this.FULL_RANGE, 0.0F, CelestialBiomeKeys.JUPITER_LESSER_STORM);
    }

    private void addOtherBiome(Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> p_187196_) {
        this.addSurfaceBiome(p_187196_, this.FULL_RANGE, this.FULL_RANGE, Climate.Parameter.span(this.midInlandContinentalness, this.farInlandContinentalness), this.FULL_RANGE, this.FULL_RANGE, 0.0F, CelestialBiomeKeys.JUPITER_ETHER);
    }

    private void addSurfaceBiome(Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> p_187181_, Climate.Parameter temp, Climate.Parameter humidity, Climate.Parameter continentalness, Climate.Parameter erosion, Climate.Parameter weirdness, float offset, ResourceKey<Biome> biome) {
        p_187181_.accept(Pair.of(Climate.parameters(temp, humidity, continentalness, erosion, Climate.Parameter.point(0.0F), weirdness, offset), biome));
        p_187181_.accept(Pair.of(Climate.parameters(temp, humidity, continentalness, erosion, Climate.Parameter.point(1.0F), weirdness, offset), biome));
    }
}
