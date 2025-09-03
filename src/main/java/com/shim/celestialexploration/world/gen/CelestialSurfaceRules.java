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
}
