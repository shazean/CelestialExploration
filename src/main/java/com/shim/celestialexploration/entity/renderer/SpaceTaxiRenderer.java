package com.shim.celestialexploration.entity.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.shim.celestialexploration.entity.model.SpaceTaxiModel;
import com.shim.celestialexploration.entity.entity.vehicle.SpaceTaxi;
import mod.azure.azurelib.cache.object.BakedGeoModel;
import mod.azure.azurelib.constant.DataTickets;
import mod.azure.azurelib.core.animatable.GeoAnimatable;
import mod.azure.azurelib.core.animation.AnimationState;
import mod.azure.azurelib.model.GeoModel;
import mod.azure.azurelib.renderer.GeoEntityRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.util.Mth;
import net.minecraft.world.phys.Vec3;

import java.util.Objects;

public class SpaceTaxiRenderer extends GeoEntityRenderer<SpaceTaxi> {
//    private final Map<Spaceship.Type, Pair<ResourceLocation, SpaceshipModel>> spaceshipResources;
//    private static final ResourceLocation TEXTURE = new ResourceLocation(CelestialExploration.MODID, "textures/entity/spiderlike/meteor_crawler.png");

    public SpaceTaxiRenderer(EntityRendererProvider.Context context) {
        super(context, new SpaceTaxiModel());
    }

    @Override
    public void actuallyRender(PoseStack poseStack, SpaceTaxi animatable, BakedGeoModel model, RenderType renderType, MultiBufferSource bufferSource, VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {

        if (!isReRender) {
//            float headPitch = Mth.lerp(partialTick, animatable.xRotO, animatable.getXRot());
            float motionThreshold = this.getMotionAnimThreshold(animatable);
            Vec3 velocity = animatable.getDeltaMovement();
            float avgVelocity = (float)(Math.abs(velocity.x) + Math.abs(velocity.z)) / 2.0F;
//            float avgVelocity = (float)(Math.abs(velocity.x) + Math.abs(velocity.z) + Math.abs(velocity.y)) / 3.0F;

            AnimationState<SpaceTaxi> animationState = new AnimationState<>(animatable, 1, 1, partialTick, avgVelocity >= motionThreshold);

            long instanceId = this.getInstanceId(animatable);
            animationState.setData(DataTickets.TICK, ((GeoAnimatable)animatable).getTick(animatable));
            animationState.setData(DataTickets.ENTITY, animatable);
//            animationState.setData(DataTickets.ENTITY_MODEL_DATA, new EntityModelData(shouldSit, livingEntity != null && livingEntity.isBaby(), -netHeadYaw, -headPitch));
            GeoModel<SpaceTaxi> var32 = this.model;
            Objects.requireNonNull(animationState);
            var32.addAdditionalStateData(animatable, instanceId, animationState::setData);
            this.model.handleAnimations(animatable, instanceId, animationState);
        }

        float lerpBodyRot = Mth.rotLerp(partialTick, animatable.yRotO, animatable.getYRot());
        float nativeScale = 1.7F;
        poseStack.scale(nativeScale, nativeScale, nativeScale);
        float ageInTicks = animatable.tickCount + partialTick;
        applyRotations(animatable, poseStack, ageInTicks, lerpBodyRot, partialTick, nativeScale);

        super.actuallyRender(poseStack, animatable, model, renderType, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, red, green, blue, alpha);
    }
}