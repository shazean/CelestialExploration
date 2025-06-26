package com.shim.celestialexploration.entity.robots;

import com.shim.celestialexploration.entity.client.dispatchers.CobblesaurusDispatcher;
import com.shim.celestialexploration.entity.client.dispatchers.RoverDispatcher;
import mod.azure.azurelib.animatable.GeoEntity;
import mod.azure.azurelib.core.animatable.instance.AnimatableInstanceCache;
import mod.azure.azurelib.core.animation.AnimatableManager;
import mod.azure.azurelib.core.animation.AnimationController;
import mod.azure.azurelib.core.animation.RawAnimation;
import mod.azure.azurelib.rewrite.util.MoveAnalysis;
import mod.azure.azurelib.util.AzureLibUtil;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.NbtUtils;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;

import javax.annotation.Nullable;
import java.util.Optional;
import java.util.Random;

public class Rover extends PathfinderMob {
    private static final EntityDataAccessor<Optional<BlockState>> DATA_CARRY_STATE = SynchedEntityData.defineId(Rover.class, EntityDataSerializers.BLOCK_STATE);
    public final RoverDispatcher dispatcher;
    private final MoveAnalysis moveAnalysis;

    public Rover(EntityType<? extends PathfinderMob> p_21683_, Level p_21684_) {
        super(p_21683_, p_21684_);
        this.dispatcher = new RoverDispatcher(this);
        this.moveAnalysis = new MoveAnalysis(this);

    }

    protected void registerGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(2, new WaterAvoidingRandomStrollGoal(this, 1.0D));
//        this.goalSelector.addGoal(1, new PanicGoal(this, 1.2D));
        this.goalSelector.addGoal(3, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.goalSelector.addGoal(3, new RandomLookAroundGoal(this));
        this.goalSelector.addGoal(5, new FollowMobGoal(this, 1.0D, 3.0F, 7.0F));
        this.goalSelector.addGoal(9, new RoverLeaveBlockGoal(this));
        this.goalSelector.addGoal(7, new RoverTakeBlockGoal(this));
    }

    public static boolean checkRoverSpawnRules(EntityType<Rover> rover, LevelAccessor level, MobSpawnType spawnType, BlockPos pos, Random random) {
        return random.nextInt(10) == 0 && checkMobSpawnRules(rover, level, spawnType, pos, random);
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Monster.createMonsterAttributes().add(Attributes.MOVEMENT_SPEED, 0.23).add(Attributes.FOLLOW_RANGE, 48.0D);
    }

    @Override
    public void tick() {
        super.tick();
        moveAnalysis.update();

        if (this.level.isClientSide()) { // Only execute animation logic on the client
            boolean isMovingOnGround = moveAnalysis.isMovingHorizontally() && this.isOnGround();

            if (isMovingOnGround) {
                dispatcher.roll();
            } else {
                dispatcher.idle();
            }
        }
    }

    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(DATA_CARRY_STATE, Optional.empty());
    }

    public void addAdditionalSaveData(CompoundTag nbt) {
        super.addAdditionalSaveData(nbt);
        BlockState blockstate = this.getCarriedBlock();
        if (blockstate != null) {
            nbt.put("carriedBlockState", NbtUtils.writeBlockState(blockstate));
        }
    }

    public void readAdditionalSaveData(CompoundTag nbt) {
        super.readAdditionalSaveData(nbt);
        BlockState blockstate = null;
        if (nbt.contains("carriedBlockState", 10)) {
            blockstate = NbtUtils.readBlockState(nbt.getCompound("carriedBlockState"));
            if (blockstate.isAir()) {
                blockstate = null;
            }
        }
        this.setCarriedBlock(blockstate);
    }

    public void setCarriedBlock(@Nullable BlockState p_32522_) {
        this.entityData.set(DATA_CARRY_STATE, Optional.ofNullable(p_32522_));
    }

    @Nullable
    public BlockState getCarriedBlock() {
        return this.entityData.get(DATA_CARRY_STATE).orElse((BlockState)null);
    }

    static class RoverLeaveBlockGoal extends Goal {
        private final Rover rover;

        public RoverLeaveBlockGoal(Rover p_32556_) {
            this.rover = p_32556_;
        }

        public boolean canUse() {
            if (this.rover.getCarriedBlock() == null) {
                return false;
            } else if (!net.minecraftforge.event.ForgeEventFactory.getMobGriefingEvent(this.rover.level, this.rover)) {
                return false;
            } else {
                return this.rover.getRandom().nextInt(reducedTickDelay(2000)) == 0;
            }
        }

        public void tick() {
            Random random = this.rover.getRandom();
            Level level = this.rover.level;
            int i = Mth.floor(this.rover.getX() - 1.0D + random.nextDouble() * 2.0D);
            int j = Mth.floor(this.rover.getY() + random.nextDouble() * 2.0D);
            int k = Mth.floor(this.rover.getZ() - 1.0D + random.nextDouble() * 2.0D);
            BlockPos blockpos = new BlockPos(i, j, k);
            BlockState blockstate = level.getBlockState(blockpos);
            BlockPos blockpos1 = blockpos.below();
            BlockState blockstate1 = level.getBlockState(blockpos1);
            BlockState blockstate2 = this.rover.getCarriedBlock();
            if (blockstate2 != null) {
                blockstate2 = Block.updateFromNeighbourShapes(blockstate2, this.rover.level, blockpos);
                if (this.canPlaceBlock(level, blockpos, blockstate2, blockstate, blockstate1, blockpos1) && !net.minecraftforge.event.ForgeEventFactory.onBlockPlace(rover, net.minecraftforge.common.util.BlockSnapshot.create(level.dimension(), level, blockpos1), net.minecraft.core.Direction.UP)) {
                    level.setBlock(blockpos, blockstate2, 3);
                    level.gameEvent(this.rover, GameEvent.BLOCK_PLACE, blockpos);
                    this.rover.setCarriedBlock((BlockState)null);
                }

            }
        }

        private boolean canPlaceBlock(Level p_32559_, BlockPos p_32560_, BlockState p_32561_, BlockState p_32562_, BlockState p_32563_, BlockPos p_32564_) {
            return p_32562_.isAir() && !p_32563_.isAir() && !p_32563_.is(Blocks.BEDROCK) && !p_32563_.is(net.minecraftforge.common.Tags.Blocks.ENDERMAN_PLACE_ON_BLACKLIST) && p_32563_.isCollisionShapeFullBlock(p_32559_, p_32564_) && p_32561_.canSurvive(p_32559_, p_32560_) && p_32559_.getEntities(this.rover, AABB.unitCubeFromLowerCorner(Vec3.atLowerCornerOf(p_32560_))).isEmpty();
        }
    }

    static class RoverTakeBlockGoal extends Goal {
        private final Rover rover;

        public RoverTakeBlockGoal(Rover p_32585_) {
            this.rover = p_32585_;
        }

        public boolean canUse() {
            if (this.rover.getCarriedBlock() != null) {
                return false;
            } else if (!net.minecraftforge.event.ForgeEventFactory.getMobGriefingEvent(this.rover.level, this.rover)) {
                return false;
            } else {
                return this.rover.getRandom().nextInt(reducedTickDelay(20)) == 0;
            }
        }

        public void tick() {
            Random random = this.rover.getRandom();
            Level level = this.rover.level;
            int i = Mth.floor(this.rover.getX() - 2.0D + random.nextDouble() * 4.0D);
            int j = Mth.floor(this.rover.getY() + random.nextDouble() * 3.0D);
            int k = Mth.floor(this.rover.getZ() - 2.0D + random.nextDouble() * 4.0D);
            BlockPos blockpos = new BlockPos(i, j, k);
            BlockState blockstate = level.getBlockState(blockpos);
            Vec3 vec3 = new Vec3((double)this.rover.getBlockX() + 0.5D, (double)j + 0.5D, (double)this.rover.getBlockZ() + 0.5D);
            Vec3 vec31 = new Vec3((double)i + 0.5D, (double)j + 0.5D, (double)k + 0.5D);
            BlockHitResult blockhitresult = level.clip(new ClipContext(vec3, vec31, ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, this.rover));
            boolean flag = blockhitresult.getBlockPos().equals(blockpos);
            if (blockstate.is(BlockTags.ENDERMAN_HOLDABLE) && flag) {
                level.removeBlock(blockpos, false);
                level.gameEvent(this.rover, GameEvent.BLOCK_DESTROY, blockpos);
                this.rover.setCarriedBlock(blockstate.getBlock().defaultBlockState());
            }

        }
    }
}