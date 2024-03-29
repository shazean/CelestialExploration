package com.shim.celestialexploration.datagen;

import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestialexploration.registry.*;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.LanguageProvider;

public class ModLanguageProvider extends LanguageProvider {

	public ModLanguageProvider(DataGenerator gen, String locale) {
		super(gen, CelestialExploration.MODID, locale);
	}

	@Override
	protected void addTranslations() {
		//---- MOON -------------------------------------------------------------------------------
		//STONE
		add(BlockRegistry.MOON_STONE.get(), "Lunar Stone");
		add(BlockRegistry.MOON_STONE_STAIRS.get(), "Lunar Stone Stairs");
		add(BlockRegistry.MOON_STONE_SLAB.get(), "Lunar Stone Slab");
		add(BlockRegistry.MOON_STONE_BUTTON.get(), "Lunar Stone Button");
		add(BlockRegistry.MOON_STONE_PRESSURE_PLATE.get(), "Lunar Stone Pressure Plate");

		add(BlockRegistry.MOON_COBBLESTONE.get(), "Lunar Cobblestone");
		add(BlockRegistry.MOON_COBBLESTONE_SLAB.get(), "Lunar Cobblestone Slab");
		add(BlockRegistry.MOON_COBBLESTONE_STAIRS.get(), "Lunar Cobblestone Stairs");
		add(BlockRegistry.MOON_COBBLESTONE_WALL.get(), "Lunar Cobblestone Wall");
		add(BlockRegistry.COMPRESSED_MOON_COBBLESTONE.get(), "Compressed Lunar Cobblestone");

		add(BlockRegistry.MOON_BRICKS.get(), "Lunar Bricks");

		add(BlockRegistry.MOON_BRICK_SLAB.get(), "Lunar Brick Slab");
		add(BlockRegistry.MOON_BRICK_STAIRS.get(), "Lunar Brick Stairs");
		add(BlockRegistry.MOON_BRICK_WALL.get(), "Lunar Brick Wall");
		add(BlockRegistry.CHISELED_MOON_BRICKS.get(), "Chiseled Lunar Bricks");
		add(BlockRegistry.CRACKED_MOON_BRICKS.get(), "Cracked Lunar Bricks");
		add(BlockRegistry.MOON_BRICK_PILLAR.get(), "Lunar Brick Pillar");
		add(BlockRegistry.MOON_SMOOTH_STONE.get(), "Lunar Smooth Stone");
		add(BlockRegistry.MOON_SMOOTH_STONE_SLAB.get(), "Lunar Smooth Stone Slab");

		//DEEPSLATE
		add(BlockRegistry.MOON_DEEPSLATE.get(), "Lunar Deepslate");
		add(BlockRegistry.MOON_DEEPSLATE_BUTTON.get(), "Lunar Deepslate Button");
		add(BlockRegistry.MOON_DEEPSLATE_PRESSURE_PLATE.get(), "Lunar Deepslate Pressure Plate");

		add(BlockRegistry.MOON_COBBLED_DEEPSLATE.get(), "Lunar Cobbled Deepslate");
		add(BlockRegistry.MOON_COBBLED_DEEPSLATE_SLAB.get(), "Lunar Cobbled Deepslate Slab");
		add(BlockRegistry.MOON_COBBLED_DEEPSLATE_STAIRS.get(), "Lunar Cobbled Deepslate Stairs");
		add(BlockRegistry.MOON_COBBLED_DEEPSLATE_WALL.get(), "Lunar Cobbled Deepslate Wall");
		add(BlockRegistry.COMPRESSED_MOON_COBBLED_DEEPSLATE.get(), "Compressed Lunar Cobbled Deepslate");

		add(BlockRegistry.MOON_POLISHED_DEEPSLATE.get(), "Lunar Polished Deepslate");
		add(BlockRegistry.MOON_POLISHED_DEEPSLATE_SLAB.get(), "Lunar Polished Deepslate Slab");
		add(BlockRegistry.MOON_POLISHED_DEEPSLATE_STAIRS.get(), "Lunar Polished Deepslate Stairs");
		add(BlockRegistry.MOON_POLISHED_DEEPSLATE_WALL.get(), "Lunar Polished Deepslate Wall");

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

		//ORES
		add(BlockRegistry.MOON_IRON_ORE.get(), "Lunar Iron Ore");
		add(BlockRegistry.MOON_REDSTONE_ORE.get(), "Lunar Redstone Ore");
		add(BlockRegistry.MOON_BAUXITE_ORE.get(), "Lunar Bauxite Ore");
		add(BlockRegistry.MOON_DEEPSLATE_IRON_ORE.get(), "Lunar Deepslate Iron Ore");
		add(BlockRegistry.MOON_DEEPSLATE_REDSTONE_ORE.get(), "Lunar Deepslate Redstone Ore");
		
		//OTHER
		add(BlockRegistry.MOON_SAND.get(), "Lunar Regolith");
		add(BlockRegistry.GLOWING_MOON_SAND.get(), "Glowing Lunar Regolith");
		add(BlockRegistry.COARSE_MOON_SAND.get(), "Coarse Lunar Regolith");
		add(BlockRegistry.LUNAR_LANTERN.get(), "Lunar Lantern");
		
		//---- MARS -------------------------------------------------------------------------------
		//STONE
		add(BlockRegistry.MARS_STONE.get(), "Martian Stone");
		add(BlockRegistry.MARS_STONE_STAIRS.get(), "Martian Stone Stairs");
		add(BlockRegistry.MARS_STONE_SLAB.get(), "Martian Stone Slab");
		add(BlockRegistry.MARS_STONE_BUTTON.get(), "Martian Stone Button");
		add(BlockRegistry.MARS_STONE_PRESSURE_PLATE.get(), "Martian Stone Pressure Plate");

		add(BlockRegistry.MARS_COBBLESTONE.get(), "Martian Cobblestone");
		add(BlockRegistry.MARS_COBBLESTONE_SLAB.get(), "Martian Cobblestone Slab");
		add(BlockRegistry.MARS_COBBLESTONE_STAIRS.get(), "Martian Cobblestone Stairs");
		add(BlockRegistry.MARS_COBBLESTONE_WALL.get(), "Martian Cobblestone Wall");
		add(BlockRegistry.COMPRESSED_MARS_COBBLESTONE.get(), "Compressed Martian Cobblestone");

		add(BlockRegistry.MARS_BRICKS.get(), "Martian Bricks");

		add(BlockRegistry.MARS_BRICK_SLAB.get(), "Martian Brick Slab");
		add(BlockRegistry.MARS_BRICK_STAIRS.get(), "Martian Brick Stairs");
		add(BlockRegistry.MARS_BRICK_WALL.get(), "Martian Brick Wall");
		add(BlockRegistry.CHISELED_MARS_BRICKS.get(), "Chiseled Martian Bricks");
		add(BlockRegistry.CRACKED_MARS_BRICKS.get(), "Cracked Martian Bricks");
		add(BlockRegistry.MARS_BRICK_PILLAR.get(), "Martian Brick Pillar");
		add(BlockRegistry.MARS_SMOOTH_STONE.get(), "Martian Smooth Stone");
		add(BlockRegistry.MARS_SMOOTH_STONE_SLAB.get(), "Martian Smooth Stone Slab");

		//DEEPSLATE
		add(BlockRegistry.MARS_DEEPSLATE.get(), "Martian Deepslate");
		add(BlockRegistry.MARS_DEEPSLATE_BUTTON.get(), "Martian Deepslate Button");
		add(BlockRegistry.MARS_DEEPSLATE_PRESSURE_PLATE.get(), "Martian Deepslate Pressure Plate");

		add(BlockRegistry.MARS_COBBLED_DEEPSLATE.get(), "Martian Cobbled Deepslate");
		add(BlockRegistry.MARS_COBBLED_DEEPSLATE_SLAB.get(), "Martian Cobbled Deepslate Slab");
		add(BlockRegistry.MARS_COBBLED_DEEPSLATE_STAIRS.get(), "Martian Cobbled Deepslate Stairs");
		add(BlockRegistry.MARS_COBBLED_DEEPSLATE_WALL.get(), "Martian Cobbled Deepslate Wall");
		add(BlockRegistry.COMPRESSED_MARS_COBBLED_DEEPSLATE.get(), "Compressed Martian Cobbled Deepslate");

		add(BlockRegistry.MARS_POLISHED_DEEPSLATE.get(), "Martian Polished Deepslate");
		add(BlockRegistry.MARS_POLISHED_DEEPSLATE_SLAB.get(), "Martian Polished Deepslate Slab");
		add(BlockRegistry.MARS_POLISHED_DEEPSLATE_STAIRS.get(), "Martian Polished Deepslate Stairs");
		add(BlockRegistry.MARS_POLISHED_DEEPSLATE_WALL.get(), "Martian Polished Deepslate Wall");

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

		//ORES
		add(BlockRegistry.MARS_IRON_ORE.get(), "Martian Iron Ore");
		add(BlockRegistry.MARS_REDSTONE_ORE.get(), "Martian Redstone Ore");
		add(BlockRegistry.MARS_BAUXITE_ORE.get(), "Martian Bauxite Ore");
		add(BlockRegistry.MARS_DEEPSLATE_IRON_ORE.get(), "Martian Deepslate Iron Ore");
		add(BlockRegistry.MARS_DEEPSLATE_REDSTONE_ORE.get(), "Martian Deepslate Redstone Ore");

		//OTHER
		add(BlockRegistry.MARS_SAND.get(), "Martian Regolith");
		add(BlockRegistry.COARSE_MARS_SAND.get(), "Coarse Martian Regolith");
		add(BlockRegistry.MARS_LANTERN.get(), "Martian Lantern");

		//---- VENUS -------------------------------------------------------------------------------
		//STONE
		add(BlockRegistry.VENUS_STONE.get(), "Venusian Stone");
		add(BlockRegistry.VENUS_STONE_STAIRS.get(), "Venusian Stone Stairs");
		add(BlockRegistry.VENUS_STONE_SLAB.get(), "Venusian Stone Slab");
		add(BlockRegistry.VENUS_STONE_BUTTON.get(), "Venusian Stone Button");
		add(BlockRegistry.VENUS_STONE_PRESSURE_PLATE.get(), "Venusian Stone Pressure Plate");
		add(BlockRegistry.VENUS_COBBLESTONE.get(), "Venusian Cobblestone");
		add(BlockRegistry.VENUS_COBBLESTONE_SLAB.get(), "Venusian Cobblestone Slab");
		add(BlockRegistry.VENUS_COBBLESTONE_STAIRS.get(), "Venusian Cobblestone Stairs");
		add(BlockRegistry.VENUS_COBBLESTONE_WALL.get(), "Venusian Cobblestone Wall");
		add(BlockRegistry.COMPRESSED_VENUS_COBBLESTONE.get(), "Compressed Venusian Cobblestone");

		add(BlockRegistry.VENUS_BRICKS.get(), "Venusian Bricks");
		add(BlockRegistry.VENUS_BRICK_SLAB.get(), "Venusian Brick Slab");
		add(BlockRegistry.VENUS_BRICK_STAIRS.get(), "Venusian Brick Stairs");
		add(BlockRegistry.VENUS_BRICK_WALL.get(), "Venusian Brick Wall");
		add(BlockRegistry.CHISELED_VENUS_BRICKS.get(), "Chiseled Venusian Bricks");
		add(BlockRegistry.CRACKED_VENUS_BRICKS.get(), "Cracked Venusian Bricks");
		add(BlockRegistry.VENUS_BRICK_PILLAR.get(), "Venusian Brick Pillar");

		add(BlockRegistry.SMALL_VENUS_BRICKS.get(), "Small Venusian Bricks");
		add(BlockRegistry.SMALL_VENUS_BRICK_SLAB.get(), "Small Venusian Brick Slab");
		add(BlockRegistry.SMALL_VENUS_BRICK_STAIRS.get(), "Small Venusian Brick Stairs");
		add(BlockRegistry.SMALL_VENUS_BRICK_WALL.get(), "Small Venusian Brick Wall");

		add(BlockRegistry.VENUS_SMOOTH_STONE.get(), "Venusian Smooth Stone");
		add(BlockRegistry.VENUS_SMOOTH_STONE_SLAB.get(), "Venusian Smooth Stone Slab");

		//DEEPSLATE
		add(BlockRegistry.VENUS_DEEPSLATE.get(), "Venusian Deepslate");
		add(BlockRegistry.VENUS_DEEPSLATE_BUTTON.get(), "Venusian Deepslate Button");
		add(BlockRegistry.VENUS_DEEPSLATE_PRESSURE_PLATE.get(), "Venusian Deepslate Pressure Plate");

		add(BlockRegistry.VENUS_COBBLED_DEEPSLATE.get(), "Venusian Cobbled Deepslate");
		add(BlockRegistry.VENUS_COBBLED_DEEPSLATE_SLAB.get(), "Venusian Cobbled Deepslate Slab");
		add(BlockRegistry.VENUS_COBBLED_DEEPSLATE_STAIRS.get(), "Venusian Cobbled Deepslate Stairs");
		add(BlockRegistry.VENUS_COBBLED_DEEPSLATE_WALL.get(), "Venusian Cobbled Deepslate Wall");
		add(BlockRegistry.COMPRESSED_VENUS_COBBLED_DEEPSLATE.get(), "Compressed Venusian Cobbled Deepslate");

		add(BlockRegistry.VENUS_POLISHED_DEEPSLATE.get(), "Venusian Polished Deepslate");
		add(BlockRegistry.VENUS_POLISHED_DEEPSLATE_SLAB.get(), "Venusian Polished Deepslate Slab");
		add(BlockRegistry.VENUS_POLISHED_DEEPSLATE_STAIRS.get(), "Venusian Polished Deepslate Stairs");
		add(BlockRegistry.VENUS_POLISHED_DEEPSLATE_WALL.get(), "Venusian Polished Deepslate Wall");

		add(BlockRegistry.VENUS_DEEPSLATE_BRICKS.get(), "Venusian Deepslate Bricks");
		add(BlockRegistry.VENUS_DEEPSLATE_BRICK_SLAB.get(), "Venusian Deepslate Brick Slab");
		add(BlockRegistry.VENUS_DEEPSLATE_BRICK_STAIRS.get(), "Venusian Deepslate Brick Stairs");
		add(BlockRegistry.VENUS_DEEPSLATE_BRICK_WALL.get(), "Venusian Deepslate Brick Wall");
		add(BlockRegistry.CRACKED_VENUS_DEEPSLATE_BRICKS.get(), "Cracked Venusian Deepslate Bricks");
		add(BlockRegistry.CHISELED_VENUS_DEEPSLATE_BRICKS.get(), "Chiseled Venusian Deepslate Bricks");

		add(BlockRegistry.VENUS_DEEPSLATE_TILES.get(), "Venusian Deepslate Tiles");
		add(BlockRegistry.VENUS_DEEPSLATE_TILE_SLAB.get(), "Venusian Deepslate Tile Slab");
		add(BlockRegistry.VENUS_DEEPSLATE_TILE_STAIRS.get(), "Venusian Deepslate Tile Stairs");
		add(BlockRegistry.VENUS_DEEPSLATE_TILE_WALL.get(), "Venusian Deepslate Tile Wall");
		add(BlockRegistry.CRACKED_VENUS_DEEPSLATE_TILES.get(), "Cracked Venusian Deepslate Tiles");

		//ORES
		add(BlockRegistry.VENUS_IRON_ORE.get(), "Venusian Iron Ore");
		add(BlockRegistry.VENUS_REDSTONE_ORE.get(), "Venusian Redstone Ore");
		add(BlockRegistry.VENUS_BAUXITE_ORE.get(), "Venusian Bauxite Ore");
		add(BlockRegistry.VENUS_LAPIS_ORE.get(), "Venusian Lapis Lazuli Ore");
		add(BlockRegistry.VENUS_DEEPSLATE_LAPIS_ORE.get(), "Venusian Deepslate Lapis Lazuli Ore");
		add(BlockRegistry.VENUS_DEEPSLATE_IRON_ORE.get(), "Venusian Deepslate Iron Ore");
		add(BlockRegistry.VENUS_DEEPSLATE_REDSTONE_ORE.get(), "Venusian Deepslate Redstone Ore");

		//OTHER
		add(BlockRegistry.VENUS_SAND.get(), "Venusian Regolith");
		add(BlockRegistry.FINE_VENUS_SAND.get(), "Fine Venusian Regolith");
		add(BlockRegistry.SULFURIC_OBSIDIAN.get(), "Sulfuric Obsidian");
		add(BlockRegistry.VENUS_LANTERN.get(), "Venusian Lantern");
		add(BlockRegistry.GEYSER.get(), "Sulfur Geyser");


		//---- CELESTIAL OBJECTS -------------------------------------------------------------------------------

		//METEOR
		add(BlockRegistry.METEOR.get(), "Meteorite");
		add(BlockRegistry.METEOR_BUTTON.get(), "Meteorite Button");
		add(BlockRegistry.METEOR_PRESSURE_PLATE.get(), "Meteorite Pressure Plate");
		add(BlockRegistry.METEOR_BRICK_SLAB.get(), "Meteorite Brick Slab");
		add(BlockRegistry.METEOR_BRICK_STAIRS.get(), "Meteorite Brick Stairs");
		add(BlockRegistry.METEOR_BRICK_WALL.get(), "Meteorite Brick Wall");
		add(BlockRegistry.METEOR_BRICKS.get(), "Meteorite Bricks");
		add(BlockRegistry.CHISELED_METEOR_BRICKS.get(), "Chiseled Meteorite Bricks");

		//METEOR ORES
		add(BlockRegistry.METEOR_COAL_ORE.get(), "Meteorite Coal Ore");
		add(BlockRegistry.METEOR_COPPER_ORE.get(), "Meteorite Copper Ore");
		add(BlockRegistry.METEOR_DIAMOND_ORE.get(), "Meteorite Diamond Ore");
		add(BlockRegistry.METEOR_EMERALD_ORE.get(), "Meteorite Emerald Ore");
		add(BlockRegistry.METEOR_GOLD_ORE.get(), "Meteorite Gold Ore");
		add(BlockRegistry.METEOR_IRON_ORE.get(), "Meteorite Iron Ore");
		add(BlockRegistry.METEOR_LAPIS_ORE.get(), "Meteorite Lapis Lazuli Ore");
		add(BlockRegistry.METEOR_SULFUR_ORE.get(), "Meteorite Sulfur Ore");
		add(BlockRegistry.METEOR_BAUXITE_ORE.get(), "Meteorite Bauxite Ore");
		add(BlockRegistry.METEOR_REDSTONE_ORE.get(), "Meteorite Redstone Ore");

		//SUN
		add(BlockRegistry.SOLAR_PLASMA.get(), "Solar Plasma");
		add(BlockRegistry.SOLAR_FLARE.get(), "Solar Surface");
		add(BlockRegistry.SUN_SPOT.get(), "Sun Spot");

		//---- OTHER PLANETS -------------------------------------------------------------------------------
		add(BlockRegistry.MERCURY_STONE.get(), "Mercury Stone");
		add(BlockRegistry.MERCURY_DEEPSLATE.get(), "Mercury Deepslate");
		add(BlockRegistry.JUPITER_ATMOSPHERE.get(), "Jupiter Atmosphere");
		add(BlockRegistry.JUPITER_DEEPSLATE.get(), "Jupiter Deepslate");
		add(BlockRegistry.IO_STONE.get(), "Io Stone");
		add(BlockRegistry.IO_DEEPSLATE.get(), "Io Deepslate");
		add(BlockRegistry.EUROPA_HYDRATE.get(), "Europa Hydrate");
		add(BlockRegistry.SATURN_ATMOSPHERE.get(), "Saturn Atmosphere");
		add(BlockRegistry.SATURN_DEEPSLATE.get(), "Saturn Deepslate");
		add(BlockRegistry.URANUS_ATMOSPHERE.get(), "Uranus Atmosphere");
		add(BlockRegistry.URANUS_DEEPSLATE.get(), "Uranus Deepslate");
		add(BlockRegistry.NEPTUNE_ATMOSPHERE.get(), "Neptune Atmosphere");
		add(BlockRegistry.NEPTUNE_DEEPSLATE.get(), "Neptune Deepslate");

		//---- ORES/ALLOYS -------------------------------------------------------------------------------
		add(ItemRegistry.STEEL_INGOT.get(), "Steel Ingot");
		add(ItemRegistry.STEEL_NUGGET.get(), "Steel Nugget");
		add(BlockRegistry.STEEL_BLOCK.get(), "Steel Block");
		add(BlockRegistry.BAUXITE_ORE.get(), "Bauxite Ore");
		add(ItemRegistry.RAW_BAUXITE.get(), "Raw Bauxite");
		add(ItemRegistry.BAUXITE_INGOT.get(), "Bauxite Ingot");
		add(ItemRegistry.ALUMINUM_INGOT.get(), "Aluminum Ingot");
		add(BlockRegistry.ALUMINUM_BLOCK.get(), "Aluminum Block");

		//---- SPACESHIP -------------------------------------------------------------------------------
		add(ItemRegistry.OXYGEN_COMPRESSOR.get(), "Oxygen Compressor");
		add(ItemRegistry.LOX_TANK.get(), "Liquid Oxygen Tank");
		add(BlockRegistry.WORKBENCH.get(), "Workbench");

		add(BlockRegistry.STEEL_FRAME.get(), "Steel Frame");
		add(ItemRegistry.SPACESHIP_FRAME.get(), "Spaceship Frame");
		add(ItemRegistry.SPACESHIP_CABIN.get(), "Spaceship Cabin");
		add(ItemRegistry.SPACESHIP_ENGINE.get(), "Spaceship Engine");

		add(ItemRegistry.WHITE_SPACESHIP.get(), "White Spaceship");
		add(ItemRegistry.BLACK_SPACESHIP.get(), "Black Spaceship");
		add(ItemRegistry.GREY_SPACESHIP.get(), "Grey Spaceship");
		add(ItemRegistry.LIGHT_GREY_SPACESHIP.get(), "Light Grey Spaceship");
		add(ItemRegistry.PINK_SPACESHIP.get(), "Pink Spaceship");
		add(ItemRegistry.RED_SPACESHIP.get(), "Red Spaceship");
		add(ItemRegistry.ORANGE_SPACESHIP.get(), "Orange Spaceship");
		add(ItemRegistry.YELLOW_SPACESHIP.get(), "Yellow Spaceship");
		add(ItemRegistry.LIME_SPACESHIP.get(), "Lime Spaceship");
		add(ItemRegistry.GREEN_SPACESHIP.get(), "Green Spaceship");
		add(ItemRegistry.CYAN_SPACESHIP.get(), "Cyan Spaceship");
		add(ItemRegistry.BLUE_SPACESHIP.get(), "Blue Spaceship");
		add(ItemRegistry.LIGHT_BLUE_SPACESHIP.get(), "Light Blue Spaceship");
		add(ItemRegistry.PURPLE_SPACESHIP.get(), "Purple Spaceship");
		add(ItemRegistry.MAGENTA_SPACESHIP.get(), "Magenta Spaceship");
		add(ItemRegistry.BROWN_SPACESHIP.get(), "Brown Spaceship");

		add(EntityRegistry.SPACESHIP.get(), "Spaceship");

		//---- SPACE STATION -------------------------------------------------------------------------------
		add(BlockRegistry.INSULATED_PANEL.get(), "Insulated Panel");
		add(BlockRegistry.INSULATED_PANEL_CORNER.get(), "Insulated Panel Corner");
		add(BlockRegistry.PANEL.get(), "Panel");
		add(BlockRegistry.PANEL_STAIRS.get(), "Panel Stairs");
		add(BlockRegistry.PANEL_SLAB.get(), "Panel Slab");
		add(BlockRegistry.PANEL_WALL.get(), "Panel Wall");
		add(BlockRegistry.THIN_PANEL.get(), "Thin Panel");

		add(BlockRegistry.PATHWAY_LIGHT.get(), "Pathway Light");

		add(BlockRegistry.RED_BUTTON.get(), "Red Button");
		add(BlockRegistry.YELLOW_BUTTON.get(), "Yellow Button");
		add(BlockRegistry.BLUE_BUTTON.get(), "Blue Button");
		add(BlockRegistry.GREEN_BUTTON.get(), "Green Button");
		add(BlockRegistry.WHITE_BUTTON.get(), "White Button");
		add(BlockRegistry.BLACK_BUTTON.get(), "Black Button");

		add(BlockRegistry.AIRLOCK_DOOR.get(), "Airlock");
		add(BlockRegistry.STEEL_DOOR.get(), "Steel Door");
		add(BlockRegistry.STEEL_TRAPDOOR.get(), "Steel Trapdoor");
		add(BlockRegistry.STEEL_BUTTON.get(), "Steel Button");

		//---- MAG LEV -------------------------------------------------------------------------------
		//RAILS
		add(BlockRegistry.MAG_RAIL.get(), "Mag Rail");
		add(BlockRegistry.POWERED_MAG_RAIL.get(), "Powered Mag Rail");
		add(BlockRegistry.DETECTOR_MAG_RAIL.get(), "Detector Mag Rail");
		add(BlockRegistry.ACTIVATOR_MAG_RAIL.get(), "Activator Mag Rail");

		//ITEMS
		add(ItemRegistry.MAGCART.get(), "Magcart");
		add(ItemRegistry.CHEST_MAGCART.get(), "Chest Magcart");
		add(ItemRegistry.COMMAND_BLOCK_MAGCART.get(), "Command Block Magcart");
		add(ItemRegistry.FURNACE_MAGCART.get(), "Furnace Magcart");
		add(ItemRegistry.HOPPER_MAGCART.get(), "Hopper Magcart");
		add(ItemRegistry.TNT_MAGCART.get(), "TNT Magcart");

		//ENTITIES
		add(EntityRegistry.MAGCART.get(), "Magcart");
		add(EntityRegistry.CHEST_MAGCART.get(), "Chest Magcart");
		add(EntityRegistry.COMMAND_BLOCK_MAGCART.get(), "Command Block Magcart");
		add(EntityRegistry.FURNACE_MAGCART.get(), "Furnace Magcart");
		add(EntityRegistry.HOPPER_MAGCART.get(), "Hopper Magcart");
		add(EntityRegistry.SPAWNER_MAGCART.get(), "Spawner Magcart");
		add(EntityRegistry.TNT_MAGCART.get(), "TNT Magcart");
		
		//---- ARMOR -------------------------------------------------------------------------------
		//STEEL
		add(ItemRegistry.STEEL_BOOTS.get(), "Steel Boots");
		add(ItemRegistry.STEEL_CHESTPLATE.get(), "Steel Chestplate");
		add(ItemRegistry.STEEL_HELMET.get(), "Steel Helmet");
		add(ItemRegistry.STEEL_LEGGINGS.get(), "Steel Leggings");
		
		//SPACESUIT
		add(ItemRegistry.BASIC_SPACE_SUIT_BOOTS.get(), "Basic Space Suit Boots");
		add(ItemRegistry.BASIC_SPACE_SUIT_CHESTPLATE.get(), "Basic Space Suit Chestplate");
		add(ItemRegistry.BASIC_SPACE_SUIT_HELMET.get(), "Basic Space Suit Helmet");
		add(ItemRegistry.BASIC_SPACE_SUIT_LEGGINGS.get(), "Basic Space Suit Leggings");
		add(ItemRegistry.HEAVY_DUTY_SPACE_SUIT_BOOTS.get(), "Heavy Duty Space Suit Boots");
		add(ItemRegistry.HEAVY_DUTY_SPACE_SUIT_CHESTPLATE.get(), "Heavy Duty Space Suit Chestplate");
		add(ItemRegistry.HEAVY_DUTY_SPACE_SUIT_HELMET.get(), "Heavy Duty Space Suit Helmet");
		add(ItemRegistry.HEAVY_DUTY_SPACE_SUIT_LEGGINGS.get(), "Heavy Duty Space Suit Leggings");
		add(ItemRegistry.THERMAL_SPACE_SUIT_BOOTS.get(), "Thermal Space Suit Boots");
		add(ItemRegistry.THERMAL_SPACE_SUIT_CHESTPLATE.get(), "Thermal Space Suit Chestplate");
		add(ItemRegistry.THERMAL_SPACE_SUIT_HELMET.get(), "Thermal Space Suit Helmet");
		add(ItemRegistry.THERMAL_SPACE_SUIT_LEGGINGS.get(), "Thermal Space Suit Leggings");
		add(ItemRegistry.ADVANCED_SPACE_SUIT_BOOTS.get(), "Advanced Space Suit Boots");
		add(ItemRegistry.ADVANCED_SPACE_SUIT_CHESTPLATE.get(), "Advanced Space Suit Chestplate");
		add(ItemRegistry.ADVANCED_SPACE_SUIT_HELMET.get(), "Advanced Space Suit Helmet");
		add(ItemRegistry.ADVANCED_SPACE_SUIT_LEGGINGS.get(), "Advanced Space Suit Leggings");
		
		//---- GLASS/CERAMICS -------------------------------------------------------------------------------
		//GLASS
		add(BlockRegistry.LUMINOUS_BLUE_GLASS.get(), "Luminous Blue Glass");
		add(BlockRegistry.LUMINOUS_WHITE_GLASS.get(), "Luminous White Glass");
		add(BlockRegistry.LUMINOUS_BLUE_GLASS_PANE.get(), "Luminous Blue Glass Pane");
		add(BlockRegistry.LUMINOUS_WHITE_GLASS_PANE.get(), "Luminous White Glass Pane");

		add(BlockRegistry.REINFORCED_GLASS.get(), "Reinforced  Glass");
		add(BlockRegistry.REINFORCED_GLASS_PANE.get(), "Reinforced Glass Pane");

		//CERAMIC
		add(BlockRegistry.SILICA.get(), "Silica");

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

		//---- FOOD -------------------------------------------------------------------------------
		add(ItemRegistry.MARSHMALLOW_GOO.get(), "Marshmallow Goo");
		add(ItemRegistry.MARSHMALLOW.get(), "Marshmallow");
		add(ItemRegistry.ROASTED_MARSHMALLOW.get(), "Roasted Marshmallow");
		add(ItemRegistry.CHOCOLATE.get(), "Chocolate");
		add(ItemRegistry.CRACKER.get(), "Cracker");
		add(ItemRegistry.SMORES.get(), "S'Mores");

		add(ItemRegistry.LUNAR_CHEESE.get(), "Moon Cheese");
		add(ItemRegistry.CHEESE.get(), "Cheese");
		add(ItemRegistry.LUNAR_GOO.get(), "Lunar Goo");

		//---- MISC BLOCKS/ITEMS -------------------------------------------------------------------------------
		add(BlockRegistry.DRY_ICE.get(), "Dry Ice");
		add(BlockRegistry.COMPRESSED_COBBLESTONE.get(), "Compressed Cobblestone");
		add(BlockRegistry.COMPRESSED_COBBLED_DEEPSLATE.get(), "Compressed Cobbled Deepslate");
		add(BlockRegistry.COMPRESSED_NETHERRACK.get(), "Compressed Netherrack");

		add(ItemRegistry.STEEL_ROD.get(), "Steel Rod");
		add(ItemRegistry.STEEL_WOOL.get(), "Steel Wool");
		add(ItemRegistry.SULFUR_CRYSTAL.get(), "Sulfur Crystal");
		add(ItemRegistry.FLARE_ROD.get(), "Flare Rod");
		add(ItemRegistry.RUSTED_IRON_NUGGET.get(), "Rusted Iron Nugget");
		add(ItemRegistry.BLOCK_MOLD.get(), "Block Mold");
		add(ItemRegistry.INGOT_MOLD.get(), "Ingot Mold");
		add(ItemRegistry.MOON_DUST.get(), "Lunar Dust");

		//---- SPAWN EGGS -------------------------------------------------------------------------------
		add(ItemRegistry.RUST_SPAWN_EGG.get(), "Rust Slime Spawn Egg");
		add(ItemRegistry.LUNAR_SPAWN_EGG.get(), "Lunar Slime Spawn Egg");
		add(ItemRegistry.MARS_MALLOW_SPAWN_EGG.get(), "Mars Mallow Spawn Egg");
		add(ItemRegistry.LURKER_SPAWN_EGG.get(), "Lurker Spawn Egg");
		add(ItemRegistry.VOIDFELLOW_SPAWN_EGG.get(), "Space Fellow Spawn Egg");
		add(ItemRegistry.VOIDED_SPAWN_EGG.get(), "Voided Spawn Egg");
		add(ItemRegistry.SULFUR_CUBE_SPAWN_EGG.get(), "Sulfur Cube Spawn Egg");
		add(ItemRegistry.VOIDED_PIGLIN_SPAWN_EGG.get(), "Voided Piglin Spawn Egg");
		add(ItemRegistry.FLARE_SPAWN_EGG.get(), "Flare Spawn Egg");
		add(ItemRegistry.GUST_SPAWN_EGG.get(), "Gust Spawn Egg");
		add(ItemRegistry.ASTRAL_PIGLIN_SPAWN_EGG.get(), "Astral Piglin Spawn Egg");
		add(ItemRegistry.ASTRAL_HOGLIN_SPAWN_EGG.get(), "Astral Hoglin Spawn Egg");
		add(ItemRegistry.VOIDED_ZOGLIN_SPAWN_EGG.get(), "Voided Zoglin Spawn Egg");

		//---- MOBS -------------------------------------------------------------------------------
		add(EntityRegistry.LUNAR_SLIME.get(), "Lunar Slime");
		add(EntityRegistry.MARS_MALLOW.get(), "Mars Mallow");
		add(EntityRegistry.RUST_SLIME.get(), "Rust Slime");
		add(EntityRegistry.LURKER.get(), "Lurker");
		add(EntityRegistry.VOIDFELLOW.get(), "Space Fellow");
		add(EntityRegistry.VOIDED.get(), "Voided");
		add(EntityRegistry.SULFUR_CUBE.get(), "Sulfur Cube");
		add(EntityRegistry.VOIDED_PIGLIN.get(), "Voided Piglin");
		add(EntityRegistry.FLARE.get(), "Flare");
		add(EntityRegistry.GUST.get(), "Gust");
		add(EntityRegistry.ASTRAL_PIGLIN.get(), "Astral Piglin");
		add(EntityRegistry.ASTRAL_HOGLIN.get(), "Astral Hoglin");
		add(EntityRegistry.VOIDED_ZOGLIN.get(), "Voided Zoglin");

		//---- FLUIDS -------------------------------------------------------------------------------
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
		add(FluidRegistry.SULFUR_BLOCK.get(), "Sulfur");
		add("fluid.celestialexploration.sulfur", "Sulfur");
		add(FluidRegistry.MOLTEN_ALUMINUM_BLOCK.get(), "Molten Aluminum");
		add("fluid.celestialexploration.molten_aluminum", "Molten Aluminum");
		add(FluidRegistry.SULFUR_BUCKET.get(), "Sulfur Bucket");

		//---- BIOMES -------------------------------------------------------------------------------
		add("biome.celestialexploration.moon_craters", "Lunar Craters");
		add("biome.celestialexploration.moon_desert", "Lunar Desert");
		add("biome.celestialexploration.moon_lava_flats", "Lunar Lava Flats");
		add("biome.celestialexploration.moon_lower_plains", "Lunar Lower Plains");
		add("biome.celestialexploration.moon_plains", "Lunar Plains");
		add("biome.celestialexploration.mars_craters_", "Martian Craters");
		add("biome.celestialexploration.mars_deep_craters", "Martian Deep Craters");
		add("biome.celestialexploration.mars_desert", "Martian Desert");
		add("biome.celestialexploration.mars_dunes", "Martian Dunes");
		add("biome.celestialexploration.mars_dry_ice_flats", "Martian Dry Ice Flats");
		add("biome.celestialexploration.mars_dry_ice_peaks", "Martian Dry Ice Peaks");
		add("biome.celestialexploration.mars_eroded_flats", "Martian Eroded Flats");
		add("biome.celestialexploration.mars_volcano_flats", "Martian Volcano Flats");
		add("biome.celestialexploration.venus_desert", "Venusian Desert");
		add("biome.celestialexploration.venus_lower_plains", "Venusian Lower Plains");
		add("biome.celestialexploration.venus_plains", "Venusian Plains");
		add("biome.celestialexploration.venus_sulfur_flats", "Venusian Sulfur Flats");
		add("biome.celestialexploration.space", "Space");

		//---- EFFECTS -------------------------------------------------------------------------------
		add(EffectRegistry.LOW_GRAVITY.get(), "Low Gravity");
		add(EffectRegistry.EXTRA_LOW_GRAVITY.get(), "Extra Low Gravity");
		add(EffectRegistry.HIGH_GRAVITY.get(), "High Gravity");

		//---- TABS -------------------------------------------------------------------------------
		add("itemGroup.celestial_blocks_tab", "Celestial Blocks");
		add("itemGroup.spaceship_tab", "Spaceship Items");
		add("itemGroup.celestial_misc_tab", "Celestial Items");

		//---- KEYBINDINGS -------------------------------------------------------------------------------
		add("key.categories.spaceship_controls", "Spaceship Controls");
		add("key.celestialexploration.flight_ascent", "Spaceship Ascent");
		add("key.celestialexploration.flight_descent", "Spaceship Descent");
		add("key.celestialexploration.turn_left", "Spaceship Strafe Left");
		add("key.celestialexploration.turn_right", "Spaceship Strafe Right");

		//---- DAMAGE SOURCES -------------------------------------------------------------------------------
		add("death.attack.celestialexploration.touchedSun", "%1$s discovered the heat of the sun");
		add("death.attack.celestialexploration.coldFloor", "%1$s got cold feet");

		//---- ADVANCEMENTS -------------------------------------------------------------------------------
		add("advancements.celestial.fly_into_sun.title", "Icarus");
		add("advancements.celestial.fly_into_sun.description", "Fly into the sun");
		add("advancements.celestial.enter_space.title", "To Infinity… And Beyond!");
		add("advancements.celestial.enter_space.description", "Enter space");
		add("advancements.celestial.enter_moon.title", "One Small Step For Man…");
		add("advancements.celestial.enter_moon.description", "Reach the moon");
		add("advancements.celestial.plant_potato.title", "The Best Botanist On This Planet");
		add("advancements.celestial.plant_potato.description", "Plant potatoes on Mars");

	}
}
