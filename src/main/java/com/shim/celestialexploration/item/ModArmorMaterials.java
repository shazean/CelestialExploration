package com.shim.celestialexploration.item;


import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestialexploration.registry.ItemRegistry;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.LazyLoadedValue;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.Tags;

import java.util.function.Supplier;

public enum ModArmorMaterials implements ArmorMaterial {
    STEEL("steel", 20, new int[]{2, 5, 7, 2}, 9, SoundEvents.ARMOR_EQUIP_IRON, 0.0F, 0.0F, () -> Ingredient.of(ItemRegistry.STEEL_INGOT.get())),

    //basic space suit, low space suit, high space suit, regulator space suit

    BASIC_SPACE_SUIT("basic_space_suit", 20, new int[]{2, 5, 6, 2}, 9, SoundEvents.ARMOR_EQUIP_IRON, 0.0F, 0.0F, () -> Ingredient.of(ItemRegistry.STEEL_INGOT.get())),
    THERMAL_SPACE_SUIT("thermal_space_suit", 28, new int[]{2, 5, 6, 2}, 10, SoundEvents.ARMOR_EQUIP_IRON, 1.0F, 0.0F, () -> Ingredient.of(Tags.Items.GEMS_DIAMOND)),
    HEAVY_DUTY_SPACE_SUIT("heavy_duty_space_suit", 28, new int[]{2, 5, 6, 2}, 10, SoundEvents.ARMOR_EQUIP_IRON, 1.0F, 0.0F, () -> Ingredient.of(Tags.Items.GEMS_DIAMOND)),
    ADVANCED_SPACE_SUIT("advanced_space_suit", 33, new int[]{3, 6, 8, 3}, 15, SoundEvents.ARMOR_EQUIP_DIAMOND, 2.5F, 0.0F, () -> Ingredient.of(Tags.Items.GEMS_DIAMOND));


//    IRON_SPACE_SUIT("iron_space_suit", 16, new int[]{2, 5, 6, 2}, 10, SoundEvents.ARMOR_EQUIP_IRON, 0.1F, 0.0F, () -> Ingredient.of(Tags.Items.INGOTS_IRON)),
//
//    STEEL_SPACE_SUIT("steel_space_suit", 21, new int[]{2, 5, 7, 2}, 10, SoundEvents.ARMOR_EQUIP_IRON, 0.1F, 0.0F, () -> Ingredient.of(ItemRegistry.STEEL_INGOT.get())),
//
//    COPPER_SPACE_SUIT("copper_space_suit", 13, new int[]{2, 5, 6, 2}, 20, SoundEvents.ARMOR_EQUIP_GOLD, 0.1F, 0.0F, () -> Ingredient.of(Tags.Items.INGOTS_COPPER)),
//
//    GOLD_SPACE_SUIT("gold_space_suit", 8, new int[]{1, 3, 5, 2}, 28, SoundEvents.ARMOR_EQUIP_GOLD, 0.1F, 0.0F, () -> Ingredient.of(Tags.Items.INGOTS_GOLD)),
//
//    DIAMOND_SPACE_SUIT("diamond_space_suit", 35, new int[]{3, 6, 8, 3}, 12, SoundEvents.ARMOR_EQUIP_DIAMOND, 2.1F, 0.0F, () -> Ingredient.of(Tags.Items.GEMS_DIAMOND)),
//
//    NETHERITE_SPACE_SUIT("netherite_space_suit", 39, new int[]{3, 7, 9, 3}, 17, SoundEvents.ARMOR_EQUIP_NETHERITE, 3.3F, 0.1F, () -> Ingredient.of(Tags.Items.INGOTS_NETHERITE));

//    LEATHER("leather", 5, new int[]{1, 2, 3, 1}, 15, SoundEvents.ARMOR_EQUIP_LEATHER, 0.0F, 0.0F, () -> Ingredient.of(Items.LEATHER)),
//    CHAIN("chainmail", 15, new int[]{1, 4, 5, 2}, 12, SoundEvents.ARMOR_EQUIP_CHAIN, 0.0F, 0.0F, () -> Ingredient.of(Items.IRON_INGOT);
//    IRON("iron", 15, new int[]{2, 5, 6, 2}, 9, SoundEvents.ARMOR_EQUIP_IRON, 0.0F, 0.0F, () -> Ingredient.of(Items.IRON_INGOT);
//    GOLD("gold", 7, new int[]{1, 3, 5, 2}, 25, SoundEvents.ARMOR_EQUIP_GOLD, 0.0F, 0.0F, () -> Ingredient.of(Items.GOLD_INGOT);
//    DIAMOND("diamond", 33, new int[]{3, 6, 8, 3}, 10, SoundEvents.ARMOR_EQUIP_DIAMOND, 2.0F, 0.0F, () -> Ingredient.of(Items.DIAMOND);
//    TURTLE("turtle", 25, new int[]{2, 5, 6, 2}, 9, SoundEvents.ARMOR_EQUIP_TURTLE, 0.0F, 0.0F, () -> Ingredient.of(Items.SCUTE);
//    NETHERITE("netherite", 37, new int[]{3, 6, 8, 3}, 15, SoundEvents.ARMOR_EQUIP_NETHERITE, 3.0F, 0.1F, () -> Ingredient.of(Items.NETHERITE_INGOT);

    private static final int[] HEALTH_PER_SLOT = new int[]{13, 15, 16, 11};
    private final String name;
    private final int durabilityMultiplier;
    private final int[] slotProtections;
    private final int enchantmentValue;
    private final SoundEvent sound;
    private final float toughness;
    private final float knockbackResistance;
    private final LazyLoadedValue<Ingredient> repairIngredient;

    ModArmorMaterials(String name, int durability, int[] slotProtections, int enchantmentValue, SoundEvent sound, float toughness, float knockback, Supplier<Ingredient> repairIngredient) {
        this.name = name;
        this.durabilityMultiplier = durability;
        this.slotProtections = slotProtections;
        this.enchantmentValue = enchantmentValue;
        this.sound = sound;
        this.toughness = toughness;
        this.knockbackResistance = knockback;
        this.repairIngredient = new LazyLoadedValue<>(repairIngredient);
    }

    public int getDurabilityForSlot(EquipmentSlot slot) {
        return HEALTH_PER_SLOT[slot.getIndex()] * this.durabilityMultiplier;
    }

    public int getDefenseForSlot(EquipmentSlot slot) {
        return this.slotProtections[slot.getIndex()];
    }

    public int getEnchantmentValue() {
        return this.enchantmentValue;
    }

    public SoundEvent getEquipSound() {
        return this.sound;
    }

    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }

    public String getName() {
        return CelestialExploration.MODID + ":" + this.name;
    }

    public float getToughness() {
        return this.toughness;
    }

    public float getKnockbackResistance() {
        return this.knockbackResistance;
    }
}