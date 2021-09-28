package mod.shim.celestialexploration.inventory.container;

import mod.shim.celestialexploration.registry.RegistryItems;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.container.AbstractFurnaceContainer;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;

public class ShuttleFuelSlot extends Slot {
	   private final ShuttleContainer menu;

	   public ShuttleFuelSlot(ShuttleContainer p_i50084_1_, IInventory p_i50084_2_, int p_i50084_3_, int p_i50084_4_, int p_i50084_5_) {
	      super(p_i50084_2_, p_i50084_3_, p_i50084_4_, p_i50084_5_);
	      this.menu = p_i50084_1_;
	   }

	   public boolean mayPlace(ItemStack itemstack) {
		   return isFuel(itemstack);
//	      return this.menu.isFuel(p_75214_1_) || isBucket(p_75214_1_);
	   }

	   public int getMaxStackSize(ItemStack p_178170_1_) {
		   return 1;
		   //	      return isBucket(p_178170_1_) ? 1 : super.getMaxStackSize(p_178170_1_);
	   }

//	   public static boolean isBucket(ItemStack p_178173_0_) {
//	      return p_178173_0_.getItem() == Items.BUCKET;
//	   }
	   
	   public static boolean isFuel(ItemStack p_178173_0_) {
	      return p_178173_0_.getItem() == RegistryItems.LIQUID_OXYGEN.get();
	   }
	   
	}