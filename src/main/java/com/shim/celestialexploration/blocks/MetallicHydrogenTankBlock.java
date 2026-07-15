package com.shim.celestialexploration.blocks;

import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestialexploration.blocks.blockentities.LoxTankBlockEntity;
import com.shim.celestialexploration.blocks.blockentities.MetallicHydrogenTankBlockEntity;
import com.shim.celestialexploration.capabilities.IFuelTank;
import com.shim.celestialexploration.registry.CelestialBlockEntities;
import com.shim.celestialexploration.registry.CelestialCapabilities;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;

import javax.annotation.Nullable;

public class MetallicHydrogenTankBlock extends AbstractFuelTankBlock {
    public static final IntegerProperty FULLNESS = IntegerProperty.create("fullness", 0, 16);

    public MetallicHydrogenTankBlock(BlockBehaviour.Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(FULLNESS, 0));
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> state) {
        state.add(FULLNESS);
    }


    @javax.annotation.Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
        return new MetallicHydrogenTankBlockEntity(pPos, pState);
    }

//    @Override
//    public void playerWillDestroy(Level level, BlockPos pos, BlockState state, Player player) {
//        BlockEntity blockEntity = level.getBlockEntity(pos);
//
//        if (blockEntity instanceof MetallicHydrogenTankBlockEntity) {
//            IFuelTank loxTankEntity = CelestialExploration.getCapability(blockEntity, CelestialCapabilities.FUEL_TANK_CAPABILITY);
//
//            if (loxTankEntity != null) {
//                int amount = loxTankEntity.getAmount();
//
//                ItemStack itemStack = new ItemStack(this);
//
//                IFuelTank loxTank = CelestialExploration.getCapability(itemStack, CelestialCapabilities.FUEL_TANK_CAPABILITY);
//                if (loxTank != null) {
//                    loxTank.setAmount(amount);
//                }
//
//                ItemEntity itemEntity = new ItemEntity(level, (double)pos.getX() + 0.5D, (double)pos.getY() + 0.5D, (double)pos.getZ() + 0.5D, itemStack);
//
//                itemEntity.setDefaultPickUpDelay();
//                level.addFreshEntity(itemEntity);
//            }
//        }
//        super.playerWillDestroy(level, pos, state, player);
//    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> blockEntityType) {
        return createTickerHelper(blockEntityType, CelestialBlockEntities.METALLIC_HYDROGEN_TANK_BLOCK_ENTITY.get(), MetallicHydrogenTankBlockEntity::tick);
    }
}