package com.shim.celestialexploration.world.structures;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.Holder;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.JigsawConfiguration;
import net.minecraft.world.level.levelgen.structure.pools.StructureTemplatePool;

public class OceanJigsawConfiguration implements FeatureConfiguration {
    public static final Codec<OceanJigsawConfiguration> CODEC = RecordCodecBuilder.create((p_67764_) -> {
        return p_67764_.group(StructureTemplatePool.CODEC.fieldOf("start_pool").forGetter(OceanJigsawConfiguration::startPool), Codec.intRange(0, 7).fieldOf("size").forGetter(OceanJigsawConfiguration::maxDepth)).apply(p_67764_, OceanJigsawConfiguration::new);
    });
    private final Holder<StructureTemplatePool> startPool;
    private final int maxDepth;

    public OceanJigsawConfiguration(Holder<StructureTemplatePool> p_204800_, int p_204801_) {
        this.startPool = p_204800_;
        this.maxDepth = p_204801_;
    }

    public int maxDepth() {
        return this.maxDepth;
    }

    public Holder<StructureTemplatePool> startPool() {
        return this.startPool;
    }
}