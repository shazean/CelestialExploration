package com.shim.celestialexploration.registry;

import com.google.common.collect.ImmutableList;
import com.mojang.datafixers.util.Pair;
import com.mojang.serialization.Codec;
import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestialexploration.world.biome.*;
import com.shim.celestialexploration.world.biome.builder.*;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeSource;
import net.minecraft.world.level.biome.Climate;
import net.minecraft.world.level.biome.MultiNoiseBiomeSource;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class DimensionRegistry {

    public static final ResourceKey<Level> MARS = ResourceKey.create(Registry.DIMENSION_REGISTRY, new ResourceLocation(CelestialExploration.MODID, "mars"));
    public static final ResourceKey<Level> MOON = ResourceKey.create(Registry.DIMENSION_REGISTRY, new ResourceLocation(CelestialExploration.MODID, "moon"));
    public static final ResourceKey<Level> SPACE = ResourceKey.create(Registry.DIMENSION_REGISTRY, new ResourceLocation(CelestialExploration.MODID, "space"));
    public static final ResourceKey<Level> VENUS = ResourceKey.create(Registry.DIMENSION_REGISTRY, new ResourceLocation(CelestialExploration.MODID, "venus"));
    public static final ResourceKey<Level> MERCURY = ResourceKey.create(Registry.DIMENSION_REGISTRY, new ResourceLocation(CelestialExploration.MODID, "mercury"));
    public static final ResourceKey<Level> JUPITER = ResourceKey.create(Registry.DIMENSION_REGISTRY, new ResourceLocation(CelestialExploration.MODID, "jupiter"));

    public static final MultiNoiseBiomeSource.Preset MARS_PRESET = new MultiNoiseBiomeSource.Preset(new ResourceLocation(CelestialExploration.MODID, "mars"), (biome) -> {
        ImmutableList.Builder<Pair<Climate.ParameterPoint, Holder<Biome>>> builder = ImmutableList.builder();
        new MarsBiomeBuilder().addBiomes((p_204279_) -> {
            builder.add(p_204279_.mapSecond(biome::getOrCreateHolder));
        });
        return new Climate.ParameterList<>(builder.build());
    });

    public static final MultiNoiseBiomeSource.Preset MOON_PRESET = new MultiNoiseBiomeSource.Preset(new ResourceLocation(CelestialExploration.MODID, "moon"), (biome) -> {
        ImmutableList.Builder<Pair<Climate.ParameterPoint, Holder<Biome>>> builder = ImmutableList.builder();
        new MoonBiomeBuilder().addBiomes((p_204279_) -> {
            builder.add(p_204279_.mapSecond(biome::getOrCreateHolder));
        });
        return new Climate.ParameterList<>(builder.build());
    });

    public static final MultiNoiseBiomeSource.Preset VENUS_PRESET = new MultiNoiseBiomeSource.Preset(new ResourceLocation(CelestialExploration.MODID, "venus"), (biome) -> {
        ImmutableList.Builder<Pair<Climate.ParameterPoint, Holder<Biome>>> builder = ImmutableList.builder();
        new VenusBiomeBuilder().addBiomes((p_204279_) -> {
            builder.add(p_204279_.mapSecond(biome::getOrCreateHolder));
        });
        return new Climate.ParameterList<>(builder.build());
    });

    public static final MultiNoiseBiomeSource.Preset MERCURY_PRESET = new MultiNoiseBiomeSource.Preset(new ResourceLocation(CelestialExploration.MODID, "mercury"), (biome) -> {
        ImmutableList.Builder<Pair<Climate.ParameterPoint, Holder<Biome>>> builder = ImmutableList.builder();
        new MercuryBiomeBuilder().addBiomes((p_204279_) -> {
            builder.add(p_204279_.mapSecond(biome::getOrCreateHolder));
        });
        return new Climate.ParameterList<>(builder.build());
    });

    public static final MultiNoiseBiomeSource.Preset JUPITER_PRESET = new MultiNoiseBiomeSource.Preset(new ResourceLocation(CelestialExploration.MODID, "jupiter"), (biome) -> {
        ImmutableList.Builder<Pair<Climate.ParameterPoint, Holder<Biome>>> builder = ImmutableList.builder();
        new JupiterBiomeBuilder().addBiomes((p_204279_) -> {
            builder.add(p_204279_.mapSecond(biome::getOrCreateHolder));
        });
        return new Climate.ParameterList<>(builder.build());
    });

    public static final DeferredRegister<Codec<? extends BiomeSource>> BIOME_SOURCE = DeferredRegister.create(Registry.BIOME_SOURCE_REGISTRY, CelestialExploration.MODID);
    public static final RegistryObject<Codec<CelestialBiomeSource>> CELESTIAL_BIOMES = BIOME_SOURCE.register("celestial_exploration", () -> CelestialBiomeSource.CODEC);


}
