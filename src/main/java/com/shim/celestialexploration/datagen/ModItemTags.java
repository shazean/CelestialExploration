package com.shim.celestialexploration.datagen;

import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestialexploration.registry.BlockRegistry;
import com.shim.celestialexploration.registry.ItemRegistry;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.world.item.Items;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;


public class ModItemTags extends ItemTagsProvider {

	public ModItemTags(DataGenerator generator, BlockTagsProvider blockTags, ExistingFileHelper helper) {
		super(generator, blockTags, CelestialExploration.MODID, helper);
	}

	@Override
	protected void addTags() {
		tag(Tags.Items.ORES)
				.add(ItemRegistry.MOON_IRON_ORE.get())
				.add(ItemRegistry.MOON_REDSTONE.get())
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
				.add(ItemRegistry.MARS_SAND.get())
				.add(ItemRegistry.MOON_SAND.get());

		tag(Tags.Items.STONE)
				.add(ItemRegistry.MOON_STONE.get())
				.add(ItemRegistry.MARS_STONE.get())
				.add(ItemRegistry.METEOR.get());

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
				.add(ItemRegistry.MOON_IRON_ORE.get());

		tag(Tags.Items.ORES_LAPIS)
				.add(ItemRegistry.METEOR_LAPIS_ORE.get());

		tag(Tags.Items.ORES_REDSTONE)
				.add(ItemRegistry.MARS_REDSTONE_ORE.get())
				.add(ItemRegistry.MOON_REDSTONE.get())
				.add(ItemRegistry.METEOR_REDSTONE_ORE.get());

		tag(ItemRegistry.MARS_TAG)
				.add(ItemRegistry.MARS_STONE.get())
				.add(ItemRegistry.MARS_BRICK_SLAB.get())
				.add(ItemRegistry.MARS_BRICK_STAIRS.get())
				.add(ItemRegistry.MARS_BRICK_WALL.get())
				.add(ItemRegistry.MARS_BRICKS.get())
				.add(ItemRegistry.CHISELED_MARS_BRICKS.get())
				.add(ItemRegistry.MARS_IRON_ORE.get())
				.add(ItemRegistry.MARS_REDSTONE_ORE.get())
				.add(ItemRegistry.MARS_SAND.get());

		tag(ItemRegistry.MARS_STONE_TAG)
				.add(ItemRegistry.MARS_STONE.get())
				.add(ItemRegistry.MARS_BRICK_SLAB.get())
				.add(ItemRegistry.MARS_BRICK_STAIRS.get())
				.add(ItemRegistry.MARS_BRICK_WALL.get())
				.add(ItemRegistry.MARS_BRICKS.get())
				.add(ItemRegistry.CHISELED_MARS_BRICKS.get());

	}


	@Override
	public String getName() {
		return "Celestial Exploration tags";
	}

}
