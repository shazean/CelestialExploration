package com.shim.celestialexploration.world;

import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestialexploration.world.features.CelestialOreGeneration;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = CelestialExploration.MODID)
public class CelestialWorldEvents {

    @SubscribeEvent
    public static void biomeLoadingEvent(final BiomeLoadingEvent event) {
        CelestialOreGeneration.generateOres(event);
    }

}
