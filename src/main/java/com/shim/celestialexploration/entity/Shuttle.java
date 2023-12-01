package com.shim.celestialexploration.entity;

import com.google.common.collect.Lists;
import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestialexploration.capabilities.LoxTankCapability;
import com.shim.celestialexploration.inventory.menus.ShuttleMenu;
import com.shim.celestialexploration.item.ShuttleItem;
import com.shim.celestialexploration.registry.*;
import com.shim.celestialexploration.util.Keybinds;
import com.shim.celestialexploration.world.portal.SpaceTeleporter;
import net.minecraft.BlockUtil;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.core.Rotations;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientboundAddEntityPacket;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.Mth;
import net.minecraft.world.*;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.WaterAnimal;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.vehicle.DismountHelper;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.WaterlilyBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.wrapper.InvWrapper;
import net.minecraftforge.network.NetworkHooks;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.util.List;

public class Shuttle extends Entity implements ContainerListener, MenuProvider {
    private static final EntityDataAccessor<Integer> DATA_ID_HURT = SynchedEntityData.defineId(Shuttle.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Integer> DATA_ID_HURTDIR = SynchedEntityData.defineId(Shuttle.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Float> DATA_ID_DAMAGE = SynchedEntityData.defineId(Shuttle.class, EntityDataSerializers.FLOAT);
    private static final EntityDataAccessor<Integer> DATA_ID_TYPE = SynchedEntityData.defineId(Shuttle.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Boolean> DATA_ID_PADDLE_LEFT = SynchedEntityData.defineId(Shuttle.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Boolean> DATA_ID_PADDLE_RIGHT = SynchedEntityData.defineId(Shuttle.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Integer> DATA_ID_BUBBLE_TIME = SynchedEntityData.defineId(Shuttle.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Byte> DATA_ID_FLAGS = SynchedEntityData.defineId(Shuttle.class, EntityDataSerializers.BYTE);
    private static final EntityDataAccessor<Integer> DATA_ID_TIME_ON_GROUND = SynchedEntityData.defineId(Shuttle.class, EntityDataSerializers.INT);
    private float outOfControlTicks;
    public float deltaRotation;
    private int lerpSteps;
    private double lerpX;
    private double lerpY;
    private double lerpZ;
    private double lerpYRot;
    private double lerpXRot;
    private Shuttle.Status status;
    private final float SHUTTLE_SPEED = .55F;
    private final float SHUTTLE_LOW_FUEL_SPEED = .4F;
    private final float SHUTTLE_NO_FUEL_SPEED = .2F;
    protected SimpleContainer inventory;
    private int fuelTicks = 200;
    private int maxFuelTicks = 200;
    private int teleportationCooldown = 120;
    //    public int timeOnGround = 0;
    public static int maxTimeOnGround = 10;
    private int biomeCheckCooldown = 5;
    private String celestialBodyInRange = "null";


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
        this.entityData.define(DATA_ID_FLAGS, (byte) 0);
        this.entityData.define(DATA_ID_TIME_ON_GROUND, 1);
    }

    @Override
    public boolean canCollideWith(Entity p_38376_) {
        return false;
//        return canVehicleCollide(this, p_38376_);
    }

    public static boolean canVehicleCollide(Entity p_38324_, Entity p_38325_) {
        return false;
//        return (p_38325_.canBeCollidedWith() || p_38325_.isPushable()) && !p_38324_.isPassengerOfSameVehicle(p_38325_);
    }

    @Override
    public boolean canBeCollidedWith() {
        return false;
    }

    @Override
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

                this.spawnAtLocation(this.getDropItem());
                for (int i = 0; i < this.inventory.getContainerSize(); i++) {
                    if (this.inventory.getItem(i) != null) {
                        this.spawnAtLocation(this.inventory.getItem(i));
                    }
                }
//                ShuttleItem shuttleItem = (ShuttleItem) this.getDropItem();
//                Level level = this.getLevel();
//
//                Containers.dropContents(level, new BlockPos(this.position()), (Container)this);
//
//                CompoundTag tag = new CompoundTag();
//
//                ListTag listtag = new ListTag();
//
//                for (int i = 0; i < inventory.getContainerSize(); ++i) {
//                    ItemStack itemstack = inventory.getItem(i);
//                    if (!itemstack.isEmpty()) {
//                        CompoundTag compoundtag = new CompoundTag();
//                        compoundtag.putByte("Slot", (byte) i);
//                        itemstack.save(compoundtag);
//                        listtag.add(compoundtag);
//                    }
//                }
//
//                tag.put("Items", listtag);
//                shuttleItem.setShuttleItemData(tag);

//                ItemEntity itemEntity = new ItemEntity(level, this.position().x, this.position().y, this.position().z, new ItemStack(shuttleItem));
//
//                itemEntity.setDefaultPickUpDelay();
//                level.addFreshEntity(itemEntity);
                this.discard();
            }
            return true;
        } else {
            return true;
        }
    }

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

    public void lerpTo(double lerpX, double lerpY, double lerpZ, float lerpYRot, float lerpXRot, int p_38304_, boolean p_38305_) {
        this.lerpX = lerpX;
        this.lerpY = lerpY;
        this.lerpZ = lerpZ;
        this.lerpYRot = lerpYRot;
        this.lerpXRot = lerpXRot;
        this.lerpSteps = 10;
    }

    public @NotNull Direction getMotionDirection() {
        return this.getDirection().getClockWise();
    }

    public void setTimeOnGround(int time) {
        this.entityData.set(DATA_ID_TIME_ON_GROUND, time);
    }

    public int getTimeOnGround() {
        return this.entityData.get(DATA_ID_TIME_ON_GROUND);
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

        if (!this.isOnGround()) this.setTimeOnGround(0);
        else if (this.getTimeOnGround() < maxTimeOnGround) this.setTimeOnGround(this.getTimeOnGround() + 1);

        super.tick();
        this.tickLerp();
        if (this.isControlledByLocalInstance()) {
            if (this.level.isClientSide) {
                this.controlShuttle();
                if (this.isVehicle()) {
                    if (this.getDeltaMovement().z > 0 || this.getDeltaMovement().x > 0) {
                        --fuelTicks;
                        if (fuelTicks <= 0) {
                            this.useFuel();
                            fuelTicks = maxFuelTicks;
                        }
                    }
                } else {
                    this.setDeltaMovement(Vec3.ZERO);
                }
            } else {
                this.setDeltaMovement(Vec3.ZERO);
            }
            this.move(MoverType.SELF, this.getDeltaMovement());
        }

        if (isVehicle() && isTeleportHeight()) {
            if (this.level.dimension() == Level.OVERWORLD) {
                //TODO or FIXME does not allow for multiple passengers, update if we want shuttle to allow multiple passengers in the future
                if (this.teleportationCooldown == 0) {
                    Entity passenger = this.getControllingPassenger();
                    this.displayTeleportMessage(teleportationCooldown);

                    ResourceKey<Level> destination = passenger.level.dimension() == DimensionRegistry.SPACE ? Level.OVERWORLD : DimensionRegistry.SPACE; //FIXME

//                    ResourceKey<Level> destination = DimensionRegistry.SPACE;
                    assert passenger != null;
                    this.teleportShuttle(passenger, this, destination);
                } else {
                    this.teleportationCooldown--;
                    this.displayTeleportMessage(teleportationCooldown);
                }
            }
        }

        /**
         * Possibly just a bandaid fix? Until I can come up with a
         * more efficient way of dealing with this.
         *
         * Check if we're being used as a vehicle, because if we're not, none of this matters.
         * Check if we're in space, so that way none of this code
         * ever gets run in other dimensions.
         * Then we check if we're in an appropriate biome or nearby it.
         * The reason for checking nearby is sometimes the structure we're looking for
         * (or rather the blocks making up the structure) sometimes spawns
         * near the edge of the biome, so that would mean our teleporting only
         * works approaching from *some* angles and not others.
         * If all that passes, then we'll look at whether or not we should be
         * trying to teleport to another dimension.
         **
         * The issue, that I need to somehow make more efficient, is that
         * isBiomeInRange (and also a little bit shouldTeleportToPlanet) do
         * a little bit more calculating than should be done every tick, and
         * was causing a bunch of lag, especially with multiple shuttles nearby each other.
         **/
//        biomeCheckCooldown--;
//        if (biomeCheckCooldown == 0) {
//            biomeCheckCooldown = 5;

        ResourceKey<Level> currentDimension = this.level.dimension();

        if (this.isVehicle()) {
            if (currentDimension == DimensionRegistry.SPACE) {
                Holder<Biome> currentBiome = this.level.getBiome(new BlockPos(this.position()));

                if (currentBiome.is(BiomeRegistry.MARS_ORBIT) || isBiomeInRange(BiomeRegistry.MARS_ORBIT)) { //IN MARS ORBIT OR NEAR EDGE
                    if (this.shouldTeleportToCelestialBody(BlockRegistry.MARS_STONE.get())) { //APPROACHING MARS
//                            celestialBodyInRange = "Mars";
                        Entity passenger = this.getControllingPassenger();
                        assert passenger != null;
                        if (this.teleportationCooldown == 0) {
                            this.displayTeleportMessage(teleportationCooldown);
                            ResourceKey<Level> destination = DimensionRegistry.MARS;
                            this.teleportShuttle(passenger, this, destination);
                        } else {
                            this.teleportationCooldown--;
                            this.displayTeleportMessage(teleportationCooldown);
                        }
                    }
                } else if (currentBiome.is(BiomeRegistry.EARTH_ORBIT) || isBiomeInRange(BiomeRegistry.EARTH_ORBIT)) { //IN EARTH ORBIT OR NEAR EDGE
                    if (this.shouldTeleportToCelestialBody(Blocks.STONE)) { //APPROACHING EARTH
//                            celestialBodyInRange = "Earth";
                        Entity passenger = this.getControllingPassenger();
                        assert passenger != null;
                        if (this.teleportationCooldown == 0) {
                            this.displayTeleportMessage(teleportationCooldown);
                            ResourceKey<Level> destination = Level.OVERWORLD;
                            this.teleportShuttle(passenger, this, destination);
                        } else {
                            this.teleportationCooldown--;
                            this.displayTeleportMessage(teleportationCooldown);
                        }
                    } else if (this.shouldTeleportToCelestialBody(BlockRegistry.MOON_STONE.get())) { //APPROACHING MOON
//                            celestialBodyInRange = "Moon";
                        Entity passenger = this.getControllingPassenger();
                        assert passenger != null;
                        if (this.teleportationCooldown == 0) {
                            this.displayTeleportMessage(teleportationCooldown);
                            ResourceKey<Level> destination = DimensionRegistry.MOON;
                            this.teleportShuttle(passenger, this, destination);
                        } else {
                            this.teleportationCooldown--;
                            this.displayTeleportMessage(teleportationCooldown);
                        }
                    }
                } else {
                    this.teleportationCooldown = 120; //reset the cooldown
                }
            }
        }
//        }

//        if (this.isVehicle() && celestialBodyInRange != null) {
//            Entity passenger = this.getControllingPassenger();
//            assert passenger != null;
//            if (this.teleportationCooldown == 0) {
//                this.displayTeleportMessage(teleportationCooldown);
//                ResourceKey<Level> destination;
//                if (celestialBodyInRange.equals("Mars")) {
//                    destination = DimensionRegistry.MARS;
//                } else if (celestialBodyInRange.equals("Earth")) {
//                    destination = Level.OVERWORLD;
//                } else if (celestialBodyInRange.equals("Moon")) {
//                    destination = DimensionRegistry.MOON;
//                } else {
//                    destination = null;
//                }
//                if (destination != null) {
//                    this.teleportShuttle(passenger, this, destination);
//                }
//            } else {
//                this.teleportationCooldown--;
//                this.displayTeleportMessage(teleportationCooldown);
//            }
//
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

    public void displayTeleportMessage(int teleportCooldown) {
        Entity entity = this.getControllingPassenger();

        if (entity instanceof Player) {
            if (teleportCooldown % 20 == 0) {
                ((Player) entity).displayClientMessage(Component.nullToEmpty("Teleporting in… " + teleportCooldown / 20), true);
            } else if (teleportCooldown == 0) {
                ((Player) entity).displayClientMessage(Component.nullToEmpty("Teleporting!"), true);
            }
        }
    }

    public boolean shouldTeleportToCelestialBody(Block blockToTest) {
        BlockPos pos;
        boolean blockInRange = false;
        BlockState state;

        for (int x = -10; x <= 10; x++) {
            for (int y = -10; y <= 10; y++) {
                for (int z = -10; z <= 10; z++) {
                    pos = new BlockPos(this.position().x + x, this.position().y + y, this.position().z + z);
                    state = level.getBlockState(pos);
                    if (state.getBlock() == blockToTest) blockInRange = true;
                }
            }
        }
        return blockInRange;
    }

    public boolean isBiomeInRange(ResourceKey<Biome> biomeToTest) {
        BlockPos pos;
        boolean biomeInRange = false;
        Holder<Biome> biome;

        for (int x = -11; x <= 11; x++) {
            for (int y = -11; y <= 11; y++) {
                for (int z = -11; z <= 11; z++) {
                    pos = new BlockPos(this.position().x + x, this.position().y + y, this.position().z + z);
                    biome = this.level.getBiome(new BlockPos(pos));
                    if (biome.is(biomeToTest)) biomeInRange = true;
                }
            }
        }
        return biomeInRange;
    }

    public boolean isTeleportHeight() {
        if (this.isVehicle() && this.position().y > this.level.getMaxBuildHeight() + 10) {
            return true;
        } else {
            return false;
        }
    }

    protected void resetTelportationCooldown() {
        this.teleportationCooldown = 120;
    }

    public int getTelportationCooldown() {
        return this.teleportationCooldown;
    }

    protected void teleportShuttle(Entity passenger, Shuttle shuttle, ResourceKey<Level> destinationDim) {
        if (passenger.canChangeDimensions()) {

            Level entityWorld = passenger.level;
            MinecraftServer minecraftserver = entityWorld.getServer();
            if (minecraftserver != null) {
                ServerLevel destinationWorld = minecraftserver.getLevel(destinationDim);
                if (destinationWorld != null) {
                    this.resetTelportationCooldown();
                    passenger.changeDimension(destinationWorld, new SpaceTeleporter(destinationWorld));
                    Entity newShuttle = shuttle.changeDimension(destinationWorld, new SpaceTeleporter(destinationWorld));
                    if (!this.level.isClientSide && passenger instanceof Player) {
                        assert newShuttle != null;
                        passenger.startRiding(newShuttle);
                    }
                }
            }
        }
    }

    private void tickLerp() {
        if (this.isControlledByLocalInstance()) {
            this.lerpSteps = 0;
//            this.setPacketCoordinates(this.getX(), this.getY(), this.getZ());
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

    private Shuttle.Status getStatus() {
        Shuttle.Status shuttle$status = this.isUnderwater();
        if (shuttle$status != null) {
            return shuttle$status;
        } else {
            float f = this.getGroundFriction();
            if (f > 0.0F) {
                return Shuttle.Status.ON_LAND;
            } else {
                return Shuttle.Status.IN_AIR;
            }
        }
    }

//    public boolean isTimeOnGroundSufficient() {
//        return this.timeOnGround == this.maxTimeOnGround;
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

    public boolean hasFuel() {
        boolean hasFuel = false;

        LoxTankCapability.ILoxTank firstTankCap = getTankCap(this.inventory.getItem(0));
        LoxTankCapability.ILoxTank secondTankCap = getTankCap(this.inventory.getItem(1));
        LoxTankCapability.ILoxTank thirdTankCap = getTankCap(this.inventory.getItem(2));
        LoxTankCapability.ILoxTank fourthTankCap = getTankCap(this.inventory.getItem(3));

        if (firstTankCap != null) {
            hasFuel = !firstTankCap.isEmpty();
        }
        if (secondTankCap != null) {
            hasFuel = !secondTankCap.isEmpty();
        }
        if (thirdTankCap != null) {
            hasFuel = !thirdTankCap.isEmpty();
        }
        if (fourthTankCap != null) {
            hasFuel = !fourthTankCap.isEmpty();
        }

        return hasFuel;
    }

    private void useFuel() {
        LoxTankCapability.ILoxTank firstTankCap = getTankCap(this.inventory.getItem(0));
        LoxTankCapability.ILoxTank secondTankCap = getTankCap(this.inventory.getItem(1));
        LoxTankCapability.ILoxTank thirdTankCap = getTankCap(this.inventory.getItem(2));
        LoxTankCapability.ILoxTank fourthTankCap = getTankCap(this.inventory.getItem(3));

        if (hasLowFuel()) {
            if (firstTankCap != null && !firstTankCap.isEmpty()) {
                firstTankCap.decrementAmountByFifty();
            } else if (secondTankCap != null && !secondTankCap.isEmpty()) {
                secondTankCap.decrementAmountByFifty();
            } else if (thirdTankCap != null && !thirdTankCap.isEmpty()) {
                thirdTankCap.decrementAmountByFifty();
            } else if (fourthTankCap != null && !fourthTankCap.isEmpty()) {
                fourthTankCap.decrementAmountByFifty();
            }
        } else {
            if (firstTankCap != null && !firstTankCap.isEmpty()) {
                firstTankCap.decrementAmount();
            } else if (secondTankCap != null && !secondTankCap.isEmpty()) {
                secondTankCap.decrementAmount();
            } else if (thirdTankCap != null && !thirdTankCap.isEmpty()) {
                thirdTankCap.decrementAmount();
            } else if (fourthTankCap != null && !fourthTankCap.isEmpty()) {
                fourthTankCap.decrementAmount();
            }
        }
    }

    public boolean hasLowFuel() {
        return getFuel() <= 300;
    }

    private LoxTankCapability.ILoxTank getTankCap(ItemStack tank) {
        LoxTankCapability.ILoxTank tankCap = CelestialExploration.getCapability(tank, CapabilityRegistry.LOX_TANK_CAPABILITY);
        if (tankCap != null) {
            return tankCap;
        } else {
            return null;
        }
    }

    public int getFuel() {
        int totalFuel = 0;

        LoxTankCapability.ILoxTank firstTankCap = getTankCap(this.inventory.getItem(0));
        LoxTankCapability.ILoxTank secondTankCap = getTankCap(this.inventory.getItem(1));
        LoxTankCapability.ILoxTank thirdTankCap = getTankCap(this.inventory.getItem(2));
        LoxTankCapability.ILoxTank fourthTankCap = getTankCap(this.inventory.getItem(3));

        if (firstTankCap != null && !firstTankCap.isEmpty()) {
            totalFuel += firstTankCap.getAmount();
        }
        if (secondTankCap != null && !secondTankCap.isEmpty()) {
            totalFuel += secondTankCap.getAmount();
        }
        if (thirdTankCap != null && !thirdTankCap.isEmpty()) {
            totalFuel += thirdTankCap.getAmount();
        }
        if (fourthTankCap != null && !fourthTankCap.isEmpty()) {
            totalFuel += fourthTankCap.getAmount();
        }

        return totalFuel;
    }

    public float getMaxSpeed() {
        if (this.hasFuel()) {
            if (this.hasLowFuel()) return SHUTTLE_LOW_FUEL_SPEED;
            return SHUTTLE_SPEED;
        }
        return SHUTTLE_NO_FUEL_SPEED;
    }

    public double getCurrentSpeed() {
        return this.getDeltaMovement().x;
    }


    private void controlShuttle() {
        if (this.isVehicle()) {

            float currentSpeed;
            currentSpeed = getMaxSpeed();

            LivingEntity livingentity = (LivingEntity) this.getControllingPassenger();
//            this.yRotO = this.getYRot();
//            this.setXRot(livingentity.getXRot() * 0.5F);
//            this.setRot(this.getYRot(), this.getXRot());
            float f = livingentity.zza * currentSpeed;

            if (Keybinds.TURN_LEFT_KEY.isDown()) {
                this.setYRot(livingentity.getYRot());

                --this.deltaRotation;
            } else if (Keybinds.TURN_RIGHT_KEY.isDown()) {
                this.setYRot(livingentity.getYRot());
                ++this.deltaRotation;
            } else {
                this.deltaRotation = 0;
            }
            float f1;

            if (Keybinds.ASCEND_KEY.isDown()) {
                f1 = currentSpeed;
            } else if (Keybinds.DESCEND_KEY.isDown()) {
                f1 = -1 * SHUTTLE_SPEED; //shuttle can always descend at normal speed
            } else {
                f1 = 0;
            }
            this.setDeltaMovement((Mth.sin(-this.getYRot() * ((float) Math.PI / 180F)) * f), f1, (Mth.cos(this.getYRot() * ((float) Math.PI / 180F)) * f));
        }
    }

    public void positionRider(Entity p_38379_) {
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
            p_38379_.setYHeadRot(p_38379_.getYHeadRot() + this.deltaRotation);
            this.clampRotation(p_38379_);
            if (p_38379_ instanceof Animal && this.getPassengers().size() > 1) {
                int j = p_38379_.getId() % 2 == 0 ? 90 : 270;
                p_38379_.setYBodyRot(((Animal) p_38379_).yBodyRot + (float) j);
                p_38379_.setYHeadRot(p_38379_.getYHeadRot() + (float) j);
            }

        }
    }

    public Vec3 getDismountLocationForPassenger(LivingEntity p_38357_) {
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

    protected void addAdditionalSaveData(CompoundTag tag) {
        tag.putString("Type", this.getShuttleType().getName());
        ListTag listtag = new ListTag();

        for (int i = 0; i < this.inventory.getContainerSize(); ++i) {
            ItemStack itemstack = this.inventory.getItem(i);
            if (!itemstack.isEmpty()) {
                CompoundTag compoundtag = new CompoundTag();
                compoundtag.putByte("Slot", (byte) i);
                itemstack.save(compoundtag);
                listtag.add(compoundtag);
            }
        }

        tag.put("Items", listtag);
    }

    protected void readAdditionalSaveData(CompoundTag p_38338_) {
        if (p_38338_.contains("Type", 8)) {
            this.setType(Shuttle.Type.byName(p_38338_.getString("Type")));
        }
        ListTag listtag = p_38338_.getList("Items", 10);

        this.createInventory();
        for (int i = 0; i < listtag.size(); ++i) {
            CompoundTag compoundtag = listtag.getCompound(i);
            int j = compoundtag.getByte("Slot") & 255;
            if (j >= 0 && j < this.inventory.getContainerSize()) {
                this.inventory.setItem(j, ItemStack.of(compoundtag));
            }
        }
    }

    public void setInvData(CompoundTag tag) {
        if (tag == null) {
            return;
        }
        ListTag listtag = tag.getList("Items", 10);

        this.createInventory();
        for (int i = 0; i < listtag.size(); ++i) {

            CompoundTag compoundtag = listtag.getCompound(i);
            int j = compoundtag.getByte("Slot") & 255;
            if (j >= 0 && j < this.inventory.getContainerSize()) {

                this.inventory.setItem(j, ItemStack.of(compoundtag));
            }
        }
    }

    protected int getInventorySize() {
        return 31;
    }

    protected void createInventory() {
        SimpleContainer simplecontainer = this.inventory;
        this.inventory = new SimpleContainer(this.getInventorySize());
        if (simplecontainer != null) {
            simplecontainer.removeListener(this);
            int i = Math.min(simplecontainer.getContainerSize(), this.inventory.getContainerSize());

            for (int j = 0; j < i; ++j) {
                ItemStack itemstack = simplecontainer.getItem(j);
                if (!itemstack.isEmpty()) {
                    this.inventory.setItem(j, itemstack.copy());
                }
            }
        }

        this.inventory.addListener(this);
        this.updateContainerEquipment();
        this.itemHandler = LazyOptional.of(() -> new InvWrapper(this.inventory));
    }

    protected boolean getFlag(int p_30648_) {
        return (this.entityData.get(DATA_ID_FLAGS) & p_30648_) != 0;
    }

    protected void setFlag(int p_30598_, boolean p_30599_) {
        byte b0 = this.entityData.get(DATA_ID_FLAGS);
        if (p_30599_) {
            this.entityData.set(DATA_ID_FLAGS, (byte) (b0 | p_30598_));
        } else {
            this.entityData.set(DATA_ID_FLAGS, (byte) (b0 & ~p_30598_));
        }

    }


    protected void updateContainerEquipment() {
        if (!this.level.isClientSide) {
            this.setFlag(4, !this.inventory.getItem(0).isEmpty());
        }
    }

//    private SlotAccess createEquipmentSlotAccess(final int p_149503_, final Predicate<ItemStack> p_149504_) {
//        return new SlotAccess() {
//            public ItemStack get() {
//                return Shuttle.this.inventory.getItem(p_149503_);
//            }
//
//            public boolean set(ItemStack p_149528_) {
//                if (!p_149504_.test(p_149528_)) {
//                    return false;
//                } else {
//                    Shuttle.this.inventory.setItem(p_149503_, p_149528_);
//                    Shuttle.this.updateContainerEquipment();
//                    return true;
//                }
//            }
//        };
//    }

//    public SlotAccess getSlot(int p_149479_) {
//        return p_149479_ == 499 ? new SlotAccess() {
//            public ItemStack get() {
//                return new ItemStack(Items.CHEST);
//            }
//
//            public boolean set(ItemStack p_149485_) {
//                if (p_149485_.isEmpty()) {
////                    if (AbstractChestedHorse.this.hasChest()) {
////                        AbstractChestedHorse.this.setChest(false);
//                    Shuttle.this.createInventory();
////                    }
//
//                    return true;
//                } else if (p_149485_.is(Items.CHEST)) {
////                    if (!AbstractChestedHorse.this.hasChest()) {
////                        AbstractChestedHorse.this.setChest(true);
//                    Shuttle.this.createInventory();
////                    }
//
//                    return true;
//                } else {
//                    return false;
//                }
//            }
//        } : this.getSlotSuper(p_149479_);
//    }

//    public SlotAccess getSlotSuper(int p_149514_) {
//        int i = p_149514_ - 400;
//        if (i >= 0 && i < 2 && i < this.inventory.getContainerSize()) {
//            if (i == 0) {
//                return this.createEquipmentSlotAccess(i, (p_149518_) -> {
//                    return p_149518_.isEmpty() || p_149518_.is(Items.SADDLE);
//                });
//            }
//
//            if (i == 1) {
////                if (!this.canWearArmor()) {
////                    return SlotAccess.NULL;
////                }
//
//                return this.createEquipmentSlotAccess(i, (p_149516_) -> {
//                    return p_149516_.isEmpty(); // || this.isArmor(p_149516_);
//                });
//            }
//        }
//
//        int j = p_149514_ - 500 + 2;
//        return j >= 2 && j < this.inventory.getContainerSize() ? SlotAccess.forContainer(this.inventory, j) : super.getSlot(p_149514_);
//    }

    private net.minecraftforge.common.util.LazyOptional<?> itemHandler = null;

    @Override
    public <T> net.minecraftforge.common.util.LazyOptional<T> getCapability(net.minecraftforge.common.capabilities.Capability<T> capability, @Nullable net.minecraft.core.Direction facing) {
        if (capability == net.minecraftforge.items.CapabilityItemHandler.ITEM_HANDLER_CAPABILITY && itemHandler != null)
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

    public InteractionResult interact(Player player, InteractionHand hand) {

        if (player.isSecondaryUseActive()) {

            if (player instanceof ServerPlayer) {
                NetworkHooks.openGui((ServerPlayer) player, this, buf -> buf.writeInt(this.getId()));
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

//                            for (int j = 0; j < 2; ++j) {
//                                this.spawnAtLocation(Items.STICK);
//                            }
                        }
                    }
                }

                this.resetFallDistance();
            } else if (!this.level.getFluidState(this.blockPosition().below()).is(FluidTags.WATER) && p_38307_ < 0.0D) {
                this.fallDistance -= (float) p_38307_;
            }

        }
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
