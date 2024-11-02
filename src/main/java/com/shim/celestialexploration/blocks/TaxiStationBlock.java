package com.shim.celestialexploration.blocks;

import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestialexploration.blocks.blockentities.OxygenCompressorBlockEntity;
import com.shim.celestialexploration.blocks.blockentities.TaxiStationBlockEntity;
import com.shim.celestialexploration.capabilities.ISpaceFlight;
import com.shim.celestialexploration.capabilities.TaxiCapability;
import com.shim.celestialexploration.entity.vehicle.SpaceTaxi;
import com.shim.celestialexploration.registry.BlockEntityRegistry;
import com.shim.celestialexploration.registry.CapabilityRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraftforge.network.NetworkHooks;

import javax.annotation.Nullable;
import java.util.List;

public class TaxiStationBlock extends BaseEntityBlock {

    public TaxiStationBlock(Properties p_49224_) {
        super(p_49224_);
    }

    @javax.annotation.Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new TaxiStationBlockEntity(pos, state);
    }

    @Override
    public RenderShape getRenderShape(BlockState state) {
        return RenderShape.MODEL;
    }


    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> blockEntityType) {
        return createTickerHelper(blockEntityType, BlockEntityRegistry.TAXI_STATION_BLOCK_ENTITY.get(), TaxiStationBlockEntity::tick);
    }

    @Override
    public void playerWillDestroy(Level level, BlockPos pos, BlockState state, Player player) {

        TaxiCapability.ITaxi taxiCap = CelestialExploration.getCapability(player, CapabilityRegistry.TAXI_CAPABILITY);
        if (taxiCap != null) {
            taxiCap.removeTaxiStations(pos);
        }
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {

        TaxiCapability.ITaxi taxiCap = CelestialExploration.getCapability(player, CapabilityRegistry.TAXI_CAPABILITY);
        if (taxiCap != null) {
            if (!taxiCap.existsAtThisPos(pos)) {
                taxiCap.addTaxiStations(new TaxiCapability.TaxiStationData(pos, level.dimension(), new TextComponent(state.getBlock().getName().getString() + " " + (taxiCap.getTaxiStations().size() + 1))));
            }
        }

        if (!level.isClientSide()) {
            BlockEntity entity = level.getBlockEntity(pos);
            if(entity instanceof TaxiStationBlockEntity blockEntity) {
                NetworkHooks.openGui(((ServerPlayer)player), blockEntity, pos);
            } else {
                throw new IllegalStateException("Our Container provider is missing!");
            }
        }
        return InteractionResult.sidedSuccess(level.isClientSide());
    }

}