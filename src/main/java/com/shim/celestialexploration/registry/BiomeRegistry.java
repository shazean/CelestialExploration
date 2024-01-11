package com.shim.celestialexploration.registry;

import com.shim.celestialexploration.CelestialExploration;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;

public class BiomeRegistry {

//    public static final DeferredRegister<Biome> BIOMES = DeferredRegister.create(ForgeRegistries.BIOMES, CelestialExploration.MODID);

    /**
     * MARS
     */
    public static final ResourceKey<Biome> MARS_CRATERS = register("mars_craters");
    public static final ResourceKey<Biome> MARS_DEEP_CRATERS = register("mars_deep_craters");
    public static final ResourceKey<Biome> MARS_DESERT = register("mars_desert");
    public static final ResourceKey<Biome> MARS_DRY_ICE_FLATS = register("mars_dry_ice_flats");
    public static final ResourceKey<Biome> MARS_DRY_ICE_PEAKS = register("mars_dry_ice_peaks");
    public static final ResourceKey<Biome> MARS_DUNES = register("mars_dunes");
    public static final ResourceKey<Biome> MARS_ERODED_FLATS = register("mars_eroded_flats");
    public static final ResourceKey<Biome> MARS_FLATS = register("mars_flats");
    public static final ResourceKey<Biome> MARS_VOLCANO_FLATS = register("mars_volcano_flats");

    /**
     * MOON
     */
    public static final ResourceKey<Biome> MOON_CRATERS = register("moon_craters");
    public static final ResourceKey<Biome> MOON_DESERT = register("moon_desert");
    public static final ResourceKey<Biome> MOON_LAVA_FLATS = register("moon_lava_flats");
    public static final ResourceKey<Biome> MOON_LOWER_PLAINS = register("moon_lower_plains");
    public static final ResourceKey<Biome> MOON_PLAINS = register("moon_plains");

    /**
     * SPACE
     */
    public static final ResourceKey<Biome> SPACE = register("space");
//    public static final ResourceKey<Biome> EMPTY_SPACE = register("empty_space");
//    public static final ResourceKey<Biome> LARGE_ASTEROID = register("large_asteroid");
//    public static final ResourceKey<Biome> SPARSE_ASTEROID_FIELD = register("sparse_asteroid_field");
//    public static final ResourceKey<Biome> MARS_ORBIT = register("mars_orbit");
//    public static final ResourceKey<Biome> EARTH_ORBIT = register("earth_orbit");

    /**
     * TAGS
     */
    public static final TagKey<Biome> MARS_BIOMES = create("mars");
    public static final TagKey<Biome> MOON_BIOMES = create("moon");
    public static final TagKey<Biome> SPACE_BIOMES = create("space");



    private static ResourceKey<Biome> register(String key) {
        return ResourceKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(CelestialExploration.MODID, key));
    }

    private static TagKey<Biome> create(String key) {
        return TagKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(CelestialExploration.MODID, key));
    }

}
