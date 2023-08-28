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


	}
	
	

}
