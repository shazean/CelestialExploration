package com.shim.celestialexploration.entity.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.shim.celestialexploration.entity.client.animators.SpaceshipAnimator;
import com.shim.celestialexploration.entity.client.layers.DyedGlowLayer;
import com.shim.celestialexploration.entity.vehicle.Spaceship;
import com.shim.celestialexploration.util.CelestialUtil;
import mod.azure.azurelib.render.entity.AzEntityRenderer;
import mod.azure.azurelib.render.entity.AzEntityRendererConfig;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;

@OnlyIn(Dist.CLIENT)
public class SpaceshipRenderer extends AzEntityRenderer<Spaceship> {

    public SpaceshipRenderer(EntityRendererProvider.Context context) {
        super(AzEntityRendererConfig.builder(SpaceshipRenderer::getModel, SpaceshipRenderer::getTexture).setAnimatorProvider(SpaceshipAnimator::new)
                .setScale(1.7F)
                .addRenderLayer(new DyedGlowLayer<>())
                .build(), context);
    }

    public static ResourceLocation getModel(Spaceship spaceship) {
        return CelestialUtil.getModLoc("geo/spaceship.geo.json");
    }

    public static ResourceLocation getTexture(Spaceship spaceship) {
        return CelestialUtil.getModLoc("textures/entity/spaceship/spaceship_" + spaceship.getDyeType().getName() + ".png");
    }

    @Override
    public void render(@NotNull Spaceship entity, float entityYaw, float partialTick, @NotNull PoseStack poseStack, @NotNull MultiBufferSource bufferSource, int packedLight) {

//        float lerpBodyRot = Mth.rotLerp(partialTick, entity.yRotO, entity.getYRot());
//        LivingEntity passenger = (LivingEntity) entity.getControllingPassenger();
//        if (passenger != null) {
//
//            CelestialExploration.LOGGER.debug("lerp: " + lerpBodyRot + ", passengerYBodyRot: " + passenger.yBodyRot + ", passngerYRot: " + passenger.getYRot());
//        }
//        poseStack.mulPose(Vector3f.YP.rotationDegrees(-lerpBodyRot));
//            poseStack.mulPose(Vector3f.YP.rotationDegrees(-passenger.getYRot()));
//        }

        entity.setJankyRotationFix(partialTick);

//
//        Entity passenger = entity.getControllingPassenger();
//        if (passenger != null) {
//            float lerpBodyRot = Mth.rotLerp(partialTick, entity.getControllingPassenger().yRotO, entity.getControllingPassenger().getYRot());
//            poseStack.mulPose(Vector3f.YP.rotationDegrees(-lerpBodyRot));
//        }

        //        poseStack.mulPose(Vector3f.YP.rotationDegrees(180));

//        if (entity.getDeltaMovement().y > 0)
//            poseStack.mulPose((Vector3f.XP.rotationDegrees(5f)));
//        if (entity.getDeltaMovement().y < 0)
//            poseStack.mulPose((Vector3f.XP.rotationDegrees(-5f)));
//
//        if (entity.deltaRotation < 0)
//            poseStack.mulPose((Vector3f.ZP.rotationDegrees(5f)));
//        if (entity.deltaRotation > 0)
//            poseStack.mulPose((Vector3f.ZP.rotationDegrees(-5f)));

        super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
    }
}