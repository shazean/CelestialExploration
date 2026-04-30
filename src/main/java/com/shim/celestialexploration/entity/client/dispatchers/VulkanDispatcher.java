package com.shim.celestialexploration.entity.client.dispatchers;

import com.shim.celestialexploration.entity.mob.Vulkan;
import mod.azure.azurelib.animation.dispatch.command.AzCommand;
import mod.azure.azurelib.animation.play_behavior.AzPlayBehaviors;

public class VulkanDispatcher {
    protected static String controller = "base_controller";

    private static final AzCommand IDLE = AzCommand.create(controller, "idle", AzPlayBehaviors.LOOP);

    private final Vulkan animatable;

    public VulkanDispatcher(Vulkan animatable) {
        this.animatable = animatable;
    }

    public void idle() {
        IDLE.sendForEntity(animatable);
    }
}