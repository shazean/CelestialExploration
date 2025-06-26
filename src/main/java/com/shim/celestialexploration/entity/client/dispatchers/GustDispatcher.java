package com.shim.celestialexploration.entity.client.dispatchers;

import com.shim.celestialexploration.entity.mob.Gust;
import mod.azure.azurelib.rewrite.animation.dispatch.command.AzCommand;
import mod.azure.azurelib.rewrite.animation.play_behavior.AzPlayBehaviors;

public class GustDispatcher {
    protected static String controller = "base_controller";

    private static final AzCommand IDLE = AzCommand.create(controller, "idle", AzPlayBehaviors.LOOP);
    private static final AzCommand EXPLODE = AzCommand.create(controller, "explode", AzPlayBehaviors.LOOP);

    private final Gust animatable;

    public GustDispatcher(Gust animatable) {
        this.animatable = animatable;
    }

    public void idle() {
        IDLE.sendForEntity(animatable);
    }

    public void explode() {
        EXPLODE.sendForEntity(animatable);
    }
}