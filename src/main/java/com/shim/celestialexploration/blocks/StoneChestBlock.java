package com.shim.celestialexploration.blocks;

import com.shim.celestialexploration.blocks.blockentities.StoneChestBlockEntity;
import com.shim.celestialexploration.inventory.StoneChestType;
import com.shim.celestialexploration.registry.CelestialBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.ChestBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.ChestBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.function.Supplier;

public class StoneChestBlock extends ChestBlock {
    private final StoneChestType stoneType;
    private final static ArrayList<StoneChestBlock> CHESTS = new ArrayList<>();

    public StoneChestBlock(StoneChestType stoneType) {
        super(Block.Properties.of(Material.STONE).strength(3.0F).sound(SoundType.STONE), CelestialBlockEntities.STONE_CHEST_BLOCK_ENTITY::get);
        this.stoneType = stoneType;
        CHESTS.add(this);
    }

    public static StoneChestBlock[] getChests() {
        return CHESTS.toArray(new StoneChestBlock[CHESTS.size()]);
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new StoneChestBlockEntity(this.stoneType, pos, state);
    }

    public StoneChestType getStoneType() {
        return this.stoneType;
    }
}