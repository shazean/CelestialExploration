package com.shim.celestialexploration.packets;

import com.shim.celestialexploration.entity.entity.vehicle.Spaceship;
import com.shim.celestialexploration.util.CelestialUtil;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Registry;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.Level;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class DoLightTravelPacket {

    private final int spaceshipId;
    private final int passengerOneId;
    private final int passengerTwoId;
//    private final BlockPos destinationPos;
    private final ResourceKey<Level> dimension;

    public DoLightTravelPacket(int spaceshipId, int passengerOneId, int passengerTwoId, ResourceLocation dimensionLoc) {
        this(spaceshipId, passengerOneId, passengerTwoId, ResourceKey.create(Registry.DIMENSION_REGISTRY, dimensionLoc));
    }

    public DoLightTravelPacket(int spaceshipId, int passengerOneId, int passengerTwoId, ResourceKey<Level> dimension) {

//    public DoLightTravelPacket(int spaceshipId, int passengerOneId, int passengerTwoId, BlockPos destinationPos) {
        this.spaceshipId = spaceshipId;
        this.passengerOneId = passengerOneId;
        this.passengerTwoId = passengerTwoId;
        this.dimension = dimension;
    }

    public static void encoder(DoLightTravelPacket packet, FriendlyByteBuf buffer) {
        buffer.writeInt(packet.spaceshipId);
        buffer.writeInt(packet.passengerOneId);
        buffer.writeInt(packet.passengerTwoId);
        buffer.writeResourceLocation(packet.dimension.location());
    }

    public static DoLightTravelPacket decoder(FriendlyByteBuf buffer) {
        return new DoLightTravelPacket(buffer.readInt(), buffer.readInt(), buffer.readInt(), buffer.readResourceLocation());
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

                    ChunkPos chunkPos = new ChunkPos((int) CelestialUtil.getPlanetaryChunkCoordinates(message.dimension).x(), (int) CelestialUtil.getPlanetaryChunkCoordinates(message.dimension).z());
                    BlockPos pos = chunkPos.getMiddleBlockPosition(0);

                    spaceship.doLightTravel(passengerOne, passengerTwo, pos, serverPlayer);
                }
            }
        });
        context.setPacketHandled(true);
    }
}