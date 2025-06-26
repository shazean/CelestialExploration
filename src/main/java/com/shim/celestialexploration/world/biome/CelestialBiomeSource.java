package com.shim.celestialexploration.world.biome;

import com.google.common.collect.ImmutableList;
import com.mojang.datafixers.util.Pair;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestialexploration.registry.CelestialBiomes;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.resources.RegistryOps;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeSource;
import net.minecraft.world.level.biome.Climate;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.registries.RegistryObject;

import java.text.DecimalFormat;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CelestialBiomeSource extends BiomeSource {
    public static final Codec<CelestialBiomeSource> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            Codec.LONG.fieldOf("seed").stable().forGetter(b -> b.seed),
            RegistryOps.retrieveRegistry(Registry.BIOME_REGISTRY).forGetter(b -> b.biomes)
    ).apply(instance, instance.stable(CelestialBiomeSource::new)));

    //    private static final AGBiomeBuilder DEBUG_BIOME_HOLDER = new AGBiomeBuilder();
//    private static final TerrainShaper DEBUG_TERRAIN_HOLDER = TropicraftTerrainShaper.tropics();
    private static final DecimalFormat DEBUG_DECIMAL_FORMAT = new DecimalFormat("0.000");

    private static Set<ResourceKey<Biome>> POSSIBLE_BIOMES = Stream.of(
            CelestialBiomes.MARS_CRATERS
    ).map(RegistryObject::getKey).collect(Collectors.toSet());

    private final long seed;
    private final Registry<Biome> biomes;
    private final Climate.ParameterList<Holder<Biome>> parameters;

    public CelestialBiomeSource(long seed, Registry<Biome> biomes) {
        super(POSSIBLE_BIOMES.stream().map(biomes::getHolderOrThrow));

        this.seed = seed;
        this.biomes = biomes;

        ImmutableList.Builder<Pair<Climate.ParameterPoint, Holder<Biome>>> builder = ImmutableList.builder();
//        new AGBiomeBuilder().addBiomes((point, biome) -> builder.add(Pair.of(point, biomes.getHolderOrThrow(biome))));

        parameters = new Climate.ParameterList<>(builder.build());
    }

    public static void register() {
        Registry.register(Registry.BIOME_SOURCE, new ResourceLocation(CelestialExploration.MODID, "celestial_exploration"), CODEC);
    }

    @Override
    protected Codec<? extends BiomeSource> codec() {
        return CODEC;
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public BiomeSource withSeed(long seed) {
        return new CelestialBiomeSource(seed, biomes);
    }

    @Override
    public Holder<Biome> getNoiseBiome(int x, int y, int z, Climate.Sampler sampler) {
        return this.parameters.findValue(sampler.sample(x, y, z));
    }
}
