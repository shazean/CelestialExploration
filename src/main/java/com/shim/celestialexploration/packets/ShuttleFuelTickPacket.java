package com.shim.celestialexploration.packets;

import com.shim.celestialexploration.entity.Shuttle;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class ShuttleFuelTickPacket {

    int fuelTicks;
    int shuttleId;

    public ShuttleFuelTickPacket(int shuttleId, int fuelTicks) {
        this.shuttleId = shuttleId;
        this.fuelTicks = fuelTicks;
    }

    public static void encoder(ShuttleFuelTickPacket packet, FriendlyByteBuf buffer) {
        buffer.writeInt(packet.shuttleId);
        buffer.writeInt(packet.fuelTicks);
    }

    public static ShuttleFuelTickPacket decoder(FriendlyByteBuf buffer) {
        return new ShuttleFuelTickPacket(buffer.readInt(), buffer.readInt());
    }

    public static void handle(ShuttleFuelTickPacket message, Supplier<NetworkEvent.Context> contextSupplier) {
        NetworkEvent.Context context = contextSupplier.get();
        context.enqueueWork(() -> {
            ServerPlayer player = context.getSender();
            if (player != null) {
                Entity entity = player.level.getEntity(message.shuttleId);
                if (entity instanceof Shuttle shuttle) {
                    shuttle.decrementFuelTicks();
//                    shuttle.setFuelTicks(message.fuelTicks);
                }
            }
        });
        context.setPacketHandled(true);
    }
}