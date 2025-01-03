package com.shim.celestialexploration.entity.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.shim.celestialexploration.entity.entity.friendlies.Cobblesaurus;
import com.shim.celestialexploration.entity.entity.robots.Drone;
import com.shim.celestialexploration.entity.layers.GlowLayer;
import com.shim.celestialexploration.entity.model.CobblesaurusModel;
import com.shim.celestialexploration.entity.model.DroneModel;
import mod.azure.azurelib.cache.object.BakedGeoModel;
import mod.azure.azurelib.renderer.GeoEntityRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class CobblesaurusRenderer extends GeoEntityRenderer<Cobblesaurus> {

    public CobblesaurusRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new CobblesaurusModel());
    }

    @Override
    public void actuallyRender(PoseStack poseStack, Cobblesaurus animatable, BakedGeoModel model, RenderType renderType, MultiBufferSource bufferSource, VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        if (!isReRender) {
            float scale = 1.5F;
            poseStack.scale(scale, scale, scale);
        }

        super.actuallyRender(poseStack, animatable, model, renderType, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, red, green, blue, alpha);
    }
}