package com.shim.celestialexploration.entity.client.animators;

import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestialexploration.entity.robots.MechaDog;
import com.shim.celestialexploration.util.CelestialUtil;
import mod.azure.azurelib.rewrite.animation.controller.AzAnimationController;
import mod.azure.azurelib.rewrite.animation.controller.AzAnimationControllerContainer;
import mod.azure.azurelib.rewrite.animation.impl.AzEntityAnimator;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

public class MechaDogAnimator extends AzEntityAnimator<MechaDog> {
    private static final ResourceLocation ANIMATIONS = CelestialUtil.getModLoc("animations/mechadog.animation.json");

    @Override
    public void registerControllers(AzAnimationControllerContainer<MechaDog> animationControllerContainer) {
        animationControllerContainer.add(AzAnimationController.builder(this, "base_controller").build());
    }

    @Override
    public @NotNull ResourceLocation getAnimationLocation(MechaDog animatable) {
        return ANIMATIONS;
    }
}