package com.shim.celestialexploration.entity.entity;

import com.shim.celestialexploration.registry.ParticleRegistry;
import mod.azure.azurelib.ai.pathing.AzureNavigation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.level.Level;

public class DebugNav extends AzureNavigation {
    public DebugNav(Mob entity, Level world) {
        super(entity, world);
    }

    @Override
    public void tick() {
        super.tick();
        if (this.getTargetPos() != null && this.level instanceof ServerLevel serverLevel) {
            serverLevel.sendParticles(ParticleRegistry.DUST_PARTICLE.get(), this.getTargetPos().getX(), this.getTargetPos().getY(), this.getTargetPos().getZ(), 0, 0, 0, 0, 0);
            if (this.path != null) for (int i = 0; i < this.path.getNodeCount(); i++ ) serverLevel.sendParticles(ParticleRegistry.DUST_PARTICLE.get(), this.path.getNode(i).x, this.path.getNode(i).y + 2, this.path.getNode(i).z, 0, 0, 0, 0, 0);
        }
    }
}
