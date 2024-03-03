package com.shim.celestialexploration.entity.mob;

import com.shim.celestialexploration.registry.EntityRegistry;
import com.shim.celestialexploration.registry.ItemRegistry;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.Zoglin;
import net.minecraft.world.entity.monster.hoglin.Hoglin;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;

public class AstralHoglin extends Hoglin {
    public AstralHoglin(EntityType<? extends Hoglin> p_34488_, Level p_34489_) {
        super(p_34488_, p_34489_);
    }

    public static AttributeSupplier setAttributes() {
        return Monster.createMonsterAttributes().add(Attributes.MAX_HEALTH, 40.0D).add(Attributes.MOVEMENT_SPEED, (double)0.3F).add(Attributes.KNOCKBACK_RESISTANCE, (double)0.6F).add(Attributes.ATTACK_KNOCKBACK, 1.0D).add(Attributes.ATTACK_DAMAGE, 6.0D).build();
    }

    @Override
    public void finishConversion(ServerLevel serverLevel) {
        Zoglin zoglin = this.convertTo(EntityRegistry.VOIDED_ZOGLIN.get(), true);
        if (zoglin != null) {
            zoglin.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 200, 0));
            net.minecraftforge.event.ForgeEventFactory.onLivingConvert(this, zoglin);
        }
    }

    @Nullable
    public AgeableMob getBreedOffspring(ServerLevel p_149900_, AgeableMob p_149901_) {
        Hoglin hoglin = EntityRegistry.ASTRAL_HOGLIN.get().create(p_149900_);
        if (hoglin != null) {
            hoglin.setPersistenceRequired();
        }
        return hoglin;
    }

    public boolean isFood(ItemStack p_34562_) {
        return p_34562_.is(ItemRegistry.SULFUR_CRYSTAL.get());
    }
}
