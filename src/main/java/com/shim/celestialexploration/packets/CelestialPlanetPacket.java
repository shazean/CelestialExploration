package com.shim.celestialexploration.packets;

import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestialexploration.util.CelestialUtil;
import net.minecraft.core.Registry;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.network.NetworkEvent;

import java.util.List;
import java.util.function.Supplier;

public class CelestialPlanetPacket {

    final ResourceKey<Level> dimension;
    final Vec3 location;

    public CelestialPlanetPacket(ResourceLocation dimensionLoc, double x, double y, double z) {
        this(ResourceKey.create(Registry.DIMENSION_REGISTRY, dimensionLoc), new Vec3(x, y, z));
    }

    public CelestialPlanetPacket(ResourceKey<Level> dimension, Vec3 location) {
        this.dimension = dimension;
        this.location = location;
    }

    public static void encoder(CelestialPlanetPacket packet, FriendlyByteBuf buffer) {
        buffer.writeResourceLocation(packet.dimension.location());
        buffer.writeDouble(packet.location.x);
        buffer.writeDouble(packet.location.y);
        buffer.writeDouble(packet.location.z);
    }

    public static CelestialPlanetPacket decoder(FriendlyByteBuf buffer) {
        return new CelestialPlanetPacket(buffer.readResourceLocation(), buffer.readDouble(), buffer.readDouble(), buffer.readDouble());
    }

    public static void handle(CelestialPlanetPacket message, Supplier<NetworkEvent.Context> contextSupplier) {
        NetworkEvent.Context context = contextSupplier.get();
        context.enqueueWork(() -> {
            Player player = CelestialExploration.PROXY.getPlayer();

            if (player != null) {

                CelestialUtil.setPlanetLocation(message.dimension, message.location);

            }
        });
        context.setPacketHandled(true);
    }
}