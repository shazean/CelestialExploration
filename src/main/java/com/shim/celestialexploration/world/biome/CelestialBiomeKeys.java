package com.shim.celestialexploration.world.biome;

import com.shim.celestialexploration.CelestialExploration;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;

public class CelestialBiomeKeys {

    //---- MOON -------------------------------------------------------------------------------
    public static final ResourceKey<Biome> MOON_CRATERS = register("moon_craters");
    public static final ResourceKey<Biome> MOON_DESERT = register("moon_desert");
    public static final ResourceKey<Biome> MOON_LAVA_FLATS = register("moon_lava_flats");
    public static final ResourceKey<Biome> MOON_LOWER_PLAINS = register("moon_lower_plains");
    public static final ResourceKey<Biome> MOON_PLAINS = register("moon_plains");

    //---- MARS -------------------------------------------------------------------------------
    public static final ResourceKey<Biome> MARS_CRATERS = register("mars_craters");
    public static final ResourceKey<Biome> MARS_DEEP_CRATERS = register("mars_deep_craters");
    public static final ResourceKey<Biome> MARS_DESERT = register("mars_desert");
    public static final ResourceKey<Biome> MARS_DRY_ICE_FLATS = register("mars_dry_ice_flats");
    public static final ResourceKey<Biome> MARS_DRY_ICE_PEAKS = register("mars_dry_ice_peaks");
    public static final ResourceKey<Biome> MARS_DUNES = register("mars_dunes");
    public static final ResourceKey<Biome> MARS_ERODED_FLATS = register("mars_eroded_flats");
    public static final ResourceKey<Biome> MARS_FLATS = register("mars_flats");
    public static final ResourceKey<Biome> MARS_VOLCANO_FLATS = register("mars_volcano_flats");

    //---- VENUS -------------------------------------------------------------------------------
    public static final ResourceKey<Biome> VENUS_DESERT = register("venus_desert");
    public static final ResourceKey<Biome> VENUS_SULFUR_FLATS = register("venus_flats");
    public static final ResourceKey<Biome> VENUS_LOWER_PLAINS = register("venus_lower_plains");
    public static final ResourceKey<Biome> VENUS_PLAINS = register("venus_plains");
    public static final ResourceKey<Biome> SULFUR_OCEAN = register("sulfur_ocean");
    public static final ResourceKey<Biome> SULFUR_RIVER = register("sulfur_river");

    //---- MERCURY -------------------------------------------------------------------------------
    public static final ResourceKey<Biome> MERCURY_DEEP_CRATERED_PLAINS = register("mercury_deep_cratered_plains");
    public static final ResourceKey<Biome> MERCURY_CRATERED_PLAINS = register("mercury_cratered_plains");
    public static final ResourceKey<Biome> MERCURY_DESERT = register("mercury_desert");
    public static final ResourceKey<Biome> MERCURY_PLAINS = register("mercury_plains");
    public static final ResourceKey<Biome> MERCURY_RIDGES = register("mercury_ridges");

    //---- JUPITER -------------------------------------------------------------------------------
    public static final ResourceKey<Biome> JUPITER_GREAT_STORM = register("jupiter_great_storm");
    public static final ResourceKey<Biome> JUPITER_LESSER_STORM = register("jupiter_lesser_storm");
    public static final ResourceKey<Biome> JUPITER_ETHER = register("jupiter_ether");

    //---- SPACE -------------------------------------------------------------------------------
    public static final ResourceKey<Biome> SPACE = register("space");

    private static ResourceKey<Biome> register(String key) {
        return ResourceKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(CelestialExploration.MODID, key));
    }
}
