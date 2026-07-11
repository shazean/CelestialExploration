package com.shim.celestialexploration.packets;

import com.shim.celestialexploration.entity.vehicle.Buggy;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.network.NetworkHooks;

import java.util.function.Supplier;

public class BuggyInventoryPacket {
    int buggyId;

    public BuggyInventoryPacket(int buggyId) {
        this.buggyId = buggyId;
    }

    public static void encoder(BuggyInventoryPacket packet, FriendlyByteBuf buffer) {
        buffer.writeInt(packet.buggyId);
    }

    public static BuggyInventoryPacket decoder(FriendlyByteBuf buffer) {
        return new BuggyInventoryPacket(buffer.readInt());
    }

    public static void handle(BuggyInventoryPacket message, Supplier<NetworkEvent.Context> contextSupplier) {
        NetworkEvent.Context context = contextSupplier.get();
        context.enqueueWork(() -> {
            ServerPlayer player = context.getSender();

            if (player != null) {
                Entity entity = player.level.getEntity(message.buggyId);
                if (entity instanceof Buggy buggy) {
                    NetworkHooks.openGui(player, buggy, buf -> buf.writeInt(message.buggyId));
                }
            }
        });
        context.setPacketHandled(true);
    }
}