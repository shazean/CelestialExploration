package com.shim.celestialexploration.entity.model;

import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestialexploration.entity.entity.mob.Gust;
import com.shim.celestialexploration.entity.entity.robots.Rover;
import mod.azure.azurelib.model.GeoModel;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class RoverModel extends GeoModel<Rover> {
    // Models must be stored in assets/<modid>/geo with subfolders supported inside the geo folder
    private static final ResourceLocation model = new ResourceLocation(CelestialExploration.MODID, "geo/rover.geo.json");
    // Textures must be stored in assets/<modid>/geo with subfolders supported inside the textures folder
    private static final ResourceLocation texture = new ResourceLocation(CelestialExploration.MODID, "textures/entity/rover.png");
    // Animations must be stored in assets/<modid>/animations with subfolders supported inside the animations folder
    private static final ResourceLocation animation = new ResourceLocation(CelestialExploration.MODID, "animations/rover.animation.json");

    @Override
    public ResourceLocation getModelResource(Rover rover) {
        return model;
    }

    @Override
    public ResourceLocation getTextureResource(Rover rover) {
        return texture;
    }

    @Override
    public ResourceLocation getAnimationResource(Rover rover) {
        return animation;
    }
}