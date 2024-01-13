package com.shim.celestialexploration.packets;

import com.shim.celestialexploration.entity.Spaceship;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class SpaceshipFuelCapPacket {

    int fuelTicks;
    int spaceshipId;

    public SpaceshipFuelCapPacket(int spaceshipId, int fuelTicks) {
        this.spaceshipId = spaceshipId;
        this.fuelTicks = fuelTicks;
    }

    public static void encoder(SpaceshipFuelCapPacket packet, FriendlyByteBuf buffer) {
        buffer.writeInt(packet.spaceshipId);
        buffer.writeInt(packet.fuelTicks);
    }

    public static SpaceshipFuelCapPacket decoder(FriendlyByteBuf buffer) {
        return new SpaceshipFuelCapPacket(buffer.readInt(), buffer.readInt());
    }

    public static void handle(SpaceshipFuelCapPacket message, Supplier<NetworkEvent.Context> contextSupplier) {
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