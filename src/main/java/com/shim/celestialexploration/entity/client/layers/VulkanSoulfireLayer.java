package com.shim.celestialexploration.entity.client.layers;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Vector3f;
import com.shim.celestialexploration.entity.monster.Vulkan;
import mod.azure.azurelib.model.AzBone;
import mod.azure.azurelib.render.AzRendererPipelineContext;
import mod.azure.azurelib.render.layer.AzRenderLayer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.world.level.block.Blocks;

import java.util.UUID;

public class VulkanSoulfireLayer implements AzRenderLayer<UUID, Vulkan> {

    @Override
    public void preRender(AzRendererPipelineContext<UUID, Vulkan> context) {}

    @Override
    public void render(AzRendererPipelineContext<UUID, Vulkan> context) {

        if (context.animatable().isCharged()) {

            PoseStack poseStack = context.poseStack();
            poseStack.pushPose();

            float scale = 0.5F;
            poseStack.scale(scale, scale, scale);


            poseStack.mulPose(Vector3f.YP.rotationDegrees(-context.animatable().yBodyRot));

            poseStack.translate(-0.5F, 0F, -0.5F); //0.5F, 0F, -0.5F

            Minecraft.getInstance().getBlockRenderer().renderSingleBlock(Blocks.SOUL_FIRE.defaultBlockState(), poseStack, context.multiBufferSource(), context.packedLight(), OverlayTexture.NO_OVERLAY);

            poseStack.translate(0F, 1.4F, 0F);
            Minecraft.getInstance().getBlockRenderer().renderSingleBlock(Blocks.SOUL_FIRE.defaultBlockState(), poseStack, context.multiBufferSource(), context.packedLight(), OverlayTexture.NO_OVERLAY);

            poseStack.translate(0F, 1.9F, 0F);
            Minecraft.getInstance().getBlockRenderer().renderSingleBlock(Blocks.SOUL_FIRE.defaultBlockState(), poseStack, context.multiBufferSource(), context.packedLight(), OverlayTexture.NO_OVERLAY);

            poseStack.translate(-1.25F, 0.1F, 0F);
            Minecraft.getInstance().getBlockRenderer().renderSingleBlock(Blocks.SOUL_FIRE.defaultBlockState(), poseStack, context.multiBufferSource(), context.packedLight(), OverlayTexture.NO_OVERLAY);

            poseStack.translate(2.5F, 0F, 0F);
            Minecraft.getInstance().getBlockRenderer().renderSingleBlock(Blocks.SOUL_FIRE.defaultBlockState(), poseStack, context.multiBufferSource(), context.packedLight(), OverlayTexture.NO_OVERLAY);


            poseStack.popPose();
        }

    }

    @Override
    public void renderForBone(AzRendererPipelineContext<UUID, Vulkan> context, AzBone bone) {

    }
}