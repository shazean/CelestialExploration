package com.shim.celestialexploration.registry;

import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestialexploration.world.features.*;
import net.minecraft.core.Registry;
import net.minecraft.world.level.levelgen.feature.*;
import net.minecraft.world.level.levelgen.feature.configurations.*;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class CelestialFeatures {

    public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(ForgeRegistries.FEATURES, CelestialExploration.MODID);

    public static final RegistryObject<Feature<NoneFeatureConfiguration>> GEYSER = FEATURES.register("geyser", () -> new GeyserFeature(NoneFeatureConfiguration.CODEC, CelestialBlocks.GEYSER.get(), CelestialBlocks.VENUS_STONE.get(), CelestialBlocks.VENUS_SAND.get()));
    public static final RegistryObject<Feature<NoneFeatureConfiguration>> IO_GEYSER = FEATURES.register("io_geyser", () -> new GeyserFeature(NoneFeatureConfiguration.CODEC, CelestialBlocks.IO_GEYSER.get(), CelestialBlocks.IO_STONE.get(), CelestialBlocks.IO_SAND.get()));

    public static final RegistryObject<Feature<NoneFeatureConfiguration>> JUPITER_CLOUD_FEATURE = FEATURES.register("jupiter_cloud", () -> new JupiterCloudFeature(NoneFeatureConfiguration.CODEC));

    public static final RegistryObject<Feature<NoneFeatureConfiguration>> PENITENTE = FEATURES.register("penitente", () -> new PenitenteFeature(NoneFeatureConfiguration.CODEC));
    public static final RegistryObject<Feature<NoneFeatureConfiguration>> HYDRATE = FEATURES.register("hydrate", () -> new HydrateFeature(NoneFeatureConfiguration.CODEC));

    public static final RegistryObject<Feature<NoneFeatureConfiguration>> FROZEN_OCEAN = FEATURES.register("frozen_ocean", () -> new FrozenOceanFeature(NoneFeatureConfiguration.CODEC));

    public static final RegistryObject<Feature<NoneFeatureConfiguration>> CRATER = FEATURES.register("crater_registry_object", () -> new CraterFeature(NoneFeatureConfiguration.CODEC));


}
