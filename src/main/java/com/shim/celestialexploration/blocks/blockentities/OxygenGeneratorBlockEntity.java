package com.shim.celestialexploration.blocks.blockentities;

import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestialexploration.blocks.OxygenGeneratorBlock;
import com.shim.celestialexploration.registry.CelestialBlockEntities;
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

        if (state.getValue(OxygenGeneratorBlock.LIT) && nearbyWater >= 1)
            radius = calculateRadius(level, pos, nearbyWater);
        else radius = 2;

        //produce oxygen
        if (!level.isClientSide)
            applyEffects(level, pos, radius);

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
                    player.addEffect(new MobEffectInstance(CelestialEffects.OXYGENATED_EFFECT.get(), 260, 0, true, true));
                }
            }
        }
    }

    private static int calculateRadius(Level level, BlockPos pos, int nearbyWater) {
        int signal = level.getBestNeighborSignal(pos);
        CelestialExploration.LOGGER.debug("radius ({}) = signal ({}) * water ({}) * 3 / 4", signal * nearbyWater * 3 / 4, signal, nearbyWater);
        return signal * nearbyWater * 3 / 4;
    }
}