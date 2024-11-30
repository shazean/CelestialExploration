package com.shim.celestialexploration.datagen;

import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestialexploration.registry.*;

import com.shim.celestialexploration.world.biome.CelestialBiomeKeys;
import net.minecraft.data.DataGenerator;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.LanguageProvider;
import net.minecraftforge.registries.RegistryObject;

import java.awt.*;

public class ModLanguageProvider extends LanguageProvider {

	public ModLanguageProvider(DataGenerator gen, String locale) {
		super(gen, CelestialExploration.MODID, locale);
	}

	public String getBiomeString(ResourceKey<Biome> biome) {
		return "biome." + CelestialExploration.MODID + "." + biome.location().getPath();
	}

	public String getDimensionString(ResourceKey<Level> dimension) {
		return "dimension.celestialexploration." + dimension.location().getPath();
	}


	@Override
	protected void addTranslations() {

		for (RegistryObject<? extends Block> block : BlockRegistry.BLOCK_LANG_EN_US.keySet()) this.add(block.get(), BlockRegistry.BLOCK_LANG_EN_US.get(block));
		for (RegistryObject<? extends Item> item : ItemRegistry.ITEM_LANG_EN_US.keySet()) this.add(item.get(), ItemRegistry.ITEM_LANG_EN_US.get(item));
		for (RegistryObject<? extends EntityType> entity : EntityRegistry.ENTITY_LANG_EN_US.keySet()) this.add(entity.get(), EntityRegistry.ENTITY_LANG_EN_US.get(entity));

		add("entity.minecraft.villager.celestialexploration.astronomer", "Astronomer");
		add("entity.minecraft.villager.celestialexploration.engineer", "Engineer");
		add("celestialexploration.villager.unemployed", "Unemployed");

		//---- FLUIDS -------------------------------------------------------------------------------
		add("fluid.celestialexploration.lox", "Liquid Oxygen");
		add(FluidRegistry.MOLTEN_IRON_BLOCK.get(), "Molten Iron");
		add("fluid.celestialexploration.molten_iron", "Molten Iron");
		add(FluidRegistry.MOLTEN_STEEL_BLOCK.get(), "Molten Steel");
		add("fluid.celestialexploration.molten_steel", "Molten Steel");
		add(FluidRegistry.MOLTEN_COPPER_BLOCK.get(), "Molten Copper");
		add("fluid.celestialexploration.molten_copper", "Molten Copper");
		add(FluidRegistry.MOLTEN_GOLD_BLOCK.get(), "Molten Gold");
		add("fluid.celestialexploration.molten_gold", "Molten Gold");
//		add(FluidRegistry.MOLTEN_NETHERITE_BLOCK.get(), "Molten Copper");
		add(FluidRegistry.SULFUR_BLOCK.get(), "Sulfur");
		add("fluid.celestialexploration.sulfur", "Sulfur");
		add(FluidRegistry.MOLTEN_ALUMINUM_BLOCK.get(), "Molten Aluminum");
		add("fluid.celestialexploration.molten_aluminum", "Molten Aluminum");
		add(FluidRegistry.SULFUR_BUCKET.get(), "Sulfur Bucket");
		add(FluidRegistry.METALLIC_HYDROGEN_BLOCK.get(), "Metallic Hydrogen");
		add("fluid.celestialexploration.metallic_hydrogen", "Metallic Hydrogen");
		add(FluidRegistry.METALLIC_HYDROGEN_BUCKET.get(), "Metallic Hydrogen Bucket");

		//---- BIOMES -------------------------------------------------------------------------------
		add(getBiomeString(CelestialBiomeKeys.MOON_CRATERS), "Lunar Craters");
		add(getBiomeString(CelestialBiomeKeys.MOON_DESERT), "Lunar Desert");
		add(getBiomeString(CelestialBiomeKeys.MOON_LAVA_FLATS), "Lunar Lava Flats");
		add(getBiomeString(CelestialBiomeKeys.MOON_LOWER_PLAINS), "Lunar Lower Plains");
		add(getBiomeString(CelestialBiomeKeys.MOON_PLAINS), "Lunar Plains");
		add(getBiomeString(CelestialBiomeKeys.MARS_CRATERS), "Martian Craters");
		add(getBiomeString(CelestialBiomeKeys.MARS_DEEP_CRATERS), "Martian Deep Craters");
		add(getBiomeString(CelestialBiomeKeys.MARS_DESERT), "Martian Desert");
		add(getBiomeString(CelestialBiomeKeys.MARS_DUNES), "Martian Dunes");
		add(getBiomeString(CelestialBiomeKeys.MARS_DRY_ICE_FLATS), "Martian Dry Ice Flats");
		add(getBiomeString(CelestialBiomeKeys.MARS_DRY_ICE_PEAKS), "Martian Dry Ice Peaks");
		add(getBiomeString(CelestialBiomeKeys.MARS_ERODED_FLATS), "Martian Eroded Flats");
		add(getBiomeString(CelestialBiomeKeys.MARS_VOLCANO_FLATS), "Martian Volcano Flats");
		add(getBiomeString(CelestialBiomeKeys.MARS_FLATS), "Martian Flats");
		add(getBiomeString(CelestialBiomeKeys.VENUS_DESERT), "Venusian Desert");
		add(getBiomeString(CelestialBiomeKeys.VENUS_LOWER_PLAINS), "Venusian Lower Plains");
		add(getBiomeString(CelestialBiomeKeys.VENUS_PLAINS), "Venusian Plains");
		add(getBiomeString(CelestialBiomeKeys.VENUS_SULFUR_FLATS), "Venusian Sulfur Flats");
		add(getBiomeString(CelestialBiomeKeys.SULFUR_RIVER), "Sulfuric River");
		add(getBiomeString(CelestialBiomeKeys.SULFUR_OCEAN), "Sulfuric Ocean");
		add(getBiomeString(CelestialBiomeKeys.MERCURY_CRATERED_PLAINS), "Mercurian Cratered Plains");
		add(getBiomeString(CelestialBiomeKeys.MERCURY_DESERT), "Mercurian Desert");
		add(getBiomeString(CelestialBiomeKeys.MERCURY_DEEP_CRATERED_PLAINS), "Mercurian Deep Cratered Plains");
		add(getBiomeString(CelestialBiomeKeys.MERCURY_PLAINS), "Mercurian Plains");
		add(getBiomeString(CelestialBiomeKeys.MERCURY_RIDGES), "Mercurian Ridges");
		add(getBiomeString(CelestialBiomeKeys.JUPITER_ETHER), "Jovian Ether");
		add(getBiomeString(CelestialBiomeKeys.JUPITER_LESSER_STORM), "Jovian Lesser Storm");
		add(getBiomeString(CelestialBiomeKeys.JUPITER_GREAT_STORM), "Jovian Greater Storm");
		add(getBiomeString(CelestialBiomeKeys.EUROPA_RIVER), "Europan River");
		add(getBiomeString(CelestialBiomeKeys.EUROPA_DESERT), "Europan Desert");
		add(getBiomeString(CelestialBiomeKeys.EUROPA_JAGGED_PLAINS), "Europan Jagged Plains");
		add(getBiomeString(CelestialBiomeKeys.EUROPA_OCEAN), "Europan Ocean");
		add(getBiomeString(CelestialBiomeKeys.EUROPA_LOWER_PLAINS), "Europan Lower Plains");
		add(getBiomeString(CelestialBiomeKeys.EUROPA_PLAINS), "Europan Plains");
		add(getBiomeString(CelestialBiomeKeys.CALLISTO_CRATERED_PLAINS), "Callistoan Cratered Desert");
		add(getBiomeString(CelestialBiomeKeys.CALLISTO_DESERT), "Callistoan Desert");
		add(getBiomeString(CelestialBiomeKeys.CALLISTO_LOWER_PLAINS), "Callistoan Lower Plains");
		add(getBiomeString(CelestialBiomeKeys.CALLISTO_PLAINS), "Callistoan Plains");

		add(getBiomeString(CelestialBiomeKeys.SPACE), "Outer Space");

		//---- DIMENSIONS -------------------------------------------------------------------------------
		add(getDimensionString(DimensionRegistry.SPACE), "Outer Space");
		add(getDimensionString(DimensionRegistry.MERCURY), "Mercury");
		add(getDimensionString(DimensionRegistry.VENUS), "Venus");
		add(getDimensionString(Level.OVERWORLD), "Overworld");
		add(getDimensionString(DimensionRegistry.MOON), "Moon");
		add(getDimensionString(DimensionRegistry.MARS), "Mars");
		add(getDimensionString(DimensionRegistry.JUPITER), "Jupiter");
		add(getDimensionString(DimensionRegistry.EUROPA), "Europa");
		add(getDimensionString(DimensionRegistry.CALLISTO), "Callisto");

		//---- MENUS -------------------------------------------------------------------------------
		add("container.celestialexploration.oxygen_compressor", "Oxygen Compressor");
		add("container.celestialexploration.workbench", "Workbench");

		//---- EFFECTS -------------------------------------------------------------------------------
		add(EffectRegistry.LOW_GRAVITY.get(), "Low Gravity");
		add(EffectRegistry.EXTRA_LOW_GRAVITY.get(), "Extra Low Gravity");
		add(EffectRegistry.HIGH_GRAVITY.get(), "High Gravity");

		//---- TABS -------------------------------------------------------------------------------
		add("itemGroup.celestial_blocks_tab", "Celestial Blocks");
		add("itemGroup.spaceship_tab", "Spaceship Items");
		add("itemGroup.celestial_misc_tab", "Celestial Items");

		//---- KEYBINDINGS -------------------------------------------------------------------------------
		add("key.categories.spaceship_controls", "Spaceship Controls");
		add("key.celestialexploration.flight_ascent", "Spaceship Ascent");
		add("key.celestialexploration.flight_descent", "Spaceship Descent");
		add("key.celestialexploration.turn_left", "Spaceship Strafe Left");
		add("key.celestialexploration.turn_right", "Spaceship Strafe Right");
		add("key.celestialexploration.open_spaceship_inventory", "Open Spaceship Inventory");
		add("key.celestialexploration.spaceship_light_travel", "Spaceship Light Speed Travel");


		//---- DAMAGE SOURCES -------------------------------------------------------------------------------
		add("death.attack.celestialexploration.touched_sun", "%1$s discovered the sun is hot");
		add("death.attack.celestialexploration.cold_floor", "%1$s got cold feet");
		add("death.attack.celestialexploration.sulfur", "%1$s tried to swim in sulfur");
		add("death.attack.celestialexploration.metallic_hydrogen", "%1$s drowned in death metal");
		add("death.attack.celestialexploration.dust_storm", "%1$s was sand blasted to death");


		//---- ADVANCEMENTS -------------------------------------------------------------------------------
		add("advancements.celestial.root.title", "Exploration");
		add("advancements.celestial.root.description", "Exploration of outer space");
		add("advancements.celestial.fly_into_sun.title", "Icarus");
		add("advancements.celestial.fly_into_sun.description", "Fly into the sun");
		add("advancements.celestial.enter_space.title", "To Infinity… and Beyond!");
		add("advancements.celestial.enter_space.description", "Enter space");
		add("advancements.celestial.enter_moon.title", "One Small Step For Man…");
		add("advancements.celestial.enter_moon.description", "Reach the moon");
		add("advancements.celestial.plant_potato.title", "The Best Botanist On This Planet");
		add("advancements.celestial.plant_potato.description", "Plant potatoes on Mars");
		add("advancements.celestial.enter_mars.title", "The Red Planet");
		add("advancements.celestial.enter_mars.description", "Reach Mars");
		add("advancements.celestial.enter_venus.title", "Goddess of Beauty… And Sulfur?");
		add("advancements.celestial.enter_venus.description", "Reach Venus");
		add("advancements.celestial.enter_mercury.title", "Runner Up Dwarf Planet");
		add("advancements.celestial.enter_mercury.description", "Reach Mercury");
		add("advancements.celestial.obtain_spacesuit.title", "Space Pajamas");
		add("advancements.celestial.obtain_spacesuit.description", "Acquire a spacesuit");
		add("advancements.celestial.obtain_spaceship.title", "Rocketman");
		add("advancements.celestial.obtain_spaceship.description", "Craft a spaceship");
		add("advancements.celestial.place_airlock.title", "Breathing Room");
		add("advancements.celestial.place_airlock.description", "Place an airlock door");
		add("advancements.celestial.kill_mob_in_space.title", "Space Invaders");
		add("advancements.celestial.kill_mob_in_space.description", "Defeat a mob in outer space");

		//---- SPACESHIP RELATED -------------------------------------------------------------------------------
		add("celestialexploration.spaceship.travel.mercury", "Travel to Mercury");
		add("celestialexploration.spaceship.travel.venus", "Travel to Venus");
		add("celestialexploration.spaceship.travel.overworld", "Travel to the Overworld");
		add("celestialexploration.spaceship.travel.mars", "Travel to Mars");
		add("celestialexploration.spaceship.travel.jupiter", "Travel to Jupiter");
		add("celestialexploration.spaceship.travel.message_1", "Press ");
		add("celestialexploration.spaceship.travel.message_2", " for light speed travel");
		add("celestialexploration.spaceship.travel.cooldown", "Light speed travel cooldown: ");

		add("celestialexploration.spaceship.tab.inventory", "Inventory");
		add("celestialexploration.spaceship.tab.light_travel", "Light Speed Travel");
		add("celestialexploration.spaceship.tab.light_travel_hint", "Access this feature when in space");

		//---- RECIPE-RELATED -------------------------------------------------------------------------------
		add("recipe.celestialexploration.workbench.smelting", "Workbench Smelting");
		add("recipe.celestialexploration.workbench.crafting", "Workbench Crafting");
		add("recipe.celestialexploration.workbench.blocks", "blocks");
		add("recipe.celestialexploration.workbench.ingots", "ingots");

		//---- ARMOR-RELATED -------------------------------------------------------------------------------
		add("item.celestialexploration.armor_details.when_worn", "When Worn");
		add("item.celestialexploration.armor_details.when_set_complete", "When Complete Set Worn");
		add("item.celestialexploration.armor_details.heavy_duty_full_spacesuit", "Grants jump boost");
		add("item.celestialexploration.armor_details.heavy_duty_spacesuit_helmet", "Negates liquid metallic hydrogen damage");
		add("item.celestialexploration.armor_details.heavy_duty_spacesuit_chestplate", "Piglin neutral");
		add("item.celestialexploration.armor_details.heavy_duty_spacesuit_boots", "Negates high gravity");
		add("item.celestialexploration.armor_details.thermal_full_spacesuit", "Grants speed boost");
		add("item.celestialexploration.armor_details.thermal_spacesuit_boots_1", "Negates low gravity");
		add("item.celestialexploration.armor_details.thermal_spacesuit_boots_2", "Can walk on powdered snow");


		//---- OTHER -------------------------------------------------------------------------------
		add("celestialexploration.planet_details.location", "Coordinates");
		add("celestialexploration.planet_details.moons", "Notable Moons");
		add("celestialexploration.planet_details.no_moons", "none");
		add("celestialexploration.planet_details.resources", "Notable Resources");

		add("celestialexploration.planet_details.sun_name", "The Sun");
		add("celestialexploration.planet_details.sun_resources", "none");

		add("celestialexploration.planet_details.mercury_name", "Mercury");
		add("celestialexploration.planet_details.mercury_resources", "meteors, coal, diamond");

		add("celestialexploration.planet_details.venus_name", "Venus");
		add("celestialexploration.planet_details.venus_resources", "sulfur, lapis lazuli");

		add("celestialexploration.planet_details.overworld_name", "Overworld");
		add("celestialexploration.planet_details.overworld_resources", "overworld/vanilla resources");
		add("celestialexploration.planet_details.overworld_moons", "Moon");

		add("celestialexploration.planet_details.mars_name", "Mars");
		add("celestialexploration.planet_details.mars_resources", "iron");

		add("celestialexploration.planet_details.jupiter_name", "Jupiter");
		add("celestialexploration.planet_details.jupiter_resources", "none");
		add("celestialexploration.planet_details.jupiter_moons", "Europa, IO (soon), Callisto (soon), Ganymede (soon)");

		add("celestialexploration.planet_details.saturn_name", "Saturn");
		add("celestialexploration.planet_details.saturn_resources", "TBD");
		add("celestialexploration.planet_details.saturn_moons", "TBD");

		add("celestialexploration.planet_details.uranus_name", "Uranus");
		add("celestialexploration.planet_details.uranus_resources", "TBD");
		add("celestialexploration.planet_details.uranus_moons", "TBD");

		add("celestialexploration.planet_details.neptune_name", "Neptune");
		add("celestialexploration.planet_details.neptune_resources", "TBD");
		add("celestialexploration.planet_details.neptune_moons", "TBD");

		add("item.celestialexploration.door.airlock_panel_door", "One hinge can support up to 7 wide (inclusive). Double hinge can support up to 14 wide (inclusive). No max height.");
		add("item.celestialexploration.door.hangar_door", "One hinge can support up to 32 wide (inclusive). Double hinge can support up to 64 wide (inclusive). No max height.");

		add("celestialexploration.spaceship.space_min_height", "Warning! Approaching dangerous depths of space!");



	}
}
