package com.shim.celestialexploration.registry;


import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestialexploration.world.structures.LargeCraterStructure;
import com.shim.celestialexploration.world.structures.SmallCraterStructure;
import com.shim.celestialexploration.world.structures.MediumCraterStructure;
import net.minecraft.world.level.levelgen.feature.StructureFeature;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class StructureRegistry {

    /**
     * We are using the Deferred Registry system to register our structure as this is the preferred way on Forge.
     * This will handle registering the base structure for us at the correct time so we don't have to handle it ourselves.
     *
     * HOWEVER, do note that Deferred Registries only work for anything that is a Forge Registry. This means that
     * configured structures and configured features need to be registered directly to BuiltinRegistries as there
     * is no Deferred Registry system for them.
     */
    public static final DeferredRegister<StructureFeature<?>> DEFERRED_REGISTRY_STRUCTURE = DeferredRegister.create(ForgeRegistries.STRUCTURE_FEATURES, CelestialExploration.MODID);

    /**
     * Registers the base structure itself and sets what its path is. In this case,
     * this base structure will have the resourcelocation of structure_tutorial:sky_structures.
     */
//    public static final RegistryObject<StructureFeature<?>> SKY_STRUCTURES = DEFERRED_REGISTRY_STRUCTURE.register("sky_structures", SkyStructures::new);
//    public static final RegistryObject<StructureFeature<?>> SMALL_CRATER = DEFERRED_REGISTRY_STRUCTURE.register("small_crater", SmallCraterStructure::new);
//    public static final RegistryObject<StructureFeature<?>> MEDIUM_CRATER = DEFERRED_REGISTRY_STRUCTURE.register("medium_crater", MediumCraterStructure::new);
    public static final RegistryObject<StructureFeature<?>> LARGE_CRATER = DEFERRED_REGISTRY_STRUCTURE.register("large_crater", LargeCraterStructure::new);

}
