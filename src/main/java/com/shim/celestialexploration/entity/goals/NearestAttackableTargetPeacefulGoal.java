package com.shim.celestialexploration.entity.goals;

import net.minecraft.world.Difficulty;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;

public class NearestAttackableTargetPeacefulGoal<T extends LivingEntity> extends NearestAttackableTargetGoal<T> {
    public NearestAttackableTargetPeacefulGoal(Mob entity, Class<T> target, boolean p_26066_, boolean p_26067_) {
        super(entity, target, p_26066_, p_26067_);
    }

    @Override
    public boolean canUse() {
        if (this.mob.level.getDifficulty() == Difficulty.PEACEFUL) return false;
        return super.canUse();
    }
}
