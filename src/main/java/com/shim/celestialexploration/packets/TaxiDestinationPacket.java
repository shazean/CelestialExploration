//package com.shim.celestialexploration.packets;
//
//import com.shim.celestialexploration.entity.vehicle.SpaceTaxi;
//import net.minecraft.core.BlockPos;
//import net.minecraft.core.Registry;
//import net.minecraft.network.FriendlyByteBuf;
//import net.minecraft.resources.ResourceKey;
//import net.minecraft.resources.ResourceLocation;
//import net.minecraft.server.level.ServerPlayer;
//import net.minecraft.world.entity.Entity;
//import net.minecraft.world.level.Level;
//import net.minecraftforge.network.NetworkEvent;
//
//import java.util.function.Supplier;
//
//public class TaxiDestinationPacket {
//    int taxiId;
//    BlockPos pos;
//    ResourceKey<Level> dimensionId;
//
//    public TaxiDestinationPacket(int taxiId, BlockPos pos, ResourceLocation dimensionId) {
//        this(taxiId, pos, ResourceKey.create(Registry.DIMENSION_REGISTRY, dimensionId));
//    }
//
//    public TaxiDestinationPacket(int taxiId, BlockPos pos, ResourceKey<Level> dimensionId) {
//        this.taxiId = taxiId;
//        this.pos = pos;
//        this.dimensionId = dimensionId;
//    }
//
//        public static void encoder(TaxiDestinationPacket packet, FriendlyByteBuf buffer) {
//            buffer.writeInt(packet.taxiId);
//            buffer.writeBlockPos(packet.pos);
//            buffer.writeResourceLocation(packet.dimensionId.location());
//
//        }
//
//        public static TaxiDestinationPacket decoder(FriendlyByteBuf buffer) {
//            return new TaxiDestinationPacket(buffer.readInt(), buffer.readBlockPos(), buffer.readResourceLocation());
//        }
//
//        public static void handle(TaxiDestinationPacket message, Supplier<NetworkEvent.Context> contextSupplier) {
//            NetworkEvent.Context context = contextSupplier.get();
//            context.enqueueWork(() -> {
//                ServerPlayer player = context.getSender();
//
//                if (player != null) {
//                    Entity entity = player.level.getEntity(message.taxiId);
//                    if (entity instanceof SpaceTaxi taxi) {
//
//                            taxi.setDestination(message.pos, message.dimensionId);
//
//                    }
//                }
//            });
//            context.setPacketHandled(true);
//        }
//}
//
