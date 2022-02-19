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
		
		//ORES
		SimpleCookingRecipeBuilder.smelting(Ingredient.of(BlockRegistry.MOON_IRON_ORE.get()), Items.IRON_INGOT, 1.0f, 100)
			.unlockedBy("has_ore",  has(BlockRegistry.MOON_IRON_ORE.get())).save(consumer, "moon_iron_ore");
		SimpleCookingRecipeBuilder.smelting(Ingredient.of(BlockRegistry.MARS_IRON_ORE.get()), Items.IRON_INGOT, 1.0f, 100)
			.unlockedBy("has_ore",  has(BlockRegistry.MARS_IRON_ORE.get())).save(consumer, "mars_iron_ore");
		SimpleCookingRecipeBuilder.smelting(Ingredient.of(BlockRegistry.METEOR_IRON_ORE.get()), Items.IRON_INGOT, 1.0f, 100)
			.unlockedBy("has_ore",  has(BlockRegistry.METEOR_IRON_ORE.get())).save(consumer, "meteor_iron_ore");
		SimpleCookingRecipeBuilder.smelting(Ingredient.of(BlockRegistry.METEOR_GOLD_ORE.get()), Items.GOLD_INGOT, 1.0f, 100)
			.unlockedBy("has_ore",  has(BlockRegistry.METEOR_GOLD_ORE.get())).save(consumer, "meteor_gold_ore");
		SimpleCookingRecipeBuilder.smelting(Ingredient.of(BlockRegistry.METEOR_COPPER_ORE.get()), Items.COPPER_INGOT, 1.0f, 100)
				.unlockedBy("has_ore",  has(BlockRegistry.METEOR_COPPER_ORE.get())).save(consumer, "meteor_copper_ore");

		//MOON
		SimpleCookingRecipeBuilder.smelting(Ingredient.of(BlockRegistry.MOON_SAND.get()), Items.WHITE_STAINED_GLASS, 1.0F, 100)
				.unlockedBy("has_moon_sand", has(BlockRegistry.MOON_SAND.get())).save(consumer, "moon_sand");

		//MARS
		ShapedRecipeBuilder.shaped(BlockRegistry.MARS_BRICKS.get())
				.pattern("XX")
				.pattern("XX")
				.define('X', BlockRegistry.MARS_STONE.get())
				.group("celestialexploration")
				.unlockedBy("mars_stone", InventoryChangeTrigger.TriggerInstance.hasItems(BlockRegistry.MARS_STONE.get()))
				.save(consumer);
		ShapedRecipeBuilder.shaped(BlockRegistry.MARS_BRICK_SLAB.get())
				.pattern("XXX")
				.define('X', BlockRegistry.MARS_STONE.get())
				.group("celestialexploration")
				.unlockedBy("mars_stone", InventoryChangeTrigger.TriggerInstance.hasItems(BlockRegistry.MARS_STONE.get()))
				.save(consumer);
		ShapedRecipeBuilder.shaped(BlockRegistry.MARS_BRICK_STAIRS.get())
				.pattern("X  ")
				.pattern("XX ")
				.pattern("XXX")
				.define('X', BlockRegistry.MARS_STONE.get())
				.group("celestialexploration")
				.unlockedBy("mars_stone", InventoryChangeTrigger.TriggerInstance.hasItems(BlockRegistry.MARS_STONE.get()))
				.save(consumer);
		ShapedRecipeBuilder.shaped(BlockRegistry.MARS_BRICK_WALL.get())
				.pattern("XXX")
				.pattern("XXX")
				.define('X', BlockRegistry.MARS_STONE.get())
				.group("celestialexploration")
				.unlockedBy("mars_stone", InventoryChangeTrigger.TriggerInstance.hasItems(BlockRegistry.MARS_STONE.get()))
				.save(consumer);
		ShapedRecipeBuilder.shaped(BlockRegistry.CHISELED_MARS_BRICKS.get())
				.pattern("XXX")
				.pattern("XXX")
				.define('X', BlockRegistry.MARS_BRICKS.get())
				.group("celestialexploration")
				.unlockedBy("mars_stone", InventoryChangeTrigger.TriggerInstance.hasItems(BlockRegistry.MARS_STONE.get()))
				.unlockedBy("mars_bricks", InventoryChangeTrigger.TriggerInstance.hasItems(BlockRegistry.MARS_BRICKS.get()))
				.save(consumer);

		//FIXME
//		SingleItemRecipeBuilder.stonecutting(Ingredient.of((ItemLike) BlockRegistry.MARS_STONE_TAG), BlockRegistry.MARS_BRICKS.get(), 1)
//				.unlockedBy("mars_stone", InventoryChangeTrigger.TriggerInstance.hasItems(BlockRegistry.MARS_STONE.get()))
//				.save(consumer);
//		SingleItemRecipeBuilder.stonecutting(Ingredient.of((ItemLike) BlockRegistry.MARS_STONE_TAG), BlockRegistry.MARS_BRICK_WALL.get(), 1)
//				.unlockedBy("mars_stone", InventoryChangeTrigger.TriggerInstance.hasItems(BlockRegistry.MARS_STONE.get()))
//				.save(consumer);
//		SingleItemRecipeBuilder.stonecutting(Ingredient.of((ItemLike) BlockRegistry.MARS_STONE_TAG), BlockRegistry.MARS_BRICK_SLAB.get(), 2)
//				.unlockedBy("mars_stone", InventoryChangeTrigger.TriggerInstance.hasItems(BlockRegistry.MARS_STONE.get()))
//				.save(consumer);
//		SingleItemRecipeBuilder.stonecutting(Ingredient.of((ItemLike) BlockRegistry.MARS_STONE_TAG), BlockRegistry.MARS_BRICK_STAIRS.get(), 1)
//				.unlockedBy("mars_stone", InventoryChangeTrigger.TriggerInstance.hasItems(BlockRegistry.MARS_STONE.get()))
//				.save(consumer);
//		SingleItemRecipeBuilder.stonecutting(Ingredient.of((ItemLike) BlockRegistry.MARS_STONE_TAG), BlockRegistry.CHISELED_MARS_BRICKS.get(), 1)
//				.unlockedBy("mars_stone", InventoryChangeTrigger.TriggerInstance.hasItems(BlockRegistry.MARS_BRICKS.get()))
//				.save(consumer);


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
