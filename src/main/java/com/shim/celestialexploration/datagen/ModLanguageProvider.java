package com.shim.celestialexploration.datagen;

import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestialexploration.registry.BlockRegistry;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.LanguageProvider;

public class ModLanguageProvider extends LanguageProvider {

	public ModLanguageProvider(DataGenerator gen, String locale) {
		super(gen, CelestialExploration.MODID, locale);
	}

	@Override
	protected void addTranslations() {
		add("itemGroup." + CelestialExploration.CELESTIAL_TAB.getDisplayName(), "Celestial Tab");
		
		
		//***BLOCKS***
		//MOON
		add(BlockRegistry.MOON_BRICK_SLAB.get(), "Lunar Brick Slab");
		add(BlockRegistry.MOON_BRICK_STAIRS.get(), "Lunar Brick Stairs");
		add(BlockRegistry.MOON_BRICK_WALL.get(), "Lunar Brick Wall");
		add(BlockRegistry.MOON_BRICKS.get(), "Lunar Bricks");
		add(BlockRegistry.MOON_IRON_ORE.get(), "Lunar Iron Ore");
		add(BlockRegistry.MOON_REDSTONE_ORE.get(), "Lunar Redstone Ore");
		add(BlockRegistry.MOON_SAND.get(), "Lunar Sand");
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
		add(BlockRegistry.MARS_SAND.get(), "Martian Sand");
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
		
		
	}
	
	

}
