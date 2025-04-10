package com.shim.celestialexploration.entity.entity.robots;

import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestialexploration.entity.entity.mob.Gust;
import com.shim.celestialexploration.entity.entity.projectile.StaticPulseProjectile;
import com.shim.celestialexploration.registry.EffectRegistry;
import com.shim.celestialexploration.registry.EntityRegistry;
import mod.azure.azurelib.ai.pathing.AzureNavigation;
import mod.azure.azurelib.core.animation.AnimatableManager;
import mod.azure.azurelib.core.animation.AnimationController;
import mod.azure.azurelib.core.animation.RawAnimation;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerBossEvent;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.Mth;
import net.minecraft.world.BossEvent;
import net.minecraft.world.Difficulty;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Enemy;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

import javax.annotation.Nullable;
import java.util.EnumSet;
import java.util.List;
import java.util.function.Predicate;

public class MechaCerberusBoss extends AbstractCerberus implements Enemy {
    private final ServerBossEvent bossEvent = (ServerBossEvent) (new ServerBossEvent(this.getDisplayName(), BossEvent.BossBarColor.RED, BossEvent.BossBarOverlay.PROGRESS)).setDarkenScreen(true);
    private static final int INVULNERABLE_TICKS = 100;
    private static final EntityDataAccessor<Integer> DATA_ID_INV = SynchedEntityData.defineId(MechaCerberusBoss.class, EntityDataSerializers.INT);
    int lightningAttackCooldown;
    int lightningTick;
    final static int LIGHTNING_MIN_COOLDOWN = 200; //200
    final static int LIGHTNING_MAX_COOLDOWN = 1000;
    final static int MAX_MINION_COOLDOWN = 700;
    final static int STATIC_CAP = 50;
    final static int PLAYER_CAP = 5;
    int summonMinionsTick;
    private static final EntityDataAccessor<Boolean> DATA_IS_CHARGING = SynchedEntityData.defineId(MechaCerberusBoss.class, EntityDataSerializers.BOOLEAN);
    int chargingTick;
    final static int MAX_CHARGE_TIME = 280;
    private static final EntityDataAccessor<Boolean> DATA_IS_CHARGED = SynchedEntityData.defineId(MechaCerberusBoss.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Boolean> DATA_IS_STUNNED = SynchedEntityData.defineId(MechaCerberusBoss.class, EntityDataSerializers.BOOLEAN);
    int checkStaticCooldown;
    int modifyStrategyTick;
    public static final Predicate<Entity> IS_PLAYER = (entity) -> entity instanceof Player;
    static final int MAX_STATIC_DURATION = 500;
    static final int MIN_STATIC_DURATION = 200;
    private static final EntityDataAccessor<Boolean> DATA_IS_HOWLING = SynchedEntityData.defineId(MechaCerberusBoss.class, EntityDataSerializers.BOOLEAN);
    static final int MIN_PROJECTILES = 3;
    static final int MAX_PROJECTILES = 8;
    public static final Predicate<Entity> IS_TAMED_MECHADOG = (entity) -> {
        if (entity instanceof MechaDog dog) return dog.isTame();
        else return entity.isAlive();
    };

    public MechaCerberusBoss(EntityType<? extends MechaCerberusBoss> p_30369_, Level p_30370_) {
        super(p_30369_, p_30370_);
        this.setTame(false);
//        this.isCharging = false;
//        this.isCharged = false;
//        this.isStunned = false;
        this.chargingTick = 0;
        this.summonMinionsTick = 0;
        this.checkStaticCooldown = 0;
        this.lightningTick = 0;
        this.setCharged(false);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(1, new FloatGoal(this));
        this.goalSelector.addGoal(1, new CerberusPanicGoal(1.5D));
        this.goalSelector.addGoal(3, new CerberusAvoidEntityGoal<>(this, Gust.class, 24.0F, 1.5D, 1.5D));
        this.goalSelector.addGoal(4, new LeapAtTargetGoal(this, 0.4F));
        this.goalSelector.addGoal(6, new CerberusMeleeAttackGoal(this, 1.0D, true));
        this.goalSelector.addGoal(8, new WaterAvoidingRandomStrollGoal(this, 1.0D));
        this.goalSelector.addGoal(10, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.goalSelector.addGoal(10, new RandomLookAroundGoal(this));

        this.goalSelector.addGoal(5, new ChargeUpForAttackGoal(this));
        this.goalSelector.addGoal(2, new CerberusLightningAOEAttackGoal(this));
        this.goalSelector.addGoal(1, new StunByAttackGoal(this));
//        this.goalSelector.addGoal(2, new IsStuckGoal(this));
        this.goalSelector.addGoal(3, new SummonMinionsGoal(this));


        this.targetSelector.addGoal(3, (new HurtByTargetGoal(this)).setAlertOthers());

        this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, Player.class, 10, true, false, (entity) -> {
            if (entity instanceof MechaDog dog) return entity.isAlive() && dog.isTame();
            else return entity.isAlive();
        }));

//        this.targetSelector.addGoal(5, new NonTameCreatureRandomTargetGoal<>(this, Animal.class, false, PREY_SELECTOR));
//        this.targetSelector.addGoal(6, new NonTameCreatureRandomTargetGoal<>(this, Turtle.class, false, Turtle.BABY_ON_LAND_SELECTOR));

    }

    public boolean isHowling() {
        return this.entityData.get(DATA_IS_HOWLING);
    }

    public void setHowling(boolean isHowling) {
        this.entityData.set(DATA_IS_HOWLING, isHowling);
    }

    public boolean isCharging() {
        return this.entityData.get(DATA_IS_CHARGING);
    }

    public void setCharging(boolean isCharging) {
        this.entityData.set(DATA_IS_CHARGING, isCharging);
    }

    public boolean isCharged() {
        return this.entityData.get(DATA_IS_CHARGED);
    }

    public void setCharged(boolean isCharged) {
        this.entityData.set(DATA_IS_CHARGED, isCharged);
    }

    public boolean isStunned() {
        return this.entityData.get(DATA_IS_STUNNED);
    }

    public void setStunned(boolean isStunned) {
        this.entityData.set(DATA_IS_STUNNED, isStunned);
    }

    protected static final RawAnimation howl = RawAnimation.begin().thenLoop("howl");
    protected static final RawAnimation stun = RawAnimation.begin().thenLoop("stun");
    protected static final RawAnimation charge_up = RawAnimation.begin().thenLoop("charge_up");


    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
        controllers.add(new AnimationController<>(this, "mechacerberus", 0, event -> {

//            CelestialExploration.LOGGER.debug("checking for howling for animation");

                    if (event.getAnimatable().isHowling()) {
                        return event.setAndContinue(howl);
                    }
                    if (event.getAnimatable().isCharging()) {
                        return event.setAndContinue(charge_up);
                    }
                    if (event.getAnimatable().isStunned()) {
                        return event.setAndContinue(stun);
                    }

                    boolean tamed = event.getAnimatable().isTame();
                    if (event.getAnimatable().isInSittingPose()) {
                        return event.setAndContinue(sit);
                    }

                    if (tamed && event.isMoving()) {
                        return event.setAndContinue(tamed_walk);
                    } else if (tamed && !event.isMoving()) {
//                    } else {
                        return event.setAndContinue(tamed_idle);
                    } else if (!tamed && event.isMoving()) {
                        return event.setAndContinue(tamed_walk);
//                        return event.setAndContinue(wild_walk);
                    } else {
                        return event.setAndContinue(tamed_idle);
//                        return event.setAndContinue(wild_idle);
                    }
                })
        );
    }

    public boolean hurt(DamageSource source, float damage) {
        if (!this.isStunned()) {
            damage = damage * .25F;
        }
        if (this.isStunned()) {
            damage += .1F;
        }

        if (this.isCharging() && !this.isCharged()) {
            setStunned(true);
        }

        Entity attacker = source.getEntity();
        if (attacker instanceof Player player) {
            float attackScale = player.getAttackStrengthScale(1.0F);
//            player.displayClientMessage(new TextComponent("attackScale: " + attackScale + ", strengthDelay: " + player.getCurrentItemAttackStrengthDelay()),  true);

//            if (attackScale > 0.9F) {

            if (player.hasEffect(EffectRegistry.STATIC_EFFECT.get())) {
                int amplifier = player.getEffect(EffectRegistry.STATIC_EFFECT.get()).getAmplifier();
                if (amplifier >= 9) {
                    if (player.getEffect(EffectRegistry.STATIC_EFFECT.get()).getDuration() < MIN_STATIC_DURATION - 20)
                        player.addEffect(new MobEffectInstance(EffectRegistry.STATIC_EFFECT.get(), MIN_STATIC_DURATION, 9));
                } else {
                    int duration = MAX_STATIC_DURATION - ((amplifier + 1) * 10);
                    if (player.getEffect(EffectRegistry.STATIC_EFFECT.get()).getDuration() < duration - 40)
                        player.addEffect(new MobEffectInstance(EffectRegistry.STATIC_EFFECT.get(), duration, amplifier + 1));
                }
            } else {
                player.addEffect(new MobEffectInstance(EffectRegistry.STATIC_EFFECT.get(), MAX_STATIC_DURATION));
            }

//                if (livingEntity instanceof Player player) {
            player.displayClientMessage(new TextComponent("static: " + player.getEffect(EffectRegistry.STATIC_EFFECT.get()).getAmplifier()), false);
//                }
//            }
        }

        return super.hurt(source, damage);
    }

//    private Vec3 imTooSickToNameMethods(int angle) {
//        int x;
//
//        if (angle >= 0 && angle < 90) { //quadrant 1
//            x = angle;
//            return new Vec3(Math.sin(Math.toRadians(x)), 0.0F, Math.cos(Math.toRadians(x)));
//        } else if (angle >= 90 && angle < 180) { //quadrant 2
//            x = angle - 90;
//            return new Vec3(Math.cos(Math.toRadians(x)), 0.0F, -Math.sin(Math.toRadians(x)));
//        } else if (angle >= 180 && angle < 270) { //quad 3
//            x = angle - 180;
//            return new Vec3(-Math.sin(Math.toRadians(x)), 0.0F, -Math.cos(Math.toRadians(x)));
//        } else { //better be quad 4… or else
//            x = angle - 270;
//            return new Vec3(-Math.cos(Math.toRadians(x)), 0.0F, Math.sin(Math.toRadians(x)));
//        }
//    }

    @Override
    public void tick() {
        super.tick();

//        CelestialExploration.LOGGER.debug("isCharged: " + isCharged() + ", isCharging: " + isCharging() + ", isStunned: " + isStunned() + ", isHowling: " + isHowling());

        if (!this.level.isClientSide()) {
//            CelestialExploration.LOGGER.debug("facing: " + this.getLookAngle());

            if (this.bossEvent.getProgress() < 1.0F && this.bossEvent.getProgress() > 0) {
                if (!this.isCharging() || !this.isCharged() || !this.isStunned())
                    this.summonMinionsTick++;
            }

//            ServerLevel serverLevel = (ServerLevel) this.level;
//
//            int arcLength = 20;
//            for (int i = 0; i < 360; i += arcLength) {
//                Vec3 angle = imTooSickToNameMethods(i);
//                serverLevel.sendParticles(ParticleTypes.SOUL_FIRE_FLAME, this.position().x(), this.position().y() + 3.5, this.position().z(), 0,
//                        angle.x(), 0.0F, angle.z(), 0.5F);
//            }

//            serverLevel.sendParticles(ParticleTypes.SOUL_FIRE_FLAME, this.position().x(), this.position().y() + 3.5, this.position().z(), 0,
//                    0.7D, 0.0F, 0.7F, 0.5F);
//            serverLevel.sendParticles(ParticleTypes.SOUL_FIRE_FLAME, this.position().x(), this.position().y() + 3.5, this.position().z(), 0,
//                    -0.7D, 0.0F, 0.7F, 0.5F);
//            serverLevel.sendParticles(ParticleTypes.SOUL_FIRE_FLAME, this.position().x(), this.position().y() + 3.5, this.position().z(), 0,
//                    -0.7D, 0.0F, -0.7F, 0.5F);
//            serverLevel.sendParticles(ParticleTypes.SOUL_FIRE_FLAME, this.position().x(), this.position().y() + 3.5, this.position().z(), 0,
//                    0.7D, 0.0F, -0.7F, 0.5F);
//
//            serverLevel.sendParticles(ParticleTypes.SOUL_FIRE_FLAME, this.position().x(), this.position().y() + 3.5, this.position().z(), 0,
//                    -1.0D, 0.0F, 0.0F, 0.5F);
//            serverLevel.sendParticles(ParticleTypes.SOUL_FIRE_FLAME, this.position().x(), this.position().y() + 3.5, this.position().z(), 0,
//                    0.0D, 0.0F, -1.0F, 0.5F);
//            serverLevel.sendParticles(ParticleTypes.SOUL_FIRE_FLAME, this.position().x(), this.position().y() + 3.5, this.position().z(), 0,
//                    1.0D, 0.0F, 0.0F, 0.5F);
//            serverLevel.sendParticles(ParticleTypes.SOUL_FIRE_FLAME, this.position().x(), this.position().y() + 3.5, this.position().z(), 0,
//                    0.0D, 0.0F, 1.0F, 0.5F);


            lightningTick++;

//            CelestialExploration.LOGGER.debug("lightningTick: " + lightningTick + ", cooldown: " + lightningAttackCooldown);
            checkStaticCooldown++;

            if (checkStaticCooldown == 20) {
                checkStaticCooldown = 0;

                int totalStatic = 0;
                int playerCount;
                int staticWorth;

                List<Entity> nearbyPlayers = level.getEntities(this, this.getBoundingBox().inflate(32.0D),
                        EntitySelector.NO_SPECTATORS.and(Entity::isPickable).and(EntitySelector.LIVING_ENTITY_STILL_ALIVE).and(IS_PLAYER));

                for (Entity entity : nearbyPlayers) {
                    Player player = (Player) entity;
                    if (player.hasEffect(EffectRegistry.STATIC_EFFECT.get())) {
                        int amplifier = player.getEffect(EffectRegistry.STATIC_EFFECT.get()).getAmplifier() + 1;
                        totalStatic += amplifier;
                    }
                }
                if (totalStatic > STATIC_CAP) totalStatic = STATIC_CAP;

                playerCount = Mth.clamp(nearbyPlayers.size(), 1, PLAYER_CAP);

                staticWorth = (LIGHTNING_MAX_COOLDOWN - LIGHTNING_MIN_COOLDOWN) / (playerCount * 10);
                lightningAttackCooldown = LIGHTNING_MAX_COOLDOWN - (totalStatic * staticWorth);

//                lightningAttackCooldown = LIGHTNING_MAX_COOLDOWN - (staticAffect * totalStatic);

                LivingEntity entity = this.getTarget();
                if (entity != null) {
                    if (entity instanceof Player player) {
                        player.displayClientMessage(new TextComponent("summonMinions: " + summonMinionsTick + "/" + MAX_MINION_COOLDOWN + ", lightning: " + lightningTick + "/" + lightningAttackCooldown), false);
                    }
                }

                if (this.lightningTick >= (this.lightningAttackCooldown - 60)) {
                    this.summonMinionsTick = MAX_MINION_COOLDOWN;
                }
            }


//            modifyStrategyTick++;
//
//            if (modifyStrategyTick > 60) {
//                modifyStrategyTick = 0;
//
//                List<Entity> nearbyPlayers = level.getEntities(this, this.getBoundingBox().inflate(5.0D),
//                        EntitySelector.NO_SPECTATORS.and(Entity::isPickable).and(EntitySelector.LIVING_ENTITY_STILL_ALIVE).and(IS_PLAYER));
//
//                if (nearbyPlayers.size() > 1) { //multiple players up close
//                    lightningTick += 50;
//                } else if (nearbyPlayers.size() == 1) {
//                    summonMinionsTick += 10;
//                } else {
//                    summonMinionsTick += 50;
//                }
//
//            }

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
        nbt.putInt("summonMinionsCooldown", this.summonMinionsTick);
        nbt.putBoolean("isCharging", this.isCharging());
        nbt.putInt("chargingTime", this.chargingTick);
        nbt.putBoolean("isCharged", this.isCharged());
        nbt.putBoolean("isStunned", this.isStunned());
        nbt.putBoolean("isHowling", this.isHowling());
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
        if (nbt.contains("lightningAttackCooldown"))
            this.lightningAttackCooldown = nbt.getInt("lightningAttackCooldown");
        if (nbt.contains("lightningTick")) this.lightningTick = nbt.getInt("lightningTick");
        if (nbt.contains("summonMinionsCooldown")) this.summonMinionsTick = nbt.getInt("summonMinionsCooldown");
        if (nbt.contains("isCharging")) this.setCharging(nbt.getBoolean("isCharging"));
        if (nbt.contains("chargingTime")) this.chargingTick = nbt.getInt("chargingTime");
        if (nbt.contains("isCharged")) this.setCharged(nbt.getBoolean("isCharged"));
        if (nbt.contains("isStunned")) this.setStunned(nbt.getBoolean("isStunned"));
        if (nbt.contains("isHowling")) this.setHowling(nbt.getBoolean("isHowling"));
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
    public void setTame(boolean p_30443_) {
    }

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
        this.entityData.define(DATA_IS_HOWLING, false);
        this.entityData.define(DATA_IS_CHARGING, false);
        this.entityData.define(DATA_IS_CHARGED, false);
        this.entityData.define(DATA_IS_STUNNED, false);
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
            if (this.boss.isCharged()) return false;
            if (this.boss.lightningTick < this.boss.lightningAttackCooldown) return false;
            if (this.boss.level.getDifficulty() == Difficulty.PEACEFUL) return false;
            return this.boss.chargingTick <= Math.min(MAX_CHARGE_TIME * (this.boss.getHealth() / this.boss.getMaxHealth()), (float) MAX_CHARGE_TIME / 3);
        }

        @Override
        public boolean canContinueToUse() {
            if (this.boss.isStunned()) return false;
            return super.canContinueToUse();
        }

        @Override
        public void start() {
            LivingEntity entity = this.boss.getTarget();
            if (entity != null) {
                entity.addEffect(new MobEffectInstance(MobEffects.LUCK, 100));
                if (entity instanceof Player player) {
                    player.displayClientMessage(new TextComponent("charging up for attack"), false);
                }
            }
//            this.boss.getNavigation().stop();
            ((AzureNavigation) this.boss.getNavigation()).hardStop();

            this.boss.setCharging(true);
            this.stunned = false;
        }

        @Override
        public void stop() {
            LivingEntity entity = this.boss.getTarget();
            if (entity != null)
                entity.removeEffect(MobEffects.LUCK);

            this.boss.setCharged(!this.boss.isStunned());
//            this.boss.isCharged = !this.boss.isStunned;

            this.boss.setCharging(false);
//            this.boss.isCharging = false;
            this.boss.chargingTick = 0;
            this.boss.lightningTick = 0;
        }

        @Override
        public boolean requiresUpdateEveryTick() {
            return true;
        }

        @Override
        public void tick() {

            CelestialExploration.LOGGER.debug("chargingTick: " + this.boss.chargingTick + ", totalCharge: " + Math.min(MAX_CHARGE_TIME * (this.boss.getHealth() / this.boss.getMaxHealth()), (float) MAX_CHARGE_TIME / 3));

            if (!stunned) {
                this.boss.chargingTick++;
            }
        }
    }

    public static class CerberusLightningAOEAttackGoal extends Goal {
        MechaCerberusBoss boss;
        int lengthTick = 0;

        public CerberusLightningAOEAttackGoal(MechaCerberusBoss mechaCerberus) {
            this.boss = mechaCerberus;
//            this.setFlags(EnumSet.of(Goal.Flag.JUMP, Goal.Flag.MOVE));
            this.setFlags(EnumSet.of(Goal.Flag.MOVE));
        }

        @Override
        public boolean canUse() {
            if (this.boss.level.getDifficulty() == Difficulty.PEACEFUL) return false;

//            List<Entity> nearbyPlayers = this.boss.level.getEntities(this.boss, this.boss.getBoundingBox().inflate(40.0D),
//                    EntitySelector.NO_CREATIVE_OR_SPECTATOR.and(Entity::isPickable).and(EntitySelector.LIVING_ENTITY_STILL_ALIVE).and(IS_PLAYER));
//
//            if (nearbyPlayers.isEmpty()) return false;

            return this.boss.isCharged() && !this.boss.isStunned();
        }

        @Override
        public boolean canContinueToUse() {
            if (this.lengthTick > 50) return false;
            else return super.canContinueToUse();
        }

        @Override
        public void start() {
            ((AzureNavigation) this.boss.getNavigation()).hardStop();
//            this.boss.summonMinionsTick -= 80;

            if (this.boss.getTarget() instanceof Player player) player.displayClientMessage(new TextComponent("lightning attack!"), false);

            if (!this.boss.level.isClientSide()) {
                ServerLevel serverLevel = (ServerLevel) this.boss.level;

//                int circleSections = 360 / 45; //8
//                for (int i = 0; i < circleSections; i++) {
//                    float j = 1.0F / (float) circleSections;
//
//                    serverLevel.sendParticles(ParticleTypes.ELECTRIC_SPARK, this.boss.position().x(), this.boss.position().y(), this.boss.position().z(), 0,
//                            j * (i + 1), 0.0F, j * (i + 1), 1.0F);
//                }

//                CelestialExploration.LOGGER.debug("facing: " + this.boss.getLookAngle());


                int arcLength = 20;
                for (int i = 0; i < 360; i += arcLength) {
                    Vec3 angle = getParticleDirection(i);
                    serverLevel.sendParticles(ParticleTypes.SOUL_FIRE_FLAME, this.boss.position().x(), this.boss.position().y() + 1.5, this.boss.position().z(), 0,
                            angle.x(), 0.0F, angle.z(), 0.91F);

                    serverLevel.sendParticles(ParticleTypes.SOUL_FIRE_FLAME, this.boss.position().x() + 0.1, this.boss.position().y() + 1.5, this.boss.position().z(), 0,
                            angle.x(), 0.0F, angle.z(), 0.91F);

                    serverLevel.sendParticles(ParticleTypes.SOUL_FIRE_FLAME, this.boss.position().x(), this.boss.position().y() + 1.5, this.boss.position().z() + 0.1, 0,
                            angle.x(), 0.0F, angle.z(), 0.91F);

                }
            }

//            if (this.boss.level instanceof ServerLevel serverLevel) {
//
//                int range = MAX_PROJECTILES - MIN_PROJECTILES;
//                float healthPerc = this.boss.getHealth() / this.boss.getMaxHealth();
//                int projectiles = (int) ((1 - healthPerc) * range) + MIN_PROJECTILES;
//                projectiles += (this.boss.getRandom().nextInt(4) - 2);
//                projectiles = Mth.clamp(projectiles, 1, MAX_PROJECTILES);
//
//
//                for (int i = 0; i <= projectiles; i++) {
//                    spawnProjectiles(serverLevel);
//                    CelestialExploration.LOGGER.debug("spawning projectile " + i + " of " + projectiles);
//                }
//            }
            super.start();
        }
        private void waveAttack(float radius) {
            List<Entity> nearbyEntities = this.boss.level.getEntities(this.boss, this.boss.getBoundingBox().inflate(radius),
                    EntitySelector.NO_CREATIVE_OR_SPECTATOR.and(Entity::isPickable).and(EntitySelector.LIVING_ENTITY_STILL_ALIVE).and(IS_TAMED_MECHADOG));

            for (Entity entity : nearbyEntities) {
                this.doHurtTarget(entity);
            }

            if (!this.boss.level.isClientSide()) {
                ServerLevel serverLevel = (ServerLevel) this.boss.level;
                serverLevel.sendParticles(ParticleTypes.SOUL_FIRE_FLAME, this.boss.position().x() + radius, this.boss.position().y() + 3.5, this.boss.position().z(), 0, 0.0F, 0.0F, 0.0F, 0.15F);
                serverLevel.sendParticles(ParticleTypes.SOUL_FIRE_FLAME, this.boss.position().x() - radius, this.boss.position().y() + 3.5, this.boss.position().z(), 0, 0.0F, 0.0F, 0.0F, 0.15F);
                serverLevel.sendParticles(ParticleTypes.SOUL_FIRE_FLAME, this.boss.position().x(), this.boss.position().y() + 3.5, this.boss.position().z() + radius, 0, 0.0F, 0.0F, 0.0F, 0.15F);
                serverLevel.sendParticles(ParticleTypes.SOUL_FIRE_FLAME, this.boss.position().x(), this.boss.position().y() + 3.5, this.boss.position().z() - radius, 0, 0.0F, 0.0F, 0.0F, 0.15F);
            }
        }

        public boolean doHurtTarget(Entity entity) {
            float damage;

            if (entity instanceof Player)
                damage = (float)this.boss.getAttributeValue(Attributes.ATTACK_DAMAGE) * 3;
            else
                damage = (float)this.boss.getAttributeValue(Attributes.ATTACK_DAMAGE) * 2;

            if (entity instanceof LivingEntity livingEntity) {
                if (livingEntity.hasEffect(EffectRegistry.STATIC_EFFECT.get())) {
                    int amplify = livingEntity.getEffect(EffectRegistry.STATIC_EFFECT.get()).getAmplifier() + 1;
                    damage += (float) amplify * 0.2F;
                }
            }

            if (this.boss.level.getDifficulty() == Difficulty.EASY) damage -= 1.0F;
            if (this.boss.level.getDifficulty() == Difficulty.HARD) damage += 1.0F;

            float knockback = (float)this.boss.getAttributeValue(Attributes.ATTACK_KNOCKBACK);
            if (entity instanceof LivingEntity) {
                damage += EnchantmentHelper.getDamageBonus(this.boss.getMainHandItem(), ((LivingEntity)entity).getMobType());
                knockback += (float)EnchantmentHelper.getKnockbackBonus(this.boss);
            }

            int i = EnchantmentHelper.getFireAspect(this.boss);
            if (i > 0) {
                entity.setSecondsOnFire(i * 4);
            }

            boolean flag = entity.hurt(DamageSource.mobAttack(this.boss), damage);
            if (flag) {
                if (knockback > 0.0F && entity instanceof LivingEntity) {
                    ((LivingEntity)entity).knockback((double)(knockback * 0.5F), (double)Mth.sin(this.boss.getYRot() * ((float)Math.PI / 180F)), (double)(-Mth.cos(this.boss.getYRot() * ((float)Math.PI / 180F))));
                    this.boss.setDeltaMovement(this.boss.getDeltaMovement().multiply(0.6D, 1.0D, 0.6D));
                }

                if (entity instanceof Player player) {
                    this.maybeDisableShield(player, this.boss.getMainHandItem(), player.isUsingItem() ? player.getUseItem() : ItemStack.EMPTY);
                }

                this.boss.doEnchantDamageEffects(this.boss, entity);
                this.boss.setLastHurtMob(entity);
            }

            return flag;
        }

        private void maybeDisableShield(Player p_21425_, ItemStack p_21426_, ItemStack p_21427_) {
            if (!p_21426_.isEmpty() && !p_21427_.isEmpty() && p_21426_.getItem() instanceof AxeItem && p_21427_.is(Items.SHIELD)) {
                float f = 0.25F + (float)EnchantmentHelper.getBlockEfficiency(this.boss) * 0.05F;
                if (this.boss.random.nextFloat() < f) {
                    p_21425_.getCooldowns().addCooldown(Items.SHIELD, 100);
                    this.boss.level.broadcastEntityEvent(p_21425_, (byte)30);
                }
            }

        }

        private Vec3 getParticleDirection(int angle) {
            int x;

            if (angle >= 0 && angle < 90) { //quadrant 1
                x = angle;
                return new Vec3(Math.sin(Math.toRadians(x)), 0.0F, Math.cos(Math.toRadians(x)));
            } else if (angle >= 90 && angle < 180) { //quadrant 2
                x = angle - 90;
                return new Vec3(Math.cos(Math.toRadians(x)), 0.0F, -Math.sin(Math.toRadians(x)));
            } else if (angle >= 180 && angle < 270) { //quad 3
                x = angle - 180;
                return new Vec3(-Math.sin(Math.toRadians(x)), 0.0F, -Math.cos(Math.toRadians(x)));
            } else { //hopefully quad 4…
                x = angle - 270;
                return new Vec3(-Math.cos(Math.toRadians(x)), 0.0F, Math.sin(Math.toRadians(x)));
            }
        }

        private void spawnProjectiles(ServerLevel serverLevel) {
            StaticPulseProjectile pulse = EntityRegistry.STATIC_PULSE.get().create(serverLevel);
            if (pulse != null) {
                pulse.moveTo(this.boss.position().x, this.boss.position().y + 2, this.boss.position().z);
                serverLevel.addFreshEntity(pulse);
            }
        }

//        private void explode() {
//            if (!this.boss.level.isClientSide) {
//                float currentHealth = this.boss.getHealth();
//
//
//
//                this.boss.level.explode(this.boss, this.boss.getX(), this.boss.getY(), this.boss.getZ(), 4.0F, Explosion.BlockInteraction.NONE);
//                this.boss.setHealth(currentHealth);
//                spawnLingeringCloud();
//            }
//            this.boss.setCharged(false);
//            this.boss.isCharged = false;
//        }
//
//        private void spawnLingeringCloud() {
//            Collection<MobEffectInstance> collection = this.boss.getActiveEffects();
//            if (!collection.isEmpty()) {
//                AreaEffectCloud areaeffectcloud = new AreaEffectCloud(this.boss.level, this.boss.getX(), this.boss.getY(), this.boss.getZ());
//                areaeffectcloud.setRadius(2.5F);
//                areaeffectcloud.setRadiusOnUse(-0.5F);
//                areaeffectcloud.setWaitTime(10);
//                areaeffectcloud.setDuration(areaeffectcloud.getDuration() / 2);
//                areaeffectcloud.setRadiusPerTick(-areaeffectcloud.getRadius() / (float) areaeffectcloud.getDuration());
//
//                for (MobEffectInstance mobeffectinstance : collection) {
//                    areaeffectcloud.addEffect(new MobEffectInstance(mobeffectinstance));
//                }
//
//                this.boss.level.addFreshEntity(areaeffectcloud);
//            }
//
//        }
        @Override
        public void tick() {
            this.lengthTick++;

            if (this.lengthTick == 4) waveAttack(3.0F);
            else if (this.lengthTick == 6) waveAttack(5.5F);
            else if (this.lengthTick == 8) waveAttack(8.0F);

            super.tick();
        }

        @Override
        public void stop() {
            this.boss.setCharged(false);
            this.lengthTick = 0;
            super.stop();
//            this.boss.isCharged = false;
        }

//        @Override
//        public boolean isInterruptable() {
//            return false;
//        }
    }

    public static class StunByAttackGoal extends Goal {
        MechaCerberusBoss boss;
        static final int MAX_STUN = 30;
        int stunTick;

        public StunByAttackGoal(MechaCerberusBoss mechaCerberus) {
            this.boss = mechaCerberus;
            this.setFlags(EnumSet.of(Goal.Flag.JUMP, Goal.Flag.MOVE));
        }

        @Override
        public boolean canUse() {
            return this.boss.isStunned();
        }

        @Override
        public void start() {
            LivingEntity entity = this.boss.getTarget();
            if (entity != null)
                entity.addEffect(new MobEffectInstance(MobEffects.WATER_BREATHING, 100));

            if (entity instanceof Player player) {
                player.displayClientMessage(new TextComponent("is stunned!"), false);
            }

//            this.boss.getNavigation().stop();
            ((AzureNavigation) this.boss.getNavigation()).hardStop();
            super.start();
        }

        @Override
        public void stop() {
            LivingEntity entity = this.boss.getTarget();
            if (entity != null)
                entity.removeEffect(MobEffects.WATER_BREATHING);

            List<Entity> nearbyPlayers = this.boss.level.getEntities(this.boss, this.boss.getBoundingBox().inflate(32.0D),
                    EntitySelector.NO_SPECTATORS.and(Entity::isPickable).and(EntitySelector.LIVING_ENTITY_STILL_ALIVE).and(IS_PLAYER));

            for (Entity e : nearbyPlayers) {
                if (e instanceof Player player) {
                    player.removeEffect(EffectRegistry.STATIC_EFFECT.get());
                }
            }
        }

        @Override
        public void tick() {
            super.tick();
            stunTick++;
            if (stunTick > MAX_STUN) {
                this.boss.setStunned(false);
//                this.boss.isStunned = false;
                stunTick = 0;
            }
        }
    }

    public static class IsStuckGoal extends Goal {
        MechaCerberusBoss boss;

        public IsStuckGoal(MechaCerberusBoss mechaCerberus) {
        }

        @Override
        public boolean canUse() {
            return false;
        }
    }

    public static class CerberusMeleeAttackGoal extends MeleeAttackGoal {

        public CerberusMeleeAttackGoal(PathfinderMob p_25552_, double p_25553_, boolean p_25554_) {
            super(p_25552_, p_25553_, p_25554_);
        }

//        @Override
//        protected void checkAndPerformAttack(LivingEntity target, double p_25558_) {
//            double d0 = this.getAttackReachSqr(target);
//            if (p_25558_ <= d0 && this.getTicksUntilNextAttack() <= 0) {
//                this.resetAttackCooldown();
//                this.mob.swing(InteractionHand.MAIN_HAND);
//                this.mob.doHurtTarget(target);

        /// /                int maxDuration = 200;
        /// /                int minDuration = 100;
        /// /                if (target.hasEffect(EffectRegistry.STATIC_EFFECT.get())) {
        /// /                    int amplifier = target.getEffect(EffectRegistry.STATIC_EFFECT.get()).getAmplifier();
        /// /                    if (amplifier >= 9) {
        /// /                        target.addEffect(new MobEffectInstance(EffectRegistry.STATIC_EFFECT.get(), minDuration, 9));
        /// /                    } else {
        /// /                        int duration = maxDuration - ((amplifier + 1) * 10);
        /// /                        target.addEffect(new MobEffectInstance(EffectRegistry.STATIC_EFFECT.get(), duration, amplifier + 1));
        /// /                    }
        /// /                } else {
        /// /                    target.addEffect(new MobEffectInstance(EffectRegistry.STATIC_EFFECT.get(), maxDuration));
        /// /                }
        /// /
        /// /                if (target instanceof Player player) {
        /// /                    player.displayClientMessage(new TextComponent("static: " + player.getEffect(EffectRegistry.STATIC_EFFECT.get()).getAmplifier()), false);
        /// /                }
//
//            }
//        }
        protected double getAttackReachSqr(LivingEntity p_25556_) {
            return (double) (this.mob.getBbWidth() * 1.5F * this.mob.getBbWidth() * 1.5F + p_25556_.getBbWidth()); //2.0F
        }

    }

    public static class SummonMinionsGoal extends Goal {
        MechaCerberusBoss boss;
        int summonLength;

        public SummonMinionsGoal(MechaCerberusBoss mechaCerberus) {
            this.boss = mechaCerberus;
            this.setFlags(EnumSet.of(Goal.Flag.MOVE));
            summonLength = 0;
        }

        @Override
        public boolean canUse() {
            List<Entity> nearbyMinions = boss.level.getEntities(boss, boss.getBoundingBox().inflate(32.0D),
                    EntitySelector.NO_SPECTATORS.and(Entity::isPickable).and(EntitySelector.LIVING_ENTITY_STILL_ALIVE).and((entity) -> entity instanceof MechaDog));

            if (nearbyMinions.size() >= 5) return false;
//            int rand = this.boss.random.nextInt(5);
            CelestialExploration.LOGGER.debug("tick: " + this.boss.summonMinionsTick + ", max: " + MAX_MINION_COOLDOWN + ", !isCharging: " + !this.boss.isCharging() + ", !isCharged: " + !this.boss.isCharged() + ", !isStunned: " +  !this.boss.isStunned());
//            if (nearbyMinions.size() <= rand)
//                return false; //higher chance of summoning more minions the fewer there are
            return this.boss.summonMinionsTick > MAX_MINION_COOLDOWN && !this.boss.isCharging() && !this.boss.isCharged() && !this.boss.isStunned();
        }

        @Override
        public boolean canContinueToUse() {
            return summonLength < 30;
        }

        @Override
        public void tick() {
            summonLength++;
            super.tick();
        }

        @Override
        public void start() {
//            this.boss.getNavigation().stop();
            ((AzureNavigation) this.boss.getNavigation()).hardStop();
            this.boss.setHowling(true);
        }

        @Override
        public void stop() {
            this.boss.setHowling(false);
            summonLength = 0;
            int rand = this.boss.random.nextInt(9);
            int numMinions = switch (rand) {
                case 0 -> 3;
                case 1, 2, 3 -> 2;
                default -> 1;
            };

            LivingEntity entity = this.boss.getTarget();

            if (entity != null) {
                entity.addEffect(new MobEffectInstance(MobEffects.GLOWING, 20));
                if (entity instanceof Player player) {
                    player.displayClientMessage(new TextComponent("summoning " + (numMinions + 1) + " minions"), false);
                }
            }

            for (int i = 0; i <= numMinions; i++) {
                if (!this.boss.level.isClientSide()) {
                    ServerLevel serverLevel = (ServerLevel) this.boss.level;

                    MechaDog dog = EntityRegistry.MECHADOG.get().create(this.boss.level);
                    dog.moveTo(this.boss.blockPosition().west(i), 0, 0);

                    serverLevel.addFreshEntityWithPassengers(dog);
                }
            }

            this.boss.summonMinionsTick = 0;
            super.stop();
        }
    }
}
