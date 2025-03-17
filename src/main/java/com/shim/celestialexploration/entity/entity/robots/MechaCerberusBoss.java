package com.shim.celestialexploration.entity.entity.robots;

import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestialexploration.config.CelestialCommonConfig;
import com.shim.celestialexploration.entity.entity.goals.NearestAttackableTargetPeacefulGoal;
import com.shim.celestialexploration.entity.entity.mob.Gust;
import com.shim.celestialexploration.registry.BlockRegistry;
import com.shim.celestialexploration.registry.EffectRegistry;
import com.shim.celestialexploration.registry.EntityRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerBossEvent;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.Mth;
import net.minecraft.world.BossEvent;
import net.minecraft.world.Difficulty;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.entity.monster.Enemy;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.event.ForgeEventFactory;

import javax.annotation.Nullable;
import java.util.Collection;
import java.util.EnumSet;
import java.util.List;
import java.util.function.Predicate;

public class MechaCerberusBoss extends AbstractCerberus implements Enemy {
    private final ServerBossEvent bossEvent = (ServerBossEvent)(new ServerBossEvent(this.getDisplayName(), BossEvent.BossBarColor.RED, BossEvent.BossBarOverlay.PROGRESS)).setDarkenScreen(true);
    private static final int INVULNERABLE_TICKS = 100;
    private static final EntityDataAccessor<Integer> DATA_ID_INV = SynchedEntityData.defineId(MechaCerberusBoss.class, EntityDataSerializers.INT);
    int lightningAttackCooldown;
    int lightningTick;
    final static int LIGHTNING_MIN_COOLDOWN = 200;
    final static int LIGHTNING_MAX_COOLDOWN = 800;
    final static int MAX_MINION_COOLDOWN = 700;
    final static int STATIC_CAP = 20;
    int staticAffect = (LIGHTNING_MAX_COOLDOWN - LIGHTNING_MIN_COOLDOWN) / 20;
    int summonMinionsCooldown;
    boolean isCharging;
    int chargingTime;
    final static int MAX_CHARGE_TIME = 280;
    boolean isCharged;
    boolean isStunned;
    int checkStaticCooldown;
    int modifyStrategyTick;
    public static final Predicate<Entity> IS_PLAYER = (entity) -> entity instanceof Player;

    public MechaCerberusBoss(EntityType<? extends MechaCerberusBoss> p_30369_, Level p_30370_) {
        super(p_30369_, p_30370_);
        this.setTame(false);
        this.isCharging = false;
        this.isCharged = false;
        this.isStunned = false;
        this.chargingTime = 0;
        this.summonMinionsCooldown = 0;
        this.checkStaticCooldown = 0;
        this.lightningTick = 0;
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(1, new FloatGoal(this));
        this.goalSelector.addGoal(1, new CerberusPanicGoal(1.5D));
        this.goalSelector.addGoal(3, new CerberusAvoidEntityGoal<>(this, Gust.class, 24.0F, 1.5D, 1.5D));
        this.goalSelector.addGoal(4, new LeapAtTargetGoal(this, 0.4F));
        this.goalSelector.addGoal(5, new CerberusMeleeAttackGoal(this, 1.0D, true));
        this.goalSelector.addGoal(8, new WaterAvoidingRandomStrollGoal(this, 1.0D));
        this.goalSelector.addGoal(10, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.goalSelector.addGoal(10, new RandomLookAroundGoal(this));

        this.goalSelector.addGoal(5, new ChargeUpForAttackGoal(this));
        this.goalSelector.addGoal(2, new CerberusLightningAOEAttackGoal(this));
        this.goalSelector.addGoal(1, new StunByAttackGoal(this));
//        this.goalSelector.addGoal(2, new IsStuckGoal(this));
        this.goalSelector.addGoal(2, new SummonMinionsGoal(this));


        this.targetSelector.addGoal(3, (new HurtByTargetGoal(this)).setAlertOthers());
        this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, Player.class, 10,true, false, (entity) -> {
            if (entity instanceof MechaDog dog) { //only attack tamed mechadogs, and not wild ones
                return entity.isAlive() && dog.isTame();
            } else {
                return entity.isAlive();
            }
        }));

//        this.targetSelector.addGoal(5, new NonTameCreatureRandomTargetGoal<>(this, Animal.class, false, PREY_SELECTOR));
//        this.targetSelector.addGoal(6, new NonTameCreatureRandomTargetGoal<>(this, Turtle.class, false, Turtle.BABY_ON_LAND_SELECTOR));

    }

    public boolean hurt(DamageSource source, float damage) {
        if (!this.isCharging || !this.isStunned) {
            damage = damage * .25F;
        }
        if (this.isStunned) {
            damage += .1F;
        }

        if (this.isCharging && !this.isCharged) {
            isStunned = true;
        }

        return super.hurt(source, damage);
    }

    @Override
    public void tick() {
        super.tick();

        if (!this.level.isClientSide()) {
            if (this.bossEvent.getProgress() < 1.0F && this.bossEvent.getProgress() > 0) {
                if (!this.isCharging || !this.isCharged || !this.isStunned)
                    this.summonMinionsCooldown++;
            }

            lightningTick++;
            checkStaticCooldown++;

            if (checkStaticCooldown == 20) {
                checkStaticCooldown = 0;

                int totalStatic = 0;

                List<Entity> nearbyPlayers = level.getEntities(this, this.getBoundingBox().inflate(32.0D),
                        EntitySelector.NO_SPECTATORS.and(Entity::isPickable).and(EntitySelector.LIVING_ENTITY_STILL_ALIVE).and(IS_PLAYER));

                for (Entity entity : nearbyPlayers) {
                    Player player = (Player) entity;
                    if (player.hasEffect(EffectRegistry.STATIC_EFFECT.get())) {
                        int amplifier = player.getEffect(EffectRegistry.STATIC_EFFECT.get()).getAmplifier();
                        totalStatic += amplifier;
                    }
                }
                if (totalStatic > STATIC_CAP) totalStatic = STATIC_CAP; //cap at 20

                CelestialExploration.LOGGER.debug("LIGHTNING_MAX_COOLDOWN " + LIGHTNING_MAX_COOLDOWN + " - (staticAffect " + staticAffect + " * totalStatic " + totalStatic + ") = " + lightningAttackCooldown);


                lightningAttackCooldown = LIGHTNING_MAX_COOLDOWN - (staticAffect * totalStatic);
            }

            CelestialExploration.LOGGER.debug("lightningTick: " + lightningTick + ", cooldown: " + lightningAttackCooldown + "| minions: " + summonMinionsCooldown + ", cooldown: " + MAX_MINION_COOLDOWN);

            modifyStrategyTick++;

            if (modifyStrategyTick > 60) {
                modifyStrategyTick = 0;

                List<Entity> nearbyPlayers = level.getEntities(this, this.getBoundingBox().inflate(5.0D),
                        EntitySelector.NO_SPECTATORS.and(Entity::isPickable).and(EntitySelector.LIVING_ENTITY_STILL_ALIVE).and(IS_PLAYER));

                if (nearbyPlayers.size() > 1) { //multiple players up close
                    lightningTick += 50;
                } else if (nearbyPlayers.size() == 1) {
                    summonMinionsCooldown += 10;
                } else {
                    summonMinionsCooldown += 50;
                }

            }

        }

    }

    public void makeInvulnerable() {
//        if (!this.isTame()) {
//            this.setInvulnerableTicks(INVULNERABLE_TICKS);
//            this.bossEvent.setProgress(0.0F);
//            this.setHealth(this.getMaxHealth() / 3.0F);
//        }
    }

    public void addAdditionalSaveData(CompoundTag nbt) {
        super.addAdditionalSaveData(nbt);
        nbt.putInt("Invul", this.getInvulnerableTicks());
        nbt.putInt("lightningAttackCooldown", this.lightningAttackCooldown);
        nbt.putInt("lightningTick", this.lightningTick);
        nbt.putInt("summonMinionsCooldown", this.summonMinionsCooldown);
        nbt.putBoolean("isCharging", this.isCharging);
        nbt.putInt("chargingTime", this.chargingTime);
        nbt.putBoolean("isCharged", this.isCharged);
        nbt.putBoolean("isStunned", this.isStunned);
        nbt.putInt("checkStaticCooldown", this.checkStaticCooldown);
        nbt.putInt("modifyStrategyTick", this.modifyStrategyTick);
    }

    public void readAdditionalSaveData(CompoundTag nbt) {
        super.readAdditionalSaveData(nbt);
        this.setInvulnerableTicks(nbt.getInt("Invul"));
        if (this.hasCustomName()) {
            if (!this.isTame())
                this.bossEvent.setName(this.getDisplayName());
        }
        if (nbt.contains("lightningAttackCooldown")) this.lightningAttackCooldown = nbt.getInt("lightningAttackCooldown");
        if (nbt.contains("lightningTick")) this.lightningTick = nbt.getInt("lightningTick");
        if (nbt.contains("summonMinionsCooldown")) this.summonMinionsCooldown = nbt.getInt("summonMinionsCooldown");
        if (nbt.contains("isCharging")) this.isCharging = nbt.getBoolean("isCharging");
        if (nbt.contains("chargingTime")) this.chargingTime = nbt.getInt("chargingTime");
        if (nbt.contains("isCharged")) this.isCharged = nbt.getBoolean("isCharged");
        if (nbt.contains("isStunned")) this.isStunned = nbt.getBoolean("isStunned");
        if (nbt.contains("checkStaticCooldown")) this.checkStaticCooldown = nbt.getInt("checkStaticCooldown");
        if (nbt.contains("modifyStrategyTick")) this.modifyStrategyTick = nbt.getInt("modifyStrategyTick");
    }

    public int getInvulnerableTicks() {
        return this.entityData.get(DATA_ID_INV);
    }

    public void setInvulnerableTicks(int p_31511_) {
        this.entityData.set(DATA_ID_INV, p_31511_);
    }

    public void setCustomName(@Nullable Component p_31476_) {
        super.setCustomName(p_31476_);
        if (!this.isTame())
            this.bossEvent.setName(this.getDisplayName());
    }

    public void startSeenByPlayer(ServerPlayer p_31483_) {
        if (!this.isTame()) {
            this.bossEvent.addPlayer(p_31483_);
        }
    }

    public void stopSeenByPlayer(ServerPlayer p_31488_) {
        if (!this.isTame()) {
            this.bossEvent.removePlayer(p_31488_);
        }
    }

    protected void customServerAiStep() {
       this.bossEvent.setProgress(this.getHealth() / this.getMaxHealth());
    }

    @Override
    public boolean canBeLeashed(Player p_21813_) {
        return false;
    }

    @Override
    public void setTame(boolean p_30443_) {}

    public static AttributeSupplier.Builder createAttributes() {
        return Monster.createMonsterAttributes().add(Attributes.MAX_HEALTH, 250.0D).add(Attributes.MOVEMENT_SPEED, 0.28F).add(Attributes.FOLLOW_RANGE, 40.0D).add(Attributes.ARMOR, 4.0D)
                .add(Attributes.ATTACK_KNOCKBACK, 1.5D);
    }

    public void checkDespawn() {
        if (this.level.getDifficulty() == Difficulty.PEACEFUL && this.shouldDespawnInPeaceful()) {
            this.discard();
        } else {
            this.noActionTime = 0;
        }
    }

    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(DATA_ID_INV, 0);
    }

    public static class ChargeUpForAttackGoal extends Goal {
        MechaCerberusBoss boss;
        boolean stunned;

        public ChargeUpForAttackGoal(MechaCerberusBoss mechaCerberus) {
            this.boss = mechaCerberus;
            this.setFlags(EnumSet.of(Goal.Flag.JUMP, Goal.Flag.MOVE));
//            this.setFlags(EnumSet.of(Goal.Flag.MOVE));
        }

        @Override
        public boolean canUse() {
            if (this.boss.isCharged) return false;
//            if (this.boss.bossEvent.getProgress() == 1.0F) return false;
            if (this.boss.lightningTick < this.boss.lightningAttackCooldown) return false;
            return this.boss.chargingTime <= MAX_CHARGE_TIME;
        }

        @Override
        public boolean canContinueToUse() {
            if (this.boss.isStunned) return false;
            return super.canContinueToUse();
        }

        @Override
        public void start() {
            LivingEntity entity = this.boss.getTarget();
            if (entity != null)
                entity.addEffect(new MobEffectInstance(MobEffects.LUCK, 100));

            this.boss.getNavigation().stop();
            this.boss.isCharging = true;
            this.stunned = false;
        }

        @Override
        public void stop() {
            LivingEntity entity = this.boss.getTarget();
            if (entity != null)
                entity.removeEffect(MobEffects.LUCK);

            this.boss.isCharged = !this.boss.isStunned;

            this.boss.isCharging = false;
            this.boss.chargingTime = 0;
            this.boss.lightningTick = 0;
        }

        @Override
        public boolean requiresUpdateEveryTick() {
            return true;
        }

        @Override
        public void tick() {
            if (!stunned) {
                this.boss.chargingTime++;
            }
        }
    }

    public static class CerberusLightningAOEAttackGoal extends Goal {
        MechaCerberusBoss boss;

        public CerberusLightningAOEAttackGoal(MechaCerberusBoss mechaCerberus) {
            this.boss = mechaCerberus;
//            this.setFlags(EnumSet.of(Goal.Flag.JUMP, Goal.Flag.MOVE));
            this.setFlags(EnumSet.of(Goal.Flag.MOVE));
        }

        @Override
        public boolean canUse() {
            return this.boss.isCharged && !this.boss.isStunned;
        }

        @Override
        public void start() {
            this.boss.getNavigation().stop();
            this.boss.summonMinionsCooldown -= 80;

            //FIXME change to…whatever it is we're doing instead
            explode();
            super.start();
        }

        private void explode() {
            if (!this.boss.level.isClientSide) {
                float currentHealth = this.boss.getHealth();
                this.boss.level.explode(this.boss, this.boss.getX(), this.boss.getY(), this.boss.getZ(), 4.0F, Explosion.BlockInteraction.NONE);
                this.boss.setHealth(currentHealth);
                spawnLingeringCloud();
            }
            this.boss.isCharged = false;
        }

        private void spawnLingeringCloud() {
            Collection<MobEffectInstance> collection = this.boss.getActiveEffects();
            if (!collection.isEmpty()) {
                AreaEffectCloud areaeffectcloud = new AreaEffectCloud(this.boss.level, this.boss.getX(), this.boss.getY(), this.boss.getZ());
                areaeffectcloud.setRadius(2.5F);
                areaeffectcloud.setRadiusOnUse(-0.5F);
                areaeffectcloud.setWaitTime(10);
                areaeffectcloud.setDuration(areaeffectcloud.getDuration() / 2);
                areaeffectcloud.setRadiusPerTick(-areaeffectcloud.getRadius() / (float)areaeffectcloud.getDuration());

                for(MobEffectInstance mobeffectinstance : collection) {
                    areaeffectcloud.addEffect(new MobEffectInstance(mobeffectinstance));
                }

                this.boss.level.addFreshEntity(areaeffectcloud);
            }

        }

        @Override
        public void stop() {
            this.boss.isCharged = false;
        }

        @Override
        public boolean isInterruptable() {
            return false;
        }
    }

    public static class StunByAttackGoal extends Goal {
        MechaCerberusBoss boss;
        static final int MAX_STUN = 20;
        int stunTick;

        public StunByAttackGoal(MechaCerberusBoss mechaCerberus) {
            this.boss = mechaCerberus;
            this.setFlags(EnumSet.of(Goal.Flag.JUMP, Goal.Flag.MOVE));
        }

        @Override
        public boolean canUse() {
            return this.boss.isStunned;
        }

        @Override
        public void start() {
            LivingEntity entity = this.boss.getTarget();
            if (entity != null)
                entity.addEffect(new MobEffectInstance(MobEffects.WATER_BREATHING, 100));

            this.boss.getNavigation().stop();
            super.start();
        }

        @Override
        public void stop() {
            LivingEntity entity = this.boss.getTarget();
            if (entity != null)
                entity.removeEffect(MobEffects.WATER_BREATHING);

        }

        @Override
        public void tick() {
            super.tick();
            stunTick++;
            if (stunTick > MAX_STUN) {
                this.boss.isStunned = false;
                stunTick = 0;
            }
        }
    }

    public static class IsStuckGoal extends Goal {
        MechaCerberusBoss boss;

        public IsStuckGoal(MechaCerberusBoss mechaCerberus) {}

        @Override
        public boolean canUse() {
            return false;
        }
    }

    public static class CerberusMeleeAttackGoal extends MeleeAttackGoal {

        public CerberusMeleeAttackGoal(PathfinderMob p_25552_, double p_25553_, boolean p_25554_) {
            super(p_25552_, p_25553_, p_25554_);

        }

        @Override
        protected void checkAndPerformAttack(LivingEntity target, double p_25558_) {
            double d0 = this.getAttackReachSqr(target);
            if (p_25558_ <= d0 && this.getTicksUntilNextAttack() <= 0) {
                this.resetAttackCooldown();
                this.mob.swing(InteractionHand.MAIN_HAND);
                CelestialExploration.LOGGER.debug("knockback: " + this.mob.getAttribute(Attributes.ATTACK_KNOCKBACK).getValue());
                this.mob.doHurtTarget(target);
                if (target.hasEffect(EffectRegistry.STATIC_EFFECT.get())) {
                    int amplifier = target.getEffect(EffectRegistry.STATIC_EFFECT.get()).getAmplifier();
                    if (amplifier >= 9)
                        target.addEffect(new MobEffectInstance(EffectRegistry.STATIC_EFFECT.get(), 600, 9));
                    else
                        target.addEffect(new MobEffectInstance(EffectRegistry.STATIC_EFFECT.get(), 600, amplifier + 1));
                } else {
                    target.addEffect(new MobEffectInstance(EffectRegistry.STATIC_EFFECT.get(), 600));
                }
            }
        }
    }

    public static class SummonMinionsGoal extends Goal {
        MechaCerberusBoss boss;

        public SummonMinionsGoal(MechaCerberusBoss mechaCerberus) {
            this.boss = mechaCerberus;
            this.setFlags(EnumSet.of(Goal.Flag.MOVE));
        }

        @Override
        public boolean canUse() {
            CelestialExploration.LOGGER.debug("returning: " + (this.boss.summonMinionsCooldown > MAX_MINION_COOLDOWN && !this.boss.isCharging && !this.boss.isCharged && !this.boss.isStunned) +
                    ", !isCharging: " + !this.boss.isCharging + ", !isCharged" + !this.boss.isCharged + ", !isStunned" + !this.boss.isStunned);
            return this.boss.summonMinionsCooldown > MAX_MINION_COOLDOWN && !this.boss.isCharging && !this.boss.isCharged && !this.boss.isStunned;
        }

        @Override
        public void start() {
            LivingEntity entity = this.boss.getTarget();
            if (entity != null)
                entity.addEffect(new MobEffectInstance(MobEffects.GLOWING, 20));

            this.boss.getNavigation().stop();
            int rand = this.boss.random.nextInt(9);
            int numMinions = switch (rand) {
                case 0 -> 3;
                case 1, 2, 3 -> 2;
                default -> 1;
            };

            for (int i = 0; i <= numMinions; i++) {
                if (!this.boss.level.isClientSide()) {
                    ServerLevel serverLevel = (ServerLevel) this.boss.level;

                    MechaDog dog = EntityRegistry.MECHADOG.get().create(this.boss.level);
                    dog.moveTo(this.boss.blockPosition().west(i), 0, 0);

                    serverLevel.addFreshEntityWithPassengers(dog);
                }
            }
            this.boss.summonMinionsCooldown = 0;
        }

        @Override
        public void stop() {
            super.stop();
        }
    }
}
