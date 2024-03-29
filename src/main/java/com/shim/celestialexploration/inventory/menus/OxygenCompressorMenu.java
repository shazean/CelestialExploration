package com.shim.celestialexploration.inventory.menus;

import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestialexploration.blocks.blockentities.OxygenCompressorBlockEntity;
import com.shim.celestialexploration.inventory.FuelSlot;
import com.shim.celestialexploration.inventory.OxygenTankSlot;
import com.shim.celestialexploration.registry.BlockRegistry;
import com.shim.celestialexploration.registry.MenuRegistry;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.*;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.SlotItemHandler;

public class OxygenCompressorMenu extends AbstractContainerMenu {
    private final OxygenCompressorBlockEntity blockEntity;
    private final Level level;
    private final ContainerData data;


    public OxygenCompressorMenu(int containerId, Inventory inv, FriendlyByteBuf extraData) {
        this(containerId, inv, inv.player.level.getBlockEntity(extraData.readBlockPos()), new SimpleContainerData(4));
    }

    public OxygenCompressorMenu(int containerId, Inventory inv, BlockEntity entity, ContainerData data) {
        super(MenuRegistry.OXYGEN_COMPRESSOR_MENU.get(), containerId);

        checkContainerSize(inv, 6);
        blockEntity = ((OxygenCompressorBlockEntity) entity);
        this.level = inv.player.level;
        this.data = data;

        addPlayerInventory(inv);
        addPlayerHotbar(inv);

        CelestialExploration.LOGGER.debug("inventory slot 1: " + inv.getItem(36) + ", "+ inv.getItem(37) + ", "+ inv.getItem(38) + ", "+ inv.getItem(39) + ", "+ inv.getItem(40));

        this.blockEntity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY).ifPresent(handler -> {
            this.addSlot(new FuelSlot(handler, 0, 31, 51));
            this.addSlot(new OxygenTankSlot(handler, 1, 106, 23));
            this.addSlot(new OxygenTankSlot(handler, 2, 130, 23));
            this.addSlot(new OxygenTankSlot(handler, 3, 106, 47));
            this.addSlot(new OxygenTankSlot(handler, 4, 130, 47));

            CelestialExploration.LOGGER.debug("menu slot 0: " + this.getSlot(35).getItem() + ", " + this.getSlot(36).getItem() + ", " + this.getSlot(37).getItem());
        });

        addDataSlots(data);
    }


    /**
     CREDIT GOES TO: diesieben07 | https://github.com/diesieben07/SevenCommons
    **/
    private static final int HOTBAR_SLOT_COUNT = 9;
    private static final int PLAYER_INVENTORY_ROW_COUNT = 3;
    private static final int PLAYER_INVENTORY_COLUMN_COUNT = 9;
    private static final int PLAYER_INVENTORY_SLOT_COUNT = PLAYER_INVENTORY_COLUMN_COUNT * PLAYER_INVENTORY_ROW_COUNT;
    private static final int VANILLA_SLOT_COUNT = HOTBAR_SLOT_COUNT + PLAYER_INVENTORY_SLOT_COUNT;
    private static final int VANILLA_FIRST_SLOT_INDEX = 0;
    private static final int TE_INVENTORY_FIRST_SLOT_INDEX = VANILLA_FIRST_SLOT_INDEX + VANILLA_SLOT_COUNT;

    private static final int TE_INVENTORY_SLOT_COUNT = 5;  // must be the number of slots you have!

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
    public boolean stillValid(Player pPlayer) {
        return stillValid(ContainerLevelAccess.create(level, blockEntity.getBlockPos()),
                pPlayer, BlockRegistry.OXYGEN_COMPRESSOR.get());
    }

    private void addPlayerInventory(Inventory playerInventory) {
        for (int i = 0; i < 3; ++i) {
            for (int l = 0; l < 9; ++l) {
                this.addSlot(new Slot(playerInventory, l + i * 9 + 9, 8 + l * 18, 84 + i * 18)); //8 + l * 18, 86 + l * 18
            }
        }
    }

    private void addPlayerHotbar(Inventory playerInventory) {
        for (int i = 0; i < 9; ++i) {
            this.addSlot(new Slot(playerInventory, i, 8 + i * 18, 142)); //144
        }
    }

//    public float getBurnProgress() {
////        int i = this.blockEntity.getBurnProgress();
////        return this.blockEntity.getBurnProgress() / 10;
////        int i = this.data.get(2);
////        int j = this.data.get(3);
////        return j != 0 && i != 0 ? i * 24 / j : 0;
////        int i = this.blockEntity.getBurnProgress() / this.blockEntity.getBurnMaxTime() * 100; //50 / 250 = .20 * 10 = 20 //200 / 250 = .8 * 100 = 80
////        i = 100 - i; //100 - 20 = 80 //100 - 80 = 20
////        return i / 10;
//
//        int i = this.blockEntity.getBurnProgress();
//        int j = this.blockEntity.getBurnMaxTime();
//
//        if (j == 0) {
//            return 0;
//        }
//
//
//        float k = (float)i / (float)j;
////        i = (int) (k * 100);
////        i = 100 - i; //100 - 20 = 80 //100 - 80 = 20
//        return k;
//    }

    public int getScaledProgress(int progressSize) {
        int progress = this.data.get(0);
        int maxProgress = this.data.get(1);  // Max Progress
//        int progressArrowSize = 19;

        return maxProgress != 0 && progress != 0 ? progress * progressSize / maxProgress : 0;
    }

    public int getBurnProgress() {
        int i = this.data.get(2);
        int j = this.data.get(3);
        return j != 0 && i != 0 ? i * 24 / j : 0;
    }

    public int getLitProgress() {
        int i = this.data.get(3);
        int j = this.data.get(2);
        if (i == 0) {
            i = 200;
        }
//        CelestialExploration.LOGGER.debug("maxFuelBurnTime: " + i + " fuelBurnTime: " + j + " getLitProgress (fuel * 13 / max): " + j * 13 / i);

        return j * 13 / i;
    }

    public boolean isLit() {
        return this.data.get(2) > 0;
    }

    public boolean isBurning() {
        return this.data.get(0) > 0;
    }

//    public int getBurnProgress() {
////        int i = this.blockEntity.getBurnProgress();
////        return this.blockEntity.getBurnProgress() / 10;
////        int i = this.data.get(2);
////        int j = this.data.get(3);
////        return j != 0 && i != 0 ? i * 24 / j : 0;
////        int i = this.blockEntity.getBurnProgress() / this.blockEntity.getBurnMaxTime() * 100; //50 / 250 = .20 * 10 = 20 //200 / 250 = .8 * 100 = 80
////        i = 100 - i; //100 - 20 = 80 //100 - 80 = 20
////        return i / 10;
//
//        int i = this.blockEntity.getBurnProgress();
//        int j = this.blockEntity.getBurnMaxTime();
//
//        if (j == 0) {
//            return 0;
//        }
//        double k = (double)i / (double)j;
//        i = (int) (k * 100);
//        i = 100 - i; //100 - 20 = 80 //100 - 80 = 20
//        return i / 10;
//    }
//
////    public float getLitProgress() {
////        int i = this.blockEntity.getLitProgress();
////        int j = this.blockEntity.getLitTotalTime();
////
////        if (j == 0) {
////            return 0;
////        }
////
////        float k = (float)i / (float)j;
//////        i = (int) (k * 100);
////
////
//////        i = i * 100; //50 / 250 = .20 * 10 = 20 //200 / 250 = .8 * 100 = 80
//////        i = 100 - i; //100 - 20 = 80 //100 - 80 = 20
////        return k;
////    }
//
//    public int getLitProgress() {
//        int i = this.blockEntity.getLitProgress();
//        int j = this.blockEntity.getLitTotalTime();
//
//        if (j == 0) {
//            return 0;
//        }
//
//        double k = (double)i / (double)j;
//        i = (int) (k * 100);
//
//
////        i = i * 100; //50 / 250 = .20 * 10 = 20 //200 / 250 = .8 * 100 = 80
//        i = 100 - i; //100 - 20 = 80 //100 - 80 = 20
//        return i / 10;
//    }
////        int i = this.data.get(1);
////        if (i == 0) {
////            i = 200;
////        }
////
////        return this.data.get(0) * 13 / i;
////    }

//    public boolean isLit() {
//        return this.blockEntity.isLit();
////        return this.data.get(0) > 0;
//    }
}
