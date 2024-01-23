package com.shim.celestialexploration.datagen;

import com.shim.celestialexploration.blocks.AtmosphereBlock;
import com.shim.celestialexploration.blocks.SolarBlock;
import com.shim.celestialexploration.blocks.SolarFlareBlock;
import com.shim.celestialexploration.datagen.util.BaseLootTableProvider;
import com.shim.celestialexploration.registry.BlockRegistry;

import com.shim.celestialexploration.registry.ItemRegistry;
import net.minecraft.data.DataGenerator;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.registries.RegistryObject;

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
    	lootTables.put(BlockRegistry.GLOWING_MOON_SAND.get(), createSilkTouchTable("glowing_moon_sand", BlockRegistry.GLOWING_MOON_SAND.get(), ItemRegistry.MOON_DUST.get(), 2, 5));
    	lootTables.put(BlockRegistry.MOON_IRON_ORE.get(), createOreTable("moon_iron_ore", BlockRegistry.MOON_IRON_ORE.get(), Items.RAW_IRON));
    	lootTables.put(BlockRegistry.MOON_REDSTONE_ORE.get(), createOreTable("moon_redstone_ore", BlockRegistry.MOON_REDSTONE_ORE.get(), Items.REDSTONE));
		lootTables.put(BlockRegistry.MOON_COBBLESTONE.get(), createSimpleTable("moon_cobblestone", BlockRegistry.MOON_COBBLESTONE.get()));
		lootTables.put(BlockRegistry.MOON_DEEPSLATE.get(), createSilkTouchTable("moon_deepslate", BlockRegistry.MOON_DEEPSLATE.get(), BlockRegistry.MOON_COBBLED_DEEPSLATE.get(), 1, 1));
		lootTables.put(BlockRegistry.MOON_COBBLED_DEEPSLATE.get(), createSimpleTable("moon_cobblestone", BlockRegistry.MOON_COBBLED_DEEPSLATE.get()));
		lootTables.put(BlockRegistry.MOON_BRICK_PILLAR.get(), createSimpleTable("moon_brick_pillar", BlockRegistry.MOON_BRICK_PILLAR.get()));
		lootTables.put(BlockRegistry.MOON_DEEPSLATE_IRON_ORE.get(), createOreTable("moon_deepslate_iron_ore", BlockRegistry.MOON_DEEPSLATE_IRON_ORE.get(), Items.RAW_IRON));
		lootTables.put(BlockRegistry.MOON_DEEPSLATE_REDSTONE_ORE.get(), createOreTable("moon_deepslate_redstone_ore", BlockRegistry.MOON_DEEPSLATE_REDSTONE_ORE.get(), Items.REDSTONE));

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


		/*
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
		lootTables.put(BlockRegistry.MARS_IRON_ORE.get(), createOreTable("mars_iron_ore", BlockRegistry.MARS_IRON_ORE.get(), Items.RAW_IRON));
    	lootTables.put(BlockRegistry.MARS_REDSTONE_ORE.get(), createOreTable("mars_redstone_ore", BlockRegistry.MARS_REDSTONE_ORE.get(), Items.REDSTONE));
		lootTables.put(BlockRegistry.MARS_COBBLESTONE.get(), createSimpleTable("mars_cobblestone", BlockRegistry.MARS_COBBLESTONE.get()));
		lootTables.put(BlockRegistry.MARS_DEEPSLATE.get(), createSilkTouchTable("mars_deepslate", BlockRegistry.MARS_DEEPSLATE.get(), BlockRegistry.MARS_COBBLED_DEEPSLATE.get(), 1, 1));
		lootTables.put(BlockRegistry.MARS_COBBLED_DEEPSLATE.get(), createSimpleTable("mars_cobblestone", BlockRegistry.MARS_COBBLED_DEEPSLATE.get()));
		lootTables.put(BlockRegistry.MARS_BRICK_PILLAR.get(), createSimpleTable("mars_brick_pillar", BlockRegistry.MARS_BRICK_PILLAR.get()));
		lootTables.put(BlockRegistry.MARS_DEEPSLATE_IRON_ORE.get(), createOreTable("mars_deepslate_iron_ore", BlockRegistry.MARS_DEEPSLATE_IRON_ORE.get(), Items.RAW_IRON));
		lootTables.put(BlockRegistry.MARS_DEEPSLATE_REDSTONE_ORE.get(), createOreTable("mars_deepslate_redstone_ore", BlockRegistry.MARS_DEEPSLATE_REDSTONE_ORE.get(), Items.REDSTONE));

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


		/*
		 * VENUS
		 */
		lootTables.put(BlockRegistry.CHISELED_VENUS_BRICKS.get(), createSimpleTable("chiseled_venus_bricks", BlockRegistry.CHISELED_VENUS_BRICKS.get()));
		lootTables.put(BlockRegistry.VENUS_BRICK_SLAB.get(), createSimpleTable("venus_brick_slab", BlockRegistry.VENUS_BRICK_SLAB.get()));
		lootTables.put(BlockRegistry.VENUS_BRICK_STAIRS.get(), createSimpleTable("venus_brick_stairs", BlockRegistry.VENUS_BRICK_STAIRS.get()));
		lootTables.put(BlockRegistry.VENUS_BRICK_WALL.get(), createSimpleTable("venus_brick_wall", BlockRegistry.VENUS_BRICK_WALL.get()));
		lootTables.put(BlockRegistry.VENUS_BRICKS.get(), createSimpleTable("venus_bricks", BlockRegistry.VENUS_BRICKS.get()));
		lootTables.put(BlockRegistry.VENUS_SAND.get(), createSimpleTable("venus_sand", BlockRegistry.VENUS_SAND.get()));
		lootTables.put(BlockRegistry.FINE_VENUS_SAND.get(), createSimpleTable("coarse_venus_sand", BlockRegistry.FINE_VENUS_SAND.get()));

		lootTables.put(BlockRegistry.CRACKED_VENUS_BRICKS.get(), createSimpleTable("cracked_venus_bricks", BlockRegistry.CRACKED_VENUS_BRICKS.get()));

//		lootTables.put(BlockRegistry.VENUS_STONE.get(), createSimpleTable("venus_stone", BlockRegistry.VENUS_STONE.get()));
//		lootTables.put(BlockRegistry.MARS_STONE.get(), createSilkTouchTable("mars_stone", BlockRegistry.MARS_STONE.get(), BlockRegistry.MARS_COBBLESTONE.get(), 1, 1));
		lootTables.put(BlockRegistry.VENUS_IRON_ORE.get(), createOreTable("venus_iron_ore", BlockRegistry.VENUS_IRON_ORE.get(), Items.RAW_IRON));
		lootTables.put(BlockRegistry.VENUS_REDSTONE_ORE.get(), createOreTable("venus_redstone_ore", BlockRegistry.VENUS_REDSTONE_ORE.get(), Items.REDSTONE));
		lootTables.put(BlockRegistry.VENUS_LAPIS_ORE.get(), createOreTable("venus_lapis_ore", BlockRegistry.VENUS_LAPIS_ORE.get(), Items.LAPIS_LAZULI));
		lootTables.put(BlockRegistry.VENUS_COBBLESTONE.get(), createSimpleTable("venus_cobblestone", BlockRegistry.VENUS_COBBLESTONE.get()));
		lootTables.put(BlockRegistry.VENUS_DEEPSLATE.get(), createSilkTouchTable("venus_deepslate", BlockRegistry.VENUS_DEEPSLATE.get(), BlockRegistry.VENUS_COBBLED_DEEPSLATE.get(), 1, 1));
		lootTables.put(BlockRegistry.VENUS_COBBLED_DEEPSLATE.get(), createSimpleTable("venus_cobblestone", BlockRegistry.VENUS_COBBLED_DEEPSLATE.get()));
//		lootTables.put(BlockRegistry.VENUS_BRICK_PILLAR.get(), createSimpleTable("mars_brick_pillar", BlockRegistry.VENUS_BRICK_PILLAR.get()));
		lootTables.put(BlockRegistry.VENUS_DEEPSLATE_IRON_ORE.get(), createOreTable("venus_deepslate_iron_ore", BlockRegistry.VENUS_DEEPSLATE_IRON_ORE.get(), Items.RAW_IRON));
		lootTables.put(BlockRegistry.VENUS_DEEPSLATE_REDSTONE_ORE.get(), createOreTable("venus_deepslate_redstone_ore", BlockRegistry.VENUS_DEEPSLATE_REDSTONE_ORE.get(), Items.REDSTONE));
		lootTables.put(BlockRegistry.VENUS_DEEPSLATE_LAPIS_ORE.get(), createOreTable("venus_deepslate_lapis_ore", BlockRegistry.VENUS_DEEPSLATE_LAPIS_ORE.get(), Items.LAPIS_LAZULI));

		lootTables.put(BlockRegistry.GEYSER.get(), createSimpleTable("geyser", BlockRegistry.GEYSER.get()));

		lootTables.put(BlockRegistry.COMPRESSED_VENUS_COBBLESTONE.get(), createSimpleTable("compressed_venus_cobblestone", BlockRegistry.COMPRESSED_VENUS_COBBLESTONE.get()));
		lootTables.put(BlockRegistry.COMPRESSED_VENUS_COBBLED_DEEPSLATE.get(), createSimpleTable("compressed_venus_cobbled_deepslate", BlockRegistry.COMPRESSED_VENUS_COBBLED_DEEPSLATE.get()));


		lootTables.put(BlockRegistry.VENUS_STONE_STAIRS.get(), createSimpleTable("venus_stone_stairs", BlockRegistry.VENUS_STONE_STAIRS.get()));
		lootTables.put(BlockRegistry.VENUS_STONE_SLAB.get(), createSimpleTable("venus_stone_slab", BlockRegistry.VENUS_STONE_SLAB.get()));

		lootTables.put(BlockRegistry.VENUS_COBBLESTONE_SLAB.get(), createSimpleTable("venus_cobblestone_slab", BlockRegistry.VENUS_COBBLESTONE_SLAB.get()));
		lootTables.put(BlockRegistry.VENUS_COBBLESTONE_STAIRS.get(), createSimpleTable("venus_cobblestone_stairs", BlockRegistry.VENUS_COBBLESTONE_STAIRS.get()));
		lootTables.put(BlockRegistry.VENUS_COBBLESTONE_WALL.get(), createSimpleTable("venus_cobblestone_wall", BlockRegistry.VENUS_COBBLESTONE_WALL.get()));

		lootTables.put(BlockRegistry.VENUS_COBBLED_DEEPSLATE_SLAB.get(), createSimpleTable("venus_cobbled_deepslate_slab", BlockRegistry.VENUS_COBBLED_DEEPSLATE_SLAB.get()));
		lootTables.put(BlockRegistry.VENUS_COBBLED_DEEPSLATE_STAIRS.get(), createSimpleTable("venus_cobbled_deepslate_stairs", BlockRegistry.VENUS_COBBLED_DEEPSLATE_STAIRS.get()));
		lootTables.put(BlockRegistry.VENUS_COBBLED_DEEPSLATE_WALL.get(), createSimpleTable("venus_cobbled_deepslate_wall", BlockRegistry.VENUS_COBBLED_DEEPSLATE_WALL.get()));

//		lootTables.put(BlockRegistry.VENUS_SMOOTH_STONE.get(), createSimpleTable("mars_smooth_stone", BlockRegistry.MARS_SMOOTH_STONE.get()));
//		lootTables.put(BlockRegistry.MARS_SMOOTH_STONE_SLAB.get(), createSimpleTable("mars_smooth_stone_slab", BlockRegistry.MARS_SMOOTH_STONE_SLAB.get()));

		lootTables.put(BlockRegistry.VENUS_DEEPSLATE_BRICKS.get(), createSimpleTable("venus_deepslate_bricks", BlockRegistry.VENUS_DEEPSLATE_BRICKS.get()));
		lootTables.put(BlockRegistry.VENUS_DEEPSLATE_BRICK_SLAB.get(), createSimpleTable("venus_deepslate_brick_slab", BlockRegistry.VENUS_DEEPSLATE_BRICK_SLAB.get()));
		lootTables.put(BlockRegistry.VENUS_DEEPSLATE_BRICK_STAIRS.get(), createSimpleTable("venus_deepslate_brick_stairs", BlockRegistry.VENUS_DEEPSLATE_BRICK_STAIRS.get()));
		lootTables.put(BlockRegistry.VENUS_DEEPSLATE_BRICK_WALL.get(), createSimpleTable("venus_deepslate_brick_wall", BlockRegistry.VENUS_DEEPSLATE_BRICK_WALL.get()));

		lootTables.put(BlockRegistry.CHISELED_VENUS_DEEPSLATE_BRICKS.get(), createSimpleTable("chiseled_venus_deepslate_bricks", BlockRegistry.CHISELED_VENUS_DEEPSLATE_BRICKS.get()));
//		lootTables.put(BlockRegistry.CRACKED_MARS_DEEPSLATE_BRICKS.get(), createSimpleTable("cracked_mars_deepslate_bricks", BlockRegistry.CRACKED_MARS_DEEPSLATE_BRICKS.get()));

		lootTables.put(BlockRegistry.VENUS_POLISHED_DEEPSLATE.get(), createSimpleTable("venus_polished_deepslate", BlockRegistry.VENUS_POLISHED_DEEPSLATE.get()));
		lootTables.put(BlockRegistry.VENUS_POLISHED_DEEPSLATE_SLAB.get(), createSimpleTable("venus_polished_deepslate_slab", BlockRegistry.VENUS_POLISHED_DEEPSLATE_SLAB.get()));
		lootTables.put(BlockRegistry.VENUS_POLISHED_DEEPSLATE_STAIRS.get(), createSimpleTable("venus_polished_deepslate_stairs", BlockRegistry.VENUS_POLISHED_DEEPSLATE_STAIRS.get()));
		lootTables.put(BlockRegistry.VENUS_POLISHED_DEEPSLATE_WALL.get(), createSimpleTable("venus_polished_deepslate_wall", BlockRegistry.VENUS_POLISHED_DEEPSLATE_WALL.get()));

		lootTables.put(BlockRegistry.VENUS_DEEPSLATE_TILES.get(), createSimpleTable("venus_deepslate_tiles", BlockRegistry.VENUS_DEEPSLATE_TILES.get()));
		lootTables.put(BlockRegistry.VENUS_DEEPSLATE_TILE_SLAB.get(), createSimpleTable("venus_deepslate_tile_slab", BlockRegistry.VENUS_DEEPSLATE_TILE_SLAB.get()));
		lootTables.put(BlockRegistry.VENUS_DEEPSLATE_TILE_STAIRS.get(), createSimpleTable("venus_deepslate_tile_stairs", BlockRegistry.VENUS_DEEPSLATE_TILE_STAIRS.get()));
		lootTables.put(BlockRegistry.VENUS_DEEPSLATE_TILE_WALL.get(), createSimpleTable("venus_deepslate_tile_wall", BlockRegistry.VENUS_DEEPSLATE_TILE_WALL.get()));

//		lootTables.put(BlockRegistry.CRACKED_MARS_DEEPSLATE_TILES.get(), createSimpleTable("cracked_mars_deepslate_tiles", BlockRegistry.CRACKED_MARS_DEEPSLATE_TILES.get()));

		lootTables.put(BlockRegistry.VENUS_STONE_BUTTON.get(), createSimpleTable("venus_stone_button", BlockRegistry.VENUS_STONE_BUTTON.get()));
		lootTables.put(BlockRegistry.VENUS_STONE_PRESSURE_PLATE.get(), createSimpleTable("venus_stone_pressure_plate", BlockRegistry.VENUS_STONE_PRESSURE_PLATE.get()));
		lootTables.put(BlockRegistry.VENUS_DEEPSLATE_BUTTON.get(), createSimpleTable("venus_deepslate_button", BlockRegistry.VENUS_DEEPSLATE_BUTTON.get()));
		lootTables.put(BlockRegistry.VENUS_DEEPSLATE_PRESSURE_PLATE.get(), createSimpleTable("venus_deepslate_pressure_plate", BlockRegistry.VENUS_DEEPSLATE_PRESSURE_PLATE.get()));

		lootTables.put(BlockRegistry.SULFURIC_OBSIDIAN.get(), createSimpleTable("sulfuric_obsidian", BlockRegistry.SULFURIC_OBSIDIAN.get()));



		/*
         * METEOR
         */
    	lootTables.put(BlockRegistry.METEOR.get(), createSimpleTable("meteor", BlockRegistry.METEOR.get()));
    	lootTables.put(BlockRegistry.METEOR_BRICK_SLAB.get(), createSimpleTable("meteor_brick_slab", BlockRegistry.METEOR_BRICK_SLAB.get()));
    	lootTables.put(BlockRegistry.METEOR_BRICK_STAIRS.get(), createSimpleTable("moon_brick_stairs", BlockRegistry.METEOR_BRICK_STAIRS.get()));
    	lootTables.put(BlockRegistry.METEOR_BRICK_WALL.get(), createSimpleTable("meteor_brick_wall", BlockRegistry.METEOR_BRICK_WALL.get()));
    	lootTables.put(BlockRegistry.METEOR_BRICKS.get(), createSimpleTable("meteor_bricks", BlockRegistry.METEOR_BRICKS.get()));
    	lootTables.put(BlockRegistry.METEOR_COAL_ORE.get(), createOreTable("meteor_coal_ore", BlockRegistry.METEOR_COAL_ORE.get(), Items.COAL));
    	lootTables.put(BlockRegistry.METEOR_COPPER_ORE.get(), createOreTable("meteor_copper_ore", BlockRegistry.METEOR_COPPER_ORE.get(), Items.RAW_COPPER));
    	lootTables.put(BlockRegistry.METEOR_DIAMOND_ORE.get(), createOreTable("meteor_diamond_ore", BlockRegistry.METEOR_DIAMOND_ORE.get(), Items.DIAMOND));
    	lootTables.put(BlockRegistry.METEOR_EMERALD_ORE.get(), createOreTable("meteor_emerald_ore", BlockRegistry.METEOR_EMERALD_ORE.get(), Items.EMERALD));
    	lootTables.put(BlockRegistry.METEOR_GOLD_ORE.get(), createOreTable("meteor_gold_ore", BlockRegistry.METEOR_GOLD_ORE.get(), Items.RAW_GOLD));
    	lootTables.put(BlockRegistry.METEOR_IRON_ORE.get(), createOreTable("meteor_iron_ore", BlockRegistry.METEOR_IRON_ORE.get(), Items.RAW_IRON));
    	lootTables.put(BlockRegistry.METEOR_LAPIS_ORE.get(), createOreTable("meteor_lapis_ore", BlockRegistry.METEOR_LAPIS_ORE.get(), Items.LAPIS_LAZULI));
		lootTables.put(BlockRegistry.METEOR_SULFUR_ORE.get(), createOreTable("meteor_sulfur_ore", BlockRegistry.METEOR_SULFUR_ORE.get(), ItemRegistry.SULFUR_CRYSTAL.get()));
    	lootTables.put(BlockRegistry.METEOR_REDSTONE_ORE.get(), createOreTable("meteor_redstone_ore", BlockRegistry.METEOR_REDSTONE_ORE.get(), Items.REDSTONE));

    	lootTables.put(BlockRegistry.CHISELED_METEOR_BRICKS.get(), createSimpleTable("chiseled_meteor_bricks", BlockRegistry.CHISELED_METEOR_BRICKS.get()));

		lootTables.put(BlockRegistry.METEOR_BUTTON.get(), createSimpleTable("meteor_button", BlockRegistry.METEOR_BUTTON.get()));
		lootTables.put(BlockRegistry.METEOR_PRESSURE_PLATE.get(), createSimpleTable("meteor_pressure_plate", BlockRegistry.METEOR_PRESSURE_PLATE.get()));


		lootTables.put(BlockRegistry.SOLAR_PLASMA.get(), createSimpleTable("solar_plasma", BlockRegistry.SOLAR_PLASMA.get()));
		lootTables.put(BlockRegistry.SUN_SPOT.get(), createSimpleTable("sun_spot", BlockRegistry.SUN_SPOT.get()));
		lootTables.put(BlockRegistry.SOLAR_FLARE.get(), createSimpleTable("solar_flare", BlockRegistry.SOLAR_FLARE.get()));
		lootTables.put(BlockRegistry.MERCURY_STONE.get(), createSimpleTable("mercury_stone", BlockRegistry.MERCURY_STONE.get()));
		lootTables.put(BlockRegistry.MERCURY_DEEPSLATE.get(), createSimpleTable("mercury_deepslate", BlockRegistry.MERCURY_DEEPSLATE.get()));
		lootTables.put(BlockRegistry.JUPITER_ATMOSPHERE.get(), createSimpleTable("jupiter_atmosphere", BlockRegistry.JUPITER_ATMOSPHERE.get()));
		lootTables.put(BlockRegistry.JUPITER_DEEPSLATE.get(), createSimpleTable("jupiter_deepslate", BlockRegistry.JUPITER_DEEPSLATE.get()));
		lootTables.put(BlockRegistry.IO_STONE.get(), createSimpleTable("io_stone", BlockRegistry.IO_STONE.get()));
		lootTables.put(BlockRegistry.IO_DEEPSLATE.get(), createSimpleTable("io_deepslate", BlockRegistry.IO_DEEPSLATE.get()));
		lootTables.put(BlockRegistry.EUROPA_HYDRATE.get(), createSimpleTable("europa_hydrate", BlockRegistry.EUROPA_HYDRATE.get()));
		lootTables.put(BlockRegistry.SATURN_ATMOSPHERE.get(), createSimpleTable("saturn_atmosphere", BlockRegistry.SATURN_ATMOSPHERE.get()));
		lootTables.put(BlockRegistry.SATURN_DEEPSLATE.get(), createSimpleTable("saturn_deepslate", BlockRegistry.SATURN_DEEPSLATE.get()));
		lootTables.put(BlockRegistry.URANUS_ATMOSPHERE.get(), createSimpleTable("uranus_atmosphere", BlockRegistry.URANUS_ATMOSPHERE.get()));
		lootTables.put(BlockRegistry.URANUS_DEEPSLATE.get(), createSimpleTable("uranus_deepslate", BlockRegistry.URANUS_DEEPSLATE.get()));
		lootTables.put(BlockRegistry.NEPTUNE_ATMOSPHERE.get(), createSimpleTable("neptune_atmosphere", BlockRegistry.NEPTUNE_ATMOSPHERE.get()));
		lootTables.put(BlockRegistry.NEPTUNE_DEEPSLATE.get(), createSimpleTable("neptune_deepslate", BlockRegistry.NEPTUNE_DEEPSLATE.get()));
		/*
		 * OTHER
		 */
//    	lootTables.put(BlockRegistry.SOLAR_PANEL.get(), createSimpleTable("solar_panel", BlockRegistry.SOLAR_PANEL.get()));
		lootTables.put(BlockRegistry.LUNAR_LANTERN.get(), createSilkTouchTable("lunar_lantern", BlockRegistry.LUNAR_LANTERN.get(), ItemRegistry.MOON_DUST.get(), 1, 3));
		lootTables.put(BlockRegistry.MARS_LANTERN.get(), createSilkTouchTable("mars_lantern", BlockRegistry.MARS_LANTERN.get(), ItemRegistry.RUSTED_IRON_NUGGET.get(), 1, 3));
		lootTables.put(BlockRegistry.VENUS_LANTERN.get(), createSilkTouchTable("venus_lantern", BlockRegistry.VENUS_LANTERN.get(), ItemRegistry.SULFUR_CRYSTAL.get(), 1, 3));

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

		lootTables.put(BlockRegistry.WORKBENCH.get(), createSimpleTable("workbench", BlockRegistry.WORKBENCH.get()));
		lootTables.put(BlockRegistry.SILICA.get(), createSimpleTable("silica", BlockRegistry.SILICA.get()));

		lootTables.put(BlockRegistry.CERAMIC.get(), createSilkTouchTable("ceramic", BlockRegistry.CERAMIC.get(), BlockRegistry.SILICA.get(), 1, 1));
		lootTables.put(BlockRegistry.CERAMIC_TILE.get(), createSilkTouchTable("ceramic_tile", BlockRegistry.CERAMIC_TILE.get(), BlockRegistry.SILICA.get(), 1, 1));

		lootTables.put(BlockRegistry.WHITE_CERAMIC.get(), createSilkTouchTable("white_ceramic", BlockRegistry.WHITE_CERAMIC.get(), BlockRegistry.SILICA.get(), 1, 1));
		lootTables.put(BlockRegistry.WHITE_CERAMIC_TILE.get(), createSilkTouchTable("white_ceramic_tile", BlockRegistry.WHITE_CERAMIC_TILE.get(), BlockRegistry.SILICA.get(), 1, 1));
		lootTables.put(BlockRegistry.LIGHT_GREY_CERAMIC.get(), createSilkTouchTable("light_grey_ceramic", BlockRegistry.LIGHT_GREY_CERAMIC.get(), BlockRegistry.SILICA.get(), 1, 1));
		lootTables.put(BlockRegistry.LIGHT_GREY_CERAMIC_TILE.get(), createSilkTouchTable("light_grey_ceramic_tile", BlockRegistry.LIGHT_GREY_CERAMIC_TILE.get(), BlockRegistry.SILICA.get(), 1, 1));
		lootTables.put(BlockRegistry.GREY_CERAMIC.get(), createSilkTouchTable("grey_ceramic", BlockRegistry.GREY_CERAMIC.get(), BlockRegistry.SILICA.get(), 1, 1));
		lootTables.put(BlockRegistry.GREY_CERAMIC_TILE.get(), createSilkTouchTable("grey_ceramic_tile", BlockRegistry.GREY_CERAMIC_TILE.get(), BlockRegistry.SILICA.get(), 1, 1));
		lootTables.put(BlockRegistry.BLACK_CERAMIC.get(), createSilkTouchTable("black_ceramic", BlockRegistry.BLACK_CERAMIC.get(), BlockRegistry.SILICA.get(), 1, 1));
		lootTables.put(BlockRegistry.BLACK_CERAMIC_TILE.get(), createSilkTouchTable("black_ceramic_tile", BlockRegistry.BLACK_CERAMIC_TILE.get(), BlockRegistry.SILICA.get(), 1, 1));
		lootTables.put(BlockRegistry.PURPLE_CERAMIC.get(), createSilkTouchTable("purple_ceramic", BlockRegistry.PURPLE_CERAMIC.get(), BlockRegistry.SILICA.get(), 1, 1));
		lootTables.put(BlockRegistry.PURPLE_CERAMIC_TILE.get(), createSilkTouchTable("purple_ceramic_tile", BlockRegistry.PURPLE_CERAMIC_TILE.get(), BlockRegistry.SILICA.get(), 1, 1));
		lootTables.put(BlockRegistry.MAGENTA_CERAMIC.get(), createSilkTouchTable("magenta_ceramic", BlockRegistry.MAGENTA_CERAMIC.get(), BlockRegistry.SILICA.get(), 1, 1));
		lootTables.put(BlockRegistry.MAGENTA_CERAMIC_TILE.get(), createSilkTouchTable("magenta_ceramic_tile", BlockRegistry.MAGENTA_CERAMIC_TILE.get(), BlockRegistry.SILICA.get(), 1, 1));
		lootTables.put(BlockRegistry.BLUE_CERAMIC.get(), createSilkTouchTable("blue_ceramic", BlockRegistry.BLUE_CERAMIC.get(), BlockRegistry.SILICA.get(), 1, 1));
		lootTables.put(BlockRegistry.BLUE_CERAMIC_TILE.get(), createSilkTouchTable("blue_ceramic_tile", BlockRegistry.BLUE_CERAMIC_TILE.get(), BlockRegistry.SILICA.get(), 1, 1));
		lootTables.put(BlockRegistry.LIGHT_BLUE_CERAMIC.get(), createSilkTouchTable("light_blue_ceramic", BlockRegistry.LIGHT_BLUE_CERAMIC.get(), BlockRegistry.SILICA.get(), 1, 1));
		lootTables.put(BlockRegistry.LIGHT_BLUE_CERAMIC_TILE.get(), createSilkTouchTable("light_blue_ceramic_tile", BlockRegistry.LIGHT_BLUE_CERAMIC_TILE.get(), BlockRegistry.SILICA.get(), 1, 1));
		lootTables.put(BlockRegistry.CYAN_CERAMIC.get(), createSilkTouchTable("cyan_ceramic", BlockRegistry.CYAN_CERAMIC.get(), BlockRegistry.SILICA.get(), 1, 1));
		lootTables.put(BlockRegistry.CYAN_CERAMIC_TILE.get(), createSilkTouchTable("cyan_ceramic_tile", BlockRegistry.CYAN_CERAMIC_TILE.get(), BlockRegistry.SILICA.get(), 1, 1));
		lootTables.put(BlockRegistry.GREEN_CERAMIC.get(), createSilkTouchTable("green_ceramic", BlockRegistry.GREEN_CERAMIC.get(), BlockRegistry.SILICA.get(), 1, 1));
		lootTables.put(BlockRegistry.GREEN_CERAMIC_TILE.get(), createSilkTouchTable("green_ceramic_tile", BlockRegistry.GREEN_CERAMIC_TILE.get(), BlockRegistry.SILICA.get(), 1, 1));
		lootTables.put(BlockRegistry.LIME_CERAMIC.get(), createSilkTouchTable("lime_ceramic", BlockRegistry.LIME_CERAMIC.get(), BlockRegistry.SILICA.get(), 1, 1));
		lootTables.put(BlockRegistry.LIME_CERAMIC_TILE.get(), createSilkTouchTable("lime_ceramic_tile", BlockRegistry.LIME_CERAMIC_TILE.get(), BlockRegistry.SILICA.get(), 1, 1));
		lootTables.put(BlockRegistry.YELLOW_CERAMIC.get(), createSilkTouchTable("yellow_ceramic", BlockRegistry.YELLOW_CERAMIC.get(), BlockRegistry.SILICA.get(), 1, 1));
		lootTables.put(BlockRegistry.YELLOW_CERAMIC_TILE.get(), createSilkTouchTable("yellow_ceramic_tile", BlockRegistry.YELLOW_CERAMIC_TILE.get(), BlockRegistry.SILICA.get(), 1, 1));
		lootTables.put(BlockRegistry.ORANGE_CERAMIC.get(), createSilkTouchTable("orange_ceramic", BlockRegistry.ORANGE_CERAMIC.get(), BlockRegistry.SILICA.get(), 1, 1));
		lootTables.put(BlockRegistry.ORANGE_CERAMIC_TILE.get(), createSilkTouchTable("orange_ceramic_tile", BlockRegistry.ORANGE_CERAMIC_TILE.get(), BlockRegistry.SILICA.get(), 1, 1));
		lootTables.put(BlockRegistry.BROWN_CERAMIC.get(), createSilkTouchTable("brown_ceramic", BlockRegistry.BROWN_CERAMIC.get(), BlockRegistry.SILICA.get(), 1, 1));
		lootTables.put(BlockRegistry.BROWN_CERAMIC_TILE.get(), createSilkTouchTable("brown_ceramic_tile", BlockRegistry.BROWN_CERAMIC_TILE.get(), BlockRegistry.SILICA.get(), 1, 1));
		lootTables.put(BlockRegistry.RED_CERAMIC.get(), createSilkTouchTable("red_ceramic", BlockRegistry.RED_CERAMIC.get(), BlockRegistry.SILICA.get(), 1, 1));
		lootTables.put(BlockRegistry.RED_CERAMIC_TILE.get(), createSilkTouchTable("red_ceramic_tile", BlockRegistry.RED_CERAMIC_TILE.get(), BlockRegistry.SILICA.get(), 1, 1));
		lootTables.put(BlockRegistry.PINK_CERAMIC.get(), createSilkTouchTable("pink_ceramic", BlockRegistry.PINK_CERAMIC.get(), BlockRegistry.SILICA.get(), 1, 1));
		lootTables.put(BlockRegistry.PINK_CERAMIC_TILE.get(), createSilkTouchTable("pink_ceramic_tile", BlockRegistry.PINK_CERAMIC_TILE.get(), BlockRegistry.SILICA.get(), 1, 1));


		lootTables.put(BlockRegistry.PAINTED_WHITE_CERAMIC.get(), createSilkTouchTable("painted_white_ceramic", BlockRegistry.PAINTED_WHITE_CERAMIC.get(), BlockRegistry.SILICA.get(), 1, 1));
		lootTables.put(BlockRegistry.PAINTED_LIGHT_GREY_CERAMIC.get(), createSilkTouchTable("painted_light_grey_ceramic", BlockRegistry.PAINTED_LIGHT_GREY_CERAMIC.get(), BlockRegistry.SILICA.get(), 1, 1));
		lootTables.put(BlockRegistry.PAINTED_GREY_CERAMIC.get(), createSilkTouchTable("painted_grey_ceramic", BlockRegistry.PAINTED_GREY_CERAMIC.get(), BlockRegistry.SILICA.get(), 1, 1));
		lootTables.put(BlockRegistry.PAINTED_BLACK_CERAMIC.get(), createSilkTouchTable("painted_black_ceramic", BlockRegistry.PAINTED_BLACK_CERAMIC.get(), BlockRegistry.SILICA.get(), 1, 1));
		lootTables.put(BlockRegistry.PAINTED_PURPLE_CERAMIC.get(), createSilkTouchTable("painted_purple_ceramic", BlockRegistry.PAINTED_PURPLE_CERAMIC.get(), BlockRegistry.SILICA.get(), 1, 1));
		lootTables.put(BlockRegistry.PAINTED_MAGENTA_CERAMIC.get(), createSilkTouchTable("painted_magenta_ceramic", BlockRegistry.PAINTED_MAGENTA_CERAMIC.get(), BlockRegistry.SILICA.get(), 1, 1));
		lootTables.put(BlockRegistry.PAINTED_BLUE_CERAMIC.get(), createSilkTouchTable("painted_blue_ceramic", BlockRegistry.PAINTED_BLUE_CERAMIC.get(), BlockRegistry.SILICA.get(), 1, 1));
		lootTables.put(BlockRegistry.PAINTED_LIGHT_BLUE_CERAMIC.get(), createSilkTouchTable("painted_light_blue_ceramic", BlockRegistry.PAINTED_LIGHT_BLUE_CERAMIC.get(), BlockRegistry.SILICA.get(), 1, 1));
		lootTables.put(BlockRegistry.PAINTED_CYAN_CERAMIC.get(), createSilkTouchTable("painted_cyan_ceramic", BlockRegistry.PAINTED_CYAN_CERAMIC.get(), BlockRegistry.SILICA.get(), 1, 1));
		lootTables.put(BlockRegistry.PAINTED_GREEN_CERAMIC.get(), createSilkTouchTable("painted_green_ceramic", BlockRegistry.PAINTED_GREEN_CERAMIC.get(), BlockRegistry.SILICA.get(), 1, 1));
		lootTables.put(BlockRegistry.PAINTED_LIME_CERAMIC.get(), createSilkTouchTable("painted_lime_ceramic", BlockRegistry.PAINTED_LIME_CERAMIC.get(), BlockRegistry.SILICA.get(), 1, 1));
		lootTables.put(BlockRegistry.PAINTED_YELLOW_CERAMIC.get(), createSilkTouchTable("painted_yellow_ceramic", BlockRegistry.PAINTED_YELLOW_CERAMIC.get(), BlockRegistry.SILICA.get(), 1, 1));
		lootTables.put(BlockRegistry.PAINTED_ORANGE_CERAMIC.get(), createSilkTouchTable("painted_orange_ceramic", BlockRegistry.PAINTED_ORANGE_CERAMIC.get(), BlockRegistry.SILICA.get(), 1, 1));
		lootTables.put(BlockRegistry.PAINTED_BROWN_CERAMIC.get(), createSilkTouchTable("painted_brown_ceramic", BlockRegistry.PAINTED_BROWN_CERAMIC.get(), BlockRegistry.SILICA.get(), 1, 1));
		lootTables.put(BlockRegistry.PAINTED_RED_CERAMIC.get(), createSilkTouchTable("painted_red_ceramic", BlockRegistry.PAINTED_RED_CERAMIC.get(), BlockRegistry.SILICA.get(), 1, 1));
		lootTables.put(BlockRegistry.PAINTED_PINK_CERAMIC.get(), createSilkTouchTable("painted_pink_ceramic", BlockRegistry.PAINTED_PINK_CERAMIC.get(), BlockRegistry.SILICA.get(), 1, 1));


		/*
		 * SPACESHIP-RELATED
		 */
//		lootTables.put(BlockRegistry.ASSEMBLY_STATION.get(), createSimpleTable("assembly_station", BlockRegistry.ASSEMBLY_STATION.get()));
		lootTables.put(BlockRegistry.OXYGEN_COMPRESSOR.get(), createSimpleTable("oxygen_compressor", BlockRegistry.OXYGEN_COMPRESSOR.get()));
		lootTables.put(BlockRegistry.STEEL_FRAME.get(), createSimpleTable("steel_frame", BlockRegistry.STEEL_FRAME.get()));

		/* MAG RAILS */
		lootTables.put(BlockRegistry.MAG_RAIL.get(), createSimpleTable("mag_rail", BlockRegistry.MAG_RAIL.get()));
		lootTables.put(BlockRegistry.POWERED_MAG_RAIL.get(), createSimpleTable("powered_mag_rail", BlockRegistry.POWERED_MAG_RAIL.get()));
		lootTables.put(BlockRegistry.DETECTOR_MAG_RAIL.get(), createSimpleTable("detector_mag_rail", BlockRegistry.DETECTOR_MAG_RAIL.get()));
		lootTables.put(BlockRegistry.ACTIVATOR_MAG_RAIL.get(), createSimpleTable("activator_mag_rail", BlockRegistry.ACTIVATOR_MAG_RAIL.get()));

	}
}