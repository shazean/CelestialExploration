package com.shim.celestialexploration.entity.mob;

import com.shim.celestialexploration.config.CelestialCommonConfig;
import com.shim.celestialexploration.entity.client.dispatchers.GustDispatcher;
import mod.azure.azurelib.util.MoveAnalysis;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.Cat;
import net.minecraft.world.entity.animal.Ocelot;
import net.minecraft.world.entity.animal.goat.Goat;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.event.ForgeEventFactory;

import javax.annotation.Nullable;
import java.util.Collection;
import java.util.EnumSet;
import java.util.Random;

public class Gust extends Monster implements PowerableMob {
    private static final EntityDataAccessor<Integer> DATA_SWELL_DIR = SynchedEntityData.defineId(Gust.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Boolean> DATA_IS_POWERED = SynchedEntityData.defineId(Gust.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Boolean> DATA_IS_IGNITED = SynchedEntityData.defineId(Gust.class, EntityDataSerializers.BOOLEAN);
    private int oldSwell;
    private int swell;
    private int maxSwell = 30;
    private int explosionRadius = 3;
    private int droppedSkulls;
    private int nextHeightOffsetChangeTick;
    private float allowedHeightOffset = 0.5F;
    public final GustDispatcher dispatcher;
    private final MoveAnalysis moveAnalysis;

    public Gust(EntityType<? extends Gust> p_32278_, Level p_32279_) {
        super(p_32278_, p_32279_);
        this.dispatcher = new GustDispatcher(this);
        this.moveAnalysis = new MoveAnalysis(this);

    }

    protected void registerGoals() {
        this.goalSelector.addGoal(1, new FloatGoal(this));
        this.goalSelector.addGoal(2, new SwellGoal(this));
        this.goalSelector.addGoal(3, new AvoidEntityGoal<>(this, Ocelot.class, 6.0F, 1.0D, 1.2D));
        this.goalSelector.addGoal(3, new AvoidEntityGoal<>(this, Cat.class, 6.0F, 1.0D, 1.2D));
        this.goalSelector.addGoal(4, new MeleeAttackGoal(this, 1.0D, false));
        this.goalSelector.addGoal(5, new WaterAvoidingRandomStrollGoal(this, 0.8D));
        this.goalSelector.addGoal(6, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.goalSelector.addGoal(6, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, Player.class, true));
        this.targetSelector.addGoal(2, new HurtByTargetGoal(this));
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Monster.createMonsterAttributes().add(Attributes.MOVEMENT_SPEED, 0.25D);
    }

    public static boolean checkGustSpawnRules(EntityType<Gust> entity, LevelAccessor levelAccessor, MobSpawnType spawnType, BlockPos pos, Random random) {
        if (levelAccessor.getLevelData().isRaining()) {
            return checkMobSpawnRules(entity, levelAccessor, spawnType, pos, random);
        } else {
            return random.nextInt(20) == 0 && isDarkEnoughToSpawn((ServerLevelAccessor) levelAccessor, pos, random) && checkMobSpawnRules(entity, levelAccessor, spawnType, pos, random);
        }
    }

    public int getMaxFallDistance() {
        return this.getTarget() == null ? 3 : 3 + (int)(this.getHealth() - 1.0F);
    }

    public boolean causeFallDamage(float p_149687_, float p_149688_, DamageSource p_149689_) {
        return false;
//        boolean flag = super.causeFallDamage(p_149687_, p_149688_, p_149689_);
//        this.swell += (int)(p_149687_ * 1.5F);
//        if (this.swell > this.maxSwell - 5) {
//            this.swell = this.maxSwell - 5;
//        }
//
//        return flag;
    }

    protected void checkFallDamage(double p_20809_, boolean p_20810_, BlockState p_20811_, BlockPos p_20812_) {
    }

    public void aiStep() {
        if (!this.onGround && this.getDeltaMovement().y < 0.0D) {
            this.setDeltaMovement(this.getDeltaMovement().multiply(1.0D, 0.6D, 1.0D));
        }
        super.aiStep();
    }

//    @Override
//    public void setNoGravity(boolean p_20243_) {
//        super.setNoGravity(true);
//    }

    protected void customServerAiStep() {
        --this.nextHeightOffsetChangeTick;
        if (this.nextHeightOffsetChangeTick <= 0) {
            this.nextHeightOffsetChangeTick = 100;
            this.allowedHeightOffset = 0.5F + (float)this.random.nextGaussian() * 3.0F;
        }

        LivingEntity livingentity = this.getTarget();
        if (livingentity != null && livingentity.getEyeY() > this.getEyeY() + (double)this.allowedHeightOffset && this.canAttack(livingentity)) {
            Vec3 vec3 = this.getDeltaMovement();
            this.setDeltaMovement(this.getDeltaMovement().add(0.0D, ((double)0.3F - vec3.y) * (double)0.3F, 0.0D));
            this.hasImpulse = true;
        }

        super.customServerAiStep();
    }

//    @Override
//    public void travel(Vec3 p_20818_) {
//        if (this.isInWater()) {
//            this.moveRelative(0.02F, p_20818_);
//            this.move(MoverType.SELF, this.getDeltaMovement());
//            this.setDeltaMovement(this.getDeltaMovement().scale((double)0.8F));
//        } else if (this.isInLava()) {
//            this.moveRelative(0.02F, p_20818_);
//            this.move(MoverType.SELF, this.getDeltaMovement());
//            this.setDeltaMovement(this.getDeltaMovement().scale(0.5D));
//        } else {
//            BlockPos ground = new BlockPos(this.getX(), this.getY() - 1.0D, this.getZ());
//            float f = 0.91F;
//            if (this.onGround) {
//                f = this.level.getBlockState(ground).getFriction(this.level, ground, this) * 0.91F;
//            }
//
//            float f1 = 0.16277137F / (f * f * f);
//            f = 0.91F;
//            if (this.onGround) {
//                f = this.level.getBlockState(ground).getFriction(this.level, ground, this) * 0.91F;
//            }
//
//            this.moveRelative(this.onGround ? 0.1F * f1 : 0.02F, p_20818_);
//            this.move(MoverType.SELF, this.getDeltaMovement());
//            this.setDeltaMovement(this.getDeltaMovement().scale((double)f));
//        }
//
//        this.calculateEntityAnimation(this, false);
//    }

    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(DATA_SWELL_DIR, -1);
        this.entityData.define(DATA_IS_POWERED, false);
        this.entityData.define(DATA_IS_IGNITED, false);
    }

    public void addAdditionalSaveData(CompoundTag p_32304_) {
        super.addAdditionalSaveData(p_32304_);
        if (this.entityData.get(DATA_IS_POWERED)) {
            p_32304_.putBoolean("powered", true);
        }

        p_32304_.putShort("Fuse", (short)this.maxSwell);
        p_32304_.putByte("ExplosionRadius", (byte)this.explosionRadius);
        p_32304_.putBoolean("ignited", this.isIgnited());
    }

    public void readAdditionalSaveData(CompoundTag p_32296_) {
        super.readAdditionalSaveData(p_32296_);
        this.entityData.set(DATA_IS_POWERED, p_32296_.getBoolean("powered"));
        if (p_32296_.contains("Fuse", 99)) {
            this.maxSwell = p_32296_.getShort("Fuse");
        }

        if (p_32296_.contains("ExplosionRadius", 99)) {
            this.explosionRadius = p_32296_.getByte("ExplosionRadius");
        }

        if (p_32296_.getBoolean("ignited")) {
            this.ignite();
        }
    }

    public void tick() {
        if (this.isAlive()) {

            if (this.level.isClientSide()) { // Only execute animation logic on the client
                if (this.swell > 0) {
                    dispatcher.explode();
                } else {
                    dispatcher.idle();
                }
            }

            this.oldSwell = this.swell;
            if (this.isIgnited()) {
                this.setSwellDir(1);
            }

            int i = this.getSwellDir();
            if (i > 0 && this.swell == 0) {
                this.playSound(SoundEvents.CREEPER_PRIMED, 1.0F, 0.5F);
                this.gameEvent(GameEvent.PRIME_FUSE);
            }

            this.swell += i;
            if (this.swell < 0) {
                this.swell = 0;
            }

            if (this.swell >= this.maxSwell) {
                this.swell = this.maxSwell;
                this.explodeGust();
            }
        }

        super.tick();
    }

    public void setTarget(@Nullable LivingEntity p_149691_) {
        if (!(p_149691_ instanceof Goat)) {
            super.setTarget(p_149691_);
        }
    }

    protected SoundEvent getHurtSound(DamageSource p_32309_) {
        return SoundEvents.CREEPER_HURT;
    }

    protected SoundEvent getDeathSound() {
        return SoundEvents.CREEPER_DEATH;
    }

//    protected void dropCustomDeathLoot(DamageSource p_32292_, int p_32293_, boolean p_32294_) {
//        super.dropCustomDeathLoot(p_32292_, p_32293_, p_32294_);
//        Entity entity = p_32292_.getEntity();
//        if (entity != this && entity instanceof Gust) {
//            Gust gust = (Gust)entity;
//            if (gust.canDropMobsSkull()) {
//                gust.increaseDroppedSkulls();
//                this.spawnAtLocation(Items.CREEPER_HEAD);
//            }
//        }
//    }

    public boolean doHurtTarget(Entity p_32281_) {
        return true;
    }

    public boolean isPowered() {
        return this.entityData.get(DATA_IS_POWERED);
    }

    public float getSwelling(float p_32321_) {
        return Mth.lerp(p_32321_, (float)this.oldSwell, (float)this.swell) / (float)(this.maxSwell - 2);
    }

    public int getSwellDir() {
        return this.entityData.get(DATA_SWELL_DIR);
    }

    public void setSwellDir(int p_32284_) {
        this.entityData.set(DATA_SWELL_DIR, p_32284_);
    }

    public void thunderHit(ServerLevel p_32286_, LightningBolt p_32287_) {
        super.thunderHit(p_32286_, p_32287_);
        this.entityData.set(DATA_IS_POWERED, true);
    }

    protected InteractionResult mobInteract(Player p_32301_, InteractionHand p_32302_) {
        ItemStack itemstack = p_32301_.getItemInHand(p_32302_);
        if (itemstack.is(Items.FLINT_AND_STEEL)) {
            this.level.playSound(p_32301_, this.getX(), this.getY(), this.getZ(), SoundEvents.FLINTANDSTEEL_USE, this.getSoundSource(), 1.0F, this.random.nextFloat() * 0.4F + 0.8F);
            if (!this.level.isClientSide) {
                this.ignite();
                itemstack.hurtAndBreak(1, p_32301_, (p_32290_) -> {
                    p_32290_.broadcastBreakEvent(p_32302_);
                });
            }

            return InteractionResult.sidedSuccess(this.level.isClientSide);
        } else {
            return super.mobInteract(p_32301_, p_32302_);
        }
    }

    private void explodeGust() {
        if (!this.level.isClientSide) {
            Explosion.BlockInteraction explosion$blockinteraction = Explosion.BlockInteraction.DESTROY;
            if (!ForgeEventFactory.getMobGriefingEvent(this.level, this))
                explosion$blockinteraction = Explosion.BlockInteraction.NONE;
            if (!CelestialCommonConfig.GUST_GRIEFING.get())
                explosion$blockinteraction = Explosion.BlockInteraction.NONE;

//            Explosion.BlockInteraction explosion$blockinteraction = net.minecraftforge.event.ForgeEventFactory.getMobGriefingEvent(this.level, this) ? Explosion.BlockInteraction.DESTROY : Explosion.BlockInteraction.NONE;
            float f = this.isPowered() ? 2.0F : 1.0F;
            this.dead = true;
            this.level.explode(this, this.getX(), this.getY(), this.getZ(), (float)this.explosionRadius * f, explosion$blockinteraction);
//            this.explode(this, this.getX(), this.getY(), this.getZ(), (float)this.explosionRadius * f, explosion$blockinteraction);
            this.discard();
            this.spawnLingeringCloud();
        }
    }

    public Explosion explode(@Nullable Entity p_46512_, double p_46513_, double p_46514_, double p_46515_, float p_46516_, Explosion.BlockInteraction p_46517_) {
        return this.explode(p_46512_, (DamageSource)null, (ExplosionDamageCalculator)null, p_46513_, p_46514_, p_46515_, p_46516_, false, p_46517_);
    }

    public Explosion explode(@Nullable Entity p_46519_, double p_46520_, double p_46521_, double p_46522_, float p_46523_, boolean p_46524_, Explosion.BlockInteraction p_46525_) {
        return this.explode(p_46519_, (DamageSource)null, (ExplosionDamageCalculator)null, p_46520_, p_46521_, p_46522_, p_46523_, p_46524_, p_46525_);
    }

    public Explosion explode(@Nullable Entity p_46526_, @Nullable DamageSource p_46527_, @Nullable ExplosionDamageCalculator p_46528_, double p_46529_, double p_46530_, double p_46531_, float p_46532_, boolean p_46533_, Explosion.BlockInteraction p_46534_) {
        Explosion explosion = new Explosion(this.level, p_46526_, p_46527_, p_46528_, p_46529_, p_46530_, p_46531_, p_46532_, p_46533_, p_46534_);
        if (net.minecraftforge.event.ForgeEventFactory.onExplosionStart(this.level, explosion)) return explosion;
        explosion.explode();
        explosion.finalizeExplosion(true);
        return explosion;
    }

    private void spawnLingeringCloud() {
        Collection<MobEffectInstance> collection = this.getActiveEffects();
        if (!collection.isEmpty()) {
            AreaEffectCloud areaeffectcloud = new AreaEffectCloud(this.level, this.getX(), this.getY(), this.getZ());
            areaeffectcloud.setRadius(2.5F);
            areaeffectcloud.setRadiusOnUse(-0.5F);
            areaeffectcloud.setWaitTime(10);
            areaeffectcloud.setDuration(areaeffectcloud.getDuration() / 2);
            areaeffectcloud.setRadiusPerTick(-areaeffectcloud.getRadius() / (float)areaeffectcloud.getDuration());

            for(MobEffectInstance mobeffectinstance : collection) {
                areaeffectcloud.addEffect(new MobEffectInstance(mobeffectinstance));
            }

            this.level.addFreshEntity(areaeffectcloud);
        }

    }

    public boolean isIgnited() {
        return this.entityData.get(DATA_IS_IGNITED);
    }

    public void ignite() {
        this.entityData.set(DATA_IS_IGNITED, true);
    }

    public boolean canDropMobsSkull() {
        return this.isPowered() && this.droppedSkulls < 1;
    }

    public void increaseDroppedSkulls() {
        ++this.droppedSkulls;
    }

    public class SwellGoal extends Goal {
        private final Gust gust;
        @Nullable
        private LivingEntity target;

        public SwellGoal(Gust p_25919_) {
            this.gust = p_25919_;
            this.setFlags(EnumSet.of(Goal.Flag.MOVE));
        }

        public boolean canUse() {
            LivingEntity livingentity = this.gust.getTarget();
            return this.gust.getSwellDir() > 0 || livingentity != null && this.gust.distanceToSqr(livingentity) < 9.0D;
        }

        public void start() {
            this.gust.getNavigation().stop();
            this.target = this.gust.getTarget();
        }

        public void stop() {
            this.target = null;
        }

        public boolean requiresUpdateEveryTick() {
            return true;
        }

        public void tick() {
            if (this.target == null) {
                this.gust.setSwellDir(-1);
            } else if (this.gust.distanceToSqr(this.target) > 49.0D) {
                this.gust.setSwellDir(-1);
            } else if (!this.gust.getSensing().hasLineOfSight(this.target)) {
                this.gust.setSwellDir(-1);
            } else {
                this.gust.setSwellDir(1);
            }
        }
    }

}
