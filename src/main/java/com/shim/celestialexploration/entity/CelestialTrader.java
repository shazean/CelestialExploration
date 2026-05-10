//package com.shim.celestialexploration.entity;
//
//import com.shim.celestialexploration.entity.mob.Voided;
//import com.shim.celestialexploration.events.CelestialVillagerTrades;
//import net.minecraft.core.BlockPos;
//import net.minecraft.nbt.CompoundTag;
//import net.minecraft.nbt.NbtUtils;
//import net.minecraft.server.level.ServerLevel;
//import net.minecraft.sounds.SoundEvent;
//import net.minecraft.sounds.SoundEvents;
//import net.minecraft.stats.Stats;
//import net.minecraft.world.InteractionHand;
//import net.minecraft.world.InteractionResult;
//import net.minecraft.world.damagesource.DamageSource;
//import net.minecraft.world.entity.AgeableMob;
//import net.minecraft.world.entity.EntityType;
//import net.minecraft.world.entity.ExperienceOrb;
//import net.minecraft.world.entity.Mob;
//import net.minecraft.world.entity.ai.goal.*;
//import net.minecraft.world.entity.monster.*;
//import net.minecraft.world.entity.npc.AbstractVillager;
//import net.minecraft.world.entity.npc.VillagerTrades;
//import net.minecraft.world.entity.player.Player;
//import net.minecraft.world.item.ItemStack;
//import net.minecraft.world.item.Items;
//import net.minecraft.world.item.alchemy.PotionUtils;
//import net.minecraft.world.item.alchemy.Potions;
//import net.minecraft.world.item.trading.MerchantOffer;
//import net.minecraft.world.item.trading.MerchantOffers;
//import net.minecraft.world.level.Level;
//import net.minecraft.world.phys.Vec3;
//
//import javax.annotation.Nullable;
//import java.util.EnumSet;
//
//public class CelestialTrader extends AbstractVillager {
//    private static final int NUMBER_OF_TRADE_OFFERS = 5;
//    @Nullable
//    private BlockPos wanderTarget;
//    private int despawnDelay;
//
//    public CelestialTrader(EntityType<? extends CelestialTrader> p_35843_, Level p_35844_) {
//        super(p_35843_, p_35844_);
//    }
//
//
//    protected void registerGoals() {
//        this.goalSelector.addGoal(0, new FloatGoal(this));
//        this.goalSelector.addGoal(0, new UseItemGoal<>(this, PotionUtils.setPotion(new ItemStack(Items.POTION), Potions.INVISIBILITY), SoundEvents.WANDERING_TRADER_DISAPPEARED, (p_35882_) -> {
//            return this.level.isNight() && !p_35882_.isInvisible();
//        }));
//        this.goalSelector.addGoal(0, new UseItemGoal<>(this, new ItemStack(Items.MILK_BUCKET), SoundEvents.WANDERING_TRADER_REAPPEARED, (p_35880_) -> {
//            return this.level.isDay() && p_35880_.isInvisible();
//        }));
//        this.goalSelector.addGoal(1, new TradeWithPlayerGoal(this));
//        this.goalSelector.addGoal(1, new AvoidEntityGoal<>(this, Zombie.class, 8.0F, 0.5D, 0.5D));
//        this.goalSelector.addGoal(1, new AvoidEntityGoal<>(this, Evoker.class, 12.0F, 0.5D, 0.5D));
//        this.goalSelector.addGoal(1, new AvoidEntityGoal<>(this, Vindicator.class, 8.0F, 0.5D, 0.5D));
//        this.goalSelector.addGoal(1, new AvoidEntityGoal<>(this, Vex.class, 8.0F, 0.5D, 0.5D));
//        this.goalSelector.addGoal(1, new AvoidEntityGoal<>(this, Pillager.class, 15.0F, 0.5D, 0.5D));
//        this.goalSelector.addGoal(1, new AvoidEntityGoal<>(this, Illusioner.class, 12.0F, 0.5D, 0.5D));
//        this.goalSelector.addGoal(1, new AvoidEntityGoal<>(this, Zoglin.class, 10.0F, 0.5D, 0.5D));
//        this.goalSelector.addGoal(1, new AvoidEntityGoal<>(this, Voided.class, 8.0F, 0.5D, 0.5D));
//        this.goalSelector.addGoal(1, new PanicGoal(this, 0.5D));
//        this.goalSelector.addGoal(1, new LookAtTradingPlayerGoal(this));
//        this.goalSelector.addGoal(2, new CelestialTrader.WanderToPositionGoal(this, 2.0D, 0.35D));
//        this.goalSelector.addGoal(4, new MoveTowardsRestrictionGoal(this, 0.35D));
//        this.goalSelector.addGoal(8, new WaterAvoidingRandomStrollGoal(this, 0.35D));
//        this.goalSelector.addGoal(9, new InteractGoal(this, Player.class, 3.0F, 1.0F));
//        this.goalSelector.addGoal(10, new LookAtPlayerGoal(this, Mob.class, 8.0F));
//    }
//
//    @Nullable
//    public AgeableMob getBreedOffspring(ServerLevel p_150046_, AgeableMob p_150047_) {
//        return null;
//    }
//
//    public boolean showProgressBar() {
//        return false;
//    }
//
//    public InteractionResult mobInteract(Player p_35856_, InteractionHand p_35857_) {
//        ItemStack itemstack = p_35856_.getItemInHand(p_35857_);
//        if (!itemstack.is(Items.VILLAGER_SPAWN_EGG) && this.isAlive() && !this.isTrading() && !this.isBaby()) {
//            if (p_35857_ == InteractionHand.MAIN_HAND) {
//                p_35856_.awardStat(Stats.TALKED_TO_VILLAGER);
//            }
//
//            if (this.getOffers().isEmpty()) {
//                return InteractionResult.sidedSuccess(this.level.isClientSide);
//            } else {
//                if (!this.level.isClientSide) {
//                    this.setTradingPlayer(p_35856_);
//                    this.openTradingScreen(p_35856_, this.getDisplayName(), 1);
//                }
//
//                return InteractionResult.sidedSuccess(this.level.isClientSide);
//            }
//        } else {
//            return super.mobInteract(p_35856_, p_35857_);
//        }
//    }
//
//    protected void updateTrades() {
////        VillagerTrades.ItemListing[] listing1 = CelestialVillagerTrades.CELESTIAL_TRADER_TRADES.get(1);
////        VillagerTrades.ItemListing[] listing2 = CelestialVillagerTrades.CELESTIAL_TRADER_TRADES.get(2);
////        if (listing1 != null && listing2 != null) {
////            MerchantOffers merchantoffers = this.getOffers();
////            this.addOffersFromItemListings(merchantoffers, listing1, NUMBER_OF_TRADE_OFFERS);
////            int i = this.random.nextInt(listing2.length);
////            VillagerTrades.ItemListing villagertrades$itemlisting = listing2[i];
////            MerchantOffer merchantoffer = villagertrades$itemlisting.getOffer(this, this.random);
////            if (merchantoffer != null) {
////                merchantoffers.add(merchantoffer);
////            }
////
////        }
//    }
//
//    public void addAdditionalSaveData(CompoundTag p_35861_) {
//        super.addAdditionalSaveData(p_35861_);
//        p_35861_.putInt("DespawnDelay", this.despawnDelay);
//        if (this.wanderTarget != null) {
//            p_35861_.put("WanderTarget", NbtUtils.writeBlockPos(this.wanderTarget));
//        }
//
//    }
//
//    public void readAdditionalSaveData(CompoundTag p_35852_) {
//        super.readAdditionalSaveData(p_35852_);
//        if (p_35852_.contains("DespawnDelay", 99)) {
//            this.despawnDelay = p_35852_.getInt("DespawnDelay");
//        }
//
//        if (p_35852_.contains("WanderTarget")) {
//            this.wanderTarget = NbtUtils.readBlockPos(p_35852_.getCompound("WanderTarget"));
//        }
//
//        this.setAge(Math.max(0, this.getAge()));
//    }
//
//    public boolean removeWhenFarAway(double p_35886_) {
//        return false;
//    }
//
//    protected void rewardTradeXp(MerchantOffer p_35859_) {
//        if (p_35859_.shouldRewardExp()) {
//            int i = 3 + this.random.nextInt(4);
//            this.level.addFreshEntity(new ExperienceOrb(this.level, this.getX(), this.getY() + 0.5D, this.getZ(), i));
//        }
//
//    }
//
//    protected SoundEvent getAmbientSound() {
//        return this.isTrading() ? SoundEvents.WANDERING_TRADER_TRADE : SoundEvents.WANDERING_TRADER_AMBIENT;
//    }
//
//    protected SoundEvent getHurtSound(DamageSource source) {
//        return SoundEvents.WANDERING_TRADER_HURT;
//    }
//
//    protected SoundEvent getDeathSound() {
//        return SoundEvents.WANDERING_TRADER_DEATH;
//    }
//
//    protected SoundEvent getDrinkingSound(ItemStack itemStack) {
//        return itemStack.is(Items.MILK_BUCKET) ? SoundEvents.WANDERING_TRADER_DRINK_MILK : SoundEvents.WANDERING_TRADER_DRINK_POTION;
//    }
//
//    protected SoundEvent getTradeUpdatedSound(boolean wasSuccessful) {
//        return wasSuccessful ? SoundEvents.WANDERING_TRADER_YES : SoundEvents.WANDERING_TRADER_NO;
//    }
//
//    public SoundEvent getNotifyTradeSound() {
//        return SoundEvents.WANDERING_TRADER_YES;
//    }
//
//    public void setDespawnDelay(int p_35892_) {
//        this.despawnDelay = p_35892_;
//    }
//
//    public int getDespawnDelay() {
//        return this.despawnDelay;
//    }
//
//    public void aiStep() {
//        super.aiStep();
//        if (!this.level.isClientSide) {
//            this.maybeDespawn();
//        }
//    }
//
//    private void maybeDespawn() {
//        if (this.despawnDelay > 0 && !this.isTrading() && --this.despawnDelay == 0) {
//            this.discard();
//        }
//    }
//
//    public void setWanderTarget(@Nullable BlockPos p_35884_) {
//        this.wanderTarget = p_35884_;
//    }
//
//    @Nullable
//    BlockPos getWanderTarget() {
//        return this.wanderTarget;
//    }
//
//    class WanderToPositionGoal extends Goal {
//        final CelestialTrader trader;
//        final double stopDistance;
//        final double speedModifier;
//
//        WanderToPositionGoal(CelestialTrader trader, double stopDistance, double speedModifier) {
//            this.trader = trader;
//            this.stopDistance = stopDistance;
//            this.speedModifier = speedModifier;
//            this.setFlags(EnumSet.of(Goal.Flag.MOVE));
//        }
//
//        public void stop() {
//            this.trader.setWanderTarget(null);
//            CelestialTrader.this.navigation.stop();
//        }
//
//        public boolean canUse() {
//            BlockPos pos = this.trader.getWanderTarget();
//            return pos != null && this.isTooFarAway(pos, this.stopDistance);
//        }
//
//        public void tick() {
//            BlockPos pos = this.trader.getWanderTarget();
//            if (pos != null && CelestialTrader.this.navigation.isDone()) {
//                if (this.isTooFarAway(pos, 10.0D)) {
//                    Vec3 vec3 = (new Vec3((double)pos.getX() - this.trader.getX(), (double)pos.getY() - this.trader.getY(), (double)pos.getZ() - this.trader.getZ())).normalize();
//                    Vec3 vec31 = vec3.scale(10.0D).add(this.trader.getX(), this.trader.getY(), this.trader.getZ());
//                    CelestialTrader.this.navigation.moveTo(vec31.x, vec31.y, vec31.z, this.speedModifier);
//                } else {
//                    CelestialTrader.this.navigation.moveTo(pos.getX(), pos.getY(), pos.getZ(), this.speedModifier);
//                }
//            }
//        }
//
//        private boolean isTooFarAway(BlockPos pos, double p_35905_) {
//            return !pos.closerToCenterThan(this.trader.position(), p_35905_);
//        }
//    }
//}