package com.shim.celestialexploration.datagen;

import com.shim.celestialexploration.datagen.util.BaseLootTableProvider;
import com.shim.celestialexploration.registry.BlockRegistry;

import com.shim.celestialexploration.registry.ItemRegistry;
import net.minecraft.data.DataGenerator;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

public class LootTables extends BaseLootTableProvider {

    public LootTables(DataGenerator dataGeneratorIn) {
        super(dataGeneratorIn);
    }


    @Override
    protected void addTables() {

		for (RegistryObject<? extends Block> block : BlockRegistry.BLOCKS_LOOT_TABLE) lootTables.put(block.get(), createSimpleTable(block.get()));

		//---- MOON -------------------------------------------------------------------------------
		//STONE
		lootTables.put(BlockRegistry.MOON_STONE.get(), createSilkTouchTable(BlockRegistry.MOON_STONE.get(), BlockRegistry.MOON_COBBLESTONE.get(), 1, 1));

		lootTables.put(BlockRegistry.MOON_STONE_SLAB.get(), createSlabItemTable(BlockRegistry.MOON_STONE_SLAB.get()));
		lootTables.put(BlockRegistry.MOON_COBBLESTONE_SLAB.get(), createSlabItemTable(BlockRegistry.MOON_COBBLESTONE_SLAB.get()));
		lootTables.put(BlockRegistry.MOON_BRICK_SLAB.get(), createSlabItemTable(BlockRegistry.MOON_BRICK_SLAB.get()));
		lootTables.put(BlockRegistry.MOON_SMOOTH_STONE_SLAB.get(), createSlabItemTable(BlockRegistry.MOON_SMOOTH_STONE_SLAB.get()));

		//DEEPSLATE
		lootTables.put(BlockRegistry.MOON_DEEPSLATE.get(), createSilkTouchTable(BlockRegistry.MOON_DEEPSLATE.get(), BlockRegistry.MOON_COBBLED_DEEPSLATE.get(), 1, 1));

		lootTables.put(BlockRegistry.MOON_COBBLED_DEEPSLATE_SLAB.get(), createSlabItemTable(BlockRegistry.MOON_COBBLED_DEEPSLATE_SLAB.get()));
		lootTables.put(BlockRegistry.MOON_DEEPSLATE_BRICK_SLAB.get(), createSlabItemTable(BlockRegistry.MOON_DEEPSLATE_BRICK_SLAB.get()));
		lootTables.put(BlockRegistry.MOON_POLISHED_DEEPSLATE_SLAB.get(), createSlabItemTable(BlockRegistry.MOON_POLISHED_DEEPSLATE_SLAB.get()));
		lootTables.put(BlockRegistry.MOON_DEEPSLATE_TILE_SLAB.get(), createSlabItemTable(BlockRegistry.MOON_DEEPSLATE_TILE_SLAB.get()));

		//ORES
		lootTables.put(BlockRegistry.MOON_IRON_ORE.get(), createIronOreTable(BlockRegistry.MOON_IRON_ORE.get()));
		lootTables.put(BlockRegistry.MOON_REDSTONE_ORE.get(), createRedstoneOreTable(BlockRegistry.MOON_REDSTONE_ORE.get()));
		lootTables.put(BlockRegistry.MOON_BAUXITE_ORE.get(), createBauxiteOreTable(BlockRegistry.MOON_BAUXITE_ORE.get()));
		lootTables.put(BlockRegistry.MOON_DEEPSLATE_IRON_ORE.get(), createIronOreTable(BlockRegistry.MOON_DEEPSLATE_IRON_ORE.get()));
		lootTables.put(BlockRegistry.MOON_DEEPSLATE_REDSTONE_ORE.get(), createRedstoneOreTable(BlockRegistry.MOON_DEEPSLATE_REDSTONE_ORE.get()));

		lootTables.put(BlockRegistry.CHISELED_MOON_DEEPSLATE_BRICKS.get(), createSimpleTable(BlockRegistry.CHISELED_MOON_DEEPSLATE_BRICKS.get()));
		lootTables.put(BlockRegistry.CRACKED_MOON_DEEPSLATE_BRICKS.get(), createSimpleTable(BlockRegistry.CRACKED_MOON_DEEPSLATE_BRICKS.get()));

		//OTHER
    	lootTables.put(BlockRegistry.GLOWING_MOON_SAND.get(), createSilkTouchTable(BlockRegistry.GLOWING_MOON_SAND.get(), ItemRegistry.MOON_DUST.get(), 2, 5));
		lootTables.put(BlockRegistry.LUNAR_LANTERN.get(), createSilkTouchTable(BlockRegistry.LUNAR_LANTERN.get(), ItemRegistry.MOON_DUST.get(), 1, 3));

		//---- MARS -------------------------------------------------------------------------------
		//STONE
		lootTables.put(BlockRegistry.MARS_STONE_SLAB.get(), createSlabItemTable(BlockRegistry.MARS_STONE_SLAB.get()));
		lootTables.put(BlockRegistry.MARS_COBBLESTONE_SLAB.get(), createSlabItemTable(BlockRegistry.MARS_COBBLESTONE_SLAB.get()));
		lootTables.put(BlockRegistry.MARS_BRICK_SLAB.get(), createSlabItemTable(BlockRegistry.MARS_BRICK_SLAB.get()));
		lootTables.put(BlockRegistry.MARS_SMOOTH_STONE_SLAB.get(), createSlabItemTable(BlockRegistry.MARS_SMOOTH_STONE_SLAB.get()));

		//DEEPSLATE
		lootTables.put(BlockRegistry.MARS_DEEPSLATE.get(), createSilkTouchTable(BlockRegistry.MARS_DEEPSLATE.get(), BlockRegistry.MARS_COBBLED_DEEPSLATE.get(), 1, 1));

		lootTables.put(BlockRegistry.MARS_COBBLED_DEEPSLATE_SLAB.get(), createSlabItemTable(BlockRegistry.MARS_COBBLED_DEEPSLATE_SLAB.get()));
		lootTables.put(BlockRegistry.MARS_DEEPSLATE_BRICK_SLAB.get(), createSlabItemTable(BlockRegistry.MARS_DEEPSLATE_BRICK_SLAB.get()));
		lootTables.put(BlockRegistry.MARS_POLISHED_DEEPSLATE_SLAB.get(), createSlabItemTable(BlockRegistry.MARS_POLISHED_DEEPSLATE_SLAB.get()));
		lootTables.put(BlockRegistry.MARS_DEEPSLATE_TILE_SLAB.get(), createSlabItemTable(BlockRegistry.MARS_DEEPSLATE_TILE_SLAB.get()));

		//ORES
		lootTables.put(BlockRegistry.MARS_IRON_ORE.get(), createIronOreTable(BlockRegistry.MARS_IRON_ORE.get()));
		lootTables.put(BlockRegistry.MARS_REDSTONE_ORE.get(), createRedstoneOreTable(BlockRegistry.MARS_REDSTONE_ORE.get()));
		lootTables.put(BlockRegistry.MARS_BAUXITE_ORE.get(), createBauxiteOreTable(BlockRegistry.MARS_BAUXITE_ORE.get()));
		lootTables.put(BlockRegistry.MARS_DEEPSLATE_IRON_ORE.get(), createIronOreTable(BlockRegistry.MARS_DEEPSLATE_IRON_ORE.get()));
		lootTables.put(BlockRegistry.MARS_DEEPSLATE_REDSTONE_ORE.get(), createIronOreTable(BlockRegistry.MARS_DEEPSLATE_REDSTONE_ORE.get()));

		//OTHER
		lootTables.put(BlockRegistry.MARS_LANTERN.get(), createSilkTouchTable(BlockRegistry.MARS_LANTERN.get(), ItemRegistry.RUSTED_IRON_NUGGET.get(), 1, 3));

		//---- VENUS -------------------------------------------------------------------------------
		//STONE
		lootTables.put(BlockRegistry.VENUS_STONE_SLAB.get(), createSlabItemTable(BlockRegistry.VENUS_STONE_SLAB.get()));
		lootTables.put(BlockRegistry.VENUS_COBBLESTONE_SLAB.get(), createSlabItemTable(BlockRegistry.VENUS_COBBLESTONE_SLAB.get()));
		lootTables.put(BlockRegistry.VENUS_BRICK_SLAB.get(), createSlabItemTable(BlockRegistry.VENUS_BRICK_SLAB.get()));
		lootTables.put(BlockRegistry.SMALL_VENUS_BRICK_SLAB.get(), createSlabItemTable(BlockRegistry.SMALL_VENUS_BRICK_SLAB.get()));
		lootTables.put(BlockRegistry.VENUS_SMOOTH_STONE_SLAB.get(), createSlabItemTable(BlockRegistry.VENUS_SMOOTH_STONE_SLAB.get()));

		//DEEPSLATE
		lootTables.put(BlockRegistry.VENUS_DEEPSLATE.get(), createSilkTouchTable(BlockRegistry.VENUS_DEEPSLATE.get(), BlockRegistry.VENUS_COBBLED_DEEPSLATE.get(), 1, 1));

		lootTables.put(BlockRegistry.VENUS_COBBLED_DEEPSLATE_SLAB.get(), createSlabItemTable(BlockRegistry.VENUS_COBBLED_DEEPSLATE_SLAB.get()));
		lootTables.put(BlockRegistry.VENUS_DEEPSLATE_BRICK_SLAB.get(), createSlabItemTable(BlockRegistry.VENUS_DEEPSLATE_BRICK_SLAB.get()));
		lootTables.put(BlockRegistry.VENUS_POLISHED_DEEPSLATE_SLAB.get(), createSlabItemTable(BlockRegistry.VENUS_POLISHED_DEEPSLATE_SLAB.get()));
		lootTables.put(BlockRegistry.VENUS_DEEPSLATE_TILE_SLAB.get(), createSlabItemTable(BlockRegistry.VENUS_DEEPSLATE_TILE_SLAB.get()));

		//ORES
		lootTables.put(BlockRegistry.VENUS_IRON_ORE.get(), createIronOreTable(BlockRegistry.VENUS_IRON_ORE.get()));
		lootTables.put(BlockRegistry.VENUS_REDSTONE_ORE.get(), createRedstoneOreTable(BlockRegistry.VENUS_REDSTONE_ORE.get()));
		lootTables.put(BlockRegistry.VENUS_BAUXITE_ORE.get(), createBauxiteOreTable(BlockRegistry.VENUS_BAUXITE_ORE.get()));
		lootTables.put(BlockRegistry.VENUS_LAPIS_ORE.get(), createOreTable(BlockRegistry.VENUS_LAPIS_ORE.get(), Items.LAPIS_LAZULI));

		lootTables.put(BlockRegistry.VENUS_DEEPSLATE_IRON_ORE.get(), createIronOreTable(BlockRegistry.VENUS_DEEPSLATE_IRON_ORE.get()));
		lootTables.put(BlockRegistry.VENUS_DEEPSLATE_REDSTONE_ORE.get(), createRedstoneOreTable(BlockRegistry.VENUS_DEEPSLATE_REDSTONE_ORE.get()));
		lootTables.put(BlockRegistry.VENUS_DEEPSLATE_LAPIS_ORE.get(), createOreTable(BlockRegistry.VENUS_DEEPSLATE_LAPIS_ORE.get(), Items.LAPIS_LAZULI));
		
		//OTHER
		lootTables.put(BlockRegistry.VENUS_LANTERN.get(), createSilkTouchTable(BlockRegistry.VENUS_LANTERN.get(), ItemRegistry.SULFUR_CRYSTAL.get(), 1, 3));

		//---- CELESTIAL OBJECTS -------------------------------------------------------------------------------
		//METEOR
    	lootTables.put(BlockRegistry.METEOR_BRICK_SLAB.get(), createSlabItemTable(BlockRegistry.METEOR_BRICK_SLAB.get()));

		//METEOR ORE
		lootTables.put(BlockRegistry.METEOR_COAL_ORE.get(), createCoalOreTable(BlockRegistry.METEOR_COAL_ORE.get()));
		lootTables.put(BlockRegistry.METEOR_COPPER_ORE.get(), createCopperOreTable(BlockRegistry.METEOR_COPPER_ORE.get()));
		lootTables.put(BlockRegistry.METEOR_DIAMOND_ORE.get(), createOreTable(BlockRegistry.METEOR_DIAMOND_ORE.get(), Items.DIAMOND));
		lootTables.put(BlockRegistry.METEOR_EMERALD_ORE.get(), createOreTable(BlockRegistry.METEOR_EMERALD_ORE.get(), Items.EMERALD));
		lootTables.put(BlockRegistry.METEOR_GOLD_ORE.get(), createOreTable(BlockRegistry.METEOR_GOLD_ORE.get(), Items.RAW_GOLD));
		lootTables.put(BlockRegistry.METEOR_IRON_ORE.get(), createIronOreTable(BlockRegistry.METEOR_IRON_ORE.get()));
		lootTables.put(BlockRegistry.METEOR_LAPIS_ORE.get(), createOreTable(BlockRegistry.METEOR_LAPIS_ORE.get(), Items.LAPIS_LAZULI));
		lootTables.put(BlockRegistry.METEOR_SULFUR_ORE.get(), createSulfurOreTable(BlockRegistry.METEOR_SULFUR_ORE.get()));
		lootTables.put(BlockRegistry.METEOR_REDSTONE_ORE.get(), createRedstoneOreTable(BlockRegistry.METEOR_REDSTONE_ORE.get()));
		lootTables.put(BlockRegistry.METEOR_BAUXITE_ORE.get(), createBauxiteOreTable(BlockRegistry.METEOR_BAUXITE_ORE.get()));

		//SUN
		lootTables.put(BlockRegistry.SOLAR_PLASMA.get(), createSimpleTable(BlockRegistry.SOLAR_PLASMA.get()));
		lootTables.put(BlockRegistry.SUN_SPOT.get(), createSimpleTable(BlockRegistry.SUN_SPOT.get()));
		lootTables.put(BlockRegistry.SOLAR_FLARE.get(), createSimpleTable(BlockRegistry.SOLAR_FLARE.get()));

		//---- MERCURY -------------------------------------------------------------------------------
		//STONE
		lootTables.put(BlockRegistry.MERCURY_STONE.get(), createSilkTouchTable(BlockRegistry.MERCURY_STONE.get(), BlockRegistry.MERCURY_COBBLESTONE.get(), 1, 1));

		lootTables.put(BlockRegistry.MERCURY_STONE_SLAB.get(), createSlabItemTable(BlockRegistry.MERCURY_STONE_SLAB.get()));
		lootTables.put(BlockRegistry.MERCURY_COBBLESTONE_SLAB.get(), createSlabItemTable(BlockRegistry.MERCURY_COBBLESTONE_SLAB.get()));
		lootTables.put(BlockRegistry.MERCURY_BRICK_SLAB.get(), createSlabItemTable(BlockRegistry.MERCURY_BRICK_SLAB.get()));
		lootTables.put(BlockRegistry.MERCURY_SMOOTH_STONE_SLAB.get(), createSlabItemTable(BlockRegistry.MERCURY_SMOOTH_STONE_SLAB.get()));

		//DEEPSLATE
		lootTables.put(BlockRegistry.MERCURY_DEEPSLATE.get(), createSilkTouchTable(BlockRegistry.MERCURY_DEEPSLATE.get(), BlockRegistry.MERCURY_COBBLED_DEEPSLATE.get(), 1, 1));
		lootTables.put(BlockRegistry.MERCURY_COBBLED_DEEPSLATE_SLAB.get(), createSlabItemTable(BlockRegistry.MERCURY_COBBLED_DEEPSLATE_SLAB.get()));
		lootTables.put(BlockRegistry.MERCURY_DEEPSLATE_BRICK_SLAB.get(), createSlabItemTable(BlockRegistry.MERCURY_DEEPSLATE_BRICK_SLAB.get()));
		lootTables.put(BlockRegistry.MERCURY_POLISHED_DEEPSLATE_SLAB.get(), createSlabItemTable(BlockRegistry.MERCURY_POLISHED_DEEPSLATE_SLAB.get()));
		lootTables.put(BlockRegistry.MERCURY_DEEPSLATE_TILE_SLAB.get(), createSlabItemTable(BlockRegistry.MERCURY_DEEPSLATE_TILE_SLAB.get()));

		//ORES
		lootTables.put(BlockRegistry.MERCURY_BAUXITE_ORE.get(), createBauxiteOreTable(BlockRegistry.MERCURY_BAUXITE_ORE.get()));
		lootTables.put(BlockRegistry.MERCURY_SULFUR_ORE.get(), createSulfurOreTable(BlockRegistry.MERCURY_SULFUR_ORE.get()));
		lootTables.put(BlockRegistry.MERCURY_COAL_ORE.get(), createCoalOreTable(BlockRegistry.MERCURY_COAL_ORE.get()));
		lootTables.put(BlockRegistry.MERCURY_DIAMOND_ORE.get(), createOreTable(BlockRegistry.MERCURY_DIAMOND_ORE.get(), Items.DIAMOND));
		lootTables.put(BlockRegistry.MERCURY_DEEPSLATE_DIAMOND_ORE.get(), createOreTable(BlockRegistry.MERCURY_DIAMOND_ORE.get(), Items.DIAMOND));
		lootTables.put(BlockRegistry.MERCURY_DEEPSLATE_IRON_ORE.get(), createIronOreTable(BlockRegistry.MERCURY_DEEPSLATE_IRON_ORE.get()));
		lootTables.put(BlockRegistry.MERCURY_DEEPSLATE_COAL_ORE.get(), createCoalOreTable(BlockRegistry.MERCURY_DEEPSLATE_COAL_ORE.get()));
		lootTables.put(BlockRegistry.MERCURY_DEEPSLATE_REDSTONE_ORE.get(), createRedstoneOreTable(BlockRegistry.MERCURY_DEEPSLATE_REDSTONE_ORE.get()));

		//OTHER
		lootTables.put(BlockRegistry.MERCURY_LANTERN.get(), createSilkTouchTable(BlockRegistry.MERCURY_LANTERN.get(), BlockRegistry.MERCURY_STONE.get(), 1, 1)); //FIXME
		lootTables.put(BlockRegistry.MERCURY_SAND_PATH.get(), createSimpleTable(BlockRegistry.MERCURY_SAND.get()));

		//---- JUPITER -------------------------------------------------------------------------------
		//DEEPSLATE
		lootTables.put(BlockRegistry.JUPITER_DEEPSLATE.get(), createSilkTouchTable(BlockRegistry.JUPITER_DEEPSLATE.get(), BlockRegistry.JUPITER_COBBLED_DEEPSLATE.get(), 1, 1));

		lootTables.put(BlockRegistry.JUPITER_COBBLED_DEEPSLATE_SLAB.get(), createSlabItemTable(BlockRegistry.JUPITER_COBBLED_DEEPSLATE_SLAB.get()));
		lootTables.put(BlockRegistry.JUPITER_DEEPSLATE_BRICK_SLAB.get(), createSlabItemTable(BlockRegistry.JUPITER_DEEPSLATE_BRICK_SLAB.get()));
		lootTables.put(BlockRegistry.JUPITER_POLISHED_DEEPSLATE_SLAB.get(), createSlabItemTable(BlockRegistry.JUPITER_POLISHED_DEEPSLATE_SLAB.get()));
		lootTables.put(BlockRegistry.JUPITER_DEEPSLATE_TILE_SLAB.get(), createSlabItemTable(BlockRegistry.JUPITER_DEEPSLATE_TILE_SLAB.get()));

		lootTables.put(BlockRegistry.CHISELED_JUPITER_DEEPSLATE_BRICKS.get(), createSimpleTable(BlockRegistry.CHISELED_JUPITER_DEEPSLATE_BRICKS.get()));
		lootTables.put(BlockRegistry.CRACKED_JUPITER_DEEPSLATE_BRICKS.get(), createSimpleTable(BlockRegistry.CRACKED_JUPITER_DEEPSLATE_BRICKS.get()));

		//OTHER
		lootTables.put(BlockRegistry.JUPITER_LANTERN.get(), createSilkTouchTable(BlockRegistry.JUPITER_LANTERN.get(), BlockRegistry.JUPITER_DEEPSLATE.get(), 1, 3)); //FIXME?
		lootTables.put(BlockRegistry.JUPITER_ATMOSPHERE.get(), createSimpleTable(BlockRegistry.JUPITER_ATMOSPHERE.get()));


		//---- EUROPA -------------------------------------------------------------------------------
		lootTables.put(BlockRegistry.EUROPA_BRICK_SLAB.get(), createSlabItemTable(BlockRegistry.EUROPA_BRICK_SLAB.get()));
		lootTables.put(BlockRegistry.GLOWING_EUROPA_SAND.get(), createSilkTouchTable(BlockRegistry.GLOWING_EUROPA_SAND.get(), ItemRegistry.EUROPA_DUST.get(), 2, 5));
		lootTables.put(BlockRegistry.EUROPA_LANTERN.get(), createSilkTouchTable(BlockRegistry.EUROPA_LANTERN.get(), ItemRegistry.EUROPA_DUST.get(), 1, 3));


		//---- ORES/ALLOYS -------------------------------------------------------------------------------
		lootTables.put(BlockRegistry.BAUXITE_ORE.get(), createBauxiteOreTable(BlockRegistry.BAUXITE_ORE.get()));

		//---- SPACESHIP-RELATED -------------------------------------------------------------------------------
		lootTables.put(BlockRegistry.STEEL_FRAME.get(), createSimpleTable(BlockRegistry.STEEL_FRAME.get()));

		//---- GLASS/CERAMICS -------------------------------------------------------------------------------
		//GLASS
		lootTables.put(BlockRegistry.LUMINOUS_BLUE_GLASS.get(), createSilkTouchTable(BlockRegistry.LUMINOUS_BLUE_GLASS.get(), ItemRegistry.MOON_DUST.get(), 1, 1));
		lootTables.put(BlockRegistry.LUMINOUS_WHITE_GLASS.get(), createSilkTouchTable(BlockRegistry.LUMINOUS_WHITE_GLASS.get(), ItemRegistry.MOON_DUST.get(), 1, 1));
		lootTables.put(BlockRegistry.LUMINOUS_BLUE_GLASS_PANE.get(), createSilkTouchTable(BlockRegistry.LUMINOUS_BLUE_GLASS_PANE.get(), ItemRegistry.MOON_DUST.get(), 1, 1));
		lootTables.put(BlockRegistry.LUMINOUS_WHITE_GLASS_PANE.get(), createSilkTouchTable(BlockRegistry.LUMINOUS_WHITE_GLASS_PANE.get(), ItemRegistry.MOON_DUST.get(), 1, 1));

		lootTables.put(BlockRegistry.REINFORCED_GLASS.get(), createSimpleTable(BlockRegistry.REINFORCED_GLASS.get()));
		lootTables.put(BlockRegistry.REINFORCED_GLASS_PANE.get(), createSimpleTable(BlockRegistry.REINFORCED_GLASS_PANE.get()));

		//CERAMIC
		lootTables.put(BlockRegistry.CERAMIC.get(), createCeramicTable(BlockRegistry.CERAMIC.get()));
		lootTables.put(BlockRegistry.CERAMIC_TILE.get(), createCeramicTable(BlockRegistry.CERAMIC_TILE.get()));
		lootTables.put(BlockRegistry.WHITE_CERAMIC.get(), createCeramicTable(BlockRegistry.WHITE_CERAMIC.get()));
		lootTables.put(BlockRegistry.WHITE_CERAMIC_TILE.get(), createCeramicTable(BlockRegistry.WHITE_CERAMIC_TILE.get()));
		lootTables.put(BlockRegistry.LIGHT_GREY_CERAMIC.get(), createCeramicTable(BlockRegistry.LIGHT_GREY_CERAMIC.get()));
		lootTables.put(BlockRegistry.LIGHT_GREY_CERAMIC_TILE.get(), createCeramicTable(BlockRegistry.LIGHT_GREY_CERAMIC_TILE.get()));
		lootTables.put(BlockRegistry.GREY_CERAMIC.get(), createCeramicTable(BlockRegistry.GREY_CERAMIC.get()));
		lootTables.put(BlockRegistry.GREY_CERAMIC_TILE.get(), createCeramicTable(BlockRegistry.GREY_CERAMIC_TILE.get()));
		lootTables.put(BlockRegistry.BLACK_CERAMIC.get(), createCeramicTable(BlockRegistry.BLACK_CERAMIC.get()));
		lootTables.put(BlockRegistry.BLACK_CERAMIC_TILE.get(), createCeramicTable(BlockRegistry.BLACK_CERAMIC_TILE.get()));
		lootTables.put(BlockRegistry.PURPLE_CERAMIC.get(), createCeramicTable(BlockRegistry.PURPLE_CERAMIC.get()));
		lootTables.put(BlockRegistry.PURPLE_CERAMIC_TILE.get(), createCeramicTable(BlockRegistry.PURPLE_CERAMIC_TILE.get()));
		lootTables.put(BlockRegistry.MAGENTA_CERAMIC.get(), createCeramicTable(BlockRegistry.MAGENTA_CERAMIC.get()));
		lootTables.put(BlockRegistry.MAGENTA_CERAMIC_TILE.get(), createCeramicTable(BlockRegistry.MAGENTA_CERAMIC_TILE.get()));
		lootTables.put(BlockRegistry.BLUE_CERAMIC.get(), createCeramicTable(BlockRegistry.BLUE_CERAMIC.get()));
		lootTables.put(BlockRegistry.BLUE_CERAMIC_TILE.get(), createCeramicTable(BlockRegistry.BLUE_CERAMIC_TILE.get()));
		lootTables.put(BlockRegistry.LIGHT_BLUE_CERAMIC.get(), createCeramicTable(BlockRegistry.LIGHT_BLUE_CERAMIC.get()));
		lootTables.put(BlockRegistry.LIGHT_BLUE_CERAMIC_TILE.get(), createCeramicTable(BlockRegistry.LIGHT_BLUE_CERAMIC_TILE.get()));
		lootTables.put(BlockRegistry.CYAN_CERAMIC.get(), createCeramicTable(BlockRegistry.CYAN_CERAMIC.get()));
		lootTables.put(BlockRegistry.CYAN_CERAMIC_TILE.get(), createCeramicTable(BlockRegistry.CYAN_CERAMIC_TILE.get()));
		lootTables.put(BlockRegistry.GREEN_CERAMIC.get(), createCeramicTable(BlockRegistry.GREEN_CERAMIC.get()));
		lootTables.put(BlockRegistry.GREEN_CERAMIC_TILE.get(), createCeramicTable(BlockRegistry.GREEN_CERAMIC_TILE.get()));
		lootTables.put(BlockRegistry.LIME_CERAMIC.get(), createCeramicTable(BlockRegistry.LIME_CERAMIC.get()));
		lootTables.put(BlockRegistry.LIME_CERAMIC_TILE.get(), createCeramicTable(BlockRegistry.LIME_CERAMIC_TILE.get()));
		lootTables.put(BlockRegistry.YELLOW_CERAMIC.get(), createCeramicTable(BlockRegistry.YELLOW_CERAMIC.get()));
		lootTables.put(BlockRegistry.YELLOW_CERAMIC_TILE.get(), createCeramicTable(BlockRegistry.YELLOW_CERAMIC_TILE.get()));
		lootTables.put(BlockRegistry.ORANGE_CERAMIC.get(), createCeramicTable(BlockRegistry.ORANGE_CERAMIC.get()));
		lootTables.put(BlockRegistry.ORANGE_CERAMIC_TILE.get(), createCeramicTable(BlockRegistry.ORANGE_CERAMIC_TILE.get()));
		lootTables.put(BlockRegistry.BROWN_CERAMIC.get(), createCeramicTable(BlockRegistry.BROWN_CERAMIC.get()));
		lootTables.put(BlockRegistry.BROWN_CERAMIC_TILE.get(), createCeramicTable(BlockRegistry.BROWN_CERAMIC_TILE.get()));
		lootTables.put(BlockRegistry.RED_CERAMIC.get(), createCeramicTable(BlockRegistry.RED_CERAMIC.get()));
		lootTables.put(BlockRegistry.RED_CERAMIC_TILE.get(), createCeramicTable(BlockRegistry.RED_CERAMIC_TILE.get()));
		lootTables.put(BlockRegistry.PINK_CERAMIC.get(), createCeramicTable(BlockRegistry.PINK_CERAMIC.get()));
		lootTables.put(BlockRegistry.PINK_CERAMIC_TILE.get(), createCeramicTable(BlockRegistry.PINK_CERAMIC_TILE.get()));

		lootTables.put(BlockRegistry.PAINTED_WHITE_CERAMIC.get(), createCeramicTable(BlockRegistry.PAINTED_WHITE_CERAMIC.get()));
		lootTables.put(BlockRegistry.PAINTED_LIGHT_GREY_CERAMIC.get(), createCeramicTable(BlockRegistry.PAINTED_LIGHT_GREY_CERAMIC.get()));
		lootTables.put(BlockRegistry.PAINTED_GREY_CERAMIC.get(), createCeramicTable(BlockRegistry.PAINTED_GREY_CERAMIC.get()));
		lootTables.put(BlockRegistry.PAINTED_BLACK_CERAMIC.get(), createCeramicTable(BlockRegistry.PAINTED_BLACK_CERAMIC.get()));
		lootTables.put(BlockRegistry.PAINTED_PURPLE_CERAMIC.get(), createCeramicTable(BlockRegistry.PAINTED_PURPLE_CERAMIC.get()));
		lootTables.put(BlockRegistry.PAINTED_MAGENTA_CERAMIC.get(), createCeramicTable(BlockRegistry.PAINTED_MAGENTA_CERAMIC.get()));
		lootTables.put(BlockRegistry.PAINTED_BLUE_CERAMIC.get(), createCeramicTable(BlockRegistry.PAINTED_BLUE_CERAMIC.get()));
		lootTables.put(BlockRegistry.PAINTED_LIGHT_BLUE_CERAMIC.get(), createCeramicTable(BlockRegistry.PAINTED_LIGHT_BLUE_CERAMIC.get()));
		lootTables.put(BlockRegistry.PAINTED_CYAN_CERAMIC.get(), createCeramicTable(BlockRegistry.PAINTED_CYAN_CERAMIC.get()));
		lootTables.put(BlockRegistry.PAINTED_GREEN_CERAMIC.get(), createCeramicTable(BlockRegistry.PAINTED_GREEN_CERAMIC.get()));
		lootTables.put(BlockRegistry.PAINTED_LIME_CERAMIC.get(), createCeramicTable(BlockRegistry.PAINTED_LIME_CERAMIC.get()));
		lootTables.put(BlockRegistry.PAINTED_YELLOW_CERAMIC.get(), createCeramicTable(BlockRegistry.PAINTED_YELLOW_CERAMIC.get()));
		lootTables.put(BlockRegistry.PAINTED_ORANGE_CERAMIC.get(), createCeramicTable(BlockRegistry.PAINTED_ORANGE_CERAMIC.get()));
		lootTables.put(BlockRegistry.PAINTED_BROWN_CERAMIC.get(), createCeramicTable(BlockRegistry.PAINTED_BROWN_CERAMIC.get()));
		lootTables.put(BlockRegistry.PAINTED_RED_CERAMIC.get(), createCeramicTable(BlockRegistry.PAINTED_RED_CERAMIC.get()));
		lootTables.put(BlockRegistry.PAINTED_PINK_CERAMIC.get(), createCeramicTable(BlockRegistry.PAINTED_PINK_CERAMIC.get()));
	}
}