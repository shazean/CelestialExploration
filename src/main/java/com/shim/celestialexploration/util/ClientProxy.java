package com.shim.celestialexploration.util;

import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.player.Player;

public class ClientProxy implements IProxy{

    @Override
    public Player getPlayer() {
        return Minecraft.getInstance().player;
    }
}