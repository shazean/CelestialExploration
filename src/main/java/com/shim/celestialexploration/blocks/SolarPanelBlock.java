package com.shim.celestialexploration.blocks;

import com.shim.celestialexploration.blocks.blockentities.SolarPanelBlockEntity;
import com.shim.celestialexploration.registry.CelestialBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LightLayer;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import javax.annotation.Nullable;

public class SolarPanelBlock extends BaseEntityBlock {
    public static final IntegerProperty POWER = BlockStateProperties.POWER;
//    public static final BooleanProperty INVERTED = BlockStateProperties.INVERTED;
    protected static final VoxelShape SHAPE = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 6.0D, 16.0D);

    public SolarPanelBlock(BlockBehaviour.Properties p_52382_) {
        super(p_52382_);
        this.registerDefaultState(this.stateDefinition.any().setValue(POWER, 0));
    }

    public VoxelShape getShape(BlockState blockState, BlockGetter blockGetter, BlockPos pos, CollisionContext collisionContext) {
        return SHAPE;
    }

    public boolean useShapeForLightOcclusion(BlockState blockState) {
        return true;
    }

    public int getSignal(BlockState blockState, BlockGetter blockGetter, BlockPos pos, Direction direction) {
        return blockState.getValue(POWER);
    }

    private static void updateSignalStrength(BlockState blockState, Level level, BlockPos pos) {
        int i = level.getBrightness(LightLayer.SKY, pos) - level.getSkyDarken();
        float f = level.getSunAngle(1.0F);
//        boolean flag = p_52411_.getValue(INVERTED);
//        if (flag) {
//            i = 15 - i;
//        } else
        if (i > 0) {
            float f1 = f < (float)Math.PI ? 0.0F : ((float)Math.PI * 2F);
            f += (f1 - f) * 0.2F;
            i = Math.round((float)i * Mth.cos(f));
        }

        i = Mth.clamp(i, 0, 15);
        if (blockState.getValue(POWER) != i) {
            level.setBlock(pos, blockState.setValue(POWER, i), 3);
        }

    }

    public InteractionResult use(BlockState blockState, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {
        if (player.mayBuild() && level.isClientSide) {
            return InteractionResult.SUCCESS;
        } else {
            return super.use(blockState, level, pos, player, hand, hitResult);
        }

//        if (player.mayBuild()) {
//            if (level.isClientSide) {
//                return InteractionResult.SUCCESS;
////            } else {
////                BlockState blockstate = p_52391_.cycle(INVERTED);
////                p_52392_.setBlock(p_52393_, blockstate, 4);
////                updateSignalStrength(blockstate, p_52392_, p_52393_);
////                return InteractionResult.CONSUME;
//            }
//        } else {
//            return super.use(blockState, level, pos, player, hand, hitResult);
//        }
    }

    public RenderShape getRenderShape(BlockState blockState) {
        return RenderShape.MODEL;
    }

    public boolean isSignalSource(BlockState blockState) {
        return true;
    }

    public BlockEntity newBlockEntity(BlockPos pos, BlockState blockState) {
        return new SolarPanelBlockEntity(pos, blockState);
    }

    @Nullable
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState blockState, BlockEntityType<T> blockEntity) {
        return !level.isClientSide && level.dimensionType().hasSkyLight() ? createTickerHelper(blockEntity, CelestialBlockEntities.SOLAR_PANEL_BLOCK_ENTITY.get(), SolarPanelBlock::tickEntity) : null;
    }

    private static void tickEntity(Level level, BlockPos pos, BlockState blockState, SolarPanelBlockEntity blockEntity) {
        if (level.getGameTime() % 20L == 0L) {
            updateSignalStrength(blockState, level, pos);
        }
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> p_52398_) {
        p_52398_.add(POWER);
    }
}
