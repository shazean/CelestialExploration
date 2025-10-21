package com.shim.celestialexploration.entity.client.animators;

import com.shim.celestialexploration.entity.mob.Orbiter;
import com.shim.celestialexploration.util.CelestialUtil;
import mod.azure.azurelib.animation.controller.AzAnimationController;
import mod.azure.azurelib.animation.controller.AzAnimationControllerContainer;
import mod.azure.azurelib.animation.impl.AzEntityAnimator;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

public class OrbiterAnimator extends AzEntityAnimator<Orbiter> {
    private static final ResourceLocation ANIMATIONS = CelestialUtil.getModLoc("animations/orbiter.animation.json");

    @Override
    public void registerControllers(AzAnimationControllerContainer<Orbiter> animationControllerContainer) {
        animationControllerContainer.add(AzAnimationController.builder(this, "base_controller").build());
    }

    @Override
    public @NotNull ResourceLocation getAnimationLocation(Orbiter animatable) {
        return ANIMATIONS;
    }
}