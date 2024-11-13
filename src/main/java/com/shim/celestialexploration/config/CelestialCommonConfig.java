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
    public static final ForgeConfigSpec.ConfigValue<Boolean> STORMS;
    public static final ForgeConfigSpec.ConfigValue<Integer> SPACESHIP_LIGHT_TRAVEL_MAX_COOLDOWN;
    public static final ForgeConfigSpec.ConfigValue<Integer> SPACESHIP_LIGHT_TRAVEL_COOLDOWN_DECREMENT;
    public static final ForgeConfigSpec.ConfigValue<Integer> SPACESHIP_LIGHT_TRAVEL_MIN_COOLDOWN;
    public static final ForgeConfigSpec.ConfigValue<Boolean> PORTALS;

    static {
        BUILDER.push("Configs for Celestial Exploration");

        RANGE_OF_SPACE = BUILDER.comment("Size of space (calculated by # of chunks between the sun and Mercury)").defineInRange("Range of Space", 13, 6, 24);
        USE_GRAVITY_EFFECTS = BUILDER.comment("Should the gravity effects (i.e. low gravity on Mars) be applied to players?").define("Gravity Effects", true);
        SPACESHIP_FUEL_RATE = BUILDER.comment("How quickly the spaceship depletes fuel, in # of ticks (higher is slower)").defineInRange("Spaceship Fuel Rate", 60, 20, 200);
        SPACESHIP_SPEED = BUILDER.comment("Speed of the spaceship").defineInRange("Spaceship Speed", 1.0D, 0.40D, 1.80D);
        SPACESHIP_FASTER_IN_SPACE = BUILDER.comment("Should the spaceship move faster through the space dimension?").define("Spaceship Faster in Space", true);
        STORMS = BUILDER.comment("Should there be storms on appropriate planets, i.e. dust storms on Mars? If true, storms will occur when it's raining on the overworld").define("Storms", true);

        SPACESHIP_LIGHT_TRAVEL_MAX_COOLDOWN = BUILDER.comment("What the max cooldown is, in ticks, after the first time you use the spaceship light speed travel to a particular location").defineInRange("Spaceship Max Cooldown", 24000, 6000, 96000);
        SPACESHIP_LIGHT_TRAVEL_COOLDOWN_DECREMENT = BUILDER.comment("How much the max cooldown drops, in ticks, after each subsequent time using spaceship light speed travel to that specific place").defineInRange("Spaceship Cooldown Decrement", 300, 0, 1600);
        SPACESHIP_LIGHT_TRAVEL_MIN_COOLDOWN = BUILDER.comment("What the minimum the spaceship light speed travel cooldown can be, in ticks").defineInRange("Spaceship Min Cooldown", 1200, 300, 1600);

        PORTALS = BUILDER.comment("Allow portals to the various planets and moons?").define("Portals", true);


        BUILDER.pop();
        SPEC = BUILDER.build();
    }
}