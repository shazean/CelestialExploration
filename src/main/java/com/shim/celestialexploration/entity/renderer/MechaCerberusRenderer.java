package com.shim.celestialexploration.entity.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.shim.celestialexploration.entity.entity.robots.AbstractCerberus;
import com.shim.celestialexploration.entity.layers.MechaCerberusGlowLayer;
import com.shim.celestialexploration.entity.model.MechaCerberusModel;
import mod.azure.azurelib.cache.object.BakedGeoModel;
import mod.azure.azurelib.renderer.GeoEntityRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

public class MechaCerberusRenderer extends GeoEntityRenderer<AbstractCerberus> {

    public MechaCerberusRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new MechaCerberusModel());
        addRenderLayer(new MechaCerberusGlowLayer(this));
    }

    @Override
    public void actuallyRender(PoseStack poseStack, AbstractCerberus animatable, BakedGeoModel model, RenderType renderType, MultiBufferSource bufferSource, VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        if (!isReRender) {
            if (animatable.isTame()) {
                float scale = 1.5F;
                poseStack.scale(scale, scale, scale);
            } else {
                float scale = 2.5F;
                poseStack.scale(scale, scale, scale);
            }
        }

        super.actuallyRender(poseStack, animatable, model, renderType, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, red, green, blue, alpha);
    }
}