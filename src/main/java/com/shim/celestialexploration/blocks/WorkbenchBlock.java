package com.shim.celestialexploration.blocks;

import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestialexploration.blocks.blockentities.LoxTankBlockEntity;
import com.shim.celestialexploration.blocks.blockentities.WorkbenchBlockEntity;
import com.shim.celestialexploration.capabilities.LoxTankCapability;
import com.shim.celestialexploration.registry.BlockEntityRegistry;
import com.shim.celestialexploration.registry.CapabilityRegistry;
import com.shim.celestialexploration.registry.FluidRegistry;
import com.shim.celestialexploration.registry.ItemRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.Containers;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.ClipContext;
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
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.capability.IFluidHandler;
import net.minecraftforge.fluids.capability.templates.FluidTank;
import net.minecraftforge.network.NetworkHooks;
import org.jetbrains.annotations.NotNull;
import org.lwjgl.system.CallbackI;

import javax.annotation.Nullable;

public class WorkbenchBlock extends BaseEntityBlock {
    public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
    public static final BooleanProperty LIT = BlockStateProperties.LIT;
//    public static final IntegerProperty FULLNESS = IntegerProperty.create("fullness", 0, 8);

    public WorkbenchBlock(BlockBehaviour.Properties p_48687_) {
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
    public @NotNull RenderShape getRenderShape(@NotNull BlockState state) {
        return RenderShape.MODEL;
    }

    @Override
    public void onRemove(BlockState state, @NotNull Level level, @NotNull BlockPos pos, BlockState newState, boolean isMoving) {
        if (state.getBlock() != newState.getBlock()) {
            BlockEntity blockEntity = level.getBlockEntity(pos);
            if (blockEntity instanceof WorkbenchBlockEntity) {
                ((WorkbenchBlockEntity) blockEntity).drops();
            }
        }
        super.onRemove(state, level, pos, newState, isMoving);
    }

    @Override
    public @NotNull InteractionResult use(BlockState state, Level level, BlockPos pos,
                                          Player player, InteractionHand hand, BlockHitResult hit) {
        if (!level.isClientSide()) {
            BlockEntity entity = level.getBlockEntity(pos);
            if(entity instanceof WorkbenchBlockEntity) {
                NetworkHooks.openGui(((ServerPlayer)player), (WorkbenchBlockEntity)entity, pos);
            } else {
                throw new IllegalStateException("Our Container provider is missing!");
            }
        }
        return InteractionResult.sidedSuccess(level.isClientSide());
    }

    @Override
    public void playerWillDestroy(Level level, BlockPos pos, BlockState state, Player player) {
        BlockEntity blockEntity = level.getBlockEntity(pos);

        if (blockEntity instanceof WorkbenchBlockEntity) {
            FluidTank tank = ((WorkbenchBlockEntity) blockEntity).getFluidTank();

            if (tank.isEmpty()) {
                return;
            }

            ItemStack itemStack;
            ItemEntity itemEntity;
            itemStack = getFullBucketItem(tank.getFluid());
//            itemEntity = new ItemEntity(level,(double)pos.getX() + 0.5D, (double)pos.getY() + 0.5D, (double)pos.getZ() + 0.5D, itemStack);
            int numItems = 0;
            int i;
            int j = 0;

            for (i = 0; i < tank.getFluidAmount() / 1000; i++) {
                itemStack = getFullBucketItem(tank.getFluid());
                Containers.dropItemStack(level, pos.getX(), pos.getY(), pos.getZ(), itemStack);
//                tank.drain(1000, IFluidHandler.FluidAction.EXECUTE);
//                level.addFreshEntity(itemEntity);
                CelestialExploration.LOGGER.debug("i:" + i + " fluidAmount / 1000: " + (tank.getFluidAmount() / 1000));
                j++;
            }

            itemStack = getPartialBucketItem(tank.getFluid());
//            itemEntity = new ItemEntity(level,(double)pos.getX() + 0.5D, (double)pos.getY() + 0.5D, (double)pos.getZ() + 0.5D, itemStack);
            tank.drain(j * 1000, IFluidHandler.FluidAction.EXECUTE);

            for (i = 0; i < tank.getFluidAmount() / 100; i++) {
                itemStack = getPartialBucketItem(tank.getFluid());
                Containers.dropItemStack(level, pos.getX(), pos.getY(), pos.getZ(), itemStack);

//                level.addFreshEntity(itemEntity);
                CelestialExploration.LOGGER.debug("i:" + i + " fluidAmount / 100: " + (tank.getFluidAmount() / 100));

            }

//            while (tank.getFluidAmount() >= 1000) {
//                tank.drain(1000, IFluidHandler.FluidAction.EXECUTE);
//                CelestialExploration.LOGGER.debug("Full buckets amount:" + tank.getFluidAmount());
//            }
//            itemStack.setCount(itemStack.getCount() + 1);
//            CelestialExploration.LOGGER.debug("Num items to drop" + itemStack.getCount());
//            itemEntity = new ItemEntity(level,(double)pos.getX() + 0.5D, (double)pos.getY() + 0.5D, (double)pos.getZ() + 0.5D, itemStack);
//            level.addFreshEntity(itemEntity);
//
//            itemStack = getPartialBucketItem(tank.getFluid());
//
//            while (tank.getFluidAmount() >= 100) {
//                tank.drain(100, IFluidHandler.FluidAction.EXECUTE);
//                CelestialExploration.LOGGER.debug("Partial buckets amount:" + tank.getFluidAmount());
//            }
//            itemStack.setCount(itemStack.getCount() + 1);
//            itemEntity = new ItemEntity(level,(double)pos.getX() + 0.5D, (double)pos.getY() + 0.5D, (double)pos.getZ() + 0.5D, itemStack);
//            level.addFreshEntity(itemEntity);


            CelestialExploration.LOGGER.debug("Fluid amount:" + tank.getFluidAmount());
        }
        super.playerWillDestroy(level, pos, state, player);
    }

    private static ItemStack getFullBucketItem(FluidStack fluid) {
        if (fluid.containsFluid(new FluidStack(Fluids.WATER, 1))) {
            return new ItemStack(Items.WATER_BUCKET);
        } else if (fluid.containsFluid(new FluidStack(Fluids.LAVA, 1))) {
            return new ItemStack(Items.LAVA_BUCKET);
        } else if (fluid.containsFluid(new FluidStack(FluidRegistry.MOLTEN_IRON.get(), 1))) {
            return new ItemStack(Items.IRON_BLOCK);
        } else if (fluid.containsFluid(new FluidStack(FluidRegistry.MOLTEN_STEEL.get(), 1))) {
           return new ItemStack(ItemRegistry.STEEL_BLOCK.get());
        } else if (fluid.containsFluid(new FluidStack(FluidRegistry.MOLTEN_COPPER.get(), 1))) {
            return new ItemStack(Items.COPPER_BLOCK);
        } else if (fluid.containsFluid(new FluidStack(FluidRegistry.MOLTEN_GOLD.get(), 1))) {
           return new ItemStack(Items.GOLD_BLOCK);
        } else {
            return ItemStack.EMPTY;
        }
    }

    private static ItemStack getPartialBucketItem(FluidStack fluid) {
//        if (fluid.containsFluid(new FluidStack(Fluids.WATER, 1))) {
//            return new ItemStack(Items.WATER_BUCKET);
//        } else if (fluid.containsFluid(new FluidStack(Fluids.LAVA, 1))) {
//            return new ItemStack(Items.LAVA_BUCKET);
//        } else
        if (fluid.containsFluid(new FluidStack(FluidRegistry.MOLTEN_IRON.get(), 1))) {
            return new ItemStack(Items.IRON_INGOT);
        } else if (fluid.containsFluid(new FluidStack(FluidRegistry.MOLTEN_STEEL.get(), 1))) {
            return new ItemStack(ItemRegistry.STEEL_INGOT.get());
        } else if (fluid.containsFluid(new FluidStack(FluidRegistry.MOLTEN_COPPER.get(), 1))) {
            return new ItemStack(Items.COPPER_INGOT);
        } else if (fluid.containsFluid(new FluidStack(FluidRegistry.MOLTEN_GOLD.get(), 1))) {
            return new ItemStack(Items.GOLD_INGOT);
        } else {
            return ItemStack.EMPTY;
        }
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new WorkbenchBlockEntity(pos, state);
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> blockEntityType) {
        return createTickerHelper(blockEntityType, BlockEntityRegistry.WORKBENCH_BLOCK_ENTITY.get(),
                WorkbenchBlockEntity::tick);
    }
}