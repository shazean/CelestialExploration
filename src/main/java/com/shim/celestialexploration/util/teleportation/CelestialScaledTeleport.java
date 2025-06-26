package com.shim.celestialexploration.util.teleportation;

import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestialexploration.util.CelestialUtil;
import net.minecraft.world.phys.Vec3;

public class CelestialScaledTeleport extends AbstractCelestialTeleportData {
    double scale;

    public CelestialScaledTeleport(double scale) {
        this.scale = scale;
    }

    @Override
    public Vec3 getOutputCoordinates(int x, int z) {
        return new Vec3(x * scale, 0, z * scale);
    }
}