package com.shim.celestialexploration.entity;

import com.google.common.collect.Lists;
import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestialexploration.capabilities.LoxTankCapability;
import com.shim.celestialexploration.config.CelestialCommonConfig;
import com.shim.celestialexploration.inventory.menus.SpaceshipMenu;
import com.shim.celestialexploration.packets.CelestialPacketHandler;
import com.shim.celestialexploration.packets.SpaceshipFuelTickPacket;
import com.shim.celestialexploration.registry.*;
import com.shim.celestialexploration.util.CelestialUtil;
import com.shim.celestialexploration.util.Keybinds;
import com.shim.celestialexploration.world.portal.CelestialTeleporter;
import net.minecraft.BlockUtil;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.core.RegistryAccess;
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
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.Mth;
import net.minecraft.world.*;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.WaterAnimal;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.vehicle.DismountHelper;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.RecipeManager;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.WaterlilyBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkSource;
import net.minecraft.world.level.entity.LevelEntityGetter;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.saveddata.maps.MapItemSavedData;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.world.scores.Scoreboard;
import net.minecraft.world.ticks.LevelTickAccess;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.wrapper.InvWrapper;
import net.minecraftforge.network.NetworkHooks;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.util.List;

public class Spaceship extends Entity implements ContainerListener, MenuProvider {
    private static final EntityDataAccessor<Integer> DATA_ID_HURT = SynchedEntityData.defineId(Spaceship.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Integer> DATA_ID_HURTDIR = SynchedEntityData.defineId(Spaceship.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Float> DATA_ID_DAMAGE = SynchedEntityData.defineId(Spaceship.class, EntityDataSerializers.FLOAT);
    private static final EntityDataAccessor<Integer> DATA_ID_TYPE = SynchedEntityData.defineId(Spaceship.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Boolean> DATA_ID_PADDLE_LEFT = SynchedEntityData.defineId(Spaceship.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Boolean> DATA_ID_PADDLE_RIGHT = SynchedEntityData.defineId(Spaceship.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Integer> DATA_ID_BUBBLE_TIME = SynchedEntityData.defineId(Spaceship.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Byte> DATA_ID_FLAGS = SynchedEntityData.defineId(Spaceship.class, EntityDataSerializers.BYTE);
    private static final EntityDataAccessor<Integer> DATA_ID_TIME_ON_GROUND = SynchedEntityData.defineId(Spaceship.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Integer> DATA_ID_FUEL_TICKS = SynchedEntityData.defineId(Spaceship.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Integer> DATA_ID_FUEL = SynchedEntityData.defineId(Spaceship.class, EntityDataSerializers.INT);
    private float outOfControlTicks;
    public float deltaRotation;
    private int lerpSteps;
    private double lerpX;
    private double lerpY;
    private double lerpZ;
    private double lerpYRot;
    private double lerpXRot;
    private Spaceship.Status status;
    private static final float SPACESHIP_SPEED = (float) (double) CelestialCommonConfig.SPACESHIP_SPEED.get();
    private static final float SPACESHIP_LOW_FUEL_SPEED = SPACESHIP_SPEED - .15F;
    private static final float SPACESHIP_NO_FUEL_SPEED = .2F;
    private static final float SPACESHIP_IN_SPACE_SPEED = SPACESHIP_SPEED + .15F;
    protected SimpleContainer inventory;
    private static final int MAX_FUEL_TICKS = CelestialCommonConfig.SPACESHIP_FUEL_RATE.get();
    private int teleportationCooldown = 60;
    public static int maxTimeOnGround = 15;
    private final int LOW_FUEL = 300;

    public Spaceship(EntityType<? extends Spaceship> p_38290_, Level p_38291_) {
        super(p_38290_, p_38291_);
        this.blocksBuilding = true;
        this.createInventory();
    }

    public Spaceship(Level p_38293_, double p_38294_, double p_38295_, double p_38296_) {
        this(EntityRegistry.SPACESHIP.get(), p_38293_);
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
        return new SpaceshipMenu(containerId, inventory, this);
    }

    @Override
    public Component getDisplayName() {
        return new TextComponent("Spaceship");
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
        this.entityData.define(DATA_ID_FUEL_TICKS, MAX_FUEL_TICKS);
        this.entityData.define(DATA_ID_FUEL, 0);
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
                this.discard();
            }
            return true;
        } else {
            return true;
        }
    }

    public Item getDropItem() {
        return switch (this.getSpaceshipType()) {
            case BLACK -> ItemRegistry.BLACK_SPACESHIP.get();
            case GREY -> ItemRegistry.GREY_SPACESHIP.get();
            case LIGHT_GREY -> ItemRegistry.LIGHT_GREY_SPACESHIP.get();
            case WHITE -> ItemRegistry.WHITE_SPACESHIP.get();
            case PINK -> ItemRegistry.PINK_SPACESHIP.get();
            case MAGENTA -> ItemRegistry.MAGENTA_SPACESHIP.get();
            case RED -> ItemRegistry.RED_SPACESHIP.get();
            case ORANGE -> ItemRegistry.ORANGE_SPACESHIP.get();
            case YELLOW -> ItemRegistry.YELLOW_SPACESHIP.get();
            case LIME -> ItemRegistry.LIME_SPACESHIP.get();
            case GREEN -> ItemRegistry.GREEN_SPACESHIP.get();
            case CYAN -> ItemRegistry.CYAN_SPACESHIP.get();
            case LIGHT_BLUE -> ItemRegistry.LIGHT_BLUE_SPACESHIP.get();
            case BLUE -> ItemRegistry.BLUE_SPACESHIP.get();
            case PURPLE -> ItemRegistry.PURPLE_SPACESHIP.get();
            default -> ItemRegistry.WHITE_SPACESHIP.get();
        };
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

    public void setFuelTicks(int ticks) {
        this.entityData.set(DATA_ID_FUEL_TICKS, ticks);
    }

    public int getFuelTicks() {
        return this.entityData.get(DATA_ID_FUEL_TICKS);
    }

    public void setFuelDataId(int mb) {
        this.entityData.set(DATA_ID_FUEL, mb);
    }

    public int getFuelDataId() {
        return this.entityData.get(DATA_ID_FUEL);
    }

    public boolean isFuelDataIdLowFuel() {
        return getFuelDataId() <= LOW_FUEL;
    }


    public void decrementFuelTicks() {
        this.setFuelTicks(this.getFuelTicks() - 1);
    }

    public void tick() {
        this.status = this.getStatus();
        if (this.status != Spaceship.Status.UNDER_WATER && this.status != Spaceship.Status.UNDER_FLOWING_WATER) {
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
                this.controlSpaceship();
                if (this.isVehicle()) {
                    if (this.getDeltaMovement().z != 0 || this.getDeltaMovement().x != 0) {
                        CelestialPacketHandler.INSTANCE.sendToServer(new SpaceshipFuelTickPacket(this.getId(), this.getFuelTicks()));
                    }
                } else {
                    this.setDeltaMovement(Vec3.ZERO);
                }
            } else {
                this.setDeltaMovement(Vec3.ZERO);
            }
            this.move(MoverType.SELF, this.getDeltaMovement());
        }

        if (!this.level.isClientSide) {
            if (this.getFuelTicks() <= 0) {
                this.useFuel();
                this.setFuelTicks(MAX_FUEL_TICKS);
            }
            this.setFuelDataId(this.getFuel());
        }

        ResourceKey<Level> currentDimension = this.level.dimension();

        if (isVehicle() && isTeleportHeight()) {
            if (!(currentDimension == DimensionRegistry.SPACE)) {
                //TODO or FIXME does not allow for multiple passengers. Update if we want spaceship to allow multiple passengers in the future
                if (this.level.dimension() == DimensionRegistry.VENUS) teleportToSpace(2);
                if (this.level.dimension() == Level.OVERWORLD || this.level.dimension() == DimensionRegistry.MOON)
                    teleportToSpace(3);
                if (this.level.dimension() == DimensionRegistry.MARS) teleportToSpace(4);
            } else {
                resetTelportationCooldown();
            }
        }

        if (this.isVehicle() && currentDimension == DimensionRegistry.SPACE) {
            ChunkPos spaceshipChunkPos = new ChunkPos(this.blockPosition());
            ResourceKey<Level> destination = getTeleportLocation(this, spaceshipChunkPos);
            if (destination != null) {
                if (this.teleportationCooldown == 0) {
                    Entity passenger = this.getControllingPassenger();
                    assert passenger != null;

                    Vec3 teleportPosition = new Vec3(this.position().x, this.position().y, this.position().z); //this.level.getMaxBuildHeight() - 10, this.position().z);
                    teleportSpaceship(passenger, this, destination, teleportPosition);
                } else {
                    this.teleportationCooldown--;
                    this.displayTeleportMessage(this.teleportationCooldown, destination);
                }
            }
            if (destination == null) {
                this.resetTelportationCooldown();
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

    public void teleportToSpace(int planetOriginNum) {
        if (this.teleportationCooldown == 0) {
            Entity passenger = this.getControllingPassenger();
            this.displayTeleportMessage(teleportationCooldown, DimensionRegistry.SPACE);
            assert passenger != null;
            ResourceKey<Level> destination = DimensionRegistry.SPACE;
            Vec3 earthLocation = new Vec3(CelestialUtil.getPlanetaryChunkCoordinates(planetOriginNum).x * 16, 135.0, CelestialUtil.getPlanetaryChunkCoordinates(planetOriginNum).z * 16);
            this.teleportSpaceship(passenger, this, destination, earthLocation);
        } else {
            this.teleportationCooldown--;
            this.displayTeleportMessage(teleportationCooldown, DimensionRegistry.SPACE);
        }
    }

    public static ResourceKey<Level> getTeleportLocation(Spaceship spaceship, ChunkPos spaceshipChunkPos) {
        if (spaceship.position().y > 130) return null;

        Vec3 mercuryLocation = new Vec3(CelestialUtil.getPlanetaryChunkCoordinates(1).x, spaceship.position().y, CelestialUtil.getPlanetaryChunkCoordinates(1).z);
        ChunkPos planetChunkPos = new ChunkPos((int) mercuryLocation.x, (int) mercuryLocation.z);
        if (CelestialUtil.isInRectangle(planetChunkPos.x, planetChunkPos.z, 2, spaceshipChunkPos.x, spaceshipChunkPos.z)) {
//                return DimensionRegistry.MERCURY;
        }

        Vec3 venusLocation = new Vec3(CelestialUtil.getPlanetaryChunkCoordinates(2).x, spaceship.position().y, CelestialUtil.getPlanetaryChunkCoordinates(2).z);
        planetChunkPos = new ChunkPos((int) venusLocation.x, (int) venusLocation.z);
        if (CelestialUtil.isInRectangle(planetChunkPos.x, planetChunkPos.z, 2, spaceshipChunkPos.x, spaceshipChunkPos.z)) {
            if (isNearBlockOfPlanet(spaceship, BlockRegistry.VENUS_CORE.get())) {
                return DimensionRegistry.VENUS;
            }
        }

        Vec3 earthLocation = new Vec3(CelestialUtil.getPlanetaryChunkCoordinates(3).x, spaceship.position().y, CelestialUtil.getPlanetaryChunkCoordinates(3).z);
        planetChunkPos = new ChunkPos((int) earthLocation.x, (int) earthLocation.z);
        if (CelestialUtil.isInRectangle(planetChunkPos.x, planetChunkPos.z, 4, spaceshipChunkPos.x, spaceshipChunkPos.z)) {
            if (isNearBlockOfMoon(spaceship, BlockRegistry.MOON_CORE.get())) { //BlockRegistry.MOON_CORE.get())) {
                return DimensionRegistry.MOON;
            } else if (isNearBlockOfPlanet(spaceship, Blocks.BEDROCK)) { //Blocks.BEDROCK)) {
                return Level.OVERWORLD;
            }
        }

        Vec3 marsLocation = new Vec3(CelestialUtil.getPlanetaryChunkCoordinates(4).x, spaceship.position().y, CelestialUtil.getPlanetaryChunkCoordinates(4).z);
        planetChunkPos = new ChunkPos((int) marsLocation.x, (int) marsLocation.z);
        if (CelestialUtil.isInRectangle(planetChunkPos.x, planetChunkPos.z, 2, spaceshipChunkPos.x, spaceshipChunkPos.z)) {
            if (isNearBlockOfPlanet(spaceship, BlockRegistry.MARS_CORE.get())) { //BlockRegistry.MARS_CORE.get())) {
                return DimensionRegistry.MARS;
            }
        }

        Vec3 jupiterLocation = new Vec3(CelestialUtil.getPlanetaryChunkCoordinates(5).x, spaceship.position().y, CelestialUtil.getPlanetaryChunkCoordinates(5).z);
        planetChunkPos = new ChunkPos((int) jupiterLocation.x, (int) jupiterLocation.z);
        if (CelestialUtil.isInRectangle(planetChunkPos.x, planetChunkPos.z, 2, spaceshipChunkPos.x, spaceshipChunkPos.z)) {
//                return DimensionRegistry.JUPITER;
        }

        Vec3 saturnLocation = new Vec3(CelestialUtil.getPlanetaryChunkCoordinates(6).x, spaceship.position().y, CelestialUtil.getPlanetaryChunkCoordinates(6).z);
        planetChunkPos = new ChunkPos((int) saturnLocation.x, (int) saturnLocation.z);
        if (CelestialUtil.isInRectangle(planetChunkPos.x, planetChunkPos.z, 2, spaceshipChunkPos.x, spaceshipChunkPos.z)) {
//                return DimensionRegistry.SATURN;
        }

        Vec3 uranusLocation = new Vec3(CelestialUtil.getPlanetaryChunkCoordinates(7).x, spaceship.position().y, CelestialUtil.getPlanetaryChunkCoordinates(7).z);
        planetChunkPos = new ChunkPos((int) uranusLocation.x, (int) uranusLocation.z);
        if (CelestialUtil.isInRectangle(planetChunkPos.x, planetChunkPos.z, 2, spaceshipChunkPos.x, spaceshipChunkPos.z)) {
//                return DimensionRegistry.JUPITER;
        }

        Vec3 neptuneLocation = new Vec3(CelestialUtil.getPlanetaryChunkCoordinates(8).x, spaceship.position().y, CelestialUtil.getPlanetaryChunkCoordinates(8).z);
        planetChunkPos = new ChunkPos((int) neptuneLocation.x, (int) neptuneLocation.z);
        if (CelestialUtil.isInRectangle(planetChunkPos.x, planetChunkPos.z, 2, spaceshipChunkPos.x, spaceshipChunkPos.z)) {
//                return DimensionRegistry.NEPTUNE;
        }
        return null;
    }

    public void displayTeleportMessage(int teleportCooldown, ResourceKey<Level> destination) {
        Entity entity = this.getControllingPassenger();

        if (entity instanceof Player) {
            if (teleportCooldown % 20 == 0) {
                ((Player) entity).displayClientMessage(Component.nullToEmpty("Teleporting to " + destination.location().getPath().toUpperCase() + " in… " + teleportCooldown / 20), true);
            } else if (teleportCooldown == 0) {
                ((Player) entity).displayClientMessage(Component.nullToEmpty("Teleporting!"), true);
            }
        }
    }

    public static boolean isNearBlockOfPlanet(Spaceship spaceship, Block blockToTest) {
        BlockPos pos;
        BlockState state;
        int i = 30;

        for (int x = -i; x <= i; x++) {
            for (int y = -i; y <= i; y++) {
                for (int z = -i; z <= i; z++) {
                    pos = new BlockPos(spaceship.position().x + x, spaceship.position().y + y, spaceship.position().z + z);
                    state = spaceship.level.getBlockState(pos);
                    if (state.getBlock() == blockToTest) return true;
                }
            }
        }
        return false;
    }

    public static boolean isNearBlockOfMoon(Spaceship spaceship, Block blockToTest) {
        BlockPos pos;
        BlockState state;
        int i = 18;

        for (int x = -i; x <= i; x++) {
            for (int y = -i; y <= i; y++) {
                for (int z = -i; z <= i; z++) {
                    pos = new BlockPos(spaceship.position().x + x, spaceship.position().y + y, spaceship.position().z + z);
                    state = spaceship.level.getBlockState(pos);
                    if (state.getBlock() == blockToTest) return true;
                }
            }
        }
        return false;
    }

    public boolean isTeleportHeight() {
        return this.isVehicle() && this.position().y > this.level.getMaxBuildHeight() + 10;
    }

    protected void resetTelportationCooldown() {
        this.teleportationCooldown = 80;
    }

    public int getTelportationCooldown() {
        return this.teleportationCooldown;
    }

    protected void teleportSpaceship(Entity passenger, Spaceship spaceship, ResourceKey<Level> destinationDim, Vec3 locationInPlace) {
        if (passenger.canChangeDimensions()) {

            Level entityWorld = passenger.level;
            MinecraftServer minecraftserver = entityWorld.getServer();
            if (minecraftserver != null) {
                ServerLevel destinationWorld = minecraftserver.getLevel(destinationDim);
                if (destinationWorld != null) {
                    this.resetTelportationCooldown();
                    passenger.changeDimension(destinationWorld, new CelestialTeleporter(destinationWorld));
                    Entity newSpaceship = spaceship.changeDimension(destinationWorld, new CelestialTeleporter(destinationWorld));

                    if (!(destinationDim == DimensionRegistry.SPACE)) {
                        locationInPlace = new Vec3(locationInPlace.x, passenger.level.getMaxBuildHeight() - 10, locationInPlace.z);
                    }

                    if (passenger instanceof ServerPlayer player) {
                        ServerLevel level = player.getLevel();
                        level.getProfiler().push("placing");
                        player.moveTo(locationInPlace.x, locationInPlace.y, locationInPlace.z);
                        level.getProfiler().pop();
                    } else {
                        passenger.moveTo(locationInPlace);
                    }
                    assert newSpaceship != null;
                    newSpaceship.moveTo(locationInPlace.x, locationInPlace.y, locationInPlace.z);
                    ((Spaceship) newSpaceship).hasFuel();

                    if (!this.level.isClientSide) {
                        passenger.startRiding(newSpaceship);
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

    private Spaceship.Status getStatus() {
        Spaceship.Status spaceship$status = this.isUnderwater();
        if (spaceship$status != null) {
            return spaceship$status;
        } else {
            float f = this.getGroundFriction();
            if (f > 0.0F) return Spaceship.Status.ON_LAND;
            else return Spaceship.Status.IN_AIR;
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
    private Spaceship.Status isUnderwater() {
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
                        if (!fluidstate.isSource()) return Spaceship.Status.UNDER_FLOWING_WATER;
                        flag = true;
                    }
                }
            }
        }
        return flag ? Spaceship.Status.UNDER_WATER : null;
    }

    public boolean hasFuel() {
        LoxTankCapability.ILoxTank firstTankCap = getTankCap(this.inventory.getItem(0));
        LoxTankCapability.ILoxTank secondTankCap = getTankCap(this.inventory.getItem(1));
        LoxTankCapability.ILoxTank thirdTankCap = getTankCap(this.inventory.getItem(2));
        LoxTankCapability.ILoxTank fourthTankCap = getTankCap(this.inventory.getItem(3));

        if (firstTankCap != null && !firstTankCap.isEmpty()) return true;
        if (secondTankCap != null && !secondTankCap.isEmpty()) return true;
        if (thirdTankCap != null && !thirdTankCap.isEmpty()) return true;
        if (fourthTankCap != null) return !fourthTankCap.isEmpty();

        return false;
    }

    private void useFuel() {
        LoxTankCapability.ILoxTank firstTankCap = getTankCap(this.inventory.getItem(0));
        LoxTankCapability.ILoxTank secondTankCap = getTankCap(this.inventory.getItem(1));
        LoxTankCapability.ILoxTank thirdTankCap = getTankCap(this.inventory.getItem(2));
        LoxTankCapability.ILoxTank fourthTankCap = getTankCap(this.inventory.getItem(3));

        if (hasLowFuel()) {
            if (firstTankCap != null && !firstTankCap.isEmpty()) firstTankCap.decrementAmountByFifty();
            else if (secondTankCap != null && !secondTankCap.isEmpty()) secondTankCap.decrementAmountByFifty();
            else if (thirdTankCap != null && !thirdTankCap.isEmpty()) thirdTankCap.decrementAmountByFifty();
            else if (fourthTankCap != null && !fourthTankCap.isEmpty()) fourthTankCap.decrementAmountByFifty();
        } else {
            if (firstTankCap != null && !firstTankCap.isEmpty()) firstTankCap.decrementAmount();
            else if (secondTankCap != null && !secondTankCap.isEmpty()) secondTankCap.decrementAmount();
            else if (thirdTankCap != null && !thirdTankCap.isEmpty()) thirdTankCap.decrementAmount();
            else if (fourthTankCap != null && !fourthTankCap.isEmpty()) fourthTankCap.decrementAmount();
        }
    }

    public boolean hasLowFuel() {
        return getFuel() <= LOW_FUEL;
    }

    private LoxTankCapability.ILoxTank getTankCap(ItemStack tank) {
        return CelestialExploration.getCapability(tank, CapabilityRegistry.LOX_TANK_CAPABILITY);
    }

    public int getFuel() {
        int totalFuel = 0;

        LoxTankCapability.ILoxTank firstTankCap = getTankCap(this.inventory.getItem(0));
        LoxTankCapability.ILoxTank secondTankCap = getTankCap(this.inventory.getItem(1));
        LoxTankCapability.ILoxTank thirdTankCap = getTankCap(this.inventory.getItem(2));
        LoxTankCapability.ILoxTank fourthTankCap = getTankCap(this.inventory.getItem(3));

        if (firstTankCap != null && !firstTankCap.isEmpty()) totalFuel += firstTankCap.getAmount();
        if (secondTankCap != null && !secondTankCap.isEmpty()) totalFuel += secondTankCap.getAmount();
        if (thirdTankCap != null && !thirdTankCap.isEmpty()) totalFuel += thirdTankCap.getAmount();
        if (fourthTankCap != null && !fourthTankCap.isEmpty()) totalFuel += fourthTankCap.getAmount();

        return totalFuel;
    }

    public float getMaxSpeed() {
        Entity passenger = this.getControllingPassenger();
        if (passenger instanceof Player player) {
            if (player.isCreative()) {
                if (CelestialCommonConfig.SPACESHIP_FASTER_IN_SPACE.get() && this.level.dimension() == DimensionRegistry.SPACE)
                    return SPACESHIP_IN_SPACE_SPEED;
                return SPACESHIP_SPEED;
            }
        }

        if (this.getFuelDataId() > 0) {
            if (this.getFuelDataId() <= LOW_FUEL) return SPACESHIP_LOW_FUEL_SPEED;
            if (CelestialCommonConfig.SPACESHIP_FASTER_IN_SPACE.get() && this.level.dimension() == DimensionRegistry.SPACE)
                return SPACESHIP_IN_SPACE_SPEED;
            return SPACESHIP_SPEED;
        }
        return SPACESHIP_NO_FUEL_SPEED;
    }

    public double getCurrentSpeed() {
        return this.getDeltaMovement().x;
    }


    private void controlSpaceship() {
        if (this.isVehicle()) {
            float currentSpeed;
            currentSpeed = this.getMaxSpeed();

            LivingEntity livingentity = (LivingEntity) this.getControllingPassenger();
            assert livingentity != null;
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

            if (Keybinds.ASCEND_KEY.isDown()) f1 = currentSpeed;
            else if (Keybinds.DESCEND_KEY.isDown())
                f1 = -1 * SPACESHIP_SPEED; //spaceship can always descend at normal speed
            else f1 = 0;

            this.setDeltaMovement((Mth.sin(-this.getYRot() * ((float) Math.PI / 180F)) * f), f1, (Mth.cos(this.getYRot() * ((float) Math.PI / 180F)) * f));
        }
    }

    public double getPassengersRidingOffset() {  //FIXME
        return 0.45D;
    }

    public void positionRider(Entity p_38379_) {
        if (this.hasPassenger(p_38379_)) {
            float f = 1.1F; //4.0F

            if (p_38379_ instanceof Animal) {
                f += 0.2F;
            }

            float f1 = (float) ((this.isRemoved() ? (double) 0.01F : this.getPassengersRidingOffset()) + p_38379_.getMyRidingOffset());
            if (this.getPassengers().size() > 1) {
                int i = this.getPassengers().indexOf(p_38379_);
                if (i == 0) {
                    f = -0.0F; //0.2F
                } else {
                    f = 1.1F;
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
        tag.putString("Type", this.getSpaceshipType().getName());
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

        if (!this.inventory.getItem(0).isEmpty())
            tag.put("Fuel Tank 1", this.getTankCap(this.inventory.getItem(0)).getLoxData());
        if (!this.inventory.getItem(1).isEmpty())
            tag.put("Fuel Tank 2", this.getTankCap(this.inventory.getItem(1)).getLoxData());
        if (!this.inventory.getItem(2).isEmpty())
            tag.put("Fuel Tank 3", this.getTankCap(this.inventory.getItem(2)).getLoxData());
        if (!this.inventory.getItem(3).isEmpty())
            tag.put("Fuel Tank 4", this.getTankCap(this.inventory.getItem(3)).getLoxData());
    }

    protected void readAdditionalSaveData(CompoundTag tag) {
        if (tag.contains("Type", 8)) {
            this.setType(Spaceship.Type.byName(tag.getString("Type")));
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

        if (tag.contains("Fuel Tank 1"))
            this.getTankCap(this.inventory.getItem(0)).setLoxData(tag.getCompound("Fuel Tank 1"));
        if (tag.contains("Fuel Tank 2"))
            this.getTankCap(this.inventory.getItem(1)).setLoxData(tag.getCompound("Fuel Tank 2"));
        if (tag.contains("Fuel Tank 3"))
            this.getTankCap(this.inventory.getItem(2)).setLoxData(tag.getCompound("Fuel Tank 3"));
        if (tag.contains("Fuel Tank 4"))
            this.getTankCap(this.inventory.getItem(3)).setLoxData(tag.getCompound("Fuel Tank 4"));
        this.updateContainerEquipment();

    }

    @Override
    public void load(CompoundTag tag) {
        if (tag.contains("Type", 8)) {
            this.setType(Spaceship.Type.byName(tag.getString("Type")));
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

        if (tag.contains("Fuel Tank 1"))
            this.getTankCap(this.inventory.getItem(0)).setLoxData(tag.getCompound("Fuel Tank 1"));
        if (tag.contains("Fuel Tank 2"))
            this.getTankCap(this.inventory.getItem(1)).setLoxData(tag.getCompound("Fuel Tank 2"));
        if (tag.contains("Fuel Tank 3"))
            this.getTankCap(this.inventory.getItem(2)).setLoxData(tag.getCompound("Fuel Tank 3"));
        if (tag.contains("Fuel Tank 4"))
            this.getTankCap(this.inventory.getItem(3)).setLoxData(tag.getCompound("Fuel Tank 4"));
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
                    if (this.status != Spaceship.Status.ON_LAND) {
                        this.resetFallDistance();
                        return;
                    }

                    this.causeFallDamage(this.fallDistance, 1.0F, DamageSource.FALL);
                    if (!this.level.isClientSide && !this.isRemoved()) {
                        this.kill();
                        if (this.level.getGameRules().getBoolean(GameRules.RULE_DOENTITYDROPS)) {
                            for (int i = 0; i < 3; ++i) {
                                this.spawnAtLocation(this.getSpaceshipType().getDye());
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

    public void setType(Spaceship.Type p_38333_) {
        this.entityData.set(DATA_ID_TYPE, p_38333_.ordinal());
    }

    public Spaceship.Type getSpaceshipType() {
        return Spaceship.Type.byId(this.entityData.get(DATA_ID_TYPE));
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
        return this.status == Spaceship.Status.UNDER_WATER || this.status == Spaceship.Status.UNDER_FLOWING_WATER;
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

        public static Spaceship.Type byId(int p_38431_) {
            Spaceship.Type[] spaceship$type = values();
            if (p_38431_ < 0 || p_38431_ >= spaceship$type.length) {
                p_38431_ = 0;
            }
            return spaceship$type[p_38431_];
        }

        public static Spaceship.Type byName(String p_38433_) {
            Spaceship.Type[] spaceship$type = values();

            for (Type type : spaceship$type) {
                if (type.getName().equals(p_38433_)) {
                    return type;
                }
            }
            return spaceship$type[0];
        }
    }
}