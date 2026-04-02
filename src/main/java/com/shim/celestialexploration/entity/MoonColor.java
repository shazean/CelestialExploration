package com.shim.celestialexploration.entity;

import com.google.common.collect.Maps;
import com.shim.celestialexploration.registry.CelestialTags;
import net.minecraft.Util;
import net.minecraft.core.Holder;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;

import javax.annotation.Nullable;
import java.util.Map;

public class MoonColor {

    private static final Map<TagKey<Biome>, DyeType> BY_BIOME = Util.make(Maps.newHashMap(), (map) -> {
        map.put(CelestialTags.Biomes.MOON_BIOMES, DyeType.BLUE);
        map.put(CelestialTags.Biomes.CALLISTO_BIOMES, DyeType.MAGENTA);
        map.put(CelestialTags.Biomes.GANYMEDE_BIOMES, DyeType.RED);
        map.put(CelestialTags.Biomes.IO_BIOMES, DyeType.LIME);
        map.put(CelestialTags.Biomes.EUROPA_BIOMES, DyeType.CYAN);
//        map.put(CelestialTags.Biomes.TITAN_BIOMES, DyeType.YELLOW);
//        map.put(CelestialTags.Biomes.ENCELADUS_BIOMES, DyeType.LIGHT_BLUE);
//        map.put(CelestialTags.Biomes.RHEA_BIOMES, DyeType.ORANGE);
//        map.put(CelestialTags.Biomes.IAPETUS_BIOMES, DyeType.BROWN);
//        map.put(CelestialTags.Biomes.DIONE_BIOMES, DyeType.GREEN);
//        map.put(CelestialTags.Biomes.TITANIA_BIOMES, DyeType.PINK);
//        map.put(CelestialTags.Biomes.OBERON_BIOMES, DyeType.BLUE);
//        map.put(CelestialTags.Biomes.TRITON_BIOMES, DyeType.PURPLE);
    });

    @Nullable
    public static DyeType getColor(Holder<Biome> biome) {
        for (TagKey<Biome> tag : BY_BIOME.keySet()) {
            if (biome.is(tag)) {
                return BY_BIOME.get(tag);
            }
        }
        return null;
    }
}