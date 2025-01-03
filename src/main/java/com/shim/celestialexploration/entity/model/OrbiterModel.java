package com.shim.celestialexploration.entity.model;

import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestialexploration.entity.entity.mob.Orbiter;
import com.shim.celestialexploration.entity.entity.robots.Drone;
import mod.azure.azurelib.model.GeoModel;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class OrbiterModel extends GeoModel<Orbiter> {
    private static final ResourceLocation model = new ResourceLocation(CelestialExploration.MODID, "geo/orbiter.geo.json");
    private static final ResourceLocation texture = new ResourceLocation(CelestialExploration.MODID, "textures/entity/orbiter.png");
    private static final ResourceLocation animation = new ResourceLocation(CelestialExploration.MODID, "animations/orbiter.animation.json");

    @Override
    public ResourceLocation getModelResource(Orbiter orbiter) {
        return model;
    }

    @Override
    public ResourceLocation getTextureResource(Orbiter orbiter) {
        return texture;
    }

    @Override
    public ResourceLocation getAnimationResource(Orbiter orbiter) {
        return animation;
    }
}