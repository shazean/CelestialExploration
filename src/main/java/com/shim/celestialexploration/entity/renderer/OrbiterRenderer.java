package com.shim.celestialexploration.entity.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.shim.celestialexploration.entity.entity.mob.Orbiter;
import com.shim.celestialexploration.entity.entity.robots.Drone;
import com.shim.celestialexploration.entity.layers.GlowLayer;
import com.shim.celestialexploration.entity.model.DroneModel;
import com.shim.celestialexploration.entity.model.OrbiterModel;
import mod.azure.azurelib.cache.object.BakedGeoModel;
import mod.azure.azurelib.renderer.GeoEntityRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class OrbiterRenderer extends GeoEntityRenderer<Orbiter> {

    public OrbiterRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new OrbiterModel());
        this.addRenderLayer(new GlowLayer<>(this));
    }

    @Override
    public void actuallyRender(PoseStack poseStack, Orbiter animatable, BakedGeoModel model, RenderType renderType, MultiBufferSource bufferSource, VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        if (!isReRender) {
            float scale = 2.0F;
            poseStack.scale(scale, scale, scale);
        }

        super.actuallyRender(poseStack, animatable, model, renderType, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, red, green, blue, alpha);
    }
}