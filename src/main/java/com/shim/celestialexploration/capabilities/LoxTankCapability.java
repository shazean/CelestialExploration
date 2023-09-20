package com.shim.celestialexploration.capabilities;

import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestialexploration.registry.CapabilityRegistry;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.fluids.FluidAttributes;
import net.minecraftforge.fluids.capability.CapabilityFluidHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class LoxTankCapability {
    public interface ILoxTank {
        public int getAmount();
        public void setAmount(int amount);
        public boolean incrementAmount();
        public boolean decrementAmount();
        CompoundTag getLoxData();
        public void setFullness();
        public int getFullness();
        public boolean isFull();
        public boolean isEmpty();
        void setLoxData(CompoundTag nbt);
    }

    public static class LoxTankHandler implements ILoxTank {
        private int loxAmount;
        private int fullness;
        private static final int DEFAULT_CAPACITY = FluidAttributes.BUCKET_VOLUME * 8;

        @Override
        public int getAmount() {
            return loxAmount;
        }

        @Override
        public void setAmount(int amount) {
            loxAmount = amount;
            fullness = (int) (((double)loxAmount / (double)DEFAULT_CAPACITY) * 8);
        }

        @Override
        public boolean incrementAmount() {
            if (loxAmount < DEFAULT_CAPACITY) {
                loxAmount += 1000;
                fullness = (int) (((double)loxAmount / (double)DEFAULT_CAPACITY) * 8);
                return true;
            } else {
                return false;
            }
        }

        @Override
        public boolean decrementAmount() {
            if (loxAmount > 0) {
                loxAmount -= 100;
                fullness = (int) (((double)loxAmount / (double)DEFAULT_CAPACITY) * 8);
                return true;
            } else {
                return false;
            }
        }

        @Override
        public CompoundTag getLoxData() {
            CompoundTag loxData = new CompoundTag();
            loxData.putInt("amount", this.loxAmount);
            loxData.putInt("fullness", this.fullness);
            return loxData;
        }

        @Override
        public void setFullness() {
//            this.fullness = fullness;
            this.fullness = (int) (((double)loxAmount / (double)DEFAULT_CAPACITY) * 8);
        }

        @Override
        public int getFullness() {
            fullness = (int) (((double)loxAmount / (double)DEFAULT_CAPACITY) * 8);
            return fullness;
        }

        public boolean isFull() {
            return (loxAmount >= DEFAULT_CAPACITY) ?  true :  false;
        }

        public boolean isEmpty() {
            return (loxAmount <= 0) ?  true :  false;
        }



        @Override
        public void setLoxData(CompoundTag nbt) {
            if (nbt.contains("amount")) this.loxAmount = nbt.getInt("amount");
            if (nbt.contains("fullness")) this.fullness = nbt.getInt("fullness");
        }
    }

    public static class LoxTankCapabilityProvider implements ICapabilityProvider, ICapabilitySerializable<CompoundTag> {
        private final LazyOptional<ILoxTank> loxTank = LazyOptional.of(LoxTankHandler::new);

        @NotNull
        @Override
        public <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
            return CapabilityRegistry.LOX_TANK_CAPABILITY.orEmpty(cap, loxTank.cast());
        }

        @Override
        public CompoundTag serializeNBT() {
            return loxTank.orElseThrow(NullPointerException::new).getLoxData();
        }

        @Override
        public void deserializeNBT(CompoundTag nbt) {
            loxTank.orElseThrow(NullPointerException::new).setLoxData(nbt);
        }
    }
}