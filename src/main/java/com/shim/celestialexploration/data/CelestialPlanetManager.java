package com.shim.celestialexploration.data;

import com.google.gson.*;
import com.shim.celestialexploration.util.CelestialUtil;
import com.shim.celestialexploration.util.teleportation.TeleportUtil;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.server.packs.resources.SimpleJsonResourceReloadListener;
import net.minecraft.util.GsonHelper;
import net.minecraft.util.profiling.ProfilerFiller;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.phys.Vec3;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CelestialPlanetManager extends SimpleJsonResourceReloadListener {
    private static final Gson GSON = (new GsonBuilder()).setPrettyPrinting().disableHtmlEscaping().create();

    public CelestialPlanetManager() {
        super(GSON, "celestialexploration/planets");
    }

    @Override
    protected void apply(Map<ResourceLocation, JsonElement> elements, ResourceManager p_10794_, ProfilerFiller p_10795_) {

        TeleportUtil.clearDimensionStructureBlocks();
        CelestialUtil.clearPlanetLocations();

        elements.forEach((dimensionPath, element) -> {

            JsonObject json = element.getAsJsonObject();

            String dimName = GsonHelper.getAsString(json, "target_dimension");
            ResourceKey<Level> dimension = ResourceKey.create(Registry.DIMENSION_REGISTRY, new ResourceLocation(dimName));
//            CelestialExploration.LOGGER.debug("target_dimension: " + dimension);

            if (json.has("spawn_chunk_coordinates")) {
                JsonObject coordinates = GsonHelper.getAsJsonObject(json, "spawn_chunk_coordinates");

                if (!coordinates.isJsonNull()) {
                    if (coordinates.has("x") && coordinates.has("z")) {
                        int x = GsonHelper.getAsInt(coordinates, "x");
                        int z = GsonHelper.getAsInt(coordinates, "z");
//                        CelestialExploration.LOGGER.debug("xz: " + x + "/" + z);

                        CelestialUtil.setPlanetLocation(dimension, new Vec3(x, 0, z));

                    }
                }
            }

            if (json.has("blocks")) {
                JsonArray blocks = GsonHelper.getAsJsonArray(json, "blocks");
                List<Block> blocksList = new ArrayList<>();

                for (int i = 0; i < blocks.size(); i++) {
                    blocksList.add(i, Block.byItem(GsonHelper.convertToItem(blocks.get(i), "block")));
                }

                TeleportUtil.addDimensionStructureBlocks(dimension, blocksList);

            }
        });
    }
}