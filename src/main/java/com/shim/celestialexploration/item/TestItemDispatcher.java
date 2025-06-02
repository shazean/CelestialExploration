package com.shim.celestialexploration.item;

import com.shim.celestialexploration.CelestialExploration;
import mod.azure.azurelib.rewrite.animation.dispatch.command.AzCommand;
import mod.azure.azurelib.rewrite.animation.play_behavior.AzPlayBehaviors;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;

public class TestItemDispatcher {
    private static final AzCommand IDLE = AzCommand.create("base_controller", "idle", AzPlayBehaviors.LOOP);

    public void idle(Entity entity, ItemStack itemStack) {
        IDLE.sendForItem(entity, itemStack);
    }
}