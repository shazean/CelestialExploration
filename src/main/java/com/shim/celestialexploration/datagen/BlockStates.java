package com.shim.celestialexploration.datagen;

import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestialexploration.blocks.AbstractPortalBlock;
import com.shim.celestialexploration.registry.BlockRegistry;
import com.shim.celestialexploration.registry.FluidRegistry;
import net.minecraft.core.Direction;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.properties.SlabType;
import net.minecraftforge.client.model.generators.BlockModelBuilder;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;

public class BlockStates extends BlockStateProvider {

	public BlockStates(DataGenerator gen, ExistingFileHelper helper) {
		super(gen, CelestialExploration.MODID, helper);
	}

	@Override
	protected void registerStatesAndModels() {

		//---- MOON -------------------------------------------------------------------------------
		//STONE
		varietyBlock(BlockRegistry.MOON_STONE.get());
		stairsBlock(BlockRegistry.MOON_STONE_STAIRS.get(), modLoc("block/moon_stone"));
		slabBlock(BlockRegistry.MOON_STONE_SLAB.get(), modLoc("block/moon_stone"), modLoc("block/moon_stone"));
		buttonBlock(BlockRegistry.MOON_STONE_BUTTON.get(), modLoc("block/moon_stone"));
		pressurePlateBlock(BlockRegistry.MOON_STONE_PRESSURE_PLATE.get(), modLoc("block/moon_stone"));

		simpleBlock(BlockRegistry.MOON_COBBLESTONE.get());
		stairsBlock(BlockRegistry.MOON_COBBLESTONE_STAIRS.get(), modLoc("block/moon_cobblestone"));
		slabBlock(BlockRegistry.MOON_COBBLESTONE_SLAB.get(), modLoc("block/moon_cobblestone"), modLoc("block/moon_cobblestone"));
		wallBlock(BlockRegistry.MOON_COBBLESTONE_WALL.get(), modLoc("block/moon_cobblestone"));
		simpleBlock(BlockRegistry.COMPRESSED_MOON_COBBLESTONE.get());
		simpleBlock(BlockRegistry.SUPER_COMPRESSED_MOON_COBBLESTONE.get());

		simpleBlock(BlockRegistry.MOON_BRICKS.get());
		stairsBlock(BlockRegistry.MOON_BRICK_STAIRS.get(), modLoc("block/moon_bricks"));
		slabBlock(BlockRegistry.MOON_BRICK_SLAB.get(), modLoc("block/moon_bricks"), modLoc("block/moon_bricks"));
		wallBlock(BlockRegistry.MOON_BRICK_WALL.get(), modLoc("block/moon_bricks"));
		simpleBlock(BlockRegistry.CHISELED_MOON_BRICKS.get());
		axisBlock(BlockRegistry.MOON_BRICK_PILLAR.get(), modLoc("block/moon_brick_pillar"));
		simpleBlock(BlockRegistry.CRACKED_MOON_BRICKS.get());

		simpleBlock(BlockRegistry.MOON_SMOOTH_STONE.get());
		smoothStoneSlabBlock(BlockRegistry.MOON_SMOOTH_STONE_SLAB.get(), "moon");


		//DEEPSLATE
		axisBlock(BlockRegistry.MOON_DEEPSLATE.get());

		simpleBlock(BlockRegistry.MOON_COBBLED_DEEPSLATE.get());
		stairsBlock(BlockRegistry.MOON_COBBLED_DEEPSLATE_STAIRS.get(), modLoc("block/moon_cobbled_deepslate"));
		slabBlock(BlockRegistry.MOON_COBBLED_DEEPSLATE_SLAB.get(), modLoc("block/moon_cobbled_deepslate"), modLoc("block/moon_cobbled_deepslate"));
		wallBlock(BlockRegistry.MOON_COBBLED_DEEPSLATE_WALL.get(), modLoc("block/moon_cobbled_deepslate"));
		buttonBlock(BlockRegistry.MOON_DEEPSLATE_BUTTON.get(), modLoc("block/moon_deepslate_side"));
		pressurePlateBlock(BlockRegistry.MOON_DEEPSLATE_PRESSURE_PLATE.get(), modLoc("block/moon_deepslate_side"));
		simpleBlock(BlockRegistry.COMPRESSED_MOON_COBBLED_DEEPSLATE.get());
		simpleBlock(BlockRegistry.SUPER_COMPRESSED_MOON_COBBLED_DEEPSLATE.get());

		simpleBlock(BlockRegistry.MOON_POLISHED_DEEPSLATE.get());
		stairsBlock(BlockRegistry.MOON_POLISHED_DEEPSLATE_STAIRS.get(), modLoc("block/moon_polished_deepslate"));
		slabBlock(BlockRegistry.MOON_POLISHED_DEEPSLATE_SLAB.get(), modLoc("block/moon_polished_deepslate"), modLoc("block/moon_polished_deepslate"));
		wallBlock(BlockRegistry.MOON_POLISHED_DEEPSLATE_WALL.get(), modLoc("block/moon_polished_deepslate"));

		simpleBlock(BlockRegistry.MOON_DEEPSLATE_BRICKS.get());
		stairsBlock(BlockRegistry.MOON_DEEPSLATE_BRICK_STAIRS.get(), modLoc("block/moon_deepslate_bricks"));
		slabBlock(BlockRegistry.MOON_DEEPSLATE_BRICK_SLAB.get(), modLoc("block/moon_deepslate_bricks"), modLoc("block/moon_deepslate_bricks"));
		wallBlock(BlockRegistry.MOON_DEEPSLATE_BRICK_WALL.get(), modLoc("block/moon_deepslate_bricks"));
		simpleBlock(BlockRegistry.CHISELED_MOON_DEEPSLATE_BRICKS.get());
		simpleBlock(BlockRegistry.CRACKED_MOON_DEEPSLATE_BRICKS.get());

		simpleBlock(BlockRegistry.MOON_DEEPSLATE_TILES.get());
		stairsBlock(BlockRegistry.MOON_DEEPSLATE_TILE_STAIRS.get(), modLoc("block/moon_deepslate_tiles"));
		slabBlock(BlockRegistry.MOON_DEEPSLATE_TILE_SLAB.get(), modLoc("block/moon_deepslate_tiles"), modLoc("block/moon_deepslate_tiles"));
		wallBlock(BlockRegistry.MOON_DEEPSLATE_TILE_WALL.get(), modLoc("block/moon_deepslate_tiles"));
		simpleBlock(BlockRegistry.CRACKED_MOON_DEEPSLATE_TILES.get());

		//ORES
		simpleBlock(BlockRegistry.MOON_IRON_ORE.get());
		simpleBlock(BlockRegistry.MOON_REDSTONE_ORE.get());
		simpleBlock(BlockRegistry.MOON_BAUXITE_ORE.get());
		simpleBlock(BlockRegistry.MOON_DEEPSLATE_IRON_ORE.get());
		simpleBlock(BlockRegistry.MOON_DEEPSLATE_REDSTONE_ORE.get());

		//OTHER
		simpleBlock(BlockRegistry.MOON_CORE.get());
		sandBlock(BlockRegistry.MOON_SAND.get());
		sandPathBlock(BlockRegistry.MOON_SAND_PATH.get(), "moon_sand");
		sandBlock(BlockRegistry.COARSE_MOON_SAND.get());
		simpleBlock(BlockRegistry.GLOWING_MOON_SAND.get());
		simpleBlock(BlockRegistry.LUNAR_LANTERN.get());
		portalBlock(BlockRegistry.MOON_PORTAL.get());

		//---- MARS -------------------------------------------------------------------------------
		//STONE
		varietyBlock(BlockRegistry.MARS_STONE.get());
		stairsBlock(BlockRegistry.MARS_STONE_STAIRS.get(), modLoc("block/mars_stone"));
		slabBlock(BlockRegistry.MARS_STONE_SLAB.get(), modLoc("block/mars_stone"), modLoc("block/mars_stone"));
		buttonBlock(BlockRegistry.MARS_STONE_BUTTON.get(), modLoc("block/mars_stone"));
		pressurePlateBlock(BlockRegistry.MARS_STONE_PRESSURE_PLATE.get(), modLoc("block/mars_stone"));

		simpleBlock(BlockRegistry.MARS_COBBLESTONE.get());
		stairsBlock(BlockRegistry.MARS_COBBLESTONE_STAIRS.get(), modLoc("block/mars_cobblestone"));
		slabBlock(BlockRegistry.MARS_COBBLESTONE_SLAB.get(), modLoc("block/mars_cobblestone"), modLoc("block/mars_cobblestone"));
		wallBlock(BlockRegistry.MARS_COBBLESTONE_WALL.get(), modLoc("block/mars_cobblestone"));
		simpleBlock(BlockRegistry.COMPRESSED_MARS_COBBLESTONE.get());
		simpleBlock(BlockRegistry.SUPER_COMPRESSED_MARS_COBBLESTONE.get());

		simpleBlock(BlockRegistry.MARS_BRICKS.get());
		stairsBlock(BlockRegistry.MARS_BRICK_STAIRS.get(), modLoc("block/mars_bricks"));
		slabBlock(BlockRegistry.MARS_BRICK_SLAB.get(), modLoc("block/mars_bricks"), modLoc("block/mars_bricks"));
		wallBlock(BlockRegistry.MARS_BRICK_WALL.get(), modLoc("block/mars_bricks"));
		simpleBlock(BlockRegistry.CHISELED_MARS_BRICKS.get());
		axisBlock(BlockRegistry.MARS_BRICK_PILLAR.get(), modLoc("block/mars_brick_pillar"));
		simpleBlock(BlockRegistry.CRACKED_MARS_BRICKS.get());

		simpleBlock(BlockRegistry.MARS_SMOOTH_STONE.get());
		smoothStoneSlabBlock(BlockRegistry.MARS_SMOOTH_STONE_SLAB.get(), "mars");

		//DEEPSLATE
		axisBlock((RotatedPillarBlock) BlockRegistry.MARS_DEEPSLATE.get());

		simpleBlock(BlockRegistry.MARS_COBBLED_DEEPSLATE.get());
		stairsBlock(BlockRegistry.MARS_COBBLED_DEEPSLATE_STAIRS.get(), modLoc("block/mars_cobbled_deepslate"));
		slabBlock(BlockRegistry.MARS_COBBLED_DEEPSLATE_SLAB.get(), modLoc("block/mars_cobbled_deepslate"), modLoc("block/mars_cobbled_deepslate"));
		wallBlock(BlockRegistry.MARS_COBBLED_DEEPSLATE_WALL.get(), modLoc("block/mars_cobbled_deepslate"));
		buttonBlock(BlockRegistry.MARS_DEEPSLATE_BUTTON.get(), modLoc("block/mars_deepslate_side"));
		pressurePlateBlock(BlockRegistry.MARS_DEEPSLATE_PRESSURE_PLATE.get(), modLoc("block/mars_deepslate_side"));
		simpleBlock(BlockRegistry.COMPRESSED_MARS_COBBLED_DEEPSLATE.get());
		simpleBlock(BlockRegistry.SUPER_COMPRESSED_MARS_COBBLED_DEEPSLATE.get());

		simpleBlock(BlockRegistry.MARS_POLISHED_DEEPSLATE.get());
		stairsBlock(BlockRegistry.MARS_POLISHED_DEEPSLATE_STAIRS.get(), modLoc("block/mars_polished_deepslate"));
		slabBlock(BlockRegistry.MARS_POLISHED_DEEPSLATE_SLAB.get(), modLoc("block/mars_polished_deepslate"), modLoc("block/mars_polished_deepslate"));
		wallBlock(BlockRegistry.MARS_POLISHED_DEEPSLATE_WALL.get(), modLoc("block/mars_polished_deepslate"));

		simpleBlock(BlockRegistry.MARS_DEEPSLATE_BRICKS.get());
		stairsBlock(BlockRegistry.MARS_DEEPSLATE_BRICK_STAIRS.get(), modLoc("block/mars_deepslate_bricks"));
		slabBlock(BlockRegistry.MARS_DEEPSLATE_BRICK_SLAB.get(), modLoc("block/mars_deepslate_bricks"), modLoc("block/mars_deepslate_bricks"));
		wallBlock(BlockRegistry.MARS_DEEPSLATE_BRICK_WALL.get(), modLoc("block/mars_deepslate_bricks"));
		simpleBlock(BlockRegistry.CHISELED_MARS_DEEPSLATE_BRICKS.get());
		simpleBlock(BlockRegistry.CRACKED_MARS_DEEPSLATE_BRICKS.get());

		simpleBlock(BlockRegistry.MARS_DEEPSLATE_TILES.get());
		stairsBlock(BlockRegistry.MARS_DEEPSLATE_TILE_STAIRS.get(), modLoc("block/mars_deepslate_tiles"));
		slabBlock(BlockRegistry.MARS_DEEPSLATE_TILE_SLAB.get(), modLoc("block/mars_deepslate_tiles"), modLoc("block/mars_deepslate_tiles"));
		wallBlock(BlockRegistry.MARS_DEEPSLATE_TILE_WALL.get(), modLoc("block/mars_deepslate_tiles"));
		simpleBlock(BlockRegistry.CRACKED_MARS_DEEPSLATE_TILES.get());

		//ORES
		simpleBlock(BlockRegistry.MARS_IRON_ORE.get());
		simpleBlock(BlockRegistry.MARS_REDSTONE_ORE.get());
		simpleBlock(BlockRegistry.MARS_BAUXITE_ORE.get());
		simpleBlock(BlockRegistry.MARS_DEEPSLATE_IRON_ORE.get());
		simpleBlock(BlockRegistry.MARS_DEEPSLATE_REDSTONE_ORE.get());

		//OTHER
		simpleBlock(BlockRegistry.MARS_CORE.get());
		simpleBlock(BlockRegistry.MARS_LANTERN.get());
		sandBlock(BlockRegistry.MARS_SAND.get());
		sandPathBlock(BlockRegistry.MARS_SAND_PATH.get(), "mars_sand");
		sandBlock(BlockRegistry.COARSE_MARS_SAND.get());
		portalBlock(BlockRegistry.MARS_PORTAL.get());


		//---- VENUS -------------------------------------------------------------------------------
		//STONE
		varietyBlock(BlockRegistry.VENUS_STONE.get());
		stairsBlock(BlockRegistry.VENUS_STONE_STAIRS.get(), modLoc("block/venus_stone"));
		slabBlock(BlockRegistry.VENUS_STONE_SLAB.get(), modLoc("block/venus_stone"), modLoc("block/venus_stone"));
		buttonBlock((ButtonBlock) BlockRegistry.VENUS_STONE_BUTTON.get(), modLoc("block/venus_stone"));
		pressurePlateBlock((PressurePlateBlock) BlockRegistry.VENUS_STONE_PRESSURE_PLATE.get(), modLoc("block/venus_stone"));

		simpleBlock(BlockRegistry.VENUS_COBBLESTONE.get());
		stairsBlock(BlockRegistry.VENUS_COBBLESTONE_STAIRS.get(), modLoc("block/venus_cobblestone"));
		slabBlock(BlockRegistry.VENUS_COBBLESTONE_SLAB.get(), modLoc("block/venus_cobblestone"), modLoc("block/venus_cobblestone"));
		wallBlock(BlockRegistry.VENUS_COBBLESTONE_WALL.get(), modLoc("block/venus_cobblestone"));
		simpleBlock(BlockRegistry.COMPRESSED_VENUS_COBBLESTONE.get());
		simpleBlock(BlockRegistry.SUPER_COMPRESSED_VENUS_COBBLESTONE.get());

		simpleBlock(BlockRegistry.VENUS_BRICKS.get());
		stairsBlock(BlockRegistry.VENUS_BRICK_STAIRS.get(), modLoc("block/venus_bricks"));
		slabBlock(BlockRegistry.VENUS_BRICK_SLAB.get(), modLoc("block/venus_bricks"), modLoc("block/venus_bricks"));
		wallBlock(BlockRegistry.VENUS_BRICK_WALL.get(), modLoc("block/venus_bricks"));
		simpleBlock(BlockRegistry.CHISELED_VENUS_BRICKS.get());
		axisBlock((RotatedPillarBlock) BlockRegistry.VENUS_BRICK_PILLAR.get(), modLoc("block/venus_brick_pillar"));
		simpleBlock(BlockRegistry.CRACKED_VENUS_BRICKS.get());

		simpleBlock(BlockRegistry.SMALL_VENUS_BRICKS.get());
		stairsBlock(BlockRegistry.SMALL_VENUS_BRICK_STAIRS.get(), modLoc("block/small_venus_bricks"));
		slabBlock(BlockRegistry.SMALL_VENUS_BRICK_SLAB.get(), modLoc("block/small_venus_bricks"), modLoc("block/small_venus_bricks"));
		wallBlock(BlockRegistry.SMALL_VENUS_BRICK_WALL.get(), modLoc("block/small_venus_bricks"));

		simpleBlock(BlockRegistry.VENUS_SMOOTH_STONE.get());
		smoothStoneSlabBlock(BlockRegistry.VENUS_SMOOTH_STONE_SLAB.get(), "venus");

		//DEEPSLATE
		axisBlock((RotatedPillarBlock) BlockRegistry.VENUS_DEEPSLATE.get());

		simpleBlock(BlockRegistry.VENUS_COBBLED_DEEPSLATE.get());
		stairsBlock(BlockRegistry.VENUS_COBBLED_DEEPSLATE_STAIRS.get(), modLoc("block/venus_cobbled_deepslate"));
		slabBlock(BlockRegistry.VENUS_COBBLED_DEEPSLATE_SLAB.get(), modLoc("block/venus_cobbled_deepslate"), modLoc("block/venus_cobbled_deepslate"));
		wallBlock(BlockRegistry.VENUS_COBBLED_DEEPSLATE_WALL.get(), modLoc("block/venus_cobbled_deepslate"));
		buttonBlock((ButtonBlock) BlockRegistry.VENUS_DEEPSLATE_BUTTON.get(), modLoc("block/venus_deepslate_side"));
		pressurePlateBlock((PressurePlateBlock) BlockRegistry.VENUS_DEEPSLATE_PRESSURE_PLATE.get(), modLoc("block/venus_deepslate_side"));
		simpleBlock(BlockRegistry.COMPRESSED_VENUS_COBBLED_DEEPSLATE.get());
		simpleBlock(BlockRegistry.SUPER_COMPRESSED_VENUS_COBBLED_DEEPSLATE.get());

		simpleBlock(BlockRegistry.VENUS_POLISHED_DEEPSLATE.get());
		stairsBlock(BlockRegistry.VENUS_POLISHED_DEEPSLATE_STAIRS.get(), modLoc("block/venus_polished_deepslate"));
		slabBlock(BlockRegistry.VENUS_POLISHED_DEEPSLATE_SLAB.get(), modLoc("block/venus_polished_deepslate"), modLoc("block/venus_polished_deepslate"));
		wallBlock(BlockRegistry.VENUS_POLISHED_DEEPSLATE_WALL.get(), modLoc("block/venus_polished_deepslate"));

		simpleBlock(BlockRegistry.VENUS_DEEPSLATE_BRICKS.get());
		stairsBlock(BlockRegistry.VENUS_DEEPSLATE_BRICK_STAIRS.get(), modLoc("block/venus_deepslate_bricks"));
		slabBlock(BlockRegistry.VENUS_DEEPSLATE_BRICK_SLAB.get(), modLoc("block/venus_deepslate_bricks"), modLoc("block/venus_deepslate_bricks"));
		wallBlock(BlockRegistry.VENUS_DEEPSLATE_BRICK_WALL.get(), modLoc("block/venus_deepslate_bricks"));
		simpleBlock(BlockRegistry.CHISELED_VENUS_DEEPSLATE_BRICKS.get());
		simpleBlock(BlockRegistry.CRACKED_VENUS_DEEPSLATE_BRICKS.get());

		simpleBlock(BlockRegistry.VENUS_DEEPSLATE_TILES.get());
		stairsBlock(BlockRegistry.VENUS_DEEPSLATE_TILE_STAIRS.get(), modLoc("block/venus_deepslate_tiles"));
		slabBlock(BlockRegistry.VENUS_DEEPSLATE_TILE_SLAB.get(), modLoc("block/venus_deepslate_tiles"), modLoc("block/venus_deepslate_tiles"));
		wallBlock(BlockRegistry.VENUS_DEEPSLATE_TILE_WALL.get(), modLoc("block/venus_deepslate_tiles"));
		simpleBlock(BlockRegistry.CRACKED_VENUS_DEEPSLATE_TILES.get());

		//ORES
		simpleBlock(BlockRegistry.VENUS_IRON_ORE.get());
		simpleBlock(BlockRegistry.VENUS_REDSTONE_ORE.get());
		simpleBlock(BlockRegistry.VENUS_BAUXITE_ORE.get());
		simpleBlock(BlockRegistry.VENUS_LAPIS_ORE.get());
		simpleBlock(BlockRegistry.VENUS_DEEPSLATE_LAPIS_ORE.get());
		simpleBlock(BlockRegistry.VENUS_DEEPSLATE_IRON_ORE.get());
		simpleBlock(BlockRegistry.VENUS_DEEPSLATE_REDSTONE_ORE.get());

		//OTHER
		simpleBlock(BlockRegistry.VENUS_CORE.get());
		simpleBlock(BlockRegistry.FINE_VENUS_SAND.get());
		simpleBlock(BlockRegistry.SULFURIC_OBSIDIAN.get());
		simpleBlock(BlockRegistry.VENUS_LANTERN.get());

		sandBlock(BlockRegistry.VENUS_SAND.get());
		sandPathBlock(BlockRegistry.VENUS_SAND_PATH.get(), "venus_sand");
		portalBlock(BlockRegistry.VENUS_PORTAL.get());


		//---- MERCURY -------------------------------------------------------------------------------
		//STONE
		varietyBlock(BlockRegistry.MERCURY_STONE.get());
		stairsBlock(BlockRegistry.MERCURY_STONE_STAIRS.get(), modLoc("block/mercury_stone"));
		slabBlock(BlockRegistry.MERCURY_STONE_SLAB.get(), modLoc("block/mercury_stone"), modLoc("block/mercury_stone"));
		buttonBlock(BlockRegistry.MERCURY_STONE_BUTTON.get(), modLoc("block/mercury_stone"));
		pressurePlateBlock(BlockRegistry.MERCURY_STONE_PRESSURE_PLATE.get(), modLoc("block/mercury_stone"));

		simpleBlock(BlockRegistry.MERCURY_COBBLESTONE.get());
		stairsBlock(BlockRegistry.MERCURY_COBBLESTONE_STAIRS.get(), modLoc("block/mercury_cobblestone"));
		slabBlock(BlockRegistry.MERCURY_COBBLESTONE_SLAB.get(), modLoc("block/mercury_cobblestone"), modLoc("block/mercury_cobblestone"));
		wallBlock(BlockRegistry.MERCURY_COBBLESTONE_WALL.get(), modLoc("block/mercury_cobblestone"));
		simpleBlock(BlockRegistry.COMPRESSED_MERCURY_COBBLESTONE.get());
		simpleBlock(BlockRegistry.SUPER_COMPRESSED_MERCURY_COBBLESTONE.get());

		simpleBlock(BlockRegistry.MERCURY_BRICKS.get());
		stairsBlock(BlockRegistry.MERCURY_BRICK_STAIRS.get(), modLoc("block/mercury_bricks"));
		slabBlock(BlockRegistry.MERCURY_BRICK_SLAB.get(), modLoc("block/mercury_bricks"), modLoc("block/mercury_bricks"));
		wallBlock(BlockRegistry.MERCURY_BRICK_WALL.get(), modLoc("block/mercury_bricks"));
		simpleBlock(BlockRegistry.CHISELED_MERCURY_BRICKS.get());
		axisBlock(BlockRegistry.MERCURY_BRICK_PILLAR.get(), modLoc("block/mercury_brick_pillar"));
		simpleBlock(BlockRegistry.CRACKED_MERCURY_BRICKS.get());

		simpleBlock(BlockRegistry.MERCURY_SMOOTH_STONE.get());
		smoothStoneSlabBlock(BlockRegistry.MERCURY_SMOOTH_STONE_SLAB.get(), "mercury");

		//DEEPSLATE
		axisBlock(BlockRegistry.MERCURY_DEEPSLATE.get());

		simpleBlock(BlockRegistry.MERCURY_COBBLED_DEEPSLATE.get());
		stairsBlock(BlockRegistry.MERCURY_COBBLED_DEEPSLATE_STAIRS.get(), modLoc("block/mercury_cobbled_deepslate"));
		slabBlock(BlockRegistry.MERCURY_COBBLED_DEEPSLATE_SLAB.get(), modLoc("block/mercury_cobbled_deepslate"), modLoc("block/mercury_cobbled_deepslate"));
		wallBlock(BlockRegistry.MERCURY_COBBLED_DEEPSLATE_WALL.get(), modLoc("block/mercury_cobbled_deepslate"));
		buttonBlock(BlockRegistry.MERCURY_DEEPSLATE_BUTTON.get(), modLoc("block/mercury_deepslate_side"));
		pressurePlateBlock(BlockRegistry.MERCURY_DEEPSLATE_PRESSURE_PLATE.get(), modLoc("block/mercury_deepslate_side"));
		simpleBlock(BlockRegistry.COMPRESSED_MERCURY_COBBLED_DEEPSLATE.get());
		simpleBlock(BlockRegistry.SUPER_COMPRESSED_MERCURY_COBBLED_DEEPSLATE.get());

		simpleBlock(BlockRegistry.MERCURY_POLISHED_DEEPSLATE.get());
		stairsBlock(BlockRegistry.MERCURY_POLISHED_DEEPSLATE_STAIRS.get(), modLoc("block/mercury_polished_deepslate"));
		slabBlock(BlockRegistry.MERCURY_POLISHED_DEEPSLATE_SLAB.get(), modLoc("block/mercury_polished_deepslate"), modLoc("block/mercury_polished_deepslate"));
		wallBlock(BlockRegistry.MERCURY_POLISHED_DEEPSLATE_WALL.get(), modLoc("block/mercury_polished_deepslate"));

		simpleBlock(BlockRegistry.MERCURY_DEEPSLATE_BRICKS.get());
		stairsBlock(BlockRegistry.MERCURY_DEEPSLATE_BRICK_STAIRS.get(), modLoc("block/mercury_deepslate_bricks"));
		slabBlock(BlockRegistry.MERCURY_DEEPSLATE_BRICK_SLAB.get(), modLoc("block/mercury_deepslate_bricks"), modLoc("block/mercury_deepslate_bricks"));
		wallBlock(BlockRegistry.MERCURY_DEEPSLATE_BRICK_WALL.get(), modLoc("block/mercury_deepslate_bricks"));
		simpleBlock(BlockRegistry.CHISELED_MERCURY_DEEPSLATE_BRICKS.get());
		simpleBlock(BlockRegistry.CRACKED_MERCURY_DEEPSLATE_BRICKS.get());

		simpleBlock(BlockRegistry.MERCURY_DEEPSLATE_TILES.get());
		stairsBlock(BlockRegistry.MERCURY_DEEPSLATE_TILE_STAIRS.get(), modLoc("block/mercury_deepslate_tiles"));
		slabBlock(BlockRegistry.MERCURY_DEEPSLATE_TILE_SLAB.get(), modLoc("block/mercury_deepslate_tiles"), modLoc("block/mercury_deepslate_tiles"));
		wallBlock(BlockRegistry.MERCURY_DEEPSLATE_TILE_WALL.get(), modLoc("block/mercury_deepslate_tiles"));
		simpleBlock(BlockRegistry.CRACKED_MERCURY_DEEPSLATE_TILES.get());

		//ORES
		simpleBlock(BlockRegistry.MERCURY_BAUXITE_ORE.get());
		simpleBlock(BlockRegistry.MERCURY_SULFUR_ORE.get());
		simpleBlock(BlockRegistry.MERCURY_COAL_ORE.get());
		simpleBlock(BlockRegistry.MERCURY_DIAMOND_ORE.get());
		simpleBlock(BlockRegistry.MERCURY_DEEPSLATE_DIAMOND_ORE.get());
		simpleBlock(BlockRegistry.MERCURY_DEEPSLATE_IRON_ORE.get());
		simpleBlock(BlockRegistry.MERCURY_DEEPSLATE_COAL_ORE.get());
		simpleBlock(BlockRegistry.MERCURY_DEEPSLATE_REDSTONE_ORE.get());

		//OTHER
		simpleBlock(BlockRegistry.MERCURY_CORE.get());
		simpleBlock(BlockRegistry.MERCURY_LANTERN.get());

		sandBlock(BlockRegistry.MERCURY_SAND.get());
		sandPathBlock(BlockRegistry.MERCURY_SAND_PATH.get(), "mercury_sand");
		sandBlock(BlockRegistry.COARSE_MERCURY_SAND.get());
		portalBlock(BlockRegistry.MERCURY_PORTAL.get());


		//---- JUPITER -------------------------------------------------------------------------------
		//DEEPSLATE
		axisBlock(BlockRegistry.JUPITER_DEEPSLATE.get());

		simpleBlock(BlockRegistry.JUPITER_COBBLED_DEEPSLATE.get());
		stairsBlock(BlockRegistry.JUPITER_COBBLED_DEEPSLATE_STAIRS.get(), modLoc("block/jupiter_cobbled_deepslate"));
		slabBlock(BlockRegistry.JUPITER_COBBLED_DEEPSLATE_SLAB.get(), modLoc("block/jupiter_cobbled_deepslate"), modLoc("block/jupiter_cobbled_deepslate"));
		wallBlock(BlockRegistry.JUPITER_COBBLED_DEEPSLATE_WALL.get(), modLoc("block/jupiter_cobbled_deepslate"));
		buttonBlock(BlockRegistry.JUPITER_DEEPSLATE_BUTTON.get(), modLoc("block/jupiter_deepslate_side"));
		pressurePlateBlock(BlockRegistry.JUPITER_DEEPSLATE_PRESSURE_PLATE.get(), modLoc("block/jupiter_deepslate_side"));
		simpleBlock(BlockRegistry.COMPRESSED_JUPITER_COBBLED_DEEPSLATE.get());
		simpleBlock(BlockRegistry.SUPER_COMPRESSED_JUPITER_COBBLED_DEEPSLATE.get());

		simpleBlock(BlockRegistry.JUPITER_POLISHED_DEEPSLATE.get());
		stairsBlock(BlockRegistry.JUPITER_POLISHED_DEEPSLATE_STAIRS.get(), modLoc("block/jupiter_polished_deepslate"));
		slabBlock(BlockRegistry.JUPITER_POLISHED_DEEPSLATE_SLAB.get(), modLoc("block/jupiter_polished_deepslate"), modLoc("block/jupiter_polished_deepslate"));
		wallBlock(BlockRegistry.JUPITER_POLISHED_DEEPSLATE_WALL.get(), modLoc("block/jupiter_polished_deepslate"));

		simpleBlock(BlockRegistry.JUPITER_DEEPSLATE_BRICKS.get());
		stairsBlock(BlockRegistry.JUPITER_DEEPSLATE_BRICK_STAIRS.get(), modLoc("block/jupiter_deepslate_bricks"));
		slabBlock(BlockRegistry.JUPITER_DEEPSLATE_BRICK_SLAB.get(), modLoc("block/jupiter_deepslate_bricks"), modLoc("block/jupiter_deepslate_bricks"));
		wallBlock(BlockRegistry.JUPITER_DEEPSLATE_BRICK_WALL.get(), modLoc("block/jupiter_deepslate_bricks"));
		simpleBlock(BlockRegistry.CHISELED_JUPITER_DEEPSLATE_BRICKS.get());
		simpleBlock(BlockRegistry.CRACKED_JUPITER_DEEPSLATE_BRICKS.get());

		simpleBlock(BlockRegistry.JUPITER_DEEPSLATE_TILES.get());
		stairsBlock(BlockRegistry.JUPITER_DEEPSLATE_TILE_STAIRS.get(), modLoc("block/jupiter_deepslate_tiles"));
		slabBlock(BlockRegistry.JUPITER_DEEPSLATE_TILE_SLAB.get(), modLoc("block/jupiter_deepslate_tiles"), modLoc("block/jupiter_deepslate_tiles"));
		wallBlock(BlockRegistry.JUPITER_DEEPSLATE_TILE_WALL.get(), modLoc("block/jupiter_deepslate_tiles"));
		simpleBlock(BlockRegistry.CRACKED_JUPITER_DEEPSLATE_TILES.get());

		//OTHER
		simpleBlock(BlockRegistry.JUPITER_CORE.get());
		simpleBlock(BlockRegistry.JUPITER_ATMOSPHERE.get());
		simpleBlock(BlockRegistry.JUPITER_LANTERN.get());
		portalBlock(BlockRegistry.JUPITER_PORTAL.get());

		//---- JUPITER MOONS -------------------------------------------------------------------------------
		//---- IO -------------------------------------------------------------------------------
		//STONE
		varietyBlock(BlockRegistry.IO_STONE.get());
		stairsBlock(BlockRegistry.IO_STONE_STAIRS.get(), modLoc("block/io_stone"));
		slabBlock(BlockRegistry.IO_STONE_SLAB.get(), modLoc("block/io_stone"), modLoc("block/io_stone"));
		buttonBlock(BlockRegistry.IO_STONE_BUTTON.get(), modLoc("block/io_stone"));
		pressurePlateBlock(BlockRegistry.IO_STONE_PRESSURE_PLATE.get(), modLoc("block/io_stone"));

		simpleBlock(BlockRegistry.IO_COBBLESTONE.get());
		stairsBlock(BlockRegistry.IO_COBBLESTONE_STAIRS.get(), modLoc("block/io_cobblestone"));
		slabBlock(BlockRegistry.IO_COBBLESTONE_SLAB.get(), modLoc("block/io_cobblestone"), modLoc("block/io_cobblestone"));
		wallBlock(BlockRegistry.IO_COBBLESTONE_WALL.get(), modLoc("block/io_cobblestone"));
		simpleBlock(BlockRegistry.COMPRESSED_IO_COBBLESTONE.get());
		simpleBlock(BlockRegistry.SUPER_COMPRESSED_IO_COBBLESTONE.get());

		simpleBlock(BlockRegistry.IO_BRICKS.get());
		stairsBlock(BlockRegistry.IO_BRICK_STAIRS.get(), modLoc("block/io_bricks"));
		slabBlock(BlockRegistry.IO_BRICK_SLAB.get(), modLoc("block/io_bricks"), modLoc("block/io_bricks"));
		wallBlock(BlockRegistry.IO_BRICK_WALL.get(), modLoc("block/io_bricks"));
		simpleBlock(BlockRegistry.CHISELED_IO_BRICKS.get());
		axisBlock(BlockRegistry.IO_BRICK_PILLAR.get(), modLoc("block/io_brick_pillar"));
		simpleBlock(BlockRegistry.CRACKED_IO_BRICKS.get());

		simpleBlock(BlockRegistry.IO_SMOOTH_STONE.get());
		smoothStoneSlabBlock(BlockRegistry.IO_SMOOTH_STONE_SLAB.get(), "io");

		//DEEPSLATE
		axisBlock(BlockRegistry.IO_DEEPSLATE.get());

		simpleBlock(BlockRegistry.IO_COBBLED_DEEPSLATE.get());
		stairsBlock(BlockRegistry.IO_COBBLED_DEEPSLATE_STAIRS.get(), modLoc("block/io_cobbled_deepslate"));
		slabBlock(BlockRegistry.IO_COBBLED_DEEPSLATE_SLAB.get(), modLoc("block/io_cobbled_deepslate"), modLoc("block/io_cobbled_deepslate"));
		wallBlock(BlockRegistry.IO_COBBLED_DEEPSLATE_WALL.get(), modLoc("block/io_cobbled_deepslate"));
		buttonBlock(BlockRegistry.IO_DEEPSLATE_BUTTON.get(), modLoc("block/io_deepslate_side"));
		pressurePlateBlock(BlockRegistry.IO_DEEPSLATE_PRESSURE_PLATE.get(), modLoc("block/io_deepslate_side"));
		simpleBlock(BlockRegistry.COMPRESSED_IO_COBBLED_DEEPSLATE.get());
		simpleBlock(BlockRegistry.SUPER_COMPRESSED_IO_COBBLED_DEEPSLATE.get());

		simpleBlock(BlockRegistry.IO_POLISHED_DEEPSLATE.get());
		stairsBlock(BlockRegistry.IO_POLISHED_DEEPSLATE_STAIRS.get(), modLoc("block/io_polished_deepslate"));
		slabBlock(BlockRegistry.IO_POLISHED_DEEPSLATE_SLAB.get(), modLoc("block/io_polished_deepslate"), modLoc("block/io_polished_deepslate"));
		wallBlock(BlockRegistry.IO_POLISHED_DEEPSLATE_WALL.get(), modLoc("block/io_polished_deepslate"));

		simpleBlock(BlockRegistry.IO_DEEPSLATE_BRICKS.get());
		stairsBlock(BlockRegistry.IO_DEEPSLATE_BRICK_STAIRS.get(), modLoc("block/io_deepslate_bricks"));
		slabBlock(BlockRegistry.IO_DEEPSLATE_BRICK_SLAB.get(), modLoc("block/io_deepslate_bricks"), modLoc("block/io_deepslate_bricks"));
		wallBlock(BlockRegistry.IO_DEEPSLATE_BRICK_WALL.get(), modLoc("block/io_deepslate_bricks"));
		simpleBlock(BlockRegistry.CHISELED_IO_DEEPSLATE_BRICKS.get());
		simpleBlock(BlockRegistry.CRACKED_IO_DEEPSLATE_BRICKS.get());

		simpleBlock(BlockRegistry.IO_DEEPSLATE_TILES.get());
		stairsBlock(BlockRegistry.IO_DEEPSLATE_TILE_STAIRS.get(), modLoc("block/io_deepslate_tiles"));
		slabBlock(BlockRegistry.IO_DEEPSLATE_TILE_SLAB.get(), modLoc("block/io_deepslate_tiles"), modLoc("block/io_deepslate_tiles"));
		wallBlock(BlockRegistry.IO_DEEPSLATE_TILE_WALL.get(), modLoc("block/io_deepslate_tiles"));
		simpleBlock(BlockRegistry.CRACKED_IO_DEEPSLATE_TILES.get());

		//ORES
		simpleBlock(BlockRegistry.IO_SULFUR_ORE.get());
		simpleBlock(BlockRegistry.IO_LAPIS_ORE.get());
		simpleBlock(BlockRegistry.IO_DEEPSLATE_LAPIS_ORE.get());
		simpleBlock(BlockRegistry.IO_DEEPSLATE_IRON_ORE.get());

		//OTHER
		simpleBlock(BlockRegistry.IO_CORE.get());
		simpleBlock(BlockRegistry.IO_LANTERN.get());
		simpleBlock(BlockRegistry.GLOWING_IO_SAND.get());
		sandBlock(BlockRegistry.IO_SAND.get());
		sandBlock(BlockRegistry.COARSE_IO_SAND.get());
		sandPathBlock(BlockRegistry.IO_SAND_PATH.get(), "io_sand");
		portalBlock(BlockRegistry.IO_PORTAL.get());


		//---- EUROPA -------------------------------------------------------------------------------
		simpleBlock(BlockRegistry.EUROPA_CORE.get());
		simpleBlock(BlockRegistry.EUROPA_HYDRATE.get());

		//EUROPA
		simpleBlock(BlockRegistry.EUROPA_BRICKS.get());
		stairsBlock(BlockRegistry.EUROPA_BRICK_STAIRS.get(), modLoc("block/europa_bricks"));
		slabBlock(BlockRegistry.EUROPA_BRICK_SLAB.get(), modLoc("block/europa_bricks"), modLoc("block/europa_bricks"));
		wallBlock(BlockRegistry.EUROPA_BRICK_WALL.get(), modLoc("block/europa_bricks"));
		simpleBlock(BlockRegistry.CHISELED_EUROPA_BRICKS.get());
//		axisBlock(BlockRegistry.EUROPA_BRICK_PILLAR.get(), modLoc("block/europa_brick_pillar"));
//		simpleBlock(BlockRegistry.CRACKED_EUROPA_BRICKS.get());
		simpleBlock(BlockRegistry.GLOWING_EUROPA_SAND.get());
		simpleBlock(BlockRegistry.EUROPA_LANTERN.get());
		portalBlock(BlockRegistry.EUROPA_PORTAL.get());


		//---- GANYMEDE -------------------------------------------------------------------------------
		simpleBlock(BlockRegistry.GANYMEDE_CORE.get());
		simpleBlock(BlockRegistry.GANYMEDE_BRICKS.get());
		stairsBlock(BlockRegistry.GANYMEDE_BRICK_STAIRS.get(), modLoc("block/ganymede_bricks"));
		slabBlock(BlockRegistry.GANYMEDE_BRICK_SLAB.get(), modLoc("block/ganymede_bricks"), modLoc("block/ganymede_bricks"));
		wallBlock(BlockRegistry.GANYMEDE_BRICK_WALL.get(), modLoc("block/ganymede_bricks"));
		simpleBlock(BlockRegistry.CHISELED_GANYMEDE_BRICKS.get());
//		axisBlock(BlockRegistry.GANYMEDE_BRICK_PILLAR.get(), modLoc("block/ganymede_brick_pillar"));
//		simpleBlock(BlockRegistry.CRACKED_GANYMEDE_BRICKS.get());
		simpleBlock(BlockRegistry.GLOWING_GANYMEDE_SAND.get());
		simpleBlock(BlockRegistry.GANYMEDE_LANTERN.get());
//		portalBlock(BlockRegistry.GANYMEDE_PORTAL.get());

		//---- CALLISTO -------------------------------------------------------------------------------

		//CALLISTO
		simpleBlock(BlockRegistry.CALLISTO_CORE.get());
		simpleBlock(BlockRegistry.CALLISTO_BRICKS.get());
		stairsBlock(BlockRegistry.CALLISTO_BRICK_STAIRS.get(), modLoc("block/callisto_bricks"));
		slabBlock(BlockRegistry.CALLISTO_BRICK_SLAB.get(), modLoc("block/callisto_bricks"), modLoc("block/callisto_bricks"));
		wallBlock(BlockRegistry.CALLISTO_BRICK_WALL.get(), modLoc("block/callisto_bricks"));
		simpleBlock(BlockRegistry.CHISELED_CALLISTO_BRICKS.get());
//		axisBlock(BlockRegistry.CALLISTO_BRICK_PILLAR.get(), modLoc("block/callisto_brick_pillar"));
//		simpleBlock(BlockRegistry.CRACKED_CALLISTO_BRICKS.get());
		simpleBlock(BlockRegistry.GLOWING_CALLISTO_SAND.get());
		simpleBlock(BlockRegistry.CALLISTO_LANTERN.get());
		portalBlock(BlockRegistry.CALLISTO_PORTAL.get());

		//---- OTHER PLANETS -------------------------------------------------------------------------------

		//SATURN
		simpleBlock(BlockRegistry.SATURN_ATMOSPHERE.get());
		simpleBlock(BlockRegistry.SATURN_CORE.get());
		axisBlock((RotatedPillarBlock) BlockRegistry.SATURN_DEEPSLATE.get());

		simpleBlock(BlockRegistry.TITAN_CORE.get());
		simpleBlock(BlockRegistry.ENCELADUS_CORE.get());
		simpleBlock(BlockRegistry.RHEA_CORE.get());
		simpleBlock(BlockRegistry.IAPETUS_CORE.get());
		simpleBlock(BlockRegistry.DIONE_CORE.get());
		simpleBlock(BlockRegistry.HYPERION_CORE.get());

		//URANUS
		simpleBlock(BlockRegistry.URANUS_ATMOSPHERE.get());
		simpleBlock(BlockRegistry.URANUS_CORE.get());
		axisBlock((RotatedPillarBlock) BlockRegistry.URANUS_DEEPSLATE.get());

		simpleBlock(BlockRegistry.TITANIA_CORE.get());
		simpleBlock(BlockRegistry.OBERON_CORE.get());

		//NEPTUNE
		simpleBlock(BlockRegistry.NEPTUNE_ATMOSPHERE.get());
		simpleBlock(BlockRegistry.NEPTUNE_CORE.get());
		axisBlock((RotatedPillarBlock) BlockRegistry.NEPTUNE_DEEPSLATE.get());

		simpleBlock(BlockRegistry.TRITON_CORE.get());

		//DWARF PLANETS/OTHER
//		simpleBlock(BlockRegistry.PLUTO_CORE.get());
//		simpleBlock(BlockRegistry.CERES_CORE.get());
//		simpleBlock(BlockRegistry.ERIS_CORE.get());
//		simpleBlock(BlockRegistry.HAUMEA_CORE.get());
//		simpleBlock(BlockRegistry.MAKEMAKE_CORE.get());

		//---- CELESTIAL OBJECTS -------------------------------------------------------------------------------
		//METEOR
		simpleBlock(BlockRegistry.METEOR.get());
		simpleBlock(BlockRegistry.METEOR_BRICKS.get());
		simpleBlock(BlockRegistry.CHISELED_METEOR_BRICKS.get());
		stairsBlock((StairBlock) BlockRegistry.METEOR_BRICK_STAIRS.get(), modLoc("block/meteor_bricks"));
		slabBlock((SlabBlock) BlockRegistry.METEOR_BRICK_SLAB.get(), modLoc("block/meteor_bricks"), modLoc("block/meteor_bricks"));
		wallBlock((WallBlock) BlockRegistry.METEOR_BRICK_WALL.get(), modLoc("block/meteor_bricks"));
		buttonBlock((ButtonBlock) BlockRegistry.METEOR_BUTTON.get(), modLoc("block/meteor"));
		pressurePlateBlock((PressurePlateBlock) BlockRegistry.METEOR_PRESSURE_PLATE.get(), modLoc("block/meteor"));

		//METEOR ORES
		simpleBlock(BlockRegistry.METEOR_COAL_ORE.get());
		simpleBlock(BlockRegistry.METEOR_COPPER_ORE.get());
		simpleBlock(BlockRegistry.METEOR_DIAMOND_ORE.get());
		simpleBlock(BlockRegistry.METEOR_EMERALD_ORE.get());
		simpleBlock(BlockRegistry.METEOR_GOLD_ORE.get());
		simpleBlock(BlockRegistry.METEOR_IRON_ORE.get());
		simpleBlock(BlockRegistry.METEOR_LAPIS_ORE.get());
		simpleBlock(BlockRegistry.METEOR_SULFUR_ORE.get());
		simpleBlock(BlockRegistry.METEOR_BAUXITE_ORE.get());
		simpleBlock(BlockRegistry.METEOR_REDSTONE_ORE.get());

		//SUN
		simpleBlock(BlockRegistry.SOLAR_PLASMA.get());
		simpleBlock(BlockRegistry.SOLAR_FLARE.get());
		simpleBlock(BlockRegistry.SUN_SPOT.get());


		//---- ORE-RELATED -------------------------------------------------------------------------------
		simpleBlock(BlockRegistry.STEEL_BLOCK.get());
		simpleBlock(BlockRegistry.ALUMINUM_BLOCK.get());


		//---- SPACE STATION -------------------------------------------------------------------------------
		doorBlock(BlockRegistry.AIRLOCK_DOOR.get(), modLoc("block/airlock_door_bottom"), modLoc("block/airlock_door_top"));
		doorBlock(BlockRegistry.STEEL_DOOR.get(), modLoc("block/steel_door_bottom"), modLoc("block/steel_door_top"));
		trapdoorBlock(BlockRegistry.AIRLOCK_TRAPDOOR.get(), modLoc("block/airlock_trapdoor"), true);
		trapdoorBlock(BlockRegistry.STEEL_TRAPDOOR.get(), modLoc("block/steel_trapdoor"), true);
		buttonBlock(BlockRegistry.STEEL_BUTTON.get(), modLoc("block/steel_block"));
		buttonBlock(BlockRegistry.AIRLOCK_BUTTON.get(), modLoc("block/airlock_button"), modLoc("block/airlock_button_pressed"));

		simpleBlock(BlockRegistry.PANEL.get());
		paneBlock((BlockRegistry.THIN_PANEL.get()), modLoc("block/panel"), modLoc("block/thin_panel_top"));
		stairsBlock(BlockRegistry.PANEL_STAIRS.get(), modLoc("block/panel"));
		slabBlock(BlockRegistry.PANEL_SLAB.get(), modLoc("block/panel"), modLoc("block/panel"));
		wallBlock(BlockRegistry.PANEL_WALL.get(), modLoc("block/panel"));

		buttonBlock(BlockRegistry.RED_BUTTON.get(), mcLoc("block/red_stained_glass"), modLoc("block/red_button_pressed"));
		buttonBlock(BlockRegistry.YELLOW_BUTTON.get(), mcLoc("block/yellow_stained_glass"), modLoc("block/yellow_button_pressed"));
		buttonBlock(BlockRegistry.BLUE_BUTTON.get(), mcLoc("block/blue_stained_glass"), modLoc("block/blue_button_pressed"));
		buttonBlock(BlockRegistry.GREEN_BUTTON.get(), mcLoc("block/green_stained_glass"), modLoc("block/green_button_pressed"));
		buttonBlock(BlockRegistry.WHITE_BUTTON.get(), mcLoc("block/white_stained_glass"), modLoc("block/white_button_pressed"));
		buttonBlock(BlockRegistry.BLACK_BUTTON.get(), mcLoc("block/black_stained_glass"), modLoc("block/black_button_pressed"));

		//---- GLASS/CERAMICS -------------------------------------------------------------------------------
		//GLASS
		simpleBlock(BlockRegistry.LUMINOUS_BLUE_GLASS.get());
		simpleBlock(BlockRegistry.LUMINOUS_WHITE_GLASS.get());
		simpleBlock(BlockRegistry.LUMINOUS_CYAN_GLASS.get());
		simpleBlock(BlockRegistry.LUMINOUS_MAGENTA_GLASS.get());
		simpleBlock(BlockRegistry.LUMINOUS_YELLOW_GLASS.get());
		simpleBlock(BlockRegistry.LUMINOUS_RED_GLASS.get());

		paneBlock(BlockRegistry.LUMINOUS_MAGENTA_GLASS_PANE.get(), modLoc("block/luminous_magenta_glass"), mcLoc("block/magenta_stained_glass_pane_top"));
		paneBlock(BlockRegistry.LUMINOUS_BLUE_GLASS_PANE.get(), modLoc("block/luminous_blue_glass"), modLoc("block/luminous_blue_glass_pane_top"));
		paneBlock(BlockRegistry.LUMINOUS_CYAN_GLASS_PANE.get(), modLoc("block/luminous_cyan_glass"), modLoc("block/luminous_cyan_glass_pane_top"));
		paneBlock(BlockRegistry.LUMINOUS_WHITE_GLASS_PANE.get(), modLoc("block/luminous_white_glass"), modLoc("block/luminous_white_glass_pane_top"));
		paneBlock(BlockRegistry.LUMINOUS_YELLOW_GLASS_PANE.get(), modLoc("block/luminous_yellow_glass"), modLoc("block/luminous_yellow_glass_pane_top"));
		paneBlock(BlockRegistry.LUMINOUS_RED_GLASS_PANE.get(), modLoc("block/luminous_red_glass"), modLoc("block/luminous_red_glass_pane_top"));

		//CERAMIC
		simpleBlock(BlockRegistry.SILICA.get());

		simpleBlock(BlockRegistry.CERAMIC.get());
		paneBlock(BlockRegistry.CERAMIC_TILE.get(), modLoc("block/ceramic"), modLoc("block/ceramic_tile_top"));

		simpleBlock(BlockRegistry.WHITE_CERAMIC.get());
		paneBlock(BlockRegistry.WHITE_CERAMIC_TILE.get(), modLoc("block/white_ceramic"), modLoc("block/white_ceramic_tile_top"));
		simpleBlock(BlockRegistry.LIGHT_GREY_CERAMIC.get());
		paneBlock(BlockRegistry.LIGHT_GREY_CERAMIC_TILE.get(), modLoc("block/light_grey_ceramic"), modLoc("block/light_grey_ceramic_tile_top"));
		simpleBlock(BlockRegistry.GREY_CERAMIC.get());
		paneBlock(BlockRegistry.GREY_CERAMIC_TILE.get(), modLoc("block/grey_ceramic"), modLoc("block/grey_ceramic_tile_top"));
		simpleBlock(BlockRegistry.BLACK_CERAMIC.get());
		paneBlock(BlockRegistry.BLACK_CERAMIC_TILE.get(), modLoc("block/black_ceramic"), modLoc("block/black_ceramic_tile_top"));
		simpleBlock(BlockRegistry.PURPLE_CERAMIC.get());
		paneBlock(BlockRegistry.PURPLE_CERAMIC_TILE.get(), modLoc("block/purple_ceramic"), modLoc("block/purple_ceramic_tile_top"));
		simpleBlock(BlockRegistry.MAGENTA_CERAMIC.get());
		paneBlock(BlockRegistry.MAGENTA_CERAMIC_TILE.get(), modLoc("block/magenta_ceramic"), modLoc("block/magenta_ceramic_tile_top"));
		simpleBlock(BlockRegistry.BLUE_CERAMIC.get());
		paneBlock(BlockRegistry.BLUE_CERAMIC_TILE.get(), modLoc("block/blue_ceramic"), modLoc("block/blue_ceramic_tile_top"));
		simpleBlock(BlockRegistry.LIGHT_BLUE_CERAMIC.get());
		paneBlock(BlockRegistry.LIGHT_BLUE_CERAMIC_TILE.get(), modLoc("block/light_blue_ceramic"), modLoc("block/light_blue_ceramic_tile_top"));
		simpleBlock(BlockRegistry.CYAN_CERAMIC.get());
		paneBlock(BlockRegistry.CYAN_CERAMIC_TILE.get(), modLoc("block/cyan_ceramic"), modLoc("block/cyan_ceramic_tile_top"));
		simpleBlock(BlockRegistry.GREEN_CERAMIC.get());
		paneBlock(BlockRegistry.GREEN_CERAMIC_TILE.get(), modLoc("block/green_ceramic"), modLoc("block/green_ceramic_tile_top"));
		simpleBlock(BlockRegistry.LIME_CERAMIC.get());
		paneBlock(BlockRegistry.LIME_CERAMIC_TILE.get(), modLoc("block/lime_ceramic"), modLoc("block/lime_ceramic_tile_top"));
		simpleBlock(BlockRegistry.YELLOW_CERAMIC.get());
		paneBlock(BlockRegistry.YELLOW_CERAMIC_TILE.get(), modLoc("block/yellow_ceramic"), modLoc("block/yellow_ceramic_tile_top"));
		simpleBlock(BlockRegistry.ORANGE_CERAMIC.get());
		paneBlock(BlockRegistry.ORANGE_CERAMIC_TILE.get(), modLoc("block/orange_ceramic"), modLoc("block/orange_ceramic_tile_top"));
		simpleBlock(BlockRegistry.BROWN_CERAMIC.get());
		paneBlock(BlockRegistry.BROWN_CERAMIC_TILE.get(), modLoc("block/brown_ceramic"), modLoc("block/brown_ceramic_tile_top"));
		simpleBlock(BlockRegistry.RED_CERAMIC.get());
		paneBlock(BlockRegistry.RED_CERAMIC_TILE.get(), modLoc("block/red_ceramic"), modLoc("block/red_ceramic_tile_top"));
		simpleBlock(BlockRegistry.PINK_CERAMIC.get());
		paneBlock(BlockRegistry.PINK_CERAMIC_TILE.get(), modLoc("block/pink_ceramic"), modLoc("block/pink_ceramic_tile_top"));

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
		simpleBlock(FluidRegistry.LOX_BLOCK.get());
		simpleBlock(FluidRegistry.MOLTEN_IRON_BLOCK.get());
		simpleBlock(FluidRegistry.MOLTEN_STEEL_BLOCK.get());
		simpleBlock(FluidRegistry.MOLTEN_COPPER_BLOCK.get());
		simpleBlock(FluidRegistry.MOLTEN_GOLD_BLOCK.get());
//		simpleBlock(FluidRegistry.MOLTEN_NETHERITE_BLOCK.get());
		simpleBlock(FluidRegistry.MOLTEN_ALUMINUM_BLOCK.get());
		simpleBlock(FluidRegistry.SULFUR_BLOCK.get());
		simpleBlock(FluidRegistry.METALLIC_HYDROGEN_BLOCK.get());

		//OTHER
		simpleBlock(BlockRegistry.DRY_ICE.get());

		simpleBlock(BlockRegistry.COMPRESSED_COBBLESTONE.get());
		simpleBlock(BlockRegistry.COMPRESSED_COBBLED_DEEPSLATE.get());
		simpleBlock(BlockRegistry.COMPRESSED_NETHERRACK.get());
		simpleBlock(BlockRegistry.SUPER_COMPRESSED_COBBLESTONE.get());
		simpleBlock(BlockRegistry.SUPER_COMPRESSED_COBBLED_DEEPSLATE.get());
		simpleBlock(BlockRegistry.SUPER_COMPRESSED_NETHERRACK.get());

		simpleBlock(BlockRegistry.BAUXITE_ORE.get());

		simpleBlock(BlockRegistry.TAXI_STATION.get());
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

	public void sandPathBlock(Block block, String texture) {
		ModelFile model = models().cubeAll(name(block), modLoc("block/" + texture));

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
        return models().withExistingParent(name + "_mirrored", mcLoc("block" + "/cube_mirrored_all")).texture("all", texture);
	}
}