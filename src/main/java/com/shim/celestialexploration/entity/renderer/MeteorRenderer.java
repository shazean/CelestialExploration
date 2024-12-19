package com.shim.celestialexploration.entity.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Vector3f;
import com.shim.celestialexploration.entity.model.MeteorModel;
import com.shim.celestialexploration.entity.entity.projectile.MeteorProjectile;
import mod.azure.azurelib.cache.object.BakedGeoModel;
import mod.azure.azurelib.renderer.GeoEntityRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class MeteorRenderer extends GeoEntityRenderer<MeteorProjectile> {

    public MeteorRenderer(EntityRendererProvider.Context context) {
        super(context, new MeteorModel());
    }

    @Override
    public void actuallyRender(PoseStack poseStack, MeteorProjectile animatable, BakedGeoModel model, RenderType renderType, MultiBufferSource bufferSource, VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
//        if (this.rotateProjectile()) this.applyProjectileRotation(poseStack, animatable);
        poseStack.mulPose(Vector3f.XP.rotationDegrees(35));
        poseStack.scale(1.25F, 1.25F, 1.25F);

        super.actuallyRender(poseStack, animatable, model, renderType, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, red, green, blue, alpha);
    }

    public boolean rotateProjectile() { return false; }

    public void applyProjectileRotation(PoseStack poseStack, MeteorProjectile animatable) {
        poseStack.mulPose(Vector3f.YP.rotationDegrees((-animatable.getYRot()) - 180));
        poseStack.mulPose(Vector3f.XP.rotationDegrees(animatable.getXRot()));
    }
}