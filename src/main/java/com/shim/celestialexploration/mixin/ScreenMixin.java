package com.shim.celestialexploration.mixin;

import com.mojang.blaze3d.systems.RenderSystem;
import com.shim.celestialexploration.config.CelestialClientConfig;
import com.shim.celestialexploration.util.PlayerRenderDimension;
import net.minecraft.client.gui.screens.Screen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Screen.class)
public class ScreenMixin {

    @Inject(method = "renderDirtBackground", at = @At(value = "INVOKE", target = "Lcom/mojang/blaze3d/systems/RenderSystem;setShaderTexture(ILnet/minecraft/resources/ResourceLocation;)V", shift = At.Shift.AFTER))
    private void injected(int partialTick, CallbackInfo ci) {
        if (CelestialClientConfig.CUSTOM_TERRAIN_LOADING_SCREEN.get())
            RenderSystem.setShaderTexture(0, PlayerRenderDimension.getBackgroundTexture());
    }
}