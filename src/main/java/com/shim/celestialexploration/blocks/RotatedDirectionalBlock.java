package com.shim.celestialexploration.blocks;

import net.minecraft.core.Direction;
import net.minecraft.core.FrontAndTop;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.EnumProperty;

public class RotatedDirectionalBlock extends Block {
    public static final EnumProperty<FrontAndTop> ORIENTATION = BlockStateProperties.ORIENTATION;

    public RotatedDirectionalBlock(BlockBehaviour.Properties p_54225_) {
        super(p_54225_);
        this.registerDefaultState(this.stateDefinition.any().setValue(ORIENTATION, FrontAndTop.NORTH_UP));
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> p_54244_) {
        p_54244_.add(ORIENTATION);
    }

    public BlockState rotate(BlockState p_54241_, Rotation p_54242_) {
        return p_54241_.setValue(ORIENTATION, p_54242_.rotation().rotate(p_54241_.getValue(ORIENTATION)));
    }

    public BlockState mirror(BlockState p_54238_, Mirror p_54239_) {
        return p_54238_.setValue(ORIENTATION, p_54239_.rotation().rotate(p_54238_.getValue(ORIENTATION)));
    }

    public BlockState getStateForPlacement(BlockPlaceContext p_54227_) {
        Direction direction = p_54227_.getClickedFace();
        Direction direction1;
        if (direction.getAxis() == Direction.Axis.Y) {
            direction1 = p_54227_.getHorizontalDirection().getOpposite();
        } else {
            direction1 = Direction.UP;
        }

        return this.defaultBlockState().setValue(ORIENTATION, FrontAndTop.fromFrontAndTop(direction, direction1));
    }

//    public static boolean canAttach(StructureTemplate.StructureBlockInfo p_54246_, StructureTemplate.StructureBlockInfo p_54247_) {
//        Direction direction = getFrontFacing(p_54246_.state);
//        Direction direction1 = getFrontFacing(p_54247_.state);
//        Direction direction2 = getTopFacing(p_54246_.state);
//        Direction direction3 = getTopFacing(p_54247_.state);
//        JigsawBlockEntity.JointType jigsawblockentity$jointtype = JigsawBlockEntity.JointType.byName(p_54246_.nbt.getString("joint")).orElseGet(() -> {
//            return direction.getAxis().isHorizontal() ? JigsawBlockEntity.JointType.ALIGNED : JigsawBlockEntity.JointType.ROLLABLE;
//        });
//        boolean flag = jigsawblockentity$jointtype == JigsawBlockEntity.JointType.ROLLABLE;
//        return direction == direction1.getOpposite() && (flag || direction2 == direction3) && p_54246_.nbt.getString("target").equals(p_54247_.nbt.getString("name"));
//    }

    public static Direction getFrontFacing(BlockState p_54251_) {
        return p_54251_.getValue(ORIENTATION).front();
    }

    public static Direction getTopFacing(BlockState p_54253_) {
        return p_54253_.getValue(ORIENTATION).top();
    }
}
