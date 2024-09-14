package com.shim.celestialexploration.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FarmBlock;
import net.minecraft.world.level.block.FenceGateBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.Random;

public class CelestialPathBlock extends Block {
    protected static final VoxelShape SHAPE = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 15.0D, 16.0D);
    protected final Block originBlock;

    public CelestialPathBlock(BlockBehaviour.Properties p_153129_, Block originBlock) {
        super(p_153129_);
        this.originBlock = originBlock;
    }

    public boolean useShapeForLightOcclusion(BlockState state) {
        return true;
    }

    public BlockState getStateForPlacement(BlockPlaceContext p_153131_) {
        return !this.defaultBlockState().canSurvive(p_153131_.getLevel(), p_153131_.getClickedPos()) ? Block.pushEntitiesUp(this.defaultBlockState(), originBlock.defaultBlockState(), p_153131_.getLevel(), p_153131_.getClickedPos()) : super.getStateForPlacement(p_153131_);
    }

    public BlockState updateShape(BlockState state, Direction direction, BlockState p_153154_, LevelAccessor levelAccessor, BlockPos pos, BlockPos p_153157_) {
        if (direction == Direction.UP && !state.canSurvive(levelAccessor, pos)) {
            levelAccessor.scheduleTick(pos, this, 1);
        }

        return super.updateShape(state, direction, p_153154_, levelAccessor, pos, p_153157_);
    }

    public void tick(BlockState blockState, ServerLevel level, BlockPos pos, Random p_153136_) {
        level.setBlockAndUpdate(pos, pushEntitiesUp(blockState, originBlock.defaultBlockState(), level, pos));
//        FarmBlock.turnToDirt(p_153133_, p_153134_, p_153135_);
    }

    public boolean canSurvive(BlockState state, LevelReader levelReader, BlockPos pos) {
        BlockState blockstate = levelReader.getBlockState(pos.above());
        return !blockstate.getMaterial().isSolid() || blockstate.getBlock() instanceof FenceGateBlock;
    }

    public VoxelShape getShape(BlockState state, BlockGetter getter, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }

    public boolean isPathfindable(BlockState state, BlockGetter getter, BlockPos pos, PathComputationType type) {
        return false;
    }
}