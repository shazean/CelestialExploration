package mod.shim.celestialexploration.tools;

//import static mod.shim.celestialexploration.tools.ModArmorMaterial.STEEL_ARMOR;


import java.util.function.Supplier;

import mod.shim.celestialexploration.registry.RegistryItems;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;



public enum ModArmorMaterial implements IArmorMaterial {
	
	
//	   private static final ResourceLocation STEEL_ARMOR = new ResourceLocation("textures/environment/steel_layer_1.png");

		
	   STEEL("steel", 15, new int[]{2, 5, 6, 2}, 9, SoundEvents.ARMOR_EQUIP_IRON, 0.0F, () -> {
		   return Ingredient.of(RegistryItems.STEEL_INGOT.get());
	   });

	private final String name;
	private final int durability;
	private final int[] damageReductionAmount;
	private final int enchantability;
	private final SoundEvent sound;
	private final float toughness;	
	private final Supplier<Ingredient> repairMaterial;
	
	ModArmorMaterial(String name, int durability, int[] damageReductionAmount, int enchantability, SoundEvent sound, float toughness, Supplier<Ingredient> repairMaterial) {
		this.name = name;
		this.durability = durability;
		this.damageReductionAmount = damageReductionAmount;
		this.enchantability = enchantability;
		this.sound = sound;
		this.repairMaterial = repairMaterial;
		this.toughness = toughness;
	}

	@Override
	public int getDurabilityForSlot(EquipmentSlotType slotIn) {
		// TODO Auto-generated method stub
		return durability;
	}

	@Override
	public int getDefenseForSlot(EquipmentSlotType slotIn) {
		// TODO Auto-generated method stub
		return damageReductionAmount[slotIn.getIndex()];
	}

	@Override
	public int getEnchantmentValue() {
		// TODO Auto-generated method stub
		return enchantability;
	}

	@Override
	public SoundEvent getEquipSound() {
		// TODO Auto-generated method stub
		return (SoundEvent) this.sound;
	}

	@Override
	public Ingredient getRepairIngredient() {
		// TODO Auto-generated method stub
		return repairMaterial.get();
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

	@Override
	public float getToughness() {
		// TODO Auto-generated method stub
		return toughness;
	}

	@Override
	public float getKnockbackResistance() {
		// TODO Auto-generated method stub
		return 0;
	}

}
