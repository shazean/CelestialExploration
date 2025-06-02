package com.shim.celestialexploration.blocks.blockentities;

import com.shim.celestialexploration.registry.CelestialBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class SolarPanelBlockEntity extends BlockEntity {
    public SolarPanelBlockEntity(BlockPos p_155485_, BlockState p_155486_) {
        super(CelestialBlockEntities.SOLAR_PANEL_BLOCK_ENTITY.get(), p_155485_, p_155486_);
    }
}