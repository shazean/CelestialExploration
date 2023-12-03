package com.shim.celestialexploration.blocks;

import com.shim.celestialexploration.entity.vehicle.AbstractMagCart;
import com.shim.celestialexploration.entity.vehicle.IBaseMagRailBlock;
import com.shim.celestialexploration.registry.BlockRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.BaseRailBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.properties.RailShape;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public abstract class BaseMagRailBlock extends Block implements SimpleWaterloggedBlock, IBaseMagRailBlock {
    protected static final VoxelShape FLAT_AABB = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 2.0D, 16.0D);
    protected static final VoxelShape HALF_BLOCK_AABB = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 8.0D, 16.0D);
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    private final boolean isStraight;

    public static boolean isRail(Level level, BlockPos pos) {
        return isRail(level.getBlockState(pos));
    }

    public static boolean isRail(BlockState state) {
        return state.is(BlockRegistry.MAG_RAIL_TAG) && state.getBlock() instanceof BaseMagRailBlock;
    }

    protected BaseMagRailBlock(boolean isStraight, BlockBehaviour.Properties properties) {
        super(properties);
        this.isStraight = isStraight;
    }

    public boolean isStraight() {
        return this.isStraight;
    }

    public VoxelShape getShape(BlockState state, BlockGetter blockGetter, BlockPos pos, CollisionContext context) {
        RailShape railshape = state.is(this) ? state.getValue(this.getShapeProperty()) : null;
        RailShape railShape2 = state.is(this) ? getRailDirection(state, blockGetter, pos, null) : null;
        return railshape != null && railshape.isAscending() ? HALF_BLOCK_AABB : FLAT_AABB;
    }

    public boolean canSurvive(BlockState state, LevelReader reader, BlockPos pos) {
        return canSupportRigidBlock(reader, pos.below());
    }

    public void onPlace(BlockState p_49408_, Level level, BlockPos pos, BlockState p_49411_, boolean p_49412_) {
        if (!p_49411_.is(p_49408_.getBlock())) {
            this.updateState(p_49408_, level, pos, p_49412_);
        }
    }

    protected BlockState updateState(BlockState state, Level level, BlockPos pos, boolean p_49393_) {
        state = this.updateDir(level, pos, state, true);
        if (this.isStraight) {
            state.neighborChanged(level, pos, this, pos, p_49393_);
        }

        return state;
    }

    public void neighborChanged(BlockState p_49377_, Level p_49378_, BlockPos p_49379_, Block p_49380_, BlockPos p_49381_, boolean p_49382_) {
        if (!p_49378_.isClientSide && p_49378_.getBlockState(p_49379_).is(this)) {
            RailShape railshape = getRailDirection(p_49377_, p_49378_, p_49379_, null);
            if (shouldBeRemoved(p_49379_, p_49378_, railshape)) {
                dropResources(p_49377_, p_49378_, p_49379_);
                p_49378_.removeBlock(p_49379_, p_49382_);
            } else {
                this.updateState(p_49377_, p_49378_, p_49379_, p_49380_);
            }

        }
    }

    private static boolean shouldBeRemoved(BlockPos pos, Level level, RailShape shape) {
        if (!canSupportRigidBlock(level, pos.below())) {
            return true;
        } else {
            switch(shape) {
                case ASCENDING_EAST:
                    return !canSupportRigidBlock(level, pos.east());
                case ASCENDING_WEST:
                    return !canSupportRigidBlock(level, pos.west());
                case ASCENDING_NORTH:
                    return !canSupportRigidBlock(level, pos.north());
                case ASCENDING_SOUTH:
                    return !canSupportRigidBlock(level, pos.south());
                default:
                    return false;
            }
        }
    }

    protected void updateState(BlockState state, Level level, BlockPos pos, Block block) {}

    protected BlockState updateDir(Level p_49368_, BlockPos p_49369_, BlockState p_49370_, boolean p_49371_) {
        if (p_49368_.isClientSide) {
            return p_49370_;
        } else {
            RailShape railshape = p_49370_.getValue(this.getShapeProperty());
            return (new MagRailState(p_49368_, p_49369_, p_49370_)).place(p_49368_.hasNeighborSignal(p_49369_), p_49371_, railshape).getState();
        }
    }

    public PushReaction getPistonPushReaction(BlockState state) {
        return PushReaction.NORMAL;
    }

    public void onRemove(BlockState p_49384_, Level level, BlockPos pos, BlockState p_49387_, boolean p_49388_) {
        if (!p_49388_) {
            super.onRemove(p_49384_, level, pos, p_49387_, p_49388_);
            if (getRailDirection(p_49384_, level, pos, null).isAscending()) {
                level.updateNeighborsAt(pos.above(), this);
            }

            if (this.isStraight) {
                level.updateNeighborsAt(pos, this);
                level.updateNeighborsAt(pos.below(), this);
            }

        }
    }

    public BlockState getStateForPlacement(BlockPlaceContext context) {
        FluidState fluidstate = context.getLevel().getFluidState(context.getClickedPos());
        boolean flag = fluidstate.getType() == Fluids.WATER;
        BlockState blockstate = super.defaultBlockState();
        Direction direction = context.getHorizontalDirection();
        boolean flag1 = direction == Direction.EAST || direction == Direction.WEST;
        return blockstate.setValue(this.getShapeProperty(), flag1 ? RailShape.EAST_WEST : RailShape.NORTH_SOUTH).setValue(WATERLOGGED, flag);
    }

    /**
     * @deprecated Forge: Use {@link BaseRailBlock#getRailDirection(BlockState, BlockGetter, BlockPos, net.minecraft.world.entity.vehicle.AbstractMinecart)} for enhanced ability
     * If you do change this property be aware that other functions in this/subclasses may break as they can make assumptions about this property
     */
    @Deprecated
    public abstract Property<RailShape> getShapeProperty();

    public BlockState updateShape(BlockState p_152151_, Direction direction, BlockState p_152153_, LevelAccessor levelAccessor, BlockPos p_152155_, BlockPos p_152156_) {
        if (p_152151_.getValue(WATERLOGGED)) {
            levelAccessor.scheduleTick(p_152155_, Fluids.WATER, Fluids.WATER.getTickDelay(levelAccessor));
        }

        return super.updateShape(p_152151_, direction, p_152153_, levelAccessor, p_152155_, p_152156_);
    }

    public FluidState getFluidState(BlockState p_152158_) {
        return p_152158_.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(p_152158_);
    }

    @Override
    public boolean isFlexibleRail(BlockState state, BlockGetter world, BlockPos pos) {
        return !this.isStraight;
    }

    @Override
    public RailShape getRailDirection(BlockState state, BlockGetter world, BlockPos pos, AbstractMagCart cart) {
        return state.getValue(getShapeProperty());
    }
}