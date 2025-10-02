package com.shim.celestialexploration.entity.client.animators;

import com.mojang.math.Vector3f;
import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestialexploration.entity.vehicle.Spaceship;
import com.shim.celestialexploration.util.CelestialUtil;
import mod.azure.azurelib.rewrite.animation.cache.AzBoneCache;
import mod.azure.azurelib.rewrite.animation.controller.AzAnimationController;
import mod.azure.azurelib.rewrite.animation.controller.AzAnimationControllerContainer;
import mod.azure.azurelib.rewrite.animation.impl.AzEntityAnimator;
import mod.azure.azurelib.rewrite.model.AzBone;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import org.jetbrains.annotations.NotNull;

import java.util.Optional;

public class SpaceshipAnimator extends AzEntityAnimator<Spaceship> {
    private static final ResourceLocation ANIMATIONS = CelestialUtil.getModLoc("animations/spaceship.animation.json");

    @Override
    public void registerControllers(AzAnimationControllerContainer<Spaceship> animationControllerContainer) {
        animationControllerContainer.add(AzAnimationController.builder(this, "base_controller").build());
    }

    @Override
    public @NotNull ResourceLocation getAnimationLocation(Spaceship animatable) {
        return ANIMATIONS;
    }


    @Override
    public void setCustomAnimations(Spaceship animatable, float partialTicks) {
        super.setCustomAnimations(animatable, partialTicks);

//        float lerpBodyRot = Mth.rotLerp(partialTicks, animatable.yRotO, animatable.getYRot());
//
//        AzBoneCache boneCache = this.context().boneCache();
//        Optional<AzBone> root = boneCache.getBakedModel().getBone("root");
//
//        root.get().setRotY(lerpBodyRot);

//        poseStack.mulPose(Vector3f.YP.rotationDegrees(180f - lerpBodyRot));


    }
}