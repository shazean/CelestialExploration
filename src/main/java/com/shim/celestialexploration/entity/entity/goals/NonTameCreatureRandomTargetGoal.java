package com.shim.celestialexploration.entity.entity.goals;

import com.shim.celestialexploration.entity.entity.friendlies.TamableCreature;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;

import javax.annotation.Nullable;
import java.util.function.Predicate;

public class NonTameCreatureRandomTargetGoal<T extends LivingEntity> extends NearestAttackableTargetGoal<T> {
    private final TamableCreature tamableMob;

    public NonTameCreatureRandomTargetGoal(TamableCreature p_26097_, Class<T> p_26098_, boolean p_26099_, @Nullable Predicate<LivingEntity> p_26100_) {
        super(p_26097_, p_26098_, 10, p_26099_, false, p_26100_);
        this.tamableMob = p_26097_;
    }

    public boolean canUse() {
        return !this.tamableMob.isTame() && super.canUse();
    }

    public boolean canContinueToUse() {
        return this.targetConditions != null ? this.targetConditions.test(this.mob, this.target) : super.canContinueToUse();
    }
}