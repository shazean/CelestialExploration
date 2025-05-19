package com.shim.celestialexploration.item.armor;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;


public class SpacesuitArmorItem extends ArmorItem {
    public final SpacesuitDispatcher dispatcher;

    public SpacesuitArmorItem(ArmorMaterial material, EquipmentSlot slot, Properties properties) {
        super(material, slot, properties);
        this.dispatcher = new SpacesuitDispatcher();
    }

    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        if (!level.isClientSide) {
            // This is where you now trigger an animation to play
            dispatcher.equip(player, player.getItemBySlot(getSlot()));
        }
        return super.use(level, player, hand);
    }
}