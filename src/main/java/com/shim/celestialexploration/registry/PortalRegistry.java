package com.shim.celestialexploration.registry;

import com.shim.celestialexploration.CelestialExploration;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class PortalRegistry {
    public static final DeferredRegister<PoiType> POI
            = DeferredRegister.create(ForgeRegistries.POI_TYPES, CelestialExploration.MODID);

    public static final RegistryObject<PoiType> MARS_PORTAL =
            POI.register("mars_portal", () -> new PoiType("mars_portal",
                    PoiType.getBlockStates(BlockRegistry.MARS_PORTAL.get()), 0, 1));

    public static final RegistryObject<PoiType> MOON_PORTAL =
            POI.register("moon_portal", () -> new PoiType("moon_portal",
                    PoiType.getBlockStates(BlockRegistry.MOON_PORTAL.get()), 0, 1));

    public static final RegistryObject<PoiType> VENUS_PORTAL =
            POI.register("venus_portal", () -> new PoiType("venus_portal",
                    PoiType.getBlockStates(BlockRegistry.VENUS_PORTAL.get()), 0, 1));


    public static void register(IEventBus eventBus) {
        POI.register(eventBus);
    }
}