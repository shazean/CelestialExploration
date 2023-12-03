package com.shim.celestialexploration.registry;

import com.google.common.collect.Sets;
import com.shim.celestialexploration.CelestialExploration;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.level.block.state.properties.WoodType;

import java.util.Set;
import java.util.stream.Stream;

public class CelestialModelLayers {
    private static final String DEFAULT_LAYER = "main";
    private static final Set<ModelLayerLocation> ALL_MODELS = Sets.newHashSet();

    public static final ModelLayerLocation MAGCART = register( "magcart");
    public static final ModelLayerLocation CHEST_MAGCART = register( "chest_magcart");
    public static final ModelLayerLocation COMMAND_BLOCK_MAGCART = register( "command_block_magcart");
    public static final ModelLayerLocation FURNACE_MAGCART = register( "furnace_magcart");
    public static final ModelLayerLocation HOPPER_MAGCART = register( "hopper_magcart");
    public static final ModelLayerLocation SPAWNER_MAGCART = register( "spawner_magcart");
    public static final ModelLayerLocation TNT_MAGCART = register( "tnt_magcart");
//    public static final ModelLayerLocation MAGCART = register( "magcart");

    private static ModelLayerLocation register(String p_171294_) {
        return register(p_171294_, "main");
    }

    private static ModelLayerLocation register(String p_171296_, String p_171297_) {
        ModelLayerLocation modellayerlocation = createLocation(p_171296_, p_171297_);
        if (!ALL_MODELS.add(modellayerlocation)) {
            throw new IllegalStateException("Duplicate registration for " + modellayerlocation);
        } else {
            return modellayerlocation;
        }
    }

    private static ModelLayerLocation createLocation(String p_171301_, String p_171302_) {
        return new ModelLayerLocation(new ResourceLocation(CelestialExploration.MODID, p_171301_), p_171302_);
    }

}
