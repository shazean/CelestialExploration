package com.shim.celestialexploration.world.biome;

import com.shim.celestialexploration.CelestialExploration;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraftforge.registries.RegistryObject;

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
    public static final ResourceKey<Biome> VENUS_SULFUR_FLATS = register("venus_sulfur_flats");
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

    //---- JUPITER & MOONS -------------------------------------------------------------------------------
    //JUPITER
    public static final ResourceKey<Biome> JUPITER_GREAT_STORM = register("jupiter_great_storm");
    public static final ResourceKey<Biome> JUPITER_LESSER_STORM = register("jupiter_lesser_storm");
    public static final ResourceKey<Biome> JUPITER_ETHER = register("jupiter_ether");

    //IO
    public static final ResourceKey<Biome> IO_DESERT = register("io_desert");
    public static final ResourceKey<Biome> IO_SULFUR_FLATS = register("io_sulfur_flats");
    public static final ResourceKey<Biome> IO_LOWER_PLAINS = register("io_lower_plains");
    public static final ResourceKey<Biome> IO_PLAINS = register("io_plains");

    //EUROPA
    public static final ResourceKey<Biome> EUROPA_DESERT = register("europa_desert");
    public static final ResourceKey<Biome> EUROPA_LOWER_PLAINS = register("europa_lower_plains");
    public static final ResourceKey<Biome> EUROPA_PLAINS = register("europa_plains");
    public static final ResourceKey<Biome> EUROPA_JAGGED_PLAINS = register("europa_jagged_plains");
    public static final ResourceKey<Biome> EUROPA_OCEAN = register("europa_ocean");
    public static final ResourceKey<Biome> EUROPA_RIVER = register("europa_river");

    //CALLISTO
    public static final ResourceKey<Biome> CALLISTO_CRATERED_PLAINS = register("callisto_cratered_plains");
    public static final ResourceKey<Biome> CALLISTO_DESERT = register("callisto_desert");
    public static final ResourceKey<Biome> CALLISTO_LOWER_PLAINS = register("callisto_lower_plains");
    public static final ResourceKey<Biome> CALLISTO_PLAINS = register("callisto_plains");

    //GANYMEDE
    public static final ResourceKey<Biome> GANYMEDE_DESERT = register("ganymede_desert");
    public static final ResourceKey<Biome> GANYMEDE_LOWER_PLAINS = register("ganymede_lower_plains");
    public static final ResourceKey<Biome> GANYMEDE_PLAINS = register("ganymede_plains");
    public static final ResourceKey<Biome> GANYMEDE_CRATERED_PLAINS = register("ganymede_cratered_plains");


    //---- SPACE -------------------------------------------------------------------------------
    public static final ResourceKey<Biome> SPACE = register("space");

    //---- FOR DATAPACK/PRESETS -------------------------------------------------------------------------------
    public static final ResourceKey<Biome> HIGH_DESERT = register("high_desert");
    public static final ResourceKey<Biome> LOW_DESERT = register("low_desert");
    public static final ResourceKey<Biome> ICY_DESERT = register("icy_desert");
    public static final ResourceKey<Biome> MONSOON_DESERT = register("monsoon_desert");
    public static final ResourceKey<Biome> DUNES = register("dunes");
    public static final ResourceKey<Biome> SHALLOW_OCEAN = register("shallow_ocean");
    public static final ResourceKey<Biome> ISLANDS = register("islands");


    private static ResourceKey<Biome> register(String key) {
        return ResourceKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(CelestialExploration.MODID, key));
    }
}
