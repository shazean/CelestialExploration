package com.shim.celestialexploration.datagen.util;

import com.shim.celestialexploration.CelestialExploration;

import com.shim.celestialexploration.datagen.*;
import net.minecraft.data.DataGenerator;
import net.minecraft.tags.ItemTags;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;


@Mod.EventBusSubscriber(modid = CelestialExploration.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerators {

	@SubscribeEvent
	public static void gatherData(GatherDataEvent event) {
		DataGenerator generator = event.getGenerator();
		ExistingFileHelper helper = event.getExistingFileHelper();

		if (event.includeServer()) {
			generator.addProvider(new Recipes(generator));
			generator.addProvider(new LootTables(generator));
			ModBlockTags blockTags = new ModBlockTags(generator, helper);
			ModFluidTags fluidTags = new ModFluidTags(generator, CelestialExploration.MODID, helper);

			generator.addProvider(blockTags);
			generator.addProvider(fluidTags);
			generator.addProvider(new ModItemTags(generator, blockTags, helper));
			generator.addProvider(new ModBiomeTags(generator, CelestialExploration.MODID, helper));
			generator.addProvider(new ModEntityTags(generator, CelestialExploration.MODID, helper));

			generator.addProvider(new DimensionTeleports(generator, CelestialExploration.MODID, helper));
			generator.addProvider(new PlanetTeleports(generator, CelestialExploration.MODID, helper));

		}
		if (event.includeClient()) {
			generator.addProvider(new BlockStates(generator, helper));
			generator.addProvider(new ItemModels(generator, helper));
			generator.addProvider(new ModLanguageProvider(generator, "en_us"));
			generator.addProvider(new ModAdvancements(generator, helper));

		}
	}

}
