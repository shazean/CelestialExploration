package com.shim.celestialexploration.capabilities;

import com.shim.celestialexploration.registry.CapabilityRegistry;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.Tag;
import net.minecraftforge.common.capabilities.*;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.fluids.FluidAttributes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.annotation.Nonnull;

public class LoxTankCapability {
    public interface ILoxTank {
        public int getAmount();
        public void setAmount(int amount);
        public void incrementAmount();
        public void decrementAmount();
        public void decrementAmountByFifty();
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
        public void incrementAmount() {
            if (loxAmount < DEFAULT_CAPACITY) {
                loxAmount += 1000;
                fullness = (int) (((double)loxAmount / (double)DEFAULT_CAPACITY) * 8);
            } else {
            }
        }

        @Override
        public void decrementAmount() {
            if (loxAmount > 0) {
                loxAmount -= 100;
                fullness = (int) (((double)loxAmount / (double)DEFAULT_CAPACITY) * 8);
            } else {
            }
        }

        @Override
        public void decrementAmountByFifty() {
            if (loxAmount > 0) {
                loxAmount -= 50;
                fullness = (int) (((double)loxAmount / (double)DEFAULT_CAPACITY) * 8);
            } else {
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
            return loxAmount >= DEFAULT_CAPACITY;
        }

        public boolean isEmpty() {
            return loxAmount <= 0;
        }

        @Override
        public void setLoxData(CompoundTag nbt) {
            if (nbt.contains("amount")) this.loxAmount = nbt.getInt("amount");
            if (nbt.contains("fullness")) this.fullness = nbt.getInt("fullness");
        }
    }

    public static class LoxTankCapabilityProvider implements ICapabilityProvider, ICapabilitySerializable<CompoundTag> {

        public static Capability<LoxTankHandler> LOX_TANK = CapabilityManager.get(new CapabilityToken<>(){});
        private LoxTankHandler loxTankHandler = null;
        private final LazyOptional<LoxTankHandler> lazyLoxTank = LazyOptional.of(this::createLoxHandler);

        @Nonnull
        private LoxTankHandler createLoxHandler() {
            if (loxTankHandler == null) {
                loxTankHandler = new LoxTankHandler();
            }
            return loxTankHandler;
        }

        @NotNull
        @Override
        public <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
            return CapabilityRegistry.LOX_TANK_CAPABILITY.orEmpty(cap, lazyLoxTank.cast());
        }

        @Override
        public CompoundTag serializeNBT() {
            return lazyLoxTank.orElseThrow(NullPointerException::new).getLoxData();
        }

        @Override
        public void deserializeNBT(CompoundTag nbt) {
            lazyLoxTank.orElseThrow(NullPointerException::new).setLoxData(nbt);
        }
    }
}