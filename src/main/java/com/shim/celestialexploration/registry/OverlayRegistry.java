package com.shim.celestialexploration.registry;

import com.shim.celestialexploration.util.ShuttleGui;
import net.minecraftforge.client.gui.IIngameOverlay;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

public class OverlayRegistry {

    public static void registerOverlay(FMLClientSetupEvent event) {
        net.minecraftforge.client.gui.OverlayRegistry.registerOverlayTop("Shuttle Fuel Level", SHUTTLE_FUEL_ELEMENT);
    }

    public static final IIngameOverlay SHUTTLE_FUEL_ELEMENT = new ShuttleGui();
}
