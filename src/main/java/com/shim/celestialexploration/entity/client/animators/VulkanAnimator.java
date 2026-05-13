package com.shim.celestialexploration.entity.client.animators;

import com.shim.celestialexploration.entity.monster.Vulkan;
import com.shim.celestialexploration.util.CelestialUtil;
import mod.azure.azurelib.animation.controller.AzAnimationController;
import mod.azure.azurelib.animation.controller.AzAnimationControllerContainer;
import mod.azure.azurelib.animation.impl.AzEntityAnimator;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

public class VulkanAnimator extends AzEntityAnimator<Vulkan> {
    private static final ResourceLocation ANIMATIONS = CelestialUtil.getModLoc("animations/vulkan.animation.json");

    @Override
    public void registerControllers(AzAnimationControllerContainer<Vulkan> animationControllerContainer) {
        animationControllerContainer.add(AzAnimationController.builder(this, "base_controller").build());
    }

    @Override
    public @NotNull ResourceLocation getAnimationLocation(Vulkan animatable) {
        return ANIMATIONS;
    }
}