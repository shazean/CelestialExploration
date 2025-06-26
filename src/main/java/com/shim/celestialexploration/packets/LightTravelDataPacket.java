package com.shim.celestialexploration.packets;

import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestialexploration.capabilities.LightTravelCapability;
import com.shim.celestialexploration.registry.CelestialCapabilities;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class LightTravelDataPacket {

    private final int playerId;
    private final CompoundTag travelData;

    public LightTravelDataPacket(int playerId, CompoundTag travelData) {
        this.playerId = playerId;
        this.travelData = travelData;
    }

    public static void encoder(LightTravelDataPacket packet, FriendlyByteBuf buffer) {
        buffer.writeInt(packet.playerId);
        buffer.writeNbt(packet.travelData);
    }

    public static LightTravelDataPacket decoder(FriendlyByteBuf buffer) {
        return new LightTravelDataPacket(buffer.readInt(), buffer.readNbt());
    }

    public static void handle(LightTravelDataPacket message, Supplier<NetworkEvent.Context> contextSupplier) {
        NetworkEvent.Context context = contextSupplier.get();
        context.enqueueWork(() -> {
//            ServerPlayer player = context.getSender();
            Player player;

            player = CelestialExploration.PROXY.getPlayer();

            if (player != null) {
                LightTravelCapability.ILightTravel travelCap = CelestialExploration.getCapability(player, CelestialCapabilities.LIGHT_TRAVEL_CAPABILITY);

                if (travelCap != null) {
                    travelCap.setData(message.travelData);
                }
            }
        });
        context.setPacketHandled(true);
    }
}