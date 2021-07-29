package mod.shim.celestialexploration.inventory.container;

import java.util.List;
import java.util.Objects;

import javax.annotation.Nullable;

import mod.shim.celestialexploration.items.crafting.OxygenCompressorRecipe;
import mod.shim.celestialexploration.registry.RegistryBlocks;
import mod.shim.celestialexploration.registry.RegistryContainerType;
import mod.shim.celestialexploration.tileentity.OxygenCompressorTileEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.Slot;
import net.minecraft.network.PacketBuffer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IWorldPosCallable;
import net.minecraft.world.World;

public class OxygenCompressorContainer extends Container {

	
	public final OxygenCompressorTileEntity oxcompte;
	private final IWorldPosCallable canInteractWithCallable;
	
	public OxygenCompressorContainer(final int windowId, final PlayerInventory playerInv, final OxygenCompressorTileEntity oxcompte) {
		super(RegistryContainerType.OXYGEN_COMPRESSOR.get(), windowId);
		this.oxcompte = oxcompte;
		this.canInteractWithCallable = IWorldPosCallable.create(oxcompte.getLevel(), oxcompte.getBlockPos());
		
		
		//TILE ENTITY
		this.addSlot(new Slot((IInventory) oxcompte, 0, 80, 35));
		
		//MAIN PLAYER INVENTORY
		for (int row = 0; row < 3; row++) {
			for (int col = 0; col < 9; col++) {
				this.addSlot(new Slot(playerInv, col + row * 9 + 9, 8 + col * 18, 166 - (4 - row) * 18 - 10));
			}
		}

		//PLAYER HOTBAR
		for (int col = 0; col < 9; col++) {
			this.addSlot(new Slot(playerInv, col, 8 + col * 18, 142));
		}

		
	}

	public OxygenCompressorContainer(final int windowId, final PlayerInventory playerInv, final PacketBuffer data) {
		this(windowId, playerInv, getTileEntity(playerInv, data));
	}
	
	private static OxygenCompressorTileEntity getTileEntity(final PlayerInventory playerInv, final PacketBuffer data) {
		Objects.requireNonNull(playerInv, "Player Inventory cannot be null.");
		Objects.requireNonNull(data, "Player Inventory cannot be null.");
		final TileEntity oxcomp = playerInv.player.level.getBlockEntity(data.readBlockPos());
		if (oxcomp instanceof OxygenCompressorTileEntity) {
			return (OxygenCompressorTileEntity) oxcomp;
		}
		throw new IllegalStateException("Tile entity is not correct");
		
	}

	  
	
	@Override //canInteractWith? 14:59 FIXME maybe
	public boolean stillValid(PlayerEntity p_75145_1_) {
		// TODO Auto-generated method stub
//		return true;
		return stillValid(canInteractWithCallable, p_75145_1_, RegistryBlocks.OXYGEN_COMPRESSOR.get());
	}
	
	

////	FIXME 19:39
//	quickMoveStack, check AbstractFurnaceContainer
//	@Override
//	public ItemStack transferStackInSlot(PlayerEntity playerIn, int index) {
//		ItemStack stack = ItemStack.EMPTY;
//		Slot slot = this.inventorySlots.get(index);
//		if (slot != null && slot.getHasStack()) {
//			ItemStack stack1 = slot.getStack();
//			stack = stack1.copy();
//			if (index < 36 && !this.mergeItemStack(stack1, OxygenCompressorTileEntity.slots, this.inventorySlots.size(), false)) {
//				return ItemStack.EMPTY;
//			}
//			if (index < 36 && !this.mergeItemStack(stack1, 0, OxygenCompressorTileEntity.slots, false)) {
//				return ItemStack.EMPTY;
//			}
//		}
//		return stack;
//	}
	

	
}
