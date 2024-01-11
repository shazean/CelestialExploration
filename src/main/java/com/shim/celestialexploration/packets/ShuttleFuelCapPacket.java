package com.shim.celestialexploration.packets;

import com.shim.celestialexploration.entity.Shuttle;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class ShuttleFuelCapPacket {

    int fuelTicks;
    int shuttleId;

    public ShuttleFuelCapPacket(int shuttleId, int fuelTicks) {
        this.shuttleId = shuttleId;
        this.fuelTicks = fuelTicks;
    }

    public static void encoder(ShuttleFuelCapPacket packet, FriendlyByteBuf buffer) {
        buffer.writeInt(packet.shuttleId);
        buffer.writeInt(packet.fuelTicks);
    }

    public static ShuttleFuelCapPacket decoder(FriendlyByteBuf buffer) {
        return new ShuttleFuelCapPacket(buffer.readInt(), buffer.readInt());
    }

    public static void handle(ShuttleFuelCapPacket message, Supplier<NetworkEvent.Context> contextSupplier) {
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