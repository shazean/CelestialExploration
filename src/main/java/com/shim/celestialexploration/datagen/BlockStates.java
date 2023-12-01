package com.shim.celestialexploration.datagen;

import com.google.common.collect.ImmutableMap;
import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestialexploration.blocks.ConnectedGlassBlock;
import com.shim.celestialexploration.registry.BlockRegistry;

import com.shim.celestialexploration.registry.FluidRegistry;
import net.minecraft.core.Direction;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.properties.WallSide;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.client.model.generators.MultiPartBlockStateBuilder;
import net.minecraftforge.common.data.ExistingFileHelper;

import java.util.Map;
import java.util.function.Function;

public class BlockStates extends BlockStateProvider {

	public BlockStates(DataGenerator gen, ExistingFileHelper helper) {
		super(gen, CelestialExploration.MODID, helper);
	}

	@Override
	protected void registerStatesAndModels() {
		/**
		 * MOON
		 * */
		simpleBlock(BlockRegistry.MOON_BRICKS.get());
		simpleBlock(BlockRegistry.MOON_IRON_ORE.get());
		simpleBlock(BlockRegistry.MOON_REDSTONE_ORE.get());
		simpleBlock(BlockRegistry.MOON_SAND.get());
		simpleBlock(BlockRegistry.MOON_STONE.get());
		simpleBlock(BlockRegistry.COARSE_MOON_SAND.get());

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
		//FIXME
//		slabBlock((SlabBlock) BlockRegistry.MOON_SMOOTH_STONE_SLAB.get(), modLoc("block/moon_smooth_stone_slab_side"), modLoc("block/moon_cobbled_deepslate_side"), modLoc("block/moon_cobbled_deepslate"), modLoc("block/moon_cobbled_deepslate"));
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


		/**
		 * MARS
		 * */
		simpleBlock(BlockRegistry.CHISELED_MARS_BRICKS.get());
		simpleBlock(BlockRegistry.MARS_BRICKS.get());
		simpleBlock(BlockRegistry.MARS_IRON_ORE.get());
		simpleBlock(BlockRegistry.MARS_REDSTONE_ORE.get());
		simpleBlock(BlockRegistry.MARS_SAND.get());
		simpleBlock(BlockRegistry.COARSE_MARS_SAND.get());
		simpleBlock(BlockRegistry.MARS_STONE.get());
		stairsBlock((StairBlock) BlockRegistry.MARS_BRICK_STAIRS.get(), modLoc("block/mars_bricks"));
		slabBlock((SlabBlock) BlockRegistry.MARS_BRICK_SLAB.get(), modLoc("block/mars_bricks"), modLoc("block/mars_bricks"));
		wallBlock((WallBlock) BlockRegistry.MARS_BRICK_WALL.get(), modLoc("block/mars_bricks"));
		simpleBlock(BlockRegistry.MARS_COBBLESTONE.get());
		axisBlock((RotatedPillarBlock) BlockRegistry.MARS_DEEPSLATE.get());
		simpleBlock(BlockRegistry.MARS_COBBLED_DEEPSLATE.get());
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


		/**
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
		simpleBlock(BlockRegistry.METEOR_REDSTONE_ORE.get());
		simpleBlock(BlockRegistry.CHISELED_METEOR_BRICKS.get());
		stairsBlock((StairBlock) BlockRegistry.METEOR_BRICK_STAIRS.get(), modLoc("block/meteor_bricks"));
		slabBlock((SlabBlock) BlockRegistry.METEOR_BRICK_SLAB.get(), modLoc("block/meteor_bricks"), modLoc("block/meteor_bricks"));
		wallBlock((WallBlock) BlockRegistry.METEOR_BRICK_WALL.get(), modLoc("block/meteor_bricks"));

		buttonBlock((ButtonBlock) BlockRegistry.METEOR_BUTTON.get(), modLoc("block/meteor"));
		pressurePlateBlock((PressurePlateBlock) BlockRegistry.METEOR_PRESSURE_PLATE.get(), modLoc("block/meteor"));

//		simpleBlock(BlockRegistry.SOLAR_LANTERN.get());
//		simpleBlock(BlockRegistry.ECLIPSE_LANTERN.get());


		/**
		 * OTHER
		 * */
//		simpleBlock(BlockRegistry.SOLAR_PANEL.get());
//		simpleBlock(BlockRegistry.IGNEOUS_ROCK.get());
		simpleBlock(BlockRegistry.STEEL_BLOCK.get());
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
		 * SHUTTLE
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
