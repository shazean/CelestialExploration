//package com.shim.celestialexploration.packets;
//
//import com.shim.celestialexploration.entity.vehicle.SpaceTaxi;
//import net.minecraft.network.FriendlyByteBuf;
//import net.minecraft.server.level.ServerPlayer;
//import net.minecraft.world.entity.Entity;
//import net.minecraftforge.network.NetworkEvent;
//
//import java.util.function.Supplier;
//
//public class TaxiReadyForTakeoffPacket {
//        int taxiId;
//
//        public TaxiReadyForTakeoffPacket(int taxiId) {
//            this.taxiId = taxiId;
//        }
//
//        public static void encoder(TaxiReadyForTakeoffPacket packet, FriendlyByteBuf buffer) {
//            buffer.writeInt(packet.taxiId);
//
//        }
//
//        public static TaxiReadyForTakeoffPacket decoder(FriendlyByteBuf buffer) {
//            return new TaxiReadyForTakeoffPacket(buffer.readInt());
//        }
//
//        public static void handle(TaxiReadyForTakeoffPacket message, Supplier<NetworkEvent.Context> contextSupplier) {
//            NetworkEvent.Context context = contextSupplier.get();
//            context.enqueueWork(() -> {
//                ServerPlayer player = context.getSender();
//
//                if (player != null) {
//                    Entity entity = player.level.getEntity(message.taxiId);
//                    if (entity instanceof SpaceTaxi taxi) {
//
//                        taxi.setReadyForTakeoff();
//                    }
//                }
//            });
//            context.setPacketHandled(true);
//        }
//}
//
