package com.shim.celestialexploration.entity.client.animators;

import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestialexploration.entity.vehicle.Spaceship;
import com.shim.celestialexploration.util.CelestialUtil;
import mod.azure.azurelib.rewrite.animation.controller.AzAnimationController;
import mod.azure.azurelib.rewrite.animation.controller.AzAnimationControllerContainer;
import mod.azure.azurelib.rewrite.animation.impl.AzEntityAnimator;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

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
}