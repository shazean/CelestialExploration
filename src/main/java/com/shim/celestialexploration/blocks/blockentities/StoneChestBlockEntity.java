package com.shim.celestialexploration.blocks.blockentities;

import com.shim.celestialexploration.inventory.StoneChestType;
import com.shim.celestialexploration.registry.CelestialBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.ChestBlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class StoneChestBlockEntity extends ChestBlockEntity {
    StoneChestType stoneType;

    public StoneChestBlockEntity(StoneChestType stoneType, BlockPos pos, BlockState state) {
        super(CelestialBlockEntities.STONE_CHEST_BLOCK_ENTITY.get(), pos, state);
        this.stoneType = stoneType;
    }

    public StoneChestBlockEntity(BlockPos pos, BlockState state) {
        this(StoneChestType.MARS, pos, state);
    }

    public StoneChestType getStoneType() {
        return this.stoneType;
    }
}
