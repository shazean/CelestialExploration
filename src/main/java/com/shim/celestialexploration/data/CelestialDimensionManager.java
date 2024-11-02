package com.shim.celestialexploration.data;

import com.google.gson.*;
import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestialexploration.util.CelestialUtil;
import com.shim.celestialexploration.util.teleportation.CelestialCoordinateTeleport;
import com.shim.celestialexploration.util.teleportation.CelestialScaledTeleport;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.server.packs.resources.SimpleJsonResourceReloadListener;
import net.minecraft.util.GsonHelper;
import net.minecraft.util.profiling.ProfilerFiller;
import net.minecraft.world.level.Level;

import java.util.Map;

public class CelestialDimensionManager extends SimpleJsonResourceReloadListener {
    private static final Gson GSON = (new GsonBuilder()).setPrettyPrinting().disableHtmlEscaping().create();

    public CelestialDimensionManager() {
        super(GSON, "celestialexploration/dimensions");
    }

    @Override
    protected void apply(Map<ResourceLocation, JsonElement> elements, ResourceManager p_10794_, ProfilerFiller p_10795_) {

        CelestialUtil.clearDimensionLocations();

        elements.forEach((dimensionPath, element) -> {

            JsonObject json = element.getAsJsonObject();

            String dimName = GsonHelper.getAsString(json, "dimension");
            ResourceKey<Level> dimension = ResourceKey.create(Registry.DIMENSION_REGISTRY, new ResourceLocation(dimName));

            if (json.has("space_chunk_coordinates")) {
                JsonObject coordinates = GsonHelper.getAsJsonObject(json, "space_chunk_coordinates");

                if (!coordinates.isJsonNull()) {
                    if (coordinates.has("x") && coordinates.has("z")) {
                        int x = GsonHelper.getAsInt(coordinates, "x");
                        int z = GsonHelper.getAsInt(coordinates, "z");
                        CelestialUtil.setDimensionLocation(dimension, new CelestialCoordinateTeleport(x, z));
                    }
                }
            } else if (json.has("coordinate_scale")) {
                double scale = GsonHelper.getAsDouble(json, "coordinate_scale");
                if (scale <= 0.0D) { //TODO confirm this is the right exception to throw?
                    throw new IllegalStateException("Coordinate scale of " + dimension + " must be greater than 0!");
                }
                CelestialUtil.setDimensionLocation(dimension, new CelestialScaledTeleport(scale));
            }
        });
    }
}