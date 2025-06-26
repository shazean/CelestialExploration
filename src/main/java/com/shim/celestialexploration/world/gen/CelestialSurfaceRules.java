package com.shim.celestialexploration.world.gen;

import com.google.common.collect.ImmutableList;
import com.shim.celestialexploration.registry.CelestialBlocks;
import com.shim.celestialexploration.world.biome.CelestialBiomeKeys;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.Noises;
import net.minecraft.world.level.levelgen.SurfaceRules;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.placement.CaveSurface;


public class CelestialSurfaceRules {
    public static final SurfaceRules.ConditionSource EXTRA_DEEP_UNDER_FLOOR = SurfaceRules.stoneDepthCheck(0, true, 50, CaveSurface.FLOOR);

    private static final SurfaceRules.RuleSource AIR = makeStateRule(Blocks.AIR);
    private static final SurfaceRules.RuleSource BEDROCK = makeStateRule(Blocks.BEDROCK);
    private static final SurfaceRules.RuleSource DRY_ICE = makeStateRule(CelestialBlocks.DRY_ICE.get());
    private static final SurfaceRules.RuleSource MARS_DEEPSLATE = makeStateRule(CelestialBlocks.MARS_DEEPSLATE.get());
    private static final SurfaceRules.RuleSource MARS_SAND = makeStateRule(CelestialBlocks.MARS_SAND.get());
    private static final SurfaceRules.RuleSource COARSE_MARS_SAND = makeStateRule(CelestialBlocks.COARSE_MARS_SAND.get());
    private static final SurfaceRules.RuleSource MOON_DEEPSLATE = makeStateRule(CelestialBlocks.MOON_DEEPSLATE.get());
    private static final SurfaceRules.RuleSource MOON_STONE = makeStateRule(CelestialBlocks.MOON_STONE.get());
    private static final SurfaceRules.RuleSource MOON_SAND = makeStateRule(CelestialBlocks.MOON_SAND.get());
    private static final SurfaceRules.RuleSource COARSE_MOON_SAND = makeStateRule(CelestialBlocks.COARSE_MOON_SAND.get());
    private static final SurfaceRules.RuleSource GLOWING_MOON_SAND = makeStateRule(CelestialBlocks.GLOWING_MOON_SAND.get());
    private static final SurfaceRules.RuleSource VENUS_DEEPSLATE = makeStateRule(CelestialBlocks.VENUS_DEEPSLATE.get());
    private static final SurfaceRules.RuleSource VENUS_SAND = makeStateRule(CelestialBlocks.VENUS_SAND.get());
    private static final SurfaceRules.RuleSource FINE_VENUS_SAND = makeStateRule(CelestialBlocks.FINE_VENUS_SAND.get());
    private static final SurfaceRules.RuleSource GEYSER = makeStateRule(CelestialBlocks.GEYSER.get());
    private static final SurfaceRules.RuleSource MERCURY_DEEPSLATE = makeStateRule(CelestialBlocks.MERCURY_DEEPSLATE.get());
    private static final SurfaceRules.RuleSource MERCURY_SAND = makeStateRule(CelestialBlocks.MERCURY_SAND.get());
    private static final SurfaceRules.RuleSource COARSE_MERCURY_SAND = makeStateRule(CelestialBlocks.COARSE_MERCURY_SAND.get());
    private static final SurfaceRules.RuleSource JUPITER_DEEPSLATE = makeStateRule(CelestialBlocks.JUPITER_DEEPSLATE.get());
    private static final SurfaceRules.RuleSource GLOWING_EUROPA_SAND = makeStateRule(CelestialBlocks.GLOWING_EUROPA_SAND.get());
    private static final SurfaceRules.RuleSource HYDRATE = makeStateRule(CelestialBlocks.EUROPA_HYDRATE.get());
    private static final SurfaceRules.RuleSource PACKED_ICE = makeStateRule(Blocks.PACKED_ICE);
    private static final SurfaceRules.RuleSource WATER = makeStateRule(Blocks.WATER);
    private static final SurfaceRules.RuleSource WHITE_TERRACOTTA = makeStateRule(Blocks.WHITE_TERRACOTTA);
    private static final SurfaceRules.RuleSource ORANGE_TERRACOTTA = makeStateRule(Blocks.ORANGE_TERRACOTTA);
    private static final SurfaceRules.RuleSource TERRACOTTA = makeStateRule(Blocks.TERRACOTTA);
    private static final SurfaceRules.RuleSource RED_SAND = makeStateRule(Blocks.RED_SAND);
    private static final SurfaceRules.RuleSource RED_SANDSTONE = makeStateRule(Blocks.RED_SANDSTONE);
    private static final SurfaceRules.RuleSource STONE = makeStateRule(Blocks.STONE);
    private static final SurfaceRules.RuleSource DEEPSLATE = makeStateRule(Blocks.DEEPSLATE);
    private static final SurfaceRules.RuleSource DIRT = makeStateRule(Blocks.DIRT);
    private static final SurfaceRules.RuleSource PODZOL = makeStateRule(Blocks.PODZOL);
    private static final SurfaceRules.RuleSource COARSE_DIRT = makeStateRule(Blocks.COARSE_DIRT);
    private static final SurfaceRules.RuleSource MYCELIUM = makeStateRule(Blocks.MYCELIUM);
    private static final SurfaceRules.RuleSource GRASS_BLOCK = makeStateRule(Blocks.GRASS_BLOCK);
    private static final SurfaceRules.RuleSource CALCITE = makeStateRule(Blocks.CALCITE);
    private static final SurfaceRules.RuleSource GRAVEL = makeStateRule(Blocks.GRAVEL);
    private static final SurfaceRules.RuleSource SAND = makeStateRule(Blocks.SAND);
    private static final SurfaceRules.RuleSource SANDSTONE = makeStateRule(Blocks.SANDSTONE);
    private static final SurfaceRules.RuleSource SNOW_BLOCK = makeStateRule(Blocks.SNOW_BLOCK);
    private static final SurfaceRules.RuleSource POWDER_SNOW = makeStateRule(Blocks.POWDER_SNOW);
    private static final SurfaceRules.RuleSource ICE = makeStateRule(Blocks.ICE);
    private static final SurfaceRules.RuleSource GLOWING_CALLISTO_SAND = makeStateRule(CelestialBlocks.GLOWING_CALLISTO_SAND.get());
    private static final SurfaceRules.RuleSource GLOWING_IO_SAND = makeStateRule(CelestialBlocks.GLOWING_IO_SAND.get());
    private static final SurfaceRules.RuleSource IO_SAND = makeStateRule(CelestialBlocks.IO_SAND.get());
    private static final SurfaceRules.RuleSource COARSE_IO_SAND = makeStateRule(CelestialBlocks.COARSE_IO_SAND.get());
    private static final SurfaceRules.RuleSource IO_DEEPSLATE = makeStateRule(CelestialBlocks.IO_DEEPSLATE.get());
    private static final SurfaceRules.RuleSource IO_GEYSER = makeStateRule(CelestialBlocks.IO_GEYSER.get());
    private static final SurfaceRules.RuleSource GLOWING_GANYMEDE_SAND = makeStateRule(CelestialBlocks.GLOWING_GANYMEDE_SAND.get());


    private static SurfaceRules.RuleSource makeStateRule(Block block) {
        return SurfaceRules.state(block.defaultBlockState());
    }

    public static SurfaceRules.RuleSource mars() {
        ImmutableList.Builder<SurfaceRules.RuleSource> builder = ImmutableList.builder();


        SurfaceRules.ConditionSource dryIce = SurfaceRules.isBiome(CelestialBiomeKeys.MARS_DRY_ICE_FLATS, CelestialBiomeKeys.MARS_DRY_ICE_FLATS);
        SurfaceRules.ConditionSource shallowSand = SurfaceRules.isBiome(CelestialBiomeKeys.MARS_CRATERS, CelestialBiomeKeys.MARS_DEEP_CRATERS, CelestialBiomeKeys.MARS_ERODED_FLATS, CelestialBiomeKeys.MARS_FLATS, CelestialBiomeKeys.MARS_VOLCANO_FLATS);

        builder.add(SurfaceRules.ifTrue(dryIce, SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.abovePreliminarySurface(),
                SurfaceRules.ifTrue(SurfaceRules.stoneDepthCheck(0, false, 0, CaveSurface.FLOOR), DRY_ICE)))));

        builder.add(SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.stoneDepthCheck(0, false, 3, CaveSurface.FLOOR), SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.SURFACE, -0.9F, -0.3F), COARSE_MARS_SAND))));

        builder.add(SurfaceRules.ifTrue(SurfaceRules.isBiome(CelestialBiomeKeys.MARS_DUNES), SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.abovePreliminarySurface(),
                SurfaceRules.ifTrue(SurfaceRules.stoneDepthCheck(0, false, 20, CaveSurface.FLOOR), MARS_SAND)))));

        builder.add(SurfaceRules.ifTrue(SurfaceRules.isBiome(CelestialBiomeKeys.MARS_DESERT), SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.abovePreliminarySurface(),
                SurfaceRules.ifTrue(SurfaceRules.stoneDepthCheck(0, false, 3, CaveSurface.FLOOR), MARS_SAND)))));

        builder.add(SurfaceRules.ifTrue(shallowSand, SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.abovePreliminarySurface(),
                SurfaceRules.ifTrue(SurfaceRules.stoneDepthCheck(0, false, 1, CaveSurface.FLOOR), MARS_SAND)))));


        builder.add(SurfaceRules.ifTrue(SurfaceRules.verticalGradient("bedrock_floor", VerticalAnchor.bottom(), VerticalAnchor.aboveBottom(5)), BEDROCK));

        builder.add(SurfaceRules.ifTrue(SurfaceRules.verticalGradient("deepslate", VerticalAnchor.absolute(0), VerticalAnchor.absolute(8)), MARS_DEEPSLATE));
        return SurfaceRules.sequence(builder.build().toArray(SurfaceRules.RuleSource[]::new));
    }

    public static SurfaceRules.RuleSource moon() {
        ImmutableList.Builder<SurfaceRules.RuleSource> builder = ImmutableList.builder();

        SurfaceRules.ConditionSource shallowSand = SurfaceRules.isBiome(CelestialBiomeKeys.MOON_PLAINS, CelestialBiomeKeys.MOON_LOWER_PLAINS, CelestialBiomeKeys.MOON_CRATERS, CelestialBiomeKeys.MOON_LAVA_FLATS);

        builder.add(SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.abovePreliminarySurface(),
                SurfaceRules.ifTrue(SurfaceRules.stoneDepthCheck(0, false, 1, CaveSurface.FLOOR), SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.PATCH, .7F, 1.0F), GLOWING_MOON_SAND)))));

        builder.add(SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.abovePreliminarySurface(),
                SurfaceRules.ifTrue(SurfaceRules.stoneDepthCheck(0, false, 1, CaveSurface.FLOOR), SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.PATCH, -1.0F, -0.8F), GLOWING_MOON_SAND)))));

        builder.add(SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.stoneDepthCheck(0, false, 3, CaveSurface.FLOOR), SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.SURFACE, -0.9F, -0.3F), COARSE_MOON_SAND))));

        builder.add(SurfaceRules.ifTrue(SurfaceRules.isBiome(CelestialBiomeKeys.MOON_DESERT), SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.abovePreliminarySurface(),
                SurfaceRules.ifTrue(SurfaceRules.stoneDepthCheck(0, false, 15, CaveSurface.FLOOR), MOON_SAND)))));

        builder.add(SurfaceRules.ifTrue(shallowSand, SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.abovePreliminarySurface(),
                SurfaceRules.ifTrue(SurfaceRules.stoneDepthCheck(0, false, 1, CaveSurface.FLOOR), MOON_SAND)))));


        builder.add(SurfaceRules.ifTrue(SurfaceRules.verticalGradient("bedrock_floor", VerticalAnchor.bottom(), VerticalAnchor.aboveBottom(5)), BEDROCK));

        builder.add(SurfaceRules.ifTrue(SurfaceRules.verticalGradient("deepslate", VerticalAnchor.absolute(0), VerticalAnchor.absolute(8)), MOON_DEEPSLATE));
        return SurfaceRules.sequence(builder.build().toArray(SurfaceRules.RuleSource[]::new));
    }

    public static SurfaceRules.RuleSource venus() {
        ImmutableList.Builder<SurfaceRules.RuleSource> builder = ImmutableList.builder();

        SurfaceRules.ConditionSource shallowSand = SurfaceRules.isBiome(CelestialBiomeKeys.VENUS_PLAINS, CelestialBiomeKeys.VENUS_LOWER_PLAINS, CelestialBiomeKeys.VENUS_SULFUR_FLATS);

        builder.add(SurfaceRules.ifTrue(SurfaceRules.isBiome(CelestialBiomeKeys.VENUS_DESERT), SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.abovePreliminarySurface(),
                SurfaceRules.ifTrue(SurfaceRules.stoneDepthCheck(0, false, 15, CaveSurface.FLOOR), VENUS_SAND)))));


        builder.add(SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.abovePreliminarySurface(),
                SurfaceRules.ifTrue(SurfaceRules.stoneDepthCheck(0, false, 1, CaveSurface.FLOOR), SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.PATCH, .9F, 1.0F), GEYSER)))));

        builder.add(SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.abovePreliminarySurface(),
                SurfaceRules.ifTrue(SurfaceRules.stoneDepthCheck(0, false, 1, CaveSurface.FLOOR), SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.SURFACE, -1.0F, -.9F), GEYSER)))));

        builder.add(SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.abovePreliminarySurface(),
                SurfaceRules.ifTrue(SurfaceRules.stoneDepthCheck(0, false, 1, CaveSurface.FLOOR), SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.PATCH, -1.0F, -.9F), GEYSER)))));

        builder.add(SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.stoneDepthCheck(0, false, 3, CaveSurface.FLOOR), SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.SURFACE, -0.9F, -0.3F), FINE_VENUS_SAND))));

        builder.add(SurfaceRules.ifTrue(shallowSand, SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.abovePreliminarySurface(),
                SurfaceRules.ifTrue(SurfaceRules.stoneDepthCheck(0, false, 1, CaveSurface.FLOOR), VENUS_SAND)))));

        builder.add(SurfaceRules.ifTrue(SurfaceRules.verticalGradient("bedrock_floor", VerticalAnchor.bottom(), VerticalAnchor.aboveBottom(5)), BEDROCK));

        builder.add(SurfaceRules.ifTrue(SurfaceRules.verticalGradient("deepslate", VerticalAnchor.absolute(0), VerticalAnchor.absolute(8)), VENUS_DEEPSLATE));
        return SurfaceRules.sequence(builder.build().toArray(SurfaceRules.RuleSource[]::new));
    }

    public static SurfaceRules.RuleSource mercury() {
        ImmutableList.Builder<SurfaceRules.RuleSource> builder = ImmutableList.builder();

        SurfaceRules.ConditionSource shallowSand = SurfaceRules.isBiome(CelestialBiomeKeys.MERCURY_CRATERED_PLAINS, CelestialBiomeKeys.MERCURY_DEEP_CRATERED_PLAINS, CelestialBiomeKeys.MERCURY_PLAINS, CelestialBiomeKeys.MERCURY_RIDGES);

        builder.add(SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.stoneDepthCheck(0, false, 3, CaveSurface.FLOOR), SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.SURFACE, -0.9F, -0.3F), COARSE_MERCURY_SAND))));

        builder.add(SurfaceRules.ifTrue(SurfaceRules.isBiome(CelestialBiomeKeys.MERCURY_DESERT), SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.abovePreliminarySurface(),
                SurfaceRules.ifTrue(SurfaceRules.stoneDepthCheck(0, false, 15, CaveSurface.FLOOR), MERCURY_SAND)))));

        builder.add(SurfaceRules.ifTrue(shallowSand, SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.abovePreliminarySurface(),
                SurfaceRules.ifTrue(SurfaceRules.stoneDepthCheck(0, false, 1, CaveSurface.FLOOR), MERCURY_SAND)))));


        builder.add(SurfaceRules.ifTrue(SurfaceRules.verticalGradient("bedrock_floor", VerticalAnchor.bottom(), VerticalAnchor.aboveBottom(5)), BEDROCK));

        builder.add(SurfaceRules.ifTrue(SurfaceRules.verticalGradient("deepslate", VerticalAnchor.absolute(0), VerticalAnchor.absolute(8)), MERCURY_DEEPSLATE));
        return SurfaceRules.sequence(builder.build().toArray(SurfaceRules.RuleSource[]::new));
    }

    public static SurfaceRules.RuleSource space() {
        ImmutableList.Builder<SurfaceRules.RuleSource> builder = ImmutableList.builder();

        builder.add(SurfaceRules.ifTrue(SurfaceRules.verticalGradient("air", VerticalAnchor.bottom(), VerticalAnchor.aboveBottom(5)), AIR));

//        builder.add(SurfaceRules.ifTrue(SurfaceRules.isBiome(CelestialBiomeKeys.SPACE), AIR));

        return SurfaceRules.sequence(builder.build().toArray(SurfaceRules.RuleSource[]::new));
    }

    public static SurfaceRules.RuleSource jupiter() {
        ImmutableList.Builder<SurfaceRules.RuleSource> builder = ImmutableList.builder();
        builder.add(SurfaceRules.ifTrue(SurfaceRules.verticalGradient("bedrock_floor", VerticalAnchor.bottom(), VerticalAnchor.aboveBottom(5)), BEDROCK));

        return SurfaceRules.sequence(builder.build().toArray(SurfaceRules.RuleSource[]::new));
    }

    public static SurfaceRules.RuleSource europa() {
        ImmutableList.Builder<SurfaceRules.RuleSource> builder = ImmutableList.builder();

        SurfaceRules.ConditionSource shallowSand = SurfaceRules.isBiome(CelestialBiomeKeys.EUROPA_PLAINS, CelestialBiomeKeys.EUROPA_LOWER_PLAINS, CelestialBiomeKeys.EUROPA_JAGGED_PLAINS, CelestialBiomeKeys.EUROPA_OCEAN, CelestialBiomeKeys.EUROPA_RIVER);

        builder.add(SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.abovePreliminarySurface(),
                SurfaceRules.ifTrue(SurfaceRules.stoneDepthCheck(0, false, 1, CaveSurface.FLOOR), SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.PATCH, .7F, 1.0F), GLOWING_EUROPA_SAND)))));

        builder.add(SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.abovePreliminarySurface(),
                SurfaceRules.ifTrue(SurfaceRules.stoneDepthCheck(0, false, 1, CaveSurface.FLOOR), SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.PATCH, -1.0F, -0.8F), GLOWING_EUROPA_SAND)))));

        builder.add(SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.stoneDepthCheck(0, false, 3, CaveSurface.FLOOR), SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.SURFACE, -0.9F, -0.69F), COARSE_MOON_SAND))));

        builder.add(SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.abovePreliminarySurface(), SurfaceRules.ifTrue(SurfaceRules.stoneDepthCheck(0, false, 1, CaveSurface.FLOOR), SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.SURFACE_SECONDARY, -0.9F, -0.69F), AIR)))));

        builder.add(SurfaceRules.ifTrue(SurfaceRules.isBiome(CelestialBiomeKeys.EUROPA_DESERT), SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.abovePreliminarySurface(),
                SurfaceRules.ifTrue(SurfaceRules.stoneDepthCheck(0, false, 15, CaveSurface.FLOOR), MOON_SAND)))));

        builder.add(SurfaceRules.ifTrue(shallowSand, SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.abovePreliminarySurface(),
                SurfaceRules.ifTrue(SurfaceRules.stoneDepthCheck(0, false, 3, CaveSurface.FLOOR), MOON_SAND)))));


        builder.add(SurfaceRules.ifTrue(SurfaceRules.verticalGradient("bedrock_floor", VerticalAnchor.bottom(), VerticalAnchor.aboveBottom(5)), BEDROCK));
        builder.add(SurfaceRules.ifTrue(SurfaceRules.verticalGradient("deepslate", VerticalAnchor.absolute(-32), VerticalAnchor.absolute(0)), MOON_DEEPSLATE));

        return SurfaceRules.sequence(builder.build().toArray(SurfaceRules.RuleSource[]::new));
    }

    public static SurfaceRules.RuleSource callisto() {
        ImmutableList.Builder<SurfaceRules.RuleSource> builder = ImmutableList.builder();

//        SurfaceRules.ConditionSource shallowSand = SurfaceRules.isBiome(CelestialBiomeKeys.MOON_PLAINS, CelestialBiomeKeys.MOON_LOWER_PLAINS, CelestialBiomeKeys.MOON_CRATERS, CelestialBiomeKeys.MOON_LAVA_FLATS);

        builder.add(SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.abovePreliminarySurface(),
                SurfaceRules.ifTrue(SurfaceRules.stoneDepthCheck(0, false, 1, CaveSurface.FLOOR),
                        SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.PATCH, .7F, 1.0F), GLOWING_CALLISTO_SAND)))));

        builder.add(SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.abovePreliminarySurface(),
                SurfaceRules.ifTrue(SurfaceRules.stoneDepthCheck(0, false, 1, CaveSurface.FLOOR),
                        SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.PATCH, -1.0F, -0.8F), COARSE_MOON_SAND)))));

        builder.add(SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.abovePreliminarySurface(),
                SurfaceRules.ifTrue(SurfaceRules.stoneDepthCheck(0, false, 1, CaveSurface.FLOOR),
                        SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.PATCH, -0.8F, -0.6F), MOON_SAND)))));


        builder.add(SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.stoneDepthCheck(0, false, 3, CaveSurface.FLOOR), SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.SURFACE, -0.9F, -0.3F), MOON_STONE))));

        builder.add(SurfaceRules.ifTrue(SurfaceRules.isBiome(CelestialBiomeKeys.CALLISTO_DESERT), SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.abovePreliminarySurface(),
                SurfaceRules.ifTrue(SurfaceRules.stoneDepthCheck(0, false, 1, CaveSurface.FLOOR), MOON_SAND)))));

//        builder.add(SurfaceRules.ifTrue(shallowSand, SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.abovePreliminarySurface(),
//                SurfaceRules.ifTrue(SurfaceRules.stoneDepthCheck(0, false, 1, CaveSurface.FLOOR), MOON_SAND)))));


        builder.add(SurfaceRules.ifTrue(SurfaceRules.verticalGradient("bedrock_floor", VerticalAnchor.bottom(), VerticalAnchor.aboveBottom(5)), BEDROCK));

        builder.add(SurfaceRules.ifTrue(SurfaceRules.verticalGradient("deepslate", VerticalAnchor.absolute(0), VerticalAnchor.absolute(8)), MOON_DEEPSLATE));
        return SurfaceRules.sequence(builder.build().toArray(SurfaceRules.RuleSource[]::new));
    }

    public static SurfaceRules.RuleSource ganymede() {
        ImmutableList.Builder<SurfaceRules.RuleSource> builder = ImmutableList.builder();

        SurfaceRules.ConditionSource shallowSand = SurfaceRules.isBiome(CelestialBiomeKeys.GANYMEDE_PLAINS, CelestialBiomeKeys.GANYMEDE_LOWER_PLAINS, CelestialBiomeKeys.GANYMEDE_CRATERED_PLAINS, CelestialBiomeKeys.GANYMEDE_PLAINS);

        builder.add(SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.abovePreliminarySurface(),
                SurfaceRules.ifTrue(SurfaceRules.stoneDepthCheck(0, false, 1, CaveSurface.FLOOR),
                        SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.PATCH, .7F, 1.0F), GLOWING_GANYMEDE_SAND)))));

        builder.add(SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.abovePreliminarySurface(),
                SurfaceRules.ifTrue(SurfaceRules.stoneDepthCheck(0, false, 1, CaveSurface.FLOOR),
                        SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.PATCH, -1.0F, -0.8F), COARSE_MOON_SAND)))));

        builder.add(SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.abovePreliminarySurface(),
                SurfaceRules.ifTrue(SurfaceRules.stoneDepthCheck(0, false, 1, CaveSurface.FLOOR),
                        SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.PATCH, -0.8F, -0.6F), MOON_SAND)))));

        builder.add(SurfaceRules.ifTrue(SurfaceRules.isBiome(CelestialBiomeKeys.GANYMEDE_DESERT), SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.abovePreliminarySurface(),
                SurfaceRules.ifTrue(SurfaceRules.stoneDepthCheck(0, false, 1, CaveSurface.FLOOR), MOON_SAND)))));

        builder.add(SurfaceRules.ifTrue(shallowSand, SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.abovePreliminarySurface(),
                SurfaceRules.ifTrue(SurfaceRules.stoneDepthCheck(0, false, 1, CaveSurface.FLOOR), MOON_SAND)))));

        builder.add(SurfaceRules.ifTrue(SurfaceRules.verticalGradient("bedrock_floor", VerticalAnchor.bottom(), VerticalAnchor.aboveBottom(5)), BEDROCK));

        builder.add(SurfaceRules.ifTrue(SurfaceRules.verticalGradient("deepslate", VerticalAnchor.absolute(0), VerticalAnchor.absolute(8)), MOON_DEEPSLATE));
        return SurfaceRules.sequence(builder.build().toArray(SurfaceRules.RuleSource[]::new));
    }

    public static SurfaceRules.RuleSource io() {
        ImmutableList.Builder<SurfaceRules.RuleSource> builder = ImmutableList.builder();

        SurfaceRules.ConditionSource shallowSand = SurfaceRules.isBiome(CelestialBiomeKeys.IO_PLAINS, CelestialBiomeKeys.IO_LOWER_PLAINS, CelestialBiomeKeys.IO_SULFUR_FLATS);

        builder.add(SurfaceRules.ifTrue(SurfaceRules.isBiome(CelestialBiomeKeys.IO_DESERT), SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.abovePreliminarySurface(),
                SurfaceRules.ifTrue(SurfaceRules.stoneDepthCheck(0, false, 15, CaveSurface.FLOOR), IO_SAND)))));

        builder.add(SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.abovePreliminarySurface(),
                SurfaceRules.ifTrue(SurfaceRules.stoneDepthCheck(0, false, 1, CaveSurface.FLOOR), SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.PATCH, .7F, 1.0F), GLOWING_IO_SAND)))));

        builder.add(SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.abovePreliminarySurface(),
                SurfaceRules.ifTrue(SurfaceRules.stoneDepthCheck(0, false, 1, CaveSurface.FLOOR), SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.PATCH, .9F, 1.0F), IO_GEYSER)))));

        builder.add(SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.abovePreliminarySurface(),
                SurfaceRules.ifTrue(SurfaceRules.stoneDepthCheck(0, false, 1, CaveSurface.FLOOR), SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.SURFACE, -1.0F, -.9F), IO_GEYSER)))));

        builder.add(SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.abovePreliminarySurface(),
                SurfaceRules.ifTrue(SurfaceRules.stoneDepthCheck(0, false, 1, CaveSurface.FLOOR), SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.PATCH, -1.0F, -.9F), IO_GEYSER)))));

        builder.add(SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.stoneDepthCheck(0, false, 3, CaveSurface.FLOOR), SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.SURFACE, -0.9F, -0.3F), COARSE_IO_SAND))));

        builder.add(SurfaceRules.ifTrue(shallowSand, SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.abovePreliminarySurface(),
                SurfaceRules.ifTrue(SurfaceRules.stoneDepthCheck(0, false, 1, CaveSurface.FLOOR), IO_SAND)))));

        builder.add(SurfaceRules.ifTrue(SurfaceRules.verticalGradient("bedrock_floor", VerticalAnchor.bottom(), VerticalAnchor.aboveBottom(5)), BEDROCK));

        builder.add(SurfaceRules.ifTrue(SurfaceRules.verticalGradient("deepslate", VerticalAnchor.absolute(0), VerticalAnchor.absolute(8)), IO_DEEPSLATE));
        return SurfaceRules.sequence(builder.build().toArray(SurfaceRules.RuleSource[]::new));
    }

    public static SurfaceRules.RuleSource datapackPresets(boolean isDesertPreset) {
        ImmutableList.Builder<SurfaceRules.RuleSource> builder = ImmutableList.builder();

        if (isDesertPreset) {
            SurfaceRules.ConditionSource isDunes = SurfaceRules.isBiome(CelestialBiomeKeys.DUNES);
            SurfaceRules.ConditionSource needsSand = SurfaceRules.isBiome(CelestialBiomeKeys.HIGH_DESERT, CelestialBiomeKeys.LOW_DESERT, CelestialBiomeKeys.MONSOON_DESERT);
            SurfaceRules.ConditionSource needsSnow = SurfaceRules.isBiome(CelestialBiomeKeys.ICY_DESERT);
            SurfaceRules.ConditionSource needsSandstone = SurfaceRules.isBiome(CelestialBiomeKeys.ICY_DESERT, CelestialBiomeKeys.HIGH_DESERT, CelestialBiomeKeys.LOW_DESERT, CelestialBiomeKeys.MONSOON_DESERT);

            builder.add(SurfaceRules.sequence(SurfaceRules.ifTrue(isDunes, SurfaceRules.ifTrue(SurfaceRules.VERY_DEEP_UNDER_FLOOR, SAND))));
            builder.add(SurfaceRules.sequence(SurfaceRules.ifTrue(needsSand, SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, SAND))));
            builder.add(SurfaceRules.sequence(SurfaceRules.ifTrue(needsSandstone, SurfaceRules.ifTrue(SurfaceRules.VERY_DEEP_UNDER_FLOOR, SANDSTONE))));
            builder.add(SurfaceRules.sequence(SurfaceRules.ifTrue(isDunes, SurfaceRules.ifTrue(EXTRA_DEEP_UNDER_FLOOR, SANDSTONE))));
            builder.add(SurfaceRules.sequence(SurfaceRules.ifTrue(needsSnow, SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, SNOW_BLOCK))));
        }

        SurfaceRules.ConditionSource isY97 = SurfaceRules.yBlockCheck(VerticalAnchor.absolute(97), 2);
        SurfaceRules.ConditionSource isY256 = SurfaceRules.yBlockCheck(VerticalAnchor.absolute(256), 0);
        SurfaceRules.ConditionSource isYStart63 = SurfaceRules.yStartCheck(VerticalAnchor.absolute(63), -1);
        SurfaceRules.ConditionSource isYStart74 = SurfaceRules.yStartCheck(VerticalAnchor.absolute(74), 1);
        SurfaceRules.ConditionSource isY62 = SurfaceRules.yBlockCheck(VerticalAnchor.absolute(62), 0);
        SurfaceRules.ConditionSource isY63 = SurfaceRules.yBlockCheck(VerticalAnchor.absolute(63), 0);
        SurfaceRules.ConditionSource water1Deep = SurfaceRules.waterBlockCheck(-1, 0);
        SurfaceRules.ConditionSource noWaterAboveIsSurface = SurfaceRules.waterBlockCheck(0, 0);
        SurfaceRules.ConditionSource waterSixDeepWithVariety = SurfaceRules.waterStartCheck(-6, -1);
        SurfaceRules.ConditionSource hole = SurfaceRules.hole();
        SurfaceRules.ConditionSource isFrozenOcean = SurfaceRules.isBiome(Biomes.FROZEN_OCEAN, Biomes.DEEP_FROZEN_OCEAN);
        SurfaceRules.ConditionSource isSteep = SurfaceRules.steep();
        SurfaceRules.RuleSource surfacerules$rulesource = SurfaceRules.sequence(SurfaceRules.ifTrue(noWaterAboveIsSurface, GRASS_BLOCK), DIRT);
        SurfaceRules.RuleSource surfacerules$rulesource1 = SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.ON_CEILING, SANDSTONE), SAND);
        SurfaceRules.RuleSource surfacerules$rulesource2 = SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.ON_CEILING, STONE), GRAVEL);
        SurfaceRules.ConditionSource isWarmOceanBeachOrSnowyBeach = SurfaceRules.isBiome(Biomes.WARM_OCEAN, Biomes.BEACH, Biomes.SNOWY_BEACH);
        SurfaceRules.ConditionSource isDesert = SurfaceRules.isBiome(Biomes.DESERT);

        SurfaceRules.ConditionSource isStonyPeaks = SurfaceRules.isBiome(Biomes.STONY_PEAKS);
        SurfaceRules.ConditionSource isStonyShore = SurfaceRules.isBiome(Biomes.STONY_SHORE);
        SurfaceRules.ConditionSource isWindsweptHills = SurfaceRules.isBiome(Biomes.WINDSWEPT_HILLS);
        SurfaceRules.ConditionSource isDripstoneCave = SurfaceRules.isBiome(Biomes.DRIPSTONE_CAVES);
        SurfaceRules.ConditionSource isSnowySlopes = SurfaceRules.isBiome(Biomes.SNOWY_SLOPES);
        SurfaceRules.ConditionSource isJaggedPeaks = SurfaceRules.isBiome(Biomes.JAGGED_PEAKS);
        SurfaceRules.ConditionSource isGrove = SurfaceRules.isBiome(Biomes.GROVE);
        SurfaceRules.ConditionSource isWindsweptSavanna = SurfaceRules.isBiome(Biomes.WINDSWEPT_SAVANNA);
        SurfaceRules.ConditionSource isWindsweptGravelHill = SurfaceRules.isBiome(Biomes.WINDSWEPT_GRAVELLY_HILLS);


        SurfaceRules.RuleSource surfacerules$rulesource3 = SurfaceRules.sequence(SurfaceRules.ifTrue(isStonyPeaks,
                        SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.CALCITE, -0.0125D, 0.0125D), CALCITE), STONE)),
                SurfaceRules.ifTrue(isStonyShore,
                        SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.GRAVEL, -0.05D, 0.05D), surfacerules$rulesource2), STONE)),
                SurfaceRules.ifTrue(isWindsweptHills, SurfaceRules.ifTrue(surfaceNoiseAbove(1.0D), STONE)),
                SurfaceRules.ifTrue(isWarmOceanBeachOrSnowyBeach, surfacerules$rulesource1), SurfaceRules.ifTrue(isDesert, surfacerules$rulesource1),
                SurfaceRules.ifTrue(isDripstoneCave, STONE));

        SurfaceRules.RuleSource powderedSnowOnSurface = SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.POWDER_SNOW, 0.45D, 0.58D),
                SurfaceRules.ifTrue(noWaterAboveIsSurface, POWDER_SNOW));

        SurfaceRules.RuleSource powderedSnowOnSurfaceAlt = SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.POWDER_SNOW, 0.35D, 0.6D),
                SurfaceRules.ifTrue(noWaterAboveIsSurface, POWDER_SNOW));

        SurfaceRules.RuleSource surfacerules$rulesource6 = SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.isBiome(Biomes.FROZEN_PEAKS),
                        SurfaceRules.sequence(SurfaceRules.ifTrue(isSteep, PACKED_ICE),
                                SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.PACKED_ICE, -0.5D, 0.2D), PACKED_ICE),
                                SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.ICE, -0.0625D, 0.025D), ICE),
                                SurfaceRules.ifTrue(noWaterAboveIsSurface, SNOW_BLOCK))),
                SurfaceRules.ifTrue(isSnowySlopes,
                        SurfaceRules.sequence(SurfaceRules.ifTrue(isSteep, STONE), powderedSnowOnSurface,
                                SurfaceRules.ifTrue(noWaterAboveIsSurface, SNOW_BLOCK))),
                SurfaceRules.ifTrue(isJaggedPeaks, STONE),
                SurfaceRules.ifTrue(isGrove,
                        SurfaceRules.sequence(powderedSnowOnSurface, DIRT)), surfacerules$rulesource3,
                SurfaceRules.ifTrue(isWindsweptSavanna,
                        SurfaceRules.ifTrue(surfaceNoiseAbove(1.75D), STONE)),
                SurfaceRules.ifTrue(isWindsweptGravelHill,
                        SurfaceRules.sequence(SurfaceRules.ifTrue(surfaceNoiseAbove(2.0D), surfacerules$rulesource2),
                                SurfaceRules.ifTrue(surfaceNoiseAbove(1.0D), STONE),
                                SurfaceRules.ifTrue(surfaceNoiseAbove(-1.0D), DIRT), surfacerules$rulesource2)), DIRT);

        SurfaceRules.RuleSource surfacerules$rulesource7 = SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.isBiome(Biomes.FROZEN_PEAKS),
                        SurfaceRules.sequence(SurfaceRules.ifTrue(isSteep, PACKED_ICE), SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.PACKED_ICE, 0.0D, 0.2D), PACKED_ICE),
                                SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.ICE, 0.0D, 0.025D), ICE), SurfaceRules.ifTrue(noWaterAboveIsSurface, SNOW_BLOCK))),
                SurfaceRules.ifTrue(isSnowySlopes, SurfaceRules.sequence(SurfaceRules.ifTrue(isSteep, STONE), powderedSnowOnSurfaceAlt,
                        SurfaceRules.ifTrue(noWaterAboveIsSurface, SNOW_BLOCK))),
                SurfaceRules.ifTrue(isJaggedPeaks,
                        SurfaceRules.sequence(SurfaceRules.ifTrue(isSteep, STONE),
                                SurfaceRules.ifTrue(noWaterAboveIsSurface, SNOW_BLOCK))),
                SurfaceRules.ifTrue(SurfaceRules.isBiome(Biomes.GROVE), SurfaceRules.sequence(powderedSnowOnSurfaceAlt,
                        SurfaceRules.ifTrue(noWaterAboveIsSurface, SNOW_BLOCK))), surfacerules$rulesource3,
                SurfaceRules.ifTrue(isWindsweptSavanna,
                        SurfaceRules.sequence(SurfaceRules.ifTrue(surfaceNoiseAbove(1.75D), STONE),
                                SurfaceRules.ifTrue(surfaceNoiseAbove(-0.5D), COARSE_DIRT))),
                SurfaceRules.ifTrue(isWindsweptGravelHill,
                        SurfaceRules.sequence(SurfaceRules.ifTrue(surfaceNoiseAbove(2.0D), surfacerules$rulesource2),
                                SurfaceRules.ifTrue(surfaceNoiseAbove(1.0D), STONE),
                                SurfaceRules.ifTrue(surfaceNoiseAbove(-1.0D), surfacerules$rulesource), surfacerules$rulesource2)),
                SurfaceRules.ifTrue(SurfaceRules.isBiome(Biomes.OLD_GROWTH_PINE_TAIGA, Biomes.OLD_GROWTH_SPRUCE_TAIGA),
                        SurfaceRules.sequence(SurfaceRules.ifTrue(surfaceNoiseAbove(1.75D), COARSE_DIRT),
                                SurfaceRules.ifTrue(surfaceNoiseAbove(-0.95D), PODZOL))),
                SurfaceRules.ifTrue(SurfaceRules.isBiome(Biomes.ICE_SPIKES),
                        SurfaceRules.ifTrue(noWaterAboveIsSurface, SNOW_BLOCK)),
                SurfaceRules.ifTrue(SurfaceRules.isBiome(Biomes.MUSHROOM_FIELDS), MYCELIUM), surfacerules$rulesource);

        SurfaceRules.ConditionSource surfacerules$conditionsource14 = SurfaceRules.noiseCondition(Noises.SURFACE, -0.909D, -0.5454D);

        SurfaceRules.ConditionSource surfacerules$conditionsource15 = SurfaceRules.noiseCondition(Noises.SURFACE, -0.1818D, 0.1818D);

        SurfaceRules.ConditionSource surfacerules$conditionsource16 = SurfaceRules.noiseCondition(Noises.SURFACE, 0.5454D, 0.909D);

        SurfaceRules.RuleSource surfacerules$rulesource8 = SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR,
                        SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.isBiome(Biomes.WOODED_BADLANDS),
                                        SurfaceRules.ifTrue(isY97,
                                                SurfaceRules.sequence(SurfaceRules.ifTrue(surfacerules$conditionsource14, COARSE_DIRT),
                                                        SurfaceRules.ifTrue(surfacerules$conditionsource15, COARSE_DIRT),
                                                        SurfaceRules.ifTrue(surfacerules$conditionsource16, COARSE_DIRT), surfacerules$rulesource))),
                                SurfaceRules.ifTrue(SurfaceRules.isBiome(Biomes.SWAMP), SurfaceRules.ifTrue(isY62,
                                        SurfaceRules.ifTrue(SurfaceRules.not(isY63),
                                                SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.SWAMP, 0.0D), WATER)))))),
                SurfaceRules.ifTrue(SurfaceRules.isBiome(Biomes.BADLANDS, Biomes.ERODED_BADLANDS, Biomes.WOODED_BADLANDS),
                        SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR,
                                        SurfaceRules.sequence(SurfaceRules.ifTrue(isY256, ORANGE_TERRACOTTA),
                                                SurfaceRules.ifTrue(isYStart74,
                                                        SurfaceRules.sequence(SurfaceRules.ifTrue(surfacerules$conditionsource14, TERRACOTTA),
                                                                SurfaceRules.ifTrue(surfacerules$conditionsource15, TERRACOTTA),
                                                                SurfaceRules.ifTrue(surfacerules$conditionsource16, TERRACOTTA),
                                                                SurfaceRules.bandlands())), SurfaceRules.ifTrue(water1Deep,
                                                        SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.ON_CEILING, RED_SANDSTONE), RED_SAND)),
                                                SurfaceRules.ifTrue(SurfaceRules.not(hole), ORANGE_TERRACOTTA),
                                                SurfaceRules.ifTrue(waterSixDeepWithVariety, WHITE_TERRACOTTA), surfacerules$rulesource2)),
                                SurfaceRules.ifTrue(isYStart63, SurfaceRules.sequence(SurfaceRules.ifTrue(isY63,
                                        SurfaceRules.ifTrue(SurfaceRules.not(isYStart74), ORANGE_TERRACOTTA)), SurfaceRules.bandlands())),
                                SurfaceRules.ifTrue(SurfaceRules.UNDER_FLOOR, SurfaceRules.ifTrue(waterSixDeepWithVariety, WHITE_TERRACOTTA)))),
                SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, SurfaceRules.ifTrue(water1Deep,
                        SurfaceRules.sequence(SurfaceRules.ifTrue(isFrozenOcean, SurfaceRules.ifTrue(hole,
                                SurfaceRules.sequence(SurfaceRules.ifTrue(noWaterAboveIsSurface, AIR),
                                        SurfaceRules.ifTrue(SurfaceRules.temperature(), ICE), WATER))), surfacerules$rulesource7))),
                SurfaceRules.ifTrue(waterSixDeepWithVariety, SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR,
                                SurfaceRules.ifTrue(isFrozenOcean, SurfaceRules.ifTrue(hole, WATER))),
                        SurfaceRules.ifTrue(SurfaceRules.UNDER_FLOOR, surfacerules$rulesource6),
                        SurfaceRules.ifTrue(isWarmOceanBeachOrSnowyBeach,
                                SurfaceRules.ifTrue(SurfaceRules.DEEP_UNDER_FLOOR, SANDSTONE)),
                        SurfaceRules.ifTrue(isDesert,
                                SurfaceRules.ifTrue(SurfaceRules.VERY_DEEP_UNDER_FLOOR, SANDSTONE)))),
                SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR,
                        SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.isBiome(Biomes.FROZEN_PEAKS, Biomes.JAGGED_PEAKS), STONE),
                                SurfaceRules.ifTrue(SurfaceRules.isBiome(Biomes.WARM_OCEAN, Biomes.LUKEWARM_OCEAN, Biomes.DEEP_LUKEWARM_OCEAN), surfacerules$rulesource1), surfacerules$rulesource2)));


        builder.add(SurfaceRules.ifTrue(SurfaceRules.verticalGradient("bedrock_floor", VerticalAnchor.bottom(), VerticalAnchor.aboveBottom(5)), BEDROCK));

        SurfaceRules.RuleSource surfacerules$rulesource9 = SurfaceRules.ifTrue(SurfaceRules.abovePreliminarySurface(), surfacerules$rulesource8);
        builder.add(surfacerules$rulesource9);
        builder.add(SurfaceRules.ifTrue(SurfaceRules.verticalGradient("deepslate", VerticalAnchor.absolute(0), VerticalAnchor.absolute(8)), DEEPSLATE));
        return SurfaceRules.sequence(builder.build().toArray(SurfaceRules.RuleSource[]::new));
    }

    private static SurfaceRules.ConditionSource surfaceNoiseAbove(double p_194809_) {
        return SurfaceRules.noiseCondition(Noises.SURFACE, p_194809_ / 8.25D, Double.MAX_VALUE);
    }
}
