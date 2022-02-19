package com.shim.celestialexploration.datagen;

import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestialexploration.registry.BlockRegistry;
import com.shim.celestialexploration.registry.ItemRegistry;

import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ItemModels extends ItemModelProvider {

	public ItemModels(DataGenerator generator, ExistingFileHelper existingFileHelper) {
		super(generator, CelestialExploration.MODID, existingFileHelper);
	}
	
	@Override
	protected void registerModels() {
		//MOON
		withExistingParent(ItemRegistry.MOON_BRICKS.get().getRegistryName().getPath(), modLoc("block/moon_bricks"));
		withExistingParent(ItemRegistry.MOON_IRON_ORE.get().getRegistryName().getPath(), modLoc("block/moon_iron_ore"));
		withExistingParent(ItemRegistry.MOON_REDSTONE.get().getRegistryName().getPath(), modLoc("block/moon_redstone_ore"));
		withExistingParent(ItemRegistry.MOON_SAND.get().getRegistryName().getPath(), modLoc("block/moon_sand"));
		withExistingParent(ItemRegistry.MOON_STONE.get().getRegistryName().getPath(), modLoc("block/moon_stone"));
		withExistingParent(ItemRegistry.CHISELED_MOON_BRICKS.get().getRegistryName().getPath(), modLoc("block/chiseled_moon_bricks"));
		withExistingParent(ItemRegistry.GLOWING_MOON_SAND.get().getRegistryName().getPath(), modLoc("block/glowing_moon_sand"));
		withExistingParent(ItemRegistry.LUNAR_LANTERN.get().getRegistryName().getPath(), modLoc("block/lunar_lantern"));

		stairs("moon_brick_stairs", modLoc("block/moon_bricks"), modLoc("block/moon_bricks"), modLoc("block/moon_bricks"));
		slab("moon_brick_slab", modLoc("block/moon_bricks"), modLoc("block/moon_bricks"), modLoc("block/moon_bricks"));
		wallInventory("moon_brick_wall",  modLoc("block/moon_bricks"));
		
		//MARS
		withExistingParent(ItemRegistry.CHISELED_MARS_BRICKS.get().getRegistryName().getPath(), modLoc("block/chiseled_mars_bricks"));
		withExistingParent(ItemRegistry.MARS_BRICKS.get().getRegistryName().getPath(), modLoc("block/mars_bricks"));
		withExistingParent(ItemRegistry.MARS_IRON_ORE.get().getRegistryName().getPath(), modLoc("block/mars_iron_ore"));
		withExistingParent(ItemRegistry.MARS_REDSTONE_ORE.get().getRegistryName().getPath(), modLoc("block/mars_redstone_ore"));
		withExistingParent(ItemRegistry.MARS_STONE.get().getRegistryName().getPath(), modLoc("block/mars_stone"));
		withExistingParent(ItemRegistry.MARS_SAND.get().getRegistryName().getPath(), modLoc("block/mars_sand"));
		stairs("mars_brick_stairs", modLoc("block/mars_bricks"), modLoc("block/mars_bricks"), modLoc("block/mars_bricks"));
		slab("mars_brick_slab", modLoc("block/mars_bricks"), modLoc("block/mars_bricks"), modLoc("block/mars_bricks"));
		wallInventory("mars_brick_wall",  modLoc("block/mars_bricks"));

		
		//METEOR
		withExistingParent(ItemRegistry.METEOR.get().getRegistryName().getPath(), modLoc("block/meteor"));
		withExistingParent(ItemRegistry.METEOR_BRICKS.get().getRegistryName().getPath(), modLoc("block/meteor_bricks"));
		withExistingParent(ItemRegistry.METEOR_COAL_ORE.get().getRegistryName().getPath(), modLoc("block/meteor_coal_ore"));
		withExistingParent(ItemRegistry.METEOR_COPPER_ORE.get().getRegistryName().getPath(), modLoc("block/meteor_copper_ore"));
		withExistingParent(ItemRegistry.METEOR_DIAMOND_ORE.get().getRegistryName().getPath(), modLoc("block/meteor_diamond_ore"));
		withExistingParent(ItemRegistry.METEOR_EMERALD_ORE.get().getRegistryName().getPath(), modLoc("block/meteor_emerald_ore"));
		withExistingParent(ItemRegistry.METEOR_GOLD_ORE.get().getRegistryName().getPath(), modLoc("block/meteor_gold_ore"));
		withExistingParent(ItemRegistry.METEOR_IRON_ORE.get().getRegistryName().getPath(), modLoc("block/meteor_iron_ore"));
		withExistingParent(ItemRegistry.METEOR_LAPIS_ORE.get().getRegistryName().getPath(), modLoc("block/meteor_lapis_ore"));
		withExistingParent(ItemRegistry.METEOR_REDSTONE_ORE.get().getRegistryName().getPath(), modLoc("block/meteor_redstone_ore"));
		withExistingParent(ItemRegistry.CHISELED_METEOR_BRICKS.get().getRegistryName().getPath(), modLoc("block/chiseled_meteor_bricks"));
		stairs("meteor_brick_stairs", modLoc("block/meteor_bricks"), modLoc("block/meteor_bricks"), modLoc("block/meteor_bricks"));
		slab("meteor_brick_slab", modLoc("block/meteor_bricks"), modLoc("block/meteor_bricks"), modLoc("block/meteor_bricks"));
		wallInventory("meteor_brick_wall",  modLoc("block/meteor_bricks"));


		//OTHER BLOCK ITEMS
		withExistingParent(ItemRegistry.SOLAR_PANEL.get().getRegistryName().getPath(), modLoc("block/solar_panel"));
		withExistingParent(ItemRegistry.SOLAR_LANTERN.get().getRegistryName().getPath(), modLoc("block/solar_lantern"));
		withExistingParent(ItemRegistry.ECLIPSE_LANTERN.get().getRegistryName().getPath(), modLoc("block/eclipse_lantern"));

		//ITEMS
		//moon dust, etc.
		singleTexture(ItemRegistry.MOON_DUST.get().getRegistryName().getPath(), new ResourceLocation("item/handheld"), "layer0", new ResourceLocation(CelestialExploration.MODID, "item/moon_dust"));
		singleTexture(ItemRegistry.STEEL_INGOT.get().getRegistryName().getPath(), new ResourceLocation("item/handheld"), "layer0", new ResourceLocation(CelestialExploration.MODID, "item/steel_ingot"));
		singleTexture(ItemRegistry.STEEL_ROD.get().getRegistryName().getPath(), new ResourceLocation("item/handheld"), "layer0", new ResourceLocation(CelestialExploration.MODID, "item/steel_rod"));

	}
}