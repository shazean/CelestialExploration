package com.shim.celestialexploration.world.gen;

import com.google.common.collect.ImmutableList;
import com.shim.celestialexploration.registry.BlockRegistry;
import com.shim.celestialexploration.world.biome.CelestialBiomeKeys;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.Noises;
import net.minecraft.world.level.levelgen.SurfaceRules;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.placement.CaveSurface;

public class CelestialSurfaceRules {
    private static final SurfaceRules.RuleSource AIR = makeStateRule(Blocks.AIR);
    private static final SurfaceRules.RuleSource BEDROCK = makeStateRule(Blocks.BEDROCK);
    private static final SurfaceRules.RuleSource DRY_ICE = makeStateRule(BlockRegistry.DRY_ICE.get());
    private static final SurfaceRules.RuleSource MARS_DEEPSLATE = makeStateRule(BlockRegistry.MARS_DEEPSLATE.get());
    private static final SurfaceRules.RuleSource MARS_SAND = makeStateRule(BlockRegistry.MARS_SAND.get());
    private static final SurfaceRules.RuleSource COARSE_MARS_SAND = makeStateRule(BlockRegistry.COARSE_MARS_SAND.get());
    private static final SurfaceRules.RuleSource MOON_DEEPSLATE = makeStateRule(BlockRegistry.MOON_DEEPSLATE.get());
    private static final SurfaceRules.RuleSource MOON_SAND = makeStateRule(BlockRegistry.MOON_SAND.get());
    private static final SurfaceRules.RuleSource COARSE_MOON_SAND = makeStateRule(BlockRegistry.COARSE_MOON_SAND.get());
    private static final SurfaceRules.RuleSource GLOWING_MOON_SAND = makeStateRule(BlockRegistry.GLOWING_MOON_SAND.get());
    private static final SurfaceRules.RuleSource VENUS_DEEPSLATE = makeStateRule(BlockRegistry.VENUS_DEEPSLATE.get());
    private static final SurfaceRules.RuleSource VENUS_SAND = makeStateRule(BlockRegistry.VENUS_SAND.get());
    private static final SurfaceRules.RuleSource FINE_VENUS_SAND = makeStateRule(BlockRegistry.FINE_VENUS_SAND.get());
    private static final SurfaceRules.RuleSource GEYSER = makeStateRule(BlockRegistry.GEYSER.get());
    private static final SurfaceRules.RuleSource MERCURY_DEEPSLATE = makeStateRule(BlockRegistry.MERCURY_DEEPSLATE.get());
    private static final SurfaceRules.RuleSource MERCURY_SAND = makeStateRule(BlockRegistry.MERCURY_SAND.get());
    private static final SurfaceRules.RuleSource COARSE_MERCURY_SAND = makeStateRule(BlockRegistry.COARSE_MERCURY_SAND.get());
    private static final SurfaceRules.RuleSource JUPITER_DEEPSLATE = makeStateRule(BlockRegistry.JUPITER_DEEPSLATE.get());


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

//        builder.add(SurfaceRules.ifTrue(SurfaceRules.yBlockCheck(VerticalAnchor.top(), 5), AIR));

        builder.add(SurfaceRules.ifTrue(SurfaceRules.verticalGradient("bedrock_floor", VerticalAnchor.bottom(), VerticalAnchor.aboveBottom(5)), BEDROCK));

//        builder.add(SurfaceRules.ifTrue(SurfaceRules.verticalGradient("deepslate", VerticalAnchor.absolute(0), VerticalAnchor.absolute(8)), JUPITER_DEEPSLATE));
        return SurfaceRules.sequence(builder.build().toArray(SurfaceRules.RuleSource[]::new));
    }

    private static SurfaceRules.ConditionSource surfaceNoiseAbove(double p_194809_) {
        return SurfaceRules.noiseCondition(Noises.SURFACE, p_194809_ / 8.25D, Double.MAX_VALUE);
    }
}
