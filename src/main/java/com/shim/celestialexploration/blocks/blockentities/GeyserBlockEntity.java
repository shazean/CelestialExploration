package com.shim.celestialexploration.blocks.blockentities;

import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestialexploration.blocks.GeyserBlock;
import com.shim.celestialexploration.registry.BlockEntityRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

import java.util.Random;

import static com.shim.celestialexploration.blocks.GeyserBlock.ENABLED;

public class GeyserBlockEntity extends BlockEntity {
    public GeyserBlockEntity(BlockPos worldPosition, BlockState blockState) {
        super(BlockEntityRegistry.GEYSER_BLOCK_ENTITY.get(), worldPosition, blockState);
    }

    final int MIN_TICKS = 20 * 20;
    int geyserCooldown = 100;
    int geyserDuration = 50;
    Random rand = new Random();

    public void resetGeyser() {
        this.geyserCooldown = MIN_TICKS + this.rand.nextInt(400);
        this.geyserDuration = this.rand.nextInt(180) + 40;
    }

    public static void tick(Level level, BlockPos pos, BlockState state, GeyserBlockEntity blockEntity) {
//        CelestialExploration.LOGGER.debug("enabled? " + state.getValue(ENABLED) + ", geyserCooldown: " + blockEntity.geyserCooldown + ", duration: " + blockEntity.geyserDuration);
        if (blockEntity.geyserCooldown > 0) {
            blockEntity.geyserCooldown--;
            state = state.setValue(ENABLED, false);
            level.setBlock(pos, state, 3);
            setChanged(level, pos, state);
        }
        if (blockEntity.geyserCooldown == 0) {
            state = state.setValue(ENABLED, true);
            level.setBlock(pos, state, 3);
            setChanged(level, pos, state);

            if (blockEntity.geyserDuration > 0) {
                blockEntity.geyserDuration--;
            } else {
                blockEntity.resetGeyser();
            }
        }
    }
}
