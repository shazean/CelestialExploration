package com.shim.celestialexploration.blocks;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import javax.annotation.Nullable;
import java.util.Map;

public class GlowStripBlock extends Block {
    public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
    protected static final VoxelShape AABB = Block.box(7.0D, 2.0D, 0.0D, 9.0D, 14.0D, 1.0D);
    private static final Map<Direction, VoxelShape> AABBS = Maps.newEnumMap(ImmutableMap.of(
            Direction.NORTH, Block.box(7.0D, 2.0D, 15.0D, 9.0D, 14.0D, 16.0D),
            Direction.SOUTH, Block.box(7.0D, 2.0D, 0.0D, 9.0D, 14.0D, 1.0D),
            Direction.WEST, Block.box(15.0D, 2.0D, 7.0D, 16.0D, 14.0D, 9.0D),
            Direction.EAST, Block.box(0.0D, 2.0D, 7.0D, 1.0D, 14.0D, 9.0D)));

    private static final Map<Direction, VoxelShape> H_AABBS = Maps.newEnumMap(ImmutableMap.of(
            Direction.SOUTH, Block.box(2.0D, 7.0D, 0.0D, 14.0D, 9.0D, 1.0D),
            Direction.NORTH, Block.box(2.0D, 7.0D, 15.0D, 14.0D, 9.0D, 16.0D),
            Direction.WEST, Block.box(15.0D, 7.0D, 2.0D, 16.0D, 9.0D, 14.0D),
            Direction.EAST, Block.box(0.0D, 7.0D, 2.0D, 1.0D, 9.0D, 14.0D)));


    protected static final VoxelShape AABB_2 = Block.box(2.0D, 9.0D, 0.0D, 14.0D, 14.0D, 1.0D);
    private final boolean horizontal;

    public GlowStripBlock(Properties p_49795_, boolean horizontal) {
        super(p_49795_);
        this.horizontal = horizontal;
    }

//    @Override
//    public RenderShape getRenderShape(BlockState state) {
//        return RenderShape.MODEL;
//    }


    public VoxelShape getShape(BlockState state, BlockGetter p_57511_, BlockPos p_57512_, CollisionContext p_57513_) {
        return horizontal ? H_AABBS.get(state.getValue(FACING)) : AABBS.get(state.getValue(FACING));
    }


    public boolean canSurvive(BlockState p_58133_, LevelReader p_58134_, BlockPos p_58135_) {
        Direction direction = p_58133_.getValue(FACING);
        BlockPos blockpos = p_58135_.relative(direction.getOpposite());
        BlockState blockstate = p_58134_.getBlockState(blockpos);
        return blockstate.isFaceSturdy(p_58134_, blockpos, direction);
    }

    @Nullable
    public BlockState getStateForPlacement(BlockPlaceContext p_58126_) {
        BlockState blockstate = this.defaultBlockState();
        LevelReader levelreader = p_58126_.getLevel();
        BlockPos blockpos = p_58126_.getClickedPos();
        Direction[] adirection = p_58126_.getNearestLookingDirections();

        for(Direction direction : adirection) {
            if (direction.getAxis().isHorizontal()) {
                Direction direction1 = direction.getOpposite();
                blockstate = blockstate.setValue(FACING, direction1);
                if (blockstate.canSurvive(levelreader, blockpos)) {
                    return blockstate;
                }
            }
        }

        return null;
    }

    public BlockState updateShape(BlockState p_58143_, Direction p_58144_, BlockState p_58145_, LevelAccessor p_58146_, BlockPos p_58147_, BlockPos p_58148_) {
        return p_58144_.getOpposite() == p_58143_.getValue(FACING) && !p_58143_.canSurvive(p_58146_, p_58147_) ? Blocks.AIR.defaultBlockState() : p_58143_;
    }


    public BlockState rotate(BlockState p_58140_, Rotation p_58141_) {
        return p_58140_.setValue(FACING, p_58141_.rotate(p_58140_.getValue(FACING)));
    }

    public BlockState mirror(BlockState p_58137_, Mirror p_58138_) {
        return p_58137_.rotate(p_58138_.getRotation(p_58137_.getValue(FACING)));
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> p_58150_) {
        p_58150_.add(FACING);
    }


}
