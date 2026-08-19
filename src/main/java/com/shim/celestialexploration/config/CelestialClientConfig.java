package com.shim.celestialexploration.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class CelestialClientConfig {
    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    public static final ForgeConfigSpec.EnumValue<hudCorner> HUD_LOCATION;
    public static final ForgeConfigSpec.ConfigValue<Boolean> HUD_IN_CREATIVE;
    public static final ForgeConfigSpec.ConfigValue<Boolean> CUSTOM_TERRAIN_LOADING_SCREEN;

    static {
        BUILDER.push("Configs for Celestial Exploration");

        HUD_LOCATION = BUILDER.comment("Which corner the spaceship's speedometer/altimeter should appear in")
                .defineEnum("Corner for Spaceship HUD", hudCorner.BOTTOM_LEFT, hudCorner.TOP_RIGHT, hudCorner.TOP_LEFT, hudCorner.BOTTOM_LEFT, hudCorner.BOTTOM_RIGHT);
        HUD_IN_CREATIVE = BUILDER.comment("Whether the spaceship's HUD should be displayed in creative mode?").define("Spaceship HUD in Creative Mode", true);
        CUSTOM_TERRAIN_LOADING_SCREEN = BUILDER.comment("Should a custom loading screen be used when changing dimensions?").define("Custom terrain loading screen", true);

        BUILDER.pop();
        SPEC = BUILDER.build();
    }

    public enum hudCorner {
        TOP_RIGHT,
        TOP_LEFT,
        BOTTOM_LEFT,
        BOTTOM_RIGHT
    }
}