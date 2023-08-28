package com.shim.celestialexploration.datagen;

import com.shim.celestialexploration.registry.BlockRegistry;

import com.shim.celestialexploration.registry.ItemRegistry;
import net.minecraft.data.DataGenerator;
import net.minecraft.world.item.Items;

public class LootTables  extends BaseLootTableProvider {

    public LootTables(DataGenerator dataGeneratorIn) {
        super(dataGeneratorIn);
    }

    @Override
    protected void addTables() {
//        lootTables.put(Registration.FANCYBLOCK.get(), createStandardTable("fancyblock", Registration.FANCYBLOCK.get(), Registration.FANCYBLOCK_TILE.get()));
    	//MOON
    	//TODO ores
    	lootTables.put(BlockRegistry.MOON_BRICK_SLAB.get(), createSimpleTable("moon_brick_slab", BlockRegistry.MOON_BRICK_SLAB.get()));
    	lootTables.put(BlockRegistry.MOON_BRICK_STAIRS.get(), createSimpleTable("moon_brick_stairs", BlockRegistry.MOON_BRICK_STAIRS.get()));
    	lootTables.put(BlockRegistry.MOON_BRICK_WALL.get(), createSimpleTable("moon_brick_wall", BlockRegistry.MOON_BRICK_WALL.get()));
    	lootTables.put(BlockRegistry.MOON_BRICKS.get(), createSimpleTable("moon_bricks", BlockRegistry.MOON_BRICKS.get()));
    	lootTables.put(BlockRegistry.MOON_SAND.get(), createSimpleTable("moon_sand", BlockRegistry.MOON_SAND.get()));
    	lootTables.put(BlockRegistry.MOON_STONE.get(), createSimpleTable("moon_stone", BlockRegistry.MOON_STONE.get()));
    	lootTables.put(BlockRegistry.CHISELED_MOON_BRICKS.get(), createSimpleTable("chiseled_moon_bricks", BlockRegistry.CHISELED_MOON_BRICKS.get()));
    	lootTables.put(BlockRegistry.GLOWING_MOON_SAND.get(), createSilkTouchTable("glowing_moon_sand", BlockRegistry.GLOWING_MOON_SAND.get(), ItemRegistry.MOON_DUST.get(), 2, 4));
    	lootTables.put(BlockRegistry.MOON_IRON_ORE.get(), createSimpleItemTable("moon_iron_ore", Items.RAW_IRON));
    	lootTables.put(BlockRegistry.MOON_REDSTONE_ORE.get(), createSimpleItemTable("moon_redstone_ore", Items.REDSTONE));

    	
    	//MARS
    	lootTables.put(BlockRegistry.CHISELED_MARS_BRICKS.get(), createSimpleTable("chiseled_mars_bricks", BlockRegistry.CHISELED_MARS_BRICKS.get()));
    	lootTables.put(BlockRegistry.MARS_BRICK_SLAB.get(), createSimpleTable("mars_brick_slab", BlockRegistry.MARS_BRICK_SLAB.get()));
    	lootTables.put(BlockRegistry.MARS_BRICK_STAIRS.get(), createSimpleTable("mars_brick_stairs", BlockRegistry.MARS_BRICK_STAIRS.get()));
    	lootTables.put(BlockRegistry.MARS_BRICK_WALL.get(), createSimpleTable("mars_brick_wall", BlockRegistry.MARS_BRICK_WALL.get()));
    	lootTables.put(BlockRegistry.MARS_BRICKS.get(), createSimpleTable("mars_bricks", BlockRegistry.MARS_BRICKS.get()));
    	lootTables.put(BlockRegistry.MARS_SAND.get(), createSimpleTable("mars_sand", BlockRegistry.MARS_SAND.get()));
    	lootTables.put(BlockRegistry.MARS_STONE.get(), createSimpleTable("mars_stone", BlockRegistry.MARS_STONE.get()));
    	lootTables.put(BlockRegistry.MARS_IRON_ORE.get(), createSimpleItemTable("mars_iron_ore", Items.RAW_IRON));
    	lootTables.put(BlockRegistry.MARS_REDSTONE_ORE.get(), createSimpleItemTable("mars_redstone_ore", Items.REDSTONE));

    	
    	//METEOR
    	lootTables.put(BlockRegistry.METEOR.get(), createSimpleTable("meteor", BlockRegistry.METEOR.get()));
    	lootTables.put(BlockRegistry.METEOR_BRICK_SLAB.get(), createSimpleTable("meteor_brick_slab", BlockRegistry.METEOR_BRICK_SLAB.get()));
    	lootTables.put(BlockRegistry.METEOR_BRICK_STAIRS.get(), createSimpleTable("moon_brick_stairs", BlockRegistry.METEOR_BRICK_STAIRS.get()));
    	lootTables.put(BlockRegistry.METEOR_BRICK_WALL.get(), createSimpleTable("meteor_brick_wall", BlockRegistry.METEOR_BRICK_WALL.get()));
    	lootTables.put(BlockRegistry.METEOR_BRICKS.get(), createSimpleTable("meteor_bricks", BlockRegistry.METEOR_BRICKS.get()));
    	lootTables.put(BlockRegistry.METEOR_COAL_ORE.get(), createSimpleItemTable("meteor_coal_ore", Items.COAL));
    	lootTables.put(BlockRegistry.METEOR_COPPER_ORE.get(), createSimpleItemTable("meteor_copper_ore", Items.RAW_COPPER));
    	lootTables.put(BlockRegistry.METEOR_DIAMOND_ORE.get(), createSimpleItemTable("meteor_diamond_ore", Items.DIAMOND));
    	lootTables.put(BlockRegistry.METEOR_EMERALD_ORE.get(), createSimpleItemTable("meteor_emerald_ore", Items.EMERALD));
    	lootTables.put(BlockRegistry.METEOR_GOLD_ORE.get(), createSimpleItemTable("meteor_gold_ore", Items.RAW_GOLD));
    	lootTables.put(BlockRegistry.METEOR_IRON_ORE.get(), createSimpleItemTable("meteor_iron_ore", Items.RAW_IRON));
    	lootTables.put(BlockRegistry.METEOR_LAPIS_ORE.get(), createSimpleItemTable("meteor_lapis_ore", Items.LAPIS_LAZULI));
    	lootTables.put(BlockRegistry.METEOR_REDSTONE_ORE.get(), createSimpleItemTable("meteor_redstone_ore", Items.REDSTONE));
    	lootTables.put(BlockRegistry.CHISELED_METEOR_BRICKS.get(), createSimpleTable("chiseled_meteor_bricks", BlockRegistry.CHISELED_METEOR_BRICKS.get()));

		//OTHER
    	lootTables.put(BlockRegistry.SOLAR_PANEL.get(), createSimpleTable("solar_panel", BlockRegistry.SOLAR_PANEL.get()));
		lootTables.put(BlockRegistry.LUNAR_LANTERN.get(), createSilkTouchTable("lunar_lantern", BlockRegistry.LUNAR_LANTERN.get(), ItemRegistry.MOON_DUST.get(), 1, 3));



	}
}