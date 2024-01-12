package com.shim.celestialexploration.world;

import com.shim.celestialexploration.registry.BiomeRegistry;
import net.minecraft.world.level.biome.Biomes;
import net.minecraftforge.common.BiomeDictionary;

import static net.minecraftforge.common.BiomeDictionary.Type.*;

public class CelestialBiomes extends BiomeDictionary {

    public static final Type MARS = getType("MARS");
    public static final Type MOON = getType("MOON");

    public static final Type SPACE = getType("SPACE");


    static {
        registerBiomes();
    }

    private static void registerBiomes() {
        addTypes(BiomeRegistry.SPACE, SPACE);
        addTypes(BiomeRegistry.MOON_CRATERS, SPACE);
        addTypes(BiomeRegistry.MOON_DESERT, DRY);
    }
}
