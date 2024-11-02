package com.shim.celestialexploration.registry;

import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestialexploration.world.biome.*;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class BiomeRegistry {

    public static final DeferredRegister<Biome> BIOMES = DeferredRegister.create(Registry.BIOME_REGISTRY, CelestialExploration.MODID);

    //---- MOON -------------------------------------------------------------------------------
    public static final RegistryObject<Biome> MOON_CRATERS = BIOMES.register("moon_craters", MoonBiomes::craters);
    public static final RegistryObject<Biome> MOON_DESERT = BIOMES.register("moon_desert", MoonBiomes::desert);
    public static final RegistryObject<Biome> MOON_LAVA_FLATS = BIOMES.register("moon_lava_flats", MoonBiomes::lavaFlats);
    public static final RegistryObject<Biome> MOON_LOWER_PLAINS = BIOMES.register("moon_lower_plains", MoonBiomes::desert);
    public static final RegistryObject<Biome> MOON_PLAINS = BIOMES.register("moon_plains", MoonBiomes::plains);

    //---- MARS -------------------------------------------------------------------------------
    public static final RegistryObject<Biome> MARS_CRATERS = BIOMES.register("mars_craters", MarsBiomes::craters);
    public static final RegistryObject<Biome> MARS_DEEP_CRATERS = BIOMES.register("mars_deep_craters", MarsBiomes::craters);
    public static final RegistryObject<Biome> MARS_DESERT = BIOMES.register("mars_desert", MarsBiomes::desert);
    public static final RegistryObject<Biome> MARS_DRY_ICE_FLATS = BIOMES.register("mars_dry_ice_flats", () -> MarsBiomes.flats(true));
    public static final RegistryObject<Biome> MARS_DRY_ICE_PEAKS = BIOMES.register("mars_dry_ice_peaks", MarsBiomes::desert);
    public static final RegistryObject<Biome> MARS_DUNES = BIOMES.register("mars_dunes", MarsBiomes::dunes);
    public static final RegistryObject<Biome> MARS_ERODED_FLATS = BIOMES.register("mars_eroded_flats", () -> MarsBiomes.flats(false));
    public static final RegistryObject<Biome> MARS_FLATS = BIOMES.register("mars_flats", () -> MarsBiomes.flats(false));
    public static final RegistryObject<Biome> MARS_VOLCANO_FLATS = BIOMES.register("mars_volcano_flats", () -> MarsBiomes.flats(false));

    //---- VENUS -------------------------------------------------------------------------------
    public static final RegistryObject<Biome> VENUS_DESERT = BIOMES.register("venus_desert", VenusBiomes::desert);
    public static final RegistryObject<Biome> VENUS_SULFUR_FLATS = BIOMES.register("venus_sulfur_flats", VenusBiomes::plains);
    public static final RegistryObject<Biome> VENUS_LOWER_PLAINS = BIOMES.register("venus_lower_plains", VenusBiomes::plains);
    public static final RegistryObject<Biome> VENUS_PLAINS = BIOMES.register("venus_plains", VenusBiomes::plains);
    public static final RegistryObject<Biome> SULFUR_OCEAN = BIOMES.register("sulfur_ocean", VenusBiomes::ocean);
    public static final RegistryObject<Biome> SULFUR_RIVER = BIOMES.register("sulfur_river", VenusBiomes::river);

    //---- SPACE -------------------------------------------------------------------------------
    public static final RegistryObject<Biome> SPACE = BIOMES.register("space", CelestialBiomes::space);

    //---- MERCURY -------------------------------------------------------------------------------
    public static final RegistryObject<Biome> MERCURY_DEEP_CRATERED_PLAINS = BIOMES.register("mercury_deep_cratered_plains", MercuryBiomes::craters);
    public static final RegistryObject<Biome> MERCURY_CRATERED_PLAINS = BIOMES.register("mercury_cratered_plains", MercuryBiomes::craters);
    public static final RegistryObject<Biome> MERCURY_DESERT = BIOMES.register("mercury_desert", MercuryBiomes::desert);
    public static final RegistryObject<Biome> MERCURY_PLAINS = BIOMES.register("mercury_plains", MercuryBiomes::plains);
    public static final RegistryObject<Biome> MERCURY_RIDGES = BIOMES.register("mercury_ridges", MercuryBiomes::ridges);

    //---- JUPITER -------------------------------------------------------------------------------
    public static final RegistryObject<Biome> JUPITER_GREAT_STORM = BIOMES.register("jupiter_great_storm", JupiterBiomes::ether);
    public static final RegistryObject<Biome> JUPITER_LESSER_STORM = BIOMES.register("jupiter_lesser_storm", JupiterBiomes::ether);
    public static final RegistryObject<Biome> JUPITER_ETHER = BIOMES.register("jupiter_ether", JupiterBiomes::ether);


}