package com.shim.celestialexploration.datagen;

import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestialexploration.registry.*;

import net.minecraft.data.DataGenerator;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.LanguageProvider;

public class ModLanguageProvider extends LanguageProvider {

	public ModLanguageProvider(DataGenerator gen, String locale) {
		super(gen, CelestialExploration.MODID, locale);
	}

	@Override
	protected void addTranslations() {
		/**TABS**/
		add("itemGroup.celestialblockstab", "Celestial Blocks");
		add("itemGroup.shuttletab", "Shuttle Items");
		add("itemGroup.celestialmisctab", "Celestial Items");

		/**BIOMES**/
		add("biomes.celestialexploration.moon_craters", "Lunar Craters");
		add("biomes.celestialexploration.moon_desert", "Lunar Desert");
		add("biomes.celestialexploration.moon_lava_flats", "Lunar Lava Flats");
		add("biomes.celestialexploration.moon_lower_plains", "Lunar Lower Plains");
		add("biomes.celestialexploration.moon_plains", "Lunar Plains");
		add("biomes.celestialexploration.mars_craters_", "Martian Craters");
		add("biomes.celestialexploration.mars_deep_craters", "Martian Deep Craters");
		add("biomes.celestialexploration.mars_desert", "Martian Desert");
		add("biomes.celestialexploration.mars_dunes", "Martian Dunes");
		add("biomes.celestialexploration.mars_dry_ice_flats", "Martian Dry Ice Flats");
		add("biomes.celestialexploration.mars_dry_ice_peaks", "Martian Dry Ice Peaks");
		add("biomes.celestialexploration.mars_eroded_flats", "Martian Eroded Flats");
		add("biomes.celestialexploration.mars_volcano_flats", "Martian Volcano Flats");
		add("biomes.celestialexploration.asteroid_field", "Asteroid Field");
		add("biomes.celestialexploration.earth_orbit", "Earthen Orbit");
		add("biomes.celestialexploration.empty_space", "Empty Space");
		add("biomes.celestialexploration.large_asteroid", "Large Asteroid");
		add("biomes.celestialexploration.mars_orbit", "Martian Orbit");
		add("biomes.celestialexploration.sparse_asteroid_field", "Sparse Asteroid Field");

		/**MOON**/
		add(BlockRegistry.MOON_BRICK_SLAB.get(), "Lunar Brick Slab");
		add(BlockRegistry.MOON_BRICK_STAIRS.get(), "Lunar Brick Stairs");
		add(BlockRegistry.MOON_BRICK_WALL.get(), "Lunar Brick Wall");
		add(BlockRegistry.MOON_BRICKS.get(), "Lunar Bricks");
		add(BlockRegistry.MOON_IRON_ORE.get(), "Lunar Iron Ore");
		add(BlockRegistry.MOON_REDSTONE_ORE.get(), "Lunar Redstone Ore");
		add(BlockRegistry.MOON_SAND.get(), "Lunar Regolith");
		add(BlockRegistry.MOON_STONE.get(), "Lunar Stone");
		add(BlockRegistry.CHISELED_MOON_BRICKS.get(), "Chiseled Lunar Bricks");
		add(BlockRegistry.GLOWING_MOON_SAND.get(), "Glowing Lunar Regolith");
		add(BlockRegistry.COARSE_MOON_SAND.get(), "Coarse Lunar Regolith");
		add(BlockRegistry.LUNAR_LANTERN.get(), "Lunar Lantern");
		add(ItemRegistry.MOON_DUST.get(), "Lunar Dust");
		add(BlockRegistry.MOON_COBBLESTONE.get(), "Lunar Cobblestone");
		add(BlockRegistry.MOON_BRICK_PILLAR.get(), "Lunar Brick Pillar");
		add(BlockRegistry.MOON_DEEPSLATE.get(), "Lunar Deepslate");
		add(BlockRegistry.MOON_COBBLED_DEEPSLATE.get(), "Lunar Cobbled Deepslate");
		add(BlockRegistry.MOON_STONE_STAIRS.get(), "Lunar Stone Stairs");
		add(BlockRegistry.MOON_STONE_SLAB.get(), "Lunar Stone Slab");
		add(BlockRegistry.MOON_COBBLESTONE_SLAB.get(), "Lunar Cobblestone Slab");
		add(BlockRegistry.MOON_COBBLESTONE_STAIRS.get(), "Lunar Cobblestone Stairs");
		add(BlockRegistry.MOON_COBBLESTONE_WALL.get(), "Lunar Cobblestone Wall");
		add(BlockRegistry.MOON_COBBLED_DEEPSLATE_SLAB.get(), "Lunar Cobbled Deepslate Slab");
		add(BlockRegistry.MOON_COBBLED_DEEPSLATE_STAIRS.get(), "Lunar Cobbled Deepslate Stairs");
		add(BlockRegistry.MOON_COBBLED_DEEPSLATE_WALL.get(), "Lunar Cobbled Deeplsate Wall");
		add(BlockRegistry.MOON_SMOOTH_STONE.get(), "Lunar Smooth Stone");
//		add(BlockRegistry.MOON_SMOOTH_STONE_SLAB.get(), "Lunar Smooth Stone Slab");
		add(BlockRegistry.CRACKED_MOON_BRICKS.get(), "Cracked Lunar Bricks");
		add(BlockRegistry.MOON_DEEPSLATE_IRON_ORE.get(), "Lunar Deepslate Iron Ore");
		add(BlockRegistry.MOON_DEEPSLATE_REDSTONE_ORE.get(), "Lunar Deepslate Redstone Ore");

		add(BlockRegistry.MOON_DEEPSLATE_BRICKS.get(), "Lunar Deepslate Bricks");
		add(BlockRegistry.MOON_DEEPSLATE_BRICK_SLAB.get(), "Lunar Deepslate Brick Slab");
		add(BlockRegistry.MOON_DEEPSLATE_BRICK_STAIRS.get(), "Lunar Deepslate Brick Stairs");
		add(BlockRegistry.MOON_DEEPSLATE_BRICK_WALL.get(), "Lunar Deepslate Brick Wall");
		add(BlockRegistry.CRACKED_MOON_DEEPSLATE_BRICKS.get(), "Cracked Lunar Deepslate Bricks");
		add(BlockRegistry.CHISELED_MOON_DEEPSLATE_BRICKS.get(), "Chiseled Lunar Deepslate Bricks");


		add(BlockRegistry.MOON_DEEPSLATE_TILES.get(), "Lunar Deepslate Tiles");
		add(BlockRegistry.MOON_DEEPSLATE_TILE_SLAB.get(), "Lunar Deepslate Tile Slab");
		add(BlockRegistry.MOON_DEEPSLATE_TILE_STAIRS.get(), "Lunar Deepslate Tile Stairs");
		add(BlockRegistry.MOON_DEEPSLATE_TILE_WALL.get(), "Lunar Deepslate Tile Wall");
		add(BlockRegistry.CRACKED_MOON_DEEPSLATE_TILES.get(), "Cracked Lunar Deepslate Tiles");


		add(BlockRegistry.MOON_POLISHED_DEEPSLATE.get(), "Lunar Polished Deepslate");
		add(BlockRegistry.MOON_POLISHED_DEEPSLATE_SLAB.get(), "Lunar Polished Deepslate Slab");
		add(BlockRegistry.MOON_POLISHED_DEEPSLATE_STAIRS.get(), "Lunar Polished Deepslate Stairs");
		add(BlockRegistry.MOON_POLISHED_DEEPSLATE_WALL.get(), "Lunar Polished Deepslate Wall");

		add(BlockRegistry.MOON_STONE_BUTTON.get(), "Lunar Stone Button");
		add(BlockRegistry.MOON_STONE_PRESSURE_PLATE.get(), "Lunar Stone Pressure Plate");
		add(BlockRegistry.MOON_DEEPSLATE_BUTTON.get(), "Lunar Deepslate Button");
		add(BlockRegistry.MOON_DEEPSLATE_PRESSURE_PLATE.get(), "Lunar Deepslate Pressure Plate");

		add(BlockRegistry.COMPRESSED_MOON_COBBLESTONE.get(), "Compressed Lunar Cobblestone");
		add(BlockRegistry.COMPRESSED_MOON_COBBLED_DEEPSLATE.get(), "Compressed Lunar Cobbled Deepslate");


		/**MARS**/
		add(BlockRegistry.CHISELED_MARS_BRICKS.get(), "Chiseled Martian Bricks");
		add(BlockRegistry.MARS_BRICK_SLAB.get(), "Martian Brick Slab");
		add(BlockRegistry.MARS_BRICK_STAIRS.get(), "Martian Brick Stairs");
		add(BlockRegistry.MARS_BRICK_WALL.get(), "Martian Brick Wall");
		add(BlockRegistry.MARS_BRICKS.get(), "Martian Bricks");
		add(BlockRegistry.MARS_IRON_ORE.get(), "Martian Iron Ore");
		add(BlockRegistry.MARS_REDSTONE_ORE.get(), "Martian Redstone Ore");
		add(BlockRegistry.MARS_SAND.get(), "Martian Regolith");
		add(BlockRegistry.MARS_STONE.get(), "Martian Stone");
		add(BlockRegistry.MARS_COBBLESTONE.get(), "Martian Cobblestone");
		add(BlockRegistry.MARS_BRICK_PILLAR.get(), "Martian Brick Pillar");
		add(BlockRegistry.MARS_DEEPSLATE.get(), "Martian Deepslate");
		add(BlockRegistry.MARS_COBBLED_DEEPSLATE.get(), "Martian Cobbled Deepslate");
		add(BlockRegistry.MARS_STONE_SLAB.get(), "Martian Stone Slab");
		add(BlockRegistry.MARS_DEEPSLATE_IRON_ORE.get(), "Martian Deepslate Iron Ore");
		add(BlockRegistry.MARS_DEEPSLATE_REDSTONE_ORE.get(), "Martian Deepslate Redstone Ore");

		add(BlockRegistry.MARS_COBBLESTONE_SLAB.get(), "Martian Cobblestone Slab");
		add(BlockRegistry.MARS_COBBLESTONE_STAIRS.get(), "Martian Cobblestone Stairs");
		add(BlockRegistry.MARS_COBBLESTONE_WALL.get(), "Martian Cobblestone Wall");
		add(BlockRegistry.MARS_COBBLED_DEEPSLATE_SLAB.get(), "Martian Cobbled Deepslate Slab");
		add(BlockRegistry.MARS_COBBLED_DEEPSLATE_STAIRS.get(), "Martian Cobbled Deepslate Stairs");
		add(BlockRegistry.MARS_COBBLED_DEEPSLATE_WALL.get(), "Martian Cobbled Deeplsate Wall");

		add(BlockRegistry.MARS_SMOOTH_STONE.get(), "Martian Smooth Stone");
//		add(BlockRegistry.MARS_SMOOTH_STONE_SLAB.get(), "Martian Smooth Stone Slab");
		add(BlockRegistry.CRACKED_MARS_BRICKS.get(), "Cracked Martian Bricks");

		add(BlockRegistry.MARS_DEEPSLATE_BRICKS.get(), "Martian Deepslate Bricks");
		add(BlockRegistry.MARS_DEEPSLATE_BRICK_SLAB.get(), "Martian Deepslate Brick Slab");
		add(BlockRegistry.MARS_DEEPSLATE_BRICK_STAIRS.get(), "Martian Deepslate Brick Stairs");
		add(BlockRegistry.MARS_DEEPSLATE_BRICK_WALL.get(), "Martian Deepslate Brick Wall");
		add(BlockRegistry.CRACKED_MARS_DEEPSLATE_BRICKS.get(), "Cracked Martian Deepslate Bricks");
		add(BlockRegistry.CHISELED_MARS_DEEPSLATE_BRICKS.get(), "Chiseled Martian Deepslate Bricks");


		add(BlockRegistry.MARS_DEEPSLATE_TILES.get(), "Martian Deepslate Tiles");
		add(BlockRegistry.MARS_DEEPSLATE_TILE_SLAB.get(), "Martian Deepslate Tile Slab");
		add(BlockRegistry.MARS_DEEPSLATE_TILE_STAIRS.get(), "Martian Deepslate Tile Stairs");
		add(BlockRegistry.MARS_DEEPSLATE_TILE_WALL.get(), "Martian Deepslate Tile Wall");
		add(BlockRegistry.CRACKED_MARS_DEEPSLATE_TILES.get(), "Cracked Martian Deepslate Tiles");

		add(BlockRegistry.MARS_POLISHED_DEEPSLATE.get(), "Martian Polished Deepslate");
		add(BlockRegistry.MARS_POLISHED_DEEPSLATE_SLAB.get(), "Martian Polished Deepslate Slab");
		add(BlockRegistry.MARS_POLISHED_DEEPSLATE_STAIRS.get(), "Martian Polished Deepslate Stairs");
		add(BlockRegistry.MARS_POLISHED_DEEPSLATE_WALL.get(), "Martian Polished Deepslate Wall");

		add(BlockRegistry.MARS_STONE_BUTTON.get(), "Martian Stone Button");
		add(BlockRegistry.MARS_STONE_PRESSURE_PLATE.get(), "Martian Stone Pressure Plate");
		add(BlockRegistry.MARS_DEEPSLATE_BUTTON.get(), "Martian Deepslate Button");
		add(BlockRegistry.MARS_DEEPSLATE_PRESSURE_PLATE.get(), "Martian Deepslate Pressure Plate");

		add(BlockRegistry.COMPRESSED_MARS_COBBLESTONE.get(), "Compressed Martian Cobblestone");
		add(BlockRegistry.COMPRESSED_MARS_COBBLED_DEEPSLATE.get(), "Compressed Martian Cobbled Deepslate");


		/**METEOR**/
		add(BlockRegistry.METEOR.get(), "Meteorite");
		add(BlockRegistry.METEOR_BRICK_SLAB.get(), "Meteorite Brick Slab");
		add(BlockRegistry.METEOR_BRICK_STAIRS.get(), "Meteorite Brick Stairs");
		add(BlockRegistry.METEOR_BRICK_WALL.get(), "Meteorite Brick Wall");
		add(BlockRegistry.METEOR_BRICKS.get(), "Meteorite Bricks");
		add(BlockRegistry.CHISELED_METEOR_BRICKS.get(), "Chiseled Meteorite Bricks");
		add(BlockRegistry.METEOR_COAL_ORE.get(), "Meteorite Coal Ore");
		add(BlockRegistry.METEOR_COPPER_ORE.get(), "Meteorite Copper Ore");
		add(BlockRegistry.METEOR_DIAMOND_ORE.get(), "Meteorite Diamond Ore");
		add(BlockRegistry.METEOR_EMERALD_ORE.get(), "Meteorite Emerald Ore");
		add(BlockRegistry.METEOR_GOLD_ORE.get(), "Meteorite Gold Ore");
		add(BlockRegistry.METEOR_IRON_ORE.get(), "Meteorite Iron Ore");
		add(BlockRegistry.METEOR_LAPIS_ORE.get(), "Meteorite Lapis Lazuli Ore");
		add(BlockRegistry.METEOR_REDSTONE_ORE.get(), "Meteorite Redstone Ore");

		add(BlockRegistry.METEOR_BUTTON.get(), "Meteorite Button");
		add(BlockRegistry.METEOR_PRESSURE_PLATE.get(), "Meteorite Pressure Plate");

		/**OTHER BLOCKS**/
//		add(BlockRegistry.SOLAR_PANEL.get(), "Solar Panel");
//		add(BlockRegistry.IGNEOUS_ROCK.get(), "Igneous Rock");
//		add(ItemRegistry.ASSEMBLY_STATION.get(), "Assembly Station");
		add(ItemRegistry.OXYGEN_COMPRESSOR.get(), "Oxygen Compressor");
		add(ItemRegistry.LOX_TANK.get(), "Liquid Oxygen Tank");
//		add(FluidRegistry.LOX_BUCKET.get(), "Liquid Oxygen Bucket");
		add(ItemRegistry.STEEL_ROD.get(), "Steel Rod");
		add(ItemRegistry.STEEL_INGOT.get(), "Steel Ingot");
		add(ItemRegistry.STEEL_NUGGET.get(), "Steel Nugget");
		add(ItemRegistry.STEEL_WOOL.get(), "Steel Wool");
		add(BlockRegistry.STEEL_BLOCK.get(), "Steel Block");
		add(BlockRegistry.CERAMIC.get(), "Ceramic");
		add(BlockRegistry.CERAMIC_TILE.get(), "Ceramic Tile");

		add(BlockRegistry.WHITE_CERAMIC.get(), "White Ceramic");
		add(BlockRegistry.WHITE_CERAMIC_TILE.get(), "White Ceramic Tile");
		add(BlockRegistry.LIGHT_GREY_CERAMIC.get(), "Light Grey Ceramic");
		add(BlockRegistry.LIGHT_GREY_CERAMIC_TILE.get(), "Light Grey Ceramic Tile");
		add(BlockRegistry.GREY_CERAMIC.get(), "Grey Ceramic");
		add(BlockRegistry.GREY_CERAMIC_TILE.get(), "Grey Ceramic Tile");
		add(BlockRegistry.BLACK_CERAMIC.get(), "Black Ceramic");
		add(BlockRegistry.BLACK_CERAMIC_TILE.get(), "Black Ceramic Tile");
		add(BlockRegistry.PURPLE_CERAMIC.get(), "Purple Ceramic");
		add(BlockRegistry.PURPLE_CERAMIC_TILE.get(), "Purple Ceramic Tile");
		add(BlockRegistry.MAGENTA_CERAMIC.get(), "Magenta Ceramic");
		add(BlockRegistry.MAGENTA_CERAMIC_TILE.get(), "Magenta Ceramic Tile");
		add(BlockRegistry.BLUE_CERAMIC.get(), "Blue Ceramic");
		add(BlockRegistry.BLUE_CERAMIC_TILE.get(), "Blue Ceramic Tile");
		add(BlockRegistry.LIGHT_BLUE_CERAMIC.get(), "Light Blue Ceramic");
		add(BlockRegistry.LIGHT_BLUE_CERAMIC_TILE.get(), "Light Blue Ceramic Tile");
		add(BlockRegistry.CYAN_CERAMIC.get(), "Cyan Ceramic");
		add(BlockRegistry.CYAN_CERAMIC_TILE.get(), "Cyan Ceramic Tile");
		add(BlockRegistry.GREEN_CERAMIC.get(), "Green Ceramic");
		add(BlockRegistry.GREEN_CERAMIC_TILE.get(), "Green Ceramic Tile");
		add(BlockRegistry.LIME_CERAMIC.get(), "Lime Ceramic");
		add(BlockRegistry.LIME_CERAMIC_TILE.get(), "Lime Ceramic Tile");
		add(BlockRegistry.YELLOW_CERAMIC.get(), "Yellow Ceramic");
		add(BlockRegistry.YELLOW_CERAMIC_TILE.get(), "Yellow Ceramic Tile");
		add(BlockRegistry.ORANGE_CERAMIC.get(), "Orange Ceramic");
		add(BlockRegistry.ORANGE_CERAMIC_TILE.get(), "Orange Ceramic Tile");
		add(BlockRegistry.BROWN_CERAMIC.get(), "Brown Ceramic");
		add(BlockRegistry.BROWN_CERAMIC_TILE.get(), "Brown Ceramic Tile");
		add(BlockRegistry.RED_CERAMIC.get(), "Red Ceramic");
		add(BlockRegistry.RED_CERAMIC_TILE.get(), "Red Ceramic Tile");
		add(BlockRegistry.PINK_CERAMIC.get(), "Pink Ceramic");
		add(BlockRegistry.PINK_CERAMIC_TILE.get(), "Pink Ceramic Tile");

		add(BlockRegistry.PAINTED_WHITE_CERAMIC.get(), "Painted White Ceramic");
		add(BlockRegistry.PAINTED_LIGHT_GREY_CERAMIC.get(), "Painted Light Grey Ceramic");
		add(BlockRegistry.PAINTED_GREY_CERAMIC.get(), "Painted Grey Ceramic");
		add(BlockRegistry.PAINTED_BLACK_CERAMIC.get(), "Painted Black Ceramic");
		add(BlockRegistry.PAINTED_PURPLE_CERAMIC.get(), "Painted Purple Ceramic");
		add(BlockRegistry.PAINTED_MAGENTA_CERAMIC.get(), "Painted Magenta Ceramic");
		add(BlockRegistry.PAINTED_BLUE_CERAMIC.get(), "Painted Blue Ceramic");
		add(BlockRegistry.PAINTED_LIGHT_BLUE_CERAMIC.get(), "Painted Light Blue Ceramic");
		add(BlockRegistry.PAINTED_CYAN_CERAMIC.get(), "Painted Cyan Ceramic");
		add(BlockRegistry.PAINTED_GREEN_CERAMIC.get(), "Painted Green Ceramic");
		add(BlockRegistry.PAINTED_LIME_CERAMIC.get(), "Painted Lime Ceramic");
		add(BlockRegistry.PAINTED_YELLOW_CERAMIC.get(), "Painted Yellow Ceramic");
		add(BlockRegistry.PAINTED_ORANGE_CERAMIC.get(), "Painted Orange Ceramic");
		add(BlockRegistry.PAINTED_BROWN_CERAMIC.get(), "Painted Brown Ceramic");
		add(BlockRegistry.PAINTED_RED_CERAMIC.get(), "Painted Red Ceramic");
		add(BlockRegistry.PAINTED_PINK_CERAMIC.get(), "Painted Pink Ceramic");



		add(BlockRegistry.DRY_ICE.get(), "Dry Ice");
		add(BlockRegistry.LUMINOUS_BLUE_GLASS.get(), "Luminous Blue Glass");
		add(BlockRegistry.LUMINOUS_WHITE_GLASS.get(), "Luminous White Glass");
		add(BlockRegistry.LUMINOUS_BLUE_GLASS_PANE.get(), "Luminous Blue Glass Pane");
		add(BlockRegistry.LUMINOUS_WHITE_GLASS_PANE.get(), "Luminous White Glass Pane");

		add(BlockRegistry.REINFORCED_GLASS.get(), "Reinforced  Glass");
		add(BlockRegistry.REINFORCED_GLASS_PANE.get(), "Reinforced Glass Pane");

		add(BlockRegistry.COMPRESSED_COBBLESTONE.get(), "Compressed Cobblestone");
		add(BlockRegistry.COMPRESSED_COBBLED_DEEPSLATE.get(), "Compressed Cobbled Deepslate");

		add(BlockRegistry.WORKBENCH.get(), "Workbench");
		add(BlockRegistry.SILICA.get(), "Silica");


		/**ARMOR**/
		add(ItemRegistry.STEEL_BOOTS.get(), "Steel Boots");
		add(ItemRegistry.STEEL_CHESTPLATE.get(), "Steel Chestplate");
		add(ItemRegistry.STEEL_HELMET.get(), "Steel Helmet");
		add(ItemRegistry.STEEL_LEGGINGS.get(), "Steel Leggings");
		add(ItemRegistry.SPACE_SUIT_BOOTS.get(), "Space Suit Boots");
		add(ItemRegistry.SPACE_SUIT_CHESTPLATE.get(), "Space Suit Chestplate");
		add(ItemRegistry.SPACE_SUIT_HELMET.get(), "Space Suit Helmet");
		add(ItemRegistry.SPACE_SUIT_LEGGINGS.get(), "Space Suit Leggings");

		/**SPAWN EGGS**/
		add(ItemRegistry.RUST_SPAWN_EGG.get(), "Rust Slime Spawn Egg");
		add(ItemRegistry.LUNAR_SPAWN_EGG.get(), "Lunar Slime Spawn Egg");
		add(ItemRegistry.MARS_MALLOW_SPAWN_EGG.get(), "Mars Mallow Spawn Egg");
		add(ItemRegistry.LURKER_SPAWN_EGG.get(), "Lurker Spawn Egg");
		add(ItemRegistry.VOIDFELLOW_SPAWN_EGG.get(), "Voidfellow Spawn Egg");

		/**MOBS**/
		add(EntityRegistry.LUNAR_SLIME.get(), "Lunar Slime");
		add(EntityRegistry.MARS_MALLOW.get(), "Mars Mallow");
		add(EntityRegistry.RUST_SLIME.get(), "Rust Slime");
		add(EntityRegistry.LURKER.get(), "Lurker");
		add(EntityRegistry.VOIDFELLOW.get(), "Voidfellow");

		/**SHUTTLE ITEMS**/
		add(ItemRegistry.WHITE_SHUTTLE.get(), "White Shuttle");
		add(ItemRegistry.BLACK_SHUTTLE.get(), "Black Shuttle");
		add(ItemRegistry.GREY_SHUTTLE.get(), "Grey Shuttle");
		add(ItemRegistry.LIGHT_GREY_SHUTTLE.get(), "Light Grey Shuttle");
		add(ItemRegistry.PINK_SHUTTLE.get(), "Pink Shuttle");
		add(ItemRegistry.RED_SHUTTLE.get(), "Red Shuttle");
		add(ItemRegistry.ORANGE_SHUTTLE.get(), "Orange Shuttle");
		add(ItemRegistry.YELLOW_SHUTTLE.get(), "Yellow Shuttle");
		add(ItemRegistry.LIME_SHUTTLE.get(), "Lime Shuttle");
		add(ItemRegistry.GREEN_SHUTTLE.get(), "Green Shuttle");
		add(ItemRegistry.CYAN_SHUTTLE.get(), "Cyan Shuttle");
		add(ItemRegistry.BLUE_SHUTTLE.get(), "Blue Shuttle");
		add(ItemRegistry.LIGHT_BLUE_SHUTTLE.get(), "Light Blue Shuttle");
		add(ItemRegistry.PURPLE_SHUTTLE.get(), "Purple Shuttle");
		add(ItemRegistry.MAGENTA_SHUTTLE.get(), "Magenta Shuttle");
		add(ItemRegistry.BROWN_SHUTTLE.get(), "Brown Shuttle");

		/**
		 * SHUTTLE-RELATED
		 */
		add(BlockRegistry.STEEL_FRAME.get(), "Steel Frame");
		add(ItemRegistry.SHUTTLE_FRAME.get(), "Shuttle Frame");
		add(ItemRegistry.SHUTTLE_CABIN.get(), "Shuttle Cabin");
		add(ItemRegistry.SHUTTLE_ENGINE.get(), "Shuttle Engine");
//		add(ItemRegistry.NOSE_CONE.get(), "Shuttle Nose Cone");

		/**
		 * FOOD
		 */
		add(ItemRegistry.MARSHMALLOW_GOO.get(), "Marshmallow Goo");
		add(ItemRegistry.MARSHMALLOW.get(), "Marshmallow");
		add(ItemRegistry.ROASTED_MARSHMALLOW.get(), "Roasted Marshmallow");
		add(ItemRegistry.CHOCOLATE.get(), "Chocolate");
		add(ItemRegistry.CRACKER.get(), "Cracker");
		add(ItemRegistry.SMORES.get(), "S'Mores");

		add(ItemRegistry.LUNAR_CHEESE.get(), "Moon Cheese");
		add(ItemRegistry.CHEESE.get(), "Cheese");
		add(ItemRegistry.LUNAR_GOO.get(), "Lunar Goo");

//		add(ItemRegistry.IRON_DUST.get(), "Iron Dust");
		add(ItemRegistry.RUSTED_IRON_NUGGET.get(), "Rusted Iron Nugget");

		add(ItemRegistry.BLOCK_MOLD.get(), "Block Mold");
		add(ItemRegistry.INGOT_MOLD.get(), "Ingot Mold");


		/* FLUID */
		add("fluid.celestialexploration.lox", "Liquid Oxygen");
		add(FluidRegistry.MOLTEN_IRON_BLOCK.get(), "Molten Iron");
		add("fluid.celestialexploration.molten_iron", "Molten Iron");
		add(FluidRegistry.MOLTEN_STEEL_BLOCK.get(), "Molten Steel");
		add("fluid.celestialexploration.molten_steel", "Molten Steel");
		add(FluidRegistry.MOLTEN_COPPER_BLOCK.get(), "Molten Copper");
		add("fluid.celestialexploration.molten_copper", "Molten Copper");
		add(FluidRegistry.MOLTEN_GOLD_BLOCK.get(), "Molten Gold");
		add("fluid.celestialexploration.molten_gold", "Molten Gold");
//		add(FluidRegistry.MOLTEN_NETHERITE_BLOCK.get(), "Molten Copper");

		/* MAG LEV */
		add(BlockRegistry.MAG_RAIL.get(), "Mag Rail");
		add(BlockRegistry.POWERED_MAG_RAIL.get(), "Powered Mag Rail");
		add(BlockRegistry.DETECTOR_MAG_RAIL.get(), "Detector Mag Rail");
		add(BlockRegistry.ACTIVATOR_MAG_RAIL.get(), "Activator Mag Rail");

		add(ItemRegistry.MAGCART.get(), "Magcart");
		add(ItemRegistry.CHEST_MAGCART.get(), "Chest Magcart");
		add(ItemRegistry.COMMAND_BLOCK_MAGCART.get(), "Command Block Magcart");
		add(ItemRegistry.FURNACE_MAGCART.get(), "Furnace Magcart");
		add(ItemRegistry.HOPPER_MAGCART.get(), "Hopper Magcart");
		add(ItemRegistry.TNT_MAGCART.get(), "TNT Magcart");

		add(EntityRegistry.MAGCART.get(), "Magcart");
		add(EntityRegistry.CHEST_MAGCART.get(), "Chest Magcart");
		add(EntityRegistry.COMMAND_BLOCK_MAGCART.get(), "Command Block Magcart");
		add(EntityRegistry.FURNACE_MAGCART.get(), "Furnace Magcart");
		add(EntityRegistry.HOPPER_MAGCART.get(), "Hopper Magcart");
		add(EntityRegistry.SPAWNER_MAGCART.get(), "Spawner Magcart");
		add(EntityRegistry.TNT_MAGCART.get(), "TNT Magcart");

	}
}
