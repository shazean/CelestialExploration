package com.shim.celestialexploration.datagen;

import com.shim.celestialexploration.registry.BlockRegistry;

import com.shim.celestialexploration.registry.ItemRegistry;
import net.minecraft.data.DataGenerator;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;

public class LootTables  extends BaseLootTableProvider {

    public LootTables(DataGenerator dataGeneratorIn) {
        super(dataGeneratorIn);
    }

    @Override
    protected void addTables() {
    	/**
		 * MOON
		 */
    	lootTables.put(BlockRegistry.MOON_BRICK_SLAB.get(), createSimpleTable("moon_brick_slab", BlockRegistry.MOON_BRICK_SLAB.get()));
    	lootTables.put(BlockRegistry.MOON_BRICK_STAIRS.get(), createSimpleTable("moon_brick_stairs", BlockRegistry.MOON_BRICK_STAIRS.get()));
    	lootTables.put(BlockRegistry.MOON_BRICK_WALL.get(), createSimpleTable("moon_brick_wall", BlockRegistry.MOON_BRICK_WALL.get()));
    	lootTables.put(BlockRegistry.MOON_BRICKS.get(), createSimpleTable("moon_bricks", BlockRegistry.MOON_BRICKS.get()));
    	lootTables.put(BlockRegistry.MOON_SAND.get(), createSimpleTable("moon_sand", BlockRegistry.MOON_SAND.get()));
		lootTables.put(BlockRegistry.COARSE_MOON_SAND.get(), createSimpleTable("coarse_moon_sand", BlockRegistry.COARSE_MOON_SAND.get()));
		//    	lootTables.put(BlockRegistry.MOON_STONE.get(), createSimpleTable("moon_stone", BlockRegistry.MOON_STONE.get()));
		lootTables.put(BlockRegistry.MOON_STONE.get(), createSilkTouchTable("moon_stone", BlockRegistry.MOON_STONE.get(), BlockRegistry.MOON_COBBLESTONE.get(), 1, 1));
    	lootTables.put(BlockRegistry.CHISELED_MOON_BRICKS.get(), createSimpleTable("chiseled_moon_bricks", BlockRegistry.CHISELED_MOON_BRICKS.get()));
    	lootTables.put(BlockRegistry.GLOWING_MOON_SAND.get(), createSilkTouchTable("glowing_moon_sand", BlockRegistry.GLOWING_MOON_SAND.get(), ItemRegistry.MOON_DUST.get(), 2, 4));
    	lootTables.put(BlockRegistry.MOON_IRON_ORE.get(), createSimpleItemTable("moon_iron_ore", Items.RAW_IRON));
    	lootTables.put(BlockRegistry.MOON_REDSTONE_ORE.get(), createSimpleItemTable("moon_redstone_ore", Items.REDSTONE));
		lootTables.put(BlockRegistry.MOON_COBBLESTONE.get(), createSimpleTable("moon_cobblestone", BlockRegistry.MOON_COBBLESTONE.get()));
		lootTables.put(BlockRegistry.MOON_DEEPSLATE.get(), createSilkTouchTable("moon_deepslate", BlockRegistry.MOON_DEEPSLATE.get(), BlockRegistry.MOON_COBBLED_DEEPSLATE.get(), 1, 1));
		lootTables.put(BlockRegistry.MOON_COBBLED_DEEPSLATE.get(), createSimpleTable("moon_cobblestone", BlockRegistry.MOON_COBBLED_DEEPSLATE.get()));
		lootTables.put(BlockRegistry.MOON_BRICK_PILLAR.get(), createSimpleTable("moon_brick_pillar", BlockRegistry.MOON_BRICK_PILLAR.get()));
		lootTables.put(BlockRegistry.MOON_DEEPSLATE_IRON_ORE.get(), createSimpleItemTable("moon_deepslate_iron_ore", Items.RAW_IRON));
		lootTables.put(BlockRegistry.MOON_DEEPSLATE_REDSTONE_ORE.get(), createSimpleItemTable("moon_deepslate_redstone_ore", Items.REDSTONE));

		lootTables.put(BlockRegistry.COMPRESSED_MOON_COBBLESTONE.get(), createSimpleTable("compressed_moon_cobblestone", BlockRegistry.COMPRESSED_MOON_COBBLESTONE.get()));
		lootTables.put(BlockRegistry.COMPRESSED_MOON_COBBLED_DEEPSLATE.get(), createSimpleTable("compressed_moon_cobbled_deepslate", BlockRegistry.COMPRESSED_MOON_COBBLED_DEEPSLATE.get()));

		lootTables.put(BlockRegistry.MOON_STONE_STAIRS.get(), createSimpleTable("moon_stone_stairs", BlockRegistry.MOON_STONE_STAIRS.get()));
		lootTables.put(BlockRegistry.MOON_STONE_SLAB.get(), createSimpleTable("moon_stone_slab", BlockRegistry.MOON_STONE_SLAB.get()));

		lootTables.put(BlockRegistry.MOON_COBBLESTONE_SLAB.get(), createSimpleTable("moon_cobblestone_slab", BlockRegistry.MOON_COBBLESTONE_SLAB.get()));
		lootTables.put(BlockRegistry.MOON_COBBLESTONE_STAIRS.get(), createSimpleTable("moon_cobblestone_stairs", BlockRegistry.MOON_COBBLESTONE_STAIRS.get()));
		lootTables.put(BlockRegistry.MOON_COBBLESTONE_WALL.get(), createSimpleTable("moon_cobblestone_wall", BlockRegistry.MOON_COBBLESTONE_WALL.get()));

		lootTables.put(BlockRegistry.MOON_COBBLED_DEEPSLATE_SLAB.get(), createSimpleTable("moon_cobbled_deepslate_slab", BlockRegistry.MOON_COBBLED_DEEPSLATE_SLAB.get()));
		lootTables.put(BlockRegistry.MOON_COBBLED_DEEPSLATE_STAIRS.get(), createSimpleTable("moon_cobbled_deepslate_stairs", BlockRegistry.MOON_COBBLED_DEEPSLATE_STAIRS.get()));
		lootTables.put(BlockRegistry.MOON_COBBLED_DEEPSLATE_WALL.get(), createSimpleTable("moon_cobbled_deepslate_wall", BlockRegistry.MOON_COBBLED_DEEPSLATE_WALL.get()));

		lootTables.put(BlockRegistry.MOON_SMOOTH_STONE.get(), createSimpleTable("moon_smooth_stone", BlockRegistry.MOON_SMOOTH_STONE.get()));
//		lootTables.put(BlockRegistry.MOON_SMOOTH_STONE_SLAB.get(), createSimpleTable("moon_smooth_stone_slab", BlockRegistry.MOON_SMOOTH_STONE_SLAB.get()));

		lootTables.put(BlockRegistry.MOON_DEEPSLATE_BRICKS.get(), createSimpleTable("moon_deepslate_bricks", BlockRegistry.MOON_DEEPSLATE_BRICKS.get()));
		lootTables.put(BlockRegistry.MOON_DEEPSLATE_BRICK_SLAB.get(), createSimpleTable("moon_deepslate_brick_slab", BlockRegistry.MOON_DEEPSLATE_BRICK_SLAB.get()));
		lootTables.put(BlockRegistry.MOON_DEEPSLATE_BRICK_STAIRS.get(), createSimpleTable("moon_deepslate_brick_stairs", BlockRegistry.MOON_DEEPSLATE_BRICK_STAIRS.get()));
		lootTables.put(BlockRegistry.MOON_DEEPSLATE_BRICK_WALL.get(), createSimpleTable("moon_deepslate_brick_wall", BlockRegistry.MOON_DEEPSLATE_BRICK_WALL.get()));

		lootTables.put(BlockRegistry.CHISELED_MOON_DEEPSLATE_BRICKS.get(), createSimpleTable("chiseled_moon_deepslate_bricks", BlockRegistry.CHISELED_MOON_DEEPSLATE_BRICKS.get()));
		lootTables.put(BlockRegistry.CRACKED_MOON_DEEPSLATE_BRICKS.get(), createSimpleTable("cracked_moon_deepslate_bricks", BlockRegistry.CRACKED_MOON_DEEPSLATE_BRICKS.get()));

		lootTables.put(BlockRegistry.MOON_POLISHED_DEEPSLATE.get(), createSimpleTable("moon_polished_deepslate", BlockRegistry.MOON_POLISHED_DEEPSLATE.get()));
		lootTables.put(BlockRegistry.MOON_POLISHED_DEEPSLATE_SLAB.get(), createSimpleTable("moon_polished_deepslate_slab", BlockRegistry.MOON_POLISHED_DEEPSLATE_SLAB.get()));
		lootTables.put(BlockRegistry.MOON_POLISHED_DEEPSLATE_STAIRS.get(), createSimpleTable("moon_polished_deepslate_stairs", BlockRegistry.MOON_POLISHED_DEEPSLATE_STAIRS.get()));
		lootTables.put(BlockRegistry.MOON_POLISHED_DEEPSLATE_WALL.get(), createSimpleTable("moon_polished_deepslate_wall", BlockRegistry.MOON_POLISHED_DEEPSLATE_WALL.get()));

		lootTables.put(BlockRegistry.MOON_DEEPSLATE_TILES.get(), createSimpleTable("moon_deepslate_tiles", BlockRegistry.MOON_DEEPSLATE_TILES.get()));
		lootTables.put(BlockRegistry.MOON_DEEPSLATE_TILE_SLAB.get(), createSimpleTable("moon_deepslate_tile_slab", BlockRegistry.MOON_DEEPSLATE_TILE_SLAB.get()));
		lootTables.put(BlockRegistry.MOON_DEEPSLATE_TILE_STAIRS.get(), createSimpleTable("moon_deepslate_tile_stairs", BlockRegistry.MOON_DEEPSLATE_TILE_STAIRS.get()));
		lootTables.put(BlockRegistry.MOON_DEEPSLATE_TILE_WALL.get(), createSimpleTable("moon_deepslate_tile_wall", BlockRegistry.MOON_DEEPSLATE_TILE_WALL.get()));

		lootTables.put(BlockRegistry.CRACKED_MOON_DEEPSLATE_TILES.get(), createSimpleTable("cracked_moon_deepslate_tiles", BlockRegistry.CRACKED_MOON_DEEPSLATE_TILES.get()));

		lootTables.put(BlockRegistry.MOON_STONE_BUTTON.get(), createSimpleTable("moon_stone_button", BlockRegistry.MOON_STONE_BUTTON.get()));
		lootTables.put(BlockRegistry.MOON_STONE_PRESSURE_PLATE.get(), createSimpleTable("moon_stone_pressure_plate", BlockRegistry.MOON_STONE_PRESSURE_PLATE.get()));
		lootTables.put(BlockRegistry.MOON_DEEPSLATE_BUTTON.get(), createSimpleTable("moon_deepslate_button", BlockRegistry.MOON_DEEPSLATE_BUTTON.get()));
		lootTables.put(BlockRegistry.MOON_DEEPSLATE_PRESSURE_PLATE.get(), createSimpleTable("moon_deepslate_pressure_plate", BlockRegistry.MOON_DEEPSLATE_PRESSURE_PLATE.get()));


		/**
         * MARS
         */
    	lootTables.put(BlockRegistry.CHISELED_MARS_BRICKS.get(), createSimpleTable("chiseled_mars_bricks", BlockRegistry.CHISELED_MARS_BRICKS.get()));
    	lootTables.put(BlockRegistry.MARS_BRICK_SLAB.get(), createSimpleTable("mars_brick_slab", BlockRegistry.MARS_BRICK_SLAB.get()));
    	lootTables.put(BlockRegistry.MARS_BRICK_STAIRS.get(), createSimpleTable("mars_brick_stairs", BlockRegistry.MARS_BRICK_STAIRS.get()));
    	lootTables.put(BlockRegistry.MARS_BRICK_WALL.get(), createSimpleTable("mars_brick_wall", BlockRegistry.MARS_BRICK_WALL.get()));
    	lootTables.put(BlockRegistry.MARS_BRICKS.get(), createSimpleTable("mars_bricks", BlockRegistry.MARS_BRICKS.get()));
    	lootTables.put(BlockRegistry.MARS_SAND.get(), createSimpleTable("mars_sand", BlockRegistry.MARS_SAND.get()));
		lootTables.put(BlockRegistry.COARSE_MARS_SAND.get(), createSimpleTable("coarse_mars_sand", BlockRegistry.COARSE_MARS_SAND.get()));

		//    	lootTables.put(BlockRegistry.MARS_STONE.get(), createSimpleTable("mars_stone", BlockRegistry.MARS_STONE.get()));
//		lootTables.put(BlockRegistry.MARS_STONE.get(), createSilkTouchTable("mars_stone", BlockRegistry.MARS_STONE.get(), BlockRegistry.MARS_COBBLESTONE.get(), 1, 1));
		lootTables.put(BlockRegistry.MARS_IRON_ORE.get(), createSimpleItemTable("mars_iron_ore", Items.RAW_IRON));
    	lootTables.put(BlockRegistry.MARS_REDSTONE_ORE.get(), createSimpleItemTable("mars_redstone_ore", Items.REDSTONE));
		lootTables.put(BlockRegistry.MARS_COBBLESTONE.get(), createSimpleTable("moon_cobblestone", BlockRegistry.MARS_COBBLESTONE.get()));
		lootTables.put(BlockRegistry.MARS_DEEPSLATE.get(), createSilkTouchTable("mars_deepslate", BlockRegistry.MARS_DEEPSLATE.get(), BlockRegistry.MARS_COBBLED_DEEPSLATE.get(), 1, 1));
		lootTables.put(BlockRegistry.MARS_COBBLED_DEEPSLATE.get(), createSimpleTable("mars_cobblestone", BlockRegistry.MARS_COBBLED_DEEPSLATE.get()));
		lootTables.put(BlockRegistry.MARS_BRICK_PILLAR.get(), createSimpleTable("mars_brick_pillar", BlockRegistry.MARS_BRICK_PILLAR.get()));
		lootTables.put(BlockRegistry.MARS_DEEPSLATE_IRON_ORE.get(), createSimpleItemTable("mars_deepslate_iron_ore", Items.RAW_IRON));
		lootTables.put(BlockRegistry.MARS_DEEPSLATE_REDSTONE_ORE.get(), createSimpleItemTable("mars_deepslate_redstone_ore", Items.REDSTONE));

		lootTables.put(BlockRegistry.COMPRESSED_MARS_COBBLESTONE.get(), createSimpleTable("compressed_mars_cobblestone", BlockRegistry.COMPRESSED_MARS_COBBLESTONE.get()));
		lootTables.put(BlockRegistry.COMPRESSED_MARS_COBBLED_DEEPSLATE.get(), createSimpleTable("compressed_mars_cobbled_deepslate", BlockRegistry.COMPRESSED_MARS_COBBLED_DEEPSLATE.get()));

		lootTables.put(BlockRegistry.MARS_STONE_STAIRS.get(), createSimpleTable("mars_stone_stairs", BlockRegistry.MARS_STONE_STAIRS.get()));
		lootTables.put(BlockRegistry.MARS_STONE_SLAB.get(), createSimpleTable("mars_stone_slab", BlockRegistry.MARS_STONE_SLAB.get()));

		lootTables.put(BlockRegistry.MARS_COBBLESTONE_SLAB.get(), createSimpleTable("mars_cobblestone_slab", BlockRegistry.MARS_COBBLESTONE_SLAB.get()));
		lootTables.put(BlockRegistry.MARS_COBBLESTONE_STAIRS.get(), createSimpleTable("mars_cobblestone_stairs", BlockRegistry.MARS_COBBLESTONE_STAIRS.get()));
		lootTables.put(BlockRegistry.MARS_COBBLESTONE_WALL.get(), createSimpleTable("mars_cobblestone_wall", BlockRegistry.MARS_COBBLESTONE_WALL.get()));

		lootTables.put(BlockRegistry.MARS_COBBLED_DEEPSLATE_SLAB.get(), createSimpleTable("mars_cobbled_deepslate_slab", BlockRegistry.MARS_COBBLED_DEEPSLATE_SLAB.get()));
		lootTables.put(BlockRegistry.MARS_COBBLED_DEEPSLATE_STAIRS.get(), createSimpleTable("mars_cobbled_deepslate_stairs", BlockRegistry.MARS_COBBLED_DEEPSLATE_STAIRS.get()));
		lootTables.put(BlockRegistry.MARS_COBBLED_DEEPSLATE_WALL.get(), createSimpleTable("mars_cobbled_deepslate_wall", BlockRegistry.MARS_COBBLED_DEEPSLATE_WALL.get()));

		lootTables.put(BlockRegistry.MARS_SMOOTH_STONE.get(), createSimpleTable("mars_smooth_stone", BlockRegistry.MARS_SMOOTH_STONE.get()));
//		lootTables.put(BlockRegistry.MARS_SMOOTH_STONE_SLAB.get(), createSimpleTable("mars_smooth_stone_slab", BlockRegistry.MARS_SMOOTH_STONE_SLAB.get()));

		lootTables.put(BlockRegistry.MARS_DEEPSLATE_BRICKS.get(), createSimpleTable("mars_deepslate_bricks", BlockRegistry.MARS_DEEPSLATE_BRICKS.get()));
		lootTables.put(BlockRegistry.MARS_DEEPSLATE_BRICK_SLAB.get(), createSimpleTable("mars_deepslate_brick_slab", BlockRegistry.MARS_DEEPSLATE_BRICK_SLAB.get()));
		lootTables.put(BlockRegistry.MARS_DEEPSLATE_BRICK_STAIRS.get(), createSimpleTable("mars_deepslate_brick_stairs", BlockRegistry.MARS_DEEPSLATE_BRICK_STAIRS.get()));
		lootTables.put(BlockRegistry.MARS_DEEPSLATE_BRICK_WALL.get(), createSimpleTable("mars_deepslate_brick_wall", BlockRegistry.MARS_DEEPSLATE_BRICK_WALL.get()));

		lootTables.put(BlockRegistry.CHISELED_MARS_DEEPSLATE_BRICKS.get(), createSimpleTable("chiseled_mars_deepslate_bricks", BlockRegistry.CHISELED_MARS_DEEPSLATE_BRICKS.get()));
		lootTables.put(BlockRegistry.CRACKED_MARS_DEEPSLATE_BRICKS.get(), createSimpleTable("cracked_mars_deepslate_bricks", BlockRegistry.CRACKED_MARS_DEEPSLATE_BRICKS.get()));

		lootTables.put(BlockRegistry.MARS_POLISHED_DEEPSLATE.get(), createSimpleTable("mars_polished_deepslate", BlockRegistry.MARS_POLISHED_DEEPSLATE.get()));
		lootTables.put(BlockRegistry.MARS_POLISHED_DEEPSLATE_SLAB.get(), createSimpleTable("mars_polished_deepslate_slab", BlockRegistry.MARS_POLISHED_DEEPSLATE_SLAB.get()));
		lootTables.put(BlockRegistry.MARS_POLISHED_DEEPSLATE_STAIRS.get(), createSimpleTable("mars_polished_deepslate_stairs", BlockRegistry.MARS_POLISHED_DEEPSLATE_STAIRS.get()));
		lootTables.put(BlockRegistry.MARS_POLISHED_DEEPSLATE_WALL.get(), createSimpleTable("mars_polished_deepslate_wall", BlockRegistry.MARS_POLISHED_DEEPSLATE_WALL.get()));

		lootTables.put(BlockRegistry.MARS_DEEPSLATE_TILES.get(), createSimpleTable("mars_deepslate_tiles", BlockRegistry.MARS_DEEPSLATE_TILES.get()));
		lootTables.put(BlockRegistry.MARS_DEEPSLATE_TILE_SLAB.get(), createSimpleTable("mars_deepslate_tile_slab", BlockRegistry.MARS_DEEPSLATE_TILE_SLAB.get()));
		lootTables.put(BlockRegistry.MARS_DEEPSLATE_TILE_STAIRS.get(), createSimpleTable("mars_deepslate_tile_stairs", BlockRegistry.MARS_DEEPSLATE_TILE_STAIRS.get()));
		lootTables.put(BlockRegistry.MARS_DEEPSLATE_TILE_WALL.get(), createSimpleTable("mars_deepslate_tile_wall", BlockRegistry.MARS_DEEPSLATE_TILE_WALL.get()));

		lootTables.put(BlockRegistry.CRACKED_MARS_DEEPSLATE_TILES.get(), createSimpleTable("cracked_mars_deepslate_tiles", BlockRegistry.CRACKED_MARS_DEEPSLATE_TILES.get()));

		lootTables.put(BlockRegistry.MARS_STONE_BUTTON.get(), createSimpleTable("mars_stone_button", BlockRegistry.MARS_STONE_BUTTON.get()));
		lootTables.put(BlockRegistry.MARS_STONE_PRESSURE_PLATE.get(), createSimpleTable("mars_stone_pressure_plate", BlockRegistry.MARS_STONE_PRESSURE_PLATE.get()));
		lootTables.put(BlockRegistry.MARS_DEEPSLATE_BUTTON.get(), createSimpleTable("mars_deepslate_button", BlockRegistry.MARS_DEEPSLATE_BUTTON.get()));
		lootTables.put(BlockRegistry.MARS_DEEPSLATE_PRESSURE_PLATE.get(), createSimpleTable("mars_deepslate_pressure_plate", BlockRegistry.MARS_DEEPSLATE_PRESSURE_PLATE.get()));


		/**
         * METEOR
         */
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

		lootTables.put(BlockRegistry.METEOR_BUTTON.get(), createSimpleTable("meteor_button", BlockRegistry.METEOR_BUTTON.get()));
		lootTables.put(BlockRegistry.METEOR_PRESSURE_PLATE.get(), createSimpleTable("meteor_pressure_plate", BlockRegistry.METEOR_PRESSURE_PLATE.get()));


		/**
		 * OTHER
		 */
//    	lootTables.put(BlockRegistry.SOLAR_PANEL.get(), createSimpleTable("solar_panel", BlockRegistry.SOLAR_PANEL.get()));
		lootTables.put(BlockRegistry.LUNAR_LANTERN.get(), createSilkTouchTable("lunar_lantern", BlockRegistry.LUNAR_LANTERN.get(), ItemRegistry.MOON_DUST.get(), 1, 3));

//		lootTables.put(BlockRegistry.IGNEOUS_ROCK.get(), createSimpleTable("igneous_rock", BlockRegistry.IGNEOUS_ROCK.get()));
		lootTables.put(BlockRegistry.STEEL_BLOCK.get(), createSimpleTable("steel_block", BlockRegistry.STEEL_BLOCK.get()));
		lootTables.put(BlockRegistry.DRY_ICE.get(), createSimpleTable("dry_ice", BlockRegistry.DRY_ICE.get()));

		lootTables.put(BlockRegistry.LUMINOUS_BLUE_GLASS.get(), createSilkTouchTable("luminous_blue_glass", BlockRegistry.LUMINOUS_BLUE_GLASS.get(), ItemRegistry.MOON_DUST.get(), 1, 1));
		lootTables.put(BlockRegistry.LUMINOUS_WHITE_GLASS.get(), createSilkTouchTable("luminous_white_glass", BlockRegistry.LUMINOUS_WHITE_GLASS.get(), ItemRegistry.MOON_DUST.get(), 1, 1));
		lootTables.put(BlockRegistry.LUMINOUS_BLUE_GLASS_PANE.get(), createSilkTouchTable("luminous_blue_glass_pane", BlockRegistry.LUMINOUS_BLUE_GLASS_PANE.get(), ItemRegistry.MOON_DUST.get(), 1, 1));
		lootTables.put(BlockRegistry.LUMINOUS_WHITE_GLASS_PANE.get(), createSilkTouchTable("luminous_white_glass_pane", BlockRegistry.LUMINOUS_WHITE_GLASS_PANE.get(), ItemRegistry.MOON_DUST.get(), 1, 1));

		lootTables.put(BlockRegistry.REINFORCED_GLASS.get(), createSimpleTable("reinforced_glass", BlockRegistry.REINFORCED_GLASS.get()));
		lootTables.put(BlockRegistry.REINFORCED_GLASS_PANE.get(), createSimpleTable("reinforced_glass_pane", BlockRegistry.REINFORCED_GLASS_PANE.get()));


		lootTables.put(BlockRegistry.COMPRESSED_COBBLESTONE.get(), createSimpleTable("compressed_cobblestone", BlockRegistry.COMPRESSED_COBBLESTONE.get()));
		lootTables.put(BlockRegistry.COMPRESSED_COBBLED_DEEPSLATE.get(), createSimpleTable("compressed_cobbled_deepslate", BlockRegistry.COMPRESSED_COBBLED_DEEPSLATE.get()));


		/**
		 * SHUTTLE-RELATED
		 */
//		lootTables.put(BlockRegistry.ASSEMBLY_STATION.get(), createSimpleTable("assembly_station", BlockRegistry.ASSEMBLY_STATION.get()));
		lootTables.put(BlockRegistry.OXYGEN_COMPRESSOR.get(), createSimpleTable("oxygen_compressor", BlockRegistry.OXYGEN_COMPRESSOR.get()));
		lootTables.put(BlockRegistry.STEEL_FRAME.get(), createSimpleTable("steel_frame", BlockRegistry.STEEL_FRAME.get()));
	}
}