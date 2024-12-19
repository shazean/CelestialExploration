package com.shim.celestialexploration.entity.layers;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Vector3f;
import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestialexploration.entity.entity.robots.Rover;
import com.shim.celestialexploration.entity.model.RoverModel;
import mod.azure.azurelib.animatable.GeoEntity;
import mod.azure.azurelib.cache.object.BakedGeoModel;
import mod.azure.azurelib.renderer.GeoRenderer;
import mod.azure.azurelib.renderer.layer.GeoRenderLayer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.EndermanModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.world.entity.monster.EnderMan;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class RoverCarriedBlockLayer extends GeoRenderLayer<Rover> {


    public RoverCarriedBlockLayer(GeoRenderer<Rover> entityRendererIn) {
        super(entityRendererIn);
    }

    @Override
    public void render(PoseStack poseStack, Rover animatable, BakedGeoModel bakedModel, RenderType renderType, MultiBufferSource bufferSource, VertexConsumer buffer, float partialTick, int packedLight, int packedOverlay) {
        super.render(poseStack, animatable, bakedModel, renderType, bufferSource, buffer, partialTick, packedLight, packedOverlay);

        BlockState blockstate = animatable.getCarriedBlock();
        if (blockstate != null) {
            poseStack.pushPose();
            poseStack.translate(0.0D, 0.0D, -0.75D); //0.0D, 0.6875D, -0.75D

            poseStack.mulPose(Vector3f.ZP.rotationDegrees(animatable.yBodyRot));
            poseStack.mulPose(Vector3f.XP.rotationDegrees(animatable.yBodyRot));
            poseStack.mulPose(Vector3f.YP.rotationDegrees(animatable.yBodyRot));

//            poseStack.mulPose(Vector3f.XP.rotationDegrees(20.0F));
            poseStack.mulPose(Vector3f.YP.rotationDegrees(45.0F));
            poseStack.translate(0.25D, 0.1875D, 0.25D);
            float f = 0.45F;
            poseStack.scale(-f, -f, f);
            poseStack.mulPose(Vector3f.ZP.rotationDegrees(180.0F));

            poseStack.mulPose(Vector3f.YP.rotationDegrees(90.0F));
            CelestialExploration.PROXY.getMinecraft().getBlockRenderer().renderSingleBlock(blockstate, poseStack, bufferSource, packedLight, OverlayTexture.NO_OVERLAY);
            poseStack.popPose();
        }
    }
}