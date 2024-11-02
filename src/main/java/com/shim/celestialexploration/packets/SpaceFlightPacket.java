package com.shim.celestialexploration.packets;

import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestialexploration.capabilities.ISpaceFlight;
import com.shim.celestialexploration.registry.CapabilityRegistry;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class SpaceFlightPacket {
    int teleportationCooldown;

    public SpaceFlightPacket(int teleportationCooldown) {
        this.teleportationCooldown = teleportationCooldown;
    }

    public static void encoder(SpaceFlightPacket packet, FriendlyByteBuf buffer) {
        buffer.writeInt(packet.teleportationCooldown);
    }

    public static SpaceFlightPacket decoder(FriendlyByteBuf buffer) {
        return new SpaceFlightPacket(buffer.readInt());
    }

    public static void handle(SpaceFlightPacket message, Supplier<NetworkEvent.Context> contextSupplier) {
        NetworkEvent.Context context = contextSupplier.get();
        context.enqueueWork(() -> {
            ServerPlayer player = context.getSender();
            if (player != null) {

                Entity spaceVehicle = null;

                ISpaceFlight flightCap = CelestialExploration.getCapability(player, CapabilityRegistry.SPACE_FLIGHT_CAPABILITY);
                if (flightCap != null) spaceVehicle = player;
                else {
                    if (player.getVehicle() != null) {
                        flightCap = CelestialExploration.getCapability(player.getVehicle(), CapabilityRegistry.SPACE_FLIGHT_CAPABILITY);
                        if (flightCap != null) spaceVehicle = player.getVehicle();
                    }
                }

                if (spaceVehicle != null) {
                    flightCap.setTeleportationCooldown(message.teleportationCooldown);
                }
            }
        });
        context.setPacketHandled(true);
    }
}