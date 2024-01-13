package com.shim.celestialexploration.packets;

import com.shim.celestialexploration.entity.Spaceship;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class SpaceshipFuelTickPacket {

    int fuelTicks;
    int spaceshipId;

    public SpaceshipFuelTickPacket(int spaceshipId, int fuelTicks) {
        this.spaceshipId = spaceshipId;
        this.fuelTicks = fuelTicks;
    }

    public static void encoder(SpaceshipFuelTickPacket packet, FriendlyByteBuf buffer) {
        buffer.writeInt(packet.spaceshipId);
        buffer.writeInt(packet.fuelTicks);
    }

    public static SpaceshipFuelTickPacket decoder(FriendlyByteBuf buffer) {
        return new SpaceshipFuelTickPacket(buffer.readInt(), buffer.readInt());
    }

    public static void handle(SpaceshipFuelTickPacket message, Supplier<NetworkEvent.Context> contextSupplier) {
        NetworkEvent.Context context = contextSupplier.get();
        context.enqueueWork(() -> {
            ServerPlayer player = context.getSender();
            if (player != null) {
                Entity entity = player.level.getEntity(message.spaceshipId);
                if (entity instanceof Spaceship spaceship) {
                    spaceship.decrementFuelTicks();
//                    spaceship.setFuelTicks(message.fuelTicks);
                }
            }
        });
        context.setPacketHandled(true);
    }
}