package com.shim.celestialexploration.registry;

import com.shim.celestialexploration.CelestialExploration;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.util.ObfuscationReflectionHelper;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.lang.reflect.InvocationTargetException;

public class PoiRegistry {

    //---- PORTALS -------------------------------------------------------------------------------
    public static final DeferredRegister<PoiType> POI = DeferredRegister.create(ForgeRegistries.POI_TYPES, CelestialExploration.MODID);

    public static final RegistryObject<PoiType> MARS_PORTAL = POI.register("mars_portal", () -> new PoiType("mars_portal",
                    PoiType.getBlockStates(BlockRegistry.MARS_PORTAL.get()), 0, 1));

    public static final RegistryObject<PoiType> MOON_PORTAL = POI.register("moon_portal", () -> new PoiType("moon_portal",
                    PoiType.getBlockStates(BlockRegistry.MOON_PORTAL.get()), 0, 1));

    public static final RegistryObject<PoiType> VENUS_PORTAL = POI.register("venus_portal", () -> new PoiType("venus_portal",
                    PoiType.getBlockStates(BlockRegistry.VENUS_PORTAL.get()), 0, 1));

    public static final RegistryObject<PoiType> MERCURY_PORTAL = POI.register("mercury_portal", () -> new PoiType("mercury_portal",
            PoiType.getBlockStates(BlockRegistry.MERCURY_PORTAL.get()), 0, 1));

    public static final RegistryObject<PoiType> JUPITER_PORTAL = POI.register("jupiter_portal", () -> new PoiType("jupiter_portal",
            PoiType.getBlockStates(BlockRegistry.JUPITER_PORTAL.get()), 0, 1));

    public static final RegistryObject<PoiType> EUROPA_PORTAL = POI.register("europa_portal", () -> new PoiType("europa_portal",
            PoiType.getBlockStates(BlockRegistry.EUROPA_PORTAL.get()), 0, 1));


    //---- VILLAGERS -------------------------------------------------------------------------------
    public static final RegistryObject<PoiType> ASTRONOMY_POI = POI.register("astronomy_poi",
            () -> new PoiType("astronomy_poi", PoiType.getBlockStates(BlockRegistry.PLANET_CHART.get()), 1, 1));

    public static final RegistryObject<PoiType> ENGINEER_POI = POI.register("engineer_poi",
            () -> new PoiType("engineer_poi", PoiType.getBlockStates(BlockRegistry.WORKBENCH.get()), 1, 1));

//    public static final RegistryObject<PoiType> GEOLOGIST_POI = POI_TYPES.register("geologist_poi", () -> new PoiType("geologist_poi", PoiType.getBlockStates(BlockRegistry.GRINDING_WHEEL.get()), 1, 1));  //TODO crushing wheel?
//    public static final RegistryObject<PoiType> CHEF_POI = POI_TYPES.register("chef_poi", () -> new PoiType("chef_poi", PoiType.getBlockStates(Blocks.FURNACE), 1, 1)); //TODO

    public static void registerPOIs() {
        try {
            ObfuscationReflectionHelper.findMethod(PoiType.class, "registerBlockStates", PoiType.class).invoke(null, PoiRegistry.ASTRONOMY_POI.get());
            ObfuscationReflectionHelper.findMethod(PoiType.class, "registerBlockStates", PoiType.class).invoke(null, PoiRegistry.ENGINEER_POI.get());
//            ObfuscationReflectionHelper.findMethod(PoiType.class, "registerBlockStates", PoiType.class).invoke(null, GEOLOGIST_POI.get());
//            ObfuscationReflectionHelper.findMethod(PoiType.class, "registerBlockStates", PoiType.class).invoke(null, BAKER_POI.get());
        } catch(InvocationTargetException | IllegalAccessException exception) {
            exception.printStackTrace();
        }
    }

    public static void register(IEventBus eventBus) {
        POI.register(eventBus);
    }
}