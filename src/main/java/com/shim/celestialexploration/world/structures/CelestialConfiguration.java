package com.shim.celestialexploration.world.structures;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.Holder;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.structure.pools.StructureTemplatePool;

public class CelestialConfiguration implements FeatureConfiguration, ISerializableConfig {
    public static final Codec<CelestialConfiguration> CODEC = RecordCodecBuilder.create((p_67764_) -> {
        return p_67764_.group(StructureTemplatePool.CODEC.fieldOf("start_pool").forGetter(CelestialConfiguration::startPool),
                        Codec.intRange(0, 7).fieldOf("size").forGetter(CelestialConfiguration::maxDepth),
        Codec.INT.fieldOf("x").forGetter(CelestialConfiguration::x),
        Codec.INT.fieldOf("z").forGetter(CelestialConfiguration::z))
                .apply(p_67764_, CelestialConfiguration::new);
    });
    private final Holder<StructureTemplatePool> startPool;
    private final int maxDepth;
    private final int x;
    private final int z;

    public CelestialConfiguration(Holder<StructureTemplatePool> pool, int maxDepth, int x, int z) {
        this.startPool = pool;
        this.maxDepth = maxDepth;
        this.x = x;
        this.z = z;
    }

    public int maxDepth() {
        return this.maxDepth;
    }

    public Holder<StructureTemplatePool> startPool() {
        return this.startPool;
    }

    public int x() {
        return this.x;
    }

    public int z() {
        return this.z;
    }

    @Override
    public JsonElement serialize() {
        JsonObject configJson = new JsonObject();

        configJson.addProperty("start_pool", this.startPool.toString());
        configJson.addProperty("size", this.maxDepth());
        configJson.addProperty("x", x());
        configJson.addProperty("z", z());


        //TODO
        return null;
    }
}
