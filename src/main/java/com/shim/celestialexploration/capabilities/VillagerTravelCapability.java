//package com.shim.celestialexploration.capabilities;
//
//import com.shim.celestialexploration.registry.CelestialCapabilities;
//import net.minecraft.core.Direction;
//import net.minecraft.nbt.CompoundTag;
//import net.minecraft.world.entity.player.Player;
//import net.minecraftforge.common.capabilities.*;
//import net.minecraftforge.common.util.LazyOptional;
//import org.jetbrains.annotations.NotNull;
//import org.jetbrains.annotations.Nullable;
//
//import javax.annotation.Nonnull;
//
//public class VillagerTravelCapability {
//
//    public interface ITravel {
//
//     boolean isWillingToTravel();
//        void toggleTravelWillingness(Player player);
//        Player getPlayerWhoSet();
//        CompoundTag getData();
//        void setData(CompoundTag nbt);
//    }
//
//    public static class TravelHandler implements ITravel {
//
//        Player player = null;
//        boolean willingness = true;
//
//        @Override
//        public boolean isWillingToTravel() {
//            return this.willingness;
//        }
//
//        @Override
//        public void toggleTravelWillingness(Player player) {
//            if (!willingness) {
//                if (this.player == player) {
//                    willingness = !willingness;
//                }
//            } else {
//                willingness = !willingness;
//                this.player = player;
//            }
//        }
//
//        @Override
//        public Player getPlayerWhoSet() {
//            return this.player;
//        }
//
//        @Override
//        public CompoundTag getData() {
//            return new CompoundTag(); //TODO
//        }
//
//        @Override
//        public void setData(CompoundTag nbt) {
//            //TODO
//
//        }
//    }
//
//    public static class VillagerTravelCapabilityProvider implements ICapabilityProvider, ICapabilitySerializable<CompoundTag> {
//
//        public static Capability<TravelHandler> TRAVEL_CAP = CapabilityManager.get(new CapabilityToken<>(){});
//        private TravelHandler travelHandler = null;
//        private final LazyOptional<TravelHandler> lazyTravelHandler = LazyOptional.of(this::createHandler);
//
//        @Nonnull
//        private TravelHandler createHandler() {
//            if (travelHandler == null) {
//                travelHandler = new TravelHandler();
//            }
//            return travelHandler;
//        }
//
//        @NotNull
//        @Override
//        public <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
//            return CelestialCapabilities.LOX_TANK_CAPABILITY.orEmpty(cap, lazyTravelHandler.cast());
//        }
//
//        @Override
//        public CompoundTag serializeNBT() {
//            return lazyTravelHandler.orElseThrow(NullPointerException::new).getData();
//        }
//
//        @Override
//        public void deserializeNBT(CompoundTag nbt) {
//            lazyTravelHandler.orElseThrow(NullPointerException::new).setData(nbt);
//        }
//    }
//}
