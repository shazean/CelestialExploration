package com.shim.celestialexploration.world.features.placement;

import com.shim.celestialexploration.world.features.CelestialFeatures;
import com.shim.celestialexploration.world.features.CelestialOreFeatures;
import com.shim.celestialexploration.world.features.placement.CelestialOrePlacement;
import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.features.EndFeatures;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.placement.*;

public class CelestialFeaturePlacements {

    public static final Holder<PlacedFeature> OBSIDIAN_LAKE = PlacementUtils.register("obsidian_lake", CelestialFeatures.OBSIDIAN_LAKE, RarityFilter.onAverageOnceEvery(80), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome());

    //---- DISKS -------------------------------------------------------------------------------
    public static final Holder<PlacedFeature> DISK_MARS_SAND = PlacementUtils.register("disk_mars_sand", CelestialFeatures.DISK_MARS_SAND, CountPlacement.of(3), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_TOP_SOLID, BiomeFilter.biome());
    public static final Holder<PlacedFeature> DISK_MOON_SAND = PlacementUtils.register("disk_moon_sand", CelestialFeatures.DISK_MOON_SAND, CountPlacement.of(3), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_TOP_SOLID, BiomeFilter.biome());
    public static final Holder<PlacedFeature> DISK_VENUS_SAND = PlacementUtils.register("disk_venus_sand", CelestialFeatures.DISK_VENUS_SAND, CountPlacement.of(3), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_TOP_SOLID, BiomeFilter.biome());
    public static final Holder<PlacedFeature> DISK_MERCURY_SAND = PlacementUtils.register("disk_mercury_sand", CelestialFeatures.DISK_MERCURY_SAND, CountPlacement.of(3), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_TOP_SOLID, BiomeFilter.biome());
//    public static final Holder<PlacedFeature> DISK_IO_SAND = PlacementUtils.register("disk_io_sand", CelestialFeatures.DISK_IO_SAND, CountPlacement.of(3), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_TOP_SOLID, BiomeFilter.biome());


    //---- ORES -------------------------------------------------------------------------------
    public static final Holder<PlacedFeature> MOON_IRON_ORE_UPPER = PlacementUtils.register("moon_iron_ore_upper", CelestialOreFeatures.MOON_IRON_ORE, CelestialOrePlacement.commonOrePlacement(90, HeightRangePlacement.triangle(VerticalAnchor.absolute(80), VerticalAnchor.absolute(256))));
    public static final Holder<PlacedFeature> MOON_IRON_ORE_MIDDLE = PlacementUtils.register("moon_iron_ore_middle", CelestialOreFeatures.MOON_IRON_ORE, CelestialOrePlacement.commonOrePlacement(10, HeightRangePlacement.triangle(VerticalAnchor.absolute(-24), VerticalAnchor.absolute(56))));
    public static final Holder<PlacedFeature> MOON_IRON_ORE_SMALL = PlacementUtils.register("moon_iron_ore_small", CelestialOreFeatures.MOON_IRON_ORE_SMALL, CelestialOrePlacement.commonOrePlacement(10, HeightRangePlacement.uniform(VerticalAnchor.bottom(), VerticalAnchor.absolute(72))));
    public static final Holder<PlacedFeature> MOON_REDSTONE_ORE = PlacementUtils.register("moon_redstone_ore", CelestialOreFeatures.MOON_REDSTONE_ORE, CelestialOrePlacement.commonOrePlacement(4, HeightRangePlacement.uniform(VerticalAnchor.bottom(), VerticalAnchor.absolute(15))));
    public static final Holder<PlacedFeature> MOON_REDSTONE_ORE_LOWER = PlacementUtils.register("moon_redstone_ore_lower", CelestialOreFeatures.MOON_REDSTONE_ORE, CelestialOrePlacement.commonOrePlacement(8, HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-32), VerticalAnchor.aboveBottom(32))));
    public static final Holder<PlacedFeature> MOON_BAUXITE_ORE = PlacementUtils.register("moon_bauxite_ore", CelestialOreFeatures.MOON_BAUXITE_ORE, CelestialOrePlacement.commonOrePlacement(10, HeightRangePlacement.triangle(VerticalAnchor.absolute(-24), VerticalAnchor.absolute(56))));

    public static final Holder<PlacedFeature> MARS_IRON_ORE_UPPER = PlacementUtils.register("mars_iron_ore_upper", CelestialOreFeatures.MOON_IRON_ORE, CelestialOrePlacement.commonOrePlacement(100, HeightRangePlacement.triangle(VerticalAnchor.absolute(80), VerticalAnchor.absolute(384))));
    public static final Holder<PlacedFeature> MARS_IRON_ORE_MIDDLE = PlacementUtils.register("mars_iron_ore_middle", CelestialOreFeatures.MOON_IRON_ORE, CelestialOrePlacement.commonOrePlacement(20, HeightRangePlacement.triangle(VerticalAnchor.absolute(-24), VerticalAnchor.absolute(56))));
    public static final Holder<PlacedFeature> MARS_IRON_ORE_SMALL = PlacementUtils.register("mars_iron_ore_small", CelestialOreFeatures.MARS_IRON_ORE_SMALL, CelestialOrePlacement.commonOrePlacement(15, HeightRangePlacement.uniform(VerticalAnchor.bottom(), VerticalAnchor.absolute(72))));
    public static final Holder<PlacedFeature> MARS_REDSTONE_ORE = PlacementUtils.register("mars_redstone_ore", CelestialOreFeatures.MARS_REDSTONE_ORE, CelestialOrePlacement.commonOrePlacement(4, HeightRangePlacement.uniform(VerticalAnchor.bottom(), VerticalAnchor.absolute(15))));
    public static final Holder<PlacedFeature> MARS_REDSTONE_ORE_LOWER = PlacementUtils.register("mars_redstone_ore_lower", CelestialOreFeatures.MARS_REDSTONE_ORE, CelestialOrePlacement.commonOrePlacement(8, HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-32), VerticalAnchor.aboveBottom(32))));
    public static final Holder<PlacedFeature> MARS_BAUXITE_ORE = PlacementUtils.register("mars_bauxite_ore", CelestialOreFeatures.MARS_BAUXITE_ORE, CelestialOrePlacement.commonOrePlacement(10, HeightRangePlacement.triangle(VerticalAnchor.absolute(-24), VerticalAnchor.absolute(56))));

    public static final Holder<PlacedFeature> VENUS_IRON_ORE_UPPER = PlacementUtils.register("venus_iron_ore_upper", CelestialOreFeatures.VENUS_IRON_ORE, CelestialOrePlacement.commonOrePlacement(90, HeightRangePlacement.triangle(VerticalAnchor.absolute(80), VerticalAnchor.absolute(384))));
    public static final Holder<PlacedFeature> VENUS_IRON_ORE_MIDDLE = PlacementUtils.register("venus_iron_ore_middle", CelestialOreFeatures.VENUS_IRON_ORE, CelestialOrePlacement.commonOrePlacement(10, HeightRangePlacement.triangle(VerticalAnchor.absolute(-24), VerticalAnchor.absolute(56))));
    public static final Holder<PlacedFeature> VENUS_IRON_ORE_SMALL = PlacementUtils.register("venus_iron_ore_small", CelestialOreFeatures.VENUS_IRON_ORE_SMALL, CelestialOrePlacement.commonOrePlacement(10, HeightRangePlacement.uniform(VerticalAnchor.bottom(), VerticalAnchor.absolute(72))));
    public static final Holder<PlacedFeature> VENUS_REDSTONE_ORE = PlacementUtils.register("venus_redstone_ore", CelestialOreFeatures.VENUS_REDSTONE_ORE, CelestialOrePlacement.commonOrePlacement(4, HeightRangePlacement.uniform(VerticalAnchor.bottom(), VerticalAnchor.absolute(15))));
    public static final Holder<PlacedFeature> VENUS_REDSTONE_ORE_LOWER = PlacementUtils.register("venus_redstone_ore_lower", CelestialOreFeatures.VENUS_REDSTONE_ORE, CelestialOrePlacement.commonOrePlacement(8, HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-32), VerticalAnchor.aboveBottom(32))));
    public static final Holder<PlacedFeature> VENUS_LAPIS_ORE = PlacementUtils.register("venus_lapis_ore", CelestialOreFeatures.VENUS_LAPIS_ORE, CelestialOrePlacement.commonOrePlacement(4, HeightRangePlacement.triangle(VerticalAnchor.absolute(-32), VerticalAnchor.absolute(32))));
    public static final Holder<PlacedFeature> VENUS_LAPIS_ORE_BURIED = PlacementUtils.register("venus_lapis_ore_buried", CelestialOreFeatures.VENUS_LAPIS_ORE_BURIED, CelestialOrePlacement.commonOrePlacement(4, HeightRangePlacement.uniform(VerticalAnchor.bottom(), VerticalAnchor.absolute(64))));
    public static final Holder<PlacedFeature> VENUS_BAUXITE_ORE = PlacementUtils.register("venus_bauxite_ore", CelestialOreFeatures.VENUS_BAUXITE_ORE, CelestialOrePlacement.commonOrePlacement(10, HeightRangePlacement.triangle(VerticalAnchor.absolute(-24), VerticalAnchor.absolute(56))));

    public static final Holder<PlacedFeature> BAUXITE_ORE = PlacementUtils.register("bauxite_ore", CelestialOreFeatures.BAUXITE_ORE, CelestialOrePlacement.commonOrePlacement(10, HeightRangePlacement.triangle(VerticalAnchor.absolute(-24), VerticalAnchor.absolute(56))));

    public static final Holder<PlacedFeature> MERCURY_IRON_ORE_UPPER = PlacementUtils.register("mercury_iron_ore_upper", CelestialOreFeatures.MERCURY_IRON_ORE, CelestialOrePlacement.commonOrePlacement(90, HeightRangePlacement.triangle(VerticalAnchor.absolute(80), VerticalAnchor.absolute(384))));
    public static final Holder<PlacedFeature> MERCURY_IRON_ORE_MIDDLE = PlacementUtils.register("mercury_iron_ore_middle", CelestialOreFeatures.MERCURY_IRON_ORE, CelestialOrePlacement.commonOrePlacement(10, HeightRangePlacement.triangle(VerticalAnchor.absolute(-24), VerticalAnchor.absolute(56))));
    public static final Holder<PlacedFeature> MERCURY_IRON_ORE_SMALL = PlacementUtils.register("mercury_iron_ore_small", CelestialOreFeatures.MERCURY_IRON_ORE_SMALL, CelestialOrePlacement.commonOrePlacement(10, HeightRangePlacement.uniform(VerticalAnchor.bottom(), VerticalAnchor.absolute(72))));
    public static final Holder<PlacedFeature> MERCURY_REDSTONE_ORE = PlacementUtils.register("mercury_redstone_ore", CelestialOreFeatures.MERCURY_REDSTONE_ORE, CelestialOrePlacement.commonOrePlacement(4, HeightRangePlacement.uniform(VerticalAnchor.bottom(), VerticalAnchor.absolute(15))));
    public static final Holder<PlacedFeature> MERCURY_REDSTONE_ORE_LOWER = PlacementUtils.register("mercury_redstone_ore_lower", CelestialOreFeatures.MERCURY_REDSTONE_ORE, CelestialOrePlacement.commonOrePlacement(8, HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-32), VerticalAnchor.aboveBottom(32))));
    public static final Holder<PlacedFeature> MERCURY_COAL_ORE_UPPER = PlacementUtils.register("mercury_coal_ore_upper", CelestialOreFeatures.MERCURY_COAL_ORE, CelestialOrePlacement.commonOrePlacement(30, HeightRangePlacement.uniform(VerticalAnchor.absolute(136), VerticalAnchor.top())));
    public static final Holder<PlacedFeature> MERCURY_COAL_ORE_LOWER = PlacementUtils.register("mercury_coal_ore_lower", CelestialOreFeatures.MERCURY_COAL_ORE_LOWER, CelestialOrePlacement.commonOrePlacement(20, HeightRangePlacement.triangle(VerticalAnchor.absolute(0), VerticalAnchor.absolute(192))));
    public static final Holder<PlacedFeature> MERCURY_BAUXITE_ORE = PlacementUtils.register("mercury_bauxite_ore", CelestialOreFeatures.MERCURY_BAUXITE_ORE, CelestialOrePlacement.commonOrePlacement(10, HeightRangePlacement.triangle(VerticalAnchor.absolute(-24), VerticalAnchor.absolute(56))));
    public static final Holder<PlacedFeature> MERCURY_SULFUR_ORE = PlacementUtils.register("mercury_sulfur_ore", CelestialOreFeatures.MERCURY_SULFUR_ORE, CelestialOrePlacement.commonOrePlacement(10, HeightRangePlacement.triangle(VerticalAnchor.absolute(-24), VerticalAnchor.absolute(56))));
    public static final Holder<PlacedFeature> MERCURY_DIAMOND_ORE = PlacementUtils.register("mercury_diamond_ore", CelestialOreFeatures.MERCURY_DIAMOND_ORE, CelestialOrePlacement.commonOrePlacement(7, HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-16), VerticalAnchor.aboveBottom(16))));



//    public static final Holder<PlacedFeature> JUPITER_CLOUD = PlacementUtils.register("jupiter_cloud", CelestialFeatures.JUPITER_CLOUD, RarityFilter.onAverageOnceEvery(14), PlacementUtils.countExtra(1, 0.25F, 1), InSquarePlacement.spread(), HeightRangePlacement.uniform(VerticalAnchor.absolute(55), VerticalAnchor.absolute(70)), BiomeFilter.biome());
//    public static final Holder<PlacedFeature> END_ISLAND_DECORATED = PlacementUtils.register("end_island_decorated", EndFeatures.END_ISLAND, RarityFilter.onAverageOnceEvery(14), PlacementUtils.countExtra(1, 0.25F, 1), InSquarePlacement.spread(), HeightRangePlacement.uniform(VerticalAnchor.absolute(55), VerticalAnchor.absolute(70)), BiomeFilter.biome());


}
