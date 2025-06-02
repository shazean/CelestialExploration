package com.shim.celestialexploration.capabilities;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.Entity;

import java.util.ArrayList;

/**
 * For an example…
 * @see VehicleFlightHandler
 */
public interface ISpaceFlight {
    /**
     * Checks if entity is allowed/capable of space travel.
     * Can be used to check for certain equipment, etc.
     * @param entity The entity to do the check on
     **/
    boolean canSpaceTravel(Entity entity);

    int getTeleportationCooldown();
    void setTeleportationCooldown(int cooldown);
    void decrementTeleportationCooldown();
    void resetTeleportationCooldown();

    /**
     * Check if entity should be bringing additional entities with, i.e. passengers
     * @param entity The entity to do the check on
     * @return ArrayList of all additional entities, excluding self
     */
    ArrayList<Entity> getAdditionalEntitiesToTeleport(Entity entity);

    boolean isTeleportHeight(Entity entity);

    CompoundTag getData();
    void setData(CompoundTag nbt);
}