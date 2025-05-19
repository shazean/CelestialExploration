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

public class FeatureRegistry {

    private static final DeferredRegister<ConfiguredFeature<?,?>> CONFIGURED_FEATURES = DeferredRegister.create(Registry.CONFIGURED_FEATURE_REGISTRY, CelestialExploration.MODID);
    public static final DeferredRegister<PlacedFeature> PLACED_FEATURES = DeferredRegister.create(Registry.PLACED_FEATURE_REGISTRY, CelestialExploration.MODID);
    public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(ForgeRegistries.FEATURES, CelestialExploration.MODID);

    public static final RegistryObject<Feature<NoneFeatureConfiguration>> GEYSER = FEATURES.register("geyser", () -> new GeyserFeature(NoneFeatureConfiguration.CODEC, BlockRegistry.GEYSER.get(), BlockRegistry.VENUS_STONE.get(), BlockRegistry.VENUS_SAND.get()));
    public static final RegistryObject<Feature<NoneFeatureConfiguration>> IO_GEYSER = FEATURES.register("io_geyser", () -> new GeyserFeature(NoneFeatureConfiguration.CODEC, BlockRegistry.IO_GEYSER.get(), BlockRegistry.IO_STONE.get(), BlockRegistry.IO_SAND.get()));

    public static final RegistryObject<Feature<NoneFeatureConfiguration>> JUPITER_CLOUD_FEATURE = FEATURES.register("jupiter_cloud", () -> new JupiterCloudFeature(NoneFeatureConfiguration.CODEC));

    public static final RegistryObject<Feature<NoneFeatureConfiguration>> PENITENTE = FEATURES.register("penitente", () -> new PenitenteFeature(NoneFeatureConfiguration.CODEC));
    public static final RegistryObject<Feature<NoneFeatureConfiguration>> HYDRATE = FEATURES.register("hydrate", () -> new HydrateFeature(NoneFeatureConfiguration.CODEC));

    public static final RegistryObject<Feature<NoneFeatureConfiguration>> FROZEN_OCEAN = FEATURES.register("frozen_ocean", () -> new FrozenOceanFeature(NoneFeatureConfiguration.CODEC));



//    public static final RegistryObject<Feature<ConfiguredFeature<?, ?>>> CONFIGURED_JUPITER_CLOUD = CONFIGURED_FEATURES.register("jupiter_cloud", () -> new ConfiguredFeature<>(Feature.BLOCK_PILE, new BlockPileConfiguration(BlockStateProvider.simple(Blocks.TNT))));

//    private static final RegistryObject<ConfiguredFeature<?,?>> CONFIGURED_JUPITER_CLOUD =
//            CONFIGURED_FEATURES.register("jupiter_cloud",
//                    () -> new ConfiguredFeature<>(JUPITER_CLOUD_FEATURE,
//                            new NoneFeatureConfiguration()));

//    private static final RegistryObject<ConfiguredFeature<?,?>> CONFIGURED_TNT_PILE =
//            CONFIGURED_FEATURES.register(TNT_PILE_NAME,
//                    // ConfiguredFeature takes a feature type and a featureconfig.
//                    // You generally can't static init featureconfigs ahead of time, as they
//                    // very often have hard references to blocks (such as this one does).
//                    // The feature type defines the generation logic, the feature config is extra data used by that logic.
//                    // Feature.BLOCK_PILE generates blocks in a pile, it takes a BlockPileConfiguration.
//                    () -> new ConfiguredFeature<>(Feature.BLOCK_PILE,
//                            // BlockPileConfiguration takes a blockstate provider, we use one that always provides TNT.
//                            new BlockPileConfiguration(BlockStateProvider.simple(Blocks.TNT))));

//
//    private static final RegistryObject<PlacedFeature> PLACED_JUPITER_CLOUD =
//            PLACED_FEATURES.register("jupiter_cloud",
//                    () -> new PlacedFeature(CONFIGURED_JUPITER_CLOUD.getHolder().get(),
//                            // InSquarePlacement.spread() takes the input position
//                            // and randomizes the X and Z coordinates within the chunk
//                            // PlacementUtils.HEIGHTMAP sets the Y-coordinate of the input position to the heightmap.
//                            // This causes the tnt pile to be generated at a random surface position in the chunk.
//                            List.of(InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP)));

//    public static final RegistryObject<Feature<NoneFeatureConfiguration>> JUPITER_CLOUD = PLACED_FEATURES.register("jupiter_cloud", () -> new new PlacedFeature()
//    public static final Feature<NoneFeatureConfiguration> END_ISLAND = register("end_island", new EndIslandFeature(NoneFeatureConfiguration.CODEC));


    private static <C extends FeatureConfiguration, F extends Feature<C>> F register(String p_65808_, F p_65809_) {
        return Registry.register(Registry.FEATURE, p_65808_, p_65809_);
    }

    public static void register(IEventBus eventbus) {
        FEATURES.register(eventbus);
        PLACED_FEATURES.register(eventbus);
    }
}
