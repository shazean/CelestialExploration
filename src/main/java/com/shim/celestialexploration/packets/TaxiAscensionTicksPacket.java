package com.shim.celestialexploration.packets;

import com.shim.celestialexploration.entity.vehicle.SpaceTaxi;
import com.shim.celestialexploration.entity.vehicle.Spaceship;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class TaxiAscensionTicksPacket {
        int taxiId;
        int ticks;

        public TaxiAscensionTicksPacket(int taxiId, int fuelTicks) {
            this.taxiId = taxiId;
            this.ticks = ticks;
        }

        public static void encoder(TaxiAscensionTicksPacket packet, FriendlyByteBuf buffer) {
            buffer.writeInt(packet.taxiId);
            buffer.writeInt(packet.ticks);
        }

        public static TaxiAscensionTicksPacket decoder(FriendlyByteBuf buffer) {
            return new TaxiAscensionTicksPacket(buffer.readInt(), buffer.readInt());
        }

        public static void handle(TaxiAscensionTicksPacket message, Supplier<NetworkEvent.Context> contextSupplier) {
            NetworkEvent.Context context = contextSupplier.get();
            context.enqueueWork(() -> {
                ServerPlayer player = context.getSender();
                if (player != null) {
                    Entity entity = player.level.getEntity(message.taxiId);
                    if (entity instanceof SpaceTaxi taxi) {
                        taxi.setTicksAscended(message.ticks);
//                    spaceship.setFuelTicks(message.fuelTicks);
                    }
                }
            });
            context.setPacketHandled(true);
        }
}