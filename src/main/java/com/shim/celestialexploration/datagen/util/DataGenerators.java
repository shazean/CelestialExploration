package com.shim.celestialexploration.datagen.util;

import com.shim.celestialexploration.CelestialExploration;

import com.shim.celestialexploration.datagen.*;
import net.minecraft.data.DataGenerator;
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
			generator.addProvider(new CelestialRecipes(generator));
			generator.addProvider(new CelestialLootTables(generator));
			CelestialBlockTags blockTags = new CelestialBlockTags(generator, helper);
			CelestialFluidTags fluidTags = new CelestialFluidTags(generator, CelestialExploration.MODID, helper);
			CelestialStructureTags structureTags = new CelestialStructureTags(generator, helper);

			generator.addProvider(blockTags);
			generator.addProvider(fluidTags);
			generator.addProvider(structureTags);
			generator.addProvider(new CelestialItemTags(generator, blockTags, helper));
			generator.addProvider(new CelestialBiomeTags(generator, CelestialExploration.MODID, helper));
			generator.addProvider(new CelestialEntityTags(generator, CelestialExploration.MODID, helper));

			generator.addProvider(new DimensionTeleports(generator, CelestialExploration.MODID, helper));
			generator.addProvider(new PlanetTeleports(generator, CelestialExploration.MODID, helper));

		}
		if (event.includeClient()) {
			generator.addProvider(new CelestialBlockStates(generator, helper));
			generator.addProvider(new CelestialItemModels(generator, helper));
			generator.addProvider(new CelestialLangProvider(generator, "en_us"));
			generator.addProvider(new CelestialAdvancements(generator, helper));

		}
	}

}
