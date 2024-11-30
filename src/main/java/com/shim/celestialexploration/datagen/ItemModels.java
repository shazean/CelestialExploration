package com.shim.celestialexploration.datagen;

import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestialexploration.registry.BlockRegistry;
import com.shim.celestialexploration.registry.FluidRegistry;
import com.shim.celestialexploration.registry.ItemRegistry;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ItemModels extends ItemModelProvider {

	public ItemModels(DataGenerator generator, ExistingFileHelper existingFileHelper) {
		super(generator, CelestialExploration.MODID, existingFileHelper);
	}

	@Override
	protected void registerModels() {

		//---- MOON -------------------------------------------------------------------------------
		//STONE
		self(BlockRegistry.MOON_STONE.get());
		stairsItem(BlockRegistry.MOON_STONE_STAIRS.get(), "moon_stone");
		slabItem(BlockRegistry.MOON_STONE_SLAB.get(), "moon_stone");
		buttonInventory(name(BlockRegistry.MOON_STONE_BUTTON.get()), modLoc("block/moon_stone"));
		pressurePlate(name(BlockRegistry.MOON_STONE_PRESSURE_PLATE.get()), modLoc("block/moon_stone"));

		self(BlockRegistry.MOON_COBBLESTONE.get());
		stairsItem(BlockRegistry.MOON_COBBLESTONE_STAIRS.get(), "moon_cobblestone");
		slabItem(BlockRegistry.MOON_COBBLESTONE_SLAB.get(), "moon_cobblestone");
		wallItem(BlockRegistry.MOON_COBBLESTONE_WALL.get(), "moon_cobblestone");
		self(BlockRegistry.COMPRESSED_MOON_COBBLESTONE.get());
		self(BlockRegistry.SUPER_COMPRESSED_MOON_COBBLESTONE.get());

		self(BlockRegistry.MOON_BRICKS.get());
		stairsItem(BlockRegistry.MOON_BRICK_STAIRS.get(),"moon_bricks");
		slabItem(BlockRegistry.MOON_BRICK_SLAB.get(), "moon_bricks");
		wallItem(BlockRegistry.MOON_BRICK_WALL.get(),  "moon_bricks");
		self(BlockRegistry.CHISELED_MOON_BRICKS.get());
		self(BlockRegistry.CRACKED_MOON_BRICKS.get());
		self(BlockRegistry.MOON_BRICK_PILLAR.get());

		self(BlockRegistry.MOON_SMOOTH_STONE.get());
		slabItem(BlockRegistry.MOON_SMOOTH_STONE_SLAB.get(), "moon_smooth_stone");

		//DEEPSLATE
		self(BlockRegistry.MOON_DEEPSLATE.get());
		buttonInventory(name(BlockRegistry.MOON_DEEPSLATE_BUTTON.get()), modLoc("block/moon_deepslate_side"));
		pressurePlate(name(BlockRegistry.MOON_DEEPSLATE_PRESSURE_PLATE.get()), modLoc("block/moon_deepslate_side"));

		self(BlockRegistry.MOON_COBBLED_DEEPSLATE.get());
		stairsItem(BlockRegistry.MOON_COBBLED_DEEPSLATE_STAIRS.get(), "moon_cobbled_deepslate");
		slabItem(BlockRegistry.MOON_COBBLED_DEEPSLATE_SLAB.get(), "moon_cobbled_deepslate");
		wallItem(BlockRegistry.MOON_COBBLED_DEEPSLATE_WALL.get(),"moon_cobbled_deepslate");
		self(BlockRegistry.COMPRESSED_MOON_COBBLED_DEEPSLATE.get());
		self(BlockRegistry.SUPER_COMPRESSED_MOON_COBBLED_DEEPSLATE.get());

		self(BlockRegistry.MOON_POLISHED_DEEPSLATE.get());
		stairsItem(BlockRegistry.MOON_POLISHED_DEEPSLATE_STAIRS.get(), "moon_polished_deepslate");
		slabItem(BlockRegistry.MOON_POLISHED_DEEPSLATE_SLAB.get(), "moon_polished_deepslate");
		wallItem(BlockRegistry.MOON_POLISHED_DEEPSLATE_WALL.get(), "moon_polished_deepslate");

		self(BlockRegistry.MOON_DEEPSLATE_BRICKS.get());
		stairsItem(BlockRegistry.MOON_DEEPSLATE_BRICK_STAIRS.get(), "moon_deepslate_bricks");
		slabItem(BlockRegistry.MOON_DEEPSLATE_BRICK_SLAB.get(), "moon_deepslate_bricks");
		wallItem(BlockRegistry.MOON_DEEPSLATE_BRICK_WALL.get(), "moon_deepslate_bricks");
		self(BlockRegistry.CHISELED_MOON_DEEPSLATE_BRICKS.get());
		self(BlockRegistry.CRACKED_MOON_DEEPSLATE_BRICKS.get());

		self(BlockRegistry.MOON_DEEPSLATE_TILES.get());
		stairsItem(BlockRegistry.MOON_DEEPSLATE_TILE_STAIRS.get(), "moon_deepslate_tiles");
		slabItem(BlockRegistry.MOON_DEEPSLATE_TILE_SLAB.get(),"moon_deepslate_tiles");
		wallItem(BlockRegistry.MOON_DEEPSLATE_TILE_WALL.get(), "moon_deepslate_tiles");
		self(BlockRegistry.CRACKED_MOON_DEEPSLATE_TILES.get());
		
		//ORES
		self(BlockRegistry.MOON_IRON_ORE.get());
		self(BlockRegistry.MOON_REDSTONE_ORE.get());
		self(BlockRegistry.MOON_BAUXITE_ORE.get());
		self(BlockRegistry.MOON_DEEPSLATE_IRON_ORE.get());
		self(BlockRegistry.MOON_DEEPSLATE_REDSTONE_ORE.get());

		//OTHER
		self(BlockRegistry.MOON_CORE.get());
		self(BlockRegistry.MOON_SAND.get());
		self(BlockRegistry.COARSE_MOON_SAND.get());
		self(BlockRegistry.GLOWING_MOON_SAND.get());
		self(BlockRegistry.LUNAR_LANTERN.get());
		self(BlockRegistry.MOON_SAND_PATH.get());


		//---- MARS -------------------------------------------------------------------------------
		//STONE
		self(BlockRegistry.MARS_STONE.get());
		stairsItem(BlockRegistry.MARS_STONE_STAIRS.get(), "mars_stone");
		slabItem(BlockRegistry.MARS_STONE_SLAB.get(), "mars_stone");
		buttonInventory(name(BlockRegistry.MARS_STONE_BUTTON.get()), modLoc("block/mars_stone"));
		pressurePlate(name(BlockRegistry.MARS_STONE_PRESSURE_PLATE.get()), modLoc("block/mars_stone"));

		self(BlockRegistry.MARS_COBBLESTONE.get());
		stairsItem(BlockRegistry.MARS_COBBLESTONE_STAIRS.get(), "mars_cobblestone");
		slabItem(BlockRegistry.MARS_COBBLESTONE_SLAB.get(), "mars_cobblestone");
		wallItem(BlockRegistry.MARS_COBBLESTONE_WALL.get(), "mars_cobblestone");
		self(BlockRegistry.COMPRESSED_MARS_COBBLESTONE.get());
		self(BlockRegistry.SUPER_COMPRESSED_MARS_COBBLESTONE.get());

		self(BlockRegistry.MARS_BRICKS.get());
		stairsItem(BlockRegistry.MARS_BRICK_STAIRS.get(),"mars_bricks");
		slabItem(BlockRegistry.MARS_BRICK_SLAB.get(), "mars_bricks");
		wallItem(BlockRegistry.MARS_BRICK_WALL.get(),  "mars_bricks");
		self(BlockRegistry.CHISELED_MARS_BRICKS.get());
		self(BlockRegistry.CRACKED_MARS_BRICKS.get());
		self(BlockRegistry.MARS_BRICK_PILLAR.get());

		self(BlockRegistry.MARS_SMOOTH_STONE.get());
		slabItem(BlockRegistry.MARS_SMOOTH_STONE_SLAB.get(), "mars_smooth_stone");
		
		//DEEPSLATE
		self(BlockRegistry.MARS_DEEPSLATE.get());
		buttonInventory(name(BlockRegistry.MARS_DEEPSLATE_BUTTON.get()), modLoc("block/mars_deepslate_side"));
		pressurePlate(name(BlockRegistry.MARS_DEEPSLATE_PRESSURE_PLATE.get()), modLoc("block/mars_deepslate_side"));

		self(BlockRegistry.MARS_COBBLED_DEEPSLATE.get());
		stairsItem(BlockRegistry.MARS_COBBLED_DEEPSLATE_STAIRS.get(), "mars_cobbled_deepslate");
		slabItem(BlockRegistry.MARS_COBBLED_DEEPSLATE_SLAB.get(), "mars_cobbled_deepslate");
		wallItem(BlockRegistry.MARS_COBBLED_DEEPSLATE_WALL.get(),"mars_cobbled_deepslate");
		self(BlockRegistry.COMPRESSED_MARS_COBBLED_DEEPSLATE.get());
		self(BlockRegistry.SUPER_COMPRESSED_MARS_COBBLED_DEEPSLATE.get());

		self(BlockRegistry.MARS_POLISHED_DEEPSLATE.get());
		stairsItem(BlockRegistry.MARS_POLISHED_DEEPSLATE_STAIRS.get(), "mars_polished_deepslate");
		slabItem(BlockRegistry.MARS_POLISHED_DEEPSLATE_SLAB.get(), "mars_polished_deepslate");
		wallItem(BlockRegistry.MARS_POLISHED_DEEPSLATE_WALL.get(), "mars_polished_deepslate");

		self(BlockRegistry.MARS_DEEPSLATE_BRICKS.get());
		stairsItem(BlockRegistry.MARS_DEEPSLATE_BRICK_STAIRS.get(), "mars_deepslate_bricks");
		slabItem(BlockRegistry.MARS_DEEPSLATE_BRICK_SLAB.get(), "mars_deepslate_bricks");
		wallItem(BlockRegistry.MARS_DEEPSLATE_BRICK_WALL.get(), "mars_deepslate_bricks");
		self(BlockRegistry.CHISELED_MARS_DEEPSLATE_BRICKS.get());
		self(BlockRegistry.CRACKED_MARS_DEEPSLATE_BRICKS.get());

		self(BlockRegistry.MARS_DEEPSLATE_TILES.get());
		stairsItem(BlockRegistry.MARS_DEEPSLATE_TILE_STAIRS.get(), "mars_deepslate_tiles");
		slabItem(BlockRegistry.MARS_DEEPSLATE_TILE_SLAB.get(),"mars_deepslate_tiles");
		wallItem(BlockRegistry.MARS_DEEPSLATE_TILE_WALL.get(), "mars_deepslate_tiles");
		self(BlockRegistry.CRACKED_MARS_DEEPSLATE_TILES.get());

		//ORES
		self(BlockRegistry.MARS_IRON_ORE.get());
		self(BlockRegistry.MARS_REDSTONE_ORE.get());
		self(BlockRegistry.MARS_BAUXITE_ORE.get());
		self(BlockRegistry.MARS_DEEPSLATE_IRON_ORE.get());
		self(BlockRegistry.MARS_DEEPSLATE_REDSTONE_ORE.get());

		//OTHER
		self(BlockRegistry.MARS_CORE.get());
		self(BlockRegistry.MARS_LANTERN.get());
		self(BlockRegistry.MARS_SAND.get());
		self(BlockRegistry.COARSE_MARS_SAND.get());
		self(BlockRegistry.MARS_SAND_PATH.get());


		//---- VENUS -------------------------------------------------------------------------------
		//STONE
		self(BlockRegistry.VENUS_STONE.get());
		stairsItem(BlockRegistry.VENUS_STONE_STAIRS.get(), "venus_stone");
		slabItem(BlockRegistry.VENUS_STONE_SLAB.get(), "venus_stone");
		buttonInventory(name(BlockRegistry.VENUS_STONE_BUTTON.get()), modLoc("block/venus_stone"));
		pressurePlate(name(BlockRegistry.VENUS_STONE_PRESSURE_PLATE.get()), modLoc("block/venus_stone"));

		self(BlockRegistry.VENUS_COBBLESTONE.get());
		stairsItem(BlockRegistry.VENUS_COBBLESTONE_STAIRS.get(), "venus_cobblestone");
		slabItem(BlockRegistry.VENUS_COBBLESTONE_SLAB.get(), "venus_cobblestone");
		wallItem(BlockRegistry.VENUS_COBBLESTONE_WALL.get(), "venus_cobblestone");
		self(BlockRegistry.COMPRESSED_VENUS_COBBLESTONE.get());
		self(BlockRegistry.SUPER_COMPRESSED_VENUS_COBBLESTONE.get());

		self(BlockRegistry.VENUS_BRICKS.get());
		stairsItem(BlockRegistry.VENUS_BRICK_STAIRS.get(),"venus_bricks");
		slabItem(BlockRegistry.VENUS_BRICK_SLAB.get(), "venus_bricks");
		wallItem(BlockRegistry.VENUS_BRICK_WALL.get(),  "venus_bricks");
		self(BlockRegistry.CHISELED_VENUS_BRICKS.get());
		self(BlockRegistry.CRACKED_VENUS_BRICKS.get());
		self(BlockRegistry.VENUS_BRICK_PILLAR.get());

		self(BlockRegistry.SMALL_VENUS_BRICKS.get());
		stairsItem(BlockRegistry.SMALL_VENUS_BRICK_STAIRS.get(),"small_venus_bricks");
		slabItem(BlockRegistry.SMALL_VENUS_BRICK_SLAB.get(), "small_venus_bricks");
		wallItem(BlockRegistry.SMALL_VENUS_BRICK_WALL.get(),  "small_venus_bricks");

		self(BlockRegistry.VENUS_SMOOTH_STONE.get());
		slabItem(BlockRegistry.VENUS_SMOOTH_STONE_SLAB.get(), "venus_smooth_stone");
		
		//DEEPSLATE
		self(BlockRegistry.VENUS_DEEPSLATE.get());
		buttonInventory(name(BlockRegistry.VENUS_DEEPSLATE_BUTTON.get()), modLoc("block/venus_deepslate_side"));
		pressurePlate(name(BlockRegistry.VENUS_DEEPSLATE_PRESSURE_PLATE.get()), modLoc("block/venus_deepslate_side"));

		self(BlockRegistry.VENUS_COBBLED_DEEPSLATE.get());
		stairsItem(BlockRegistry.VENUS_COBBLED_DEEPSLATE_STAIRS.get(), "venus_cobbled_deepslate");
		slabItem(BlockRegistry.VENUS_COBBLED_DEEPSLATE_SLAB.get(), "venus_cobbled_deepslate");
		wallItem(BlockRegistry.VENUS_COBBLED_DEEPSLATE_WALL.get(),"venus_cobbled_deepslate");
		self(BlockRegistry.COMPRESSED_VENUS_COBBLED_DEEPSLATE.get());
		self(BlockRegistry.SUPER_COMPRESSED_VENUS_COBBLED_DEEPSLATE.get());

		self(BlockRegistry.VENUS_POLISHED_DEEPSLATE.get());
		stairsItem(BlockRegistry.VENUS_POLISHED_DEEPSLATE_STAIRS.get(), "venus_polished_deepslate");
		slabItem(BlockRegistry.VENUS_POLISHED_DEEPSLATE_SLAB.get(), "venus_polished_deepslate");
		wallItem(BlockRegistry.VENUS_POLISHED_DEEPSLATE_WALL.get(), "venus_polished_deepslate");

		self(BlockRegistry.VENUS_DEEPSLATE_BRICKS.get());
		stairsItem(BlockRegistry.VENUS_DEEPSLATE_BRICK_STAIRS.get(), "venus_deepslate_bricks");
		slabItem(BlockRegistry.VENUS_DEEPSLATE_BRICK_SLAB.get(), "venus_deepslate_bricks");
		wallItem(BlockRegistry.VENUS_DEEPSLATE_BRICK_WALL.get(), "venus_deepslate_bricks");
		self(BlockRegistry.CHISELED_VENUS_DEEPSLATE_BRICKS.get());
		self(BlockRegistry.CRACKED_VENUS_DEEPSLATE_BRICKS.get());

		self(BlockRegistry.VENUS_DEEPSLATE_TILES.get());
		stairsItem(BlockRegistry.VENUS_DEEPSLATE_TILE_STAIRS.get(), "venus_deepslate_tiles");
		slabItem(BlockRegistry.VENUS_DEEPSLATE_TILE_SLAB.get(),"venus_deepslate_tiles");
		wallItem(BlockRegistry.VENUS_DEEPSLATE_TILE_WALL.get(), "venus_deepslate_tiles");
		self(BlockRegistry.CRACKED_VENUS_DEEPSLATE_TILES.get());

		//ORES
		self(BlockRegistry.VENUS_IRON_ORE.get());
		self(BlockRegistry.VENUS_REDSTONE_ORE.get());
		self(BlockRegistry.VENUS_BAUXITE_ORE.get());
		self(BlockRegistry.VENUS_LAPIS_ORE.get());
		self(BlockRegistry.VENUS_DEEPSLATE_LAPIS_ORE.get());
		self(BlockRegistry.VENUS_DEEPSLATE_IRON_ORE.get());
		self(BlockRegistry.VENUS_DEEPSLATE_REDSTONE_ORE.get());

		//OTHER
		self(BlockRegistry.VENUS_CORE.get());
		self(BlockRegistry.VENUS_SAND.get());
		self(BlockRegistry.FINE_VENUS_SAND.get());
		self(BlockRegistry.SULFURIC_OBSIDIAN.get());
		self(BlockRegistry.VENUS_LANTERN.get());
		self(BlockRegistry.GEYSER.get());
		self(BlockRegistry.VENUS_SAND_PATH.get());


		//---- MERCURY -------------------------------------------------------------------------------
		//STONE
		self(BlockRegistry.MERCURY_STONE.get());
		stairsItem(BlockRegistry.MERCURY_STONE_STAIRS.get(), "mercury_stone");
		slabItem(BlockRegistry.MERCURY_STONE_SLAB.get(), "mercury_stone");
		buttonInventory(name(BlockRegistry.MERCURY_STONE_BUTTON.get()), modLoc("block/mercury_stone"));
		pressurePlate(name(BlockRegistry.MERCURY_STONE_PRESSURE_PLATE.get()), modLoc("block/mercury_stone"));

		self(BlockRegistry.MERCURY_COBBLESTONE.get());
		stairsItem(BlockRegistry.MERCURY_COBBLESTONE_STAIRS.get(), "mercury_cobblestone");
		slabItem(BlockRegistry.MERCURY_COBBLESTONE_SLAB.get(), "mercury_cobblestone");
		wallItem(BlockRegistry.MERCURY_COBBLESTONE_WALL.get(), "mercury_cobblestone");
		self(BlockRegistry.COMPRESSED_MERCURY_COBBLESTONE.get());
		self(BlockRegistry.SUPER_COMPRESSED_MERCURY_COBBLESTONE.get());

		self(BlockRegistry.MERCURY_BRICKS.get());
		stairsItem(BlockRegistry.MERCURY_BRICK_STAIRS.get(),"mercury_bricks");
		slabItem(BlockRegistry.MERCURY_BRICK_SLAB.get(), "mercury_bricks");
		wallItem(BlockRegistry.MERCURY_BRICK_WALL.get(),  "mercury_bricks");
		self(BlockRegistry.CHISELED_MERCURY_BRICKS.get());
		self(BlockRegistry.CRACKED_MERCURY_BRICKS.get());
		self(BlockRegistry.MERCURY_BRICK_PILLAR.get());

		self(BlockRegistry.MERCURY_SMOOTH_STONE.get());
		slabItem(BlockRegistry.MERCURY_SMOOTH_STONE_SLAB.get(), "mercury_smooth_stone");
		//DEEPSLATE
		self(BlockRegistry.MERCURY_DEEPSLATE.get());
		buttonInventory(name(BlockRegistry.MERCURY_DEEPSLATE_BUTTON.get()), modLoc("block/mercury_deepslate_side"));
		pressurePlate(name(BlockRegistry.MERCURY_DEEPSLATE_PRESSURE_PLATE.get()), modLoc("block/mercury_deepslate_side"));

		self(BlockRegistry.MERCURY_COBBLED_DEEPSLATE.get());
		stairsItem(BlockRegistry.MERCURY_COBBLED_DEEPSLATE_STAIRS.get(), "mercury_cobbled_deepslate");
		slabItem(BlockRegistry.MERCURY_COBBLED_DEEPSLATE_SLAB.get(), "mercury_cobbled_deepslate");
		wallItem(BlockRegistry.MERCURY_COBBLED_DEEPSLATE_WALL.get(),"mercury_cobbled_deepslate");
		self(BlockRegistry.COMPRESSED_MERCURY_COBBLED_DEEPSLATE.get());
		self(BlockRegistry.SUPER_COMPRESSED_MERCURY_COBBLED_DEEPSLATE.get());

		self(BlockRegistry.MERCURY_POLISHED_DEEPSLATE.get());
		stairsItem(BlockRegistry.MERCURY_POLISHED_DEEPSLATE_STAIRS.get(), "mercury_polished_deepslate");
		slabItem(BlockRegistry.MERCURY_POLISHED_DEEPSLATE_SLAB.get(), "mercury_polished_deepslate");
		wallItem(BlockRegistry.MERCURY_POLISHED_DEEPSLATE_WALL.get(), "mercury_polished_deepslate");

		self(BlockRegistry.MERCURY_DEEPSLATE_BRICKS.get());
		stairsItem(BlockRegistry.MERCURY_DEEPSLATE_BRICK_STAIRS.get(), "mercury_deepslate_bricks");
		slabItem(BlockRegistry.MERCURY_DEEPSLATE_BRICK_SLAB.get(), "mercury_deepslate_bricks");
		wallItem(BlockRegistry.MERCURY_DEEPSLATE_BRICK_WALL.get(), "mercury_deepslate_bricks");
		self(BlockRegistry.CHISELED_MERCURY_DEEPSLATE_BRICKS.get());
		self(BlockRegistry.CRACKED_MERCURY_DEEPSLATE_BRICKS.get());

		self(BlockRegistry.MERCURY_DEEPSLATE_TILES.get());
		stairsItem(BlockRegistry.MERCURY_DEEPSLATE_TILE_STAIRS.get(), "mercury_deepslate_tiles");
		slabItem(BlockRegistry.MERCURY_DEEPSLATE_TILE_SLAB.get(),"mercury_deepslate_tiles");
		wallItem(BlockRegistry.MERCURY_DEEPSLATE_TILE_WALL.get(), "mercury_deepslate_tiles");
		self(BlockRegistry.CRACKED_MERCURY_DEEPSLATE_TILES.get());

		//ORES
		self(BlockRegistry.MERCURY_BAUXITE_ORE.get());
		self(BlockRegistry.MERCURY_SULFUR_ORE.get());
		self(BlockRegistry.MERCURY_COAL_ORE.get());
		self(BlockRegistry.MERCURY_DIAMOND_ORE.get());
		self(BlockRegistry.MERCURY_DEEPSLATE_DIAMOND_ORE.get());
		self(BlockRegistry.MERCURY_DEEPSLATE_IRON_ORE.get());
		self(BlockRegistry.MERCURY_DEEPSLATE_COAL_ORE.get());
		self(BlockRegistry.MERCURY_DEEPSLATE_REDSTONE_ORE.get());

		//OTHER
		self(BlockRegistry.MERCURY_CORE.get());
		self(BlockRegistry.MERCURY_SAND.get());
		self(BlockRegistry.COARSE_MERCURY_SAND.get());
		self(BlockRegistry.MERCURY_SAND_PATH.get());
		self(BlockRegistry.MERCURY_LANTERN.get());

		//---- JUPITER -------------------------------------------------------------------------------
		//DEEPSLATE
		self(BlockRegistry.JUPITER_DEEPSLATE.get());
		buttonInventory(name(BlockRegistry.JUPITER_DEEPSLATE_BUTTON.get()), modLoc("block/jupiter_deepslate_side"));
		pressurePlate(name(BlockRegistry.JUPITER_DEEPSLATE_PRESSURE_PLATE.get()), modLoc("block/jupiter_deepslate_side"));

		self(BlockRegistry.JUPITER_COBBLED_DEEPSLATE.get());
		stairsItem(BlockRegistry.JUPITER_COBBLED_DEEPSLATE_STAIRS.get(), "jupiter_cobbled_deepslate");
		slabItem(BlockRegistry.JUPITER_COBBLED_DEEPSLATE_SLAB.get(), "jupiter_cobbled_deepslate");
		wallItem(BlockRegistry.JUPITER_COBBLED_DEEPSLATE_WALL.get(),"jupiter_cobbled_deepslate");
		self(BlockRegistry.COMPRESSED_JUPITER_COBBLED_DEEPSLATE.get());
		self(BlockRegistry.SUPER_COMPRESSED_JUPITER_COBBLED_DEEPSLATE.get());

		self(BlockRegistry.JUPITER_POLISHED_DEEPSLATE.get());
		stairsItem(BlockRegistry.JUPITER_POLISHED_DEEPSLATE_STAIRS.get(), "jupiter_polished_deepslate");
		slabItem(BlockRegistry.JUPITER_POLISHED_DEEPSLATE_SLAB.get(), "jupiter_polished_deepslate");
		wallItem(BlockRegistry.JUPITER_POLISHED_DEEPSLATE_WALL.get(), "jupiter_polished_deepslate");

		self(BlockRegistry.JUPITER_DEEPSLATE_BRICKS.get());
		stairsItem(BlockRegistry.JUPITER_DEEPSLATE_BRICK_STAIRS.get(), "jupiter_deepslate_bricks");
		slabItem(BlockRegistry.JUPITER_DEEPSLATE_BRICK_SLAB.get(), "jupiter_deepslate_bricks");
		wallItem(BlockRegistry.JUPITER_DEEPSLATE_BRICK_WALL.get(), "jupiter_deepslate_bricks");
		self(BlockRegistry.CHISELED_JUPITER_DEEPSLATE_BRICKS.get());
		self(BlockRegistry.CRACKED_JUPITER_DEEPSLATE_BRICKS.get());

		self(BlockRegistry.JUPITER_DEEPSLATE_TILES.get());
		stairsItem(BlockRegistry.JUPITER_DEEPSLATE_TILE_STAIRS.get(), "jupiter_deepslate_tiles");
		slabItem(BlockRegistry.JUPITER_DEEPSLATE_TILE_SLAB.get(),"jupiter_deepslate_tiles");
		wallItem(BlockRegistry.JUPITER_DEEPSLATE_TILE_WALL.get(), "jupiter_deepslate_tiles");
		self(BlockRegistry.CRACKED_JUPITER_DEEPSLATE_TILES.get());

		//OTHER
		self(BlockRegistry.JUPITER_CORE.get());
		self(BlockRegistry.JUPITER_ATMOSPHERE.get());
		self(BlockRegistry.JUPITER_LANTERN.get());


		//---- JUPITER'S MOONS -------------------------------------------------------------------------------

		//IO
		self(BlockRegistry.IO_CORE.get());
		self(BlockRegistry.IO_STONE.get());
		self(BlockRegistry.IO_DEEPSLATE.get());

		//EUROPA
		self(BlockRegistry.EUROPA_CORE.get());
		self(BlockRegistry.EUROPA_HYDRATE.get());

		self(BlockRegistry.EUROPA_BRICKS.get());
		stairsItem(BlockRegistry.EUROPA_BRICK_STAIRS.get(),"europa_bricks");
		slabItem(BlockRegistry.EUROPA_BRICK_SLAB.get(), "europa_bricks");
		wallItem(BlockRegistry.EUROPA_BRICK_WALL.get(),  "europa_bricks");
//		self(BlockRegistry.CHISELED_EUROPA_BRICKS.get());
//		self(BlockRegistry.CRACKED_EUROPA_BRICKS.get());
//		self(BlockRegistry.EUROPA_BRICK_PILLAR.get());

		self(BlockRegistry.GLOWING_EUROPA_SAND.get());
		self(BlockRegistry.EUROPA_LANTERN.get());

		//GANYMEDE
		self(BlockRegistry.GANYMEDE_CORE.get());

		//CALLISTO
		self(BlockRegistry.CALLISTO_CORE.get());
		self(BlockRegistry.CALLISTO_BRICKS.get());
		stairsItem(BlockRegistry.CALLISTO_BRICK_STAIRS.get(),"callisto_bricks");
		slabItem(BlockRegistry.CALLISTO_BRICK_SLAB.get(), "callisto_bricks");
		wallItem(BlockRegistry.CALLISTO_BRICK_WALL.get(),  "callisto_bricks");
//		self(BlockRegistry.CHISELED_CALLISTO_BRICKS.get());
//		self(BlockRegistry.CRACKED_CALLISTO_BRICKS.get());
//		self(BlockRegistry.CALLISTO_BRICK_PILLAR.get());
		self(BlockRegistry.GLOWING_CALLISTO_SAND.get());
		self(BlockRegistry.CALLISTO_LANTERN.get());

		//---- OTHER PLANETS -------------------------------------------------------------------------------

		//SATURN
		self(BlockRegistry.SATURN_ATMOSPHERE.get());
		self(BlockRegistry.SATURN_CORE.get());
		self(BlockRegistry.SATURN_DEEPSLATE.get());

		self(BlockRegistry.TITAN_CORE.get());
		self(BlockRegistry.ENCELADUS_CORE.get());
		self(BlockRegistry.IAPETUS_CORE.get());
		self(BlockRegistry.RHEA_CORE.get());
		self(BlockRegistry.DIONE_CORE.get());
		self(BlockRegistry.HYPERION_CORE.get());

		//URANUS
		self(BlockRegistry.URANUS_CORE.get());
		self(BlockRegistry.URANUS_DEEPSLATE.get());
		self(BlockRegistry.URANUS_ATMOSPHERE.get());

		self(BlockRegistry.TITANIA_CORE.get());
		self(BlockRegistry.OBERON_CORE.get());

		//NEPTUNE
		self(BlockRegistry.NEPTUNE_CORE.get());
		self(BlockRegistry.NEPTUNE_ATMOSPHERE.get());
		self(BlockRegistry.NEPTUNE_DEEPSLATE.get());

		self(BlockRegistry.TRITON_CORE.get());

		//DWARF PLANETS/OTHER
//		self(BlockRegistry.PLUTO_CORE.get());
//		self(BlockRegistry.ERIS_CORE.get());
//		self(BlockRegistry.HAUMEA_CORE.get());
//		self(BlockRegistry.CERES_CORE.get());
//		self(BlockRegistry.MAKEMAKE_CORE.get());

		//---- CELESTIAL OBJECTS -------------------------------------------------------------------------------
		//METEOR
		self(BlockRegistry.METEOR.get());
		buttonInventory(name(BlockRegistry.METEOR_BUTTON.get()), modLoc("block/meteor"));
		pressurePlate(name(BlockRegistry.METEOR_PRESSURE_PLATE.get()), modLoc("block/meteor"));

		self(BlockRegistry.METEOR_BRICKS.get());
		stairsItem(BlockRegistry.METEOR_BRICK_STAIRS.get(), "meteor_bricks");
		slabItem(BlockRegistry.METEOR_BRICK_SLAB.get(), "meteor_bricks");
		wallItem(BlockRegistry.METEOR_BRICK_WALL.get(), "meteor_bricks");
		self(BlockRegistry.CHISELED_METEOR_BRICKS.get());
		
		//METEOR ORE
		self(BlockRegistry.METEOR_COAL_ORE.get());
		self(BlockRegistry.METEOR_COPPER_ORE.get());
		self(BlockRegistry.METEOR_DIAMOND_ORE.get());
		self(BlockRegistry.METEOR_EMERALD_ORE.get());
		self(BlockRegistry.METEOR_GOLD_ORE.get());
		self(BlockRegistry.METEOR_IRON_ORE.get());
		self(BlockRegistry.METEOR_LAPIS_ORE.get());
		self(BlockRegistry.METEOR_SULFUR_ORE.get());
		self(BlockRegistry.METEOR_REDSTONE_ORE.get());
		self(BlockRegistry.METEOR_BAUXITE_ORE.get());
		
		//SUN
		self(BlockRegistry.SOLAR_PLASMA.get());
		self(BlockRegistry.SOLAR_FLARE.get());
		self(BlockRegistry.SUN_SPOT.get());

		//---- ORE-RELATED -------------------------------------------------------------------------------
		self(BlockRegistry.ALUMINUM_BLOCK.get());
		self(BlockRegistry.STEEL_BLOCK.get());
		generatedItem(ItemRegistry.STEEL_INGOT.get());
		generatedItem(ItemRegistry.STEEL_NUGGET.get());
		generatedItem(ItemRegistry.BAUXITE_INGOT.get());
		generatedItem(ItemRegistry.ALUMINUM_INGOT.get());
		generatedItem(ItemRegistry.RAW_BAUXITE.get());
		generatedItem(ItemRegistry.RUSTED_IRON_NUGGET.get());
		self(BlockRegistry.BAUXITE_ORE.get());

		//---- SPACESHIP -------------------------------------------------------------------------------
		self(BlockRegistry.OXYGEN_COMPRESSOR.get());
		self(BlockRegistry.WORKBENCH.get());

		generatedItem(ItemRegistry.SPACESHIP_FRAME.get());
		generatedItem(ItemRegistry.SPACESHIP_CABIN.get());
		generatedItem(ItemRegistry.SPACESHIP_ENGINE.get());

		generatedItem(ItemRegistry.BLACK_SPACESHIP.get());
		generatedItem(ItemRegistry.GREY_SPACESHIP.get());
		generatedItem(ItemRegistry.LIGHT_GREY_SPACESHIP.get());
		generatedItem(ItemRegistry.WHITE_SPACESHIP.get());
		generatedItem(ItemRegistry.PINK_SPACESHIP.get());
		generatedItem(ItemRegistry.MAGENTA_SPACESHIP.get());
		generatedItem(ItemRegistry.RED_SPACESHIP.get());
		generatedItem(ItemRegistry.BROWN_SPACESHIP.get());
		generatedItem(ItemRegistry.ORANGE_SPACESHIP.get());
		generatedItem(ItemRegistry.YELLOW_SPACESHIP.get());
		generatedItem(ItemRegistry.LIME_SPACESHIP.get());
		generatedItem(ItemRegistry.GREEN_SPACESHIP.get());
		generatedItem(ItemRegistry.CYAN_SPACESHIP.get());
		generatedItem(ItemRegistry.LIGHT_BLUE_SPACESHIP.get());
		generatedItem(ItemRegistry.BLUE_SPACESHIP.get());
		generatedItem(ItemRegistry.PURPLE_SPACESHIP.get());

		//---- SPACE STATION -------------------------------------------------------------------------------
		self(BlockRegistry.INSULATED_PANEL.get());
		self(BlockRegistry.INSULATED_PANEL_CORNER.get());
		self(BlockRegistry.PANEL.get());
		stairs("panel_stairs", modLoc("block/panel"), modLoc("block/panel"), modLoc("block/panel"));
		slab("panel_slab", modLoc("block/panel"), modLoc("block/panel"), modLoc("block/panel"));
		wallInventory("panel_wall",  modLoc("block/panel"));
		generatedBlockItem(BlockRegistry.THIN_PANEL.get(), "block/panel");
		generatedBlockItem(BlockRegistry.STEEL_LADDER.get());
		
		buttonInventory(name(BlockRegistry.RED_BUTTON.get()), modLoc("block/red_ceramic"));
		buttonInventory(name(BlockRegistry.YELLOW_BUTTON.get()), modLoc("block/yellow_ceramic"));
		buttonInventory(name(BlockRegistry.BLUE_BUTTON.get()), modLoc("block/blue_ceramic"));
		buttonInventory(name(BlockRegistry.GREEN_BUTTON.get()), modLoc("block/green_ceramic"));
		buttonInventory(name(BlockRegistry.WHITE_BUTTON.get()), modLoc("block/white_ceramic"));
		buttonInventory(name(BlockRegistry.BLACK_BUTTON.get()), modLoc("block/black_ceramic"));

		self(BlockRegistry.PATHWAY_LIGHT.get());
		self(BlockRegistry.SOLAR_PANEL.get());
		self(BlockRegistry.GLOW_STRIP.get());
		self(BlockRegistry.HORIZONTAL_GLOW_STRIP.get());

		generatedBlockItem(BlockRegistry.AIRLOCK_PANEL_DOOR.get(), "block/airlock_panel_hinge");
		generatedBlockItem(BlockRegistry.AIRLOCK_PANEL_DOOR_WINDOW.get(), "block/airlock_panel_window");
		generatedBlockItem(BlockRegistry.HANGAR_DOOR.get(), "block/hangar_hinge");
		generatedBlockItem(BlockRegistry.HANGAR_DOOR_WINDOW.get(), "block/hangar_window");

		generatedBlockItem(BlockRegistry.AIRLOCK_DOOR.get(), "item/airlock_door");
		generatedBlockItem(BlockRegistry.STEEL_DOOR.get(), "item/steel_door");
		withExistingParent(name(BlockRegistry.AIRLOCK_TRAPDOOR.get()), modLoc("block/airlock_trapdoor_bottom"));
		withExistingParent(name(BlockRegistry.STEEL_TRAPDOOR.get()), modLoc("block/steel_trapdoor_bottom"));
		buttonInventory(name(BlockRegistry.STEEL_BUTTON.get()), modLoc("block/steel_block"));
		buttonInventory(name(BlockRegistry.AIRLOCK_BUTTON.get()), modLoc("block/airlock_button"));

		//---- MAG LEV -------------------------------------------------------------------------------
		generatedBlockItem(BlockRegistry.MAG_RAIL.get());
		generatedBlockItem(BlockRegistry.POWERED_MAG_RAIL.get());
		generatedBlockItem(BlockRegistry.DETECTOR_MAG_RAIL.get());
		generatedBlockItem(BlockRegistry.ACTIVATOR_MAG_RAIL.get());
		generatedItem(ItemRegistry.MAGCART.get());
		generatedItem(ItemRegistry.CHEST_MAGCART.get());
		generatedItem(ItemRegistry.COMMAND_BLOCK_MAGCART.get());
		generatedItem(ItemRegistry.FURNACE_MAGCART.get());
		generatedItem(ItemRegistry.HOPPER_MAGCART.get());
		generatedItem(ItemRegistry.TNT_MAGCART.get());

		//---- ARMOR -------------------------------------------------------------------------------
		//STEEL
		generatedItem(ItemRegistry.STEEL_HELMET.get());
		generatedItem(ItemRegistry.STEEL_LEGGINGS.get());
		generatedItem(ItemRegistry.STEEL_CHESTPLATE.get());
		generatedItem(ItemRegistry.STEEL_BOOTS.get());

		//SPACESUIT
		generatedItem(ItemRegistry.BASIC_SPACESUIT_HELMET.get());
		generatedItem(ItemRegistry.BASIC_SPACESUIT_LEGGINGS.get());
		generatedItem(ItemRegistry.BASIC_SPACESUIT_CHESTPLATE.get());
		generatedItem(ItemRegistry.BASIC_SPACESUIT_BOOTS.get());
		generatedItem(ItemRegistry.HEAVY_DUTY_SPACESUIT_HELMET.get());
		generatedItem(ItemRegistry.HEAVY_DUTY_SPACESUIT_LEGGINGS.get());
		generatedItem(ItemRegistry.HEAVY_DUTY_SPACESUIT_CHESTPLATE.get());
		generatedItem(ItemRegistry.HEAVY_DUTY_SPACESUIT_BOOTS.get());
		generatedItem(ItemRegistry.THERMAL_SPACESUIT_HELMET.get());
		generatedItem(ItemRegistry.THERMAL_SPACESUIT_LEGGINGS.get());
		generatedItem(ItemRegistry.THERMAL_SPACESUIT_CHESTPLATE.get());
		generatedItem(ItemRegistry.THERMAL_SPACESUIT_BOOTS.get());
		generatedItem(ItemRegistry.ADVANCED_SPACESUIT_HELMET.get());
		generatedItem(ItemRegistry.ADVANCED_SPACESUIT_LEGGINGS.get());
		generatedItem(ItemRegistry.ADVANCED_SPACESUIT_CHESTPLATE.get());
		generatedItem(ItemRegistry.ADVANCED_SPACESUIT_BOOTS.get());
		
		//---- GLASS/CERAMICS -------------------------------------------------------------------------------
		//GLASS
		self(BlockRegistry.LUMINOUS_BLUE_GLASS.get());
		self(BlockRegistry.LUMINOUS_WHITE_GLASS.get());
		self(BlockRegistry.LUMINOUS_CYAN_GLASS.get());
		self(BlockRegistry.LUMINOUS_MAGENTA_GLASS.get());
		generatedBlockItem(BlockRegistry.LUMINOUS_MAGENTA_GLASS_PANE.get(), "block/luminous_magenta_glass");
		generatedBlockItem(BlockRegistry.LUMINOUS_BLUE_GLASS_PANE.get(), "block/luminous_blue_glass");
		generatedBlockItem(BlockRegistry.LUMINOUS_CYAN_GLASS_PANE.get(), "block/luminous_cyan_glass");
		generatedBlockItem(BlockRegistry.LUMINOUS_WHITE_GLASS_PANE.get(), "block/luminous_white_glass");

		withExistingParent(name(BlockRegistry.REINFORCED_GLASS.get()), modLoc("block/reinforced_glass_inventory"));
		generatedBlockItem(BlockRegistry.REINFORCED_GLASS_PANE.get(), "block/reinforced_glass");

		//CERAMIC
		self(BlockRegistry.SILICA.get());

		self(BlockRegistry.CERAMIC.get());
		generatedBlockItem(BlockRegistry.CERAMIC_TILE.get(), "block/ceramic");

		self(BlockRegistry.WHITE_CERAMIC.get());
		generatedBlockItem(BlockRegistry.WHITE_CERAMIC_TILE.get(), "block/white_ceramic");
		self(BlockRegistry.LIGHT_GREY_CERAMIC.get());
		generatedBlockItem(BlockRegistry.LIGHT_GREY_CERAMIC_TILE.get(), "block/light_grey_ceramic");
		self(BlockRegistry.GREY_CERAMIC.get());
		generatedBlockItem(BlockRegistry.GREY_CERAMIC_TILE.get(), "block/grey_ceramic");
		self(BlockRegistry.BLACK_CERAMIC.get());
		generatedBlockItem(BlockRegistry.BLACK_CERAMIC_TILE.get(), "block/black_ceramic");
		self(BlockRegistry.PURPLE_CERAMIC.get());
		generatedBlockItem(BlockRegistry.PURPLE_CERAMIC_TILE.get(), "block/purple_ceramic");
		self(BlockRegistry.MAGENTA_CERAMIC.get());
		generatedBlockItem(BlockRegistry.MAGENTA_CERAMIC_TILE.get(), "block/magenta_ceramic");
		self(BlockRegistry.BLUE_CERAMIC.get());
		generatedBlockItem(BlockRegistry.BLUE_CERAMIC_TILE.get(), "block/blue_ceramic");
		self(BlockRegistry.LIGHT_BLUE_CERAMIC.get());
		generatedBlockItem(BlockRegistry.LIGHT_BLUE_CERAMIC_TILE.get(), "block/light_blue_ceramic");
		self(BlockRegistry.CYAN_CERAMIC.get());
		generatedBlockItem(BlockRegistry.CYAN_CERAMIC_TILE.get(), "block/cyan_ceramic");
		self(BlockRegistry.GREEN_CERAMIC.get());
		generatedBlockItem(BlockRegistry.GREEN_CERAMIC_TILE.get(), "block/green_ceramic");
		self(BlockRegistry.LIME_CERAMIC.get());
		generatedBlockItem(BlockRegistry.LIME_CERAMIC_TILE.get(), "block/lime_ceramic");
		self(BlockRegistry.YELLOW_CERAMIC.get());
		generatedBlockItem(BlockRegistry.YELLOW_CERAMIC_TILE.get(), "block/yellow_ceramic");
		self(BlockRegistry.ORANGE_CERAMIC.get());
		generatedBlockItem(BlockRegistry.ORANGE_CERAMIC_TILE.get(), "block/orange_ceramic");
		self(BlockRegistry.BROWN_CERAMIC.get());
		generatedBlockItem(BlockRegistry.BROWN_CERAMIC_TILE.get(), "block/brown_ceramic");
		self(BlockRegistry.RED_CERAMIC.get());
		generatedBlockItem(BlockRegistry.RED_CERAMIC_TILE.get(), "block/red_ceramic");
		self(BlockRegistry.PINK_CERAMIC.get());
		generatedBlockItem(BlockRegistry.PINK_CERAMIC_TILE.get(), "block/pink_ceramic");

		self(BlockRegistry.PAINTED_WHITE_CERAMIC.get());
		self(BlockRegistry.PAINTED_LIGHT_GREY_CERAMIC.get());
		self(BlockRegistry.PAINTED_GREY_CERAMIC.get());
		self(BlockRegistry.PAINTED_BLACK_CERAMIC.get());
		self(BlockRegistry.PAINTED_PURPLE_CERAMIC.get());
		self(BlockRegistry.PAINTED_MAGENTA_CERAMIC.get());
		self(BlockRegistry.PAINTED_BLUE_CERAMIC.get());
		self(BlockRegistry.PAINTED_LIGHT_BLUE_CERAMIC.get());
		self(BlockRegistry.PAINTED_CYAN_CERAMIC.get());
		self(BlockRegistry.PAINTED_GREEN_CERAMIC.get());
		self(BlockRegistry.PAINTED_LIME_CERAMIC.get());
		self(BlockRegistry.PAINTED_YELLOW_CERAMIC.get());
		self(BlockRegistry.PAINTED_ORANGE_CERAMIC.get());
		self(BlockRegistry.PAINTED_BROWN_CERAMIC.get());
		self(BlockRegistry.PAINTED_RED_CERAMIC.get());
		self(BlockRegistry.PAINTED_PINK_CERAMIC.get());

		//---- FOOD -------------------------------------------------------------------------------
		generatedItem(ItemRegistry.MARSHMALLOW_GOO.get());
		generatedItem(ItemRegistry.MARSHMALLOW.get());
		generatedItem(ItemRegistry.ROASTED_MARSHMALLOW.get());
		generatedItem(ItemRegistry.CHOCOLATE.get());
		generatedItem(ItemRegistry.CRACKER.get());
		generatedItem(ItemRegistry.SMORES.get());

		generatedItem(ItemRegistry.LUNAR_CHEESE.get());
		generatedItem(ItemRegistry.CHEESE.get());
		generatedItem(ItemRegistry.SUSPICIOUS_JELLO.get());


		//---- MISC -------------------------------------------------------------------------------
		//BUCKETS
		generatedItem(FluidRegistry.LOX_BUCKET.get());
		singleTexture(name(FluidRegistry.MOLTEN_IRON_BUCKET.get()), new ResourceLocation("item/generated"), "layer0", new ResourceLocation("item/lava_bucket"));
		singleTexture(name(FluidRegistry.MOLTEN_STEEL_BUCKET.get()), new ResourceLocation("item/generated"), "layer0", new ResourceLocation("item/lava_bucket"));
		singleTexture(name(FluidRegistry.MOLTEN_COPPER_BUCKET.get()), new ResourceLocation("item/generated"), "layer0", new ResourceLocation("item/lava_bucket"));
		singleTexture(name(FluidRegistry.MOLTEN_GOLD_BUCKET.get()), new ResourceLocation("item/generated"), "layer0", new ResourceLocation("item/lava_bucket"));
		singleTexture(name(FluidRegistry.MOLTEN_ALUMINUM_BUCKET.get()), new ResourceLocation("item/generated"), "layer0", new ResourceLocation("item/lava_bucket"));
		generatedItem(FluidRegistry.SULFUR_BUCKET.get());
		generatedItem(FluidRegistry.METALLIC_HYDROGEN_BUCKET.get());
		generatedItem(ItemRegistry.EUREKA_BUCKET.get());

		//BLOCKS
		self(BlockRegistry.DRY_ICE.get());
		self(BlockRegistry.COMPRESSED_COBBLESTONE.get());
		self(BlockRegistry.COMPRESSED_COBBLED_DEEPSLATE.get());
		self(BlockRegistry.COMPRESSED_NETHERRACK.get());
		self(BlockRegistry.SUPER_COMPRESSED_COBBLESTONE.get());
		self(BlockRegistry.SUPER_COMPRESSED_COBBLED_DEEPSLATE.get());
		self(BlockRegistry.SUPER_COMPRESSED_NETHERRACK.get());

		self(BlockRegistry.PLANET_CHART.get());
		self(BlockRegistry.TAXI_STATION.get());

		//ITEMS
		generatedItem(ItemRegistry.MOON_DUST.get());
		generatedItem(ItemRegistry.EUROPA_DUST.get());
		generatedItem(ItemRegistry.CALLISTO_DUST.get());
		handheldItem(ItemRegistry.STEEL_ROD.get());
		generatedItem(ItemRegistry.STEEL_WOOL.get());
		handheldItem(ItemRegistry.FLARE_ROD.get());
		generatedItem(ItemRegistry.BLOCK_MOLD.get());
		generatedItem(ItemRegistry.INGOT_MOLD.get());
		generatedItem(ItemRegistry.SULFUR_CRYSTAL.get());
		generatedItem(ItemRegistry.LUNAR_GOO.get());
		generatedItem(ItemRegistry.CINNABAR.get());

		//SPAWN EGGS
		spawnEgg(ItemRegistry.RUST_SPAWN_EGG.get());
		spawnEgg(ItemRegistry.LUNAR_SPAWN_EGG.get());
		spawnEgg(ItemRegistry.MARS_MALLOW_SPAWN_EGG.get());
		spawnEgg(ItemRegistry.QUICKSILVER_SPAWN_EGG.get());
		spawnEgg(ItemRegistry.VISCOUS_SPAWN_EGG.get());
		spawnEgg(ItemRegistry.LURKER_SPAWN_EGG.get());
		spawnEgg(ItemRegistry.VOIDFELLOW_SPAWN_EGG.get());
		spawnEgg(ItemRegistry.VOIDED_SPAWN_EGG.get());
		spawnEgg(ItemRegistry.SULFUR_CUBE_SPAWN_EGG.get());
		spawnEgg(ItemRegistry.VOIDED_PIGLIN_SPAWN_EGG.get());
		spawnEgg(ItemRegistry.ASTRAL_PIGLIN_SPAWN_EGG.get());
		spawnEgg(ItemRegistry.CYBORG_PIGLIN_SPAWN_EGG.get());
		spawnEgg(ItemRegistry.FLARE_SPAWN_EGG.get());
		spawnEgg(ItemRegistry.GUST_SPAWN_EGG.get());
		spawnEgg(ItemRegistry.GYST_SPAWN_EGG.get());
		spawnEgg(ItemRegistry.VOIDED_ZOGLIN_SPAWN_EGG.get());
		spawnEgg(ItemRegistry.ASTRAL_HOGLIN_SPAWN_EGG.get());
		spawnEgg(ItemRegistry.METEOR_CRAWLER_SPAWN_EGG.get());
		spawnEgg(ItemRegistry.VOID_CRAWLER_SPAWN_EGG.get());
		spawnEgg(ItemRegistry.CELESTIAL_CAT_SPAWN_EGG.get());
		spawnEgg(ItemRegistry.EUREKA_SPAWN_EGG.get());

		this.withExistingParent(name(BlockRegistry.LURKER_HEAD.get()), this.mcLoc("item/template_skull"));
		this.withExistingParent(name(BlockRegistry.VOIDED_HEAD.get()), this.mcLoc("item/template_skull"));

//		generatedItem(ItemRegistry.CONTROL_PANEL.get());

	}

	private String name(Block block) {
		return block.getRegistryName().getPath();
	}

	private String name(Item item) {
		return item.getRegistryName().getPath();
	}


	protected void self(Block block) {
		this.withExistingParent(name(block), this.modLoc("block/" + name(block)));
	}

	protected void spawnEgg(Item item) {
		this.withExistingParent(name(item), this.mcLoc("item/template_spawn_egg"));
	}

	public void generatedBlockItem(Block item) {
		this.singleTexture(name(item), new ResourceLocation("item/generated"), "layer0", modLoc("block/" + name(item)));
	}

	public void generatedBlockItem(Block item, String path) {
		this.singleTexture(name(item), new ResourceLocation("item/generated"), "layer0", modLoc(path));
	}

	//for all non hand-held single-texture items
	public void generatedItem(Item item) {
		this.singleTexture(name(item), new ResourceLocation("item/generated"), "layer0", modLoc("item/" + name(item)));
	}

	//for weapons, tools, sticks, etc.
	public void handheldItem(Item item) {
		this.singleTexture(name(item), new ResourceLocation("item/handheld"), "layer0", modLoc("item/" + name(item)));
	}

	public void stairsItem(Block stairs, String textureName) {
		stairs(name(stairs), modLoc("block/" + textureName), modLoc("block/" + textureName), modLoc("block/" + textureName));
	}

	public void slabItem(Block slab, String textureName) {
		slab(name(slab), modLoc("block/" + textureName), modLoc("block/" + textureName), modLoc("block/" + textureName));
	}

	public void wallItem(Block wall, String textureName) {
		wallInventory(name(wall), modLoc("block/" + textureName));
	}
}