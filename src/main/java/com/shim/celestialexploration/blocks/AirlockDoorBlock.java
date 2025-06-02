package com.shim.celestialexploration.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.*;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import javax.annotation.Nullable;

public class AirlockDoorBlock extends Block {
    public static final EnumProperty<CelestialProperties.AirlockDoorHingeSide> HINGE = CelestialProperties.HINGE;
//    public static final EnumProperty<DoorPieceType> DOOR_PIECE = EnumProperty.create("door_piece", DoorPieceType.class);
    public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
    public static final BooleanProperty OPEN = BlockStateProperties.OPEN;
    public static final BooleanProperty POWERED = BlockStateProperties.POWERED;
    protected static final VoxelShape SOUTH_AABB = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 3.0D);
    protected static final VoxelShape NORTH_AABB = Block.box(0.0D, 0.0D, 13.0D, 16.0D, 16.0D, 16.0D);
    protected static final VoxelShape WEST_AABB = Block.box(13.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D);
    protected static final VoxelShape EAST_AABB = Block.box(0.0D, 0.0D, 0.0D, 3.0D, 16.0D, 16.0D);
    protected static final VoxelShape SW_CORNER_AABB = Block.box(0.0D, 0.0D, 11.0D, 5.0D, 16.0D, 16.0D);
    protected static final VoxelShape NW_CORNER_AABB = Block.box(0.0D, 0.0D, 0.0D, 5.0D, 16.0D, 5.0D);
    protected static final VoxelShape NE_CORNER_AABB = Block.box(11.0D, 0.0D, 0.0D, 16.0D, 16.0D, 5.0D);
    protected static final VoxelShape SE_CORNER_AABB = Block.box(11.0D, 0.0D, 11.0D, 16.0D, 16.0D, 16.0D);
    protected static final Vec2 MAX_SIZE = new Vec2(5, 5);

    public VoxelShape getShape(BlockState state, BlockGetter getter, BlockPos pos, CollisionContext context) {
        Direction direction = state.getValue(FACING);
        boolean notOpen = !state.getValue(OPEN);

        if (!notOpen && state.getValue(HINGE) == CelestialProperties.AirlockDoorHingeSide.NON_HINGE) {
            return Shapes.empty();
        }

        boolean hingeOnRight = state.getValue(HINGE) == CelestialProperties.AirlockDoorHingeSide.RIGHT;
        return switch (direction) {
            case EAST -> notOpen ? EAST_AABB : (hingeOnRight ? SW_CORNER_AABB : NW_CORNER_AABB);
            case SOUTH -> notOpen ? SOUTH_AABB : (hingeOnRight ? NW_CORNER_AABB : NE_CORNER_AABB);
            case WEST -> notOpen ? WEST_AABB : (hingeOnRight ? NE_CORNER_AABB : SE_CORNER_AABB);
            case NORTH -> notOpen ? NORTH_AABB : (hingeOnRight ? SE_CORNER_AABB : SW_CORNER_AABB);
            default -> notOpen ? EAST_AABB : (hingeOnRight ? SW_CORNER_AABB : NW_CORNER_AABB);
        };
    }

    public AirlockDoorBlock(Properties p_49795_) {
        super(p_49795_);
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(OPEN, false).setValue(POWERED, false).setValue(HINGE, CelestialProperties.AirlockDoorHingeSide.LEFT));
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> p_52803_) {
        p_52803_.add(FACING, OPEN, HINGE, POWERED);
    }

   public boolean canSurvive(BlockState state, LevelReader levelReader, BlockPos pos) {
       BlockPos blockBelow = pos.below();
       BlockPos blockAbove = pos.above();
       BlockState blockstateBelow = levelReader.getBlockState(blockBelow);
       BlockState blockstateAbove = levelReader.getBlockState(blockAbove);
       return blockstateBelow.isFaceSturdy(levelReader, blockBelow, Direction.UP) || blockstateAbove.isFaceSturdy(levelReader, blockAbove, Direction.DOWN) || blockstateBelow.getBlock() instanceof AirlockDoorBlock || blockstateAbove.getBlock() instanceof AirlockDoorBlock;
    }

    @Nullable
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        int oppositeNeighbor = neighborHasOppositeHinge(context);
        boolean shouldHaveHinge = !hasNeighbor(context) || aboveOrBelowHinge(context) || /*!aboveOrBelowNonHinge(context) ||*/ oppositeNeighbor > 0 || hasReachedMaxWidth(context);
        Level level = context.getLevel();
        BlockPos clickedPos = context.getClickedPos();

        boolean powered = level.hasNeighborSignal(clickedPos) || level.hasNeighborSignal(clickedPos.above()) || level.hasNeighborSignal(clickedPos.below());
        BlockState blockBelow = context.getLevel().getBlockState(clickedPos.below());
        BlockState blockAbove = context.getLevel().getBlockState(clickedPos.above());

        Direction facing = blockBelow.getBlock() instanceof AirlockDoorBlock ? blockBelow.getValue(FACING) : (blockAbove.getBlock() instanceof AirlockDoorBlock ? blockAbove.getValue(FACING) : context.getHorizontalDirection());
        CelestialProperties.AirlockDoorHingeSide hingeSide;
        if (shouldHaveHinge) {
            if (blockBelow.getBlock() instanceof AirlockDoorBlock) hingeSide = blockBelow.getValue(HINGE);
            else if (blockAbove.getBlock() instanceof AirlockDoorBlock) hingeSide = blockAbove.getValue(HINGE);
            else if (oppositeNeighbor == 1) hingeSide = CelestialProperties.AirlockDoorHingeSide.LEFT;
            else if (oppositeNeighbor == 2) hingeSide = CelestialProperties.AirlockDoorHingeSide.RIGHT;
            else hingeSide = this.getHinge(context);
        } else {
            hingeSide = CelestialProperties.AirlockDoorHingeSide.NON_HINGE;
        }
        return this.defaultBlockState().setValue(FACING, facing).setValue(HINGE, hingeSide).setValue(POWERED, powered).setValue(OPEN, powered);
    }

    public boolean hasReachedMaxWidth(BlockPlaceContext context) {
        BlockGetter blockgetter = context.getLevel();
        Direction direction = context.getHorizontalDirection();
        Direction clockWise = direction.getClockWise();
        Direction counterClockWise = direction.getCounterClockWise();
        int distToLeft = 0;
        int distToRight = 0;
        int i;
        BlockState block;

        for (i = 0; i < MAX_SIZE.x; i++) {
            block = blockgetter.getBlockState(context.getClickedPos().relative(counterClockWise, i + 1));
            if (block.getBlock() instanceof AirlockDoorBlock && block.getValue(HINGE) != CelestialProperties.AirlockDoorHingeSide.NON_HINGE) return false;
            distToLeft++;
        }
        if (distToLeft > MAX_SIZE.x) return true;
        for (i = 0; i < MAX_SIZE.x + 1; i++) {
            block = blockgetter.getBlockState(context.getClickedPos().relative(clockWise, i + 1));
            if (block.getBlock() instanceof AirlockDoorBlock && block.getValue(HINGE) != CelestialProperties.AirlockDoorHingeSide.NON_HINGE) return false;
            distToRight++;
        }
        return (distToRight + distToLeft) > MAX_SIZE.x - 1;
    }

    public boolean hasNeighbor(BlockPlaceContext context) {
        BlockGetter blockgetter = context.getLevel();
        Direction direction = context.getHorizontalDirection();

        Direction directionOne = direction.getClockWise();
        Direction directionTwo = direction.getCounterClockWise();

        BlockState above = blockgetter.getBlockState(context.getClickedPos().above());
        BlockState below = blockgetter.getBlockState(context.getClickedPos().below());
        BlockState toLeft = blockgetter.getBlockState(context.getClickedPos().relative(directionOne));
        BlockState toRight = blockgetter.getBlockState(context.getClickedPos().relative(directionTwo));

        return isSameAndFacing(toLeft, direction) || isSameAndFacing(toRight, direction) || isSameAndFacing(above, direction) || isSameAndFacing(below, direction); //isSame(north) || isSame(west) || isSame(south) || isSame(east);
    }

    public int neighborHasOppositeHinge(BlockPlaceContext context) {
        BlockGetter blockgetter = context.getLevel();
        Direction direction = context.getHorizontalDirection();

        Direction directionOne = direction.getClockWise();
        Direction directionTwo = direction.getCounterClockWise();

        BlockState toLeft = blockgetter.getBlockState(context.getClickedPos().relative(directionTwo));
        BlockState toRight = blockgetter.getBlockState(context.getClickedPos().relative(directionOne));

        if (toLeft.getBlock() instanceof AirlockDoorBlock && toLeft.getValue(HINGE).toString().equals("right")) {
            return 1;
        }
        if (toRight.getBlock() instanceof AirlockDoorBlock && toRight.getValue(HINGE).toString().equals("left")) {
            return 2;
        } else {
            return 0;
        }
    }

    public boolean isSameAndFacing(BlockState compared, Direction direction) {
//        if (!compared.is(this)) return false;
        if (!(compared.getBlock() instanceof AirlockDoorBlock)) return false;
        return compared.getValue(FACING) == direction;
    }

    public boolean aboveOrBelowHinge(BlockPlaceContext context) {
        BlockGetter blockgetter = context.getLevel();
        BlockState above = blockgetter.getBlockState(context.getClickedPos().above());
        BlockState below = blockgetter.getBlockState(context.getClickedPos().below());

        if (above.getBlock() instanceof AirlockDoorBlock && isHinge(above)) return true;
        else return below.getBlock() instanceof AirlockDoorBlock && isHinge(below);
    }

    public boolean isOpen(BlockState p_52816_) {
        return p_52816_.getValue(OPEN);
    }

    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {
        if (this.material == Material.METAL) {
            return InteractionResult.PASS;
        } else {
        state = state.cycle(OPEN);
        level.setBlock(pos, state, 10);
        level.levelEvent(player, state.getValue(OPEN) ? this.getOpenSound() : this.getCloseSound(), pos, 0);
        level.gameEvent(player, this.isOpen(state) ? GameEvent.BLOCK_OPEN : GameEvent.BLOCK_CLOSE, pos);
        level.updateNeighborsAt(pos, this);
        return InteractionResult.sidedSuccess(level.isClientSide);
        }
    }

    public void neighborChanged(BlockState self, Level level, BlockPos selfPos, Block block, BlockPos neighborPos, boolean p_52781_) {
        BlockState neighbor = level.getBlockState(neighborPos);

        if (neighbor.getBlock() instanceof AirlockDoorBlock) {
            boolean isOpen = neighbor.getValue(OPEN);

            //TODO future me, please find a better way of doing this?
            if (neighbor.getValue(HINGE) != CelestialProperties.AirlockDoorHingeSide.NON_HINGE && self.getValue(HINGE) !=  CelestialProperties.AirlockDoorHingeSide.NON_HINGE) {
            } else if (neighbor.getValue(HINGE) == CelestialProperties.AirlockDoorHingeSide.NON_HINGE && self.getValue(HINGE) != CelestialProperties.AirlockDoorHingeSide.NON_HINGE) {
                if (self.getValue(FACING) == Direction.NORTH && selfPos.getX() < neighborPos.getX() && self.getValue(HINGE) == CelestialProperties.AirlockDoorHingeSide.RIGHT) {
                } else if (self.getValue(FACING) == Direction.NORTH && selfPos.getX() > neighborPos.getX() && self.getValue(HINGE) == CelestialProperties.AirlockDoorHingeSide.LEFT) {
                } else if (self.getValue(FACING) == Direction.SOUTH && selfPos.getX() < neighborPos.getX() && self.getValue(HINGE) == CelestialProperties.AirlockDoorHingeSide.LEFT) {
                } else if (self.getValue(FACING) == Direction.SOUTH && selfPos.getX() > neighborPos.getX() && self.getValue(HINGE) == CelestialProperties.AirlockDoorHingeSide.RIGHT) {
                } else if (self.getValue(FACING) == Direction.WEST && selfPos.getZ() > neighborPos.getZ() && self.getValue(HINGE) == CelestialProperties.AirlockDoorHingeSide.RIGHT) {
                } else if (self.getValue(FACING) == Direction.WEST && selfPos.getZ() < neighborPos.getZ() && self.getValue(HINGE) == CelestialProperties.AirlockDoorHingeSide.LEFT) {
                } else if (self.getValue(FACING) == Direction.EAST && selfPos.getZ() < neighborPos.getZ() && self.getValue(HINGE) == CelestialProperties.AirlockDoorHingeSide.RIGHT) {
                } else if (self.getValue(FACING) == Direction.EAST && selfPos.getZ() > neighborPos.getZ() && self.getValue(HINGE) == CelestialProperties.AirlockDoorHingeSide.LEFT) {
                } else {
                    if (neighbor.getValue(FACING) == self.getValue(FACING))
                        level.setBlockAndUpdate(selfPos, self.setValue(OPEN, isOpen));
                }

            } else if (neighbor.getValue(HINGE) != CelestialProperties.AirlockDoorHingeSide.NON_HINGE && self.getValue(HINGE) == CelestialProperties.AirlockDoorHingeSide.NON_HINGE) {
                if (self.getValue(FACING) == Direction.NORTH && selfPos.getX() < neighborPos.getX() && neighbor.getValue(HINGE) == CelestialProperties.AirlockDoorHingeSide.LEFT) {
                } else if (self.getValue(FACING) == Direction.NORTH && selfPos.getX() > neighborPos.getX() && neighbor.getValue(HINGE) == CelestialProperties.AirlockDoorHingeSide.RIGHT) {
                } else if (self.getValue(FACING) == Direction.SOUTH && selfPos.getX() < neighborPos.getX() && neighbor.getValue(HINGE) == CelestialProperties.AirlockDoorHingeSide.RIGHT) {
                } else if (self.getValue(FACING) == Direction.SOUTH && selfPos.getX() > neighborPos.getX() && neighbor.getValue(HINGE) == CelestialProperties.AirlockDoorHingeSide.LEFT) {
                } else if (self.getValue(FACING) == Direction.WEST && selfPos.getZ() < neighborPos.getZ() && neighbor.getValue(HINGE) == CelestialProperties.AirlockDoorHingeSide.RIGHT) {
                } else if (self.getValue(FACING) == Direction.WEST && selfPos.getZ() > neighborPos.getZ() && neighbor.getValue(HINGE) == CelestialProperties.AirlockDoorHingeSide.LEFT) {
                } else if (self.getValue(FACING) == Direction.EAST && selfPos.getZ() > neighborPos.getZ() && neighbor.getValue(HINGE) == CelestialProperties.AirlockDoorHingeSide.RIGHT) {
                } else if (self.getValue(FACING) == Direction.EAST && selfPos.getZ() < neighborPos.getZ() && neighbor.getValue(HINGE) == CelestialProperties.AirlockDoorHingeSide.LEFT) {
                } else {
                    if (neighbor.getValue(FACING) == self.getValue(FACING))
                        level.setBlockAndUpdate(selfPos, self.setValue(OPEN, isOpen));
                }
            } else {
                if (neighbor.getValue(FACING) == self.getValue(FACING))
                    level.setBlockAndUpdate(selfPos, self.setValue(OPEN, isOpen));
            }
        }

        boolean neighborSignal = level.hasNeighborSignal(selfPos);
        if (!this.defaultBlockState().is(block) && neighborSignal != self.getValue(POWERED)) {
            if (neighborSignal != self.getValue(OPEN)) {
                this.playSound(level, selfPos, neighborSignal);
                level.gameEvent(neighborSignal ? GameEvent.BLOCK_OPEN : GameEvent.BLOCK_CLOSE, selfPos);
            }
            level.setBlockAndUpdate(selfPos, self.setValue(POWERED, neighborSignal).setValue(OPEN, neighborSignal));
        }
    }

    private void playSound(Level p_52760_, BlockPos p_52761_, boolean p_52762_) {
        p_52760_.levelEvent(null, p_52762_ ? this.getOpenSound() : this.getCloseSound(), p_52761_, 0);
    }

    private int getCloseSound() {
        return 1011;
    }

    private int getOpenSound() {
        return 1005;
    }

    public static boolean isHinge(BlockState state) {
        return state.getValue(HINGE) != CelestialProperties.AirlockDoorHingeSide.NON_HINGE;
    }

    private CelestialProperties.AirlockDoorHingeSide getHinge(BlockPlaceContext context) {
        BlockGetter blockgetter = context.getLevel();
        BlockPos clickedPos = context.getClickedPos();
        Direction direction = context.getHorizontalDirection();
        BlockPos blockAboveClicked = clickedPos.above();
        Direction direction1 = direction.getCounterClockWise();
        BlockPos blockpos2 = clickedPos.relative(direction1);
        BlockState blockstate = blockgetter.getBlockState(blockpos2);
        BlockPos blockpos3 = blockAboveClicked.relative(direction1);
        BlockState blockstate1 = blockgetter.getBlockState(blockpos3);
        Direction direction2 = direction.getClockWise();
        BlockPos blockpos4 = clickedPos.relative(direction2);
        BlockState blockstate2 = blockgetter.getBlockState(blockpos4);
        BlockPos blockpos5 = blockAboveClicked.relative(direction2);
        BlockState blockstate3 = blockgetter.getBlockState(blockpos5);
        int i = (blockstate.isCollisionShapeFullBlock(blockgetter, blockpos2) ? -1 : 0) + (blockstate1.isCollisionShapeFullBlock(blockgetter, blockpos3) ? -1 : 0) + (blockstate2.isCollisionShapeFullBlock(blockgetter, blockpos4) ? 1 : 0) + (blockstate3.isCollisionShapeFullBlock(blockgetter, blockpos5) ? 1 : 0);
        if (i <= 0) {//((!flag || flag1) && i <= 0) {
            if (i >= 0) {//((!flag1 || flag) && i >= 0) {
                int j = direction.getStepX();
                int k = direction.getStepZ();
                Vec3 vec3 = context.getClickLocation();
                double d0 = vec3.x - (double)clickedPos.getX();
                double d1 = vec3.z - (double)clickedPos.getZ();
                return (j >= 0 || !(d1 < 0.5D)) && (j <= 0 || !(d1 > 0.5D)) && (k >= 0 || !(d0 > 0.5D)) && (k <= 0 || !(d0 < 0.5D)) ? CelestialProperties.AirlockDoorHingeSide.LEFT : CelestialProperties.AirlockDoorHingeSide.RIGHT;
            } else {
                return CelestialProperties.AirlockDoorHingeSide.LEFT;
            }
        } else {
            return CelestialProperties.AirlockDoorHingeSide.RIGHT;
        }
    }

    public BlockState rotate(BlockState p_52790_, Rotation p_52791_) {
        return p_52790_.setValue(FACING, p_52791_.rotate(p_52790_.getValue(FACING)));
    }

    public BlockState mirror(BlockState p_52787_, Mirror p_52788_) {
        return p_52788_ == Mirror.NONE ? p_52787_ : p_52787_.rotate(p_52788_.getRotation(p_52787_.getValue(FACING))).cycle(HINGE);
    }

}