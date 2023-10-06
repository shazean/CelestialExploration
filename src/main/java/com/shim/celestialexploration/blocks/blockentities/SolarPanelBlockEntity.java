//package com.shim.celestialexploration.blocks.blockentities;
//
//import com.shim.celestialexploration.registry.BlockEntityRegistry;
//import com.shim.celestialexploration.registry.BlockRegistry;
//import com.shim.celestialexploration.tools.CustomEnergyStorage;
//import net.minecraft.core.BlockPos;
//import net.minecraft.core.Direction;
//import net.minecraft.nbt.CompoundTag;
//import net.minecraft.network.chat.Component;
//import net.minecraft.network.chat.TextComponent;
//import net.minecraft.world.MenuProvider;
//import net.minecraft.world.entity.player.Inventory;
//import net.minecraft.world.entity.player.Player;
//import net.minecraft.world.inventory.AbstractContainerMenu;
//import net.minecraft.world.item.ItemStack;
//import net.minecraft.world.item.Items;
//import net.minecraft.world.level.block.Block;
//import net.minecraft.world.level.block.entity.BlockEntity;
//import net.minecraft.world.level.block.state.BlockState;
//import net.minecraft.world.level.block.state.properties.BlockStateProperties;
//import net.minecraftforge.common.ForgeConfigSpec;
//import net.minecraftforge.common.capabilities.Capability;
//import net.minecraftforge.common.util.LazyOptional;
//import net.minecraftforge.energy.CapabilityEnergy;
//import net.minecraftforge.energy.IEnergyStorage;
//import net.minecraftforge.items.CapabilityItemHandler;
//import net.minecraftforge.items.IItemHandler;
//import net.minecraftforge.items.ItemStackHandler;
//
//import javax.annotation.Nonnull;
//import javax.annotation.Nullable;
//import java.util.concurrent.atomic.AtomicInteger;
//
//public class SolarPanelBlockEntity extends BlockEntity {
//
//    public static final int SOLAR_PANEL_CAPACITY = 5000; //max capacity
//    public static final int SOLAR_PANEL_GENERATE = 60; //generation per tick
//    public static final int SOLAR_PANEL_SEND = 200; //power to send out per tick
//    public static final int SOLAR_PANEL_TICKS = 1; //???
//
//    private final ItemStackHandler itemHandler = createHandler();
//    private final LazyOptional<IItemHandler> handler = LazyOptional.of(() -> itemHandler);
//
//    private final CustomEnergyStorage energyStorage = createEnergy();
//    private LazyOptional<IEnergyStorage> energy = LazyOptional.of(() -> energyStorage);
//
//    private int counter;
//
//    public SolarPanelBlockEntity(BlockPos pos, BlockState state) {
//        super(BlockEntityRegistry.SOLAR_PANEL_BLOCK_ENTITY.get(), pos, state);
//    }
//
//    @Override
//    public void setRemoved() {
//        super.setRemoved();
//        handler.invalidate();
//        energy.invalidate();
//    }
//
//    public void tickServer() {
//        if (counter > 0) {
//            counter--;
//            if (counter <= 0) {
//                energyStorage.addEnergy(SOLAR_PANEL_GENERATE);
//            }
//            setChanged();
//        }
//
//        if (counter <= 0) {
//            ItemStack stack = itemHandler.getStackInSlot(0);
//            if (stack.getItem() == Items.DIAMOND) {
//                itemHandler.extractItem(0, 1, false);
//                counter = SOLAR_PANEL_TICKS;
//                setChanged();
//            }
//        }
//
//        BlockState blockState = level.getBlockState(worldPosition);
//        if (blockState.getValue(BlockStateProperties.POWERED) != counter > 0) {
//            level.setBlock(worldPosition, blockState.setValue(BlockStateProperties.POWERED, counter > 0),
//                    Block.UPDATE_ALL);
//        }
//
//        sendOutPower();
//    }
//
//    private void sendOutPower() {
//        AtomicInteger capacity = new AtomicInteger(energyStorage.getEnergyStored());
//        if (capacity.get() > 0) {
//            for (Direction direction : Direction.values()) {
//                BlockEntity te = level.getBlockEntity(worldPosition.relative(direction));
//                if (te != null) {
//                    boolean doContinue = te.getCapability(CapabilityEnergy.ENERGY, direction).map(handler -> {
//                                if (handler.canReceive()) {
//                                    int received = handler.receiveEnergy(Math.min(capacity.get(), SOLAR_PANEL_SEND), false);
//                                    capacity.addAndGet(-received);
//                                    energyStorage.consumeEnergy(received);
//                                    setChanged();
//                                    return capacity.get() > 0;
//                                } else {
//                                    return true;
//                                }
//                            }
//                    ).orElse(true);
//                    if (!doContinue) {
//                        return;
//                    }
//                }
//            }
//        }
//    }
//
//    @Override
//    public void load(CompoundTag tag) {
//        if (tag.contains("inv")) {
//            itemHandler.deserializeNBT(tag.getCompound("inv"));
//        }
//        if (tag.contains("energy")) {
//            energyStorage.deserializeNBT(tag.get("energy"));
//        }
//
//        counter = tag.getInt("counter");
//        super.load(tag);
//    }
//
//    @Override
//    public void saveAdditional(CompoundTag tag) {
//        tag.put("inv", itemHandler.serializeNBT());
//        tag.put("energy", energyStorage.serializeNBT());
//
//        tag.putInt("counter", counter);
//    }
//
//    private ItemStackHandler createHandler() {
//        return new ItemStackHandler(1) {
//
//            @Override
//            protected void onContentsChanged(int slot) {
//                // To make sure the TE persists when the chunk is saved later we need to
//                // mark it dirty every time the item handler changes
//                setChanged();
//            }
//
//            @Override
//            public boolean isItemValid(int slot, @Nonnull ItemStack stack) {
//                return stack.getItem() == Items.DIAMOND;
//            }
//
//            @Nonnull
//            @Override
//            public ItemStack insertItem(int slot, @Nonnull ItemStack stack, boolean simulate) {
//                if (stack.getItem() != Items.DIAMOND) {
//                    return stack;
//                }
//                return super.insertItem(slot, stack, simulate);
//            }
//        };
//    }
//
//    private CustomEnergyStorage createEnergy() {
//        return new CustomEnergyStorage(SOLAR_PANEL_CAPACITY, 0) {
//            @Override
//            protected void onEnergyChanged() {
//                setChanged();
//            }
//        };
//    }
//
//    @Nonnull
//    @Override
//    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side) {
//        if (cap == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {
//            return handler.cast();
//        }
//        if (cap == CapabilityEnergy.ENERGY) {
//            return energy.cast();
//        }
//        return super.getCapability(cap, side);
//    }
//
//}