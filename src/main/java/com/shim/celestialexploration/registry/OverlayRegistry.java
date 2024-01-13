package com.shim.celestialexploration.registry;

import com.shim.celestialexploration.util.SpaceshipGui;
import net.minecraftforge.client.gui.IIngameOverlay;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

public class OverlayRegistry {

    public static void registerOverlay(FMLClientSetupEvent event) {
        net.minecraftforge.client.gui.OverlayRegistry.registerOverlayTop("Spaceship Fuel Level", SPACESHIP_FUEL_ELEMENT);
    }

    public static final IIngameOverlay SPACESHIP_FUEL_ELEMENT = new SpaceshipGui();
}
