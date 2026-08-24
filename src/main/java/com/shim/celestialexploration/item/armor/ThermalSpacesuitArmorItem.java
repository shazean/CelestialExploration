package com.shim.celestialexploration.item.armor;

import com.google.common.collect.ImmutableMap;
import com.shim.celestialexploration.item.CelestialArmorMaterials;
import com.shim.celestialexploration.registry.CelestialItems;
import com.shim.celestiallib.api.armor.ISpacesuit;
import com.shim.celestiallib.api.effects.GravityEffect;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

import java.util.List;
import java.util.Map;

public class ThermalSpacesuitArmorItem extends ArmorItem implements ISpacesuit {
    private static final Map<ArmorMaterial, MobEffectInstance> MATERIAL_TO_EFFECT_MAP = (new ImmutableMap.Builder<ArmorMaterial, MobEffectInstance>()).put(CelestialArmorMaterials.THERMAL_SPACESUIT, new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 200, 1, false, false)).build();

    public ThermalSpacesuitArmorItem(EquipmentSlot slot, Properties properties) {
        super(CelestialArmorMaterials.THERMAL_SPACESUIT, slot, properties);
    }

    @Override
    public void onArmorTick(ItemStack stack, Level world, Player player) {
        if(!world.isClientSide()) {
            if(hasFullSuitOfArmorOn(player)) {
                evaluateArmorEffects(player);
            }
        }
    }

    @Override
    public boolean canWalkOnPowderedSnow(ItemStack stack, LivingEntity wearer) {
        return stack.getItem() instanceof ThermalSpacesuitArmorItem && ((ArmorItem) stack.getItem()).getSlot() == EquipmentSlot.FEET;
//        return super.canWalkOnPowderedSnow(stack, wearer);
    }

    public boolean isGravityBoots(ItemStack stack) {
        return stack.getItem() instanceof ThermalSpacesuitArmorItem && ((ArmorItem) stack.getItem()).getSlot() == EquipmentSlot.FEET;
    }

    private void evaluateArmorEffects(Player player) {
        for (Map.Entry<ArmorMaterial, MobEffectInstance> entry : MATERIAL_TO_EFFECT_MAP.entrySet()) {
            ArmorMaterial mapArmorMaterial = entry.getKey();
            MobEffectInstance mapStatusEffect = entry.getValue();

            if(hasCorrectArmorOn(mapArmorMaterial, player)) {
                addStatusEffectForMaterial(player, mapArmorMaterial, mapStatusEffect);
            }
        }
    }

    private void addStatusEffectForMaterial(Player player, ArmorMaterial mapArmorMaterial, MobEffectInstance mapStatusEffect) {
        boolean hasPlayerEffect = player.hasEffect(mapStatusEffect.getEffect());

        if(hasCorrectArmorOn(mapArmorMaterial, player) && !hasPlayerEffect) {
            player.addEffect(new MobEffectInstance(mapStatusEffect.getEffect(), mapStatusEffect.getDuration(), mapStatusEffect.getAmplifier(), mapStatusEffect.isAmbient(), mapStatusEffect.isVisible()));
        }
    }

    private boolean hasFullSuitOfArmorOn(Player player) {
        ItemStack boots = player.getInventory().getArmor(0);
        ItemStack leggings = player.getInventory().getArmor(1);
        ItemStack breastplate = player.getInventory().getArmor(2);
        ItemStack helmet = player.getInventory().getArmor(3);

        return !helmet.isEmpty() && !breastplate.isEmpty()
                && !leggings.isEmpty() && !boots.isEmpty();
    }

    private boolean hasCorrectArmorOn(ArmorMaterial material, Player player) {
        for (ItemStack armorStack: player.getInventory().armor) {
            if(!(armorStack.getItem() instanceof ArmorItem)) {
                return false;
            }
        }

        ArmorItem boots = ((ArmorItem)player.getInventory().getArmor(0).getItem());
        ArmorItem leggings = ((ArmorItem)player.getInventory().getArmor(1).getItem());
        ArmorItem breastplate = ((ArmorItem)player.getInventory().getArmor(2).getItem());
        ArmorItem helmet = ((ArmorItem)player.getInventory().getArmor(3).getItem());

        return helmet.getMaterial() == material && breastplate.getMaterial() == material &&
                leggings.getMaterial() == material && boots.getMaterial() == material;
    }

    @Override
    public void appendHoverText(ItemStack itemStack, @javax.annotation.Nullable Level level, List<Component> components, TooltipFlag tooltipFlag) {

        components.add(new TextComponent(""));

        components.add(new TranslatableComponent("item.celestialexploration.armor_details.when_set_complete").withStyle(ChatFormatting.GRAY));
        components.add(new TranslatableComponent("item.celestialexploration.armor_details.thermal_full_spacesuit").withStyle(ChatFormatting.DARK_PURPLE));

        if (itemStack.is(CelestialItems.THERMAL_SPACESUIT_BOOTS.get())) {
            components.add(new TranslatableComponent("item.celestialexploration.armor_details.when_worn").withStyle(ChatFormatting.GRAY));
            components.add(new TranslatableComponent("item.celestialexploration.armor_details.thermal_spacesuit_boots_1").withStyle(ChatFormatting.BLUE));
            components.add(new TranslatableComponent("item.celestialexploration.armor_details.thermal_spacesuit_boots_2").withStyle(ChatFormatting.BLUE));

        }
    }

    @Override
    public boolean shouldNegateGravity(MobEffect mobEffect, ItemStack itemStack) {
        return itemStack.is(CelestialItems.THERMAL_SPACESUIT_BOOTS.get()) && mobEffect instanceof GravityEffect gravity && gravity.isLowGravity();
    }
}