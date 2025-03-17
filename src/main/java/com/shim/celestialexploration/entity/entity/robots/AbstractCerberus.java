package com.shim.celestialexploration.entity.entity.robots;

import com.shim.celestialexploration.entity.DyeType;
import com.shim.celestialexploration.entity.IDyeable;
import com.shim.celestialexploration.entity.model.CerberusPart;
import mod.azure.azurelib.animatable.GeoEntity;
import mod.azure.azurelib.core.animatable.instance.AnimatableInstanceCache;
import mod.azure.azurelib.core.animation.AnimatableManager;
import mod.azure.azurelib.core.animation.AnimationController;
import mod.azure.azurelib.core.animation.RawAnimation;
import mod.azure.azurelib.util.AzureLibUtil;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientboundAddMobPacket;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.AvoidEntityGoal;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.PanicGoal;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.horse.AbstractHorse;
import net.minecraft.world.entity.animal.horse.Llama;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.entity.monster.Ghast;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.entity.PartEntity;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.util.EnumSet;
import java.util.function.Predicate;

public abstract class AbstractCerberus extends TamableAnimal implements GeoEntity, IDyeable {
    private final AnimatableInstanceCache cache = AzureLibUtil.createInstanceCache(this);
    private static final EntityDataAccessor<Boolean> DATA_INTERESTED_ID = SynchedEntityData.defineId(AbstractCerberus.class, EntityDataSerializers.BOOLEAN);
    //    private static final EntityDataAccessor<Integer> DATA_COLLAR_COLOR = SynchedEntityData.defineId(MechaDog.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Integer> DATA_ID_TYPE = SynchedEntityData.defineId(AbstractCerberus.class, EntityDataSerializers.INT);
    //    private static final EntityDataAccessor<Integer> DATA_REMAINING_ANGER_TIME = SynchedEntityData.defineId(MechaDog.class, EntityDataSerializers.INT);
    public static final Predicate<LivingEntity> PREY_SELECTOR = (p_30437_) -> {
        EntityType<?> entitytype = p_30437_.getType();
        return entitytype == EntityType.SHEEP || entitytype == EntityType.RABBIT || entitytype == EntityType.FOX;
    };
    //    private static final float START_HEALTH = 8.0F;
//    private static final float TAME_HEALTH = 20.0F;
    private float interestedAngle;
    private float interestedAngleO;
    private boolean isWet;
    private boolean isShaking;
    private float shakeAnim;
    private float shakeAnimO;
    //    private static final UniformInt PERSISTENT_ANGER_TIME = TimeUtil.rangeOfSeconds(20, 39);
//    @Nullable
//    private UUID persistentAngerTarget;
    private final Item foodItem = Items.REDSTONE;
    private final CerberusPart[] cerberusParts;
    private final CerberusPart headCenter;
    private final CerberusPart headLeft;
    private final CerberusPart headRight;

    public AbstractCerberus(EntityType<? extends AbstractCerberus> p_30369_, Level p_30370_) {
        super(p_30369_, p_30370_);
        this.setTame(false);
        this.setPathfindingMalus(BlockPathTypes.POWDER_SNOW, -1.0F);
        this.setPathfindingMalus(BlockPathTypes.DANGER_POWDER_SNOW, -1.0F);
        this.headCenter = new CerberusPart(this, "headCenter", 2.5F, 1.5F, 2.5F, 2.0F, 0.0F, true);
        this.headLeft = new CerberusPart(this, "headLeft", 1.6F, 1.5F, 2.6F, 2.0F, 1.5F, true);
        this.headRight = new CerberusPart(this, "headRight", 1.6F, 1.5F, 2.6F, 2.0F, -1.5F, true);
        this.cerberusParts = new CerberusPart[]{this.headCenter
                , this.headLeft, this.headRight
        };
    }

    @Override
    public boolean isMultipartEntity() {
        return true;
    }

    @Override
    public @org.jetbrains.annotations.Nullable PartEntity<?>[] getParts() {

        return this.cerberusParts;
    }

    @Override
    public boolean canBreed() {
        return false;
    }

    @Override
    public boolean canMate(Animal p_27569_) {
        return false;
    }

    @Override
    public @org.jetbrains.annotations.Nullable AgeableMob getBreedOffspring(ServerLevel p_146743_, AgeableMob p_146744_) {
        return null;
    }

    @Override
    public boolean canFallInLove() {
        return false;
    }

    //    private static final RawAnimation wild_idle = RawAnimation.begin().thenLoop("idle_wild");
//    private static final RawAnimation wild_walk = RawAnimation.begin().thenLoop("walk_wild");
    private static final RawAnimation tamed_idle = RawAnimation.begin().thenLoop("idle");
    private static final RawAnimation tamed_walk = RawAnimation.begin().thenLoop("walk");
    private static final RawAnimation sit = RawAnimation.begin().thenLoop("sit");

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
        controllers.add(new AnimationController<>(this, "mechacerberus", 0, event -> {

                    boolean tamed = event.getAnimatable().isTame();
                    if (event.getAnimatable().isInSittingPose()) {
                        return event.setAndContinue(sit);
                    } else if (tamed && event.isMoving()) {
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
//            if (event.isMoving()) {
//                    return event.setAndContinue(flyingAnimation);
//                return event.setAndContinue(RawAnimation.begin().thenLoop("flying"));
//            } else {
//                return event.setAndContinue(idleAnimation);
//                return event.setAndContinue(RawAnimation.begin().thenPlay("idle"));
//            }
//                    return event.setAndContinue(
//                            // If moving, play the walking animation
//                            event.isMoving() ? walking :
//                                    // If not moving, play the idle animation
//                                    idle);
//                })
//                // Sets a Sound KeyFrame
//                .setSoundKeyframeHandler(event -> {
//                    //Plays the step sound on the walk keyframes in an animation
//                    if (event.getKeyframeData().getSound().matches("walk"))
//                        if (level().isClientSide())
//                            level().playLocalSound(
//                                    this.getX(), this.getY(), this.getZ(),
//                                    DoomSounds.PINKY_STEP,
//                                    SoundSource.HOSTILE, 0.25F, 1.0F, false);
//                })
        );
    }


    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }

//    public static AttributeSupplier.Builder createAttributes() {
//        return Mob.createMobAttributes().add(Attributes.MOVEMENT_SPEED, (double)0.3F).add(Attributes.MAX_HEALTH, 10.0D).add(Attributes.ATTACK_DAMAGE, 2.0D);
//    }

    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(DATA_INTERESTED_ID, false);
//        this.entityData.define(DATA_COLLAR_COLOR, DyeColor.RED.getId());
        this.entityData.define(DATA_ID_TYPE, DyeType.BLACK.ordinal());
//        this.entityData.define(DATA_REMAINING_ANGER_TIME, 0);
    }

    protected void playStepSound(BlockPos p_30415_, BlockState p_30416_) {
        this.playSound(SoundEvents.WOLF_STEP, 0.15F, 1.0F);
    }

    public void addAdditionalSaveData(CompoundTag tag) {
        super.addAdditionalSaveData(tag);
//        tag.putByte("CollarColor", (byte)this.getCollarColor().getId());
        tag.putString("Type", this.getDyeType().getName());
//        this.addPersistentAngerSaveData(tag);
    }

    public void readAdditionalSaveData(CompoundTag tag) {
        super.readAdditionalSaveData(tag);
//        if (tag.contains("CollarColor", 99)) {
//            this.setCollarColor(DyeColor.byId(tag.getInt("CollarColor")));
//        }
        if (tag.contains("Type", 8)) {
            this.setDyeType(DyeType.byName(tag.getString("Type")));
        }
//        this.readPersistentAngerSaveData(this.level, p_30402_);
    }

    public void setDyeType(DyeType p_38333_) {
        this.entityData.set(DATA_ID_TYPE, p_38333_.ordinal());
    }

    public DyeType getDyeType() {
        return DyeType.byId(this.entityData.get(DATA_ID_TYPE));
    }


    protected SoundEvent getAmbientSound() {
//        if (this.isAngry()) {
//            return SoundEvents.WOLF_GROWL;
//        } else
        if (this.random.nextInt(3) == 0) {
            return this.isTame() && this.getHealth() < 10.0F ? SoundEvents.WOLF_WHINE : SoundEvents.WOLF_PANT;
        } else {
            return SoundEvents.WOLF_AMBIENT;
        }
    }

    protected SoundEvent getHurtSound(DamageSource p_30424_) {
        return SoundEvents.WOLF_HURT;
    }

    protected SoundEvent getDeathSound() {
        return SoundEvents.WOLF_DEATH;
    }

    protected float getSoundVolume() {
        return 0.4F;
    }

    public void aiStep() {
        super.aiStep();
        if (!this.level.isClientSide && this.isWet && !this.isShaking && !this.isPathFinding() && this.onGround) {
            this.isShaking = true;
            this.shakeAnim = 0.0F;
            this.shakeAnimO = 0.0F;
            this.level.broadcastEntityEvent(this, (byte) 8);
        }

        for (CerberusPart cerberusPart : cerberusParts) {
            cerberusPart.updatePosition(cerberusPart.getDefaultXOffset(), cerberusPart.getDefaultYOffset(), cerberusPart.getDefaultZOffset());
        }

//        if (!this.level.isClientSide) {
//            this.updatePersistentAnger((ServerLevel)this.level, true);
//        }
    }


    /**
     * Mob packet handling.  This is necessary to set up hitboxes and multiparts.
     * In most cases you shouldn't have to call these for subclasses, they should be handled automatically here as long as you are extending ADragonBase
     */
    @Override
    public void recreateFromPacket(@NotNull ClientboundAddMobPacket mobPacketIn) {
        super.recreateFromPacket(mobPacketIn);
        PartEntity<?>[] part = this.getParts();
        for (int i = 0; i < part.length; ++i) part[i].setId(i + mobPacketIn.getId() + 1);
    }

    @Override
    public @NotNull Packet<?> getAddEntityPacket() {
        return new ClientboundAddMobPacket(this);
    }


    public void tick() {
        super.tick();
        if (this.isAlive()) {
            this.interestedAngleO = this.interestedAngle;
            if (this.isInterested()) {
                this.interestedAngle += (1.0F - this.interestedAngle) * 0.4F;
            } else {
                this.interestedAngle += (0.0F - this.interestedAngle) * 0.4F;
            }

            if (this.isInWaterRainOrBubble()) {
                this.isWet = true;
                if (this.isShaking && !this.level.isClientSide) {
                    this.level.broadcastEntityEvent(this, (byte) 56);
                    this.cancelShake();
                }
            } else if ((this.isWet || this.isShaking) && this.isShaking) {
                if (this.shakeAnim == 0.0F) {
                    this.playSound(SoundEvents.WOLF_SHAKE, this.getSoundVolume(), (this.random.nextFloat() - this.random.nextFloat()) * 0.2F + 1.0F);
                    this.gameEvent(GameEvent.WOLF_SHAKING);
                }

                this.shakeAnimO = this.shakeAnim;
                this.shakeAnim += 0.05F;
                if (this.shakeAnimO >= 2.0F) {
                    this.isWet = false;
                    this.isShaking = false;
                    this.shakeAnimO = 0.0F;
                    this.shakeAnim = 0.0F;
                }

                if (this.shakeAnim > 0.4F) {
                    float f = (float) this.getY();
                    int i = (int) (Mth.sin((this.shakeAnim - 0.4F) * (float) Math.PI) * 7.0F);
                    Vec3 vec3 = this.getDeltaMovement();

                    for (int j = 0; j < i; ++j) {
                        float f1 = (this.random.nextFloat() * 2.0F - 1.0F) * this.getBbWidth() * 0.5F;
                        float f2 = (this.random.nextFloat() * 2.0F - 1.0F) * this.getBbWidth() * 0.5F;
                        this.level.addParticle(ParticleTypes.SPLASH, this.getX() + (double) f1, (double) (f + 0.8F), this.getZ() + (double) f2, vec3.x, vec3.y, vec3.z);
                    }
                }
            }

        }
    }

    private void cancelShake() {
        this.isShaking = false;
        this.shakeAnim = 0.0F;
        this.shakeAnimO = 0.0F;
    }

    public void die(DamageSource p_30384_) {
        this.isWet = false;
        this.isShaking = false;
        this.shakeAnimO = 0.0F;
        this.shakeAnim = 0.0F;
        super.die(p_30384_);
    }

    public boolean isWet() {
        return this.isWet;
    }

    public float getWetShade(float p_30447_) {
        return Math.min(0.5F + Mth.lerp(p_30447_, this.shakeAnimO, this.shakeAnim) / 2.0F * 0.5F, 1.0F);
    }

    public float getBodyRollAngle(float p_30433_, float p_30434_) {
        float f = (Mth.lerp(p_30433_, this.shakeAnimO, this.shakeAnim) + p_30434_) / 1.8F;
        if (f < 0.0F) {
            f = 0.0F;
        } else if (f > 1.0F) {
            f = 1.0F;
        }

        return Mth.sin(f * (float) Math.PI) * Mth.sin(f * (float) Math.PI * 11.0F) * 0.15F * (float) Math.PI;
    }

    public float getHeadRollAngle(float p_30449_) {
        return Mth.lerp(p_30449_, this.interestedAngleO, this.interestedAngle) * 0.15F * (float) Math.PI;
    }

    protected float getStandingEyeHeight(Pose p_30409_, EntityDimensions p_30410_) {
        return p_30410_.height * 0.8F;
    }

    public int getMaxHeadXRot() {
        return this.isInSittingPose() ? 20 : super.getMaxHeadXRot();
    }

    public boolean hurt(DamageSource p_30386_, float p_30387_) {
        if (this.isInvulnerableTo(p_30386_)) {
            return false;
        } else {
            Entity entity = p_30386_.getEntity();
            if (!this.level.isClientSide) {
                this.setOrderedToSit(false);
            }

            if (entity != null && !(entity instanceof Player) && !(entity instanceof AbstractArrow)) {
                p_30387_ = (p_30387_ + 1.0F) / 2.0F;
            }

            return super.hurt(p_30386_, p_30387_);
        }
    }

//    public boolean doHurtTarget(Entity p_30372_) {
//        boolean flag = p_30372_.hurt(DamageSource.mobAttack(this), (float) ((int) this.getAttributeValue(Attributes.ATTACK_DAMAGE)));
//        if (flag) {
//            this.doEnchantDamageEffects(this, p_30372_);
//        }
//
//        return flag;
//    }

    public void setTame(boolean p_30443_) {
        super.setTame(p_30443_);
        if (p_30443_) {
            this.getAttribute(Attributes.MAX_HEALTH).setBaseValue(20.0D);
            this.setHealth(20.0F);
        } else {
            this.getAttribute(Attributes.MAX_HEALTH).setBaseValue(8.0D);
        }
        this.getAttribute(Attributes.ATTACK_DAMAGE).setBaseValue(4.0D);
    }

    public void handleEntityEvent(byte p_30379_) {
        if (p_30379_ == 8) {
            this.isShaking = true;
            this.shakeAnim = 0.0F;
            this.shakeAnimO = 0.0F;
        } else if (p_30379_ == 56) {
            this.cancelShake();
        } else {
            super.handleEntityEvent(p_30379_);
        }
    }

    public float getTailAngle() {
//        if (this.isAngry()) {
//            return 1.5393804F;
//        } else {
        return this.isTame() ? (0.55F - (this.getMaxHealth() - this.getHealth()) * 0.02F) * (float) Math.PI : ((float) Math.PI / 5F);
//        }
    }

    public boolean isFood(ItemStack p_30440_) {
//        Item item = p_30440_.getItem();
        return p_30440_.is(foodItem);
//        return item.isEdible() && p_30440_.getFoodProperties(this).isMeat();
    }

    public int getMaxSpawnClusterSize() {
        return 8;
    }

//    public int getRemainingPersistentAngerTime() {
//        return this.entityData.get(DATA_REMAINING_ANGER_TIME);
//    }
//
//    public void setRemainingPersistentAngerTime(int p_30404_) {
//        this.entityData.set(DATA_REMAINING_ANGER_TIME, p_30404_);
//    }
//
//    public void startPersistentAngerTimer() {
//        this.setRemainingPersistentAngerTime(PERSISTENT_ANGER_TIME.sample(this.random));
//    }

//    @Nullable
//    public UUID getPersistentAngerTarget() {
//        return this.persistentAngerTarget;
//    }
//
//    public void setPersistentAngerTarget(@Nullable UUID p_30400_) {
//        this.persistentAngerTarget = p_30400_;
//    }

//    public DyeColor getCollarColor() {
//        return DyeColor.byId(this.entityData.get(DATA_COLLAR_COLOR));
//    }
//
//    public void setCollarColor(DyeColor p_30398_) {
//        this.entityData.set(DATA_COLLAR_COLOR, p_30398_.getId());
//    }

    public void setIsInterested(boolean p_30445_) {
        this.entityData.set(DATA_INTERESTED_ID, p_30445_);
    }

    public boolean isInterested() {
        return this.entityData.get(DATA_INTERESTED_ID);
    }

    public boolean wantsToAttack(LivingEntity p_30389_, LivingEntity p_30390_) {
        if (!(p_30389_ instanceof Creeper) && !(p_30389_ instanceof Ghast)) {
            if (p_30389_ instanceof MechaDog mechadog) {
                return !mechadog.isTame() || mechadog.getOwner() != p_30390_;
            } else if (p_30389_ instanceof Player && p_30390_ instanceof Player && !((Player) p_30390_).canHarmPlayer((Player) p_30389_)) {
                return false;
            } else if (p_30389_ instanceof AbstractHorse && ((AbstractHorse) p_30389_).isTamed()) {
                return false;
            } else {
                return !(p_30389_ instanceof TamableAnimal) || !((TamableAnimal) p_30389_).isTame();
            }
        } else {
            return false;
        }
    }

//    public boolean canBeLeashed(Player p_30396_) {
//        return !this.isAngry() && super.canBeLeashed(p_30396_);
//    }

    public Vec3 getLeashOffset() {
        return new Vec3(0.0D, (double) (0.6F * this.getEyeHeight()), (double) (this.getBbWidth() * 0.4F));
    }

//    public static boolean checkMechaDogSpawnRules(EntityType<MechaDog> p_186244_, LevelAccessor p_186245_, MobSpawnType p_186246_, BlockPos p_186247_, Random p_186248_) {
//        return p_186245_.getBlockState(p_186247_.below()).is(BlockTags.WOLVES_SPAWNABLE_ON) && isBrightEnoughToSpawn(p_186245_, p_186247_);
//    }

    class CerberusAvoidEntityGoal<T extends LivingEntity> extends AvoidEntityGoal<T> {
        private final AbstractCerberus mechadog;

        public CerberusAvoidEntityGoal(AbstractCerberus p_30454_, Class<T> p_30455_, float p_30456_, double p_30457_, double p_30458_) {
            super(p_30454_, p_30455_, p_30456_, p_30457_, p_30458_);
            this.mechadog = p_30454_;
        }

        public boolean canUse() {
            if (super.canUse() && this.toAvoid instanceof Llama) {
                return !this.mechadog.isTame() && this.avoidLlama((Llama) this.toAvoid);
            } else {
                return false;
            }
        }

        private boolean avoidLlama(Llama p_30461_) {
            return p_30461_.getStrength() >= AbstractCerberus.this.random.nextInt(5);
        }

        public void start() {
            AbstractCerberus.this.setTarget((LivingEntity) null);
            super.start();
        }

        public void tick() {
            AbstractCerberus.this.setTarget((LivingEntity) null);
            super.tick();
        }
    }

    class CerberusPanicGoal extends PanicGoal {
        public CerberusPanicGoal(double p_203124_) {
            super(AbstractCerberus.this, p_203124_);
        }

        protected boolean shouldPanic() {
            return this.mob.isFreezing() || this.mob.isOnFire();
        }
    }

    class BegGoal extends Goal {
        private final AbstractCerberus mechadog;
        @Nullable
        private Player player;
        private final Level level;
        private final float lookDistance;
        private int lookTime;
        private final TargetingConditions begTargeting;

        public BegGoal(AbstractCerberus p_25063_, float p_25064_) {
            this.mechadog = p_25063_;
            this.level = p_25063_.level;
            this.lookDistance = p_25064_;
            this.begTargeting = TargetingConditions.forNonCombat().range((double) p_25064_);
            this.setFlags(EnumSet.of(Goal.Flag.LOOK));
        }

        public boolean canUse() {
            this.player = this.level.getNearestPlayer(this.begTargeting, this.mechadog);
            return this.player != null && this.playerHoldingInteresting(this.player);
        }

        public boolean canContinueToUse() {
            if (!this.player.isAlive()) {
                return false;
            } else if (this.mechadog.distanceToSqr(this.player) > (double) (this.lookDistance * this.lookDistance)) {
                return false;
            } else {
                return this.lookTime > 0 && this.playerHoldingInteresting(this.player);
            }
        }

        public void start() {
            this.mechadog.setIsInterested(true);
            this.lookTime = this.adjustedTickDelay(40 + this.mechadog.getRandom().nextInt(40));
        }

        public void stop() {
            this.mechadog.setIsInterested(false);
            this.player = null;
        }

        public void tick() {
            this.mechadog.getLookControl().setLookAt(this.player.getX(), this.player.getEyeY(), this.player.getZ(), 10.0F, (float) this.mechadog.getMaxHeadXRot());
            --this.lookTime;
        }

        private boolean playerHoldingInteresting(Player p_25067_) {
            for (InteractionHand interactionhand : InteractionHand.values()) {
                ItemStack itemstack = p_25067_.getItemInHand(interactionhand);
                if (this.mechadog.isTame() && itemstack.is(this.mechadog.foodItem)) {
                    return true;
                }

                if (this.mechadog.isFood(itemstack)) {
                    return true;
                }
            }

            return false;
        }
    }
}
