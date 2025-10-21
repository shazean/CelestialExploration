package com.shim.celestialexploration.entity.client.dispatchers;

import mod.azure.azurelib.animation.dispatch.command.AzCommand;
import mod.azure.azurelib.animation.play_behavior.AzPlayBehaviors;
import net.minecraft.world.entity.Entity;

public class SimpleEntityDispatcher {
    private static final AzCommand IDLE = AzCommand.create("base_controller", "idle", AzPlayBehaviors.LOOP);
    private final Entity animatable;

    public SimpleEntityDispatcher(Entity animatable) {
        this.animatable = animatable;
    }

    public void idle() {
        IDLE.sendForEntity(animatable);
    }
}