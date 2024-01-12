package com.shim.celestialexploration.entity.renderer;

import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestialexploration.entity.VoidedPiglin;
import com.shim.celestialexploration.registry.CelestialModelLayers;
import net.minecraft.client.model.PiglinModel;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.resources.ResourceLocation;

public class VoidedPiglinRenderer extends HumanoidMobRenderer<VoidedPiglin, PiglinModel<VoidedPiglin>> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(CelestialExploration.MODID, "textures/entity/voided_piglin.png");
    private static final float PIGLIN_CUSTOM_HEAD_SCALE = 1.0019531F;

    public VoidedPiglinRenderer(EntityRendererProvider.Context context) {
        super(context, new PiglinModel<>(context.bakeLayer(CelestialModelLayers.VOIDED_PIGLIN)), 0.5F, 1.0019531F, 1.0F, 1.0019531F);
        //        super(context, createModel(context.getModelSet(), p_174345_, p_174348_), 0.5F, 1.0019531F, 1.0F, 1.0019531F);
//        this.addLayer(new HumanoidArmorLayer<>(this, new HumanoidModel(context.bakeLayer(CelestialModelLayers.VOIDED_PIGLIN_INNER_ARMOR)), new HumanoidModel(context.bakeLayer(CelestialModelLayers.VOIDED_PIGLIN_OUTER_ARMOR))));
    }

    private static PiglinModel<VoidedPiglin> createModel(EntityModelSet p_174350_, ModelLayerLocation p_174351_, boolean p_174352_) {
        PiglinModel<VoidedPiglin> piglinmodel = new PiglinModel<>(p_174350_.bakeLayer(p_174351_));
        if (p_174352_) {
            piglinmodel.rightEar.visible = false;
        }

        return piglinmodel;
    }

    public ResourceLocation getTextureLocation(VoidedPiglin p_115708_) {
        return TEXTURE;
    }
}