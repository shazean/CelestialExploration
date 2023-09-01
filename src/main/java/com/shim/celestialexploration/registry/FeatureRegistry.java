package com.shim.celestialexploration.registry;

import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestialexploration.world.features.GlowingSandFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class FeatureRegistry {


    public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(ForgeRegistries.FEATURES, CelestialExploration.MODID);

    public static final RegistryObject<Feature<NoneFeatureConfiguration>> GLOWING_SAND = FEATURES.register("glowing_sand", () -> new GlowingSandFeature(NoneFeatureConfiguration.CODEC));

    public static void register(IEventBus eventbus) {
        FEATURES.register(eventbus);
    }


}
