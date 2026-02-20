package com.shim.celestialexploration.entity.robots;

import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestialexploration.blocks.blockentities.WorkbenchBlockEntity;
import com.shim.celestialexploration.entity.DyeType;
import com.shim.celestialexploration.entity.IDyeable;
import com.shim.celestialexploration.entity.client.dispatchers.MechaCrowDispatcher;
import com.shim.celestialexploration.recipes.MechaCrowCraftingRecipe;
import com.shim.celestialexploration.recipes.WorkbenchCraftingRecipe;
import com.shim.celestialexploration.recipes.WorkbenchSmeltingRecipe;
import mod.azure.azurelib.util.MoveAnalysis;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.*;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.FlyingMoveControl;
import net.minecraft.world.entity.ai.control.MoveControl;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.navigation.FlyingPathNavigation;
import net.minecraft.world.entity.ai.navigation.GroundPathNavigation;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.ai.util.AirAndWaterRandomPos;
import net.minecraft.world.entity.ai.util.HoverRandomPos;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.horse.AbstractHorse;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.minecraft.world.level.pathfinder.Path;
import net.minecraft.world.level.pathfinder.WalkNodeEvaluator;
import net.minecraft.world.phys.Vec3;

import javax.annotation.Nullable;
import java.util.EnumSet;
import java.util.List;
import java.util.Optional;
import java.util.Random;

public class MechaCrow extends TamableAnimal implements ContainerListener, IDyeable { //implements FlyingAnimal {
    static double movementSpeed = 0.21;
    public final MechaCrowDispatcher dispatcher;
    private final MoveAnalysis moveAnalysis;
    private boolean shouldBeFlying;
    private static final EntityDataAccessor<Boolean> DATA_IS_FLYING = SynchedEntityData.defineId(MechaCrow.class, EntityDataSerializers.BOOLEAN);
//    private static final EntityDataAccessor<Byte> DATA_ID_FLAGS = SynchedEntityData.defineId(MechaCrow.class, EntityDataSerializers.BYTE);
    private static final EntityDataAccessor<Integer> DATA_ID_TYPE = SynchedEntityData.defineId(MechaCrow.class, EntityDataSerializers.INT);

    private final MoveControl flyingMoveControl = new FlyingMoveControl(this, 10, true);
    private final MoveControl groundMoveControl = new MoveControl(this);
    protected SimpleContainer inventory;


    public MechaCrow(EntityType<? extends TamableAnimal> entity, Level level) {
        super(entity, level);
//        this.addEffect(new MobEffectInstance(CLibEffects.LOW_GRAVITY.get(), 120000, 0, false, false, true));
        this.moveControl = new FlyingMoveControl(this, 10, false);

        this.dispatcher = new MechaCrowDispatcher(this);
        this.moveAnalysis = new MoveAnalysis(this);
        this.setPathfindingMalus(BlockPathTypes.DANGER_FIRE, -1.0F);
        this.setPathfindingMalus(BlockPathTypes.FENCE, -1.0F);
        this.setFlying(false);
        this.createInventory();
    }

    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(DATA_IS_FLYING, false);
        this.entityData.define(DATA_ID_TYPE, DyeType.BLACK.ordinal());
    }

    public boolean isFlying() {
        return this.entityData.get(DATA_IS_FLYING);
    }

    public void setFlyingData(boolean isFlying) {
        this.entityData.set(DATA_IS_FLYING, isFlying);
    }

    public void setMoveControlToFlying(boolean shouldFly) {
        this.moveControl = shouldFly ? flyingMoveControl : groundMoveControl;
        this.navigation = shouldFly ? getFlyingNavigation(this.level) : getGroundNavigation(this.level);
    }

    public void setFlying(boolean shouldFly) {
        setFlyingData(shouldFly);
        setMoveControlToFlying(shouldFly);
    }

    public boolean causeFallDamage(float p_147105_, float p_147106_, DamageSource damageSource) {
        return false;
    }

    protected void registerGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));
//        this.goalSelector.addGoal(2, new MechaCrow.MechaCrowWanderGoal(this, 0.8D));

        this.goalSelector.addGoal(3, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.goalSelector.addGoal(3, new RandomLookAroundGoal(this));
        this.goalSelector.addGoal(1, new MechaCrowFollowOwnerGoal(this, 1.0D, 5.0F, 1.0F, true));
//        this.goalSelector.addGoal(5, new FollowMobGoal(this, 1.0D, 3.0F, 7.0F));
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
    public @org.jetbrains.annotations.Nullable AgeableMob getBreedOffspring(ServerLevel level, AgeableMob mob) {
        return null;
    }

    @Override
    public boolean canFallInLove() {
        return false;
    }

    public static boolean checkMechaCrowSpawnRules(EntityType<MechaCrow> entity, LevelAccessor level, MobSpawnType spawnType, BlockPos pos, Random random) {
        return random.nextInt(5) == 0 && checkMobSpawnRules(entity, level, spawnType, pos, random);
    }

    @Override
    public InteractionResult mobInteract(Player player, InteractionHand hand) {
        ItemStack itemstack = player.getItemInHand(hand);

        if (this.level.isClientSide) {
            boolean flag = this.isOwnedBy(player) || this.isTame() || itemstack.is(Items.REDSTONE) && !this.isTame();
            return flag ? InteractionResult.CONSUME : InteractionResult.PASS;
        } else {
            if (itemstack.is(Items.REDSTONE)) {
                if (!player.getAbilities().instabuild) {
                    itemstack.shrink(1);
                }

                if (this.random.nextInt(3) == 0) { // && !net.minecraftforge.event.ForgeEventFactory.onAnimalTame(this, player)) {
                    this.tame(player);
                    this.navigation.stop();
                    this.setTarget((LivingEntity) null);
//                this.setOrderedToSit(true);
                    this.level.broadcastEntityEvent(this, (byte) 7);
                } else {
                    this.level.broadcastEntityEvent(this, (byte) 6);
                }
                return InteractionResult.SUCCESS;
            }
        }
        return super.mobInteract(player, hand);
    }

    protected PathNavigation getFlyingNavigation(Level level) {
        FlyingPathNavigation flyingpathnavigation = new FlyingPathNavigation(this, level);
        flyingpathnavigation.setCanOpenDoors(false);
        flyingpathnavigation.setCanFloat(true);
        flyingpathnavigation.setCanPassDoors(true);
        return flyingpathnavigation;
    }

    protected PathNavigation getGroundNavigation(Level level) {
        return new GroundPathNavigation(this, level);
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Animal.createLivingAttributes().add(Attributes.MOVEMENT_SPEED, movementSpeed).add(Attributes.FOLLOW_RANGE, 48.0D).add(Attributes.FLYING_SPEED, movementSpeed + .05);
    }

//    @Override
//    public boolean isFlying() {
//        return this.isOnGround();
//    }

    protected Runnable getAnimation() {
//        if (this.isInSittingPose()) {
//            return dispatcher::idle;
//        } else {
            boolean isMovingOnGround = moveAnalysis.isMovingHorizontally() && this.onGround;
            if (this.isFlying()) {
                return dispatcher::fly;
            }
            if (isMovingOnGround) {
                return dispatcher::hop;
            } else {
                return dispatcher::idle;
            }
//        }
    }

    protected float getJumpPower() {
        if (!this.horizontalCollision && (!this.moveControl.hasWanted() || !(this.moveControl.getWantedY() > this.getY() + 0.5D))) {
            Path path = this.navigation.getPath();
            if (path != null && !path.isDone()) {
                Vec3 vec3 = path.getNextEntityPos(this);
                if (vec3.y > this.getY() + 0.5D) {
                    return 0.5F;
                }
            }

            return this.moveControl.getSpeedModifier() <= 0.6D ? 0.2F : 0.3F;
        } else {
            return 0.4F; //0.5F;
        }
    }


    @Override
    public void tick() {
        super.tick();

        if (this.isAlive()) {
            if (this.level.isClientSide()) {
                Runnable animationRunner = this.getAnimation();
                animationRunner.run();
            }
        }

        SimpleContainer inventory = new SimpleContainer(1);


    }

    private net.minecraftforge.common.util.LazyOptional<?> itemHandler = null;

    @Override
    public <T> net.minecraftforge.common.util.LazyOptional<T> getCapability(net.minecraftforge.common.capabilities.Capability<T> capability, @Nullable net.minecraft.core.Direction facing) {
        if (this.isAlive() && capability == net.minecraftforge.items.CapabilityItemHandler.ITEM_HANDLER_CAPABILITY && itemHandler != null)
            return itemHandler.cast();
        return super.getCapability(capability, facing);
    }

    @Override
    public void invalidateCaps() {
        super.invalidateCaps();
        if (itemHandler != null) {
            net.minecraftforge.common.util.LazyOptional<?> oldHandler = itemHandler;
            itemHandler = null;
            oldHandler.invalidate();
        }
    }

    public boolean hasInventoryChanged(Container p_149512_) {
        return this.inventory != p_149512_;
    }

    protected int getInventorySize() {
        return 1;
    }

    protected void createInventory() {
        SimpleContainer simplecontainer = this.inventory;
        this.inventory = new SimpleContainer(this.getInventorySize());
        if (simplecontainer != null) {
            simplecontainer.removeListener(this);
            int i = 1; //Math.min(simplecontainer.getContainerSize(), this.inventory.getContainerSize());

            for(int j = 0; j < i; ++j) {
                ItemStack itemstack = simplecontainer.getItem(j);
                if (!itemstack.isEmpty()) {
                    this.inventory.setItem(j, itemstack.copy());
                }
            }
        }

        this.inventory.addListener(this);
        this.updateContainerEquipment();
        this.itemHandler = net.minecraftforge.common.util.LazyOptional.of(() -> new net.minecraftforge.items.wrapper.InvWrapper(this.inventory));
    }

    protected void updateContainerEquipment() {
        if (!this.level.isClientSide) {
            this.setFlag(4, !this.inventory.getItem(0).isEmpty());
        }
    }

    public void containerChanged(Container p_30548_) {
        this.updateContainerEquipment();
    }

    protected void dropEquipment() {
        super.dropEquipment();
        if (this.inventory != null) {
            for(int i = 0; i < this.inventory.getContainerSize(); ++i) {
                ItemStack itemstack = this.inventory.getItem(i);
                if (!itemstack.isEmpty() && !EnchantmentHelper.hasVanishingCurse(itemstack)) {
                    this.spawnAtLocation(itemstack);
                }
            }
        }
    }

    public void addAdditionalSaveData(CompoundTag tag) {
        super.addAdditionalSaveData(tag);
        tag.putString("Type", this.getDyeType().getName());
    }

    public void readAdditionalSaveData(CompoundTag tag) {
        super.readAdditionalSaveData(tag);
        if (tag.contains("Type", 8)) {
            this.setDyeType(DyeType.byName(tag.getString("Type")));
        }
    }

    public void setDyeType(DyeType p_38333_) {
        this.entityData.set(DATA_ID_TYPE, p_38333_.ordinal());
    }

    public DyeType getDyeType() {
        return DyeType.byId(this.entityData.get(DATA_ID_TYPE));
    }


    @Override
    public boolean canPickUpLoot() {
        return true;
    }

//    @Override
//    public boolean canHoldItem(ItemStack p_21545_) {
//        return false;
//    }

    @Override
    protected void pickUpItem(ItemEntity itemEntity) {
        ItemStack itemstack = itemEntity.getItem();
//        CelestialExploration.LOGGER.debug("item is: " + itemstack + ", thrown by: " + itemEntity.getThrower() + ", looking for: " + this.getOwnerUUID());
        if (itemEntity.getThrower() == null) {
            return;
        }
        if (itemEntity.getThrower().equals(this.getOwnerUUID())) {
            if (this.inventory.canAddItem(itemstack)) {

                this.inventory.addItem(itemstack);
                CelestialExploration.LOGGER.debug("checking for recipe next");

                if (hasRecipe(this)) {
                    CelestialExploration.LOGGER.debug("has recipe");

                    this.onItemPickup(itemEntity);
                    this.take(itemEntity, itemstack.getCount());
                    itemEntity.discard();

                    Optional<MechaCrowCraftingRecipe> recipe = level.getRecipeManager().getRecipeFor(MechaCrowCraftingRecipe.Type.INSTANCE, this.inventory, level);
                    if (recipe.isPresent()) {
                        MechaCrowCraftingRecipe craftingRecipe = recipe.get();

                        ItemStack resultItem = craftingRecipe.assemble(this.inventory);
                        ItemEntity resultItemEntity = new ItemEntity(level, (double) this.blockPosition().getX() + 0.5D, (double) this.blockPosition().getY() + 0.5D,
                                (double) this.blockPosition().getZ() + 0.5D, resultItem);

                        resultItemEntity.setDefaultPickUpDelay();
                        level.addFreshEntity(resultItemEntity);
                        this.inventory.clearContent();

                    }
                } else {
                    this.inventory.clearContent();
                }
            }
//            super.pickUpItem(itemEntity);
        }
    }

    private static boolean hasRecipe(MechaCrow entity) {
        Level level = entity.level;

//        List<MechaCrowCraftingRecipe> s = level.getRecipeManager().getAllRecipesFor(MechaCrowCraftingRecipe.Type.INSTANCE);
//        CelestialExploration.LOGGER.debug("crow recipes: {}", s);
//        List<WorkbenchCraftingRecipe> s1 = level.getRecipeManager().getAllRecipesFor(WorkbenchCraftingRecipe.Type.INSTANCE);
//        CelestialExploration.LOGGER.debug("workbench recipes: {}", s1);


        Optional<MechaCrowCraftingRecipe> match = level.getRecipeManager().getRecipeFor(MechaCrowCraftingRecipe.Type.INSTANCE, entity.inventory, level);

        return match.isPresent();
    }

    protected boolean getFlag(int p_30648_) {
        return (this.entityData.get(DATA_FLAGS_ID) & p_30648_) != 0;
    }

    protected void setFlag(int p_30598_, boolean p_30599_) {
        byte b0 = this.entityData.get(DATA_FLAGS_ID);
        if (p_30599_) this.entityData.set(DATA_FLAGS_ID, (byte)(b0 | p_30598_));
        else this.entityData.set(DATA_FLAGS_ID, (byte)(b0 & ~p_30598_));
    }


    protected class MechaCrowWanderGoal extends WaterAvoidingRandomFlyingGoal {
        private final MechaCrow crow;


        public MechaCrowWanderGoal(MechaCrow crow, double p_25982_) {
            super(crow, p_25982_);
            this.crow = crow;
        }

        @Override
        public void start() {
            int rand = crow.random.nextInt(2);
            if (rand == 0) {
                this.crow.setFlying(true);
            } else {
                this.crow.setFlying(false);
            }
            super.start();
        }

        @Override
        public void stop() {
            this.crow.setFlying(false);
            this.crow.setNoGravity(false);
            super.stop();
        }

        @Override
        public void tick() {
            super.tick();
            if (!this.crow.isFlying()) {
                this.crow.jumpControl.jump();
            }
        }

        @Nullable
        protected Vec3 getPosition() {
            Vec3 vec3 = this.mob.getViewVector(0.0F);
            Vec3 vec31 = HoverRandomPos.getPos(this.mob, 8, 7, vec3.x, vec3.z, ((float)Math.PI / 2F), 3, 1);

            if (vec31 != null)
                vec31.add(0, this.crow.random.nextInt(2), 0);

            return vec31 != null ? vec31 : AirAndWaterRandomPos.getPos(this.mob, 8, 4, -2, vec3.x, vec3.z, (double)((float)Math.PI / 2F));
        }
    }

    protected static class MechaCrowFollowOwnerGoal extends Goal {
        public static final int TELEPORT_WHEN_DISTANCE_IS = 12;
        private static final int MIN_XZ_DIST_FROM_PLAYER_TELEPORTING = 2;
        private static final int MAX_XZ_DIST_FROM_PLAYER_TELEPORTING = 3;
        private static final int MAX_Y_DIST_FROM_PLAYER_TELEPORTING = 1;
        private final MechaCrow crow;
        private LivingEntity owner;
        private final LevelReader level;
        private final double speedModifier;
        private final PathNavigation navigation;
        private int timeToRecalcPath;
        private final float stopDistance;
        private final float startDistance;
        private float oldWaterCost;
        private final boolean canFly;

        public MechaCrowFollowOwnerGoal(MechaCrow crow, double speedModifier, float startDistance, float stopDistance, boolean canFly) {
            this.crow = crow;
            this.level = crow.level;
            this.speedModifier = speedModifier;
            this.navigation = crow.getNavigation();
            this.startDistance = startDistance;
            this.stopDistance = stopDistance;
            this.canFly = canFly;
            this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK));
            if (!(crow.getNavigation() instanceof GroundPathNavigation) && !(crow.getNavigation() instanceof FlyingPathNavigation)) {
                throw new IllegalArgumentException("Unsupported mob type for FollowOwnerGoal");
            }
        }

        public boolean canUse() {
            LivingEntity livingentity = this.crow.getOwner();
            if (livingentity == null) {
                return false;
            } else if (livingentity.isSpectator()) {
                return false;
            } else if (this.crow.isOrderedToSit()) {
                return false;
            } else if (this.crow.distanceToSqr(livingentity) < (double) (this.startDistance * this.startDistance)) {
                return false;
            } else {
                this.owner = livingentity;
                return true;
            }
        }

        public boolean canContinueToUse() {
            if (this.navigation.isDone()) {
                this.crow.setFlying(false);
                return false;
            } else if (this.crow.isOrderedToSit()) {
                this.crow.setFlying(false);
                return false;
            } else {
                return !(this.crow.distanceToSqr(this.owner) <= (double) (this.stopDistance * this.stopDistance));
            }
        }

        public void start() {
            this.timeToRecalcPath = 0;
            this.oldWaterCost = this.crow.getPathfindingMalus(BlockPathTypes.WATER);
            this.crow.setPathfindingMalus(BlockPathTypes.WATER, 0.0F);
        }

        public void stop() {
            this.owner = null;
            this.navigation.stop();
            this.crow.setPathfindingMalus(BlockPathTypes.WATER, this.oldWaterCost);
        }

        public void tick() {
            this.crow.getLookControl().setLookAt(this.owner, 10.0F, (float) this.crow.getMaxHeadXRot());
            if (--this.timeToRecalcPath <= 0) {
                this.timeToRecalcPath = this.adjustedTickDelay(10);
                if (!this.crow.isLeashed() && !this.crow.isPassenger()) {
                    if (this.crow.distanceToSqr(this.owner) >= 144.0D) {
                        this.teleportToOwner();
                    } else {
                        this.navigation.moveTo(this.owner, this.speedModifier);
                    }

                }
            }
        }

        private void teleportToOwner() {
            BlockPos pos = this.owner.blockPosition();

            for (int i = 0; i < 10; ++i) {
                int j = this.randomIntInclusive(-MAX_XZ_DIST_FROM_PLAYER_TELEPORTING, MAX_XZ_DIST_FROM_PLAYER_TELEPORTING);
                int k = this.randomIntInclusive(-MAX_Y_DIST_FROM_PLAYER_TELEPORTING, MAX_Y_DIST_FROM_PLAYER_TELEPORTING);
                int l = this.randomIntInclusive(-MAX_XZ_DIST_FROM_PLAYER_TELEPORTING, MAX_XZ_DIST_FROM_PLAYER_TELEPORTING);
                boolean teleported = this.maybeTeleportTo(pos.getX() + j, pos.getY() + k, pos.getZ() + l);
                if (teleported) {
                    return;
                }
            }
        }

        private boolean maybeTeleportTo(int x, int y, int z) {
            if (Math.abs((double) x - this.owner.getX()) < 2.0D && Math.abs((double) z - this.owner.getZ()) < 2.0D) {
                return false;
            } else if (!this.canTeleportTo(new BlockPos(x, y, z))) {
                return false;
            } else {
                this.crow.moveTo((double) x + 0.5D, (double) y, (double) z + 0.5D, this.crow.getYRot(), this.crow.getXRot());
                this.navigation.stop();
                return true;
            }
        }

        private boolean canTeleportTo(BlockPos pos) {
            BlockPathTypes blockpathtypes = WalkNodeEvaluator.getBlockPathTypeStatic(this.level, pos.mutable());
            if (blockpathtypes != BlockPathTypes.WALKABLE) {
                return false;
            } else {
                BlockState blockstate = this.level.getBlockState(pos.below());
                if (!this.canFly && blockstate.getBlock() instanceof LeavesBlock) {
                    return false;
                } else {
                    BlockPos blockpos = pos.subtract(this.crow.blockPosition());
                    return this.level.noCollision(this.crow, this.crow.getBoundingBox().move(blockpos));
                }
            }
        }

        private int randomIntInclusive(int p_25301_, int p_25302_) {
            return this.crow.getRandom().nextInt(p_25302_ - p_25301_ + 1) + p_25301_;
        }
    }

}
