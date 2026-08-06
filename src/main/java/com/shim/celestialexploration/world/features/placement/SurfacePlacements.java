package com.shim.celestialexploration.world.features.placement;

import com.shim.celestialexploration.world.features.CelestialFeatureUtils;
import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.placement.*;

public class SurfacePlacements {



    public static final Holder<PlacedFeature> GEYSER = PlacementUtils.register("geyser", CelestialFeatureUtils.GEYSER, InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome());
    public static final Holder<PlacedFeature> IO_GEYSER = PlacementUtils.register("io_geyser", CelestialFeatureUtils.IO_GEYSER, InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome());

//    public static final Holder<PlacedFeature> JUPITER_CLOUD = PlacementUtils.register("jupiter_cloud", CelestialFeatureUtils.JUPITER_CLOUD, RarityFilter.onAverageOnceEvery(20), InSquarePlacement.spread(), HeightRangePlacement.of(BiasedToBottomHeight.of(VerticalAnchor.absolute(64), VerticalAnchor.absolute(512), 8)), BiomeFilter.biome());

    public static final Holder<PlacedFeature> PENITENTE = PlacementUtils.register("penitente", CelestialFeatureUtils.PENITENTE, CountPlacement.of(4), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome());
    public static final Holder<PlacedFeature> SPARSE_PENITENTE = PlacementUtils.register("sparse_penitente", CelestialFeatureUtils.PENITENTE, RarityFilter.onAverageOnceEvery(10), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome());

    public static final Holder<PlacedFeature> FROZEN_OCEAN = PlacementUtils.register("frozen_ocean", CelestialFeatureUtils.FROZEN_OCEAN, CountPlacement.of(20), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome());

    private static final int COMMON_SMALL = 64;
    private static final int COMMON_MEDIUM = 96;
    private static final int COMMON_LARGE = 128;
    private static final int UNCOMMON_SMALL = 192;
    private static final int UNCOMMON_MEDIUM = 256;
    private static final int UNCOMMON_LARGE = 512;
    private static final int PLUS = 48;

    public static final Holder<PlacedFeature> UNCOMMON_SMALL_CRATER = PlacementUtils.register("uncommon_small_crater", CelestialFeatureUtils.SMALL_CRATER, RarityFilter.onAverageOnceEvery(UNCOMMON_SMALL), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome());
    public static final Holder<PlacedFeature> COMMON_SMALL_CRATER = PlacementUtils.register("common_small_crater", CelestialFeatureUtils.SMALL_CRATER, RarityFilter.onAverageOnceEvery(COMMON_SMALL), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome());

    public static final Holder<PlacedFeature> UNCOMMON_MEDIUM_CRATER = PlacementUtils.register("uncommon_medium_crater", CelestialFeatureUtils.MEDIUM_CRATER, RarityFilter.onAverageOnceEvery(UNCOMMON_MEDIUM), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome());
    public static final Holder<PlacedFeature> COMMON_MEDIUM_CRATER = PlacementUtils.register("common_medium_crater", CelestialFeatureUtils.MEDIUM_CRATER, RarityFilter.onAverageOnceEvery(COMMON_MEDIUM), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome());

    public static final Holder<PlacedFeature> UNCOMMON_LARGE_CRATER = PlacementUtils.register("uncommon_large_crater", CelestialFeatureUtils.LARGE_CRATER, RarityFilter.onAverageOnceEvery(UNCOMMON_LARGE), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome());
    public static final Holder<PlacedFeature> COMMON_LARGE_CRATER = PlacementUtils.register("common_large_crater", CelestialFeatureUtils.LARGE_CRATER, RarityFilter.onAverageOnceEvery(COMMON_LARGE), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome());

    public static final Holder<PlacedFeature> UNCOMMON_SMALL_METEOR = PlacementUtils.register("uncommon_small_meteor", CelestialFeatureUtils.SMALL_METEOR, RarityFilter.onAverageOnceEvery(UNCOMMON_SMALL + PLUS), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome());
    public static final Holder<PlacedFeature> COMMON_SMALL_METEOR = PlacementUtils.register("common_small_meteor", CelestialFeatureUtils.SMALL_METEOR, RarityFilter.onAverageOnceEvery(COMMON_SMALL + PLUS), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome());

    public static final Holder<PlacedFeature> UNCOMMON_MEDIUM_METEOR = PlacementUtils.register("uncommon_medium_meteor", CelestialFeatureUtils.MEDIUM_METEOR, RarityFilter.onAverageOnceEvery(UNCOMMON_MEDIUM + PLUS), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome());
    public static final Holder<PlacedFeature> COMMON_MEDIUM_METEOR = PlacementUtils.register("common_medium_meteor", CelestialFeatureUtils.MEDIUM_METEOR, RarityFilter.onAverageOnceEvery(COMMON_MEDIUM + PLUS), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome());

    public static final Holder<PlacedFeature> UNCOMMON_LARGE_METEOR = PlacementUtils.register("uncommon_large_meteor", CelestialFeatureUtils.LARGE_METEOR, RarityFilter.onAverageOnceEvery(UNCOMMON_SMALL + PLUS), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome());
    public static final Holder<PlacedFeature> COMMON_LARGE_METEOR = PlacementUtils.register("common_large_meteor", CelestialFeatureUtils.LARGE_METEOR, RarityFilter.onAverageOnceEvery(COMMON_LARGE + PLUS), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome());

    public static final Holder<PlacedFeature> UNCOMMON_SMALL_SLIME_CRATER = PlacementUtils.register("uncommon_small_slime_crater", CelestialFeatureUtils.SMALL_SLIME_CRATER, RarityFilter.onAverageOnceEvery(UNCOMMON_SMALL), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome());
    public static final Holder<PlacedFeature> UNCOMMON_MEDIUM_SLIME_CRATER = PlacementUtils.register("uncommon_medium_slime_crater", CelestialFeatureUtils.MEDIUM_SLIME_CRATER, RarityFilter.onAverageOnceEvery(UNCOMMON_MEDIUM), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome());
    public static final Holder<PlacedFeature> UNCOMMON_LARGE_SLIME_CRATER = PlacementUtils.register("uncommon_large_slime_crater", CelestialFeatureUtils.LARGE_SLIME_CRATER, RarityFilter.onAverageOnceEvery(UNCOMMON_LARGE), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome());

    public static final Holder<PlacedFeature> UNCOMMON_SMALL_ICE_CRATER = PlacementUtils.register("uncommon_small_ice_crater", CelestialFeatureUtils.SMALL_ICE_CRATER, RarityFilter.onAverageOnceEvery(UNCOMMON_SMALL + PLUS), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome());
    public static final Holder<PlacedFeature> UNCOMMON_MEDIUM_ICE_CRATER = PlacementUtils.register("uncommon_medium_ice_crater", CelestialFeatureUtils.MEDIUM_ICE_CRATER, RarityFilter.onAverageOnceEvery(UNCOMMON_MEDIUM + PLUS), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome());
    public static final Holder<PlacedFeature> UNCOMMON_LARGE_ICE_CRATER = PlacementUtils.register("uncommon_large_ice_crater", CelestialFeatureUtils.LARGE_ICE_CRATER, RarityFilter.onAverageOnceEvery(UNCOMMON_LARGE + PLUS), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome());

    public static final Holder<PlacedFeature> ASTEROID = PlacementUtils.register("asteroid", CelestialFeatureUtils.ASTEROID, RarityFilter.onAverageOnceEvery(3), PlacementUtils.countExtra(1, 0.25F, 1), InSquarePlacement.spread(), HeightRangePlacement.uniform(VerticalAnchor.absolute(40), VerticalAnchor.absolute(80)), BiomeFilter.biome());


//    public static final Holder<PlacedFeature> HYDRATE = PlacementUtils.register("hydrate", CelestialFeatureUtils.HYDRATE, RarityFilter.onAverageOnceEvery(20), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome());

}