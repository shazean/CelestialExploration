package com.shim.celestialexploration.registry;


import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestialexploration.world.structures.*;
import net.minecraft.world.level.levelgen.feature.StructureFeature;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class StructureRegistry {

    public static final DeferredRegister<StructureFeature<?>> DEFERRED_REGISTRY_STRUCTURE = DeferredRegister.create(ForgeRegistries.STRUCTURE_FEATURES, CelestialExploration.MODID);

    //CRATERS
//    public static final RegistryObject<StructureFeature<?>> SMALL_CRATER = DEFERRED_REGISTRY_STRUCTURE.register("small_crater", SmallCraterStructure::new);
//    public static final RegistryObject<StructureFeature<?>> MEDIUM_CRATER = DEFERRED_REGISTRY_STRUCTURE.register("medium_crater", MediumCraterStructure::new);
    public static final RegistryObject<StructureFeature<?>> LARGE_CRATER = DEFERRED_REGISTRY_STRUCTURE.register("large_crater", LargeCraterStructure::new);

    //PLANETS
    public static final RegistryObject<StructureFeature<?>> SUN = DEFERRED_REGISTRY_STRUCTURE.register("sun", SunStructure::new);
    public static final RegistryObject<StructureFeature<?>> MERCURY = DEFERRED_REGISTRY_STRUCTURE.register("mercury", MercuryStructure::new);
    public static final RegistryObject<StructureFeature<?>> VENUS = DEFERRED_REGISTRY_STRUCTURE.register("venus", VenusStructure::new);
    public static final RegistryObject<StructureFeature<?>> EARTH = DEFERRED_REGISTRY_STRUCTURE.register("earth", EarthStructure::new);
    public static final RegistryObject<StructureFeature<?>> MARS = DEFERRED_REGISTRY_STRUCTURE.register("mars", MarsStructure::new);
    public static final RegistryObject<StructureFeature<?>> JUPITER = DEFERRED_REGISTRY_STRUCTURE.register("jupiter", JupiterStructure::new);
    public static final RegistryObject<StructureFeature<?>> SATURN = DEFERRED_REGISTRY_STRUCTURE.register("saturn", SaturnStructure::new);
    public static final RegistryObject<StructureFeature<?>> URANUS = DEFERRED_REGISTRY_STRUCTURE.register("uranus", UranusStructure::new);
    public static final RegistryObject<StructureFeature<?>> NEPTUNE = DEFERRED_REGISTRY_STRUCTURE.register("neptune", NeptuneStructure::new);

    //ASTEROIDS
    public static final RegistryObject<StructureFeature<?>> LARGE_ASTEROID = DEFERRED_REGISTRY_STRUCTURE.register("large_asteroid", LargeAsteroidStructure::new);
    public static final RegistryObject<StructureFeature<?>> MEDIUM_ASTEROID = DEFERRED_REGISTRY_STRUCTURE.register("medium_asteroid", MediumAsteroidStructure::new);
    public static final RegistryObject<StructureFeature<?>> SMALL_ASTEROID = DEFERRED_REGISTRY_STRUCTURE.register("small_asteroid", SmallAsteroidStructure::new);


    //VILLAGES - LUNAR
    public static final RegistryObject<StructureFeature<?>> LUNAR_COLONY = DEFERRED_REGISTRY_STRUCTURE.register("lunar_colony", LunarColonyStructure::new);

}