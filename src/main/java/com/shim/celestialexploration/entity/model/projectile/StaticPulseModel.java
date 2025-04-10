package com.shim.celestialexploration.entity.model.projectile;

import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestialexploration.entity.entity.projectile.StaticPulseProjectile;
import mod.azure.azurelib.model.GeoModel;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class StaticPulseModel extends GeoModel<StaticPulseProjectile> {
    private static final ResourceLocation model = new ResourceLocation(CelestialExploration.MODID, "geo/static_pulse.geo.json");
    private static final ResourceLocation texture = new ResourceLocation(CelestialExploration.MODID, "textures/entity/static_pulse.png");
    private static final ResourceLocation animation = new ResourceLocation(CelestialExploration.MODID, "animations/static_pulse.animation.json");

    @Override
    public ResourceLocation getModelResource(StaticPulseProjectile projectile) {
        return model;
    }

    @Override
    public ResourceLocation getTextureResource(StaticPulseProjectile projectile) {
        return texture;
    }

    @Override
    public ResourceLocation getAnimationResource(StaticPulseProjectile projectile) {
        return animation;
    }
}