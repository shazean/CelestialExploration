package com.shim.celestialexploration.entity.renderer;

import com.google.common.collect.ImmutableMap;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.datafixers.util.Pair;
import com.shim.celestialexploration.entity.entity.vehicle.Spaceship;
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
    }

    @Override
    public void actuallyRender(PoseStack poseStack, Spaceship animatable, BakedGeoModel model, RenderType renderType, MultiBufferSource bufferSource, VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        if (!isReRender) {
            float motionThreshold = this.getMotionAnimThreshold(animatable);
            Vec3 velocity = animatable.getDeltaMovement();
            float avgVelocity = (float)(Math.abs(velocity.x) + Math.abs(velocity.z)) / 2.0F;
            AnimationState<Spaceship> animationState = new AnimationState<>(animatable, 1, 1, partialTick, avgVelocity >= motionThreshold);

            long instanceId = this.getInstanceId(animatable);
            animationState.setData(DataTickets.TICK, ((GeoAnimatable)animatable).getTick(animatable));
            animationState.setData(DataTickets.ENTITY, animatable);
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
}