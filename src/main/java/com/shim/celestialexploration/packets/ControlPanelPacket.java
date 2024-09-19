//package com.shim.celestialexploration.packets;
//
//import com.shim.celestialexploration.entity.ControlPanel;
//import net.minecraft.client.multiplayer.ClientLevel;
//import net.minecraft.core.BlockPos;
//import net.minecraft.core.Direction;
//import net.minecraft.core.Registry;
//import net.minecraft.network.FriendlyByteBuf;
//import net.minecraft.network.protocol.Packet;
//import net.minecraft.world.entity.decoration.Motive;
//import net.minecraftforge.network.NetworkEvent;
//
//import java.util.UUID;
//import java.util.function.Supplier;
//
//public class ControlPanelPacket implements Packet<CelestialClientPacketListener> {
//    private final int id;
//    private final UUID uuid;
//    private final BlockPos pos;
//    private final Direction direction;
//    private final int motive;
//
//    public ControlPanelPacket(ControlPanel panel) {
//        this.id = panel.getId();
//        this.uuid = panel.getUUID();
//        this.pos = panel.getPos();
//        this.direction = panel.getDirection();
//        this.motive = Registry.MOTIVE.getId(panel.motive);
//    }
//
//    public ControlPanelPacket(FriendlyByteBuf buffer) {
//        this.id = buffer.readVarInt();
//        this.uuid = buffer.readUUID();
//        this.motive = buffer.readVarInt();
//        this.pos = buffer.readBlockPos();
//        this.direction = Direction.from2DDataValue(buffer.readUnsignedByte());
//    }
//
//    public ControlPanelPacket(int id, UUID uuid, BlockPos pos, Direction direction, int motive) {
//        this.id = id;
//        this.uuid = uuid;
//        this.pos = pos;
//        this.direction = direction;
//        this.motive = motive;
//
//    }
//
//    public static ControlPanelPacket decoder(FriendlyByteBuf buffer) {
//        return new ControlPanelPacket(buffer.readVarInt(), buffer.readUUID(), buffer.readBlockPos(), Direction.from2DDataValue(buffer.readUnsignedByte()), buffer.readVarInt());
//    }
//
//    public void write(FriendlyByteBuf buffer) {
//        buffer.writeVarInt(this.id);
//        buffer.writeUUID(this.uuid);
//        buffer.writeVarInt(this.motive);
//        buffer.writeBlockPos(this.pos);
//        buffer.writeByte(this.direction.get2DDataValue());
//    }
//
//    @Override
//    public void handle(CelestialClientPacketListener packetListener) {
//        packetListener.handleAddControlPanel(this);
//    }
//
////    @Override
////    public void handle(ClientGamePacketListener packetListener) {
////
////        packetListener.handleAddPainting(this);
////
//////        handle(this, packetListener);
////    }
//
//
//    public static void handle(ControlPanelPacket message, Supplier<NetworkEvent.Context> contextSupplier) {
//        NetworkEvent.Context context = contextSupplier.get();
//        context.enqueueWork(() -> {
//
//            if (context.getSender() != null && context.getSender().level.isClientSide) {
//                ClientLevel level = (ClientLevel) context.getSender().level;
//
//                ControlPanel panel = new ControlPanel(level, message.getPos(), message.getDirection(), message.getMotive());
//                panel.setId(message.getId());
//                panel.setUUID(message.getUUID());
//
//                level.putNonPlayerEntity(message.getId(), panel);
//
//            }
////            ServerPlayer player = context.getSender();
////            if (player != null) {
////                Entity entity = player.level.getEntity(message.spaceshipId);
////                if (entity instanceof Spaceship spaceship) {
////                    spaceship.decrementFuelTicks();
////                }
////            }
//        });
//        context.setPacketHandled(true);
//    }
//
////    public void handle(ClientGamePacketListener p_131579_) {
////
////        PacketUtils.ensureRunningOnSameThread(this, this, this.minecraft);
////        Painting painting = new Painting(this.level, this.getPos(), this.getDirection(), this.getMotive());
////        painting.setId(this.getId());
////        painting.setUUID(this.getUUID());
////        this.level.putNonPlayerEntity(this.getId(), painting);
//////        p_131579_.handleAddPainting(this);
////    }
//
//    public int getId() {
//        return this.id;
//    }
//
//    public UUID getUUID() {
//        return this.uuid;
//    }
//
//    public BlockPos getPos() {
//        return this.pos;
//    }
//
//    public Direction getDirection() {
//        return this.direction;
//    }
//
//    public Motive getMotive() {
//        return Registry.MOTIVE.byId(this.motive);
//    }
//}
