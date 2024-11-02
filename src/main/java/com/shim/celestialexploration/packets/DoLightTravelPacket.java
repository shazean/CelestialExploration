package com.shim.celestialexploration.packets;

import com.shim.celestialexploration.entity.vehicle.Spaceship;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class DoLightTravelPacket {

    private final int spaceshipId;
    private final int passengerOneId;
    private final int passengerTwoId;
    private final BlockPos destinationPos;

    public DoLightTravelPacket(int spaceshipId, int passengerOneId, int passengerTwoId, BlockPos destinationPos) {
        this.spaceshipId = spaceshipId;
        this.passengerOneId = passengerOneId;
        this.passengerTwoId = passengerTwoId;
        this.destinationPos = destinationPos;
    }

    public static void encoder(DoLightTravelPacket packet, FriendlyByteBuf buffer) {
        buffer.writeInt(packet.spaceshipId);
        buffer.writeInt(packet.passengerOneId);
        buffer.writeInt(packet.passengerTwoId);
        buffer.writeBlockPos(packet.destinationPos);
    }

    public static DoLightTravelPacket decoder(FriendlyByteBuf buffer) {
        return new DoLightTravelPacket(buffer.readInt(), buffer.readInt(), buffer.readInt(), buffer.readBlockPos());
    }

    public static void handle(DoLightTravelPacket message, Supplier<NetworkEvent.Context> contextSupplier) {
        NetworkEvent.Context context = contextSupplier.get();
        context.enqueueWork(() -> {
            ServerPlayer serverPlayer = context.getSender();

            if (serverPlayer != null) {

                Entity entity = serverPlayer.level.getEntity(message.spaceshipId);
                if (entity instanceof Spaceship spaceship) {
                    Entity passengerOne = serverPlayer.level.getEntity(message.passengerOneId);
                    Entity passengerTwo;
                    if (message.passengerTwoId != -1)
                         passengerTwo = serverPlayer.level.getEntity(message.passengerTwoId);
                    else
                        passengerTwo = null;

                    spaceship.doLightTravel(passengerOne, passengerTwo, message.destinationPos, serverPlayer);
                }
            }
        });
        context.setPacketHandled(true);
    }
}