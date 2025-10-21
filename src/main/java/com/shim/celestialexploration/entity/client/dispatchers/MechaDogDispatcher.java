package com.shim.celestialexploration.entity.client.dispatchers;

import com.shim.celestialexploration.entity.robots.MechaDog;
import mod.azure.azurelib.animation.dispatch.command.AzCommand;
import mod.azure.azurelib.animation.play_behavior.AzPlayBehaviors;

public class MechaDogDispatcher {
    protected static String controller = "base_controller";

    private static final AzCommand IDLE = AzCommand.create(controller, "idle", AzPlayBehaviors.LOOP);
    private static final AzCommand WILD_IDLE = AzCommand.create(controller, "idle_wild", AzPlayBehaviors.LOOP);
    private static final AzCommand WALK = AzCommand.create(controller, "walk", AzPlayBehaviors.LOOP);
    private static final AzCommand WILD_WALK = AzCommand.create(controller, "walk_wild", AzPlayBehaviors.LOOP);
    private static final AzCommand SIT = AzCommand.create(controller, "sit", AzPlayBehaviors.LOOP);

    private final MechaDog animatable;

    public MechaDogDispatcher(MechaDog animatable) {
        this.animatable = animatable;
    }

    public void idle() {
        if (animatable.isTame()) {
            IDLE.sendForEntity(animatable);
        } else {
            WILD_IDLE.sendForEntity(animatable);
        }
    }

    public void sit() {
        SIT.sendForEntity(animatable);
    }

    public void walk() {
        if (animatable.isTame()) {
            WALK.sendForEntity(animatable);
        } else {
            WILD_WALK.sendForEntity(animatable);
        }
    }
}