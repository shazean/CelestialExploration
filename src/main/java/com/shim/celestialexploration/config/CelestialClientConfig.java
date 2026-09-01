package com.shim.celestialexploration.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class CelestialClientConfig {
    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    public static final ForgeConfigSpec.EnumValue<HudCorner> HUD_LOCATION;
    public static final ForgeConfigSpec.ConfigValue<Boolean> HUD_IN_CREATIVE;
    public static final ForgeConfigSpec.ConfigValue<Boolean> CUSTOM_TERRAIN_LOADING_SCREEN;
    public static final ForgeConfigSpec.EnumValue<OxygenDisplay> OXYGEN_LOCATION;

    static {
        BUILDER.push("Configs for Celestial Exploration");

        HUD_LOCATION = BUILDER.comment("Which corner the spaceship's speedometer/altimeter should appear in?")
                .defineEnum("Corner for Spaceship HUD", HudCorner.BOTTOM_LEFT, HudCorner.TOP_RIGHT, HudCorner.TOP_LEFT, HudCorner.BOTTOM_LEFT, HudCorner.BOTTOM_RIGHT);
        HUD_IN_CREATIVE = BUILDER.comment("Whether the spaceship's HUD should be displayed in creative mode?").define("Spaceship HUD in Creative Mode", true);
        CUSTOM_TERRAIN_LOADING_SCREEN = BUILDER.comment("Should a custom loading screen be used when changing dimensions?").define("Custom terrain loading screen", true);
        OXYGEN_LOCATION = BUILDER.comment("Which side of the hotbar should the oxygen display appear on?")
                .defineEnum("Oxygen Quantity Display", OxygenDisplay.RIGHT, OxygenDisplay.LEFT, OxygenDisplay.RIGHT);

        BUILDER.pop();
        SPEC = BUILDER.build();
    }

    public enum HudCorner {
        TOP_RIGHT,
        TOP_LEFT,
        BOTTOM_LEFT,
        BOTTOM_RIGHT
    }

    public enum OxygenDisplay {
        LEFT,
        RIGHT
    }
}