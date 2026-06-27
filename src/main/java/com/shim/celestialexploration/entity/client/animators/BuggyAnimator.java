package com.shim.celestialexploration.entity.client.animators;

import com.shim.celestialexploration.entity.vehicle.Buggy;
import com.shim.celestialexploration.util.CelestialUtil;
import mod.azure.azurelib.animation.controller.AzAnimationController;
import mod.azure.azurelib.animation.controller.AzAnimationControllerContainer;
import mod.azure.azurelib.animation.impl.AzEntityAnimator;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

public class BuggyAnimator extends AzEntityAnimator<Buggy> {
    private static final ResourceLocation ANIMATIONS = CelestialUtil.getModLoc("animations/buggy.animation.json");

    @Override
    public void registerControllers(AzAnimationControllerContainer<Buggy> animationControllerContainer) {
        animationControllerContainer.add(AzAnimationController.builder(this, "base_controller").setTransitionLength(1).build());
    }

    @Override
    public @NotNull ResourceLocation getAnimationLocation(Buggy animatable) {
        return ANIMATIONS;
    }


}