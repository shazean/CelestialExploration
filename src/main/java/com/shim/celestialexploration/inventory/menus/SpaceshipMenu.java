package com.shim.celestialexploration.inventory.menus;

import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestialexploration.capabilities.ISpaceFlight;
import com.shim.celestialexploration.capabilities.LightTravelCapability;
import com.shim.celestialexploration.entity.vehicle.Spaceship;
import com.shim.celestialexploration.inventory.OxygenTankSlot;
import com.shim.celestialexploration.packets.CelestialPacketHandler;
import com.shim.celestialexploration.packets.DoLightTravelPacket;
import com.shim.celestialexploration.packets.ServerResetLightTravelPacket;
import com.shim.celestialexploration.packets.TaxiDestinationPacket;
import com.shim.celestialexploration.registry.CapabilityRegistry;
import com.shim.celestialexploration.registry.DimensionRegistry;
import com.shim.celestialexploration.registry.MenuRegistry;
import com.shim.celestialexploration.util.CelestialUtil;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.SlotItemHandler;

import java.util.HashMap;
import java.util.Map;

public class SpaceshipMenu extends AbstractContainerMenu {
    private final Spaceship entity;
    private final Level level;
    protected Minecraft minecraft;
    protected final Map<ResourceKey<Level>, Vec3> PLANET_LOCATIONS;
    Inventory inventory;

    public SpaceshipMenu(int containerId, Inventory inventory, FriendlyByteBuf friendlyByteBuf) {
        this(containerId, inventory, inventory.player.level.getEntity(friendlyByteBuf.readInt()), new HashMap<>());
    }

    public SpaceshipMenu(int containerId, Inventory inv, Entity spaceship, Map<ResourceKey<Level>, Vec3> planets) {
        super(MenuRegistry.SPACESHIP_MENU.get(), containerId);
        checkContainerSize(inv, 32);
        entity = ((Spaceship) spaceship);
        this.level = inv.player.level;
        this.PLANET_LOCATIONS = planets;
        this.inventory = inv;

        addPlayerInventory(inv);
        addPlayerHotbar(inv);

        this.entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY).ifPresent(handler -> {
            //fuel slots
            this.addSlot(new OxygenTankSlot(handler, 0, 26, 16));
            this.addSlot(new OxygenTankSlot(handler, 1, 62, 16));
            this.addSlot(new OxygenTankSlot(handler, 2, 98, 16));
            this.addSlot(new OxygenTankSlot(handler, 3, 134, 16));

            //spaceship storage
            for (int i = 0; i < 2; ++i) {
                for (int l = 0; l < 9; ++l) {
                    this.addSlot(new SlotItemHandler(handler, l + i * 9 + 4, 8 + l * 18, 50 - 8 + 4 + i * 18));
                }
            }
        });
    }

    @Override
    public ItemStack quickMoveStack(Player playerIn, int index) {
//        int indexMealDisplay = 6;
//        int indexContainerInput = 7;
        int indexOutput = 4 + 27 + 1;
        int startPlayerInv = indexOutput + 1;
        int endPlayerInv = startPlayerInv + 36;
        ItemStack slotStackCopy = ItemStack.EMPTY;
        Slot slot = this.slots.get(index);
        if (slot.hasItem()) {
            ItemStack slotStack = slot.getItem();
            slotStackCopy = slotStack.copy();
            if (index == indexOutput) {
                if (!this.moveItemStackTo(slotStack, startPlayerInv, endPlayerInv, true)) {
                    return ItemStack.EMPTY;
                }
            } else if (index > indexOutput) {
//                boolean isValidContainer = slotStack.is(inventory.getItem(index));
//                if (!this.moveItemStackTo(slotStack, indexContainerInput, indexContainerInput + 1, false)) {
//                    return ItemStack.EMPTY;
//                } else if (!this.moveItemStackTo(slotStack, 0, indexMealDisplay, false)) {
//                    return ItemStack.EMPTY;
//                } else
                    if (!this.moveItemStackTo(slotStack, indexOutput, indexOutput, false)) {
                    return ItemStack.EMPTY;
                }
            } else if (!this.moveItemStackTo(slotStack, startPlayerInv, endPlayerInv, false)) {
                return ItemStack.EMPTY;
            }

            if (slotStack.isEmpty()) {
                slot.set(ItemStack.EMPTY);
            } else {
                slot.setChanged();
            }

            if (slotStack.getCount() == slotStackCopy.getCount()) {
                return ItemStack.EMPTY;
            }

            slot.onTake(playerIn, slotStack);
        }
        return slotStackCopy;
    }

//    // Credit: diesieben07 | https://github.com/diesieben07/SevenCommons
//    private static final int HOTBAR_SLOT_COUNT = 9;
//    private static final int PLAYER_INVENTORY_ROW_COUNT = 3;
//    private static final int PLAYER_INVENTORY_COLUMN_COUNT = 9;
//    private static final int PLAYER_INVENTORY_SLOT_COUNT = PLAYER_INVENTORY_COLUMN_COUNT * PLAYER_INVENTORY_ROW_COUNT;
//    private static final int VANILLA_SLOT_COUNT = HOTBAR_SLOT_COUNT + PLAYER_INVENTORY_SLOT_COUNT;
//    private static final int VANILLA_FIRST_SLOT_INDEX = 0;
//    private static final int TE_INVENTORY_FIRST_SLOT_INDEX = VANILLA_FIRST_SLOT_INDEX + VANILLA_SLOT_COUNT;
//
//    private static final int TE_INVENTORY_SLOT_COUNT = 31;  // must be the number of slots you have!
//
//    @Override
//    public ItemStack quickMoveStack(Player playerIn, int index) {
//        Slot sourceSlot = slots.get(index);
//        if (sourceSlot == null || !sourceSlot.hasItem()) return ItemStack.EMPTY;  //EMPTY_ITEM
//        ItemStack sourceStack = sourceSlot.getItem();
//        ItemStack copyOfSourceStack = sourceStack.copy();
//
//        // Check if the slot clicked is one of the vanilla container slots
//        if (index < VANILLA_FIRST_SLOT_INDEX + VANILLA_SLOT_COUNT) {
//            // This is a vanilla container slot so merge the stack into the tile inventory
//            if (!moveItemStackTo(sourceStack, TE_INVENTORY_FIRST_SLOT_INDEX, TE_INVENTORY_FIRST_SLOT_INDEX + TE_INVENTORY_SLOT_COUNT, false)) {
//                return ItemStack.EMPTY;  // EMPTY_ITEM
//            }
//        } else if (index < TE_INVENTORY_FIRST_SLOT_INDEX + TE_INVENTORY_SLOT_COUNT) {
//            // This is a TE slot so merge the stack into the players inventory
//            if (!moveItemStackTo(sourceStack, VANILLA_FIRST_SLOT_INDEX, VANILLA_FIRST_SLOT_INDEX + VANILLA_SLOT_COUNT, false)) {
//                return ItemStack.EMPTY;
//            }
//        } else {
//            CelestialExploration.LOGGER.debug("Invalid slotIndex:" + index);
//            return ItemStack.EMPTY;
//        }
//        // If stack size == 0 (the entire stack was moved) set slot contents to null
//        if (sourceStack.getCount() == 0) {
//            sourceSlot.set(ItemStack.EMPTY);
//        } else {
//            sourceSlot.setChanged();
//        }
//        sourceSlot.onTake(playerIn, sourceStack);
//        return copyOfSourceStack;
//    }

    @Override
    public boolean stillValid(Player player) {
        return this.entity.distanceTo(player) < 8.0F;
    }

    private void addPlayerInventory(Inventory playerInventory) {
        for (int i = 0; i < 3; ++i) {
            for (int l = 0; l < 9; ++l) {
                this.addSlot(new Slot(playerInventory, l + i * 9 + 9, 8 + l * 18, 84 + 34 - 16 - 8 + i * 18)); //8 + l * 18, 86 + l * 18
            }
        }
    }

    private void addPlayerHotbar(Inventory playerInventory) {
        for (int i = 0; i < 9; ++i) {
            this.addSlot(new Slot(playerInventory, i, 8 + i * 18, 142 + 34 - 16 - 8));
        }
    }

    public boolean lightTravelAllowed() {
        return this.entity.getPassengers().size() >= 1 && this.entity.level.dimension().equals(DimensionRegistry.SPACE);
    }

    public Vec3 getPlanetLocation(ResourceKey<Level> dimension) {
        return PLANET_LOCATIONS.get(dimension);
    }

    public Vec3 getPlanetaryChunkCoordinates(ResourceKey<Level> planet) {
        Vec3 coord = getPlanetLocation(planet); //CE_DIMENSION_LOCATION.get(planet);
//        if (coord == null) coord = CE_DIMENSION_LOCATION.get(Level.OVERWORLD);
        coord = new Vec3(coord.x * CelestialUtil.getSpaceRatio(), coord.y, coord.z * CelestialUtil.getSpaceRatio());
        return coord;
    }


    public void doLightTravel(ResourceKey<Level> dimension, Player player) {
        if (lightTravelAllowed()) {

//            ChunkPos chunkPos = new ChunkPos((int) getPlanetaryChunkCoordinates(dimension).x(), (int) getPlanetaryChunkCoordinates(dimension).z());

            ChunkPos chunkPos = new ChunkPos((int) CelestialUtil.getPlanetaryChunkCoordinates(dimension).x(), (int) CelestialUtil.getPlanetaryChunkCoordinates(dimension).z());
            BlockPos pos = chunkPos.getMiddleBlockPosition(0);

            int secondPassenger = (this.entity.getPassengers().size() > 1) ? this.entity.getPassengers().get(1).getId() : -1;
            CelestialPacketHandler.INSTANCE.sendToServer(new DoLightTravelPacket(this.entity.getId(), this.entity.getPassengers().get(0).getId(), secondPassenger, pos));

            if (this.entity.getFirstPassenger() == player) {
//                LightTravelCapability.ILightTravel travelCap = CelestialExploration.getCapability(player, CapabilityRegistry.LIGHT_TRAVEL_CAPABILITY);

//                if (travelCap != null) {
//                    if (dimension.equals(DimensionRegistry.MERCURY))
//                        travelCap.getMercuryCooldown().resetCooldown();
//                    if (dimension.equals(DimensionRegistry.VENUS))
//                        travelCap.getVenusCooldown().resetCooldown();
//                    if (dimension.equals(Level.OVERWORLD))
//                        travelCap.getOverworldCooldown().resetCooldown();
//                    if (dimension.equals(DimensionRegistry.MARS))
//                        travelCap.getMarsCooldown().resetCooldown();
//                    if (dimension.equals(DimensionRegistry.JUPITER))
//                        travelCap.getJupiterCooldown().resetCooldown();
//                }

                CelestialPacketHandler.INSTANCE.sendToServer(new ServerResetLightTravelPacket(this.entity.getFirstPassenger().getId(), dimension));

            }
        }
    }

//    public Player interactingPlayer() {
//        return this.getMinecraft().player;
//    }
//
//    public LightTravelCapability.ILightTravel getPlayerLightTravel() {
//        Player player = interactingPlayer();
//
//        return CelestialExploration.getCapability(player, CapabilityRegistry.LIGHT_TRAVEL_CAPABILITY);
//
//    }

}
