package mod.shim.celestialexploration.tools;

import java.util.function.Supplier;

import mod.shim.celestialexploration.registry.RegistryItems;
import net.minecraft.item.IItemTier;
import net.minecraft.item.crafting.Ingredient;

public enum ModItemTier implements IItemTier {
	
	
	STEEL(2, 333, 7.0F, 0, 14, () -> {
		return Ingredient.of(RegistryItems.STEEL_SWORD.get());
	}); //if add new tier, change this semicolon to a comma, and add this same stuff below for new tier template thing
	
	private final int harvestLevel;
	private final int maxUses;
	private final float efficiency;
	private final float attackDamage;
	private final int enchantability;
	private final Supplier<Ingredient> repairMaterial;
	
	ModItemTier(int harvestLevel, int maxUses, float efficiency, float attackDamage, int enchantability, Supplier<Ingredient> repairMaterial) {
		this.harvestLevel = harvestLevel;
		this.maxUses = maxUses;
		this.efficiency = efficiency;
		this.attackDamage = attackDamage;
		this.enchantability = enchantability;
		this.repairMaterial = repairMaterial;
	}
	
	@Override
	public int getUses() {
		// TODO Auto-generated method stub
		return maxUses;
	}

	@Override
	public float getSpeed() {
		// TODO Auto-generated method stub
		return efficiency;
	}

	@Override
	public float getAttackDamageBonus() {
		// TODO Auto-generated method stub
		return attackDamage;
	}

	@Override
	public int getLevel() {
		// TODO Auto-generated method stub
		return harvestLevel;
	}


	@Override
	public int getEnchantmentValue() {
		// TODO Auto-generated method stub
		return enchantability;
	}

	@Override
	public Ingredient getRepairIngredient() {
		return repairMaterial.get();
	}

}
