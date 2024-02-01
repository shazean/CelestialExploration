package com.shim.celestialexploration.datagen;

import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestialexploration.blocks.ConnectedGlassBlock;
import com.shim.celestialexploration.registry.BlockRegistry;

import com.shim.celestialexploration.registry.FluidRegistry;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.client.model.generators.MultiPartBlockStateBuilder;
import net.minecraftforge.common.data.ExistingFileHelper;

public class BlockStates extends BlockStateProvider {

	public BlockStates(DataGenerator gen, ExistingFileHelper helper) {
		super(gen, CelestialExploration.MODID, helper);
	}

	@Override
	protected void registerStatesAndModels() {

		//---- MOON -------------------------------------------------------------------------------
		//STONE
		stairsBlock(BlockRegistry.MOON_STONE_STAIRS.get(), modLoc("block/moon_stone"));
		slabBlock(BlockRegistry.MOON_STONE_SLAB.get(), modLoc("block/moon_stone"), modLoc("block/moon_stone"));
		buttonBlock(BlockRegistry.MOON_STONE_BUTTON.get(), modLoc("block/moon_stone"));
		pressurePlateBlock(BlockRegistry.MOON_STONE_PRESSURE_PLATE.get(), modLoc("block/moon_stone"));

		simpleBlock(BlockRegistry.MOON_COBBLESTONE.get());
		stairsBlock(BlockRegistry.MOON_COBBLESTONE_STAIRS.get(), modLoc("block/moon_cobblestone"));
		slabBlock(BlockRegistry.MOON_COBBLESTONE_SLAB.get(), modLoc("block/moon_cobblestone"), modLoc("block/moon_cobblestone"));
		wallBlock(BlockRegistry.MOON_COBBLESTONE_WALL.get(), modLoc("block/moon_cobblestone"));
		simpleBlock(BlockRegistry.COMPRESSED_MOON_COBBLESTONE.get());

		simpleBlock(BlockRegistry.MOON_BRICKS.get());
		stairsBlock(BlockRegistry.MOON_BRICK_STAIRS.get(), modLoc("block/moon_bricks"));
		slabBlock(BlockRegistry.MOON_BRICK_SLAB.get(), modLoc("block/moon_bricks"), modLoc("block/moon_bricks"));
		wallBlock(BlockRegistry.MOON_BRICK_WALL.get(), modLoc("block/moon_bricks"));
		simpleBlock(BlockRegistry.CHISELED_MOON_BRICKS.get());
		axisBlock(BlockRegistry.MOON_BRICK_PILLAR.get(), modLoc("block/moon_brick_pillar"));
		simpleBlock(BlockRegistry.CRACKED_MOON_BRICKS.get());

		simpleBlock(BlockRegistry.MOON_SMOOTH_STONE.get());

		//DEEPSLATE
		axisBlock(BlockRegistry.MOON_DEEPSLATE.get());

		simpleBlock(BlockRegistry.MOON_COBBLED_DEEPSLATE.get());
		stairsBlock(BlockRegistry.MOON_COBBLED_DEEPSLATE_STAIRS.get(), modLoc("block/moon_cobbled_deepslate"));
		slabBlock(BlockRegistry.MOON_COBBLED_DEEPSLATE_SLAB.get(), modLoc("block/moon_cobbled_deepslate"), modLoc("block/moon_cobbled_deepslate"));
		wallBlock(BlockRegistry.MOON_COBBLED_DEEPSLATE_WALL.get(), modLoc("block/moon_cobbled_deepslate"));
		buttonBlock(BlockRegistry.MOON_DEEPSLATE_BUTTON.get(), modLoc("block/moon_deepslate_side"));
		pressurePlateBlock(BlockRegistry.MOON_DEEPSLATE_PRESSURE_PLATE.get(), modLoc("block/moon_deepslate_side"));
		simpleBlock(BlockRegistry.COMPRESSED_MOON_COBBLED_DEEPSLATE.get());

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
		simpleBlock(BlockRegistry.GLOWING_MOON_SAND.get());
		simpleBlock(BlockRegistry.LUNAR_LANTERN.get());

		//---- MARS -------------------------------------------------------------------------------
		//STONE
		stairsBlock(BlockRegistry.MARS_STONE_STAIRS.get(), modLoc("block/mars_stone"));
		slabBlock(BlockRegistry.MARS_STONE_SLAB.get(), modLoc("block/mars_stone"), modLoc("block/mars_stone"));
		buttonBlock(BlockRegistry.MARS_STONE_BUTTON.get(), modLoc("block/mars_stone"));
		pressurePlateBlock(BlockRegistry.MARS_STONE_PRESSURE_PLATE.get(), modLoc("block/mars_stone"));

		simpleBlock(BlockRegistry.MARS_COBBLESTONE.get());
		stairsBlock(BlockRegistry.MARS_COBBLESTONE_STAIRS.get(), modLoc("block/mars_cobblestone"));
		slabBlock(BlockRegistry.MARS_COBBLESTONE_SLAB.get(), modLoc("block/mars_cobblestone"), modLoc("block/mars_cobblestone"));
		wallBlock(BlockRegistry.MARS_COBBLESTONE_WALL.get(), modLoc("block/mars_cobblestone"));
		simpleBlock(BlockRegistry.COMPRESSED_MARS_COBBLESTONE.get());

		simpleBlock(BlockRegistry.MARS_BRICKS.get());
		stairsBlock(BlockRegistry.MARS_BRICK_STAIRS.get(), modLoc("block/mars_bricks"));
		slabBlock(BlockRegistry.MARS_BRICK_SLAB.get(), modLoc("block/mars_bricks"), modLoc("block/mars_bricks"));
		wallBlock(BlockRegistry.MARS_BRICK_WALL.get(), modLoc("block/mars_bricks"));
		simpleBlock(BlockRegistry.CHISELED_MARS_BRICKS.get());
		axisBlock(BlockRegistry.MARS_BRICK_PILLAR.get(), modLoc("block/mars_brick_pillar"));
		simpleBlock(BlockRegistry.CRACKED_MARS_BRICKS.get());

		simpleBlock(BlockRegistry.MARS_SMOOTH_STONE.get());

		//DEEPSLATE
		axisBlock((RotatedPillarBlock) BlockRegistry.MARS_DEEPSLATE.get());

		simpleBlock(BlockRegistry.MARS_COBBLED_DEEPSLATE.get());
		stairsBlock(BlockRegistry.MARS_COBBLED_DEEPSLATE_STAIRS.get(), modLoc("block/mars_cobbled_deepslate"));
		slabBlock(BlockRegistry.MARS_COBBLED_DEEPSLATE_SLAB.get(), modLoc("block/mars_cobbled_deepslate"), modLoc("block/mars_cobbled_deepslate"));
		wallBlock(BlockRegistry.MARS_COBBLED_DEEPSLATE_WALL.get(), modLoc("block/mars_cobbled_deepslate"));
		buttonBlock(BlockRegistry.MARS_DEEPSLATE_BUTTON.get(), modLoc("block/mars_deepslate_side"));
		pressurePlateBlock(BlockRegistry.MARS_DEEPSLATE_PRESSURE_PLATE.get(), modLoc("block/mars_deepslate_side"));
		simpleBlock(BlockRegistry.COMPRESSED_MARS_COBBLED_DEEPSLATE.get());

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

		//---- VENUS -------------------------------------------------------------------------------
		//STONE
		stairsBlock(BlockRegistry.VENUS_STONE_STAIRS.get(), modLoc("block/venus_stone"));
		slabBlock(BlockRegistry.VENUS_STONE_SLAB.get(), modLoc("block/venus_stone"), modLoc("block/venus_stone"));
		buttonBlock((ButtonBlock) BlockRegistry.VENUS_STONE_BUTTON.get(), modLoc("block/venus_stone"));
		pressurePlateBlock((PressurePlateBlock) BlockRegistry.VENUS_STONE_PRESSURE_PLATE.get(), modLoc("block/venus_stone"));

		simpleBlock(BlockRegistry.VENUS_COBBLESTONE.get());
		stairsBlock(BlockRegistry.VENUS_COBBLESTONE_STAIRS.get(), modLoc("block/venus_cobblestone"));
		slabBlock(BlockRegistry.VENUS_COBBLESTONE_SLAB.get(), modLoc("block/venus_cobblestone"), modLoc("block/venus_cobblestone"));
		wallBlock(BlockRegistry.VENUS_COBBLESTONE_WALL.get(), modLoc("block/venus_cobblestone"));
		simpleBlock(BlockRegistry.COMPRESSED_VENUS_COBBLESTONE.get());

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

		//DEEPSLATE
		axisBlock((RotatedPillarBlock) BlockRegistry.VENUS_DEEPSLATE.get());

		simpleBlock(BlockRegistry.VENUS_COBBLED_DEEPSLATE.get());
		stairsBlock(BlockRegistry.VENUS_COBBLED_DEEPSLATE_STAIRS.get(), modLoc("block/venus_cobbled_deepslate"));
		slabBlock(BlockRegistry.VENUS_COBBLED_DEEPSLATE_SLAB.get(), modLoc("block/venus_cobbled_deepslate"), modLoc("block/venus_cobbled_deepslate"));
		wallBlock(BlockRegistry.VENUS_COBBLED_DEEPSLATE_WALL.get(), modLoc("block/venus_cobbled_deepslate"));
		buttonBlock((ButtonBlock) BlockRegistry.VENUS_DEEPSLATE_BUTTON.get(), modLoc("block/venus_deepslate_side"));
		pressurePlateBlock((PressurePlateBlock) BlockRegistry.VENUS_DEEPSLATE_PRESSURE_PLATE.get(), modLoc("block/venus_deepslate_side"));
		simpleBlock(BlockRegistry.COMPRESSED_VENUS_COBBLED_DEEPSLATE.get());

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

		//---- OTHER PLANETS -------------------------------------------------------------------------------
		//MERCURY
		simpleBlock(BlockRegistry.MERCURY_STONE.get());
		simpleBlock(BlockRegistry.MERCURY_CORE.get());
		axisBlock((RotatedPillarBlock) BlockRegistry.MERCURY_DEEPSLATE.get());

		//JUPITER
		simpleBlock(BlockRegistry.JUPITER_ATMOSPHERE.get());
		simpleBlock(BlockRegistry.JUPITER_CORE.get());
		axisBlock((RotatedPillarBlock) BlockRegistry.JUPITER_DEEPSLATE.get());

		simpleBlock(BlockRegistry.IO_STONE.get());
		simpleBlock(BlockRegistry.IO_CORE.get());
		axisBlock((RotatedPillarBlock) BlockRegistry.IO_DEEPSLATE.get());

		simpleBlock(BlockRegistry.EUROPA_CORE.get());
		simpleBlock(BlockRegistry.EUROPA_HYDRATE.get());

		simpleBlock(BlockRegistry.GANYMEDE_CORE.get());
		simpleBlock(BlockRegistry.CALLISTO_CORE.get());

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

		//---- ORE-RELATED -------------------------------------------------------------------------------
		simpleBlock(BlockRegistry.STEEL_BLOCK.get());
		simpleBlock(BlockRegistry.ALUMINUM_BLOCK.get());


		//---- SPACE STATION -------------------------------------------------------------------------------
		doorBlock(BlockRegistry.AIRLOCK_DOOR.get(), modLoc("block/airlock_door_bottom"), modLoc("block/airlock_door_top"));
		doorBlock(BlockRegistry.STEEL_DOOR.get(), modLoc("block/steel_door_bottom"), modLoc("block/steel_door_top"));
		trapdoorBlock(BlockRegistry.STEEL_TRAPDOOR.get(), modLoc("block/steel_trapdoor"), true);
		buttonBlock(BlockRegistry.STEEL_BUTTON.get(), modLoc("block/steel_block"));

		simpleBlock(BlockRegistry.PANEL.get());
		paneBlock((BlockRegistry.THIN_PANEL.get()), modLoc("block/panel"), modLoc("block/thin_panel_top"));
		stairsBlock(BlockRegistry.PANEL_STAIRS.get(), modLoc("block/panel"));
		slabBlock(BlockRegistry.PANEL_SLAB.get(), modLoc("block/panel"), modLoc("block/panel"));
		wallBlock(BlockRegistry.PANEL_WALL.get(), modLoc("block/panel"));

		buttonBlock(BlockRegistry.RED_BUTTON.get(), mcLoc("block/red_stained_glass"));
		buttonBlock(BlockRegistry.YELLOW_BUTTON.get(), mcLoc("block/yellow_stained_glass"));
		buttonBlock(BlockRegistry.BLUE_BUTTON.get(), mcLoc("block/blue_stained_glass"));
		buttonBlock(BlockRegistry.GREEN_BUTTON.get(), mcLoc("block/green_stained_glass"));
		buttonBlock(BlockRegistry.WHITE_BUTTON.get(), mcLoc("block/white_stained_glass"));
		buttonBlock(BlockRegistry.BLACK_BUTTON.get(), mcLoc("block/black_stained_glass"));

		//---- GLASS/CERAMICS -------------------------------------------------------------------------------
		//GLASS
		simpleBlock(BlockRegistry.LUMINOUS_BLUE_GLASS.get());
		simpleBlock(BlockRegistry.LUMINOUS_WHITE_GLASS.get());
		paneBlock((IronBarsBlock) BlockRegistry.LUMINOUS_BLUE_GLASS_PANE.get(), modLoc("block/luminous_blue_glass"), modLoc("block/luminous_blue_glass_pane_top"));
		paneBlock((IronBarsBlock) BlockRegistry.LUMINOUS_WHITE_GLASS_PANE.get(), modLoc("block/luminous_white_glass"), modLoc("block/luminous_white_glass_pane_top"));

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

		//OTHER
		simpleBlock(BlockRegistry.DRY_ICE.get());

		simpleBlock(BlockRegistry.COMPRESSED_COBBLESTONE.get());
		simpleBlock(BlockRegistry.COMPRESSED_COBBLED_DEEPSLATE.get());
		simpleBlock(BlockRegistry.COMPRESSED_NETHERRACK.get());
		simpleBlock(BlockRegistry.BAUXITE_ORE.get());
	}
}