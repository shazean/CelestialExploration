package com.shim.celestialexploration.datagen;

import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestialexploration.registry.BlockRegistry;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModBlockTags extends BlockTagsProvider {

	public ModBlockTags(DataGenerator generator, ExistingFileHelper helper) {
		super(generator, CelestialExploration.MODID, helper);
	}

	@Override
	protected void addTags() {
		tag(BlockTags.MINEABLE_WITH_PICKAXE)
			//MOON
			.add(BlockRegistry.MOON_BRICK_SLAB.get())
			.add(BlockRegistry.MOON_BRICK_STAIRS.get())
			.add(BlockRegistry.MOON_BRICK_WALL.get())
			.add(BlockRegistry.MOON_IRON_ORE.get())
			.add(BlockRegistry.MOON_REDSTONE_ORE.get())
			.add(BlockRegistry.MOON_STONE.get())
			.add(BlockRegistry.CHISELED_MOON_BRICKS.get())
			//MARS
			.add(BlockRegistry.MARS_BRICK_SLAB.get())
			.add(BlockRegistry.MARS_BRICK_STAIRS.get())
			.add(BlockRegistry.MARS_BRICK_WALL.get())
			.add(BlockRegistry.MARS_BRICKS.get())
			.add(BlockRegistry.MARS_IRON_ORE.get())
			.add(BlockRegistry.MARS_REDSTONE_ORE.get())
			.add(BlockRegistry.MARS_STONE.get())
			.add(BlockRegistry.CHISELED_MARS_BRICKS.get())
			//METEOR
			.add(BlockRegistry.METEOR.get())
			.add(BlockRegistry.METEOR_BRICK_SLAB.get())
			.add(BlockRegistry.METEOR_BRICK_STAIRS.get())
			.add(BlockRegistry.METEOR_BRICK_WALL.get())
			.add(BlockRegistry.METEOR_BRICKS.get())
			.add(BlockRegistry.METEOR_COAL_ORE.get())
			.add(BlockRegistry.METEOR_COPPER_ORE.get())
			.add(BlockRegistry.METEOR_DIAMOND_ORE.get())
			.add(BlockRegistry.METEOR_EMERALD_ORE.get())
			.add(BlockRegistry.METEOR_GOLD_ORE.get())
			.add(BlockRegistry.METEOR_IRON_ORE.get())
			.add(BlockRegistry.METEOR_LAPIS_ORE.get())
			.add(BlockRegistry.METEOR_REDSTONE_ORE.get())
			.add(BlockRegistry.CHISELED_METEOR_BRICKS.get());

		tag(BlockTags.NEEDS_IRON_TOOL)
			.add(BlockRegistry.MOON_REDSTONE_ORE.get())
			.add(BlockRegistry.MARS_REDSTONE_ORE.get())
			.add(BlockRegistry.METEOR_REDSTONE_ORE.get())
			.add(BlockRegistry.METEOR_DIAMOND_ORE.get())
			.add(BlockRegistry.METEOR_EMERALD_ORE.get())
			.add(BlockRegistry.METEOR_GOLD_ORE.get())
			.add(BlockRegistry.METEOR_LAPIS_ORE.get());

		tag(Tags.Blocks.ORES)
			.add(BlockRegistry.MOON_IRON_ORE.get())
			.add(BlockRegistry.MOON_REDSTONE_ORE.get())
			.add(BlockRegistry.MARS_IRON_ORE.get())
			.add(BlockRegistry.MARS_REDSTONE_ORE.get())
			.add(BlockRegistry.METEOR_COAL_ORE.get())
			.add(BlockRegistry.METEOR_COPPER_ORE.get())
			.add(BlockRegistry.METEOR_DIAMOND_ORE.get())
			.add(BlockRegistry.METEOR_EMERALD_ORE.get())
			.add(BlockRegistry.METEOR_GOLD_ORE.get())
			.add(BlockRegistry.METEOR_IRON_ORE.get())
			.add(BlockRegistry.METEOR_LAPIS_ORE.get())
			.add(BlockRegistry.METEOR_REDSTONE_ORE.get());

		tag(BlockTags.DIRT);

		tag(BlockTags.COAL_ORES)
			.add(BlockRegistry.METEOR_COAL_ORE.get());

		tag(BlockTags.COPPER_ORES)
			.add(BlockRegistry.METEOR_COPPER_ORE.get());

		tag(BlockTags.DIAMOND_ORES)
			.add(BlockRegistry.METEOR_DIAMOND_ORE.get());

		tag(BlockTags.EMERALD_ORES)
			.add(BlockRegistry.METEOR_EMERALD_ORE.get());

		tag(BlockTags.GOLD_ORES)
			.add(BlockRegistry.METEOR_GOLD_ORE.get());

		tag(BlockTags.IRON_ORES)
			.add(BlockRegistry.MOON_IRON_ORE.get())
			.add(BlockRegistry.MARS_IRON_ORE.get())
			.add(BlockRegistry.METEOR_IRON_ORE.get());

		tag(BlockTags.LAPIS_ORES)
			.add(BlockRegistry.METEOR_LAPIS_ORE.get());

		tag(BlockTags.REDSTONE_ORES)
			.add(BlockRegistry.MOON_REDSTONE_ORE.get())
			.add(BlockRegistry.MARS_REDSTONE_ORE.get())
			.add(BlockRegistry.METEOR_REDSTONE_ORE.get());

		tag(BlockTags.NEEDS_DIAMOND_TOOL);

		tag(BlockTags.SLABS)
			.add(BlockRegistry.MARS_BRICK_SLAB.get())
			.add(BlockRegistry.MOON_BRICK_SLAB.get())
			.add(BlockRegistry.METEOR_BRICK_SLAB.get());

		tag(BlockTags.STAIRS)
			.add(BlockRegistry.MARS_BRICK_STAIRS.get())
			.add(BlockRegistry.METEOR_BRICK_STAIRS.get())
			.add(BlockRegistry.MOON_BRICK_STAIRS.get());

		tag(BlockTags.WALLS)
			.add(BlockRegistry.MARS_BRICK_WALL.get())
			.add(BlockRegistry.METEOR_BRICK_WALL.get())
			.add(BlockRegistry.MOON_BRICK_WALL.get());

		tag(Tags.Blocks.SAND)
			.add(BlockRegistry.GLOWING_MOON_SAND.get())
			.add(BlockRegistry.MARS_SAND.get())
			.add(BlockRegistry.MOON_SAND.get());

		tag(Tags.Blocks.ORE_RATES_DENSE)
		;
		tag(Tags.Blocks.ORE_RATES_SINGULAR)
		;
		tag(Tags.Blocks.ORE_RATES_SPARSE)
		;

		tag(BlockRegistry.MARS_TAG)
				.add(BlockRegistry.MARS_BRICKS.get())
				.add(BlockRegistry.MARS_IRON_ORE.get())
				.add(BlockRegistry.MARS_BRICK_SLAB.get())
				.add(BlockRegistry.MARS_BRICK_STAIRS.get())
				.add(BlockRegistry.MARS_BRICK_WALL.get())
				.add(BlockRegistry.MARS_REDSTONE_ORE.get())
				.add(BlockRegistry.MARS_SAND.get())
				.add(BlockRegistry.MARS_STONE.get())
				.add(BlockRegistry.CHISELED_MARS_BRICKS.get());

		tag(BlockRegistry.MARS_STONE_TAG)
				.add(BlockRegistry.MARS_BRICKS.get())
				.add(BlockRegistry.MARS_BRICK_SLAB.get())
				.add(BlockRegistry.MARS_BRICK_STAIRS.get())
				.add(BlockRegistry.MARS_BRICK_WALL.get())
				.add(BlockRegistry.MARS_STONE.get())
				.add(BlockRegistry.CHISELED_MARS_BRICKS.get());

	}
	
	@Override
	public String getName() {
		return "Celestial Exploration tags";
		
	}

}
