package com.shim.celestialexploration.item.armor;

import com.shim.celestialexploration.item.CelestialArmorMaterials;
import com.shim.celestialexploration.util.OxygenUtil;
import com.shim.celestiallib.api.armor.ISpacesuit;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.util.Mth;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraftforge.client.event.ColorHandlerEvent;
import org.jetbrains.annotations.Nullable;

import javax.annotation.Nonnull;
import java.util.List;

public class SpacesuitArmorItem extends ArmorItem implements ISpacesuit {
    static String COLOR_TAG = "dye_color";

    public SpacesuitArmorItem(ArmorMaterial material, EquipmentSlot slot, Properties properties) {
        super(material, slot, properties);
    }

    @Override
    public boolean canWalkOnPowderedSnow(ItemStack itemStack, LivingEntity wearer) {
        if (itemStack.getItem() instanceof SpacesuitArmorItem armor)
            return isLightweight(armor) && isBoots(armor);
        else return false;
    }

    public static int getOxygenBoost(ItemStack itemStack, Player player) {
        if (itemStack.getItem() instanceof SpacesuitArmorItem armor) {
            if (isPants(armor) || isBoots(armor))
                return 0; //pants and boots provide no additional oxygen
            if (isChestplate(armor)) {
                if (!player.getInventory().getArmor(3).isEmpty())
                    return OxygenUtil.DEFAULT_SPACESUIT_CHESTPLATE_OXYGEN;
                else return 0; //chestplate only adds to oxygen IF player is wearing a helmet
            }
            if (isHelmet(armor)) {
                if (isLightweight(armor))
                    return OxygenUtil.LIGHTWEIGHT_HELMET_OXYGEN; //lightweight helmet gives the most boost
                return OxygenUtil.DEFAULT_SPACESUIT_HELMET_OXYGEN; //all other spacesuit helmets (and we're sure we're a spacesuit helmet by this point) give a smaller amount
            }
        }
        return 0;
    }

    @Override
    public void onArmorTick(ItemStack itemStack, Level level, Player player) {
        if (itemStack.getItem() instanceof SpacesuitArmorItem armor) {
            if (isHeavyDuty(armor) && (isChestplate(armor) || isPants(armor))) {
                if (!player.hasEffect(MobEffects.MOVEMENT_SLOWDOWN))
                    player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 200, 1, true, false));
            } else if (isLightweight(armor)) {
                if (isChestplate(armor)) {
                    if (!player.hasEffect(MobEffects.MOVEMENT_SPEED))
                        player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 200, 1, true, false));
                } else if (isPants(armor)) {
                    if (!player.hasEffect(MobEffects.JUMP))
                        player.addEffect(new MobEffectInstance(MobEffects.JUMP, 200, 1, true, false));
                }
            }
        }
    }

    public static boolean isLightweight(ArmorItem armor) {
        return armor.getMaterial() == CelestialArmorMaterials.LIGHTWEIGHT;
    }

    public static boolean isHeavyDuty(ArmorItem armor) {
        return armor.getMaterial() == CelestialArmorMaterials.HEAVY_DUTY;
    }

    public static boolean isInsulated(ArmorItem armor) {
        return armor.getMaterial() == CelestialArmorMaterials.INSULATED;
    }

    public static boolean isLongFall(ArmorItem armor) {
        return armor.getMaterial() == CelestialArmorMaterials.LONG_FALL;
    }

    public static boolean isBoots(ArmorItem armor) {
        return armor.getSlot() == EquipmentSlot.FEET;
    }

    public static boolean isHelmet(ArmorItem armor) {
        return armor.getSlot() == EquipmentSlot.HEAD;
    }

    public static boolean isChestplate(ArmorItem armor) {
        return armor.getSlot() == EquipmentSlot.CHEST;
    }

    public static boolean isPants(ArmorItem armor) {
        return armor.getSlot() == EquipmentSlot.LEGS;
    }


    @Override
    public boolean shouldNegateGravity(MobEffect mobEffect, ItemStack itemStack) {
        if (itemStack.getItem() instanceof SpacesuitArmorItem armor)
            return isHeavyDuty(armor) && isBoots(armor);
        else return false;
    }

    @Override
    public void appendHoverText(ItemStack itemStack, @Nullable Level level, List<Component> components, TooltipFlag flag) {

        if (itemStack.getItem() instanceof SpacesuitArmorItem armor) {
            if (isHelmet(armor)) {
                if (isLightweight(armor)) {
                    components.add(new TextComponent(""));
                    components.add(new TranslatableComponent("item.celestialexploration.armor_details.lightweight_helmet"));
                } else if (isHeavyDuty(armor)) {
                    components.add(new TextComponent(""));
                    components.add(new TranslatableComponent("item.celestialexploration.armor_details.heavy_duty_helmet"));
                }
//                if (isInsulated(armor))
//                    components.add(new TranslatableComponent("item.celestialexploration.armor_details.lightweight_helmet"));
            } else if (isChestplate(armor)) {
                if (isLightweight(armor)) {
                    components.add(new TextComponent(""));
                    components.add(new TranslatableComponent("item.celestialexploration.armor_details.lightweight_chestplate"));
                } else if (isHeavyDuty(armor)) {
                    components.add(new TextComponent(""));
                    components.add(new TranslatableComponent("item.celestialexploration.armor_details.heavy_duty_chestplate"));
                }
//                if (isInsulated(armor))
//                    components.add(new TranslatableComponent("item.celestialexploration.armor_details.lightweight_chestpiece"));
            } else if (isPants(armor)) {
                if (isLightweight(armor)) {
                    components.add(new TextComponent(""));
                    components.add(new TranslatableComponent("item.celestialexploration.armor_details.lightweight_leggings"));
                } else if (isHeavyDuty(armor)) {
                    components.add(new TextComponent(""));
                    components.add(new TranslatableComponent("item.celestialexploration.armor_details.heavy_duty_leggings"));
                }
//                if (isInsulated(armor))
//                    components.add(new TranslatableComponent(item."celestialexploration.armor_details.lightweight_leggings"));
            } else if (isBoots(armor)) {
                if (isLightweight(armor)) {
                    components.add(new TextComponent(""));
                    components.add(new TranslatableComponent("item.celestialexploration.armor_details.buoyant_boots"));
                } else if (isHeavyDuty(armor)) {
                    components.add(new TextComponent(""));
                    components.add(new TranslatableComponent("item.celestialexploration.armor_details.gravity_boots"));
                }
//               else if (isInsulated(armor))
//                    components.add(new TranslatableComponent("item.celestialexploration.armor_details.lightweight_boots"));
                else if (isLongFall(armor)) {
                    components.add(new TextComponent(""));
                    components.add(new TranslatableComponent("item.celestialexploration.armor_details.long_fall_boots"));
                }
            }
        }
    }


    public int getColor(@Nonnull ItemStack itemStack) {
        CompoundTag tag = itemStack.getTagElement("display");
        if (tag != null && tag.contains(COLOR_TAG, 99)) return this.validateColorRange(tag.getInt(COLOR_TAG));
        return DyeColor.WHITE.getId();
    }

    public int validateColorRange(int color) {
        return Mth.clamp(color, 0, 15);
    }

    @javax.annotation.Nullable
    public DyeColor getDyeColor(@Nonnull ItemStack itemStack) {
        return DyeColor.byId(this.getColor(itemStack));
    }

    public void clearColor(ItemStack itemStack) {
        this.setColor(itemStack, DyeColor.WHITE.getId());
    }

    public void setColor(ItemStack itemStack, int color) {
        itemStack.getOrCreateTagElement("display").putInt(COLOR_TAG, Mth.clamp(color, 0, 15));
    }

    public void setColor(ItemStack itemStack, DyeColor dyeColor) {
        this.setColor(itemStack, dyeColor.getId());
    }

    public static int getMaterialColor(@Nonnull ItemStack itemStack) {
        if (itemStack.getItem() instanceof SpacesuitArmorItem) {
            CompoundTag tag = itemStack.getTagElement("display");
            if (tag != null && tag.contains(COLOR_TAG, 99)) {
                int color = tag.getInt(COLOR_TAG);
                if (color >= 0) return DyeColor.byId(color).getMaterialColor().col;
            }
        }
//        return -1;
        return DyeColor.LIGHT_GRAY.getMaterialColor().col;
    }

    public static float getColorPredicate(ItemStack itemStack) {
        if (itemStack.getItem() instanceof SpacesuitArmorItem) {
            CompoundTag tag = itemStack.getTagElement("display");
            if (tag != null && tag.contains(COLOR_TAG, 99)) {
                int color = tag.getInt(COLOR_TAG);
                if (color >= 0) {
                    return color / 16.0F;
                }
            }
        }
        return 0.0F;
    }

    public static void registerSpacesuitItemColors(ColorHandlerEvent.Item event, ItemLike... items) {
        event.getItemColors().register((itemStack, layer) -> layer == 1 ? SpacesuitArmorItem.getMaterialColor(itemStack) : -1, items);
    }


}
