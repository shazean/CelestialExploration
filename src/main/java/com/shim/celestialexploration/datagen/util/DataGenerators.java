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
			generator.addProvider(new Recipes(generator));
			generator.addProvider(new LootTables(generator));
			BlockTags blockTags = new BlockTags(generator, helper);
			FluidTags fluidTags = new FluidTags(generator, CelestialExploration.MODID, helper);
			StructureTags structureTags = new StructureTags(generator, helper);

			generator.addProvider(blockTags);
			generator.addProvider(fluidTags);
			generator.addProvider(structureTags);
			generator.addProvider(new ItemTags(generator, blockTags, helper));
			generator.addProvider(new BiomeTags(generator, CelestialExploration.MODID, helper));
			generator.addProvider(new EntityTags(generator, CelestialExploration.MODID, helper));

			generator.addProvider(new DimensionTeleports(generator, CelestialExploration.MODID, helper));
			generator.addProvider(new PlanetTeleports(generator, CelestialExploration.MODID, helper));

		}
		if (event.includeClient()) {
			generator.addProvider(new BlockStates(generator, helper));
			generator.addProvider(new ItemModels(generator, helper));
			generator.addProvider(new LanguageProvider(generator, "en_us"));
			generator.addProvider(new Advancements(generator, helper));

		}
	}

}
