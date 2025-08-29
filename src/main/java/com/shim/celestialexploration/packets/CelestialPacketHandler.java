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

        INSTANCE.registerMessage(i++, SpaceFlightPacket.class, SpaceFlightPacket::encoder,
                SpaceFlightPacket::decoder, SpaceFlightPacket::handle, Optional.of(NetworkDirection.PLAY_TO_CLIENT));

        INSTANCE.registerMessage(i++, SpaceshipInventoryPacket.class, SpaceshipInventoryPacket::encoder,
                SpaceshipInventoryPacket::decoder, SpaceshipInventoryPacket::handle, Optional.of(NetworkDirection.PLAY_TO_SERVER));

        INSTANCE.registerMessage(i++, LightTravelDataPacket.class, LightTravelDataPacket::encoder,
                LightTravelDataPacket::decoder, LightTravelDataPacket::handle, Optional.of(NetworkDirection.PLAY_TO_CLIENT));

        INSTANCE.registerMessage(i++, TaxiPassengersPacket.class, TaxiPassengersPacket::encoder,
                TaxiPassengersPacket::decoder, TaxiPassengersPacket::handle, Optional.of(NetworkDirection.PLAY_TO_SERVER));

        INSTANCE.registerMessage(i++, TaxiDestinationPacket.class, TaxiDestinationPacket::encoder,
                TaxiDestinationPacket::decoder, TaxiDestinationPacket::handle, Optional.of(NetworkDirection.PLAY_TO_SERVER));

        INSTANCE.registerMessage(i++, TaxiReadyForTakeoffPacket.class, TaxiReadyForTakeoffPacket::encoder,
                TaxiReadyForTakeoffPacket::decoder, TaxiReadyForTakeoffPacket::handle, Optional.of(NetworkDirection.PLAY_TO_SERVER));

        INSTANCE.registerMessage(i++, TaxiAscensionTicksPacket.class, TaxiAscensionTicksPacket::encoder,
                TaxiAscensionTicksPacket::decoder, TaxiAscensionTicksPacket::handle, Optional.of(NetworkDirection.PLAY_TO_SERVER));

        INSTANCE.registerMessage(i++, DoLightTravelPacket.class, DoLightTravelPacket::encoder,
                DoLightTravelPacket::decoder, DoLightTravelPacket::handle, Optional.of(NetworkDirection.PLAY_TO_SERVER));

        INSTANCE.registerMessage(i++, ServerDidLightTravelPacket.class, ServerDidLightTravelPacket::encoder,
                ServerDidLightTravelPacket::decoder, ServerDidLightTravelPacket::handle, Optional.of(NetworkDirection.PLAY_TO_CLIENT));

        INSTANCE.registerMessage(i++, ServerResetLightTravelPacket.class, ServerResetLightTravelPacket::encoder,
                ServerResetLightTravelPacket::decoder, ServerResetLightTravelPacket::handle, Optional.of(NetworkDirection.PLAY_TO_SERVER));


//        INSTANCE.registerMessage(i++, ControlPanelPacket.class, ControlPanelPacket::write,
//                ControlPanelPacket::decoder, ControlPanelPacket::handle, Optional.of(NetworkDirection.PLAY_TO_SERVER));
    }
}