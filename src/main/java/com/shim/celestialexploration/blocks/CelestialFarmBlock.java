package com.shim.celestialexploration.blocks;

import com.shim.celestialexploration.registry.CelestialTags;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FarmBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.IPlantable;

import java.util.Random;

public class CelestialFarmBlock extends FarmBlock {
    final Block dirtBlock;
    public CelestialFarmBlock(Properties properties, Block dirtBlock) {
        super(properties);
        this.dirtBlock = dirtBlock;
    }

    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return !this.defaultBlockState().canSurvive(context.getLevel(), context.getClickedPos()) ? this.dirtBlock.defaultBlockState() : super.getStateForPlacement(context);
    }

    @Override
    public void fallOn(Level level, BlockState state, BlockPos pos, Entity entity, float p_153231_) {
        if (!level.isClientSide && net.minecraftforge.common.ForgeHooks.onFarmlandTrample(level, pos, this.dirtBlock.defaultBlockState(), p_153231_, entity)) { // Forge: Move logic to Entity#canTrample
            turnToDirt(state, level, pos);
        }

        entity.causeFallDamage(p_153231_, 1.0F, DamageSource.FALL);

//        super.fallOn(level, state, pos, entity, p_153231_);
    }

    @Override
    public void tick(BlockState state, ServerLevel level, BlockPos pos, Random random) {
        if (!state.canSurvive(level, pos)) {
            turnToDirt(state, level, pos);
        }

    }

    @Override
    public void randomTick(BlockState state, ServerLevel level, BlockPos pos, Random random) {
        int i = state.getValue(MOISTURE);
        if (!isNearWater(level, pos) && !level.isRainingAt(pos.above())) {
            if (i > 0) {
                level.setBlock(pos, state.setValue(MOISTURE, Integer.valueOf(i - 1)), 2);
            } else if (!isUnderCrops(level, pos)) {
                turnToDirt(state, level, pos);
            }
        } else if (i < 7) {
            level.setBlock(pos, state.setValue(MOISTURE, Integer.valueOf(7)), 2);
        }
    }

    private static boolean isUnderCrops(BlockGetter p_53251_, BlockPos pos) {
        BlockState plant = p_53251_.getBlockState(pos.above());
        BlockState state = p_53251_.getBlockState(pos);
        return plant.getBlock() instanceof net.minecraftforge.common.IPlantable && state.canSustainPlant(p_53251_, pos, Direction.UP, (net.minecraftforge.common.IPlantable)plant.getBlock());
    }

    private static boolean isNearWater(LevelReader level, BlockPos p_53260_) {
        for(BlockPos blockpos : BlockPos.betweenClosed(p_53260_.offset(-4, 0, -4), p_53260_.offset(4, 1, 4))) {
            if (level.getFluidState(blockpos).is(FluidTags.WATER)) {
                return true;
            }
        }

        return net.minecraftforge.common.FarmlandWaterManager.hasBlockWaterTicket(level, p_53260_);
    }

    public static void turnToDirt(BlockState state, Level level, BlockPos pos) {
        if (state.getBlock() instanceof CelestialFarmBlock farmBlock)
            level.setBlockAndUpdate(pos, pushEntitiesUp(state, farmBlock.dirtBlock.defaultBlockState(), level, pos));
    }

    @Override
    public boolean canSustainPlant(BlockState state, BlockGetter world, BlockPos pos, Direction facing, IPlantable plantable) {
        net.minecraftforge.common.PlantType type = plantable.getPlantType(world, pos.relative(facing));

        if (net.minecraftforge.common.PlantType.CROP.equals(type))
            return state.is(CelestialTags.Blocks.FARMLAND);
        else
            return super.canSustainPlant(state, world, pos, facing, plantable);
    }
}
