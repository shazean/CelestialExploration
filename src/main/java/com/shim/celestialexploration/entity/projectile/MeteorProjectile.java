package com.shim.celestialexploration.entity.projectile;

import com.shim.celestialexploration.config.CelestialCommonConfig;
import com.shim.celestialexploration.registry.CelestialBlocks;
import com.shim.celestialexploration.registry.CelestialParticles;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.projectile.ProjectileUtil;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;

import java.util.Random;

public class MeteorProjectile extends AbstractDirectionalProjectile {
    final int MAX_LIFESPAN;
    int lifeSpan;
    float defaultMovementSpeed = 0.06F;
    float currentYMovementSpeed = defaultMovementSpeed / 3;
    float currentZMovementSpeed = defaultMovementSpeed;

    public MeteorProjectile(EntityType<? extends AbstractDirectionalProjectile> entityTypeIn, Level levelIn) {
        super(entityTypeIn, levelIn);
        this.MAX_LIFESPAN = 15 + new Random().nextInt(10);
        this.lifeSpan = MAX_LIFESPAN;
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
        this.setDeltaMovement(currentMovement.x + this.level.getRandom().nextDouble(0.5D) - 0.25D,
                currentMovement.y - currentYMovementSpeed - this.level.getRandom().nextDouble(0.3D),
                currentMovement.z + currentZMovementSpeed + this.level.getRandom().nextDouble(0.3D));

        double d0 = this.getX() + currentMovement.x;
        double d1 = this.getY() + currentMovement.y;
        double d2 = this.getZ() + currentMovement.z;

        this.level.addParticle(CelestialParticles.SHOOTING_STAR_PARTICLE.get(), d0, d1 + 1.0D, d2 - 1.0D, 0.0D, 0.0D, 0.0D);
        this.level.addParticle(CelestialParticles.SHOOTING_STAR_PARTICLE.get(), d0, d1 + 1.25D, d2 - 1.25D, 0.0D, 0.0D, 0.0D);
        this.level.addParticle(CelestialParticles.SHOOTING_STAR_PARTICLE.get(), d0, d1 + 1.5D, d2 - 1.5D, 0.0D, 0.0D, 0.0D);
        this.level.addParticle(CelestialParticles.SHOOTING_STAR_PARTICLE.get(), d0, d1 + 1.75D, d2 - 1.75D, 0.0D, 0.0D, 0.0D);
        this.level.addParticle(CelestialParticles.SHOOTING_STAR_PARTICLE.get(), d0, d1 + 2.0D, d2 - 2.0D, 0.0D, 0.0D, 0.0D);
        this.level.addParticle(CelestialParticles.SHOOTING_STAR_PARTICLE.get(), d0, d1 + 2.25D, d2 - 2.25D, 0.0D, 0.0D, 0.0D);
        this.level.addParticle(CelestialParticles.SHOOTING_STAR_PARTICLE.get(), d0, d1 + 2.5D, d2 - 2.5D, 0.0D, 0.0D, 0.0D);
        this.level.addParticle(CelestialParticles.SHOOTING_STAR_PARTICLE.get(), d0, d1 + 2.75D, d2 - 2.75D, 0.0D, 0.0D, 0.0D);
        this.level.addParticle(CelestialParticles.SHOOTING_STAR_PARTICLE.get(), d0, d1 + 3.0D, d2 - 3.0D, 0.0D, 0.0D, 0.0D);
        this.level.addParticle(CelestialParticles.SHOOTING_STAR_PARTICLE.get(), d0, d1 + 3.25D, d2 - 3.25D, 0.0D, 0.0D, 0.0D);

    }

    private void calculateArc() {
        if (this.lifeSpan >= (MAX_LIFESPAN / 3 * 2)) {
            this.currentYMovementSpeed = defaultMovementSpeed - 0.05F;
            this.currentZMovementSpeed = defaultMovementSpeed + 0.05F;
        } else if (this.lifeSpan < (MAX_LIFESPAN / 3 * 2) && this.lifeSpan > (MAX_LIFESPAN / 3)) {
            this.currentYMovementSpeed = defaultMovementSpeed;
            this.currentZMovementSpeed = defaultMovementSpeed;
        } else {
            this.currentYMovementSpeed = defaultMovementSpeed + 0.05F;
            this.currentZMovementSpeed = defaultMovementSpeed - 0.05F;
        }
    }

    private void explode() {
        if (!this.level.isClientSide) {
            Explosion.BlockInteraction explosion$blockinteraction = CelestialCommonConfig.METEORS_EXPLODE.get() ? Explosion.BlockInteraction.DESTROY : Explosion.BlockInteraction.NONE;

            explosion$blockinteraction = this.level.getRandom().nextInt(3) == 0 ? Explosion.BlockInteraction.NONE : explosion$blockinteraction;

            float explosion = this.level.getRandom().nextFloat(7.5F) - 4.0F;
            explosion = explosion < 0 ? 0 : explosion;

            this.level.explode(this, this.getX(), this.getY(), this.getZ(), explosion, explosion$blockinteraction);

            if (explosion > 2.5F && this.level.random.nextInt(16) == 0) {
                if (this.level.getBlockState(new BlockPos(this.position()).below()).isAir()) {
                    this.level.setBlock(new BlockPos(this.position()).below(), CelestialBlocks.METEOR.get().defaultBlockState(), 1);
                } else if (this.level.getBlockState(new BlockPos(this.position()).below(2)).isAir()) {
                    this.level.setBlock(new BlockPos(this.position()).below(), CelestialBlocks.METEOR.get().defaultBlockState(), 1);
                } else if ((this.level.getBlockState(new BlockPos(this.position()).below(3)).isAir())) {
                    this.level.setBlock(new BlockPos(this.position()).below(), CelestialBlocks.METEOR.get().defaultBlockState(), 1);
                } else if ((this.level.getBlockState(new BlockPos(this.position()).below(4)).isAir())) {
                    this.level.setBlock(new BlockPos(this.position()).below(), CelestialBlocks.METEOR.get().defaultBlockState(), 1);
                }
            }

            this.discard();
//            this.spawnLingeringCloud();
        }
    }

    @Override
    public boolean isNoGravity() {
        return true;
    }
}