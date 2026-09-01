package com.shim.celestialexploration.blocks;

import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestialexploration.blocks.blockentities.OxygenGeneratorBlockEntity;
import com.shim.celestialexploration.registry.CelestialBlockEntities;
import com.shim.celestialexploration.registry.CelestialBlocks;
import com.shim.celestialexploration.registry.CelestialEffects;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.Mth;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.AABB;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Random;

public class OxygenGeneratorBlock extends BaseEntityBlock {
    public static final BooleanProperty LIT = RedstoneTorchBlock.LIT;
    public static final IntegerProperty HAS_WATER =  IntegerProperty.create("has_water", 0, 9);
    public static final BooleanProperty OPERATING = BooleanProperty.create("operating");
    public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;

    public OxygenGeneratorBlock(BlockBehaviour.Properties p_48687_) {
        super(p_48687_);
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(LIT, false).setValue(HAS_WATER, 0).setValue(OPERATING, false));
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> stateBuilder) {
        stateBuilder.add(LIT, HAS_WATER, OPERATING, FACING);
    }

    @Nullable
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return this.defaultBlockState().setValue(LIT, context.getLevel().hasNeighborSignal(context.getClickedPos())).setValue(HAS_WATER, 0).setValue(OPERATING, false).setValue(FACING, context.getHorizontalDirection().getOpposite());
    }

    public void neighborChanged(BlockState state, Level level, BlockPos pos, Block p_55669_, BlockPos p_55670_, boolean p_55671_) {
        if (!level.isClientSide) {
            boolean lit = level.hasNeighborSignal(pos);
            int water = nearbyWaterBlocks(level, pos);
            boolean operating = lit && water >= 1;
            level.setBlock(pos, state.setValue(LIT, lit).setValue(HAS_WATER, water).setValue(OPERATING, operating), 2);
        }
    }

//    @Override
//    public void tick(BlockState state, ServerLevel level, BlockPos pos, Random random) {
//        if (!level.isClientSide) {
//
//            boolean lit = level.hasNeighborSignal(pos);
//            if (!lit) {
//                if (level.getBlockState(pos.above()).is(CelestialBlocks.OXYGEN_COMPRESSOR.get())) {
//                    lit = level.getBlockState(pos.above()).getValue(OxygenCompressorBlock.LIT);
//                }
//            }
//            int water = nearbyWaterBlocks(level, pos);
//            boolean operating = lit && water >= 1;
//            level.setBlock(pos, state.setValue(LIT, lit).setValue(HAS_WATER, water).setValue(OPERATING, operating), 2);
//        }
//    }

    @Override
    public RenderShape getRenderShape(BlockState state) {
        return RenderShape.MODEL;
    }

    public static int nearbyWaterBlocks(LevelReader levelReader, BlockPos pos) {

        int nearbyWater = 0;

        for(BlockPos blockpos : BlockPos.betweenClosed(pos.offset(-4, -1, -4), pos.offset(4, 1, 4))) {
            if (levelReader.getFluidState(blockpos).is(FluidTags.WATER)) {
                nearbyWater++;
            }
        }

        return Mth.clamp(nearbyWater, 0, 8);
    }

    public BlockState rotate(BlockState state, Rotation rotation) {
        return state.setValue(FACING, rotation.rotate(state.getValue(FACING)));
    }

    public BlockState mirror(BlockState state, Mirror mirror) {
        return state.rotate(mirror.getRotation(state.getValue(FACING)));
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new OxygenGeneratorBlockEntity(pos, state);
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> blockEntityType) {
        return createTickerHelper(blockEntityType, CelestialBlockEntities.OXYGEN_GENERATOR_BLOCK_ENTITY.get(),
                OxygenGeneratorBlockEntity::tick);
    }
}