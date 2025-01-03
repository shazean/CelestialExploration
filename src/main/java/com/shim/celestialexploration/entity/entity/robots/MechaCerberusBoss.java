package com.shim.celestialexploration.entity.entity.robots;

import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestialexploration.entity.entity.goals.NearestAttackableTargetPeacefulGoal;
import com.shim.celestialexploration.entity.entity.mob.Gust;
import com.shim.celestialexploration.registry.EntityRegistry;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerBossEvent;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.BossEvent;
import net.minecraft.world.Difficulty;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.monster.Enemy;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;

public class MechaCerberusBoss extends AbstractCerberus implements Enemy {
    private final ServerBossEvent bossEvent = (ServerBossEvent)(new ServerBossEvent(this.getDisplayName(), BossEvent.BossBarColor.RED, BossEvent.BossBarOverlay.PROGRESS)).setDarkenScreen(true);
    private static final int INVULNERABLE_TICKS = 100;
    private static final EntityDataAccessor<Integer> DATA_ID_INV = SynchedEntityData.defineId(MechaCerberusBoss.class, EntityDataSerializers.INT);
    int lightningAttackCooldown;
    int summonMinionsCooldown;
    final static int MAX_COOLDOWN = 100; //FIXME? random number
    boolean isCharging;
    int chargingTime;
    final static int MAX_CHARGE_TIME = 60; //FIXME
    boolean isCharged;
    boolean isStunned;

    public MechaCerberusBoss(EntityType<? extends MechaCerberusBoss> p_30369_, Level p_30370_) {
        super(p_30369_, p_30370_);
        this.setTame(false);
        this.isCharging = false;
        this.isCharged = false;
        this.isStunned = false;
        this.chargingTime = 0;
        this.summonMinionsCooldown = MAX_COOLDOWN;
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(1, new FloatGoal(this));
        this.goalSelector.addGoal(1, new CerberusPanicGoal(1.5D));
        this.goalSelector.addGoal(3, new CerberusAvoidEntityGoal<>(this, Gust.class, 24.0F, 1.5D, 1.5D));
        this.goalSelector.addGoal(4, new LeapAtTargetGoal(this, 0.4F));
//        this.goalSelector.addGoal(5, new MeleeAttackGoal(this, 1.0D, true));
        this.goalSelector.addGoal(8, new WaterAvoidingRandomStrollGoal(this, 1.0D));
        this.goalSelector.addGoal(10, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.goalSelector.addGoal(10, new RandomLookAroundGoal(this));

//        this.goalSelector.addGoal(5, new ChargeUpForAttackGoal(this));
//        this.goalSelector.addGoal(2, new CerberusLightningAOEAttackGoal(this));
//        this.goalSelector.addGoal(5, new CerberusMinorAttackGoal(this));
//        this.goalSelector.addGoal(1, new StunByAttackGoal(this));
//        this.goalSelector.addGoal(2, new IsStuckGoal(this));
        this.goalSelector.addGoal(2, new SummonMinionsGoal(this));


        this.targetSelector.addGoal(3, (new HurtByTargetGoal(this)).setAlertOthers());
        this.targetSelector.addGoal(4, new NearestAttackableTargetPeacefulGoal<>(this, Player.class, true, false));
//        this.targetSelector.addGoal(5, new NonTameCreatureRandomTargetGoal<>(this, Animal.class, false, PREY_SELECTOR));
//        this.targetSelector.addGoal(6, new NonTameCreatureRandomTargetGoal<>(this, Turtle.class, false, Turtle.BABY_ON_LAND_SELECTOR));

    }

    @Override
    public void tick() {
        super.tick();
        CelestialExploration.LOGGER.debug("bossProgress: " + this.bossEvent.getProgress() + ", minionCooldown: " + this.summonMinionsCooldown);
        if (this.bossEvent.getProgress() < 1.0F && this.bossEvent.getProgress() > 0) {
            this.summonMinionsCooldown--;
        }
    }

    public void makeInvulnerable() {
//        if (!this.isTame()) {
//            this.setInvulnerableTicks(INVULNERABLE_TICKS);
//            this.bossEvent.setProgress(0.0F);
//            this.setHealth(this.getMaxHealth() / 3.0F);
//        }
    }

    public void addAdditionalSaveData(CompoundTag p_31485_) {
        super.addAdditionalSaveData(p_31485_);
        p_31485_.putInt("Invul", this.getInvulnerableTicks());
    }

    public void readAdditionalSaveData(CompoundTag p_31474_) {
        super.readAdditionalSaveData(p_31474_);
        this.setInvulnerableTicks(p_31474_.getInt("Invul"));
        if (this.hasCustomName()) {
            if (!this.isTame())
                this.bossEvent.setName(this.getDisplayName());
        }

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

    @Override
    public boolean canBeLeashed(Player p_21813_) {
        return false;
    }

    @Override
    public void setTame(boolean p_30443_) {}

    public static AttributeSupplier.Builder createAttributes() {
        return Monster.createMonsterAttributes().add(Attributes.MAX_HEALTH, 250.0D).add(Attributes.MOVEMENT_SPEED, 0.6F).add(Attributes.FOLLOW_RANGE, 40.0D).add(Attributes.ARMOR, 4.0D);
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

        public ChargeUpForAttackGoal(MechaCerberusBoss mechaCerberus) {
            this.boss = mechaCerberus;
        }

        @Override
        public boolean canUse() {
            return this.boss.lightningAttackCooldown == 0 && this.boss.chargingTime <= MAX_CHARGE_TIME;
        }

        @Override
        public void start() {
            this.boss.isCharging = true;
        }

        @Override
        public void stop() {
            this.boss.isCharging = false;
            this.boss.chargingTime = 0;
        }

        @Override
        public boolean requiresUpdateEveryTick() {
            return true;
        }

        @Override
        public void tick() {
            this.boss.chargingTime++;
        }
    }

    public static class CerberusLightningAOEAttackGoal extends Goal {
        MechaCerberusBoss boss;

        public CerberusLightningAOEAttackGoal(MechaCerberusBoss mechaCerberus) {
            this.boss = mechaCerberus;
        }
        @Override
        public boolean canUse() {
            return this.boss.isCharged;
        }

        @Override
        public void stop() {
            this.boss.isCharged = false;
        }
    }

    public static class CerberusMinorAttackGoal extends MeleeAttackGoal {
        //TODO apply effect to player?
        public CerberusMinorAttackGoal(MechaCerberusBoss mechaCerberus) {
            super(mechaCerberus, 1.0D, true);
        }
    }

    public static class StunByAttackGoal extends Goal {
        MechaCerberusBoss boss;

        public StunByAttackGoal(MechaCerberusBoss mechaCerberus) {}

        @Override
        public boolean canUse() {
            return false;
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

    public static class SummonMinionsGoal extends Goal {
        MechaCerberusBoss boss;

        public SummonMinionsGoal(MechaCerberusBoss mechaCerberus) {
            this.boss = mechaCerberus;
        }

        @Override
        public boolean canUse() {
            return this.boss.summonMinionsCooldown == 0;
        }

        @Override
        public void start() {
            int numMinions = this.boss.random.nextInt(3) + 1;

            for (int i = 0; i <= numMinions; i++) {
                if (!this.boss.level.isClientSide()) {
                    ServerLevel serverLevel = (ServerLevel) this.boss.level;

                    MechaDog dog = EntityRegistry.MECHADOG.get().create(this.boss.level);
                    dog.moveTo(this.boss.blockPosition().west(i), 0, 0);

                    serverLevel.addFreshEntityWithPassengers(dog);
                }
            }
            this.boss.summonMinionsCooldown = MAX_COOLDOWN;
        }
    }
}
