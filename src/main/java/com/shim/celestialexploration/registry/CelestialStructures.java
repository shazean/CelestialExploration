package com.shim.celestialexploration.registry;


import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestialexploration.world.structures.*;
import com.shim.celestialexploration.world.structures.space.*;
import com.shim.celestiallib.api.world.structure.PlanetStructure;
import net.minecraft.world.level.levelgen.feature.StructureFeature;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class CelestialStructures {

    public static final DeferredRegister<StructureFeature<?>> DEFERRED_REGISTRY_STRUCTURE = DeferredRegister.create(ForgeRegistries.STRUCTURE_FEATURES, CelestialExploration.MODID);

    //CRATERS
    public static final RegistryObject<StructureFeature<?>> TINY_CRATER = DEFERRED_REGISTRY_STRUCTURE.register("tiny_crater", TinyCraterStructure::new);
    public static final RegistryObject<StructureFeature<?>> SMALL_CRATER = DEFERRED_REGISTRY_STRUCTURE.register("small_crater", SmallCraterStructure::new);
    public static final RegistryObject<StructureFeature<?>> MEDIUM_CRATER = DEFERRED_REGISTRY_STRUCTURE.register("medium_crater", MediumCraterStructure::new);
    public static final RegistryObject<StructureFeature<?>> LARGE_CRATER = DEFERRED_REGISTRY_STRUCTURE.register("large_crater", LargeCraterStructure::new);

    //PLANETS/CELESTIAL BODIES
    public static final RegistryObject<StructureFeature<?>> SUN = DEFERRED_REGISTRY_STRUCTURE.register("sun", SunStructure::new);
    public static final RegistryObject<StructureFeature<?>> SUN_TOP = DEFERRED_REGISTRY_STRUCTURE.register("sun_top", SunTopStructure::new);

//    public static final RegistryObject<StructureFeature<?>> MERCURY = DEFERRED_REGISTRY_STRUCTURE.register("mercury", MercuryStructure::new);
//    public static final RegistryObject<StructureFeature<?>> VENUS = DEFERRED_REGISTRY_STRUCTURE.register("venus", VenusStructure::new);
//    public static final RegistryObject<StructureFeature<?>> EARTH = DEFERRED_REGISTRY_STRUCTURE.register("earth", EarthStructure::new);
//    public static final RegistryObject<StructureFeature<?>> MARS = DEFERRED_REGISTRY_STRUCTURE.register("mars", MarsStructure::new);
//    public static final RegistryObject<StructureFeature<?>> JUPITER = DEFERRED_REGISTRY_STRUCTURE.register("jupiter", JupiterStructure::new);
    public static final RegistryObject<StructureFeature<?>> SATURN = DEFERRED_REGISTRY_STRUCTURE.register("saturn", SaturnStructure::new);
    public static final RegistryObject<StructureFeature<?>> TITAN = DEFERRED_REGISTRY_STRUCTURE.register("titan", TitanStructure::new);
    public static final RegistryObject<StructureFeature<?>> IAPETUS = DEFERRED_REGISTRY_STRUCTURE.register("iapetus", IapetusStructure::new);

    public static final RegistryObject<StructureFeature<?>> URANUS = DEFERRED_REGISTRY_STRUCTURE.register("uranus", UranusStructure::new);
    public static final RegistryObject<StructureFeature<?>> NEPTUNE = DEFERRED_REGISTRY_STRUCTURE.register("neptune", NeptuneStructure::new);

    public static final RegistryObject<StructureFeature<?>> PLANET = DEFERRED_REGISTRY_STRUCTURE.register("planet", PlanetStructure::new);

    //ASTEROIDS
    public static final RegistryObject<StructureFeature<?>> LARGE_ASTEROID = DEFERRED_REGISTRY_STRUCTURE.register("large_asteroid", LargeAsteroidStructure::new);
    public static final RegistryObject<StructureFeature<?>> MEDIUM_ASTEROID = DEFERRED_REGISTRY_STRUCTURE.register("medium_asteroid", MediumAsteroidStructure::new);
    public static final RegistryObject<StructureFeature<?>> SMALL_ASTEROID = DEFERRED_REGISTRY_STRUCTURE.register("small_asteroid", SmallAsteroidStructure::new);

    //MAG RAILS
    public static final RegistryObject<StructureFeature<?>> MAG_RAIL = DEFERRED_REGISTRY_STRUCTURE.register("mag_rail", MagRailStructure::new);

    //VILLAGES
    public static final RegistryObject<StructureFeature<?>> LUNAR_COLONY = DEFERRED_REGISTRY_STRUCTURE.register("lunar_colony", LunarColonyStructure::new);
    public static final RegistryObject<StructureFeature<?>> MARS_COLONY = DEFERRED_REGISTRY_STRUCTURE.register("mars_colony", MarsColonyStructure::new);
    public static final RegistryObject<StructureFeature<?>> MERCURY_COLONY = DEFERRED_REGISTRY_STRUCTURE.register("mercury_colony", MercuryColonyStructure::new);

    //DUNGEONS
    public static final RegistryObject<StructureFeature<?>> VENUS_FLARE_TREE = DEFERRED_REGISTRY_STRUCTURE.register("venus_flare_tree", VenusFlareTreeStructure::new);
    public static final RegistryObject<StructureFeature<?>> JUPITER_DUNGEON = DEFERRED_REGISTRY_STRUCTURE.register("jupiter_dungeon", JupiterDungeonStructure::new);
    public static final RegistryObject<StructureFeature<?>> MARS_LABYRINTH = DEFERRED_REGISTRY_STRUCTURE.register("mars_labyrinth", MarsLabyrinthStructure::new);


    //RESEARCH TUNNELS
    public static final RegistryObject<StructureFeature<?>> RESEARCH_TUNNEL = DEFERRED_REGISTRY_STRUCTURE.register("research_tunnel", ResearchTunnelStructure::new);

    public static final RegistryObject<StructureFeature<?>> SOLAR_FIELD = DEFERRED_REGISTRY_STRUCTURE.register("solar_field", SolarFieldStructure::new);


    //OTHER
    public static final RegistryObject<StructureFeature<?>> JUPITER_CLOUD = DEFERRED_REGISTRY_STRUCTURE.register("jupiter_cloud", JupiterCloudStructure::new);
    public static final RegistryObject<StructureFeature<?>> LINEAE = DEFERRED_REGISTRY_STRUCTURE.register("lineae", LineaeStructure::new);

    public static final RegistryObject<StructureFeature<?>> VOLCANO = DEFERRED_REGISTRY_STRUCTURE.register("volcano", VolcanoStructure::new);


}