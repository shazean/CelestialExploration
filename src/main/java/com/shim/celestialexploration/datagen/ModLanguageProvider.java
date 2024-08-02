package com.shim.celestialexploration.datagen;

import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestialexploration.registry.*;

import net.minecraft.data.DataGenerator;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.LanguageProvider;
import net.minecraftforge.registries.RegistryObject;

public class ModLanguageProvider extends LanguageProvider {

	public ModLanguageProvider(DataGenerator gen, String locale) {
		super(gen, CelestialExploration.MODID, locale);
	}

	@Override
	protected void addTranslations() {

		for (RegistryObject<? extends Block> block : BlockRegistry.BLOCK_LANG_EN_US.keySet()) this.add(block.get(), BlockRegistry.BLOCK_LANG_EN_US.get(block));
		for (RegistryObject<? extends Item> item : ItemRegistry.ITEM_LANG_EN_US.keySet()) this.add(item.get(), ItemRegistry.ITEM_LANG_EN_US.get(item));
		for (RegistryObject<? extends EntityType> entity : EntityRegistry.ENTITY_LANG_EN_US.keySet()) this.add(entity.get(), EntityRegistry.ENTITY_LANG_EN_US.get(entity));

//		//---- SPACESHIP -------------------------------------------------------------------------------
//		add(EntityRegistry.SPACESHIP.get(), "Spaceship");
//
//		//---- MAG LEV -------------------------------------------------------------------------------
//		add(EntityRegistry.MAGCART.get(), "Magcart");
//		add(EntityRegistry.CHEST_MAGCART.get(), "Chest Magcart");
//		add(EntityRegistry.COMMAND_BLOCK_MAGCART.get(), "Command Block Magcart");
//		add(EntityRegistry.FURNACE_MAGCART.get(), "Furnace Magcart");
//		add(EntityRegistry.HOPPER_MAGCART.get(), "Hopper Magcart");
//		add(EntityRegistry.SPAWNER_MAGCART.get(), "Spawner Magcart");
//		add(EntityRegistry.TNT_MAGCART.get(), "TNT Magcart");
//
//		//---- MOBS -------------------------------------------------------------------------------
//		add(EntityRegistry.LUNAR_SLIME.get(), "Lunar Slime");
//		add(EntityRegistry.MARS_MALLOW.get(), "Mars Mallow");
//		add(EntityRegistry.RUST_SLIME.get(), "Rust Slime");
//		add(EntityRegistry.LURKER.get(), "Lurker");
//		add(EntityRegistry.VOIDFELLOW.get(), "Space Fellow");
//		add(EntityRegistry.VOIDED.get(), "Voided");
//		add(EntityRegistry.SULFUR_CUBE.get(), "Sulfur Cube");
//		add(EntityRegistry.VOIDED_PIGLIN.get(), "Voided Piglin");
//		add(EntityRegistry.FLARE.get(), "Flare");
//		add(EntityRegistry.GUST.get(), "Gust");
//		add(EntityRegistry.ASTRAL_PIGLIN.get(), "Astral Piglin");
//		add(EntityRegistry.ASTRAL_HOGLIN.get(), "Astral Hoglin");
//		add(EntityRegistry.VOIDED_ZOGLIN.get(), "Voided Zoglin");

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

		//---- BIOMES -------------------------------------------------------------------------------
		add("biome.celestialexploration.moon_craters", "Lunar Craters");
		add("biome.celestialexploration.moon_desert", "Lunar Desert");
		add("biome.celestialexploration.moon_lava_flats", "Lunar Lava Flats");
		add("biome.celestialexploration.moon_lower_plains", "Lunar Lower Plains");
		add("biome.celestialexploration.moon_plains", "Lunar Plains");
		add("biome.celestialexploration.mars_craters_", "Martian Craters");
		add("biome.celestialexploration.mars_deep_craters", "Martian Deep Craters");
		add("biome.celestialexploration.mars_desert", "Martian Desert");
		add("biome.celestialexploration.mars_dunes", "Martian Dunes");
		add("biome.celestialexploration.mars_dry_ice_flats", "Martian Dry Ice Flats");
		add("biome.celestialexploration.mars_dry_ice_peaks", "Martian Dry Ice Peaks");
		add("biome.celestialexploration.mars_eroded_flats", "Martian Eroded Flats");
		add("biome.celestialexploration.mars_volcano_flats", "Martian Volcano Flats");
		add("biome.celestialexploration.venus_desert", "Venusian Desert");
		add("biome.celestialexploration.venus_lower_plains", "Venusian Lower Plains");
		add("biome.celestialexploration.venus_plains", "Venusian Plains");
		add("biome.celestialexploration.venus_sulfur_flats", "Venusian Sulfur Flats");
		add("biome.celestialexploration.space", "Space");

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

		//---- DAMAGE SOURCES -------------------------------------------------------------------------------
		add("death.attack.celestialexploration.touchedSun", "%1$s discovered the heat of the sun");
		add("death.attack.celestialexploration.coldFloor", "%1$s got cold feet");

		//---- ADVANCEMENTS -------------------------------------------------------------------------------
		add("advancements.celestial.fly_into_sun.title", "Icarus");
		add("advancements.celestial.fly_into_sun.description", "Fly into the sun");
		add("advancements.celestial.enter_space.title", "To Infinity… And Beyond!");
		add("advancements.celestial.enter_space.description", "Enter space");
		add("advancements.celestial.enter_moon.title", "One Small Step For Man…");
		add("advancements.celestial.enter_moon.description", "Reach the moon");
		add("advancements.celestial.plant_potato.title", "The Best Botanist On This Planet");
		add("advancements.celestial.plant_potato.description", "Plant potatoes on Mars");
	}
}
