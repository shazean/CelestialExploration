//package com.shim.celestialexploration.blocks;
//
//import com.shim.celestialexploration.registry.CelestialBlockEntities;
//import com.shim.celestialexploration.registry.DisplayBoardType;
//import net.minecraft.core.BlockPos;
//import net.minecraft.world.entity.LivingEntity;
//import net.minecraft.world.item.DyeColor;
//import net.minecraft.world.item.ItemStack;
//import net.minecraft.world.level.Level;
//import net.minecraft.world.level.block.*;
//import net.minecraft.world.level.block.entity.BlockEntity;
//import net.minecraft.world.level.block.entity.SignBlockEntity;
//import net.minecraft.world.level.block.state.BlockState;
//import net.minecraft.world.level.block.state.properties.WoodType;
//import net.minecraft.world.level.material.Material;
//import org.jetbrains.annotations.Nullable;
//
//public class StandingDisplayBoardBlock extends StandingSignBlock {
//
//    DyeColor textColor;
//    net.minecraft.client.resources.model.Material material;
//
//    public StandingDisplayBoardBlock(net.minecraft.client.resources.model.Material material, WoodType type, DyeColor defaultDyeColor) {
//        super(Block.Properties.of(Material.METAL).strength(0.1F).sound(SoundType.METAL), type);
//        this.textColor = defaultDyeColor;
//        this.material = material;
//    }
//
//    @Override
//    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
//        return CelestialBlockEntities.DISPLAY_BOARD_BLOCK_ENTITY.get().create(pos, state);
//    }
//
//    @Override
//    public void setPlacedBy(Level level, BlockPos pos, BlockState state, @Nullable LivingEntity entity, ItemStack stack) {
//        BlockEntity tileEntity = level.getBlockEntity(pos);
//        Block block = state.getBlock();
//        if (tileEntity instanceof SignBlockEntity signBlockEntity && block instanceof StandingDisplayBoardBlock) {
//            signBlockEntity.setColor(this.textColor);
//            if (this.textColor != DyeColor.BLACK)
//                signBlockEntity.setHasGlowingText(true);
//        }
//    }
//
//    public net.minecraft.client.resources.model.Material getMaterial() {
//        return this.material;
//    }
//
//}