package com.shim.celestialexploration.datagen;

import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestialexploration.registry.BlockRegistry;
import com.shim.celestialexploration.registry.ItemRegistry;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;


public class ModItemTags extends ItemTagsProvider {

	public ModItemTags(DataGenerator generator, BlockTagsProvider blockTags, ExistingFileHelper helper) {
		super(generator, blockTags, CelestialExploration.MODID, helper);
	}

	@Override
	protected void addTags() {
		tag(Tags.Items.ORES)
				.add(ItemRegistry.MOON_IRON_ORE.get())
				.add(ItemRegistry.MOON_REDSTONE_ORE.get())
				.add(ItemRegistry.MOON_DEEPSLATE_IRON_ORE.get())
				.add(ItemRegistry.MOON_DEEPSLATE_REDSTONE_ORE.get())
				.add(ItemRegistry.MARS_DEEPSLATE_IRON_ORE.get())
				.add(ItemRegistry.MARS_DEEPSLATE_REDSTONE_ORE.get())

				.add(ItemRegistry.MARS_REDSTONE_ORE.get())
				.add(ItemRegistry.MARS_IRON_ORE.get())
				.add(ItemRegistry.METEOR_COAL_ORE.get())
				.add(ItemRegistry.METEOR_COPPER_ORE.get())
				.add(ItemRegistry.METEOR_DIAMOND_ORE.get())
				.add(ItemRegistry.METEOR_EMERALD_ORE.get())
				.add(ItemRegistry.METEOR_GOLD_ORE.get())
				.add(ItemRegistry.METEOR_IRON_ORE.get())
				.add(ItemRegistry.METEOR_LAPIS_ORE.get())
				.add(ItemRegistry.METEOR_REDSTONE_ORE.get())

				.add(ItemRegistry.VENUS_DEEPSLATE_REDSTONE_ORE.get())
				.add(ItemRegistry.VENUS_DEEPSLATE_IRON_ORE.get())
				.add(ItemRegistry.VENUS_DEEPSLATE_LAPIS_ORE.get())

				.add(ItemRegistry.VENUS_REDSTONE_ORE.get())
				.add(ItemRegistry.VENUS_IRON_ORE.get())
				.add(ItemRegistry.VENUS_LAPIS_ORE.get())

		;

		tag(Tags.Items.SAND)
				.add(ItemRegistry.GLOWING_MOON_SAND.get())
//				.add(ItemRegistry.COARSE_MOON_SAND.get())
//				.add(ItemRegistry.COARSE_MARS_SAND.get())
				.add(ItemRegistry.MARS_SAND.get())
				.add(ItemRegistry.MOON_SAND.get())
				.add(ItemRegistry.VENUS_SAND.get())
		;

		tag(ItemTags.SAND)
				.add(ItemRegistry.GLOWING_MOON_SAND.get())
//				.add(ItemRegistry.COARSE_MOON_SAND.get())
//				.add(ItemRegistry.COARSE_MARS_SAND.get())
				.add(ItemRegistry.MARS_SAND.get())
				.add(ItemRegistry.MOON_SAND.get())
				.add(ItemRegistry.VENUS_SAND.get())
		;

		tag(ItemTags.DIRT)
				.add(ItemRegistry.COARSE_MOON_SAND.get())
				.add(ItemRegistry.COARSE_MARS_SAND.get())
//				.add(ItemRegistry.COARSE_VENUS_SAND.get())
		;

		tag(Tags.Items.STONE)
				.add(ItemRegistry.MARS_STONE.get())
				.add(ItemRegistry.METEOR.get())
//				.add(ItemRegistry.MARS_COBBLESTONE.get())
//				.add(ItemRegistry.MARS_DEEPSLATE.get())
//				.add(ItemRegistry.MARS_COBBLED_DEEPSLATE.get())
//				.add(ItemRegistry.MARS_STONE_SLAB.get())
//				.add(ItemRegistry.MARS_COBBLESTONE_SLAB.get())
//				.add(ItemRegistry.MARS_COBBLESTONE_STAIRS.get())
//				.add(ItemRegistry.MARS_COBBLESTONE_WALL.get())
//				.add(ItemRegistry.MARS_COBBLED_DEEPSLATE_SLAB.get())
//				.add(ItemRegistry.MARS_COBBLED_DEEPSLATE_STAIRS.get())
//				.add(ItemRegistry.MARS_COBBLED_DEEPSLATE_WALL.get())
				.add(ItemRegistry.MARS_SMOOTH_STONE.get())
//				.add(ItemRegistry.MARS_SMOOTH_STONE_SLAB.get())
//				.add(ItemRegistry.CRACKED_MARS_BRICKS.get())
//				.add(ItemRegistry.CRACKED_MARS_DEEPSLATE_BRICKS.get())
//				.add(ItemRegistry.CRACKED_MARS_DEEPSLATE_TILES.get())
//				.add(ItemRegistry.CHISELED_MARS_DEEPSLATE_BRICKS.get())
//				.add(ItemRegistry.MARS_DEEPSLATE_BRICKS.get())
//				.add(ItemRegistry.MARS_DEEPSLATE_BRICK_SLAB.get())
//				.add(ItemRegistry.MARS_DEEPSLATE_BRICK_STAIRS.get())
//				.add(ItemRegistry.MARS_DEEPSLATE_BRICK_WALL.get())
//				.add(ItemRegistry.MARS_DEEPSLATE_TILES.get())
//				.add(ItemRegistry.MARS_DEEPSLATE_TILE_SLAB.get())
//				.add(ItemRegistry.MARS_DEEPSLATE_TILE_STAIRS.get())
//				.add(ItemRegistry.MARS_DEEPSLATE_TILE_WALL.get())
//				.add(ItemRegistry.MARS_POLISHED_DEEPSLATE.get())
//				.add(ItemRegistry.MARS_POLISHED_DEEPSLATE_SLAB.get())
//				.add(ItemRegistry.MARS_POLISHED_DEEPSLATE_STAIRS.get())
//				.add(ItemRegistry.MARS_POLISHED_DEEPSLATE_WALL.get())
				.add(ItemRegistry.MOON_STONE.get())
//				.add(ItemRegistry.MOON_BRICK_SLAB.get())
//				.add(ItemRegistry.MOON_BRICK_STAIRS.get())
//				.add(ItemRegistry.MOON_BRICK_WALL.get())
//				.add(ItemRegistry.MOON_BRICKS.get())
//				.add(ItemRegistry.CHISELED_MOON_BRICKS.get())
//				.add(ItemRegistry.MOON_IRON_ORE.get())
//				.add(ItemRegistry.MOON_REDSTONE_ORE.get())
//				.add(ItemRegistry.MOON_DEEPSLATE_IRON_ORE.get())
//				.add(ItemRegistry.MOON_DEEPSLATE_REDSTONE_ORE.get())
//				.add(ItemRegistry.MARS_DEEPSLATE_IRON_ORE.get())
//				.add(ItemRegistry.MARS_DEEPSLATE_REDSTONE_ORE.get())
//				.add(ItemRegistry.MOON_BRICK_PILLAR.get())
//				.add(ItemRegistry.MOON_DEEPSLATE.get())
//				.add(ItemRegistry.MOON_COBBLED_DEEPSLATE.get())
//				.add(ItemRegistry.MOON_COBBLESTONE.get())
//				.add(ItemRegistry.MOON_STONE_SLAB.get())
//				.add(ItemRegistry.MOON_COBBLESTONE_SLAB.get())
//				.add(ItemRegistry.MOON_COBBLESTONE_STAIRS.get())
//				.add(ItemRegistry.MOON_COBBLESTONE_WALL.get())
//				.add(ItemRegistry.MOON_COBBLED_DEEPSLATE_SLAB.get())
//				.add(ItemRegistry.MOON_COBBLED_DEEPSLATE_STAIRS.get())
//				.add(ItemRegistry.MOON_COBBLED_DEEPSLATE_WALL.get())
				.add(ItemRegistry.MOON_SMOOTH_STONE.get())
//				.add(ItemRegistry.MOON_SMOOTH_STONE_SLAB.get())
//				.add(ItemRegistry.CRACKED_MOON_BRICKS.get())
//				.add(ItemRegistry.CRACKED_MOON_DEEPSLATE_BRICKS.get())
//				.add(ItemRegistry.CRACKED_MOON_DEEPSLATE_TILES.get())
//				.add(ItemRegistry.CHISELED_MOON_DEEPSLATE_BRICKS.get())
//				.add(ItemRegistry.MOON_DEEPSLATE_BRICKS.get())
//				.add(ItemRegistry.MOON_DEEPSLATE_BRICK_SLAB.get())
//				.add(ItemRegistry.MOON_DEEPSLATE_BRICK_STAIRS.get())
//				.add(ItemRegistry.MOON_DEEPSLATE_BRICK_WALL.get())
//				.add(ItemRegistry.MOON_DEEPSLATE_TILES.get())
//				.add(ItemRegistry.MOON_DEEPSLATE_TILE_SLAB.get())
//				.add(ItemRegistry.MOON_DEEPSLATE_TILE_STAIRS.get())
//				.add(ItemRegistry.MOON_DEEPSLATE_TILE_WALL.get())
//				.add(ItemRegistry.MOON_POLISHED_DEEPSLATE.get())
//				.add(ItemRegistry.MOON_POLISHED_DEEPSLATE_SLAB.get())
//				.add(ItemRegistry.MOON_POLISHED_DEEPSLATE_STAIRS.get())
//				.add(ItemRegistry.MOON_POLISHED_DEEPSLATE_WALL.get())
				.add(ItemRegistry.VENUS_STONE.get())
		;

		tag(Tags.Items.COBBLESTONE)
				.add(ItemRegistry.MARS_COBBLESTONE.get())
//				.add(ItemRegistry.MARS_COBBLESTONE_SLAB.get())
//				.add(ItemRegistry.MARS_COBBLESTONE_STAIRS.get())
//				.add(ItemRegistry.MARS_COBBLESTONE_WALL.get())
				.add(ItemRegistry.MOON_COBBLESTONE.get())
//				.add(ItemRegistry.MOON_COBBLESTONE_SLAB.get())
//				.add(ItemRegistry.MOON_COBBLESTONE_STAIRS.get())
//				.add(ItemRegistry.MOON_COBBLESTONE_WALL.get())
				.add(ItemRegistry.VENUS_COBBLESTONE.get())
		;

//		tag(Tags.Items.COBBLESTONE_DEEPSLATE)
//				.add(ItemRegistry.MARS_COBBLED_DEEPSLATE.get())
////				.add(ItemRegistry.MARS_COBBLED_DEEPSLATE_SLAB.get())
////				.add(ItemRegistry.MARS_COBBLED_DEEPSLATE_STAIRS.get())
////				.add(ItemRegistry.MARS_COBBLED_DEEPSLATE_WALL.get())
//				.add(ItemRegistry.MOON_COBBLED_DEEPSLATE.get())
////				.add(ItemRegistry.MOON_COBBLED_DEEPSLATE_SLAB.get())
////				.add(ItemRegistry.MOON_COBBLED_DEEPSLATE_STAIRS.get())
////				.add(ItemRegistry.MOON_COBBLED_DEEPSLATE_WALL.get())
//				.add(ItemRegistry.VENUS_COBBLED_DEEPSLATE.get())
//		;

		tag(Tags.Items.ORES_COAL)
				.add(ItemRegistry.METEOR_COAL_ORE.get());

		tag(Tags.Items.ORES_COPPER)
				.add(ItemRegistry.METEOR_COPPER_ORE.get());

		tag(Tags.Items.ORES_DIAMOND)
				.add(ItemRegistry.METEOR_DIAMOND_ORE.get());

		tag(Tags.Items.ORES_EMERALD)
				.add(ItemRegistry.METEOR_EMERALD_ORE.get());

		tag(Tags.Items.ORES_GOLD)
				.add(ItemRegistry.METEOR_GOLD_ORE.get())

		;

		tag(Tags.Items.ORES_IRON)
				.add(ItemRegistry.MARS_IRON_ORE.get())
				.add(ItemRegistry.METEOR_IRON_ORE.get())
				.add(ItemRegistry.MOON_IRON_ORE.get())
				.add(ItemRegistry.MOON_DEEPSLATE_IRON_ORE.get())
				.add(ItemRegistry.MARS_DEEPSLATE_IRON_ORE.get())
				.add(ItemRegistry.VENUS_IRON_ORE.get())
				.add(ItemRegistry.VENUS_DEEPSLATE_IRON_ORE.get())
		;

		tag(Tags.Items.ORES_LAPIS)
				.add(ItemRegistry.METEOR_LAPIS_ORE.get())
				.add(ItemRegistry.VENUS_LAPIS_ORE.get())
				.add(ItemRegistry.VENUS_DEEPSLATE_LAPIS_ORE.get())
		;

		tag(Tags.Items.GLASS)
				.add(ItemRegistry.LUMINOUS_BLUE_GLASS.get())
//				.add(ItemRegistry.LUMINOUS_BLUE_GLASS_PANE.get())
				.add(ItemRegistry.LUMINOUS_WHITE_GLASS.get())
				.add(ItemRegistry.REINFORCED_GLASS.get())
//				.add(ItemRegistry.LUMINOUS_WHITE_GLASS_PANE.get())
	 			;

		tag(Tags.Items.GLASS_PANES)
				.add(ItemRegistry.LUMINOUS_BLUE_GLASS_PANE.get())
				.add(ItemRegistry.LUMINOUS_WHITE_GLASS_PANE.get())
				.add(ItemRegistry.REINFORCED_GLASS_PANE.get());

		tag(Tags.Items.ORES_REDSTONE)
				.add(ItemRegistry.MARS_REDSTONE_ORE.get())
				.add(ItemRegistry.MOON_REDSTONE_ORE.get())
				.add(ItemRegistry.METEOR_REDSTONE_ORE.get())
				.add(ItemRegistry.MOON_DEEPSLATE_REDSTONE_ORE.get())
				.add(ItemRegistry.MARS_DEEPSLATE_REDSTONE_ORE.get())
				.add(ItemRegistry.VENUS_REDSTONE_ORE.get())
				.add(ItemRegistry.VENUS_DEEPSLATE_REDSTONE_ORE.get())
		;

		tag(ItemRegistry.MOON_TAG)
				.add(ItemRegistry.MOON_STONE.get())
				.add(ItemRegistry.MOON_BRICK_SLAB.get())
				.add(ItemRegistry.MOON_BRICK_STAIRS.get())
				.add(ItemRegistry.MOON_BRICK_WALL.get())
				.add(ItemRegistry.MOON_BRICKS.get())
				.add(ItemRegistry.CHISELED_MOON_BRICKS.get())
				.add(ItemRegistry.MOON_IRON_ORE.get())
				.add(ItemRegistry.MOON_REDSTONE_ORE.get())
				.add(ItemRegistry.MOON_SAND.get())
				.add(ItemRegistry.GLOWING_MOON_SAND.get())
				.add(ItemRegistry.COARSE_MOON_SAND.get())
				.add(ItemRegistry.MOON_BRICK_PILLAR.get())
				.add(ItemRegistry.MOON_DEEPSLATE_IRON_ORE.get())
				.add(ItemRegistry.MOON_DEEPSLATE_REDSTONE_ORE.get())
				.add(ItemRegistry.MOON_DEEPSLATE.get())
				.add(ItemRegistry.MOON_COBBLED_DEEPSLATE.get())
				.add(ItemRegistry.MOON_COBBLESTONE.get())
				.add(ItemRegistry.MOON_STONE_SLAB.get())
				.add(ItemRegistry.MOON_COBBLESTONE_SLAB.get())
				.add(ItemRegistry.MOON_COBBLESTONE_STAIRS.get())
				.add(ItemRegistry.MOON_COBBLESTONE_WALL.get())
				.add(ItemRegistry.MOON_COBBLED_DEEPSLATE_SLAB.get())
				.add(ItemRegistry.MOON_COBBLED_DEEPSLATE_STAIRS.get())
				.add(ItemRegistry.MOON_COBBLED_DEEPSLATE_WALL.get())
				.add(ItemRegistry.MOON_SMOOTH_STONE.get())
//				.add(ItemRegistry.MOON_SMOOTH_STONE_SLAB.get())
				.add(ItemRegistry.CRACKED_MOON_BRICKS.get())
				.add(ItemRegistry.CRACKED_MOON_DEEPSLATE_BRICKS.get())
				.add(ItemRegistry.CRACKED_MOON_DEEPSLATE_TILES.get())
				.add(ItemRegistry.CHISELED_MOON_DEEPSLATE_BRICKS.get())
				.add(ItemRegistry.MOON_DEEPSLATE_BRICKS.get())
				.add(ItemRegistry.MOON_DEEPSLATE_BRICK_SLAB.get())
				.add(ItemRegistry.MOON_DEEPSLATE_BRICK_STAIRS.get())
				.add(ItemRegistry.MOON_DEEPSLATE_BRICK_WALL.get())
				.add(ItemRegistry.MOON_DEEPSLATE_TILES.get())
				.add(ItemRegistry.MOON_DEEPSLATE_TILE_SLAB.get())
				.add(ItemRegistry.MOON_DEEPSLATE_TILE_STAIRS.get())
				.add(ItemRegistry.MOON_DEEPSLATE_TILE_WALL.get())
				.add(ItemRegistry.MOON_POLISHED_DEEPSLATE.get())
				.add(ItemRegistry.MOON_POLISHED_DEEPSLATE_SLAB.get())
				.add(ItemRegistry.MOON_POLISHED_DEEPSLATE_STAIRS.get())
				.add(ItemRegistry.MOON_POLISHED_DEEPSLATE_WALL.get());

		tag(ItemRegistry.MOON_STONE_TAG)
				.add(ItemRegistry.MOON_STONE.get())
//				.add(ItemRegistry.MOON_BRICK_SLAB.get())
//				.add(ItemRegistry.MOON_BRICK_STAIRS.get())
//				.add(ItemRegistry.MOON_BRICK_WALL.get())
				.add(ItemRegistry.MOON_BRICKS.get())
				.add(ItemRegistry.CHISELED_MOON_BRICKS.get())
				.add(ItemRegistry.MOON_BRICK_PILLAR.get())
//				.add(ItemRegistry.MOON_STONE_SLAB.get())
				.add(ItemRegistry.MOON_SMOOTH_STONE.get())
//				.add(ItemRegistry.MOON_SMOOTH_STONE_SLAB.get())
				.add(ItemRegistry.CRACKED_MOON_BRICKS.get());

		tag(ItemRegistry.MOON_COBBLESTONE_TAG)
				.add(ItemRegistry.MOON_COBBLESTONE.get())
//				.add(ItemRegistry.MOON_COBBLESTONE_SLAB.get())
//				.add(ItemRegistry.MOON_COBBLESTONE_STAIRS.get())
//				.add(ItemRegistry.MOON_COBBLESTONE_WALL.get())
				;

		tag(ItemRegistry.MOON_DEEPSLATE_TAG)
				.add(ItemRegistry.MOON_DEEPSLATE.get())
				.add(ItemRegistry.CRACKED_MOON_DEEPSLATE_BRICKS.get())
				.add(ItemRegistry.CRACKED_MOON_DEEPSLATE_TILES.get())
				.add(ItemRegistry.CHISELED_MOON_DEEPSLATE_BRICKS.get())
				.add(ItemRegistry.MOON_DEEPSLATE_BRICKS.get())
				.add(ItemRegistry.MOON_DEEPSLATE_TILES.get())
				.add(ItemRegistry.MOON_POLISHED_DEEPSLATE.get())
				;

		tag(ItemRegistry.MOON_COBBLED_DEEPSLATE_TAG)
				.add(ItemRegistry.MOON_COBBLED_DEEPSLATE.get())
//				.add(ItemRegistry.MOON_COBBLED_DEEPSLATE_SLAB.get())
//				.add(ItemRegistry.MOON_COBBLED_DEEPSLATE_STAIRS.get())
//				.add(ItemRegistry.MOON_COBBLED_DEEPSLATE_WALL.get())
		;

		tag(ItemRegistry.MARS_TAG)
				.add(ItemRegistry.MARS_STONE.get())
				.add(ItemRegistry.MARS_BRICK_SLAB.get())
				.add(ItemRegistry.MARS_BRICK_STAIRS.get())
				.add(ItemRegistry.MARS_BRICK_WALL.get())
				.add(ItemRegistry.MARS_BRICKS.get())
				.add(ItemRegistry.CHISELED_MARS_BRICKS.get())
				.add(ItemRegistry.MARS_IRON_ORE.get())
				.add(ItemRegistry.MARS_REDSTONE_ORE.get())
				.add(ItemRegistry.MARS_SAND.get())
				.add(ItemRegistry.COARSE_MARS_SAND.get())
				.add(ItemRegistry.MARS_BRICK_PILLAR.get())
				.add(ItemRegistry.MARS_DEEPSLATE.get())
				.add(ItemRegistry.MARS_COBBLED_DEEPSLATE.get())
				.add(ItemRegistry.MARS_COBBLESTONE.get())
				.add(ItemRegistry.MARS_STONE_SLAB.get())
				.add(ItemRegistry.MARS_COBBLESTONE_SLAB.get())
				.add(ItemRegistry.MARS_COBBLESTONE_STAIRS.get())
				.add(ItemRegistry.MARS_COBBLESTONE_WALL.get())
				.add(ItemRegistry.MARS_COBBLED_DEEPSLATE_SLAB.get())
				.add(ItemRegistry.MARS_COBBLED_DEEPSLATE_STAIRS.get())
				.add(ItemRegistry.MARS_COBBLED_DEEPSLATE_WALL.get())
				.add(ItemRegistry.MARS_DEEPSLATE_IRON_ORE.get())
				.add(ItemRegistry.MARS_DEEPSLATE_REDSTONE_ORE.get())

				.add(ItemRegistry.MARS_SMOOTH_STONE.get())
//				.add(ItemRegistry.MARS_SMOOTH_STONE_SLAB.get())
				.add(ItemRegistry.CRACKED_MARS_BRICKS.get())
				.add(ItemRegistry.CRACKED_MARS_DEEPSLATE_BRICKS.get())
				.add(ItemRegistry.CRACKED_MARS_DEEPSLATE_TILES.get())
				.add(ItemRegistry.CHISELED_MARS_DEEPSLATE_BRICKS.get())
				.add(ItemRegistry.MARS_DEEPSLATE_BRICKS.get())
				.add(ItemRegistry.MARS_DEEPSLATE_BRICK_SLAB.get())
				.add(ItemRegistry.MARS_DEEPSLATE_BRICK_STAIRS.get())
				.add(ItemRegistry.MARS_DEEPSLATE_BRICK_WALL.get())
				.add(ItemRegistry.MARS_DEEPSLATE_TILES.get())
				.add(ItemRegistry.MARS_DEEPSLATE_TILE_SLAB.get())
				.add(ItemRegistry.MARS_DEEPSLATE_TILE_STAIRS.get())
				.add(ItemRegistry.MARS_DEEPSLATE_TILE_WALL.get())
				.add(ItemRegistry.MARS_POLISHED_DEEPSLATE.get())
				.add(ItemRegistry.MARS_POLISHED_DEEPSLATE_SLAB.get())
				.add(ItemRegistry.MARS_POLISHED_DEEPSLATE_STAIRS.get())
				.add(ItemRegistry.MARS_POLISHED_DEEPSLATE_WALL.get());

		tag(ItemRegistry.MARS_STONE_TAG)
				.add(ItemRegistry.MARS_STONE.get())
//				.add(ItemRegistry.MARS_BRICK_SLAB.get())
//				.add(ItemRegistry.MARS_BRICK_STAIRS.get())
//				.add(ItemRegistry.MARS_BRICK_WALL.get())
				.add(ItemRegistry.MARS_BRICKS.get())
				.add(ItemRegistry.CHISELED_MARS_BRICKS.get())
				.add(ItemRegistry.MARS_BRICK_PILLAR.get())
//				.add(ItemRegistry.MARS_STONE_SLAB.get())
				.add(ItemRegistry.MARS_SMOOTH_STONE.get())
//				.add(ItemRegistry.MARS_SMOOTH_STONE_SLAB.get())
				.add(ItemRegistry.CRACKED_MARS_BRICKS.get());

		tag(ItemRegistry.MARS_COBBLESTONE_TAG)
				.add(ItemRegistry.MARS_COBBLESTONE.get())
//				.add(ItemRegistry.MARS_COBBLESTONE_SLAB.get())
//				.add(ItemRegistry.MARS_COBBLESTONE_STAIRS.get())
//				.add(ItemRegistry.MARS_COBBLESTONE_WALL.get())
		;

		tag(ItemRegistry.MARS_DEEPSLATE_TAG)
				.add(ItemRegistry.MARS_DEEPSLATE.get())
				.add(ItemRegistry.CRACKED_MARS_DEEPSLATE_BRICKS.get())
				.add(ItemRegistry.CRACKED_MARS_DEEPSLATE_TILES.get())
				.add(ItemRegistry.CHISELED_MARS_DEEPSLATE_BRICKS.get())
				.add(ItemRegistry.MARS_DEEPSLATE_BRICKS.get())
				.add(ItemRegistry.MARS_DEEPSLATE_TILES.get())
				.add(ItemRegistry.MARS_POLISHED_DEEPSLATE.get())
		;

		tag(ItemRegistry.MARS_COBBLED_DEEPSLATE_TAG)
				.add(ItemRegistry.MARS_COBBLED_DEEPSLATE.get())
		;

		tag(ItemRegistry.VENUS_TAG)
				.add(ItemRegistry.VENUS_STONE.get())
				.add(ItemRegistry.VENUS_BRICK_SLAB.get())
				.add(ItemRegistry.VENUS_BRICK_STAIRS.get())
				.add(ItemRegistry.VENUS_BRICK_WALL.get())
				.add(ItemRegistry.VENUS_BRICKS.get())
				.add(ItemRegistry.CHISELED_VENUS_BRICKS.get())
				.add(ItemRegistry.VENUS_IRON_ORE.get())
				.add(ItemRegistry.VENUS_REDSTONE_ORE.get())
				.add(ItemRegistry.VENUS_SAND.get())
				.add(ItemRegistry.FINE_VENUS_SAND.get())
//				.add(ItemRegistry.VENUS_BRICK_PILLAR.get())
				.add(ItemRegistry.VENUS_DEEPSLATE.get())
				.add(ItemRegistry.VENUS_COBBLED_DEEPSLATE.get())
				.add(ItemRegistry.VENUS_COBBLESTONE.get())
				.add(ItemRegistry.VENUS_STONE_SLAB.get())
				.add(ItemRegistry.VENUS_COBBLESTONE_SLAB.get())
				.add(ItemRegistry.VENUS_COBBLESTONE_STAIRS.get())
				.add(ItemRegistry.VENUS_COBBLESTONE_WALL.get())
				.add(ItemRegistry.VENUS_COBBLED_DEEPSLATE_SLAB.get())
				.add(ItemRegistry.VENUS_COBBLED_DEEPSLATE_STAIRS.get())
				.add(ItemRegistry.VENUS_COBBLED_DEEPSLATE_WALL.get())
				.add(ItemRegistry.VENUS_DEEPSLATE_IRON_ORE.get())
				.add(ItemRegistry.VENUS_DEEPSLATE_REDSTONE_ORE.get())

//				.add(ItemRegistry.VENUS_SMOOTH_STONE.get())
//				.add(ItemRegistry.VENUS_SMOOTH_STONE_SLAB.get())
//				.add(ItemRegistry.CRACKED_VENUS_BRICKS.get())
//				.add(ItemRegistry.CRACKED_VENUS_DEEPSLATE_BRICKS.get())
//				.add(ItemRegistry.CRACKED_VENUS_DEEPSLATE_TILES.get())
//				.add(ItemRegistry.CHISELED_VENUS_DEEPSLATE_BRICKS.get())
				.add(ItemRegistry.VENUS_DEEPSLATE_BRICKS.get())
				.add(ItemRegistry.VENUS_DEEPSLATE_BRICK_SLAB.get())
				.add(ItemRegistry.VENUS_DEEPSLATE_BRICK_STAIRS.get())
				.add(ItemRegistry.VENUS_DEEPSLATE_BRICK_WALL.get())
				.add(ItemRegistry.VENUS_DEEPSLATE_TILES.get())
				.add(ItemRegistry.VENUS_DEEPSLATE_TILE_SLAB.get())
				.add(ItemRegistry.VENUS_DEEPSLATE_TILE_STAIRS.get())
				.add(ItemRegistry.VENUS_DEEPSLATE_TILE_WALL.get())
				.add(ItemRegistry.VENUS_POLISHED_DEEPSLATE.get())
				.add(ItemRegistry.VENUS_POLISHED_DEEPSLATE_SLAB.get())
				.add(ItemRegistry.VENUS_POLISHED_DEEPSLATE_STAIRS.get())
				.add(ItemRegistry.VENUS_POLISHED_DEEPSLATE_WALL.get());

		tag(ItemRegistry.VENUS_STONE_TAG)
				.add(ItemRegistry.VENUS_STONE.get())
				.add(ItemRegistry.VENUS_BRICKS.get())
				.add(ItemRegistry.CHISELED_VENUS_BRICKS.get())
//				.add(ItemRegistry.VENUS_BRICK_PILLAR.get())
//				.add(ItemRegistry.VENUS_SMOOTH_STONE.get())
//				.add(ItemRegistry.CRACKED_VENUS_BRICKS.get());
		;

		tag(ItemRegistry.VENUS_COBBLESTONE_TAG)
				.add(ItemRegistry.VENUS_COBBLESTONE.get())
		;

		tag(ItemRegistry.VENUS_DEEPSLATE_TAG)
				.add(ItemRegistry.VENUS_DEEPSLATE.get())
//				.add(ItemRegistry.CRACKED_VENUS_DEEPSLATE_BRICKS.get())
//				.add(ItemRegistry.CRACKED_VENUS_DEEPSLATE_TILES.get())
//				.add(ItemRegistry.CHISELED_VENUS_DEEPSLATE_BRICKS.get())
				.add(ItemRegistry.VENUS_DEEPSLATE_BRICKS.get())
				.add(ItemRegistry.VENUS_DEEPSLATE_TILES.get())
				.add(ItemRegistry.VENUS_POLISHED_DEEPSLATE.get())
		;

		tag(ItemRegistry.VENUS_COBBLED_DEEPSLATE_TAG)
				.add(ItemRegistry.VENUS_COBBLED_DEEPSLATE.get())
		;


		tag(ItemRegistry.METEOR_TAG)
				.add(ItemRegistry.METEOR.get())
//				.add(ItemRegistry.METEOR_BRICK_SLAB.get())
//				.add(ItemRegistry.METEOR_BRICK_STAIRS.get())
//				.add(ItemRegistry.METEOR_BRICK_WALL.get())
				.add(ItemRegistry.METEOR_BRICKS.get())
				.add(ItemRegistry.CHISELED_METEOR_BRICKS.get())
				.add(ItemRegistry.METEOR_REDSTONE_ORE.get())
//				.add(ItemRegistry.METEOR_GOLD_ORE.get())
//				.add(ItemRegistry.METEOR_DIAMOND_ORE.get())
//				.add(ItemRegistry.METEOR_LAPIS_ORE.get())
//				.add(ItemRegistry.METEOR_EMERALD_ORE.get())
//				.add(ItemRegistry.METEOR_COPPER_ORE.get())
//				.add(ItemRegistry.METEOR_COAL_ORE.get())
//				.add(ItemRegistry.METEOR_IRON_ORE.get());
		;

		tag(Tags.Items.GLASS)
				.add(ItemRegistry.LUMINOUS_WHITE_GLASS.get())
				.add(ItemRegistry.LUMINOUS_BLUE_GLASS.get())
				.add(ItemRegistry.REINFORCED_GLASS.get());

		tag(Tags.Items.GLASS_PANES)
				.add(ItemRegistry.LUMINOUS_BLUE_GLASS_PANE.get())
				.add(ItemRegistry.LUMINOUS_WHITE_GLASS_PANE.get())
				.add(ItemRegistry.REINFORCED_GLASS_PANE.get());

		tag(Tags.Items.GLASS_COLORLESS)
				.add(ItemRegistry.REINFORCED_GLASS.get());

		tag(Tags.Items.GLASS_BLUE)
				.add(ItemRegistry.LUMINOUS_BLUE_GLASS.get());

		tag(Tags.Items.GLASS_WHITE)
				.add(ItemRegistry.LUMINOUS_WHITE_GLASS.get());

		tag(Tags.Items.GLASS_PANES_BLUE)
				.add(ItemRegistry.LUMINOUS_BLUE_GLASS_PANE.get());

		tag(Tags.Items.GLASS_PANES_WHITE)
				.add(ItemRegistry.LUMINOUS_WHITE_GLASS_PANE.get());

		tag(ItemRegistry.DYED_CERAMIC_TAG)
				.add(ItemRegistry.WHITE_CERAMIC.get())
				.add(ItemRegistry.LIGHT_GREY_CERAMIC.get())
				.add(ItemRegistry.GREY_CERAMIC.get())
				.add(ItemRegistry.BLACK_CERAMIC.get())
				.add(ItemRegistry.PURPLE_CERAMIC.get())
				.add(ItemRegistry.MAGENTA_CERAMIC.get())
				.add(ItemRegistry.BLUE_CERAMIC.get())
				.add(ItemRegistry.LIGHT_BLUE_CERAMIC.get())
				.add(ItemRegistry.CYAN_CERAMIC.get())
				.add(ItemRegistry.GREEN_CERAMIC.get())
				.add(ItemRegistry.LIME_CERAMIC.get())
				.add(ItemRegistry.YELLOW_CERAMIC.get())
				.add(ItemRegistry.ORANGE_CERAMIC.get())
				.add(ItemRegistry.BROWN_CERAMIC.get())
				.add(ItemRegistry.RED_CERAMIC.get())
				.add(ItemRegistry.PINK_CERAMIC.get());

		tag(ItemRegistry.DYED_CERAMIC_TILE_TAG)
                .add(ItemRegistry.WHITE_CERAMIC_TILE.get())
                .add(ItemRegistry.LIGHT_GREY_CERAMIC_TILE.get())
                .add(ItemRegistry.GREY_CERAMIC_TILE.get())
                .add(ItemRegistry.BLACK_CERAMIC_TILE.get())
                .add(ItemRegistry.PURPLE_CERAMIC_TILE.get())
                .add(ItemRegistry.MAGENTA_CERAMIC_TILE.get())
                .add(ItemRegistry.BLUE_CERAMIC_TILE.get())
                .add(ItemRegistry.LIGHT_BLUE_CERAMIC_TILE.get())
                .add(ItemRegistry.CYAN_CERAMIC_TILE.get())
                .add(ItemRegistry.GREEN_CERAMIC_TILE.get())
                .add(ItemRegistry.LIME_CERAMIC_TILE.get())
                .add(ItemRegistry.YELLOW_CERAMIC_TILE.get())
                .add(ItemRegistry.ORANGE_CERAMIC_TILE.get())
                .add(ItemRegistry.BROWN_CERAMIC_TILE.get())
                .add(ItemRegistry.RED_CERAMIC_TILE.get())
                .add(ItemRegistry.PINK_CERAMIC_TILE.get());

		tag(ItemRegistry.PAINTED_CERAMIC_TAG)
				.add(ItemRegistry.PAINTED_WHITE_CERAMIC.get())
				.add(ItemRegistry.PAINTED_LIGHT_GREY_CERAMIC.get())
				.add(ItemRegistry.PAINTED_GREY_CERAMIC.get())
				.add(ItemRegistry.PAINTED_BLACK_CERAMIC.get())
				.add(ItemRegistry.PAINTED_PURPLE_CERAMIC.get())
				.add(ItemRegistry.PAINTED_MAGENTA_CERAMIC.get())
				.add(ItemRegistry.PAINTED_BLUE_CERAMIC.get())
				.add(ItemRegistry.PAINTED_LIGHT_BLUE_CERAMIC.get())
				.add(ItemRegistry.PAINTED_CYAN_CERAMIC.get())
				.add(ItemRegistry.PAINTED_GREEN_CERAMIC.get())
				.add(ItemRegistry.PAINTED_LIME_CERAMIC.get())
				.add(ItemRegistry.PAINTED_YELLOW_CERAMIC.get())
				.add(ItemRegistry.PAINTED_ORANGE_CERAMIC.get())
				.add(ItemRegistry.PAINTED_BROWN_CERAMIC.get())
				.add(ItemRegistry.PAINTED_RED_CERAMIC.get())
				.add(ItemRegistry.PAINTED_PINK_CERAMIC.get());

		tag(ItemRegistry.STONE_PRESSURE_PLATE_TAG)
				.add(ItemRegistry.MOON_STONE_PRESSURE_PLATE.get())
				.add(ItemRegistry.MOON_DEEPSLATE_PRESSURE_PLATE.get())
				.add(ItemRegistry.MARS_STONE_PRESSURE_PLATE.get())
				.add(ItemRegistry.MARS_DEEPSLATE_PRESSURE_PLATE.get())
				.add(ItemRegistry.METEOR_PRESSURE_PLATE.get())
				.add(Items.STONE_PRESSURE_PLATE)
				.add(Items.POLISHED_BLACKSTONE_PRESSURE_PLATE)
				.add(ItemRegistry.VENUS_DEEPSLATE_PRESSURE_PLATE.get())
				.add(ItemRegistry.VENUS_STONE_PRESSURE_PLATE.get())
		;
	}

	@Override
	public String getName() {
		return "Celestial Exploration tags";
	}

}
