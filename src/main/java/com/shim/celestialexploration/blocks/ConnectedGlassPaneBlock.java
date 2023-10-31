package com.shim.celestialexploration.blocks;

import com.shim.celestialexploration.registry.BlockRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class ConnectedGlassPaneBlock extends Block {
    public static final BooleanProperty NORTH = BlockStateProperties.NORTH;
    public static final BooleanProperty EAST = BlockStateProperties.EAST;
    public static final BooleanProperty SOUTH = BlockStateProperties.SOUTH;
    public static final BooleanProperty WEST = BlockStateProperties.WEST;
    public static final BooleanProperty UP = BlockStateProperties.UP;
    public static final BooleanProperty DOWN = BlockStateProperties.DOWN;
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;

//    public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;

    public ConnectedGlassPaneBlock(BlockBehaviour.Properties p_48687_) {
        super(p_48687_);
        this.registerDefaultState(this.stateDefinition.any().setValue(NORTH, false).setValue(EAST, false).setValue(SOUTH, false).setValue(WEST, false).setValue(UP, false).setValue(DOWN, false).setValue(WATERLOGGED, false));
    }

    public boolean propagatesSkylightDown(BlockState p_52348_, BlockGetter p_52349_, BlockPos p_52350_) {
        return !p_52348_.getValue(WATERLOGGED);
    }

    public FluidState getFluidState(BlockState p_52362_) {
        return p_52362_.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(p_52362_);
    }


    public VoxelShape getVisualShape(BlockState p_48735_, BlockGetter p_48736_, BlockPos p_48737_, CollisionContext p_48738_) {
        return Shapes.empty();
    }

    public BlockState getStateForPlacement(BlockPlaceContext context) {
        LevelReader levelreader = context.getLevel();
        BlockPos blockpos = context.getClickedPos();
        FluidState fluidstate = context.getLevel().getFluidState(context.getClickedPos());

        BlockPos posNorth = blockpos.north();
        BlockPos posEast = blockpos.east();
        BlockPos posSouth = blockpos.south();
        BlockPos posWest = blockpos.west();
        BlockPos posAbove = blockpos.above();
        BlockPos posBelow = blockpos.below();

        BlockState stateNorth = levelreader.getBlockState(posNorth);
        BlockState stateEast = levelreader.getBlockState(posEast);
        BlockState stateSouth = levelreader.getBlockState(posSouth);
        BlockState stateWest = levelreader.getBlockState(posWest);
        BlockState stateAbove = levelreader.getBlockState(posAbove);
        BlockState stateBelow = levelreader.getBlockState(posBelow);

        boolean flagNorth = this.connectsTo(stateNorth);
        boolean flagEast = this.connectsTo(stateEast);
        boolean flagSouth = this.connectsTo(stateSouth);
        boolean flagWest = this.connectsTo(stateWest);
        boolean flagAbove = this.connectsTo(stateAbove);
        boolean flagBelow = this.connectsTo(stateBelow);

//        return this.updateShape(levelreader, blockpos5, blockstate4, flag, flag1, flag2, flag3);
        return super.getStateForPlacement(context).setValue(NORTH, flagNorth).setValue(EAST, flagEast).setValue(SOUTH, flagSouth).setValue(WEST, flagWest).setValue(UP, flagAbove).setValue(DOWN, flagBelow).setValue(WATERLOGGED, fluidstate.getType() == Fluids.WATER);

//        blockstate.setValue(UP, Boolean.valueOf(this.shouldRaisePost(blockstate, p_57983_, voxelshape)))

//        return this.defaultBlockState().setValue(FACING, p_48689_.getHorizontalDirection().getOpposite());
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(NORTH, EAST, SOUTH, WEST, UP, DOWN, WATERLOGGED);
    }

    public BlockState updateShape(BlockState p_53323_, Direction direction, BlockState p_53325_, LevelAccessor levelAccessor, BlockPos p_53327_, BlockPos p_53328_) {
        if (p_53323_.getValue(WATERLOGGED)) {
            levelAccessor.scheduleTick(p_53327_, Fluids.WATER, Fluids.WATER.getTickDelay(levelAccessor));
        }

        BlockPos posNorth = p_53327_.north();
        BlockPos posEast = p_53327_.east();
        BlockPos posSouth = p_53327_.south();
        BlockPos posWest = p_53327_.west();
        BlockPos posAbove = p_53327_.above();
        BlockPos posBelow = p_53327_.below();

        BlockState stateNorth = levelAccessor.getBlockState(posNorth);
        BlockState stateEast = levelAccessor.getBlockState(posEast);
        BlockState stateSouth = levelAccessor.getBlockState(posSouth);
        BlockState stateWest = levelAccessor.getBlockState(posWest);
        BlockState stateAbove = levelAccessor.getBlockState(posAbove);
        BlockState stateBelow = levelAccessor.getBlockState(posBelow);

        boolean flagNorth = this.connectsTo(stateNorth);
        boolean flagEast = this.connectsTo(stateEast);
        boolean flagSouth = this.connectsTo(stateSouth);
        boolean flagWest = this.connectsTo(stateWest);
        boolean flagAbove = this.connectsTo(stateAbove);
        boolean flagBelow = this.connectsTo(stateBelow);

        return p_53323_.setValue(NORTH, flagNorth).setValue(EAST, flagEast).setValue(SOUTH, flagSouth).setValue(WEST, flagWest).setValue(UP, flagAbove).setValue(DOWN, flagBelow);
    }


    private boolean connectsTo(BlockState state) {
        return state.is(BlockRegistry.CONNECTED_GLASS_PANE_TAG);
    }

    @Override
    public RenderShape getRenderShape(BlockState state) {
        return RenderShape.MODEL;
    }
}
