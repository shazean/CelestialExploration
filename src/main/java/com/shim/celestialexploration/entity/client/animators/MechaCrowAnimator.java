package com.shim.celestialexploration.entity.client.animators;

import com.shim.celestialexploration.entity.robots.MechaCrow;
import com.shim.celestialexploration.util.CelestialUtil;
import mod.azure.azurelib.animation.controller.AzAnimationController;
import mod.azure.azurelib.animation.controller.AzAnimationControllerContainer;
import mod.azure.azurelib.animation.impl.AzEntityAnimator;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

public class MechaCrowAnimator extends AzEntityAnimator<MechaCrow> {
    private static final ResourceLocation ANIMATIONS = CelestialUtil.getModLoc("animations/mechacrow.animation.json");

    @Override
    public void registerControllers(AzAnimationControllerContainer<MechaCrow> animationControllerContainer) {
        animationControllerContainer.add(AzAnimationController.builder(this, "base_controller").build());
    }

    @Override
    public @NotNull ResourceLocation getAnimationLocation(MechaCrow animatable) {
        return ANIMATIONS;
    }
}