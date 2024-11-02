package com.shim.celestialexploration.inventory.menus;

import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestialexploration.capabilities.TaxiCapability;
import com.shim.celestialexploration.entity.vehicle.SpaceTaxi;
import com.shim.celestialexploration.packets.*;
import com.shim.celestialexploration.registry.CapabilityRegistry;
import com.shim.celestialexploration.registry.MenuRegistry;
import com.shim.celestialexploration.util.CelestialUtil;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntitySelector;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.*;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.SlotItemHandler;

import javax.annotation.Nullable;
import java.util.List;

public class SpaceTaxiMenu extends AbstractContainerMenu {
    private final Entity entity;
    private final Level level;
    //    private final ContainerData data;
    private final List<Entity> nearbyEntites;
    private final List<TaxiCapability.TaxiStationData> taxiStations;
    private List<Entity> selectedEntities;
    private final ContainerData data;

    public SpaceTaxiMenu(int containerId, Inventory inventory, FriendlyByteBuf friendlyByteBuf) {
        this(containerId, inventory, inventory.player.level.getEntity(friendlyByteBuf.readInt()), new SimpleContainerData(8));
    }

    public SpaceTaxiMenu(int containerId, Inventory inv, Entity entity, ContainerData data) {
        super(MenuRegistry.SPACE_TAXI_MENU.get(), containerId);

        checkContainerSize(inv, 6);
        checkContainerDataCount(data, 8);
        this.entity = (SpaceTaxi) entity;
        this.level = inv.player.level;
        Player player = inv.player;
        this.data = data;

        addPlayerInventory(inv);
        addPlayerHotbar(inv);

        //TODO filter by willingness, and canRide
        nearbyEntites = level.getEntities(player, player.getBoundingBox().inflate(32.0D), EntitySelector.NO_SPECTATORS.and(Entity::isPickable).and(EntitySelector.LIVING_ENTITY_STILL_ALIVE));

        TaxiCapability.ITaxi taxiCap = CelestialExploration.getCapability(player, CapabilityRegistry.TAXI_CAPABILITY);
        if (taxiCap != null) {
            this.taxiStations = taxiCap.getTaxiStations();
        } else {
            this.taxiStations = null;
        }

        this.entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY).ifPresent(handler -> {
            this.addSlot(new SlotItemHandler(handler, 0, 178, 42));
        });

        this.addDataSlots(this.data);
    }

    @Override
    public void setData(int p_39044_, int p_39045_) {
        super.setData(p_39044_, p_39045_);
        this.sendAllDataToRemote();
        this.broadcastChanges();
    }

    public List<Entity> getNearbyEntites() {
        return this.nearbyEntites;
    }

    public List<TaxiCapability.TaxiStationData> getTaxiStations() {
        return this.taxiStations;
    }

    public void setSelectedEntity(Entity entity, int passengerNum) {
//        this.data.set(index, entity.getId());
//        this.setData(index, entity.getId());

        CelestialPacketHandler.INSTANCE.sendToServer(new TaxiPassengersPacket(this.entity.getId(), entity.getId(), passengerNum));

        //send passengers packet to entity
    }

    public void setSelectedLocation(TaxiCapability.TaxiStationData stationData) {
        this.data.set(2, stationData.pos().getX());
        this.data.set(3, stationData.pos().getY());
        this.data.set(4, stationData.pos().getZ());
        this.data.set(5, CelestialUtil.getIdFromDimension(stationData.dimension()));

        this.setData(2, stationData.pos().getX());
        this.setData(3, stationData.pos().getY());
        this.setData(4, stationData.pos().getZ());
        this.setData(5, CelestialUtil.getIdFromDimension(stationData.dimension()));

        CelestialPacketHandler.INSTANCE.sendToServer(new TaxiDestinationPacket(this.entity.getId(), stationData.pos(), stationData.dimension()));

        //send location packet to taxi
    }

    public boolean hasEmeralds() {
        return this.data.get(6) == 1;
    }

    public void setButtonClicked() {
        this.data.set(7, 1);
        this.setData(7, 1);

        CelestialPacketHandler.INSTANCE.sendToServer(new TaxiReadyForTakeoffPacket(this.entity.getId()));

        //send go time packet to taxi
    }

    //credit to diesieben07 | https://github.com/diesieben07/SevenCommons
    private static final int HOTBAR_SLOT_COUNT = 9;
    private static final int PLAYER_INVENTORY_ROW_COUNT = 3;
    private static final int PLAYER_INVENTORY_COLUMN_COUNT = 9;
    private static final int PLAYER_INVENTORY_SLOT_COUNT = PLAYER_INVENTORY_COLUMN_COUNT * PLAYER_INVENTORY_ROW_COUNT;
    private static final int VANILLA_SLOT_COUNT = HOTBAR_SLOT_COUNT + PLAYER_INVENTORY_SLOT_COUNT;
    private static final int VANILLA_FIRST_SLOT_INDEX = 0;
    private static final int TE_INVENTORY_FIRST_SLOT_INDEX = VANILLA_FIRST_SLOT_INDEX + VANILLA_SLOT_COUNT;

    private static final int TE_INVENTORY_SLOT_COUNT = 2;  // must be the number of slots you have!

    @Override
    public ItemStack quickMoveStack(Player playerIn, int index) {
        Slot sourceSlot = slots.get(index);
        if (sourceSlot == null || !sourceSlot.hasItem()) return ItemStack.EMPTY;  //EMPTY_ITEM
        ItemStack sourceStack = sourceSlot.getItem();
        ItemStack copyOfSourceStack = sourceStack.copy();

        // Check if the slot clicked is one of the vanilla container slots
        if (index < VANILLA_FIRST_SLOT_INDEX + VANILLA_SLOT_COUNT) {
            // This is a vanilla container slot so merge the stack into the tile inventory
            if (!moveItemStackTo(sourceStack, TE_INVENTORY_FIRST_SLOT_INDEX, TE_INVENTORY_FIRST_SLOT_INDEX
                    + TE_INVENTORY_SLOT_COUNT, false)) {
                return ItemStack.EMPTY;  // EMPTY_ITEM
            }
        } else if (index < TE_INVENTORY_FIRST_SLOT_INDEX + TE_INVENTORY_SLOT_COUNT) {
            // This is a TE slot so merge the stack into the players inventory
            if (!moveItemStackTo(sourceStack, VANILLA_FIRST_SLOT_INDEX, VANILLA_FIRST_SLOT_INDEX + VANILLA_SLOT_COUNT, false)) {
                return ItemStack.EMPTY;
            }
        } else {
            System.out.println("Invalid slotIndex:" + index);
            return ItemStack.EMPTY;
        }
        // If stack size == 0 (the entire stack was moved) set slot contents to null
        if (sourceStack.getCount() == 0) {
            sourceSlot.set(ItemStack.EMPTY);
        } else {
            sourceSlot.setChanged();
        }
        sourceSlot.onTake(playerIn, sourceStack);
        return copyOfSourceStack;
    }

    @Override
    public boolean stillValid(Player player) {
        return this.entity.distanceTo(player) < 8.0F;
    }

    private void addPlayerInventory(Inventory playerInventory) {
        for (int i = 0; i < 3; ++i) {
            for (int l = 0; l < 9; ++l) {
                this.addSlot(new Slot(playerInventory, l + i * 9 + 9, 8 + l * 18 + 100, 84 + i * 18)); //8 + l * 18, 86 + l * 18
            }
        }
    }

    private void addPlayerHotbar(Inventory playerInventory) {
        for (int i = 0; i < 9; ++i) {
            this.addSlot(new Slot(playerInventory, i, 8 + i * 18 + 100, 142)); //144
        }
    }
}
