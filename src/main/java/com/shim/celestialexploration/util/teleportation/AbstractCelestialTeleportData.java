package com.shim.celestialexploration.util.teleportation;

import net.minecraft.world.phys.Vec3;

public abstract class AbstractCelestialTeleportData {
    public abstract Vec3 getOutputCoordinates(int x, int z);
}
