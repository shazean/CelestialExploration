package com.shim.celestialexploration.entity.renderer;

import com.google.common.collect.ImmutableMap;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.datafixers.util.Pair;
import com.shim.celestialexploration.entity.vehicle.Spaceship;
import com.shim.celestialexploration.entity.model.SpaceshipModel;
import mod.azure.azurelib.cache.object.BakedGeoModel;
import mod.azure.azurelib.constant.DataTickets;
import mod.azure.azurelib.core.animatable.GeoAnimatable;
import mod.azure.azurelib.core.animation.AnimationState;
import mod.azure.azurelib.model.GeoModel;
import mod.azure.azurelib.renderer.GeoEntityRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.Map;
import java.util.Objects;
import java.util.stream.Stream;

@OnlyIn(Dist.CLIENT)
public class SpaceshipRenderer extends GeoEntityRenderer<Spaceship> {
    private final Map<Spaceship.Type, Pair<ResourceLocation, SpaceshipModel>> spaceshipResources;

    public SpaceshipRenderer(EntityRendererProvider.Context context) {
        super(context, new SpaceshipModel());
        this.spaceshipResources = Stream.of(Spaceship.Type.values()).collect(ImmutableMap.toImmutableMap((type) ->
                type, (p_173941_) ->
                Pair.of(new ResourceLocation("textures/entity/spaceship/" + p_173941_.getName() + ".png"), new SpaceshipModel())));


//        addRenderLayer(new AutoGlowingGeoLayer<>(this));

    }

//    @Override
//    public GeoEntityRenderer<Spaceship> withScale(float scale) {
//        return super.withScale(1.7F);
//    }


    @Override
    public void actuallyRender(PoseStack poseStack, Spaceship animatable, BakedGeoModel model, RenderType renderType, MultiBufferSource bufferSource, VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {


        if (!isReRender) {
//            float headPitch = Mth.lerp(partialTick, animatable.xRotO, animatable.getXRot());
            float motionThreshold = this.getMotionAnimThreshold(animatable);
            Vec3 velocity = animatable.getDeltaMovement();
            float avgVelocity = (float)(Math.abs(velocity.x) + Math.abs(velocity.z)) / 2.0F;
//            float avgVelocity = (float)(Math.abs(velocity.x) + Math.abs(velocity.z) + Math.abs(velocity.y)) / 3.0F;

//            CelestialExploration.LOGGER.debug("average velocity: " + avgVelocity);
            AnimationState<Spaceship> animationState = new AnimationState<>(animatable, 1, 1, partialTick, avgVelocity >= motionThreshold);
//            if (animationState.isMoving()) CelestialExploration.LOGGER.debug("isMoving:" + animationState.isMoving());

            long instanceId = this.getInstanceId(animatable);
            animationState.setData(DataTickets.TICK, ((GeoAnimatable)animatable).getTick(animatable));
            animationState.setData(DataTickets.ENTITY, animatable);
//            animationState.setData(DataTickets.ENTITY_MODEL_DATA, new EntityModelData(shouldSit, livingEntity != null && livingEntity.isBaby(), -netHeadYaw, -headPitch));
            GeoModel<Spaceship> var32 = this.model;
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

//    @Override
//    public void preRender(PoseStack poseStack, Spaceship animatable, BakedGeoModel model, MultiBufferSource bufferSource, VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
////        poseStack.mulPose(Vector3f.YP.rotationDegrees(180.0F - partialTick));
//
//        this.withScale(1.7F);
//
//        super.preRender(poseStack, animatable, model, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, red, green, blue, alpha);
//    }

//    @Override
//    public void render(Spaceship spaceship, float p_225623_2_, float p_225623_3_, PoseStack poseStack, MultiBufferSource bufferSource, int p_225623_6_) {
//        poseStack.mulPose(Vector3f.YP.rotationDegrees(180.0F - p_225623_2_));
//
//        super.render(spaceship, p_225623_2_, p_225623_3_, poseStack, bufferSource, p_225623_6_);
//    }
}