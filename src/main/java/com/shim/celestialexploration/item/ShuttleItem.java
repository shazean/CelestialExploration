package com.shim.celestialexploration.item;

import com.shim.celestialexploration.entity.Shuttle;
import net.minecraft.core.BlockPos;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntitySelector;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;

import java.util.List;
import java.util.function.Predicate;

public class ShuttleItem extends Item {
    private static final Predicate<Entity> ENTITY_PREDICATE = EntitySelector.NO_SPECTATORS.and(Entity::isPickable);
    private final Shuttle.Type type;
//    private CompoundTag shuttleData;

    public ShuttleItem(Shuttle.Type p_40619_, Item.Properties p_40620_) {
        super(p_40620_);
        this.type = p_40619_;
    }

    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {

        ItemStack itemstack = player.getItemInHand(hand);
        HitResult hitresult = getPlayerPOVHitResult(level, player, ClipContext.Fluid.ANY);
        if (hitresult.getType() == HitResult.Type.MISS) {
            return InteractionResultHolder.pass(itemstack);
        } else {
            Vec3 vec3 = player.getViewVector(1.0F);
            double d0 = 5.0D;
            List<Entity> list = level.getEntities(player, player.getBoundingBox().expandTowards(vec3.scale(5.0D)).inflate(1.0D), ENTITY_PREDICATE);
            if (!list.isEmpty()) {
                Vec3 vec31 = player.getEyePosition();

                for(Entity entity : list) {
                    AABB aabb = entity.getBoundingBox().inflate((double)entity.getPickRadius());
                    if (aabb.contains(vec31)) {
                        return InteractionResultHolder.pass(itemstack);
                    }
                }
            }

            if (hitresult.getType() == HitResult.Type.BLOCK) {
                Shuttle shuttle = new Shuttle(level, hitresult.getLocation().x, hitresult.getLocation().y, hitresult.getLocation().z);
                shuttle.setType(this.type);
                shuttle.setYRot(player.getYRot());
                if (!level.noCollision(shuttle, shuttle.getBoundingBox())) {
                    return InteractionResultHolder.fail(itemstack);
                } else {
                    if (!level.isClientSide) {
//                        Block block = level.getBlockState(new BlockPos(hitresult.getLocation())).getBlock();
//                        if (block instanceof LaunchPadBlock) {
//                        } else {
//                            shuttle.setInvData(shuttleData);
                            level.addFreshEntity(shuttle);
                            level.gameEvent(player, GameEvent.ENTITY_PLACE, new BlockPos(hitresult.getLocation()));
                            if (!player.getAbilities().instabuild) {
                                itemstack.shrink(1);
//                            }
                        }

                    }

                    player.awardStat(Stats.ITEM_USED.get(this));
                    return InteractionResultHolder.sidedSuccess(itemstack, level.isClientSide());
                }
            } else {
                return InteractionResultHolder.pass(itemstack);
            }
        }
    }

//    public void setShuttleItemData(CompoundTag tag) {
//        this.shuttleData = tag;
//    }
//
//    @Override
//    public CompoundTag getShareTag(ItemStack stackIn) {
//        CompoundTag nbt = stackIn.getOrCreateTag();
////        LoxTankCapability.ILoxTank loxCap = CelestialExploration.getCapability(stackIn, CapabilityRegistry.LOX_TANK_CAPABILITY);
////        if (loxCap != null) {
////            nbt.put("LoxData", loxCap.getLoxData());
////        }
//        return nbt;
//    }
//
//    @Override
//    public void readShareTag(ItemStack stackIn, @Nullable CompoundTag nbtIn) {
//        super.readShareTag(stackIn, nbtIn);
////        if (nbtIn != null) {
////            LoxTankCapability.ILoxTank loxCap = CelestialExploration.getCapability(stackIn, CapabilityRegistry.LOX_TANK_CAPABILITY);
////            if (loxCap != null && nbtIn.contains("LoxData", 10)) loxCap.setLoxData(nbtIn.getCompound("LoxData"));
////        }
//    }
}