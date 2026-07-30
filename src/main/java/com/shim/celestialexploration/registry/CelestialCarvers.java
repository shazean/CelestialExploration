package com.shim.celestialexploration.registry;

import com.shim.celestialexploration.CelestialExploration;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.util.valueproviders.ConstantFloat;
import net.minecraft.util.valueproviders.FloatProvider;
import net.minecraft.util.valueproviders.TrapezoidFloat;
import net.minecraft.util.valueproviders.UniformFloat;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.carver.*;
import net.minecraft.world.level.levelgen.heightproviders.HeightProvider;
import net.minecraft.world.level.levelgen.heightproviders.UniformHeight;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class CelestialCarvers {

    public static final DeferredRegister<WorldCarver<?>> CARVERS = DeferredRegister.create(ForgeRegistries.WORLD_CARVERS, CelestialExploration.MODID);
    private static final DeferredRegister<ConfiguredWorldCarver<?>> CONFIGURED_CARVERS = DeferredRegister.create(Registry.CONFIGURED_CARVER_REGISTRY, CelestialExploration.MODID);

//    public static final RegistryObject<WorldCarver<CanyonCarverConfiguration>> CRATER = CARVERS.register("crater",
//            () -> new CanyonWorldCarver(CanyonCarverConfiguration.CODEC));
//
//    public static final Holder<ConfiguredWorldCarver<CanyonCarverConfiguration>> CONFIGURED_CRATER = WorldCarver.CANYON.configured(new CanyonCarverConfiguration(
//                    0.1F, //probability 0.01
//                    UniformHeight.of(VerticalAnchor.absolute(10), VerticalAnchor.absolute(67)), //y
//                    ConstantFloat.of(3.0F), //yScale
//                    VerticalAnchor.aboveBottom(8), //lavaLevel
//                    CarverDebugSettings.of(true, CelestialBlocks.BLUE_BUTTON.get().defaultBlockState()), //debugSettings
//                    UniformFloat.of(-0.125F, 0.125F), //verticalRotation
//                    new CanyonCarverConfiguration.CanyonShapeConfiguration( //shape
//                            UniformFloat.of(0.75F, 1.0F), //distance factor //0.75, 1.0
//                            TrapezoidFloat.of(2.0F, 2.0F, 2.0F), //thickness 0.0, 6.0, 2.0
//                            3, //width smoothness
//                            UniformFloat.of(0.75F, 1.0F), //horizontalRadiusFactor 0.75, 1.0
//                            1.0F, //verticalRadiusDefaultFactor 1.0
//                            0.0F))); //verticalRadiusCenterFactor 0.0


//    public static final RegistryObject<WorldCarver<?>> MOON_STONE = CARVERS.register("moon_stone", () -> WorldCarver.CANYON.configured(
//            new CanyonCarverConfiguration(
//                    0.1F, //probability 0.01
//                    UniformHeight.of(VerticalAnchor.absolute(10), VerticalAnchor.absolute(67)), //y
//                    ConstantFloat.of(3.0F), //yScale
//                    VerticalAnchor.aboveBottom(8), //lavaLevel
//                    CarverDebugSettings.of(true, CelestialBlocks.BLUE_BUTTON.get().defaultBlockState()), //debugSettings
//                    UniformFloat.of(-0.125F, 0.125F), //verticalRotation
//                    new CanyonCarverConfiguration.CanyonShapeConfiguration( //shape
//                            UniformFloat.of(0.75F, 1.0F), //distance factor //0.75, 1.0
//                            TrapezoidFloat.of(2.0F, 2.0F, 2.0F), //thickness 0.0, 6.0, 2.0
//                            3, //width smoothness
//                            UniformFloat.of(0.75F, 1.0F), //horizontalRadiusFactor 0.75, 1.0
//                            1.0F, //verticalRadiusDefaultFactor 1.0
//                            0.0F)))); //verticalRadiusCenterFactor 0.0
//
//
//
//    public static final Holder<ConfiguredWorldCarver<CanyonCarverConfiguration>> MAYBE_CRATER = register("celestialexploration:crater", WorldCarver.CANYON.configured(
//            new CanyonCarverConfiguration(
//                    0.1F, //probability 0.01
//                    UniformHeight.of(VerticalAnchor.absolute(10), VerticalAnchor.absolute(67)), //y
//                    ConstantFloat.of(3.0F), //yScale
//                    VerticalAnchor.aboveBottom(8), //lavaLevel
//                    CarverDebugSettings.of(true, CelestialBlocks.BLUE_BUTTON.get().defaultBlockState()), //debugSettings
//                    UniformFloat.of(-0.125F, 0.125F), //verticalRotation
//                    new CanyonCarverConfiguration.CanyonShapeConfiguration( //shape
//                            UniformFloat.of(0.75F, 1.0F), //distance factor //0.75, 1.0
//                            TrapezoidFloat.of(2.0F, 2.0F, 2.0F), //thickness 0.0, 6.0, 2.0
//                            3, //width smoothness
//                            UniformFloat.of(0.75F, 1.0F), //horizontalRadiusFactor 0.75, 1.0
//                            1.0F, //verticalRadiusDefaultFactor 1.0
//                            0.0F)))); //verticalRadiusCenterFactor 0.0
//
//
//
    private static <WC extends CarverConfiguration> Holder<ConfiguredWorldCarver<WC>> register(String p_206431_, ConfiguredWorldCarver<WC> p_206432_) {
        return BuiltinRegistries.registerExact(BuiltinRegistries.CONFIGURED_CARVER, p_206431_, p_206432_);
    }
}
