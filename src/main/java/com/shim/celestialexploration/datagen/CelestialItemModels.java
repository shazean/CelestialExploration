package com.shim.celestialexploration.datagen;

import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestialexploration.registry.CelestialBlocks;
import com.shim.celestialexploration.registry.CelestialFluids;
import com.shim.celestialexploration.registry.CelestialItems;
import com.shim.celestiallib.api.datagen.base.BaseItemModels;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class CelestialItemModels extends BaseItemModels {

	public CelestialItemModels(DataGenerator generator, ExistingFileHelper existingFileHelper) {
		super(generator, CelestialExploration.MODID, existingFileHelper);
	}

	@Override
	protected void registerModels() {

		//---- MOON -------------------------------------------------------------------------------
		//STONE
		self(CelestialBlocks.MOON_STONE.get());
		stairsItem(CelestialBlocks.MOON_STONE_STAIRS.get(), "moon_stone");
		slabItem(CelestialBlocks.MOON_STONE_SLAB.get(), "moon_stone");
		buttonInventory(name(CelestialBlocks.MOON_STONE_BUTTON.get()), modLoc("block/moon_stone"));
		pressurePlate(name(CelestialBlocks.MOON_STONE_PRESSURE_PLATE.get()), modLoc("block/moon_stone"));

		self(CelestialBlocks.MOON_COBBLESTONE.get());
		stairsItem(CelestialBlocks.MOON_COBBLESTONE_STAIRS.get(), "moon_cobblestone");
		slabItem(CelestialBlocks.MOON_COBBLESTONE_SLAB.get(), "moon_cobblestone");
		wallItem(CelestialBlocks.MOON_COBBLESTONE_WALL.get(), "moon_cobblestone");
		self(CelestialBlocks.COMPRESSED_MOON_COBBLESTONE.get());
		self(CelestialBlocks.SUPER_COMPRESSED_MOON_COBBLESTONE.get());

		self(CelestialBlocks.MOON_BRICKS.get());
		stairsItem(CelestialBlocks.MOON_BRICK_STAIRS.get(),"moon_bricks");
		slabItem(CelestialBlocks.MOON_BRICK_SLAB.get(), "moon_bricks");
		wallItem(CelestialBlocks.MOON_BRICK_WALL.get(),  "moon_bricks");
		self(CelestialBlocks.CHISELED_MOON_BRICKS.get());
		self(CelestialBlocks.CRACKED_MOON_BRICKS.get());
		self(CelestialBlocks.MOON_BRICK_PILLAR.get());

		self(CelestialBlocks.MOON_SMOOTH_STONE.get());
		slabItem(CelestialBlocks.MOON_SMOOTH_STONE_SLAB.get(), "moon_smooth_stone");

		//DEEPSLATE
		self(CelestialBlocks.MOON_DEEPSLATE.get());
		buttonInventory(name(CelestialBlocks.MOON_DEEPSLATE_BUTTON.get()), modLoc("block/moon_deepslate_side"));
		pressurePlate(name(CelestialBlocks.MOON_DEEPSLATE_PRESSURE_PLATE.get()), modLoc("block/moon_deepslate_side"));

		self(CelestialBlocks.MOON_COBBLED_DEEPSLATE.get());
		stairsItem(CelestialBlocks.MOON_COBBLED_DEEPSLATE_STAIRS.get(), "moon_cobbled_deepslate");
		slabItem(CelestialBlocks.MOON_COBBLED_DEEPSLATE_SLAB.get(), "moon_cobbled_deepslate");
		wallItem(CelestialBlocks.MOON_COBBLED_DEEPSLATE_WALL.get(),"moon_cobbled_deepslate");
		self(CelestialBlocks.COMPRESSED_MOON_COBBLED_DEEPSLATE.get());
		self(CelestialBlocks.SUPER_COMPRESSED_MOON_COBBLED_DEEPSLATE.get());

		self(CelestialBlocks.MOON_POLISHED_DEEPSLATE.get());
		stairsItem(CelestialBlocks.MOON_POLISHED_DEEPSLATE_STAIRS.get(), "moon_polished_deepslate");
		slabItem(CelestialBlocks.MOON_POLISHED_DEEPSLATE_SLAB.get(), "moon_polished_deepslate");
		wallItem(CelestialBlocks.MOON_POLISHED_DEEPSLATE_WALL.get(), "moon_polished_deepslate");

		self(CelestialBlocks.MOON_DEEPSLATE_BRICKS.get());
		stairsItem(CelestialBlocks.MOON_DEEPSLATE_BRICK_STAIRS.get(), "moon_deepslate_bricks");
		slabItem(CelestialBlocks.MOON_DEEPSLATE_BRICK_SLAB.get(), "moon_deepslate_bricks");
		wallItem(CelestialBlocks.MOON_DEEPSLATE_BRICK_WALL.get(), "moon_deepslate_bricks");
		self(CelestialBlocks.CHISELED_MOON_DEEPSLATE_BRICKS.get());
		self(CelestialBlocks.CRACKED_MOON_DEEPSLATE_BRICKS.get());

		self(CelestialBlocks.MOON_DEEPSLATE_TILES.get());
		stairsItem(CelestialBlocks.MOON_DEEPSLATE_TILE_STAIRS.get(), "moon_deepslate_tiles");
		slabItem(CelestialBlocks.MOON_DEEPSLATE_TILE_SLAB.get(),"moon_deepslate_tiles");
		wallItem(CelestialBlocks.MOON_DEEPSLATE_TILE_WALL.get(), "moon_deepslate_tiles");
		self(CelestialBlocks.CRACKED_MOON_DEEPSLATE_TILES.get());
		
		//ORES
		self(CelestialBlocks.MOON_IRON_ORE.get());
		self(CelestialBlocks.MOON_REDSTONE_ORE.get());
		self(CelestialBlocks.MOON_BAUXITE_ORE.get());
		self(CelestialBlocks.MOON_DEEPSLATE_IRON_ORE.get());
		self(CelestialBlocks.MOON_DEEPSLATE_REDSTONE_ORE.get());

		//OTHER
		self(CelestialBlocks.MOON_CORE.get());
		self(CelestialBlocks.MOON_SAND.get());
		self(CelestialBlocks.COARSE_MOON_SAND.get());
		self(CelestialBlocks.GLOWING_MOON_SAND.get());
		self(CelestialBlocks.LUNAR_LANTERN.get());
		self(CelestialBlocks.MOON_SAND_PATH.get());
		chestItem(CelestialBlocks.MOON_CHEST.get(), CelestialBlocks.MOON_STONE.get());
		self(CelestialBlocks.MOON_FARMLAND.get());


		//---- MARS -------------------------------------------------------------------------------
		//STONE
		self(CelestialBlocks.MARS_STONE.get());
		stairsItem(CelestialBlocks.MARS_STONE_STAIRS.get(), "mars_stone");
		slabItem(CelestialBlocks.MARS_STONE_SLAB.get(), "mars_stone");
		buttonInventory(name(CelestialBlocks.MARS_STONE_BUTTON.get()), modLoc("block/mars_stone"));
		pressurePlate(name(CelestialBlocks.MARS_STONE_PRESSURE_PLATE.get()), modLoc("block/mars_stone"));

		self(CelestialBlocks.MARS_COBBLESTONE.get());
		stairsItem(CelestialBlocks.MARS_COBBLESTONE_STAIRS.get(), "mars_cobblestone");
		slabItem(CelestialBlocks.MARS_COBBLESTONE_SLAB.get(), "mars_cobblestone");
		wallItem(CelestialBlocks.MARS_COBBLESTONE_WALL.get(), "mars_cobblestone");
		self(CelestialBlocks.COMPRESSED_MARS_COBBLESTONE.get());
		self(CelestialBlocks.SUPER_COMPRESSED_MARS_COBBLESTONE.get());

		self(CelestialBlocks.MARS_BRICKS.get());
		stairsItem(CelestialBlocks.MARS_BRICK_STAIRS.get(),"mars_bricks");
		slabItem(CelestialBlocks.MARS_BRICK_SLAB.get(), "mars_bricks");
		wallItem(CelestialBlocks.MARS_BRICK_WALL.get(),  "mars_bricks");
		self(CelestialBlocks.CHISELED_MARS_BRICKS.get());
		self(CelestialBlocks.CRACKED_MARS_BRICKS.get());
		self(CelestialBlocks.MARS_BRICK_PILLAR.get());

		self(CelestialBlocks.MARS_SMOOTH_STONE.get());
		slabItem(CelestialBlocks.MARS_SMOOTH_STONE_SLAB.get(), "mars_smooth_stone");
		
		//DEEPSLATE
		self(CelestialBlocks.MARS_DEEPSLATE.get());
		buttonInventory(name(CelestialBlocks.MARS_DEEPSLATE_BUTTON.get()), modLoc("block/mars_deepslate_side"));
		pressurePlate(name(CelestialBlocks.MARS_DEEPSLATE_PRESSURE_PLATE.get()), modLoc("block/mars_deepslate_side"));

		self(CelestialBlocks.MARS_COBBLED_DEEPSLATE.get());
		stairsItem(CelestialBlocks.MARS_COBBLED_DEEPSLATE_STAIRS.get(), "mars_cobbled_deepslate");
		slabItem(CelestialBlocks.MARS_COBBLED_DEEPSLATE_SLAB.get(), "mars_cobbled_deepslate");
		wallItem(CelestialBlocks.MARS_COBBLED_DEEPSLATE_WALL.get(),"mars_cobbled_deepslate");
		self(CelestialBlocks.COMPRESSED_MARS_COBBLED_DEEPSLATE.get());
		self(CelestialBlocks.SUPER_COMPRESSED_MARS_COBBLED_DEEPSLATE.get());

		self(CelestialBlocks.MARS_POLISHED_DEEPSLATE.get());
		stairsItem(CelestialBlocks.MARS_POLISHED_DEEPSLATE_STAIRS.get(), "mars_polished_deepslate");
		slabItem(CelestialBlocks.MARS_POLISHED_DEEPSLATE_SLAB.get(), "mars_polished_deepslate");
		wallItem(CelestialBlocks.MARS_POLISHED_DEEPSLATE_WALL.get(), "mars_polished_deepslate");

		self(CelestialBlocks.MARS_DEEPSLATE_BRICKS.get());
		stairsItem(CelestialBlocks.MARS_DEEPSLATE_BRICK_STAIRS.get(), "mars_deepslate_bricks");
		slabItem(CelestialBlocks.MARS_DEEPSLATE_BRICK_SLAB.get(), "mars_deepslate_bricks");
		wallItem(CelestialBlocks.MARS_DEEPSLATE_BRICK_WALL.get(), "mars_deepslate_bricks");
		self(CelestialBlocks.CHISELED_MARS_DEEPSLATE_BRICKS.get());
		self(CelestialBlocks.CRACKED_MARS_DEEPSLATE_BRICKS.get());

		self(CelestialBlocks.MARS_DEEPSLATE_TILES.get());
		stairsItem(CelestialBlocks.MARS_DEEPSLATE_TILE_STAIRS.get(), "mars_deepslate_tiles");
		slabItem(CelestialBlocks.MARS_DEEPSLATE_TILE_SLAB.get(),"mars_deepslate_tiles");
		wallItem(CelestialBlocks.MARS_DEEPSLATE_TILE_WALL.get(), "mars_deepslate_tiles");
		self(CelestialBlocks.CRACKED_MARS_DEEPSLATE_TILES.get());

		//ORES
		self(CelestialBlocks.MARS_IRON_ORE.get());
		self(CelestialBlocks.MARS_REDSTONE_ORE.get());
		self(CelestialBlocks.MARS_BAUXITE_ORE.get());
		self(CelestialBlocks.MARS_DEEPSLATE_IRON_ORE.get());
		self(CelestialBlocks.MARS_DEEPSLATE_REDSTONE_ORE.get());

		//OTHER
		self(CelestialBlocks.MARS_CORE.get());
		self(CelestialBlocks.MARS_LANTERN.get());
		self(CelestialBlocks.MARS_SAND.get());
		self(CelestialBlocks.COARSE_MARS_SAND.get());
		self(CelestialBlocks.MARS_SAND_PATH.get());
		chestItem(CelestialBlocks.MARS_CHEST.get(), CelestialBlocks.MARS_STONE.get());
		self(CelestialBlocks.MARS_FARMLAND.get());


		//---- VENUS -------------------------------------------------------------------------------
		//STONE
		self(CelestialBlocks.VENUS_STONE.get());
		stairsItem(CelestialBlocks.VENUS_STONE_STAIRS.get(), "venus_stone");
		slabItem(CelestialBlocks.VENUS_STONE_SLAB.get(), "venus_stone");
		buttonInventory(name(CelestialBlocks.VENUS_STONE_BUTTON.get()), modLoc("block/venus_stone"));
		pressurePlate(name(CelestialBlocks.VENUS_STONE_PRESSURE_PLATE.get()), modLoc("block/venus_stone"));

		self(CelestialBlocks.VENUS_COBBLESTONE.get());
		stairsItem(CelestialBlocks.VENUS_COBBLESTONE_STAIRS.get(), "venus_cobblestone");
		slabItem(CelestialBlocks.VENUS_COBBLESTONE_SLAB.get(), "venus_cobblestone");
		wallItem(CelestialBlocks.VENUS_COBBLESTONE_WALL.get(), "venus_cobblestone");
		self(CelestialBlocks.COMPRESSED_VENUS_COBBLESTONE.get());
		self(CelestialBlocks.SUPER_COMPRESSED_VENUS_COBBLESTONE.get());

		self(CelestialBlocks.VENUS_BRICKS.get());
		stairsItem(CelestialBlocks.VENUS_BRICK_STAIRS.get(),"venus_bricks");
		slabItem(CelestialBlocks.VENUS_BRICK_SLAB.get(), "venus_bricks");
		wallItem(CelestialBlocks.VENUS_BRICK_WALL.get(),  "venus_bricks");
		self(CelestialBlocks.CHISELED_VENUS_BRICKS.get());
		self(CelestialBlocks.CRACKED_VENUS_BRICKS.get());
		self(CelestialBlocks.VENUS_BRICK_PILLAR.get());

		self(CelestialBlocks.SMALL_VENUS_BRICKS.get());
		stairsItem(CelestialBlocks.SMALL_VENUS_BRICK_STAIRS.get(),"small_venus_bricks");
		slabItem(CelestialBlocks.SMALL_VENUS_BRICK_SLAB.get(), "small_venus_bricks");
		wallItem(CelestialBlocks.SMALL_VENUS_BRICK_WALL.get(),  "small_venus_bricks");

		self(CelestialBlocks.VENUS_SMOOTH_STONE.get());
		slabItem(CelestialBlocks.VENUS_SMOOTH_STONE_SLAB.get(), "venus_smooth_stone");
		
		//DEEPSLATE
		self(CelestialBlocks.VENUS_DEEPSLATE.get());
		buttonInventory(name(CelestialBlocks.VENUS_DEEPSLATE_BUTTON.get()), modLoc("block/venus_deepslate_side"));
		pressurePlate(name(CelestialBlocks.VENUS_DEEPSLATE_PRESSURE_PLATE.get()), modLoc("block/venus_deepslate_side"));

		self(CelestialBlocks.VENUS_COBBLED_DEEPSLATE.get());
		stairsItem(CelestialBlocks.VENUS_COBBLED_DEEPSLATE_STAIRS.get(), "venus_cobbled_deepslate");
		slabItem(CelestialBlocks.VENUS_COBBLED_DEEPSLATE_SLAB.get(), "venus_cobbled_deepslate");
		wallItem(CelestialBlocks.VENUS_COBBLED_DEEPSLATE_WALL.get(),"venus_cobbled_deepslate");
		self(CelestialBlocks.COMPRESSED_VENUS_COBBLED_DEEPSLATE.get());
		self(CelestialBlocks.SUPER_COMPRESSED_VENUS_COBBLED_DEEPSLATE.get());

		self(CelestialBlocks.VENUS_POLISHED_DEEPSLATE.get());
		stairsItem(CelestialBlocks.VENUS_POLISHED_DEEPSLATE_STAIRS.get(), "venus_polished_deepslate");
		slabItem(CelestialBlocks.VENUS_POLISHED_DEEPSLATE_SLAB.get(), "venus_polished_deepslate");
		wallItem(CelestialBlocks.VENUS_POLISHED_DEEPSLATE_WALL.get(), "venus_polished_deepslate");

		self(CelestialBlocks.VENUS_DEEPSLATE_BRICKS.get());
		stairsItem(CelestialBlocks.VENUS_DEEPSLATE_BRICK_STAIRS.get(), "venus_deepslate_bricks");
		slabItem(CelestialBlocks.VENUS_DEEPSLATE_BRICK_SLAB.get(), "venus_deepslate_bricks");
		wallItem(CelestialBlocks.VENUS_DEEPSLATE_BRICK_WALL.get(), "venus_deepslate_bricks");
		self(CelestialBlocks.CHISELED_VENUS_DEEPSLATE_BRICKS.get());
		self(CelestialBlocks.CRACKED_VENUS_DEEPSLATE_BRICKS.get());

		self(CelestialBlocks.VENUS_DEEPSLATE_TILES.get());
		stairsItem(CelestialBlocks.VENUS_DEEPSLATE_TILE_STAIRS.get(), "venus_deepslate_tiles");
		slabItem(CelestialBlocks.VENUS_DEEPSLATE_TILE_SLAB.get(),"venus_deepslate_tiles");
		wallItem(CelestialBlocks.VENUS_DEEPSLATE_TILE_WALL.get(), "venus_deepslate_tiles");
		self(CelestialBlocks.CRACKED_VENUS_DEEPSLATE_TILES.get());

		//ORES
		self(CelestialBlocks.VENUS_IRON_ORE.get());
		self(CelestialBlocks.VENUS_REDSTONE_ORE.get());
		self(CelestialBlocks.VENUS_BAUXITE_ORE.get());
		self(CelestialBlocks.VENUS_LAPIS_ORE.get());
		self(CelestialBlocks.VENUS_DEEPSLATE_LAPIS_ORE.get());
		self(CelestialBlocks.VENUS_DEEPSLATE_IRON_ORE.get());
		self(CelestialBlocks.VENUS_DEEPSLATE_REDSTONE_ORE.get());

		//OTHER
		self(CelestialBlocks.VENUS_CORE.get());
		self(CelestialBlocks.VENUS_SAND.get());
		self(CelestialBlocks.FINE_VENUS_SAND.get());
		self(CelestialBlocks.SULFURIC_OBSIDIAN.get());
		self(CelestialBlocks.VENUS_LANTERN.get());
		self(CelestialBlocks.GEYSER.get());
		self(CelestialBlocks.VENUS_SAND_PATH.get());
		chestItem(CelestialBlocks.VENUS_CHEST.get(), CelestialBlocks.VENUS_STONE.get());


		//---- MERCURY -------------------------------------------------------------------------------
		//STONE
		self(CelestialBlocks.MERCURY_STONE.get());
		stairsItem(CelestialBlocks.MERCURY_STONE_STAIRS.get(), "mercury_stone");
		slabItem(CelestialBlocks.MERCURY_STONE_SLAB.get(), "mercury_stone");
		buttonInventory(name(CelestialBlocks.MERCURY_STONE_BUTTON.get()), modLoc("block/mercury_stone"));
		pressurePlate(name(CelestialBlocks.MERCURY_STONE_PRESSURE_PLATE.get()), modLoc("block/mercury_stone"));

		self(CelestialBlocks.MERCURY_COBBLESTONE.get());
		stairsItem(CelestialBlocks.MERCURY_COBBLESTONE_STAIRS.get(), "mercury_cobblestone");
		slabItem(CelestialBlocks.MERCURY_COBBLESTONE_SLAB.get(), "mercury_cobblestone");
		wallItem(CelestialBlocks.MERCURY_COBBLESTONE_WALL.get(), "mercury_cobblestone");
		self(CelestialBlocks.COMPRESSED_MERCURY_COBBLESTONE.get());
		self(CelestialBlocks.SUPER_COMPRESSED_MERCURY_COBBLESTONE.get());

		self(CelestialBlocks.MERCURY_BRICKS.get());
		stairsItem(CelestialBlocks.MERCURY_BRICK_STAIRS.get(),"mercury_bricks");
		slabItem(CelestialBlocks.MERCURY_BRICK_SLAB.get(), "mercury_bricks");
		wallItem(CelestialBlocks.MERCURY_BRICK_WALL.get(),  "mercury_bricks");
		self(CelestialBlocks.CHISELED_MERCURY_BRICKS.get());
		self(CelestialBlocks.CRACKED_MERCURY_BRICKS.get());
		self(CelestialBlocks.MERCURY_BRICK_PILLAR.get());

		self(CelestialBlocks.MERCURY_SMOOTH_STONE.get());
		slabItem(CelestialBlocks.MERCURY_SMOOTH_STONE_SLAB.get(), "mercury_smooth_stone");
		//DEEPSLATE
		self(CelestialBlocks.MERCURY_DEEPSLATE.get());
		buttonInventory(name(CelestialBlocks.MERCURY_DEEPSLATE_BUTTON.get()), modLoc("block/mercury_deepslate_side"));
		pressurePlate(name(CelestialBlocks.MERCURY_DEEPSLATE_PRESSURE_PLATE.get()), modLoc("block/mercury_deepslate_side"));

		self(CelestialBlocks.MERCURY_COBBLED_DEEPSLATE.get());
		stairsItem(CelestialBlocks.MERCURY_COBBLED_DEEPSLATE_STAIRS.get(), "mercury_cobbled_deepslate");
		slabItem(CelestialBlocks.MERCURY_COBBLED_DEEPSLATE_SLAB.get(), "mercury_cobbled_deepslate");
		wallItem(CelestialBlocks.MERCURY_COBBLED_DEEPSLATE_WALL.get(),"mercury_cobbled_deepslate");
		self(CelestialBlocks.COMPRESSED_MERCURY_COBBLED_DEEPSLATE.get());
		self(CelestialBlocks.SUPER_COMPRESSED_MERCURY_COBBLED_DEEPSLATE.get());

		self(CelestialBlocks.MERCURY_POLISHED_DEEPSLATE.get());
		stairsItem(CelestialBlocks.MERCURY_POLISHED_DEEPSLATE_STAIRS.get(), "mercury_polished_deepslate");
		slabItem(CelestialBlocks.MERCURY_POLISHED_DEEPSLATE_SLAB.get(), "mercury_polished_deepslate");
		wallItem(CelestialBlocks.MERCURY_POLISHED_DEEPSLATE_WALL.get(), "mercury_polished_deepslate");

		self(CelestialBlocks.MERCURY_DEEPSLATE_BRICKS.get());
		stairsItem(CelestialBlocks.MERCURY_DEEPSLATE_BRICK_STAIRS.get(), "mercury_deepslate_bricks");
		slabItem(CelestialBlocks.MERCURY_DEEPSLATE_BRICK_SLAB.get(), "mercury_deepslate_bricks");
		wallItem(CelestialBlocks.MERCURY_DEEPSLATE_BRICK_WALL.get(), "mercury_deepslate_bricks");
		self(CelestialBlocks.CHISELED_MERCURY_DEEPSLATE_BRICKS.get());
		self(CelestialBlocks.CRACKED_MERCURY_DEEPSLATE_BRICKS.get());

		self(CelestialBlocks.MERCURY_DEEPSLATE_TILES.get());
		stairsItem(CelestialBlocks.MERCURY_DEEPSLATE_TILE_STAIRS.get(), "mercury_deepslate_tiles");
		slabItem(CelestialBlocks.MERCURY_DEEPSLATE_TILE_SLAB.get(),"mercury_deepslate_tiles");
		wallItem(CelestialBlocks.MERCURY_DEEPSLATE_TILE_WALL.get(), "mercury_deepslate_tiles");
		self(CelestialBlocks.CRACKED_MERCURY_DEEPSLATE_TILES.get());

		//ORES
		self(CelestialBlocks.MERCURY_BAUXITE_ORE.get());
		self(CelestialBlocks.MERCURY_SULFUR_ORE.get());
		self(CelestialBlocks.MERCURY_COAL_ORE.get());
		self(CelestialBlocks.MERCURY_DIAMOND_ORE.get());
		self(CelestialBlocks.MERCURY_DEEPSLATE_DIAMOND_ORE.get());
		self(CelestialBlocks.MERCURY_DEEPSLATE_IRON_ORE.get());
		self(CelestialBlocks.MERCURY_DEEPSLATE_COAL_ORE.get());
		self(CelestialBlocks.MERCURY_DEEPSLATE_REDSTONE_ORE.get());

		//OTHER
		self(CelestialBlocks.MERCURY_CORE.get());
		self(CelestialBlocks.MERCURY_SAND.get());
		self(CelestialBlocks.COARSE_MERCURY_SAND.get());
		self(CelestialBlocks.MERCURY_SAND_PATH.get());
		self(CelestialBlocks.MERCURY_LANTERN.get());
		chestItem(CelestialBlocks.MERCURY_CHEST.get(), CelestialBlocks.MERCURY_STONE.get());
		self(CelestialBlocks.MERCURY_FARMLAND.get());

		//---- JUPITER -------------------------------------------------------------------------------
		//DEEPSLATE
		self(CelestialBlocks.JUPITER_DEEPSLATE.get());
		buttonInventory(name(CelestialBlocks.JUPITER_DEEPSLATE_BUTTON.get()), modLoc("block/jupiter_deepslate_side"));
		pressurePlate(name(CelestialBlocks.JUPITER_DEEPSLATE_PRESSURE_PLATE.get()), modLoc("block/jupiter_deepslate_side"));

		self(CelestialBlocks.JUPITER_COBBLED_DEEPSLATE.get());
		stairsItem(CelestialBlocks.JUPITER_COBBLED_DEEPSLATE_STAIRS.get(), "jupiter_cobbled_deepslate");
		slabItem(CelestialBlocks.JUPITER_COBBLED_DEEPSLATE_SLAB.get(), "jupiter_cobbled_deepslate");
		wallItem(CelestialBlocks.JUPITER_COBBLED_DEEPSLATE_WALL.get(),"jupiter_cobbled_deepslate");
		self(CelestialBlocks.COMPRESSED_JUPITER_COBBLED_DEEPSLATE.get());
		self(CelestialBlocks.SUPER_COMPRESSED_JUPITER_COBBLED_DEEPSLATE.get());

		self(CelestialBlocks.JUPITER_POLISHED_DEEPSLATE.get());
		stairsItem(CelestialBlocks.JUPITER_POLISHED_DEEPSLATE_STAIRS.get(), "jupiter_polished_deepslate");
		slabItem(CelestialBlocks.JUPITER_POLISHED_DEEPSLATE_SLAB.get(), "jupiter_polished_deepslate");
		wallItem(CelestialBlocks.JUPITER_POLISHED_DEEPSLATE_WALL.get(), "jupiter_polished_deepslate");

		self(CelestialBlocks.JUPITER_DEEPSLATE_BRICKS.get());
		stairsItem(CelestialBlocks.JUPITER_DEEPSLATE_BRICK_STAIRS.get(), "jupiter_deepslate_bricks");
		slabItem(CelestialBlocks.JUPITER_DEEPSLATE_BRICK_SLAB.get(), "jupiter_deepslate_bricks");
		wallItem(CelestialBlocks.JUPITER_DEEPSLATE_BRICK_WALL.get(), "jupiter_deepslate_bricks");
		self(CelestialBlocks.CHISELED_JUPITER_DEEPSLATE_BRICKS.get());
		self(CelestialBlocks.CRACKED_JUPITER_DEEPSLATE_BRICKS.get());

		self(CelestialBlocks.JUPITER_DEEPSLATE_TILES.get());
		stairsItem(CelestialBlocks.JUPITER_DEEPSLATE_TILE_STAIRS.get(), "jupiter_deepslate_tiles");
		slabItem(CelestialBlocks.JUPITER_DEEPSLATE_TILE_SLAB.get(),"jupiter_deepslate_tiles");
		wallItem(CelestialBlocks.JUPITER_DEEPSLATE_TILE_WALL.get(), "jupiter_deepslate_tiles");
		self(CelestialBlocks.CRACKED_JUPITER_DEEPSLATE_TILES.get());

		//OTHER
		self(CelestialBlocks.JUPITER_CORE.get());
		self(CelestialBlocks.JUPITER_ATMOSPHERE.get());
		self(CelestialBlocks.JUPITER_LANTERN.get());
		chestItem(CelestialBlocks.JUPITER_CHEST.get(), "jupiter_deepslate_end");


		//---- JUPITER'S MOONS -------------------------------------------------------------------------------
		//---- IO -------------------------------------------------------------------------------
		//STONE
		self(CelestialBlocks.IO_STONE.get());
		stairsItem(CelestialBlocks.IO_STONE_STAIRS.get(), "io_stone");
		slabItem(CelestialBlocks.IO_STONE_SLAB.get(), "io_stone");
		buttonInventory(name(CelestialBlocks.IO_STONE_BUTTON.get()), modLoc("block/io_stone"));
		pressurePlate(name(CelestialBlocks.IO_STONE_PRESSURE_PLATE.get()), modLoc("block/io_stone"));

		self(CelestialBlocks.IO_COBBLESTONE.get());
		stairsItem(CelestialBlocks.IO_COBBLESTONE_STAIRS.get(), "io_cobblestone");
		slabItem(CelestialBlocks.IO_COBBLESTONE_SLAB.get(), "io_cobblestone");
		wallItem(CelestialBlocks.IO_COBBLESTONE_WALL.get(), "io_cobblestone");
		self(CelestialBlocks.COMPRESSED_IO_COBBLESTONE.get());
		self(CelestialBlocks.SUPER_COMPRESSED_IO_COBBLESTONE.get());

		self(CelestialBlocks.IO_BRICKS.get());
		stairsItem(CelestialBlocks.IO_BRICK_STAIRS.get(),"io_bricks");
		slabItem(CelestialBlocks.IO_BRICK_SLAB.get(), "io_bricks");
		wallItem(CelestialBlocks.IO_BRICK_WALL.get(),  "io_bricks");
		self(CelestialBlocks.CHISELED_IO_BRICKS.get());
		self(CelestialBlocks.CRACKED_IO_BRICKS.get());
		self(CelestialBlocks.IO_BRICK_PILLAR.get());

		self(CelestialBlocks.IO_SMOOTH_STONE.get());
		slabItem(CelestialBlocks.IO_SMOOTH_STONE_SLAB.get(), "io_smooth_stone");
		//DEEPSLATE
		self(CelestialBlocks.IO_DEEPSLATE.get());
		buttonInventory(name(CelestialBlocks.IO_DEEPSLATE_BUTTON.get()), modLoc("block/io_deepslate_side"));
		pressurePlate(name(CelestialBlocks.IO_DEEPSLATE_PRESSURE_PLATE.get()), modLoc("block/io_deepslate_side"));

		self(CelestialBlocks.IO_COBBLED_DEEPSLATE.get());
		stairsItem(CelestialBlocks.IO_COBBLED_DEEPSLATE_STAIRS.get(), "io_cobbled_deepslate");
		slabItem(CelestialBlocks.IO_COBBLED_DEEPSLATE_SLAB.get(), "io_cobbled_deepslate");
		wallItem(CelestialBlocks.IO_COBBLED_DEEPSLATE_WALL.get(),"io_cobbled_deepslate");
		self(CelestialBlocks.COMPRESSED_IO_COBBLED_DEEPSLATE.get());
		self(CelestialBlocks.SUPER_COMPRESSED_IO_COBBLED_DEEPSLATE.get());

		self(CelestialBlocks.IO_POLISHED_DEEPSLATE.get());
		stairsItem(CelestialBlocks.IO_POLISHED_DEEPSLATE_STAIRS.get(), "io_polished_deepslate");
		slabItem(CelestialBlocks.IO_POLISHED_DEEPSLATE_SLAB.get(), "io_polished_deepslate");
		wallItem(CelestialBlocks.IO_POLISHED_DEEPSLATE_WALL.get(), "io_polished_deepslate");

		self(CelestialBlocks.IO_DEEPSLATE_BRICKS.get());
		stairsItem(CelestialBlocks.IO_DEEPSLATE_BRICK_STAIRS.get(), "io_deepslate_bricks");
		slabItem(CelestialBlocks.IO_DEEPSLATE_BRICK_SLAB.get(), "io_deepslate_bricks");
		wallItem(CelestialBlocks.IO_DEEPSLATE_BRICK_WALL.get(), "io_deepslate_bricks");
		self(CelestialBlocks.CHISELED_IO_DEEPSLATE_BRICKS.get());
		self(CelestialBlocks.CRACKED_IO_DEEPSLATE_BRICKS.get());

		self(CelestialBlocks.IO_DEEPSLATE_TILES.get());
		stairsItem(CelestialBlocks.IO_DEEPSLATE_TILE_STAIRS.get(), "io_deepslate_tiles");
		slabItem(CelestialBlocks.IO_DEEPSLATE_TILE_SLAB.get(),"io_deepslate_tiles");
		wallItem(CelestialBlocks.IO_DEEPSLATE_TILE_WALL.get(), "io_deepslate_tiles");
		self(CelestialBlocks.CRACKED_IO_DEEPSLATE_TILES.get());

		//ORES
		self(CelestialBlocks.IO_SULFUR_ORE.get());
		self(CelestialBlocks.IO_LAPIS_ORE.get());
		self(CelestialBlocks.IO_DEEPSLATE_LAPIS_ORE.get());
		self(CelestialBlocks.IO_DEEPSLATE_IRON_ORE.get());

		//OTHER
		self(CelestialBlocks.IO_CORE.get());
		self(CelestialBlocks.IO_SAND.get());
		self(CelestialBlocks.COARSE_IO_SAND.get());
		self(CelestialBlocks.GLOWING_IO_SAND.get());
		self(CelestialBlocks.IO_SAND_PATH.get());
		self(CelestialBlocks.IO_LANTERN.get());
		self(CelestialBlocks.IO_GEYSER.get());
		chestItem(CelestialBlocks.IO_CHEST.get(), CelestialBlocks.IO_STONE.get());


		//EUROPA
		self(CelestialBlocks.EUROPA_CORE.get());
		self(CelestialBlocks.EUROPA_HYDRATE.get());

		self(CelestialBlocks.EUROPA_BRICKS.get());
		stairsItem(CelestialBlocks.EUROPA_BRICK_STAIRS.get(),"europa_bricks");
		slabItem(CelestialBlocks.EUROPA_BRICK_SLAB.get(), "europa_bricks");
		wallItem(CelestialBlocks.EUROPA_BRICK_WALL.get(),  "europa_bricks");
		self(CelestialBlocks.CHISELED_EUROPA_BRICKS.get());
//		self(BlockRegistry.CRACKED_EUROPA_BRICKS.get());
//		self(BlockRegistry.EUROPA_BRICK_PILLAR.get());

		self(CelestialBlocks.GLOWING_EUROPA_SAND.get());
		self(CelestialBlocks.EUROPA_LANTERN.get());

		//GANYMEDE
		self(CelestialBlocks.GANYMEDE_CORE.get());
		self(CelestialBlocks.GANYMEDE_BRICKS.get());
		stairsItem(CelestialBlocks.GANYMEDE_BRICK_STAIRS.get(),"ganymede_bricks");
		slabItem(CelestialBlocks.GANYMEDE_BRICK_SLAB.get(), "ganymede_bricks");
		wallItem(CelestialBlocks.GANYMEDE_BRICK_WALL.get(),  "ganymede_bricks");
		self(CelestialBlocks.CHISELED_GANYMEDE_BRICKS.get());
//		self(BlockRegistry.CRACKED_GANYMEDE_BRICKS.get());
//		self(BlockRegistry.GANYMEDE_BRICK_PILLAR.get());
		self(CelestialBlocks.GLOWING_GANYMEDE_SAND.get());
		self(CelestialBlocks.GANYMEDE_LANTERN.get());

		//CALLISTO
		self(CelestialBlocks.CALLISTO_CORE.get());
		self(CelestialBlocks.CALLISTO_BRICKS.get());
		stairsItem(CelestialBlocks.CALLISTO_BRICK_STAIRS.get(),"callisto_bricks");
		slabItem(CelestialBlocks.CALLISTO_BRICK_SLAB.get(), "callisto_bricks");
		wallItem(CelestialBlocks.CALLISTO_BRICK_WALL.get(),  "callisto_bricks");
		self(CelestialBlocks.CHISELED_CALLISTO_BRICKS.get());
//		self(BlockRegistry.CRACKED_CALLISTO_BRICKS.get());
//		self(BlockRegistry.CALLISTO_BRICK_PILLAR.get());
		self(CelestialBlocks.GLOWING_CALLISTO_SAND.get());
		self(CelestialBlocks.CALLISTO_LANTERN.get());

		//---- OTHER PLANETS -------------------------------------------------------------------------------

		//SATURN
		self(CelestialBlocks.SATURN_ATMOSPHERE.get());
		self(CelestialBlocks.SATURN_CORE.get());
		self(CelestialBlocks.SATURN_DEEPSLATE.get());

		self(CelestialBlocks.TITAN_CORE.get());
		self(CelestialBlocks.ENCELADUS_CORE.get());
		self(CelestialBlocks.IAPETUS_CORE.get());
		self(CelestialBlocks.RHEA_CORE.get());
		self(CelestialBlocks.DIONE_CORE.get());
		self(CelestialBlocks.HYPERION_CORE.get());

		//URANUS
		self(CelestialBlocks.URANUS_CORE.get());
		self(CelestialBlocks.URANUS_DEEPSLATE.get());
		self(CelestialBlocks.URANUS_ATMOSPHERE.get());

		self(CelestialBlocks.TITANIA_CORE.get());
		self(CelestialBlocks.OBERON_CORE.get());

		//NEPTUNE
		self(CelestialBlocks.NEPTUNE_CORE.get());
		self(CelestialBlocks.NEPTUNE_ATMOSPHERE.get());
		self(CelestialBlocks.NEPTUNE_DEEPSLATE.get());

		self(CelestialBlocks.TRITON_CORE.get());

		//DWARF PLANETS/OTHER
//		self(BlockRegistry.PLUTO_CORE.get());
//		self(BlockRegistry.ERIS_CORE.get());
//		self(BlockRegistry.HAUMEA_CORE.get());
//		self(BlockRegistry.CERES_CORE.get());
//		self(BlockRegistry.MAKEMAKE_CORE.get());

		//---- CELESTIAL OBJECTS -------------------------------------------------------------------------------
		//METEOR
		self(CelestialBlocks.METEOR.get());
		buttonInventory(name(CelestialBlocks.METEOR_BUTTON.get()), modLoc("block/meteor"));
		pressurePlate(name(CelestialBlocks.METEOR_PRESSURE_PLATE.get()), modLoc("block/meteor"));

		self(CelestialBlocks.METEOR_BRICKS.get());
		stairsItem(CelestialBlocks.METEOR_BRICK_STAIRS.get(), "meteor_bricks");
		slabItem(CelestialBlocks.METEOR_BRICK_SLAB.get(), "meteor_bricks");
		wallItem(CelestialBlocks.METEOR_BRICK_WALL.get(), "meteor_bricks");
		self(CelestialBlocks.CHISELED_METEOR_BRICKS.get());
		
		//METEOR ORE
		self(CelestialBlocks.METEOR_COAL_ORE.get());
		self(CelestialBlocks.METEOR_COPPER_ORE.get());
		self(CelestialBlocks.METEOR_DIAMOND_ORE.get());
		self(CelestialBlocks.METEOR_EMERALD_ORE.get());
		self(CelestialBlocks.METEOR_GOLD_ORE.get());
		self(CelestialBlocks.METEOR_IRON_ORE.get());
		self(CelestialBlocks.METEOR_LAPIS_ORE.get());
		self(CelestialBlocks.METEOR_SULFUR_ORE.get());
		self(CelestialBlocks.METEOR_REDSTONE_ORE.get());
		self(CelestialBlocks.METEOR_BAUXITE_ORE.get());
		
		//SUN
		self(CelestialBlocks.SOLAR_PLASMA.get());
		self(CelestialBlocks.SOLAR_FLARE.get());
		self(CelestialBlocks.SUN_SPOT.get());

		//---- ORE-RELATED -------------------------------------------------------------------------------
		self(CelestialBlocks.ALUMINUM_BLOCK.get());
		self(CelestialBlocks.STEEL_BLOCK.get());
		generatedItem(CelestialItems.STEEL_INGOT.get());
		generatedItem(CelestialItems.STEEL_NUGGET.get());
		generatedItem(CelestialItems.BAUXITE_INGOT.get());
		generatedItem(CelestialItems.ALUMINUM_INGOT.get());
		generatedItem(CelestialItems.RAW_BAUXITE.get());
		generatedItem(CelestialItems.RUSTED_IRON_NUGGET.get());
		self(CelestialBlocks.BAUXITE_ORE.get());

		//---- SPACESHIP -------------------------------------------------------------------------------
		self(CelestialBlocks.OXYGEN_COMPRESSOR.get());
		self(CelestialBlocks.WORKBENCH.get());

		generatedItem(CelestialItems.SPACESHIP_FRAME.get());
		generatedItem(CelestialItems.SPACESHIP_CABIN.get());
		generatedItem(CelestialItems.SPACESHIP_ENGINE.get());

		generatedItem(CelestialItems.BLACK_SPACESHIP.get());
		generatedItem(CelestialItems.GREY_SPACESHIP.get());
		generatedItem(CelestialItems.LIGHT_GREY_SPACESHIP.get());
		generatedItem(CelestialItems.WHITE_SPACESHIP.get());
		generatedItem(CelestialItems.PINK_SPACESHIP.get());
		generatedItem(CelestialItems.MAGENTA_SPACESHIP.get());
		generatedItem(CelestialItems.RED_SPACESHIP.get());
		generatedItem(CelestialItems.BROWN_SPACESHIP.get());
		generatedItem(CelestialItems.ORANGE_SPACESHIP.get());
		generatedItem(CelestialItems.YELLOW_SPACESHIP.get());
		generatedItem(CelestialItems.LIME_SPACESHIP.get());
		generatedItem(CelestialItems.GREEN_SPACESHIP.get());
		generatedItem(CelestialItems.CYAN_SPACESHIP.get());
		generatedItem(CelestialItems.LIGHT_BLUE_SPACESHIP.get());
		generatedItem(CelestialItems.BLUE_SPACESHIP.get());
		generatedItem(CelestialItems.PURPLE_SPACESHIP.get());

		//---- SPACE STATION -------------------------------------------------------------------------------
		self(CelestialBlocks.INSULATED_PANEL.get());
		self(CelestialBlocks.INSULATED_PANEL_CORNER.get());
		self(CelestialBlocks.PANEL.get());
		stairs("panel_stairs", modLoc("block/panel"), modLoc("block/panel"), modLoc("block/panel"));
		slab("panel_slab", modLoc("block/panel"), modLoc("block/panel"), modLoc("block/panel"));
		wallInventory("panel_wall",  modLoc("block/panel"));
		generatedBlockItem(CelestialBlocks.THIN_PANEL.get(), "block/panel");
		generatedBlockItem(CelestialBlocks.STEEL_LADDER.get());
		
		buttonInventory(name(CelestialBlocks.RED_BUTTON.get()), modLoc("block/red_ceramic"));
		buttonInventory(name(CelestialBlocks.YELLOW_BUTTON.get()), modLoc("block/yellow_ceramic"));
		buttonInventory(name(CelestialBlocks.BLUE_BUTTON.get()), modLoc("block/blue_ceramic"));
		buttonInventory(name(CelestialBlocks.GREEN_BUTTON.get()), modLoc("block/green_ceramic"));
		buttonInventory(name(CelestialBlocks.WHITE_BUTTON.get()), modLoc("block/white_ceramic"));
		buttonInventory(name(CelestialBlocks.BLACK_BUTTON.get()), modLoc("block/black_ceramic"));

		self(CelestialBlocks.PATHWAY_LIGHT.get());
		self(CelestialBlocks.SOLAR_PANEL.get());
		self(CelestialBlocks.GLOW_STRIP.get());
		self(CelestialBlocks.HORIZONTAL_GLOW_STRIP.get());

		generatedBlockItem(CelestialBlocks.AIRLOCK_PANEL_DOOR.get(), "block/airlock_panel_hinge");
		generatedBlockItem(CelestialBlocks.AIRLOCK_PANEL_DOOR_WINDOW.get(), "block/airlock_panel_window");
		generatedBlockItem(CelestialBlocks.HANGAR_DOOR.get(), "block/hangar_hinge");
		generatedBlockItem(CelestialBlocks.HANGAR_DOOR_WINDOW.get(), "block/hangar_window");

		generatedBlockItem(CelestialBlocks.AIRLOCK_DOOR.get(), "item/airlock_door");
		generatedBlockItem(CelestialBlocks.STEEL_DOOR.get(), "item/steel_door");
		withExistingParent(name(CelestialBlocks.AIRLOCK_TRAPDOOR.get()), modLoc("block/airlock_trapdoor_bottom"));
		withExistingParent(name(CelestialBlocks.STEEL_TRAPDOOR.get()), modLoc("block/steel_trapdoor_bottom"));
		buttonInventory(name(CelestialBlocks.STEEL_BUTTON.get()), modLoc("block/steel_block"));
		buttonInventory(name(CelestialBlocks.AIRLOCK_BUTTON.get()), modLoc("block/airlock_button"));

		//---- MAG LEV -------------------------------------------------------------------------------
		generatedBlockItem(CelestialBlocks.MAGRAIL.get());
		generatedBlockItem(CelestialBlocks.POWERED_MAGRAIL.get());
		generatedBlockItem(CelestialBlocks.DETECTOR_MAGRAIL.get());
		generatedBlockItem(CelestialBlocks.ACTIVATOR_MAGRAIL.get());
		generatedItem(CelestialItems.MAGCART.get());
		generatedItem(CelestialItems.CHEST_MAGCART.get());
		generatedItem(CelestialItems.COMMAND_BLOCK_MAGCART.get());
		generatedItem(CelestialItems.FURNACE_MAGCART.get());
		generatedItem(CelestialItems.HOPPER_MAGCART.get());
		generatedItem(CelestialItems.TNT_MAGCART.get());

		//---- ARMOR -------------------------------------------------------------------------------
		//STEEL
		generatedItem(CelestialItems.STEEL_HELMET.get());
		generatedItem(CelestialItems.STEEL_LEGGINGS.get());
		generatedItem(CelestialItems.STEEL_CHESTPLATE.get());
		generatedItem(CelestialItems.STEEL_BOOTS.get());

		//SPACESUIT
		generatedItem(CelestialItems.BASIC_SPACESUIT_HELMET.get());
		generatedItem(CelestialItems.BASIC_SPACESUIT_LEGGINGS.get());
		generatedItem(CelestialItems.BASIC_SPACESUIT_CHESTPLATE.get());
		generatedItem(CelestialItems.BASIC_SPACESUIT_BOOTS.get());
		generatedItem(CelestialItems.HEAVY_DUTY_SPACESUIT_HELMET.get());
		generatedItem(CelestialItems.HEAVY_DUTY_SPACESUIT_LEGGINGS.get());
		generatedItem(CelestialItems.HEAVY_DUTY_SPACESUIT_CHESTPLATE.get());
		generatedItem(CelestialItems.HEAVY_DUTY_SPACESUIT_BOOTS.get());
		generatedItem(CelestialItems.THERMAL_SPACESUIT_HELMET.get());
		generatedItem(CelestialItems.THERMAL_SPACESUIT_LEGGINGS.get());
		generatedItem(CelestialItems.THERMAL_SPACESUIT_CHESTPLATE.get());
		generatedItem(CelestialItems.THERMAL_SPACESUIT_BOOTS.get());
		generatedItem(CelestialItems.ADVANCED_SPACESUIT_HELMET.get());
		generatedItem(CelestialItems.ADVANCED_SPACESUIT_LEGGINGS.get());
		generatedItem(CelestialItems.ADVANCED_SPACESUIT_CHESTPLATE.get());
		generatedItem(CelestialItems.ADVANCED_SPACESUIT_BOOTS.get());
		
		//---- GLASS/CERAMICS -------------------------------------------------------------------------------
		//GLASS
		self(CelestialBlocks.LUMINOUS_BLUE_GLASS.get());
		self(CelestialBlocks.LUMINOUS_WHITE_GLASS.get());
		self(CelestialBlocks.LUMINOUS_CYAN_GLASS.get());
		self(CelestialBlocks.LUMINOUS_MAGENTA_GLASS.get());
		self(CelestialBlocks.LUMINOUS_YELLOW_GLASS.get());
		self(CelestialBlocks.LUMINOUS_RED_GLASS.get());
		generatedBlockItem(CelestialBlocks.LUMINOUS_RED_GLASS_PANE.get(), "block/luminous_red_glass");
		generatedBlockItem(CelestialBlocks.LUMINOUS_YELLOW_GLASS_PANE.get(), "block/luminous_yellow_glass");
		generatedBlockItem(CelestialBlocks.LUMINOUS_MAGENTA_GLASS_PANE.get(), "block/luminous_magenta_glass");
		generatedBlockItem(CelestialBlocks.LUMINOUS_BLUE_GLASS_PANE.get(), "block/luminous_blue_glass");
		generatedBlockItem(CelestialBlocks.LUMINOUS_CYAN_GLASS_PANE.get(), "block/luminous_cyan_glass");
		generatedBlockItem(CelestialBlocks.LUMINOUS_WHITE_GLASS_PANE.get(), "block/luminous_white_glass");

		withExistingParent(name(CelestialBlocks.REINFORCED_GLASS.get()), modLoc("block/reinforced_glass_inventory"));
		generatedBlockItem(CelestialBlocks.REINFORCED_GLASS_PANE.get(), "block/reinforced_glass");

		//CERAMIC
		self(CelestialBlocks.SILICA.get());

		self(CelestialBlocks.CERAMIC.get());
		generatedBlockItem(CelestialBlocks.CERAMIC_TILE.get(), "block/ceramic");

		self(CelestialBlocks.WHITE_CERAMIC.get());
		generatedBlockItem(CelestialBlocks.WHITE_CERAMIC_TILE.get(), "block/white_ceramic");
		self(CelestialBlocks.LIGHT_GREY_CERAMIC.get());
		generatedBlockItem(CelestialBlocks.LIGHT_GREY_CERAMIC_TILE.get(), "block/light_grey_ceramic");
		self(CelestialBlocks.GREY_CERAMIC.get());
		generatedBlockItem(CelestialBlocks.GREY_CERAMIC_TILE.get(), "block/grey_ceramic");
		self(CelestialBlocks.BLACK_CERAMIC.get());
		generatedBlockItem(CelestialBlocks.BLACK_CERAMIC_TILE.get(), "block/black_ceramic");
		self(CelestialBlocks.PURPLE_CERAMIC.get());
		generatedBlockItem(CelestialBlocks.PURPLE_CERAMIC_TILE.get(), "block/purple_ceramic");
		self(CelestialBlocks.MAGENTA_CERAMIC.get());
		generatedBlockItem(CelestialBlocks.MAGENTA_CERAMIC_TILE.get(), "block/magenta_ceramic");
		self(CelestialBlocks.BLUE_CERAMIC.get());
		generatedBlockItem(CelestialBlocks.BLUE_CERAMIC_TILE.get(), "block/blue_ceramic");
		self(CelestialBlocks.LIGHT_BLUE_CERAMIC.get());
		generatedBlockItem(CelestialBlocks.LIGHT_BLUE_CERAMIC_TILE.get(), "block/light_blue_ceramic");
		self(CelestialBlocks.CYAN_CERAMIC.get());
		generatedBlockItem(CelestialBlocks.CYAN_CERAMIC_TILE.get(), "block/cyan_ceramic");
		self(CelestialBlocks.GREEN_CERAMIC.get());
		generatedBlockItem(CelestialBlocks.GREEN_CERAMIC_TILE.get(), "block/green_ceramic");
		self(CelestialBlocks.LIME_CERAMIC.get());
		generatedBlockItem(CelestialBlocks.LIME_CERAMIC_TILE.get(), "block/lime_ceramic");
		self(CelestialBlocks.YELLOW_CERAMIC.get());
		generatedBlockItem(CelestialBlocks.YELLOW_CERAMIC_TILE.get(), "block/yellow_ceramic");
		self(CelestialBlocks.ORANGE_CERAMIC.get());
		generatedBlockItem(CelestialBlocks.ORANGE_CERAMIC_TILE.get(), "block/orange_ceramic");
		self(CelestialBlocks.BROWN_CERAMIC.get());
		generatedBlockItem(CelestialBlocks.BROWN_CERAMIC_TILE.get(), "block/brown_ceramic");
		self(CelestialBlocks.RED_CERAMIC.get());
		generatedBlockItem(CelestialBlocks.RED_CERAMIC_TILE.get(), "block/red_ceramic");
		self(CelestialBlocks.PINK_CERAMIC.get());
		generatedBlockItem(CelestialBlocks.PINK_CERAMIC_TILE.get(), "block/pink_ceramic");

		self(CelestialBlocks.PAINTED_WHITE_CERAMIC.get());
		self(CelestialBlocks.PAINTED_LIGHT_GREY_CERAMIC.get());
		self(CelestialBlocks.PAINTED_GREY_CERAMIC.get());
		self(CelestialBlocks.PAINTED_BLACK_CERAMIC.get());
		self(CelestialBlocks.PAINTED_PURPLE_CERAMIC.get());
		self(CelestialBlocks.PAINTED_MAGENTA_CERAMIC.get());
		self(CelestialBlocks.PAINTED_BLUE_CERAMIC.get());
		self(CelestialBlocks.PAINTED_LIGHT_BLUE_CERAMIC.get());
		self(CelestialBlocks.PAINTED_CYAN_CERAMIC.get());
		self(CelestialBlocks.PAINTED_GREEN_CERAMIC.get());
		self(CelestialBlocks.PAINTED_LIME_CERAMIC.get());
		self(CelestialBlocks.PAINTED_YELLOW_CERAMIC.get());
		self(CelestialBlocks.PAINTED_ORANGE_CERAMIC.get());
		self(CelestialBlocks.PAINTED_BROWN_CERAMIC.get());
		self(CelestialBlocks.PAINTED_RED_CERAMIC.get());
		self(CelestialBlocks.PAINTED_PINK_CERAMIC.get());

		//---- FOOD -------------------------------------------------------------------------------
		generatedItem(CelestialItems.MARSHMALLOW_GOO.get());
		generatedItem(CelestialItems.MARSHMALLOW.get());
		generatedItem(CelestialItems.ROASTED_MARSHMALLOW.get());
		generatedItem(CelestialItems.CHOCOLATE.get());
		generatedItem(CelestialItems.CRACKER.get());
		generatedItem(CelestialItems.SMORES.get());

		generatedItem(CelestialItems.LUNAR_CHEESE.get());
		generatedItem(CelestialItems.CHEESE.get());
		generatedItem(CelestialItems.SUSPICIOUS_JELLO.get());


		//---- MISC -------------------------------------------------------------------------------
		//BUCKETS
		generatedItem(CelestialFluids.LOX_BUCKET.get());
		singleTexture(name(CelestialFluids.MOLTEN_IRON_BUCKET.get()), new ResourceLocation("item/generated"), "layer0", new ResourceLocation("item/lava_bucket"));
		singleTexture(name(CelestialFluids.MOLTEN_STEEL_BUCKET.get()), new ResourceLocation("item/generated"), "layer0", new ResourceLocation("item/lava_bucket"));
		singleTexture(name(CelestialFluids.MOLTEN_COPPER_BUCKET.get()), new ResourceLocation("item/generated"), "layer0", new ResourceLocation("item/lava_bucket"));
		singleTexture(name(CelestialFluids.MOLTEN_GOLD_BUCKET.get()), new ResourceLocation("item/generated"), "layer0", new ResourceLocation("item/lava_bucket"));
		singleTexture(name(CelestialFluids.MOLTEN_ALUMINUM_BUCKET.get()), new ResourceLocation("item/generated"), "layer0", new ResourceLocation("item/lava_bucket"));
		generatedItem(CelestialFluids.SULFUR_BUCKET.get());
		generatedItem(CelestialFluids.METALLIC_HYDROGEN_BUCKET.get());
		generatedItem(CelestialItems.EUREKA_BUCKET.get());

		generatedItem(CelestialItems.FLUID_BASIN.get());


		//BLOCKS
		self(CelestialBlocks.DRY_ICE.get());
		self(CelestialBlocks.COMPRESSED_COBBLESTONE.get());
		self(CelestialBlocks.COMPRESSED_COBBLED_DEEPSLATE.get());
		self(CelestialBlocks.COMPRESSED_NETHERRACK.get());
		self(CelestialBlocks.SUPER_COMPRESSED_COBBLESTONE.get());
		self(CelestialBlocks.SUPER_COMPRESSED_COBBLED_DEEPSLATE.get());
		self(CelestialBlocks.SUPER_COMPRESSED_NETHERRACK.get());

		self(CelestialBlocks.PLANET_CHART.get());
		self(CelestialBlocks.TAXI_STATION.get());

		//ITEMS
		generatedItem(CelestialItems.MOON_DUST.get());
		generatedItem(CelestialItems.EUROPA_DUST.get());
		generatedItem(CelestialItems.CALLISTO_DUST.get());
		generatedItem(CelestialItems.IO_DUST.get());
		generatedItem(CelestialItems.GANYMEDE_DUST.get());
		generatedItem(CelestialItems.WHITE_MOON_DUST.get());

		handheldItem(CelestialItems.STEEL_ROD.get());
		generatedItem(CelestialItems.STEEL_WOOL.get());
		handheldItem(CelestialItems.FLARE_ROD.get());
		generatedItem(CelestialItems.SULFUR_CRYSTAL.get());
		generatedItem(CelestialItems.LUNAR_GOO.get());
		generatedItem(CelestialItems.CINNABAR.get());
		generatedItem(CelestialItems.MECHACERBERUS_CORE.get());

		generatedItem(CelestialItems.MOON_MILK_BUCKET.get());


		//SPAWN EGGS
		spawnEgg(CelestialItems.RUST_SPAWN_EGG.get());
		spawnEgg(CelestialItems.LUNAR_SPAWN_EGG.get());
		spawnEgg(CelestialItems.MARS_MALLOW_SPAWN_EGG.get());
		spawnEgg(CelestialItems.QUICKSILVER_SPAWN_EGG.get());
		spawnEgg(CelestialItems.VISCOUS_SPAWN_EGG.get());
		spawnEgg(CelestialItems.LURKER_SPAWN_EGG.get());
		spawnEgg(CelestialItems.VOIDFELLOW_SPAWN_EGG.get());
		spawnEgg(CelestialItems.VOIDED_SPAWN_EGG.get());
		spawnEgg(CelestialItems.SULFUR_CUBE_SPAWN_EGG.get());
		spawnEgg(CelestialItems.VOIDED_PIGLIN_SPAWN_EGG.get());
		spawnEgg(CelestialItems.ASTRAL_PIGLIN_SPAWN_EGG.get());
		spawnEgg(CelestialItems.CYBORG_PIGLIN_SPAWN_EGG.get());
		spawnEgg(CelestialItems.FLARE_SPAWN_EGG.get());
		spawnEgg(CelestialItems.GYST_SPAWN_EGG.get());
		spawnEgg(CelestialItems.VOIDED_ZOGLIN_SPAWN_EGG.get());
		spawnEgg(CelestialItems.ASTRAL_HOGLIN_SPAWN_EGG.get());
		spawnEgg(CelestialItems.METEOR_CRAWLER_SPAWN_EGG.get());
		spawnEgg(CelestialItems.VOID_CRAWLER_SPAWN_EGG.get());
		spawnEgg(CelestialItems.CELESTIAL_CAT_SPAWN_EGG.get());
		spawnEgg(CelestialItems.EUREKA_SPAWN_EGG.get());
		spawnEgg(CelestialItems.GUST_SPAWN_EGG.get());
		spawnEgg(CelestialItems.ROVER_SPAWN_EGG.get());
		spawnEgg(CelestialItems.DRONE_SPAWN_EGG.get());
		spawnEgg(CelestialItems.WILD_MECHADOG_SPAWN_EGG.get());
		spawnEgg(CelestialItems.COBBLESAURUS_SPAWN_EGG.get());
		spawnEgg(CelestialItems.ORBITER_SPAWN_EGG.get());
		spawnEgg(CelestialItems.MOON_COW_SPAWN_EGG.get());

		generatedItem(CelestialItems.BLACK_MECHADOG.get());
		generatedItem(CelestialItems.GREY_MECHADOG.get());
		generatedItem(CelestialItems.LIGHT_GREY_MECHADOG.get());
		generatedItem(CelestialItems.WHITE_MECHADOG.get());
		generatedItem(CelestialItems.PINK_MECHADOG.get());
		generatedItem(CelestialItems.MAGENTA_MECHADOG.get());
		generatedItem(CelestialItems.RED_MECHADOG.get());
		generatedItem(CelestialItems.BROWN_MECHADOG.get());
		generatedItem(CelestialItems.ORANGE_MECHADOG.get());
		generatedItem(CelestialItems.YELLOW_MECHADOG.get());
		generatedItem(CelestialItems.LIME_MECHADOG.get());
		generatedItem(CelestialItems.GREEN_MECHADOG.get());
		generatedItem(CelestialItems.CYAN_MECHADOG.get());
		generatedItem(CelestialItems.LIGHT_BLUE_MECHADOG.get());
		generatedItem(CelestialItems.BLUE_MECHADOG.get());
		generatedItem(CelestialItems.PURPLE_MECHADOG.get());

		generatedItem(CelestialItems.BLACK_MECHACERBERUS.get());
		generatedItem(CelestialItems.GREY_MECHACERBERUS.get());
		generatedItem(CelestialItems.LIGHT_GREY_MECHACERBERUS.get());
		generatedItem(CelestialItems.WHITE_MECHACERBERUS.get());
		generatedItem(CelestialItems.PINK_MECHACERBERUS.get());
		generatedItem(CelestialItems.MAGENTA_MECHACERBERUS.get());
		generatedItem(CelestialItems.RED_MECHACERBERUS.get());
		generatedItem(CelestialItems.BROWN_MECHACERBERUS.get());
		generatedItem(CelestialItems.ORANGE_MECHACERBERUS.get());
		generatedItem(CelestialItems.YELLOW_MECHACERBERUS.get());
		generatedItem(CelestialItems.LIME_MECHACERBERUS.get());
		generatedItem(CelestialItems.GREEN_MECHACERBERUS.get());
		generatedItem(CelestialItems.CYAN_MECHACERBERUS.get());
		generatedItem(CelestialItems.LIGHT_BLUE_MECHACERBERUS.get());
		generatedItem(CelestialItems.BLUE_MECHACERBERUS.get());
		generatedItem(CelestialItems.PURPLE_MECHACERBERUS.get());

		generatedItem(CelestialItems.RED_DISPLAY_BOARD.get());
		generatedItem(CelestialItems.BLACK_DISPLAY_BOARD.get());
		generatedItem(CelestialItems.BLUE_DISPLAY_BOARD.get());
		generatedItem(CelestialItems.WHITE_DISPLAY_BOARD.get());


		this.withExistingParent(name(CelestialBlocks.LURKER_HEAD.get()), this.mcLoc("item/template_skull"));
		this.withExistingParent(name(CelestialBlocks.VOIDED_HEAD.get()), this.mcLoc("item/template_skull"));
		generatedBlockItem(CelestialBlocks.MECHADOG_HEAD.get(), "item/mechadog_head");

//		generatedItem(ItemRegistry.CONTROL_PANEL.get());

	}

	protected String name(ItemLike block) {
		return block.asItem().getRegistryName().getPath();
	}

	public void chestItem(Block item, Block particle) {
		this.singleTexture(name(item), new ResourceLocation(CelestialExploration.MODID, "item/chest_item"), "particle", modLoc("block/" + name(particle)));
	}

	public void chestItem(Block item, String particle) {
		this.singleTexture(name(item), new ResourceLocation(CelestialExploration.MODID, "item/chest_item"), "particle", modLoc("block/" + particle));
	}

}