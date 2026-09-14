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

            if (level.getFluidState(pos).is(CelestialFluids.METALLIC_HYDROGEN.get())) {
                ItemStack itemstack = context.getItemInHand();
                Player player = context.getPlayer();
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
    }
}
