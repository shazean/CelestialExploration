package com.shim.celestialexploration.item;

import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestialexploration.capabilities.IFuelTank;
import com.shim.celestialexploration.registry.CelestialCapabilities;
import com.shim.celestialexploration.registry.CelestialFluids;
import net.minecraft.core.BlockPos;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.BucketPickup;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.BlockHitResult;

public class MetallicHydrogenTankItem extends FuelTankItem {
    public MetallicHydrogenTankItem(Block block, Properties properties) {
        super(block, properties);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {

//        if (!context.isSecondaryUseActive()) {

            BlockPos pos = context.getClickedPos();
            pos = pos.relative(context.getClickedFace());
            Level level = context.getLevel();

            CelestialExploration.LOGGER.debug("secondary not active, clicked on: " + level.getFluidState(pos) + " @ " + pos);

            if (level.getFluidState(pos).is(CelestialFluids.METALLIC_HYDROGEN.get())) {
                ItemStack itemstack = context.getItemInHand();
                Player player = context.getPlayer();

                CelestialExploration.LOGGER.debug("is metallic hydrogen");

                IFuelTank fuelTank = CelestialExploration.getCapability(itemstack, CelestialCapabilities.FUEL_TANK_CAPABILITY);
                if (fuelTank != null) {

                    if (fuelTank.isFull()) return InteractionResult.PASS;

                    fuelTank.incrementAmount();
                    level.setBlock(pos, Blocks.AIR.defaultBlockState(), 1);
                    player.awardStat(Stats.ITEM_USED.get(this));
//                bucketpickup.getPickupSound(blockstate1).ifPresent((p_150709_) -> {
                    if (Fluids.WATER.getPickupSound().isPresent())
                        player.playSound(Fluids.WATER.getPickupSound().get(), 1.0F, 1.0F);
//                });
                    level.gameEvent(player, GameEvent.FLUID_PICKUP, pos);
                    return InteractionResult.PASS;

                }
            }

            return super.useOn(context);
//            return InteractionResult.PASS;
//        }

//        return super.useOn(context);
    }

//    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
//        ItemStack itemstack = player.getItemInHand(hand);
//        BlockHitResult blockhitresult = getPlayerPOVHitResult(level, player, ClipContext.Fluid.SOURCE_ONLY);
//
//        //did click on metallic hydrogen?
//        //has room?
//        //increase amount
//        //replace fluid block with air
//
//        BlockPos pos = blockhitresult.getBlockPos();
//
//        if (level.getBlockState(pos).is(CelestialFluids.METALLIC_HYDROGEN_BLOCK.get())) {
//            CelestialExploration.LOGGER.debug("is metallic hydrogen");
//
//            IFuelTank fuelTank = CelestialExploration.getCapability(itemstack, CelestialCapabilities.FUEL_TANK_CAPABILITY);
//            if (fuelTank != null) {
//
//                fuelTank.incrementAmount();
//                level.setBlock(pos, Blocks.AIR.defaultBlockState(), 1);
//                player.awardStat(Stats.ITEM_USED.get(this));
////                bucketpickup.getPickupSound(blockstate1).ifPresent((p_150709_) -> {
////                    player.playSound(p_150709_, 1.0F, 1.0F);
////                });
//                level.gameEvent(player, GameEvent.FLUID_PICKUP, pos);
//                return InteractionResultHolder.sidedSuccess(itemstack, level.isClientSide());
//
//            }
//        }
//
//        return InteractionResultHolder.pass(itemstack);
//
//
////        InteractionResultHolder<ItemStack> ret = net.minecraftforge.event.ForgeEventFactory.onBucketUse(player, level, itemstack, blockhitresult);
////        if (ret != null) return ret;
////        if (blockhitresult.getType() == HitResult.Type.MISS) {
////            return InteractionResultHolder.pass(itemstack);
////        } else if (blockhitresult.getType() != HitResult.Type.BLOCK) {
////            return InteractionResultHolder.pass(itemstack);
////        } else {
////            BlockPos blockpos = blockhitresult.getBlockPos();
////            Direction direction = blockhitresult.getDirection();
////            BlockPos blockpos1 = blockpos.relative(direction);
////            if (level.mayInteract(player, blockpos) && player.mayUseItemAt(blockpos1, direction, itemstack)) {
////                BlockState blockstate1 = level.getBlockState(blockpos);
////                if (blockstate1.getBlock() instanceof BucketPickup) {
////                    BucketPickup bucketpickup = (BucketPickup)blockstate1.getBlock();
////                    ItemStack itemstack1 = bucketpickup.pickupBlock(level, blockpos, blockstate1);
////                    if (!itemstack1.isEmpty()) {
////                        player.awardStat(Stats.ITEM_USED.get(this));
////                        bucketpickup.getPickupSound(blockstate1).ifPresent((p_150709_) -> {
////                            player.playSound(p_150709_, 1.0F, 1.0F);
////                        });
////                        level.gameEvent(player, GameEvent.FLUID_PICKUP, blockpos);
////                        ItemStack itemstack2 = ItemUtils.createFilledResult(itemstack, player, itemstack1);
////                        if (!level.isClientSide) {
////                            CriteriaTriggers.FILLED_BUCKET.trigger((ServerPlayer)player, itemstack1);
////                        }
////
////                        return InteractionResultHolder.sidedSuccess(itemstack2, level.isClientSide());
////                    }
////                }
////
////                return InteractionResultHolder.fail(itemstack);
////            } else {
////                return InteractionResultHolder.fail(itemstack);
////            }
////        }
//    }
}
