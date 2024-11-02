package com.shim.celestialexploration.datagen.util;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.shim.celestialexploration.CelestialExploration;
import net.minecraft.advancements.Advancement;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;
import java.util.function.Consumer;
import java.util.function.Function;

public class DimensionTeleport {
    private final ResourceLocation id;
    private final ResourceKey<Level> dimension;
    @Nullable
    private final SpaceCoordinates coordinates;
    @Nullable
    private final double coordinateScale;

    public DimensionTeleport(ResourceLocation id, ResourceKey<Level> dimension, SpaceCoordinates coordinates) {
        this(id, dimension, coordinates, -1);
    }

    public DimensionTeleport(ResourceLocation id, ResourceKey<Level> dimension, double coordinateScale) {
        this(id, dimension, null, coordinateScale);
    }

    public DimensionTeleport(ResourceLocation id, ResourceKey<Level> dimension, SpaceCoordinates coordinates, double coordinateScale) {
        this.id = id;
        this.dimension = dimension;
        this.coordinates = coordinates;
        this.coordinateScale = coordinateScale;
    }

    public Builder deconstruct() {
        return new Builder(this.dimension, this.coordinates, this.coordinateScale);
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
        @Nullable
        SpaceCoordinates coordinates;
        double coordinateScale;

        public Builder(ResourceKey<Level> dimension, @Nullable SpaceCoordinates coordinates) {
               this(dimension, coordinates, -1);
        }

        public Builder(ResourceKey<Level> dimension, double coordinateScale) {
            this(dimension, null, coordinateScale);
        }

        public Builder(ResourceKey<Level> dimension, @Nullable SpaceCoordinates coordinates, double coordinateScale) {
            this.dimension = dimension;
            this.coordinates = coordinates;
            this.coordinateScale = coordinateScale;
        }

        private Builder() {
            this.coordinates = null;
            this.coordinateScale = -1;
        }

        public static Builder teleporter() {
            return new Builder();
        }

        public Builder dimension(ResourceKey<Level> dimension) {
            this.dimension = dimension;
            return this;
        }

        public Builder coordinates(SpaceCoordinates coord) {
            this.coordinates = coord;
            return this;
        }

        public Builder coordinateScale(double scale) {
            this.coordinateScale = scale;
            return this;
        }

        public boolean canBuild(Function<ResourceLocation, DimensionTeleport> p_138393_) {
            if (dimension == null) {
                return false;
            }
            if (coordinates == null && coordinateScale == -1) {
                throw new IllegalStateException("Either coordinates or coordinate scale must be set!");
            }
            if (coordinateScale != -1 && coordinateScale < 0) {
                throw new IllegalStateException("Coordinate scale must be greater than 0!");
            }

            return true;
        }

        public DimensionTeleport build(ResourceLocation resourceLocation) {
            if (!this.canBuild((loc) -> {
                CelestialExploration.LOGGER.debug("loc: " + loc);
                return null;
            })) {
                throw new IllegalStateException("Tried to build incomplete teleport!");
            } else {
                return new DimensionTeleport(resourceLocation, this.dimension, this.coordinates, this.coordinateScale);
            }
        }

        public DimensionTeleport save(Consumer<DimensionTeleport> consumer, String name) {
            DimensionTeleport dimension = this.build(new ResourceLocation(name));
            consumer.accept(dimension);
            return dimension;
        }

        public JsonObject serializeToJson() {
            JsonObject json = new JsonObject();

            json.addProperty("dimension", this.dimension.location().toString());

            if (this.coordinates != null) {
                json.add("space_chunk_coordinates", this.coordinates.serializeToJson());
            }

            if (this.coordinateScale != -1) {
                json.addProperty("coordinate_scale", this.coordinateScale);
            }

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

            if (this.coordinateScale == -1) {
                byteBuf.writeBoolean(false);
            } else {
                byteBuf.writeBoolean(true);
                byteBuf.writeDouble(this.coordinateScale);
            }

        }
    }
}
