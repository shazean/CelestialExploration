package com.shim.celestialexploration.entity.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Vector3f;
import com.shim.celestialexploration.entity.client.animators.SpaceTaxiAnimator;
import com.shim.celestialexploration.entity.client.layers.DyedGlowLayer;
import com.shim.celestialexploration.entity.vehicle.SpaceTaxi;
import com.shim.celestialexploration.util.CelestialUtil;
import mod.azure.azurelib.render.entity.AzEntityRenderer;
import mod.azure.azurelib.render.entity.AzEntityRendererConfig;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;

@OnlyIn(Dist.CLIENT)
public class SpaceTaxiRenderer extends AzEntityRenderer<SpaceTaxi> {

    public SpaceTaxiRenderer(EntityRendererProvider.Context context) {
        super(AzEntityRendererConfig.builder(SpaceshipRenderer::getModel, SpaceTaxiRenderer::getTexture).setAnimatorProvider(SpaceTaxiAnimator::new)
                .setScale(1.7F)
                .addRenderLayer(new DyedGlowLayer<>())
                .build(), context);
    }

    public static ResourceLocation getTexture(SpaceTaxi spaceship) {
        return CelestialUtil.getModLoc("textures/entity/spaceship/taxi.png");
    }

    @Override
    public void render(@NotNull SpaceTaxi entity, float entityYaw, float partialTick, @NotNull PoseStack poseStack, @NotNull MultiBufferSource bufferSource, int packedLight) {

        float lerpBodyRot = Mth.rotLerp(partialTick, entity.yRotO, entity.getYRot());
        poseStack.mulPose(Vector3f.YP.rotationDegrees(180f - lerpBodyRot));

        if (entity.getDeltaMovement().y > 0)
            poseStack.mulPose((Vector3f.XP.rotationDegrees(5f)));
        if (entity.getDeltaMovement().y < 0)
            poseStack.mulPose((Vector3f.XP.rotationDegrees(-5f)));

        if (entity.deltaRotation < 0)
            poseStack.mulPose((Vector3f.ZP.rotationDegrees(5f)));
        if (entity.deltaRotation > 0)
            poseStack.mulPose((Vector3f.ZP.rotationDegrees(-5f)));

        super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
    }
}