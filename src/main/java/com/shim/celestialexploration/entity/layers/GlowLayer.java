package com.shim.celestialexploration.entity.layers;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestialexploration.entity.entity.robots.MechaDog;
import mod.azure.azurelib.animatable.GeoEntity;
import mod.azure.azurelib.cache.object.BakedGeoModel;
import mod.azure.azurelib.renderer.GeoRenderer;
import mod.azure.azurelib.renderer.layer.GeoRenderLayer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.apache.commons.lang3.StringUtils;

@OnlyIn(Dist.CLIENT)
public class GlowLayer<T extends GeoEntity> extends GeoRenderLayer<T> {
//    private static final RenderType GLOW = RenderType.eyes(new ResourceLocation("textures/entity/spider_eyes.png"));

    public GlowLayer(GeoRenderer<T> entityRendererIn) {
        super(entityRendererIn);
    }

    public void render(PoseStack poseStack, T animatable, BakedGeoModel bakedModel, RenderType renderType, MultiBufferSource bufferSource, VertexConsumer buffer, float partialTick, int packedLight, int packedOverlay) {
        RenderType emissiveRenderType = this.renderType(animatable);
        this.getRenderer().reRender(bakedModel, poseStack, bufferSource, animatable, emissiveRenderType, bufferSource.getBuffer(emissiveRenderType), partialTick, 15728640, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
    }

    public RenderType renderType(T animatable) {
//        CelestialExploration.LOGGER.debug("renderType: " + (new ResourceLocation(CelestialExploration.MODID, StringUtils.removeEnd(this.getTextureResource(animatable).getPath(), ".png") + "_glow.png")));
        return RenderType.eyes(new ResourceLocation(CelestialExploration.MODID, StringUtils.removeEnd(this.getTextureResource(animatable).getPath(), ".png") + "_glow.png"));
    }
}