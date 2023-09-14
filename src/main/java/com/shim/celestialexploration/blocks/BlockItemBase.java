package com.shim.celestialexploration.blocks;

import com.shim.celestialexploration.CelestialExploration;

import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.Block;

public class BlockItemBase extends BlockItem {

	public BlockItemBase(Block block) {
		super(block, new Item.Properties().tab(CelestialExploration.CELESTIAL_TAB));
	
	}
	
}
