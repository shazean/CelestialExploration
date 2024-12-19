package com.shim.celestialexploration.packets;

import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestialexploration.capabilities.LightTravelCapability;
import com.shim.celestialexploration.registry.CapabilityRegistry;
import com.shim.celestialexploration.registry.DimensionRegistry;
import net.minecraft.core.Registry;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class ServerResetLightTravelPacket {

    private final int playerId;
    private final ResourceKey<Level> dimension;

    public ServerResetLightTravelPacket(int playerId, ResourceLocation dimensionLoc) {
        this(playerId, ResourceKey.create(Registry.DIMENSION_REGISTRY, dimensionLoc));
    }

    public ServerResetLightTravelPacket(int playerId, ResourceKey<Level> dimension) {
        this.playerId = playerId;
        this.dimension = dimension;
    }

    public static void encoder(ServerResetLightTravelPacket packet, FriendlyByteBuf buffer) {
        buffer.writeInt(packet.playerId);
        buffer.writeResourceLocation(packet.dimension.location());
    }

    public static ServerResetLightTravelPacket decoder(FriendlyByteBuf buffer) {
        return new ServerResetLightTravelPacket(buffer.readInt(), buffer.readResourceLocation());
    }

    public static void handle(ServerResetLightTravelPacket message, Supplier<NetworkEvent.Context> contextSupplier) {
        NetworkEvent.Context context = contextSupplier.get();
        context.enqueueWork(() -> {
            ServerPlayer serverPlayer = context.getSender();

            if (serverPlayer != null) {

                Entity player = serverPlayer.level.getEntity(message.playerId);

                LightTravelCapability.ILightTravel travelCap = CelestialExploration.getCapability(player, CapabilityRegistry.LIGHT_TRAVEL_CAPABILITY);

                if (travelCap != null) {
                    if (message.dimension.equals(DimensionRegistry.MERCURY))
                        travelCap.getMercuryCooldown().resetCooldown();
                    if (message.dimension.equals(DimensionRegistry.VENUS))
                        travelCap.getVenusCooldown().resetCooldown();
                    if (message.dimension.equals(Level.OVERWORLD))
                        travelCap.getOverworldCooldown().resetCooldown();
                    if (message.dimension.equals(DimensionRegistry.MARS))
                        travelCap.getMarsCooldown().resetCooldown();
                    if (message.dimension.equals(DimensionRegistry.JUPITER))
                        travelCap.getJupiterCooldown().resetCooldown();

                    travelCap.sync((Player) player);

                }
            }
        });
        context.setPacketHandled(true);
    }
}