//package com.shim.celestialexploration.blocks.blockentities;
//
//import com.shim.celestialexploration.CelestialExploration;
//import com.shim.celestialexploration.entity.vehicle.SpaceTaxi;
//import com.shim.celestialexploration.inventory.menus.TaxiStationMenu;
//import com.shim.celestialexploration.registry.CelestialBlockEntities;
//import net.minecraft.core.BlockPos;
//import net.minecraft.core.Direction;
//import net.minecraft.nbt.CompoundTag;
//import net.minecraft.network.chat.Component;
//import net.minecraft.network.chat.TranslatableComponent;
//import net.minecraft.world.Containers;
//import net.minecraft.world.MenuProvider;
//import net.minecraft.world.SimpleContainer;
//import net.minecraft.world.entity.Entity;
//import net.minecraft.world.entity.EntityType;
//import net.minecraft.world.entity.player.Inventory;
//import net.minecraft.world.entity.player.Player;
//import net.minecraft.world.inventory.AbstractContainerMenu;
//import net.minecraft.world.inventory.ContainerData;
//import net.minecraft.world.level.Level;
//import net.minecraft.world.level.block.entity.BlockEntity;
//import net.minecraft.world.level.block.state.BlockState;
//import net.minecraftforge.common.capabilities.Capability;
//import net.minecraftforge.common.util.LazyOptional;
//import net.minecraftforge.items.CapabilityItemHandler;
//import net.minecraftforge.items.IItemHandler;
//import net.minecraftforge.items.ItemStackHandler;
//import org.jetbrains.annotations.NotNull;
//import org.jetbrains.annotations.Nullable;
//
//import javax.annotation.Nonnull;
//import java.util.ArrayList;
//import java.util.List;
//
//public class TaxiStationBlockEntity extends BlockEntity implements MenuProvider {
//    protected final ContainerData data;
//    List<TaxiAndPassengers> incomingTaxis;
//
//    public record TaxiAndPassengers(SpaceTaxi taxi, List<Entity> passengers) {}
//
//    public TaxiStationBlockEntity(BlockPos pos, BlockState state) {
//        super(CelestialBlockEntities.TAXI_STATION_BLOCK_ENTITY.get(), pos, state);
//        this.data = new ContainerData() {
//            public int get(int index) {
//                return switch (index) {
//                    case 0 -> 4;
//                    default -> 0;
//                };
//            }
//            public void set(int index, int value) {
////                switch (index) {
////                    case 0 -> OxygenCompressorBlockEntity.this.progress = value;
////                }
//            }
//            public int getCount() {
//                return 4;
//            }
//        };
//        incomingTaxis = new ArrayList<>();
//    }
//
//    private final ItemStackHandler itemHandler = new ItemStackHandler(2) {
//        @Override
//        protected void onContentsChanged(int slot) {
//            setChanged();
//        }
//    };
//
//    private LazyOptional<IItemHandler> lazyItemHandler = LazyOptional.empty();
//
//
//    @Override
//    public Component getDisplayName() {
//        return new TranslatableComponent("container.celestialexploration.taxi_station");
//    }
//
//    @Nullable
//    @Override
//    public AbstractContainerMenu createMenu(int containerId, Inventory inventory, Player player) {
//        return new TaxiStationMenu(containerId, inventory, this, this.data);
//    }
//
//    @Nonnull
//    @Override
//    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @javax.annotation.Nullable Direction side) {
//        if (cap == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {
//            return lazyItemHandler.cast();
//        }
//        return super.getCapability(cap, side);
//    }
//
//    @Override
//    public void onLoad() {
//        super.onLoad();
//        lazyItemHandler = LazyOptional.of(() -> itemHandler);
//    }
//
//    @Override
//    public void invalidateCaps() {
//        super.invalidateCaps();
//        lazyItemHandler.invalidate();
//    }
//
//    @Override
//    protected void saveAdditional(@NotNull CompoundTag tag) {
////        CelestialExploration.LOGGER.debug("saveAdditional: itemHandler slot 0: " + itemHandler.getStackInSlot(0));
//
//        tag.put("inventory", itemHandler.serializeNBT());
////        tag.putInt("oxygen_compressor.progress", progress);
////        tag.putInt("oxygen_compressor.maxProgress", maxProgress);
////        tag.putInt("oxygen_compressor.fuelBurnTime", fuelBurnTime);
////        tag.putInt("oxygen_compressor.maxFuelBurnTime", maxFuelBurnTime);
//
//        super.saveAdditional(tag);
//    }
//
//    @Override
//    public void load(@NotNull CompoundTag nbt) {
//        super.load(nbt);
//        itemHandler.deserializeNBT(nbt.getCompound("inventory"));
////        CelestialExploration.LOGGER.debug("load: itemHandler slot 0: " + itemHandler.getStackInSlot(0));
//
////        progress = nbt.getInt("oxygen_compressor.progress");
////        maxProgress = nbt.getInt("oxygen_compressor.maxProgress");
////        fuelBurnTime = nbt.getInt("oxygen_compressor.fuelBurnTime");
////        maxFuelBurnTime = nbt.getInt("oxygen_compressor.maxFuelBurnTime");
//    }
//
//    public void drops() {
//        SimpleContainer inventory = new SimpleContainer(itemHandler.getSlots());
//        for (int i = 0; i < itemHandler.getSlots(); i++) {
//            inventory.setItem(i, itemHandler.getStackInSlot(i));
//        }
//        assert this.level != null;
//        Containers.dropContents(this.level, this.worldPosition, inventory);
//    }
//
//    public static void tick(Level level, BlockPos pos, BlockState state, TaxiStationBlockEntity blockEntity) {
//
////        CelestialExploration.LOGGER.debug("timeOfDay(0): " + level.getTimeOfDay(0) + ", dayTime: " + level.getDayTime());
//
////        if (!level.isClientSide()) {
//            if (level.getDayTime() == 7000) {
//                CelestialExploration.LOGGER.debug("incomingTaxis: " + blockEntity.incomingTaxis);
//
//
//                for (TaxiAndPassengers taxi : blockEntity.incomingTaxis) {
//                    blockEntity.incomingTaxis.remove(taxi);
//
//                    taxi.taxi().moveTo(pos.getX(), pos.above(50).getY(), pos.getZ());
//                    level.addFreshEntity(taxi.taxi());
//
//                    for (Entity passenger : taxi.passengers()) {
//                        passenger.moveTo(pos.getX(), pos.above(50).getY(), pos.getZ());
//                        level.addFreshEntity(passenger);
//                        passenger.startRiding(taxi.taxi());
//
//                    }
//
//                    taxi.taxi().setDescent();
//
//                }
//            }
////        }
//
//    }
//
//    public void setIncomingTaxi(SpaceTaxi taxi, List<Entity> passengers) {
//        this.incomingTaxis.add(new TaxiAndPassengers(taxi, passengers));
//        this.saveTaxiPassengers();
//        CelestialExploration.LOGGER.debug("incomingTaxis: " + incomingTaxis);
//    }
//
//    private void saveTaxiPassengers() {
//        CompoundTag nbt = new CompoundTag();
//        for (TaxiAndPassengers taxi : this.incomingTaxis) {
//
//            nbt = taxi.taxi().saveWithoutId(nbt);
//            SpaceTaxi newTaxi = (SpaceTaxi) EntityType.create(nbt, taxi.taxi().level).get();
//
//            List<Entity> passengers = new ArrayList<>();
//            for (Entity entity : taxi.passengers()) {
//                nbt = new CompoundTag();
//                nbt = entity.saveWithoutId(nbt);
//                Entity newEntity = EntityType.create(nbt, entity.level).get();
//
//                passengers.add(newEntity);
//            }
//
//            this.incomingTaxis.remove(taxi);
//            this.incomingTaxis.add(new TaxiAndPassengers(newTaxi, passengers));
//
//        }
//    }
//}