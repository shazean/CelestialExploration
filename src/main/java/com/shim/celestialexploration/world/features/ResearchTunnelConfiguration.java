package com.shim.celestialexploration.world.features;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.shim.celestialexploration.world.structures.ResearchTunnelStructure;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;

public class ResearchTunnelConfiguration implements FeatureConfiguration {
    public static final Codec<ResearchTunnelConfiguration> CODEC = RecordCodecBuilder.create((configurationInstance) ->
            configurationInstance.group(Codec.floatRange(0.0F, 1.0F).fieldOf("probability").forGetter((configuration) ->
                    configuration.probability), ResearchTunnelStructure.Type.CODEC.fieldOf("type").forGetter((configuration) ->
                    configuration.type)).apply(configurationInstance, ResearchTunnelConfiguration::new));
    public final float probability;
    public final ResearchTunnelStructure.Type type;

    public ResearchTunnelConfiguration(float probability, ResearchTunnelStructure.Type type) {
        this.probability = probability;
        this.type = type;
    }
}