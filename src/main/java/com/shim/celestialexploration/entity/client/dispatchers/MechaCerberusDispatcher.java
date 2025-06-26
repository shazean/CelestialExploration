package com.shim.celestialexploration.entity.client.dispatchers;

import com.shim.celestialexploration.entity.robots.AbstractCerberus;
import mod.azure.azurelib.rewrite.animation.dispatch.command.AzCommand;
import mod.azure.azurelib.rewrite.animation.play_behavior.AzPlayBehaviors;

public class MechaCerberusDispatcher {
    protected static String controller = "base_controller";

    //FIXME update animation names
    private static final AzCommand IDLE = AzCommand.create(controller, "idle", AzPlayBehaviors.LOOP);
    private static final AzCommand WILD_IDLE = AzCommand.create(controller, "wild_idle", AzPlayBehaviors.LOOP);
    private static final AzCommand WALK = AzCommand.create(controller, "walk", AzPlayBehaviors.LOOP);
    private static final AzCommand WILD_WALK = AzCommand.create(controller, "wild_walk", AzPlayBehaviors.LOOP);
    private static final AzCommand SIT = AzCommand.create(controller, "sit", AzPlayBehaviors.LOOP);
    private static final AzCommand WILD_SIT = AzCommand.create(controller, "wild_sit", AzPlayBehaviors.LOOP);
    private static final AzCommand HOWL = AzCommand.create(controller, "howl_new", AzPlayBehaviors.PLAY_ONCE);
    private static final AzCommand CHARGE_UP = AzCommand.create(controller, "charge_up_new", AzPlayBehaviors.LOOP);
    private static final AzCommand CHARGE_UP_END = AzCommand.create(controller, "charge_up_end_shim", AzPlayBehaviors.PLAY_ONCE);
    private static final AzCommand CHARGE_ATTACK = AzCommand.create(controller, "bark_shim", AzPlayBehaviors.PLAY_ONCE); //FIXME
    private static final AzCommand STUN = AzCommand.create(controller, "stun_shim", AzPlayBehaviors.LOOP);

    private final AbstractCerberus animatable;

    public MechaCerberusDispatcher(AbstractCerberus animatable) {
        this.animatable = animatable;
    }

    public void idle() {
//        if (animatable.isTame()) {
            IDLE.sendForEntity(animatable);
//        } else {
//            WILD_IDLE.sendForEntity(animatable);
//        }
    }

    public void sit() {
        SIT.sendForEntity(animatable);
    }

    public void walk() {
//        if (animatable.isTame()) {
            WALK.sendForEntity(animatable);
//        } else {
//            WILD_WALK.sendForEntity(animatable);
//        }
    }

    public void howl() {
        HOWL.sendForEntity(animatable);
    }

    public void chargeUp() {
        CHARGE_UP.sendForEntity(animatable);
    }

    public void chargeUpEnd() {
        CHARGE_UP_END.sendForEntity(animatable);
    }

    public void chargeAttack() {
        CHARGE_ATTACK.sendForEntity(animatable);
    }

    public void stun() {
        STUN.sendForEntity(animatable);
    }

}