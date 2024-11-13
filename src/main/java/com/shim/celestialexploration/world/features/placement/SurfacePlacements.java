package com.shim.celestialexploration.world.features.placement;

import com.shim.celestialexploration.registry.BlockRegistry;
import com.shim.celestialexploration.world.features.CelestialFeatureUtils;
import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.RandomPatchConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.heightproviders.BiasedToBottomHeight;
import net.minecraft.world.level.levelgen.placement.*;

public class SurfacePlacements {

    public static final Holder<PlacedFeature> GEYSER = PlacementUtils.register("geyser", CelestialFeatureUtils.GEYSER, InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome());

//    public static final Holder<PlacedFeature> JUPITER_CLOUD = PlacementUtils.register("jupiter_cloud", CelestialFeatureUtils.JUPITER_CLOUD, RarityFilter.onAverageOnceEvery(20), InSquarePlacement.spread(), HeightRangePlacement.of(BiasedToBottomHeight.of(VerticalAnchor.absolute(64), VerticalAnchor.absolute(512), 8)), BiomeFilter.biome());

    public static final Holder<PlacedFeature> PENITENTE = PlacementUtils.register("penitente", CelestialFeatureUtils.PENITENTE, CountPlacement.of(4), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome());
    public static final Holder<PlacedFeature> SPARSE_PENITENTE = PlacementUtils.register("sparse_penitente", CelestialFeatureUtils.PENITENTE, RarityFilter.onAverageOnceEvery(10), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome());

    public static final Holder<PlacedFeature> FROZEN_OCEAN = PlacementUtils.register("frozen_ocean", CelestialFeatureUtils.FROZEN_OCEAN, CountPlacement.of(8), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome());

//    public static final Holder<PlacedFeature> HYDRATE = PlacementUtils.register("hydrate", CelestialFeatureUtils.HYDRATE, RarityFilter.onAverageOnceEvery(20), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome());

}