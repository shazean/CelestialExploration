package com.shim.celestialexploration.registry;

import com.shim.celestialexploration.CelestialExploration;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class DimensionRegistry {

    public static final ResourceKey<Level> MARS = ResourceKey.create(Registry.DIMENSION_REGISTRY, new ResourceLocation(CelestialExploration.MODID, "mars"));
    public static final ResourceKey<Level> MOON = ResourceKey.create(Registry.DIMENSION_REGISTRY, new ResourceLocation(CelestialExploration.MODID, "moon"));
    public static final ResourceKey<Level> SPACE = ResourceKey.create(Registry.DIMENSION_REGISTRY, new ResourceLocation(CelestialExploration.MODID, "space"));


    public static final ResourceLocation MARS_EFFECTS = new ResourceLocation(CelestialExploration.MODID, "mars");


}
