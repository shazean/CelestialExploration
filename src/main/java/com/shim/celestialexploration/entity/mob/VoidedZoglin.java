package com.shim.celestialexploration.entity.mob;

import com.shim.celestialexploration.registry.EntityRegistry;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.sensing.Sensor;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.Zoglin;
import net.minecraft.world.entity.monster.hoglin.HoglinBase;
import net.minecraft.world.level.Level;

public class VoidedZoglin extends Zoglin implements HoglinBase {

    public VoidedZoglin(EntityType<? extends Zoglin> p_34204_, Level p_34205_) {
        super(p_34204_, p_34205_);
    }

    public static AttributeSupplier setAttributes() {
        return Monster.createMonsterAttributes().add(Attributes.MAX_HEALTH, 40.0D).add(Attributes.MOVEMENT_SPEED, (double)0.3F).add(Attributes.KNOCKBACK_RESISTANCE, (double)0.6F).add(Attributes.ATTACK_KNOCKBACK, 1.0D).add(Attributes.ATTACK_DAMAGE, 6.0D).build();
    }

    @Override
    public boolean isTargetable(LivingEntity p_34253_) {
        EntityType<?> entitytype = p_34253_.getType();
        return entitytype != EntityType.ZOGLIN && entitytype != EntityRegistry.VOIDED_ZOGLIN.get() && entitytype != EntityType.CREEPER && Sensor.isEntityAttackable(this, p_34253_);
    }
}
