package com.shim.celestialexploration.entity.mob;

import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestialexploration.datagen.CelestialFluidTags;
import com.shim.celestialexploration.entity.client.dispatchers.VulkanDispatcher;
import com.shim.celestialexploration.registry.CelestialBlocks;
import com.shim.celestialexploration.registry.CelestialFluids;
import com.shim.celestialexploration.registry.CelestialParticles;
import com.shim.celestialexploration.registry.CelestialTags;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Fireball;
import net.minecraft.world.entity.projectile.LargeFireball;
import net.minecraft.world.entity.projectile.SmallFireball;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.minecraft.world.phys.Vec3;

import java.util.EnumSet;
import java.util.Random;

public class Vulkan extends Monster {
    private float allowedHeightOffset = 0.5F;
    private int nextHeightOffsetChangeTick;
    private static final EntityDataAccessor<Byte> DATA_FLAGS_ID = SynchedEntityData.defineId(Vulkan.class, EntityDataSerializers.BYTE);
    public VulkanDispatcher dispatcher;

    public Vulkan(EntityType<? extends Monster> entity, Level level) {
        super(entity, level);
        this.dispatcher = new VulkanDispatcher(this);
        this.setPathfindingMalus(BlockPathTypes.WATER, -1.0F);
        this.setPathfindingMalus(BlockPathTypes.LAVA, 8.0F);
        this.setPathfindingMalus(BlockPathTypes.DANGER_FIRE, 0.0F);
        this.setPathfindingMalus(BlockPathTypes.DAMAGE_FIRE, 0.0F);
        this.xpReward = 10;
    }


    protected void registerGoals() {
        this.goalSelector.addGoal(3, new Vulkan.VulkanFloatOverLavaAndSulfurGoal(this));
        this.goalSelector.addGoal(4, new Vulkan.VulkanAttackGoal(this));
        this.goalSelector.addGoal(4, new Vulkan.VulkanEruptGoal(this));
        this.goalSelector.addGoal(5, new MoveTowardsRestrictionGoal(this, 1.0D));
        this.goalSelector.addGoal(7, new WaterAvoidingRandomStrollGoal(this, 1.0D, 0.0F));
        this.goalSelector.addGoal(8, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(1, (new HurtByTargetGoal(this)).setAlertOthers());
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Monster.createMonsterAttributes().add(Attributes.ATTACK_DAMAGE, 6.0D).add(Attributes.MAX_HEALTH, 50.0F).add(Attributes.MOVEMENT_SPEED, (double) 0.23F).add(Attributes.FOLLOW_RANGE, 48.0D);
    }

    public void tick() {
        if (this.isAlive()) {

            if (this.level.isClientSide()) { // Only execute animation logic on the client
                dispatcher.idle();
            }
        }

        super.tick();
    }


    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(DATA_FLAGS_ID, (byte) 0);
    }

    protected SoundEvent getAmbientSound() {
        return SoundEvents.BLAZE_AMBIENT;
    }

    protected SoundEvent getHurtSound(DamageSource damageSource) {
        return SoundEvents.BLAZE_HURT;
    }

    protected SoundEvent getDeathSound() {
        return SoundEvents.BLAZE_DEATH;
    }

    public float getBrightness() {
        return 1.0F;
    }

    public void aiStep() {
        if (!this.onGround && this.getDeltaMovement().y < 0.0D) {
            this.setDeltaMovement(this.getDeltaMovement().multiply(1.0D, 0.6D, 1.0D));
        }

        if (this.level.isClientSide) {
            if (this.random.nextInt(24) == 0 && !this.isSilent()) {
                this.level.playLocalSound(this.getX() + 0.5D, this.getY() + 0.5D, this.getZ() + 0.5D, SoundEvents.BLAZE_BURN, this.getSoundSource(), 1.0F + this.random.nextFloat(), this.random.nextFloat() * 0.7F + 0.3F, false);
            }

            for (int i = 0; i < 2; ++i) {
                this.level.addParticle(ParticleTypes.LARGE_SMOKE, this.getRandomX(0.5D), this.getRandomY(), this.getRandomZ(0.5D), 0.0D, 0.0D, 0.0D);
            }

            if (this.tickCount % 2 == 0) {
                if (this.random.nextInt(5) == 0) {
                int height = this.random.nextInt(20) + 5;
                for (int i = 0; i < height; i++) {

                    this.level.addParticle(CelestialParticles.SULFUR_PARTICLE.get(), (double) this.blockPosition().getX() + 0.5D + (this.random.nextInt(20) - 10), (double) this.blockPosition().getY() + 1.5 - 1.0 + (i / 2.0), (double) this.blockPosition().getZ() + 0.5D + (this.random.nextInt(20) - 10), 0.0D, 0.5D, 0.0D);
                }
                }
            }

        }

        super.aiStep();
    }

    public boolean isSensitiveToWater() {
        return true;
    }

    protected void customServerAiStep() {
        --this.nextHeightOffsetChangeTick;
        if (this.nextHeightOffsetChangeTick <= 0) {
            this.nextHeightOffsetChangeTick = 100;
            this.allowedHeightOffset = 0.5F + (float) this.random.nextGaussian() * 3.0F;
        }

        LivingEntity livingentity = this.getTarget();
        if (livingentity != null && livingentity.getEyeY() > this.getEyeY() + (double) this.allowedHeightOffset && this.canAttack(livingentity)) {
            Vec3 vec3 = this.getDeltaMovement();
            this.setDeltaMovement(this.getDeltaMovement().add(0.0D, ((double) 0.3F - vec3.y) * (double) 0.3F, 0.0D));
            this.hasImpulse = true;
        }

        super.customServerAiStep();
    }

    public boolean causeFallDamage(float p_149683_, float p_149684_, DamageSource p_149685_) {
        return false;
    }

    public boolean isOnFire() {
        return false;
//        return this.isCharged();
    }

    public boolean isCharged() {
        return (this.entityData.get(DATA_FLAGS_ID) & 1) != 0;
    }

    void setCharged(boolean p_32241_) {
        byte b0 = this.entityData.get(DATA_FLAGS_ID);
        if (p_32241_) {
            b0 = (byte) (b0 | 1);
        } else {
            b0 = (byte) (b0 & -2);
        }

        this.entityData.set(DATA_FLAGS_ID, b0);
    }

    static class VulkanAttackGoal extends Goal {
        private final Vulkan vulkan;
        private int attackStep;
        private int attackTime;
        private int lastSeen;

        public VulkanAttackGoal(Vulkan p_32247_) {
            this.vulkan = p_32247_;
            this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK));
        }

        public boolean canUse() {
            LivingEntity livingentity = this.vulkan.getTarget();
            return livingentity != null && livingentity.isAlive() && this.vulkan.canAttack(livingentity);
        }

        public void start() {
            this.attackStep = 0;
        }

        public void stop() {
            this.vulkan.setCharged(false);
            this.lastSeen = 0;
        }

        public boolean requiresUpdateEveryTick() {
            return true;
        }

        public void tick() {
            --this.attackTime;
            LivingEntity target = this.vulkan.getTarget();
            if (target != null) {
                boolean lineOfSight = this.vulkan.getSensing().hasLineOfSight(target);
                if (lineOfSight) {
                    this.lastSeen = 0;
                } else {
                    ++this.lastSeen;
                }

                double d0 = this.vulkan.distanceToSqr(target);
                if (d0 < 4.0D) {
                    if (!lineOfSight) {
                        return;
                    }

                    if (this.attackTime <= 0) {
                        this.attackTime = 20;
                        this.vulkan.doHurtTarget(target);
                    }

                    this.vulkan.getMoveControl().setWantedPosition(target.getX(), target.getY(), target.getZ(), 1.0D);
                } else if (d0 < this.getFollowDistance() * this.getFollowDistance() && lineOfSight) {
                    double d1 = target.getX() - this.vulkan.getX();
                    double d2 = target.getY(0.5D) - this.vulkan.getY(0.5D);
                    double d3 = target.getZ() - this.vulkan.getZ();
                    if (this.attackTime <= 0) {
                        ++this.attackStep;
                        if (this.attackStep == 1) {
                            this.attackTime = 60;
                            this.vulkan.setCharged(true);
                        } else if (this.attackStep <= 4) {
                            this.attackTime = 6;
                        } else {
                            this.attackTime = 100;
                            this.attackStep = 0;
                            this.vulkan.setCharged(false);
                        }

                        if (this.attackStep > 1) {
                            double d4 = Math.sqrt(Math.sqrt(d0)) * 0.5D;
                            if (!this.vulkan.isSilent()) {
                                this.vulkan.level.levelEvent((Player) null, 1018, this.vulkan.blockPosition(), 0);
                            }

                            for (int i = 0; i < 1; ++i) {
                                SmallFireball smallfireball = new SmallFireball(this.vulkan.level, this.vulkan, d1 + this.vulkan.getRandom().nextGaussian() * d4, d2, d3 + this.vulkan.getRandom().nextGaussian() * d4);
                                smallfireball.setPos(smallfireball.getX(), this.vulkan.getY(0.5D) + 0.5D, smallfireball.getZ());
                                this.vulkan.level.addFreshEntity(smallfireball);
                            }
                        }
                    }

                    this.vulkan.getLookControl().setLookAt(target, 10.0F, 10.0F);
                } else if (this.lastSeen < 5) {
                    this.vulkan.getMoveControl().setWantedPosition(target.getX(), target.getY(), target.getZ(), 1.0D);
                }

                super.tick();
            }
        }

        private double getFollowDistance() {
            return this.vulkan.getAttributeValue(Attributes.FOLLOW_RANGE);
        }
    }

    static class VulkanFloatOverLavaAndSulfurGoal extends Goal {
        Vulkan vulkan;

        public VulkanFloatOverLavaAndSulfurGoal(Vulkan vulkan) {
            this.vulkan = vulkan;
        }

        @Override
        public boolean canUse() {
            return true;
        }

        @Override
        public void tick() {
            if (this.vulkan.isInLava() || this.isInSulfur()) {
                this.vulkan.setDeltaMovement(this.vulkan.getDeltaMovement().x(), 0.1F, this.vulkan.getDeltaMovement().z());
            }

            FluidState fluidBelow = this.vulkan.level.getBlockState(this.vulkan.blockPosition().below()).getFluidState();
            if (fluidBelow.is(FluidTags.LAVA) || fluidBelow.is(CelestialTags.Fluids.SULFUR)) {
                this.vulkan.setDeltaMovement(this.vulkan.getDeltaMovement().x(), 0.1F, this.vulkan.getDeltaMovement().z());
            }

            super.tick();
        }

        public boolean isInSulfur() {
            return !this.vulkan.firstTick && this.vulkan.fluidHeight.getDouble(CelestialTags.Fluids.SULFUR) > 0.0D;
        }

    }

    static class VulkanEruptGoal extends Goal {
        private final Vulkan vulkan;
        private int eruptTime;

        public VulkanEruptGoal(Vulkan vulkan) {
            this.vulkan = vulkan;
        }

        public boolean canUse() {
            return true;
        }

//        public void start() {
//            this.vulkan.setCharged(true);
//        }
//
//        public void stop() {
//            this.vulkan.setCharged(false);
//        }

        public boolean requiresUpdateEveryTick() {
            return true;
        }

        public void tick() {
            --this.eruptTime;

            if (this.eruptTime <= 0) {
//                if (this.eruptTime == 0) {
                    for (int i = 0; i < this.vulkan.random.nextInt(6); ++i) {
                        LargeFireball smallfireball = new LargeFireball(this.vulkan.level, this.vulkan, this.vulkan.getRandom().nextGaussian(), Mth.abs((float) this.vulkan.getRandom().nextGaussian()) * 2.5f, this.vulkan.getRandom().nextGaussian(), 1);
                        smallfireball.setPos(smallfireball.getX(), this.vulkan.getY(0.5D) + 1.5D, smallfireball.getZ());
                        this.vulkan.level.addFreshEntity(smallfireball);
                    }
//                }

//                int height = this.vulkan.random.nextInt(20) + 5;
//                for (int i = 0; i < height; i++) {
//                    this.vulkan.level.addParticle(CelestialParticles.SULFUR_PARTICLE.get(), (double) this.vulkan.blockPosition().getX() + 0.5D, (double) this.vulkan.blockPosition().getY() + 1.5 + (i / 2.0), (double) this.vulkan.blockPosition().getZ() + 0.5D, 0.0D, 0.5D, 0.0D);
//                }
//
//                if (this.eruptTime <= -20)
                    this.eruptTime = 20 + this.vulkan.random.nextInt(20);

            }

            super.tick();
        }

        private double getFollowDistance() {
            return this.vulkan.getAttributeValue(Attributes.FOLLOW_RANGE);
        }
    }
}
