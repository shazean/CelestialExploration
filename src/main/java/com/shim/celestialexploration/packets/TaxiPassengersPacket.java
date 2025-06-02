package com.shim.celestialexploration.packets;

import com.shim.celestialexploration.entity.vehicle.SpaceTaxi;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class TaxiPassengersPacket {
    int taxiId;
    int passengerId;
    int passengerNumber;

    public TaxiPassengersPacket(int taxiId, int passengerId, int passengerNumber) {
        this.taxiId = taxiId;
        this.passengerId = passengerId;
        this.passengerNumber = passengerNumber;
    }

    public static void encoder(TaxiPassengersPacket packet, FriendlyByteBuf buffer) {
        buffer.writeInt(packet.taxiId);
        buffer.writeInt(packet.passengerId);
        buffer.writeInt(packet.passengerNumber);

    }

    public static TaxiPassengersPacket decoder(FriendlyByteBuf buffer) {
        return new TaxiPassengersPacket(buffer.readInt(), buffer.readInt(), buffer.readInt());
    }

    public static void handle(TaxiPassengersPacket message, Supplier<NetworkEvent.Context> contextSupplier) {
        NetworkEvent.Context context = contextSupplier.get();
        context.enqueueWork(() -> {
            ServerPlayer player = context.getSender();

            if (player != null) {
                Entity entity = player.level.getEntity(message.taxiId);
                if (entity instanceof SpaceTaxi taxi) {
                    Entity passenger = player.level.getEntity(message.passengerId);

                    if (passenger != null) {
                        taxi.setPassenger(passenger, message.passengerNumber);

                    }
                }
            }
        });
        context.setPacketHandled(true);
    }
}

