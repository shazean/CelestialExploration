package com.shim.celestialexploration.entity.client.dispatchers;

import com.shim.celestialexploration.entity.vehicle.Buggy;
import mod.azure.azurelib.animation.dispatch.command.AzCommand;
import mod.azure.azurelib.animation.play_behavior.AzPlayBehaviors;

public class BuggyDispatcher {
    protected static String controller = "base_controller";
    private final Buggy buggy;

    private static final AzCommand IDLE = AzCommand.create(controller, "idle", AzPlayBehaviors.LOOP);
    private static final AzCommand FORWARD = AzCommand.create(controller, "forward", AzPlayBehaviors.LOOP);
    private static final AzCommand BACKWARD = AzCommand.create(controller, "backward", AzPlayBehaviors.LOOP);
    private static final AzCommand FORWARD_LEFT = AzCommand.create(controller, "forward_left", AzPlayBehaviors.LOOP);
    private static final AzCommand FORWARD_RIGHT = AzCommand.create(controller, "forward_right", AzPlayBehaviors.LOOP);
    private static final AzCommand BACKWARD_LEFT = AzCommand.create(controller, "backward_left", AzPlayBehaviors.LOOP);
    private static final AzCommand BACKWARD_RIGHT = AzCommand.create(controller, "backward_right", AzPlayBehaviors.LOOP);
    private static final AzCommand STATIC_LEFT = AzCommand.create(controller, "static_left", AzPlayBehaviors.LOOP);
    private static final AzCommand STATIC_RIGHT = AzCommand.create(controller, "static_right", AzPlayBehaviors.LOOP);
    private static final AzCommand JUMP_FORWARD = AzCommand.create(controller, "jump_forward", AzPlayBehaviors.PLAY_ONCE);

    public BuggyDispatcher(Buggy animatable) {
        this.buggy = animatable;
    }

    public void idle() {
        IDLE.sendForEntity(buggy);
    }

    public void moveForward() {
        FORWARD.sendForEntity(buggy);
    }

    public void moveBackward() {
        BACKWARD.sendForEntity(buggy);
    }

    public void forwardLeft() {
        FORWARD_LEFT.sendForEntity(buggy);
    }

    public void forwardRight() {
        FORWARD_RIGHT.sendForEntity(buggy);
    }

    public void backwardLeft() {
        BACKWARD_LEFT.sendForEntity(buggy);
    }

    public void backwardRight() {
        BACKWARD_RIGHT.sendForEntity(buggy);
    }

    public void staticLeft() {
        STATIC_LEFT.sendForEntity(buggy);
    }

    public void staticRight() {
        STATIC_RIGHT.sendForEntity(buggy);
    }

    public void jump() {
        JUMP_FORWARD.sendForEntity(buggy);
    }

}