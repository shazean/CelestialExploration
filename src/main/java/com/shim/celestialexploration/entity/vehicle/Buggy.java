package com.shim.celestialexploration.entity.vehicle;

import com.google.common.collect.Lists;
import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestialexploration.entity.client.dispatchers.BuggyDispatcher;
import com.shim.celestialexploration.inventory.menus.BuggyMenu;
import com.shim.celestialexploration.packets.BuggyInventoryPacket;
import com.shim.celestialexploration.packets.CelestialPacketHandler;
import com.shim.celestialexploration.registry.CelestialEntities;
import com.shim.celestialexploration.registry.CelestialItems;
import com.shim.celestialexploration.util.Keybinds;
import net.minecraft.BlockUtil;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientboundAddEntityPacket;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.Mth;
import net.minecraft.world.*;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.FlyingAnimal;
import net.minecraft.world.entity.animal.WaterAnimal;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.vehicle.DismountHelper;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
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

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;

public class Buggy extends Entity implements ContainerListener, MenuProvider {
    private static final EntityDataAccessor<Integer> DATA_ID_HURT = SynchedEntityData.defineId(Buggy.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Integer> DATA_ID_HURTDIR = SynchedEntityData.defineId(Buggy.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Float> DATA_ID_DAMAGE = SynchedEntityData.defineId(Buggy.class, EntityDataSerializers.FLOAT);
    private static final EntityDataAccessor<Byte> DATA_ID_FLAGS = SynchedEntityData.defineId(Buggy.class, EntityDataSerializers.BYTE);
    private float outOfControlTicks;
    public float oldDeltaRotation;
    public float deltaRotation;
    private int lerpSteps;
    private double lerpX;
    private double lerpY;
    private double lerpZ;
    private double lerpYRot;
    private double lerpXRot;
    private Buggy.Status status;
    private static final float BUGGY_SPEED = .2F;
    protected SimpleContainer inventory;
    public final BuggyDispatcher dispatcher;
    public float jankyFixYRot;
    public float jankyFixYRotO;
    protected int jumpDelay;

    public Buggy(EntityType<? extends Buggy> p_38290_, Level p_38291_) {
        super(p_38290_, p_38291_);
        this.blocksBuilding = true;
        this.createInventory();
        this.dispatcher = new BuggyDispatcher(this);
    }

    public Buggy(Level p_38293_, double p_38294_, double p_38295_, double p_38296_) {
        this(CelestialEntities.BUGGY.get(), p_38293_);
        this.setPos(p_38294_, p_38295_, p_38296_);
        this.xo = p_38294_;
        this.yo = p_38295_;
        this.zo = p_38296_;
//        this.setNoGravity(true);
    }

    @Override
    public void containerChanged(Container p_18983_) {}

    @org.jetbrains.annotations.Nullable
    @Override
    public AbstractContainerMenu createMenu(int containerId, Inventory inventory, Player player) {
        return new BuggyMenu(containerId, inventory, this);
//        return null;
    }

    @Override
    public Component getDisplayName() {
        return new TranslatableComponent("entity.celestialexploration.buggy");
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
        this.entityData.define(DATA_ID_FLAGS, (byte) 0);
    }

    @Override
    public boolean canCollideWith(Entity p_38376_) {
        return canVehicleCollide(this, p_38376_);
    }

    public static boolean canVehicleCollide(Entity p_38324_, Entity p_38325_) {
        return (p_38325_.canBeCollidedWith() || p_38325_.isPushable()) && !p_38324_.isPassengerOfSameVehicle(p_38325_);
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

    public boolean hurt(DamageSource source, float p_38320_) {
        if (source.getEntity() instanceof Player player) {
            if (this.hasPassenger(player)) {
                return false;
            } else {
                if (!this.level.isClientSide && !this.isRemoved()) {
                    this.setHurtDir(-this.getHurtDir());
                    this.setHurtTime(10);
                    this.setDamage(this.getDamage() + p_38320_ * 10.0F);
                    this.markHurt();
                    this.gameEvent(GameEvent.ENTITY_DAMAGED, source.getEntity());
                    boolean flag = source.getEntity() instanceof Player && ((Player) source.getEntity()).getAbilities().instabuild;
                    if (flag || this.getDamage() > 20.0F) {

                        this.spawnAtLocation(this.getDropItem());
                        for (int i = 0; i < this.inventory.getContainerSize(); i++) {
                            if (this.inventory.getItem(i) != null) {
                                this.spawnAtLocation(this.inventory.getItem(i));
                            }
                        }
                        this.discard();
                    }
                    return true;
                }
            }
        } else {
            return false;
        }
        return false;
    }

    public Item getDropItem() {
       return CelestialItems.BUGGY.get();
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
        this.lerpSteps = 10; //10
    }

    public @NotNull Direction getMotionDirection() {
        return this.getDirection().getClockWise();
    }

    public void tick() {

//        if (this.level.isClientSide) {
//            dispatcher.flying();
//        }

        this.status = this.getStatus();
        if (this.status != Buggy.Status.UNDER_WATER && this.status != Buggy.Status.UNDER_FLOWING_WATER) {
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

        if (this.jumpDelay > 0) this.jumpDelay--;

        if (this.isControlledByLocalInstance()) {
            if (this.level.isClientSide) {
                this.controlBuggy();
            } else {
                this.setDeltaMovement(Vec3.ZERO);
            }

            if (!this.isOnGround() && this.jumpDelay == 0) {
                this.setDeltaMovement(this.getDeltaMovement().x(), -0.2D, this.getDeltaMovement().z());
            }

            this.move(MoverType.SELF, this.getDeltaMovement());
        }

        if (this.isVehicle() && this.getControllingPassenger() instanceof Player) {
            if (this.level.isClientSide) {

                if (Keybinds.OPEN_VEHICLE_INVENTORY.isDown()) {
                    CelestialPacketHandler.INSTANCE.sendToServer(new BuggyInventoryPacket(this.getId()));
                }
            }
        }

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

    public void controlBuggy() {
        if (this.isVehicle()) {

            LivingEntity passenger = (LivingEntity) this.getControllingPassenger();
            if (passenger != null) {
                float f = passenger.zza * BUGGY_SPEED;

                if (f > 0) {
                         this.dispatcher.moveForward();
                } else if (f < 0) {
                         this.dispatcher.moveBackward();
                } else {
                         this.dispatcher.idle();
                }

                float y;
                if (this.isOnGround() && Keybinds.ASCEND_KEY.isDown()) {
                    y = this.getJumpPower() + (float) this.getJumpBoostPower() + 1.0F;
                    this.jumpDelay = 8;
                } else {
                    y = 0.0F;
                }

                this.setYRot(passenger.getYRot());
                this.yRotO = this.getYRot();
                this.setXRot(passenger.getXRot()* 0.5F);
                this.setRot(this.getYRot(), this.getXRot());

                this.jankyFixYRotO = jankyFixYRot;
                this.jankyFixYRot = this.getYRot();
                
                this.setDeltaMovement((Mth.sin(-this.getYRot() * ((float) Math.PI / 180F)) * f), y, (Mth.cos(this.getYRot() * ((float) Math.PI / 180F)) * f));
            }
        }
    }

    public float getViewYRot(float p_21286_) {
        return p_21286_ == 1.0F ? this.getYRot() : Mth.lerp(p_21286_, this.yRotO, this.getYRot());
    }

    public void travel(Vec3 p_21280_) {
        if (this.isControlledByLocalInstance()) {
                    this.setDeltaMovement(p_21280_.x, p_21280_.y, p_21280_.z);

        }
    }

    protected float getJumpPower() {
        return 0.42F * this.getBlockJumpFactor();
    }

    public double getJumpBoostPower() {
        if (this.isVehicle()) {
            LivingEntity passenger = (LivingEntity) this.getControllingPassenger();
            return passenger.hasEffect(MobEffects.JUMP) ? (double)(0.1F * (float)(passenger.getEffect(MobEffects.JUMP).getAmplifier() + 1)) : 0.0D;
        }
        return 0.0D;
    }

    public void setJankyRotationFix(float partialTick) {
        this.setYRot(Mth.rotLerp(partialTick, jankyFixYRotO, jankyFixYRot));
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

    private Buggy.Status getStatus() {
        Buggy.Status buggy$status = this.isUnderwater();
        if (buggy$status != null) {
            return buggy$status;
        } else {
            float f = this.getGroundFriction();
            if (f > 0.0F) return Buggy.Status.ON_LAND;
            else return Buggy.Status.IN_AIR;
        }
    }

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
    private Buggy.Status isUnderwater() {
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
                        if (!fluidstate.isSource()) return Buggy.Status.UNDER_FLOWING_WATER;
                        flag = true;
                    }
                }
            }
        }
        return flag ? Buggy.Status.UNDER_WATER : null;
    }

    public static Vec3 translateWithXRotation(@Nonnull Vec3 baseIn, double rotationIn, double xOffsetIn, double yOffsetIn, double zOffsetIn) {
        double rotation = Math.toRadians(rotationIn);
        double offsetXRotated = (xOffsetIn * -Math.sin(rotation)) + (zOffsetIn * Math.cos(rotation));
        double offsetZRotated = (xOffsetIn * Math.cos(rotation)) + (zOffsetIn * Math.sin(rotation));
        return new Vec3(baseIn.x + offsetXRotated, baseIn.y + yOffsetIn, baseIn.z + offsetZRotated);
    }

    public double getPassengersRidingOffset() {  //FIXME
        return 0.45D;
    }

    public void positionRider(Entity passenger) {
        if (this.hasPassenger(passenger)) {
            float x = -0.45F; //.9F; //.25F //4.0F
            float z = -0.5F;

//            if (passenger instanceof Animal) {
//                x += 0.2F;
//            }

            float f1 = (float) ((this.isRemoved() ? (double) 0.01F : this.getPassengersRidingOffset()) + passenger.getMyRidingOffset());
            if (this.getPassengers().size() > 1) {
                int i = this.getPassengers().indexOf(passenger);
                if (i == 1) { //0
//                    x = 0.5F; //0.2F
                    z = -0.5F;
                }
//                else {
//                    x = .25F; //1.1F;
//                }

            }

            if (passenger instanceof Animal) {
                x += 0.2F;
            }

            Vec3 vec3 = (new Vec3(x, 0.0D, z)).yRot(-this.getYRot() * ((float) Math.PI / 180F) - ((float) Math.PI / 2F));
            passenger.setPos(this.getX() + vec3.x, this.getY() + (double) f1 + 0.35F, this.getZ() + vec3.z);
            passenger.setYRot(passenger.getYRot() + this.deltaRotation);
            passenger.setYHeadRot(passenger.getYHeadRot() + this.deltaRotation);
            passenger.setYHeadRot(passenger.getYHeadRot() + this.deltaRotation);
            this.clampRotation(passenger);


//            if (p_38379_ instanceof Animal && this.getPassengers().size() > 1) {
//                int j = p_38379_.getId() % 2 == 0 ? 90 : 270;
//                p_38379_.setYBodyRot(((Animal) p_38379_).yBodyRot + (float) j);
//                p_38379_.setYHeadRot(p_38379_.getYHeadRot() + (float) j);
//            }

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

    public void clampRotation(Entity p_38322_) {
        p_38322_.setYBodyRot(this.getYRot());
        float f = Mth.wrapDegrees(p_38322_.getYRot() - this.getYRot());
        float f1 = Mth.clamp(f, -105.0F, 105.0F);
        p_38322_.yRotO += f1 - f;
        p_38322_.setYRot(p_38322_.getYRot() + f1 - f);
        p_38322_.setYHeadRot(p_38322_.getYRot());
    }

    public void onPassengerTurned(Entity passenger) {
        this.clampRotation(passenger);
    }

    protected void addAdditionalSaveData(CompoundTag tag) {
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

    protected void readAdditionalSaveData(CompoundTag tag) {
        ListTag listtag = tag.getList("Items", 10);

        this.createInventory();
        for (int i = 0; i < listtag.size(); ++i) {
            CompoundTag compoundtag = listtag.getCompound(i);
            int j = compoundtag.getByte("Slot") & 255;
            if (j >= 0 && j < this.inventory.getContainerSize()) {
                this.inventory.setItem(j, ItemStack.of(compoundtag));
            }
        }
        this.updateContainerEquipment();
    }

    @Override
    public void load(CompoundTag tag) {
        ListTag listtag = tag.getList("Items", 10);

        this.createInventory();
        for (int i = 0; i < listtag.size(); ++i) {
            CompoundTag compoundtag = listtag.getCompound(i);
            int j = compoundtag.getByte("Slot") & 255;
            if (j >= 0 && j < this.inventory.getContainerSize()) {
                this.inventory.setItem(j, ItemStack.of(compoundtag));
            }
        }
        this.updateContainerEquipment();

        super.load(tag);
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
        if (this.getPassengers().contains(player)) return InteractionResult.PASS;

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

//    protected void checkFallDamage(double p_38307_, boolean p_38308_, BlockState p_38309_, BlockPos p_38310_) {
    ////        double lastYd = this.getDeltaMovement().y;
//        if (!this.isPassenger()) {
//            if (p_38308_) {
//                if (this.fallDistance > 3.0F) {
//                    if (this.status != Buggy.Status.ON_LAND) {
//                        this.resetFallDistance();
//                        return;
//                    }
//
//                    this.causeFallDamage(this.fallDistance, 1.0F, DamageSource.FALL);
//                    if (!this.level.isClientSide && !this.isRemoved()) {
//                        this.kill();
//                        if (this.level.getGameRules().getBoolean(GameRules.RULE_DOENTITYDROPS)) {
//                            for (int i = 0; i < 3; ++i) {
//                                this.spawnAtLocation(this.getDyeType().getDye());
//                            }
//                        }
//                    }
//                }
//
//                this.resetFallDistance();
//            } else if (!this.level.getFluidState(this.blockPosition().below()).is(FluidTags.WATER) && p_38307_ < 0.0D) {
//                this.fallDistance -= (float) p_38307_;
//            }
//
//        }
//    }

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
        return this.status == Buggy.Status.UNDER_WATER || this.status == Buggy.Status.UNDER_FLOWING_WATER;
    }

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
}