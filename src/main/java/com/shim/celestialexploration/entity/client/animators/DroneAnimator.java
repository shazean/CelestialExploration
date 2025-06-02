package com.shim.celestialexploration.entity.client.animators;

import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestialexploration.entity.robots.Drone;
import com.shim.celestialexploration.entity.robots.MechaDog;
import com.shim.celestialexploration.util.CelestialUtil;
import mod.azure.azurelib.rewrite.animation.controller.AzAnimationController;
import mod.azure.azurelib.rewrite.animation.controller.AzAnimationControllerContainer;
import mod.azure.azurelib.rewrite.animation.impl.AzEntityAnimator;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

public class DroneAnimator extends AzEntityAnimator<Drone> {
    private static final ResourceLocation ANIMATIONS = CelestialUtil.getModLoc("animations/drone.animation.json");

    @Override
    public void registerControllers(AzAnimationControllerContainer<Drone> animationControllerContainer) {
        animationControllerContainer.add(AzAnimationController.builder(this, "base_controller").build());
    }

    @Override
    public @NotNull ResourceLocation getAnimationLocation(Drone animatable) {
        return ANIMATIONS;
    }
}