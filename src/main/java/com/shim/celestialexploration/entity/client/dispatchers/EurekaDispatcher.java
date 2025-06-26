package com.shim.celestialexploration.entity.client.dispatchers;

import com.shim.celestialexploration.entity.ambient.Eureka;
import mod.azure.azurelib.rewrite.animation.dispatch.command.AzCommand;
import mod.azure.azurelib.rewrite.animation.play_behavior.AzPlayBehaviors;

public class EurekaDispatcher {
    private static final AzCommand IDLE_COMMAND = AzCommand.create(
            "base_controller",
            "idle",
            AzPlayBehaviors.LOOP
    );

    private final Eureka eureka;

    public EurekaDispatcher(Eureka animatable) {
        this.eureka = animatable;
    }

    public void idle() {
        IDLE_COMMAND.sendForEntity(eureka);
    }
}