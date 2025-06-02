package com.shim.celestialexploration.datagen;

import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestialexploration.blocks.AbstractPortalBlock;
import com.shim.celestialexploration.registry.CelestialBlocks;
import com.shim.celestialexploration.registry.CelestialFluids;
import net.minecraft.core.Direction;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.properties.SlabType;
import net.minecraftforge.client.model.generators.*;
import net.minecraftforge.common.data.ExistingFileHelper;

public class CelestialBlockStates extends BlockStateProvider {

	public CelestialBlockStates(DataGenerator gen, ExistingFileHelper helper) {
		super(gen, CelestialExploration.MODID, helper);
	}

	@Override
	protected void registerStatesAndModels() {

		//---- MOON -------------------------------------------------------------------------------
		//STONE
		varietyBlock(CelestialBlocks.MOON_STONE.get());
		stairsBlock(CelestialBlocks.MOON_STONE_STAIRS.get(), modLoc("block/moon_stone"));
		slabBlock(CelestialBlocks.MOON_STONE_SLAB.get(), modLoc("block/moon_stone"), modLoc("block/moon_stone"));
		buttonBlock(CelestialBlocks.MOON_STONE_BUTTON.get(), modLoc("block/moon_stone"));
		pressurePlateBlock(CelestialBlocks.MOON_STONE_PRESSURE_PLATE.get(), modLoc("block/moon_stone"));

		simpleBlock(CelestialBlocks.MOON_COBBLESTONE.get());
		stairsBlock(CelestialBlocks.MOON_COBBLESTONE_STAIRS.get(), modLoc("block/moon_cobblestone"));
		slabBlock(CelestialBlocks.MOON_COBBLESTONE_SLAB.get(), modLoc("block/moon_cobblestone"), modLoc("block/moon_cobblestone"));
		wallBlock(CelestialBlocks.MOON_COBBLESTONE_WALL.get(), modLoc("block/moon_cobblestone"));
		simpleBlock(CelestialBlocks.COMPRESSED_MOON_COBBLESTONE.get());
		simpleBlock(CelestialBlocks.SUPER_COMPRESSED_MOON_COBBLESTONE.get());

		simpleBlock(CelestialBlocks.MOON_BRICKS.get());
		stairsBlock(CelestialBlocks.MOON_BRICK_STAIRS.get(), modLoc("block/moon_bricks"));
		slabBlock(CelestialBlocks.MOON_BRICK_SLAB.get(), modLoc("block/moon_bricks"), modLoc("block/moon_bricks"));
		wallBlock(CelestialBlocks.MOON_BRICK_WALL.get(), modLoc("block/moon_bricks"));
		simpleBlock(CelestialBlocks.CHISELED_MOON_BRICKS.get());
		axisBlock(CelestialBlocks.MOON_BRICK_PILLAR.get(), modLoc("block/moon_brick_pillar"));
		simpleBlock(CelestialBlocks.CRACKED_MOON_BRICKS.get());

		simpleBlock(CelestialBlocks.MOON_SMOOTH_STONE.get());
		smoothStoneSlabBlock(CelestialBlocks.MOON_SMOOTH_STONE_SLAB.get(), "moon");


		//DEEPSLATE
		axisBlock(CelestialBlocks.MOON_DEEPSLATE.get());

		simpleBlock(CelestialBlocks.MOON_COBBLED_DEEPSLATE.get());
		stairsBlock(CelestialBlocks.MOON_COBBLED_DEEPSLATE_STAIRS.get(), modLoc("block/moon_cobbled_deepslate"));
		slabBlock(CelestialBlocks.MOON_COBBLED_DEEPSLATE_SLAB.get(), modLoc("block/moon_cobbled_deepslate"), modLoc("block/moon_cobbled_deepslate"));
		wallBlock(CelestialBlocks.MOON_COBBLED_DEEPSLATE_WALL.get(), modLoc("block/moon_cobbled_deepslate"));
		buttonBlock(CelestialBlocks.MOON_DEEPSLATE_BUTTON.get(), modLoc("block/moon_deepslate_side"));
		pressurePlateBlock(CelestialBlocks.MOON_DEEPSLATE_PRESSURE_PLATE.get(), modLoc("block/moon_deepslate_side"));
		simpleBlock(CelestialBlocks.COMPRESSED_MOON_COBBLED_DEEPSLATE.get());
		simpleBlock(CelestialBlocks.SUPER_COMPRESSED_MOON_COBBLED_DEEPSLATE.get());

		simpleBlock(CelestialBlocks.MOON_POLISHED_DEEPSLATE.get());
		stairsBlock(CelestialBlocks.MOON_POLISHED_DEEPSLATE_STAIRS.get(), modLoc("block/moon_polished_deepslate"));
		slabBlock(CelestialBlocks.MOON_POLISHED_DEEPSLATE_SLAB.get(), modLoc("block/moon_polished_deepslate"), modLoc("block/moon_polished_deepslate"));
		wallBlock(CelestialBlocks.MOON_POLISHED_DEEPSLATE_WALL.get(), modLoc("block/moon_polished_deepslate"));

		simpleBlock(CelestialBlocks.MOON_DEEPSLATE_BRICKS.get());
		stairsBlock(CelestialBlocks.MOON_DEEPSLATE_BRICK_STAIRS.get(), modLoc("block/moon_deepslate_bricks"));
		slabBlock(CelestialBlocks.MOON_DEEPSLATE_BRICK_SLAB.get(), modLoc("block/moon_deepslate_bricks"), modLoc("block/moon_deepslate_bricks"));
		wallBlock(CelestialBlocks.MOON_DEEPSLATE_BRICK_WALL.get(), modLoc("block/moon_deepslate_bricks"));
		simpleBlock(CelestialBlocks.CHISELED_MOON_DEEPSLATE_BRICKS.get());
		simpleBlock(CelestialBlocks.CRACKED_MOON_DEEPSLATE_BRICKS.get());

		simpleBlock(CelestialBlocks.MOON_DEEPSLATE_TILES.get());
		stairsBlock(CelestialBlocks.MOON_DEEPSLATE_TILE_STAIRS.get(), modLoc("block/moon_deepslate_tiles"));
		slabBlock(CelestialBlocks.MOON_DEEPSLATE_TILE_SLAB.get(), modLoc("block/moon_deepslate_tiles"), modLoc("block/moon_deepslate_tiles"));
		wallBlock(CelestialBlocks.MOON_DEEPSLATE_TILE_WALL.get(), modLoc("block/moon_deepslate_tiles"));
		simpleBlock(CelestialBlocks.CRACKED_MOON_DEEPSLATE_TILES.get());

		//ORES
		simpleBlock(CelestialBlocks.MOON_IRON_ORE.get());
		simpleBlock(CelestialBlocks.MOON_REDSTONE_ORE.get());
		simpleBlock(CelestialBlocks.MOON_BAUXITE_ORE.get());
		simpleBlock(CelestialBlocks.MOON_DEEPSLATE_IRON_ORE.get());
		simpleBlock(CelestialBlocks.MOON_DEEPSLATE_REDSTONE_ORE.get());

		//OTHER
		simpleBlock(CelestialBlocks.MOON_CORE.get());
		sandBlock(CelestialBlocks.MOON_SAND.get());
		sandPathBlock(CelestialBlocks.MOON_SAND_PATH.get(), CelestialBlocks.MOON_SAND.get());
		sandBlock(CelestialBlocks.COARSE_MOON_SAND.get());
		simpleBlock(CelestialBlocks.GLOWING_MOON_SAND.get());
		simpleBlock(CelestialBlocks.LUNAR_LANTERN.get());
		portalBlock(CelestialBlocks.MOON_PORTAL.get());

		//---- MARS -------------------------------------------------------------------------------
		//STONE
		varietyBlock(CelestialBlocks.MARS_STONE.get());
		stairsBlock(CelestialBlocks.MARS_STONE_STAIRS.get(), modLoc("block/mars_stone"));
		slabBlock(CelestialBlocks.MARS_STONE_SLAB.get(), modLoc("block/mars_stone"), modLoc("block/mars_stone"));
		buttonBlock(CelestialBlocks.MARS_STONE_BUTTON.get(), modLoc("block/mars_stone"));
		pressurePlateBlock(CelestialBlocks.MARS_STONE_PRESSURE_PLATE.get(), modLoc("block/mars_stone"));

		simpleBlock(CelestialBlocks.MARS_COBBLESTONE.get());
		stairsBlock(CelestialBlocks.MARS_COBBLESTONE_STAIRS.get(), modLoc("block/mars_cobblestone"));
		slabBlock(CelestialBlocks.MARS_COBBLESTONE_SLAB.get(), modLoc("block/mars_cobblestone"), modLoc("block/mars_cobblestone"));
		wallBlock(CelestialBlocks.MARS_COBBLESTONE_WALL.get(), modLoc("block/mars_cobblestone"));
		simpleBlock(CelestialBlocks.COMPRESSED_MARS_COBBLESTONE.get());
		simpleBlock(CelestialBlocks.SUPER_COMPRESSED_MARS_COBBLESTONE.get());

		simpleBlock(CelestialBlocks.MARS_BRICKS.get());
		stairsBlock(CelestialBlocks.MARS_BRICK_STAIRS.get(), modLoc("block/mars_bricks"));
		slabBlock(CelestialBlocks.MARS_BRICK_SLAB.get(), modLoc("block/mars_bricks"), modLoc("block/mars_bricks"));
		wallBlock(CelestialBlocks.MARS_BRICK_WALL.get(), modLoc("block/mars_bricks"));
		simpleBlock(CelestialBlocks.CHISELED_MARS_BRICKS.get());
		axisBlock(CelestialBlocks.MARS_BRICK_PILLAR.get(), modLoc("block/mars_brick_pillar"));
		simpleBlock(CelestialBlocks.CRACKED_MARS_BRICKS.get());

		simpleBlock(CelestialBlocks.MARS_SMOOTH_STONE.get());
		smoothStoneSlabBlock(CelestialBlocks.MARS_SMOOTH_STONE_SLAB.get(), "mars");

		//DEEPSLATE
		axisBlock((RotatedPillarBlock) CelestialBlocks.MARS_DEEPSLATE.get());

		simpleBlock(CelestialBlocks.MARS_COBBLED_DEEPSLATE.get());
		stairsBlock(CelestialBlocks.MARS_COBBLED_DEEPSLATE_STAIRS.get(), modLoc("block/mars_cobbled_deepslate"));
		slabBlock(CelestialBlocks.MARS_COBBLED_DEEPSLATE_SLAB.get(), modLoc("block/mars_cobbled_deepslate"), modLoc("block/mars_cobbled_deepslate"));
		wallBlock(CelestialBlocks.MARS_COBBLED_DEEPSLATE_WALL.get(), modLoc("block/mars_cobbled_deepslate"));
		buttonBlock(CelestialBlocks.MARS_DEEPSLATE_BUTTON.get(), modLoc("block/mars_deepslate_side"));
		pressurePlateBlock(CelestialBlocks.MARS_DEEPSLATE_PRESSURE_PLATE.get(), modLoc("block/mars_deepslate_side"));
		simpleBlock(CelestialBlocks.COMPRESSED_MARS_COBBLED_DEEPSLATE.get());
		simpleBlock(CelestialBlocks.SUPER_COMPRESSED_MARS_COBBLED_DEEPSLATE.get());

		simpleBlock(CelestialBlocks.MARS_POLISHED_DEEPSLATE.get());
		stairsBlock(CelestialBlocks.MARS_POLISHED_DEEPSLATE_STAIRS.get(), modLoc("block/mars_polished_deepslate"));
		slabBlock(CelestialBlocks.MARS_POLISHED_DEEPSLATE_SLAB.get(), modLoc("block/mars_polished_deepslate"), modLoc("block/mars_polished_deepslate"));
		wallBlock(CelestialBlocks.MARS_POLISHED_DEEPSLATE_WALL.get(), modLoc("block/mars_polished_deepslate"));

		simpleBlock(CelestialBlocks.MARS_DEEPSLATE_BRICKS.get());
		stairsBlock(CelestialBlocks.MARS_DEEPSLATE_BRICK_STAIRS.get(), modLoc("block/mars_deepslate_bricks"));
		slabBlock(CelestialBlocks.MARS_DEEPSLATE_BRICK_SLAB.get(), modLoc("block/mars_deepslate_bricks"), modLoc("block/mars_deepslate_bricks"));
		wallBlock(CelestialBlocks.MARS_DEEPSLATE_BRICK_WALL.get(), modLoc("block/mars_deepslate_bricks"));
		simpleBlock(CelestialBlocks.CHISELED_MARS_DEEPSLATE_BRICKS.get());
		simpleBlock(CelestialBlocks.CRACKED_MARS_DEEPSLATE_BRICKS.get());

		simpleBlock(CelestialBlocks.MARS_DEEPSLATE_TILES.get());
		stairsBlock(CelestialBlocks.MARS_DEEPSLATE_TILE_STAIRS.get(), modLoc("block/mars_deepslate_tiles"));
		slabBlock(CelestialBlocks.MARS_DEEPSLATE_TILE_SLAB.get(), modLoc("block/mars_deepslate_tiles"), modLoc("block/mars_deepslate_tiles"));
		wallBlock(CelestialBlocks.MARS_DEEPSLATE_TILE_WALL.get(), modLoc("block/mars_deepslate_tiles"));
		simpleBlock(CelestialBlocks.CRACKED_MARS_DEEPSLATE_TILES.get());

		//ORES
		simpleBlock(CelestialBlocks.MARS_IRON_ORE.get());
		simpleBlock(CelestialBlocks.MARS_REDSTONE_ORE.get());
		simpleBlock(CelestialBlocks.MARS_BAUXITE_ORE.get());
		simpleBlock(CelestialBlocks.MARS_DEEPSLATE_IRON_ORE.get());
		simpleBlock(CelestialBlocks.MARS_DEEPSLATE_REDSTONE_ORE.get());

		//OTHER
		simpleBlock(CelestialBlocks.MARS_CORE.get());
		simpleBlock(CelestialBlocks.MARS_LANTERN.get());
		sandBlock(CelestialBlocks.MARS_SAND.get());
		sandPathBlock(CelestialBlocks.MARS_SAND_PATH.get(), CelestialBlocks.MARS_SAND.get());
		sandBlock(CelestialBlocks.COARSE_MARS_SAND.get());
		portalBlock(CelestialBlocks.MARS_PORTAL.get());


		//---- VENUS -------------------------------------------------------------------------------
		//STONE
		varietyBlock(CelestialBlocks.VENUS_STONE.get());
		stairsBlock(CelestialBlocks.VENUS_STONE_STAIRS.get(), modLoc("block/venus_stone"));
		slabBlock(CelestialBlocks.VENUS_STONE_SLAB.get(), modLoc("block/venus_stone"), modLoc("block/venus_stone"));
		buttonBlock((ButtonBlock) CelestialBlocks.VENUS_STONE_BUTTON.get(), modLoc("block/venus_stone"));
		pressurePlateBlock((PressurePlateBlock) CelestialBlocks.VENUS_STONE_PRESSURE_PLATE.get(), modLoc("block/venus_stone"));

		simpleBlock(CelestialBlocks.VENUS_COBBLESTONE.get());
		stairsBlock(CelestialBlocks.VENUS_COBBLESTONE_STAIRS.get(), modLoc("block/venus_cobblestone"));
		slabBlock(CelestialBlocks.VENUS_COBBLESTONE_SLAB.get(), modLoc("block/venus_cobblestone"), modLoc("block/venus_cobblestone"));
		wallBlock(CelestialBlocks.VENUS_COBBLESTONE_WALL.get(), modLoc("block/venus_cobblestone"));
		simpleBlock(CelestialBlocks.COMPRESSED_VENUS_COBBLESTONE.get());
		simpleBlock(CelestialBlocks.SUPER_COMPRESSED_VENUS_COBBLESTONE.get());

		simpleBlock(CelestialBlocks.VENUS_BRICKS.get());
		stairsBlock(CelestialBlocks.VENUS_BRICK_STAIRS.get(), modLoc("block/venus_bricks"));
		slabBlock(CelestialBlocks.VENUS_BRICK_SLAB.get(), modLoc("block/venus_bricks"), modLoc("block/venus_bricks"));
		wallBlock(CelestialBlocks.VENUS_BRICK_WALL.get(), modLoc("block/venus_bricks"));
		simpleBlock(CelestialBlocks.CHISELED_VENUS_BRICKS.get());
		axisBlock((RotatedPillarBlock) CelestialBlocks.VENUS_BRICK_PILLAR.get(), modLoc("block/venus_brick_pillar"));
		simpleBlock(CelestialBlocks.CRACKED_VENUS_BRICKS.get());

		simpleBlock(CelestialBlocks.SMALL_VENUS_BRICKS.get());
		stairsBlock(CelestialBlocks.SMALL_VENUS_BRICK_STAIRS.get(), modLoc("block/small_venus_bricks"));
		slabBlock(CelestialBlocks.SMALL_VENUS_BRICK_SLAB.get(), modLoc("block/small_venus_bricks"), modLoc("block/small_venus_bricks"));
		wallBlock(CelestialBlocks.SMALL_VENUS_BRICK_WALL.get(), modLoc("block/small_venus_bricks"));

		simpleBlock(CelestialBlocks.VENUS_SMOOTH_STONE.get());
		smoothStoneSlabBlock(CelestialBlocks.VENUS_SMOOTH_STONE_SLAB.get(), "venus");

		//DEEPSLATE
		axisBlock((RotatedPillarBlock) CelestialBlocks.VENUS_DEEPSLATE.get());

		simpleBlock(CelestialBlocks.VENUS_COBBLED_DEEPSLATE.get());
		stairsBlock(CelestialBlocks.VENUS_COBBLED_DEEPSLATE_STAIRS.get(), modLoc("block/venus_cobbled_deepslate"));
		slabBlock(CelestialBlocks.VENUS_COBBLED_DEEPSLATE_SLAB.get(), modLoc("block/venus_cobbled_deepslate"), modLoc("block/venus_cobbled_deepslate"));
		wallBlock(CelestialBlocks.VENUS_COBBLED_DEEPSLATE_WALL.get(), modLoc("block/venus_cobbled_deepslate"));
		buttonBlock((ButtonBlock) CelestialBlocks.VENUS_DEEPSLATE_BUTTON.get(), modLoc("block/venus_deepslate_side"));
		pressurePlateBlock((PressurePlateBlock) CelestialBlocks.VENUS_DEEPSLATE_PRESSURE_PLATE.get(), modLoc("block/venus_deepslate_side"));
		simpleBlock(CelestialBlocks.COMPRESSED_VENUS_COBBLED_DEEPSLATE.get());
		simpleBlock(CelestialBlocks.SUPER_COMPRESSED_VENUS_COBBLED_DEEPSLATE.get());

		simpleBlock(CelestialBlocks.VENUS_POLISHED_DEEPSLATE.get());
		stairsBlock(CelestialBlocks.VENUS_POLISHED_DEEPSLATE_STAIRS.get(), modLoc("block/venus_polished_deepslate"));
		slabBlock(CelestialBlocks.VENUS_POLISHED_DEEPSLATE_SLAB.get(), modLoc("block/venus_polished_deepslate"), modLoc("block/venus_polished_deepslate"));
		wallBlock(CelestialBlocks.VENUS_POLISHED_DEEPSLATE_WALL.get(), modLoc("block/venus_polished_deepslate"));

		simpleBlock(CelestialBlocks.VENUS_DEEPSLATE_BRICKS.get());
		stairsBlock(CelestialBlocks.VENUS_DEEPSLATE_BRICK_STAIRS.get(), modLoc("block/venus_deepslate_bricks"));
		slabBlock(CelestialBlocks.VENUS_DEEPSLATE_BRICK_SLAB.get(), modLoc("block/venus_deepslate_bricks"), modLoc("block/venus_deepslate_bricks"));
		wallBlock(CelestialBlocks.VENUS_DEEPSLATE_BRICK_WALL.get(), modLoc("block/venus_deepslate_bricks"));
		simpleBlock(CelestialBlocks.CHISELED_VENUS_DEEPSLATE_BRICKS.get());
		simpleBlock(CelestialBlocks.CRACKED_VENUS_DEEPSLATE_BRICKS.get());

		simpleBlock(CelestialBlocks.VENUS_DEEPSLATE_TILES.get());
		stairsBlock(CelestialBlocks.VENUS_DEEPSLATE_TILE_STAIRS.get(), modLoc("block/venus_deepslate_tiles"));
		slabBlock(CelestialBlocks.VENUS_DEEPSLATE_TILE_SLAB.get(), modLoc("block/venus_deepslate_tiles"), modLoc("block/venus_deepslate_tiles"));
		wallBlock(CelestialBlocks.VENUS_DEEPSLATE_TILE_WALL.get(), modLoc("block/venus_deepslate_tiles"));
		simpleBlock(CelestialBlocks.CRACKED_VENUS_DEEPSLATE_TILES.get());

		//ORES
		simpleBlock(CelestialBlocks.VENUS_IRON_ORE.get());
		simpleBlock(CelestialBlocks.VENUS_REDSTONE_ORE.get());
		simpleBlock(CelestialBlocks.VENUS_BAUXITE_ORE.get());
		simpleBlock(CelestialBlocks.VENUS_LAPIS_ORE.get());
		simpleBlock(CelestialBlocks.VENUS_DEEPSLATE_LAPIS_ORE.get());
		simpleBlock(CelestialBlocks.VENUS_DEEPSLATE_IRON_ORE.get());
		simpleBlock(CelestialBlocks.VENUS_DEEPSLATE_REDSTONE_ORE.get());

		//OTHER
		simpleBlock(CelestialBlocks.VENUS_CORE.get());
		simpleBlock(CelestialBlocks.FINE_VENUS_SAND.get());
		simpleBlock(CelestialBlocks.SULFURIC_OBSIDIAN.get());
		simpleBlock(CelestialBlocks.VENUS_LANTERN.get());

		sandBlock(CelestialBlocks.VENUS_SAND.get());
		sandPathBlock(CelestialBlocks.VENUS_SAND_PATH.get(), CelestialBlocks.VENUS_SAND.get());
		portalBlock(CelestialBlocks.VENUS_PORTAL.get());


		//---- MERCURY -------------------------------------------------------------------------------
		//STONE
		varietyBlock(CelestialBlocks.MERCURY_STONE.get());
		stairsBlock(CelestialBlocks.MERCURY_STONE_STAIRS.get(), modLoc("block/mercury_stone"));
		slabBlock(CelestialBlocks.MERCURY_STONE_SLAB.get(), modLoc("block/mercury_stone"), modLoc("block/mercury_stone"));
		buttonBlock(CelestialBlocks.MERCURY_STONE_BUTTON.get(), modLoc("block/mercury_stone"));
		pressurePlateBlock(CelestialBlocks.MERCURY_STONE_PRESSURE_PLATE.get(), modLoc("block/mercury_stone"));

		simpleBlock(CelestialBlocks.MERCURY_COBBLESTONE.get());
		stairsBlock(CelestialBlocks.MERCURY_COBBLESTONE_STAIRS.get(), modLoc("block/mercury_cobblestone"));
		slabBlock(CelestialBlocks.MERCURY_COBBLESTONE_SLAB.get(), modLoc("block/mercury_cobblestone"), modLoc("block/mercury_cobblestone"));
		wallBlock(CelestialBlocks.MERCURY_COBBLESTONE_WALL.get(), modLoc("block/mercury_cobblestone"));
		simpleBlock(CelestialBlocks.COMPRESSED_MERCURY_COBBLESTONE.get());
		simpleBlock(CelestialBlocks.SUPER_COMPRESSED_MERCURY_COBBLESTONE.get());

		simpleBlock(CelestialBlocks.MERCURY_BRICKS.get());
		stairsBlock(CelestialBlocks.MERCURY_BRICK_STAIRS.get(), modLoc("block/mercury_bricks"));
		slabBlock(CelestialBlocks.MERCURY_BRICK_SLAB.get(), modLoc("block/mercury_bricks"), modLoc("block/mercury_bricks"));
		wallBlock(CelestialBlocks.MERCURY_BRICK_WALL.get(), modLoc("block/mercury_bricks"));
		simpleBlock(CelestialBlocks.CHISELED_MERCURY_BRICKS.get());
		axisBlock(CelestialBlocks.MERCURY_BRICK_PILLAR.get(), modLoc("block/mercury_brick_pillar"));
		simpleBlock(CelestialBlocks.CRACKED_MERCURY_BRICKS.get());

		simpleBlock(CelestialBlocks.MERCURY_SMOOTH_STONE.get());
		smoothStoneSlabBlock(CelestialBlocks.MERCURY_SMOOTH_STONE_SLAB.get(), "mercury");

		//DEEPSLATE
		axisBlock(CelestialBlocks.MERCURY_DEEPSLATE.get());

		simpleBlock(CelestialBlocks.MERCURY_COBBLED_DEEPSLATE.get());
		stairsBlock(CelestialBlocks.MERCURY_COBBLED_DEEPSLATE_STAIRS.get(), modLoc("block/mercury_cobbled_deepslate"));
		slabBlock(CelestialBlocks.MERCURY_COBBLED_DEEPSLATE_SLAB.get(), modLoc("block/mercury_cobbled_deepslate"), modLoc("block/mercury_cobbled_deepslate"));
		wallBlock(CelestialBlocks.MERCURY_COBBLED_DEEPSLATE_WALL.get(), modLoc("block/mercury_cobbled_deepslate"));
		buttonBlock(CelestialBlocks.MERCURY_DEEPSLATE_BUTTON.get(), modLoc("block/mercury_deepslate_side"));
		pressurePlateBlock(CelestialBlocks.MERCURY_DEEPSLATE_PRESSURE_PLATE.get(), modLoc("block/mercury_deepslate_side"));
		simpleBlock(CelestialBlocks.COMPRESSED_MERCURY_COBBLED_DEEPSLATE.get());
		simpleBlock(CelestialBlocks.SUPER_COMPRESSED_MERCURY_COBBLED_DEEPSLATE.get());

		simpleBlock(CelestialBlocks.MERCURY_POLISHED_DEEPSLATE.get());
		stairsBlock(CelestialBlocks.MERCURY_POLISHED_DEEPSLATE_STAIRS.get(), modLoc("block/mercury_polished_deepslate"));
		slabBlock(CelestialBlocks.MERCURY_POLISHED_DEEPSLATE_SLAB.get(), modLoc("block/mercury_polished_deepslate"), modLoc("block/mercury_polished_deepslate"));
		wallBlock(CelestialBlocks.MERCURY_POLISHED_DEEPSLATE_WALL.get(), modLoc("block/mercury_polished_deepslate"));

		simpleBlock(CelestialBlocks.MERCURY_DEEPSLATE_BRICKS.get());
		stairsBlock(CelestialBlocks.MERCURY_DEEPSLATE_BRICK_STAIRS.get(), modLoc("block/mercury_deepslate_bricks"));
		slabBlock(CelestialBlocks.MERCURY_DEEPSLATE_BRICK_SLAB.get(), modLoc("block/mercury_deepslate_bricks"), modLoc("block/mercury_deepslate_bricks"));
		wallBlock(CelestialBlocks.MERCURY_DEEPSLATE_BRICK_WALL.get(), modLoc("block/mercury_deepslate_bricks"));
		simpleBlock(CelestialBlocks.CHISELED_MERCURY_DEEPSLATE_BRICKS.get());
		simpleBlock(CelestialBlocks.CRACKED_MERCURY_DEEPSLATE_BRICKS.get());

		simpleBlock(CelestialBlocks.MERCURY_DEEPSLATE_TILES.get());
		stairsBlock(CelestialBlocks.MERCURY_DEEPSLATE_TILE_STAIRS.get(), modLoc("block/mercury_deepslate_tiles"));
		slabBlock(CelestialBlocks.MERCURY_DEEPSLATE_TILE_SLAB.get(), modLoc("block/mercury_deepslate_tiles"), modLoc("block/mercury_deepslate_tiles"));
		wallBlock(CelestialBlocks.MERCURY_DEEPSLATE_TILE_WALL.get(), modLoc("block/mercury_deepslate_tiles"));
		simpleBlock(CelestialBlocks.CRACKED_MERCURY_DEEPSLATE_TILES.get());

		//ORES
		simpleBlock(CelestialBlocks.MERCURY_BAUXITE_ORE.get());
		simpleBlock(CelestialBlocks.MERCURY_SULFUR_ORE.get());
		simpleBlock(CelestialBlocks.MERCURY_COAL_ORE.get());
		simpleBlock(CelestialBlocks.MERCURY_DIAMOND_ORE.get());
		simpleBlock(CelestialBlocks.MERCURY_DEEPSLATE_DIAMOND_ORE.get());
		simpleBlock(CelestialBlocks.MERCURY_DEEPSLATE_IRON_ORE.get());
		simpleBlock(CelestialBlocks.MERCURY_DEEPSLATE_COAL_ORE.get());
		simpleBlock(CelestialBlocks.MERCURY_DEEPSLATE_REDSTONE_ORE.get());

		//OTHER
		simpleBlock(CelestialBlocks.MERCURY_CORE.get());
		simpleBlock(CelestialBlocks.MERCURY_LANTERN.get());

		sandBlock(CelestialBlocks.MERCURY_SAND.get());
		sandPathBlock(CelestialBlocks.MERCURY_SAND_PATH.get(), CelestialBlocks.MERCURY_SAND.get());
		sandBlock(CelestialBlocks.COARSE_MERCURY_SAND.get());
		portalBlock(CelestialBlocks.MERCURY_PORTAL.get());


		//---- JUPITER -------------------------------------------------------------------------------
		//DEEPSLATE
		axisBlock(CelestialBlocks.JUPITER_DEEPSLATE.get());

		simpleBlock(CelestialBlocks.JUPITER_COBBLED_DEEPSLATE.get());
		stairsBlock(CelestialBlocks.JUPITER_COBBLED_DEEPSLATE_STAIRS.get(), modLoc("block/jupiter_cobbled_deepslate"));
		slabBlock(CelestialBlocks.JUPITER_COBBLED_DEEPSLATE_SLAB.get(), modLoc("block/jupiter_cobbled_deepslate"), modLoc("block/jupiter_cobbled_deepslate"));
		wallBlock(CelestialBlocks.JUPITER_COBBLED_DEEPSLATE_WALL.get(), modLoc("block/jupiter_cobbled_deepslate"));
		buttonBlock(CelestialBlocks.JUPITER_DEEPSLATE_BUTTON.get(), modLoc("block/jupiter_deepslate_side"));
		pressurePlateBlock(CelestialBlocks.JUPITER_DEEPSLATE_PRESSURE_PLATE.get(), modLoc("block/jupiter_deepslate_side"));
		simpleBlock(CelestialBlocks.COMPRESSED_JUPITER_COBBLED_DEEPSLATE.get());
		simpleBlock(CelestialBlocks.SUPER_COMPRESSED_JUPITER_COBBLED_DEEPSLATE.get());

		simpleBlock(CelestialBlocks.JUPITER_POLISHED_DEEPSLATE.get());
		stairsBlock(CelestialBlocks.JUPITER_POLISHED_DEEPSLATE_STAIRS.get(), modLoc("block/jupiter_polished_deepslate"));
		slabBlock(CelestialBlocks.JUPITER_POLISHED_DEEPSLATE_SLAB.get(), modLoc("block/jupiter_polished_deepslate"), modLoc("block/jupiter_polished_deepslate"));
		wallBlock(CelestialBlocks.JUPITER_POLISHED_DEEPSLATE_WALL.get(), modLoc("block/jupiter_polished_deepslate"));

		simpleBlock(CelestialBlocks.JUPITER_DEEPSLATE_BRICKS.get());
		stairsBlock(CelestialBlocks.JUPITER_DEEPSLATE_BRICK_STAIRS.get(), modLoc("block/jupiter_deepslate_bricks"));
		slabBlock(CelestialBlocks.JUPITER_DEEPSLATE_BRICK_SLAB.get(), modLoc("block/jupiter_deepslate_bricks"), modLoc("block/jupiter_deepslate_bricks"));
		wallBlock(CelestialBlocks.JUPITER_DEEPSLATE_BRICK_WALL.get(), modLoc("block/jupiter_deepslate_bricks"));
		simpleBlock(CelestialBlocks.CHISELED_JUPITER_DEEPSLATE_BRICKS.get());
		simpleBlock(CelestialBlocks.CRACKED_JUPITER_DEEPSLATE_BRICKS.get());

		simpleBlock(CelestialBlocks.JUPITER_DEEPSLATE_TILES.get());
		stairsBlock(CelestialBlocks.JUPITER_DEEPSLATE_TILE_STAIRS.get(), modLoc("block/jupiter_deepslate_tiles"));
		slabBlock(CelestialBlocks.JUPITER_DEEPSLATE_TILE_SLAB.get(), modLoc("block/jupiter_deepslate_tiles"), modLoc("block/jupiter_deepslate_tiles"));
		wallBlock(CelestialBlocks.JUPITER_DEEPSLATE_TILE_WALL.get(), modLoc("block/jupiter_deepslate_tiles"));
		simpleBlock(CelestialBlocks.CRACKED_JUPITER_DEEPSLATE_TILES.get());

		//OTHER
		simpleBlock(CelestialBlocks.JUPITER_CORE.get());
		simpleBlock(CelestialBlocks.JUPITER_ATMOSPHERE.get());
		simpleBlock(CelestialBlocks.JUPITER_LANTERN.get());
		portalBlock(CelestialBlocks.JUPITER_PORTAL.get());

		//---- JUPITER MOONS -------------------------------------------------------------------------------
		//---- IO -------------------------------------------------------------------------------
		//STONE
		varietyBlock(CelestialBlocks.IO_STONE.get());
		stairsBlock(CelestialBlocks.IO_STONE_STAIRS.get(), modLoc("block/io_stone"));
		slabBlock(CelestialBlocks.IO_STONE_SLAB.get(), modLoc("block/io_stone"), modLoc("block/io_stone"));
		buttonBlock(CelestialBlocks.IO_STONE_BUTTON.get(), modLoc("block/io_stone"));
		pressurePlateBlock(CelestialBlocks.IO_STONE_PRESSURE_PLATE.get(), modLoc("block/io_stone"));

		simpleBlock(CelestialBlocks.IO_COBBLESTONE.get());
		stairsBlock(CelestialBlocks.IO_COBBLESTONE_STAIRS.get(), modLoc("block/io_cobblestone"));
		slabBlock(CelestialBlocks.IO_COBBLESTONE_SLAB.get(), modLoc("block/io_cobblestone"), modLoc("block/io_cobblestone"));
		wallBlock(CelestialBlocks.IO_COBBLESTONE_WALL.get(), modLoc("block/io_cobblestone"));
		simpleBlock(CelestialBlocks.COMPRESSED_IO_COBBLESTONE.get());
		simpleBlock(CelestialBlocks.SUPER_COMPRESSED_IO_COBBLESTONE.get());

		simpleBlock(CelestialBlocks.IO_BRICKS.get());
		stairsBlock(CelestialBlocks.IO_BRICK_STAIRS.get(), modLoc("block/io_bricks"));
		slabBlock(CelestialBlocks.IO_BRICK_SLAB.get(), modLoc("block/io_bricks"), modLoc("block/io_bricks"));
		wallBlock(CelestialBlocks.IO_BRICK_WALL.get(), modLoc("block/io_bricks"));
		simpleBlock(CelestialBlocks.CHISELED_IO_BRICKS.get());
		axisBlock(CelestialBlocks.IO_BRICK_PILLAR.get(), modLoc("block/io_brick_pillar"));
		simpleBlock(CelestialBlocks.CRACKED_IO_BRICKS.get());

		simpleBlock(CelestialBlocks.IO_SMOOTH_STONE.get());
		smoothStoneSlabBlock(CelestialBlocks.IO_SMOOTH_STONE_SLAB.get(), "io");

		//DEEPSLATE
		axisBlock(CelestialBlocks.IO_DEEPSLATE.get());

		simpleBlock(CelestialBlocks.IO_COBBLED_DEEPSLATE.get());
		stairsBlock(CelestialBlocks.IO_COBBLED_DEEPSLATE_STAIRS.get(), modLoc("block/io_cobbled_deepslate"));
		slabBlock(CelestialBlocks.IO_COBBLED_DEEPSLATE_SLAB.get(), modLoc("block/io_cobbled_deepslate"), modLoc("block/io_cobbled_deepslate"));
		wallBlock(CelestialBlocks.IO_COBBLED_DEEPSLATE_WALL.get(), modLoc("block/io_cobbled_deepslate"));
		buttonBlock(CelestialBlocks.IO_DEEPSLATE_BUTTON.get(), modLoc("block/io_deepslate_side"));
		pressurePlateBlock(CelestialBlocks.IO_DEEPSLATE_PRESSURE_PLATE.get(), modLoc("block/io_deepslate_side"));
		simpleBlock(CelestialBlocks.COMPRESSED_IO_COBBLED_DEEPSLATE.get());
		simpleBlock(CelestialBlocks.SUPER_COMPRESSED_IO_COBBLED_DEEPSLATE.get());

		simpleBlock(CelestialBlocks.IO_POLISHED_DEEPSLATE.get());
		stairsBlock(CelestialBlocks.IO_POLISHED_DEEPSLATE_STAIRS.get(), modLoc("block/io_polished_deepslate"));
		slabBlock(CelestialBlocks.IO_POLISHED_DEEPSLATE_SLAB.get(), modLoc("block/io_polished_deepslate"), modLoc("block/io_polished_deepslate"));
		wallBlock(CelestialBlocks.IO_POLISHED_DEEPSLATE_WALL.get(), modLoc("block/io_polished_deepslate"));

		simpleBlock(CelestialBlocks.IO_DEEPSLATE_BRICKS.get());
		stairsBlock(CelestialBlocks.IO_DEEPSLATE_BRICK_STAIRS.get(), modLoc("block/io_deepslate_bricks"));
		slabBlock(CelestialBlocks.IO_DEEPSLATE_BRICK_SLAB.get(), modLoc("block/io_deepslate_bricks"), modLoc("block/io_deepslate_bricks"));
		wallBlock(CelestialBlocks.IO_DEEPSLATE_BRICK_WALL.get(), modLoc("block/io_deepslate_bricks"));
		simpleBlock(CelestialBlocks.CHISELED_IO_DEEPSLATE_BRICKS.get());
		simpleBlock(CelestialBlocks.CRACKED_IO_DEEPSLATE_BRICKS.get());

		simpleBlock(CelestialBlocks.IO_DEEPSLATE_TILES.get());
		stairsBlock(CelestialBlocks.IO_DEEPSLATE_TILE_STAIRS.get(), modLoc("block/io_deepslate_tiles"));
		slabBlock(CelestialBlocks.IO_DEEPSLATE_TILE_SLAB.get(), modLoc("block/io_deepslate_tiles"), modLoc("block/io_deepslate_tiles"));
		wallBlock(CelestialBlocks.IO_DEEPSLATE_TILE_WALL.get(), modLoc("block/io_deepslate_tiles"));
		simpleBlock(CelestialBlocks.CRACKED_IO_DEEPSLATE_TILES.get());

		//ORES
		simpleBlock(CelestialBlocks.IO_SULFUR_ORE.get());
		simpleBlock(CelestialBlocks.IO_LAPIS_ORE.get());
		simpleBlock(CelestialBlocks.IO_DEEPSLATE_LAPIS_ORE.get());
		simpleBlock(CelestialBlocks.IO_DEEPSLATE_IRON_ORE.get());

		//OTHER
		simpleBlock(CelestialBlocks.IO_CORE.get());
		simpleBlock(CelestialBlocks.IO_LANTERN.get());
		simpleBlock(CelestialBlocks.GLOWING_IO_SAND.get());
		sandBlock(CelestialBlocks.IO_SAND.get());
		sandBlock(CelestialBlocks.COARSE_IO_SAND.get());
		sandPathBlock(CelestialBlocks.IO_SAND_PATH.get(), CelestialBlocks.IO_SAND.get());
		portalBlock(CelestialBlocks.IO_PORTAL.get());


		//---- EUROPA -------------------------------------------------------------------------------
		simpleBlock(CelestialBlocks.EUROPA_CORE.get());
		simpleBlock(CelestialBlocks.EUROPA_HYDRATE.get());

		//EUROPA
		simpleBlock(CelestialBlocks.EUROPA_BRICKS.get());
		stairsBlock(CelestialBlocks.EUROPA_BRICK_STAIRS.get(), modLoc("block/europa_bricks"));
		slabBlock(CelestialBlocks.EUROPA_BRICK_SLAB.get(), modLoc("block/europa_bricks"), modLoc("block/europa_bricks"));
		wallBlock(CelestialBlocks.EUROPA_BRICK_WALL.get(), modLoc("block/europa_bricks"));
		simpleBlock(CelestialBlocks.CHISELED_EUROPA_BRICKS.get());
//		axisBlock(BlockRegistry.EUROPA_BRICK_PILLAR.get(), modLoc("block/europa_brick_pillar"));
//		simpleBlock(BlockRegistry.CRACKED_EUROPA_BRICKS.get());
		simpleBlock(CelestialBlocks.GLOWING_EUROPA_SAND.get());
		simpleBlock(CelestialBlocks.EUROPA_LANTERN.get());
		portalBlock(CelestialBlocks.EUROPA_PORTAL.get());


		//---- GANYMEDE -------------------------------------------------------------------------------
		simpleBlock(CelestialBlocks.GANYMEDE_CORE.get());
		simpleBlock(CelestialBlocks.GANYMEDE_BRICKS.get());
		stairsBlock(CelestialBlocks.GANYMEDE_BRICK_STAIRS.get(), modLoc("block/ganymede_bricks"));
		slabBlock(CelestialBlocks.GANYMEDE_BRICK_SLAB.get(), modLoc("block/ganymede_bricks"), modLoc("block/ganymede_bricks"));
		wallBlock(CelestialBlocks.GANYMEDE_BRICK_WALL.get(), modLoc("block/ganymede_bricks"));
		simpleBlock(CelestialBlocks.CHISELED_GANYMEDE_BRICKS.get());
//		axisBlock(BlockRegistry.GANYMEDE_BRICK_PILLAR.get(), modLoc("block/ganymede_brick_pillar"));
//		simpleBlock(BlockRegistry.CRACKED_GANYMEDE_BRICKS.get());
		simpleBlock(CelestialBlocks.GLOWING_GANYMEDE_SAND.get());
		simpleBlock(CelestialBlocks.GANYMEDE_LANTERN.get());
//		portalBlock(BlockRegistry.GANYMEDE_PORTAL.get());

		//---- CALLISTO -------------------------------------------------------------------------------

		//CALLISTO
		simpleBlock(CelestialBlocks.CALLISTO_CORE.get());
		simpleBlock(CelestialBlocks.CALLISTO_BRICKS.get());
		stairsBlock(CelestialBlocks.CALLISTO_BRICK_STAIRS.get(), modLoc("block/callisto_bricks"));
		slabBlock(CelestialBlocks.CALLISTO_BRICK_SLAB.get(), modLoc("block/callisto_bricks"), modLoc("block/callisto_bricks"));
		wallBlock(CelestialBlocks.CALLISTO_BRICK_WALL.get(), modLoc("block/callisto_bricks"));
		simpleBlock(CelestialBlocks.CHISELED_CALLISTO_BRICKS.get());
//		axisBlock(BlockRegistry.CALLISTO_BRICK_PILLAR.get(), modLoc("block/callisto_brick_pillar"));
//		simpleBlock(BlockRegistry.CRACKED_CALLISTO_BRICKS.get());
		simpleBlock(CelestialBlocks.GLOWING_CALLISTO_SAND.get());
		simpleBlock(CelestialBlocks.CALLISTO_LANTERN.get());
		portalBlock(CelestialBlocks.CALLISTO_PORTAL.get());

		//---- OTHER PLANETS -------------------------------------------------------------------------------

		//SATURN
		simpleBlock(CelestialBlocks.SATURN_ATMOSPHERE.get());
		simpleBlock(CelestialBlocks.SATURN_CORE.get());
		axisBlock((RotatedPillarBlock) CelestialBlocks.SATURN_DEEPSLATE.get());

		simpleBlock(CelestialBlocks.TITAN_CORE.get());
		simpleBlock(CelestialBlocks.ENCELADUS_CORE.get());
		simpleBlock(CelestialBlocks.RHEA_CORE.get());
		simpleBlock(CelestialBlocks.IAPETUS_CORE.get());
		simpleBlock(CelestialBlocks.DIONE_CORE.get());
		simpleBlock(CelestialBlocks.HYPERION_CORE.get());

		//URANUS
		simpleBlock(CelestialBlocks.URANUS_ATMOSPHERE.get());
		simpleBlock(CelestialBlocks.URANUS_CORE.get());
		axisBlock((RotatedPillarBlock) CelestialBlocks.URANUS_DEEPSLATE.get());

		simpleBlock(CelestialBlocks.TITANIA_CORE.get());
		simpleBlock(CelestialBlocks.OBERON_CORE.get());

		//NEPTUNE
		simpleBlock(CelestialBlocks.NEPTUNE_ATMOSPHERE.get());
		simpleBlock(CelestialBlocks.NEPTUNE_CORE.get());
		axisBlock((RotatedPillarBlock) CelestialBlocks.NEPTUNE_DEEPSLATE.get());

		simpleBlock(CelestialBlocks.TRITON_CORE.get());

		//DWARF PLANETS/OTHER
//		simpleBlock(BlockRegistry.PLUTO_CORE.get());
//		simpleBlock(BlockRegistry.CERES_CORE.get());
//		simpleBlock(BlockRegistry.ERIS_CORE.get());
//		simpleBlock(BlockRegistry.HAUMEA_CORE.get());
//		simpleBlock(BlockRegistry.MAKEMAKE_CORE.get());

		//---- CELESTIAL OBJECTS -------------------------------------------------------------------------------
		//METEOR
		simpleBlock(CelestialBlocks.METEOR.get());
		simpleBlock(CelestialBlocks.METEOR_BRICKS.get());
		simpleBlock(CelestialBlocks.CHISELED_METEOR_BRICKS.get());
		stairsBlock((StairBlock) CelestialBlocks.METEOR_BRICK_STAIRS.get(), modLoc("block/meteor_bricks"));
		slabBlock((SlabBlock) CelestialBlocks.METEOR_BRICK_SLAB.get(), modLoc("block/meteor_bricks"), modLoc("block/meteor_bricks"));
		wallBlock((WallBlock) CelestialBlocks.METEOR_BRICK_WALL.get(), modLoc("block/meteor_bricks"));
		buttonBlock((ButtonBlock) CelestialBlocks.METEOR_BUTTON.get(), modLoc("block/meteor"));
		pressurePlateBlock((PressurePlateBlock) CelestialBlocks.METEOR_PRESSURE_PLATE.get(), modLoc("block/meteor"));

		//METEOR ORES
		simpleBlock(CelestialBlocks.METEOR_COAL_ORE.get());
		simpleBlock(CelestialBlocks.METEOR_COPPER_ORE.get());
		simpleBlock(CelestialBlocks.METEOR_DIAMOND_ORE.get());
		simpleBlock(CelestialBlocks.METEOR_EMERALD_ORE.get());
		simpleBlock(CelestialBlocks.METEOR_GOLD_ORE.get());
		simpleBlock(CelestialBlocks.METEOR_IRON_ORE.get());
		simpleBlock(CelestialBlocks.METEOR_LAPIS_ORE.get());
		simpleBlock(CelestialBlocks.METEOR_SULFUR_ORE.get());
		simpleBlock(CelestialBlocks.METEOR_BAUXITE_ORE.get());
		simpleBlock(CelestialBlocks.METEOR_REDSTONE_ORE.get());

		//SUN
		simpleBlock(CelestialBlocks.SOLAR_PLASMA.get());
		simpleBlock(CelestialBlocks.SOLAR_FLARE.get());
		simpleBlock(CelestialBlocks.SUN_SPOT.get());


		//---- ORE-RELATED -------------------------------------------------------------------------------
		simpleBlock(CelestialBlocks.STEEL_BLOCK.get());
		simpleBlock(CelestialBlocks.ALUMINUM_BLOCK.get());


		//---- SPACE STATION -------------------------------------------------------------------------------
		doorBlock(CelestialBlocks.AIRLOCK_DOOR.get(), modLoc("block/airlock_door_bottom"), modLoc("block/airlock_door_top"));
		doorBlock(CelestialBlocks.STEEL_DOOR.get(), modLoc("block/steel_door_bottom"), modLoc("block/steel_door_top"));
		trapdoorBlock(CelestialBlocks.AIRLOCK_TRAPDOOR.get(), modLoc("block/airlock_trapdoor"), true);
		trapdoorBlock(CelestialBlocks.STEEL_TRAPDOOR.get(), modLoc("block/steel_trapdoor"), true);
		buttonBlock(CelestialBlocks.STEEL_BUTTON.get(), modLoc("block/steel_block"));
		buttonBlock(CelestialBlocks.AIRLOCK_BUTTON.get(), modLoc("block/airlock_button"), modLoc("block/airlock_button_pressed"));

		simpleBlock(CelestialBlocks.PANEL.get());
		paneBlock((CelestialBlocks.THIN_PANEL.get()), modLoc("block/panel"), modLoc("block/thin_panel_top"));
		stairsBlock(CelestialBlocks.PANEL_STAIRS.get(), modLoc("block/panel"));
		slabBlock(CelestialBlocks.PANEL_SLAB.get(), modLoc("block/panel"), modLoc("block/panel"));
		wallBlock(CelestialBlocks.PANEL_WALL.get(), modLoc("block/panel"));

		buttonBlock(CelestialBlocks.RED_BUTTON.get(), mcLoc("block/red_stained_glass"), modLoc("block/red_button_pressed"));
		buttonBlock(CelestialBlocks.YELLOW_BUTTON.get(), mcLoc("block/yellow_stained_glass"), modLoc("block/yellow_button_pressed"));
		buttonBlock(CelestialBlocks.BLUE_BUTTON.get(), mcLoc("block/blue_stained_glass"), modLoc("block/blue_button_pressed"));
		buttonBlock(CelestialBlocks.GREEN_BUTTON.get(), mcLoc("block/green_stained_glass"), modLoc("block/green_button_pressed"));
		buttonBlock(CelestialBlocks.WHITE_BUTTON.get(), mcLoc("block/white_stained_glass"), modLoc("block/white_button_pressed"));
		buttonBlock(CelestialBlocks.BLACK_BUTTON.get(), mcLoc("block/black_stained_glass"), modLoc("block/black_button_pressed"));

		//---- GLASS/CERAMICS -------------------------------------------------------------------------------
		//GLASS
		simpleBlock(CelestialBlocks.LUMINOUS_BLUE_GLASS.get());
		simpleBlock(CelestialBlocks.LUMINOUS_WHITE_GLASS.get());
		simpleBlock(CelestialBlocks.LUMINOUS_CYAN_GLASS.get());
		simpleBlock(CelestialBlocks.LUMINOUS_MAGENTA_GLASS.get());
		simpleBlock(CelestialBlocks.LUMINOUS_YELLOW_GLASS.get());
		simpleBlock(CelestialBlocks.LUMINOUS_RED_GLASS.get());

		paneBlock(CelestialBlocks.LUMINOUS_MAGENTA_GLASS_PANE.get(), modLoc("block/luminous_magenta_glass"), mcLoc("block/magenta_stained_glass_pane_top"));
		paneBlock(CelestialBlocks.LUMINOUS_BLUE_GLASS_PANE.get(), modLoc("block/luminous_blue_glass"), modLoc("block/luminous_blue_glass_pane_top"));
		paneBlock(CelestialBlocks.LUMINOUS_CYAN_GLASS_PANE.get(), modLoc("block/luminous_cyan_glass"), modLoc("block/luminous_cyan_glass_pane_top"));
		paneBlock(CelestialBlocks.LUMINOUS_WHITE_GLASS_PANE.get(), modLoc("block/luminous_white_glass"), modLoc("block/luminous_white_glass_pane_top"));
		paneBlock(CelestialBlocks.LUMINOUS_YELLOW_GLASS_PANE.get(), modLoc("block/luminous_yellow_glass"), modLoc("block/luminous_yellow_glass_pane_top"));
		paneBlock(CelestialBlocks.LUMINOUS_RED_GLASS_PANE.get(), modLoc("block/luminous_red_glass"), modLoc("block/luminous_red_glass_pane_top"));

		//CERAMIC
		simpleBlock(CelestialBlocks.SILICA.get());

		simpleBlock(CelestialBlocks.CERAMIC.get());
		paneBlock(CelestialBlocks.CERAMIC_TILE.get(), modLoc("block/ceramic"), modLoc("block/ceramic_tile_top"));

		simpleBlock(CelestialBlocks.WHITE_CERAMIC.get());
		paneBlock(CelestialBlocks.WHITE_CERAMIC_TILE.get(), modLoc("block/white_ceramic"), modLoc("block/white_ceramic_tile_top"));
		simpleBlock(CelestialBlocks.LIGHT_GREY_CERAMIC.get());
		paneBlock(CelestialBlocks.LIGHT_GREY_CERAMIC_TILE.get(), modLoc("block/light_grey_ceramic"), modLoc("block/light_grey_ceramic_tile_top"));
		simpleBlock(CelestialBlocks.GREY_CERAMIC.get());
		paneBlock(CelestialBlocks.GREY_CERAMIC_TILE.get(), modLoc("block/grey_ceramic"), modLoc("block/grey_ceramic_tile_top"));
		simpleBlock(CelestialBlocks.BLACK_CERAMIC.get());
		paneBlock(CelestialBlocks.BLACK_CERAMIC_TILE.get(), modLoc("block/black_ceramic"), modLoc("block/black_ceramic_tile_top"));
		simpleBlock(CelestialBlocks.PURPLE_CERAMIC.get());
		paneBlock(CelestialBlocks.PURPLE_CERAMIC_TILE.get(), modLoc("block/purple_ceramic"), modLoc("block/purple_ceramic_tile_top"));
		simpleBlock(CelestialBlocks.MAGENTA_CERAMIC.get());
		paneBlock(CelestialBlocks.MAGENTA_CERAMIC_TILE.get(), modLoc("block/magenta_ceramic"), modLoc("block/magenta_ceramic_tile_top"));
		simpleBlock(CelestialBlocks.BLUE_CERAMIC.get());
		paneBlock(CelestialBlocks.BLUE_CERAMIC_TILE.get(), modLoc("block/blue_ceramic"), modLoc("block/blue_ceramic_tile_top"));
		simpleBlock(CelestialBlocks.LIGHT_BLUE_CERAMIC.get());
		paneBlock(CelestialBlocks.LIGHT_BLUE_CERAMIC_TILE.get(), modLoc("block/light_blue_ceramic"), modLoc("block/light_blue_ceramic_tile_top"));
		simpleBlock(CelestialBlocks.CYAN_CERAMIC.get());
		paneBlock(CelestialBlocks.CYAN_CERAMIC_TILE.get(), modLoc("block/cyan_ceramic"), modLoc("block/cyan_ceramic_tile_top"));
		simpleBlock(CelestialBlocks.GREEN_CERAMIC.get());
		paneBlock(CelestialBlocks.GREEN_CERAMIC_TILE.get(), modLoc("block/green_ceramic"), modLoc("block/green_ceramic_tile_top"));
		simpleBlock(CelestialBlocks.LIME_CERAMIC.get());
		paneBlock(CelestialBlocks.LIME_CERAMIC_TILE.get(), modLoc("block/lime_ceramic"), modLoc("block/lime_ceramic_tile_top"));
		simpleBlock(CelestialBlocks.YELLOW_CERAMIC.get());
		paneBlock(CelestialBlocks.YELLOW_CERAMIC_TILE.get(), modLoc("block/yellow_ceramic"), modLoc("block/yellow_ceramic_tile_top"));
		simpleBlock(CelestialBlocks.ORANGE_CERAMIC.get());
		paneBlock(CelestialBlocks.ORANGE_CERAMIC_TILE.get(), modLoc("block/orange_ceramic"), modLoc("block/orange_ceramic_tile_top"));
		simpleBlock(CelestialBlocks.BROWN_CERAMIC.get());
		paneBlock(CelestialBlocks.BROWN_CERAMIC_TILE.get(), modLoc("block/brown_ceramic"), modLoc("block/brown_ceramic_tile_top"));
		simpleBlock(CelestialBlocks.RED_CERAMIC.get());
		paneBlock(CelestialBlocks.RED_CERAMIC_TILE.get(), modLoc("block/red_ceramic"), modLoc("block/red_ceramic_tile_top"));
		simpleBlock(CelestialBlocks.PINK_CERAMIC.get());
		paneBlock(CelestialBlocks.PINK_CERAMIC_TILE.get(), modLoc("block/pink_ceramic"), modLoc("block/pink_ceramic_tile_top"));

//		stairsBlock(BlockRegistry.CERAMIC_STAIRS.get(), modLoc("block/ceramic"));
//		slabBlock(BlockRegistry.CERAMIC_SLAB.get(), modLoc("block/ceramic"), modLoc("block/ceramic"));
//		stairsBlock(BlockRegistry.WHITE_CERAMIC_STAIRS.get(), modLoc("block/white_ceramic"));
//		slabBlock(BlockRegistry.WHITE_CERAMIC_SLAB.get(), modLoc("block/white_ceramic"), modLoc("block/white_ceramic"));
//		stairsBlock(BlockRegistry.LIGHT_GREY_CERAMIC_STAIRS.get(), modLoc("block/light_grey_ceramic"));
//		slabBlock(BlockRegistry.LIGHT_GREY_CERAMIC_SLAB.get(), modLoc("block/light_grey_ceramic"), modLoc("block/light_grey_ceramic"));
//		stairsBlock(BlockRegistry.GREY_CERAMIC_STAIRS.get(), modLoc("block/grey_ceramic"));
//		slabBlock(BlockRegistry.GREY_CERAMIC_SLAB.get(), modLoc("block/grey_ceramic"), modLoc("block/grey_ceramic"));
//		stairsBlock(BlockRegistry.BLACK_CERAMIC_STAIRS.get(), modLoc("block/black_ceramic"));
//		slabBlock(BlockRegistry.BLACK_CERAMIC_SLAB.get(), modLoc("block/black_ceramic"), modLoc("block/black_ceramic"));
//		stairsBlock(BlockRegistry.PURPLE_CERAMIC_STAIRS.get(), modLoc("block/purple_ceramic"));
//		slabBlock(BlockRegistry.PURPLE_CERAMIC_SLAB.get(), modLoc("block/purple_ceramic"), modLoc("block/purple_ceramic"));
//		stairsBlock(BlockRegistry.MAGENTA_CERAMIC_STAIRS.get(), modLoc("block/magenta_ceramic"));
//		slabBlock(BlockRegistry.MAGENTA_CERAMIC_SLAB.get(), modLoc("block/magenta_ceramic"), modLoc("block/magenta_ceramic"));
//		stairsBlock(BlockRegistry.BLUE_CERAMIC_STAIRS.get(), modLoc("block/blue_ceramic"));
//		slabBlock(BlockRegistry.BLUE_CERAMIC_SLAB.get(), modLoc("block/blue_ceramic"), modLoc("block/blue_ceramic"));
//		stairsBlock(BlockRegistry.LIGHT_BLUE_CERAMIC_STAIRS.get(), modLoc("block/light_blue_ceramic"));
//		slabBlock(BlockRegistry.LIGHT_BLUE_CERAMIC_SLAB.get(), modLoc("block/light_blue_ceramic"), modLoc("block/light_blue_ceramic"));
//		stairsBlock(BlockRegistry.CYAN_CERAMIC_STAIRS.get(), modLoc("block/cyan_ceramic"));
//		slabBlock(BlockRegistry.CYAN_CERAMIC_SLAB.get(), modLoc("block/cyan_ceramic"), modLoc("block/cyan_ceramic"));
//		stairsBlock(BlockRegistry.GREEN_CERAMIC_STAIRS.get(), modLoc("block/green_ceramic"));
//		slabBlock(BlockRegistry.GREEN_CERAMIC_SLAB.get(), modLoc("block/green_ceramic"), modLoc("block/green_ceramic"));
//		stairsBlock(BlockRegistry.LIME_CERAMIC_STAIRS.get(), modLoc("block/lime_ceramic"));
//		slabBlock(BlockRegistry.LIME_CERAMIC_SLAB.get(), modLoc("block/lime_ceramic"), modLoc("block/lime_ceramic"));
//		stairsBlock(BlockRegistry.YELLOW_CERAMIC_STAIRS.get(), modLoc("block/yellow_ceramic"));
//		slabBlock(BlockRegistry.YELLOW_CERAMIC_SLAB.get(), modLoc("block/yellow_ceramic"), modLoc("block/yellow_ceramic"));
//		stairsBlock(BlockRegistry.ORANGE_CERAMIC_STAIRS.get(), modLoc("block/orange_ceramic"));
//		slabBlock(BlockRegistry.ORANGE_CERAMIC_SLAB.get(), modLoc("block/orange_ceramic"), modLoc("block/orange_ceramic"));
//		stairsBlock(BlockRegistry.BROWN_CERAMIC_STAIRS.get(), modLoc("block/brown_ceramic"));
//		slabBlock(BlockRegistry.BROWN_CERAMIC_SLAB.get(), modLoc("block/brown_ceramic"), modLoc("block/brown_ceramic"));
//		stairsBlock(BlockRegistry.RED_CERAMIC_STAIRS.get(), modLoc("block/red_ceramic"));
//		slabBlock(BlockRegistry.RED_CERAMIC_SLAB.get(), modLoc("block/red_ceramic"), modLoc("block/red_ceramic"));
//		stairsBlock(BlockRegistry.PINK_CERAMIC_STAIRS.get(), modLoc("block/pink_ceramic"));
//		slabBlock(BlockRegistry.PINK_CERAMIC_SLAB.get(), modLoc("block/pink_ceramic"), modLoc("block/pink_ceramic_tile_top"));

		//---- MISC -------------------------------------------------------------------------------
		//FLUIDS
		simpleBlock(CelestialFluids.LOX_BLOCK.get());
		simpleBlock(CelestialFluids.MOLTEN_IRON_BLOCK.get());
		simpleBlock(CelestialFluids.MOLTEN_STEEL_BLOCK.get());
		simpleBlock(CelestialFluids.MOLTEN_COPPER_BLOCK.get());
		simpleBlock(CelestialFluids.MOLTEN_GOLD_BLOCK.get());
//		simpleBlock(FluidRegistry.MOLTEN_NETHERITE_BLOCK.get());
		simpleBlock(CelestialFluids.MOLTEN_ALUMINUM_BLOCK.get());
		simpleBlock(CelestialFluids.SULFUR_BLOCK.get());
		simpleBlock(CelestialFluids.METALLIC_HYDROGEN_BLOCK.get());

		//OTHER
		simpleBlock(CelestialBlocks.DRY_ICE.get());

		simpleBlock(CelestialBlocks.COMPRESSED_COBBLESTONE.get());
		simpleBlock(CelestialBlocks.COMPRESSED_COBBLED_DEEPSLATE.get());
		simpleBlock(CelestialBlocks.COMPRESSED_NETHERRACK.get());
		simpleBlock(CelestialBlocks.SUPER_COMPRESSED_COBBLESTONE.get());
		simpleBlock(CelestialBlocks.SUPER_COMPRESSED_COBBLED_DEEPSLATE.get());
		simpleBlock(CelestialBlocks.SUPER_COMPRESSED_NETHERRACK.get());

		simpleBlock(CelestialBlocks.BAUXITE_ORE.get());

		simpleBlock(CelestialBlocks.TAXI_STATION.get());
	}

	public void buttonBlock(ButtonBlock block, ResourceLocation texture, ResourceLocation texturePressed) {
		ModelFile button = models().button(name(block), texture);
		ModelFile buttonPressed = models().buttonPressed(name(block) + "_pressed", texturePressed);
		buttonBlock(block, button, buttonPressed);
	}

	private String name(Block block) {
		return block.getRegistryName().getPath();
	}

	public void varietyBlock(Block block) {
		ModelFile var = models().cubeAll(name(block), blockTexture(block));
		ModelFile mirror = cubeMirroredAll(name(block), blockTexture(block));

		getVariantBuilder(block)
				.partialState().addModels(new ConfiguredModel(var), new ConfiguredModel(var, 0, 180, false),
						new ConfiguredModel(mirror), new ConfiguredModel(mirror, 0, 180, false));
	}

	public void sandPathBlock(Block block, Block bottomTexture) {
		ModelFile model = models().withExistingParent(name(block), modLoc("template_sand_path"))
				.texture("side", blockTexture(block) + "_side").texture("top", blockTexture(block) + "_top")
				.texture("bottom", blockTexture(bottomTexture)).texture("particle", blockTexture(bottomTexture));

		getVariantBuilder(block)
				.partialState().addModels(new ConfiguredModel(model), new ConfiguredModel(model, 0, 90, false),
						new ConfiguredModel(model, 0, 180, false), new ConfiguredModel(model, 0, 270, false));
	}

	public void sandBlock(Block block) {
		ModelFile model = models().cubeAll(name(block), blockTexture(block));

		getVariantBuilder(block)
				.partialState().addModels(new ConfiguredModel(model), new ConfiguredModel(model, 0, 90, false),
						new ConfiguredModel(model, 0, 180, false), new ConfiguredModel(model, 0, 270, false));
	}

	public void portalBlock(Block block) {
		ModelFile ew_model = models().withExistingParent(block.getRegistryName().getPath() + "_ew", modLoc("template_portal_ew"))
				.texture("portal", blockTexture(block)).texture("particle", blockTexture(block));
		ModelFile ns_model = models().withExistingParent(block.getRegistryName().getPath() + "_ns", modLoc("template_portal_ns"))
				.texture("portal", blockTexture(block)).texture("particle", blockTexture(block));

		getVariantBuilder(block)
				.partialState().with(AbstractPortalBlock.AXIS, Direction.Axis.Z).modelForState().modelFile(ew_model).addModel()
				.partialState().with(AbstractPortalBlock.AXIS, Direction.Axis.X).modelForState().modelFile(ns_model).addModel();
	}

	public void smoothStoneSlabBlock(Block block, String prefix) {
		ModelFile bottomSlab = models().withExistingParent(block.getRegistryName().getPath(), mcLoc("slab"))
				.texture("bottom", modLoc("block/" + prefix + "_smooth_stone"))
				.texture("top", modLoc("block/" + prefix + "_smooth_stone"))
				.texture("side", modLoc("block/" + prefix + "_smooth_stone_slab_side"));

		ModelFile doubleSlab = models().withExistingParent(block.getRegistryName().getPath() + "_double", mcLoc("cube_column"))
				.texture("end", modLoc("block/" + prefix + "_smooth_stone"))
				.texture("side", modLoc("block/" + prefix + "_smooth_stone_slab_side"));

		ModelFile topSlab = models().withExistingParent(block.getRegistryName().getPath() + "_top", mcLoc("slab_top"))
				.texture("bottom", modLoc("block/" + prefix + "_smooth_stone"))
				.texture("top", modLoc("block/" + prefix + "_smooth_stone"))
				.texture("side", modLoc("block/" + prefix + "_smooth_stone_slab_side"));

		getVariantBuilder(block)
				.partialState().with(SlabBlock.TYPE, SlabType.BOTTOM).modelForState().modelFile(bottomSlab).addModel()
				.partialState().with(SlabBlock.TYPE, SlabType.DOUBLE).modelForState().modelFile(doubleSlab).addModel()
				.partialState().with(SlabBlock.TYPE, SlabType.TOP).modelForState().modelFile(topSlab).addModel();
	}

	public BlockModelBuilder cubeMirroredAll(String name, ResourceLocation texture) {
        return models().withExistingParent(name + "_mirrored", mcLoc("block/cube_mirrored_all")).texture("all", texture);
	}
}