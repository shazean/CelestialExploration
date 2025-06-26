package com.shim.celestialexploration.entity.client.dispatchers;

import com.shim.celestialexploration.entity.robots.Rover;
import mod.azure.azurelib.rewrite.animation.dispatch.command.AzCommand;
import mod.azure.azurelib.rewrite.animation.play_behavior.AzPlayBehaviors;

public class RoverDispatcher {
    protected static String controller = "base_controller";

    private static final AzCommand IDLE = AzCommand.create(controller, "idle", AzPlayBehaviors.LOOP);
    private static final AzCommand ROLL = AzCommand.create(controller, "rolling", AzPlayBehaviors.LOOP);

    private final Rover animatable;

    public RoverDispatcher(Rover animatable) {
        this.animatable = animatable;
    }

    public void idle() {
        IDLE.sendForEntity(animatable);
    }
    public void roll() {
        ROLL.sendForEntity(animatable);
    }
}