package com.shim.celestialexploration.entity.robots;

import com.shim.celestialexploration.entity.client.dispatchers.MechaCrowDispatcher;
import com.shim.celestiallib.api.effects.CLibEffects;
import mod.azure.azurelib.util.MoveAnalysis;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.navigation.FlyingPathNavigation;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.ai.util.AirAndWaterRandomPos;
import net.minecraft.world.entity.ai.util.HoverRandomPos;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.FlyingAnimal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec3;

import java.util.EnumSet;
import java.util.Random;

public class MechaCrow extends TamableAnimal implements FlyingAnimal {
    static double movementSpeed = 0.21;
    public final MechaCrowDispatcher dispatcher;
    private final MoveAnalysis moveAnalysis;

    public MechaCrow(EntityType<? extends TamableAnimal> p_21803_, Level p_21804_) {
        super(p_21803_, p_21804_);
        this.addEffect(new MobEffectInstance(CLibEffects.LOW_GRAVITY.get(), 120000, 0, false, false, true));
        this.dispatcher = new MechaCrowDispatcher(this);
        this.moveAnalysis = new MoveAnalysis(this);
    }

    public boolean causeFallDamage(float p_147105_, float p_147106_, DamageSource p_147107_) {
        return false;
    }

    protected void registerGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));
//        this.goalSelector.addGoal(1, new HoverGoal(this, movementSpeed / 2));
        this.goalSelector.addGoal(2, new MechaCrow.MechaCrowWanderGoal(this));
        this.goalSelector.addGoal(3, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.goalSelector.addGoal(3, new RandomLookAroundGoal(this));
        this.goalSelector.addGoal(1, new FollowOwnerGoal(this, 1.0D, 5.0F, 1.0F, true));
        this.goalSelector.addGoal(5, new FollowMobGoal(this, 1.0D, 3.0F, 7.0F));
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

    protected PathNavigation createNavigation(Level p_29417_) {
        FlyingPathNavigation flyingpathnavigation = new FlyingPathNavigation(this, p_29417_);
        flyingpathnavigation.setCanOpenDoors(false);
        flyingpathnavigation.setCanFloat(true);
        flyingpathnavigation.setCanPassDoors(true);
        return flyingpathnavigation;
    }

    class MechaCrowWanderGoal extends Goal {
        private static final int WANDER_THRESHOLD = 22;
        MechaCrow mechaCrow;

        MechaCrowWanderGoal(MechaCrow mechaCrow) {
            this.setFlags(EnumSet.of(Goal.Flag.MOVE));
            this.mechaCrow = mechaCrow;
        }

        public boolean canUse() {
            return this.mechaCrow.navigation.isDone() && MechaCrow.this.random.nextInt(10) == 0;
        }

        public boolean canContinueToUse() {
            return this.mechaCrow.navigation.isInProgress();
        }

        public void start() {
            Vec3 vec3 = this.findPos();
            if (vec3 != null) {
                this.mechaCrow.navigation.moveTo(this.mechaCrow.navigation.createPath(new BlockPos(vec3), 1), 1.0D);
            }

        }

        @javax.annotation.Nullable
        private Vec3 findPos() {
            Vec3 vec3 = this.mechaCrow.getViewVector(0.0F);
            Vec3 vec32 = HoverRandomPos.getPos(this.mechaCrow, 8, 7, vec3.x, vec3.z, ((float) Math.PI / 2F), 3, 1);
            return vec32 != null ? vec32 : AirAndWaterRandomPos.getPos(this.mechaCrow, 8, 4, -2, vec3.x, vec3.z, (double) ((float) Math.PI / 2F));
        }
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Animal.createLivingAttributes().add(Attributes.MOVEMENT_SPEED, movementSpeed).add(Attributes.FOLLOW_RANGE, 48.0D);
    }

    @Override
    public boolean isFlying() {
        return this.isOnGround();
    }

    @Override
    public void tick() {
        super.tick();

        if (this.isAlive()) {
            if (this.level.isClientSide()) { // Only execute animation logic on the client
                boolean isMovingOnGround = moveAnalysis.isMovingHorizontally() && this.isOnGround();

                if (isMovingOnGround) {
                    dispatcher.hop();
                } else {
                    dispatcher.idle();

                }
            }
        }
    }
}
