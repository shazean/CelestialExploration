package com.shim.celestialexploration.world.features.placement;

import com.shim.celestialexploration.world.features.CelestialFeatureUtils;
import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.heightproviders.BiasedToBottomHeight;
import net.minecraft.world.level.levelgen.placement.*;

public class SurfacePlacements {

    public static final Holder<PlacedFeature> GEYSER = PlacementUtils.register("geyser", CelestialFeatureUtils.GEYSER, InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome());

    public static final Holder<PlacedFeature> JUPITER_CLOUD = PlacementUtils.register("jupiter_cloud", CelestialFeatureUtils.JUPITER_CLOUD, RarityFilter.onAverageOnceEvery(20), InSquarePlacement.spread(), HeightRangePlacement.of(BiasedToBottomHeight.of(VerticalAnchor.absolute(64), VerticalAnchor.absolute(512), 8)), BiomeFilter.biome());

}