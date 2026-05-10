//package com.shim.celestialexploration.entity.creatures;
//
//import com.shim.celestialexploration.registry.CelestialEntities;
//import net.minecraft.nbt.CompoundTag;
//import net.minecraft.world.DifficultyInstance;
//import net.minecraft.world.entity.*;
//import net.minecraft.world.entity.ai.goal.Goal;
//import net.minecraft.world.entity.ai.goal.PanicGoal;
//import net.minecraft.world.entity.ai.goal.target.TargetGoal;
//import net.minecraft.world.entity.ai.targeting.TargetingConditions;
//import net.minecraft.world.entity.animal.horse.Llama;
//import net.minecraft.world.entity.player.Player;
//import net.minecraft.world.level.Level;
//import net.minecraft.world.level.ServerLevelAccessor;
//
//import javax.annotation.Nullable;
//import java.util.EnumSet;
//
//public abstract class AbstractSpaceTraderLlama extends Llama {
//    private int despawnDelay = 47999;
//
//    public AbstractSpaceTraderLlama(EntityType<? extends AbstractSpaceTraderLlama> p_30939_, Level p_30940_) {
//        super(p_30939_, p_30940_);
//    }
//
//    public boolean isTraderLlama() {
//        return true;
//    }
//
//    protected abstract Llama makeBabyLlama();
//
//    public void addAdditionalSaveData(CompoundTag p_30950_) {
//        super.addAdditionalSaveData(p_30950_);
//        p_30950_.putInt("DespawnDelay", this.despawnDelay);
//    }
//
//    public void readAdditionalSaveData(CompoundTag p_30948_) {
//        super.readAdditionalSaveData(p_30948_);
//        if (p_30948_.contains("DespawnDelay", 99)) {
//            this.despawnDelay = p_30948_.getInt("DespawnDelay");
//        }
//
//    }
//
//    protected void registerGoals() {
//        super.registerGoals();
//        this.goalSelector.addGoal(1, new PanicGoal(this, 2.0D));
//        this.targetSelector.addGoal(1, new SpaceTraderLlama.TraderLlamaDefendWanderingTraderGoal(this));
//    }
//
//    public void setDespawnDelay(int p_149556_) {
//        this.despawnDelay = p_149556_;
//    }
//
//    protected void doPlayerRide(Player p_30958_) {
//        Entity entity = this.getLeashHolder();
////        if (!(entity instanceof CelestialTrader)) {
//            super.doPlayerRide(p_30958_);
////        }
//    }
//
//    public void aiStep() {
//        super.aiStep();
//        if (!this.level.isClientSide) {
//            this.maybeDespawn();
//        }
//
//    }
//
//    private void maybeDespawn() {
//        if (this.canDespawn()) {
////            this.despawnDelay = this.isLeashedToWanderingTrader() ? ((CelestialTrader)this.getLeashHolder()).getDespawnDelay() - 1 : this.despawnDelay - 1;
////            if (this.despawnDelay <= 0) {
//                this.dropLeash(true, false);
//                this.discard();
////            }
//
//        }
//    }
//
//    private boolean canDespawn() {
//        return !this.isTamed() && !this.isLeashedToSomethingOtherThanTheWanderingTrader() && !this.hasExactlyOnePlayerPassenger();
//    }
//
//    private boolean isLeashedToWanderingTrader() {
//        return false;
////        return this.getLeashHolder() instanceof CelestialTrader;
//    }
//
//    private boolean isLeashedToSomethingOtherThanTheWanderingTrader() {
//        return this.isLeashed() && !this.isLeashedToWanderingTrader();
//    }
//
//    @Nullable
//    public SpawnGroupData finalizeSpawn(ServerLevelAccessor p_30942_, DifficultyInstance p_30943_, MobSpawnType p_30944_, @Nullable SpawnGroupData p_30945_, @Nullable CompoundTag p_30946_) {
//        if (p_30944_ == MobSpawnType.EVENT) {
//            this.setAge(0);
//        }
//
//        if (p_30945_ == null) {
//            p_30945_ = new AgeableMob.AgeableMobGroupData(false);
//        }
//
//        return super.finalizeSpawn(p_30942_, p_30943_, p_30944_, p_30945_, p_30946_);
//    }
//
//    protected static class TraderLlamaDefendWanderingTraderGoal extends TargetGoal {
//        private final Llama llama;
//        private LivingEntity ownerLastHurtBy;
//        private int timestamp;
//
//        public TraderLlamaDefendWanderingTraderGoal(Llama p_149558_) {
//            super(p_149558_, false);
//            this.llama = p_149558_;
//            this.setFlags(EnumSet.of(Goal.Flag.TARGET));
//        }
//
//        public boolean canUse() {
//            if (!this.llama.isLeashed()) {
//                return false;
//            } else {
//                return true;
////                Entity entity = this.llama.getLeashHolder();
////                if (!(entity instanceof CelestialTrader)) {
////                    return false;
////                } else {
////                    CelestialTrader wanderingtrader = (CelestialTrader)entity;
////                    this.ownerLastHurtBy = wanderingtrader.getLastHurtByMob();
////                    int i = wanderingtrader.getLastHurtByMobTimestamp();
////                    return i != this.timestamp && this.canAttack(this.ownerLastHurtBy, TargetingConditions.DEFAULT);
////                }
//            }
//        }
//
//        public void start() {
//            this.mob.setTarget(this.ownerLastHurtBy);
//            Entity entity = this.llama.getLeashHolder();
////            if (entity instanceof CelestialTrader) {
////                this.timestamp = ((CelestialTrader)entity).getLastHurtByMobTimestamp();
////            }
//
//            super.start();
//        }
//    }
//}