package com.shim.celestialexploration.capabilities;

import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestialexploration.registry.CapabilityRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Registry;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.capabilities.*;
import net.minecraftforge.common.util.LazyOptional;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.List;

public class TaxiCapability {
    public interface ITaxi {
        List<TaxiStationData> getTaxiStations();
        void addTaxiStations(TaxiStationData data);
        void removeTaxiStations(TaxiStationData data);
        void removeTaxiStations(BlockPos pos);
        boolean existsAtThisPos(BlockPos pos);
        CompoundTag getData();
        void setData(CompoundTag nbt);
    }

    public record TaxiStationData(BlockPos pos, ResourceKey<Level> dimension, Component name) {

        @Override
        public String toString() {
            return name.getString() + ", at " + pos + " in " + dimension;
        }
    }

    public static class TaxiHandler implements ITaxi {
        private final List<TaxiStationData> taxiStationData = new ArrayList<>();

        @Override
        public List<TaxiStationData> getTaxiStations() {
            return taxiStationData;
        }

        @Override
        public void addTaxiStations(TaxiStationData data) {
            taxiStationData.add(data);
            for (TaxiStationData taxiStationDatum : taxiStationData) {
                CelestialExploration.LOGGER.debug(taxiStationDatum.toString());
            }
        }

        @Override
        public void removeTaxiStations(TaxiStationData data) {
            taxiStationData.remove(data);
        }

        @Override
        public void removeTaxiStations(BlockPos pos) {
            ChunkPos chunkPos = new ChunkPos(pos);
            for (TaxiStationData taxiStationDatum : taxiStationData) {
                ChunkPos chunkToCheck = new ChunkPos(taxiStationDatum.pos());
                if (chunkToCheck.equals(chunkPos))
                    taxiStationData.remove(taxiStationDatum);
            }
        }

        @Override
        public boolean existsAtThisPos(BlockPos pos) {
            ChunkPos chunkPos = new ChunkPos(pos);
            for (TaxiStationData taxiStationDatum : taxiStationData) {
                ChunkPos chunkToCheck = new ChunkPos(taxiStationDatum.pos());
                if (chunkToCheck.equals(chunkPos))
                    return true;
            }
            return false;
        }

        @Override
        public CompoundTag getData() {
            CompoundTag nbt = new CompoundTag();
            nbt.putInt("size", this.taxiStationData.size());
            for (int i = 0; i < this.taxiStationData.size(); i++) {
                nbt.putInt("x_" + i, this.taxiStationData.get(i).pos().getX());
                nbt.putInt("y_" + i, this.taxiStationData.get(i).pos().getY());
                nbt.putInt("z_" + i, this.taxiStationData.get(i).pos().getZ());

                nbt.putString("dimension_" + i, this.taxiStationData.get(i).dimension().location().getPath());

                nbt.putString("name_" + i, this.taxiStationData.get(i).name().getString());

                CelestialExploration.LOGGER.debug("saving! i:" + i + ", xyz: " + nbt.getInt("x_" + i) + "/" + nbt.getInt("y_" + i) + "/" + nbt.getInt("z_" + i) +
                        ", dimension: " + nbt.getString("dimension_" + i) + ", name: " + nbt.getString("name_" + i));

            }
            return nbt;
        }

        @Override
        public void setData(CompoundTag nbt) {
            int size;
            if (nbt.contains("size")) {

                size = nbt.getInt("size");
                CelestialExploration.LOGGER.debug("loading! size: " + size);

                for (int i = 0; i < size; i++) {
                    int x = 0;
                    int y = 0;
                    int z = 0;
                    if (nbt.contains("x_" + i)) x = nbt.getInt("x_" + i);
                    if (nbt.contains("y_" + i)) y = nbt.getInt("y_" + i);
                    if (nbt.contains("z_" + i)) z = nbt.getInt("z_" + i);
                    BlockPos pos = new BlockPos(x, y, z);

                    String dimensionString = null;
                    if (nbt.contains("dimension_" + i)) dimensionString = nbt.getString("dimension_" + i);
                    if (dimensionString != null) {
                        ResourceKey<Level> dimension = ResourceKey.create(Registry.DIMENSION_REGISTRY, new ResourceLocation(dimensionString));

                        Component name = null;
                        if (nbt.contains("name_" + i)) name = new TextComponent(nbt.getString("name_" + i));

                        if (name != null) {
                            this.taxiStationData.add(new TaxiStationData(pos, dimension, name));

                            CelestialExploration.LOGGER.debug("loading! i:" + i + ", xyz: " + nbt.getInt("x_" + i) + "/" + nbt.getInt("y_" + i) + "/" + nbt.getInt("z_" + i) +
                                    ", dimension: " + nbt.getString("dimension_" + i) + ", name: " + nbt.getString("name_" + i));

                        }
                    }
                }
            }
        }
    }

    public static class TaxiProvider implements ICapabilityProvider, ICapabilitySerializable<CompoundTag> {

        public static Capability<TaxiCapability.TaxiHandler> TAXI = CapabilityManager.get(new CapabilityToken<>() {
        });
        private TaxiCapability.TaxiHandler taxiHandler = null;
        private final LazyOptional<TaxiCapability.TaxiHandler> lazyTaxi = LazyOptional.of(this::createHandler);

        @Nonnull
        private TaxiCapability.TaxiHandler createHandler() {
            if (taxiHandler == null) {
                taxiHandler = new TaxiCapability.TaxiHandler();
            }
            return taxiHandler;
        }

        @NotNull
        @Override
        public <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
            return CapabilityRegistry.TAXI_CAPABILITY.orEmpty(cap, lazyTaxi.cast());
        }

        @Override
        public CompoundTag serializeNBT() {
            return lazyTaxi.orElseThrow(NullPointerException::new).getData();
        }

        @Override
        public void deserializeNBT(CompoundTag nbt) {
            lazyTaxi.orElseThrow(NullPointerException::new).setData(nbt);
        }
    }
}