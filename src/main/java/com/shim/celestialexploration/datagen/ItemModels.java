package com.shim.celestialexploration.datagen;

import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestialexploration.registry.FluidRegistry;
import com.shim.celestialexploration.registry.ItemRegistry;

import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ItemModels extends ItemModelProvider {

	public ItemModels(DataGenerator generator, ExistingFileHelper existingFileHelper) {
		super(generator, CelestialExploration.MODID, existingFileHelper);
	}

	@Override
	protected void registerModels() {

		//---- MOON -------------------------------------------------------------------------------
		//STONE
		withExistingParent(ItemRegistry.MOON_STONE.get().getRegistryName().getPath(), modLoc("block/moon_stone"));
		stairs("moon_stone_stairs", modLoc("block/moon_stone"), modLoc("block/moon_stone"), modLoc("block/moon_stone"));
		slab("moon_stone_slab", modLoc("block/moon_stone"), modLoc("block/moon_stone"), modLoc("block/moon_stone"));
		buttonInventory(ItemRegistry.MOON_STONE_BUTTON.get().getRegistryName().getPath(), modLoc("block/moon_stone"));
		pressurePlate(ItemRegistry.MOON_STONE_PRESSURE_PLATE.get().getRegistryName().getPath(), modLoc("block/moon_stone"));

		withExistingParent(ItemRegistry.MOON_COBBLESTONE.get().getRegistryName().getPath(), modLoc("block/moon_cobblestone"));
		stairs("moon_cobblestone_stairs", modLoc("block/moon_cobblestone"), modLoc("block/moon_cobblestone"), modLoc("block/moon_cobblestone"));
		slab("moon_cobblestone_slab", modLoc("block/moon_cobblestone"), modLoc("block/moon_cobblestone"), modLoc("block/moon_cobblestone"));
		wallInventory("moon_cobblestone_wall",  modLoc("block/moon_cobblestone"));
		withExistingParent(ItemRegistry.COMPRESSED_MOON_COBBLESTONE.get().getRegistryName().getPath(), modLoc("block/compressed_moon_cobblestone"));

		withExistingParent(ItemRegistry.MOON_BRICKS.get().getRegistryName().getPath(), modLoc("block/moon_bricks"));
		stairs("moon_brick_stairs", modLoc("block/moon_bricks"), modLoc("block/moon_bricks"), modLoc("block/moon_bricks"));
		slab("moon_brick_slab", modLoc("block/moon_bricks"), modLoc("block/moon_bricks"), modLoc("block/moon_bricks"));
		wallInventory("moon_brick_wall",  modLoc("block/moon_bricks"));
		withExistingParent(ItemRegistry.CHISELED_MOON_BRICKS.get().getRegistryName().getPath(), modLoc("block/chiseled_moon_bricks"));
		withExistingParent(ItemRegistry.CRACKED_MOON_BRICKS.get().getRegistryName().getPath(), modLoc("block/cracked_moon_bricks"));
		withExistingParent(ItemRegistry.MOON_BRICK_PILLAR.get().getRegistryName().getPath(), modLoc("block/moon_brick_pillar"));

		withExistingParent(ItemRegistry.MOON_SMOOTH_STONE.get().getRegistryName().getPath(), modLoc("block/moon_smooth_stone"));
		slab("moon_smooth_stone_slab", modLoc("block/moon_smooth_stone_slab_side"), modLoc("block/moon_smooth_stone"), modLoc("block/moon_smooth_stone"));

		//DEEPSLATE
		withExistingParent(ItemRegistry.MOON_DEEPSLATE.get().getRegistryName().getPath(), modLoc("block/moon_deepslate"));
		buttonInventory(ItemRegistry.MOON_DEEPSLATE_BUTTON.get().getRegistryName().getPath(), modLoc("block/moon_deepslate_side"));
		pressurePlate(ItemRegistry.MOON_DEEPSLATE_PRESSURE_PLATE.get().getRegistryName().getPath(), modLoc("block/moon_deepslate_side"));

		withExistingParent(ItemRegistry.MOON_COBBLED_DEEPSLATE.get().getRegistryName().getPath(), modLoc("block/moon_cobbled_deepslate"));
		stairs("moon_cobbled_deepslate_stairs", modLoc("block/moon_cobbled_deepslate"), modLoc("block/moon_cobbled_deepslate"), modLoc("block/moon_cobbled_deepslate"));
		slab("moon_cobbled_deepslate_slab", modLoc("block/moon_cobbled_deepslate"), modLoc("block/moon_cobbled_deepslate"), modLoc("block/moon_cobbled_deepslate"));
		wallInventory("moon_cobbled_deepslate_wall",  modLoc("block/moon_cobbled_deepslate"));
		withExistingParent(ItemRegistry.COMPRESSED_MOON_COBBLED_DEEPSLATE.get().getRegistryName().getPath(), modLoc("block/compressed_moon_cobbled_deepslate"));

		withExistingParent(ItemRegistry.MOON_POLISHED_DEEPSLATE.get().getRegistryName().getPath(), modLoc("block/moon_polished_deepslate"));
		stairs("moon_polished_deepslate_stairs", modLoc("block/moon_polished_deepslate"), modLoc("block/moon_polished_deepslate"), modLoc("block/moon_polished_deepslate"));
		slab("moon_polished_deepslate_slab", modLoc("block/moon_polished_deepslate"), modLoc("block/moon_polished_deepslate"), modLoc("block/moon_polished_deepslate"));
		wallInventory("moon_polished_deepslate_wall",  modLoc("block/moon_polished_deepslate"));

		withExistingParent(ItemRegistry.MOON_DEEPSLATE_BRICKS.get().getRegistryName().getPath(), modLoc("block/moon_deepslate_bricks"));
		stairs("moon_deepslate_brick_stairs", modLoc("block/moon_deepslate_bricks"), modLoc("block/moon_deepslate_bricks"), modLoc("block/moon_deepslate_bricks"));
		slab("moon_deepslate_brick_slab", modLoc("block/moon_deepslate_bricks"), modLoc("block/moon_deepslate_bricks"), modLoc("block/moon_deepslate_bricks"));
		wallInventory("moon_deepslate_brick_wall",  modLoc("block/moon_deepslate_bricks"));
		withExistingParent(ItemRegistry.CHISELED_MOON_DEEPSLATE_BRICKS.get().getRegistryName().getPath(), modLoc("block/chiseled_moon_deepslate_bricks"));
		withExistingParent(ItemRegistry.CRACKED_MOON_DEEPSLATE_BRICKS.get().getRegistryName().getPath(), modLoc("block/cracked_moon_deepslate_bricks"));

		withExistingParent(ItemRegistry.MOON_DEEPSLATE_TILES.get().getRegistryName().getPath(), modLoc("block/moon_deepslate_tiles"));
		stairs("moon_deepslate_tile_stairs", modLoc("block/moon_deepslate_tiles"), modLoc("block/moon_deepslate_tiles"), modLoc("block/moon_deepslate_tiles"));
		slab("moon_deepslate_tile_slab", modLoc("block/moon_deepslate_tiles"), modLoc("block/moon_deepslate_tiles"), modLoc("block/moon_deepslate_tiles"));
		wallInventory("moon_deepslate_tile_wall",  modLoc("block/moon_deepslate_tiles"));
		withExistingParent(ItemRegistry.CRACKED_MOON_DEEPSLATE_TILES.get().getRegistryName().getPath(), modLoc("block/cracked_moon_deepslate_tiles"));
		
		//ORES
		withExistingParent(ItemRegistry.MOON_IRON_ORE.get().getRegistryName().getPath(), modLoc("block/moon_iron_ore"));
		withExistingParent(ItemRegistry.MOON_REDSTONE_ORE.get().getRegistryName().getPath(), modLoc("block/moon_redstone_ore"));
		withExistingParent(ItemRegistry.MOON_BAUXITE_ORE.get().getRegistryName().getPath(), modLoc("block/moon_bauxite_ore"));
		withExistingParent(ItemRegistry.MOON_DEEPSLATE_IRON_ORE.get().getRegistryName().getPath(), modLoc("block/moon_deepslate_iron_ore"));
		withExistingParent(ItemRegistry.MOON_DEEPSLATE_REDSTONE_ORE.get().getRegistryName().getPath(), modLoc("block/moon_deepslate_redstone_ore"));

		//OTHER
		withExistingParent(ItemRegistry.MOON_CORE.get().getRegistryName().getPath(), modLoc("block/moon_core"));
		withExistingParent(ItemRegistry.MOON_SAND.get().getRegistryName().getPath(), modLoc("block/moon_sand"));
		withExistingParent(ItemRegistry.COARSE_MOON_SAND.get().getRegistryName().getPath(), modLoc("block/coarse_moon_sand"));
		withExistingParent(ItemRegistry.GLOWING_MOON_SAND.get().getRegistryName().getPath(), modLoc("block/glowing_moon_sand"));
		withExistingParent(ItemRegistry.LUNAR_LANTERN.get().getRegistryName().getPath(), modLoc("block/lunar_lantern"));

		//---- MARS -------------------------------------------------------------------------------
		//STONE
		withExistingParent(ItemRegistry.MARS_STONE.get().getRegistryName().getPath(), modLoc("block/mars_stone"));
		stairs("mars_stone_stairs", modLoc("block/mars_stone"), modLoc("block/mars_stone"), modLoc("block/mars_stone"));
		slab("mars_stone_slab", modLoc("block/mars_stone"), modLoc("block/mars_stone"), modLoc("block/mars_stone"));
		buttonInventory(ItemRegistry.MARS_STONE_BUTTON.get().getRegistryName().getPath(), modLoc("block/mars_stone"));
		pressurePlate(ItemRegistry.MARS_STONE_PRESSURE_PLATE.get().getRegistryName().getPath(), modLoc("block/mars_stone"));

		withExistingParent(ItemRegistry.MARS_COBBLESTONE.get().getRegistryName().getPath(), modLoc("block/mars_cobblestone"));
		stairs("mars_cobblestone_stairs", modLoc("block/mars_cobblestone"), modLoc("block/mars_cobblestone"), modLoc("block/mars_cobblestone"));
		slab("mars_cobblestone_slab", modLoc("block/mars_cobblestone"), modLoc("block/mars_cobblestone"), modLoc("block/mars_cobblestone"));
		wallInventory("mars_cobblestone_wall",  modLoc("block/mars_cobblestone"));
		withExistingParent(ItemRegistry.COMPRESSED_MARS_COBBLESTONE.get().getRegistryName().getPath(), modLoc("block/compressed_mars_cobblestone"));

		withExistingParent(ItemRegistry.MARS_BRICKS.get().getRegistryName().getPath(), modLoc("block/mars_bricks"));
		stairs("mars_brick_stairs", modLoc("block/mars_bricks"), modLoc("block/mars_bricks"), modLoc("block/mars_bricks"));
		slab("mars_brick_slab", modLoc("block/mars_bricks"), modLoc("block/mars_bricks"), modLoc("block/mars_bricks"));
		wallInventory("mars_brick_wall",  modLoc("block/mars_bricks"));
		withExistingParent(ItemRegistry.CHISELED_MARS_BRICKS.get().getRegistryName().getPath(), modLoc("block/chiseled_mars_bricks"));
		withExistingParent(ItemRegistry.CRACKED_MARS_BRICKS.get().getRegistryName().getPath(), modLoc("block/cracked_mars_bricks"));
		withExistingParent(ItemRegistry.MARS_BRICK_PILLAR.get().getRegistryName().getPath(), modLoc("block/mars_brick_pillar"));

		withExistingParent(ItemRegistry.MARS_SMOOTH_STONE.get().getRegistryName().getPath(), modLoc("block/mars_smooth_stone"));
		slab("mars_smooth_stone_slab", modLoc("block/mars_smooth_stone_slab_side"), modLoc("block/mars_smooth_stone"), modLoc("block/mars_smooth_stone"));

		//DEEPSLATE
		withExistingParent(ItemRegistry.MARS_DEEPSLATE.get().getRegistryName().getPath(), modLoc("block/mars_deepslate"));
		buttonInventory(ItemRegistry.MARS_DEEPSLATE_BUTTON.get().getRegistryName().getPath(), modLoc("block/mars_deepslate_side"));
		pressurePlate(ItemRegistry.MARS_DEEPSLATE_PRESSURE_PLATE.get().getRegistryName().getPath(), modLoc("block/mars_deepslate_side"));

		withExistingParent(ItemRegistry.MARS_COBBLED_DEEPSLATE.get().getRegistryName().getPath(), modLoc("block/mars_cobbled_deepslate"));
		stairs("mars_cobbled_deepslate_stairs", modLoc("block/mars_cobbled_deepslate"), modLoc("block/mars_cobbled_deepslate"), modLoc("block/mars_cobbled_deepslate"));
		slab("mars_cobbled_deepslate_slab", modLoc("block/mars_cobbled_deepslate"), modLoc("block/mars_cobbled_deepslate"), modLoc("block/mars_cobbled_deepslate"));
		wallInventory("mars_cobbled_deepslate_wall",  modLoc("block/mars_cobbled_deepslate"));
		withExistingParent(ItemRegistry.COMPRESSED_MARS_COBBLED_DEEPSLATE.get().getRegistryName().getPath(), modLoc("block/compressed_mars_cobbled_deepslate"));

		withExistingParent(ItemRegistry.MARS_POLISHED_DEEPSLATE.get().getRegistryName().getPath(), modLoc("block/mars_polished_deepslate"));
		stairs("mars_polished_deepslate_stairs", modLoc("block/mars_polished_deepslate"), modLoc("block/mars_polished_deepslate"), modLoc("block/mars_polished_deepslate"));
		slab("mars_polished_deepslate_slab", modLoc("block/mars_polished_deepslate"), modLoc("block/mars_polished_deepslate"), modLoc("block/mars_polished_deepslate"));
		wallInventory("mars_polished_deepslate_wall",  modLoc("block/mars_polished_deepslate"));

		withExistingParent(ItemRegistry.MARS_DEEPSLATE_BRICKS.get().getRegistryName().getPath(), modLoc("block/mars_deepslate_bricks"));
		stairs("mars_deepslate_brick_stairs", modLoc("block/mars_deepslate_bricks"), modLoc("block/mars_deepslate_bricks"), modLoc("block/mars_deepslate_bricks"));
		slab("mars_deepslate_brick_slab", modLoc("block/mars_deepslate_bricks"), modLoc("block/mars_deepslate_bricks"), modLoc("block/mars_deepslate_bricks"));
		wallInventory("mars_deepslate_brick_wall",  modLoc("block/mars_deepslate_bricks"));
		withExistingParent(ItemRegistry.CHISELED_MARS_DEEPSLATE_BRICKS.get().getRegistryName().getPath(), modLoc("block/chiseled_mars_deepslate_bricks"));
		withExistingParent(ItemRegistry.CRACKED_MARS_DEEPSLATE_BRICKS.get().getRegistryName().getPath(), modLoc("block/cracked_mars_deepslate_bricks"));

		withExistingParent(ItemRegistry.MARS_DEEPSLATE_TILES.get().getRegistryName().getPath(), modLoc("block/mars_deepslate_tiles"));
		stairs("mars_deepslate_tile_stairs", modLoc("block/mars_deepslate_tiles"), modLoc("block/mars_deepslate_tiles"), modLoc("block/mars_deepslate_tiles"));
		slab("mars_deepslate_tile_slab", modLoc("block/mars_deepslate_tiles"), modLoc("block/mars_deepslate_tiles"), modLoc("block/mars_deepslate_tiles"));
		wallInventory("mars_deepslate_tile_wall",  modLoc("block/mars_deepslate_tiles"));
		withExistingParent(ItemRegistry.CRACKED_MARS_DEEPSLATE_TILES.get().getRegistryName().getPath(), modLoc("block/cracked_mars_deepslate_tiles"));

		//ORES
		withExistingParent(ItemRegistry.MARS_IRON_ORE.get().getRegistryName().getPath(), modLoc("block/mars_iron_ore"));
		withExistingParent(ItemRegistry.MARS_REDSTONE_ORE.get().getRegistryName().getPath(), modLoc("block/mars_redstone_ore"));
		withExistingParent(ItemRegistry.MARS_BAUXITE_ORE.get().getRegistryName().getPath(), modLoc("block/mars_bauxite_ore"));
		withExistingParent(ItemRegistry.MARS_DEEPSLATE_IRON_ORE.get().getRegistryName().getPath(), modLoc("block/mars_deepslate_iron_ore"));
		withExistingParent(ItemRegistry.MARS_DEEPSLATE_REDSTONE_ORE.get().getRegistryName().getPath(), modLoc("block/mars_deepslate_redstone_ore"));

		//OTHER
		withExistingParent(ItemRegistry.MARS_CORE.get().getRegistryName().getPath(), modLoc("block/mars_core"));
		withExistingParent(ItemRegistry.MARS_LANTERN.get().getRegistryName().getPath(), modLoc("block/mars_lantern"));
		withExistingParent(ItemRegistry.MARS_SAND.get().getRegistryName().getPath(), modLoc("block/mars_sand"));
		withExistingParent(ItemRegistry.COARSE_MARS_SAND.get().getRegistryName().getPath(), modLoc("block/coarse_mars_sand"));

		//---- VENUS -------------------------------------------------------------------------------
		//STONE
		withExistingParent(ItemRegistry.VENUS_STONE.get().getRegistryName().getPath(), modLoc("block/venus_stone"));
		stairs("venus_stone_stairs", modLoc("block/venus_stone"), modLoc("block/venus_stone"), modLoc("block/venus_stone"));
		slab("venus_stone_slab", modLoc("block/venus_stone"), modLoc("block/venus_stone"), modLoc("block/venus_stone"));
		buttonInventory(ItemRegistry.VENUS_STONE_BUTTON.get().getRegistryName().getPath(), modLoc("block/venus_stone"));
		pressurePlate(ItemRegistry.VENUS_STONE_PRESSURE_PLATE.get().getRegistryName().getPath(), modLoc("block/venus_stone"));

		withExistingParent(ItemRegistry.VENUS_COBBLESTONE.get().getRegistryName().getPath(), modLoc("block/venus_cobblestone"));
		stairs("venus_cobblestone_stairs", modLoc("block/venus_cobblestone"), modLoc("block/venus_cobblestone"), modLoc("block/venus_cobblestone"));
		slab("venus_cobblestone_slab", modLoc("block/venus_cobblestone"), modLoc("block/venus_cobblestone"), modLoc("block/venus_cobblestone"));
		wallInventory("venus_cobblestone_wall",  modLoc("block/venus_cobblestone"));
		withExistingParent(ItemRegistry.COMPRESSED_VENUS_COBBLESTONE.get().getRegistryName().getPath(), modLoc("block/compressed_venus_cobblestone"));

		withExistingParent(ItemRegistry.VENUS_BRICKS.get().getRegistryName().getPath(), modLoc("block/venus_bricks"));
		stairs("venus_brick_stairs", modLoc("block/venus_bricks"), modLoc("block/venus_bricks"), modLoc("block/venus_bricks"));
		slab("venus_brick_slab", modLoc("block/venus_bricks"), modLoc("block/venus_bricks"), modLoc("block/venus_bricks"));
		wallInventory("venus_brick_wall",  modLoc("block/venus_bricks"));
		withExistingParent(ItemRegistry.CHISELED_VENUS_BRICKS.get().getRegistryName().getPath(), modLoc("block/chiseled_venus_bricks"));
		withExistingParent(ItemRegistry.CRACKED_VENUS_BRICKS.get().getRegistryName().getPath(), modLoc("block/cracked_venus_bricks"));
		withExistingParent(ItemRegistry.VENUS_BRICK_PILLAR.get().getRegistryName().getPath(), modLoc("block/venus_brick_pillar"));

		withExistingParent(ItemRegistry.SMALL_VENUS_BRICKS.get().getRegistryName().getPath(), modLoc("block/small_venus_bricks"));
		stairs("small_venus_brick_stairs", modLoc("block/small_venus_bricks"), modLoc("block/small_venus_bricks"), modLoc("block/small_venus_bricks"));
		slab("small_venus_brick_slab", modLoc("block/small_venus_bricks"), modLoc("block/small_venus_bricks"), modLoc("block/small_venus_bricks"));
		wallInventory("small_venus_brick_wall",  modLoc("block/small_venus_bricks"));


		withExistingParent(ItemRegistry.VENUS_SMOOTH_STONE.get().getRegistryName().getPath(), modLoc("block/venus_smooth_stone"));
		slab("venus_smooth_stone_slab", modLoc("block/venus_smooth_stone_slab_side"), modLoc("block/venus_smooth_stone"), modLoc("block/venus_smooth_stone"));

		//DEEPSLATE
		withExistingParent(ItemRegistry.VENUS_DEEPSLATE.get().getRegistryName().getPath(), modLoc("block/venus_deepslate"));
		buttonInventory(ItemRegistry.VENUS_DEEPSLATE_BUTTON.get().getRegistryName().getPath(), modLoc("block/venus_deepslate_side"));
		pressurePlate(ItemRegistry.VENUS_DEEPSLATE_PRESSURE_PLATE.get().getRegistryName().getPath(), modLoc("block/venus_deepslate_side"));

		withExistingParent(ItemRegistry.VENUS_COBBLED_DEEPSLATE.get().getRegistryName().getPath(), modLoc("block/venus_cobbled_deepslate"));
		stairs("venus_cobbled_deepslate_stairs", modLoc("block/venus_cobbled_deepslate"), modLoc("block/venus_cobbled_deepslate"), modLoc("block/venus_cobbled_deepslate"));
		slab("venus_cobbled_deepslate_slab", modLoc("block/venus_cobbled_deepslate"), modLoc("block/venus_cobbled_deepslate"), modLoc("block/venus_cobbled_deepslate"));
		wallInventory("venus_cobbled_deepslate_wall",  modLoc("block/venus_cobbled_deepslate"));
		withExistingParent(ItemRegistry.COMPRESSED_VENUS_COBBLED_DEEPSLATE.get().getRegistryName().getPath(), modLoc("block/compressed_venus_cobbled_deepslate"));

		withExistingParent(ItemRegistry.VENUS_POLISHED_DEEPSLATE.get().getRegistryName().getPath(), modLoc("block/venus_polished_deepslate"));
		stairs("venus_polished_deepslate_stairs", modLoc("block/venus_polished_deepslate"), modLoc("block/venus_polished_deepslate"), modLoc("block/venus_polished_deepslate"));
		slab("venus_polished_deepslate_slab", modLoc("block/venus_polished_deepslate"), modLoc("block/venus_polished_deepslate"), modLoc("block/venus_polished_deepslate"));
		wallInventory("venus_polished_deepslate_wall",  modLoc("block/venus_polished_deepslate"));

		withExistingParent(ItemRegistry.VENUS_DEEPSLATE_BRICKS.get().getRegistryName().getPath(), modLoc("block/venus_deepslate_bricks"));
		stairs("venus_deepslate_brick_stairs", modLoc("block/venus_deepslate_bricks"), modLoc("block/venus_deepslate_bricks"), modLoc("block/venus_deepslate_bricks"));
		slab("venus_deepslate_brick_slab", modLoc("block/venus_deepslate_bricks"), modLoc("block/venus_deepslate_bricks"), modLoc("block/venus_deepslate_bricks"));
		wallInventory("venus_deepslate_brick_wall",  modLoc("block/venus_deepslate_bricks"));
		withExistingParent(ItemRegistry.CHISELED_VENUS_DEEPSLATE_BRICKS.get().getRegistryName().getPath(), modLoc("block/chiseled_venus_deepslate_bricks"));
		withExistingParent(ItemRegistry.CRACKED_VENUS_DEEPSLATE_BRICKS.get().getRegistryName().getPath(), modLoc("block/cracked_venus_deepslate_bricks"));

		withExistingParent(ItemRegistry.VENUS_DEEPSLATE_TILES.get().getRegistryName().getPath(), modLoc("block/venus_deepslate_tiles"));
		stairs("venus_deepslate_tile_stairs", modLoc("block/venus_deepslate_tiles"), modLoc("block/venus_deepslate_tiles"), modLoc("block/venus_deepslate_tiles"));
		slab("venus_deepslate_tile_slab", modLoc("block/venus_deepslate_tiles"), modLoc("block/venus_deepslate_tiles"), modLoc("block/venus_deepslate_tiles"));
		wallInventory("venus_deepslate_tile_wall",  modLoc("block/venus_deepslate_tiles"));
		withExistingParent(ItemRegistry.CRACKED_VENUS_DEEPSLATE_TILES.get().getRegistryName().getPath(), modLoc("block/cracked_venus_deepslate_tiles"));

		//ORES
		withExistingParent(ItemRegistry.VENUS_IRON_ORE.get().getRegistryName().getPath(), modLoc("block/venus_iron_ore"));
		withExistingParent(ItemRegistry.VENUS_REDSTONE_ORE.get().getRegistryName().getPath(), modLoc("block/venus_redstone_ore"));
		withExistingParent(ItemRegistry.VENUS_BAUXITE_ORE.get().getRegistryName().getPath(), modLoc("block/venus_bauxite_ore"));
		withExistingParent(ItemRegistry.VENUS_LAPIS_ORE.get().getRegistryName().getPath(), modLoc("block/venus_lapis_ore"));
		withExistingParent(ItemRegistry.VENUS_DEEPSLATE_LAPIS_ORE.get().getRegistryName().getPath(), modLoc("block/venus_deepslate_lapis_ore"));
		withExistingParent(ItemRegistry.VENUS_DEEPSLATE_IRON_ORE.get().getRegistryName().getPath(), modLoc("block/venus_deepslate_iron_ore"));
		withExistingParent(ItemRegistry.VENUS_DEEPSLATE_REDSTONE_ORE.get().getRegistryName().getPath(), modLoc("block/venus_deepslate_redstone_ore"));

		//OTHER
		withExistingParent(ItemRegistry.VENUS_CORE.get().getRegistryName().getPath(), modLoc("block/venus_core"));
		withExistingParent(ItemRegistry.VENUS_SAND.get().getRegistryName().getPath(), modLoc("block/venus_sand"));
		withExistingParent(ItemRegistry.FINE_VENUS_SAND.get().getRegistryName().getPath(), modLoc("block/fine_venus_sand"));
		withExistingParent(ItemRegistry.SULFURIC_OBSIDIAN.get().getRegistryName().getPath(), modLoc("block/sulfuric_obsidian"));
		withExistingParent(ItemRegistry.VENUS_LANTERN.get().getRegistryName().getPath(), modLoc("block/venus_lantern"));
		withExistingParent(ItemRegistry.GEYSER.get().getRegistryName().getPath(), modLoc("block/geyser"));


		//---- CELESTIAL OBJECTS -------------------------------------------------------------------------------
		//METEOR
		withExistingParent(ItemRegistry.METEOR.get().getRegistryName().getPath(), modLoc("block/meteor"));
		buttonInventory(ItemRegistry.METEOR_BUTTON.get().getRegistryName().getPath(), modLoc("block/meteor"));
		pressurePlate(ItemRegistry.METEOR_PRESSURE_PLATE.get().getRegistryName().getPath(), modLoc("block/meteor"));

		withExistingParent(ItemRegistry.METEOR_BRICKS.get().getRegistryName().getPath(), modLoc("block/meteor_bricks"));
		stairs("meteor_brick_stairs", modLoc("block/meteor_bricks"), modLoc("block/meteor_bricks"), modLoc("block/meteor_bricks"));
		slab("meteor_brick_slab", modLoc("block/meteor_bricks"), modLoc("block/meteor_bricks"), modLoc("block/meteor_bricks"));
		wallInventory("meteor_brick_wall",  modLoc("block/meteor_bricks"));
		withExistingParent(ItemRegistry.CHISELED_METEOR_BRICKS.get().getRegistryName().getPath(), modLoc("block/chiseled_meteor_bricks"));


		//METEOR ORE
		withExistingParent(ItemRegistry.METEOR_COAL_ORE.get().getRegistryName().getPath(), modLoc("block/meteor_coal_ore"));
		withExistingParent(ItemRegistry.METEOR_COPPER_ORE.get().getRegistryName().getPath(), modLoc("block/meteor_copper_ore"));
		withExistingParent(ItemRegistry.METEOR_DIAMOND_ORE.get().getRegistryName().getPath(), modLoc("block/meteor_diamond_ore"));
		withExistingParent(ItemRegistry.METEOR_EMERALD_ORE.get().getRegistryName().getPath(), modLoc("block/meteor_emerald_ore"));
		withExistingParent(ItemRegistry.METEOR_GOLD_ORE.get().getRegistryName().getPath(), modLoc("block/meteor_gold_ore"));
		withExistingParent(ItemRegistry.METEOR_IRON_ORE.get().getRegistryName().getPath(), modLoc("block/meteor_iron_ore"));
		withExistingParent(ItemRegistry.METEOR_LAPIS_ORE.get().getRegistryName().getPath(), modLoc("block/meteor_lapis_ore"));
		withExistingParent(ItemRegistry.METEOR_SULFUR_ORE.get().getRegistryName().getPath(), modLoc("block/meteor_sulfur_ore"));
		withExistingParent(ItemRegistry.METEOR_REDSTONE_ORE.get().getRegistryName().getPath(), modLoc("block/meteor_redstone_ore"));
		withExistingParent(ItemRegistry.METEOR_BAUXITE_ORE.get().getRegistryName().getPath(), modLoc("block/meteor_bauxite_ore"));


		//SUN
		withExistingParent(ItemRegistry.SOLAR_PLASMA.get().getRegistryName().getPath(), modLoc("block/solar_plasma"));
		withExistingParent(ItemRegistry.SOLAR_FLARE.get().getRegistryName().getPath(), modLoc("block/solar_flare"));
		withExistingParent(ItemRegistry.SUN_SPOT.get().getRegistryName().getPath(), modLoc("block/sun_spot"));

		//---- OTHER PLANETS -------------------------------------------------------------------------------
		//MERCURY
		withExistingParent(ItemRegistry.MERCURY_CORE.get().getRegistryName().getPath(), modLoc("block/mercury_core"));
		withExistingParent(ItemRegistry.MERCURY_STONE.get().getRegistryName().getPath(), modLoc("block/mercury_stone"));
		withExistingParent(ItemRegistry.MERCURY_DEEPSLATE.get().getRegistryName().getPath(), modLoc("block/mercury_deepslate"));

		//JUPITER
		withExistingParent(ItemRegistry.JUPITER_CORE.get().getRegistryName().getPath(), modLoc("block/jupiter_core"));
		withExistingParent(ItemRegistry.JUPITER_ATMOSPHERE.get().getRegistryName().getPath(), modLoc("block/jupiter_atmosphere"));
		withExistingParent(ItemRegistry.JUPITER_DEEPSLATE.get().getRegistryName().getPath(), modLoc("block/jupiter_deepslate"));

		withExistingParent(ItemRegistry.IO_CORE.get().getRegistryName().getPath(), modLoc("block/io_core"));
		withExistingParent(ItemRegistry.IO_STONE.get().getRegistryName().getPath(), modLoc("block/io_stone"));
		withExistingParent(ItemRegistry.IO_DEEPSLATE.get().getRegistryName().getPath(), modLoc("block/io_deepslate"));

		withExistingParent(ItemRegistry.EUROPA_CORE.get().getRegistryName().getPath(), modLoc("block/europa_core"));
		withExistingParent(ItemRegistry.EUROPA_HYDRATE.get().getRegistryName().getPath(), modLoc("block/europa_hydrate"));

		withExistingParent(ItemRegistry.GANYMEDE_CORE.get().getRegistryName().getPath(), modLoc("block/ganymede_core"));
		withExistingParent(ItemRegistry.CALLISTO_CORE.get().getRegistryName().getPath(), modLoc("block/callisto_core"));

		//SATURN
		withExistingParent(ItemRegistry.SATURN_ATMOSPHERE.get().getRegistryName().getPath(), modLoc("block/saturn_atmosphere"));
		withExistingParent(ItemRegistry.SATURN_CORE.get().getRegistryName().getPath(), modLoc("block/saturn_core"));
		withExistingParent(ItemRegistry.SATURN_DEEPSLATE.get().getRegistryName().getPath(), modLoc("block/saturn_deepslate"));

		withExistingParent(ItemRegistry.TITAN_CORE.get().getRegistryName().getPath(), modLoc("block/titan_core"));
		withExistingParent(ItemRegistry.ENCELADUS_CORE.get().getRegistryName().getPath(), modLoc("block/enceladus_core"));
		withExistingParent(ItemRegistry.IAPETUS_CORE.get().getRegistryName().getPath(), modLoc("block/iapetus_core"));
		withExistingParent(ItemRegistry.RHEA_CORE.get().getRegistryName().getPath(), modLoc("block/rhea_core"));
		withExistingParent(ItemRegistry.DIONE_CORE.get().getRegistryName().getPath(), modLoc("block/dione_core"));
		withExistingParent(ItemRegistry.HYPERION_CORE.get().getRegistryName().getPath(), modLoc("block/hyperion_core"));

		//URANUS
		withExistingParent(ItemRegistry.URANUS_CORE.get().getRegistryName().getPath(), modLoc("block/uranus_core"));
		withExistingParent(ItemRegistry.URANUS_DEEPSLATE.get().getRegistryName().getPath(), modLoc("block/uranus_deepslate"));
		withExistingParent(ItemRegistry.URANUS_ATMOSPHERE.get().getRegistryName().getPath(), modLoc("block/uranus_atmosphere"));

		withExistingParent(ItemRegistry.TITANIA_CORE.get().getRegistryName().getPath(), modLoc("block/titania_core"));
		withExistingParent(ItemRegistry.OBERON_CORE.get().getRegistryName().getPath(), modLoc("block/oberon_core"));

		//NEPTUNE
		withExistingParent(ItemRegistry.NEPTUNE_CORE.get().getRegistryName().getPath(), modLoc("block/neptune_core"));
		withExistingParent(ItemRegistry.NEPTUNE_ATMOSPHERE.get().getRegistryName().getPath(), modLoc("block/neptune_atmosphere"));
		withExistingParent(ItemRegistry.NEPTUNE_DEEPSLATE.get().getRegistryName().getPath(), modLoc("block/neptune_deepslate"));

		withExistingParent(ItemRegistry.TRITON_CORE.get().getRegistryName().getPath(), modLoc("block/triton_core"));

		//DWARF PLANETS/OTHER
//		withExistingParent(ItemRegistry.PLUTO_CORE.get().getRegistryName().getPath(), modLoc("block/pluto_core"));
//		withExistingParent(ItemRegistry.ERIS_CORE.get().getRegistryName().getPath(), modLoc("block/eris_core"));
//		withExistingParent(ItemRegistry.HAUMEA_CORE.get().getRegistryName().getPath(), modLoc("block/haumea_core"));
//		withExistingParent(ItemRegistry.CERES_CORE.get().getRegistryName().getPath(), modLoc("block/ceres_core"));
//		withExistingParent(ItemRegistry.MAKEMAKE_CORE.get().getRegistryName().getPath(), modLoc("block/makemake_core"));

		//---- ORE-RELATED -------------------------------------------------------------------------------
		withExistingParent(ItemRegistry.ALUMINUM_BLOCK.get().getRegistryName().getPath(), modLoc("block/aluminum_block"));
		withExistingParent(ItemRegistry.STEEL_BLOCK.get().getRegistryName().getPath(), modLoc("block/steel_block"));
		singleTexture(ItemRegistry.STEEL_INGOT.get().getRegistryName().getPath(), new ResourceLocation("item/generated"), "layer0", new ResourceLocation(CelestialExploration.MODID, "item/steel_ingot"));
		singleTexture(ItemRegistry.STEEL_NUGGET.get().getRegistryName().getPath(), new ResourceLocation("item/generated"), "layer0", new ResourceLocation(CelestialExploration.MODID, "item/steel_nugget"));
		singleTexture(ItemRegistry.BAUXITE_INGOT.get().getRegistryName().getPath(), new ResourceLocation("item/generated"), "layer0", new ResourceLocation(CelestialExploration.MODID, "item/bauxite_ingot"));
		singleTexture(ItemRegistry.ALUMINUM_INGOT.get().getRegistryName().getPath(), new ResourceLocation("item/generated"), "layer0", new ResourceLocation(CelestialExploration.MODID, "item/aluminum_ingot"));
		singleTexture(ItemRegistry.RAW_BAUXITE.get().getRegistryName().getPath(), new ResourceLocation("item/generated"), "layer0", new ResourceLocation(CelestialExploration.MODID, "item/raw_bauxite"));
		singleTexture(ItemRegistry.RUSTED_IRON_NUGGET.get().getRegistryName().getPath(), new ResourceLocation("item/generated"), "layer0", new ResourceLocation(CelestialExploration.MODID, "item/rusted_iron_nugget"));
		withExistingParent(ItemRegistry.BAUXITE_ORE.get().getRegistryName().getPath(), modLoc("block/bauxite_ore"));

		//---- SPACESHIP -------------------------------------------------------------------------------
		withExistingParent(ItemRegistry.OXYGEN_COMPRESSOR.get().getRegistryName().getPath(), modLoc("block/oxygen_compressor"));
		withExistingParent(ItemRegistry.WORKBENCH.get().getRegistryName().getPath(), modLoc("block/workbench"));

		singleTexture(ItemRegistry.SPACESHIP_FRAME.get().getRegistryName().getPath(), new ResourceLocation("item/generated"), "layer0", new ResourceLocation(CelestialExploration.MODID, "item/spaceship_frame"));
		singleTexture(ItemRegistry.SPACESHIP_CABIN.get().getRegistryName().getPath(), new ResourceLocation("item/generated"), "layer0", new ResourceLocation(CelestialExploration.MODID, "item/spaceship_cabin"));
		singleTexture(ItemRegistry.SPACESHIP_ENGINE.get().getRegistryName().getPath(), new ResourceLocation("item/generated"), "layer0", new ResourceLocation(CelestialExploration.MODID, "item/spaceship_engine"));

		singleTexture(ItemRegistry.BLACK_SPACESHIP.get().getRegistryName().getPath(), new ResourceLocation("item/generated"), "layer0", new ResourceLocation(CelestialExploration.MODID, "item/black_spaceship"));
		singleTexture(ItemRegistry.GREY_SPACESHIP.get().getRegistryName().getPath(), new ResourceLocation("item/generated"), "layer0", new ResourceLocation(CelestialExploration.MODID, "item/grey_spaceship"));
		singleTexture(ItemRegistry.LIGHT_GREY_SPACESHIP.get().getRegistryName().getPath(), new ResourceLocation("item/generated"), "layer0", new ResourceLocation(CelestialExploration.MODID, "item/light_grey_spaceship"));
		singleTexture(ItemRegistry.WHITE_SPACESHIP.get().getRegistryName().getPath(), new ResourceLocation("item/generated"), "layer0", new ResourceLocation(CelestialExploration.MODID, "item/white_spaceship"));
		singleTexture(ItemRegistry.PINK_SPACESHIP.get().getRegistryName().getPath(), new ResourceLocation("item/generated"), "layer0", new ResourceLocation(CelestialExploration.MODID, "item/pink_spaceship"));
		singleTexture(ItemRegistry.MAGENTA_SPACESHIP.get().getRegistryName().getPath(), new ResourceLocation("item/generated"), "layer0", new ResourceLocation(CelestialExploration.MODID, "item/magenta_spaceship"));
		singleTexture(ItemRegistry.RED_SPACESHIP.get().getRegistryName().getPath(), new ResourceLocation("item/generated"), "layer0", new ResourceLocation(CelestialExploration.MODID, "item/red_spaceship"));
		singleTexture(ItemRegistry.BROWN_SPACESHIP.get().getRegistryName().getPath(), new ResourceLocation("item/generated"), "layer0", new ResourceLocation(CelestialExploration.MODID, "item/brown_spaceship"));
		singleTexture(ItemRegistry.ORANGE_SPACESHIP.get().getRegistryName().getPath(), new ResourceLocation("item/generated"), "layer0", new ResourceLocation(CelestialExploration.MODID, "item/orange_spaceship"));
		singleTexture(ItemRegistry.YELLOW_SPACESHIP.get().getRegistryName().getPath(), new ResourceLocation("item/generated"), "layer0", new ResourceLocation(CelestialExploration.MODID, "item/yellow_spaceship"));
		singleTexture(ItemRegistry.LIME_SPACESHIP.get().getRegistryName().getPath(), new ResourceLocation("item/generated"), "layer0", new ResourceLocation(CelestialExploration.MODID, "item/lime_spaceship"));
		singleTexture(ItemRegistry.GREEN_SPACESHIP.get().getRegistryName().getPath(), new ResourceLocation("item/generated"), "layer0", new ResourceLocation(CelestialExploration.MODID, "item/green_spaceship"));
		singleTexture(ItemRegistry.CYAN_SPACESHIP.get().getRegistryName().getPath(), new ResourceLocation("item/generated"), "layer0", new ResourceLocation(CelestialExploration.MODID, "item/cyan_spaceship"));
		singleTexture(ItemRegistry.LIGHT_BLUE_SPACESHIP.get().getRegistryName().getPath(), new ResourceLocation("item/generated"), "layer0", new ResourceLocation(CelestialExploration.MODID, "item/light_blue_spaceship"));
		singleTexture(ItemRegistry.BLUE_SPACESHIP.get().getRegistryName().getPath(), new ResourceLocation("item/generated"), "layer0", new ResourceLocation(CelestialExploration.MODID, "item/blue_spaceship"));
		singleTexture(ItemRegistry.PURPLE_SPACESHIP.get().getRegistryName().getPath(), new ResourceLocation("item/generated"), "layer0", new ResourceLocation(CelestialExploration.MODID, "item/purple_spaceship"));

		//---- SPACE STATION -------------------------------------------------------------------------------
		withExistingParent(ItemRegistry.INSULATED_PANEL.get().getRegistryName().getPath(), modLoc("block/insulated_panel"));
		withExistingParent(ItemRegistry.INSULATED_PANEL_CORNER.get().getRegistryName().getPath(), modLoc("block/insulated_panel_corner"));
		withExistingParent(ItemRegistry.PANEL.get().getRegistryName().getPath(), modLoc("block/panel"));
		stairs("panel_stairs", modLoc("block/panel"), modLoc("block/panel"), modLoc("block/panel"));
		slab("panel_slab", modLoc("block/panel"), modLoc("block/panel"), modLoc("block/panel"));
		wallInventory("panel_wall",  modLoc("block/panel"));
		singleTexture(ItemRegistry.THIN_PANEL.get().getRegistryName().getPath(), new ResourceLocation("item/generated"), "layer0", new ResourceLocation(CelestialExploration.MODID, "block/panel"));

		buttonInventory(ItemRegistry.RED_BUTTON.get().getRegistryName().getPath(), modLoc("block/red_ceramic"));
		buttonInventory(ItemRegistry.YELLOW_BUTTON.get().getRegistryName().getPath(), modLoc("block/yellow_ceramic"));
		buttonInventory(ItemRegistry.BLUE_BUTTON.get().getRegistryName().getPath(), modLoc("block/blue_ceramic"));
		buttonInventory(ItemRegistry.GREEN_BUTTON.get().getRegistryName().getPath(), modLoc("block/green_ceramic"));
		buttonInventory(ItemRegistry.WHITE_BUTTON.get().getRegistryName().getPath(), modLoc("block/white_ceramic"));
		buttonInventory(ItemRegistry.BLACK_BUTTON.get().getRegistryName().getPath(), modLoc("block/black_ceramic"));

		withExistingParent(ItemRegistry.PATHWAY_LIGHT.get().getRegistryName().getPath(), modLoc("block/pathway_light"));

		singleTexture(ItemRegistry.AIRLOCK_DOOR.get().getRegistryName().getPath(), new ResourceLocation("item/generated"), "layer0", new ResourceLocation(CelestialExploration.MODID, "item/airlock_door"));
		singleTexture(ItemRegistry.STEEL_DOOR.get().getRegistryName().getPath(), new ResourceLocation("item/generated"), "layer0", new ResourceLocation(CelestialExploration.MODID, "item/steel_door"));
		withExistingParent(ItemRegistry.STEEL_TRAPDOOR.get().getRegistryName().getPath(), modLoc("block/steel_trapdoor_bottom"));
		buttonInventory(ItemRegistry.STEEL_BUTTON.get().getRegistryName().getPath(), modLoc("block/steel_block"));

		//---- MAG LEV -------------------------------------------------------------------------------
		singleTexture(ItemRegistry.MAG_RAIL.get().getRegistryName().getPath(), new ResourceLocation("item/generated"), "layer0", new ResourceLocation(CelestialExploration.MODID, "block/mag_rail"));
		singleTexture(ItemRegistry.POWERED_MAG_RAIL.get().getRegistryName().getPath(), new ResourceLocation("item/generated"), "layer0", new ResourceLocation(CelestialExploration.MODID, "block/powered_mag_rail"));
		singleTexture(ItemRegistry.DETECTOR_MAG_RAIL.get().getRegistryName().getPath(), new ResourceLocation("item/generated"), "layer0", new ResourceLocation(CelestialExploration.MODID, "block/detector_mag_rail"));
		singleTexture(ItemRegistry.ACTIVATOR_MAG_RAIL.get().getRegistryName().getPath(), new ResourceLocation("item/generated"), "layer0", new ResourceLocation(CelestialExploration.MODID, "block/activator_mag_rail"));
		singleTexture(ItemRegistry.MAGCART.get().getRegistryName().getPath(), new ResourceLocation("item/generated"), "layer0", new ResourceLocation(CelestialExploration.MODID, "item/magcart"));
		singleTexture(ItemRegistry.CHEST_MAGCART.get().getRegistryName().getPath(), new ResourceLocation("item/generated"), "layer0", new ResourceLocation(CelestialExploration.MODID, "item/chest_magcart"));
		singleTexture(ItemRegistry.COMMAND_BLOCK_MAGCART.get().getRegistryName().getPath(), new ResourceLocation("item/generated"), "layer0", new ResourceLocation(CelestialExploration.MODID, "item/command_block_magcart"));
		singleTexture(ItemRegistry.FURNACE_MAGCART.get().getRegistryName().getPath(), new ResourceLocation("item/generated"), "layer0", new ResourceLocation(CelestialExploration.MODID, "item/furnace_magcart"));
		singleTexture(ItemRegistry.HOPPER_MAGCART.get().getRegistryName().getPath(), new ResourceLocation("item/generated"), "layer0", new ResourceLocation(CelestialExploration.MODID, "item/hopper_magcart"));
		singleTexture(ItemRegistry.TNT_MAGCART.get().getRegistryName().getPath(), new ResourceLocation("item/generated"), "layer0", new ResourceLocation(CelestialExploration.MODID, "item/tnt_magcart"));

		//---- ARMOR -------------------------------------------------------------------------------
		//STEEL
		singleTexture(ItemRegistry.STEEL_HELMET.get().getRegistryName().getPath(), new ResourceLocation("item/generated"), "layer0", new ResourceLocation(CelestialExploration.MODID, "item/steel_helmet"));
		singleTexture(ItemRegistry.STEEL_LEGGINGS.get().getRegistryName().getPath(), new ResourceLocation("item/generated"), "layer0", new ResourceLocation(CelestialExploration.MODID, "item/steel_leggings"));
		singleTexture(ItemRegistry.STEEL_CHESTPLATE.get().getRegistryName().getPath(), new ResourceLocation("item/generated"), "layer0", new ResourceLocation(CelestialExploration.MODID, "item/steel_chestplate"));
		singleTexture(ItemRegistry.STEEL_BOOTS.get().getRegistryName().getPath(), new ResourceLocation("item/generated"), "layer0", new ResourceLocation(CelestialExploration.MODID, "item/steel_boots"));

		//SPACESUIT
		singleTexture(ItemRegistry.BASIC_SPACE_SUIT_HELMET.get().getRegistryName().getPath(), new ResourceLocation("item/generated"), "layer0", new ResourceLocation(CelestialExploration.MODID, "item/basic_space_suit_helmet"));
		singleTexture(ItemRegistry.BASIC_SPACE_SUIT_LEGGINGS.get().getRegistryName().getPath(), new ResourceLocation("item/generated"), "layer0", new ResourceLocation(CelestialExploration.MODID, "item/basic_space_suit_leggings"));
		singleTexture(ItemRegistry.BASIC_SPACE_SUIT_CHESTPLATE.get().getRegistryName().getPath(), new ResourceLocation("item/generated"), "layer0", new ResourceLocation(CelestialExploration.MODID, "item/basic_space_suit_chestplate"));
		singleTexture(ItemRegistry.BASIC_SPACE_SUIT_BOOTS.get().getRegistryName().getPath(), new ResourceLocation("item/generated"), "layer0", new ResourceLocation(CelestialExploration.MODID, "item/basic_space_suit_boots"));
		singleTexture(ItemRegistry.HEAVY_DUTY_SPACE_SUIT_HELMET.get().getRegistryName().getPath(), new ResourceLocation("item/generated"), "layer0", new ResourceLocation(CelestialExploration.MODID, "item/heavy_duty_space_suit_helmet"));
		singleTexture(ItemRegistry.HEAVY_DUTY_SPACE_SUIT_LEGGINGS.get().getRegistryName().getPath(), new ResourceLocation("item/generated"), "layer0", new ResourceLocation(CelestialExploration.MODID, "item/heavy_duty_space_suit_leggings"));
		singleTexture(ItemRegistry.HEAVY_DUTY_SPACE_SUIT_CHESTPLATE.get().getRegistryName().getPath(), new ResourceLocation("item/generated"), "layer0", new ResourceLocation(CelestialExploration.MODID, "item/heavy_duty_space_suit_chestplate"));
		singleTexture(ItemRegistry.HEAVY_DUTY_SPACE_SUIT_BOOTS.get().getRegistryName().getPath(), new ResourceLocation("item/generated"), "layer0", new ResourceLocation(CelestialExploration.MODID, "item/heavy_duty_space_suit_boots"));
		singleTexture(ItemRegistry.THERMAL_SPACE_SUIT_HELMET.get().getRegistryName().getPath(), new ResourceLocation("item/generated"), "layer0", new ResourceLocation(CelestialExploration.MODID, "item/thermal_space_suit_helmet"));
		singleTexture(ItemRegistry.THERMAL_SPACE_SUIT_LEGGINGS.get().getRegistryName().getPath(), new ResourceLocation("item/generated"), "layer0", new ResourceLocation(CelestialExploration.MODID, "item/thermal_space_suit_leggings"));
		singleTexture(ItemRegistry.THERMAL_SPACE_SUIT_CHESTPLATE.get().getRegistryName().getPath(), new ResourceLocation("item/generated"), "layer0", new ResourceLocation(CelestialExploration.MODID, "item/thermal_space_suit_chestplate"));
		singleTexture(ItemRegistry.THERMAL_SPACE_SUIT_BOOTS.get().getRegistryName().getPath(), new ResourceLocation("item/generated"), "layer0", new ResourceLocation(CelestialExploration.MODID, "item/thermal_space_suit_boots"));
		singleTexture(ItemRegistry.ADVANCED_SPACE_SUIT_HELMET.get().getRegistryName().getPath(), new ResourceLocation("item/generated"), "layer0", new ResourceLocation(CelestialExploration.MODID, "item/advanced_space_suit_helmet"));
		singleTexture(ItemRegistry.ADVANCED_SPACE_SUIT_LEGGINGS.get().getRegistryName().getPath(), new ResourceLocation("item/generated"), "layer0", new ResourceLocation(CelestialExploration.MODID, "item/advanced_space_suit_leggings"));
		singleTexture(ItemRegistry.ADVANCED_SPACE_SUIT_CHESTPLATE.get().getRegistryName().getPath(), new ResourceLocation("item/generated"), "layer0", new ResourceLocation(CelestialExploration.MODID, "item/advanced_space_suit_chestplate"));
		singleTexture(ItemRegistry.ADVANCED_SPACE_SUIT_BOOTS.get().getRegistryName().getPath(), new ResourceLocation("item/generated"), "layer0", new ResourceLocation(CelestialExploration.MODID, "item/advanced_space_suit_boots"));


		//---- GLASS/CERAMICS -------------------------------------------------------------------------------
		//GLASS
		withExistingParent(ItemRegistry.LUMINOUS_BLUE_GLASS.get().getRegistryName().getPath(), modLoc("block/luminous_blue_glass"));
		withExistingParent(ItemRegistry.LUMINOUS_WHITE_GLASS.get().getRegistryName().getPath(), modLoc("block/luminous_white_glass"));
		singleTexture(ItemRegistry.LUMINOUS_BLUE_GLASS_PANE.get().getRegistryName().getPath(), new ResourceLocation("item/generated"), "layer0", new ResourceLocation(CelestialExploration.MODID, "block/luminous_blue_glass"));
		singleTexture(ItemRegistry.LUMINOUS_WHITE_GLASS_PANE.get().getRegistryName().getPath(), new ResourceLocation("item/generated"), "layer0", new ResourceLocation(CelestialExploration.MODID, "block/luminous_white_glass"));

		withExistingParent(ItemRegistry.REINFORCED_GLASS.get().getRegistryName().getPath(), modLoc("block/reinforced_glass_inventory"));
		singleTexture(ItemRegistry.REINFORCED_GLASS_PANE.get().getRegistryName().getPath(), new ResourceLocation("item/generated"), "layer0", new ResourceLocation(CelestialExploration.MODID, "block/reinforced_glass"));

		//CERAMIC
		withExistingParent(ItemRegistry.SILICA.get().getRegistryName().getPath(), modLoc("block/silica"));

		withExistingParent(ItemRegistry.CERAMIC.get().getRegistryName().getPath(), modLoc("block/ceramic"));
		singleTexture(ItemRegistry.CERAMIC_TILE.get().getRegistryName().getPath(), new ResourceLocation("item/generated"), "layer0", new ResourceLocation(CelestialExploration.MODID, "block/ceramic"));

		withExistingParent(ItemRegistry.WHITE_CERAMIC.get().getRegistryName().getPath(), modLoc("block/white_ceramic"));
		singleTexture(ItemRegistry.WHITE_CERAMIC_TILE.get().getRegistryName().getPath(), new ResourceLocation("item/generated"), "layer0", new ResourceLocation(CelestialExploration.MODID, "block/white_ceramic"));
		withExistingParent(ItemRegistry.LIGHT_GREY_CERAMIC.get().getRegistryName().getPath(), modLoc("block/light_grey_ceramic"));
		singleTexture(ItemRegistry.LIGHT_GREY_CERAMIC_TILE.get().getRegistryName().getPath(), new ResourceLocation("item/generated"), "layer0", new ResourceLocation(CelestialExploration.MODID, "block/light_grey_ceramic"));
		withExistingParent(ItemRegistry.GREY_CERAMIC.get().getRegistryName().getPath(), modLoc("block/grey_ceramic"));
		singleTexture(ItemRegistry.GREY_CERAMIC_TILE.get().getRegistryName().getPath(), new ResourceLocation("item/generated"), "layer0", new ResourceLocation(CelestialExploration.MODID, "block/grey_ceramic"));
		withExistingParent(ItemRegistry.BLACK_CERAMIC.get().getRegistryName().getPath(), modLoc("block/black_ceramic"));
		singleTexture(ItemRegistry.BLACK_CERAMIC_TILE.get().getRegistryName().getPath(), new ResourceLocation("item/generated"), "layer0", new ResourceLocation(CelestialExploration.MODID, "block/black_ceramic"));
		withExistingParent(ItemRegistry.PURPLE_CERAMIC.get().getRegistryName().getPath(), modLoc("block/purple_ceramic"));
		singleTexture(ItemRegistry.PURPLE_CERAMIC_TILE.get().getRegistryName().getPath(), new ResourceLocation("item/generated"), "layer0", new ResourceLocation(CelestialExploration.MODID, "block/purple_ceramic"));
		withExistingParent(ItemRegistry.MAGENTA_CERAMIC.get().getRegistryName().getPath(), modLoc("block/magenta_ceramic"));
		singleTexture(ItemRegistry.MAGENTA_CERAMIC_TILE.get().getRegistryName().getPath(), new ResourceLocation("item/generated"), "layer0", new ResourceLocation(CelestialExploration.MODID, "block/magenta_ceramic"));
		withExistingParent(ItemRegistry.BLUE_CERAMIC.get().getRegistryName().getPath(), modLoc("block/blue_ceramic"));
		singleTexture(ItemRegistry.BLUE_CERAMIC_TILE.get().getRegistryName().getPath(), new ResourceLocation("item/generated"), "layer0", new ResourceLocation(CelestialExploration.MODID, "block/blue_ceramic"));
		withExistingParent(ItemRegistry.LIGHT_BLUE_CERAMIC.get().getRegistryName().getPath(), modLoc("block/light_blue_ceramic"));
		singleTexture(ItemRegistry.LIGHT_BLUE_CERAMIC_TILE.get().getRegistryName().getPath(), new ResourceLocation("item/generated"), "layer0", new ResourceLocation(CelestialExploration.MODID, "block/light_blue_ceramic"));
		withExistingParent(ItemRegistry.CYAN_CERAMIC.get().getRegistryName().getPath(), modLoc("block/cyan_ceramic"));
		singleTexture(ItemRegistry.CYAN_CERAMIC_TILE.get().getRegistryName().getPath(), new ResourceLocation("item/generated"), "layer0", new ResourceLocation(CelestialExploration.MODID, "block/cyan_ceramic"));
		withExistingParent(ItemRegistry.GREEN_CERAMIC.get().getRegistryName().getPath(), modLoc("block/green_ceramic"));
		singleTexture(ItemRegistry.GREEN_CERAMIC_TILE.get().getRegistryName().getPath(), new ResourceLocation("item/generated"), "layer0", new ResourceLocation(CelestialExploration.MODID, "block/green_ceramic"));
		withExistingParent(ItemRegistry.LIME_CERAMIC.get().getRegistryName().getPath(), modLoc("block/lime_ceramic"));
		singleTexture(ItemRegistry.LIME_CERAMIC_TILE.get().getRegistryName().getPath(), new ResourceLocation("item/generated"), "layer0", new ResourceLocation(CelestialExploration.MODID, "block/lime_ceramic"));
		withExistingParent(ItemRegistry.YELLOW_CERAMIC.get().getRegistryName().getPath(), modLoc("block/yellow_ceramic"));
		singleTexture(ItemRegistry.YELLOW_CERAMIC_TILE.get().getRegistryName().getPath(), new ResourceLocation("item/generated"), "layer0", new ResourceLocation(CelestialExploration.MODID, "block/yellow_ceramic"));
		withExistingParent(ItemRegistry.ORANGE_CERAMIC.get().getRegistryName().getPath(), modLoc("block/orange_ceramic"));
		singleTexture(ItemRegistry.ORANGE_CERAMIC_TILE.get().getRegistryName().getPath(), new ResourceLocation("item/generated"), "layer0", new ResourceLocation(CelestialExploration.MODID, "block/orange_ceramic"));
		withExistingParent(ItemRegistry.BROWN_CERAMIC.get().getRegistryName().getPath(), modLoc("block/brown_ceramic"));
		singleTexture(ItemRegistry.BROWN_CERAMIC_TILE.get().getRegistryName().getPath(), new ResourceLocation("item/generated"), "layer0", new ResourceLocation(CelestialExploration.MODID, "block/brown_ceramic"));
		withExistingParent(ItemRegistry.RED_CERAMIC.get().getRegistryName().getPath(), modLoc("block/red_ceramic"));
		singleTexture(ItemRegistry.RED_CERAMIC_TILE.get().getRegistryName().getPath(), new ResourceLocation("item/generated"), "layer0", new ResourceLocation(CelestialExploration.MODID, "block/red_ceramic"));
		withExistingParent(ItemRegistry.PINK_CERAMIC.get().getRegistryName().getPath(), modLoc("block/pink_ceramic"));
		singleTexture(ItemRegistry.PINK_CERAMIC_TILE.get().getRegistryName().getPath(), new ResourceLocation("item/generated"), "layer0", new ResourceLocation(CelestialExploration.MODID, "block/pink_ceramic"));

//		stairs("ceramic_stairs", modLoc("block/ceramic"), modLoc("block/ceramic"), modLoc("block/ceramic"));
//		slab("ceramic_slab", modLoc("block/ceramic"), modLoc("block/ceramic"), modLoc("block/ceramic"));
//		stairs("white_ceramic_stairs", modLoc("block/white_ceramic"), modLoc("block/white_ceramic"), modLoc("block/white_ceramic"));
//		slab("white_ceramic_slab", modLoc("block/white_ceramic"), modLoc("block/white_ceramic"), modLoc("block/white_ceramic"));
//		stairs("white_ceramic_stairs", modLoc("block/white_ceramic"), modLoc("block/white_ceramic"), modLoc("block/white_ceramic"));
//		slab("light_grey_ceramic_slab", modLoc("block/light_grey_ceramic"), modLoc("block/light_grey_ceramic"), modLoc("block/light_grey_ceramic"));
//		stairs("light_grey_ceramic_stairs", modLoc("block/light_grey_ceramic"), modLoc("block/light_grey_ceramic"), modLoc("block/light_grey_ceramic"));
//		slab("grey_slab_ceramic", modLoc("block/grey_ceramic"), modLoc("block/grey_ceramic"), modLoc("block/grey_ceramic"));
//		stairs("grey_stairs_ceramic", modLoc("block/grey_ceramic"), modLoc("block/grey_ceramic"), modLoc("block/grey_ceramic"));
//		slab("black_ceramic_slab", modLoc("block/black_ceramic"), modLoc("block/black_ceramic"), modLoc("block/black_ceramic"));
//		stairs("black_ceramic_stairs", modLoc("block/black_ceramic"), modLoc("block/black_ceramic"), modLoc("block/black_ceramic"));
//		slab("purple_ceramic_slab", modLoc("block/purple_ceramic"), modLoc("block/purple_ceramic"), modLoc("block/purple_ceramic"));
//		stairs("purple_ceramic_stairs", modLoc("block/purple_ceramic"), modLoc("block/purple_ceramic"), modLoc("block/purple_ceramic"));
//		slab("magenta_ceramic_slab", modLoc("block/magenta_ceramic"), modLoc("block/magenta_ceramic"), modLoc("block/magenta_ceramic"));
//		stairs("magenta_ceramic_stairs", modLoc("block/magenta_ceramic"), modLoc("block/magenta_ceramic"), modLoc("block/magenta_ceramic"));
//		slab("blue_ceramic_slab", modLoc("block/blue_ceramic"), modLoc("block/blue_ceramic"), modLoc("block/blue_ceramic"));
//		stairs("blue_ceramic_stairs", modLoc("block/blue_ceramic"), modLoc("block/blue_ceramic"), modLoc("block/blue_ceramic"));
//		slab("light_blue_ceramic_slab", modLoc("block/light_blue_ceramic"), modLoc("block/light_blue_ceramic"), modLoc("block/light_blue_ceramic"));
//		stairs("light_blue_ceramic_stairs", modLoc("block/light_blue_ceramic"), modLoc("block/light_blue_ceramic"), modLoc("block/light_blue_ceramic"));
//		slab("cyan_ceramic_slab", modLoc("block/cyan_ceramic"), modLoc("block/cyan_ceramic"), modLoc("block/cyan_ceramic"));
//		stairs("cyan_ceramic_stairs", modLoc("block/cyan_ceramic"), modLoc("block/cyan_ceramic"), modLoc("block/cyan_ceramic"));
//		slab("green_ceramic_slab", modLoc("block/green_ceramic"), modLoc("block/green_ceramic"), modLoc("block/green_ceramic"));
//		stairs("green_ceramic_stairs", modLoc("block/green_ceramic"), modLoc("block/green_ceramic"), modLoc("block/green_ceramic"));
//		slab("lime_ceramic_slab", modLoc("block/lime_ceramic"), modLoc("block/lime_ceramic"), modLoc("block/lime_ceramic"));
//		stairs("lime_ceramic_stairs", modLoc("block/lime_ceramic"), modLoc("block/lime_ceramic"), modLoc("block/lime_ceramic"));
//		slab("yellow_ceramic_slab", modLoc("block/yellow_ceramic"), modLoc("block/yellow_ceramic"), modLoc("block/yellow_ceramic"));
//		stairs("yellow_ceramic_stairs", modLoc("block/yellow_ceramic"), modLoc("block/yellow_ceramic"), modLoc("block/yellow_ceramic"));
//		slab("orange_ceramic_slab", modLoc("block/orange_ceramic"), modLoc("block/orange_ceramic"), modLoc("block/orange_ceramic"));
//		stairs("orange_ceramic_stairs", modLoc("block/orange_ceramic"), modLoc("block/orange_ceramic"), modLoc("block/orange_ceramic"));
//		slab("brown_ceramic_slab", modLoc("block/brown_ceramic"), modLoc("block/brown_ceramic"), modLoc("block/brown_ceramic"));
//		stairs("brown_ceramic_stairs", modLoc("block/brown_ceramic"), modLoc("block/brown_ceramic"), modLoc("block/brown_ceramic"));
//		slab("red_ceramic_slab", modLoc("block/red_ceramic"), modLoc("block/red_ceramic"), modLoc("block/red_ceramic"));
//		stairs("red_ceramic_stairs", modLoc("block/red_ceramic"), modLoc("block/red_ceramic"), modLoc("block/red_ceramic"));
//		slab("pink_ceramic_slab", modLoc("block/pink_ceramic"), modLoc("block/pink_ceramic"), modLoc("block/pink_ceramic"));
//		stairs("pink_ceramic_stairs", modLoc("block/pink_ceramic"), modLoc("block/pink_ceramic"), modLoc("block/pink_ceramic"));

		withExistingParent(ItemRegistry.PAINTED_WHITE_CERAMIC.get().getRegistryName().getPath(), modLoc("block/painted_white_ceramic"));
		withExistingParent(ItemRegistry.PAINTED_LIGHT_GREY_CERAMIC.get().getRegistryName().getPath(), modLoc("block/painted_light_grey_ceramic"));
		withExistingParent(ItemRegistry.PAINTED_GREY_CERAMIC.get().getRegistryName().getPath(), modLoc("block/painted_grey_ceramic"));
		withExistingParent(ItemRegistry.PAINTED_BLACK_CERAMIC.get().getRegistryName().getPath(), modLoc("block/painted_black_ceramic"));
		withExistingParent(ItemRegistry.PAINTED_PURPLE_CERAMIC.get().getRegistryName().getPath(), modLoc("block/painted_purple_ceramic"));
		withExistingParent(ItemRegistry.PAINTED_MAGENTA_CERAMIC.get().getRegistryName().getPath(), modLoc("block/painted_magenta_ceramic"));
		withExistingParent(ItemRegistry.PAINTED_BLUE_CERAMIC.get().getRegistryName().getPath(), modLoc("block/painted_blue_ceramic"));
		withExistingParent(ItemRegistry.PAINTED_LIGHT_BLUE_CERAMIC.get().getRegistryName().getPath(), modLoc("block/painted_light_blue_ceramic"));
		withExistingParent(ItemRegistry.PAINTED_CYAN_CERAMIC.get().getRegistryName().getPath(), modLoc("block/painted_cyan_ceramic"));
		withExistingParent(ItemRegistry.PAINTED_GREEN_CERAMIC.get().getRegistryName().getPath(), modLoc("block/painted_green_ceramic"));
		withExistingParent(ItemRegistry.PAINTED_LIME_CERAMIC.get().getRegistryName().getPath(), modLoc("block/painted_lime_ceramic"));
		withExistingParent(ItemRegistry.PAINTED_YELLOW_CERAMIC.get().getRegistryName().getPath(), modLoc("block/painted_yellow_ceramic"));
		withExistingParent(ItemRegistry.PAINTED_ORANGE_CERAMIC.get().getRegistryName().getPath(), modLoc("block/painted_orange_ceramic"));
		withExistingParent(ItemRegistry.PAINTED_BROWN_CERAMIC.get().getRegistryName().getPath(), modLoc("block/painted_brown_ceramic"));
		withExistingParent(ItemRegistry.PAINTED_RED_CERAMIC.get().getRegistryName().getPath(), modLoc("block/painted_red_ceramic"));
		withExistingParent(ItemRegistry.PAINTED_PINK_CERAMIC.get().getRegistryName().getPath(), modLoc("block/painted_pink_ceramic"));

		//---- FOOD -------------------------------------------------------------------------------
		singleTexture(ItemRegistry.MARSHMALLOW_GOO.get().getRegistryName().getPath(), new ResourceLocation("item/generated"), "layer0", new ResourceLocation(CelestialExploration.MODID, "item/marshmallow_goo"));
		singleTexture(ItemRegistry.MARSHMALLOW.get().getRegistryName().getPath(), new ResourceLocation("item/generated"), "layer0", new ResourceLocation(CelestialExploration.MODID, "item/marshmallow"));
		singleTexture(ItemRegistry.ROASTED_MARSHMALLOW.get().getRegistryName().getPath(), new ResourceLocation("item/generated"), "layer0", new ResourceLocation(CelestialExploration.MODID, "item/roasted_marshmallow"));
		singleTexture(ItemRegistry.CHOCOLATE.get().getRegistryName().getPath(), new ResourceLocation("item/generated"), "layer0", new ResourceLocation(CelestialExploration.MODID, "item/chocolate"));
		singleTexture(ItemRegistry.CRACKER.get().getRegistryName().getPath(), new ResourceLocation("item/generated"), "layer0", new ResourceLocation(CelestialExploration.MODID, "item/cracker"));
		singleTexture(ItemRegistry.SMORES.get().getRegistryName().getPath(), new ResourceLocation("item/generated"), "layer0", new ResourceLocation(CelestialExploration.MODID, "item/smores"));

		singleTexture(ItemRegistry.LUNAR_CHEESE.get().getRegistryName().getPath(), new ResourceLocation("item/generated"), "layer0", new ResourceLocation(CelestialExploration.MODID, "item/lunar_cheese"));
		singleTexture(ItemRegistry.CHEESE.get().getRegistryName().getPath(), new ResourceLocation("item/generated"), "layer0", new ResourceLocation(CelestialExploration.MODID, "item/cheese"));

		//---- MISC -------------------------------------------------------------------------------
		//BUCKETS
		singleTexture(FluidRegistry.LOX_BUCKET.get().getRegistryName().getPath(), new ResourceLocation("item/generated"), "layer0", new ResourceLocation(CelestialExploration.MODID, "item/lox_bucket"));
		singleTexture(FluidRegistry.MOLTEN_IRON_BUCKET.get().getRegistryName().getPath(), new ResourceLocation("item/generated"), "layer0", new ResourceLocation("item/lava_bucket"));
		singleTexture(FluidRegistry.MOLTEN_STEEL_BUCKET.get().getRegistryName().getPath(), new ResourceLocation("item/generated"), "layer0", new ResourceLocation("item/lava_bucket"));
		singleTexture(FluidRegistry.MOLTEN_COPPER_BUCKET.get().getRegistryName().getPath(), new ResourceLocation("item/generated"), "layer0", new ResourceLocation("item/lava_bucket"));
		singleTexture(FluidRegistry.MOLTEN_GOLD_BUCKET.get().getRegistryName().getPath(), new ResourceLocation("item/generated"), "layer0", new ResourceLocation("item/lava_bucket"));
//		singleTexture(FluidRegistry.MOLTEN_NETHERITE_BUCKET.get().getRegistryName().getPath(), new ResourceLocation("item/generated"), "layer0", new ResourceLocation("item/lava_bucket"));
		singleTexture(FluidRegistry.MOLTEN_ALUMINUM_BUCKET.get().getRegistryName().getPath(), new ResourceLocation("item/generated"), "layer0", new ResourceLocation("item/lava_bucket"));
		singleTexture(FluidRegistry.SULFUR_BUCKET.get().getRegistryName().getPath(), new ResourceLocation("item/generated"), "layer0", new ResourceLocation("item/lava_bucket"));

		//BLOCKS
		withExistingParent(ItemRegistry.DRY_ICE.get().getRegistryName().getPath(), modLoc("block/dry_ice"));
		withExistingParent(ItemRegistry.COMPRESSED_COBBLESTONE.get().getRegistryName().getPath(), modLoc("block/compressed_cobblestone"));
		withExistingParent(ItemRegistry.COMPRESSED_COBBLED_DEEPSLATE.get().getRegistryName().getPath(), modLoc("block/compressed_cobbled_deepslate"));
		withExistingParent(ItemRegistry.COMPRESSED_NETHERRACK.get().getRegistryName().getPath(), modLoc("block/compressed_netherrack"));

		//ITEMS
		singleTexture(ItemRegistry.MOON_DUST.get().getRegistryName().getPath(), new ResourceLocation("item/generated"), "layer0", new ResourceLocation(CelestialExploration.MODID, "item/moon_dust"));
		singleTexture(ItemRegistry.STEEL_ROD.get().getRegistryName().getPath(), new ResourceLocation("item/handheld"), "layer0", new ResourceLocation(CelestialExploration.MODID, "item/steel_rod"));
		singleTexture(ItemRegistry.STEEL_WOOL.get().getRegistryName().getPath(), new ResourceLocation("item/generated"), "layer0", new ResourceLocation(CelestialExploration.MODID, "item/steel_wool"));
		singleTexture(ItemRegistry.FLARE_ROD.get().getRegistryName().getPath(), new ResourceLocation("item/handheld"), "layer0", new ResourceLocation(CelestialExploration.MODID, "item/flare_rod"));
		singleTexture(ItemRegistry.BLOCK_MOLD.get().getRegistryName().getPath(), new ResourceLocation("item/generated"), "layer0", new ResourceLocation(CelestialExploration.MODID, "item/block_mold"));
		singleTexture(ItemRegistry.INGOT_MOLD.get().getRegistryName().getPath(), new ResourceLocation("item/generated"), "layer0", new ResourceLocation(CelestialExploration.MODID, "item/ingot_mold"));
		singleTexture(ItemRegistry.SULFUR_CRYSTAL.get().getRegistryName().getPath(), new ResourceLocation("item/generated"), "layer0", new ResourceLocation(CelestialExploration.MODID, "item/sulfur_crystal"));
		singleTexture(ItemRegistry.LUNAR_GOO.get().getRegistryName().getPath(), new ResourceLocation("item/generated"), "layer0", new ResourceLocation(CelestialExploration.MODID, "item/lunar_goo"));

	}
}