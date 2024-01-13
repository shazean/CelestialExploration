package com.shim.celestialexploration.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class CelestialCommonConfig {
    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    public static final ForgeConfigSpec.ConfigValue<Integer> RANGE_OF_SPACE;
    public static final ForgeConfigSpec.ConfigValue<Boolean> USE_GRAVITY_EFFECTS;
    public static final ForgeConfigSpec.ConfigValue<Integer> SPACESHIP_FUEL_RATE;
    public static final ForgeConfigSpec.ConfigValue<Double> SPACESHIP_SPEED;
    public static final ForgeConfigSpec.ConfigValue<Boolean> SPACESHIP_FASTER_IN_SPACE;


    static {
        BUILDER.push("Configs for Celestial Exploration");

        RANGE_OF_SPACE = BUILDER.comment("Size of space (calculated by # of chunks between the sun and Mercury)").defineInRange("Range of Space", 10, 6, 24);
        USE_GRAVITY_EFFECTS = BUILDER.comment("Should the gravity effects (i.e. low gravity on Mars) be applied to players?").define("Gravity Effects", true);
        SPACESHIP_FUEL_RATE = BUILDER.comment("How quickly the spaceship depletes fuel, in # of ticks (higher is slower)").defineInRange("Spaceship Fuel Rate", 50, 20, 200);
        SPACESHIP_SPEED = BUILDER.comment("Speed of the spaceship").defineInRange("Spaceship Speed", 0.580D, 0.40D, 0.70D);
        SPACESHIP_FASTER_IN_SPACE = BUILDER.comment("Should the spaceship move faster through the space dimension?").define("Spaceship Faster in Space", true);


        BUILDER.pop();
        SPEC = BUILDER.build();
    }
}