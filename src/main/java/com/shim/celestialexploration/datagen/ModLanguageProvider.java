package com.shim.celestialexploration.datagen;

import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestialexploration.registry.BlockRegistry;

import com.shim.celestialexploration.registry.ItemRegistry;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.LanguageProvider;

public class ModLanguageProvider extends LanguageProvider {

	public ModLanguageProvider(DataGenerator gen, String locale) {
		super(gen, CelestialExploration.MODID, locale);
	}

	@Override
	protected void addTranslations() {
		add("itemGroup.celestialtab", "Celestial Tab");
		
		
		//***BLOCKS***
		//MOON
		add(BlockRegistry.MOON_BRICK_SLAB.get(), "Lunar Brick Slab");
		add(BlockRegistry.MOON_BRICK_STAIRS.get(), "Lunar Brick Stairs");
		add(BlockRegistry.MOON_BRICK_WALL.get(), "Lunar Brick Wall");
		add(BlockRegistry.MOON_BRICKS.get(), "Lunar Bricks");
		add(BlockRegistry.MOON_IRON_ORE.get(), "Lunar Iron Ore");
		add(BlockRegistry.MOON_REDSTONE_ORE.get(), "Lunar Redstone Ore");
		add(BlockRegistry.MOON_SAND.get(), "Lunar Regolith");
		add(BlockRegistry.MOON_STONE.get(), "Lunar Stone");
		add(BlockRegistry.CHISELED_MOON_BRICKS.get(), "Chiseled Lunar Bricks");
		add(BlockRegistry.GLOWING_MOON_SAND.get(), "Glowing Lunar Sand");
		add(BlockRegistry.LUNAR_LANTERN.get(), "Lunar Lantern");
		
		
		//MARS
		add(BlockRegistry.CHISELED_MARS_BRICKS.get(), "Chiseled Martian Bricks");
		add(BlockRegistry.MARS_BRICK_SLAB.get(), "Martian Brick Slab");
		add(BlockRegistry.MARS_BRICK_STAIRS.get(), "Martian Brick Stairs");
		add(BlockRegistry.MARS_BRICK_WALL.get(), "Martian Brick Wall");
		add(BlockRegistry.MARS_BRICKS.get(), "Martian Bricks");
		add(BlockRegistry.MARS_IRON_ORE.get(), "Martian Iron Ore");
		add(BlockRegistry.MARS_REDSTONE_ORE.get(), "Martian Redstone Ore");
		add(BlockRegistry.MARS_SAND.get(), "Martian Regolith");
		add(BlockRegistry.MARS_STONE.get(), "Martian Stone");
		
		//METEOR
		add(BlockRegistry.METEOR.get(), "Meteorite");
		add(BlockRegistry.METEOR_BRICK_SLAB.get(), "Meteorite Brick Slab");
		add(BlockRegistry.METEOR_BRICK_STAIRS.get(), "Meteorite Brick Stairs");
		add(BlockRegistry.METEOR_BRICK_WALL.get(), "Meteorite Brick Wall");
		add(BlockRegistry.METEOR_BRICKS.get(), "Meteorite Bricks");
		add(BlockRegistry.METEOR_COAL_ORE.get(), "Meteorite Coal Ore");
		add(BlockRegistry.METEOR_COPPER_ORE.get(), "Meteorite Copper Ore");
		add(BlockRegistry.METEOR_DIAMOND_ORE.get(), "Meteorite Diamond Ore");
		add(BlockRegistry.METEOR_EMERALD_ORE.get(), "Meteorite Emerald Ore");
		add(BlockRegistry.METEOR_GOLD_ORE.get(), "Meteorite Gold Ore");
		add(BlockRegistry.METEOR_IRON_ORE.get(), "Meteorite Iron Ore");
		add(BlockRegistry.METEOR_LAPIS_ORE.get(), "Meteorite Lapis Lazuli Ore");
		add(BlockRegistry.METEOR_REDSTONE_ORE.get(), "Meteorite Redstone Ore");

		//OTHER
		add(BlockRegistry.SOLAR_PANEL.get(), "Solar Panel");
		add(BlockRegistry.IGNEOUS_ROCK.get(), "Igneous Rock");


		//ARMOR
		add(ItemRegistry.STEEL_BOOTS.get(), "Steel Boots");
		add(ItemRegistry.STEEL_CHESTPLATE.get(), "Steel Chestplate");
		add(ItemRegistry.STEEL_HELMET.get(), "Steel Helmet");
		add(ItemRegistry.STEEL_LEGGINGS.get(), "Steel Leggings");
		add(ItemRegistry.SPACE_SUIT_BOOTS.get(), "Space Suit Boots");
		add(ItemRegistry.SPACE_SUIT_CHESTPLATE.get(), "Space Suit Chestplate");
		add(ItemRegistry.SPACE_SUIT_HELMET.get(), "Space Suit Helmet");
		add(ItemRegistry.SPACE_SUIT_LEGGINGS.get(), "Space Suit Leggings");

		//SPAWN EGGS
		add(ItemRegistry.RUST_SPAWN_EGG.get(), "Rust Slime Spawn Egg");
		add(ItemRegistry.LUNAR_SPAWN_EGG.get(), "Lunar Slime Spawn Egg");
		add(ItemRegistry.MARS_MALLOW_SPAWN_EGG.get(), "Mars Mallow Spawn Egg");
		add(ItemRegistry.LURKER_SPAWN_EGG.get(), "Lurker Spawn Egg");

//		add(ItemRegistry.ASSEMBLY_STATION.get(), "Assembly Station");
		add(ItemRegistry.OXYGEN_COMPRESSOR.get(), "Oxygen Compressor");
		add(ItemRegistry.LOX_TANK.get(), "Liquid Oxygen Tank");
		add(ItemRegistry.LOX_BUCKET.get(), "Liquid Oxygen Bucket");

		//SHUTTLE
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

	}
	
	

}
