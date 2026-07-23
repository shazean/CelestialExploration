package com.shim.celestialexploration.blocks.blockentities;

import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestialexploration.blocks.MercurySlimeBlock;
import com.shim.celestialexploration.registry.CelestialBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

import java.util.Random;


public class MercurySlimeBlockEntity extends BlockEntity {
    public MercurySlimeBlockEntity(BlockPos worldPosition, BlockState blockState) {
        super(CelestialBlockEntities.MERCURY_SLIME_BLOCK_ENTITY.get(), worldPosition, blockState);
    }

    public static void tick(Level level, BlockPos pos, BlockState state, MercurySlimeBlockEntity blockEntity) {
//        CelestialExploration.LOGGER.debug("enabled? " + state.getValue(ENABLED) + ", geyserCooldown: " + blockEntity.geyserCooldown + ", duration: " + blockEntity.geyserDuration);

//        if (level.getTimeOfDay(1) % 10 == 0) {
//            CelestialExploration.LOGGER.debug(level.getTimeOfDay(0.0F));
//        }

        if (!level.isClientSide()) {

            if (level.isNight()) {
                state = state.setValue(MercurySlimeBlock.IS_VISCOUS, true);
            } else { //if (level.getTimeOfDay(1.0F) == 20000) {
                state = state.setValue(MercurySlimeBlock.IS_VISCOUS, false);
            }
            level.setBlock(pos, state, 3);
            setChanged(level, pos, state);
        }
    }
}
