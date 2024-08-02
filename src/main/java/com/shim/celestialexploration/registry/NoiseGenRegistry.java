package com.shim.celestialexploration.registry;

import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestialexploration.world.biome.CelestialBiomeSource;
import com.shim.celestialexploration.world.gen.CelestialSurfaceRules;
import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.TerrainProvider;
import net.minecraft.util.CubicSpline;
import net.minecraft.world.level.biome.TerrainShaper;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.*;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class NoiseGenRegistry extends NoiseRouterData {

    public static final DeferredRegister<NoiseGeneratorSettings> NOISES = DeferredRegister.create(Registry.NOISE_GENERATOR_SETTINGS_REGISTRY, CelestialExploration.MODID);

    public static final RegistryObject<NoiseGeneratorSettings> MARS_NOISE = NOISES.register("mars", () -> {
        NoiseSettings noisesettings = marsNoiseSettings(false);
        return new NoiseGeneratorSettings(noisesettings, BlockRegistry.MARS_STONE.get().defaultBlockState(), Blocks.AIR.defaultBlockState(), NoiseRouterData.overworld(noisesettings, false),
                CelestialSurfaceRules.mars(), 63, false, true, false, false);
    });

    public static final RegistryObject<NoiseGeneratorSettings> MOON_NOISE = NOISES.register("moon", () -> {
        NoiseSettings noisesettings = moonNoiseSettings(false);
        return new NoiseGeneratorSettings(noisesettings, BlockRegistry.MOON_STONE.get().defaultBlockState(), Blocks.AIR.defaultBlockState(), NoiseRouterData.overworldWithoutCaves(noisesettings),
                CelestialSurfaceRules.moon(), 63, false, true , false, false);
    });

    public static final RegistryObject<NoiseGeneratorSettings> VENUS_NOISE = NOISES.register("venus", () -> {
        NoiseSettings noisesettings = venusNoiseSettings(false);
        return new NoiseGeneratorSettings(noisesettings, BlockRegistry.VENUS_STONE.get().defaultBlockState(), FluidRegistry.SULFUR_BLOCK.get().defaultBlockState(), NoiseRouterData.overworld(noisesettings, false),
                CelestialSurfaceRules.venus(), 63, false, true, false, false);
    });

    public static final RegistryObject<NoiseGeneratorSettings> MERCURY_NOISE = NOISES.register("mercury", () -> {
        NoiseSettings noisesettings = mercuryNoiseSettings(false);
        return new NoiseGeneratorSettings(noisesettings, BlockRegistry.MERCURY_STONE.get().defaultBlockState(), Blocks.AIR.defaultBlockState(), NoiseRouterData.overworldWithoutCaves(noisesettings),
                CelestialSurfaceRules.mercury(), 63, false, true, false, false);
    });

    public static final RegistryObject<NoiseGeneratorSettings> SPACE_NOISE = NOISES.register("space", () -> {
        NoiseSettings noisesettings = spaceNoiseSettings(false);
        return new NoiseGeneratorSettings(noisesettings, BlockRegistry.METEOR.get().defaultBlockState(), Blocks.AIR.defaultBlockState(), NoiseRouterData.overworld(noisesettings, false),
                CelestialSurfaceRules.space(), -64, false, false, false, false);
    });

    static NoiseSettings moonNoiseSettings(boolean p_212308_) {
        return NoiseSettings.create(-64, 384, new NoiseSamplingSettings(1.0D, 1.0D, 80.0D, 160.0D),
                new NoiseSlider(-0.078125D, 2, p_212308_ ? 0 : 8), new NoiseSlider(p_212308_ ? 0.4D : 0.1171875D, 3, 0), 1, 2, TerrainProvider.overworld(p_212308_));
    }

    static NoiseSettings marsNoiseSettings(boolean p_212308_) {
        return NoiseSettings.create(-64, 384, new NoiseSamplingSettings(1.0D, 1.0D, 80.0D, 160.0D),
                new NoiseSlider(-0.078125D, 2, p_212308_ ? 0 : 8), new NoiseSlider(p_212308_ ? 0.4D : 0.1171875D, 3, 0), 1, 2, TerrainProvider.overworld(p_212308_));
    }

    static NoiseSettings venusNoiseSettings(boolean p_212308_) {
        return NoiseSettings.create(-64, 384, new NoiseSamplingSettings(1.0D, 1.0D, 80.0D, 160.0D),
                new NoiseSlider(-0.078125D, 2, p_212308_ ? 0 : 8), new NoiseSlider(p_212308_ ? 0.4D : 0.1171875D, 3, 0), 1, 2, TerrainProvider.overworld(p_212308_));
    }

    static NoiseSettings mercuryNoiseSettings(boolean p_212308_) {
        return NoiseSettings.create(-64, 384, new NoiseSamplingSettings(1.0D, 1.0D, 80.0D, 160.0D),
                new NoiseSlider(-0.078125D, 2, p_212308_ ? 0 : 8), new NoiseSlider(p_212308_ ? 0.4D : 0.1171875D, 3, 0), 1, 2, TerrainProvider.overworld(p_212308_));
    }

    static NoiseSettings spaceNoiseSettings(boolean p_212308_) {
        return NoiseSettings.create(-64, 384, new NoiseSamplingSettings(1.0D, 1.0D, 80.0D, 160.0D),
                new NoiseSlider(-0.078125D, 2, p_212308_ ? 0 : 8), new NoiseSlider(p_212308_ ? 0.4D : 0.1171875D, 3, 0), 1, 2, new TerrainShaper(CubicSpline.constant(0.0F), CubicSpline.constant(0.0F), CubicSpline.constant(0.0F)));
    }
}
