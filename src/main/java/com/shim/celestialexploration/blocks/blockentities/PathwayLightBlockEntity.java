package com.shim.celestialexploration.blocks.blockentities;

import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestialexploration.registry.BlockEntityRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

import java.util.Random;

import static com.shim.celestialexploration.blocks.PathwayLightBlock.LIT;

public class PathwayLightBlockEntity extends BlockEntity {
    public PathwayLightBlockEntity(BlockPos worldPosition, BlockState blockState) {
        super(BlockEntityRegistry.PATHWAY_LIGHT_BLOCK_ENTITY.get(), worldPosition, blockState);
    }

    int litTime = 20;

    public void resetLitTime() {
        this.litTime = 20;
    }

    public static void tick(Level level, BlockPos pos, BlockState state, PathwayLightBlockEntity blockEntity) {
        if (!level.isClientSide) {
//            CelestialExploration.LOGGER.debug("pathway block is ticking " + blockEntity.litTime);
            if (blockEntity.litTime > 0) {
                blockEntity.litTime--;
            }
            if (blockEntity.litTime <= 0) {
                state = state.setValue(LIT, false);
                level.setBlock(pos, state, 3);
                setChanged(level, pos, state);
                blockEntity.resetLitTime();
            }
        }
    }
}
