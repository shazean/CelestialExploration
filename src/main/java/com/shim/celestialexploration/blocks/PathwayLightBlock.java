package com.shim.celestialexploration.blocks;

import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestialexploration.blocks.blockentities.GeyserBlockEntity;
import com.shim.celestialexploration.blocks.blockentities.PathwayLightBlockEntity;
import com.shim.celestialexploration.registry.BlockEntityRegistry;
import net.minecraft.client.renderer.texture.Tickable;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

import java.util.Random;

public class PathwayLightBlock extends BaseEntityBlock {
    public static final BooleanProperty LIT = RedstoneTorchBlock.LIT;
    protected static final VoxelShape SHAPE = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 1.0D, 16.0D);

    public PathwayLightBlock(BlockBehaviour.Properties properties) {
        super(properties);
        this.registerDefaultState(this.defaultBlockState().setValue(LIT, Boolean.FALSE));
    }

    @Override
    public RenderShape getRenderShape(BlockState state) {
        return RenderShape.MODEL;
    }

    public void stepOn(Level level, BlockPos pos, BlockState state, Entity entity) {
        interact(state, level, pos);
        super.stepOn(level, pos, state, entity);
    }

    public void entityInside(BlockState state, Level level, BlockPos pos, Entity entity) {
        interact(state, level, pos);
        super.entityInside(state, level, pos, entity);
    }


    private static void interact(BlockState state, Level level, BlockPos pos) {
        if (!state.getValue(LIT)) {
            level.setBlock(pos, state.setValue(LIT, Boolean.TRUE), 3);
        }
    }

//    public boolean isRandomlyTicking(BlockState state) {
//        return state.getValue(LIT);
//    }
//
//    public void randomTick(BlockState state, ServerLevel serverLevel, BlockPos pos, Random random) {
//        if (state.getValue(LIT)) {
//            serverLevel.setBlock(pos, state.setValue(LIT, Boolean.FALSE), 3);
//        }
//    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new PathwayLightBlockEntity(pos, state);
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> blockEntityType) {
        return createTickerHelper(blockEntityType, BlockEntityRegistry.PATHWAY_LIGHT_BLOCK_ENTITY.get(), PathwayLightBlockEntity::tick);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(LIT);
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter getter, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }

    @Override
    public BlockState updateShape(BlockState state, Direction direction, BlockState p_152928_, LevelAccessor levelAccessor, BlockPos pos, BlockPos p_152931_) {
        return !state.canSurvive(levelAccessor, pos) ? Blocks.AIR.defaultBlockState() : super.updateShape(state, direction, p_152928_, levelAccessor, pos, p_152931_);
    }

    @Override
    public boolean canSurvive(BlockState state, LevelReader reader, BlockPos pos) {
        return !reader.isEmptyBlock(pos.below());
    }
}
