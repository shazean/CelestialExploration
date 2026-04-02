package com.shim.celestialexploration.entity.client.dispatchers;

import com.shim.celestialexploration.entity.creatures.Cobblesaurus;
import mod.azure.azurelib.animation.dispatch.command.AzCommand;
import mod.azure.azurelib.animation.play_behavior.AzPlayBehaviors;

public class CobblesaurusDispatcher {
    protected static String controller = "base_controller";

    private static final AzCommand IDLE = AzCommand.create(controller, "idle", AzPlayBehaviors.LOOP);
    private static final AzCommand WALK = AzCommand.create(controller, "walk", AzPlayBehaviors.LOOP);

    private final Cobblesaurus animatable;

    public CobblesaurusDispatcher(Cobblesaurus animatable) {
        this.animatable = animatable;
    }

    public void idle() {
        IDLE.sendForEntity(animatable);
    }
    public void walk() {
        WALK.sendForEntity(animatable);
    }
}