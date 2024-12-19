package com.shim.celestialexploration.entity.model;

import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestialexploration.entity.entity.ambient.Eureka;
import mod.azure.azurelib.model.GeoModel;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class EurekaModel extends GeoModel<Eureka> {
    // Models must be stored in assets/<modid>/geo with subfolders supported inside the geo folder
    private static final ResourceLocation model = new ResourceLocation(CelestialExploration.MODID, "geo/eureka.geo.json");
    // Textures must be stored in assets/<modid>/geo with subfolders supported inside the textures folder
    private static final ResourceLocation texture = new ResourceLocation(CelestialExploration.MODID, "textures/entity/eureka.png");
    // Animations must be stored in assets/<modid>/animations with subfolders supported inside the animations folder
    private static final ResourceLocation animation = new ResourceLocation(CelestialExploration.MODID, "animations/eureka.animation.json");

    @Override
    public ResourceLocation getModelResource(Eureka spaceship) {
        return model;
    }

    @Override
    public ResourceLocation getTextureResource(Eureka spaceship) {
        return texture;
    }

    @Override
    public ResourceLocation getAnimationResource(Eureka spaceship) {
        return animation;
    }
}