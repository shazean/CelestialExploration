package com.shim.celestialexploration.datagen;

import java.util.function.Consumer;

import com.shim.celestialexploration.registry.BlockRegistry;

import com.shim.celestialexploration.registry.ItemRegistry;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.SimpleCookingRecipeBuilder;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Blocks;

public class Recipes extends RecipeProvider {

	public Recipes(DataGenerator generatorIn) {
		super(generatorIn);
	}
	
	@Override
	protected void buildCraftingRecipes(Consumer<FinishedRecipe> consumer) {
		//TODO check/update experience granted arguments
		
		//MOON
		SimpleCookingRecipeBuilder.smelting(Ingredient.of(BlockRegistry.MOON_IRON_ORE.get()), Items.IRON_INGOT, 1.0f, 100)
		.unlockedBy("has_ore",  has(BlockRegistry.MOON_IRON_ORE.get()))
		.save(consumer, "moon_iron_ore");
		
		//MARS
		SimpleCookingRecipeBuilder.smelting(Ingredient.of(BlockRegistry.MARS_IRON_ORE.get()), Items.IRON_INGOT, 1.0f, 100)
		.unlockedBy("has_ore",  has(BlockRegistry.MARS_IRON_ORE.get()))
		.save(consumer, "mars_iron_ore");
		
		//METEOR
		SimpleCookingRecipeBuilder.smelting(Ingredient.of(BlockRegistry.METEOR_IRON_ORE.get()), Items.IRON_INGOT, 1.0f, 100)
		.unlockedBy("has_ore",  has(BlockRegistry.METEOR_IRON_ORE.get()))
		.save(consumer, "meteor_iron_ore");
		
		SimpleCookingRecipeBuilder.smelting(Ingredient.of(BlockRegistry.METEOR_GOLD_ORE.get()), Items.GOLD_INGOT, 1.0f, 100)
		.unlockedBy("has_ore",  has(BlockRegistry.METEOR_GOLD_ORE.get()))
		.save(consumer, "meteor_gold_ore");
		
		SimpleCookingRecipeBuilder.smelting(Ingredient.of(BlockRegistry.METEOR_COPPER_ORE.get()), Items.COPPER_INGOT, 1.0f, 100)
		.unlockedBy("has_ore",  has(BlockRegistry.METEOR_COPPER_ORE.get()))
		.save(consumer, "meteor_copper_ore");

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
