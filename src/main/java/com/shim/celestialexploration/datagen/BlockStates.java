package com.shim.celestialexploration.datagen;

import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestialexploration.registry.BlockRegistry;

import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.WallBlock;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class BlockStates extends BlockStateProvider {

	public BlockStates(DataGenerator gen, ExistingFileHelper helper) {
		super(gen, CelestialExploration.MODID, helper);
	}
	
	@Override
	protected void registerStatesAndModels() {
		//MOON
		simpleBlock(BlockRegistry.MOON_BRICKS.get());
		simpleBlock(BlockRegistry.MOON_IRON_ORE.get());
		simpleBlock(BlockRegistry.MOON_REDSTONE_ORE.get());
		simpleBlock(BlockRegistry.MOON_SAND.get());
		simpleBlock(BlockRegistry.MOON_STONE.get());
		simpleBlock(BlockRegistry.CHISELED_MOON_BRICKS.get());
		simpleBlock(BlockRegistry.GLOWING_MOON_SAND.get());
		simpleBlock(BlockRegistry.LUNAR_LANTERN.get());
		stairsBlock((StairBlock) BlockRegistry.MOON_BRICK_STAIRS.get(), modLoc("block/moon_bricks"));
		slabBlock((SlabBlock) BlockRegistry.MOON_BRICK_SLAB.get(), modLoc("block/moon_bricks"), modLoc("block/moon_bricks"));
		wallBlock((WallBlock) BlockRegistry.MOON_BRICK_WALL.get(), modLoc("block/moon_bricks"));

		//MARS
		simpleBlock(BlockRegistry.CHISELED_MARS_BRICKS.get());
		simpleBlock(BlockRegistry.MARS_BRICKS.get());
		simpleBlock(BlockRegistry.MARS_IRON_ORE.get());
		simpleBlock(BlockRegistry.MARS_REDSTONE_ORE.get());
		simpleBlock(BlockRegistry.MARS_SAND.get());
		simpleBlock(BlockRegistry.MARS_STONE.get());
		stairsBlock((StairBlock) BlockRegistry.MARS_BRICK_STAIRS.get(), modLoc("block/mars_bricks"));
		slabBlock((SlabBlock) BlockRegistry.MARS_BRICK_SLAB.get(), modLoc("block/mars_bricks"), modLoc("block/mars_bricks"));
		wallBlock((WallBlock) BlockRegistry.MARS_BRICK_WALL.get(), modLoc("block/mars_bricks"));

		
		
		//METEORS
		simpleBlock(BlockRegistry.METEOR.get());
		simpleBlock(BlockRegistry.METEOR_BRICKS.get());
		simpleBlock(BlockRegistry.METEOR_COAL_ORE.get());
		simpleBlock(BlockRegistry.METEOR_COPPER_ORE.get());
		simpleBlock(BlockRegistry.METEOR_DIAMOND_ORE.get());
		simpleBlock(BlockRegistry.METEOR_EMERALD_ORE.get());
		simpleBlock(BlockRegistry.METEOR_GOLD_ORE.get());
		simpleBlock(BlockRegistry.METEOR_IRON_ORE.get());
		simpleBlock(BlockRegistry.METEOR_LAPIS_ORE.get());
		simpleBlock(BlockRegistry.METEOR_REDSTONE_ORE.get());
		simpleBlock(BlockRegistry.CHISELED_METEOR_BRICKS.get());
		stairsBlock((StairBlock) BlockRegistry.METEOR_BRICK_STAIRS.get(), modLoc("block/meteor_bricks"));
		slabBlock((SlabBlock) BlockRegistry.METEOR_BRICK_SLAB.get(), modLoc("block/meteor_bricks"), modLoc("block/meteor_bricks"));
		wallBlock((WallBlock) BlockRegistry.METEOR_BRICK_WALL.get(), modLoc("block/meteor_bricks"));


		
		
		
		//OTHER
		simpleBlock(BlockRegistry.SOLAR_PANEL.get());
		
	}
	
}
