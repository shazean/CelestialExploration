package com.shim.celestialexploration.entity;

import com.google.common.collect.Lists;
import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestialexploration.blocks.blockentities.OxygenCompressorBlockEntity;
import com.shim.celestialexploration.inventory.menus.ShuttleMenu;
import com.shim.celestialexploration.registry.EntityRegistry;
import com.shim.celestialexploration.registry.ItemRegistry;
import com.shim.celestialexploration.util.Keybinds;
import net.minecraft.BlockUtil;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientboundAddEntityPacket;
import net.minecraft.network.protocol.game.ServerboundPaddleBoatPacket;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.Mth;
import net.minecraft.world.*;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.WaterAnimal;
import net.minecraft.world.entity.animal.horse.AbstractChestedHorse;
import net.minecraft.world.entity.animal.horse.AbstractHorse;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.vehicle.DismountHelper;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.WaterlilyBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.network.NetworkHooks;

import javax.annotation.Nullable;
import java.util.List;
import java.util.function.Predicate;

public class Shuttle extends Entity implements ContainerListener, MenuProvider {
    private static final EntityDataAccessor<Integer> DATA_ID_HURT = SynchedEntityData.defineId(Shuttle.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Integer> DATA_ID_HURTDIR = SynchedEntityData.defineId(Shuttle.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Float> DATA_ID_DAMAGE = SynchedEntityData.defineId(Shuttle.class, EntityDataSerializers.FLOAT);
    private static final EntityDataAccessor<Integer> DATA_ID_TYPE = SynchedEntityData.defineId(Shuttle.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Boolean> DATA_ID_PADDLE_LEFT = SynchedEntityData.defineId(Shuttle.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Boolean> DATA_ID_PADDLE_RIGHT = SynchedEntityData.defineId(Shuttle.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Integer> DATA_ID_BUBBLE_TIME = SynchedEntityData.defineId(Shuttle.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Byte> DATA_ID_FLAGS = SynchedEntityData.defineId(Shuttle.class, EntityDataSerializers.BYTE);

    private float outOfControlTicks;
    private float deltaRotation;
    private int lerpSteps;
    private double lerpX;
    private double lerpY;
    private double lerpZ;
    private double lerpYRot;
    private double lerpXRot;
    private Shuttle.Status status;
    private final float SHUTTLE_SPEED = .45F;
    private final float SHUTTLE_NO_FUEL_SPEED = .1F; //TODO
    protected SimpleContainer inventory;

    public Shuttle(EntityType<? extends Shuttle> p_38290_, Level p_38291_) {
        super(p_38290_, p_38291_);
        this.blocksBuilding = true;
        this.createInventory();
    }

    public Shuttle(Level p_38293_, double p_38294_, double p_38295_, double p_38296_) {
        this(EntityRegistry.SHUTTLE.get(), p_38293_);
        this.setPos(p_38294_, p_38295_, p_38296_);
        this.xo = p_38294_;
        this.yo = p_38295_;
        this.zo = p_38296_;
        this.setNoGravity(true);
    }

    @Override
    public void containerChanged(Container p_18983_) {

    }


    @org.jetbrains.annotations.Nullable
    @Override
    public AbstractContainerMenu createMenu(int containerId, Inventory inventory, Player player) {
        return new ShuttleMenu(containerId, inventory, this);
    }

    @Override
    public Component getDisplayName() {
        return new TextComponent("Shuttle");
    }


    protected float getEyeHeight(Pose p_38327_, EntityDimensions p_38328_) {
        return p_38328_.height;
    }

    protected Entity.MovementEmission getMovementEmission() {
        return Entity.MovementEmission.NONE;
    }

    @Override
    protected void defineSynchedData() {
        this.entityData.define(DATA_ID_HURT, 0);
        this.entityData.define(DATA_ID_HURTDIR, 1);
        this.entityData.define(DATA_ID_DAMAGE, 0.0F);
        this.entityData.define(DATA_ID_TYPE, Type.WHITE.ordinal());
        this.entityData.define(DATA_ID_PADDLE_LEFT, false);
        this.entityData.define(DATA_ID_PADDLE_RIGHT, false);
        this.entityData.define(DATA_ID_BUBBLE_TIME, 0);
        this.entityData.define(DATA_ID_FLAGS, (byte)0);
    }

    public boolean canCollideWith(Entity p_38376_) {
        return false;
//        return canVehicleCollide(this, p_38376_);
    }

    public static boolean canVehicleCollide(Entity p_38324_, Entity p_38325_) {
        return false;
//        return (p_38325_.canBeCollidedWith() || p_38325_.isPushable()) && !p_38324_.isPassengerOfSameVehicle(p_38325_);
    }

    public boolean canBeCollidedWith() {
        return false;
    }

    public boolean isPushable() {
        return false;
    }

    protected Vec3 getRelativePortalPosition(Direction.Axis p_38335_, BlockUtil.FoundRectangle p_38336_) {
        return LivingEntity.resetForwardDirectionOfRelativePortalPosition(super.getRelativePortalPosition(p_38335_, p_38336_));
    }

    public double getPassengersRidingOffset() {  //FIXME
        return 0.8D;
    }

    public boolean hurt(DamageSource p_38319_, float p_38320_) {
        if (this.isInvulnerableTo(p_38319_)) {
            return false;
        } else if (!this.level.isClientSide && !this.isRemoved()) {
            this.setHurtDir(-this.getHurtDir());
            this.setHurtTime(10);
            this.setDamage(this.getDamage() + p_38320_ * 10.0F);
            this.markHurt();
            this.gameEvent(GameEvent.ENTITY_DAMAGED, p_38319_.getEntity());
            boolean flag = p_38319_.getEntity() instanceof Player && ((Player) p_38319_.getEntity()).getAbilities().instabuild;
            if (flag || this.getDamage() > 40.0F) {
                if (!flag && this.level.getGameRules().getBoolean(GameRules.RULE_DOENTITYDROPS)) {
                    this.spawnAtLocation(this.getDropItem());
                }

                this.discard();
            }

            return true;
        } else {
            return true;
        }
    }

//    public void onAboveBubbleCol(boolean p_38381_) {
//        if (!this.level.isClientSide) {
//            this.isAboveBubbleColumn = true;
//            this.bubbleColumnDirectionIsDown = p_38381_;
//            if (this.getBubbleTime() == 0) {
//                this.setBubbleTime(60);
//            }
//        }
//
//        this.level.addParticle(ParticleTypes.SPLASH, this.getX() + (double)this.random.nextFloat(), this.getY() + 0.7D, this.getZ() + (double)this.random.nextFloat(), 0.0D, 0.0D, 0.0D);
//        if (this.random.nextInt(20) == 0) {
//            this.level.playLocalSound(this.getX(), this.getY(), this.getZ(), this.getSwimSplashSound(), this.getSoundSource(), 1.0F, 0.8F + 0.4F * this.random.nextFloat(), false);
//        }
//
//        this.gameEvent(GameEvent.SPLASH, this.getControllingPassenger());
//    }

//    public void push(Entity p_38373_) {
//        if (p_38373_ instanceof Shuttle) {
//            if (p_38373_.getBoundingBox().minY < this.getBoundingBox().maxY) {
//                super.push(p_38373_);
//            }
//        } else if (p_38373_.getBoundingBox().minY <= this.getBoundingBox().minY) {
//            super.push(p_38373_);
//        }
//
//    }

    public Item getDropItem() {
        switch (this.getShuttleType()) {
            case BLACK:
                return ItemRegistry.BLACK_SHUTTLE.get();
            case GREY:
                return ItemRegistry.GREY_SHUTTLE.get();
            case LIGHT_GREY:
                return ItemRegistry.LIGHT_GREY_SHUTTLE.get();
            case WHITE:
            default:
                return ItemRegistry.WHITE_SHUTTLE.get();
            case PINK:
                return ItemRegistry.PINK_SHUTTLE.get();
            case MAGENTA:
                return ItemRegistry.MAGENTA_SHUTTLE.get();
            case RED:
                return ItemRegistry.RED_SHUTTLE.get();
            case ORANGE:
                return ItemRegistry.ORANGE_SHUTTLE.get();
            case YELLOW:
                return ItemRegistry.YELLOW_SHUTTLE.get();
            case LIME:
                return ItemRegistry.LIME_SHUTTLE.get();
            case GREEN:
                return ItemRegistry.GREEN_SHUTTLE.get();
            case CYAN:
                return ItemRegistry.CYAN_SHUTTLE.get();
            case LIGHT_BLUE:
                return ItemRegistry.LIGHT_BLUE_SHUTTLE.get();
            case BLUE:
                return ItemRegistry.BLUE_SHUTTLE.get();
            case PURPLE:
                return ItemRegistry.PURPLE_SHUTTLE.get();
        }
    }

    public void animateHurt() {
        this.setHurtDir(-this.getHurtDir());
        this.setHurtTime(10);
        this.setDamage(this.getDamage() * 11.0F);
    }

    public boolean isPickable() {
        return !this.isRemoved();
    }

    public void lerpTo(double p_38299_, double p_38300_, double p_38301_, float p_38302_, float p_38303_, int p_38304_, boolean p_38305_) {
        this.lerpX = p_38299_;
        this.lerpY = p_38300_;
        this.lerpZ = p_38301_;
        this.lerpYRot = p_38302_;
        this.lerpXRot = p_38303_;
        this.lerpSteps = 10;
    }

    public Direction getMotionDirection() {
        return this.getDirection().getClockWise();
    }

    public void tick() {
//        Status oldStatus = this.status;
        this.status = this.getStatus();
        if (this.status != Shuttle.Status.UNDER_WATER && this.status != Shuttle.Status.UNDER_FLOWING_WATER) {
            this.outOfControlTicks = 0.0F;
        } else {
            ++this.outOfControlTicks;
        }

        if (!this.level.isClientSide && this.outOfControlTicks >= 60.0F) {
            this.ejectPassengers();
        }

        if (this.getHurtTime() > 0) {
            this.setHurtTime(this.getHurtTime() - 1);
        }

        if (this.getDamage() > 0.0F) {
            this.setDamage(this.getDamage() - 1.0F);
        }

        super.tick();
        this.tickLerp();
        if (this.isControlledByLocalInstance()) {
//            if (!(this.getFirstPassenger() instanceof Player)) {
//                this.setPaddleState(false, false);
//            }

//            this.floatShuttle();
            if (this.level.isClientSide) {
                this.controlShuttle();
                this.level.sendPacketToServer(new ServerboundPaddleBoatPacket(this.getPaddleState(0), this.getPaddleState(1)));
            }

            this.move(MoverType.SELF, this.getDeltaMovement());
        } else {
            this.setDeltaMovement(Vec3.ZERO);
        }

//        this.tickBubbleColumn();

//        for(int i = 0; i <= 1; ++i) {
//            if (this.getPaddleState(i)) {
//                if (!this.isSilent() && (double)(this.paddlePositions[i] % ((float)Math.PI * 2F)) <= (double)((float)Math.PI / 4F) && (double)((this.paddlePositions[i] + ((float)Math.PI / 8F)) % ((float)Math.PI * 2F)) >= (double)((float)Math.PI / 4F)) {
//                    SoundEvent soundevent = this.getPaddleSound();
//                    if (soundevent != null) {
//                        Vec3 vec3 = this.getViewVector(1.0F);
//                        double d0 = i == 1 ? -vec3.z : vec3.z;
//                        double d1 = i == 1 ? vec3.x : -vec3.x;
//                        this.level.playSound((Player)null, this.getX() + d0, this.getY(), this.getZ() + d1, soundevent, this.getSoundSource(), 1.0F, 0.8F + 0.4F * this.random.nextFloat());
//                        this.level.gameEvent(this.getControllingPassenger(), GameEvent.SPLASH, new BlockPos(this.getX() + d0, this.getY(), this.getZ() + d1));
//                    }
//                }
//
//                this.paddlePositions[i] += ((float)Math.PI / 8F);
//            } else {
//                this.paddlePositions[i] = 0.0F;
//            }
//        }

        this.checkInsideBlocks();
        List<Entity> list = this.level.getEntities(this, this.getBoundingBox().inflate(0.2F, -0.01F, 0.2F), EntitySelector.pushableBy(this));
        if (!list.isEmpty()) {
            boolean flag = !this.level.isClientSide && !(this.getControllingPassenger() instanceof Player);

            for (Entity entity : list) {
                if (!entity.hasPassenger(this)) {
                    if (flag && this.getPassengers().size() < 2 && !entity.isPassenger() && entity.getBbWidth() < this.getBbWidth() && entity instanceof LivingEntity && !(entity instanceof WaterAnimal) && !(entity instanceof Player)) {
                        entity.startRiding(this);
                    } else {
                        this.push(entity);
                    }
                }
            }
        }

    }

//    private void tickBubbleColumn() {
//        if (this.level.isClientSide) {
//            int i = this.getBubbleTime();
//            if (i > 0) {
//                this.bubbleMultiplier += 0.05F;
//            } else {
//                this.bubbleMultiplier -= 0.1F;
//            }
//
//            this.bubbleMultiplier = Mth.clamp(this.bubbleMultiplier, 0.0F, 1.0F);
//            this.bubbleAngleO = this.bubbleAngle;
//            this.bubbleAngle = 10.0F * (float)Math.sin((double)(0.5F * (float)this.level.getGameTime())) * this.bubbleMultiplier;
//        } else {
//            if (!this.isAboveBubbleColumn) {
//                this.setBubbleTime(0);
//            }
//
//            int k = this.getBubbleTime();
//            if (k > 0) {
//                --k;
//                this.setBubbleTime(k);
//                int j = 60 - k - 1;
//                if (j > 0 && k == 0) {
//                    this.setBubbleTime(0);
//                    Vec3 vec3 = this.getDeltaMovement();
//                    if (this.bubbleColumnDirectionIsDown) {
//                        this.setDeltaMovement(vec3.add(0.0D, -0.7D, 0.0D));
//                        this.ejectPassengers();
//                    } else {
//                        this.setDeltaMovement(vec3.x, this.hasPassenger((p_150274_) -> {
//                            return p_150274_ instanceof Player;
//                        }) ? 2.7D : 0.6D, vec3.z);
//                    }
//                }
//
//                this.isAboveBubbleColumn = false;
//            }
//        }
//
//    }

//    @javax.annotation.Nullable
//    protected SoundEvent getPaddleSound() {
//        switch(this.getStatus()) {
//            case IN_WATER:
//            case UNDER_WATER:
//            case UNDER_FLOWING_WATER:
//                return SoundEvents.BOAT_PADDLE_WATER;
//            case ON_LAND:
//                return SoundEvents.BOAT_PADDLE_LAND;
//            case IN_AIR:
//            default:
//                return null;
//        }
//    }

    private void tickLerp() {
        if (this.isControlledByLocalInstance()) {
            this.lerpSteps = 0;
            this.setPacketCoordinates(this.getX(), this.getY(), this.getZ());
        }

        if (this.lerpSteps > 0) {
            double d0 = this.getX() + (this.lerpX - this.getX()) / (double) this.lerpSteps;
            double d1 = this.getY() + (this.lerpY - this.getY()) / (double) this.lerpSteps;
            double d2 = this.getZ() + (this.lerpZ - this.getZ()) / (double) this.lerpSteps;
            double d3 = Mth.wrapDegrees(this.lerpYRot - (double) this.getYRot());
            this.setYRot(this.getYRot() + (float) d3 / (float) this.lerpSteps);
            this.setXRot(this.getXRot() + (float) (this.lerpXRot - (double) this.getXRot()) / (float) this.lerpSteps);
            --this.lerpSteps;
            this.setPos(d0, d1, d2);
            this.setRot(this.getYRot(), this.getXRot());
        }
    }

//    public void setPaddleState(boolean p_38340_, boolean p_38341_) {
//        this.entityData.set(DATA_ID_PADDLE_LEFT, p_38340_);
//        this.entityData.set(DATA_ID_PADDLE_RIGHT, p_38341_);
//    }

//    public float getRowingTime(int p_38316_, float p_38317_) {
//        return this.getPaddleState(p_38316_) ? Mth.clampedLerp(this.paddlePositions[p_38316_] - ((float)Math.PI / 8F), this.paddlePositions[p_38316_], p_38317_) : 0.0F;
//    }

    private Shuttle.Status getStatus() {
        Shuttle.Status suttle$status = this.isUnderwater();
        if (suttle$status != null) {
//            double waterLevel = this.getBoundingBox().maxY;
            return suttle$status;
//        } else if (this.checkInWater()) {
//            return Shuttle.Status.IN_WATER;
        } else {
            float f = this.getGroundFriction();
            if (f > 0.0F) {
                return Shuttle.Status.ON_LAND;
            } else {
                return Shuttle.Status.IN_AIR;
            }
        }
    }

//    public float getWaterLevelAbove() {
//        AABB aabb = this.getBoundingBox();
//        int i = Mth.floor(aabb.minX);
//        int j = Mth.ceil(aabb.maxX);
//        int k = Mth.floor(aabb.maxY);
//        int l = Mth.ceil(aabb.maxY - this.lastYd);
//        int i1 = Mth.floor(aabb.minZ);
//        int j1 = Mth.ceil(aabb.maxZ);
//        BlockPos.MutableBlockPos blockpos$mutableblockpos = new BlockPos.MutableBlockPos();
//
//        label39:
//        for(int k1 = k; k1 < l; ++k1) {
//            float f = 0.0F;
//
//            for(int l1 = i; l1 < j; ++l1) {
//                for(int i2 = i1; i2 < j1; ++i2) {
//                    blockpos$mutableblockpos.set(l1, k1, i2);
//                    FluidState fluidstate = this.level.getFluidState(blockpos$mutableblockpos);
//                    if (fluidstate.is(FluidTags.WATER)) {
//                        f = Math.max(f, fluidstate.getHeight(this.level, blockpos$mutableblockpos));
//                    }
//
//                    if (f >= 1.0F) {
//                        continue label39;
//                    }
//                }
//            }
//
//            if (f < 1.0F) {
//                return (float)blockpos$mutableblockpos.getY() + f;
//            }
//        }
//
//        return (float)(l + 1);
//    }

    public float getGroundFriction() {
        AABB aabb = this.getBoundingBox();
        AABB aabb1 = new AABB(aabb.minX, aabb.minY - 0.001D, aabb.minZ, aabb.maxX, aabb.minY, aabb.maxZ);
        int i = Mth.floor(aabb1.minX) - 1;
        int j = Mth.ceil(aabb1.maxX) + 1;
        int k = Mth.floor(aabb1.minY) - 1;
        int l = Mth.ceil(aabb1.maxY) + 1;
        int i1 = Mth.floor(aabb1.minZ) - 1;
        int j1 = Mth.ceil(aabb1.maxZ) + 1;
        VoxelShape voxelshape = Shapes.create(aabb1);
        float f = 0.0F;
        int k1 = 0;
        BlockPos.MutableBlockPos blockpos$mutableblockpos = new BlockPos.MutableBlockPos();

        for (int l1 = i; l1 < j; ++l1) {
            for (int i2 = i1; i2 < j1; ++i2) {
                int j2 = (l1 != i && l1 != j - 1 ? 0 : 1) + (i2 != i1 && i2 != j1 - 1 ? 0 : 1);
                if (j2 != 2) {
                    for (int k2 = k; k2 < l; ++k2) {
                        if (j2 <= 0 || k2 != k && k2 != l - 1) {
                            blockpos$mutableblockpos.set(l1, k2, i2);
                            BlockState blockstate = this.level.getBlockState(blockpos$mutableblockpos);
                            if (!(blockstate.getBlock() instanceof WaterlilyBlock) && Shapes.joinIsNotEmpty(blockstate.getCollisionShape(this.level, blockpos$mutableblockpos).move(l1, k2, i2), voxelshape, BooleanOp.AND)) {
                                f += blockstate.getFriction(this.level, blockpos$mutableblockpos, this);
                                ++k1;
                            }
                        }
                    }
                }
            }
        }

        return f / (float) k1;
//        return 0;
    }

//    private boolean checkInWater() {
//        AABB aabb = this.getBoundingBox();
//        int i = Mth.floor(aabb.minX);
//        int j = Mth.ceil(aabb.maxX);
//        int k = Mth.floor(aabb.minY);
//        int l = Mth.ceil(aabb.minY + 0.001D);
//        int i1 = Mth.floor(aabb.minZ);
//        int j1 = Mth.ceil(aabb.maxZ);
//        boolean flag = false;
//        this.waterLevel = -Double.MAX_VALUE;
//        BlockPos.MutableBlockPos blockpos$mutableblockpos = new BlockPos.MutableBlockPos();
//
//        for(int k1 = i; k1 < j; ++k1) {
//            for(int l1 = k; l1 < l; ++l1) {
//                for(int i2 = i1; i2 < j1; ++i2) {
//                    blockpos$mutableblockpos.set(k1, l1, i2);
//                    FluidState fluidstate = this.level.getFluidState(blockpos$mutableblockpos);
//                    if (fluidstate.is(FluidTags.WATER)) {
//                        float f = (float)l1 + fluidstate.getHeight(this.level, blockpos$mutableblockpos);
//                        this.waterLevel = Math.max((double)f, this.waterLevel);
//                        flag |= aabb.minY < (double)f;
//                    }
//                }
//            }
//        }
//
//        return flag;
//    }

    @javax.annotation.Nullable
    private Shuttle.Status isUnderwater() {
        AABB aabb = this.getBoundingBox();
        double d0 = aabb.maxY + 0.001D;
        int i = Mth.floor(aabb.minX);
        int j = Mth.ceil(aabb.maxX);
        int k = Mth.floor(aabb.maxY);
        int l = Mth.ceil(d0);
        int i1 = Mth.floor(aabb.minZ);
        int j1 = Mth.ceil(aabb.maxZ);
        boolean flag = false;
        BlockPos.MutableBlockPos blockpos$mutableblockpos = new BlockPos.MutableBlockPos();

        for (int k1 = i; k1 < j; ++k1) {
            for (int l1 = k; l1 < l; ++l1) {
                for (int i2 = i1; i2 < j1; ++i2) {
                    blockpos$mutableblockpos.set(k1, l1, i2);
                    FluidState fluidstate = this.level.getFluidState(blockpos$mutableblockpos);
                    if (fluidstate.is(FluidTags.WATER) && d0 < (double) ((float) blockpos$mutableblockpos.getY() + fluidstate.getHeight(this.level, blockpos$mutableblockpos))) {
                        if (!fluidstate.isSource()) {
                            return Shuttle.Status.UNDER_FLOWING_WATER;
                        }

                        flag = true;
                    }
                }
            }
        }

        return flag ? Shuttle.Status.UNDER_WATER : null;
    }

//    private void floatShuttle() {
//        double d0 = (double)-0.04F;
//        double d1 = this.isNoGravity() ? 0.0D : (double)-0.04F;
//        double d2 = 0.0D;
//        this.invFriction = 0.05F;
//        if (this.oldStatus == Shuttle.Status.IN_AIR && this.status != Shuttle.Status.IN_AIR && this.status != Shuttle.Status.ON_LAND) {
//            this.waterLevel = this.getY(1.0D);
//            this.setPos(this.getX(), (double)(this.getWaterLevelAbove() - this.getBbHeight()) + 0.101D, this.getZ());
//            this.setDeltaMovement(this.getDeltaMovement().multiply(1.0D, 0.0D, 1.0D));
//            this.lastYd = 0.0D;
//            this.status = Shuttle.Status.IN_WATER;
//        } else {
//            if (this.status == Shuttle.Status.IN_WATER) {
//                d2 = (this.waterLevel - this.getY()) / (double)this.getBbHeight();
//                this.invFriction = 0.9F;
//            } else if (this.status == Shuttle.Status.UNDER_FLOWING_WATER) {
//                d1 = -7.0E-4D;
//                this.invFriction = 0.9F;
//            } else if (this.status == Shuttle.Status.UNDER_WATER) {
//                d2 = (double)0.01F;
//                this.invFriction = 0.45F;
//            } else if (this.status == Shuttle.Status.IN_AIR) {
//                this.invFriction = 0.9F;
//            } else if (this.status == Shuttle.Status.ON_LAND) {
//                this.invFriction = this.landFriction;
//                if (this.getControllingPassenger() instanceof Player) {
//                    this.landFriction /= 2.0F;
//                }
//            }
//
//            Vec3 vec3 = this.getDeltaMovement();
//            this.setDeltaMovement(vec3.x * (double)this.invFriction, vec3.y + d1, vec3.z * (double)this.invFriction);
//            this.deltaRotation *= this.invFriction;
//            if (d2 > 0.0D) {
//                Vec3 vec31 = this.getDeltaMovement();
//                this.setDeltaMovement(vec31.x, (vec31.y + d2 * 0.06153846016296973D) * 0.75D, vec31.z);
//            }
//        }
//
//    }

    private void controlShuttle() {
        if (this.isVehicle()) {

            LivingEntity livingentity = (LivingEntity) this.getControllingPassenger();
            this.setYRot(livingentity.getYRot());
            this.yRotO = this.getYRot();
            this.setXRot(livingentity.getXRot() * 0.5F);
            this.setRot(this.getYRot(), this.getXRot());
            float f = livingentity.zza * SHUTTLE_SPEED;

            if (livingentity.xxa > 0) {
                --this.deltaRotation;
            }

            if (livingentity.xxa < 0) {
                ++this.deltaRotation;
            }
            float f1;

//            if (livingentity.getDeltaMovement().y > 0) {
            if (Keybinds.ASCEND_KEY.isDown()) {
                f1 = SHUTTLE_SPEED;
            } else if (Keybinds.DESCEND_KEY.isDown()) {
                f1 = -1 * SHUTTLE_SPEED;
            }
//            else if (livingentity.getDeltaMovement().y < 0) {
//                f1 = -0.5F;
//            }
            else {
                f1 = 0;
            }
//
            this.setDeltaMovement((Mth.sin(-this.getYRot() * ((float) Math.PI / 180F)) * f), f1, (Mth.cos(this.getYRot() * ((float) Math.PI / 180F)) * f));
//            this.setDeltaMovement(this.getDeltaMovement().add((double)(Mth.sin(-this.getYRot() * ((float)Math.PI / 180F)) * f), f1, (double)(Mth.cos(this.getYRot() * ((float)Math.PI / 180F)) * f)));
//            this.setPaddleState(this.inputRight && !this.inputLeft || this.inputUp, this.inputLeft && !this.inputRight || this.inputUp);
        }
    }

    public void positionRider(Entity p_38379_) { //FIXME
        if (this.hasPassenger(p_38379_)) {
            float f = 4.0F;
            float f1 = (float) ((this.isRemoved() ? (double) 0.01F : this.getPassengersRidingOffset()) + p_38379_.getMyRidingOffset());
            if (this.getPassengers().size() > 1) {
                int i = this.getPassengers().indexOf(p_38379_);
                if (i == 0) {
                    f = 0.2F;
                } else {
                    f = -0.6F;
                }

                if (p_38379_ instanceof Animal) {
                    f += 0.2F;
                }
            }

            Vec3 vec3 = (new Vec3(f, 0.0D, 0.0D)).yRot(-this.getYRot() * ((float) Math.PI / 180F) - ((float) Math.PI / 2F));
            p_38379_.setPos(this.getX() + vec3.x, this.getY() + (double) f1, this.getZ() + vec3.z);
            p_38379_.setYRot(p_38379_.getYRot() + this.deltaRotation);
            p_38379_.setYHeadRot(p_38379_.getYHeadRot() + this.deltaRotation);
            this.clampRotation(p_38379_);
            if (p_38379_ instanceof Animal && this.getPassengers().size() > 1) {
                int j = p_38379_.getId() % 2 == 0 ? 90 : 270;
                p_38379_.setYBodyRot(((Animal) p_38379_).yBodyRot + (float) j);
                p_38379_.setYHeadRot(p_38379_.getYHeadRot() + (float) j);
            }

        }
    }

    public Vec3 getDismountLocationForPassenger(LivingEntity p_38357_) { //FIXME
        Vec3 vec3 = getCollisionHorizontalEscapeVector((this.getBbWidth() * Mth.SQRT_OF_TWO), p_38357_.getBbWidth(), p_38357_.getYRot());
        double d0 = this.getX() + vec3.x;
        double d1 = this.getZ() + vec3.z;
        BlockPos blockpos = new BlockPos(d0, this.getBoundingBox().maxY, d1);
        BlockPos blockpos1 = blockpos.below();
        if (!this.level.isWaterAt(blockpos1)) {
            List<Vec3> list = Lists.newArrayList();
            double d2 = this.level.getBlockFloorHeight(blockpos);
            if (DismountHelper.isBlockFloorValid(d2)) {
                list.add(new Vec3(d0, (double) blockpos.getY() + d2, d1));
            }

            double d3 = this.level.getBlockFloorHeight(blockpos1);
            if (DismountHelper.isBlockFloorValid(d3)) {
                list.add(new Vec3(d0, (double) blockpos1.getY() + d3, d1));
            }

            for (Pose pose : p_38357_.getDismountPoses()) {
                for (Vec3 vec31 : list) {
                    if (DismountHelper.canDismountTo(this.level, vec31, p_38357_, pose)) {
                        p_38357_.setPose(pose);
                        return vec31;
                    }
                }
            }
        }

        return super.getDismountLocationForPassenger(p_38357_);
    }

    protected void clampRotation(Entity p_38322_) {
        p_38322_.setYBodyRot(this.getYRot());
        float f = Mth.wrapDegrees(p_38322_.getYRot() - this.getYRot());
        float f1 = Mth.clamp(f, -105.0F, 105.0F);
        p_38322_.yRotO += f1 - f;
        p_38322_.setYRot(p_38322_.getYRot() + f1 - f);
        p_38322_.setYHeadRot(p_38322_.getYRot());
    }

    public void onPassengerTurned(Entity p_38383_) {
        this.clampRotation(p_38383_);
    }

    protected void addAdditionalSaveData(CompoundTag p_38359_) {
        p_38359_.putString("Type", this.getShuttleType().getName());
        ListTag listtag = new ListTag();

        for(int i = 2; i < this.inventory.getContainerSize(); ++i) {
            ItemStack itemstack = this.inventory.getItem(i);
            if (!itemstack.isEmpty()) {
                CompoundTag compoundtag = new CompoundTag();
                compoundtag.putByte("Slot", (byte)i);
                itemstack.save(compoundtag);
                listtag.add(compoundtag);
            }
        }

        p_38359_.put("Items", listtag);

    }

    protected void readAdditionalSaveData(CompoundTag p_38338_) {
        if (p_38338_.contains("Type", 8)) {
            this.setType(Shuttle.Type.byName(p_38338_.getString("Type")));
        }
        ListTag listtag = p_38338_.getList("Items", 10);

        this.createInventory();
        for(int i = 0; i < listtag.size(); ++i) {
            CompoundTag compoundtag = listtag.getCompound(i);
            int j = compoundtag.getByte("Slot") & 255;
            if (j >= 2 && j < this.inventory.getContainerSize()) {
                this.inventory.setItem(j, ItemStack.of(compoundtag));
            }
        }

    }

    protected int getInventorySize() {
        return 29;
    }

    protected void createInventory() {
        SimpleContainer simplecontainer = this.inventory;
        this.inventory = new SimpleContainer(this.getInventorySize());
        if (simplecontainer != null) {
            simplecontainer.removeListener(this);
            int i = Math.min(simplecontainer.getContainerSize(), this.inventory.getContainerSize());

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

    protected boolean getFlag(int p_30648_) {
        return (this.entityData.get(DATA_ID_FLAGS) & p_30648_) != 0;
    }

    protected void setFlag(int p_30598_, boolean p_30599_) {
        byte b0 = this.entityData.get(DATA_ID_FLAGS);
        if (p_30599_) {
            this.entityData.set(DATA_ID_FLAGS, (byte)(b0 | p_30598_));
        } else {
            this.entityData.set(DATA_ID_FLAGS, (byte)(b0 & ~p_30598_));
        }

    }

    protected void updateContainerEquipment() {
        if (!this.level.isClientSide) {
            this.setFlag(4, !this.inventory.getItem(0).isEmpty());
        }
    }

    private SlotAccess createEquipmentSlotAccess(final int p_149503_, final Predicate<ItemStack> p_149504_) {
        return new SlotAccess() {
            public ItemStack get() {
                return Shuttle.this.inventory.getItem(p_149503_);
            }

            public boolean set(ItemStack p_149528_) {
                if (!p_149504_.test(p_149528_)) {
                    return false;
                } else {
                    Shuttle.this.inventory.setItem(p_149503_, p_149528_);
                    Shuttle.this.updateContainerEquipment();
                    return true;
                }
            }
        };
    }

    public SlotAccess getSlot(int p_149479_) {
        return p_149479_ == 499 ? new SlotAccess() {
            public ItemStack get() {
                return new ItemStack(Items.CHEST);
            }

            public boolean set(ItemStack p_149485_) {
                if (p_149485_.isEmpty()) {
//                    if (AbstractChestedHorse.this.hasChest()) {
//                        AbstractChestedHorse.this.setChest(false);
                        Shuttle.this.createInventory();
//                    }

                    return true;
                } else if (p_149485_.is(Items.CHEST)) {
//                    if (!AbstractChestedHorse.this.hasChest()) {
//                        AbstractChestedHorse.this.setChest(true);
                        Shuttle.this.createInventory();
//                    }

                    return true;
                } else {
                    return false;
                }
            }
        } : this.getSlotSuper(p_149479_);
    }

    public SlotAccess getSlotSuper(int p_149514_) {
        int i = p_149514_ - 400;
        if (i >= 0 && i < 2 && i < this.inventory.getContainerSize()) {
            if (i == 0) {
                return this.createEquipmentSlotAccess(i, (p_149518_) -> {
                    return p_149518_.isEmpty() || p_149518_.is(Items.SADDLE);
                });
            }

            if (i == 1) {
//                if (!this.canWearArmor()) {
//                    return SlotAccess.NULL;
//                }

                return this.createEquipmentSlotAccess(i, (p_149516_) -> {
                    return p_149516_.isEmpty(); // || this.isArmor(p_149516_);
                });
            }
        }

        int j = p_149514_ - 500 + 2;
        return j >= 2 && j < this.inventory.getContainerSize() ? SlotAccess.forContainer(this.inventory, j) : super.getSlot(p_149514_);
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

//    public boolean hasInventoryChanged(Container p_149512_) {
//        return this.inventory != p_149512_;
//    }
//
//    public int getInventoryColumns() {
//        return 5;
//    }

    public InteractionResult interact(Player player, InteractionHand hand) {

        if (player.isSecondaryUseActive()) {

            if (player instanceof ServerPlayer) {
                NetworkHooks.openGui((ServerPlayer)player, this, buf -> buf.writeInt(this.getId()));
            }
            return InteractionResult.sidedSuccess(this.level.isClientSide());

        } else if (this.outOfControlTicks < 60.0F) {
            if (!this.level.isClientSide) {
                return player.startRiding(this) ? InteractionResult.CONSUME : InteractionResult.PASS;
            } else {
                return InteractionResult.SUCCESS;
            }
        } else {
            return InteractionResult.PASS;
        }
    }

    protected void checkFallDamage(double p_38307_, boolean p_38308_, BlockState p_38309_, BlockPos p_38310_) {
//        double lastYd = this.getDeltaMovement().y;
        if (!this.isPassenger()) {
            if (p_38308_) {
                if (this.fallDistance > 3.0F) {
                    if (this.status != Shuttle.Status.ON_LAND) {
                        this.resetFallDistance();
                        return;
                    }

                    this.causeFallDamage(this.fallDistance, 1.0F, DamageSource.FALL);
                    if (!this.level.isClientSide && !this.isRemoved()) {
                        this.kill();
                        if (this.level.getGameRules().getBoolean(GameRules.RULE_DOENTITYDROPS)) {
                            for (int i = 0; i < 3; ++i) {
                                this.spawnAtLocation(this.getShuttleType().getDye());
                            }

                            for (int j = 0; j < 2; ++j) {
                                this.spawnAtLocation(Items.STICK);
                            }
                        }
                    }
                }

                this.resetFallDistance();
            } else if (!this.level.getFluidState(this.blockPosition().below()).is(FluidTags.WATER) && p_38307_ < 0.0D) {
                this.fallDistance -= (float) p_38307_;
            }

        }
    }

    public boolean getPaddleState(int p_38314_) {
        return this.entityData.<Boolean>get(p_38314_ == 0 ? DATA_ID_PADDLE_LEFT : DATA_ID_PADDLE_RIGHT) && this.getControllingPassenger() != null;
    }

    public void setDamage(float p_38312_) {
        this.entityData.set(DATA_ID_DAMAGE, p_38312_);
    }

    public float getDamage() {
        return this.entityData.get(DATA_ID_DAMAGE);
    }

    public void setHurtTime(int p_38355_) {
        this.entityData.set(DATA_ID_HURT, p_38355_);
    }

    public int getHurtTime() {
        return this.entityData.get(DATA_ID_HURT);
    }

    public void setHurtDir(int p_38363_) {
        this.entityData.set(DATA_ID_HURTDIR, p_38363_);
    }

    public int getHurtDir() {
        return this.entityData.get(DATA_ID_HURTDIR);
    }

    public void setType(Shuttle.Type p_38333_) {
        this.entityData.set(DATA_ID_TYPE, p_38333_.ordinal());
    }

    public Shuttle.Type getShuttleType() {
        return Shuttle.Type.byId(this.entityData.get(DATA_ID_TYPE));
    }

    protected boolean canAddPassenger(Entity p_38390_) {
        return this.getPassengers().size() < 2 && !this.isEyeInFluid(FluidTags.WATER);
    }

    @Nullable
    public Entity getControllingPassenger() {
        return this.getFirstPassenger();
    }

    public Packet<?> getAddEntityPacket() {
        return new ClientboundAddEntityPacket(this);
    }

    public boolean isUnderWater() {
        return this.status == Shuttle.Status.UNDER_WATER || this.status == Shuttle.Status.UNDER_FLOWING_WATER;
    }

    // Forge: Fix MC-119811 by instantly completing lerp on board
    @Override
    protected void addPassenger(Entity passenger) {
        super.addPassenger(passenger);
        if (this.isControlledByLocalInstance() && this.lerpSteps > 0) {
            this.lerpSteps = 0;
            this.absMoveTo(this.lerpX, this.lerpY, this.lerpZ, (float) this.lerpYRot, (float) this.lerpXRot);
        }
    }


    public enum Status {
        IN_WATER,
        UNDER_WATER,
        UNDER_FLOWING_WATER,
        ON_LAND,
        IN_AIR
    }

    public enum Type {
        BLACK(Items.BLACK_DYE, "black"),
        GREY(Items.GRAY_DYE, "grey"),
        LIGHT_GREY(Items.LIGHT_GRAY_DYE, "light_grey"),
        WHITE(Items.WHITE_DYE, "white"),
        PINK(Items.PINK_DYE, "pink"),
        MAGENTA(Items.MAGENTA_DYE, "magenta"),
        RED(Items.RED_DYE, "red"),
        BROWN(Items.BROWN_DYE, "brown"),
        ORANGE(Items.ORANGE_DYE, "orange"),
        YELLOW(Items.YELLOW_DYE, "yellow"),
        LIME(Items.LIME_DYE, "lime"),
        GREEN(Items.GREEN_DYE, "green"),
        CYAN(Items.CYAN_DYE, "cyan"),
        LIGHT_BLUE(Items.LIGHT_BLUE_DYE, "light_blue"),
        BLUE(Items.RED_DYE, "blue"),
        PURPLE(Items.RED_DYE, "purple");

        private final String name;
        private final Item dye;

        Type(Item dye, String name) {
            this.name = name;
            this.dye = dye;
        }

        public String getName() {
            return this.name;
        }

        public Item getDye() {
            return this.dye;
        }

        public String toString() {
            return this.name;
        }

        public static Shuttle.Type byId(int p_38431_) {
            Shuttle.Type[] shuttle$type = values();
            if (p_38431_ < 0 || p_38431_ >= shuttle$type.length) {
                p_38431_ = 0;
            }

            return shuttle$type[p_38431_];
        }

        public static Shuttle.Type byName(String p_38433_) {
            Shuttle.Type[] shuttle$type = values();

            for (Type type : shuttle$type) {
                if (type.getName().equals(p_38433_)) {
                    return type;
                }
            }

            return shuttle$type[0];
        }
    }
}
