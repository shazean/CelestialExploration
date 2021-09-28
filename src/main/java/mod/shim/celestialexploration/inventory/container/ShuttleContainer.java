package mod.shim.celestialexploration.inventory.container;

import mod.shim.celestialexploration.registry.RegistryContainerType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.IIntArray;
import net.minecraft.util.IntArray;
import net.minecraft.world.World;

public class ShuttleContainer extends Container {

	private final IInventory container;
	private final IIntArray data;
	protected final World level;


	public ShuttleContainer(int p_i241921_4_, PlayerInventory p_i241921_5_, PacketBuffer data) {
		this(RegistryContainerType.SHUTTLE.get(), p_i241921_4_, p_i241921_5_, new Inventory(19), new IntArray(20));
	}

	public ShuttleContainer(ContainerType<?> p_i241922_1_, int p_i241922_4_, PlayerInventory playerInv, IInventory inv, IIntArray p_i241922_7_) {
		super(p_i241922_1_, p_i241922_4_);
		checkContainerSize(inv, 19);
		checkContainerDataCount(p_i241922_7_, 20);
		this.container = inv;
		this.data = p_i241922_7_;
		this.level = playerInv.player.level;
		//		this.addSlot(new Slot(inv, 0, 56, 17));
		this.addSlot(new ShuttleFuelSlot(this, inv, 18, 22, 35));
		//		      this.addSlot(new FurnaceFuelSlot(this, p_i241922_6_, 1, 56, 53));
		//		      this.addSlot(new FurnaceResultSlot(p_i241922_5_.player, p_i241922_6_, 2, 116, 35));


		//3 rows container
		for(int j = 0; j < 3; ++j) {
			for(int k = 0; k < 6; ++k) {
				this.addSlot(new Slot(inv, k + j * 6, 62 + k * 18, 17 + j * 18)); //18, 14
			}
		}

		//player inventory
		for(int i = 0; i < 3; ++i) {
			for(int j = 0; j < 9; ++j) {
				this.addSlot(new Slot(playerInv, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
			}
		}

		//player hotbar
		for(int k = 0; k < 9; ++k) {
			this.addSlot(new Slot(playerInv, k, 8 + k * 18, 142));
		}

		this.addDataSlots(p_i241922_7_);
	}

	@Override
	public boolean stillValid(PlayerEntity p_75145_1_) {
		// TODO Auto-generated method stub
		return this.container.stillValid(p_75145_1_);
		//		return false;
	}

	@Override
	public void removed(PlayerEntity p_75134_1_) {
		super.removed(p_75134_1_);
		this.container.stopOpen(p_75134_1_);
	}

	public ItemStack quickMoveStack(PlayerEntity p_82846_1_, int p_82846_2_) {
		ItemStack itemstack = ItemStack.EMPTY;
		Slot slot = this.slots.get(p_82846_2_);
		if (slot != null && slot.hasItem()) {
			ItemStack itemstack1 = slot.getItem();
			itemstack = itemstack1.copy();
			if (p_82846_2_ == 2) {
				if (!this.moveItemStackTo(itemstack1, 3, 39, true)) {
					return ItemStack.EMPTY;
				}

				slot.onQuickCraft(itemstack1, itemstack);
			} else if (p_82846_2_ != 1 && p_82846_2_ != 0) {
				//	            if (this.canSmelt(itemstack1)) {
				//	               if (!this.moveItemStackTo(itemstack1, 0, 1, false)) {
				//	                  return ItemStack.EMPTY;
				//	               }
				//	            } else if (this.isFuel(itemstack1)) {
				//	               if (!this.moveItemStackTo(itemstack1, 1, 2, false)) {
				//	                  return ItemStack.EMPTY;
				//	               }
				//	            } else
				if (p_82846_2_ >= 3 && p_82846_2_ < 30) {
					if (!this.moveItemStackTo(itemstack1, 30, 39, false)) {
						return ItemStack.EMPTY;
					}
				} else if (p_82846_2_ >= 30 && p_82846_2_ < 39 && !this.moveItemStackTo(itemstack1, 3, 30, false)) {
					return ItemStack.EMPTY;
				}
			} else if (!this.moveItemStackTo(itemstack1, 3, 39, false)) {
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

			slot.onTake(p_82846_1_, itemstack1);
		}

		return itemstack;
	}

}