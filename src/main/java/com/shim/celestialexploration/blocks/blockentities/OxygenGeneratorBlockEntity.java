package com.shim.celestialexploration.blocks.blockentities;

import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestialexploration.blocks.OxygenCompressorBlock;
import com.shim.celestialexploration.blocks.OxygenGeneratorBlock;
import com.shim.celestialexploration.config.CelestialCommonConfig;
import com.shim.celestialexploration.registry.CelestialBlockEntities;
import com.shim.celestialexploration.registry.CelestialBlocks;
import com.shim.celestialexploration.registry.CelestialEffects;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class OxygenGeneratorBlockEntity extends BlockEntity {
    int tick = 0;

    public OxygenGeneratorBlockEntity(BlockPos worldPosition, BlockState blockState) {
        super(CelestialBlockEntities.OXYGEN_GENERATOR_BLOCK_ENTITY.get(), worldPosition, blockState);
    }

    @Override
    protected void saveAdditional(@NotNull CompoundTag tag) {
        super.saveAdditional(tag);
    }

    @Override
    public void load(@NotNull CompoundTag nbt) {
        super.load(nbt);
    }

    public static void tick(Level level, BlockPos pos, BlockState state, OxygenGeneratorBlockEntity blockEntity) {

        int nearbyWater = state.getValue(OxygenGeneratorBlock.HAS_WATER);
        int radius;
        blockEntity.tick++;

        if (state.getValue(OxygenGeneratorBlock.LIT) && nearbyWater >= 1)
            radius = calculateRadius(level, pos, nearbyWater);
        else radius = 2;

        //produce oxygen
        if (!level.isClientSide) {
            if (CelestialCommonConfig.OXYGEN_MECHANIC_ENABLED.get()) {
                if (blockEntity.tick % 2 == 0)
                    applyEffects(level, pos, radius);
            }

            boolean lit = level.hasNeighborSignal(pos);
            if (!lit) {
                if (level.getBlockState(pos.above()).is(CelestialBlocks.OXYGEN_COMPRESSOR.get())) {
                    lit = level.getBlockState(pos.above()).getValue(OxygenCompressorBlock.LIT);
                }
            }
            int water = OxygenGeneratorBlock.nearbyWaterBlocks(level, pos);
            boolean operating = lit && water >= 1;
            if (state.getValue(OxygenGeneratorBlock.LIT) != lit || state.getValue(OxygenGeneratorBlock.HAS_WATER) != water) {
                level.setBlock(pos, state.setValue(OxygenGeneratorBlock.LIT, lit).setValue(OxygenGeneratorBlock.HAS_WATER, water).setValue(OxygenGeneratorBlock.OPERATING, operating), 2);
                setChanged(level, pos, state);
            }

        }
    }


    private static void applyEffects(Level level, BlockPos pos, int radius) {
        int x = pos.getX();
        int y = pos.getY();
        int z = pos.getZ();
        AABB aabb = (new AABB(x, y, z, (x + 1), (y + 1), (z + 1))).inflate(radius).expandTowards(0.0D, level.getHeight(), 0.0D);
        List<Player> list = level.getEntitiesOfClass(Player.class, aabb);
        if (!list.isEmpty()) {
            for(Player player : list) {
                if (pos.closerThan(player.blockPosition(), radius)) {
//                    if (!player.isCreative())
                        player.addEffect(new MobEffectInstance(CelestialEffects.OXYGENATED_EFFECT.get(), 260, 0, true, true));
                }
            }
        }
    }

    private static int calculateRadius(Level level, BlockPos pos, int nearbyWater) {
        int signal = level.getBestNeighborSignal(pos);
        BlockState compressor = level.getBlockState(pos.above());
        if (compressor.is(CelestialBlocks.OXYGEN_COMPRESSOR.get()))
            if (compressor.getValue(OxygenCompressorBlock.LIT))
                signal = Math.max(signal, level.getBestNeighborSignal(pos.above()));
        return signal * nearbyWater * 3 / 4;
    }
}