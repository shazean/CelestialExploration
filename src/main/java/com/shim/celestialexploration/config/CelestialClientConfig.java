package com.shim.celestialexploration.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class CelestialClientConfig {
    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    static {
        BUILDER.push("Configs for Celestial Exploration");

        BUILDER.pop();
        SPEC = BUILDER.build();
    }
}