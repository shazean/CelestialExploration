package com.shim.celestialexploration.item.armor;

import com.shim.celestialexploration.CelestialExploration;
import mod.azure.azurelib.rewrite.animation.controller.AzAnimationController;
import mod.azure.azurelib.rewrite.animation.controller.AzAnimationControllerContainer;
import mod.azure.azurelib.rewrite.animation.impl.AzItemAnimator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

public class SpacesuitAnimator extends AzItemAnimator {
    private static final ResourceLocation IDLE = ResourceLocation.fromNamespaceAndPath(
            CelestialExploration.MODID, "animations/spacesuit.animation.json");

    @Override
    public void registerControllers(AzAnimationControllerContainer<ItemStack> animationControllerContainer) {
        animationControllerContainer.add(AzAnimationController.builder(this, "base_controller").build());
    }

    @Override
    public @NotNull ResourceLocation getAnimationLocation(ItemStack animatable) {
        return IDLE;
    }
}