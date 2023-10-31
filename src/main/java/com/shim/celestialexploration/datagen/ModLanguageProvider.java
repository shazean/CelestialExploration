package com.shim.celestialexploration.datagen;

import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestialexploration.registry.BiomeRegistry;
import com.shim.celestialexploration.registry.BlockRegistry;

import com.shim.celestialexploration.registry.EntityRegistry;
import com.shim.celestialexploration.registry.ItemRegistry;
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
		add(BiomeRegistry.MOON_CRATERS.getRegistryName().getNamespace(), "Lunar Craters");
//		add(BiomeRegistry.MOON_DESERT.getRegistryName().getNamespace(), "Lunar Desert");
//		add(BiomeRegistry.MOON_LAVA_FLATS.getRegistryName().getNamespace(), "Lunar Lava Flats");
//		add(BiomeRegistry.MOON_LOWER_PLAINS.getRegistryName().getNamespace(), "Lunar Lower Plains");
//		add(BiomeRegistry.MOON_PLAINS.getRegistryName().getNamespace(), "Lunar Plains");
//		add(BiomeRegistry.MARS_CRATERS.getRegistryName().getNamespace(), "Martian Craters");
//		add(BiomeRegistry.MARS_DEEP_CRATERS.getRegistryName().getNamespace(), "Martian Deep Craters");
//		add(BiomeRegistry.MARS_DESERT.getRegistryName().getNamespace(), "Martian Desert");
//		add(BiomeRegistry.MARS_DUNES.getRegistryName().getNamespace(), "Martian Dunes");
//		add(BiomeRegistry.MARS_DRY_ICE_FLATS.getRegistryName().getNamespace(), "Martian Dry Ice Flats");
//		add(BiomeRegistry.MARS_DRY_ICE_PEAKS.getRegistryName().getNamespace(), "Martian Dry Ice Peaks");
//		add(BiomeRegistry.MARS_ERODED_FLATS.getRegistryName().getNamespace(), "Martian Eroded Flats");
//		add(BiomeRegistry.MARS_VOLCANO_FLATS.getRegistryName().getNamespace(), "Martian Volcano Flats");
//		add(BiomeRegistry.MARS_FLATS.getRegistryName().getNamespace(), "Martian Flats");

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
		add(BlockRegistry.LUNAR_LANTERN.get(), "Lunar Lantern");
		add(ItemRegistry.MOON_DUST.get(), "Lunar Dust");
		add(BlockRegistry.MOON_COBBLESTONE.get(), "Lunar Cobblestone");
		add(BlockRegistry.MOON_BRICK_PILLAR.get(), "Lunar Brick Pillar");
		add(BlockRegistry.MOON_DEEPSLATE.get(), "Lunar Deepslate");
		add(BlockRegistry.MOON_COBBLED_DEEPSLATE.get(), "Lunar Cobbled Deepslate");
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
		add(ItemRegistry.LOX_BUCKET.get(), "Liquid Oxygen Bucket");
		add(ItemRegistry.STEEL_ROD.get(), "Steel Rod");
		add(ItemRegistry.STEEL_INGOT.get(), "Steel Ingot");
		add(BlockRegistry.STEEL_BLOCK.get(), "Steel Block");
		add(BlockRegistry.CERAMIC.get(), "Ceramic");
		add(BlockRegistry.CERAMIC_TILE.get(), "Ceramic Tile");
		add(BlockRegistry.DRY_ICE.get(), "Dry Ice");
		add(BlockRegistry.LUMINOUS_BLUE_GLASS.get(), "Luminous Blue Glass");
		add(BlockRegistry.LUMINOUS_WHITE_GLASS.get(), "Luminous White Glass");
		add(BlockRegistry.LUMINOUS_BLUE_GLASS_PANE.get(), "Luminous Blue Glass Pane");
		add(BlockRegistry.LUMINOUS_WHITE_GLASS_PANE.get(), "Luminous White Glass Pane");


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

		/**MOBS**/
		add(EntityRegistry.LUNAR_SLIME.get(), "Lunar Slime");
		add(EntityRegistry.MARS_MALLOW.get(), "Mars Mallow");
		add(EntityRegistry.RUST_SLIME.get(), "Rust Slime");
		add(EntityRegistry.LURKER.get(), "Lurker");

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
		add(ItemRegistry.NOSE_CONE.get(), "Shuttle Nose Cone");

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

		add(ItemRegistry.IRON_DUST.get(), "Iron Dust");
		add(ItemRegistry.RUSTED_IRON_NUGGET.get(), "Rusted Iron Nugget");

	}
}
