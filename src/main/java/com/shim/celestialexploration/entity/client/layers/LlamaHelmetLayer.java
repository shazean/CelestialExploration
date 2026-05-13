package com.shim.celestialexploration.entity.client.layers;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Vector3f;
import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestialexploration.entity.creatures.SpaceTraderLlama;
import net.minecraft.client.model.LlamaModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

public class LlamaHelmetLayer extends RenderLayer<SpaceTraderLlama, LlamaModel<SpaceTraderLlama>> {
    public LlamaHelmetLayer(RenderLayerParent<SpaceTraderLlama, LlamaModel<SpaceTraderLlama>> p_116994_) {
        super(p_116994_);
    }

    public void render(PoseStack poseStack, MultiBufferSource bufferSource, int p_117009_, SpaceTraderLlama llama, float p_117011_, float p_117012_, float p_117013_, float p_117014_, float p_117015_, float p_117016_) {
        BlockState blockState = Blocks.GLASS.defaultBlockState();

        poseStack.pushPose();

        poseStack.mulPose(Vector3f.YP.rotationDegrees(-llama.yBodyRot - llama.yHeadRot));

        poseStack.translate(0.35D, -0.0D, -1.0D); //.35, -0.8, -.35
        float f = 0.75F;
        poseStack.scale(-0.75F, -0.75F, 0.75F);


//        poseStack.mulPose(Vector3f.XP.rotationDegrees(90.0F));



        CelestialExploration.PROXY.getMinecraft().getBlockRenderer().renderSingleBlock(blockState, poseStack, bufferSource, p_117009_, OverlayTexture.NO_OVERLAY);
        poseStack.popPose();
    }
}