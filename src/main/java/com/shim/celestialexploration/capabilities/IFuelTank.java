package com.shim.celestialexploration.capabilities;

import net.minecraft.nbt.CompoundTag;

public interface IFuelTank {
    int getAmount();

    void setAmount(int amount);

    void incrementAmount();

    void decrementAmount();

    void decrementAmountByFifty();

    CompoundTag getFuelData();

    void setFullness();

    int getFullness();

    boolean isFull();

    boolean isEmpty();

    void setFuelData(CompoundTag nbt);

    int getTotalCapacity();

    float getSpeedModifier();
}