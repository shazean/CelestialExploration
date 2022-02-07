package com.shim.celestialexploration.datagen;

import com.shim.celestialexploration.CelestialExploration;

import net.minecraft.data.DataGenerator;
import net.minecraft.tags.ItemTags;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;

@Mod.EventBusSubscriber(modid = CelestialExploration.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerators {
	
	@SubscribeEvent
	public static void gatherData(GatherDataEvent event) {
		DataGenerator generator = event.getGenerator();
		if (event.includeServer()) {
			generator.addProvider(new Recipes(generator));
			generator.addProvider(new LootTables(generator));
			ModBlockTags blockTags = new ModBlockTags(generator, event.getExistingFileHelper());
			generator.addProvider(blockTags);
			generator.addProvider(new ModItemTags(generator, blockTags, event.getExistingFileHelper()));
		}
		if (event.includeClient()) {
			generator.addProvider(new BlockStates(generator, event.getExistingFileHelper()));
			generator.addProvider(new ItemModels(generator, event.getExistingFileHelper()));
			generator.addProvider(new ModLanguageProvider(generator, "en_us"));
			
		}
	}

}
