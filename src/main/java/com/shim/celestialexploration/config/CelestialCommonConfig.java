package com.shim.celestialexploration.config;

import com.shim.celestialexploration.util.OxygenDamage;
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
    public static final ForgeConfigSpec.ConfigValue<Boolean> METEORS_EXPLODE;
    public static final ForgeConfigSpec.ConfigValue<Boolean> GUST_GRIEFING;
    public static final ForgeConfigSpec.ConfigValue<Integer> SPACESHIP_LIGHT_TRAVEL_MAX_COOLDOWN;
    public static final ForgeConfigSpec.ConfigValue<Integer> SPACESHIP_LIGHT_TRAVEL_COOLDOWN_DECREMENT;
    public static final ForgeConfigSpec.ConfigValue<Integer> SPACESHIP_LIGHT_TRAVEL_MIN_COOLDOWN;
    public static final ForgeConfigSpec.ConfigValue<Boolean> PORTALS;
    public static final ForgeConfigSpec.EnumValue<OxygenDamage> OXYGEN_DAMAGE_TYPE;
    public static final ForgeConfigSpec.ConfigValue<Boolean> OXYGEN_DEBUFF;
    public static final ForgeConfigSpec.ConfigValue<Boolean> OXYGEN_MECHANIC_ENABLED;
    public static final ForgeConfigSpec.ConfigValue<Boolean> OXYGEN_SCALES_WITH_DIFFICULTY;

    static {
        BUILDER.push("Configs for Celestial Exploration");

        RANGE_OF_SPACE = BUILDER.comment("Size of space (calculated by # of chunks between the sun and Mercury) **Must be defined before the dimension is loaded for the first time!**").defineInRange("Range of Space", 13, 6, 24);
        USE_GRAVITY_EFFECTS = BUILDER.comment("Should the gravity effects (i.e. low gravity on Mars) be applied to players?").define("Gravity Effects", true);
        STORMS = BUILDER.comment("Should there be storms on appropriate planets, i.e. dust storms on Mars? If true, storms will occur when it's raining on the overworld").define("Storms", true);
        METEORS_EXPLODE = BUILDER.comment("Should meteors cause an explosion when they hit the ground? (Like creeper explosions)").define("Meteor Explosions", true);
        GUST_GRIEFING = BUILDER.comment("Should the gust explosions break blocks?").define("Gust Griefing", true);
        PORTALS = BUILDER.comment("Allow portals to the various planets and moons?").define("Portals", true);

        BUILDER.push("Spaceship");
        SPACESHIP_FUEL_RATE = BUILDER.comment("How quickly the spaceship depletes fuel, in # of ticks (higher is slower)").defineInRange("Spaceship Fuel Rate", 60, 20, 200);
        SPACESHIP_SPEED = BUILDER.comment("Speed of the spaceship").defineInRange("Spaceship Speed", 1.0D, 0.40D, 1.80D);
        SPACESHIP_FASTER_IN_SPACE = BUILDER.comment("Should the spaceship move faster through the space dimension?").define("Spaceship Faster in Space", true);
        SPACESHIP_LIGHT_TRAVEL_MAX_COOLDOWN = BUILDER.comment("What the max cooldown is, in ticks, after the first time you use the spaceship light speed travel to a particular location").defineInRange("Spaceship Max Cooldown", 24000, 6000, 96000);
        SPACESHIP_LIGHT_TRAVEL_COOLDOWN_DECREMENT = BUILDER.comment("How much the max cooldown drops, in ticks, after each subsequent time using spaceship light speed travel to that specific place").defineInRange("Spaceship Cooldown Decrement", 300, 0, 1600);
        SPACESHIP_LIGHT_TRAVEL_MIN_COOLDOWN = BUILDER.comment("What the minimum the spaceship light speed travel cooldown can be, in ticks").defineInRange("Spaceship Min Cooldown", 1200, 300, 2000);
        BUILDER.pop();


        BUILDER.push("Oxygen");
        OXYGEN_MECHANIC_ENABLED = BUILDER.comment("Should oxygen mechanic be used? If false, below values will be ignored. Turning this off also allows oxygen compressor to produce liquid oxygen in any dimension, without an oxygen generator.")
                .define("Oxygen Mechanic Enabled", true);
        OXYGEN_SCALES_WITH_DIFFICULTY = BUILDER.comment("If true, the below oxygen values will be applied to \"normal mode\" and scale accordingly for peaceful, easy, and hard modes. If false, the below values will be used regardless of difficulty.")
                .define("Oxygen Scales With Game Difficulty?", true);
        OXYGEN_DAMAGE_TYPE = BUILDER.comment("What should happen when a player runs out of oxygen in outer space? Options are take full, fatal damage, take damage until a half a heart remaining, or take no damage at all.")
                .defineEnum("Oxygen Damage Type", OxygenDamage.FULL, OxygenDamage.FULL, OxygenDamage.HALF_HEART, OxygenDamage.NONE);
        OXYGEN_DEBUFF = BUILDER.comment("Should running out of oxygen apply a debuff to the player until oxygen is restored? Off by default.")
                .define("Suffocation Debuff", false);
        BUILDER.pop();

        BUILDER.pop();
        SPEC = BUILDER.build();
    }
}