package com.shim.celestialexploration.entity.model;

import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestialexploration.entity.entity.friendlies.Cobblesaurus;
import com.shim.celestialexploration.entity.entity.robots.Drone;
import mod.azure.azurelib.model.GeoModel;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class CobblesaurusModel extends GeoModel<Cobblesaurus> {
    private static final ResourceLocation model = new ResourceLocation(CelestialExploration.MODID, "geo/cobblesaurus.geo.json");
    private static final ResourceLocation texture = new ResourceLocation(CelestialExploration.MODID, "textures/entity/cobblesaurus.png");
    private static final ResourceLocation animation = new ResourceLocation(CelestialExploration.MODID, "animations/cobblesaurus.animation.json");

    @Override
    public ResourceLocation getModelResource(Cobblesaurus cobblesaurus) {
        return model;
    }

    @Override
    public ResourceLocation getTextureResource(Cobblesaurus cobblesaurus) {
        return texture;
    }

    @Override
    public ResourceLocation getAnimationResource(Cobblesaurus cobblesaurus) {
        return animation;
    }
}