package com.shim.celestialexploration.packets;

import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestialexploration.capabilities.OxygenHandler;
import com.shim.celestialexploration.entity.vehicle.Spaceship;
import com.shim.celestialexploration.registry.CelestialCapabilities;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.network.NetworkHooks;

import java.util.function.Supplier;

public class OxygenHandlerPacket {
    int oxygen;

    public OxygenHandlerPacket(int oxygen) {
        this.oxygen = oxygen;
    }

    public static void encoder(OxygenHandlerPacket packet, FriendlyByteBuf buffer) {
        buffer.writeInt(packet.oxygen);
    }

    public static OxygenHandlerPacket decoder(FriendlyByteBuf buffer) {
        return new OxygenHandlerPacket(buffer.readInt());
    }

    public static void handle(OxygenHandlerPacket message, Supplier<NetworkEvent.Context> contextSupplier) {
        NetworkEvent.Context context = contextSupplier.get();
        context.enqueueWork(() -> {

            Player player = CelestialExploration.PROXY.getPlayer();

            if (player != null) {
                OxygenHandler handler = CelestialExploration.getCapability(player, CelestialCapabilities.OXYGEN_CAPABILITY);
                if (handler != null) {
                    handler.setOxygen(message.oxygen);
                }
            }
        });
        context.setPacketHandled(true);
    }
}
