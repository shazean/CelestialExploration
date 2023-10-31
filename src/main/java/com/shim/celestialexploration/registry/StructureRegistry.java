package com.shim.celestialexploration.registry;


import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestialexploration.world.structures.EarthStructure;
import com.shim.celestialexploration.world.structures.LargeCraterStructure;
import com.shim.celestialexploration.world.structures.MarsStructure;
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
    public static final RegistryObject<StructureFeature<?>> MARS = DEFERRED_REGISTRY_STRUCTURE.register("mars", MarsStructure::new);
    public static final RegistryObject<StructureFeature<?>> EARTH = DEFERRED_REGISTRY_STRUCTURE.register("earth", EarthStructure::new);

}