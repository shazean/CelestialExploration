package com.shim.celestialexploration.entity.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestialexploration.entity.mob.Gyst;
import net.minecraft.client.model.GhastModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class GystRenderer extends MobRenderer<Gyst, GhastModel<Gyst>> {
    private static final ResourceLocation GUST_LOCATION = new ResourceLocation(CelestialExploration.MODID, "textures/entity/ghastlike/gyst.png");
    private static final ResourceLocation GUST_SHOOTING_LOCATION = new ResourceLocation(CelestialExploration.MODID, "textures/entity/ghastlike/gyst_shooting.png");

    public GystRenderer(EntityRendererProvider.Context p_174129_) {
        super(p_174129_, new GhastModel<>(p_174129_.bakeLayer(ModelLayers.GHAST)), 1.5F);
    }

    public ResourceLocation getTextureLocation(Gyst p_114755_) {
        return p_114755_.isCharging() ? GUST_SHOOTING_LOCATION : GUST_LOCATION;
    }

    protected void scale(Gyst p_114757_, PoseStack p_114758_, float p_114759_) {
        float f = 1.0F;
        float f1 = 4.5F;
        float f2 = 4.5F;
        p_114758_.scale(4.5F, 4.5F, 4.5F);
    }
}