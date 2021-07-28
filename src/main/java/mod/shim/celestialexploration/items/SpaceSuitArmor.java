package mod.shim.celestialexploration.items;

import mod.shim.celestialexploration.registry.RegistryItems;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.world.World;

public class SpaceSuitArmor extends ArmorItem {

	public SpaceSuitArmor(IArmorMaterial materialIn, EquipmentSlotType slot, Properties builder) {
		super(materialIn, slot, builder);
	}

	@Override
	public void onArmorTick(ItemStack itemStack, World world, PlayerEntity player) {
		ItemStack boots = player.getItemBySlot(EquipmentSlotType.FEET);
		if(boots.getItem() == RegistryItems.SPACE_SUIT_BOOTS.get()) {
				player.addEffect(new EffectInstance(Effects.JUMP, 50, 1, false, false, false));
				player.addEffect(new EffectInstance(Effects.SLOW_FALLING, 50, 1, false, false, false));
				

		} 
	}
}	