package com.shim.celestialexploration.util;

import com.shim.celestialexploration.registry.CelestialDimensions;
import it.unimi.dsi.fastutil.objects.Object2ObjectArrayMap;
import net.minecraft.Util;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.Level;

import java.util.Map;


public class DimensionUtil {
    private static final Map<ResourceKey<Level>, gravityType> DIMENSION_GRAVITY = Util.make(new Object2ObjectArrayMap<>(), (dimension) -> {
        dimension.defaultReturnValue(gravityType.NORMAL);
        dimension.put(CelestialDimensions.MILKY_WAY, gravityType.LOW);
        dimension.put(CelestialDimensions.MOON, gravityType.LOW);
        dimension.put(CelestialDimensions.MARS, gravityType.LOW);
        dimension.put(CelestialDimensions.VENUS, gravityType.NORMAL);
        dimension.put(CelestialDimensions.MERCURY, gravityType.LOW);
    });

    public static void addDimensionGravity(ResourceKey<Level> dimension, gravityType gravityType) {
        DIMENSION_GRAVITY.put(dimension, gravityType);
    }

    public static boolean isLowGravityDimension(ResourceKey<Level> dimension) {
        return DIMENSION_GRAVITY.get(dimension).equals(gravityType.LOW);
    }

    public static boolean isExtraLowGravityDimension(ResourceKey<Level> dimension) {
        return DIMENSION_GRAVITY.get(dimension).equals(gravityType.EXTRA_LOW);
    }

    public static boolean isHighGravityDimension(ResourceKey<Level> dimension) {
        return DIMENSION_GRAVITY.get(dimension).equals(gravityType.HIGH);
    }


    public enum gravityType {
        EXTRA_LOW,
        LOW,
        NORMAL,
        HIGH
    }
}