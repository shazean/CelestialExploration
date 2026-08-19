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
			generator.addProvider(new CelestialRecipeGen(generator));
			generator.addProvider(new CelestialLootTables(generator));
			CelestialBlockTags blockTags = new CelestialBlockTags(generator, helper);
			CelestialFluidTags fluidTags = new CelestialFluidTags(generator, helper);
			CelestialStructureTags structureTags = new CelestialStructureTags(generator, helper);

			generator.addProvider(blockTags);
			generator.addProvider(fluidTags);
			generator.addProvider(structureTags);
			generator.addProvider(new CelestialItemTags(generator, blockTags, helper));
			generator.addProvider(new CelestialBiomeTags(generator, helper));
			generator.addProvider(new CelestialEntityTags(generator, helper));

			generator.addProvider(new CelestialDimensionGen(generator, helper));
			generator.addProvider(new CelestialDimensionTypes(generator, helper));
			generator.addProvider(new CelestialStructureGen(generator, helper));

			generator.addProvider(new CelestialPlanetData(generator, helper));
			generator.addProvider(new CelestialSpaceTravel(generator, helper));
			generator.addProvider(new CelestialPlanetStructures(generator, helper));

			generator.addProvider(new AsteroidOreGen(generator, helper));


		}
		if (event.includeClient()) {
			generator.addProvider(new CelestialBlockStates(generator, helper));
			generator.addProvider(new CelestialItemModels(generator, helper));
			generator.addProvider(new CelestialLangProvider(generator, "en_us"));
			generator.addProvider(new CelestialAdvancements(generator, helper));

			generator.addProvider(new CelestialGalaxyBackgrounds(generator, helper));
			generator.addProvider(new CelestialGalaxyIcons(generator, helper));
			generator.addProvider(new CelestialPlanetIcons(generator, helper));

		}
	}

}
