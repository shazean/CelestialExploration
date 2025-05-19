package com.shim.celestialexploration.datagen;

import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestialexploration.registry.ItemRegistry;

import com.shim.celestialexploration.registry.TagRegistry;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.Items;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;


public class ItemTags extends ItemTagsProvider {

	public ItemTags(DataGenerator generator, BlockTagsProvider blockTags, ExistingFileHelper helper) {
		super(generator, blockTags, CelestialExploration.MODID, helper);
	}

	@Override
	protected void addTags() {

		this.copy(BlockTags.COAL_ORES, net.minecraft.tags.ItemTags.COAL_ORES);
		this.copy(BlockTags.COPPER_ORES, net.minecraft.tags.ItemTags.COPPER_ORES);
		this.copy(BlockTags.DIAMOND_ORES, net.minecraft.tags.ItemTags.DIAMOND_ORES);
		this.copy(BlockTags.EMERALD_ORES, net.minecraft.tags.ItemTags.EMERALD_ORES);
		this.copy(BlockTags.GOLD_ORES, net.minecraft.tags.ItemTags.GOLD_ORES);
		this.copy(BlockTags.LAPIS_ORES, net.minecraft.tags.ItemTags.LAPIS_ORES);
		this.copy(BlockTags.IRON_ORES, net.minecraft.tags.ItemTags.IRON_ORES);
		this.copy(BlockTags.REDSTONE_ORES, net.minecraft.tags.ItemTags.REDSTONE_ORES);

		this.copy(BlockTags.SAND, net.minecraft.tags.ItemTags.SAND);
		this.copy(BlockTags.SLABS, net.minecraft.tags.ItemTags.SLABS);
		this.copy(BlockTags.STAIRS, net.minecraft.tags.ItemTags.STAIRS);
		this.copy(BlockTags.WALLS, net.minecraft.tags.ItemTags.WALLS);
		this.copy(BlockTags.DOORS, net.minecraft.tags.ItemTags.DOORS);
		this.copy(BlockTags.TRAPDOORS, net.minecraft.tags.ItemTags.TRAPDOORS);
		this.copy(BlockTags.BUTTONS, net.minecraft.tags.ItemTags.BUTTONS);
		this.copy(BlockTags.SOUL_FIRE_BASE_BLOCKS, net.minecraft.tags.ItemTags.SOUL_FIRE_BASE_BLOCKS);

		this.copy(Tags.Blocks.ORES, Tags.Items.ORES);
		this.copy(Tags.Blocks.ORE_RATES_DENSE, Tags.Items.ORE_RATES_DENSE);
		this.copy(Tags.Blocks.ORE_RATES_SINGULAR, Tags.Items.ORE_RATES_SINGULAR);
		this.copy(Tags.Blocks.ORE_RATES_SPARSE, Tags.Items.ORE_RATES_SPARSE);
		this.copy(Tags.Blocks.SAND, Tags.Items.SAND);
		this.copy(Tags.Blocks.GLASS, Tags.Items.GLASS);
		this.copy(Tags.Blocks.GLASS_PANES, Tags.Items.GLASS_PANES);

		this.copy(TagRegistry.Blocks.MOON_STONE, TagRegistry.Items.MOON_STONE);
		this.copy(TagRegistry.Blocks.MOON_COBBLESTONE, TagRegistry.Items.MOON_COBBLESTONE);
		this.copy(TagRegistry.Blocks.MOON_DEEPSLATE, TagRegistry.Items.MOON_DEEPSLATE);
		this.copy(TagRegistry.Blocks.MOON_COBBLED_DEEPSLATE, TagRegistry.Items.MOON_COBBLED_DEEPSLATE);
		this.copy(TagRegistry.Blocks.MARS_STONE, TagRegistry.Items.MARS_STONE);
		this.copy(TagRegistry.Blocks.MARS_COBBLESTONE, TagRegistry.Items.MARS_COBBLESTONE);
		this.copy(TagRegistry.Blocks.MARS_DEEPSLATE, TagRegistry.Items.MARS_DEEPSLATE);
		this.copy(TagRegistry.Blocks.MARS_COBBLED_DEEPSLATE, TagRegistry.Items.MARS_COBBLED_DEEPSLATE);
		this.copy(TagRegistry.Blocks.VENUS_STONE, TagRegistry.Items.VENUS_STONE);
		this.copy(TagRegistry.Blocks.VENUS_COBBLESTONE, TagRegistry.Items.VENUS_COBBLESTONE);
		this.copy(TagRegistry.Blocks.VENUS_DEEPSLATE, TagRegistry.Items.VENUS_DEEPSLATE);
		this.copy(TagRegistry.Blocks.VENUS_COBBLED_DEEPSLATE, TagRegistry.Items.VENUS_COBBLED_DEEPSLATE);
		this.copy(TagRegistry.Blocks.JUPITER_DEEPSLATE, TagRegistry.Items.JUPITER_DEEPSLATE);
		this.copy(TagRegistry.Blocks.JUPITER_COBBLED_DEEPSLATE, TagRegistry.Items.JUPITER_COBBLED_DEEPSLATE);

		this.copy(TagRegistry.Blocks.METEOR, TagRegistry.Items.METEOR);

		this.copy(TagRegistry.Blocks.MERCURY_STONE, TagRegistry.Items.MERCURY_STONE);
		this.copy(TagRegistry.Blocks.MERCURY_COBBLESTONE, TagRegistry.Items.MERCURY_COBBLESTONE);
		this.copy(TagRegistry.Blocks.MERCURY_DEEPSLATE, TagRegistry.Items.MERCURY_DEEPSLATE);
		this.copy(TagRegistry.Blocks.MERCURY_COBBLED_DEEPSLATE, TagRegistry.Items.MERCURY_COBBLED_DEEPSLATE);

		this.copy(TagRegistry.Blocks.IO_STONE, TagRegistry.Items.IO_STONE);
		this.copy(TagRegistry.Blocks.IO_COBBLESTONE, TagRegistry.Items.IO_COBBLESTONE);
		this.copy(TagRegistry.Blocks.IO_DEEPSLATE, TagRegistry.Items.IO_DEEPSLATE);
		this.copy(TagRegistry.Blocks.IO_COBBLED_DEEPSLATE, TagRegistry.Items.IO_COBBLED_DEEPSLATE);

		this.copy(TagRegistry.Blocks.DYED_CERAMIC, TagRegistry.Items.DYED_CERAMIC);

		this.copy(TagRegistry.Blocks.DYED_CERAMIC_TILE, TagRegistry.Items.DYED_CERAMIC_TILE);

		this.copy(TagRegistry.Blocks.PAINTED_CERAMIC, TagRegistry.Items.PAINTED_CERAMIC);

		this.copy(TagRegistry.Blocks.REGOLITH, TagRegistry.Items.REGOLITH);
		this.copy(TagRegistry.Blocks.MAG_RAIL, TagRegistry.Items.MAG_RAIL);

		this.copy(TagRegistry.Blocks.BAUXITE_ORE, TagRegistry.Items.BAUXITE_ORE);

		this.copy(TagRegistry.Blocks.COMPRESSIBLE, TagRegistry.Items.COMPRESSIBLE);

		this.copy(TagRegistry.Blocks.COBBLESAURUS_FOOD, TagRegistry.Items.COBBLESAURUS_FOOD);


		tag(TagRegistry.Items.SLIME_DROPS).add(Items.SLIME_BALL).add(ItemRegistry.MARSHMALLOW_GOO.get()).add(ItemRegistry.LUNAR_GOO.get());

	}

	@Override
	public String getName() {
		return "Celestial Exploration tags";
	}

}
