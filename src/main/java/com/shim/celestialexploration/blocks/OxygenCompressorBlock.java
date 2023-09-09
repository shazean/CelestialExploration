package com.shim.celestialexploration.blocks;

import com.shim.celestialexploration.blocks.blockentities.OxygenCompressorBlockEntity;
import com.shim.celestialexploration.registry.BlockEntityRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraftforge.network.NetworkHooks;

import javax.annotation.Nullable;

public class OxygenCompressorBlock extends BaseEntityBlock {
    public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
    public static final BooleanProperty LIT = BlockStateProperties.LIT;

    public OxygenCompressorBlock(BlockBehaviour.Properties p_48687_) {
        super(p_48687_);
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(LIT, Boolean.FALSE));
    }

    public BlockState getStateForPlacement(BlockPlaceContext p_48689_) {
        return this.defaultBlockState().setValue(FACING, p_48689_.getHorizontalDirection().getOpposite());
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> p_48725_) {
        p_48725_.add(FACING, LIT);
    }

    @Override
    public RenderShape getRenderShape(BlockState state) {
        return RenderShape.MODEL;
    }

    @Override
    public void onRemove(BlockState pState, Level pLevel, BlockPos pPos, BlockState pNewState, boolean pIsMoving) {
        if (pState.getBlock() != pNewState.getBlock()) {
            BlockEntity blockEntity = pLevel.getBlockEntity(pPos);
            if (blockEntity instanceof OxygenCompressorBlockEntity) {
                ((OxygenCompressorBlockEntity) blockEntity).drops();
            }
        }
        super.onRemove(pState, pLevel, pPos, pNewState, pIsMoving);
    }

    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos,
                                 Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        if (!pLevel.isClientSide()) {
            BlockEntity entity = pLevel.getBlockEntity(pPos);
            if(entity instanceof OxygenCompressorBlockEntity) {
                NetworkHooks.openGui(((ServerPlayer)pPlayer), (OxygenCompressorBlockEntity)entity, pPos);
            } else {
                throw new IllegalStateException("Our Container provider is missing!");
            }
        }
        return InteractionResult.sidedSuccess(pLevel.isClientSide());
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
        return new OxygenCompressorBlockEntity(pPos, pState);
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level pLevel, BlockState pState, BlockEntityType<T> pBlockEntityType) {
        return createTickerHelper(pBlockEntityType, BlockEntityRegistry.OXYGEN_COMPRESSOR_BLOCK_ENTITY.get(),
                OxygenCompressorBlockEntity::tick);
    }
}


//    public InteractionResult use(BlockState p_48706_, Level p_48707_, BlockPos p_48708_, Player p_48709_, InteractionHand p_48710_, BlockHitResult p_48711_) {
//        if (p_48707_.isClientSide) {
//            return InteractionResult.SUCCESS;
//        } else {
//            this.openContainer(p_48707_, p_48708_, p_48709_);
//            return InteractionResult.CONSUME;
//        }
//    }
//
//    public BlockState getStateForPlacement(BlockPlaceContext p_48689_) {
//        return this.defaultBlockState().setValue(FACING, p_48689_.getHorizontalDirection().getOpposite());
//    }
//
////    public void setPlacedBy(Level p_48694_, BlockPos p_48695_, BlockState p_48696_, LivingEntity p_48697_, ItemStack p_48698_) {
////        if (p_48698_.hasCustomHoverName()) {
////            BlockEntity blockentity = p_48694_.getBlockEntity(p_48695_);
////            if (blockentity instanceof OxygenCompressorBlockEntity) {
////                ((OxygenCompressorBlockEntity)blockentity).setCustomName(p_48698_.getHoverName());
////            }
////        }
////
////    }
//
//    public void onRemove(BlockState p_48713_, Level p_48714_, BlockPos p_48715_, BlockState p_48716_, boolean p_48717_) {
//        if (!p_48713_.is(p_48716_.getBlock())) {
//            BlockEntity blockentity = p_48714_.getBlockEntity(p_48715_);
//            if (blockentity instanceof OxygenCompressorBlockEntity) {
//                if (p_48714_ instanceof ServerLevel) {
//                    ((OxygenCompressorBlockEntity) blockentity).drops();
////                        Containers.dropContents(p_48714_, p_48715_, (OxygenCompressorBlockEntity)blockentity);
////                    ((OxygenCompressorBlockEntity)blockentity).getRecipesToAwardAndPopExperience((ServerLevel)p_48714_, Vec3.atCenterOf(p_48715_));
//                }
//
//                p_48714_.updateNeighbourForOutputSignal(p_48715_, this);
//            }
//
//            super.onRemove(p_48713_, p_48714_, p_48715_, p_48716_, p_48717_);
//        }
//    }
//
//    public boolean hasAnalogOutputSignal(BlockState p_48700_) {
//        return true;
//    }
//
//    public int getAnalogOutputSignal(BlockState p_48702_, Level p_48703_, BlockPos p_48704_) {
//        return AbstractContainerMenu.getRedstoneSignalFromBlockEntity(p_48703_.getBlockEntity(p_48704_));
//    }
//
//    public RenderShape getRenderShape(BlockState p_48727_) {
//        return RenderShape.MODEL;
//    }
//
//    public BlockState rotate(BlockState p_48722_, Rotation p_48723_) {
//        return p_48722_.setValue(FACING, p_48723_.rotate(p_48722_.getValue(FACING)));
//    }
//
//    public BlockState mirror(BlockState p_48719_, Mirror p_48720_) {
//        return p_48719_.rotate(p_48720_.getRotation(p_48719_.getValue(FACING)));
//    }
//
//    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> p_48725_) {
//        p_48725_.add(FACING, LIT);
//    }
//
////    @Nullable
////    protected static <T extends BlockEntity> BlockEntityTicker<T> createCompressorTicker(Level p_151988_, BlockEntityType<T> p_151989_, BlockEntityType<? extends OxygenCompressorBlockEntity> p_151990_) {
////        return p_151988_.isClientSide ? null : createTickerHelper(p_151989_, p_151990_, OxygenCompressorBlockEntity::serverTick);
////    }
//
//    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
//        return new OxygenCompressorBlockEntity(pos, state);
//    }
//
////    @Nullable
////    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level p_153273_, BlockState p_153274_, BlockEntityType<T> p_153275_) {
////        return createCompressorTicker(p_153273_, p_153275_, BlockEntityRegistry.OXYGEN_COMPRESSOR_BLOCK_ENTITY.get());
////    }
//
//    protected void openContainer(Level p_53631_, BlockPos p_53632_, Player p_53633_) {
//        BlockEntity blockentity = p_53631_.getBlockEntity(p_53632_);
//        if (blockentity instanceof OxygenCompressorBlockEntity) {
//            p_53633_.openMenu((MenuProvider)blockentity);
//            p_53633_.awardStat(Stats.INTERACT_WITH_FURNACE);
//        }
//
//    }
//
//    public void animateTick(BlockState p_53635_, Level p_53636_, BlockPos p_53637_, Random p_53638_) {
//        if (p_53635_.getValue(LIT)) {
//            double d0 = (double)p_53637_.getX() + 0.5D;
//            double d1 = (double)p_53637_.getY();
//            double d2 = (double)p_53637_.getZ() + 0.5D;
//            if (p_53638_.nextDouble() < 0.1D) {
//                p_53636_.playLocalSound(d0, d1, d2, SoundEvents.FURNACE_FIRE_CRACKLE, SoundSource.BLOCKS, 1.0F, 1.0F, false);
//            }
//
//            Direction direction = p_53635_.getValue(FACING);
//            Direction.Axis direction$axis = direction.getAxis();
//            double d3 = 0.52D;
//            double d4 = p_53638_.nextDouble() * 0.6D - 0.3D;
//            double d5 = direction$axis == Direction.Axis.X ? (double)direction.getStepX() * 0.52D : d4;
//            double d6 = p_53638_.nextDouble() * 6.0D / 16.0D;
//            double d7 = direction$axis == Direction.Axis.Z ? (double)direction.getStepZ() * 0.52D : d4;
//            p_53636_.addParticle(ParticleTypes.SMOKE, d0 + d5, d1 + d6, d2 + d7, 0.0D, 0.0D, 0.0D);
//            p_53636_.addParticle(ParticleTypes.FLAME, d0 + d5, d1 + d6, d2 + d7, 0.0D, 0.0D, 0.0D);
//        }
//    }
//
//}