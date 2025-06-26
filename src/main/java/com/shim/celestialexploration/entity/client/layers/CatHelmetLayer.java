package com.shim.celestialexploration.entity.client.layers;

import com.mojang.blaze3d.vertex.PoseStack;
import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestialexploration.entity.friendlies.CelestialCat;
import net.minecraft.client.model.CatModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

public class CatHelmetLayer extends RenderLayer<CelestialCat, CatModel<CelestialCat>> {
public CatHelmetLayer(RenderLayerParent<CelestialCat, CatModel<CelestialCat>> p_116994_) {
        super(p_116994_);
        }

public void render(PoseStack poseStack, MultiBufferSource bufferSource, int p_117009_, CelestialCat entity, float p_117011_, float p_117012_, float p_117013_, float p_117014_, float p_117015_, float p_117016_) {
        boolean isSleeping = entity.isSleeping();
        boolean isSitting = entity.isInSittingPose();
        boolean isBaby = entity.isBaby();

        BlockState blockState = Blocks.GLASS.defaultBlockState();

        poseStack.pushPose();
        poseStack.translate(0.35D, 1.3D, -.85D); //.35, .5, -.35
        float f = 0.5F;
        poseStack.scale(-0.58F, -0.58F, 0.58F);

        if (isBaby) {
//            float f = 0.75F;
                poseStack.scale(0.75F, 0.75F, 0.75F);
                poseStack.translate(0.0D, 0.5D, (double)0.209375F);
        }

        if (isSitting) {
                poseStack.translate(0.0F, 0.6F, 0.0F);
        }

//        p_117007_.translate((double)(this.head.x / 16.0F), (double)(this.head.y / 16.0F), (double)(this.head.z / 16.0F));
//        float f1 = p_117010_.getHeadRollAngle(p_117013_);
//        p_117007_.mulPose(Vector3f.ZP.rotation(f1));
//        p_117007_.mulPose(Vector3f.YP.rotationDegrees(p_117015_));
//        p_117007_.mulPose(Vector3f.XP.rotationDegrees(p_117016_));
//        if (p_117010_.isBaby()) {
//            if (flag) {
//                p_117007_.translate((double)0.4F, (double)0.26F, (double)0.15F);
//            } else {
//                p_117007_.translate((double)0.06F, (double)0.26F, -0.5D);
//            }
//        } else if (flag) {
//            p_117007_.translate((double)0.46F, (double)0.26F, (double)0.22F);
//        } else {
//            p_117007_.translate((double)0.06F, (double)0.27F, -0.5D);
//        }

//        poseStack.mulPose(Vector3f.XP.rotationDegrees(90.0F));
//        if (flag) {
//            p_117007_.mulPose(Vector3f.ZP.rotationDegrees(90.0F));
//        }

//        ItemStack itemstack = p_117010_.getItemBySlot(EquipmentSlot.MAINHAND);
        //        Minecraft.getInstance().getItemInHandRenderer().renderItem(p_117010_, blockstate, ItemTransforms.TransformType.GROUND, false, p_117007_, p_117008_, p_117009_);
        CelestialExploration.PROXY.getMinecraft().getBlockRenderer().renderSingleBlock(blockState, poseStack, bufferSource, p_117009_, OverlayTexture.NO_OVERLAY);
        poseStack.popPose();
}
}