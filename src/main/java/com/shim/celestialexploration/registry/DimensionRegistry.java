package com.shim.celestialexploration.registry;

import com.google.common.collect.ImmutableList;
import com.mojang.datafixers.util.Pair;
import com.mojang.serialization.Codec;
import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestialexploration.world.biome.*;
import com.shim.celestialexploration.world.biome.builder.*;
import com.shim.celestialexploration.world.biome.builder.presets.DesertPlanetBiomeBuilder;
import com.shim.celestialexploration.world.biome.builder.presets.ForestPlanetBiomeBuilder;
import com.shim.celestialexploration.world.biome.builder.presets.IcyPlanetBiomeBuilder;
import com.shim.celestialexploration.world.biome.builder.presets.OceanPlanetBiomeBuilder;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeSource;
import net.minecraft.world.level.biome.Climate;
import net.minecraft.world.level.biome.MultiNoiseBiomeSource;
import net.minecraftforge.registries.*;

public class DimensionRegistry {


    public static final ResourceKey<Level> MARS = ResourceKey.create(Registry.DIMENSION_REGISTRY, new ResourceLocation(CelestialExploration.MODID, "mars"));
    public static final ResourceKey<Level> MOON = ResourceKey.create(Registry.DIMENSION_REGISTRY, new ResourceLocation(CelestialExploration.MODID, "moon"));
    public static final ResourceKey<Level> SPACE = ResourceKey.create(Registry.DIMENSION_REGISTRY, new ResourceLocation(CelestialExploration.MODID, "space"));
    public static final ResourceKey<Level> VENUS = ResourceKey.create(Registry.DIMENSION_REGISTRY, new ResourceLocation(CelestialExploration.MODID, "venus"));
    public static final ResourceKey<Level> MERCURY = ResourceKey.create(Registry.DIMENSION_REGISTRY, new ResourceLocation(CelestialExploration.MODID, "mercury"));
    public static final ResourceKey<Level> JUPITER = ResourceKey.create(Registry.DIMENSION_REGISTRY, new ResourceLocation(CelestialExploration.MODID, "jupiter"));
//    public static final ResourceKey<Level> IO = ResourceKey.create(Registry.DIMENSION_REGISTRY, new ResourceLocation(CelestialExploration.MODID, "io"));
//public static final ResourceKey<Level> GANYMEDE = ResourceKey.create(Registry.DIMENSION_REGISTRY, new ResourceLocation(CelestialExploration.MODID, "ganymede"));
//    public static final ResourceKey<Level> CALLISTO = ResourceKey.create(Registry.DIMENSION_REGISTRY, new ResourceLocation(CelestialExploration.MODID, "callisto"));
    public static final ResourceKey<Level> EUROPA = ResourceKey.create(Registry.DIMENSION_REGISTRY, new ResourceLocation(CelestialExploration.MODID, "europa"));

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

//    public static final MultiNoiseBiomeSource.Preset IO_PRESET = new MultiNoiseBiomeSource.Preset(new ResourceLocation(CelestialExploration.MODID, "io"), (biome) -> {
//        ImmutableList.Builder<Pair<Climate.ParameterPoint, Holder<Biome>>> builder = ImmutableList.builder();
//        new IoBiomeBuilder().addBiomes((p_204279_) -> {
//            builder.add(p_204279_.mapSecond(biome::getOrCreateHolder));
//        });
//        return new Climate.ParameterList<>(builder.build());
//    });

//    public static final MultiNoiseBiomeSource.Preset GANYMEDE_PRESET = new MultiNoiseBiomeSource.Preset(new ResourceLocation(CelestialExploration.MODID, "ganymede"), (biome) -> {
//        ImmutableList.Builder<Pair<Climate.ParameterPoint, Holder<Biome>>> builder = ImmutableList.builder();
//        new GanymedeBiomeBuilder().addBiomes((p_204279_) -> {
//            builder.add(p_204279_.mapSecond(biome::getOrCreateHolder));
//        });
//        return new Climate.ParameterList<>(builder.build());
//    });

//    public static final MultiNoiseBiomeSource.Preset CALLISTO_PRESET = new MultiNoiseBiomeSource.Preset(new ResourceLocation(CelestialExploration.MODID, "callisto"), (biome) -> {
//        ImmutableList.Builder<Pair<Climate.ParameterPoint, Holder<Biome>>> builder = ImmutableList.builder();
//        new CallistoBiomeBuilder().addBiomes((p_204279_) -> {
//            builder.add(p_204279_.mapSecond(biome::getOrCreateHolder));
//        });
//        return new Climate.ParameterList<>(builder.build());
//    });

    public static final MultiNoiseBiomeSource.Preset EUROPA_PRESET = new MultiNoiseBiomeSource.Preset(new ResourceLocation(CelestialExploration.MODID, "europa"), (biome) -> {
        ImmutableList.Builder<Pair<Climate.ParameterPoint, Holder<Biome>>> builder = ImmutableList.builder();
        new EuropaBiomeBuilder().addBiomes((p_204279_) -> {
            builder.add(p_204279_.mapSecond(biome::getOrCreateHolder));
        });
        return new Climate.ParameterList<>(builder.build());
    });



    //---- FOR DATAPACK/PRESETS -------------------------------------------------------------------------------
    public static final MultiNoiseBiomeSource.Preset DESERT_PRESET = new MultiNoiseBiomeSource.Preset(new ResourceLocation(CelestialExploration.MODID, "desert_planet"), (biome) -> {
        ImmutableList.Builder<Pair<Climate.ParameterPoint, Holder<Biome>>> builder = ImmutableList.builder();
        new DesertPlanetBiomeBuilder().addBiomes((p_204279_) -> {
            builder.add(p_204279_.mapSecond(biome::getOrCreateHolder));
        });
        return new Climate.ParameterList<>(builder.build());
    });

    public static final MultiNoiseBiomeSource.Preset FOREST_PRESET = new MultiNoiseBiomeSource.Preset(new ResourceLocation(CelestialExploration.MODID, "forest_planet"), (biome) -> {
        ImmutableList.Builder<Pair<Climate.ParameterPoint, Holder<Biome>>> builder = ImmutableList.builder();
        new ForestPlanetBiomeBuilder().addBiomes((p_204279_) -> {
            builder.add(p_204279_.mapSecond(biome::getOrCreateHolder));
        });
        return new Climate.ParameterList<>(builder.build());
    });

    public static final MultiNoiseBiomeSource.Preset ICE_PRESET = new MultiNoiseBiomeSource.Preset(new ResourceLocation(CelestialExploration.MODID, "icy_planet"), (biome) -> {
        ImmutableList.Builder<Pair<Climate.ParameterPoint, Holder<Biome>>> builder = ImmutableList.builder();
        new IcyPlanetBiomeBuilder().addBiomes((p_204279_) -> {
            builder.add(p_204279_.mapSecond(biome::getOrCreateHolder));
        });
        return new Climate.ParameterList<>(builder.build());
    });

    public static final MultiNoiseBiomeSource.Preset OCEAN_PRESET = new MultiNoiseBiomeSource.Preset(new ResourceLocation(CelestialExploration.MODID, "ocean_planet"), (biome) -> {
        ImmutableList.Builder<Pair<Climate.ParameterPoint, Holder<Biome>>> builder = ImmutableList.builder();
        new OceanPlanetBiomeBuilder().addBiomes((p_204279_) -> {
            builder.add(p_204279_.mapSecond(biome::getOrCreateHolder));
        });
        return new Climate.ParameterList<>(builder.build());
    });


    public static final DeferredRegister<Codec<? extends BiomeSource>> BIOME_SOURCE = DeferredRegister.create(Registry.BIOME_SOURCE_REGISTRY, CelestialExploration.MODID);
    public static final RegistryObject<Codec<CelestialBiomeSource>> CELESTIAL_BIOMES = BIOME_SOURCE.register("celestial_exploration", () -> CelestialBiomeSource.CODEC);


}
