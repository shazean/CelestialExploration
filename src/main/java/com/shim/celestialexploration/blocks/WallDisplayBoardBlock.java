//package com.shim.celestialexploration.blocks;
//
//import com.shim.celestialexploration.blocks.blockentities.DisplayBoardBlockEntity;
//import com.shim.celestialexploration.registry.CelestialBlockEntities;
//import net.minecraft.client.resources.model.Material;
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
//import org.jetbrains.annotations.Nullable;
//
//public class WallDisplayBoardBlock extends WallSignBlock {
//
//    DyeColor textColor;
//    Material material;
//
//    public WallDisplayBoardBlock(Material material, WoodType type, DyeColor defaultDyeColor) {
//        super(Block.Properties.of(net.minecraft.world.level.material.Material.METAL).strength(0.1F).sound(SoundType.METAL), type);
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
//        if (tileEntity instanceof SignBlockEntity signBlockEntity && block instanceof WallDisplayBoardBlock) {
//            signBlockEntity.setColor(this.textColor);
//            if (this.textColor != DyeColor.BLACK)
//                signBlockEntity.setHasGlowingText(true);
//
//        }
//    }
//
//    public Material getMaterial() {
//        return this.material;
//    }
//
//}