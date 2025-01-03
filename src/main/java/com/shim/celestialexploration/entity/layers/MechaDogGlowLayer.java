package com.shim.celestialexploration.entity.layers;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestialexploration.entity.entity.robots.MechaDog;
import mod.azure.azurelib.animatable.GeoEntity;
import mod.azure.azurelib.cache.object.BakedGeoModel;
import mod.azure.azurelib.renderer.GeoRenderer;
import mod.azure.azurelib.renderer.layer.GeoRenderLayer;
import net.minecraft.client.model.SpiderModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.EyesLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class MechaDogGlowLayer extends GlowLayer<MechaDog> {
//    private static final RenderType SPIDER_EYES = RenderType.eyes(new ResourceLocation("textures/entity/spider_eyes.png"));

//    public MechaDogGlowLayer(GeoRenderer<T> entityRendererIn) {
//        super(entityRendererIn);
//    }

    private static final ResourceLocation[] MECHADOG_TEXTURE_LOCATIONS = new ResourceLocation[]{
            new ResourceLocation(CelestialExploration.MODID, "textures/entity/mechadog/mechadog_black_glow.png"),  new ResourceLocation(CelestialExploration.MODID, "textures/entity/mechadog/mechadog_grey_glow.png"),
            new ResourceLocation(CelestialExploration.MODID, "textures/entity/mechadog/mechadog_light_grey_glow.png"), new ResourceLocation(CelestialExploration.MODID, "textures/entity/mechadog/mechadog_white_glow.png"),
            new ResourceLocation(CelestialExploration.MODID, "textures/entity/mechadog/mechadog_pink_glow.png"), new ResourceLocation(CelestialExploration.MODID, "textures/entity/mechadog/mechadog_magenta_glow.png"),
            new ResourceLocation(CelestialExploration.MODID, "textures/entity/mechadog/mechadog_red_glow.png"), new ResourceLocation(CelestialExploration.MODID, "textures/entity/mechadog/mechadog_brown_glow.png"),
            new ResourceLocation(CelestialExploration.MODID, "textures/entity/mechadog/mechadog_orange_glow.png"), new ResourceLocation(CelestialExploration.MODID, "textures/entity/mechadog/mechadog_yellow_glow.png"),
            new ResourceLocation(CelestialExploration.MODID, "textures/entity/mechadog/mechadog_lime_glow.png"), new ResourceLocation(CelestialExploration.MODID, "textures/entity/mechadog/mechadog_green_glow.png"),
            new ResourceLocation(CelestialExploration.MODID, "textures/entity/mechadog/mechadog_cyan_glow.png"), new ResourceLocation(CelestialExploration.MODID, "textures/entity/mechadog/mechadog_light_blue_glow.png"),
            new ResourceLocation(CelestialExploration.MODID, "textures/entity/mechadog/mechadog_blue_glow.png"), new ResourceLocation(CelestialExploration.MODID, "textures/entity/mechadog/mechadog_purple_glow.png")};

    public MechaDogGlowLayer(GeoRenderer<MechaDog> entityRendererIn) {
        super(entityRendererIn);
    }


//    public void render(PoseStack p_116983_, MultiBufferSource p_116984_, int p_116985_, MechaDog p_116986_, float p_116987_, float p_116988_, float p_116989_, float p_116990_, float p_116991_, float p_116992_) {
//        VertexConsumer vertexconsumer = p_116984_.getBuffer(this.renderType());
////        this.getParentModel().renderToBuffer(p_116983_, vertexconsumer, 15728640, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
//    }

//    public void render(PoseStack poseStack, T animatable, BakedGeoModel bakedModel, RenderType renderType, MultiBufferSource bufferSource, VertexConsumer buffer, float partialTick, int packedLight, int packedOverlay) {
//        RenderType emissiveRenderType = this.renderType((MechaDog) animatable);
//        this.getRenderer().reRender(bakedModel, poseStack, bufferSource, animatable, emissiveRenderType, bufferSource.getBuffer(emissiveRenderType), partialTick, 15728640, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
//
////        this.getParentModel().renderToBuffer(p_116983_, vertexconsumer, 15728640, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
//    }


    @Override
    public RenderType renderType(MechaDog animatable) {
        return RenderType.eyes(MECHADOG_TEXTURE_LOCATIONS[animatable.getDyeType().ordinal()]);
    }
}