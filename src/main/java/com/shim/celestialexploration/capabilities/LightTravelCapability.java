package com.shim.celestialexploration.capabilities;

import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestialexploration.config.CelestialCommonConfig;
import com.shim.celestialexploration.packets.CelestialPacketHandler;
import com.shim.celestialexploration.packets.LightTravelDataPacket;
import com.shim.celestialexploration.registry.CelestialCapabilities;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.common.capabilities.*;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.network.PacketDistributor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.annotation.Nonnull;

public class LightTravelCapability {
    public interface ILightTravel {
        boolean hasBeenToSpace();
        boolean hasBeenToMars();
        boolean hasBeenToVenus();
        boolean hasBeenToMercury();
        boolean hasBeenToJupiter();

        void setBeenToSpace();
        void setBeenToMars();
        void setBeenToVenus();
        void setBeenToMercury();
        void setBeenToJupiter();

        PlanetCooldown getOverworldCooldown();
        PlanetCooldown getMarsCooldown();
        PlanetCooldown getVenusCooldown();
        PlanetCooldown getMercuryCooldown();
        PlanetCooldown getJupiterCooldown();

        void sync(Player player);

        CompoundTag getData();
        void setData(CompoundTag nbt);
    }

    public static class PlanetCooldown {
        int currentCooldown;
        int numTimesReset;

        public PlanetCooldown() {
            this.currentCooldown = 0;
            this.numTimesReset = 0;
        }

        public void resetCooldown() {
//            this.numTimesReset = 0;
            this.currentCooldown = CelestialCommonConfig.SPACESHIP_LIGHT_TRAVEL_MAX_COOLDOWN.get() - (CelestialCommonConfig.SPACESHIP_LIGHT_TRAVEL_COOLDOWN_DECREMENT.get() * this.numTimesReset);
            if (this.currentCooldown < CelestialCommonConfig.SPACESHIP_LIGHT_TRAVEL_MIN_COOLDOWN.get()) this.currentCooldown = CelestialCommonConfig.SPACESHIP_LIGHT_TRAVEL_MIN_COOLDOWN.get();
            CelestialExploration.LOGGER.debug("maxCooldown: " + CelestialCommonConfig.SPACESHIP_LIGHT_TRAVEL_MAX_COOLDOWN.get() +
                    ", cooldownDecrement: " + CelestialCommonConfig.SPACESHIP_LIGHT_TRAVEL_COOLDOWN_DECREMENT.get() +
                    ", timesReset: " + numTimesReset +
                    ", totalDecrement: " + (CelestialCommonConfig.SPACESHIP_LIGHT_TRAVEL_COOLDOWN_DECREMENT.get() * this.numTimesReset));
            this.numTimesReset++;
        }

        public int getCurrentCooldown() {
            return this.currentCooldown;
        }

        public boolean isCooldownEnded() {
            return this.currentCooldown == 0;
        }

        public void decrementCooldown() {
            if (this.currentCooldown > 0) {
                this.currentCooldown--;
//                CelestialExploration.LOGGER.debug("cooldown: " + this.currentCooldown + " m:" + ((this.currentCooldown / 20) / 60) + ", s: " + ((this.currentCooldown / 20) % 60));
            }
        }

        public String getFormattedCooldown() {
            int minutes;
            int seconds;
            String cooldown;

            minutes = (this.currentCooldown / 20) / 60;
            seconds = (this.currentCooldown / 20) % 60;

            cooldown = minutes + "m " + seconds + "s";

            return cooldown;
        }

        public void load(CompoundTag nbt) {
            if (nbt.contains("cooldown")) this.currentCooldown = nbt.getInt("cooldown");
            if (nbt.contains("timesReset")) this.numTimesReset = nbt.getInt("timesReset");
//            CelestialExploration.LOGGER.debug("loading: " + this + ", timesReset: " + this.numTimesReset);

        }

        public CompoundTag save() {
            CompoundTag nbt = new CompoundTag();

//            CelestialExploration.LOGGER.debug("saving: " + this + ", timesReset: " + this.numTimesReset);
            nbt.putInt("cooldown", this.currentCooldown);
            nbt.putInt("timesReset", this.numTimesReset);

            return nbt;
        }
    }

    public static class LightTravelHandler implements ILightTravel {
        boolean beenToSpace = false;
        boolean beenToMars = false;
        boolean beenToVenus = false;
        boolean beenToMercury = false;
        boolean beenToJupiter = false;
        PlanetCooldown overworldCooldown = new PlanetCooldown();
        PlanetCooldown marsCooldown = new PlanetCooldown();
        PlanetCooldown venusCooldown = new PlanetCooldown();
        PlanetCooldown mercuryCooldown = new PlanetCooldown();
        PlanetCooldown jupiterCooldown = new PlanetCooldown();

        @Override
        public boolean hasBeenToSpace() {
            return this.beenToSpace;
        }

        @Override
        public boolean hasBeenToMars() {
            return this.beenToMars;
        }

        @Override
        public boolean hasBeenToVenus() {
            return this.beenToVenus;
        }

        @Override
        public boolean hasBeenToMercury() {
            return this.beenToMercury;
        }

        @Override
        public boolean hasBeenToJupiter() {
            return this.beenToJupiter;
        }

        @Override
        public void setBeenToSpace() {
            this.beenToSpace = true;
        }

        @Override
        public void setBeenToMars() {
            this.beenToMars = true;
        }

        @Override
        public void setBeenToVenus() {
            this.beenToVenus = true;
        }

        @Override
        public void setBeenToMercury() {
            this.beenToMercury = true;
        }

        @Override
        public void setBeenToJupiter() {
            this.beenToJupiter = true;
        }

        @Override
        public PlanetCooldown getOverworldCooldown() {
            return overworldCooldown;
        }

        @Override
        public PlanetCooldown getMarsCooldown() {
            return marsCooldown;
        }

        @Override
        public PlanetCooldown getVenusCooldown() {
            return venusCooldown;
        }

        @Override
        public PlanetCooldown getMercuryCooldown() {
            return mercuryCooldown;
        }

        @Override
        public PlanetCooldown getJupiterCooldown() {
            return jupiterCooldown;
        }

        @Override
        public void sync(Player player) {
            if (player instanceof ServerPlayer serverPlayer) {
                LightTravelCapability.ILightTravel travelCap = CelestialExploration.getCapability(serverPlayer, CelestialCapabilities.LIGHT_TRAVEL_CAPABILITY);

                if (travelCap != null) {
                    PacketDistributor.PacketTarget targetPlayer = PacketDistributor.PLAYER.with(() -> serverPlayer);
                    CelestialPacketHandler.INSTANCE.send(targetPlayer, new LightTravelDataPacket(serverPlayer.getId(), travelCap.getData()));

                }
            }
        }

        @Override
        public CompoundTag getData() {
            CompoundTag nbt = new CompoundTag();

            nbt.putBoolean("mars", this.beenToMars);
            nbt.putBoolean("space", this.beenToSpace);
            nbt.putBoolean("venus", this.beenToVenus);
            nbt.putBoolean("mercury", this.beenToMercury);
            nbt.putBoolean("jupiter", this.beenToJupiter);
            nbt.put("mercury_cooldown", this.mercuryCooldown.save());
            nbt.put("venus_cooldown", this.venusCooldown.save());
            nbt.put("overworld_cooldown", this.overworldCooldown.save());
            nbt.put("mars_cooldown", this.marsCooldown.save());
            nbt.put("jupiter_cooldown", this.jupiterCooldown.save());

            return nbt;
        }

        @Override
        public void setData(CompoundTag nbt) {
            if (nbt.contains("mars")) this.beenToMars = nbt.getBoolean("mars");
            if (nbt.contains("space")) this.beenToSpace = nbt.getBoolean("space");
            if (nbt.contains("venus")) this.beenToVenus = nbt.getBoolean("venus");
            if (nbt.contains("mercury")) this.beenToMercury = nbt.getBoolean("mercury");
            if (nbt.contains("jupiter")) this.beenToJupiter = nbt.getBoolean("jupiter");

            if (nbt.contains("mars_cooldown")) this.marsCooldown.load(nbt.getCompound("mars_cooldown"));
            if (nbt.contains("overworld_cooldown")) this.overworldCooldown.load(nbt.getCompound("overworld_cooldown"));
            if (nbt.contains("venus_cooldown")) this.venusCooldown.load(nbt.getCompound("venus_cooldown"));
            if (nbt.contains("mercury_cooldown")) this.mercuryCooldown.load(nbt.getCompound("mercury_cooldown"));
            if (nbt.contains("jupiter_cooldown")) this.jupiterCooldown.load(nbt.getCompound("jupiter_cooldown"));

        }
    }

    public static class LightTravelProvider implements ICapabilityProvider, ICapabilitySerializable<CompoundTag> {

        public static Capability<LightTravelHandler> LIGHT_TRAVEL = CapabilityManager.get(new CapabilityToken<>(){});
        private LightTravelHandler lightTravelHandler = null;
        private final LazyOptional<LightTravelHandler> lazyLightTravel = LazyOptional.of(this::createLightTravelHandler);

        @Nonnull
        private LightTravelHandler createLightTravelHandler() {
            if (lightTravelHandler == null) {
                lightTravelHandler = new LightTravelHandler();
            }
            return lightTravelHandler;
        }

        @NotNull
        @Override
        public <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
            return CelestialCapabilities.LIGHT_TRAVEL_CAPABILITY.orEmpty(cap, lazyLightTravel.cast());
        }

        @Override
        public CompoundTag serializeNBT() {
            return lazyLightTravel.orElseThrow(NullPointerException::new).getData();
        }

        @Override
        public void deserializeNBT(CompoundTag nbt) {
            lazyLightTravel.orElseThrow(NullPointerException::new).setData(nbt);
        }
    }
}
