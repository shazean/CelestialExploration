package com.shim.celestialexploration.entity.model;

import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestialexploration.entity.entity.robots.Drone;
import mod.azure.azurelib.model.GeoModel;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class DroneModel extends GeoModel<Drone> {
    private static final ResourceLocation model = new ResourceLocation(CelestialExploration.MODID, "geo/drone.geo.json");
    private static final ResourceLocation texture = new ResourceLocation(CelestialExploration.MODID, "textures/entity/drone.png");
    private static final ResourceLocation animation = new ResourceLocation(CelestialExploration.MODID, "animations/drone.animation.json");

    @Override
    public ResourceLocation getModelResource(Drone gust) {
        return model;
    }

    @Override
    public ResourceLocation getTextureResource(Drone gust) {
        return texture;
    }

    @Override
    public ResourceLocation getAnimationResource(Drone gust) {
        return animation;
    }
}