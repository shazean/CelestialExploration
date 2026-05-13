package com.shim.celestialexploration.blocks.blockentities;

import com.shim.celestialexploration.registry.CelestialBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.SignBlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class DisplayBoardBlockEntity extends SignBlockEntity {

    public DisplayBoardBlockEntity(BlockPos pos, BlockState state) {
        super(pos, state);
    }

    @Override
    public BlockEntityType<?> getType() {
        return CelestialBlockEntities.DISPLAY_BOARD_BLOCK_ENTITY.get();
    }
}