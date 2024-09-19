package com.shim.celestialexploration.capabilities;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.Entity;

import java.util.ArrayList;

public interface ISpaceFlight {
    boolean canSpaceTravel();
    int getTeleportationCooldown();
    void setTeleportationCooldown(int cooldown);
    void decrementTeleportationCooldown();
    void resetTeleportationCooldown();
    ArrayList<Entity> getAdditionalEntitiesToTeleport(Entity entity);
    boolean isTeleportHeight(Entity entity);
    CompoundTag getData();
    void setData(CompoundTag nbt);
}