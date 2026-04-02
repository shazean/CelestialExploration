package com.shim.celestialexploration.entity.creatures;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.mojang.datafixers.util.Pair;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.Brain;
import net.minecraft.world.entity.ai.behavior.*;
import net.minecraft.world.entity.ai.memory.MemoryModuleType;
import net.minecraft.world.entity.ai.memory.MemoryStatus;
import net.minecraft.world.entity.ai.memory.WalkTarget;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.ai.util.DefaultRandomPos;
import net.minecraft.world.entity.schedule.Activity;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.pathfinder.Path;
import net.minecraft.world.phys.Vec3;

import javax.annotation.Nullable;
import java.util.Optional;

public class CelestialAxolotlAi {
    private static final UniformInt ADULT_FOLLOW_RANGE = UniformInt.of(5, 16);
    private static final float SPEED_MULTIPLIER_WHEN_MAKING_LOVE = 0.2F;
    private static final float SPEED_MULTIPLIER_ON_LAND = 0.15F;
    private static final float SPEED_MULTIPLIER_WHEN_IDLING_IN_WATER = 0.5F;
    private static final float SPEED_MULTIPLIER_WHEN_CHASING_IN_WATER = 0.6F;
    private static final float SPEED_MULTIPLIER_WHEN_FOLLOWING_ADULT_IN_WATER = 0.6F;

    protected static Brain<?> makeBrain(Brain<CelestialAxolotl> brain) {
        initCoreActivity(brain);
        initIdleActivity(brain);
        initFightActivity(brain);
        initPlayDeadActivity(brain);
        brain.setCoreActivities(ImmutableSet.of(Activity.CORE));
        brain.setDefaultActivity(Activity.IDLE);
        brain.useDefaultActivity();
        return brain;
    }

    private static void initPlayDeadActivity(Brain<CelestialAxolotl> brain) {
        brain.addActivityAndRemoveMemoriesWhenStopped(Activity.PLAY_DEAD, ImmutableList.of(Pair.of(0, new PlayDead()), Pair.of(1, new EraseMemoryIf<>(CelestialAxolotlAi::isBreeding, MemoryModuleType.PLAY_DEAD_TICKS))), ImmutableSet.of(
                Pair.of(MemoryModuleType.PLAY_DEAD_TICKS, MemoryStatus.VALUE_PRESENT)), ImmutableSet.of(MemoryModuleType.PLAY_DEAD_TICKS));
    }

    private static void initFightActivity(Brain<CelestialAxolotl> brain) {
        brain.addActivityAndRemoveMemoryWhenStopped(Activity.FIGHT, 0, ImmutableList.of(new StopAttackingIfTargetInvalid<>(CelestialAxolotl::onStopAttacking),
                new SetWalkTargetFromAttackTargetIfTargetOutOfReach(CelestialAxolotlAi::getSpeedModifierChasing),
                new MeleeAttack(20),
                new EraseMemoryIf<>(CelestialAxolotlAi::isBreeding, MemoryModuleType.ATTACK_TARGET)), MemoryModuleType.ATTACK_TARGET);
    }

    private static void initCoreActivity(Brain<CelestialAxolotl> brain) {
        brain.addActivity(Activity.CORE, 0, ImmutableList.of(
                new LookAtTargetSink(45, 90),
                new MoveToTargetSink(),
                new ValidatePlayDead(),
                new CountDownCooldownTicks(MemoryModuleType.TEMPTATION_COOLDOWN_TICKS)));
    }

    private static void initIdleActivity(Brain<CelestialAxolotl> brain) {
        brain.addActivity(Activity.IDLE, ImmutableList.of(
                Pair.of(0, new RunSometimes<>(new SetEntityLookTarget(EntityType.PLAYER, 6.0F), UniformInt.of(30, 60))),
                Pair.of(1, new AnimalMakeLove(EntityType.AXOLOTL, 0.2F)),
                Pair.of(2, new RunOne<>(ImmutableList.of(Pair.of(new FollowTemptation(CelestialAxolotlAi::getSpeedModifier), 1),
                        Pair.of(new BabyFollowAdult<>(ADULT_FOLLOW_RANGE, CelestialAxolotlAi::getSpeedModifierFollowingAdult), 1)))),
                Pair.of(3, new StartAttacking<>(CelestialAxolotlAi::findNearestValidAttackTarget)),
//                Pair.of(3, new TryFindWater(6, 0.15F)),
                Pair.of(4, new GateBehavior<>(ImmutableMap.of(MemoryModuleType.WALK_TARGET, MemoryStatus.VALUE_ABSENT), ImmutableSet.of(), GateBehavior.OrderPolicy.ORDERED, GateBehavior.RunningPolicy.TRY_ALL, ImmutableList.of(
//                                Pair.of(new RandomSwim(0.5F), 2),
                        Pair.of(new RandomStroll(0.15F, 10, 64, true), 2),
                        Pair.of(new SetWalkTargetFromLookTarget(CelestialAxolotlAi::canSetWalkTargetFromLookTarget, CelestialAxolotlAi::getSpeedModifier, 8), 3) // 3
//                        Pair.of(new RunIf<>(Entity::isInWaterOrBubble, new DoNothing(30, 60)), 5),
//                        Pair.of(new RunIf<>(Entity::isOnGround, new DoNothing(200, 400)), 5)
                )))));
    }

    private static boolean canSetWalkTargetFromLookTarget(LivingEntity entity) {
        Level level = entity.level;
        Optional<PositionTracker> optional = entity.getBrain().getMemory(MemoryModuleType.LOOK_TARGET);
        if (optional.isPresent()) {
            BlockPos blockpos = optional.get().currentBlockPosition();
            return true;
//            return level.isWaterAt(blockpos) == entity.isInWaterOrBubble();
        } else {
            return false;
        }
    }

    public static void updateActivity(CelestialAxolotl axolotl) {
        Brain<CelestialAxolotl> brain = axolotl.getBrain();
        Activity activity = brain.getActiveNonCoreActivity().orElse((Activity)null);
        if (activity != Activity.PLAY_DEAD) {
            brain.setActiveActivityToFirstValid(ImmutableList.of(Activity.PLAY_DEAD, Activity.FIGHT, Activity.IDLE));
            if (activity == Activity.FIGHT && brain.getActiveNonCoreActivity().orElse((Activity)null) != Activity.FIGHT) {
                brain.setMemoryWithExpiry(MemoryModuleType.HAS_HUNTING_COOLDOWN, true, 2400L);
            }
        }
    }

    private static float getSpeedModifierChasing(LivingEntity entity) {
        return 0.6F;
    }

    private static float getSpeedModifierFollowingAdult(LivingEntity entity) {
        return 0.6F;
    }

    private static float getSpeedModifier(LivingEntity entity) {
        return 0.5F;
    }

    private static Optional<? extends LivingEntity> findNearestValidAttackTarget(CelestialAxolotl axolotl) {
        return isBreeding(axolotl) ? Optional.empty() : axolotl.getBrain().getMemory(MemoryModuleType.NEAREST_ATTACKABLE);
    }

    private static boolean isBreeding(CelestialAxolotl axolotl) {
        return axolotl.getBrain().hasMemoryValue(MemoryModuleType.BREED_TARGET);
    }

    public static Ingredient getTemptations() {
        return Ingredient.of(ItemTags.AXOLOTL_TEMPT_ITEMS);
    }

    public static class PlayDead extends Behavior<CelestialAxolotl> {
        public PlayDead() {
            super(ImmutableMap.of(MemoryModuleType.PLAY_DEAD_TICKS, MemoryStatus.VALUE_PRESENT, MemoryModuleType.HURT_BY_ENTITY, MemoryStatus.VALUE_PRESENT), 200);
        }

        protected boolean checkExtraStartConditions(ServerLevel level, CelestialAxolotl axolotl) {
            return true;
//            return axolotl.isInWaterOrBubble();
        }

        protected boolean canStillUse(ServerLevel level, CelestialAxolotl axolotl, long p_149324_) {
            return
//                    axolotl.isInWaterOrBubble() &&
                            axolotl.getBrain().hasMemoryValue(MemoryModuleType.PLAY_DEAD_TICKS);
        }

        protected void start(ServerLevel level, CelestialAxolotl axolotl, long p_149332_) {
            Brain<CelestialAxolotl> brain = axolotl.getBrain();
            brain.eraseMemory(MemoryModuleType.WALK_TARGET);
            brain.eraseMemory(MemoryModuleType.LOOK_TARGET);
            axolotl.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 200, 0));
        }
    }

    public static class ValidatePlayDead extends Behavior<CelestialAxolotl> {
        public ValidatePlayDead() {
            super(ImmutableMap.of(MemoryModuleType.PLAY_DEAD_TICKS, MemoryStatus.VALUE_PRESENT));
        }

        protected void start(ServerLevel level, CelestialAxolotl axolotl, long p_149341_) {
            Brain<CelestialAxolotl> brain = axolotl.getBrain();
            int i = brain.getMemory(MemoryModuleType.PLAY_DEAD_TICKS).get();
            if (i <= 0) {
                brain.eraseMemory(MemoryModuleType.PLAY_DEAD_TICKS);
                brain.eraseMemory(MemoryModuleType.HURT_BY_ENTITY);
                brain.useDefaultActivity();
            } else {
                brain.setMemory(MemoryModuleType.PLAY_DEAD_TICKS, i - 1);
            }

        }
    }
}