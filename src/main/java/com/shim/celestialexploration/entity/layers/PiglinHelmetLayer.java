package com.shim.celestialexploration.entity.layers;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Vector3f;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.PiglinModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

public class PiglinHelmetLayer<T extends Monster> extends RenderLayer<T, PiglinModel<T>> {
    public PiglinHelmetLayer(RenderLayerParent<T, PiglinModel<T>> p_116994_) {
        super(p_116994_);
    }

    public void render(PoseStack poseStack, MultiBufferSource bufferSource, int p_117009_, T entity, float p_117011_, float p_117012_, float p_117013_, float p_117014_, float p_117015_, float p_117016_) {
        boolean isBaby = entity.isBaby();

        BlockState blockState = Blocks.GLASS.defaultBlockState();

        poseStack.pushPose();
        poseStack.translate(0.35D, -0.65D, -.35D); //.35, .5, -.35
        float f = 0.5F;
        poseStack.scale(-0.80F, -0.80F, 0.80F);

        if (isBaby) {
            float scale = 0.72F;
            poseStack.scale(scale, scale, scale);
            poseStack.translate(0.0D, -1.6D, (double)0.209375F);
        }

        poseStack.mulPose(Vector3f.XP.rotationDegrees(90.0F));

        Minecraft.getInstance().getBlockRenderer().renderSingleBlock(blockState, poseStack, bufferSource, p_117009_, OverlayTexture.NO_OVERLAY);
        poseStack.popPose();
    }
}
