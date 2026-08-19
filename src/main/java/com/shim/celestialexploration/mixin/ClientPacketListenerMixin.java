package com.shim.celestialexploration.mixin;

import com.shim.celestialexploration.util.PlayerRenderDimension;
import net.minecraft.client.multiplayer.ClientPacketListener;
import net.minecraft.network.protocol.game.ClientboundRespawnPacket;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ClientPacketListener.class)
public class ClientPacketListenerMixin {

    @Inject(method = "handleRespawn", at = @At("HEAD"))
    private void injected(ClientboundRespawnPacket packet, CallbackInfo ci) {
        PlayerRenderDimension.setPlayerDimension(packet.getDimension());
    }
}