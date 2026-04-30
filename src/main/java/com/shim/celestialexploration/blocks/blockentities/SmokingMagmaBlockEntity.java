package com.shim.celestialexploration.blocks.blockentities;

import com.shim.celestialexploration.blocks.SmokingMagmaBlock;
import com.shim.celestialexploration.registry.CelestialBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.CampfireBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.CampfireBlockEntity;
import net.minecraft.world.level.block.state.BlockState;

import java.util.Random;

import static com.shim.celestialexploration.blocks.GeyserBlock.ENABLED;

public class SmokingMagmaBlockEntity extends BlockEntity {
    public SmokingMagmaBlockEntity(BlockPos worldPosition, BlockState blockState) {
        super(CelestialBlockEntities.SMOKING_MAGMA_BLOCK_ENTITY.get(), worldPosition, blockState);
    }

    final int MIN_TICKS = 20 * 20;
    int cooldown = 100;
    int duration = 50;
    Random rand = new Random();

    public void resetGeyser() {
        this.cooldown = MIN_TICKS + this.rand.nextInt(400);
        this.duration = this.rand.nextInt(180) + 40;
    }

    public static void tick(Level level, BlockPos pos, BlockState state, SmokingMagmaBlockEntity blockEntity) {
//        CelestialExploration.LOGGER.debug("enabled? " + state.getValue(ENABLED) + ", geyserCooldown: " + blockEntity.geyserCooldown + ", duration: " + blockEntity.geyserDuration);

        Random random = level.random;
        if (random.nextFloat() < 0.11F) {
            for(int i = 0; i < random.nextInt(2) + 2; ++i) {
                SmokingMagmaBlock.makeParticles(level, pos);
            }
        }
    }
}
