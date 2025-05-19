package com.shim.celestialexploration.item.armor;

import mod.azure.azurelib.rewrite.animation.dispatch.command.AzCommand;
import mod.azure.azurelib.rewrite.animation.play_behavior.AzPlayBehaviors;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;

public class SpacesuitDispatcher {
    private static final AzCommand EQUIP_COMMAND = AzCommand.create(
            "base_controller",
            "equipping",
            AzPlayBehaviors.LOOP
    );

    public void equip(Entity entity, ItemStack itemStack) {
        EQUIP_COMMAND.sendForItem(entity, itemStack);
    }
}