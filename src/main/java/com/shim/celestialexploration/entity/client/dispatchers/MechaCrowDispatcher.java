package com.shim.celestialexploration.entity.client.dispatchers;

import com.shim.celestialexploration.entity.robots.MechaCrow;
import mod.azure.azurelib.animation.dispatch.command.AzCommand;
import mod.azure.azurelib.animation.play_behavior.AzPlayBehaviors;

public class MechaCrowDispatcher {
    protected static String controller = "base_controller";

    private static final AzCommand IDLE = AzCommand.create(controller, "idle", AzPlayBehaviors.LOOP);
    private static final AzCommand HOP = AzCommand.create(controller, "hop", AzPlayBehaviors.LOOP);

    private final MechaCrow animatable;

    public MechaCrowDispatcher(MechaCrow animatable) {
        this.animatable = animatable;
    }

    public void idle() {
        IDLE.sendForEntity(animatable);
    }

    public void hop() {
        HOP.sendForEntity(animatable);
    }

}