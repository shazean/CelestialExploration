package com.shim.celestialexploration.entity.goals;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.level.Level;

public class HoverGoal extends Goal {
    LivingEntity drone;
    double ascentSpeed;

    public HoverGoal(LivingEntity drone, double ascentSpeed) {
        this.drone = drone;
        this.ascentSpeed = ascentSpeed;
    }

    @Override
    public boolean canUse() {
        return true;
    }

    @Override
    public void tick() {
        super.tick();
        BlockPos dronePos = this.drone.blockPosition();
        BlockPos posBelow = dronePos.below();
        BlockPos pos2Below = dronePos.below(2);
        Level level = drone.getLevel();

        if (level.getBlockState(posBelow).isAir() && level.getBlockState(pos2Below).isAir()) {
            this.drone.setDeltaMovement(this.drone.getDeltaMovement().x(), -ascentSpeed, this.drone.getDeltaMovement().z());
        } else if (!level.getBlockState(posBelow).isAir() && !level.getBlockState(pos2Below).isAir()) {
            this.drone.setDeltaMovement(this.drone.getDeltaMovement().x(), ascentSpeed, this.drone.getDeltaMovement().z());
        } else {
            this.drone.setDeltaMovement(this.drone.getDeltaMovement().x(), 0, this.drone.getDeltaMovement().z());
        }
    }
}
