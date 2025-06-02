package com.shim.celestialexploration.datagen;

import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestialexploration.registry.CelestialItems;

import com.shim.celestialexploration.registry.CelestialTags;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.Items;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;


public class CelestialItemTags extends ItemTagsProvider {

	public CelestialItemTags(DataGenerator generator, BlockTagsProvider blockTags, ExistingFileHelper helper) {
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

		this.copy(CelestialTags.Blocks.MOON_STONE, CelestialTags.Items.MOON_STONE);
		this.copy(CelestialTags.Blocks.MOON_COBBLESTONE, CelestialTags.Items.MOON_COBBLESTONE);
		this.copy(CelestialTags.Blocks.MOON_DEEPSLATE, CelestialTags.Items.MOON_DEEPSLATE);
		this.copy(CelestialTags.Blocks.MOON_COBBLED_DEEPSLATE, CelestialTags.Items.MOON_COBBLED_DEEPSLATE);
		this.copy(CelestialTags.Blocks.MARS_STONE, CelestialTags.Items.MARS_STONE);
		this.copy(CelestialTags.Blocks.MARS_COBBLESTONE, CelestialTags.Items.MARS_COBBLESTONE);
		this.copy(CelestialTags.Blocks.MARS_DEEPSLATE, CelestialTags.Items.MARS_DEEPSLATE);
		this.copy(CelestialTags.Blocks.MARS_COBBLED_DEEPSLATE, CelestialTags.Items.MARS_COBBLED_DEEPSLATE);
		this.copy(CelestialTags.Blocks.VENUS_STONE, CelestialTags.Items.VENUS_STONE);
		this.copy(CelestialTags.Blocks.VENUS_COBBLESTONE, CelestialTags.Items.VENUS_COBBLESTONE);
		this.copy(CelestialTags.Blocks.VENUS_DEEPSLATE, CelestialTags.Items.VENUS_DEEPSLATE);
		this.copy(CelestialTags.Blocks.VENUS_COBBLED_DEEPSLATE, CelestialTags.Items.VENUS_COBBLED_DEEPSLATE);
		this.copy(CelestialTags.Blocks.JUPITER_DEEPSLATE, CelestialTags.Items.JUPITER_DEEPSLATE);
		this.copy(CelestialTags.Blocks.JUPITER_COBBLED_DEEPSLATE, CelestialTags.Items.JUPITER_COBBLED_DEEPSLATE);

		this.copy(CelestialTags.Blocks.METEOR, CelestialTags.Items.METEOR);

		this.copy(CelestialTags.Blocks.MERCURY_STONE, CelestialTags.Items.MERCURY_STONE);
		this.copy(CelestialTags.Blocks.MERCURY_COBBLESTONE, CelestialTags.Items.MERCURY_COBBLESTONE);
		this.copy(CelestialTags.Blocks.MERCURY_DEEPSLATE, CelestialTags.Items.MERCURY_DEEPSLATE);
		this.copy(CelestialTags.Blocks.MERCURY_COBBLED_DEEPSLATE, CelestialTags.Items.MERCURY_COBBLED_DEEPSLATE);

		this.copy(CelestialTags.Blocks.IO_STONE, CelestialTags.Items.IO_STONE);
		this.copy(CelestialTags.Blocks.IO_COBBLESTONE, CelestialTags.Items.IO_COBBLESTONE);
		this.copy(CelestialTags.Blocks.IO_DEEPSLATE, CelestialTags.Items.IO_DEEPSLATE);
		this.copy(CelestialTags.Blocks.IO_COBBLED_DEEPSLATE, CelestialTags.Items.IO_COBBLED_DEEPSLATE);

		this.copy(CelestialTags.Blocks.DYED_CERAMIC, CelestialTags.Items.DYED_CERAMIC);

		this.copy(CelestialTags.Blocks.DYED_CERAMIC_TILE, CelestialTags.Items.DYED_CERAMIC_TILE);

		this.copy(CelestialTags.Blocks.PAINTED_CERAMIC, CelestialTags.Items.PAINTED_CERAMIC);

		this.copy(CelestialTags.Blocks.REGOLITH, CelestialTags.Items.REGOLITH);
		this.copy(CelestialTags.Blocks.MAG_RAIL, CelestialTags.Items.MAG_RAIL);

		this.copy(CelestialTags.Blocks.BAUXITE_ORE, CelestialTags.Items.BAUXITE_ORE);

		this.copy(CelestialTags.Blocks.COMPRESSIBLE, CelestialTags.Items.COMPRESSIBLE);

		this.copy(CelestialTags.Blocks.COBBLESAURUS_FOOD, CelestialTags.Items.COBBLESAURUS_FOOD);

		tag(CelestialTags.Items.LUNAR_DUSTS).add(CelestialItems.MOON_DUST.get()).add(CelestialItems.CALLISTO_DUST.get())
				.add(CelestialItems.IO_DUST.get()).add(CelestialItems.GANYMEDE_DUST.get()).add(CelestialItems.EUROPA_DUST.get())
				.add(CelestialItems.WHITE_MOON_DUST.get());


		tag(CelestialTags.Items.SLIME_DROPS).add(Items.SLIME_BALL).add(CelestialItems.MARSHMALLOW_GOO.get()).add(CelestialItems.LUNAR_GOO.get());

	}

	@Override
	public String getName() {
		return "Celestial Exploration tags";
	}

}
