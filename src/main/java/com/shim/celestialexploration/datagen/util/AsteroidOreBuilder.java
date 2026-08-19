package com.shim.celestialexploration.datagen.util;

import com.google.gson.JsonObject;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;

import java.util.function.Consumer;
import java.util.function.Function;

public class AsteroidOreBuilder {
    private final ResourceLocation id;
    private final Block ore;
    private final int weight;
    private final float frequency;

    public AsteroidOreBuilder(ResourceLocation id, Block ore, int weight, float frequency) {
        this.id = id;
        this.ore = ore;
        this.weight = weight;
        this.frequency = frequency;
    }

    public AsteroidOreBuilder.Builder deconstruct() {
        return new AsteroidOreBuilder.Builder(this.ore, this.weight, this.frequency);
    }

    public static AsteroidOreBuilder.Builder builder() {
        return new AsteroidOreBuilder.Builder();
    }

    public ResourceLocation getId() {
        return this.id;
    }


    public static class Builder {
        Block ore;
        int weight = -1;
        float frequency = -1F;

        public Builder(Block ore, int weight, float frequency) {
            this.ore = ore;
            this.weight = weight;
            this.frequency = frequency;
        }

        private Builder() {}

        public AsteroidOreBuilder.Builder ore(Block ore) {
            this.ore = ore;
            return this;
        }

        public AsteroidOreBuilder.Builder weight(int weight) {
            this.weight = weight;
            return this;
        }

        public AsteroidOreBuilder.Builder frequency(float frequency) {
            this.frequency = frequency;
            return this;
        }


        public boolean canBuild(Function<ResourceLocation, AsteroidOreBuilder> function) {
            return ore != null && weight != -1 && frequency != -1F;
        }

        public AsteroidOreBuilder build(ResourceLocation resourceLocation) {
            if (!this.canBuild((loc) -> {
                return null;
            })) {
                throw new IllegalStateException("Tried to build incomplete teleport!");
            } else {
                return new AsteroidOreBuilder(resourceLocation, this.ore, this.weight, this.frequency);
            }
        }

        public AsteroidOreBuilder save(Consumer<AsteroidOreBuilder> consumer, ResourceLocation name) {
            AsteroidOreBuilder oreGen = this.build(name);
            consumer.accept(oreGen);
            return oreGen;
        }

        public JsonObject serializeToJson() {
            JsonObject json = new JsonObject();

            json.addProperty("ore", this.ore.getRegistryName().toString());
            json.addProperty("weight", this.weight);
            json.addProperty("frequency", this.frequency);

            return json;
        }

        public void serializeToNetwork(FriendlyByteBuf byteBuf) {

            if (this.ore == null) {
                byteBuf.writeBoolean(false);
            } else {
                byteBuf.writeBoolean(true);
                byteBuf.writeResourceLocation(this.ore.getRegistryName());
            }

            if (this.weight == -1) {
                byteBuf.writeBoolean(false);
            } else {
                byteBuf.writeBoolean(true);
                byteBuf.writeInt(this.weight);
            }

            if (this.frequency == -1) {
                byteBuf.writeBoolean(false);
            } else {
                byteBuf.writeBoolean(true);
                byteBuf.writeFloat(this.frequency);
            }
        }
    }
}