package com.shim.celestialexploration.item;

import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestialexploration.entity.DyeType;
import com.shim.celestialexploration.entity.IDyeable;
import com.shim.celestialexploration.entity.entity.friendlies.TamableCreature;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.BaseSpawner;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.SpawnerBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;

import javax.annotation.Nullable;
import java.util.Objects;
import java.util.function.Supplier;

public class AutoTameSpawnItem extends Item {
    @Nullable
    DyeType dyeType;
//    private final EntityType<?> defaultType;
    private final Supplier<? extends EntityType<? extends Mob>> typeSupplier;


    public AutoTameSpawnItem(Supplier<? extends EntityType<? extends Mob>> type, Properties properties) {
        this(type, null, properties);
    }

    public AutoTameSpawnItem(Supplier<? extends EntityType<? extends Mob>> type, @Nullable DyeType dye, Properties properties) {
        super(properties);
        this.typeSupplier = type;
//        this.defaultType = null;
        this.dyeType = dye;
    }

    public InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();
        if (!(level instanceof ServerLevel)) {
            return InteractionResult.SUCCESS;
        } else {
            ItemStack itemstack = context.getItemInHand();
            BlockPos blockpos = context.getClickedPos();
            Direction direction = context.getClickedFace();
            BlockState blockstate = level.getBlockState(blockpos);
            if (blockstate.is(Blocks.SPAWNER)) {
                BlockEntity blockentity = level.getBlockEntity(blockpos);
                if (blockentity instanceof SpawnerBlockEntity) {
                    BaseSpawner basespawner = ((SpawnerBlockEntity)blockentity).getSpawner();
                    EntityType<?> entitytype1 = this.getType(itemstack.getTag());
                    basespawner.setEntityId(entitytype1);
                    blockentity.setChanged();
                    level.sendBlockUpdated(blockpos, blockstate, blockstate, 3);
                    itemstack.shrink(1);
                    return InteractionResult.CONSUME;
                }
            }

            BlockPos blockpos1;
            if (blockstate.getCollisionShape(level, blockpos).isEmpty()) {
                blockpos1 = blockpos;
            } else {
                blockpos1 = blockpos.relative(direction);
            }

            EntityType<?> entitytype = this.getType(itemstack.getTag());
            Entity entity = entitytype.spawn((ServerLevel)level, itemstack, context.getPlayer(), blockpos1, MobSpawnType.SPAWN_EGG, true, !Objects.equals(blockpos, blockpos1) && direction == Direction.UP);
            if (entity != null) {

                if (entity instanceof IDyeable dyeable && dyeType != null) {
                    dyeable.setDyeType(dyeType);
                }

                if (entity instanceof TamableCreature creature) {
                    creature.tame(context.getPlayer());
                }

                itemstack.shrink(1);
                level.gameEvent(context.getPlayer(), GameEvent.ENTITY_PLACE, blockpos);
            }

            return InteractionResult.CONSUME;
        }
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack itemstack = player.getItemInHand(hand);
        HitResult hitresult = getPlayerPOVHitResult(level, player, ClipContext.Fluid.SOURCE_ONLY);
        if (hitresult.getType() != HitResult.Type.BLOCK) {
            return InteractionResultHolder.pass(itemstack);
        } else if (!(level instanceof ServerLevel)) {
            return InteractionResultHolder.success(itemstack);
        } else {
            BlockHitResult blockhitresult = (BlockHitResult)hitresult;
            BlockPos blockpos = blockhitresult.getBlockPos();
            if (!(level.getBlockState(blockpos).getBlock() instanceof LiquidBlock)) {
                return InteractionResultHolder.pass(itemstack);
            } else if (level.mayInteract(player, blockpos) && player.mayUseItemAt(blockpos, blockhitresult.getDirection(), itemstack)) {
                EntityType<?> entitytype = this.getType(itemstack.getTag());
                Entity entity = entitytype.spawn((ServerLevel)level, itemstack, player, blockpos, MobSpawnType.SPAWN_EGG, false, false);
                if (entity == null) {
                    return InteractionResultHolder.pass(itemstack);
                } else {
                    if (!player.getAbilities().instabuild) {
                        itemstack.shrink(1);
                    }

                    CelestialExploration.LOGGER.debug("entity: " + entity);

                    if (entity instanceof TamableCreature creature) {
                        CelestialExploration.LOGGER.debug("is tamable");
                        creature.tame(player);
                    }

                    player.awardStat(Stats.ITEM_USED.get(this));
                    level.gameEvent(GameEvent.ENTITY_PLACE, player);
                    return InteractionResultHolder.consume(itemstack);
                }
            } else {
                return InteractionResultHolder.fail(itemstack);
            }
        }
    }

    public EntityType<?> getType(@Nullable CompoundTag tag)
    {
//        EntityType<?> type = getVanillaType(tag);
//        return type != null ? type : typeSupplier.get();
        return typeSupplier.get();
    }

//    @Nullable
//    protected DispenseItemBehavior createDispenseBehavior()
//    {
//        return DEFAULT_DISPENSE_BEHAVIOR;
//    }
//
//    private static final DispenseItemBehavior DEFAULT_DISPENSE_BEHAVIOR = (source, stack) ->
//    {
//        Direction face = source.getBlockState().getValue(DispenserBlock.FACING);
//        EntityType<?> type = ((SpawnEggItem)stack.getItem()).getType(stack.getTag());
//
//        try
//        {
//            type.spawn(source.getLevel(), stack, null, source.getPos().relative(face), MobSpawnType.DISPENSER, face != Direction.UP, false);
//        }
//        catch (Exception exception)
//        {
//            DispenseItemBehavior.LOGGER.error("Error while dispensing spawn egg from dispenser at {}", source.getPos(), exception);
//            return ItemStack.EMPTY;
//        }
//
//        stack.shrink(1);
//        source.getLevel().gameEvent(GameEvent.ENTITY_PLACE, source.getPos());
//        return stack;
//    };

//    public EntityType<?> getVanillaType(@Nullable CompoundTag p_43229_) {
//        if (p_43229_ != null && p_43229_.contains("EntityTag", 10)) {
//            CompoundTag compoundtag = p_43229_.getCompound("EntityTag");
//            if (compoundtag.contains("id", 8)) {
//                return EntityType.byString(compoundtag.getString("id")).orElse(this.defaultType);
//            }
//        }
//
//        return this.defaultType;
//    }

}
