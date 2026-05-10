//package com.shim.celestialexploration.entity.creatures;
//
//import com.google.common.collect.ImmutableList;
//import com.google.common.collect.Maps;
//import com.mojang.logging.LogUtils;
//import com.mojang.math.Vector3f;
//import com.mojang.serialization.Dynamic;
//import com.shim.celestialexploration.registry.CelestialEntities;
//import net.minecraft.Util;
//import net.minecraft.core.BlockPos;
//import net.minecraft.nbt.CompoundTag;
//import net.minecraft.network.protocol.game.DebugPackets;
//import net.minecraft.network.syncher.EntityDataAccessor;
//import net.minecraft.network.syncher.EntityDataSerializers;
//import net.minecraft.network.syncher.SynchedEntityData;
//import net.minecraft.server.level.ServerLevel;
//import net.minecraft.sounds.SoundEvent;
//import net.minecraft.sounds.SoundEvents;
//import net.minecraft.tags.ItemTags;
//import net.minecraft.world.DifficultyInstance;
//import net.minecraft.world.InteractionHand;
//import net.minecraft.world.InteractionResult;
//import net.minecraft.world.damagesource.DamageSource;
//import net.minecraft.world.effect.MobEffectInstance;
//import net.minecraft.world.effect.MobEffects;
//import net.minecraft.world.entity.*;
//import net.minecraft.world.entity.ai.Brain;
//import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
//import net.minecraft.world.entity.ai.attributes.Attributes;
//import net.minecraft.world.entity.ai.control.FlyingMoveControl;
//import net.minecraft.world.entity.ai.control.LookControl;
//import net.minecraft.world.entity.ai.memory.MemoryModuleType;
//import net.minecraft.world.entity.ai.navigation.FlyingPathNavigation;
//import net.minecraft.world.entity.ai.navigation.PathNavigation;
//import net.minecraft.world.entity.ai.navigation.WaterBoundPathNavigation;
//import net.minecraft.world.entity.ai.sensing.Sensor;
//import net.minecraft.world.entity.ai.sensing.SensorType;
//import net.minecraft.world.entity.animal.Animal;
//import net.minecraft.world.entity.animal.Bucketable;
//import net.minecraft.world.entity.player.Player;
//import net.minecraft.world.item.ItemStack;
//import net.minecraft.world.item.Items;
//import net.minecraft.world.level.Level;
//import net.minecraft.world.level.LevelReader;
//import net.minecraft.world.level.ServerLevelAccessor;
//import net.minecraft.world.level.pathfinder.AmphibiousNodeEvaluator;
//import net.minecraft.world.level.pathfinder.BlockPathTypes;
//import net.minecraft.world.level.pathfinder.PathFinder;
//import net.minecraft.world.phys.Vec3;
//import org.slf4j.Logger;
//
//import javax.annotation.Nullable;
//import java.util.*;
//
//public class CelestialAxolotl extends Animal implements LerpingModel, Bucketable {
//    private static final Logger LOGGER = LogUtils.getLogger();
//    public static final int TOTAL_PLAYDEAD_TIME = 200;
//    protected static final ImmutableList<? extends SensorType<? extends Sensor<? super CelestialAxolotl>>> SENSOR_TYPES = ImmutableList.of(SensorType.NEAREST_LIVING_ENTITIES, SensorType.NEAREST_ADULT, SensorType.HURT_BY, SensorType.AXOLOTL_ATTACKABLES, SensorType.AXOLOTL_TEMPTATIONS);
//    protected static final ImmutableList<? extends MemoryModuleType<?>> MEMORY_TYPES = ImmutableList.of(MemoryModuleType.BREED_TARGET, MemoryModuleType.NEAREST_LIVING_ENTITIES, MemoryModuleType.NEAREST_VISIBLE_LIVING_ENTITIES, MemoryModuleType.NEAREST_VISIBLE_PLAYER, MemoryModuleType.NEAREST_VISIBLE_ATTACKABLE_PLAYER, MemoryModuleType.LOOK_TARGET, MemoryModuleType.WALK_TARGET, MemoryModuleType.CANT_REACH_WALK_TARGET_SINCE, MemoryModuleType.PATH, MemoryModuleType.ATTACK_TARGET, MemoryModuleType.ATTACK_COOLING_DOWN, MemoryModuleType.NEAREST_VISIBLE_ADULT, MemoryModuleType.HURT_BY_ENTITY, MemoryModuleType.PLAY_DEAD_TICKS, MemoryModuleType.NEAREST_ATTACKABLE, MemoryModuleType.TEMPTING_PLAYER, MemoryModuleType.TEMPTATION_COOLDOWN_TICKS, MemoryModuleType.IS_TEMPTED, MemoryModuleType.HAS_HUNTING_COOLDOWN);
//    private static final EntityDataAccessor<Integer> DATA_VARIANT = SynchedEntityData.defineId(CelestialAxolotl.class, EntityDataSerializers.INT);
//    private static final EntityDataAccessor<Boolean> DATA_PLAYING_DEAD = SynchedEntityData.defineId(CelestialAxolotl.class, EntityDataSerializers.BOOLEAN);
//    private static final EntityDataAccessor<Boolean> FROM_BUCKET = SynchedEntityData.defineId(CelestialAxolotl.class, EntityDataSerializers.BOOLEAN);
//    public static final double PLAYER_REGEN_DETECTION_RANGE = 20.0D;
//    public static final int RARE_VARIANT_CHANCE = 1200;
//    private static final int REGEN_BUFF_MAX_DURATION = 2400;
//    private final Map<String, Vector3f> modelRotationValues = Maps.newHashMap();
//    private static final int REGEN_BUFF_BASE_DURATION = 100;
//
//    public CelestialAxolotl(EntityType<? extends CelestialAxolotl> axolotl, Level level) {
//        super(axolotl, level);
////        this.setPathfindingMalus(BlockPathTypes.WATER, 0.0F);
//        this.moveControl = new CelestialAxolotl.AxolotlMoveControl(this);
//        this.lookControl = new CelestialAxolotl.AxolotlLookControl(this); //, 20);
//        this.maxUpStep = 1.0F;
//        this.setNoGravity(true);
//    }
//
//    public Map<String, Vector3f> getModelRotationValues() {
//        return this.modelRotationValues;
//    }
//
//    public float getWalkTargetValue(BlockPos pos, LevelReader level) {
//        return 0.0F;
//    }
//
//    protected void defineSynchedData() {
//        super.defineSynchedData();
//        this.entityData.define(DATA_VARIANT, 0);
//        this.entityData.define(DATA_PLAYING_DEAD, false);
//        this.entityData.define(FROM_BUCKET, false);
//    }
//
//    public void addAdditionalSaveData(CompoundTag nbt) {
//        super.addAdditionalSaveData(nbt);
//        nbt.putInt("Variant", this.getVariant().getId());
//        nbt.putBoolean("FromBucket", this.fromBucket());
//    }
//
//    public void readAdditionalSaveData(CompoundTag nbt) {
//        super.readAdditionalSaveData(nbt);
//        this.setVariant(CelestialAxolotl.Variant.BY_ID[nbt.getInt("Variant")]);
//        this.setFromBucket(nbt.getBoolean("FromBucket"));
//    }
//
//    public void playAmbientSound() {
//        if (!this.isPlayingDead()) {
//            super.playAmbientSound();
//        }
//    }
//
//    public SpawnGroupData finalizeSpawn(ServerLevelAccessor level, DifficultyInstance difficultyInstance, MobSpawnType spawnType, @Nullable SpawnGroupData spawnData, @Nullable CompoundTag nbt) {
//        boolean flag = false;
//        if (spawnType == MobSpawnType.BUCKET) {
//            return spawnData;
//        } else {
//            if (spawnData instanceof CelestialAxolotl.AxolotlGroupData) {
//                if (((CelestialAxolotl.AxolotlGroupData)spawnData).getGroupSize() >= 2) {
//                    flag = true;
//                }
//            } else {
//                spawnData = new CelestialAxolotl.AxolotlGroupData(CelestialAxolotl.Variant.getCommonSpawnVariant(this.level.random), CelestialAxolotl.Variant.getCommonSpawnVariant(this.level.random));
//            }
//
//            this.setVariant(((CelestialAxolotl.AxolotlGroupData)spawnData).getVariant(this.level.random));
//            if (flag) {
//                this.setAge(-24000);
//            }
//
//            return super.finalizeSpawn(level, difficultyInstance, spawnType, spawnData, nbt);
//        }
//    }
//
//    public CelestialAxolotl.Variant getVariant() {
//        return CelestialAxolotl.Variant.BY_ID[this.entityData.get(DATA_VARIANT)];
//    }
//
//    private void setVariant(CelestialAxolotl.Variant variant) {
//        this.entityData.set(DATA_VARIANT, variant.getId());
//    }
//
//    private static boolean useRareVariant(Random random) {
//        return random.nextInt(RARE_VARIANT_CHANCE) == 0;
//    }
//
//    public boolean checkSpawnObstruction(LevelReader level) {
//        return level.isUnobstructed(this);
//    }
//
//    public boolean canBreatheUnderwater() {
//        return true;
//    }
//
//    public boolean isPushedByFluid() {
//        return false;
//    }
//
////    public MobType getMobType() {
////        return MobType.WATER;
////    }
//
//    public void setPlayingDead(boolean playingDead) {
//        this.entityData.set(DATA_PLAYING_DEAD, playingDead);
//    }
//
//    public boolean isPlayingDead() {
//        return this.entityData.get(DATA_PLAYING_DEAD);
//    }
//
//    public boolean fromBucket() {
//        return this.entityData.get(FROM_BUCKET);
//    }
//
//    public void setFromBucket(boolean fromBucket) {
//        this.entityData.set(FROM_BUCKET, fromBucket);
//    }
//
//    @Nullable
//    public AgeableMob getBreedOffspring(ServerLevel level, AgeableMob mob) {
//        CelestialAxolotl axolotl = CelestialEntities.CELESTIAL_AXOLOTL.get().create(level);
//        if (axolotl != null) {
//            CelestialAxolotl.Variant axolotl$variant;
//            if (useRareVariant(this.random)) {
//                axolotl$variant = CelestialAxolotl.Variant.getRareSpawnVariant(this.random);
//            } else {
//                axolotl$variant = this.random.nextBoolean() ? this.getVariant() : ((CelestialAxolotl)mob).getVariant();
//            }
//
//            axolotl.setVariant(axolotl$variant);
//            axolotl.setPersistenceRequired();
//        }
//
//        return axolotl;
//    }
//
//    public double getMeleeAttackRangeSqr(LivingEntity entity) {
//        return 1.5D + (double)entity.getBbWidth() * 2.0D;
//    }
//
//    public boolean isFood(ItemStack itemStack) {
//        return itemStack.is(ItemTags.AXOLOTL_TEMPT_ITEMS);
//    }
//
//    public boolean canBeLeashed(Player player) {
//        return true;
//    }
//
//    protected void customServerAiStep() {
//        this.level.getProfiler().push("axolotlBrain");
//        this.getBrain().tick((ServerLevel)this.level, this);
//        this.level.getProfiler().pop();
//        this.level.getProfiler().push("axolotlActivityUpdate");
//        CelestialAxolotlAi.updateActivity(this);
//        this.level.getProfiler().pop();
//        if (!this.isNoAi()) {
//            Optional<Integer> optional = this.getBrain().getMemory(MemoryModuleType.PLAY_DEAD_TICKS);
//            this.setPlayingDead(optional.isPresent() && optional.get() > 0);
//        }
//
//    }
//
//    public static AttributeSupplier.Builder createAttributes() {
//        return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 14.0D).add(Attributes.MOVEMENT_SPEED, 1.0D).add(Attributes.FLYING_SPEED, 1.0D).add(Attributes.ATTACK_DAMAGE, 2.0D);
//    }
//
//    protected PathNavigation createNavigation(Level level) {
//        FlyingPathNavigation flyingpathnavigation = new FlyingPathNavigation(this, level);
//        flyingpathnavigation.setCanOpenDoors(false);
//        flyingpathnavigation.setCanFloat(true);
//        flyingpathnavigation.setCanPassDoors(true);
//        return flyingpathnavigation;
////        return new CelestialAxolotl.AxolotlPathNavigation(this, level);
//    }
//
//    public boolean doHurtTarget(Entity entity) {
//        boolean flag = entity.hurt(DamageSource.mobAttack(this), (float)((int)this.getAttributeValue(Attributes.ATTACK_DAMAGE)));
//        if (flag) {
//            this.doEnchantDamageEffects(this, entity);
//            this.playSound(SoundEvents.AXOLOTL_ATTACK, 1.0F, 1.0F);
//        }
//
//        return flag;
//    }
//
//    public boolean hurt(DamageSource damageSource, float p_149116_) {
//        float f = this.getHealth();
//        if (!this.level.isClientSide && !this.isNoAi() && this.level.random.nextInt(3) == 0 && ((float)this.level.random.nextInt(3) < p_149116_ || f / this.getMaxHealth() < 0.5F) && p_149116_ < f
////                && this.isInWater()
//                && (damageSource.getEntity() != null || damageSource.getDirectEntity() != null) && !this.isPlayingDead()) {
//            this.brain.setMemory(MemoryModuleType.PLAY_DEAD_TICKS, 200);
//        }
//
//        return super.hurt(damageSource, p_149116_);
//    }
//
//    protected float getStandingEyeHeight(Pose pose, EntityDimensions dimensions) {
//        return dimensions.height * 0.655F;
//    }
//
//    public int getMaxHeadXRot() {
//        return 1;
//    }
//
//    public int getMaxHeadYRot() {
//        return 1;
//    }
//
//    public InteractionResult mobInteract(Player player, InteractionHand hand) {
//        return Bucketable.bucketMobPickup(player, hand, this).orElse(super.mobInteract(player, hand));
//    }
//
//    public void saveToBucketTag(ItemStack itemStack) {
//        Bucketable.saveDefaultDataToBucketTag(this, itemStack);
//        CompoundTag compoundtag = itemStack.getOrCreateTag();
//        compoundtag.putInt("Variant", this.getVariant().getId());
//        compoundtag.putInt("Age", this.getAge());
//        Brain<?> brain = this.getBrain();
//        if (brain.hasMemoryValue(MemoryModuleType.HAS_HUNTING_COOLDOWN)) {
//            compoundtag.putLong("HuntingCooldown", brain.getTimeUntilExpiry(MemoryModuleType.HAS_HUNTING_COOLDOWN));
//        }
//
//    }
//
//    public void loadFromBucketTag(CompoundTag nbt) {
//        Bucketable.loadDefaultDataFromBucketTag(this, nbt);
//        int i = nbt.getInt("Variant");
//        if (i >= 0 && i < CelestialAxolotl.Variant.BY_ID.length) {
//            this.setVariant(CelestialAxolotl.Variant.BY_ID[i]);
//        } else {
//            LOGGER.error("Invalid variant: {}", (int)i);
//        }
//
//        if (nbt.contains("Age")) {
//            this.setAge(nbt.getInt("Age"));
//        }
//
//        if (nbt.contains("HuntingCooldown")) {
//            this.getBrain().setMemoryWithExpiry(MemoryModuleType.HAS_HUNTING_COOLDOWN, true, nbt.getLong("HuntingCooldown"));
//        }
//
//    }
//
//    public ItemStack getBucketItemStack() {
//        return new ItemStack(Items.AXOLOTL_BUCKET);
//    }
//
//    public SoundEvent getPickupSound() {
//        return SoundEvents.BUCKET_FILL_AXOLOTL;
//    }
//
//    public boolean canBeSeenAsEnemy() {
//        return !this.isPlayingDead() && super.canBeSeenAsEnemy();
//    }
//
//    public static void onStopAttacking(CelestialAxolotl axolotl) {
//        Optional<LivingEntity> optional = axolotl.getBrain().getMemory(MemoryModuleType.ATTACK_TARGET);
//        if (optional.isPresent()) {
//            Level level = axolotl.level;
//            LivingEntity livingentity = optional.get();
//            if (livingentity.isDeadOrDying()) {
//                DamageSource damagesource = livingentity.getLastDamageSource();
//                if (damagesource != null) {
//                    Entity entity = damagesource.getEntity();
//                    if (entity != null && entity.getType() == EntityType.PLAYER) {
//                        Player player = (Player)entity;
//                        List<Player> list = level.getEntitiesOfClass(Player.class, axolotl.getBoundingBox().inflate(20.0D));
//                        if (list.contains(player)) {
//                            axolotl.applySupportingEffects(player);
//                        }
//                    }
//                }
//            }
//
//        }
//    }
//
//    public void applySupportingEffects(Player player) {
//        MobEffectInstance mobeffectinstance = player.getEffect(MobEffects.REGENERATION);
//        int i = mobeffectinstance != null ? mobeffectinstance.getDuration() : 0;
//        if (i < REGEN_BUFF_MAX_DURATION) {
//            i = Math.min(REGEN_BUFF_MAX_DURATION, REGEN_BUFF_BASE_DURATION + i);
//            player.addEffect(new MobEffectInstance(MobEffects.REGENERATION, i, 0), this);
//        }
//
//        player.removeEffect(MobEffects.DIG_SLOWDOWN);
//    }
//
//    public boolean requiresCustomPersistence() {
//        return super.requiresCustomPersistence() || this.fromBucket();
//    }
//
//    protected SoundEvent getHurtSound(DamageSource damageSource) {
//        return SoundEvents.AXOLOTL_HURT;
//    }
//
//    @Nullable
//    protected SoundEvent getDeathSound() {
//        return SoundEvents.AXOLOTL_DEATH;
//    }
//
//    @Nullable
//    protected SoundEvent getAmbientSound() {
//        return this.isInWater() ? SoundEvents.AXOLOTL_IDLE_WATER : SoundEvents.AXOLOTL_IDLE_AIR;
//    }
//
//    protected SoundEvent getSwimSplashSound() {
//        return SoundEvents.AXOLOTL_SPLASH;
//    }
//
//    protected SoundEvent getSwimSound() {
//        return SoundEvents.AXOLOTL_SWIM;
//    }
//
//    protected Brain.Provider<CelestialAxolotl> brainProvider() {
//        return Brain.provider(MEMORY_TYPES, SENSOR_TYPES);
//    }
//
//    protected Brain<?> makeBrain(Dynamic<?> p_149138_) {
//        return CelestialAxolotlAi.makeBrain(this.brainProvider().makeBrain(p_149138_));
//    }
//
//    public Brain<CelestialAxolotl> getBrain() {
//        return (Brain<CelestialAxolotl>)super.getBrain();
//    }
//
//    protected void sendDebugPackets() {
//        super.sendDebugPackets();
//        DebugPackets.sendEntityBrain(this);
//    }
//
//    public void travel(Vec3 vec3) {
//        if (this.isEffectiveAi()) { //&& this.isInWater()) {
//            this.moveRelative(this.getSpeed(), vec3);
//            this.move(MoverType.SELF, this.getDeltaMovement());
//            this.setDeltaMovement(this.getDeltaMovement().scale(0.9D));
//        } else {
//            super.travel(vec3);
//        }
//
//    }
//
//    protected void usePlayerItem(Player player, InteractionHand hand, ItemStack itemStack) {
//        //FIXME?
//        if (itemStack.is(Items.TROPICAL_FISH_BUCKET)) {
//            player.setItemInHand(hand, new ItemStack(Items.WATER_BUCKET));
//        } else {
//            super.usePlayerItem(player, hand, itemStack);
//        }
//
//    }
//
//    public boolean removeWhenFarAway(double p_149183_) {
//        return !this.fromBucket() && !this.hasCustomName();
//    }
//
//    public static boolean checkAxolotlSpawnRules(EntityType<? extends LivingEntity> axolotl, ServerLevelAccessor level, MobSpawnType spawnType, BlockPos pos, Random random) {
//        return true;
////        return level.getBlockState(p_186253_.below()).is(BlockTags.AXOLOTLS_SPAWNABLE_ON);
//    }
//
//    public static class AxolotlGroupData extends AgeableMob.AgeableMobGroupData {
//        public final CelestialAxolotl.Variant[] types;
//
//        public AxolotlGroupData(CelestialAxolotl.Variant... variants) {
//            super(false);
//            this.types = variants;
//        }
//
//        public CelestialAxolotl.Variant getVariant(Random random) {
//            return this.types[random.nextInt(this.types.length)];
//        }
//    }
//
//    class AxolotlLookControl extends LookControl { //SmoothSwimmingLookControl {
//        public AxolotlLookControl(CelestialAxolotl axolotl) { //, int p_149211_) {
//            super(axolotl); //, p_149211_);
//        }
//
//        public void tick() {
//            if (!CelestialAxolotl.this.isPlayingDead()) {
//                super.tick();
//            }
//
//        }
//    }
//
//    static class AxolotlMoveControl extends FlyingMoveControl { //SmoothSwimmingMoveControl {
//        private final CelestialAxolotl axolotl;
//
//        public AxolotlMoveControl(CelestialAxolotl axolotl) {
//            super(axolotl, 85, true); //85, 10, 0.1F, 0.5F, false);
//            this.axolotl = axolotl;
//        }
//
//        public void tick() {
//            if (!this.axolotl.isPlayingDead()) {
//                super.tick();
//            }
//
//        }
//    }
//
//    public enum Variant {
//        ASTEROID(0, "asteroid", true),
//        STARDUST(1, "stardust", true);
//
//        public static final CelestialAxolotl.Variant[] BY_ID = Arrays.stream(values()).sorted(Comparator.comparingInt(CelestialAxolotl.Variant::getId)).toArray(Variant[]::new);
//        private final int id;
//        private final String name;
//        private final boolean common;
//
//        Variant(int id, String name, boolean common) {
//            this.id = id;
//            this.name = name;
//            this.common = common;
//        }
//
//        public int getId() {
//            return this.id;
//        }
//
//        public String getName() {
//            return this.name;
//        }
//
//        public static CelestialAxolotl.Variant getCommonSpawnVariant(Random random) {
//            return getSpawnVariant(random, true);
//        }
//
//        public static CelestialAxolotl.Variant getRareSpawnVariant(Random random) {
//            return getSpawnVariant(random, false);
//        }
//
//        private static CelestialAxolotl.Variant getSpawnVariant(Random random, boolean common) {
//            CelestialAxolotl.Variant[] axolotlvariant = Arrays.stream(BY_ID).filter((variant) -> variant.common == common).toArray(Variant[]::new);
//            return Util.getRandom(axolotlvariant, random);
//        }
//    }
//}