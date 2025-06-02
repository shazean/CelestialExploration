package com.shim.celestialexploration.capabilities;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.Entity;

import java.util.ArrayList;

public class VehicleFlightHandler implements ISpaceFlight {
    private int teleportationCooldown = 60;
    ArrayList<Entity> teleportingEntities;

    @Override
    public boolean canSpaceTravel(Entity entity) {
        return true;
    }

    @Override
    public int getTeleportationCooldown() {
        return teleportationCooldown;
    }

    public void setTeleportationCooldown(int cooldown) {
        teleportationCooldown = cooldown;
    }

    @Override
    public void decrementTeleportationCooldown() {
        teleportationCooldown--;
    }

    @Override
    public void resetTeleportationCooldown() {
        teleportationCooldown = 60;
    }

    @Override
    public ArrayList<Entity> getAdditionalEntitiesToTeleport(Entity vehicle) {
        teleportingEntities = new ArrayList<>();

        if (vehicle.isVehicle()) teleportingEntities.addAll(vehicle.getPassengers());
        return teleportingEntities;
    }

    @Override
    public boolean isTeleportHeight(Entity entity) {
        return entity.position().y >= entity.level.getMaxBuildHeight() + 10;
    }

    @Override
    public CompoundTag getData() {
        CompoundTag nbt = new CompoundTag();
        nbt.putInt("cooldown", this.teleportationCooldown);

        return nbt;
    }

    @Override
    public void setData(CompoundTag nbt) {
        if (nbt.contains("cooldown")) this.teleportationCooldown = nbt.getInt("cooldown");
    }

}