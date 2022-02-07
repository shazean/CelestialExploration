package com.shim.celestialexploration.datagen;

import java.util.function.Consumer;

import com.shim.celestialexploration.registry.BlockRegistry;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.SimpleCookingRecipeBuilder;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;

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
		
	}

}
