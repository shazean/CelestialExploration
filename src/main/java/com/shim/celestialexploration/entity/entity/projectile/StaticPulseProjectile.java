package com.shim.celestialexploration.entity.entity.projectile;

import com.shim.celestialexploration.config.CelestialCommonConfig;
import com.shim.celestialexploration.registry.BlockRegistry;
import com.shim.celestialexploration.registry.ParticleRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.projectile.ProjectileUtil;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;

import java.util.Random;

public class StaticPulseProjectile extends AbstractDirectionalProjectile {
    final int MAX_LIFESPAN;
    int lifeSpan;
//    float defaultMovementSpeed = 0.06F;
    double xMovementSpeed;
    double zMovementSpeed;

    public StaticPulseProjectile(EntityType<? extends AbstractDirectionalProjectile> entityTypeIn, Level levelIn) {
        super(entityTypeIn, levelIn);
        this.MAX_LIFESPAN = 15 + new Random().nextInt(10);
        this.lifeSpan = MAX_LIFESPAN;
        xMovementSpeed = this.level.getRandom().nextDouble(0.5D) - 0.25D;
        zMovementSpeed = this.level.getRandom().nextDouble(0.5D) - 0.25D;

    }

    @Override
    public void tick() {
        super.tick();
        this.lifeSpan--;
        if (this.lifeSpan <= 0) {
            this.discard();
        }

        HitResult hitresult = ProjectileUtil.getHitResult(this, this::canHitEntity);
        if (hitresult.getType() != HitResult.Type.MISS) {
            this.onHit(hitresult);
            this.explode();
        }

        this.checkInsideBlocks();
        ProjectileUtil.rotateTowardsMovement(this, 0.2F);

        Vec3 currentMovement = this.getDeltaMovement();
//        this.calculateArc();

        double x = this.level.getRandom().nextDouble(0.25D) - 0.125D;
        double z = this.level.getRandom().nextDouble(0.25D) - 0.125D;

        this.setDeltaMovement(currentMovement.x + xMovementSpeed + x,
                currentMovement.y,
                currentMovement.z + zMovementSpeed + z);


//        this.setDeltaMovement(currentMovement.x + this.level.getRandom().nextDouble(0.5D) - 0.25D,
//                currentMovement.y - currentYMovementSpeed - this.level.getRandom().nextDouble(0.3D),
//                currentMovement.z + currentZMovementSpeed + this.level.getRandom().nextDouble(0.3D));

//        double d0 = this.getX() + currentMovement.x;
//        double d1 = this.getY() + currentMovement.y;
//        double d2 = this.getZ() + currentMovement.z;

//        this.level.addParticle(ParticleRegistry.SHOOTING_STAR_PARTICLE.get(), d0, d1 + 1.0D, d2 - 1.0D, 0.0D, 0.0D, 0.0D);
//        this.level.addParticle(ParticleRegistry.SHOOTING_STAR_PARTICLE.get(), d0, d1 + 1.25D, d2 - 1.25D, 0.0D, 0.0D, 0.0D);
//        this.level.addParticle(ParticleRegistry.SHOOTING_STAR_PARTICLE.get(), d0, d1 + 1.5D, d2 - 1.5D, 0.0D, 0.0D, 0.0D);
//        this.level.addParticle(ParticleRegistry.SHOOTING_STAR_PARTICLE.get(), d0, d1 + 1.75D, d2 - 1.75D, 0.0D, 0.0D, 0.0D);
//        this.level.addParticle(ParticleRegistry.SHOOTING_STAR_PARTICLE.get(), d0, d1 + 2.0D, d2 - 2.0D, 0.0D, 0.0D, 0.0D);
//        this.level.addParticle(ParticleRegistry.SHOOTING_STAR_PARTICLE.get(), d0, d1 + 2.25D, d2 - 2.25D, 0.0D, 0.0D, 0.0D);
//        this.level.addParticle(ParticleRegistry.SHOOTING_STAR_PARTICLE.get(), d0, d1 + 2.5D, d2 - 2.5D, 0.0D, 0.0D, 0.0D);
//        this.level.addParticle(ParticleRegistry.SHOOTING_STAR_PARTICLE.get(), d0, d1 + 2.75D, d2 - 2.75D, 0.0D, 0.0D, 0.0D);
//        this.level.addParticle(ParticleRegistry.SHOOTING_STAR_PARTICLE.get(), d0, d1 + 3.0D, d2 - 3.0D, 0.0D, 0.0D, 0.0D);
//        this.level.addParticle(ParticleRegistry.SHOOTING_STAR_PARTICLE.get(), d0, d1 + 3.25D, d2 - 3.25D, 0.0D, 0.0D, 0.0D);

    }

    private void explode() {
        if (!this.level.isClientSide) {
            float explosion = this.level.getRandom().nextFloat(0.5F) + 0.5F;

            this.level.explode(this, this.getX(), this.getY(), this.getZ(), explosion, Explosion.BlockInteraction.NONE);

            this.discard();
//            this.spawnLingeringCloud();
        }
    }

    @Override
    public double gravityAmount() {
        return 0.03D;
    }

//    @Override
//    public boolean isNoGravity() {
//        return false;
//    }

}
