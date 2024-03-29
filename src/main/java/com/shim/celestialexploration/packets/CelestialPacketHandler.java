package com.shim.celestialexploration.packets;

import com.shim.celestialexploration.CelestialExploration;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.network.NetworkDirection;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.simple.SimpleChannel;

import java.util.Optional;

public class CelestialPacketHandler {

    int id = 0;

    private static final String PROTOCOL_VERSION = "1";
    public static final SimpleChannel INSTANCE = NetworkRegistry.newSimpleChannel(
            new ResourceLocation(CelestialExploration.MODID, "main"),
            () -> PROTOCOL_VERSION,
            PROTOCOL_VERSION::equals,
            PROTOCOL_VERSION::equals
    );


    public static void init() {
        int i = 0;
        INSTANCE.registerMessage(i++, SpaceshipFuelTickPacket.class, SpaceshipFuelTickPacket::encoder,
                SpaceshipFuelTickPacket::decoder, SpaceshipFuelTickPacket::handle, Optional.of(NetworkDirection.PLAY_TO_SERVER));

        INSTANCE.registerMessage(i++, SpaceshipFuelCapPacket.class, SpaceshipFuelCapPacket::encoder,
                SpaceshipFuelCapPacket::decoder, SpaceshipFuelCapPacket::handle, Optional.of(NetworkDirection.PLAY_TO_CLIENT));


    }
}
