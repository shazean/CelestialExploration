package com.shim.celestialexploration.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class CelestialCommonConfig {
    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    public static final ForgeConfigSpec.ConfigValue<Integer> RANGE_OF_SPACE;
    public static final ForgeConfigSpec.ConfigValue<Boolean> USE_GRAVITY_EFFECTS;
    public static final ForgeConfigSpec.ConfigValue<Integer> SHUTTLE_FUEL_RATE;

    static {
        BUILDER.push("Configs for Celestial Exploration");

        RANGE_OF_SPACE = BUILDER.comment("Size of space (calculated by # of chunks between the sun and Mercury)").defineInRange("Range of Space", 14, 6, 24);
        USE_GRAVITY_EFFECTS = BUILDER.comment("Should the gravity effects (i.e. low gravity on Mars) be applied to players?").define("Gravity Effects", true);
        SHUTTLE_FUEL_RATE = BUILDER.comment("How quickly the shuttle depletes fuel, in # of ticks (higher is slower)").defineInRange("Shuttle Fuel Rate", 50, 20, 200);

        BUILDER.pop();
        SPEC = BUILDER.build();
    }
}