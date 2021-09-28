package mod.shim.celestialexploration.inventory.container;

import java.util.Objects;
import java.util.Optional;

import mod.shim.celestialexploration.registry.RegistryBlocks;
import mod.shim.celestialexploration.registry.RegistryContainerType;
import mod.shim.celestialexploration.tileentity.AssemblyStationTileEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.CraftResultInventory;
import net.minecraft.inventory.CraftingInventory;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.CraftingResultSlot;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.ICraftingRecipe;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.item.crafting.RecipeBookCategory;
import net.minecraft.item.crafting.RecipeItemHelper;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.play.server.SSetSlotPacket;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IWorldPosCallable;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class AssemblyStationContainer extends Container {

	private final CraftingInventory craftSlots = new CraftingInventory(this, 4, 4);
	private final CraftResultInventory resultSlots = new CraftResultInventory();
	public final AssemblyStationTileEntity assemblystationte;
	private final IWorldPosCallable canInteractWithCallable;
	private final PlayerEntity player;

	public AssemblyStationContainer(final int windowId, final PlayerInventory playerInv, final AssemblyStationTileEntity assemblystationte) {
		super(RegistryContainerType.ASSEMBLY_STATION.get(), windowId);
		this.assemblystationte = assemblystationte;
		this.canInteractWithCallable = IWorldPosCallable.create(assemblystationte.getLevel(), assemblystationte.getBlockPos());
		this.player = playerInv.player;


		//TILE ENTITY slot, X-axis (left/right), Y-axis (up/down)
		this.addSlot(new Slot((IInventory) this.craftSlots, 0, 30, 9));
		this.addSlot(new Slot((IInventory) this.craftSlots, 1, 48, 9));
		this.addSlot(new Slot((IInventory) this.craftSlots, 2, 66, 9));
		this.addSlot(new Slot((IInventory) this.craftSlots, 3, 84, 9));
		this.addSlot(new Slot((IInventory) this.craftSlots, 4, 30, 27));
		this.addSlot(new Slot((IInventory) this.craftSlots, 5, 48, 27));
		this.addSlot(new Slot((IInventory) this.craftSlots, 6, 66, 27));
		this.addSlot(new Slot((IInventory) this.craftSlots, 7, 84, 27));
		this.addSlot(new Slot((IInventory) this.craftSlots, 8, 30, 45));
		this.addSlot(new Slot((IInventory) this.craftSlots, 9, 48, 45));
		this.addSlot(new Slot((IInventory) this.craftSlots, 10, 66, 45));
		this.addSlot(new Slot((IInventory) this.craftSlots, 11, 84, 45));
		this.addSlot(new Slot((IInventory) this.craftSlots, 12, 30, 63));
		this.addSlot(new Slot((IInventory) this.craftSlots, 13, 48, 63));
		this.addSlot(new Slot((IInventory) this.craftSlots, 14, 66, 63));
		this.addSlot(new Slot((IInventory) this.craftSlots, 15, 84, 63));

		this.addSlot(new CraftingResultSlot(playerInv.player, this.craftSlots, this.resultSlots, 16, 129, 35));


		//		this.addSlot(new CraftingResultSlot(null, null, (IInventory) assemblystationte, 16, 129, 35));


		//		for (int row = 0; row < 3; row++) {
		//			for (int col = 0; col < 3; col++) {
		//				this.addSlot(new Slot((IInventory) assemblystationte, col, 8 + col * 18, 35 - (4 - row) * 18 - 10));
		//			}
		//		}


		//MAIN PLAYER INVENTORY
		for (int row = 0; row < 3; row++) {
			for (int col = 0; col < 9; col++) {
				this.addSlot(new Slot(playerInv, col + row * 9 + 9, 8 + col * 18, 166 - (4 - row) * 18 - 10 + 10));
			}
		}

		//PLAYER HOTBAR
		for (int col = 0; col < 9; col++) {
			this.addSlot(new Slot(playerInv, col, 8 + col * 18, 142 + 10));
		}


	}

	public AssemblyStationContainer(final int windowId, final PlayerInventory playerInv, final PacketBuffer data) {
		this(windowId, playerInv, getTileEntity(playerInv, data));
	}

	private static AssemblyStationTileEntity getTileEntity(final PlayerInventory playerInv, final PacketBuffer data) {
		Objects.requireNonNull(playerInv, "Player Inventory cannot be null.");
		Objects.requireNonNull(data, "Player Inventory cannot be null.");
		final TileEntity assemblystationte = playerInv.player.level.getBlockEntity(data.readBlockPos());
		if (assemblystationte instanceof AssemblyStationTileEntity) {
			return (AssemblyStationTileEntity) assemblystationte;
		}
		throw new IllegalStateException("Tile entity is not correct");

	}

	protected static void slotChangedCraftingGrid(int p_217066_0_, World p_217066_1_, PlayerEntity p_217066_2_, CraftingInventory p_217066_3_, CraftResultInventory p_217066_4_) {
		if (!p_217066_1_.isClientSide) {
			ServerPlayerEntity serverplayerentity = (ServerPlayerEntity)p_217066_2_;
			ItemStack itemstack = ItemStack.EMPTY;
			Optional<ICraftingRecipe> optional = p_217066_1_.getServer().getRecipeManager().getRecipeFor(IRecipeType.CRAFTING, p_217066_3_, p_217066_1_);
			if (optional.isPresent()) {
				ICraftingRecipe icraftingrecipe = optional.get();
				if (p_217066_4_.setRecipeUsed(p_217066_1_, serverplayerentity, icraftingrecipe)) {
					itemstack = icraftingrecipe.assemble(p_217066_3_);
				}
			}

			p_217066_4_.setItem(0, itemstack);
			serverplayerentity.connection.send(new SSetSlotPacket(p_217066_0_, 16, itemstack));
		}
	}

	public void slotsChanged(IInventory p_75130_1_) {
		this.canInteractWithCallable.execute((p_217069_1_, p_217069_2_) -> {
			slotChangedCraftingGrid(this.containerId, p_217069_1_, this.player, this.craftSlots, this.resultSlots);
		});
	}

	public void fillCraftSlotsStackedContents(RecipeItemHelper p_201771_1_) {
		this.craftSlots.fillStackedContents(p_201771_1_);
	}

	public void clearCraftingContent() {
		this.craftSlots.clearContent();
		this.resultSlots.clearContent();
	}

	public boolean recipeMatches(IRecipe<? super CraftingInventory> p_201769_1_) {
		return p_201769_1_.matches(this.craftSlots, this.player.level);
	}

	public void removed(PlayerEntity p_75134_1_) {
		super.removed(p_75134_1_);
		this.canInteractWithCallable.execute((p_217068_2_, p_217068_3_) -> {
			this.clearContainer(p_75134_1_, p_217068_2_, this.craftSlots);
		});
	}

	@Override //canInteractWith? 14:59 FIXME maybe
	public boolean stillValid(PlayerEntity p_75145_1_) {
		// TODO Auto-generated method stub
		//		return true;
		return stillValid(canInteractWithCallable, p_75145_1_, RegistryBlocks.ASSEMBLY_STATION.get());
	}

	public ItemStack quickMoveStack(PlayerEntity player, int num) {
		ItemStack itemstack = ItemStack.EMPTY;
		Slot slot = this.slots.get(num);
		if (slot != null && slot.hasItem()) {
			ItemStack itemstack1 = slot.getItem();
			itemstack = itemstack1.copy();
			if (num == 0) {
				this.canInteractWithCallable.execute((p_217067_2_, p_217067_3_) -> {
					itemstack1.getItem().onCraftedBy(itemstack1, p_217067_2_, player);
				});
				if (!this.moveItemStackTo(itemstack1, 17, 53, true)) { //10, 46, true
					return ItemStack.EMPTY;
				}

				slot.onQuickCraft(itemstack1, itemstack);
			} else if (num >= 17 && num < 53) { //10, 46
				if (!this.moveItemStackTo(itemstack1, 1, 17, false)) { //1, 10, false
					if (num < 44) { //37
						if (!this.moveItemStackTo(itemstack1, 44, 53, false)) { //37, 46, false
							return ItemStack.EMPTY;
						}
					} else if (!this.moveItemStackTo(itemstack1, 17, 44, false)) { //10, 37, false
						return ItemStack.EMPTY;
					}
				}
			} else if (!this.moveItemStackTo(itemstack1, 17, 53, false)) { //10, 46, false
				return ItemStack.EMPTY;
			}

			if (itemstack1.isEmpty()) {
				slot.set(ItemStack.EMPTY);
			} else {
				slot.setChanged();
			}

			if (itemstack1.getCount() == itemstack.getCount()) {
				return ItemStack.EMPTY;
			}

			ItemStack itemstack2 = slot.onTake(player, itemstack1);
			if (num == 0) {
				player.drop(itemstack2, false);
			}
		}

		return itemstack;
	}

	public boolean canTakeItemForPickAll(ItemStack p_94530_1_, Slot p_94530_2_) {
		return p_94530_2_.container != this.resultSlots && super.canTakeItemForPickAll(p_94530_1_, p_94530_2_);
	}

	public int getResultSlotIndex() {
		return 16;
	}

	public int getGridWidth() {
//		System.out.println(this.craftSlots.getWidth());
		return this.craftSlots.getWidth();
	}

	public int getGridHeight() {
//		System.out.println(this.craftSlots.getHeight());
		return this.craftSlots.getHeight();
	}

	@OnlyIn(Dist.CLIENT)
	public int getSize() {
		return 17;
	}

	@OnlyIn(Dist.CLIENT)
	public RecipeBookCategory getRecipeBookType() {
		return RecipeBookCategory.CRAFTING;
	}

}
