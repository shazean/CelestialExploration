package com.shim.celestialexploration.entity.client.animators;

import com.shim.celestialexploration.entity.friendlies.Cobblesaurus;
import com.shim.celestialexploration.util.CelestialUtil;
import mod.azure.azurelib.animation.controller.AzAnimationController;
import mod.azure.azurelib.animation.controller.AzAnimationControllerContainer;
import mod.azure.azurelib.animation.impl.AzEntityAnimator;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

public class CobblesaurusAnimator extends AzEntityAnimator<Cobblesaurus> {
    private static final ResourceLocation ANIMATIONS = CelestialUtil.getModLoc("animations/cobblesaurus.animation.json");

    @Override
    public void registerControllers(AzAnimationControllerContainer<Cobblesaurus> animationControllerContainer) {
        animationControllerContainer.add(AzAnimationController.builder(this, "base_controller").build());
    }

    @Override
    public @NotNull ResourceLocation getAnimationLocation(Cobblesaurus animatable) {
        return ANIMATIONS;
    }
}