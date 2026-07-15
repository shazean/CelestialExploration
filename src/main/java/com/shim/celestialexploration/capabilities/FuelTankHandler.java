package com.shim.celestialexploration.capabilities;

import com.shim.celestialexploration.CelestialExploration;
import net.minecraft.nbt.CompoundTag;
import net.minecraftforge.fluids.FluidAttributes;

public class FuelTankHandler implements IFuelTank {
    private int fuelAmount;
    private int fullness;
    private final float SPEED_MODIFIER;
    private final int CAPACITY_MODIFIER;
    private final int CAPACITY;

    public FuelTankHandler(float speedModifier, int capacityModifier) {
        SPEED_MODIFIER = speedModifier;
        CAPACITY_MODIFIER = capacityModifier;
        CAPACITY = FluidAttributes.BUCKET_VOLUME * capacityModifier;
    }


    @Override
    public float getSpeedModifier() {
        return SPEED_MODIFIER;
    }

    @Override
    public int getTotalCapacity() {
        return CAPACITY;
    }

    protected int getCapacityModifier() {
        return this.CAPACITY_MODIFIER;
    }

    @Override
    public int getAmount() {
        return fuelAmount;
    }

    @Override
    public void setAmount(int amount) {
        fuelAmount = amount;
        int whatFullnessWillBe = (int) (((double) fuelAmount / (double) this.getTotalCapacity()) * this.getCapacityModifier());
        CelestialExploration.LOGGER.debug("fullness: " + fullness + ", will be: " + whatFullnessWillBe + " ((" + fuelAmount + " / " + this.getTotalCapacity() + ") * " + this.getCapacityModifier() + ")");
        fullness = (int) (((double) fuelAmount / (double)this.getTotalCapacity()) * this.getCapacityModifier());
    }

    @Override
    public void incrementAmount() {
        if (fuelAmount < this.getTotalCapacity()) {
            if (fuelAmount <= this.getTotalCapacity() - 1000) {
                fuelAmount += 1000;
                fullness = (int) (((double) fuelAmount / (double) this.getTotalCapacity()) * this.getCapacityModifier());
            } else {
                fuelAmount += this.getTotalCapacity() - fuelAmount;
            }
        }
    }

    @Override
    public void decrementAmount() {
        if (fuelAmount > 0) {
            fuelAmount -= 100;
            fullness = (int) (((double) fuelAmount / (double)this.getTotalCapacity()) * this.getCapacityModifier());
        } else {
        }
    }

    @Override
    public void decrementAmountByFifty() {
        if (fuelAmount > 0) {
            fuelAmount -= 50;
            fullness = (int) (((double) fuelAmount / (double)this.getTotalCapacity()) * this.getCapacityModifier());
        } else {
        }
    }

    @Override
    public void setFullness() {
        this.fullness = (int) (((double) fuelAmount / (double)this.getTotalCapacity()) * this.getCapacityModifier());
    }

    @Override
    public int getFullness() {
        fullness = (int) (((double) fuelAmount / (double)this.getTotalCapacity()) * this.getCapacityModifier());
        return fullness;
    }

    public boolean isFull() {
        return fuelAmount >= this.getTotalCapacity();
    }

    public boolean isEmpty() {
        return fuelAmount <= 0;
    }

    @Override
    public void setFuelData(CompoundTag nbt) {
        if (nbt.contains("amount")) this.fuelAmount = nbt.getInt("amount");
        if (nbt.contains("fullness")) this.fullness = nbt.getInt("fullness");
    }

    @Override
    public CompoundTag getFuelData() {
        CompoundTag fuelData = new CompoundTag();
        fuelData.putInt("amount", this.fuelAmount);
        fuelData.putInt("fullness", this.fullness);
        return fuelData;
    }
}