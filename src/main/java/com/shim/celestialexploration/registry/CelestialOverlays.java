package com.shim.celestialexploration.registry;

import com.shim.celestialexploration.util.OxygenGui;
import com.shim.celestialexploration.util.SpaceshipGui;
import net.minecraftforge.client.gui.IIngameOverlay;
import net.minecraftforge.client.gui.OverlayRegistry;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

public class CelestialOverlays {

    public static void registerOverlay(FMLClientSetupEvent event) {
        OverlayRegistry.registerOverlayTop("Spaceship Fuel Level", SPACESHIP_FUEL_ELEMENT);
        OverlayRegistry.registerOverlayTop("Oxygen", OXYGEN_GUI);
    }

    public static final IIngameOverlay SPACESHIP_FUEL_ELEMENT = new SpaceshipGui();
    public static final IIngameOverlay OXYGEN_GUI = new OxygenGui();


}
