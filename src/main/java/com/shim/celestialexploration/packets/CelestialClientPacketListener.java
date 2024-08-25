package com.shim.celestialexploration.packets;

import net.minecraft.network.PacketListener;
import net.minecraft.network.protocol.game.ClientboundAddPaintingPacket;

public interface CelestialClientPacketListener extends PacketListener {

    void handleAddControlPanel(ControlPanelPacket packet);
}
