package com.shim.celestialexploration.world.portal;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.common.util.ITeleporter;

public class CelestialTeleporter implements ITeleporter {

    protected final ServerLevel level;

    public CelestialTeleporter(ServerLevel worldIn) {
        this.level = worldIn;
    }

    @Override
    public boolean playTeleportSound(ServerPlayer player, ServerLevel sourceWorld, ServerLevel destWorld) {
        return false;
    }
}