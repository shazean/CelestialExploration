package com.shim.celestialexploration.util;

import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestialexploration.entity.Shuttle;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraftforge.client.ClientRegistry;
import org.lwjgl.glfw.GLFW;

public class Keybinds {

    public static final KeyMapping DESCEND_KEY = keymap("flight_descent", GLFW.GLFW_KEY_X, "key.categories.movement");
    public static final KeyMapping ASCEND_KEY = keymap("flight_ascent", GLFW.GLFW_KEY_SPACE, "key.categories.movement");
//    public static final KeyMapping CAMERA_CONTROLS = keymap("camera_flight", GLFW.GLFW_KEY_F6, "key.categories.movement");

    @SuppressWarnings({"ConstantConditions"})
    private static KeyMapping keymap(String name, int defaultMapping, String category)
    {
        var keymap = new KeyMapping(String.format("key.%s.%s", CelestialExploration.MODID, name), defaultMapping, category);
        ClientRegistry.registerKeyBinding(keymap);
        return keymap;
    }

    public static void handleKeyPress(int key, int action) {
//        if (key == CAMERA_CONTROLS.getKey().getValue()
//                && action == GLFW.GLFW_PRESS
//                && Minecraft.getInstance().player.getVehicle() instanceof Shuttle d)
//        {
//            DMLConfig.cameraFlight = !DMLConfig.cameraFlight();
//            Minecraft.getInstance().player.displayClientMessage(new TranslatableComponent("mount.dragon.camera_controls." + (DMLConfig.cameraFlight()? "enabled" : "disabled"), d.getDisplayName()), true);
//        }
    }
}