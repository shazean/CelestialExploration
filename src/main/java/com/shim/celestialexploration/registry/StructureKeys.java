package com.shim.celestialexploration.registry;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.ConfiguredStructureFeature;

public class StructureKeys {

    private static ResourceKey<ConfiguredStructureFeature<?, ?>> createKey(String p_209873_) {
        return ResourceKey.create(Registry.CONFIGURED_STRUCTURE_FEATURE_REGISTRY, new ResourceLocation(p_209873_));
    }


    //CRATERS
    public static ResourceKey<ConfiguredStructureFeature<?, ?>> TINY_CRATER = createKey("tiny_crater");
    public static ResourceKey<ConfiguredStructureFeature<?, ?>> SMALL_CRATER = createKey("small_crater");
    public static ResourceKey<ConfiguredStructureFeature<?, ?>> MEDIUM_CRATER = createKey("medium_crater");
    public static ResourceKey<ConfiguredStructureFeature<?, ?>> LARGE_CRATER = createKey("large_crater");

    //PLANETS/CELESTIAL BODIES
    public static ResourceKey<ConfiguredStructureFeature<?, ?>> SUN = createKey("sun");

    public static ResourceKey<ConfiguredStructureFeature<?, ?>> MERCURY = createKey("mercury");
    public static ResourceKey<ConfiguredStructureFeature<?, ?>> VENUS = createKey("venus");
    public static ResourceKey<ConfiguredStructureFeature<?, ?>> EARTH = createKey("earth");
    public static ResourceKey<ConfiguredStructureFeature<?, ?>> MARS = createKey("mars");
    public static ResourceKey<ConfiguredStructureFeature<?, ?>> JUPITER = createKey("jupiter");
    public static ResourceKey<ConfiguredStructureFeature<?, ?>> SATURN = createKey("saturn");
    public static ResourceKey<ConfiguredStructureFeature<?, ?>> TITAN = createKey("titan");
    public static ResourceKey<ConfiguredStructureFeature<?, ?>> IAPETUS = createKey("iapetus");
    public static ResourceKey<ConfiguredStructureFeature<?, ?>> URANUS = createKey("uranus");
    public static ResourceKey<ConfiguredStructureFeature<?, ?>> NEPTUNE = createKey("neptune");

    public static ResourceKey<ConfiguredStructureFeature<?, ?>> PLANET = createKey("planet");

    //ASTEROIDS
    public static ResourceKey<ConfiguredStructureFeature<?, ?>> LARGE_ASTEROID = createKey("large_asteroid");
    public static ResourceKey<ConfiguredStructureFeature<?, ?>> MEDIUM_ASTEROID = createKey("medium_asteroid");
    public static ResourceKey<ConfiguredStructureFeature<?, ?>> SMALL_ASTEROID = createKey("small_asteroid");

    //MAG RAILS
    public static ResourceKey<ConfiguredStructureFeature<?, ?>> MAG_RAIL = createKey("mag_rail");

    //VILLAGES
    public static ResourceKey<ConfiguredStructureFeature<?, ?>> LUNAR_COLONY = createKey("lunar_colony");
    public static ResourceKey<ConfiguredStructureFeature<?, ?>> MARS_COLONY = createKey("mars_colony");
    public static ResourceKey<ConfiguredStructureFeature<?, ?>> MERCURY_COLONY = createKey("mercury_colony");

    //DUNGEONS
    public static ResourceKey<ConfiguredStructureFeature<?, ?>> VENUS_FLARE_TREE = createKey("venus_flare_tree");
    public static ResourceKey<ConfiguredStructureFeature<?, ?>> JUPITER_DUNGEON = createKey("jupiter_dungeon");
    public static ResourceKey<ConfiguredStructureFeature<?, ?>> MARS_LABYRINTH = createKey("mars_labyrinth");


    //RESEARCH TUNNELS
    public static ResourceKey<ConfiguredStructureFeature<?, ?>> RESEARCH_TUNNEL = createKey("research_tunnel");

    //OTHER
    public static ResourceKey<ConfiguredStructureFeature<?, ?>> JUPITER_CLOUD = createKey("jupiter_cloud");
    public static ResourceKey<ConfiguredStructureFeature<?, ?>> LINEAE = createKey("lineae");


}
