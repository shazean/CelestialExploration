package com.shim.celestialexploration.datagen;

import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestialexploration.registry.*;

import com.shim.celestialexploration.world.biome.CelestialBiomeKeys;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.LanguageProvider;
import net.minecraftforge.registries.RegistryObject;

import javax.annotation.Nullable;

public class CelestialLangProvider extends LanguageProvider {

	public CelestialLangProvider(DataGenerator gen, String locale) {
		super(gen, CelestialExploration.MODID, locale);
	}

	public void addBiome(ResourceKey<Biome> biome, String localization) {
		add("biome." + CelestialExploration.MODID + "." + biome.location().getPath(), localization);
	}

	public void addDimension(ResourceKey<Level> dimension, String localization) {
		add("dimension." + dimension.location().getNamespace() + "." + dimension.location().getPath(), localization);
	}

	public void addAdvancement(String advancement, String title, String description) {
		add("advancements." + CelestialExploration.MODID + "." + advancement + ".title", title);
		add("advancements." + CelestialExploration.MODID + "." + advancement + ".description", description);
	}

	public void addFluid(Block fluidBlock, String fluid, String localization) {
		add(fluidBlock, localization);
		add("fluid." + CelestialExploration.MODID + "." + fluid, localization);
	}

	public void addPlanetDetails(String dimensionName, String dimensionResources, @Nullable String dimensionMoons) {
		add("celestialexploration.planet_details." + dimensionName.toLowerCase() + "_name", dimensionName);
		add("celestialexploration.planet_details." + dimensionName.toLowerCase() + "_resources", dimensionResources);
		if (dimensionMoons != null)
			add("celestialexploration.planet_details." + dimensionName.toLowerCase() + "_moons", dimensionMoons);

	}

	@Override
	protected void addTranslations() {

		for (RegistryObject<? extends Block> block : CelestialBlocks.BLOCK_LANG_EN_US.keySet()) this.add(block.get(), CelestialBlocks.BLOCK_LANG_EN_US.get(block));
		for (RegistryObject<? extends Item> item : CelestialItems.ITEM_LANG_EN_US.keySet()) this.add(item.get(), CelestialItems.ITEM_LANG_EN_US.get(item));
		for (RegistryObject<? extends EntityType> entity : CelestialEntities.ENTITY_LANG_EN_US.keySet()) this.add(entity.get(), CelestialEntities.ENTITY_LANG_EN_US.get(entity));

		add("entity.minecraft.villager.celestialexploration.astronomer", "Astronomer");
		add("entity.minecraft.villager.celestialexploration.engineer", "Engineer");
		add("celestialexploration.villager.unemployed", "Unemployed");

		//---- FLUIDS -------------------------------------------------------------------------------
		addFluid(CelestialFluids.LOX_BLOCK.get(), "lox", "Molten Iron");
		addFluid(CelestialFluids.MOLTEN_IRON_BLOCK.get(), "molten_iron", "Molten Iron");
		addFluid(CelestialFluids.MOLTEN_STEEL_BLOCK.get(), "molten_steel", "Molten Steel");
		addFluid(CelestialFluids.MOLTEN_COPPER_BLOCK.get(), "molten_copper", "Molten Copper");
		addFluid(CelestialFluids.MOLTEN_GOLD_BLOCK.get(), "molten_gold","Molten Gold");
		addFluid(CelestialFluids.SULFUR_BLOCK.get(), "sulfur", "Sulfur");
		addFluid(CelestialFluids.MOLTEN_ALUMINUM_BLOCK.get(), "molten_aluminum", "Molten Aluminum");
		addFluid(CelestialFluids.METALLIC_HYDROGEN_BLOCK.get(), "metallic_hydrogen", "Liquid Metallic Hydrogen");
		add(CelestialFluids.METALLIC_HYDROGEN_BUCKET.get(),  "Liquid Metallic Hydrogen Bucket");
		add(CelestialFluids.SULFUR_BUCKET.get(), "Sulfur Bucket");

		//---- BIOMES -------------------------------------------------------------------------------
		addBiome(CelestialBiomeKeys.MILKY_WAY, "Milky Way");
		addBiome(CelestialBiomeKeys.MOON_CRATERS, "Lunar Craters");
		addBiome(CelestialBiomeKeys.MOON_DESERT, "Lunar Desert");
		addBiome(CelestialBiomeKeys.MOON_LAVA_FLATS, "Lunar Lava Flats");
		addBiome(CelestialBiomeKeys.MOON_LOWER_PLAINS, "Lunar Lower Plains");
		addBiome(CelestialBiomeKeys.MOON_PLAINS, "Lunar Plains");
		addBiome(CelestialBiomeKeys.MARS_CRATERS, "Martian Craters");
		addBiome(CelestialBiomeKeys.MARS_DEEP_CRATERS, "Martian Deep Craters");
		addBiome(CelestialBiomeKeys.MARS_DESERT, "Martian Desert");
		addBiome(CelestialBiomeKeys.MARS_DUNES, "Martian Dunes");
		addBiome(CelestialBiomeKeys.MARS_DRY_ICE_FLATS, "Martian Dry Ice Flats");
		addBiome(CelestialBiomeKeys.MARS_DRY_ICE_PEAKS, "Martian Dry Ice Peaks");
		addBiome(CelestialBiomeKeys.MARS_ERODED_FLATS, "Martian Eroded Flats");
		addBiome(CelestialBiomeKeys.MARS_VOLCANO_FLATS, "Martian Volcano Flats");
		addBiome(CelestialBiomeKeys.MARS_FLATS, "Martian Flats");
		addBiome(CelestialBiomeKeys.VENUS_DESERT, "Venusian Desert");
		addBiome(CelestialBiomeKeys.VENUS_LOWER_PLAINS, "Venusian Lower Plains");
		addBiome(CelestialBiomeKeys.VENUS_PLAINS, "Venusian Plains");
		addBiome(CelestialBiomeKeys.VENUS_SULFUR_FLATS, "Venusian Sulfur Flats");
		addBiome(CelestialBiomeKeys.SULFUR_RIVER, "Sulfuric River");
		addBiome(CelestialBiomeKeys.SULFUR_OCEAN, "Sulfuric Ocean");
		addBiome(CelestialBiomeKeys.MERCURY_CRATERED_PLAINS, "Mercurian Cratered Plains");
		addBiome(CelestialBiomeKeys.MERCURY_DESERT, "Mercurian Desert");
		addBiome(CelestialBiomeKeys.MERCURY_DEEP_CRATERED_PLAINS, "Mercurian Deep Cratered Plains");
		addBiome(CelestialBiomeKeys.MERCURY_PLAINS, "Mercurian Plains");
		addBiome(CelestialBiomeKeys.MERCURY_RIDGES, "Mercurian Ridges");
		addBiome(CelestialBiomeKeys.JUPITER_ETHER, "Jovian Ether");
		addBiome(CelestialBiomeKeys.JUPITER_LESSER_STORM, "Jovian Lesser Storm");
		addBiome(CelestialBiomeKeys.JUPITER_GREAT_STORM, "Jovian Greater Storm");
		addBiome(CelestialBiomeKeys.EUROPA_RIVER, "Europan River");
		addBiome(CelestialBiomeKeys.EUROPA_DESERT, "Europan Desert");
		addBiome(CelestialBiomeKeys.EUROPA_JAGGED_PLAINS, "Europan Jagged Plains");
		addBiome(CelestialBiomeKeys.EUROPA_OCEAN, "Europan Ocean");
		addBiome(CelestialBiomeKeys.EUROPA_LOWER_PLAINS, "Europan Lower Plains");
		addBiome(CelestialBiomeKeys.EUROPA_PLAINS, "Europan Plains");
		addBiome(CelestialBiomeKeys.CALLISTO_CRATERED_PLAINS, "Callistoan Cratered Desert");
		addBiome(CelestialBiomeKeys.CALLISTO_DESERT, "Callistoan Desert");
		addBiome(CelestialBiomeKeys.CALLISTO_LOWER_PLAINS, "Callistoan Lower Plains");
		addBiome(CelestialBiomeKeys.CALLISTO_PLAINS, "Callistoan Plains");
		addBiome(CelestialBiomeKeys.GANYMEDE_CRATERED_PLAINS, "Ganymedian Craters");
		addBiome(CelestialBiomeKeys.GANYMEDE_DESERT, "Ganymedian Desert");
		addBiome(CelestialBiomeKeys.GANYMEDE_LOWER_PLAINS, "Ganymedian Lower Plains");
		addBiome(CelestialBiomeKeys.GANYMEDE_PLAINS, "Ganymedian Plains");

		//---- DIMENSIONS -------------------------------------------------------------------------------
		addDimension(CelestialDimensions.MILKY_WAY, "Milky Way Galaxy");
		addDimension(CelestialDimensions.MERCURY, "Mercury");
		addDimension(CelestialDimensions.VENUS, "Venus");
		addDimension(Level.OVERWORLD, "Overworld");
		addDimension(CelestialDimensions.MOON, "Moon");
		addDimension(CelestialDimensions.MARS, "Mars");
		addDimension(CelestialDimensions.JUPITER, "Jupiter");
		addDimension(CelestialDimensions.EUROPA, "Europa");
		addDimension(CelestialDimensions.CALLISTO, "Callisto");
		addDimension(CelestialDimensions.GANYMEDE, "Ganymede");
		addDimension(CelestialDimensions.IO, "Io");

		//---- MENUS -------------------------------------------------------------------------------
		add("container.celestialexploration.oxygen_compressor", "Oxygen Compressor");
		add("container.celestialexploration.workbench", "Workbench");

		//---- EFFECTS -------------------------------------------------------------------------------
		add(CelestialEffects.STATIC_EFFECT.get(), "Static Build Up");

		//---- TABS -------------------------------------------------------------------------------
		add("itemGroup.celestial_blocks_tab", "Celestial Blocks");
		add("itemGroup.spaceship_tab", "Spaceship Items");
		add("itemGroup.celestial_misc_tab", "Celestial Items");

		//---- KEYBINDINGS -------------------------------------------------------------------------------
		add("key.categories.vehicle_controls", "Vehicle Controls");
		add("key.celestialexploration.flight_ascent", "Vehicle Ascent");
		add("key.celestialexploration.flight_descent", "Vehicle Descent");
		add("key.celestialexploration.turn_left", "Vehicle Strafe Left");
		add("key.celestialexploration.turn_right", "vehicle Strafe Right");
		add("key.celestialexploration.open_vehicle_inventory", "Open Vehicle Inventory");

		//---- DAMAGE SOURCES -------------------------------------------------------------------------------
		add("death.attack.celestialexploration.touched_sun", "%1$s discovered the sun is hot");
		add("death.attack.celestialexploration.cold_floor", "%1$s got cold feet");
		add("death.attack.celestialexploration.sulfur", "%1$s tried to swim in sulfur");
		add("death.attack.celestialexploration.metallic_hydrogen", "%1$s drowned in death metal");
		add("death.attack.celestialexploration.dust_storm", "%1$s was sand blasted to death");

		//---- ADVANCEMENTS -------------------------------------------------------------------------------
		addAdvancement("root", "Exploration","Exploration of outer space");
		addAdvancement("fly_into_sun", "Icarus","Fly into the sun");
		addAdvancement("plant_potato", "Best Botanist On This Planet","Plant potatoes on Mars");
		addAdvancement("obtain_spacesuit", "Space Pajamas","Acquire a spacesuit");
		addAdvancement("obtain_spaceship", "Rocketman","Craft a spaceship");
		addAdvancement("place_airlock", "Breathing Room","Place an airlock door");
		addAdvancement("kill_mob_in_space", "Space Invaders","Defeat a mob in outer space");
		addAdvancement("all_mechadogs", "Gotta Catch 'Em All","Collect all colors of the MechaDogs");

		addAdvancement("enter_milky_way", "To Infinity… and Beyond!","Enter Milky Way");
		addAdvancement("enter_moon", "One Small Step For Man…","Reach the moon");
		addAdvancement("enter_mars", "The Red Planet","Reach Mars");
		addAdvancement("enter_venus", "Goddess of Beauty… And Sulfur?","Reach Venus");
		addAdvancement("enter_mercury", "Runner Up Dwarf Planet","Reach Mercury");
		addAdvancement("enter_jupiter", "The Giant Gas Giant","Reach Jupiter");
		addAdvancement("enter_io", "Jupiter I","Reach Io");
		addAdvancement("enter_europa", "Jupiter II","Reach Europa");
		addAdvancement("enter_callisto", "Jupiter IV","Reach Callisto");
		addAdvancement("enter_ganymede", "Jupiter III","Reach Ganymede");

		addAdvancement("blue_display_board", "B.S.O.D.","Acquire a blue display board");


		//---- SPACESHIP RELATED -------------------------------------------------------------------------------
		add("celestialexploration.spaceship.travel.mercury", "Travel to Mercury");
		add("celestialexploration.spaceship.travel.venus", "Travel to Venus");
		add("celestialexploration.spaceship.travel.overworld", "Travel to the Overworld");
		add("celestialexploration.spaceship.travel.mars", "Travel to Mars");
		add("celestialexploration.spaceship.travel.jupiter", "Travel to Jupiter");
		add("celestialexploration.spaceship.travel.message_1", "Press ");
		add("celestialexploration.spaceship.travel.message_2", " for light speed travel");
		add("celestialexploration.spaceship.travel.cooldown", "Light speed travel cooldown: ");

		add("celestialexploration.spaceship.travel_unavailable", "Light speed travel unavailable at this location");

		add("celestialexploration.spaceship.tab.inventory", "Inventory");
		add("celestialexploration.spaceship.tab.light_travel", "Light Speed Travel");
		add("celestialexploration.spaceship.tab.light_travel_hint", "Access this feature when in space");

		add("celestialexploration.spaceship.space_min_height", "Warning! Approaching dangerous depths of space!");

		//---- RECIPE-RELATED -------------------------------------------------------------------------------
		add("recipe.celestialexploration.workbench.smelting", "Workbench Smelting");
		add("recipe.celestialexploration.workbench.crafting", "Workbench Crafting");
		add("recipe.celestialexploration.workbench.blocks", "blocks");
		add("recipe.celestialexploration.workbench.ingots", "ingots");
		add("recipe.celestialexploration.mechacrow.crafting", "MechaCrow Crafting");

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

		addPlanetDetails("Mercury", "meteors, coal, diamond", null);
		addPlanetDetails("Venus", "sulfur, lapis lazuli", null);
		addPlanetDetails("Overworld", "overworld/vanilla resources", "Moon");
		addPlanetDetails("Mars", "iron", null);
		addPlanetDetails("Jupiter", "none", "Europa, Io, Calliso, Ganymede");
		addPlanetDetails("Saturn", "TBD", "TBD");
		addPlanetDetails("Uranus", "TBD", "TBD");
		addPlanetDetails("Neptune", "TBD", "TBD");


		add("item.celestialexploration.door.airlock_panel_door", "One hinge can support up to 7 wide (inclusive).\nDouble hinge can support up to 14 wide (inclusive).\nNo max height.");
		add("item.celestialexploration.door.hangar_door", "One hinge can support up to 32 wide (inclusive).\nDouble hinge can support up to 64 wide (inclusive).\nNo max height.");

		add("celestialexploration.display_board.edit", "Edit Display Board Message");
	}
}