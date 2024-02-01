package com.shim.celestialexploration.inventory.menus;

import com.shim.celestialexploration.blocks.blockentities.WorkbenchBlockEntity;
import com.shim.celestialexploration.inventory.FuelSlot;
import com.shim.celestialexploration.inventory.WorkbenchResultSlot;
import com.shim.celestialexploration.inventory.containers.WorkbenchCraftingContainer;
import com.shim.celestialexploration.recipes.WorkbenchCraftingRecipe;
import com.shim.celestialexploration.registry.BlockRegistry;
import com.shim.celestialexploration.registry.MenuRegistry;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.protocol.game.ClientboundContainerSetSlotPacket;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.StackedContents;
import net.minecraft.world.inventory.*;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.fluids.capability.CapabilityFluidHandler;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.SlotItemHandler;

import java.util.Optional;

public class WorkbenchMenu extends RecipeBookMenu<WorkbenchCraftingContainer> {
    private final WorkbenchBlockEntity blockEntity;
    private final Level level;
    private final ContainerData data;
//    private FluidTank tank;
    private final WorkbenchCraftingContainer craftSlots;
    private final ResultContainer resultSlots = new ResultContainer();
    private final Player player;
    private final ContainerLevelAccess access;
//    private final FluidTank tank;

    public WorkbenchMenu(int containerId, Inventory inv, FriendlyByteBuf extraData) {
        this(containerId, inv, inv.player.level.getBlockEntity(extraData.readBlockPos()), new SimpleContainerData(7), ContainerLevelAccess.NULL);
    }

    public WorkbenchMenu(int containerId, Inventory inv, BlockEntity entity, ContainerData data, ContainerLevelAccess access) {
        super(MenuRegistry.WORKBENCH_MENU.get(), containerId);

        checkContainerSize(inv, 12);
        blockEntity = ((WorkbenchBlockEntity) entity);
        this.player = inv.player;
        this.level = inv.player.level;
        this.data = data;
        this.access = access;
//        this.tank = ((WorkbenchBlockEntity) entity).getFluidTank();
        this.craftSlots = new WorkbenchCraftingContainer(this, 3, 3, ((WorkbenchBlockEntity) entity).getFluidTank());

        addPlayerInventory(inv);
        addPlayerHotbar(inv);

        this.blockEntity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY).ifPresent(handler -> {
//            this.addSlot(new SlotItemHandler(handler, 0, 66, 17)); //component slot 1
//            this.addSlot(new SlotItemHandler(handler, 1, 84, 17)); //component slot 2
//            this.addSlot(new SlotItemHandler(handler, 2, 102, 17)); //component slot 3
//            this.addSlot(new SlotItemHandler(handler, 3, 66, 35)); //component slot 4
//            this.addSlot(new SlotItemHandler(handler, 4, 84, 35)); //component slot 5
//            this.addSlot(new SlotItemHandler(handler, 5, 102, 35)); //component slot 6
//            this.addSlot(new SlotItemHandler(handler, 6, 66, 53)); //component slot 7
//            this.addSlot(new SlotItemHandler(handler, 7, 84, 53)); //component slot 8
//            this.addSlot(new SlotItemHandler(handler, 8, 102, 53)); //component slot 9
//            this.addSlot(new ResultSlot(player, this.craftSlots, this.resultSlots, 9, 144, 35)); //result slot
//
//            this.addSlot(new SlotItemHandler(handler, 10, 13, 17)); //smelting slot
//            this.addSlot(new FuelSlot(handler, 11, 13, 53)); //fuel slot


            this.addSlot(new SlotItemHandler(handler, 0, 13, 17)); //smelting slot
            this.addSlot(new FuelSlot(handler, 1, 13, 53)); //fuel slot
            this.addSlot(new Slot(this.craftSlots, 0, 66, 17)); //component slot 1
            this.addSlot(new Slot(this.craftSlots, 1, 84, 17)); //component slot 2
            this.addSlot(new Slot(this.craftSlots, 2, 102, 17)); //component slot 3
            this.addSlot(new Slot(this.craftSlots, 3, 66, 35)); //component slot 4
            this.addSlot(new Slot(this.craftSlots, 4, 84, 35)); //component slot 5
            this.addSlot(new Slot(this.craftSlots, 5, 102, 35)); //component slot 6
            this.addSlot(new Slot(this.craftSlots, 6, 66, 53)); //component slot 7
            this.addSlot(new Slot(this.craftSlots, 7, 84, 53)); //component slot 8
            this.addSlot(new Slot(this.craftSlots, 8, 102, 53)); //component slot 9
            this.addSlot(new WorkbenchResultSlot(player, this.craftSlots, this.resultSlots, 9, 144, 35)); //result slot
        });

        this.blockEntity.getCapability(CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY).ifPresent(handler -> {
        });

//        this.tank = tank;

//        fluid.getFluid().getAttributes().getStillTexture();

        addDataSlots(data);
    }

//    public FluidTank getFluid() {
//        return tank;
//    }

    public boolean isSmelting() {
        return data.get(0) > 0;
    }

    public int getFluidLevel() {
        int progress = this.data.get(4);
        int maxProgress = this.data.get(5);
        int progressSize = 52;
//        int i = maxProgress != 0 && progress != 0 ? progress * progressSize / maxProgress : 0;

//        CelestialExploration.LOGGER.debug("fluid level: progress" + progress + " of " + maxProgress + " and should be displaying " + i);

        return maxProgress != 0 && progress != 0 ? progress * progressSize / maxProgress : 0;
    }

    public int getFluidType() {
        return this.data.get(6);
    }

    public String getFluidTypeString() {
        int index = this.data.get(6);

        return switch (index) {
            case 1 -> "Water";
            case 2 -> "Lava";
            case 3 -> "Molten Iron";
            case 4 -> "Molten Steel";
            case 5 -> "Molten Copper";
            case 6 -> "Molten Gold";
            case 8 -> "Molten Aluminum";
            default -> throw new IllegalStateException("Unexpected value: " + index);
        };
    }

    public int getFluidQuantity() {
        return this.data.get(4);
    }

    public int getScaledProgress() {
        int progress = this.data.get(0);
        int maxProgress = this.data.get(1);  // Max Progress
        int progressArrowSize = 19;

        return maxProgress != 0 && progress != 0 ? progress * progressArrowSize / maxProgress : 0;
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

    private static final int TE_INVENTORY_SLOT_COUNT = 12;  // must be the number of slots you have!

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
        return stillValid(ContainerLevelAccess.create(level, blockEntity.getBlockPos()), player, BlockRegistry.WORKBENCH.get());
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

        return j * 13 / i;
    }

    public boolean isLit() {
        return this.data.get(2) > 0;
    }

    protected static void slotChangedCraftingGrid(AbstractContainerMenu menu, Level level, Player player, WorkbenchCraftingContainer craftingContainer, ResultContainer resultContainer) {
        if (!level.isClientSide) {
            ServerPlayer serverplayer = (ServerPlayer)player;
            ItemStack itemstack = ItemStack.EMPTY;
//            Optional<CraftingRecipe> optional = level.getServer().getRecipeManager().getRecipeFor(RecipeType.CRAFTING, craftingContainer, level);
            Optional<WorkbenchCraftingRecipe> recipe = level.getRecipeManager().getRecipeFor(WorkbenchCraftingRecipe.Type.INSTANCE, craftingContainer, level);

            if (recipe.isPresent()) {
//                CraftingRecipe craftingrecipe = optional.get();
                WorkbenchCraftingRecipe craftingRecipe = recipe.get();

                if (resultContainer.setRecipeUsed(level, serverplayer, craftingRecipe)) {
                    itemstack = craftingRecipe.assemble(craftingContainer);
                }
            }

            resultContainer.setItem(9, itemstack);
            menu.setRemoteSlot(9, itemstack);
            serverplayer.connection.send(new ClientboundContainerSetSlotPacket(menu.containerId, menu.incrementStateId(), 9, itemstack));
        }
    }

    @Override
    public void slotsChanged(Container container) {
        this.access.execute((p_39386_, p_39387_) -> {
            slotChangedCraftingGrid(this, p_39386_, this.player, this.craftSlots, this.resultSlots);
        });

//        this.data.set(4, this.craftSlots.getFluidAmount());
//        this.setFluidAmount(this.craftSlots.getFluidAmount());

    }

    public void setFluidAmount(int amount) {
        this.data.set(4, amount);
    }

    @Override
    public void fillCraftSlotsStackedContents(StackedContents p_40117_) {
        this.craftSlots.fillStackedContents(p_40117_);
    }

    @Override
    public void clearCraftingContent() {
        this.craftSlots.clearContent();
        this.resultSlots.clearContent();
    }

    @Override
    public boolean recipeMatches(Recipe<? super WorkbenchCraftingContainer> p_40118_) {
        return p_40118_.matches(this.craftSlots, this.player.level);
    }

    @Override
    public void removed(Player p_39389_) {
        super.removed(p_39389_);
        this.access.execute((p_39371_, p_39372_) -> {
            this.clearContainer(p_39389_, this.craftSlots);
        });
    }

    @Override
    public int getResultSlotIndex() {
        return 9;
    }

    @Override
    public int getGridWidth() {
        return this.craftSlots.getWidth();
    }

    @Override
    public int getGridHeight() {
        return this.craftSlots.getHeight();
    }

    @Override
    public int getSize() {
        return 12;
    }

    @Override
    public RecipeBookType getRecipeBookType() {
        return null;
    }

    @Override
    public boolean shouldMoveToInventory(int p_150553_) {
        return p_150553_ != this.getResultSlotIndex();
    }
}
