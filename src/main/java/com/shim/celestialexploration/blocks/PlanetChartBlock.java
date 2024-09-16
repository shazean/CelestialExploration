package com.shim.celestialexploration.blocks;

import com.shim.celestialexploration.inventory.menus.PlanetChartMenu;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleMenuProvider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraftforge.network.NetworkHooks;

public class PlanetChartBlock extends Block {
    private static final Component CONTAINER_TITLE = new TextComponent("planet_chart");

    public PlanetChartBlock(Properties p_49795_) {
        super(p_49795_);
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        if (!level.isClientSide()) {
//            BlockEntity entity = level.getBlockEntity(pos);
//            BlockState entity = level.getBlockState(pos);
            if(state.is(this)) {
                NetworkHooks.openGui(((ServerPlayer)player), getMenuProvider(state, level, pos), pos);
            } else {
                throw new IllegalStateException("Our Container provider is missing!");
            }
        }
        return InteractionResult.sidedSuccess(level.isClientSide());
    }

    public MenuProvider getMenuProvider(BlockState state, Level level, BlockPos pos) {
        return new SimpleMenuProvider((p_52229_, p_52230_, p_52231_) -> new PlanetChartMenu(p_52229_, p_52230_, ContainerLevelAccess.create(level, pos)), CONTAINER_TITLE);
    }
}
