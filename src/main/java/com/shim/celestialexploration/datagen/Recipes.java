package com.shim.celestialexploration.datagen;

import java.util.function.Consumer;

import com.shim.celestialexploration.registry.BlockRegistry;

import com.shim.celestialexploration.registry.ItemRegistry;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.core.Registry;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.*;
import net.minecraft.world.entity.player.Inventory;
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

		//MOON
		SimpleCookingRecipeBuilder.smelting(Ingredient.of(BlockRegistry.MOON_SAND.get()), Items.WHITE_STAINED_GLASS, 1.0F, 100)
				.unlockedBy("has_moon_sand", has(BlockRegistry.MOON_SAND.get())).save(consumer, "moon_sand");

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

		//MARS
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


		//METEOR
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




		ShapedRecipeBuilder.shaped(BlockRegistry.SOLAR_PANEL.get())
				.pattern("XXX")
				.pattern(" I ")
				.pattern(" B ")
				.define('X', Blocks.DAYLIGHT_DETECTOR)
				.define('I', ItemRegistry.STEEL_ROD.get())
				.define('B', Items.IRON_BLOCK)
				.group("celestialexploration")
				.unlockedBy("redstone", InventoryChangeTrigger.TriggerInstance.hasItems(Items.REDSTONE))
				.unlockedBy("daylight_detector", InventoryChangeTrigger.TriggerInstance.hasItems(Blocks.DAYLIGHT_DETECTOR))
				.save(consumer);




	}

}
