package com.shim.celestialexploration.util.teleportation;

import com.shim.celestialexploration.util.CelestialUtil;
import net.minecraft.world.phys.Vec3;

public class CelestialCoordinateTeleport extends AbstractCelestialTeleportData {
    Vec3 coordinates;

    public CelestialCoordinateTeleport(int x, int z) {
        this.coordinates = new Vec3(x, 0, z);
    }

    @Override
    public Vec3 getOutputCoordinates(int x, int z) {
        return new Vec3(this.coordinates.x * CelestialUtil.getSpaceRatio(), this.coordinates.y * CelestialUtil.getSpaceRatio(), this.coordinates.z * CelestialUtil.getSpaceRatio());
    }
}
