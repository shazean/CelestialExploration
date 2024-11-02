package com.shim.celestialexploration.datagen.util;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.shim.celestialexploration.CelestialExploration;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public class PlanetTeleport {
    private final ResourceLocation id;
    private final ResourceKey<Level> dimension;
    private final PlanetTeleport.SpaceCoordinates coordinates;
    private final List<Block> blocksList;


    public PlanetTeleport(ResourceLocation id, ResourceKey<Level> dimension, PlanetTeleport.SpaceCoordinates coordinates, List<Block> blocksList) {
        this.id = id;
        this.dimension = dimension;
        this.coordinates = coordinates;
        this.blocksList = blocksList;
    }

    public PlanetTeleport.Builder deconstruct() {
        return new PlanetTeleport.Builder(this.dimension, this.coordinates, this.blocksList);
    }

    public ResourceLocation getId() {
        return this.id;
    }


    public record SpaceCoordinates(int x, int z) {

        public JsonElement serializeToJson() {
            JsonObject json = new JsonObject();

            json.addProperty("x", this.x());
            json.addProperty("z", this.z());

            return json;
        }

        public void serializeToNetwork(FriendlyByteBuf byteBuf) {
            byteBuf.writeInt(this.x());
            byteBuf.writeInt(this.z());
        }
    }

    public static class Builder {
        ResourceKey<Level> dimension;
        PlanetTeleport.SpaceCoordinates coordinates;
        List<Block> blocksList;

        public Builder(ResourceKey<Level> dimension, PlanetTeleport.SpaceCoordinates coordinates, List<Block> blocksList) {
            this.dimension = dimension;
            this.coordinates = coordinates;
            this.blocksList = blocksList;
        }

        private Builder() {
            this.blocksList = new ArrayList<>();
        }

        public static PlanetTeleport.Builder teleporter() {
            return new PlanetTeleport.Builder();
        }

        public PlanetTeleport.Builder dimension(ResourceKey<Level> dimension) {
            this.dimension = dimension;
            return this;
        }

        public PlanetTeleport.Builder coordinates(PlanetTeleport.SpaceCoordinates coord) {
            this.coordinates = coord;
            return this;
        }

        public PlanetTeleport.Builder block(Block block) {
            this.blocksList.add(block);
            return this;
        }

        public boolean canBuild(Function<ResourceLocation, PlanetTeleport> p_138393_) {
            return dimension != null && coordinates != null && blocksList != null;
        }

        public PlanetTeleport build(ResourceLocation resourceLocation) {
            if (!this.canBuild((loc) -> {
//                CelestialExploration.LOGGER.debug("loc: " + loc);
                return null;
            })) {
                throw new IllegalStateException("Tried to build incomplete teleport!");
            } else {
                return new PlanetTeleport(resourceLocation, this.dimension, this.coordinates, this.blocksList);
            }
        }

        public PlanetTeleport save(Consumer<PlanetTeleport> consumer, String name) {
            PlanetTeleport dimension = this.build(new ResourceLocation(name));
            consumer.accept(dimension);
            return dimension;
        }

        public JsonObject serializeToJson() {
            JsonObject json = new JsonObject();

            json.addProperty("target_dimension", this.dimension.location().toString());

            json.add("spawn_chunk_coordinates", this.coordinates.serializeToJson());

            JsonArray jsonArray = new JsonArray();

            for (Block block : this.blocksList) {
               jsonArray.add(block.getRegistryName().toString());
            }

            json.add("blocks", jsonArray);

            return json;
        }

        public void serializeToNetwork(FriendlyByteBuf byteBuf) {
            if (this.dimension == null) {
                byteBuf.writeBoolean(false);
            } else {
                byteBuf.writeBoolean(true);
                byteBuf.writeResourceLocation(this.dimension.getRegistryName());
            }

            if (this.coordinates == null) {
                byteBuf.writeBoolean(false);
            } else {
                byteBuf.writeBoolean(true);
                this.coordinates.serializeToNetwork(byteBuf);
            }

            if (this.blocksList == null) {
                byteBuf.writeBoolean(false);
            } else {
                byteBuf.writeBoolean(true);
                for (Block block : this.blocksList)
                    byteBuf.writeResourceLocation(block.getRegistryName());
            }
        }
    }
}