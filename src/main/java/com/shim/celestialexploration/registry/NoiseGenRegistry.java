package com.shim.celestialexploration.registry;

import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestialexploration.world.gen.CelestialSurfaceRules;
import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.TerrainProvider;
import net.minecraft.util.CubicSpline;
import net.minecraft.world.level.biome.TerrainShaper;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.predicate.BlockPredicate;
import net.minecraft.world.level.levelgen.*;
import net.minecraft.world.level.levelgen.structure.templatesystem.RandomBlockMatchTest;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class NoiseGenRegistry extends NoiseRouterData {

    public static final DeferredRegister<NoiseGeneratorSettings> NOISES = DeferredRegister.create(Registry.NOISE_GENERATOR_SETTINGS_REGISTRY, CelestialExploration.MODID);

    public static final RegistryObject<NoiseGeneratorSettings> MARS_NOISE = NOISES.register("mars", () -> {
        NoiseSettings noisesettings = marsNoiseSettings();

        return new NoiseGeneratorSettings(noisesettings, BlockRegistry.MARS_STONE.get().defaultBlockState(), Blocks.AIR.defaultBlockState(), NoiseRouterData.overworld(noisesettings, false),
                CelestialSurfaceRules.mars(), 0, false, true, false, false);
    });

    public static final RegistryObject<NoiseGeneratorSettings> MOON_NOISE = NOISES.register("moon", () -> {
        NoiseSettings noisesettings = moonNoiseSettings();
        return new NoiseGeneratorSettings(noisesettings, BlockRegistry.MOON_STONE.get().defaultBlockState(), Blocks.AIR.defaultBlockState(), NoiseRouterData.overworldWithoutCaves(noisesettings),
                CelestialSurfaceRules.moon(), 0, false, true , false, false);
    });

    public static final RegistryObject<NoiseGeneratorSettings> VENUS_NOISE = NOISES.register("venus", () -> {
        NoiseSettings noisesettings = venusNoiseSettings();
        return new NoiseGeneratorSettings(noisesettings, BlockRegistry.VENUS_STONE.get().defaultBlockState(), FluidRegistry.SULFUR_BLOCK.get().defaultBlockState(), NoiseRouterData.overworld(noisesettings, false),
                CelestialSurfaceRules.venus(), 63, false, true, false, false);
    });

    public static final RegistryObject<NoiseGeneratorSettings> MERCURY_NOISE = NOISES.register("mercury", () -> {
        NoiseSettings noisesettings = mercuryNoiseSettings();
        return new NoiseGeneratorSettings(noisesettings, BlockRegistry.MERCURY_STONE.get().defaultBlockState(), Blocks.AIR.defaultBlockState(), NoiseRouterData.overworldWithoutCaves(noisesettings),
                CelestialSurfaceRules.mercury(), 0, false, true, false, false);
    });

    public static final RegistryObject<NoiseGeneratorSettings> SPACE_NOISE = NOISES.register("space", () -> {
        NoiseSettings noisesettings = spaceNoiseSettings();
        return new NoiseGeneratorSettings(noisesettings, Blocks.AIR.defaultBlockState(), Blocks.AIR.defaultBlockState(), NoiseRouterData.overworld(noisesettings, false),
                CelestialSurfaceRules.space(), -64, false, false, false, false);
    });

    public static final RegistryObject<NoiseGeneratorSettings> JUPITER_NOISE = NOISES.register("jupiter", () -> {
        NoiseSettings noisesettings = jupiterNoiseSettings();
        return new NoiseGeneratorSettings(noisesettings, BlockRegistry.JUPITER_DEEPSLATE.get().defaultBlockState(), FluidRegistry.METALLIC_HYDROGEN_BLOCK.get().defaultBlockState(), NoiseRouterData.overworldWithoutCaves(noisesettings),
                CelestialSurfaceRules.jupiter(), 160, false, true, false, false);
    });

    public static final RegistryObject<NoiseGeneratorSettings> EUROPA_NOISE = NOISES.register("europa", () -> {
        NoiseSettings noisesettings = europaNoiseSettings();
        return new NoiseGeneratorSettings(noisesettings, BlockRegistry.MOON_STONE.get().defaultBlockState(), Blocks.WATER.defaultBlockState(), NoiseRouterData.overworldWithoutCaves(noisesettings),
                CelestialSurfaceRules.europa(), 58, false, true , false, false);
    });

    public static final RegistryObject<NoiseGeneratorSettings> CALLISTO_NOISE = NOISES.register("callisto", () -> {
        NoiseSettings noisesettings = callistoNoiseSettings();
        return new NoiseGeneratorSettings(noisesettings, BlockRegistry.MOON_DEEPSLATE.get().defaultBlockState(), Blocks.AIR.defaultBlockState(), NoiseRouterData.overworldWithoutCaves(noisesettings),
                CelestialSurfaceRules.callisto(), 0, false, true , false, false);
    });



    //---- FOR DATAPACK/PRESETS -------------------------------------------------------------------------------
    public static final RegistryObject<NoiseGeneratorSettings> DESERT_NOISE = NOISES.register("desert", () -> new NoiseGeneratorSettings(datapackPlanetNoiseSettings(), Blocks.SANDSTONE.defaultBlockState(), Blocks.SAND.defaultBlockState(),
            NoiseRouterData.overworld(datapackPlanetNoiseSettings(), false), CelestialSurfaceRules.datapackPresets(true), 32, false, true , true, false));


    public static final RegistryObject<NoiseGeneratorSettings> FOREST_NOISE = NOISES.register("forest", () -> new NoiseGeneratorSettings(datapackPlanetNoiseSettings(), Blocks.STONE.defaultBlockState(), Blocks.WATER.defaultBlockState(),
            NoiseRouterData.overworld(datapackPlanetNoiseSettings(), false), CelestialSurfaceRules.datapackPresets(false), 63, false, true , true, false));


    public static final RegistryObject<NoiseGeneratorSettings> OCEAN_NOISE = NOISES.register("ocean", () -> new NoiseGeneratorSettings(datapackPlanetNoiseSettings(), Blocks.STONE.defaultBlockState(), Blocks.WATER.defaultBlockState(),
            NoiseRouterData.overworld(datapackPlanetNoiseSettings(), false), CelestialSurfaceRules.datapackPresets(false), 128, false, true , true, false));


    public static final RegistryObject<NoiseGeneratorSettings> ICE_NOISE = NOISES.register("icy", () -> new NoiseGeneratorSettings(datapackPlanetNoiseSettings(), Blocks.STONE.defaultBlockState(), Blocks.WATER.defaultBlockState(),
            NoiseRouterData.overworld(datapackPlanetNoiseSettings(), false), CelestialSurfaceRules.datapackPresets(false), 63, false, true , true, false));


    static NoiseSettings moonNoiseSettings() {
        return NoiseSettings.create(-32, 256, new NoiseSamplingSettings(1.0D, 1.0D, 80.0D, 160.0D),
                new NoiseSlider(-0.078125D, 2, 8), new NoiseSlider(0.1171875D, 3, 0), 1, 2, TerrainProvider.overworld(false));
    }

    static NoiseSettings marsNoiseSettings() {
        return NoiseSettings.create(-64, 384, new NoiseSamplingSettings(1.0D, 1.0D, 80.0D, 160.0D),
                new NoiseSlider(-0.078125D, 2, 8), new NoiseSlider(0.1171875D, 3, 0), 1, 2, TerrainProvider.overworld(false));
    }

    static NoiseSettings venusNoiseSettings() {
        return NoiseSettings.create(-64, 384, new NoiseSamplingSettings(1.0D, 1.0D, 80.0D, 160.0D),
                new NoiseSlider(-0.078125D, 2, 8), new NoiseSlider(0.1171875D, 3, 0), 1, 2, TerrainProvider.overworld(false));
    }

    static NoiseSettings mercuryNoiseSettings() {
        return NoiseSettings.create(-32, 256, new NoiseSamplingSettings(1.0D, 1.0D, 80.0D, 160.0D),
                new NoiseSlider(-0.078125D, 2, 8), new NoiseSlider(0.1171875D, 3, 0), 1, 2, TerrainProvider.overworld(false));
    }

    static NoiseSettings spaceNoiseSettings() {
        return NoiseSettings.create(-32, 32, new NoiseSamplingSettings(1.0D, 1.0D, 1.0D, 1.0D), //1.0D, 1.0D, 80.0D, 160.0D
                new NoiseSlider(0.0D, 0, 0), //-0.078125D, 2, 8
                new NoiseSlider(0.0D, 0, 0), //0.1171875D, 3, 0
                1, 1, //1, 2
                new TerrainShaper(CubicSpline.constant(0.0F), CubicSpline.constant(0.0F), CubicSpline.constant(0.0F)));
    }

    static NoiseSettings jupiterNoiseSettings() {
        return NoiseSettings.create(-96, 384, new NoiseSamplingSettings(1.0D, 1.0D, 80.0D, 160.0D),
                new NoiseSlider(-0.078125D, 2, 8), new NoiseSlider(0.1171875D, 3, 0), 1, 2, TerrainProvider.overworld(false));
    }

    static NoiseSettings europaNoiseSettings() {
        return NoiseSettings.create(-96, 256, new NoiseSamplingSettings(1.0D, 1.0D, 80.0D, 160.0D),
                new NoiseSlider(-0.078125D, 2, 8), new NoiseSlider(0.1171875D, 3, 0), 1, 3, TerrainProvider.overworld(false));
    }

    static NoiseSettings datapackPlanetNoiseSettings() {
        return NoiseSettings.create(-64, 384, new NoiseSamplingSettings(1.0D, 1.0D, 80.0D, 160.0D),
                new NoiseSlider(-0.078125D, 2, 8), new NoiseSlider(0.1171875D, 3, 0), 1, 2, TerrainProvider.overworld(false));
    }

    static NoiseSettings callistoNoiseSettings() {
        return NoiseSettings.create(-32, 256, new NoiseSamplingSettings(1.0D, 1.0D, 80.0D, 160.0D),
                new NoiseSlider(-0.078125D, 2, 8), new NoiseSlider(0.1171875D, 3, 0), 1, 2, TerrainProvider.overworld(false));
    }
}