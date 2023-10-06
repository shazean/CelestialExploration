package com.shim.celestialexploration.datagen;

import java.util.function.Consumer;

import com.shim.celestialexploration.registry.BlockRegistry;

import com.shim.celestialexploration.registry.ItemRegistry;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.core.Registry;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.*;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.StonecutterRecipe;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.Tags;


public class Recipes extends RecipeProvider {

	public Recipes(DataGenerator generatorIn) {
		super(generatorIn);
	}
	
	@Override
	protected void buildCraftingRecipes(Consumer<FinishedRecipe> consumer) {
		//TODO check/update experience granted arguments

		/**MOON*/
		SimpleCookingRecipeBuilder.smelting(Ingredient.of(BlockRegistry.MOON_SAND.get()), Items.WHITE_STAINED_GLASS, 1.0F, 100)
				.unlockedBy("has_moon_sand", has(BlockRegistry.MOON_SAND.get())).save(consumer, "moon_sand");

		ShapedRecipeBuilder.shaped(BlockRegistry.LUNAR_LANTERN.get())
				.pattern("XCX")
				.pattern("CCC")
				.pattern("XCX")
				.define('X', Items.IRON_INGOT)
				.define('C', ItemRegistry.MOON_DUST.get())
				.group("celestialexploration")
				.unlockedBy("has_moon_dust", InventoryChangeTrigger.TriggerInstance.hasItems(ItemRegistry.MOON_DUST.get()))
				.save(consumer);

		ShapedRecipeBuilder.shaped(BlockRegistry.MOON_BRICKS.get())
				.pattern("XX")
				.pattern("XX")
				.define('X', BlockRegistry.MOON_STONE.get())
				.group("celestialexploration")
				.unlockedBy("moon_stone", InventoryChangeTrigger.TriggerInstance.hasItems(BlockRegistry.MOON_STONE.get()))
				.save(consumer);
		SingleItemRecipeBuilder.stonecutting(Ingredient.of(ItemRegistry.MOON_STONE_TAG), BlockRegistry.MOON_BRICKS.get(), 1)
				.unlockedBy("moon_stone", InventoryChangeTrigger.TriggerInstance.hasItems(BlockRegistry.MOON_STONE.get()))
				.group("celestialexploration")
				.save(consumer, "moon_bricks_stonecutting");

		ShapedRecipeBuilder.shaped(BlockRegistry.MOON_BRICK_SLAB.get())
				.pattern("XXX")
				.define('X', BlockRegistry.MOON_STONE.get())
				.group("celestialexploration")
				.unlockedBy("moon_stone", InventoryChangeTrigger.TriggerInstance.hasItems(BlockRegistry.MOON_STONE.get()))
				.save(consumer);
		SingleItemRecipeBuilder.stonecutting(Ingredient.of(ItemRegistry.MOON_STONE_TAG), BlockRegistry.MOON_BRICK_SLAB.get(), 2)
				.unlockedBy("moon_stone", InventoryChangeTrigger.TriggerInstance.hasItems(BlockRegistry.MOON_STONE.get()))
				.save(consumer, "moon_brick_slab_stonecutting");

		ShapedRecipeBuilder.shaped(BlockRegistry.MOON_BRICK_STAIRS.get())
				.pattern("X  ")
				.pattern("XX ")
				.pattern("XXX")
				.define('X', BlockRegistry.MOON_STONE.get())
				.group("celestialexploration")
				.unlockedBy("moon_stone", InventoryChangeTrigger.TriggerInstance.hasItems(BlockRegistry.MOON_STONE.get()))
				.save(consumer);
		SingleItemRecipeBuilder.stonecutting(Ingredient.of(ItemRegistry.MOON_STONE_TAG), BlockRegistry.MOON_BRICK_STAIRS.get(), 1)
				.unlockedBy("moon_stone", InventoryChangeTrigger.TriggerInstance.hasItems(BlockRegistry.MOON_STONE.get()))
				.save(consumer, "moon_brick_stairs_stonecutting");

		ShapedRecipeBuilder.shaped(BlockRegistry.MOON_BRICK_WALL.get())
				.pattern("XXX")
				.pattern("XXX")
				.define('X', BlockRegistry.MOON_STONE.get())
				.group("celestialexploration")
				.unlockedBy("moon_stone", InventoryChangeTrigger.TriggerInstance.hasItems(BlockRegistry.MOON_STONE.get()))
				.save(consumer);
		SingleItemRecipeBuilder.stonecutting(Ingredient.of(ItemRegistry.MOON_STONE_TAG), BlockRegistry.MOON_BRICK_WALL.get(), 1)
				.unlockedBy("moon_stone", InventoryChangeTrigger.TriggerInstance.hasItems(BlockRegistry.MOON_STONE.get()))
				.save(consumer, "moon_brick_wall_stonecutting");

		ShapedRecipeBuilder.shaped(BlockRegistry.CHISELED_MOON_BRICKS.get())
				.pattern("XXX")
				.pattern("XXX")
				.define('X', BlockRegistry.MOON_BRICKS.get())
				.group("celestialexploration")
				.unlockedBy("moon_stone", InventoryChangeTrigger.TriggerInstance.hasItems(BlockRegistry.MOON_STONE.get()))
				.unlockedBy("moon_bricks", InventoryChangeTrigger.TriggerInstance.hasItems(BlockRegistry.MOON_BRICKS.get()))
				.save(consumer);
		SingleItemRecipeBuilder.stonecutting(Ingredient.of(ItemRegistry.MOON_STONE_TAG), BlockRegistry.CHISELED_MOON_BRICKS.get(), 1)
				.unlockedBy("moon_stone", InventoryChangeTrigger.TriggerInstance.hasItems(BlockRegistry.MOON_BRICKS.get()))
				.save(consumer, "chiseled_moon_bricks_stonecutting");

//		ShapedRecipeBuilder.shaped(BlockRegistry.LUNAR_LANTERN.get())
//				.pattern("XXX")
//				.pattern("XXX")
//				.pattern("XXX")

		/**MARS*/
		SimpleCookingRecipeBuilder.smelting(Ingredient.of(BlockRegistry.MARS_SAND.get()), Items.BROWN_STAINED_GLASS, 1.0F, 100)
				.unlockedBy("has_mars_sand", has(BlockRegistry.MARS_SAND.get())).save(consumer, "mars_sand");

		ShapedRecipeBuilder.shaped(BlockRegistry.MARS_BRICKS.get())
				.pattern("XX")
				.pattern("XX")
				.define('X', BlockRegistry.MARS_STONE.get())
				.group("celestialexploration")
				.unlockedBy("mars_stone", InventoryChangeTrigger.TriggerInstance.hasItems(BlockRegistry.MARS_STONE.get()))
				.save(consumer);
		SingleItemRecipeBuilder.stonecutting(Ingredient.of(ItemRegistry.MARS_STONE_TAG), BlockRegistry.MARS_BRICKS.get(), 1)
				.unlockedBy("mars_stone", InventoryChangeTrigger.TriggerInstance.hasItems(BlockRegistry.MARS_STONE.get()))
				.save(consumer, "mars_bricks_stonecutting");

		ShapedRecipeBuilder.shaped(BlockRegistry.MARS_BRICK_SLAB.get())
				.pattern("XXX")
				.define('X', BlockRegistry.MARS_STONE.get())
				.group("celestialexploration")
				.unlockedBy("mars_stone", InventoryChangeTrigger.TriggerInstance.hasItems(BlockRegistry.MARS_STONE.get()))
				.save(consumer);
		SingleItemRecipeBuilder.stonecutting(Ingredient.of(ItemRegistry.MARS_STONE_TAG), BlockRegistry.MARS_BRICK_SLAB.get(), 2)
				.unlockedBy("mars_stone", InventoryChangeTrigger.TriggerInstance.hasItems(BlockRegistry.MARS_STONE.get()))
				.save(consumer, "mars_bricks_slab_stonecutting");

		ShapedRecipeBuilder.shaped(BlockRegistry.MARS_BRICK_STAIRS.get())
				.pattern("X  ")
				.pattern("XX ")
				.pattern("XXX")
				.define('X', BlockRegistry.MARS_STONE.get())
				.group("celestialexploration")
				.unlockedBy("mars_stone", InventoryChangeTrigger.TriggerInstance.hasItems(BlockRegistry.MARS_STONE.get()))
				.save(consumer);
		SingleItemRecipeBuilder.stonecutting(Ingredient.of(ItemRegistry.MARS_STONE_TAG), BlockRegistry.MARS_BRICK_STAIRS.get(), 1)
				.unlockedBy("mars_stone", InventoryChangeTrigger.TriggerInstance.hasItems(BlockRegistry.MARS_STONE.get()))
				.save(consumer, "mars_brick_stairs_stonecutting");

		ShapedRecipeBuilder.shaped(BlockRegistry.MARS_BRICK_WALL.get())
				.pattern("XXX")
				.pattern("XXX")
				.define('X', BlockRegistry.MARS_STONE.get())
				.group("celestialexploration")
				.unlockedBy("mars_stone", InventoryChangeTrigger.TriggerInstance.hasItems(BlockRegistry.MARS_STONE.get()))
				.save(consumer);
		SingleItemRecipeBuilder.stonecutting(Ingredient.of(ItemRegistry.MARS_STONE_TAG), BlockRegistry.MARS_BRICK_WALL.get(), 1)
				.unlockedBy("mars_stone", InventoryChangeTrigger.TriggerInstance.hasItems(BlockRegistry.MARS_STONE.get()))
				.save(consumer, "mars_brick_wall_stonecutting");

		ShapedRecipeBuilder.shaped(BlockRegistry.CHISELED_MARS_BRICKS.get())
				.pattern("XXX")
				.pattern("XXX")
				.define('X', BlockRegistry.MARS_BRICKS.get())
				.group("celestialexploration")
				.unlockedBy("mars_stone", InventoryChangeTrigger.TriggerInstance.hasItems(BlockRegistry.METEOR.get()))
				.unlockedBy("mars_bricks", InventoryChangeTrigger.TriggerInstance.hasItems(BlockRegistry.MARS_BRICKS.get()))
				.save(consumer);
		SingleItemRecipeBuilder.stonecutting(Ingredient.of(ItemRegistry.MARS_STONE_TAG), BlockRegistry.CHISELED_MARS_BRICKS.get(), 1)
				.unlockedBy("mars_stone", InventoryChangeTrigger.TriggerInstance.hasItems(BlockRegistry.MARS_BRICKS.get()))
				.save(consumer, "chiseled_mars_bricks_stonecutting");


		/**METEOR*/
//		SimpleCookingRecipeBuilder.smelting(Ingredient.of(BlockRegistry.METEOR.get()), ItemRegistry.METEOR_INGOT.get(), 1.0F, 100)
//				.unlockedBy("meteor", has(BlockRegistry.METEOR.get())).save(consumer, "meteor");

		ShapedRecipeBuilder.shaped(BlockRegistry.METEOR_BRICKS.get())
				.pattern("XX")
				.pattern("XX")
				.define('X', ItemRegistry.METEOR.get())
				.group("celestialexploration")
				.unlockedBy("meteor", InventoryChangeTrigger.TriggerInstance.hasItems(BlockRegistry.METEOR.get()))
				.save(consumer);
		SingleItemRecipeBuilder.stonecutting(Ingredient.of(ItemRegistry.METEOR_TAG), BlockRegistry.METEOR_BRICKS.get(), 1)
				.unlockedBy("meteor", InventoryChangeTrigger.TriggerInstance.hasItems(BlockRegistry.METEOR.get()))
				.save(consumer, "meteor_bricks_stonecutting");

		ShapedRecipeBuilder.shaped(BlockRegistry.METEOR_BRICK_SLAB.get())
				.pattern("XXX")
				.define('X', ItemRegistry.METEOR_BRICKS.get())
				.group("celestialexploration")
				.unlockedBy("meteor", InventoryChangeTrigger.TriggerInstance.hasItems(BlockRegistry.METEOR.get()))
				.save(consumer);
		SingleItemRecipeBuilder.stonecutting(Ingredient.of(ItemRegistry.METEOR_TAG), BlockRegistry.METEOR_BRICK_SLAB.get(), 2)
				.unlockedBy("meteor", InventoryChangeTrigger.TriggerInstance.hasItems(BlockRegistry.METEOR.get()))
				.save(consumer, "meteor_brick_slab_stonecutting");

		ShapedRecipeBuilder.shaped(BlockRegistry.METEOR_BRICK_STAIRS.get())
				.pattern("X  ")
				.pattern("XX ")
				.pattern("XXX")
				.define('X', ItemRegistry.METEOR_BRICKS.get())
				.group("celestialexploration")
				.unlockedBy("meteor", InventoryChangeTrigger.TriggerInstance.hasItems(BlockRegistry.METEOR.get()))
				.save(consumer);
		SingleItemRecipeBuilder.stonecutting(Ingredient.of(ItemRegistry.METEOR_TAG), BlockRegistry.METEOR_BRICK_STAIRS.get(), 1)
				.unlockedBy("meteor", InventoryChangeTrigger.TriggerInstance.hasItems(BlockRegistry.METEOR.get()))
				.save(consumer, "meteor_brick_stairs_stonecutting");

		ShapedRecipeBuilder.shaped(BlockRegistry.METEOR_BRICK_WALL.get())
				.pattern("XXX")
				.pattern("XXX")
				.define('X', BlockRegistry.METEOR_BRICKS.get())
				.group("celestialexploration")
				.unlockedBy("meteor", InventoryChangeTrigger.TriggerInstance.hasItems(BlockRegistry.METEOR.get()))
				.save(consumer);
		SingleItemRecipeBuilder.stonecutting(Ingredient.of(ItemRegistry.METEOR_TAG), BlockRegistry.METEOR_BRICK_WALL.get(), 1)
				.unlockedBy("meteor", InventoryChangeTrigger.TriggerInstance.hasItems(BlockRegistry.METEOR.get()))
				.save(consumer, "meteor_brick_wall_stonecutting");

		ShapedRecipeBuilder.shaped(BlockRegistry.CHISELED_METEOR_BRICKS.get())
				.pattern("XXX")
				.pattern("XXX")
				.define('X', BlockRegistry.METEOR_BRICKS.get())
				.group("celestialexploration")
				.unlockedBy("meteor", InventoryChangeTrigger.TriggerInstance.hasItems(BlockRegistry.METEOR.get()))
				.unlockedBy("meteor_bricks", InventoryChangeTrigger.TriggerInstance.hasItems(BlockRegistry.METEOR_BRICKS.get()))
				.save(consumer);
		SingleItemRecipeBuilder.stonecutting(Ingredient.of(ItemRegistry.METEOR_TAG), BlockRegistry.CHISELED_METEOR_BRICKS.get(), 1)
				.unlockedBy("meteor", InventoryChangeTrigger.TriggerInstance.hasItems(BlockRegistry.METEOR_BRICKS.get()))
				.save(consumer, "chiseled_meteor_bricks_stonecutting");

		/**STEEL*/
		ShapelessRecipeBuilder.shapeless(ItemRegistry.STEEL_INGOT.get())
				.requires(Items.COAL)
				.requires(Items.IRON_INGOT)
				.requires(Items.COAL)
				.requires(Items.IRON_INGOT)
				.group("celestialexploration")
				.unlockedBy("iron", InventoryChangeTrigger.TriggerInstance.hasItems(Items.IRON_INGOT))
				.save(consumer);

		ShapedRecipeBuilder.shaped(ItemRegistry.STEEL_ROD.get())
				.pattern("X")
				.pattern("X")
				.pattern("X")
				.define('X', ItemRegistry.STEEL_INGOT.get())
				.group("celestialexploration")
				.unlockedBy("steel", InventoryChangeTrigger.TriggerInstance.hasItems(ItemRegistry.STEEL_INGOT.get()))
				.save(consumer);
		ShapedRecipeBuilder.shaped(ItemRegistry.STEEL_BLOCK.get())
				.pattern("XXX")
				.pattern("XXX")
				.pattern("XXX")
				.define('X', ItemRegistry.STEEL_INGOT.get())
				.group("celestialexploration")
				.unlockedBy("steel", InventoryChangeTrigger.TriggerInstance.hasItems(ItemRegistry.STEEL_INGOT.get()))
				.save(consumer);

		/**SHUTTLE-ITEMS*/
		ShapedRecipeBuilder.shaped(BlockRegistry.STEEL_FRAME.get())
				.pattern("X X")
				.pattern("XXX")
				.pattern("X X")
				.define('X', ItemRegistry.STEEL_ROD.get())
				.group("celestialexploration")
				.unlockedBy("steel", InventoryChangeTrigger.TriggerInstance.hasItems(ItemRegistry.STEEL_ROD.get()))
				.save(consumer);
		ShapedRecipeBuilder.shaped(ItemRegistry.SHUTTLE_FRAME.get())
				.pattern("CSC")
				.pattern("C C")
				.pattern("CSC")
				.define('C', ItemRegistry.CERAMIC_TILE.get())
				.define('S', ItemRegistry.STEEL_ROD.get())
				.group("celestialexploration")
				.unlockedBy("steel", InventoryChangeTrigger.TriggerInstance.hasItems(ItemRegistry.STEEL_ROD.get()))
				.save(consumer);
		ShapedRecipeBuilder.shaped(ItemRegistry.NOSE_CONE.get())
				.pattern(" C ")
				.pattern("CSC")
				.define('C', ItemRegistry.CERAMIC_TILE.get())
				.define('S', ItemRegistry.STEEL_BLOCK.get())
				.group("celestialexploration")
				.unlockedBy("steel", InventoryChangeTrigger.TriggerInstance.hasItems(ItemRegistry.STEEL_ROD.get()))
				.save(consumer);
		ShapedRecipeBuilder.shaped(ItemRegistry.SHUTTLE_CABIN.get())
				.pattern(" N ")
				.pattern("CGC")
				.pattern("XSX")
				.define('N', ItemRegistry.NOSE_CONE.get())
				.define('C', ItemRegistry.CERAMIC_TILE.get())
				.define('G', Items.GLASS)
				.define('S', ItemRegistry.STEEL_BLOCK.get())
				.define('X', Items.CHEST)
				.group("celestialexploration")
				.unlockedBy("steel", InventoryChangeTrigger.TriggerInstance.hasItems(ItemRegistry.STEEL_ROD.get()))
				.save(consumer);
		ShapedRecipeBuilder.shaped(ItemRegistry.LOX_TANK.get())
				.pattern("SsS")
				.pattern("G G")
				.pattern("SsS")
				.define('S', ItemRegistry.STEEL_BLOCK.get())
				.define('s', ItemRegistry.STEEL_INGOT.get())
				.define('G', Items.GLASS)
				.group("celestialexploration")
				.unlockedBy("steel", InventoryChangeTrigger.TriggerInstance.hasItems(ItemRegistry.STEEL_ROD.get()))
				.save(consumer);
		ShapedRecipeBuilder.shaped(ItemRegistry.SHUTTLE_ENGINE.get())
				.pattern("SRS")
				.pattern("SKS")
				.pattern("TTT")
				.define('S', ItemRegistry.STEEL_BLOCK.get())
				.define('K', ItemRegistry.LOX_TANK.get())
				.define('R', Items.REDSTONE)
				.define('T', Items.REDSTONE_TORCH)
				.group("celestialexploration")
				.unlockedBy("steel", InventoryChangeTrigger.TriggerInstance.hasItems(ItemRegistry.STEEL_ROD.get()))
				.save(consumer);

		ShapedRecipeBuilder.shaped(ItemRegistry.WHITE_SHUTTLE.get())
				.pattern("C")
				.pattern("F")
				.pattern("E")
				.define('C', ItemRegistry.SHUTTLE_CABIN.get())
				.define('F', ItemRegistry.SHUTTLE_FRAME.get())
				.define('E', ItemRegistry.SHUTTLE_ENGINE.get())
				.group("celestialexploration")
				.unlockedBy("steel", InventoryChangeTrigger.TriggerInstance.hasItems(ItemRegistry.STEEL_INGOT.get()))
				.save(consumer);

		ShapelessRecipeBuilder.shapeless(ItemRegistry.BLACK_SHUTTLE.get())
				.requires(ItemRegistry.WHITE_SHUTTLE.get())
				.requires(Items.BLACK_DYE)
				.group("celestialexploration")
				.unlockedBy("shuttle", InventoryChangeTrigger.TriggerInstance.hasItems(ItemRegistry.WHITE_SHUTTLE.get()))
				.save(consumer);

		ShapelessRecipeBuilder.shapeless(ItemRegistry.GREY_SHUTTLE.get())
				.requires(ItemRegistry.WHITE_SHUTTLE.get())
				.requires(Items.GRAY_DYE)
				.group("celestialexploration")
				.unlockedBy("shuttle", InventoryChangeTrigger.TriggerInstance.hasItems(ItemRegistry.WHITE_SHUTTLE.get()))
				.save(consumer);

		ShapelessRecipeBuilder.shapeless(ItemRegistry.LIGHT_GREY_SHUTTLE.get())
				.requires(ItemRegistry.WHITE_SHUTTLE.get())
				.requires(Items.LIGHT_GRAY_DYE)
				.group("celestialexploration")
				.unlockedBy("shuttle", InventoryChangeTrigger.TriggerInstance.hasItems(ItemRegistry.WHITE_SHUTTLE.get()))
				.save(consumer);

		ShapelessRecipeBuilder.shapeless(ItemRegistry.PINK_SHUTTLE.get())
				.requires(ItemRegistry.WHITE_SHUTTLE.get())
				.requires(Items.PINK_DYE)
				.group("celestialexploration")
				.unlockedBy("shuttle", InventoryChangeTrigger.TriggerInstance.hasItems(ItemRegistry.WHITE_SHUTTLE.get()))
				.save(consumer);

		ShapelessRecipeBuilder.shapeless(ItemRegistry.RED_SHUTTLE.get())
				.requires(ItemRegistry.WHITE_SHUTTLE.get())
				.requires(Items.RED_DYE)
				.group("celestialexploration")
				.unlockedBy("shuttle", InventoryChangeTrigger.TriggerInstance.hasItems(ItemRegistry.WHITE_SHUTTLE.get()))
				.save(consumer);

		ShapelessRecipeBuilder.shapeless(ItemRegistry.ORANGE_SHUTTLE.get())
				.requires(ItemRegistry.WHITE_SHUTTLE.get())
				.requires(Items.ORANGE_DYE)
				.group("celestialexploration")
				.unlockedBy("shuttle", InventoryChangeTrigger.TriggerInstance.hasItems(ItemRegistry.WHITE_SHUTTLE.get()))
				.save(consumer);

		ShapelessRecipeBuilder.shapeless(ItemRegistry.YELLOW_SHUTTLE.get())
				.requires(ItemRegistry.WHITE_SHUTTLE.get())
				.requires(Items.YELLOW_DYE)
				.group("celestialexploration")
				.unlockedBy("shuttle", InventoryChangeTrigger.TriggerInstance.hasItems(ItemRegistry.WHITE_SHUTTLE.get()))
				.save(consumer);

		ShapelessRecipeBuilder.shapeless(ItemRegistry.LIME_SHUTTLE.get())
				.requires(ItemRegistry.WHITE_SHUTTLE.get())
				.requires(Items.LIME_DYE)
				.group("celestialexploration")
				.unlockedBy("shuttle", InventoryChangeTrigger.TriggerInstance.hasItems(ItemRegistry.WHITE_SHUTTLE.get()))
				.save(consumer);

		ShapelessRecipeBuilder.shapeless(ItemRegistry.GREEN_SHUTTLE.get())
				.requires(ItemRegistry.WHITE_SHUTTLE.get())
				.requires(Items.GREEN_DYE)
				.group("celestialexploration")
				.unlockedBy("shuttle", InventoryChangeTrigger.TriggerInstance.hasItems(ItemRegistry.WHITE_SHUTTLE.get()))
				.save(consumer);

		ShapelessRecipeBuilder.shapeless(ItemRegistry.CYAN_SHUTTLE.get())
				.requires(ItemRegistry.WHITE_SHUTTLE.get())
				.requires(Items.CYAN_DYE)
				.group("celestialexploration")
				.unlockedBy("shuttle", InventoryChangeTrigger.TriggerInstance.hasItems(ItemRegistry.WHITE_SHUTTLE.get()))
				.save(consumer);

		ShapelessRecipeBuilder.shapeless(ItemRegistry.BLUE_SHUTTLE.get())
				.requires(ItemRegistry.WHITE_SHUTTLE.get())
				.requires(Items.BLUE_DYE)
				.group("celestialexploration")
				.unlockedBy("shuttle", InventoryChangeTrigger.TriggerInstance.hasItems(ItemRegistry.WHITE_SHUTTLE.get()))
				.save(consumer);

		ShapelessRecipeBuilder.shapeless(ItemRegistry.LIGHT_BLUE_SHUTTLE.get())
				.requires(ItemRegistry.WHITE_SHUTTLE.get())
				.requires(Items.LIGHT_BLUE_DYE)
				.group("celestialexploration")
				.unlockedBy("shuttle", InventoryChangeTrigger.TriggerInstance.hasItems(ItemRegistry.WHITE_SHUTTLE.get()))
				.save(consumer);

		ShapelessRecipeBuilder.shapeless(ItemRegistry.PURPLE_SHUTTLE.get())
				.requires(ItemRegistry.WHITE_SHUTTLE.get())
				.requires(Items.PURPLE_DYE)
				.group("celestialexploration")
				.unlockedBy("shuttle", InventoryChangeTrigger.TriggerInstance.hasItems(ItemRegistry.WHITE_SHUTTLE.get()))
				.save(consumer);

		ShapelessRecipeBuilder.shapeless(ItemRegistry.MAGENTA_SHUTTLE.get())
				.requires(ItemRegistry.WHITE_SHUTTLE.get())
				.requires(Items.MAGENTA_DYE)
				.group("celestialexploration")
				.unlockedBy("shuttle", InventoryChangeTrigger.TriggerInstance.hasItems(ItemRegistry.WHITE_SHUTTLE.get()))
				.save(consumer);

		ShapelessRecipeBuilder.shapeless(ItemRegistry.BROWN_SHUTTLE.get())
				.requires(ItemRegistry.WHITE_SHUTTLE.get())
				.requires(Items.BROWN_DYE)
				.group("celestialexploration")
				.unlockedBy("shuttle", InventoryChangeTrigger.TriggerInstance.hasItems(ItemRegistry.WHITE_SHUTTLE.get()))
				.save(consumer);

		/**ARMOR**/
		ShapedRecipeBuilder.shaped(ItemRegistry.STEEL_HELMET.get())
				.pattern("XXX")
				.pattern("X X")
				.define('X', ItemRegistry.STEEL_INGOT.get())
				.group("celestialexploration")
				.unlockedBy("steel_ingot", InventoryChangeTrigger.TriggerInstance.hasItems(ItemRegistry.STEEL_INGOT.get()))
				.save(consumer);
		ShapedRecipeBuilder.shaped(ItemRegistry.STEEL_CHESTPLATE.get())
				.pattern("X X")
				.pattern("XXX")
				.pattern("XXX")
				.define('X', ItemRegistry.STEEL_INGOT.get())
				.group("celestialexploration")
				.unlockedBy("steel_ingot", InventoryChangeTrigger.TriggerInstance.hasItems(ItemRegistry.STEEL_INGOT.get()))
				.save(consumer);
		ShapedRecipeBuilder.shaped(ItemRegistry.STEEL_LEGGINGS.get())
				.pattern("XXX")
				.pattern("X X")
				.pattern("X X")
				.define('X', ItemRegistry.STEEL_INGOT.get())
				.group("celestialexploration")
				.unlockedBy("steel_ingot", InventoryChangeTrigger.TriggerInstance.hasItems(ItemRegistry.STEEL_INGOT.get()))
				.save(consumer);
		ShapedRecipeBuilder.shaped(ItemRegistry.STEEL_BOOTS.get())
				.pattern("X X")
				.pattern("X X")
				.define('X', ItemRegistry.STEEL_INGOT.get())
				.group("celestialexploration")
				.unlockedBy("steel_ingot", InventoryChangeTrigger.TriggerInstance.hasItems(ItemRegistry.STEEL_INGOT.get()))
				.save(consumer);
		ShapedRecipeBuilder.shaped(ItemRegistry.SPACE_SUIT_HELMET.get())
				.pattern("XXX")
				.pattern("XGX")
				.define('X', ItemRegistry.STEEL_INGOT.get())
				.define('G', Items.GLASS)
				.group("celestialexploration")
				.unlockedBy("steel_ingot", InventoryChangeTrigger.TriggerInstance.hasItems(ItemRegistry.STEEL_INGOT.get()))
				.save(consumer);
		ShapedRecipeBuilder.shaped(ItemRegistry.SPACE_SUIT_CHESTPLATE.get())
				.pattern("X X")
				.pattern("SSS")
				.pattern("XSX")
				.define('S', ItemRegistry.STEEL_INGOT.get())
				.define('X', Items.LEATHER)
				.group("celestialexploration")
				.unlockedBy("steel_ingot", InventoryChangeTrigger.TriggerInstance.hasItems(ItemRegistry.STEEL_INGOT.get()))
				.save(consumer);
		ShapedRecipeBuilder.shaped(ItemRegistry.SPACE_SUIT_LEGGINGS.get())
				.pattern("XSX")
				.pattern("S S")
				.pattern("X X")
				.define('S', ItemRegistry.STEEL_INGOT.get())
				.define('X', Items.LEATHER)
				.group("celestialexploration")
				.unlockedBy("steel_ingot", InventoryChangeTrigger.TriggerInstance.hasItems(ItemRegistry.STEEL_INGOT.get()))
				.save(consumer);
		ShapedRecipeBuilder.shaped(ItemRegistry.SPACE_SUIT_BOOTS.get())
				.pattern("X X")
				.pattern("S S")
				.define('S', ItemRegistry.STEEL_INGOT.get())
				.define('X', Items.LEATHER)
				.group("celestialexploration")
				.unlockedBy("steel_ingot", InventoryChangeTrigger.TriggerInstance.hasItems(ItemRegistry.STEEL_INGOT.get()))
				.save(consumer);

		/**MISC**/
		ShapedRecipeBuilder.shaped(ItemRegistry.OXYGEN_COMPRESSOR.get())
				.pattern("SSS")
				.pattern("CGC")
				.pattern("CRC")
				.define('S', ItemRegistry.STEEL_INGOT.get())
				.define('C', Tags.Items.COBBLESTONE)
				.define('G', ItemRegistry.LOX_TANK.get())
				.define('R', Items.REDSTONE)
				.group("celestialexploration")
				.unlockedBy("steel_ingot", InventoryChangeTrigger.TriggerInstance.hasItems(ItemRegistry.STEEL_INGOT.get()))
				.save(consumer);


		ShapedRecipeBuilder.shaped(BlockRegistry.CERAMIC_TILE.get())
				.pattern("XXX")
				.pattern("XXX")
				.pattern("XXX")
				.define('X', BlockRegistry.CERAMIC.get())
				.group("celestialexploration")
				.unlockedBy("clay", InventoryChangeTrigger.TriggerInstance.hasItems(Items.CLAY))
				.save(consumer);
		SingleItemRecipeBuilder.stonecutting(Ingredient.of(ItemRegistry.CERAMIC.get()), BlockRegistry.CERAMIC_TILE.get(), 2)
				.unlockedBy("clay", InventoryChangeTrigger.TriggerInstance.hasItems(Items.CLAY))
				.save(consumer, "ceramic_tile_stonecutting");

		SimpleCookingRecipeBuilder.smelting(Ingredient.of(Items.BRICK), BlockRegistry.CERAMIC.get(), 1.0F, 100)
				.unlockedBy("has_brick", has(Items.BRICK)).save(consumer, "ceramic");

//		ShapedRecipeBuilder.shaped(BlockRegistry.SOLAR_PANEL.get())
//				.pattern("XXX")
//				.pattern(" I ")
//				.pattern(" B ")
//				.define('X', Blocks.DAYLIGHT_DETECTOR)
//				.define('I', ItemRegistry.STEEL_ROD.get())
//				.define('B', Items.IRON_BLOCK)
//				.group("celestialexploration")
//				.unlockedBy("redstone", InventoryChangeTrigger.TriggerInstance.hasItems(Items.REDSTONE))
//				.unlockedBy("daylight_detector", InventoryChangeTrigger.TriggerInstance.hasItems(Blocks.DAYLIGHT_DETECTOR))
//				.save(consumer);


	}

}
