package com.shim.celestialexploration.util;

import com.shim.celestialexploration.CelestialExploration;
import net.minecraft.client.KeyMapping;
import net.minecraftforge.client.ClientRegistry;
import org.lwjgl.glfw.GLFW;

public class Keybinds {

    public static final KeyMapping DESCEND_KEY = keymap("flight_descent", GLFW.GLFW_KEY_LEFT_SHIFT, "key.categories.spaceship_controls");
    public static final KeyMapping ASCEND_KEY = keymap("flight_ascent", GLFW.GLFW_KEY_SPACE, "key.categories.spaceship_controls");
    public static final KeyMapping TURN_LEFT_KEY = keymap("turn_left", GLFW.GLFW_KEY_A, "key.categories.spaceship_controls");
    public static final KeyMapping TURN_RIGHT_KEY = keymap("turn_right", GLFW.GLFW_KEY_D, "key.categories.spaceship_controls");
    public static final KeyMapping OPEN_SPACESHIP_INVENTORY = keymap("open_spaceship_inventory", GLFW.GLFW_KEY_I, "key.categories.spaceship_inventory");

    private static KeyMapping keymap(String name, int defaultMapping, String category)
    {
        var keymap = new KeyMapping(String.format("key.%s.%s", CelestialExploration.MODID, name), defaultMapping, category);
        ClientRegistry.registerKeyBinding(keymap);
        return keymap;
    }

    public static void handleKeyPress(int key, int action) {
    }
}