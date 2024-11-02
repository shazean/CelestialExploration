package com.shim.celestialexploration.registry;

import com.google.common.collect.Sets;
import com.shim.celestialexploration.CelestialExploration;
import net.minecraft.resources.ResourceLocation;

import java.util.Collections;
import java.util.Set;

public class CELootTables {
    private static final Set<ResourceLocation> LOCATIONS = Sets.newHashSet();
    private static final Set<ResourceLocation> IMMUTABLE_LOCATIONS = Collections.unmodifiableSet(LOCATIONS);
    public static final ResourceLocation EMPTY = new ResourceLocation("empty");
    public static final ResourceLocation RESEARCH_TUNNEL = register("chests/research_tunnel");

    private static ResourceLocation register(String p_78768_) {
        return register(new ResourceLocation(CelestialExploration.MODID, p_78768_));
    }

    private static ResourceLocation register(ResourceLocation p_78770_) {
        if (LOCATIONS.add(p_78770_)) {
            return p_78770_;
        } else {
            throw new IllegalArgumentException(p_78770_ + " is already a registered loot table");
        }
    }

    public static Set<ResourceLocation> all() {
        return IMMUTABLE_LOCATIONS;
    }
}
