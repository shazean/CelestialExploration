package com.shim.celestialexploration.blocks;

import com.shim.celestialexploration.registry.BlockRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.*;
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
import net.minecraftforge.common.Tags;

public class ConnectedGlassPaneBlock extends IronBarsBlock {
    public static final BooleanProperty NORTH = BlockStateProperties.NORTH;
    public static final BooleanProperty EAST = BlockStateProperties.EAST;
    public static final BooleanProperty SOUTH = BlockStateProperties.SOUTH;
    public static final BooleanProperty WEST = BlockStateProperties.WEST;
    public static final BooleanProperty UP = BlockStateProperties.UP;
    public static final BooleanProperty DOWN = BlockStateProperties.DOWN;
    public static final BooleanProperty NORTH_GLASS = BooleanProperty.create("north_glass");
    public static final BooleanProperty EAST_GLASS = BooleanProperty.create("east_glass");
    public static final BooleanProperty SOUTH_GLASS = BooleanProperty.create("south_glass");
    public static final BooleanProperty WEST_GLASS = BooleanProperty.create("west_glass");
    public static final BooleanProperty UP_GLASS = BooleanProperty.create("up_glass");
    public static final BooleanProperty DOWN_GLASS = BooleanProperty.create("down_glass");
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;

//    public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;

    public ConnectedGlassPaneBlock(BlockBehaviour.Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any()
                .setValue(NORTH, false)
                .setValue(EAST, false)
                .setValue(SOUTH, false)
                .setValue(WEST, false)
                .setValue(UP, false)
                .setValue(DOWN, false)
                .setValue(NORTH_GLASS, false)
                .setValue(EAST_GLASS, false)
                .setValue(SOUTH_GLASS, false)
                .setValue(WEST_GLASS, false)
                .setValue(UP_GLASS, false)
                .setValue(DOWN_GLASS, false)
                .setValue(WATERLOGGED, false));
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


        boolean flagNorth = this.connectsTo(stateNorth, stateNorth.isFaceSturdy(levelreader, posNorth, Direction.SOUTH));
        boolean flagEast = this.connectsTo(stateEast, stateEast.isFaceSturdy(levelreader, posEast, Direction.WEST));
        boolean flagSouth = this.connectsTo(stateSouth, stateSouth.isFaceSturdy(levelreader, posSouth, Direction.NORTH));
        boolean flagWest = this.connectsTo(stateWest, stateWest.isFaceSturdy(levelreader, posWest, Direction.EAST));
        boolean flagAbove = this.connectsTo(stateAbove, stateAbove.isFaceSturdy(levelreader, posAbove, Direction.DOWN));
        boolean flagBelow = this.connectsTo(stateBelow, stateBelow.isFaceSturdy(levelreader, posBelow, Direction.UP));

        boolean flagNorthGlass = this.connectsToGlass(stateNorth);
        boolean flagEastGlass = this.connectsToGlass(stateEast);
        boolean flagSouthGlass = this.connectsToGlass(stateSouth);
        boolean flagWestGlass = this.connectsToGlass(stateWest);
        boolean flagAboveGlass = this.connectsToGlass(stateAbove);
        boolean flagBelowGlass = this.connectsToGlass(stateBelow);



//        return this.defaultBlockState()
//                .setValue(NORTH, Boolean.valueOf(this.connectsTo(stateNorth, stateNorth.isFaceSturdy(levelreader, posNorth, Direction.SOUTH))))
//                .setValue(SOUTH, Boolean.valueOf(this.connectsTo(stateSouth, stateSouth.isFaceSturdy(levelreader, posSouth, Direction.NORTH))))
//                .setValue(WEST, Boolean.valueOf(this.connectsTo(stateSouth, stateSouth.isFaceSturdy(levelreader, posSouth, Direction.NORTH))))
//                .setValue(EAST, Boolean.valueOf(this.attachsTo(blockstate3, blockstate3.isFaceSturdy(levelreader, blockpos4, Direction.WEST))))
//                .setValue(WATERLOGGED, Boolean.valueOf(fluidstate.getType() == Fluids.WATER));
//    }

//        return this.updateShape(levelreader, blockpos5, blockstate4, flag, flag1, flag2, flag3);
        return super.getStateForPlacement(context)
                .setValue(NORTH, flagNorth)
                .setValue(EAST, flagEast)
                .setValue(SOUTH, flagSouth)
                .setValue(WEST, flagWest)
                .setValue(UP, flagAbove)
                .setValue(DOWN, flagBelow)
                .setValue(NORTH_GLASS, flagNorthGlass)
                .setValue(EAST_GLASS, flagEastGlass)
                .setValue(SOUTH_GLASS, flagSouthGlass)
                .setValue(WEST_GLASS, flagWestGlass)
                .setValue(UP_GLASS, flagAboveGlass)
                .setValue(DOWN_GLASS, flagBelowGlass)
                .setValue(WATERLOGGED, fluidstate.getType() == Fluids.WATER);

//        blockstate.setValue(UP, Boolean.valueOf(this.shouldRaisePost(blockstate, p_57983_, voxelshape)))

//        return this.defaultBlockState().setValue(FACING, p_48689_.getHorizontalDirection().getOpposite());
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(NORTH, EAST, SOUTH, WEST, UP, DOWN, NORTH_GLASS, EAST_GLASS, SOUTH_GLASS, WEST_GLASS, UP_GLASS, DOWN_GLASS, WATERLOGGED);
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

        boolean flagNorth = this.connectsTo(stateNorth, stateNorth.isFaceSturdy(levelAccessor, posNorth, Direction.SOUTH));
        boolean flagEast = this.connectsTo(stateEast, stateEast.isFaceSturdy(levelAccessor, posEast, Direction.WEST));
        boolean flagSouth = this.connectsTo(stateSouth, stateSouth.isFaceSturdy(levelAccessor, posSouth, Direction.NORTH));
        boolean flagWest = this.connectsTo(stateWest, stateWest.isFaceSturdy(levelAccessor, posWest, Direction.EAST));
        boolean flagAbove = this.connectsTo(stateAbove, stateAbove.isFaceSturdy(levelAccessor, posAbove, Direction.DOWN));
        boolean flagBelow = this.connectsTo(stateBelow, stateBelow.isFaceSturdy(levelAccessor, posBelow, Direction.UP));

        boolean flagNorthGlass = this.connectsToGlass(stateNorth);
        boolean flagEastGlass = this.connectsToGlass(stateEast);
        boolean flagSouthGlass = this.connectsToGlass(stateSouth);
        boolean flagWestGlass = this.connectsToGlass(stateWest);
        boolean flagAboveGlass = this.connectsToGlass(stateAbove);
        boolean flagBelowGlass = this.connectsToGlass(stateBelow);

        return p_53323_.setValue(NORTH, flagNorth)
                .setValue(EAST, flagEast)
                .setValue(SOUTH, flagSouth)
                .setValue(WEST, flagWest)
                .setValue(UP, flagAbove)
                .setValue(DOWN, flagBelow)
                .setValue(NORTH_GLASS, flagNorthGlass)
                .setValue(EAST_GLASS, flagEastGlass)
                .setValue(SOUTH_GLASS, flagSouthGlass)
                .setValue(WEST_GLASS, flagWestGlass)
                .setValue(UP_GLASS, flagAboveGlass)
                .setValue(DOWN_GLASS, flagBelowGlass);
    }


    private boolean connectsTo(BlockState state, Boolean p_54219_) {
//        return true;
        return !isExceptionForConnection(state) && p_54219_ || state.getBlock() instanceof ConnectedGlassPaneBlock || state.getBlock() instanceof IronBarsBlock || state.is(BlockTags.WALLS);
//        return !(state.getBlock() instanceof AirBlock);
//        return state.is(BlockRegistry.CONNECTED_GLASS_PANE_TAG);
    }

    private boolean connectsToGlass(BlockState state) {
//        return true;
//        return !isExceptionForConnection(state) && p_54219_ || state.getBlock() instanceof ConnectedGlassPaneBlock || state.is(BlockTags.WALLS);
//        return !(state.getBlock() instanceof AirBlock);
        return state.is(BlockRegistry.CONNECTED_GLASS_PANE_TAG);
    }

//    @Override
//    public RenderShape getRenderShape(BlockState state) {
//        return RenderShape.MODEL;
//    }
}