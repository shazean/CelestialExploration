package com.shim.celestialexploration.entity.layers;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Vector3f;
import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestialexploration.entity.entity.mob.Lurker;
import net.minecraft.client.model.CreeperModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

public class LurkerHelmetLayer extends RenderLayer<Lurker, CreeperModel<Lurker>> {
    public LurkerHelmetLayer(RenderLayerParent<Lurker, CreeperModel<Lurker>> p_116994_) {
        super(p_116994_);
    }

    public void render(PoseStack poseStack, MultiBufferSource bufferSource, int p_117009_, Lurker p_117010_, float p_117011_, float p_117012_, float p_117013_, float p_117014_, float p_117015_, float p_117016_) {
        BlockState blockState = Blocks.GLASS.defaultBlockState();

        poseStack.pushPose();
        poseStack.translate(0.35D, -0.25D, -.35D); //.35, .5, -.35
        float f = 0.5F;
        poseStack.scale(-0.72F, -0.72F, 0.72F);

        poseStack.mulPose(Vector3f.XP.rotationDegrees(90.0F));
        CelestialExploration.PROXY.getMinecraft().getBlockRenderer().renderSingleBlock(blockState, poseStack, bufferSource, p_117009_, OverlayTexture.NO_OVERLAY);
        poseStack.popPose();
    }
}