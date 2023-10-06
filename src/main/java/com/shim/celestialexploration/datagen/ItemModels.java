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
		/**
		 * MOON
		 */
		withExistingParent(ItemRegistry.MOON_BRICKS.get().getRegistryName().getPath(), modLoc("block/moon_bricks"));
		withExistingParent(ItemRegistry.MOON_IRON_ORE.get().getRegistryName().getPath(), modLoc("block/moon_iron_ore"));
		withExistingParent(ItemRegistry.MOON_REDSTONE_ORE.get().getRegistryName().getPath(), modLoc("block/moon_redstone_ore"));
		withExistingParent(ItemRegistry.MOON_SAND.get().getRegistryName().getPath(), modLoc("block/moon_sand"));
		withExistingParent(ItemRegistry.MOON_STONE.get().getRegistryName().getPath(), modLoc("block/moon_stone"));
		withExistingParent(ItemRegistry.CHISELED_MOON_BRICKS.get().getRegistryName().getPath(), modLoc("block/chiseled_moon_bricks"));
		withExistingParent(ItemRegistry.GLOWING_MOON_SAND.get().getRegistryName().getPath(), modLoc("block/glowing_moon_sand"));
		withExistingParent(ItemRegistry.LUNAR_LANTERN.get().getRegistryName().getPath(), modLoc("block/lunar_lantern"));

		stairs("moon_brick_stairs", modLoc("block/moon_bricks"), modLoc("block/moon_bricks"), modLoc("block/moon_bricks"));
		slab("moon_brick_slab", modLoc("block/moon_bricks"), modLoc("block/moon_bricks"), modLoc("block/moon_bricks"));
		wallInventory("moon_brick_wall",  modLoc("block/moon_bricks"));

		/**
		 * MARS
		 */
		withExistingParent(ItemRegistry.CHISELED_MARS_BRICKS.get().getRegistryName().getPath(), modLoc("block/chiseled_mars_bricks"));
		withExistingParent(ItemRegistry.MARS_BRICKS.get().getRegistryName().getPath(), modLoc("block/mars_bricks"));
		withExistingParent(ItemRegistry.MARS_IRON_ORE.get().getRegistryName().getPath(), modLoc("block/mars_iron_ore"));
		withExistingParent(ItemRegistry.MARS_REDSTONE_ORE.get().getRegistryName().getPath(), modLoc("block/mars_redstone_ore"));
		withExistingParent(ItemRegistry.MARS_STONE.get().getRegistryName().getPath(), modLoc("block/mars_stone"));
		withExistingParent(ItemRegistry.MARS_SAND.get().getRegistryName().getPath(), modLoc("block/mars_sand"));
		stairs("mars_brick_stairs", modLoc("block/mars_bricks"), modLoc("block/mars_bricks"), modLoc("block/mars_bricks"));
		slab("mars_brick_slab", modLoc("block/mars_bricks"), modLoc("block/mars_bricks"), modLoc("block/mars_bricks"));
		wallInventory("mars_brick_wall",  modLoc("block/mars_bricks"));


		/**
		 * METEOR
		 */
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


		/**
		 * OTHER BLOCK ITEMS
		 */
//		withExistingParent(ItemRegistry.SOLAR_PANEL.get().getRegistryName().getPath(), modLoc("block/solar_panel"));
//		withExistingParent(ItemRegistry.SOLAR_LANTERN.get().getRegistryName().getPath(), modLoc("block/solar_lantern"));
//		withExistingParent(ItemRegistry.IGNEOUS_ROCK.get().getRegistryName().getPath(), modLoc("block/igneous_rock"));
//		withExistingParent(ItemRegistry.ECLIPSE_LANTERN.get().getRegistryName().getPath(), modLoc("block/eclipse_lantern"));


		/**
		 * ITEMS (not belonging to blocks)
		 */
		singleTexture(ItemRegistry.MOON_DUST.get().getRegistryName().getPath(), new ResourceLocation("item/handheld"), "layer0", new ResourceLocation(CelestialExploration.MODID, "item/moon_dust"));
		singleTexture(ItemRegistry.STEEL_INGOT.get().getRegistryName().getPath(), new ResourceLocation("item/handheld"), "layer0", new ResourceLocation(CelestialExploration.MODID, "item/steel_ingot"));
		singleTexture(ItemRegistry.STEEL_ROD.get().getRegistryName().getPath(), new ResourceLocation("item/handheld"), "layer0", new ResourceLocation(CelestialExploration.MODID, "item/steel_rod"));
		singleTexture(ItemRegistry.LOX_BUCKET.get().getRegistryName().getPath(), new ResourceLocation("item/handheld"), "layer0", new ResourceLocation(CelestialExploration.MODID, "item/lox_bucket"));

		/**
		 * ARMOR
		 */
		singleTexture(ItemRegistry.STEEL_HELMET.get().getRegistryName().getPath(), new ResourceLocation("item/handheld"), "layer0", new ResourceLocation(CelestialExploration.MODID, "item/steel_helmet"));
		singleTexture(ItemRegistry.STEEL_LEGGINGS.get().getRegistryName().getPath(), new ResourceLocation("item/handheld"), "layer0", new ResourceLocation(CelestialExploration.MODID, "item/steel_leggings"));
		singleTexture(ItemRegistry.STEEL_CHESTPLATE.get().getRegistryName().getPath(), new ResourceLocation("item/handheld"), "layer0", new ResourceLocation(CelestialExploration.MODID, "item/steel_chestplate"));
		singleTexture(ItemRegistry.STEEL_BOOTS.get().getRegistryName().getPath(), new ResourceLocation("item/handheld"), "layer0", new ResourceLocation(CelestialExploration.MODID, "item/steel_boots"));
		singleTexture(ItemRegistry.SPACE_SUIT_HELMET.get().getRegistryName().getPath(), new ResourceLocation("item/handheld"), "layer0", new ResourceLocation(CelestialExploration.MODID, "item/space_suit_helmet"));
		singleTexture(ItemRegistry.SPACE_SUIT_LEGGINGS.get().getRegistryName().getPath(), new ResourceLocation("item/handheld"), "layer0", new ResourceLocation(CelestialExploration.MODID, "item/space_suit_leggings"));
		singleTexture(ItemRegistry.SPACE_SUIT_CHESTPLATE.get().getRegistryName().getPath(), new ResourceLocation("item/handheld"), "layer0", new ResourceLocation(CelestialExploration.MODID, "item/space_suit_chestplate"));
		singleTexture(ItemRegistry.SPACE_SUIT_BOOTS.get().getRegistryName().getPath(), new ResourceLocation("item/handheld"), "layer0", new ResourceLocation(CelestialExploration.MODID, "item/space_suit_boots"));

		/**
		 * SHUTTLE ITEMS
		 */
		singleTexture(ItemRegistry.BLACK_SHUTTLE.get().getRegistryName().getPath(), new ResourceLocation("item/handheld"), "layer0", new ResourceLocation(CelestialExploration.MODID, "item/black_shuttle"));
		singleTexture(ItemRegistry.GREY_SHUTTLE.get().getRegistryName().getPath(), new ResourceLocation("item/handheld"), "layer0", new ResourceLocation(CelestialExploration.MODID, "item/grey_shuttle"));
		singleTexture(ItemRegistry.LIGHT_GREY_SHUTTLE.get().getRegistryName().getPath(), new ResourceLocation("item/handheld"), "layer0", new ResourceLocation(CelestialExploration.MODID, "item/light_grey_shuttle"));
		singleTexture(ItemRegistry.WHITE_SHUTTLE.get().getRegistryName().getPath(), new ResourceLocation("item/handheld"), "layer0", new ResourceLocation(CelestialExploration.MODID, "item/white_shuttle"));
		singleTexture(ItemRegistry.PINK_SHUTTLE.get().getRegistryName().getPath(), new ResourceLocation("item/handheld"), "layer0", new ResourceLocation(CelestialExploration.MODID, "item/pink_shuttle"));
		singleTexture(ItemRegistry.MAGENTA_SHUTTLE.get().getRegistryName().getPath(), new ResourceLocation("item/handheld"), "layer0", new ResourceLocation(CelestialExploration.MODID, "item/magenta_shuttle"));
		singleTexture(ItemRegistry.RED_SHUTTLE.get().getRegistryName().getPath(), new ResourceLocation("item/handheld"), "layer0", new ResourceLocation(CelestialExploration.MODID, "item/red_shuttle"));
		singleTexture(ItemRegistry.BROWN_SHUTTLE.get().getRegistryName().getPath(), new ResourceLocation("item/handheld"), "layer0", new ResourceLocation(CelestialExploration.MODID, "item/brown_shuttle"));
		singleTexture(ItemRegistry.ORANGE_SHUTTLE.get().getRegistryName().getPath(), new ResourceLocation("item/handheld"), "layer0", new ResourceLocation(CelestialExploration.MODID, "item/orange_shuttle"));
		singleTexture(ItemRegistry.YELLOW_SHUTTLE.get().getRegistryName().getPath(), new ResourceLocation("item/handheld"), "layer0", new ResourceLocation(CelestialExploration.MODID, "item/yellow_shuttle"));
		singleTexture(ItemRegistry.LIME_SHUTTLE.get().getRegistryName().getPath(), new ResourceLocation("item/handheld"), "layer0", new ResourceLocation(CelestialExploration.MODID, "item/lime_shuttle"));
		singleTexture(ItemRegistry.GREEN_SHUTTLE.get().getRegistryName().getPath(), new ResourceLocation("item/handheld"), "layer0", new ResourceLocation(CelestialExploration.MODID, "item/green_shuttle"));
		singleTexture(ItemRegistry.CYAN_SHUTTLE.get().getRegistryName().getPath(), new ResourceLocation("item/handheld"), "layer0", new ResourceLocation(CelestialExploration.MODID, "item/cyan_shuttle"));
		singleTexture(ItemRegistry.LIGHT_BLUE_SHUTTLE.get().getRegistryName().getPath(), new ResourceLocation("item/handheld"), "layer0", new ResourceLocation(CelestialExploration.MODID, "item/light_blue_shuttle"));
		singleTexture(ItemRegistry.BLUE_SHUTTLE.get().getRegistryName().getPath(), new ResourceLocation("item/handheld"), "layer0", new ResourceLocation(CelestialExploration.MODID, "item/blue_shuttle"));
		singleTexture(ItemRegistry.PURPLE_SHUTTLE.get().getRegistryName().getPath(), new ResourceLocation("item/handheld"), "layer0", new ResourceLocation(CelestialExploration.MODID, "item/purple_shuttle"));

		/**
		 * SHUTTLE-RELATED ITEMS
		*/
//		withExistingParent(ItemRegistry.ASSEMBLY_STATION.get().getRegistryName().getPath(), modLoc("block/assembly_station"));
		withExistingParent(ItemRegistry.OXYGEN_COMPRESSOR.get().getRegistryName().getPath(), modLoc("block/oxygen_compressor"));
		withExistingParent(ItemRegistry.STEEL_BLOCK.get().getRegistryName().getPath(), modLoc("block/steel_block"));
		withExistingParent(ItemRegistry.CERAMIC.get().getRegistryName().getPath(), modLoc("block/ceramic"));
		singleTexture(ItemRegistry.CERAMIC_TILE.get().getRegistryName().getPath(), new ResourceLocation("item/handheld"), "layer0", new ResourceLocation(CelestialExploration.MODID, "block/ceramic"));
		withExistingParent(ItemRegistry.STEEL_FRAME.get().getRegistryName().getPath(), modLoc("block/steel_frame"));
		singleTexture(ItemRegistry.SHUTTLE_FRAME.get().getRegistryName().getPath(), new ResourceLocation("item/handheld"), "layer0", new ResourceLocation(CelestialExploration.MODID, "item/shuttle_frame"));
		singleTexture(ItemRegistry.SHUTTLE_CABIN.get().getRegistryName().getPath(), new ResourceLocation("item/handheld"), "layer0", new ResourceLocation(CelestialExploration.MODID, "item/shuttle_cabin"));
		singleTexture(ItemRegistry.NOSE_CONE.get().getRegistryName().getPath(), new ResourceLocation("item/handheld"), "layer0", new ResourceLocation(CelestialExploration.MODID, "item/nose_cone"));
		singleTexture(ItemRegistry.SHUTTLE_ENGINE.get().getRegistryName().getPath(), new ResourceLocation("item/handheld"), "layer0", new ResourceLocation(CelestialExploration.MODID, "item/shuttle_engine"));

		//TODO
//		withExistingParent(ItemRegistry.WHITE_CERAMIC.get().getRegistryName().getPath(), modLoc("block/white_ceramic"));
//		withExistingParent(ItemRegistry.LIGHT_GREY_CERAMIC.get().getRegistryName().getPath(), modLoc("block/light_grey_ceramic"));
//		withExistingParent(ItemRegistry.GREY_CERAMIC.get().getRegistryName().getPath(), modLoc("block/grey_ceramic"));
//		withExistingParent(ItemRegistry.BLACK_CERAMIC.get().getRegistryName().getPath(), modLoc("block/black_ceramic"));
//		withExistingParent(ItemRegistry.PURPLE_CERAMIC.get().getRegistryName().getPath(), modLoc("block/purple_ceramic"));
//		withExistingParent(ItemRegistry.MAGENTA_CERAMIC.get().getRegistryName().getPath(), modLoc("block/magenta_ceramic"));
//		withExistingParent(ItemRegistry.BLUE_CERAMIC.get().getRegistryName().getPath(), modLoc("block/blue_ceramic"));
//		withExistingParent(ItemRegistry.LIGHT_BLUE_CERAMIC.get().getRegistryName().getPath(), modLoc("block/light_blue_ceramic"));
//		withExistingParent(ItemRegistry.CYAN_CERAMIC.get().getRegistryName().getPath(), modLoc("block/cyan_ceramic"));
//		withExistingParent(ItemRegistry.GREEN_CERAMIC.get().getRegistryName().getPath(), modLoc("block/green_ceramic"));
//		withExistingParent(ItemRegistry.LIME_CERAMIC.get().getRegistryName().getPath(), modLoc("block/lime_ceramic"));
//		withExistingParent(ItemRegistry.YELLOW_CERAMIC.get().getRegistryName().getPath(), modLoc("block/yellow_ceramic"));
//		withExistingParent(ItemRegistry.ORANGE_CERAMIC.get().getRegistryName().getPath(), modLoc("block/orange_ceramic"));
//		withExistingParent(ItemRegistry.BROWN_CERAMIC.get().getRegistryName().getPath(), modLoc("block/brown_ceramic"));
//		withExistingParent(ItemRegistry.RED_CERAMIC.get().getRegistryName().getPath(), modLoc("block/red_ceramic"));
//		withExistingParent(ItemRegistry.PINK_CERAMIC.get().getRegistryName().getPath(), modLoc("block/pink_ceramic"));

	}
}





