package com.shim.celestialexploration.entity.renderer;

import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestialexploration.entity.mob.VoidedZoglin;
import com.shim.celestialexploration.registry.CelestialModelLayers;
import net.minecraft.client.model.HoglinModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class VoidedZoglinRenderer extends MobRenderer<VoidedZoglin, HoglinModel<VoidedZoglin>> {
    private static final ResourceLocation ZOGLIN_LOCATION = new ResourceLocation(CelestialExploration.MODID, "textures/entity/hoglin/voided_zoglin.png");

    public VoidedZoglinRenderer(EntityRendererProvider.Context p_174454_) {
        super(p_174454_, new HoglinModel<>(p_174454_.bakeLayer(CelestialModelLayers.VOIDED_ZOGLIN)), 0.7F);
    }

    public ResourceLocation getTextureLocation(VoidedZoglin p_116544_) {
        return ZOGLIN_LOCATION;
    }
}