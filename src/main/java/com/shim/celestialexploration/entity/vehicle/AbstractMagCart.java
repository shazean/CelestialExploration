package com.shim.celestialexploration.entity.vehicle;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.mojang.datafixers.util.Pair;
import com.shim.celestialexploration.blocks.BaseMagRailBlock;
import com.shim.celestialexploration.blocks.PoweredMagRailBlock;
import com.shim.celestialexploration.registry.BlockRegistry;
import com.shim.celestialexploration.registry.ItemRegistry;
import net.minecraft.BlockUtil;
import net.minecraft.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Vec3i;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.NbtUtils;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientboundAddEntityPacket;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.entity.vehicle.DismountHelper;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.RailShape;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Map;

public abstract class  AbstractMagCart extends Entity implements IAbstractMagCart {
    private static final EntityDataAccessor<Integer> DATA_ID_HURT = SynchedEntityData.defineId(AbstractMagCart.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Integer> DATA_ID_HURTDIR = SynchedEntityData.defineId(AbstractMagCart.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Float> DATA_ID_DAMAGE = SynchedEntityData.defineId(AbstractMagCart.class, EntityDataSerializers.FLOAT);
    private static final EntityDataAccessor<Integer> DATA_ID_DISPLAY_BLOCK = SynchedEntityData.defineId(AbstractMagCart.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Integer> DATA_ID_DISPLAY_OFFSET = SynchedEntityData.defineId(AbstractMagCart.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Boolean> DATA_ID_CUSTOM_DISPLAY = SynchedEntityData.defineId(AbstractMagCart.class, EntityDataSerializers.BOOLEAN);
    private static final ImmutableMap<Pose, ImmutableList<Integer>> POSE_DISMOUNT_HEIGHTS = ImmutableMap.of(Pose.STANDING, ImmutableList.of(0, 1, -1), Pose.CROUCHING, ImmutableList.of(0, 1, -1), Pose.SWIMMING, ImmutableList.of(0, 1));
    protected static final float WATER_SLOWDOWN_FACTOR = 0.95F;
    private boolean flipped;
    private static final Map<RailShape, Pair<Vec3i, Vec3i>> EXITS = Util.make(Maps.newEnumMap(RailShape.class), (p_38135_) -> {
        Vec3i vec3i = Direction.WEST.getNormal();
        Vec3i vec3i1 = Direction.EAST.getNormal();
        Vec3i vec3i2 = Direction.NORTH.getNormal();
        Vec3i vec3i3 = Direction.SOUTH.getNormal();
        Vec3i vec3i4 = vec3i.below();
        Vec3i vec3i5 = vec3i1.below();
        Vec3i vec3i6 = vec3i2.below();
        Vec3i vec3i7 = vec3i3.below();
        p_38135_.put(RailShape.NORTH_SOUTH, Pair.of(vec3i2, vec3i3));
        p_38135_.put(RailShape.EAST_WEST, Pair.of(vec3i, vec3i1));
        p_38135_.put(RailShape.ASCENDING_EAST, Pair.of(vec3i4, vec3i1));
        p_38135_.put(RailShape.ASCENDING_WEST, Pair.of(vec3i, vec3i5));
        p_38135_.put(RailShape.ASCENDING_NORTH, Pair.of(vec3i2, vec3i7));
        p_38135_.put(RailShape.ASCENDING_SOUTH, Pair.of(vec3i6, vec3i3));
        p_38135_.put(RailShape.SOUTH_EAST, Pair.of(vec3i3, vec3i1));
        p_38135_.put(RailShape.SOUTH_WEST, Pair.of(vec3i3, vec3i));
        p_38135_.put(RailShape.NORTH_WEST, Pair.of(vec3i2, vec3i));
        p_38135_.put(RailShape.NORTH_EAST, Pair.of(vec3i2, vec3i1));
    });
    private static IMagCartCollisionHandler COLLISIONS = null;
    private int lSteps;
    private double lx;
    private double ly;
    private double lz;
    private double lyr;
    private double lxr;
    private double lxd;
    private double lyd;
    private double lzd;
    private boolean canBePushed = true;

    protected AbstractMagCart(EntityType<?> type, Level level) {
        super(type, level);
        this.blocksBuilding = true;
    }

    protected AbstractMagCart(EntityType<?> type, Level level, double x, double y, double z) {
        this(type, level);
        this.setPos(x, y, z);
        this.xo = x;
        this.yo = y;
        this.zo = z;
    }

    public IMagCartCollisionHandler getCollisionHandler() {
        return COLLISIONS;
    }

    public static void registerCollisionHandler(@Nullable IMagCartCollisionHandler handler) {
        COLLISIONS = handler;
    }

    public static AbstractMagCart createMagCart(Level level, double x, double y, double z, AbstractMagCart.Type type) {
        if (type == AbstractMagCart.Type.CHEST) {
            return new MagCartChest(level, x, y, z);
        } else if (type == AbstractMagCart.Type.FURNACE) {
            return new MagCartFurnace(level, x, y, z);
        } else if (type == AbstractMagCart.Type.TNT) {
            return new MagCartTNT(level, x, y, z);
        } else if (type == AbstractMagCart.Type.SPAWNER) {
            return new MagCartSpawner(level, x, y, z);
        } else if (type == AbstractMagCart.Type.HOPPER) {
            return new MagCartHopper(level, x, y, z);
        } else {
            return (AbstractMagCart)(type == AbstractMagCart.Type.COMMAND_BLOCK ? new MagCartCommandBlock(level, x, y, z) : new MagCart(level, x, y, z));
        }
//        return new MagCart(level, x, y, z);
    }

    protected Entity.MovementEmission getMovementEmission() {
        return Entity.MovementEmission.EVENTS;
    }

    protected void defineSynchedData() {
        this.entityData.define(DATA_ID_HURT, 0);
        this.entityData.define(DATA_ID_HURTDIR, 1);
        this.entityData.define(DATA_ID_DAMAGE, 0.0F);
        this.entityData.define(DATA_ID_DISPLAY_BLOCK, Block.getId(Blocks.AIR.defaultBlockState()));
        this.entityData.define(DATA_ID_DISPLAY_OFFSET, 6);
        this.entityData.define(DATA_ID_CUSTOM_DISPLAY, false);
    }

    public boolean canCollideWith(Entity entity) {
        return Boat.canVehicleCollide(this, entity);
    }

    public boolean isPushable() {
        return canBePushed;
    }

    protected Vec3 getRelativePortalPosition(Direction.Axis axis, BlockUtil.FoundRectangle p_38133_) {
        return LivingEntity.resetForwardDirectionOfRelativePortalPosition(super.getRelativePortalPosition(axis, p_38133_));
    }

    public double getPassengersRidingOffset() {
        return 0.0D;
    }

    public Vec3 getDismountLocationForPassenger(LivingEntity passenger) {
        Direction direction = this.getMotionDirection();
        if (direction.getAxis() == Direction.Axis.Y) {
            return super.getDismountLocationForPassenger(passenger);
        } else {
            int[][] aint = DismountHelper.offsetsForDirection(direction);
            BlockPos blockpos = this.blockPosition();
            BlockPos.MutableBlockPos blockpos$mutableblockpos = new BlockPos.MutableBlockPos();
            ImmutableList<Pose> immutablelist = passenger.getDismountPoses();

            for(Pose pose : immutablelist) {
                EntityDimensions entitydimensions = passenger.getDimensions(pose);
                float f = Math.min(entitydimensions.width, 1.0F) / 2.0F;

                for(int i : POSE_DISMOUNT_HEIGHTS.get(pose)) {
                    for(int[] aint1 : aint) {
                        blockpos$mutableblockpos.set(blockpos.getX() + aint1[0], blockpos.getY() + i, blockpos.getZ() + aint1[1]);
                        double d0 = this.level.getBlockFloorHeight(DismountHelper.nonClimbableShape(this.level, blockpos$mutableblockpos), () -> {
                            return DismountHelper.nonClimbableShape(this.level, blockpos$mutableblockpos.below());
                        });
                        if (DismountHelper.isBlockFloorValid(d0)) {
                            AABB aabb = new AABB((double)(-f), 0.0D, (double)(-f), (double)f, (double)entitydimensions.height, (double)f);
                            Vec3 vec3 = Vec3.upFromBottomCenterOf(blockpos$mutableblockpos, d0);
                            if (DismountHelper.canDismountTo(this.level, passenger, aabb.move(vec3))) {
                                passenger.setPose(pose);
                                return vec3;
                            }
                        }
                    }
                }
            }

            double d1 = this.getBoundingBox().maxY;
            blockpos$mutableblockpos.set((double)blockpos.getX(), d1, (double)blockpos.getZ());

            for(Pose pose1 : immutablelist) {
                double d2 = (double)passenger.getDimensions(pose1).height;
                int j = Mth.ceil(d1 - (double)blockpos$mutableblockpos.getY() + d2);
                double d3 = DismountHelper.findCeilingFrom(blockpos$mutableblockpos, j, (p_38149_) -> {
                    return this.level.getBlockState(p_38149_).getCollisionShape(this.level, p_38149_);
                });
                if (d1 + d2 <= d3) {
                    passenger.setPose(pose1);
                    break;
                }
            }

            return super.getDismountLocationForPassenger(passenger);
        }
    }

    public boolean hurt(DamageSource source, float p_38118_) {
        if (!this.level.isClientSide && !this.isRemoved()) {
            if (this.isInvulnerableTo(source)) {
                return false;
            } else {
                this.setHurtDir(-this.getHurtDir());
                this.setHurtTime(10);
                this.markHurt();
                this.setDamage(this.getDamage() + p_38118_ * 10.0F);
                this.gameEvent(GameEvent.ENTITY_DAMAGED, source.getEntity());
                boolean flag = source.getEntity() instanceof Player && ((Player)source.getEntity()).getAbilities().instabuild;
                if (flag || this.getDamage() > 40.0F) {
                    this.ejectPassengers();
                    if (flag && !this.hasCustomName()) {
                        this.discard();
                    } else {
                        this.destroy(source);
                    }
                }

                return true;
            }
        } else {
            return true;
        }
    }

    protected float getBlockSpeedFactor() {
        BlockState blockstate = this.level.getBlockState(this.blockPosition());
        return blockstate.is(BlockRegistry.MAG_RAIL_TAG) ? 1.0F : super.getBlockSpeedFactor();
    }

    public void destroy(DamageSource source) {
        this.remove(Entity.RemovalReason.KILLED);
        if (this.level.getGameRules().getBoolean(GameRules.RULE_DOENTITYDROPS)) {
            ItemStack itemstack = new ItemStack(ItemRegistry.MAGCART.get());
            if (this.hasCustomName()) {
                itemstack.setHoverName(this.getCustomName());
            }

            this.spawnAtLocation(itemstack);
        }

    }

    public void animateHurt() {
        this.setHurtDir(-this.getHurtDir());
        this.setHurtTime(10);
        this.setDamage(this.getDamage() + this.getDamage() * 10.0F);
    }

    public boolean isPickable() {
        return !this.isRemoved();
    }

    private static Pair<Vec3i, Vec3i> exits(RailShape shape) {
        return EXITS.get(shape);
    }

    public Direction getMotionDirection() {
        return this.flipped ? this.getDirection().getOpposite().getClockWise() : this.getDirection().getClockWise();
    }

    public void tick() {
        if (this.getHurtTime() > 0) {
            this.setHurtTime(this.getHurtTime() - 1);
        }

        if (this.getDamage() > 0.0F) {
            this.setDamage(this.getDamage() - 1.0F);
        }

        this.checkOutOfWorld();
        this.handleNetherPortal();
        if (this.level.isClientSide) {
            if (this.lSteps > 0) {
                double d5 = this.getX() + (this.lx - this.getX()) / (double)this.lSteps;
                double d6 = this.getY() + (this.ly - this.getY()) / (double)this.lSteps;
                double d7 = this.getZ() + (this.lz - this.getZ()) / (double)this.lSteps;
                double d2 = Mth.wrapDegrees(this.lyr - (double)this.getYRot());
                this.setYRot(this.getYRot() + (float)d2 / (float)this.lSteps);
                this.setXRot(this.getXRot() + (float)(this.lxr - (double)this.getXRot()) / (float)this.lSteps);
                --this.lSteps;
                this.setPos(d5, d6, d7);
                this.setRot(this.getYRot(), this.getXRot());
            } else {
                this.reapplyPosition();
                this.setRot(this.getYRot(), this.getXRot());
            }

        } else {
            if (!this.isNoGravity()) {
                double d0 = this.isInWater() ? -0.005D : -0.04D;
                this.setDeltaMovement(this.getDeltaMovement().add(0.0D, d0, 0.0D));
            }

            int k = Mth.floor(this.getX());
            int i = Mth.floor(this.getY());
            int j = Mth.floor(this.getZ());
            if (this.level.getBlockState(new BlockPos(k, i - 1, j)).is(BlockRegistry.MAG_RAIL_TAG)) {
                --i;
            }

            BlockPos blockpos = new BlockPos(k, i, j);
            BlockState blockstate = this.level.getBlockState(blockpos);
            if (canUseRail() && BaseMagRailBlock.isRail(blockstate)) {
                this.moveAlongTrack(blockpos, blockstate);
                if (blockstate.getBlock() instanceof PoweredMagRailBlock && ((PoweredMagRailBlock) blockstate.getBlock()).isActivatorRail()) {
                    this.activateMagCart(k, i, j, blockstate.getValue(PoweredMagRailBlock.POWERED));
                }
            } else {
                this.comeOffTrack();
            }

            this.checkInsideBlocks();
            this.setXRot(0.0F);
            double d1 = this.xo - this.getX();
            double d3 = this.zo - this.getZ();
            if (d1 * d1 + d3 * d3 > 0.001D) {
                this.setYRot((float)(Mth.atan2(d3, d1) * 180.0D / Math.PI));
                if (this.flipped) {
                    this.setYRot(this.getYRot() + 180.0F);
                }
            }

            double d4 = (double)Mth.wrapDegrees(this.getYRot() - this.yRotO);
            if (d4 < -170.0D || d4 >= 170.0D) {
                this.setYRot(this.getYRot() + 180.0F);
                this.flipped = !this.flipped;
            }


            this.setRot(this.getYRot(), this.getXRot());
            AABB box;
            if (getCollisionHandler() != null) box = getCollisionHandler().getMinecartCollisionBox(this);
            else box = this.getBoundingBox().inflate(0.2F, 0.0D, 0.2F);
            if (canBeRidden() && this.getDeltaMovement().horizontalDistanceSqr() > 0.01D) {
                List<Entity> list = this.level.getEntities(this, box, EntitySelector.pushableBy(this));
                if (!list.isEmpty()) {
                    for (Entity entity1 : list) {
                        if (!(entity1 instanceof Player) && !(entity1 instanceof IronGolem) && !(entity1 instanceof AbstractMagCart) && !this.isVehicle() && !entity1.isPassenger()) {
                            entity1.startRiding(this);
                        } else {
                            entity1.push(this);
                        }
                    }
                }
            } else {
                for(Entity entity : this.level.getEntities(this, box)) {
                    if (!this.hasPassenger(entity) && entity.isPushable() && entity instanceof AbstractMagCart) {
                        entity.push(this);
                    }
                }
            }

            this.updateInWaterStateAndDoFluidPushing();
            if (this.isInLava()) {
                this.lavaHurt();
                this.fallDistance *= 0.5F;
            }

            this.firstTick = false;
        }
    }

    protected double getMaxSpeed() {
        return (this.isInWater() ? 4.0D : 8.0D) / 15.0D; //20.0
    }

    public void activateMagCart(int p_38111_, int p_38112_, int p_38113_, boolean p_38114_) {
    }

    protected void comeOffTrack() {
        double d0 = onGround ? this.getMaxSpeed() : getMaxSpeedAirLateral();
        Vec3 vec3 = this.getDeltaMovement();
        this.setDeltaMovement(Mth.clamp(vec3.x, -d0, d0), vec3.y, Mth.clamp(vec3.z, -d0, d0));
        if (this.onGround) {
            this.setDeltaMovement(this.getDeltaMovement().scale(0.5D));
        }

        if (getMaxSpeedAirVertical() > 0 && getDeltaMovement().y > getMaxSpeedAirVertical()) {
            if(Math.abs(getDeltaMovement().x) < 0.3f && Math.abs(getDeltaMovement().z) < 0.3f)
                setDeltaMovement(new Vec3(getDeltaMovement().x, 0.15f, getDeltaMovement().z));
            else
                setDeltaMovement(new Vec3(getDeltaMovement().x, getMaxSpeedAirVertical(), getDeltaMovement().z));
        }

        this.move(MoverType.SELF, this.getDeltaMovement());
        if (!this.onGround) {
            this.setDeltaMovement(this.getDeltaMovement().scale(getDragAir()));
        }

    }

    protected void moveAlongTrack(BlockPos p_38156_, BlockState p_38157_) {
        this.resetFallDistance();
        double d0 = this.getX();
        double d1 = this.getY();
        double d2 = this.getZ();
        Vec3 vec3 = this.getPos(d0, d1, d2);
        d1 = (double)p_38156_.getY();
        boolean flag = false;
        boolean flag1 = false;
        BaseMagRailBlock baserailblock = (BaseMagRailBlock) p_38157_.getBlock();
        if (baserailblock instanceof PoweredMagRailBlock && !((PoweredMagRailBlock) baserailblock).isActivatorRail()) {
            flag = p_38157_.getValue(PoweredMagRailBlock.POWERED);
            flag1 = !flag;
        }

        double d3 = 0.0078125D;
        if (this.isInWater()) {
            d3 *= 0.2D;
        }

        Vec3 vec31 = this.getDeltaMovement();
        RailShape railshape = ((BaseMagRailBlock)p_38157_.getBlock()).getRailDirection(p_38157_, this.level, p_38156_, this);
        switch(railshape) {
            case ASCENDING_EAST:
                this.setDeltaMovement(vec31.add(-1 * getSlopeAdjustment(), 0.0D, 0.0D));
                ++d1;
                break;
            case ASCENDING_WEST:
                this.setDeltaMovement(vec31.add(getSlopeAdjustment(), 0.0D, 0.0D));
                ++d1;
                break;
            case ASCENDING_NORTH:
                this.setDeltaMovement(vec31.add(0.0D, 0.0D, getSlopeAdjustment()));
                ++d1;
                break;
            case ASCENDING_SOUTH:
                this.setDeltaMovement(vec31.add(0.0D, 0.0D, -1 * getSlopeAdjustment()));
                ++d1;
        }

        vec31 = this.getDeltaMovement();
        Pair<Vec3i, Vec3i> pair = exits(railshape);
        Vec3i vec3i = pair.getFirst();
        Vec3i vec3i1 = pair.getSecond();
        double d4 = (double)(vec3i1.getX() - vec3i.getX());
        double d5 = (double)(vec3i1.getZ() - vec3i.getZ());
        double d6 = Math.sqrt(d4 * d4 + d5 * d5);
        double d7 = vec31.x * d4 + vec31.z * d5;
        if (d7 < 0.0D) {
            d4 = -d4;
            d5 = -d5;
        }

        double d8 = Math.min(2.0D, vec31.horizontalDistance());
        vec31 = new Vec3(d8 * d4 / d6, vec31.y, d8 * d5 / d6);
        this.setDeltaMovement(vec31);
        Entity entity = this.getFirstPassenger();
        if (entity instanceof Player) {
            Vec3 vec32 = entity.getDeltaMovement();
            double d9 = vec32.horizontalDistanceSqr();
            double d11 = this.getDeltaMovement().horizontalDistanceSqr();
            if (d9 > 1.0E-4D && d11 < 0.01D) {
                this.setDeltaMovement(this.getDeltaMovement().add(vec32.x * 0.1D, 0.0D, vec32.z * 0.1D));
                flag1 = false;
            }
        }

        if (flag1 && shouldDoRailFunctions()) {
            double d22 = this.getDeltaMovement().horizontalDistance();
            if (d22 < 0.03D) {
                this.setDeltaMovement(Vec3.ZERO);
            } else {
                this.setDeltaMovement(this.getDeltaMovement().multiply(0.5D, 0.0D, 0.5D));
            }
        }

        double d23 = (double)p_38156_.getX() + 0.5D + (double)vec3i.getX() * 0.5D;
        double d10 = (double)p_38156_.getZ() + 0.5D + (double)vec3i.getZ() * 0.5D;
        double d12 = (double)p_38156_.getX() + 0.5D + (double)vec3i1.getX() * 0.5D;
        double d13 = (double)p_38156_.getZ() + 0.5D + (double)vec3i1.getZ() * 0.5D;
        d4 = d12 - d23;
        d5 = d13 - d10;
        double d14;
        if (d4 == 0.0D) {
            d14 = d2 - (double)p_38156_.getZ();
        } else if (d5 == 0.0D) {
            d14 = d0 - (double)p_38156_.getX();
        } else {
            double d15 = d0 - d23;
            double d16 = d2 - d10;
            d14 = (d15 * d4 + d16 * d5) * 2.0D;
        }

        d0 = d23 + d4 * d14;
        d2 = d10 + d5 * d14;
        this.setPos(d0, d1, d2);
        this.moveMagCartOnRail(p_38156_);
        if (vec3i.getY() != 0 && Mth.floor(this.getX()) - p_38156_.getX() == vec3i.getX() && Mth.floor(this.getZ()) - p_38156_.getZ() == vec3i.getZ()) {
            this.setPos(this.getX(), this.getY() + (double)vec3i.getY(), this.getZ());
        } else if (vec3i1.getY() != 0 && Mth.floor(this.getX()) - p_38156_.getX() == vec3i1.getX() && Mth.floor(this.getZ()) - p_38156_.getZ() == vec3i1.getZ()) {
            this.setPos(this.getX(), this.getY() + (double)vec3i1.getY(), this.getZ());
        }

        this.applyNaturalSlowdown();
        Vec3 vec33 = this.getPos(this.getX(), this.getY(), this.getZ());
        if (vec33 != null && vec3 != null) {
            double d17 = (vec3.y - vec33.y) * 0.05D;
            Vec3 vec34 = this.getDeltaMovement();
            double d18 = vec34.horizontalDistance();
            if (d18 > 0.0D) {
                this.setDeltaMovement(vec34.multiply((d18 + d17) / d18, 1.0D, (d18 + d17) / d18));
            }

            this.setPos(this.getX(), vec33.y, this.getZ());
        }

        int j = Mth.floor(this.getX());
        int i = Mth.floor(this.getZ());
        if (j != p_38156_.getX() || i != p_38156_.getZ()) {
            Vec3 vec35 = this.getDeltaMovement();
            double d26 = vec35.horizontalDistance();
            this.setDeltaMovement(d26 * (double)(j - p_38156_.getX()), vec35.y, d26 * (double)(i - p_38156_.getZ()));
        }

        if (shouldDoRailFunctions())
            baserailblock.onMagCartPass(p_38157_, level, p_38156_, this);

        if (flag && shouldDoRailFunctions()) {
            Vec3 vec36 = this.getDeltaMovement();
            double d27 = vec36.horizontalDistance();
            if (d27 > 0.01D) {
                double d19 = 0.06D;
                this.setDeltaMovement(vec36.add(vec36.x / d27 * 0.06D, 0.0D, vec36.z / d27 * 0.06D));
            } else {
                Vec3 vec37 = this.getDeltaMovement();
                double d20 = vec37.x;
                double d21 = vec37.z;
                if (railshape == RailShape.EAST_WEST) {
                    if (this.isRedstoneConductor(p_38156_.west())) {
                        d20 = 0.02D;
                    } else if (this.isRedstoneConductor(p_38156_.east())) {
                        d20 = -0.02D;
                    }
                } else {
                    if (railshape != RailShape.NORTH_SOUTH) {
                        return;
                    }

                    if (this.isRedstoneConductor(p_38156_.north())) {
                        d21 = 0.02D;
                    } else if (this.isRedstoneConductor(p_38156_.south())) {
                        d21 = -0.02D;
                    }
                }

                this.setDeltaMovement(d20, vec37.y, d21);
            }
        }

    }

    private boolean isRedstoneConductor(BlockPos p_38130_) {
        return this.level.getBlockState(p_38130_).isRedstoneConductor(this.level, p_38130_);
    }

    protected void applyNaturalSlowdown() {
        double d0 = this.isVehicle() ? 0.997D : 0.96D;
        Vec3 vec3 = this.getDeltaMovement();
        vec3 = vec3.multiply(d0, 0.0D, d0);
        if (this.isInWater()) {
            vec3 = vec3.scale((double)0.95F);
        }

        this.setDeltaMovement(vec3);
    }

    @Nullable
    public Vec3 getPosOffs(double x, double y, double z, double p_38100_) {
        int i = Mth.floor(x);
        int j = Mth.floor(y);
        int k = Mth.floor(z);
        if (this.level.getBlockState(new BlockPos(i, j - 1, k)).is(BlockRegistry.MAG_RAIL_TAG)) {
            --j;
        }

        BlockState blockstate = this.level.getBlockState(new BlockPos(i, j, k));
        if (BaseMagRailBlock.isRail(blockstate)) {
            RailShape railshape = ((BaseMagRailBlock)blockstate.getBlock()).getRailDirection(blockstate, this.level, new BlockPos(i, j, k), this);
            y = (double)j;
            if (railshape.isAscending()) {
                y = (double)(j + 1);
            }

            Pair<Vec3i, Vec3i> pair = exits(railshape);
            Vec3i vec3i = pair.getFirst();
            Vec3i vec3i1 = pair.getSecond();
            double d0 = (double)(vec3i1.getX() - vec3i.getX());
            double d1 = (double)(vec3i1.getZ() - vec3i.getZ());
            double d2 = Math.sqrt(d0 * d0 + d1 * d1);
            d0 /= d2;
            d1 /= d2;
            x += d0 * p_38100_;
            z += d1 * p_38100_;
            if (vec3i.getY() != 0 && Mth.floor(x) - i == vec3i.getX() && Mth.floor(z) - k == vec3i.getZ()) {
                y += (double)vec3i.getY();
            } else if (vec3i1.getY() != 0 && Mth.floor(x) - i == vec3i1.getX() && Mth.floor(z) - k == vec3i1.getZ()) {
                y += (double)vec3i1.getY();
            }

            return this.getPos(x, y, z);
        } else {
            return null;
        }
    }

    @Nullable
    public Vec3 getPos(double x, double y, double z) {
        int i = Mth.floor(x);
        int j = Mth.floor(y);
        int k = Mth.floor(z);
        if (this.level.getBlockState(new BlockPos(i, j - 1, k)).is(BlockRegistry.MAG_RAIL_TAG)) {
            --j;
        }

        BlockState blockstate = this.level.getBlockState(new BlockPos(i, j, k));
        if (BaseMagRailBlock.isRail(blockstate)) {
            RailShape railshape = ((BaseMagRailBlock)blockstate.getBlock()).getRailDirection(blockstate, this.level, new BlockPos(i, j, k), this);
            Pair<Vec3i, Vec3i> pair = exits(railshape);
            Vec3i vec3i = pair.getFirst();
            Vec3i vec3i1 = pair.getSecond();
            double d0 = (double)i + 0.5D + (double)vec3i.getX() * 0.5D;
            double d1 = (double)j + 0.0625D + (double)vec3i.getY() * 0.5D;
            double d2 = (double)k + 0.5D + (double)vec3i.getZ() * 0.5D;
            double d3 = (double)i + 0.5D + (double)vec3i1.getX() * 0.5D;
            double d4 = (double)j + 0.0625D + (double)vec3i1.getY() * 0.5D;
            double d5 = (double)k + 0.5D + (double)vec3i1.getZ() * 0.5D;
            double d6 = d3 - d0;
            double d7 = (d4 - d1) * 2.0D;
            double d8 = d5 - d2;
            double d9;
            if (d6 == 0.0D) {
                d9 = z - (double)k;
            } else if (d8 == 0.0D) {
                d9 = x - (double)i;
            } else {
                double d10 = x - d0;
                double d11 = z - d2;
                d9 = (d10 * d6 + d11 * d8) * 2.0D;
            }

            x = d0 + d6 * d9;
            y = d1 + d7 * d9;
            z = d2 + d8 * d9;
            if (d7 < 0.0D) {
                ++y;
            } else if (d7 > 0.0D) {
                y += 0.5D;
            }

            return new Vec3(x, y, z);
        } else {
            return null;
        }
    }

    public AABB getBoundingBoxForCulling() {
        AABB aabb = this.getBoundingBox();
        return this.hasCustomDisplay() ? aabb.inflate((double)Math.abs(this.getDisplayOffset()) / 16.0D) : aabb;
    }

    protected void readAdditionalSaveData(CompoundTag p_38137_) {
        if (p_38137_.getBoolean("CustomDisplayTile")) {
            this.setDisplayBlockState(NbtUtils.readBlockState(p_38137_.getCompound("DisplayState")));
            this.setDisplayOffset(p_38137_.getInt("DisplayOffset"));
        }

    }

    protected void addAdditionalSaveData(CompoundTag p_38151_) {
        if (this.hasCustomDisplay()) {
            p_38151_.putBoolean("CustomDisplayTile", true);
            p_38151_.put("DisplayState", NbtUtils.writeBlockState(this.getDisplayBlockState()));
            p_38151_.putInt("DisplayOffset", this.getDisplayOffset());
        }

    }

    public void push(Entity p_38165_) {
        if (getCollisionHandler() != null) {
            getCollisionHandler().onEntityCollision(this, p_38165_);
            return;
        }
        if (!this.level.isClientSide) {
            if (!p_38165_.noPhysics && !this.noPhysics) {
                if (!this.hasPassenger(p_38165_)) {
                    double d0 = p_38165_.getX() - this.getX();
                    double d1 = p_38165_.getZ() - this.getZ();
                    double d2 = d0 * d0 + d1 * d1;
                    if (d2 >= (double)1.0E-4F) {
                        d2 = Math.sqrt(d2);
                        d0 /= d2;
                        d1 /= d2;
                        double d3 = 1.0D / d2;
                        if (d3 > 1.0D) {
                            d3 = 1.0D;
                        }

                        d0 *= d3;
                        d1 *= d3;
                        d0 *= (double)0.1F;
                        d1 *= (double)0.1F;
                        d0 *= 0.5D;
                        d1 *= 0.5D;
                        if (p_38165_ instanceof AbstractMagCart) {
                            double d4 = p_38165_.getX() - this.getX();
                            double d5 = p_38165_.getZ() - this.getZ();
                            Vec3 vec3 = (new Vec3(d4, 0.0D, d5)).normalize();
                            Vec3 vec31 = (new Vec3((double)Mth.cos(this.getYRot() * ((float)Math.PI / 180F)), 0.0D, (double)Mth.sin(this.getYRot() * ((float)Math.PI / 180F)))).normalize();
                            double d6 = Math.abs(vec3.dot(vec31));
                            if (d6 < (double)0.8F) {
                                return;
                            }

                            Vec3 vec32 = this.getDeltaMovement();
                            Vec3 vec33 = p_38165_.getDeltaMovement();
                            if (((AbstractMagCart)p_38165_).isPoweredCart() && !this.isPoweredCart()) {
                                this.setDeltaMovement(vec32.multiply(0.2D, 1.0D, 0.2D));
                                this.push(vec33.x - d0, 0.0D, vec33.z - d1);
                                p_38165_.setDeltaMovement(vec33.multiply(0.95D, 1.0D, 0.95D));
                            } else if (!((AbstractMagCart)p_38165_).isPoweredCart() && this.isPoweredCart()) {
                                p_38165_.setDeltaMovement(vec33.multiply(0.2D, 1.0D, 0.2D));
                                p_38165_.push(vec32.x + d0, 0.0D, vec32.z + d1);
                                this.setDeltaMovement(vec32.multiply(0.95D, 1.0D, 0.95D));
                            } else {
                                double d7 = (vec33.x + vec32.x) / 2.0D;
                                double d8 = (vec33.z + vec32.z) / 2.0D;
                                this.setDeltaMovement(vec32.multiply(0.2D, 1.0D, 0.2D));
                                this.push(d7 - d0, 0.0D, d8 - d1);
                                p_38165_.setDeltaMovement(vec33.multiply(0.2D, 1.0D, 0.2D));
                                p_38165_.push(d7 + d0, 0.0D, d8 + d1);
                            }
                        } else {
                            this.push(-d0, 0.0D, -d1);
                            p_38165_.push(d0 / 4.0D, 0.0D, d1 / 4.0D);
                        }
                    }

                }
            }
        }
    }

    public void lerpTo(double p_38102_, double p_38103_, double p_38104_, float p_38105_, float p_38106_, int p_38107_, boolean p_38108_) {
        this.lx = p_38102_;
        this.ly = p_38103_;
        this.lz = p_38104_;
        this.lyr = (double)p_38105_;
        this.lxr = (double)p_38106_;
        this.lSteps = p_38107_ + 2;
        this.setDeltaMovement(this.lxd, this.lyd, this.lzd);
    }

    public void lerpMotion(double p_38171_, double p_38172_, double p_38173_) {
        this.lxd = p_38171_;
        this.lyd = p_38172_;
        this.lzd = p_38173_;
        this.setDeltaMovement(this.lxd, this.lyd, this.lzd);
    }

    public void setDamage(float p_38110_) {
        this.entityData.set(DATA_ID_DAMAGE, p_38110_);
    }

    public float getDamage() {
        return this.entityData.get(DATA_ID_DAMAGE);
    }

    public void setHurtTime(int p_38155_) {
        this.entityData.set(DATA_ID_HURT, p_38155_);
    }

    public int getHurtTime() {
        return this.entityData.get(DATA_ID_HURT);
    }

    public void setHurtDir(int p_38161_) {
        this.entityData.set(DATA_ID_HURTDIR, p_38161_);
    }

    public int getHurtDir() {
        return this.entityData.get(DATA_ID_HURTDIR);
    }

    public abstract AbstractMagCart.Type getMagCartType();

    public BlockState getDisplayBlockState() {
        return !this.hasCustomDisplay() ? this.getDefaultDisplayBlockState() : Block.stateById(this.getEntityData().get(DATA_ID_DISPLAY_BLOCK));
    }

    public BlockState getDefaultDisplayBlockState() {
        return Blocks.AIR.defaultBlockState();
    }

    public int getDisplayOffset() {
        return !this.hasCustomDisplay() ? this.getDefaultDisplayOffset() : this.getEntityData().get(DATA_ID_DISPLAY_OFFSET);
    }

    public int getDefaultDisplayOffset() {
        return 6;
    }

    public void setDisplayBlockState(BlockState p_38147_) {
        this.getEntityData().set(DATA_ID_DISPLAY_BLOCK, Block.getId(p_38147_));
        this.setCustomDisplay(true);
    }

    public void setDisplayOffset(int p_38175_) {
        this.getEntityData().set(DATA_ID_DISPLAY_OFFSET, p_38175_);
        this.setCustomDisplay(true);
    }

    public boolean hasCustomDisplay() {
        return this.getEntityData().get(DATA_ID_CUSTOM_DISPLAY);
    }

    public void setCustomDisplay(boolean p_38139_) {
        this.getEntityData().set(DATA_ID_CUSTOM_DISPLAY, p_38139_);
    }

    public Packet<?> getAddEntityPacket() {
        return new ClientboundAddEntityPacket(this);
    }

    private boolean canUseRail = true;
    @Override public boolean canUseRail() { return canUseRail; }
    @Override public void setCanUseRail(boolean value) { this.canUseRail = value; }
    private float currentSpeedCapOnRail = getMaxCartSpeedOnRail();
    @Override public float getCurrentCartSpeedCapOnRail() { return currentSpeedCapOnRail; }
    @Override public void setCurrentCartSpeedCapOnRail(float value) { currentSpeedCapOnRail = Math.min(value, getMaxCartSpeedOnRail()); }
    private float maxSpeedAirLateral = DEFAULT_MAX_SPEED_AIR_LATERAL;
    @Override public float getMaxSpeedAirLateral() { return maxSpeedAirLateral; }
    @Override public void setMaxSpeedAirLateral(float value) { maxSpeedAirLateral = value; }
    private float maxSpeedAirVertical = DEFAULT_MAX_SPEED_AIR_VERTICAL;
    @Override public float getMaxSpeedAirVertical() { return maxSpeedAirVertical; }
    @Override public void setMaxSpeedAirVertical(float value) { maxSpeedAirVertical = value; }
    private double dragAir = DEFAULT_AIR_DRAG;
    @Override public double getDragAir() { return dragAir; }
    @Override public void setDragAir(double value) { dragAir = value; }
    @Override
    public double getMaxSpeedWithRail() { //Non-default because getMaximumSpeed is protected
        if (!canUseRail()) return getMaxSpeed();
        BlockPos pos = this.getCurrentRailPosition();
        BlockState state = this.level.getBlockState(pos);
        if (!state.is(BlockRegistry.MAG_RAIL_TAG)) return getMaxSpeed();

        float railMaxSpeed = ((BaseMagRailBlock)state.getBlock()).getRailMaxSpeed(state, this.level, pos, this);
        return Math.min(railMaxSpeed, getCurrentCartSpeedCapOnRail());
    }

    @Override
    public void moveMagCartOnRail(BlockPos pos) { //Non-default because getMaximumSpeed is protected
        AbstractMagCart mc = this;
        double d24 = mc.isVehicle() ? 0.75D : 1.0D;
        double d25 = mc.getMaxSpeedWithRail();
        Vec3 vec3d1 = mc.getDeltaMovement();
        mc.move(MoverType.SELF, new Vec3(Mth.clamp(d24 * vec3d1.x, -d25, d25), 0.0D, Mth.clamp(d24 * vec3d1.z, -d25, d25)));
    }
    // Forge end

    public ItemStack getPickResult() {
        Item item = switch (this.getMagCartType()) {
            case FURNACE -> ItemRegistry.FURNACE_MAGCART.get();
            case CHEST -> ItemRegistry.CHEST_MAGCART.get();
            case TNT -> ItemRegistry.TNT_MAGCART.get();
            case HOPPER -> ItemRegistry.HOPPER_MAGCART.get();
            case COMMAND_BLOCK -> ItemRegistry.COMMAND_BLOCK_MAGCART.get();
            default -> ItemRegistry.MAGCART.get();
        };
        return new ItemStack(item);
    }

    public enum Type {
        RIDEABLE,
        CHEST,
        FURNACE,
        TNT,
        SPAWNER,
        HOPPER,
        COMMAND_BLOCK,
        WORKBENCH;
    }
}
