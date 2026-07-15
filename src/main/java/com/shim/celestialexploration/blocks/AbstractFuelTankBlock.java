package com.shim.celestialexploration.blocks;

import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestialexploration.blocks.blockentities.AbstractFuelTankBlockEntity;
import com.shim.celestialexploration.blocks.blockentities.LoxTankBlockEntity;
import com.shim.celestialexploration.blocks.blockentities.MetallicHydrogenTankBlockEntity;
import com.shim.celestialexploration.capabilities.IFuelTank;
import com.shim.celestialexploration.registry.CelestialBlockEntities;
import com.shim.celestialexploration.registry.CelestialCapabilities;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.item.ItemEntity;
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
import net.minecraft.world.phys.BlockHitResult;

import javax.annotation.Nullable;

public abstract class AbstractFuelTankBlock extends BaseEntityBlock {
//    public static final IntegerProperty FULLNESS = IntegerProperty.create("fullness", 0, 16);

    public AbstractFuelTankBlock(BlockBehaviour.Properties properties) {
        super(properties);
//        this.registerDefaultState(this.stateDefinition.any().setValue(FULLNESS, 0));
    }

//    public boolean skipRendering(BlockState p_53972_, BlockState p_53973_, Direction p_53974_) {
//        return p_53973_.is(this) ? true : super.skipRendering(p_53972_, p_53973_, p_53974_);
//    }
//
//    public VoxelShape getVisualShape(BlockState p_48735_, BlockGetter p_48736_, BlockPos p_48737_, CollisionContext p_48738_) {
//        return Shapes.empty();
//    }
//
//    public boolean propagatesSkylightDown(BlockState p_48740_, BlockGetter p_48741_, BlockPos p_48742_) {
//        return true;
//    }

    public BlockState getStateForPlacement(BlockPlaceContext p_48689_) {
        return this.defaultBlockState();
    }

//    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> state) {
//        state.add(FULLNESS);
//    }

    @Override
    public RenderShape getRenderShape(BlockState state) {
        return RenderShape.MODEL;
    }

    @Override
    public void playerWillDestroy(Level level, BlockPos pos, BlockState state, Player player) {
        BlockEntity blockEntity = level.getBlockEntity(pos);

        if (!player.isCreative()) {
            if (blockEntity instanceof LoxTankBlockEntity || blockEntity instanceof MetallicHydrogenTankBlockEntity) {
                IFuelTank fuelTankEntity = CelestialExploration.getCapability(blockEntity, CelestialCapabilities.FUEL_TANK_CAPABILITY);

                if (fuelTankEntity != null) {
                    int amount = fuelTankEntity.getAmount();

                    ItemStack itemStack = new ItemStack(this);

                    IFuelTank fuelTank = CelestialExploration.getCapability(itemStack, CelestialCapabilities.FUEL_TANK_CAPABILITY);
                    if (fuelTank != null) {
                        fuelTank.setAmount(amount);
                    }

                    ItemEntity itemEntity = new ItemEntity(level, (double) pos.getX() + 0.5D, (double) pos.getY() + 0.5D, (double) pos.getZ() + 0.5D, itemStack);

                    itemEntity.setDefaultPickUpDelay();
                    level.addFreshEntity(itemEntity);
                }
            }
        }
        super.playerWillDestroy(level, pos, state, player);
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        return InteractionResult.sidedSuccess(level.isClientSide());
    }

//    @javax.annotation.Nullable
//    @Override
//    public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
//        return new LoxTankBlockEntity(pPos, pState);
//    }
//
//    @Nullable
//    @Override
//    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> blockEntityType) {
//        return createTickerHelper(blockEntityType, CelestialBlockEntities.LOX_TANK_BLOCK_ENTITY.get(), LoxTankBlockEntity::tick);
//    }
}