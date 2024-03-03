package com.shim.celestialexploration.blocks;

import com.shim.celestialexploration.item.armor.ThermalSpaceSuitArmorItem;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LightLayer;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.BubbleColumnBlock;
import net.minecraft.world.level.block.HalfTransparentBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.level.pathfinder.PathComputationType;

import javax.annotation.Nullable;
import java.util.Random;

public class DryIceBlock extends HalfTransparentBlock {
    private static final int BUBBLE_COLUMN_CHECK_DELAY = 20;

    public DryIceBlock(BlockBehaviour.Properties p_54155_) {
        super(p_54155_);
    }

    public void stepOn(Level p_153777_, BlockPos p_153778_, BlockState p_153779_, Entity entity) {
        if (entity instanceof ServerPlayer player) {
            ItemStack itemStack = player.getItemBySlot(EquipmentSlot.FEET);

            if (!(itemStack.getItem() instanceof ThermalSpaceSuitArmorItem && ((ThermalSpaceSuitArmorItem) itemStack.getItem()).isGravityBoots(itemStack))) {
                entity.hurt(DamageSource.HOT_FLOOR, 1.0F);
            }

            super.stepOn(p_153777_, p_153778_, p_153779_, entity);
        }
    }

    public void playerDestroy(Level p_54157_, Player p_54158_, BlockPos p_54159_, BlockState p_54160_, @Nullable BlockEntity p_54161_, ItemStack p_54162_) {
        super.playerDestroy(p_54157_, p_54158_, p_54159_, p_54160_, p_54161_, p_54162_);
        if (EnchantmentHelper.getItemEnchantmentLevel(Enchantments.SILK_TOUCH, p_54162_) == 0) {
            if (p_54157_.dimensionType().ultraWarm()) {
                p_54157_.removeBlock(p_54159_, false);
                return;
            }

            Material material = p_54157_.getBlockState(p_54159_.below()).getMaterial();
            if (material.blocksMotion() || material.isLiquid()) {
                p_54157_.setBlockAndUpdate(p_54159_, Blocks.AIR.defaultBlockState());
            }
        }
    }

    public void randomTick(BlockState p_54164_, ServerLevel p_54165_, BlockPos p_54166_, Random p_54167_) {
        if (p_54165_.getBrightness(LightLayer.BLOCK, p_54166_) > 11 - p_54164_.getLightBlock(p_54165_, p_54166_)) {
            this.melt(p_54164_, p_54165_, p_54166_);
        }

    }

    protected void melt(BlockState p_54169_, Level p_54170_, BlockPos p_54171_) {
        if (p_54170_.dimensionType().ultraWarm()) {
            p_54170_.removeBlock(p_54171_, false);
        } else {
            p_54170_.setBlockAndUpdate(p_54171_, Blocks.AIR.defaultBlockState());
            p_54170_.neighborChanged(p_54171_, Blocks.AIR, p_54171_);
        }
    }

    public PushReaction getPistonPushReaction(BlockState p_54173_) {
        return PushReaction.NORMAL;
    }


    public void tick(BlockState p_56674_, ServerLevel p_56675_, BlockPos p_56676_, Random p_56677_) {
        DryIceBubbleColumnBlock.updateColumn(p_56675_, p_56676_.above(), p_56674_);
    }

    public BlockState updateShape(BlockState p_56689_, Direction p_56690_, BlockState p_56691_, LevelAccessor p_56692_, BlockPos p_56693_, BlockPos p_56694_) {
        if (p_56690_ == Direction.UP && p_56691_.is(Blocks.WATER)) {
            p_56692_.scheduleTick(p_56693_, this, 20);
        }

        return super.updateShape(p_56689_, p_56690_, p_56691_, p_56692_, p_56693_, p_56694_);
    }

    public void onPlace(BlockState p_56696_, Level p_56697_, BlockPos p_56698_, BlockState p_56699_, boolean p_56700_) {
        p_56697_.scheduleTick(p_56698_, this, 20);
    }

    public boolean isPathfindable(BlockState p_56679_, BlockGetter p_56680_, BlockPos p_56681_, PathComputationType p_56682_) {
        return false;
    }

}