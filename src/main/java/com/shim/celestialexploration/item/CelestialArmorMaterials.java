package com.shim.celestialexploration.item;


import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestialexploration.registry.CelestialItems;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.LazyLoadedValue;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.Tags;

import java.util.function.Supplier;

public enum CelestialArmorMaterials implements ArmorMaterial {
    STEEL("steel", 20, new int[]{2, 5, 7, 2}, 9, SoundEvents.ARMOR_EQUIP_IRON, 0.0F, 0.0F, () -> Ingredient.of(CelestialItems.STEEL_INGOT.get())),


    SIMPLE("simple", 16, new int[]{2, 5, 6, 2}, 9, SoundEvents.ARMOR_EQUIP_LEATHER, 0.0F, 0.0F, () -> Ingredient.of(CelestialItems.STEEL_INGOT.get())),
    HEAVY_DUTY("heavy_duty", 34, new int[]{3, 6, 8, 3}, 15, SoundEvents.ARMOR_EQUIP_DIAMOND, 2.5F, 0.1F, () -> Ingredient.of(Tags.Items.GEMS_DIAMOND)),
    LIGHTWEIGHT("lightweight", 14, new int[]{2, 5, 6, 2}, 15, SoundEvents.ARMOR_EQUIP_IRON, 0.0F, 0.0F, () -> Ingredient.of(Tags.Items.GEMS_DIAMOND)),
    INSULATED("insulated", 20, new int[]{2, 5, 6, 2}, 15, SoundEvents.ARMOR_EQUIP_LEATHER, 0.0F, 0.0F, () -> Ingredient.of(Tags.Items.GEMS_DIAMOND)),
    LONG_FALL("long_fall", 22, new int[]{1, 2, 3, 1}, 20, SoundEvents.ARMOR_EQUIP_IRON, 0.1F, 0.0F, () -> Ingredient.of(Tags.Items.GEMS_DIAMOND)),

    //basic space suit, low space suit, high space suit, regulator space suit
    BASIC_SPACESUIT("basic_space_suit", 20, new int[]{2, 5, 6, 2}, 9, SoundEvents.ARMOR_EQUIP_IRON, 0.0F, 0.0F, () -> Ingredient.of(CelestialItems.STEEL_INGOT.get())),
    THERMAL_SPACESUIT("thermal_space_suit", 28, new int[]{2, 5, 6, 2}, 10, SoundEvents.ARMOR_EQUIP_IRON, 1.0F, 0.0F, () -> Ingredient.of(Tags.Items.GEMS_DIAMOND)),
    HEAVY_DUTY_SPACESUIT("heavy_duty_space_suit", 28, new int[]{2, 5, 6, 2}, 10, SoundEvents.ARMOR_EQUIP_IRON, 1.0F, 0.0F, () -> Ingredient.of(Tags.Items.GEMS_DIAMOND)),
    ADVANCED_SPACESUIT("advanced_space_suit", 33, new int[]{3, 6, 8, 3}, 15, SoundEvents.ARMOR_EQUIP_DIAMOND, 2.5F, 0.0F, () -> Ingredient.of(Tags.Items.GEMS_DIAMOND));


    private static final int[] HEALTH_PER_SLOT = new int[]{12, 14, 17, 10};
    private final String name;
    private final int durabilityMultiplier;
    private final int[] slotProtections;
    private final int enchantmentValue;
    private final SoundEvent sound;
    private final float toughness;
    private final float knockbackResistance;
    private final LazyLoadedValue<Ingredient> repairIngredient;

    CelestialArmorMaterials(String name, int durability, int[] slotProtections, int enchantmentValue, SoundEvent sound, float toughness, float knockback, Supplier<Ingredient> repairIngredient) {
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