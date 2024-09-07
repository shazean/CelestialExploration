package com.shim.celestialexploration.util;

import com.shim.celestialexploration.registry.DimensionRegistry;
import it.unimi.dsi.fastutil.objects.Object2ObjectArrayMap;
import net.minecraft.Util;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.Level;

import java.util.ArrayList;
import java.util.Map;


public class DimensionUtil {
    private static final Map<ResourceKey<Level>, gravityType> DIMENSION_GRAVITY = Util.make(new Object2ObjectArrayMap<>(), (dimension) -> {
        dimension.defaultReturnValue(gravityType.NORMAL);
        dimension.put(DimensionRegistry.MOON, gravityType.LOW);
        dimension.put(DimensionRegistry.MARS, gravityType.LOW);
        dimension.put(DimensionRegistry.VENUS, gravityType.NORMAL);
        dimension.put(DimensionRegistry.MERCURY, gravityType.LOW);
    });

    public static void addDimensionGravity(ResourceKey<Level> dimension, gravityType gravityType) {
        DIMENSION_GRAVITY.put(dimension, gravityType);
    }

    public static boolean isLowGravityDimension(ResourceKey<Level> dimension) {
        return DIMENSION_GRAVITY.get(dimension).equals(gravityType.LOW);
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
