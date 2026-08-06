package com.shim.celestialexploration.registry;

import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestialexploration.world.features.*;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.*;
import net.minecraft.world.level.levelgen.feature.configurations.*;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;

public class CelestialFeatures {

    public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(ForgeRegistries.FEATURES, CelestialExploration.MODID);

    public static final RegistryObject<Feature<NoneFeatureConfiguration>> GEYSER = FEATURES.register("geyser", () -> new GeyserFeature(NoneFeatureConfiguration.CODEC, CelestialBlocks.GEYSER.get(), CelestialBlocks.VENUS_STONE.get(), CelestialBlocks.VENUS_SAND.get()));
    public static final RegistryObject<Feature<NoneFeatureConfiguration>> IO_GEYSER = FEATURES.register("io_geyser", () -> new GeyserFeature(NoneFeatureConfiguration.CODEC, CelestialBlocks.IO_GEYSER.get(), CelestialBlocks.IO_STONE.get(), CelestialBlocks.IO_SAND.get()));

    public static final RegistryObject<Feature<NoneFeatureConfiguration>> JUPITER_CLOUD_FEATURE = FEATURES.register("jupiter_cloud", () -> new JupiterCloudFeature(NoneFeatureConfiguration.CODEC));

    public static final RegistryObject<Feature<NoneFeatureConfiguration>> PENITENTE = FEATURES.register("penitente", () -> new PenitenteFeature(NoneFeatureConfiguration.CODEC));
    public static final RegistryObject<Feature<NoneFeatureConfiguration>> HYDRATE = FEATURES.register("hydrate", () -> new HydrateFeature(NoneFeatureConfiguration.CODEC));

    public static final RegistryObject<Feature<NoneFeatureConfiguration>> FROZEN_OCEAN = FEATURES.register("frozen_ocean", () -> new FrozenOceanFeature(NoneFeatureConfiguration.CODEC));

    public static final RegistryObject<Feature<NoneFeatureConfiguration>> SMALL_CRATER = FEATURES.register("small_crater", () -> new CraterFeature(NoneFeatureConfiguration.CODEC, 5, 8, false));
    public static final RegistryObject<Feature<NoneFeatureConfiguration>> MEDIUM_CRATER = FEATURES.register("medium_crater", () -> new CraterFeature(NoneFeatureConfiguration.CODEC, 9, 12, false));
    public static final RegistryObject<Feature<NoneFeatureConfiguration>> LARGE_CRATER = FEATURES.register("large_crater", () -> new CraterFeature(NoneFeatureConfiguration.CODEC, 13, 16, false));

    public static final RegistryObject<Feature<NoneFeatureConfiguration>> SMALL_METEOR = FEATURES.register("small_meteor", () -> new CraterFeature(NoneFeatureConfiguration.CODEC, 5, 8, true));
    public static final RegistryObject<Feature<NoneFeatureConfiguration>> MEDIUM_METEOR = FEATURES.register("medium_meteor", () -> new CraterFeature(NoneFeatureConfiguration.CODEC, 9, 12, true));
    public static final RegistryObject<Feature<NoneFeatureConfiguration>> LARGE_METEOR = FEATURES.register("large_meteor", () -> new CraterFeature(NoneFeatureConfiguration.CODEC, 13, 16, true));

    public static final RegistryObject<Feature<NoneFeatureConfiguration>> SMALL_SLIME_CRATER = FEATURES.register("small_slime_crater", () -> new LinedCraterFeature(NoneFeatureConfiguration.CODEC, 5, 8, CelestialBlocks.MERCURY_SLIME_BLOCK.get()));
    public static final RegistryObject<Feature<NoneFeatureConfiguration>> MEDIUM_SLIME_CRATER = FEATURES.register("medium_slime_crater", () -> new LinedCraterFeature(NoneFeatureConfiguration.CODEC, 9, 12, CelestialBlocks.MERCURY_SLIME_BLOCK.get()));
    public static final RegistryObject<Feature<NoneFeatureConfiguration>> LARGE_SLIME_CRATER = FEATURES.register("large_slime_crater", () -> new LinedCraterFeature(NoneFeatureConfiguration.CODEC, 13, 16, CelestialBlocks.MERCURY_SLIME_BLOCK.get()));

    public static final RegistryObject<Feature<NoneFeatureConfiguration>> SMALL_ICE_CRATER = FEATURES.register("small_ice_crater", () -> new LinedCraterFeature(NoneFeatureConfiguration.CODEC, 5, 8, Blocks.ICE));
    public static final RegistryObject<Feature<NoneFeatureConfiguration>> MEDIUM_ICE_CRATER = FEATURES.register("medium_ice_crater", () -> new LinedCraterFeature(NoneFeatureConfiguration.CODEC, 9, 12, Blocks.ICE));
    public static final RegistryObject<Feature<NoneFeatureConfiguration>> LARGE_ICE_CRATER = FEATURES.register("large_ice_crater", () -> new LinedCraterFeature(NoneFeatureConfiguration.CODEC, 13, 16, Blocks.ICE));

    public static final RegistryObject<Feature<NoneFeatureConfiguration>> ASTEROID = FEATURES.register("asteroid", () -> new AsteroidFeature(NoneFeatureConfiguration.CODEC));


}
