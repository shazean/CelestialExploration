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
				.add(ItemRegistry.METEOR_REDSTONE_ORE.get());

		tag(Tags.Items.SAND)
				.add(ItemRegistry.GLOWING_MOON_SAND.get())
				.add(ItemRegistry.COARSE_MOON_SAND.get())
				.add(ItemRegistry.COARSE_MARS_SAND.get())
				.add(ItemRegistry.MARS_SAND.get())
				.add(ItemRegistry.MOON_SAND.get());

		tag(Tags.Items.STONE)
				.add(ItemRegistry.MARS_STONE.get())
				.add(ItemRegistry.METEOR.get())
				.add(ItemRegistry.MARS_COBBLESTONE.get())
				.add(ItemRegistry.MARS_DEEPSLATE.get())
				.add(ItemRegistry.MARS_COBBLED_DEEPSLATE.get())
				.add(ItemRegistry.MARS_STONE_SLAB.get())
				.add(ItemRegistry.MARS_COBBLESTONE_SLAB.get())
				.add(ItemRegistry.MARS_COBBLESTONE_STAIRS.get())
				.add(ItemRegistry.MARS_COBBLESTONE_WALL.get())
				.add(ItemRegistry.MARS_COBBLED_DEEPSLATE_SLAB.get())
				.add(ItemRegistry.MARS_COBBLED_DEEPSLATE_STAIRS.get())
				.add(ItemRegistry.MARS_COBBLED_DEEPSLATE_WALL.get())
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
				.add(ItemRegistry.MARS_POLISHED_DEEPSLATE_WALL.get())
				.add(ItemRegistry.MOON_STONE.get())
				.add(ItemRegistry.MOON_BRICK_SLAB.get())
				.add(ItemRegistry.MOON_BRICK_STAIRS.get())
				.add(ItemRegistry.MOON_BRICK_WALL.get())
				.add(ItemRegistry.MOON_BRICKS.get())
				.add(ItemRegistry.CHISELED_MOON_BRICKS.get())
				.add(ItemRegistry.MOON_IRON_ORE.get())
				.add(ItemRegistry.MOON_REDSTONE_ORE.get())
				.add(ItemRegistry.MOON_DEEPSLATE_IRON_ORE.get())
				.add(ItemRegistry.MOON_DEEPSLATE_REDSTONE_ORE.get())
				.add(ItemRegistry.MARS_DEEPSLATE_IRON_ORE.get())
				.add(ItemRegistry.MARS_DEEPSLATE_REDSTONE_ORE.get())
				.add(ItemRegistry.MOON_BRICK_PILLAR.get())
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
				.add(ItemRegistry.MOON_POLISHED_DEEPSLATE_WALL.get())

		;

		tag(Tags.Items.COBBLESTONE)
				.add(ItemRegistry.MARS_COBBLESTONE.get())
				.add(ItemRegistry.MARS_COBBLESTONE_SLAB.get())
				.add(ItemRegistry.MARS_COBBLESTONE_STAIRS.get())
				.add(ItemRegistry.MARS_COBBLESTONE_WALL.get())
				.add(ItemRegistry.MOON_COBBLESTONE.get())
				.add(ItemRegistry.MOON_COBBLESTONE_SLAB.get())
				.add(ItemRegistry.MOON_COBBLESTONE_STAIRS.get())
				.add(ItemRegistry.MOON_COBBLESTONE_WALL.get())
		;

		tag(Tags.Items.COBBLESTONE_DEEPSLATE)
				.add(ItemRegistry.MARS_COBBLED_DEEPSLATE.get())
				.add(ItemRegistry.MARS_COBBLED_DEEPSLATE_SLAB.get())
				.add(ItemRegistry.MARS_COBBLED_DEEPSLATE_STAIRS.get())
				.add(ItemRegistry.MARS_COBBLED_DEEPSLATE_WALL.get())
				.add(ItemRegistry.MOON_COBBLED_DEEPSLATE.get())
				.add(ItemRegistry.MOON_COBBLED_DEEPSLATE_SLAB.get())
				.add(ItemRegistry.MOON_COBBLED_DEEPSLATE_STAIRS.get())
				.add(ItemRegistry.MOON_COBBLED_DEEPSLATE_WALL.get())
		;

		tag(Tags.Items.ORES_COAL)
				.add(ItemRegistry.METEOR_COAL_ORE.get());

		tag(Tags.Items.ORES_COPPER)
				.add(ItemRegistry.METEOR_COPPER_ORE.get());

		tag(Tags.Items.ORES_DIAMOND)
				.add(ItemRegistry.METEOR_DIAMOND_ORE.get());

		tag(Tags.Items.ORES_EMERALD)
				.add(ItemRegistry.METEOR_EMERALD_ORE.get());

		tag(Tags.Items.ORES_GOLD)
				.add(ItemRegistry.METEOR_GOLD_ORE.get());

		tag(Tags.Items.ORES_IRON)
				.add(ItemRegistry.MARS_IRON_ORE.get())
				.add(ItemRegistry.METEOR_IRON_ORE.get())
				.add(ItemRegistry.MOON_IRON_ORE.get())
				.add(ItemRegistry.MOON_DEEPSLATE_IRON_ORE.get())
				.add(ItemRegistry.MARS_DEEPSLATE_IRON_ORE.get());

		tag(Tags.Items.GLASS)
				.add(ItemRegistry.LUMINOUS_BLUE_GLASS.get())
				.add(ItemRegistry.LUMINOUS_BLUE_GLASS_PANE.get())
				.add(ItemRegistry.LUMINOUS_WHITE_GLASS.get())
				.add(ItemRegistry.LUMINOUS_WHITE_GLASS_PANE.get());

		tag(Tags.Items.GLASS_PANES)
				.add(ItemRegistry.LUMINOUS_BLUE_GLASS_PANE.get())
				.add(ItemRegistry.LUMINOUS_WHITE_GLASS_PANE.get());

		tag(Tags.Items.ORES_LAPIS)
				.add(ItemRegistry.METEOR_LAPIS_ORE.get());

		tag(Tags.Items.ORES_REDSTONE)
				.add(ItemRegistry.MARS_REDSTONE_ORE.get())
				.add(ItemRegistry.MOON_REDSTONE_ORE.get())
				.add(ItemRegistry.METEOR_REDSTONE_ORE.get())
				.add(ItemRegistry.MOON_DEEPSLATE_REDSTONE_ORE.get())
				.add(ItemRegistry.MARS_DEEPSLATE_REDSTONE_ORE.get());

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
//				.add(ItemRegistry.MARS_DEEPSLATE_BRICK_SLAB.get())
//				.add(ItemRegistry.MARS_DEEPSLATE_BRICK_STAIRS.get())
//				.add(ItemRegistry.MARS_DEEPSLATE_BRICK_WALL.get())
				.add(ItemRegistry.MARS_DEEPSLATE_TILES.get())
//				.add(ItemRegistry.MARS_DEEPSLATE_TILE_SLAB.get())
//				.add(ItemRegistry.MARS_DEEPSLATE_TILE_STAIRS.get())
//				.add(ItemRegistry.MARS_DEEPSLATE_TILE_WALL.get())
				.add(ItemRegistry.MARS_POLISHED_DEEPSLATE.get())
//				.add(ItemRegistry.MARS_POLISHED_DEEPSLATE_SLAB.get())
//				.add(ItemRegistry.MARS_POLISHED_DEEPSLATE_STAIRS.get())
//				.add(ItemRegistry.MARS_POLISHED_DEEPSLATE_WALL.get())
				;

		tag(ItemRegistry.MARS_COBBLED_DEEPSLATE_TAG)
				.add(ItemRegistry.MARS_COBBLED_DEEPSLATE.get())
//				.add(ItemRegistry.MARS_COBBLED_DEEPSLATE_SLAB.get())
//				.add(ItemRegistry.MARS_COBBLED_DEEPSLATE_STAIRS.get())
//				.add(ItemRegistry.MARS_COBBLED_DEEPSLATE_WALL.get())
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
//				.add(ItemRegistry.MOON_DEEPSLATE_BRICK_SLAB.get())
//				.add(ItemRegistry.MOON_DEEPSLATE_BRICK_STAIRS.get())
//				.add(ItemRegistry.MOON_DEEPSLATE_BRICK_WALL.get())
				.add(ItemRegistry.MOON_DEEPSLATE_TILES.get())
//				.add(ItemRegistry.MOON_DEEPSLATE_TILE_SLAB.get())
//				.add(ItemRegistry.MOON_DEEPSLATE_TILE_STAIRS.get())
//				.add(ItemRegistry.MOON_DEEPSLATE_TILE_WALL.get())
				.add(ItemRegistry.MOON_POLISHED_DEEPSLATE.get())
//				.add(ItemRegistry.MOON_POLISHED_DEEPSLATE_SLAB.get())
//				.add(ItemRegistry.MOON_POLISHED_DEEPSLATE_STAIRS.get())
//				.add(ItemRegistry.MOON_POLISHED_DEEPSLATE_WALL.get())
				;

		tag(ItemRegistry.MOON_COBBLED_DEEPSLATE_TAG)
				.add(ItemRegistry.MOON_COBBLED_DEEPSLATE.get())
//				.add(ItemRegistry.MOON_COBBLED_DEEPSLATE_SLAB.get())
//				.add(ItemRegistry.MOON_COBBLED_DEEPSLATE_STAIRS.get())
//				.add(ItemRegistry.MOON_COBBLED_DEEPSLATE_WALL.get())
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


	}

	@Override
	public String getName() {
		return "Celestial Exploration tags";
	}

}
