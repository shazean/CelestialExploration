package com.shim.celestialexploration.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class CelestialServerConfig {
    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    public static final ForgeConfigSpec.ConfigValue<Boolean> GUST_GRIEFING;

    static {
        BUILDER.push("Configs for Celestial Exploration");

        GUST_GRIEFING = BUILDER.comment("Should the gust explosions break blocks?").define("Gust Griefing", true);

        BUILDER.pop();
        SPEC = BUILDER.build();
    }
}