package com.shim.celestialexploration.blocks;

import com.shim.celestialexploration.blocks.blockentities.DisplayBoardBlockEntity;
import com.shim.celestialexploration.registry.CelestialBlockEntities;
import com.shim.celestialexploration.registry.CelestialMaterials;
import com.shim.celestialexploration.registry.DisplayBoardType;
import net.minecraft.client.resources.model.Material;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.SignBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.WoodType;
import org.jetbrains.annotations.Nullable;

public class WallDisplayBoardBlock extends WallSignBlock implements IDisplayBoard {

    DyeColor textColor;
//    Material material;

    public WallDisplayBoardBlock(WoodType type, DyeColor defaultDyeColor) {
        super(Block.Properties.of(net.minecraft.world.level.material.Material.METAL).strength(0.1F).sound(SoundType.METAL), type);
        this.textColor = defaultDyeColor;
//        this.material = material;
    }

    public net.minecraft.client.resources.model.Material getMaterial() {
        if (this.type() instanceof DisplayBoardType displayBoardType) {
            if (displayBoardType == DisplayBoardType.BLACK_TYPE)
                return CelestialMaterials.BLACK;
            if (displayBoardType == DisplayBoardType.BLUE_TYPE)
                return CelestialMaterials.BLUE;
            if (displayBoardType == DisplayBoardType.RED_TYPE)
                return CelestialMaterials.RED;
            if (displayBoardType == DisplayBoardType.WHITE_TYPE)
                return CelestialMaterials.WHITE;
        }
        return null;
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return CelestialBlockEntities.DISPLAY_BOARD_BLOCK_ENTITY.get().create(pos, state);
    }

    @Override
    public void setPlacedBy(Level level, BlockPos pos, BlockState state, @Nullable LivingEntity entity, ItemStack stack) {
        BlockEntity tileEntity = level.getBlockEntity(pos);
        Block block = state.getBlock();
//        if (tileEntity instanceof DisplayBoardBlockEntity signBlockEntity && block instanceof WallDisplayBoardBlock) {
        if (tileEntity instanceof SignBlockEntity signBlockEntity && block instanceof WallDisplayBoardBlock) {
            signBlockEntity.setColor(this.textColor);
            if (this.textColor != DyeColor.BLACK)
                signBlockEntity.setHasGlowingText(true);

        }
    }

//    public Material getMaterial() {
//        return this.material;
//    }

}