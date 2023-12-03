package com.shim.celestialexploration.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.properties.RailShape;

public class MagRailBlock extends BaseMagRailBlock {
    public static final EnumProperty<RailShape> SHAPE = BlockStateProperties.RAIL_SHAPE;

    public MagRailBlock(BlockBehaviour.Properties p_55395_) {
        super(false, p_55395_);
        this.registerDefaultState(this.stateDefinition.any().setValue(SHAPE, RailShape.NORTH_SOUTH).setValue(WATERLOGGED, Boolean.FALSE));
    }

    protected void updateState(BlockState p_55397_, Level level, BlockPos pos, Block block) {
        if (block.defaultBlockState().isSignalSource() && (new MagRailState(level, pos, p_55397_)).countPotentialConnections() == 3) {
            this.updateDir(level, pos, p_55397_, false);
        }

    }

    public Property<RailShape> getShapeProperty() {
        return SHAPE;
    }

    public BlockState rotate(BlockState state, Rotation p_55406_) {
        return switch (p_55406_) {
            case CLOCKWISE_180 -> switch ((RailShape) state.getValue(SHAPE)) {
                case ASCENDING_EAST -> state.setValue(SHAPE, RailShape.ASCENDING_WEST);
                case ASCENDING_WEST -> state.setValue(SHAPE, RailShape.ASCENDING_EAST);
                case ASCENDING_NORTH -> state.setValue(SHAPE, RailShape.ASCENDING_SOUTH);
                case ASCENDING_SOUTH -> state.setValue(SHAPE, RailShape.ASCENDING_NORTH);
                case SOUTH_EAST -> state.setValue(SHAPE, RailShape.NORTH_WEST);
                case SOUTH_WEST -> state.setValue(SHAPE, RailShape.NORTH_EAST);
                case NORTH_WEST -> state.setValue(SHAPE, RailShape.SOUTH_EAST);
                case NORTH_EAST -> state.setValue(SHAPE, RailShape.SOUTH_WEST);
                case NORTH_SOUTH, EAST_WEST -> state;
            };
            case COUNTERCLOCKWISE_90 -> switch ((RailShape) state.getValue(SHAPE)) {
                case ASCENDING_EAST -> state.setValue(SHAPE, RailShape.ASCENDING_NORTH);
                case ASCENDING_WEST -> state.setValue(SHAPE, RailShape.ASCENDING_SOUTH);
                case ASCENDING_NORTH -> state.setValue(SHAPE, RailShape.ASCENDING_WEST);
                case ASCENDING_SOUTH -> state.setValue(SHAPE, RailShape.ASCENDING_EAST);
                case SOUTH_EAST -> state.setValue(SHAPE, RailShape.NORTH_EAST);
                case SOUTH_WEST -> state.setValue(SHAPE, RailShape.SOUTH_EAST);
                case NORTH_WEST -> state.setValue(SHAPE, RailShape.SOUTH_WEST);
                case NORTH_EAST -> state.setValue(SHAPE, RailShape.NORTH_WEST);
                case NORTH_SOUTH -> state.setValue(SHAPE, RailShape.EAST_WEST);
                case EAST_WEST -> state.setValue(SHAPE, RailShape.NORTH_SOUTH);
            };
            case CLOCKWISE_90 -> switch ((RailShape) state.getValue(SHAPE)) {
                case ASCENDING_EAST -> state.setValue(SHAPE, RailShape.ASCENDING_SOUTH);
                case ASCENDING_WEST -> state.setValue(SHAPE, RailShape.ASCENDING_NORTH);
                case ASCENDING_NORTH -> state.setValue(SHAPE, RailShape.ASCENDING_EAST);
                case ASCENDING_SOUTH -> state.setValue(SHAPE, RailShape.ASCENDING_WEST);
                case SOUTH_EAST -> state.setValue(SHAPE, RailShape.SOUTH_WEST);
                case SOUTH_WEST -> state.setValue(SHAPE, RailShape.NORTH_WEST);
                case NORTH_WEST -> state.setValue(SHAPE, RailShape.NORTH_EAST);
                case NORTH_EAST -> state.setValue(SHAPE, RailShape.SOUTH_EAST);
                case NORTH_SOUTH -> state.setValue(SHAPE, RailShape.EAST_WEST);
                case EAST_WEST -> state.setValue(SHAPE, RailShape.NORTH_SOUTH);
            };
            default -> state;
        };
    }

    public BlockState mirror(BlockState state, Mirror p_55403_) {
        RailShape railshape = state.getValue(SHAPE);
        switch(p_55403_) {
            case LEFT_RIGHT:
                return switch (railshape) {
                    case ASCENDING_NORTH -> state.setValue(SHAPE, RailShape.ASCENDING_SOUTH);
                    case ASCENDING_SOUTH -> state.setValue(SHAPE, RailShape.ASCENDING_NORTH);
                    case SOUTH_EAST -> state.setValue(SHAPE, RailShape.NORTH_EAST);
                    case SOUTH_WEST -> state.setValue(SHAPE, RailShape.NORTH_WEST);
                    case NORTH_WEST -> state.setValue(SHAPE, RailShape.SOUTH_WEST);
                    case NORTH_EAST -> state.setValue(SHAPE, RailShape.SOUTH_EAST);
                    default -> super.mirror(state, p_55403_);
                };
            case FRONT_BACK:
                switch(railshape) {
                    case ASCENDING_EAST:
                        return state.setValue(SHAPE, RailShape.ASCENDING_WEST);
                    case ASCENDING_WEST:
                        return state.setValue(SHAPE, RailShape.ASCENDING_EAST);
                    case ASCENDING_NORTH:
                    case ASCENDING_SOUTH:
                    default:
                        break;
                    case SOUTH_EAST:
                        return state.setValue(SHAPE, RailShape.SOUTH_WEST);
                    case SOUTH_WEST:
                        return state.setValue(SHAPE, RailShape.SOUTH_EAST);
                    case NORTH_WEST:
                        return state.setValue(SHAPE, RailShape.NORTH_EAST);
                    case NORTH_EAST:
                        return state.setValue(SHAPE, RailShape.NORTH_WEST);
                }
        }

        return super.mirror(state, p_55403_);
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> p_55408_) {
        p_55408_.add(SHAPE, WATERLOGGED);
    }
}
