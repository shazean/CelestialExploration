package com.shim.celestialexploration.entity.client.dispatchers;

import com.shim.celestialexploration.entity.vehicle.Spaceship;
import mod.azure.azurelib.rewrite.animation.dispatch.command.AzCommand;
import mod.azure.azurelib.rewrite.animation.play_behavior.AzPlayBehaviors;

public class SpaceshipDispatcher {
    protected static String controller = "base_controller";

    private static final AzCommand IDLE = AzCommand.create(
            controller,
            "idle",
            AzPlayBehaviors.LOOP
    );

    private static final AzCommand FLYING = AzCommand.create(
            controller,
            "flying",
            AzPlayBehaviors.LOOP
    );

    private final Spaceship spaceship;

    public SpaceshipDispatcher(Spaceship animatable) {
        this.spaceship = animatable;
    }

    public void idle() {
        IDLE.sendForEntity(spaceship);
    }

    public void flying() {
        FLYING.sendForEntity(spaceship);
    }
}