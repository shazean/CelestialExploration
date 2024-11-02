package com.shim.celestialexploration.blocks;

import com.shim.celestialexploration.item.armor.HeavyDutySpaceSuitArmorItem;
import com.shim.celestialexploration.item.armor.HeavyDutySpaceSuitRenderer;
import com.shim.celestialexploration.item.armor.ThermalSpaceSuitArmorItem;
import com.shim.celestialexploration.registry.CelestialDamageSource;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FlowingFluid;

import java.util.function.Supplier;

public class MetallicHydrogenLiquidBlock extends LiquidBlock {
    public MetallicHydrogenLiquidBlock(Supplier<? extends FlowingFluid> block, Properties properties) {
        super(block, properties);
    }

    @Override
    public void entityInside(BlockState state, Level level, BlockPos pos, Entity entity) {
//        if (!entity.fireImmune()) {
//            entity.setSecondsOnFire(15);
        if (entity instanceof ServerPlayer player) {
            ItemStack itemStack = player.getItemBySlot(EquipmentSlot.HEAD);
            if (!(itemStack.getItem() instanceof HeavyDutySpaceSuitArmorItem)) {
                entity.hurt(CelestialDamageSource.METALLIC_HYDROGEN, 0.5F);
//            if (entity.hurt(CelestialDamageSource.METALLIC_HYDROGEN, 4.0F)) {
//                entity.playSound(SoundEvents.GENERIC_BURN, 0.4F, 2.0F + level.random.nextFloat() * 0.4F);
//            }
//            entity.lavaHurt();
//        }
            }
        } else {
            entity.hurt(CelestialDamageSource.METALLIC_HYDROGEN, 4.0F);
        }
        super.entityInside(state, level, pos, entity);
    }
}