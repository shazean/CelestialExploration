package com.shim.celestialexploration.entity.renderer;

import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestialexploration.entity.mob.AstralHoglin;
import com.shim.celestialexploration.registry.CelestialModelLayers;
import net.minecraft.client.model.HoglinModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class AstralHoglinRenderer extends MobRenderer<AstralHoglin, HoglinModel<AstralHoglin>> {
    private static final ResourceLocation HOGLIN_LOCATION = new ResourceLocation(CelestialExploration.MODID, "textures/entity/hoglin/astral_hoglin.png");

    public AstralHoglinRenderer(EntityRendererProvider.Context p_174165_) {
        super(p_174165_, new HoglinModel<>(p_174165_.bakeLayer(CelestialModelLayers.ASTRAL_HOGLIN)), 0.7F);
    }

    public ResourceLocation getTextureLocation(AstralHoglin p_114862_) {
        return HOGLIN_LOCATION;
    }

    protected boolean isShaking(AstralHoglin p_114864_) {
        return super.isShaking(p_114864_) || p_114864_.isConverting();
    }
}