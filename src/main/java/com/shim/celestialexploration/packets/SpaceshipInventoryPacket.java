package com.shim.celestialexploration.packets;

import com.shim.celestialexploration.entity.entity.vehicle.Spaceship;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.network.NetworkHooks;

import java.util.function.Supplier;

public class SpaceshipInventoryPacket {
    int spaceshipId;

    public SpaceshipInventoryPacket(int spaceshipId) {
        this.spaceshipId = spaceshipId;
    }

    public static void encoder(SpaceshipInventoryPacket packet, FriendlyByteBuf buffer) {
        buffer.writeInt(packet.spaceshipId);
    }

    public static SpaceshipInventoryPacket decoder(FriendlyByteBuf buffer) {
        return new SpaceshipInventoryPacket(buffer.readInt());
    }

    public static void handle(SpaceshipInventoryPacket message, Supplier<NetworkEvent.Context> contextSupplier) {
        NetworkEvent.Context context = contextSupplier.get();
        context.enqueueWork(() -> {
            ServerPlayer player = context.getSender();

            if (player != null) {
                Entity entity = player.level.getEntity(message.spaceshipId);
                if (entity instanceof Spaceship spaceship) {
                        NetworkHooks.openGui(player, spaceship, buf -> buf.writeInt(message.spaceshipId));
                }
            }
        });
        context.setPacketHandled(true);
    }
}