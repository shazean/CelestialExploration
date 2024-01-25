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
		/*
		 * MOON
		 */
		simpleBlock(BlockRegistry.MOON_CORE.get());
		simpleBlock(BlockRegistry.MOON_BRICKS.get());
		simpleBlock(BlockRegistry.MOON_IRON_ORE.get());
		simpleBlock(BlockRegistry.MOON_REDSTONE_ORE.get());
//		simpleBlock(BlockRegistry.MOON_SAND.get());
//		simpleBlock(BlockRegistry.MOON_STONE.get());
//		simpleBlock(BlockRegistry.COARSE_MOON_SAND.get());

		simpleBlock(BlockRegistry.CHISELED_MOON_BRICKS.get());
		simpleBlock(BlockRegistry.GLOWING_MOON_SAND.get());
		simpleBlock(BlockRegistry.LUNAR_LANTERN.get());
		stairsBlock((StairBlock) BlockRegistry.MOON_BRICK_STAIRS.get(), modLoc("block/moon_bricks"));
		slabBlock((SlabBlock) BlockRegistry.MOON_BRICK_SLAB.get(), modLoc("block/moon_bricks"), modLoc("block/moon_bricks"));
		wallBlock((WallBlock) BlockRegistry.MOON_BRICK_WALL.get(), modLoc("block/moon_bricks"));
		simpleBlock(BlockRegistry.MOON_COBBLESTONE.get());
		axisBlock((RotatedPillarBlock) BlockRegistry.MOON_DEEPSLATE.get());
		simpleBlock(BlockRegistry.MOON_COBBLED_DEEPSLATE.get());
		axisBlock((RotatedPillarBlock) BlockRegistry.MOON_BRICK_PILLAR.get(), modLoc("block/moon_brick_pillar"));

		stairsBlock((StairBlock) BlockRegistry.MOON_STONE_STAIRS.get(), modLoc("block/moon_stone"));
		slabBlock((SlabBlock) BlockRegistry.MOON_STONE_SLAB.get(), modLoc("block/moon_stone"), modLoc("block/moon_stone"));

		stairsBlock((StairBlock) BlockRegistry.MOON_COBBLESTONE_STAIRS.get(), modLoc("block/moon_cobblestone"));
		slabBlock((SlabBlock) BlockRegistry.MOON_COBBLESTONE_SLAB.get(), modLoc("block/moon_cobblestone"), modLoc("block/moon_cobblestone"));
		wallBlock((WallBlock) BlockRegistry.MOON_COBBLESTONE_WALL.get(), modLoc("block/moon_cobblestone"));

		stairsBlock((StairBlock) BlockRegistry.MOON_COBBLED_DEEPSLATE_STAIRS.get(), modLoc("block/moon_cobbled_deepslate"));
		slabBlock((SlabBlock) BlockRegistry.MOON_COBBLED_DEEPSLATE_SLAB.get(), modLoc("block/moon_cobbled_deepslate"), modLoc("block/moon_cobbled_deepslate"));
		wallBlock((WallBlock) BlockRegistry.MOON_COBBLED_DEEPSLATE_WALL.get(), modLoc("block/moon_cobbled_deepslate"));

		simpleBlock(BlockRegistry.MOON_SMOOTH_STONE.get());
		simpleBlock(BlockRegistry.CRACKED_MOON_BRICKS.get());

		simpleBlock(BlockRegistry.MOON_DEEPSLATE_BRICKS.get());
		stairsBlock((StairBlock) BlockRegistry.MOON_DEEPSLATE_BRICK_STAIRS.get(), modLoc("block/moon_deepslate_bricks"));
		slabBlock((SlabBlock) BlockRegistry.MOON_DEEPSLATE_BRICK_SLAB.get(), modLoc("block/moon_deepslate_bricks"), modLoc("block/moon_deepslate_bricks"));
		wallBlock((WallBlock) BlockRegistry.MOON_DEEPSLATE_BRICK_WALL.get(), modLoc("block/moon_deepslate_bricks"));
		simpleBlock(BlockRegistry.CHISELED_MOON_DEEPSLATE_BRICKS.get());
		simpleBlock(BlockRegistry.CRACKED_MOON_DEEPSLATE_BRICKS.get());

		simpleBlock(BlockRegistry.MOON_POLISHED_DEEPSLATE.get());
		stairsBlock((StairBlock) BlockRegistry.MOON_POLISHED_DEEPSLATE_STAIRS.get(), modLoc("block/moon_polished_deepslate"));
		slabBlock((SlabBlock) BlockRegistry.MOON_POLISHED_DEEPSLATE_SLAB.get(), modLoc("block/moon_polished_deepslate"), modLoc("block/moon_polished_deepslate"));
		wallBlock((WallBlock) BlockRegistry.MOON_POLISHED_DEEPSLATE_WALL.get(), modLoc("block/moon_polished_deepslate"));

		simpleBlock(BlockRegistry.MOON_DEEPSLATE_TILES.get());
		stairsBlock((StairBlock) BlockRegistry.MOON_DEEPSLATE_TILE_STAIRS.get(), modLoc("block/moon_deepslate_tiles"));
		slabBlock((SlabBlock) BlockRegistry.MOON_DEEPSLATE_TILE_SLAB.get(), modLoc("block/moon_deepslate_tiles"), modLoc("block/moon_deepslate_tiles"));
		wallBlock((WallBlock) BlockRegistry.MOON_DEEPSLATE_TILE_WALL.get(), modLoc("block/moon_deepslate_tiles"));
		simpleBlock(BlockRegistry.CRACKED_MOON_DEEPSLATE_TILES.get());

		buttonBlock((ButtonBlock) BlockRegistry.MOON_STONE_BUTTON.get(), modLoc("block/moon_stone"));
		pressurePlateBlock((PressurePlateBlock) BlockRegistry.MOON_STONE_PRESSURE_PLATE.get(), modLoc("block/moon_stone"));
		buttonBlock((ButtonBlock) BlockRegistry.MOON_DEEPSLATE_BUTTON.get(), modLoc("block/moon_deepslate_side"));
		pressurePlateBlock((PressurePlateBlock) BlockRegistry.MOON_DEEPSLATE_PRESSURE_PLATE.get(), modLoc("block/moon_deepslate_side"));
		simpleBlock(BlockRegistry.MOON_DEEPSLATE_IRON_ORE.get());
		simpleBlock(BlockRegistry.MOON_DEEPSLATE_REDSTONE_ORE.get());

		simpleBlock(BlockRegistry.COMPRESSED_MOON_COBBLESTONE.get());
		simpleBlock(BlockRegistry.COMPRESSED_MOON_COBBLED_DEEPSLATE.get());


		/*
		 * MARS
		 */
		simpleBlock(BlockRegistry.MARS_CORE.get());
		simpleBlock(BlockRegistry.CHISELED_MARS_BRICKS.get());
		simpleBlock(BlockRegistry.MARS_BRICKS.get());
		simpleBlock(BlockRegistry.MARS_IRON_ORE.get());
		simpleBlock(BlockRegistry.MARS_REDSTONE_ORE.get());
//		simpleBlock(BlockRegistry.MARS_SAND.get());
//		simpleBlock(BlockRegistry.COARSE_MARS_SAND.get());
//		simpleBlock(BlockRegistry.MARS_STONE.get());
		stairsBlock((StairBlock) BlockRegistry.MARS_BRICK_STAIRS.get(), modLoc("block/mars_bricks"));
		slabBlock((SlabBlock) BlockRegistry.MARS_BRICK_SLAB.get(), modLoc("block/mars_bricks"), modLoc("block/mars_bricks"));
		wallBlock((WallBlock) BlockRegistry.MARS_BRICK_WALL.get(), modLoc("block/mars_bricks"));
		simpleBlock(BlockRegistry.MARS_COBBLESTONE.get());
		axisBlock((RotatedPillarBlock) BlockRegistry.MARS_DEEPSLATE.get());
		simpleBlock(BlockRegistry.MARS_COBBLED_DEEPSLATE.get());

		simpleBlock(BlockRegistry.MARS_LANTERN.get());

		axisBlock((RotatedPillarBlock) BlockRegistry.MARS_BRICK_PILLAR.get(), modLoc("block/mars_brick_pillar"));

		stairsBlock((StairBlock) BlockRegistry.MARS_STONE_STAIRS.get(), modLoc("block/mars_stone"));
		slabBlock((SlabBlock) BlockRegistry.MARS_STONE_SLAB.get(), modLoc("block/mars_stone"), modLoc("block/mars_stone"));

		stairsBlock((StairBlock) BlockRegistry.MARS_COBBLESTONE_STAIRS.get(), modLoc("block/mars_cobblestone"));
		slabBlock((SlabBlock) BlockRegistry.MARS_COBBLESTONE_SLAB.get(), modLoc("block/mars_cobblestone"), modLoc("block/mars_cobblestone"));
		wallBlock((WallBlock) BlockRegistry.MARS_COBBLESTONE_WALL.get(), modLoc("block/mars_cobblestone"));

		stairsBlock((StairBlock) BlockRegistry.MARS_COBBLED_DEEPSLATE_STAIRS.get(), modLoc("block/mars_cobbled_deepslate"));
		slabBlock((SlabBlock) BlockRegistry.MARS_COBBLED_DEEPSLATE_SLAB.get(), modLoc("block/mars_cobbled_deepslate"), modLoc("block/mars_cobbled_deepslate"));
		wallBlock((WallBlock) BlockRegistry.MARS_COBBLED_DEEPSLATE_WALL.get(), modLoc("block/mars_cobbled_deepslate"));

		simpleBlock(BlockRegistry.MARS_SMOOTH_STONE.get());
		//FIXME
//		slabBlock((SlabBlock) BlockRegistry.MARS_SMOOTH_STONE_SLAB.get(), modLoc("block/mars_smooth_stone_slab_side"), modLoc("block/mars_cobbled_deepslate_side"), modLoc("block/mars_cobbled_deepslate"), modLoc("block/mars_cobbled_deepslate"));
		simpleBlock(BlockRegistry.CRACKED_MARS_BRICKS.get());

		simpleBlock(BlockRegistry.MARS_DEEPSLATE_BRICKS.get());
		stairsBlock((StairBlock) BlockRegistry.MARS_DEEPSLATE_BRICK_STAIRS.get(), modLoc("block/mars_deepslate_bricks"));
		slabBlock((SlabBlock) BlockRegistry.MARS_DEEPSLATE_BRICK_SLAB.get(), modLoc("block/mars_deepslate_bricks"), modLoc("block/mars_deepslate_bricks"));
		wallBlock((WallBlock) BlockRegistry.MARS_DEEPSLATE_BRICK_WALL.get(), modLoc("block/mars_deepslate_bricks"));
		simpleBlock(BlockRegistry.CHISELED_MARS_DEEPSLATE_BRICKS.get());
		simpleBlock(BlockRegistry.CRACKED_MARS_DEEPSLATE_BRICKS.get());

		simpleBlock(BlockRegistry.MARS_POLISHED_DEEPSLATE.get());
		stairsBlock((StairBlock) BlockRegistry.MARS_POLISHED_DEEPSLATE_STAIRS.get(), modLoc("block/mars_polished_deepslate"));
		slabBlock((SlabBlock) BlockRegistry.MARS_POLISHED_DEEPSLATE_SLAB.get(), modLoc("block/mars_polished_deepslate"), modLoc("block/mars_polished_deepslate"));
		wallBlock((WallBlock) BlockRegistry.MARS_POLISHED_DEEPSLATE_WALL.get(), modLoc("block/mars_polished_deepslate"));

		simpleBlock(BlockRegistry.MARS_DEEPSLATE_TILES.get());
		stairsBlock((StairBlock) BlockRegistry.MARS_DEEPSLATE_TILE_STAIRS.get(), modLoc("block/mars_deepslate_tiles"));
		slabBlock((SlabBlock) BlockRegistry.MARS_DEEPSLATE_TILE_SLAB.get(), modLoc("block/mars_deepslate_tiles"), modLoc("block/mars_deepslate_tiles"));
		wallBlock((WallBlock) BlockRegistry.MARS_DEEPSLATE_TILE_WALL.get(), modLoc("block/mars_deepslate_tiles"));
		simpleBlock(BlockRegistry.CRACKED_MARS_DEEPSLATE_TILES.get());

		buttonBlock((ButtonBlock) BlockRegistry.MARS_STONE_BUTTON.get(), modLoc("block/mars_stone"));
		pressurePlateBlock((PressurePlateBlock) BlockRegistry.MARS_STONE_PRESSURE_PLATE.get(), modLoc("block/mars_stone"));
		buttonBlock((ButtonBlock) BlockRegistry.MARS_DEEPSLATE_BUTTON.get(), modLoc("block/mars_deepslate_side"));
		pressurePlateBlock((PressurePlateBlock) BlockRegistry.MARS_DEEPSLATE_PRESSURE_PLATE.get(), modLoc("block/mars_deepslate_side"));

		simpleBlock(BlockRegistry.MARS_DEEPSLATE_IRON_ORE.get());
		simpleBlock(BlockRegistry.MARS_DEEPSLATE_REDSTONE_ORE.get());

		simpleBlock(BlockRegistry.COMPRESSED_MARS_COBBLESTONE.get());
		simpleBlock(BlockRegistry.COMPRESSED_MARS_COBBLED_DEEPSLATE.get());

		/*
		 * VENUS
		 */
		simpleBlock(BlockRegistry.VENUS_CORE.get());
		simpleBlock(BlockRegistry.CHISELED_VENUS_BRICKS.get());
		simpleBlock(BlockRegistry.VENUS_BRICKS.get());
		simpleBlock(BlockRegistry.VENUS_IRON_ORE.get());
		simpleBlock(BlockRegistry.VENUS_REDSTONE_ORE.get());
		simpleBlock(BlockRegistry.VENUS_LAPIS_ORE.get());
//		simpleBlock(BlockRegistry.VENUS_SAND.get());
		simpleBlock(BlockRegistry.FINE_VENUS_SAND.get());
//		simpleBlock(BlockRegistry.VENUS_STONE.get());
		stairsBlock((StairBlock) BlockRegistry.VENUS_BRICK_STAIRS.get(), modLoc("block/venus_bricks"));
		slabBlock((SlabBlock) BlockRegistry.VENUS_BRICK_SLAB.get(), modLoc("block/venus_bricks"), modLoc("block/venus_bricks"));
		wallBlock((WallBlock) BlockRegistry.VENUS_BRICK_WALL.get(), modLoc("block/venus_bricks"));
		simpleBlock(BlockRegistry.VENUS_COBBLESTONE.get());
		axisBlock((RotatedPillarBlock) BlockRegistry.VENUS_DEEPSLATE.get());
		simpleBlock(BlockRegistry.VENUS_COBBLED_DEEPSLATE.get());
		axisBlock((RotatedPillarBlock) BlockRegistry.VENUS_BRICK_PILLAR.get(), modLoc("block/venus_brick_pillar"));

		simpleBlock(BlockRegistry.SMALL_VENUS_BRICKS.get());
		stairsBlock((StairBlock) BlockRegistry.SMALL_VENUS_BRICK_STAIRS.get(), modLoc("block/small_venus_bricks"));
		slabBlock((SlabBlock) BlockRegistry.SMALL_VENUS_BRICK_SLAB.get(), modLoc("block/small_venus_bricks"), modLoc("block/small_venus_bricks"));
		wallBlock((WallBlock) BlockRegistry.SMALL_VENUS_BRICK_WALL.get(), modLoc("block/small_venus_bricks"));


		simpleBlock(BlockRegistry.CRACKED_VENUS_BRICKS.get());

		stairsBlock((StairBlock) BlockRegistry.VENUS_STONE_STAIRS.get(), modLoc("block/venus_stone"));
		slabBlock((SlabBlock) BlockRegistry.VENUS_STONE_SLAB.get(), modLoc("block/venus_stone"), modLoc("block/venus_stone"));

		stairsBlock((StairBlock) BlockRegistry.VENUS_COBBLESTONE_STAIRS.get(), modLoc("block/venus_cobblestone"));
		slabBlock((SlabBlock) BlockRegistry.VENUS_COBBLESTONE_SLAB.get(), modLoc("block/venus_cobblestone"), modLoc("block/venus_cobblestone"));
		wallBlock((WallBlock) BlockRegistry.VENUS_COBBLESTONE_WALL.get(), modLoc("block/venus_cobblestone"));

		stairsBlock((StairBlock) BlockRegistry.VENUS_COBBLED_DEEPSLATE_STAIRS.get(), modLoc("block/venus_cobbled_deepslate"));
		slabBlock((SlabBlock) BlockRegistry.VENUS_COBBLED_DEEPSLATE_SLAB.get(), modLoc("block/venus_cobbled_deepslate"), modLoc("block/venus_cobbled_deepslate"));
		wallBlock((WallBlock) BlockRegistry.VENUS_COBBLED_DEEPSLATE_WALL.get(), modLoc("block/venus_cobbled_deepslate"));

		simpleBlock(BlockRegistry.VENUS_SMOOTH_STONE.get());

		simpleBlock(BlockRegistry.VENUS_DEEPSLATE_BRICKS.get());
		stairsBlock((StairBlock) BlockRegistry.VENUS_DEEPSLATE_BRICK_STAIRS.get(), modLoc("block/venus_deepslate_bricks"));
		slabBlock((SlabBlock) BlockRegistry.VENUS_DEEPSLATE_BRICK_SLAB.get(), modLoc("block/venus_deepslate_bricks"), modLoc("block/venus_deepslate_bricks"));
		wallBlock((WallBlock) BlockRegistry.VENUS_DEEPSLATE_BRICK_WALL.get(), modLoc("block/venus_deepslate_bricks"));
		simpleBlock(BlockRegistry.CHISELED_VENUS_DEEPSLATE_BRICKS.get());
		simpleBlock(BlockRegistry.CRACKED_VENUS_DEEPSLATE_BRICKS.get());

		simpleBlock(BlockRegistry.VENUS_POLISHED_DEEPSLATE.get());
		stairsBlock((StairBlock) BlockRegistry.VENUS_POLISHED_DEEPSLATE_STAIRS.get(), modLoc("block/venus_polished_deepslate"));
		slabBlock((SlabBlock) BlockRegistry.VENUS_POLISHED_DEEPSLATE_SLAB.get(), modLoc("block/venus_polished_deepslate"), modLoc("block/venus_polished_deepslate"));
		wallBlock((WallBlock) BlockRegistry.VENUS_POLISHED_DEEPSLATE_WALL.get(), modLoc("block/venus_polished_deepslate"));

		simpleBlock(BlockRegistry.VENUS_DEEPSLATE_TILES.get());
		stairsBlock((StairBlock) BlockRegistry.VENUS_DEEPSLATE_TILE_STAIRS.get(), modLoc("block/venus_deepslate_tiles"));
		slabBlock((SlabBlock) BlockRegistry.VENUS_DEEPSLATE_TILE_SLAB.get(), modLoc("block/venus_deepslate_tiles"), modLoc("block/venus_deepslate_tiles"));
		wallBlock((WallBlock) BlockRegistry.VENUS_DEEPSLATE_TILE_WALL.get(), modLoc("block/venus_deepslate_tiles"));
		simpleBlock(BlockRegistry.CRACKED_VENUS_DEEPSLATE_TILES.get());

		buttonBlock((ButtonBlock) BlockRegistry.VENUS_STONE_BUTTON.get(), modLoc("block/venus_stone"));
		pressurePlateBlock((PressurePlateBlock) BlockRegistry.VENUS_STONE_PRESSURE_PLATE.get(), modLoc("block/venus_stone"));
		buttonBlock((ButtonBlock) BlockRegistry.VENUS_DEEPSLATE_BUTTON.get(), modLoc("block/venus_deepslate_side"));
		pressurePlateBlock((PressurePlateBlock) BlockRegistry.VENUS_DEEPSLATE_PRESSURE_PLATE.get(), modLoc("block/venus_deepslate_side"));

		simpleBlock(BlockRegistry.VENUS_DEEPSLATE_IRON_ORE.get());
		simpleBlock(BlockRegistry.VENUS_DEEPSLATE_REDSTONE_ORE.get());
		simpleBlock(BlockRegistry.VENUS_DEEPSLATE_LAPIS_ORE.get());

		simpleBlock(BlockRegistry.COMPRESSED_VENUS_COBBLESTONE.get());
		simpleBlock(BlockRegistry.COMPRESSED_VENUS_COBBLED_DEEPSLATE.get());

		simpleBlock(BlockRegistry.SULFURIC_OBSIDIAN.get());
		simpleBlock(BlockRegistry.VENUS_LANTERN.get());


		/*
		 * METEORS
		 */
		simpleBlock(BlockRegistry.METEOR.get());
		simpleBlock(BlockRegistry.METEOR_BRICKS.get());
		simpleBlock(BlockRegistry.METEOR_COAL_ORE.get());
		simpleBlock(BlockRegistry.METEOR_COPPER_ORE.get());
		simpleBlock(BlockRegistry.METEOR_DIAMOND_ORE.get());
		simpleBlock(BlockRegistry.METEOR_EMERALD_ORE.get());
		simpleBlock(BlockRegistry.METEOR_GOLD_ORE.get());
		simpleBlock(BlockRegistry.METEOR_IRON_ORE.get());
		simpleBlock(BlockRegistry.METEOR_LAPIS_ORE.get());
		simpleBlock(BlockRegistry.METEOR_SULFUR_ORE.get());
		simpleBlock(BlockRegistry.METEOR_REDSTONE_ORE.get());
		simpleBlock(BlockRegistry.CHISELED_METEOR_BRICKS.get());
		stairsBlock((StairBlock) BlockRegistry.METEOR_BRICK_STAIRS.get(), modLoc("block/meteor_bricks"));
		slabBlock((SlabBlock) BlockRegistry.METEOR_BRICK_SLAB.get(), modLoc("block/meteor_bricks"), modLoc("block/meteor_bricks"));
		wallBlock((WallBlock) BlockRegistry.METEOR_BRICK_WALL.get(), modLoc("block/meteor_bricks"));

		buttonBlock((ButtonBlock) BlockRegistry.METEOR_BUTTON.get(), modLoc("block/meteor"));
		pressurePlateBlock((PressurePlateBlock) BlockRegistry.METEOR_PRESSURE_PLATE.get(), modLoc("block/meteor"));

		/*
		 * OTHER PLANETS
		 */
//		simpleBlock(BlockRegistry.SOLAR_LANTERN.get());
//		simpleBlock(BlockRegistry.ECLIPSE_LANTERN.get());

		simpleBlock(BlockRegistry.SOLAR_PLASMA.get());
		simpleBlock(BlockRegistry.SOLAR_FLARE.get());
		simpleBlock(BlockRegistry.SUN_SPOT.get());

		simpleBlock(BlockRegistry.MERCURY_STONE.get());
		simpleBlock(BlockRegistry.MERCURY_CORE.get());
		axisBlock((RotatedPillarBlock) BlockRegistry.MERCURY_DEEPSLATE.get());

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

		simpleBlock(BlockRegistry.SATURN_ATMOSPHERE.get());
		simpleBlock(BlockRegistry.SATURN_CORE.get());
		axisBlock((RotatedPillarBlock) BlockRegistry.SATURN_DEEPSLATE.get());

		simpleBlock(BlockRegistry.TITAN_CORE.get());
		simpleBlock(BlockRegistry.ENCELADUS_CORE.get());
		simpleBlock(BlockRegistry.RHEA_CORE.get());
		simpleBlock(BlockRegistry.IAPETUS_CORE.get());
		simpleBlock(BlockRegistry.DIONE_CORE.get());
		simpleBlock(BlockRegistry.HYPERION_CORE.get());

		simpleBlock(BlockRegistry.URANUS_ATMOSPHERE.get());
		simpleBlock(BlockRegistry.URANUS_CORE.get());
		axisBlock((RotatedPillarBlock) BlockRegistry.URANUS_DEEPSLATE.get());

		simpleBlock(BlockRegistry.TITANIA_CORE.get());
		simpleBlock(BlockRegistry.OBERON_CORE.get());

		simpleBlock(BlockRegistry.NEPTUNE_ATMOSPHERE.get());
		simpleBlock(BlockRegistry.NEPTUNE_CORE.get());
		axisBlock((RotatedPillarBlock) BlockRegistry.NEPTUNE_DEEPSLATE.get());

		simpleBlock(BlockRegistry.TRITON_CORE.get());

//		simpleBlock(BlockRegistry.PLUTO_CORE.get());
//		simpleBlock(BlockRegistry.CERES_CORE.get());
//		simpleBlock(BlockRegistry.ERIS_CORE.get());
//		simpleBlock(BlockRegistry.HAUMEA_CORE.get());
//		simpleBlock(BlockRegistry.MAKEMAKE_CORE.get());



		/*
		 * OTHER
		 */
//		simpleBlock(BlockRegistry.SOLAR_PANEL.get());
//		simpleBlock(BlockRegistry.IGNEOUS_ROCK.get());
		simpleBlock(BlockRegistry.STEEL_BLOCK.get());
		doorBlock((DoorBlock) BlockRegistry.AIRLOCK_DOOR.get(), modLoc("block/airlock_door_bottom"), modLoc("block/airlock_door_top"));
		doorBlock((DoorBlock) BlockRegistry.STEEL_DOOR.get(), modLoc("block/steel_door_bottom"), modLoc("block/steel_door_top"));
		trapdoorBlock((TrapDoorBlock) BlockRegistry.STEEL_TRAPDOOR.get(), modLoc("block/steel_trapdoor"), true);
		buttonBlock((ButtonBlock) BlockRegistry.STEEL_BUTTON.get(), modLoc("block/steel_block"));

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

		simpleBlock(BlockRegistry.DRY_ICE.get());

		simpleBlock(BlockRegistry.LUMINOUS_BLUE_GLASS.get());
		simpleBlock(BlockRegistry.LUMINOUS_WHITE_GLASS.get());
		paneBlock((IronBarsBlock) BlockRegistry.LUMINOUS_BLUE_GLASS_PANE.get(), modLoc("block/luminous_blue_glass"), modLoc("block/luminous_blue_glass_pane_top"));
		paneBlock((IronBarsBlock) BlockRegistry.LUMINOUS_WHITE_GLASS_PANE.get(), modLoc("block/luminous_white_glass"), modLoc("block/luminous_white_glass_pane_top"));

		simpleBlock(BlockRegistry.COMPRESSED_COBBLESTONE.get());
		simpleBlock(BlockRegistry.COMPRESSED_COBBLED_DEEPSLATE.get());
		simpleBlock(BlockRegistry.COMPRESSED_NETHERRACK.get());

		simpleBlock(BlockRegistry.SILICA.get());



//		connectedGlassBlock((ConnectedGlassBlock) BlockRegistry.CONNECTED_GLASS.get(), modLoc("block/connected_glass"));

//		public void fenceBlock(FenceBlock block, ResourceLocation texture) {
//			String baseName = block.getRegistryName().toString();
//			fourWayBlock(block, models().fencePost(baseName + "_post", texture), models().fenceSide(baseName + "_side", texture));
//		}

//		public void fourWayBlock(CrossCollisionBlock block, ModelFile post, ModelFile side) {
//			MultiPartBlockStateBuilder builder = getMultipartBuilder(block)
//					.part().modelFile(post).addModel().end();
//			fourWayMultipart(builder, side);
//		}

		/**
		 * SPACESHIP
		 */
//		simpleBlock(BlockRegistry.STEEL_FRAME.get());

		/**
		 * FLUIDS
		 */
		simpleBlock(FluidRegistry.LOX_BLOCK.get());
		simpleBlock(FluidRegistry.MOLTEN_IRON_BLOCK.get());
		simpleBlock(FluidRegistry.MOLTEN_STEEL_BLOCK.get());
		simpleBlock(FluidRegistry.MOLTEN_COPPER_BLOCK.get());
		simpleBlock(FluidRegistry.MOLTEN_GOLD_BLOCK.get());
//		simpleBlock(FluidRegistry.MOLTEN_NETHERITE_BLOCK.get());
		simpleBlock(FluidRegistry.SULFUR_BLOCK.get());


	}

	public void connectedGlassBlock(ConnectedGlassBlock block, ResourceLocation texture) {
			String baseName = block.getRegistryName().toString();
			fourWayGlassBlock(block, models().fencePost(baseName + "_corner", texture), models().fenceSide(baseName + "_side", texture));
		}

	public void fourWayGlassBlock(ConnectedGlassBlock block, ModelFile post, ModelFile side) {
		MultiPartBlockStateBuilder builder = getMultipartBuilder(block)
				.part().modelFile(post).addModel().end();
		fourWayMultipart(builder, side);
	}

}
