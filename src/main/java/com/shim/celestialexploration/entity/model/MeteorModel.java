package com.shim.celestialexploration.entity.model;

import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestialexploration.entity.Eureka;
import com.shim.celestialexploration.entity.projectile.MeteorProjectile;
import mod.azure.azurelib.model.GeoModel;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class MeteorModel extends GeoModel<MeteorProjectile> {
    // Models must be stored in assets/<modid>/geo with subfolders supported inside the geo folder
    private static final ResourceLocation model = new ResourceLocation(CelestialExploration.MODID, "geo/meteor.geo.json");
    // Textures must be stored in assets/<modid>/geo with subfolders supported inside the textures folder
    private static final ResourceLocation texture = new ResourceLocation(CelestialExploration.MODID, "textures/entity/meteor.png");
    // Animations must be stored in assets/<modid>/animations with subfolders supported inside the animations folder
    private static final ResourceLocation animation = new ResourceLocation(CelestialExploration.MODID, "animations/meteor.animation.json");

    @Override
    public ResourceLocation getModelResource(MeteorProjectile spaceship) {
        return model;
    }

    @Override
    public ResourceLocation getTextureResource(MeteorProjectile spaceship) {
        return texture;
    }

    @Override
    public ResourceLocation getAnimationResource(MeteorProjectile spaceship) {
        return animation;
    }
}