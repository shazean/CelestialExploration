package com.shim.celestialexploration.registry;

import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestialexploration.blocks.AbstractPortalBlock;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.util.ObfuscationReflectionHelper;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.lang.reflect.InvocationTargetException;
import java.util.function.Supplier;

public class CelestialPOIs {
    public static final DeferredRegister<PoiType> POI = DeferredRegister.create(ForgeRegistries.POI_TYPES, CelestialExploration.MODID);

    //---- PORTALS -------------------------------------------------------------------------------
    public static final RegistryObject<PoiType> MARS_PORTAL = POI.register("mars_portal", () -> new PoiType("mars_portal", PoiType.getBlockStates(CelestialBlocks.MARS_PORTAL.get()), 0, 1));
    public static final RegistryObject<PoiType> MOON_PORTAL = POI.register("moon_portal", () -> new PoiType("moon_portal", PoiType.getBlockStates(CelestialBlocks.MOON_PORTAL.get()), 0, 1));
    public static final RegistryObject<PoiType> VENUS_PORTAL = POI.register("venus_portal", () -> new PoiType("venus_portal", PoiType.getBlockStates(CelestialBlocks.VENUS_PORTAL.get()), 0, 1));
    public static final RegistryObject<PoiType> MERCURY_PORTAL = POI.register("mercury_portal", () -> new PoiType("mercury_portal", PoiType.getBlockStates(CelestialBlocks.MERCURY_PORTAL.get()), 0, 1));
    public static final RegistryObject<PoiType> JUPITER_PORTAL = POI.register("jupiter_portal", () -> new PoiType("jupiter_portal", PoiType.getBlockStates(CelestialBlocks.JUPITER_PORTAL.get()), 0, 1));
    public static final RegistryObject<PoiType> EUROPA_PORTAL = POI.register("europa_portal", () -> new PoiType("europa_portal", PoiType.getBlockStates(CelestialBlocks.EUROPA_PORTAL.get()), 0, 1));
    public static final RegistryObject<PoiType> CALLISTO_PORTAL = POI.register("callisto_portal", () -> new PoiType("callisto_portal", PoiType.getBlockStates(CelestialBlocks.CALLISTO_PORTAL.get()), 0, 1));
    public static final RegistryObject<PoiType> IO_PORTAL = POI.register("io_portal", () -> new PoiType("io_portal", PoiType.getBlockStates(CelestialBlocks.IO_PORTAL.get()), 0, 1));
    public static final RegistryObject<PoiType> GANYMEDE_PORTAL = POI.register("ganymede", () -> new PoiType("ganymede_portal", PoiType.getBlockStates(CelestialBlocks.GANYMEDE_PORTAL.get()), 0, 1));

    //---- VILLAGER PROFESSIONS -------------------------------------------------------------------------------
    public static final RegistryObject<PoiType> ASTRONOMY_POI = POI.register("astronomy_poi", () -> new PoiType("astronomy_poi", PoiType.getBlockStates(CelestialBlocks.PLANET_CHART.get()), 1, 1));
    public static final RegistryObject<PoiType> ENGINEER_POI = POI.register("engineer_poi", () -> new PoiType("engineer_poi", PoiType.getBlockStates(CelestialBlocks.WORKBENCH.get()), 1, 1));
//    public static final RegistryObject<PoiType> GEOLOGIST_POI = POI_TYPES.register("geologist_poi", () -> new PoiType("geologist_poi", PoiType.getBlockStates(BlockRegistry.GRINDING_WHEEL.get()), 1, 1));  //TODO crushing wheel?
//    public static final RegistryObject<PoiType> CHEF_POI = POI_TYPES.register("chef_poi", () -> new PoiType("chef_poi", PoiType.getBlockStates(Blocks.FURNACE), 1, 1)); //TODO

    public static void registerPOIs() {
        try {
            ObfuscationReflectionHelper.findMethod(PoiType.class, "registerBlockStates", PoiType.class).invoke(null, CelestialPOIs.ASTRONOMY_POI.get());
            ObfuscationReflectionHelper.findMethod(PoiType.class, "registerBlockStates", PoiType.class).invoke(null, CelestialPOIs.ENGINEER_POI.get());
//            ObfuscationReflectionHelper.findMethod(PoiType.class, "registerBlockStates", PoiType.class).invoke(null, GEOLOGIST_POI.get());
//            ObfuscationReflectionHelper.findMethod(PoiType.class, "registerBlockStates", PoiType.class).invoke(null, BAKER_POI.get());
        } catch(InvocationTargetException | IllegalAccessException exception) {
            exception.printStackTrace();
        }
    }
}