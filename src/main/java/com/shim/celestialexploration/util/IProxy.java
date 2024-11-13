package com.shim.celestialexploration.util;

import net.minecraft.world.entity.player.Player;
import org.apache.logging.log4j.Level;

public interface IProxy {
    default Player getPlayer() {
        return null;
    }
}
