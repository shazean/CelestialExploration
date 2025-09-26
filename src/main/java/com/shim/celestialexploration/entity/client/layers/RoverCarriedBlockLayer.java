package com.shim.celestialexploration.entity.client.layers;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Vector3f;
import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestialexploration.entity.robots.Rover;
import mod.azure.azurelib.rewrite.model.AzBone;
import mod.azure.azurelib.rewrite.render.AzRendererPipelineContext;
import mod.azure.azurelib.rewrite.render.layer.AzRenderLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class RoverCarriedBlockLayer implements AzRenderLayer<Rover> {

    @Override
    public void preRender(AzRendererPipelineContext<Rover> azRendererPipelineContext) {}

    @Override
    public void render(AzRendererPipelineContext<Rover> azRendererPipelineContext) {

        Rover animatable = azRendererPipelineContext.animatable();
        PoseStack poseStack = azRendererPipelineContext.poseStack();

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
            CelestialExploration.PROXY.getMinecraft().getBlockRenderer().renderSingleBlock(blockstate, poseStack, azRendererPipelineContext.multiBufferSource(), azRendererPipelineContext.packedLight(), OverlayTexture.NO_OVERLAY);
            poseStack.popPose();
        }

    }

    @Override
    public void renderForBone(AzRendererPipelineContext<Rover> azRendererPipelineContext, AzBone azBone) {}
}