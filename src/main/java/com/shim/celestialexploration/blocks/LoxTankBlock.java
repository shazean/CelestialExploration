package com.shim.celestialexploration.blocks;

import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestialexploration.blocks.blockentities.LoxTankBlockEntity;
import com.shim.celestialexploration.capabilities.LoxTankCapability;
import com.shim.celestialexploration.registry.BlockEntityRegistry;
import com.shim.celestialexploration.registry.CapabilityRegistry;
import com.shim.celestialexploration.registry.ItemRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;

import javax.annotation.Nullable;

public class LoxTankBlock extends BaseEntityBlock {
    public static final IntegerProperty FULLNESS = IntegerProperty.create("fullness", 0, 8);

//    public static final BooleanProperty LIT = BlockStateProperties.LIT;

    public LoxTankBlock(BlockBehaviour.Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(FULLNESS, 0));
    }

    public BlockState getStateForPlacement(BlockPlaceContext p_48689_) {
        return this.defaultBlockState();
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> state) {
        state.add(FULLNESS);
    }

    @Override
    public RenderShape getRenderShape(BlockState state) {
        return RenderShape.MODEL;
    }

    @Override
    public void playerWillDestroy(Level level, BlockPos pos, BlockState state, Player player) {
        this.spawnDestroyParticles(level, player, pos, state);
        BlockEntity blockEntity = level.getBlockEntity(pos);
        if (blockEntity instanceof LoxTankBlockEntity) {

            LoxTankCapability.ILoxTank loxTankEntity = CelestialExploration.getCapability(blockEntity, CapabilityRegistry.LOX_TANK_CAPABILITY);
            if (loxTankEntity != null) {
                int amount = loxTankEntity.getAmount();
                CelestialExploration.LOGGER.debug("block lox amount: " + loxTankEntity.getAmount());

                ItemStack itemStack = new ItemStack(ItemRegistry.LOX_TANK.get());
                blockEntity.saveToItem(itemStack);

                LoxTankCapability.ILoxTank loxTank = CelestialExploration.getCapability(itemStack, CapabilityRegistry.LOX_TANK_CAPABILITY);
                if (loxTank != null) {
                    loxTank.setAmount(amount);
                    CelestialExploration.LOGGER.debug("item lox amount: " + loxTank.getAmount());

                }
            }
        }
        level.gameEvent(player, GameEvent.BLOCK_DESTROY, pos);
    }

    @Override
    public void onRemove(BlockState state, Level level, BlockPos pos, BlockState newState, boolean isMoving) {
        if (state.getBlock() != newState.getBlock()) {
            BlockEntity blockEntity = level.getBlockEntity(pos);
            if (blockEntity instanceof LoxTankBlockEntity) {

//                LoxTankCapability.ILoxTank loxTankEntity = CelestialExploration.getCapability(blockEntity, CapabilityRegistry.LOX_TANK_CAPABILITY);
//                int amount = loxTankEntity.getAmount();
//                ItemStack itemStack = new ItemStack(ItemRegistry.LOX_TANK.get());
//                blockEntity.saveToItem(itemStack);
//
//                LoxTankCapability.ILoxTank loxTank = CelestialExploration.getCapability(itemStack, CapabilityRegistry.LOX_TANK_CAPABILITY);
//                loxTank.setAmount(amount);

//                newState.getBlock().

//                LoxTankCapability.ILoxTank loxTank = CelestialExploration.getCapability(item, CapabilityRegistry.LOX_TANK_CAPABILITY);
//                int amount = loxTank.getAmount();
//
////                BlockPos blockPos = blockPlaceContext.getClickedPos();
////                Level level = blockPlaceContext.getLevel();
//                BlockEntity entity = (LoxTankBlockEntity) level.getBlockEntity(blockPos);
//
//                LoxTankCapability.ILoxTank loxTankEntity = CelestialExploration.getCapability(entity, CapabilityRegistry.LOX_TANK_CAPABILITY);
//
//                loxTankEntity.setAmount(amount);

//                ((LoxTankBlockEntity) blockEntity).drops();
            }
        }
        super.onRemove(state, level, pos, newState, isMoving);
    }

    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos,
                                 Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
//        if (!pLevel.isClientSide()) {
//            BlockEntity entity = pLevel.getBlockEntity(pPos);
//            if(entity instanceof LoxTankBlockEntity) {
//                NetworkHooks.openGui(((ServerPlayer)pPlayer), (LoxTankBlockEntity)entity, pPos);
//            } else {
//                throw new IllegalStateException("Our Container provider is missing!");
//            }
//        }
        return InteractionResult.sidedSuccess(pLevel.isClientSide());
    }

    @javax.annotation.Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
        return new LoxTankBlockEntity(pPos, pState);
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level pLevel, BlockState pState, BlockEntityType<T> pBlockEntityType) {
        return createTickerHelper(pBlockEntityType, BlockEntityRegistry.LOX_TANK_BLOCK_ENTITY.get(),
                LoxTankBlockEntity::tick);
    }
}