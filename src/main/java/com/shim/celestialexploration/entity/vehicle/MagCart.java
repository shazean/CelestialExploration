package com.shim.celestialexploration.entity.vehicle;

import com.shim.celestialexploration.registry.EntityRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

public class MagCart extends AbstractMagCart {
    public MagCart(EntityType<?> p_38470_, Level p_38471_) {
        super(p_38470_, p_38471_);
    }

    public MagCart(Level p_38473_, double p_38474_, double p_38475_, double p_38476_) {
        super(EntityRegistry.MAGCART.get(), p_38473_, p_38474_, p_38475_, p_38476_);
    }

    public InteractionResult interact(Player player, InteractionHand hand) {
        InteractionResult ret = super.interact(player, hand);
        if (ret.consumesAction()) return ret;
        if (player.isSecondaryUseActive()) {
            return InteractionResult.PASS;
        } else if (this.isVehicle()) {
            return InteractionResult.PASS;
        } else if (!this.level.isClientSide) {
            return player.startRiding(this) ? InteractionResult.CONSUME : InteractionResult.PASS;
        } else {
            return InteractionResult.SUCCESS;
        }
    }

    public void activateMagCart(int p_38478_, int p_38479_, int p_38480_, boolean p_38481_) {
        if (p_38481_) {
            if (this.isVehicle()) {
                this.ejectPassengers();
            }

            if (this.getHurtTime() == 0) {
                this.setHurtDir(-this.getHurtDir());
                this.setHurtTime(10);
                this.setDamage(50.0F);
                this.markHurt();
            }
        }
    }

    public AbstractMagCart.Type getMagCartType() {
        return AbstractMagCart.Type.RIDEABLE;
    }
}