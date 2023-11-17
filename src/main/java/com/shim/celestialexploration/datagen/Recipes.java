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

		SimpleCookingRecipeBuilder.smelting(Ingredient.of(BlockRegistry.COARSE_MOON_SAND.get()), Items.WHITE_STAINED_GLASS, 1.0F, 100)
				.unlockedBy("has_moon_sand", has(BlockRegistry.COARSE_MOON_SAND.get())).save(consumer, "coarse_moon_sand");

		ShapedRecipeBuilder.shaped(BlockRegistry.LUNAR_LANTERN.get())
				.pattern("XCX")
				.pattern("CCC")
				.pattern("XCX")
				.define('X', Items.IRON_INGOT)
				.define('C', ItemRegistry.MOON_DUST.get())
				.group("celestialexploration").unlockedBy("has_moon_dust", InventoryChangeTrigger.TriggerInstance.hasItems(ItemRegistry.MOON_DUST.get())).save(consumer);

		ShapedRecipeBuilder.shaped(BlockRegistry.MOON_BRICKS.get(), 4)
				.pattern("XX")
				.pattern("XX")
				.define('X', BlockRegistry.MOON_STONE.get())
				.group("celestialexploration").unlockedBy("moon_stone", InventoryChangeTrigger.TriggerInstance.hasItems(BlockRegistry.MOON_STONE.get())).save(consumer);
		SingleItemRecipeBuilder.stonecutting(Ingredient.of(ItemRegistry.MOON_STONE_TAG), BlockRegistry.MOON_BRICKS.get(), 1)
				.unlockedBy("moon_stone", InventoryChangeTrigger.TriggerInstance.hasItems(BlockRegistry.MOON_STONE.get()))
				.group("celestialexploration").save(consumer, "moon_bricks_stonecutting");

		ShapedRecipeBuilder.shaped(BlockRegistry.MOON_BRICK_SLAB.get(), 6)
				.pattern("XXX")
				.define('X', BlockRegistry.MOON_BRICKS.get())
				.group("celestialexploration").unlockedBy("moon_stone", InventoryChangeTrigger.TriggerInstance.hasItems(BlockRegistry.MOON_STONE.get())).save(consumer);
		SingleItemRecipeBuilder.stonecutting(Ingredient.of(ItemRegistry.MOON_STONE_TAG), BlockRegistry.MOON_BRICK_SLAB.get(), 2)
				.unlockedBy("moon_stone", InventoryChangeTrigger.TriggerInstance.hasItems(BlockRegistry.MOON_STONE.get())).save(consumer, "moon_brick_slab_stonecutting");

		ShapedRecipeBuilder.shaped(BlockRegistry.MOON_BRICK_STAIRS.get(), 4)
				.pattern("X  ")
				.pattern("XX ")
				.pattern("XXX")
				.define('X', BlockRegistry.MOON_BRICKS.get())
				.group("celestialexploration").unlockedBy("moon_stone", InventoryChangeTrigger.TriggerInstance.hasItems(BlockRegistry.MOON_STONE.get())).save(consumer);
		SingleItemRecipeBuilder.stonecutting(Ingredient.of(ItemRegistry.MOON_STONE_TAG), BlockRegistry.MOON_BRICK_STAIRS.get(), 1)
				.unlockedBy("moon_stone", InventoryChangeTrigger.TriggerInstance.hasItems(BlockRegistry.MOON_STONE.get())).save(consumer, "moon_brick_stairs_stonecutting");

		ShapedRecipeBuilder.shaped(BlockRegistry.MOON_BRICK_WALL.get(), 6)
				.pattern("XXX")
				.pattern("XXX")
				.define('X', BlockRegistry.MOON_BRICKS.get())
				.group("celestialexploration").unlockedBy("moon_stone", InventoryChangeTrigger.TriggerInstance.hasItems(BlockRegistry.MOON_STONE.get())).save(consumer);
		SingleItemRecipeBuilder.stonecutting(Ingredient.of(ItemRegistry.MOON_STONE_TAG), BlockRegistry.MOON_BRICK_WALL.get(), 1)
				.unlockedBy("moon_stone", InventoryChangeTrigger.TriggerInstance.hasItems(BlockRegistry.MOON_STONE.get())).save(consumer, "moon_brick_wall_stonecutting");

		ShapedRecipeBuilder.shaped(BlockRegistry.CHISELED_MOON_BRICKS.get())
				.pattern("X")
				.pattern("X")
				.define('X', BlockRegistry.MOON_BRICK_SLAB.get())
				.group("celestialexploration").unlockedBy("moon_stone", InventoryChangeTrigger.TriggerInstance.hasItems(BlockRegistry.MOON_STONE.get())).save(consumer);
		SingleItemRecipeBuilder.stonecutting(Ingredient.of(ItemRegistry.MOON_STONE_TAG), BlockRegistry.CHISELED_MOON_BRICKS.get(), 1)
				.unlockedBy("moon_stone", InventoryChangeTrigger.TriggerInstance.hasItems(BlockRegistry.MOON_BRICKS.get())).save(consumer, "chiseled_moon_bricks_stonecutting");

		ShapedRecipeBuilder.shaped(BlockRegistry.MOON_BRICK_PILLAR.get(), 4)
				.pattern("X")
				.pattern("X")
				.define('X', BlockRegistry.MOON_BRICKS.get())
				.group("celestialexploration").unlockedBy("moon_stone", InventoryChangeTrigger.TriggerInstance.hasItems(BlockRegistry.MOON_STONE.get())).save(consumer);
		SingleItemRecipeBuilder.stonecutting(Ingredient.of(ItemRegistry.MOON_STONE_TAG), BlockRegistry.MOON_BRICK_PILLAR.get(), 1)
				.unlockedBy("moon_stone", InventoryChangeTrigger.TriggerInstance.hasItems(BlockRegistry.MOON_STONE.get()))
				.group("celestialexploration").save(consumer, "moon_brick_pillar_stonecutting");

		SimpleCookingRecipeBuilder.smelting(Ingredient.of(BlockRegistry.MOON_COBBLESTONE.get()), BlockRegistry.MOON_STONE.get(), 1.0F, 100)
				.unlockedBy("has_moon_cobblestone", has(BlockRegistry.MOON_COBBLESTONE.get())).save(consumer, "moon_cobblestone");

		SimpleCookingRecipeBuilder.smelting(Ingredient.of(BlockRegistry.MOON_COBBLED_DEEPSLATE.get()), BlockRegistry.MOON_DEEPSLATE.get(), 1.0F, 100)
				.unlockedBy("has_moon_cobblestone", has(BlockRegistry.MOON_COBBLED_DEEPSLATE.get())).save(consumer, "moon_cobbled_deepslate");

		ShapedRecipeBuilder.shaped(BlockRegistry.MOON_STONE_STAIRS.get(), 4)
				.pattern("X  ")
				.pattern("XX ")
				.pattern("XXX")
				.define('X', BlockRegistry.MOON_STONE.get())
				.group("celestialexploration").unlockedBy("moon_stone", InventoryChangeTrigger.TriggerInstance.hasItems(BlockRegistry.MOON_STONE.get())).save(consumer);
		SingleItemRecipeBuilder.stonecutting(Ingredient.of(ItemRegistry.MOON_STONE_TAG), BlockRegistry.MOON_STONE_STAIRS.get(), 1)
				.unlockedBy("moon_stone", InventoryChangeTrigger.TriggerInstance.hasItems(BlockRegistry.MOON_STONE.get())).save(consumer, "moon_stone_stairs_stonecutting");

		ShapedRecipeBuilder.shaped(BlockRegistry.MOON_STONE_SLAB.get(), 6)
				.pattern("XXX")
				.define('X', BlockRegistry.MOON_STONE.get())
				.group("celestialexploration").unlockedBy("moon_stone", InventoryChangeTrigger.TriggerInstance.hasItems(BlockRegistry.MOON_STONE.get())).save(consumer);
		SingleItemRecipeBuilder.stonecutting(Ingredient.of(ItemRegistry.MOON_STONE_TAG), BlockRegistry.MOON_STONE_SLAB.get(), 2)
				.unlockedBy("moon_stone", InventoryChangeTrigger.TriggerInstance.hasItems(BlockRegistry.MOON_STONE.get())).save(consumer, "moon_stone_slab_stonecutting");


		ShapedRecipeBuilder.shaped(BlockRegistry.MOON_COBBLESTONE_SLAB.get(), 6)
				.pattern("XXX")
				.define('X', BlockRegistry.MOON_COBBLESTONE.get())
				.group("celestialexploration").unlockedBy("moon_cobblestone", InventoryChangeTrigger.TriggerInstance.hasItems(BlockRegistry.MOON_STONE.get())).save(consumer);
		SingleItemRecipeBuilder.stonecutting(Ingredient.of(ItemRegistry.MOON_COBBLESTONE_TAG), BlockRegistry.MOON_COBBLESTONE_SLAB.get(), 2)
				.unlockedBy("moon_stone", InventoryChangeTrigger.TriggerInstance.hasItems(BlockRegistry.MOON_STONE.get())).save(consumer, "moon_cobblestone_slab_stonecutting");

		ShapedRecipeBuilder.shaped(BlockRegistry.MOON_COBBLESTONE_STAIRS.get(), 4)
				.pattern("X  ")
				.pattern("XX ")
				.pattern("XXX")
				.define('X', BlockRegistry.MOON_COBBLESTONE.get())
				.group("celestialexploration").unlockedBy("moon_cobblestone", InventoryChangeTrigger.TriggerInstance.hasItems(BlockRegistry.MOON_STONE.get())).save(consumer);
		SingleItemRecipeBuilder.stonecutting(Ingredient.of(ItemRegistry.MOON_COBBLESTONE_TAG), BlockRegistry.MOON_COBBLESTONE_STAIRS.get(), 1)
				.unlockedBy("moon_stone", InventoryChangeTrigger.TriggerInstance.hasItems(BlockRegistry.MOON_STONE.get())).save(consumer, "moon_cobblestone_stairs_stonecutting");

		ShapedRecipeBuilder.shaped(BlockRegistry.MOON_COBBLESTONE_WALL.get(), 6)
				.pattern("XXX")
				.pattern("XXX")
				.define('X', BlockRegistry.MOON_COBBLESTONE.get())
				.group("celestialexploration").unlockedBy("moon_cobblestone", InventoryChangeTrigger.TriggerInstance.hasItems(BlockRegistry.MOON_STONE.get())).save(consumer);
		SingleItemRecipeBuilder.stonecutting(Ingredient.of(ItemRegistry.MOON_COBBLESTONE_TAG), BlockRegistry.MOON_COBBLESTONE_WALL.get(), 1)
				.unlockedBy("moon_stone", InventoryChangeTrigger.TriggerInstance.hasItems(BlockRegistry.MOON_STONE.get())).save(consumer, "moon_cobblestone_wall_stonecutting");


		ShapedRecipeBuilder.shaped(BlockRegistry.MOON_COBBLED_DEEPSLATE_SLAB.get(), 6)
				.pattern("XXX")
				.define('X', BlockRegistry.MOON_COBBLED_DEEPSLATE.get())
				.group("celestialexploration").unlockedBy("moon_stone", InventoryChangeTrigger.TriggerInstance.hasItems(BlockRegistry.MOON_STONE.get())).save(consumer);
		SingleItemRecipeBuilder.stonecutting(Ingredient.of(ItemRegistry.MOON_COBBLED_DEEPSLATE_TAG), BlockRegistry.MOON_COBBLED_DEEPSLATE_SLAB.get(), 2)
				.unlockedBy("moon_stone", InventoryChangeTrigger.TriggerInstance.hasItems(BlockRegistry.MOON_STONE.get())).save(consumer, "moon_cobbled_deepslate_slab_stonecutting");

		ShapedRecipeBuilder.shaped(BlockRegistry.MOON_COBBLED_DEEPSLATE_STAIRS.get(), 4)
				.pattern("X  ")
				.pattern("XX ")
				.pattern("XXX")
				.define('X', BlockRegistry.MOON_COBBLED_DEEPSLATE.get())
				.group("celestialexploration").unlockedBy("moon_stone", InventoryChangeTrigger.TriggerInstance.hasItems(BlockRegistry.MOON_STONE.get())).save(consumer);
		SingleItemRecipeBuilder.stonecutting(Ingredient.of(ItemRegistry.MOON_COBBLED_DEEPSLATE_TAG), BlockRegistry.MOON_COBBLED_DEEPSLATE_STAIRS.get(), 1)
				.unlockedBy("moon_stone", InventoryChangeTrigger.TriggerInstance.hasItems(BlockRegistry.MOON_STONE.get())).save(consumer, "moon_cobbled_deepslate_stairs_stonecutting");

		ShapedRecipeBuilder.shaped(BlockRegistry.MOON_COBBLED_DEEPSLATE_WALL.get(), 6)
				.pattern("XXX")
				.pattern("XXX")
				.define('X', BlockRegistry.MOON_COBBLED_DEEPSLATE.get())
				.group("celestialexploration").unlockedBy("moon_stone", InventoryChangeTrigger.TriggerInstance.hasItems(BlockRegistry.MOON_STONE.get())).save(consumer);
		SingleItemRecipeBuilder.stonecutting(Ingredient.of(ItemRegistry.MOON_COBBLED_DEEPSLATE_TAG), BlockRegistry.MOON_COBBLED_DEEPSLATE_WALL.get(), 1)
				.unlockedBy("moon_stone", InventoryChangeTrigger.TriggerInstance.hasItems(BlockRegistry.MOON_STONE.get())).save(consumer, "moon_cobbled_deepslate_wall_stonecutting");

		SimpleCookingRecipeBuilder.smelting(Ingredient.of(BlockRegistry.MOON_STONE.get()), ItemRegistry.MOON_SMOOTH_STONE.get(), 1.0F, 100)
				.unlockedBy("has_moon_stone", has(BlockRegistry.MOON_STONE.get())).save(consumer, "moon_smooth_stone");

//		ShapedRecipeBuilder.shaped(BlockRegistry.MOON_SMOOTH_STONE_SLAB.get(), 6)
//				.pattern("XXX")
//				.define('X', BlockRegistry.MOON_SMOOTH_STONE.get())
//				.group("celestialexploration").unlockedBy("has_moon_smooth_stone", InventoryChangeTrigger.TriggerInstance.hasItems(BlockRegistry.MOON_STONE.get())).save(consumer);
//		SingleItemRecipeBuilder.stonecutting(Ingredient.of(ItemRegistry.MOON_COBBLED_DEEPSLATE_TAG), BlockRegistry.MOON_SMOOTH_STONE_SLAB.get(), 2)
//				.unlockedBy("has_moon_smooth_stone", InventoryChangeTrigger.TriggerInstance.hasItems(BlockRegistry.MOON_SMOOTH_STONE.get())).save(consumer, "moon_smooth_stone_slab_stonecutting");

		ShapedRecipeBuilder.shaped(BlockRegistry.MOON_DEEPSLATE_BRICKS.get(), 4)
				.pattern("XX")
				.pattern("XX")
				.define('X', BlockRegistry.MOON_DEEPSLATE.get())
				.group("celestialexploration").unlockedBy("moon_deepslate", InventoryChangeTrigger.TriggerInstance.hasItems(BlockRegistry.MOON_DEEPSLATE.get())).save(consumer);
		SingleItemRecipeBuilder.stonecutting(Ingredient.of(ItemRegistry.MOON_DEEPSLATE_TAG), BlockRegistry.MOON_DEEPSLATE_BRICKS.get(), 1)
				.unlockedBy("has_moon_deepslate", InventoryChangeTrigger.TriggerInstance.hasItems(BlockRegistry.MOON_DEEPSLATE.get()))
				.group("celestialexploration").save(consumer, "moon_deepslate_bricks_stonecutting");

		ShapedRecipeBuilder.shaped(BlockRegistry.MOON_DEEPSLATE_BRICK_SLAB.get(), 6)
				.pattern("XXX")
				.define('X', BlockRegistry.MOON_DEEPSLATE_BRICKS.get())
				.group("celestialexploration").unlockedBy("has_moon_deepslate", InventoryChangeTrigger.TriggerInstance.hasItems(BlockRegistry.MOON_DEEPSLATE.get())).save(consumer);
		SingleItemRecipeBuilder.stonecutting(Ingredient.of(ItemRegistry.MOON_DEEPSLATE_TAG), BlockRegistry.MOON_DEEPSLATE_BRICK_SLAB.get(), 2)
				.unlockedBy("has_moon_deepslate", InventoryChangeTrigger.TriggerInstance.hasItems(BlockRegistry.MOON_DEEPSLATE.get())).save(consumer, "moon_deepslate_brick_slab_stonecutting");

		ShapedRecipeBuilder.shaped(BlockRegistry.MOON_DEEPSLATE_BRICK_STAIRS.get(), 4)
				.pattern("X  ")
				.pattern("XX ")
				.pattern("XXX")
				.define('X', BlockRegistry.MOON_DEEPSLATE_BRICKS.get())
				.group("celestialexploration").unlockedBy("has_moon_deepslate", InventoryChangeTrigger.TriggerInstance.hasItems(BlockRegistry.MOON_DEEPSLATE.get())).save(consumer);
		SingleItemRecipeBuilder.stonecutting(Ingredient.of(ItemRegistry.MOON_DEEPSLATE_TAG), BlockRegistry.MOON_DEEPSLATE_BRICK_STAIRS.get(), 1)
				.unlockedBy("has_moon_deepslate", InventoryChangeTrigger.TriggerInstance.hasItems(BlockRegistry.MOON_DEEPSLATE.get())).save(consumer, "moon_deepslate_brick_stairs_stonecutting");

		ShapedRecipeBuilder.shaped(BlockRegistry.MOON_DEEPSLATE_BRICK_WALL.get(), 6)
				.pattern("XXX")
				.pattern("XXX")
				.define('X', BlockRegistry.MOON_DEEPSLATE_BRICKS.get())
				.group("celestialexploration").unlockedBy("has_moon_deepslate", InventoryChangeTrigger.TriggerInstance.hasItems(BlockRegistry.MOON_DEEPSLATE.get())).save(consumer);
		SingleItemRecipeBuilder.stonecutting(Ingredient.of(ItemRegistry.MOON_DEEPSLATE_TAG), BlockRegistry.MOON_DEEPSLATE_BRICK_WALL.get(), 1)
				.unlockedBy("has_moon_deepslate", InventoryChangeTrigger.TriggerInstance.hasItems(BlockRegistry.MOON_DEEPSLATE.get())).save(consumer, "moon_deepslate_brick_wall_stonecutting");

		ShapedRecipeBuilder.shaped(BlockRegistry.MOON_DEEPSLATE_TILES.get(), 4)
				.pattern("XX")
				.pattern("XX")
				.define('X', BlockRegistry.MOON_DEEPSLATE.get())
				.group("celestialexploration").unlockedBy("moon_deepslate", InventoryChangeTrigger.TriggerInstance.hasItems(BlockRegistry.MOON_DEEPSLATE.get())).save(consumer);
		SingleItemRecipeBuilder.stonecutting(Ingredient.of(ItemRegistry.MOON_DEEPSLATE_TAG), BlockRegistry.MOON_DEEPSLATE_TILES.get(), 1)
				.unlockedBy("has_moon_deepslate", InventoryChangeTrigger.TriggerInstance.hasItems(BlockRegistry.MOON_DEEPSLATE.get()))
				.group("celestialexploration").save(consumer, "moon_deepslate_tiles_stonecutting");

		ShapedRecipeBuilder.shaped(BlockRegistry.MOON_DEEPSLATE_TILE_SLAB.get(), 6)
				.pattern("XXX")
				.define('X', BlockRegistry.MOON_DEEPSLATE_TILES.get())
				.group("celestialexploration").unlockedBy("has_moon_deepslate", InventoryChangeTrigger.TriggerInstance.hasItems(BlockRegistry.MOON_DEEPSLATE.get())).save(consumer);
		SingleItemRecipeBuilder.stonecutting(Ingredient.of(ItemRegistry.MOON_DEEPSLATE_TAG), BlockRegistry.MOON_DEEPSLATE_TILE_SLAB.get(), 2)
				.unlockedBy("has_moon_deepslate", InventoryChangeTrigger.TriggerInstance.hasItems(BlockRegistry.MOON_DEEPSLATE.get())).save(consumer, "moon_deepslate_tile_slab_stonecutting");

		ShapedRecipeBuilder.shaped(BlockRegistry.MOON_DEEPSLATE_TILE_STAIRS.get(), 4)
				.pattern("X  ")
				.pattern("XX ")
				.pattern("XXX")
				.define('X', BlockRegistry.MOON_DEEPSLATE_TILES.get())
				.group("celestialexploration").unlockedBy("has_moon_deepslate", InventoryChangeTrigger.TriggerInstance.hasItems(BlockRegistry.MOON_DEEPSLATE.get())).save(consumer);
		SingleItemRecipeBuilder.stonecutting(Ingredient.of(ItemRegistry.MOON_DEEPSLATE_TAG), BlockRegistry.MOON_DEEPSLATE_TILE_STAIRS.get(), 1)
				.unlockedBy("has_moon_deepslate", InventoryChangeTrigger.TriggerInstance.hasItems(BlockRegistry.MOON_DEEPSLATE.get())).save(consumer, "moon_deepslate_tile_stairs_stonecutting");

		ShapedRecipeBuilder.shaped(BlockRegistry.MOON_DEEPSLATE_TILE_WALL.get(), 6)
				.pattern("XXX")
				.pattern("XXX")
				.define('X', BlockRegistry.MOON_DEEPSLATE_TILES.get())
				.group("celestialexploration").unlockedBy("has_moon_deepslate", InventoryChangeTrigger.TriggerInstance.hasItems(BlockRegistry.MOON_DEEPSLATE.get())).save(consumer);
		SingleItemRecipeBuilder.stonecutting(Ingredient.of(ItemRegistry.MOON_DEEPSLATE_TAG), BlockRegistry.MOON_DEEPSLATE_TILE_WALL.get(), 1)
				.unlockedBy("has_moon_deepslate", InventoryChangeTrigger.TriggerInstance.hasItems(BlockRegistry.MOON_DEEPSLATE.get())).save(consumer, "moon_deepslate_tile_wall_stonecutting");

		ShapedRecipeBuilder.shaped(BlockRegistry.MOON_POLISHED_DEEPSLATE.get(), 4)
				.pattern("XX")
				.pattern("XX")
				.define('X', BlockRegistry.MOON_DEEPSLATE.get())
				.group("celestialexploration").unlockedBy("moon_deepslate", InventoryChangeTrigger.TriggerInstance.hasItems(BlockRegistry.MOON_DEEPSLATE.get())).save(consumer);
		SingleItemRecipeBuilder.stonecutting(Ingredient.of(ItemRegistry.MOON_DEEPSLATE_TAG), BlockRegistry.MOON_POLISHED_DEEPSLATE.get(), 1)
				.unlockedBy("has_moon_deepslate", InventoryChangeTrigger.TriggerInstance.hasItems(BlockRegistry.MOON_DEEPSLATE.get()))
				.group("celestialexploration").save(consumer, "moon_polished_deepslate_stonecutting");

		ShapedRecipeBuilder.shaped(BlockRegistry.MOON_POLISHED_DEEPSLATE_SLAB.get(), 6)
				.pattern("XXX")
				.define('X', BlockRegistry.MOON_POLISHED_DEEPSLATE.get())
				.group("celestialexploration").unlockedBy("has_moon_deepslate", InventoryChangeTrigger.TriggerInstance.hasItems(BlockRegistry.MOON_DEEPSLATE.get())).save(consumer);
		SingleItemRecipeBuilder.stonecutting(Ingredient.of(ItemRegistry.MOON_DEEPSLATE_TAG), BlockRegistry.MOON_POLISHED_DEEPSLATE_SLAB.get(), 2)
				.unlockedBy("has_moon_deepslate", InventoryChangeTrigger.TriggerInstance.hasItems(BlockRegistry.MOON_DEEPSLATE.get())).save(consumer, "moon_polished_deepslate_slab_stonecutting");

		ShapedRecipeBuilder.shaped(BlockRegistry.MOON_POLISHED_DEEPSLATE_STAIRS.get(), 4)
				.pattern("X  ")
				.pattern("XX ")
				.pattern("XXX")
				.define('X', BlockRegistry.MOON_POLISHED_DEEPSLATE.get())
				.group("celestialexploration").unlockedBy("has_moon_deepslate", InventoryChangeTrigger.TriggerInstance.hasItems(BlockRegistry.MOON_DEEPSLATE.get())).save(consumer);
		SingleItemRecipeBuilder.stonecutting(Ingredient.of(ItemRegistry.MOON_DEEPSLATE_TAG), BlockRegistry.MOON_POLISHED_DEEPSLATE_STAIRS.get(), 1)
				.unlockedBy("has_moon_deepslate", InventoryChangeTrigger.TriggerInstance.hasItems(BlockRegistry.MOON_DEEPSLATE.get())).save(consumer, "moon_polished_deepslate_stairs_stonecutting");

		ShapedRecipeBuilder.shaped(BlockRegistry.MOON_POLISHED_DEEPSLATE_WALL.get(), 6)
				.pattern("XXX")
				.pattern("XXX")
				.define('X', BlockRegistry.MOON_POLISHED_DEEPSLATE.get())
				.group("celestialexploration").unlockedBy("has_moon_deepslate", InventoryChangeTrigger.TriggerInstance.hasItems(BlockRegistry.MOON_DEEPSLATE.get())).save(consumer);
		SingleItemRecipeBuilder.stonecutting(Ingredient.of(ItemRegistry.MOON_DEEPSLATE_TAG), BlockRegistry.MOON_POLISHED_DEEPSLATE_WALL.get(), 1)
				.unlockedBy("has_moon_deepslate", InventoryChangeTrigger.TriggerInstance.hasItems(BlockRegistry.MOON_DEEPSLATE.get())).save(consumer, "moon_polished_deepslate_wall_stonecutting");

		ShapedRecipeBuilder.shaped(BlockRegistry.CHISELED_MOON_DEEPSLATE_BRICKS.get())
				.pattern("X")
				.pattern("X")
				.define('X', BlockRegistry.MOON_DEEPSLATE_BRICK_SLAB.get())
				.group("celestialexploration").unlockedBy("has_moon_deepslate", InventoryChangeTrigger.TriggerInstance.hasItems(BlockRegistry.MOON_DEEPSLATE.get())).save(consumer);
		SingleItemRecipeBuilder.stonecutting(Ingredient.of(ItemRegistry.MOON_DEEPSLATE_TAG), BlockRegistry.CHISELED_MOON_DEEPSLATE_BRICKS.get(), 1)
				.unlockedBy("has_moon_deepslate", InventoryChangeTrigger.TriggerInstance.hasItems(BlockRegistry.MOON_DEEPSLATE.get())).save(consumer, "chiseled_moon_deepslate_bricks_stonecutting");

		ShapelessRecipeBuilder.shapeless(ItemRegistry.MOON_STONE_BUTTON.get())
				.requires(ItemRegistry.MOON_STONE.get())
				.group("celestialexploration").unlockedBy("moon_stone", InventoryChangeTrigger.TriggerInstance.hasItems(ItemRegistry.MOON_STONE.get())).save(consumer);


		ShapedRecipeBuilder.shaped(BlockRegistry.MOON_STONE_PRESSURE_PLATE.get())
				.pattern("XX")
				.define('X', BlockRegistry.MOON_STONE.get())
				.group("celestialexploration").unlockedBy("moon_stone", InventoryChangeTrigger.TriggerInstance.hasItems(BlockRegistry.MOON_STONE.get())).save(consumer);

		ShapelessRecipeBuilder.shapeless(ItemRegistry.MOON_DEEPSLATE_BUTTON.get())
				.requires(BlockRegistry.MOON_DEEPSLATE.get())
				.group("celestialexploration").unlockedBy("moon_deepslate", InventoryChangeTrigger.TriggerInstance.hasItems(ItemRegistry.MOON_DEEPSLATE.get())).save(consumer);

		ShapedRecipeBuilder.shaped(BlockRegistry.MOON_DEEPSLATE_PRESSURE_PLATE.get())
				.pattern("XX")
				.define('X', BlockRegistry.MOON_DEEPSLATE.get())
				.group("celestialexploration").unlockedBy("moon_deepslate", InventoryChangeTrigger.TriggerInstance.hasItems(BlockRegistry.MOON_DEEPSLATE.get())).save(consumer);

		ShapedRecipeBuilder.shaped(BlockRegistry.COMPRESSED_MOON_COBBLESTONE.get())
				.pattern("XXX")
				.pattern("XXX")
				.pattern("XXX")
				.define('X', BlockRegistry.MOON_COBBLESTONE.get())
				.group("celestialexploration").unlockedBy("has_moon_cobblestone", InventoryChangeTrigger.TriggerInstance.hasItems(ItemRegistry.MOON_COBBLESTONE.get())).save(consumer);

		ShapelessRecipeBuilder.shapeless(BlockRegistry.MOON_COBBLESTONE.get(), 9)
				.requires(BlockRegistry.COMPRESSED_MOON_COBBLESTONE.get())
				.group("celestialexploration").unlockedBy("has_moon_cobblestone", InventoryChangeTrigger.TriggerInstance.hasItems(ItemRegistry.MOON_COBBLESTONE.get())).save(consumer);

		ShapedRecipeBuilder.shaped(BlockRegistry.COMPRESSED_MOON_COBBLED_DEEPSLATE.get())
				.pattern("XXX")
				.pattern("XXX")
				.pattern("XXX")
				.define('X', BlockRegistry.MOON_COBBLED_DEEPSLATE.get())
				.group("celestialexploration").unlockedBy("has_moon_cobbled_deepslate", InventoryChangeTrigger.TriggerInstance.hasItems(ItemRegistry.MOON_COBBLED_DEEPSLATE.get())).save(consumer);

		ShapelessRecipeBuilder.shapeless(BlockRegistry.MOON_COBBLED_DEEPSLATE.get(), 9)
				.requires(BlockRegistry.COMPRESSED_MOON_COBBLED_DEEPSLATE.get())
				.group("celestialexploration").unlockedBy("has_moon_cobbled_deepslate", InventoryChangeTrigger.TriggerInstance.hasItems(ItemRegistry.MOON_COBBLED_DEEPSLATE.get())).save(consumer);

//		ShapedRecipeBuilder.shaped(BlockRegistry.LUNAR_LANTERN.get())
//				.pattern("XXX")
//				.pattern("XXX")
//				.pattern("XXX")

		/**MARS*/
		SimpleCookingRecipeBuilder.smelting(Ingredient.of(BlockRegistry.MARS_SAND.get()), Items.ORANGE_STAINED_GLASS, 1.0F, 100)
				.unlockedBy("has_mars_sand", has(BlockRegistry.MARS_SAND.get())).save(consumer, "mars_sand");

		SimpleCookingRecipeBuilder.smelting(Ingredient.of(BlockRegistry.COARSE_MARS_SAND.get()), Items.ORANGE_STAINED_GLASS, 1.0F, 100)
				.unlockedBy("has_mars_sand", has(BlockRegistry.COARSE_MARS_SAND.get())).save(consumer, "coarse_mars_sand");

		ShapedRecipeBuilder.shaped(BlockRegistry.MARS_BRICKS.get(), 4)
				.pattern("XX")
				.pattern("XX")
				.define('X', BlockRegistry.MARS_STONE.get())
				.group("celestialexploration").unlockedBy("mars_stone", InventoryChangeTrigger.TriggerInstance.hasItems(BlockRegistry.MARS_STONE.get())).save(consumer);
		SingleItemRecipeBuilder.stonecutting(Ingredient.of(ItemRegistry.MARS_STONE_TAG), BlockRegistry.MARS_BRICKS.get(), 1)
				.unlockedBy("mars_stone", InventoryChangeTrigger.TriggerInstance.hasItems(BlockRegistry.MARS_STONE.get())).save(consumer, "mars_bricks_stonecutting");

		ShapedRecipeBuilder.shaped(BlockRegistry.MARS_BRICK_SLAB.get(), 6)
				.pattern("XXX")
				.define('X', BlockRegistry.MARS_BRICKS.get())
				.group("celestialexploration").unlockedBy("mars_stone", InventoryChangeTrigger.TriggerInstance.hasItems(BlockRegistry.MARS_STONE.get())).save(consumer);
		SingleItemRecipeBuilder.stonecutting(Ingredient.of(ItemRegistry.MARS_STONE_TAG), BlockRegistry.MARS_BRICK_SLAB.get(), 2)
				.unlockedBy("mars_stone", InventoryChangeTrigger.TriggerInstance.hasItems(BlockRegistry.MARS_STONE.get())).save(consumer, "mars_bricks_slab_stonecutting");

		ShapedRecipeBuilder.shaped(BlockRegistry.MARS_BRICK_STAIRS.get(), 4)
				.pattern("X  ")
				.pattern("XX ")
				.pattern("XXX")
				.define('X', BlockRegistry.MARS_BRICKS.get())
				.group("celestialexploration").unlockedBy("mars_stone", InventoryChangeTrigger.TriggerInstance.hasItems(BlockRegistry.MARS_STONE.get())).save(consumer);
		SingleItemRecipeBuilder.stonecutting(Ingredient.of(ItemRegistry.MARS_STONE_TAG), BlockRegistry.MARS_BRICK_STAIRS.get(), 1)
				.unlockedBy("mars_stone", InventoryChangeTrigger.TriggerInstance.hasItems(BlockRegistry.MARS_STONE.get())).save(consumer, "mars_brick_stairs_stonecutting");

		ShapedRecipeBuilder.shaped(BlockRegistry.MARS_BRICK_WALL.get(), 6)
				.pattern("XXX")
				.pattern("XXX")
				.define('X', BlockRegistry.MARS_BRICKS.get())
				.group("celestialexploration").unlockedBy("mars_stone", InventoryChangeTrigger.TriggerInstance.hasItems(BlockRegistry.MARS_STONE.get())).save(consumer);
		SingleItemRecipeBuilder.stonecutting(Ingredient.of(ItemRegistry.MARS_STONE_TAG), BlockRegistry.MARS_BRICK_WALL.get(), 1)
				.unlockedBy("mars_stone", InventoryChangeTrigger.TriggerInstance.hasItems(BlockRegistry.MARS_STONE.get())).save(consumer, "mars_brick_wall_stonecutting");

		ShapedRecipeBuilder.shaped(BlockRegistry.CHISELED_MARS_BRICKS.get())
				.pattern("X")
				.pattern("X")
				.define('X', BlockRegistry.MARS_BRICK_SLAB.get())
				.group("celestialexploration").unlockedBy("mars_stone", InventoryChangeTrigger.TriggerInstance.hasItems(BlockRegistry.METEOR.get())).save(consumer);
		SingleItemRecipeBuilder.stonecutting(Ingredient.of(ItemRegistry.MARS_STONE_TAG), BlockRegistry.CHISELED_MARS_BRICKS.get(), 1)
				.unlockedBy("mars_stone", InventoryChangeTrigger.TriggerInstance.hasItems(BlockRegistry.MARS_BRICKS.get())).save(consumer, "chiseled_mars_bricks_stonecutting");

		SimpleCookingRecipeBuilder.smelting(Ingredient.of(BlockRegistry.MARS_COBBLESTONE.get()), BlockRegistry.MARS_STONE.get(), 1.0F, 100)
				.unlockedBy("has_mars_cobblestone", has(BlockRegistry.MARS_COBBLESTONE.get())).save(consumer, "mars_cobblestone");

		SimpleCookingRecipeBuilder.smelting(Ingredient.of(BlockRegistry.MARS_COBBLED_DEEPSLATE.get()), BlockRegistry.MARS_DEEPSLATE.get(), 1.0F, 100)
				.unlockedBy("has_mars_cobblestone", has(BlockRegistry.MARS_COBBLED_DEEPSLATE.get())).save(consumer, "mars_cobbled_deepslate");

		ShapedRecipeBuilder.shaped(BlockRegistry.MARS_STONE_SLAB.get(), 6)
				.pattern("XXX")
				.define('X', BlockRegistry.MARS_STONE.get())
				.group("celestialexploration").unlockedBy("mars_stone", InventoryChangeTrigger.TriggerInstance.hasItems(BlockRegistry.MARS_STONE.get())).save(consumer);
		SingleItemRecipeBuilder.stonecutting(Ingredient.of(ItemRegistry.MARS_STONE_TAG), BlockRegistry.MARS_STONE_SLAB.get(), 2)
				.unlockedBy("mars_stone", InventoryChangeTrigger.TriggerInstance.hasItems(BlockRegistry.MARS_STONE.get())).save(consumer, "mars_stone_slab_stonecutting");

		ShapedRecipeBuilder.shaped(BlockRegistry.MARS_STONE_STAIRS.get(), 4)
				.pattern("X  ")
				.pattern("XX ")
				.pattern("XXX")
				.define('X', BlockRegistry.MARS_STONE.get())
				.group("celestialexploration").unlockedBy("mars_stone", InventoryChangeTrigger.TriggerInstance.hasItems(BlockRegistry.MARS_STONE.get())).save(consumer);
		SingleItemRecipeBuilder.stonecutting(Ingredient.of(ItemRegistry.MARS_STONE_TAG), BlockRegistry.MARS_STONE_STAIRS.get(), 1)
				.unlockedBy("mars_stone", InventoryChangeTrigger.TriggerInstance.hasItems(BlockRegistry.MARS_STONE.get())).save(consumer, "mars_stone_stairs_stonecutting");

		ShapedRecipeBuilder.shaped(BlockRegistry.MARS_COBBLESTONE_SLAB.get(), 6)
				.pattern("XXX")
				.define('X', BlockRegistry.MARS_COBBLESTONE.get())
				.group("celestialexploration").unlockedBy("mars_cobblestone", InventoryChangeTrigger.TriggerInstance.hasItems(BlockRegistry.MARS_STONE.get())).save(consumer);
		SingleItemRecipeBuilder.stonecutting(Ingredient.of(ItemRegistry.MARS_COBBLESTONE_TAG), BlockRegistry.MARS_COBBLESTONE_SLAB.get(), 2)
				.unlockedBy("mars_stone", InventoryChangeTrigger.TriggerInstance.hasItems(BlockRegistry.MARS_STONE.get())).save(consumer, "mars_cobblestone_slab_stonecutting");

		ShapedRecipeBuilder.shaped(BlockRegistry.MARS_COBBLESTONE_STAIRS.get(), 4)
				.pattern("X  ")
				.pattern("XX ")
				.pattern("XXX")
				.define('X', BlockRegistry.MARS_COBBLESTONE.get())
				.group("celestialexploration").unlockedBy("mars_cobblestone", InventoryChangeTrigger.TriggerInstance.hasItems(BlockRegistry.MARS_STONE.get())).save(consumer);
		SingleItemRecipeBuilder.stonecutting(Ingredient.of(ItemRegistry.MARS_COBBLESTONE_TAG), BlockRegistry.MARS_COBBLESTONE_STAIRS.get(), 1)
				.unlockedBy("mars_stone", InventoryChangeTrigger.TriggerInstance.hasItems(BlockRegistry.MARS_STONE.get())).save(consumer, "mars_cobblestone_stairs_stonecutting");

		ShapedRecipeBuilder.shaped(BlockRegistry.MARS_COBBLESTONE_WALL.get(), 6)
				.pattern("XXX")
				.pattern("XXX")
				.define('X', BlockRegistry.MARS_COBBLESTONE.get())
				.group("celestialexploration").unlockedBy("mars_cobblestone", InventoryChangeTrigger.TriggerInstance.hasItems(BlockRegistry.MARS_STONE.get())).save(consumer);
		SingleItemRecipeBuilder.stonecutting(Ingredient.of(ItemRegistry.MARS_COBBLESTONE_TAG), BlockRegistry.MARS_COBBLESTONE_WALL.get(), 1)
				.unlockedBy("mars_stone", InventoryChangeTrigger.TriggerInstance.hasItems(BlockRegistry.MARS_STONE.get())).save(consumer, "mars_cobblestone_wall_stonecutting");


		ShapedRecipeBuilder.shaped(BlockRegistry.MARS_COBBLED_DEEPSLATE_SLAB.get(), 6)
				.pattern("XXX")
				.define('X', BlockRegistry.MARS_COBBLED_DEEPSLATE.get())
				.group("celestialexploration").unlockedBy("mars_stone", InventoryChangeTrigger.TriggerInstance.hasItems(BlockRegistry.MARS_STONE.get())).save(consumer);
		SingleItemRecipeBuilder.stonecutting(Ingredient.of(ItemRegistry.MARS_COBBLED_DEEPSLATE_TAG), BlockRegistry.MARS_COBBLED_DEEPSLATE_SLAB.get(), 2)
				.unlockedBy("mars_stone", InventoryChangeTrigger.TriggerInstance.hasItems(BlockRegistry.MARS_STONE.get())).save(consumer, "mars_cobbled_deepslate_slab_stonecutting");

		ShapedRecipeBuilder.shaped(BlockRegistry.MARS_COBBLED_DEEPSLATE_STAIRS.get(), 4)
				.pattern("X  ")
				.pattern("XX ")
				.pattern("XXX")
				.define('X', BlockRegistry.MARS_COBBLED_DEEPSLATE.get())
				.group("celestialexploration").unlockedBy("mars_stone", InventoryChangeTrigger.TriggerInstance.hasItems(BlockRegistry.MARS_STONE.get())).save(consumer);
		SingleItemRecipeBuilder.stonecutting(Ingredient.of(ItemRegistry.MARS_COBBLED_DEEPSLATE_TAG), BlockRegistry.MARS_COBBLED_DEEPSLATE_STAIRS.get(), 1)
				.unlockedBy("mars_stone", InventoryChangeTrigger.TriggerInstance.hasItems(BlockRegistry.MARS_STONE.get())).save(consumer, "mars_cobbled_deepslate_stairs_stonecutting");

		ShapedRecipeBuilder.shaped(BlockRegistry.MARS_COBBLED_DEEPSLATE_WALL.get(), 6)
				.pattern("XXX")
				.pattern("XXX")
				.define('X', BlockRegistry.MARS_COBBLED_DEEPSLATE.get())
				.group("celestialexploration").unlockedBy("mars_stone", InventoryChangeTrigger.TriggerInstance.hasItems(BlockRegistry.MARS_STONE.get())).save(consumer);
		SingleItemRecipeBuilder.stonecutting(Ingredient.of(ItemRegistry.MARS_COBBLED_DEEPSLATE_TAG), BlockRegistry.MARS_COBBLED_DEEPSLATE_WALL.get(), 1)
				.unlockedBy("mars_stone", InventoryChangeTrigger.TriggerInstance.hasItems(BlockRegistry.MARS_STONE.get())).save(consumer, "mars_cobbled_deepslate_wall_stonecutting");

		SimpleCookingRecipeBuilder.smelting(Ingredient.of(BlockRegistry.MARS_STONE.get()), ItemRegistry.MARS_SMOOTH_STONE.get(), 1.0F, 100)
				.unlockedBy("has_mars_stone", has(BlockRegistry.MARS_STONE.get())).save(consumer, "mars_smooth_stone");

//		ShapedRecipeBuilder.shaped(BlockRegistry.MARS_SMOOTH_STONE_SLAB.get(), 6)
//				.pattern("XXX")
//				.define('X', BlockRegistry.MARS_SMOOTH_STONE.get())
//				.group("celestialexploration").unlockedBy("has_mars_smooth_stone", InventoryChangeTrigger.TriggerInstance.hasItems(BlockRegistry.MARS_STONE.get())).save(consumer);
//		SingleItemRecipeBuilder.stonecutting(Ingredient.of(ItemRegistry.MARS_COBBLED_DEEPSLATE_TAG), BlockRegistry.MARS_SMOOTH_STONE_SLAB.get(), 2)
//				.unlockedBy("has_mars_smooth_stone", InventoryChangeTrigger.TriggerInstance.hasItems(BlockRegistry.MARS_SMOOTH_STONE.get())).save(consumer, "mars_smooth_stone_slab_stonecutting");

		ShapedRecipeBuilder.shaped(BlockRegistry.MARS_DEEPSLATE_BRICKS.get(), 4)
				.pattern("XX")
				.pattern("XX")
				.define('X', BlockRegistry.MARS_DEEPSLATE.get())
				.group("celestialexploration").unlockedBy("mars_deepslate", InventoryChangeTrigger.TriggerInstance.hasItems(BlockRegistry.MARS_DEEPSLATE.get())).save(consumer);
		SingleItemRecipeBuilder.stonecutting(Ingredient.of(ItemRegistry.MARS_DEEPSLATE_TAG), BlockRegistry.MARS_DEEPSLATE_BRICKS.get(), 1)
				.unlockedBy("has_mars_deepslate", InventoryChangeTrigger.TriggerInstance.hasItems(BlockRegistry.MARS_DEEPSLATE.get()))
				.group("celestialexploration").save(consumer, "mars_deepslate_bricks_stonecutting");

		ShapedRecipeBuilder.shaped(BlockRegistry.MARS_DEEPSLATE_BRICK_SLAB.get(), 6)
				.pattern("XXX")
				.define('X', BlockRegistry.MARS_DEEPSLATE_BRICKS.get())
				.group("celestialexploration").unlockedBy("has_mars_deepslate", InventoryChangeTrigger.TriggerInstance.hasItems(BlockRegistry.MARS_DEEPSLATE.get())).save(consumer);
		SingleItemRecipeBuilder.stonecutting(Ingredient.of(ItemRegistry.MARS_DEEPSLATE_TAG), BlockRegistry.MARS_DEEPSLATE_BRICK_SLAB.get(), 2)
				.unlockedBy("has_mars_deepslate", InventoryChangeTrigger.TriggerInstance.hasItems(BlockRegistry.MARS_DEEPSLATE.get())).save(consumer, "mars_deepslate_brick_slab_stonecutting");

		ShapedRecipeBuilder.shaped(BlockRegistry.MARS_DEEPSLATE_BRICK_STAIRS.get(), 4)
				.pattern("X  ")
				.pattern("XX ")
				.pattern("XXX")
				.define('X', BlockRegistry.MARS_DEEPSLATE_BRICKS.get())
				.group("celestialexploration").unlockedBy("has_mars_deepslate", InventoryChangeTrigger.TriggerInstance.hasItems(BlockRegistry.MARS_DEEPSLATE.get())).save(consumer);
		SingleItemRecipeBuilder.stonecutting(Ingredient.of(ItemRegistry.MARS_DEEPSLATE_TAG), BlockRegistry.MARS_DEEPSLATE_BRICK_STAIRS.get(), 1)
				.unlockedBy("has_mars_deepslate", InventoryChangeTrigger.TriggerInstance.hasItems(BlockRegistry.MARS_DEEPSLATE.get())).save(consumer, "mars_deepslate_brick_stairs_stonecutting");

		ShapedRecipeBuilder.shaped(BlockRegistry.MARS_DEEPSLATE_BRICK_WALL.get(), 6)
				.pattern("XXX")
				.pattern("XXX")
				.define('X', BlockRegistry.MARS_DEEPSLATE_BRICKS.get())
				.group("celestialexploration").unlockedBy("has_mars_deepslate", InventoryChangeTrigger.TriggerInstance.hasItems(BlockRegistry.MARS_DEEPSLATE.get())).save(consumer);
		SingleItemRecipeBuilder.stonecutting(Ingredient.of(ItemRegistry.MARS_DEEPSLATE_TAG), BlockRegistry.MARS_DEEPSLATE_BRICK_WALL.get(), 1)
				.unlockedBy("has_mars_deepslate", InventoryChangeTrigger.TriggerInstance.hasItems(BlockRegistry.MARS_DEEPSLATE.get())).save(consumer, "mars_deepslate_brick_wall_stonecutting");

		ShapedRecipeBuilder.shaped(BlockRegistry.MARS_DEEPSLATE_TILES.get(), 4)
				.pattern("XX")
				.pattern("XX")
				.define('X', BlockRegistry.MARS_DEEPSLATE.get())
				.group("celestialexploration").unlockedBy("mars_deepslate", InventoryChangeTrigger.TriggerInstance.hasItems(BlockRegistry.MARS_DEEPSLATE.get())).save(consumer);
		SingleItemRecipeBuilder.stonecutting(Ingredient.of(ItemRegistry.MARS_DEEPSLATE_TAG), BlockRegistry.MARS_DEEPSLATE_TILES.get(), 1)
				.unlockedBy("has_mars_deepslate", InventoryChangeTrigger.TriggerInstance.hasItems(BlockRegistry.MARS_DEEPSLATE.get()))
				.group("celestialexploration").save(consumer, "mars_deepslate_tiles_stonecutting");

		ShapedRecipeBuilder.shaped(BlockRegistry.MARS_DEEPSLATE_TILE_SLAB.get(), 6)
				.pattern("XXX")
				.define('X', BlockRegistry.MARS_DEEPSLATE_TILES.get())
				.group("celestialexploration").unlockedBy("has_mars_deepslate", InventoryChangeTrigger.TriggerInstance.hasItems(BlockRegistry.MARS_DEEPSLATE.get())).save(consumer);
		SingleItemRecipeBuilder.stonecutting(Ingredient.of(ItemRegistry.MARS_DEEPSLATE_TAG), BlockRegistry.MARS_DEEPSLATE_TILE_SLAB.get(), 2)
				.unlockedBy("has_mars_deepslate", InventoryChangeTrigger.TriggerInstance.hasItems(BlockRegistry.MARS_DEEPSLATE.get())).save(consumer, "mars_deepslate_tile_slab_stonecutting");

		ShapedRecipeBuilder.shaped(BlockRegistry.MARS_DEEPSLATE_TILE_STAIRS.get(), 4)
				.pattern("X  ")
				.pattern("XX ")
				.pattern("XXX")
				.define('X', BlockRegistry.MARS_DEEPSLATE_TILES.get())
				.group("celestialexploration").unlockedBy("has_mars_deepslate", InventoryChangeTrigger.TriggerInstance.hasItems(BlockRegistry.MARS_DEEPSLATE.get())).save(consumer);
		SingleItemRecipeBuilder.stonecutting(Ingredient.of(ItemRegistry.MARS_DEEPSLATE_TAG), BlockRegistry.MARS_DEEPSLATE_TILE_STAIRS.get(), 1)
				.unlockedBy("has_mars_deepslate", InventoryChangeTrigger.TriggerInstance.hasItems(BlockRegistry.MARS_DEEPSLATE.get())).save(consumer, "mars_deepslate_tile_stairs_stonecutting");

		ShapedRecipeBuilder.shaped(BlockRegistry.MARS_DEEPSLATE_TILE_WALL.get(), 6)
				.pattern("XXX")
				.pattern("XXX")
				.define('X', BlockRegistry.MARS_DEEPSLATE_TILES.get())
				.group("celestialexploration").unlockedBy("has_mars_deepslate", InventoryChangeTrigger.TriggerInstance.hasItems(BlockRegistry.MARS_DEEPSLATE.get())).save(consumer);
		SingleItemRecipeBuilder.stonecutting(Ingredient.of(ItemRegistry.MARS_DEEPSLATE_TAG), BlockRegistry.MARS_DEEPSLATE_TILE_WALL.get(), 1)
				.unlockedBy("has_mars_deepslate", InventoryChangeTrigger.TriggerInstance.hasItems(BlockRegistry.MARS_DEEPSLATE.get())).save(consumer, "mars_deepslate_tile_wall_stonecutting");

		ShapedRecipeBuilder.shaped(BlockRegistry.MARS_POLISHED_DEEPSLATE.get(), 4)
				.pattern("XX")
				.pattern("XX")
				.define('X', BlockRegistry.MARS_DEEPSLATE.get())
				.group("celestialexploration").unlockedBy("mars_deepslate", InventoryChangeTrigger.TriggerInstance.hasItems(BlockRegistry.MARS_DEEPSLATE.get())).save(consumer);
		SingleItemRecipeBuilder.stonecutting(Ingredient.of(ItemRegistry.MARS_DEEPSLATE_TAG), BlockRegistry.MARS_POLISHED_DEEPSLATE.get(), 1)
				.unlockedBy("has_mars_deepslate", InventoryChangeTrigger.TriggerInstance.hasItems(BlockRegistry.MARS_DEEPSLATE.get()))
				.group("celestialexploration").save(consumer, "mars_polished_deepslate_stonecutting");

		ShapedRecipeBuilder.shaped(BlockRegistry.MARS_POLISHED_DEEPSLATE_SLAB.get(), 6)
				.pattern("XXX")
				.define('X', BlockRegistry.MARS_POLISHED_DEEPSLATE.get())
				.group("celestialexploration").unlockedBy("has_mars_deepslate", InventoryChangeTrigger.TriggerInstance.hasItems(BlockRegistry.MARS_DEEPSLATE.get())).save(consumer);
		SingleItemRecipeBuilder.stonecutting(Ingredient.of(ItemRegistry.MARS_DEEPSLATE_TAG), BlockRegistry.MARS_POLISHED_DEEPSLATE_SLAB.get(), 2)
				.unlockedBy("has_mars_deepslate", InventoryChangeTrigger.TriggerInstance.hasItems(BlockRegistry.MARS_DEEPSLATE.get())).save(consumer, "mars_polished_deepslate_slab_stonecutting");

		ShapedRecipeBuilder.shaped(BlockRegistry.MARS_POLISHED_DEEPSLATE_STAIRS.get(), 4)
				.pattern("X  ")
				.pattern("XX ")
				.pattern("XXX")
				.define('X', BlockRegistry.MARS_POLISHED_DEEPSLATE.get())
				.group("celestialexploration").unlockedBy("has_mars_deepslate", InventoryChangeTrigger.TriggerInstance.hasItems(BlockRegistry.MARS_DEEPSLATE.get())).save(consumer);
		SingleItemRecipeBuilder.stonecutting(Ingredient.of(ItemRegistry.MARS_DEEPSLATE_TAG), BlockRegistry.MARS_POLISHED_DEEPSLATE_STAIRS.get(), 1)
				.unlockedBy("has_mars_deepslate", InventoryChangeTrigger.TriggerInstance.hasItems(BlockRegistry.MARS_DEEPSLATE.get())).save(consumer, "mars_polished_deepslate_stairs_stonecutting");

		ShapedRecipeBuilder.shaped(BlockRegistry.MARS_POLISHED_DEEPSLATE_WALL.get(), 6)
				.pattern("XXX")
				.pattern("XXX")
				.define('X', BlockRegistry.MARS_POLISHED_DEEPSLATE.get())
				.group("celestialexploration").unlockedBy("has_mars_deepslate", InventoryChangeTrigger.TriggerInstance.hasItems(BlockRegistry.MARS_DEEPSLATE.get())).save(consumer);
		SingleItemRecipeBuilder.stonecutting(Ingredient.of(ItemRegistry.MARS_DEEPSLATE_TAG), BlockRegistry.MARS_POLISHED_DEEPSLATE_WALL.get(), 1)
				.unlockedBy("has_mars_deepslate", InventoryChangeTrigger.TriggerInstance.hasItems(BlockRegistry.MARS_DEEPSLATE.get())).save(consumer, "mars_polished_deepslate_wall_stonecutting");

		ShapedRecipeBuilder.shaped(BlockRegistry.CHISELED_MARS_DEEPSLATE_BRICKS.get())
				.pattern("X")
				.pattern("X")
				.define('X', BlockRegistry.MARS_DEEPSLATE_BRICK_SLAB.get())
				.group("celestialexploration").unlockedBy("has_mars_deepslate", InventoryChangeTrigger.TriggerInstance.hasItems(BlockRegistry.MARS_DEEPSLATE.get())).save(consumer);
		SingleItemRecipeBuilder.stonecutting(Ingredient.of(ItemRegistry.MARS_DEEPSLATE_TAG), BlockRegistry.CHISELED_MARS_DEEPSLATE_BRICKS.get(), 1)
				.unlockedBy("has_mars_deepslate", InventoryChangeTrigger.TriggerInstance.hasItems(BlockRegistry.MARS_DEEPSLATE.get())).save(consumer, "chiseled_mars_deepslate_bricks_stonecutting");

		ShapelessRecipeBuilder.shapeless(ItemRegistry.MARS_STONE_BUTTON.get())
				.requires(ItemRegistry.MARS_STONE.get())
				.group("celestialexploration").unlockedBy("mars_stone", InventoryChangeTrigger.TriggerInstance.hasItems(ItemRegistry.MARS_STONE.get())).save(consumer);

		ShapedRecipeBuilder.shaped(BlockRegistry.MARS_STONE_PRESSURE_PLATE.get())
				.pattern("XX")
				.define('X', BlockRegistry.MARS_STONE.get())
				.group("celestialexploration").unlockedBy("mars_stone", InventoryChangeTrigger.TriggerInstance.hasItems(BlockRegistry.MARS_STONE.get())).save(consumer);

		ShapelessRecipeBuilder.shapeless(ItemRegistry.MARS_DEEPSLATE_BUTTON.get())
				.requires(ItemRegistry.MARS_DEEPSLATE.get())
				.group("celestialexploration").unlockedBy("mars_deepslate", InventoryChangeTrigger.TriggerInstance.hasItems(ItemRegistry.MARS_DEEPSLATE.get())).save(consumer);

		ShapedRecipeBuilder.shaped(BlockRegistry.MARS_DEEPSLATE_PRESSURE_PLATE.get())
				.pattern("XX")
				.define('X', BlockRegistry.MARS_DEEPSLATE.get())
				.group("celestialexploration").unlockedBy("mars_deepslate", InventoryChangeTrigger.TriggerInstance.hasItems(BlockRegistry.MARS_DEEPSLATE.get())).save(consumer);

		ShapedRecipeBuilder.shaped(BlockRegistry.COMPRESSED_MARS_COBBLESTONE.get())
				.pattern("XXX")
				.pattern("XXX")
				.pattern("XXX")
				.define('X', BlockRegistry.MARS_COBBLESTONE.get())
				.group("celestialexploration").unlockedBy("has_mars_cobblestone", InventoryChangeTrigger.TriggerInstance.hasItems(ItemRegistry.MARS_COBBLESTONE.get())).save(consumer);

		ShapelessRecipeBuilder.shapeless(BlockRegistry.MARS_COBBLESTONE.get(), 9)
				.requires(BlockRegistry.COMPRESSED_MARS_COBBLESTONE.get())
				.group("celestialexploration").unlockedBy("has_mars_cobblestone", InventoryChangeTrigger.TriggerInstance.hasItems(ItemRegistry.MARS_COBBLESTONE.get())).save(consumer);

		ShapedRecipeBuilder.shaped(BlockRegistry.COMPRESSED_MARS_COBBLED_DEEPSLATE.get())
				.pattern("XXX")
				.pattern("XXX")
				.pattern("XXX")
				.define('X', BlockRegistry.MARS_COBBLED_DEEPSLATE.get())
				.group("celestialexploration").unlockedBy("has_mars_cobbled_deepslate", InventoryChangeTrigger.TriggerInstance.hasItems(ItemRegistry.MARS_COBBLED_DEEPSLATE.get())).save(consumer);

		ShapelessRecipeBuilder.shapeless(BlockRegistry.MARS_COBBLED_DEEPSLATE.get(), 9)
				.requires(BlockRegistry.COMPRESSED_MARS_COBBLED_DEEPSLATE.get())
				.group("celestialexploration").unlockedBy("has_mars_cobbled_deepslate", InventoryChangeTrigger.TriggerInstance.hasItems(ItemRegistry.MARS_COBBLED_DEEPSLATE.get())).save(consumer);


		/**METEOR*/
//		SimpleCookingRecipeBuilder.smelting(Ingredient.of(BlockRegistry.METEOR.get()), ItemRegistry.METEOR_INGOT.get(), 1.0F, 100)
//				.unlockedBy("meteor", has(BlockRegistry.METEOR.get())).save(consumer, "meteor");

		ShapedRecipeBuilder.shaped(BlockRegistry.METEOR_BRICKS.get(), 4)
				.pattern("XX")
				.pattern("XX")
				.define('X', ItemRegistry.METEOR.get())
				.group("celestialexploration").unlockedBy("meteor", InventoryChangeTrigger.TriggerInstance.hasItems(BlockRegistry.METEOR.get())).save(consumer);
		SingleItemRecipeBuilder.stonecutting(Ingredient.of(ItemRegistry.METEOR_TAG), BlockRegistry.METEOR_BRICKS.get(), 1)
				.unlockedBy("meteor", InventoryChangeTrigger.TriggerInstance.hasItems(BlockRegistry.METEOR.get())).save(consumer, "meteor_bricks_stonecutting");

		ShapedRecipeBuilder.shaped(BlockRegistry.METEOR_BRICK_SLAB.get(), 6)
				.pattern("XXX")
				.define('X', ItemRegistry.METEOR_BRICKS.get())
				.group("celestialexploration").unlockedBy("meteor", InventoryChangeTrigger.TriggerInstance.hasItems(BlockRegistry.METEOR.get())).save(consumer);
		SingleItemRecipeBuilder.stonecutting(Ingredient.of(ItemRegistry.METEOR_TAG), BlockRegistry.METEOR_BRICK_SLAB.get(), 2)
				.unlockedBy("meteor", InventoryChangeTrigger.TriggerInstance.hasItems(BlockRegistry.METEOR.get())).save(consumer, "meteor_brick_slab_stonecutting");

		ShapedRecipeBuilder.shaped(BlockRegistry.METEOR_BRICK_STAIRS.get(), 4)
				.pattern("X  ")
				.pattern("XX ")
				.pattern("XXX")
				.define('X', ItemRegistry.METEOR_BRICKS.get())
				.group("celestialexploration").unlockedBy("meteor", InventoryChangeTrigger.TriggerInstance.hasItems(BlockRegistry.METEOR.get())).save(consumer);
		SingleItemRecipeBuilder.stonecutting(Ingredient.of(ItemRegistry.METEOR_TAG), BlockRegistry.METEOR_BRICK_STAIRS.get(), 1)
				.unlockedBy("meteor", InventoryChangeTrigger.TriggerInstance.hasItems(BlockRegistry.METEOR.get())).save(consumer, "meteor_brick_stairs_stonecutting");

		ShapedRecipeBuilder.shaped(BlockRegistry.METEOR_BRICK_WALL.get(), 6)
				.pattern("XXX")
				.pattern("XXX")
				.define('X', BlockRegistry.METEOR_BRICKS.get())
				.group("celestialexploration").unlockedBy("meteor", InventoryChangeTrigger.TriggerInstance.hasItems(BlockRegistry.METEOR.get())).save(consumer);
		SingleItemRecipeBuilder.stonecutting(Ingredient.of(ItemRegistry.METEOR_TAG), BlockRegistry.METEOR_BRICK_WALL.get(), 1)
				.unlockedBy("meteor", InventoryChangeTrigger.TriggerInstance.hasItems(BlockRegistry.METEOR.get())).save(consumer, "meteor_brick_wall_stonecutting");

		ShapedRecipeBuilder.shaped(BlockRegistry.CHISELED_METEOR_BRICKS.get())
				.pattern("X")
				.pattern("X")
				.define('X', BlockRegistry.METEOR_BRICK_SLAB.get())
				.group("celestialexploration").unlockedBy("meteor", InventoryChangeTrigger.TriggerInstance.hasItems(BlockRegistry.METEOR.get())).save(consumer);
		SingleItemRecipeBuilder.stonecutting(Ingredient.of(ItemRegistry.METEOR_TAG), BlockRegistry.CHISELED_METEOR_BRICKS.get(), 1)
				.unlockedBy("meteor", InventoryChangeTrigger.TriggerInstance.hasItems(BlockRegistry.METEOR_BRICKS.get())).save(consumer, "chiseled_meteor_bricks_stonecutting");

		ShapelessRecipeBuilder.shapeless(ItemRegistry.METEOR_BUTTON.get())
				.requires(ItemRegistry.METEOR.get())
				.group("celestialexploration").unlockedBy("meteor", InventoryChangeTrigger.TriggerInstance.hasItems(ItemRegistry.METEOR.get())).save(consumer);

		ShapedRecipeBuilder.shaped(BlockRegistry.METEOR_PRESSURE_PLATE.get())
				.pattern("XX")
				.define('X', BlockRegistry.METEOR.get())
				.group("celestialexploration").unlockedBy("meteor", InventoryChangeTrigger.TriggerInstance.hasItems(BlockRegistry.METEOR.get())).save(consumer);


		/**STEEL*/
		ShapelessRecipeBuilder.shapeless(ItemRegistry.STEEL_INGOT.get(), 2)
				.requires(Items.COAL)
				.requires(Items.IRON_INGOT)
				.requires(Items.COAL)
				.requires(Items.IRON_INGOT)
				.group("celestialexploration").unlockedBy("iron", InventoryChangeTrigger.TriggerInstance.hasItems(Items.IRON_INGOT)).save(consumer);

		ShapedRecipeBuilder.shaped(ItemRegistry.STEEL_ROD.get(), 4)
				.pattern("X")
				.pattern("X")
				.pattern("X")
				.define('X', ItemRegistry.STEEL_INGOT.get())
				.group("celestialexploration").unlockedBy("steel", InventoryChangeTrigger.TriggerInstance.hasItems(ItemRegistry.STEEL_INGOT.get())).save(consumer);

		ShapedRecipeBuilder.shaped(ItemRegistry.STEEL_BLOCK.get())
				.pattern("XXX")
				.pattern("XXX")
				.pattern("XXX")
				.define('X', ItemRegistry.STEEL_INGOT.get())
				.group("celestialexploration").unlockedBy("steel", InventoryChangeTrigger.TriggerInstance.hasItems(ItemRegistry.STEEL_INGOT.get())).save(consumer);

		/**SHUTTLE-ITEMS*/
		ShapedRecipeBuilder.shaped(BlockRegistry.STEEL_FRAME.get(), 6)
				.pattern("X X")
				.pattern("XXX")
				.pattern("X X")
				.define('X', ItemRegistry.STEEL_ROD.get())
				.group("celestialexploration").unlockedBy("steel", InventoryChangeTrigger.TriggerInstance.hasItems(ItemRegistry.STEEL_INGOT.get())).save(consumer);
		ShapedRecipeBuilder.shaped(ItemRegistry.SHUTTLE_FRAME.get())
				.pattern("CSC")
				.pattern("S S")
				.pattern("CSC")
				.define('C', ItemRegistry.CERAMIC_TILE.get())
				.define('S', ItemRegistry.STEEL_INGOT.get())
				.group("celestialexploration").unlockedBy("steel", InventoryChangeTrigger.TriggerInstance.hasItems(ItemRegistry.STEEL_INGOT.get())).save(consumer);
		ShapedRecipeBuilder.shaped(ItemRegistry.NOSE_CONE.get())
				.pattern(" C ")
				.pattern("CSC")
				.define('C', ItemRegistry.CERAMIC_TILE.get())
				.define('S', ItemRegistry.STEEL_BLOCK.get())
				.group("celestialexploration").unlockedBy("steel", InventoryChangeTrigger.TriggerInstance.hasItems(ItemRegistry.STEEL_INGOT.get())).save(consumer);
		ShapedRecipeBuilder.shaped(ItemRegistry.SHUTTLE_CABIN.get())
				.pattern(" N ")
				.pattern("CGC")
				.pattern("XSX")
				.define('N', ItemRegistry.NOSE_CONE.get())
				.define('C', ItemRegistry.CERAMIC_TILE.get())
				.define('G', Items.GLASS)
				.define('S', ItemRegistry.STEEL_BLOCK.get())
				.define('X', Tags.Items.CHESTS)
				.group("celestialexploration").unlockedBy("steel", InventoryChangeTrigger.TriggerInstance.hasItems(ItemRegistry.STEEL_INGOT.get())).save(consumer);
		ShapedRecipeBuilder.shaped(ItemRegistry.LOX_TANK.get())
				.pattern("sSs")
				.pattern("G G")
				.pattern("sSs")
				.define('S', ItemRegistry.STEEL_BLOCK.get())
				.define('s', ItemRegistry.STEEL_INGOT.get())
				.define('G', Tags.Items.GLASS)
				.group("celestialexploration").unlockedBy("steel", InventoryChangeTrigger.TriggerInstance.hasItems(ItemRegistry.STEEL_INGOT.get())).save(consumer);

		ShapedRecipeBuilder.shaped(ItemRegistry.SHUTTLE_ENGINE.get())
				.pattern("sRs")
				.pattern("SKS")
				.pattern("TTT")
				.define('s', ItemRegistry.STEEL_INGOT.get())
				.define('S', ItemRegistry.STEEL_BLOCK.get())
				.define('K', ItemRegistry.LOX_TANK.get())
				.define('R', Items.REDSTONE)
				.define('T', Items.REDSTONE_TORCH)
				.group("celestialexploration").unlockedBy("steel", InventoryChangeTrigger.TriggerInstance.hasItems(ItemRegistry.STEEL_INGOT.get())).save(consumer);

		ShapedRecipeBuilder.shaped(ItemRegistry.WHITE_SHUTTLE.get())
				.pattern("C")
				.pattern("F")
				.pattern("E")
				.define('C', ItemRegistry.SHUTTLE_CABIN.get())
				.define('F', ItemRegistry.SHUTTLE_FRAME.get())
				.define('E', ItemRegistry.SHUTTLE_ENGINE.get())
				.group("celestialexploration").unlockedBy("steel", InventoryChangeTrigger.TriggerInstance.hasItems(ItemRegistry.STEEL_INGOT.get())).save(consumer);

		ShapelessRecipeBuilder.shapeless(ItemRegistry.BLACK_SHUTTLE.get())
				.requires(ItemRegistry.WHITE_SHUTTLE.get())
				.requires(Items.BLACK_DYE)
				.group("celestialexploration").unlockedBy("shuttle", InventoryChangeTrigger.TriggerInstance.hasItems(ItemRegistry.WHITE_SHUTTLE.get())).save(consumer);

		ShapelessRecipeBuilder.shapeless(ItemRegistry.GREY_SHUTTLE.get())
				.requires(ItemRegistry.WHITE_SHUTTLE.get())
				.requires(Items.GRAY_DYE)
				.group("celestialexploration").unlockedBy("shuttle", InventoryChangeTrigger.TriggerInstance.hasItems(ItemRegistry.WHITE_SHUTTLE.get())).save(consumer);

		ShapelessRecipeBuilder.shapeless(ItemRegistry.LIGHT_GREY_SHUTTLE.get())
				.requires(ItemRegistry.WHITE_SHUTTLE.get())
				.requires(Items.LIGHT_GRAY_DYE)
				.group("celestialexploration").unlockedBy("shuttle", InventoryChangeTrigger.TriggerInstance.hasItems(ItemRegistry.WHITE_SHUTTLE.get())).save(consumer);

		ShapelessRecipeBuilder.shapeless(ItemRegistry.PINK_SHUTTLE.get())
				.requires(ItemRegistry.WHITE_SHUTTLE.get())
				.requires(Items.PINK_DYE)
				.group("celestialexploration").unlockedBy("shuttle", InventoryChangeTrigger.TriggerInstance.hasItems(ItemRegistry.WHITE_SHUTTLE.get())).save(consumer);

		ShapelessRecipeBuilder.shapeless(ItemRegistry.RED_SHUTTLE.get())
				.requires(ItemRegistry.WHITE_SHUTTLE.get())
				.requires(Items.RED_DYE)
				.group("celestialexploration").unlockedBy("shuttle", InventoryChangeTrigger.TriggerInstance.hasItems(ItemRegistry.WHITE_SHUTTLE.get())).save(consumer);

		ShapelessRecipeBuilder.shapeless(ItemRegistry.ORANGE_SHUTTLE.get())
				.requires(ItemRegistry.WHITE_SHUTTLE.get())
				.requires(Items.ORANGE_DYE)
				.group("celestialexploration").unlockedBy("shuttle", InventoryChangeTrigger.TriggerInstance.hasItems(ItemRegistry.WHITE_SHUTTLE.get())).save(consumer);

		ShapelessRecipeBuilder.shapeless(ItemRegistry.YELLOW_SHUTTLE.get())
				.requires(ItemRegistry.WHITE_SHUTTLE.get())
				.requires(Items.YELLOW_DYE)
				.group("celestialexploration").unlockedBy("shuttle", InventoryChangeTrigger.TriggerInstance.hasItems(ItemRegistry.WHITE_SHUTTLE.get())).save(consumer);

		ShapelessRecipeBuilder.shapeless(ItemRegistry.LIME_SHUTTLE.get())
				.requires(ItemRegistry.WHITE_SHUTTLE.get())
				.requires(Items.LIME_DYE)
				.group("celestialexploration").unlockedBy("shuttle", InventoryChangeTrigger.TriggerInstance.hasItems(ItemRegistry.WHITE_SHUTTLE.get())).save(consumer);

		ShapelessRecipeBuilder.shapeless(ItemRegistry.GREEN_SHUTTLE.get())
				.requires(ItemRegistry.WHITE_SHUTTLE.get())
				.requires(Items.GREEN_DYE)
				.group("celestialexploration").unlockedBy("shuttle", InventoryChangeTrigger.TriggerInstance.hasItems(ItemRegistry.WHITE_SHUTTLE.get())).save(consumer);

		ShapelessRecipeBuilder.shapeless(ItemRegistry.CYAN_SHUTTLE.get())
				.requires(ItemRegistry.WHITE_SHUTTLE.get())
				.requires(Items.CYAN_DYE)
				.group("celestialexploration").unlockedBy("shuttle", InventoryChangeTrigger.TriggerInstance.hasItems(ItemRegistry.WHITE_SHUTTLE.get())).save(consumer);

		ShapelessRecipeBuilder.shapeless(ItemRegistry.BLUE_SHUTTLE.get())
				.requires(ItemRegistry.WHITE_SHUTTLE.get())
				.requires(Items.BLUE_DYE)
				.group("celestialexploration").unlockedBy("shuttle", InventoryChangeTrigger.TriggerInstance.hasItems(ItemRegistry.WHITE_SHUTTLE.get())).save(consumer);

		ShapelessRecipeBuilder.shapeless(ItemRegistry.LIGHT_BLUE_SHUTTLE.get())
				.requires(ItemRegistry.WHITE_SHUTTLE.get())
				.requires(Items.LIGHT_BLUE_DYE)
				.group("celestialexploration").unlockedBy("shuttle", InventoryChangeTrigger.TriggerInstance.hasItems(ItemRegistry.WHITE_SHUTTLE.get())).save(consumer);

		ShapelessRecipeBuilder.shapeless(ItemRegistry.PURPLE_SHUTTLE.get())
				.requires(ItemRegistry.WHITE_SHUTTLE.get())
				.requires(Items.PURPLE_DYE)
				.group("celestialexploration").unlockedBy("shuttle", InventoryChangeTrigger.TriggerInstance.hasItems(ItemRegistry.WHITE_SHUTTLE.get())).save(consumer);

		ShapelessRecipeBuilder.shapeless(ItemRegistry.MAGENTA_SHUTTLE.get())
				.requires(ItemRegistry.WHITE_SHUTTLE.get())
				.requires(Items.MAGENTA_DYE)
				.group("celestialexploration").unlockedBy("shuttle", InventoryChangeTrigger.TriggerInstance.hasItems(ItemRegistry.WHITE_SHUTTLE.get())).save(consumer);

		ShapelessRecipeBuilder.shapeless(ItemRegistry.BROWN_SHUTTLE.get())
				.requires(ItemRegistry.WHITE_SHUTTLE.get())
				.requires(Items.BROWN_DYE)
				.group("celestialexploration").unlockedBy("shuttle", InventoryChangeTrigger.TriggerInstance.hasItems(ItemRegistry.WHITE_SHUTTLE.get())).save(consumer);

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
				.group("celestialexploration").unlockedBy("steel_ingot", InventoryChangeTrigger.TriggerInstance.hasItems(ItemRegistry.STEEL_INGOT.get())).save(consumer);
		ShapedRecipeBuilder.shaped(ItemRegistry.STEEL_LEGGINGS.get())
				.pattern("XXX")
				.pattern("X X")
				.pattern("X X")
				.define('X', ItemRegistry.STEEL_INGOT.get())
				.group("celestialexploration").unlockedBy("steel_ingot", InventoryChangeTrigger.TriggerInstance.hasItems(ItemRegistry.STEEL_INGOT.get())).save(consumer);
		ShapedRecipeBuilder.shaped(ItemRegistry.STEEL_BOOTS.get())
				.pattern("X X")
				.pattern("X X")
				.define('X', ItemRegistry.STEEL_INGOT.get())
				.group("celestialexploration").unlockedBy("steel_ingot", InventoryChangeTrigger.TriggerInstance.hasItems(ItemRegistry.STEEL_INGOT.get())).save(consumer);
		ShapedRecipeBuilder.shaped(ItemRegistry.SPACE_SUIT_HELMET.get())
				.pattern("XXX")
				.pattern("XGX")
				.define('X', ItemRegistry.STEEL_INGOT.get())
				.define('G', Items.GLASS)
				.group("celestialexploration").unlockedBy("steel_ingot", InventoryChangeTrigger.TriggerInstance.hasItems(ItemRegistry.STEEL_INGOT.get())).save(consumer);
		ShapedRecipeBuilder.shaped(ItemRegistry.SPACE_SUIT_CHESTPLATE.get())
				.pattern("X X")
				.pattern("SSS")
				.pattern("XSX")
				.define('S', ItemRegistry.STEEL_INGOT.get())
				.define('X', Items.LEATHER)
				.group("celestialexploration").unlockedBy("steel_ingot", InventoryChangeTrigger.TriggerInstance.hasItems(ItemRegistry.STEEL_INGOT.get())).save(consumer);
		ShapedRecipeBuilder.shaped(ItemRegistry.SPACE_SUIT_LEGGINGS.get())
				.pattern("XSX")
				.pattern("S S")
				.pattern("X X")
				.define('S', ItemRegistry.STEEL_INGOT.get())
				.define('X', Items.LEATHER)
				.group("celestialexploration").unlockedBy("steel_ingot", InventoryChangeTrigger.TriggerInstance.hasItems(ItemRegistry.STEEL_INGOT.get())).save(consumer);
		ShapedRecipeBuilder.shaped(ItemRegistry.SPACE_SUIT_BOOTS.get())
				.pattern("X X")
				.pattern("S S")
				.define('S', ItemRegistry.STEEL_INGOT.get())
				.define('X', Items.LEATHER)
				.group("celestialexploration").unlockedBy("steel_ingot", InventoryChangeTrigger.TriggerInstance.hasItems(ItemRegistry.STEEL_INGOT.get())).save(consumer);

		/**MISC**/
		ShapedRecipeBuilder.shaped(ItemRegistry.OXYGEN_COMPRESSOR.get())
				.pattern("SSS")
				.pattern("CGC")
				.pattern("CRC")
				.define('S', ItemRegistry.STEEL_INGOT.get())
				.define('C', Tags.Items.COBBLESTONE)
				.define('G', ItemRegistry.LOX_TANK.get())
				.define('R', Items.REDSTONE)
				.group("celestialexploration").unlockedBy("steel_ingot", InventoryChangeTrigger.TriggerInstance.hasItems(ItemRegistry.STEEL_INGOT.get())).save(consumer);

		ShapelessRecipeBuilder.shapeless(ItemRegistry.LUMINOUS_BLUE_GLASS.get())
				.requires(Tags.Items.GLASS)
				.requires(ItemRegistry.MOON_DUST.get())
				.group("celestialexploration").unlockedBy("moon_dust", InventoryChangeTrigger.TriggerInstance.hasItems(ItemRegistry.MOON_DUST.get())).save(consumer);

		ShapelessRecipeBuilder.shapeless(ItemRegistry.LUMINOUS_WHITE_GLASS.get())
				.requires(ItemRegistry.LUMINOUS_BLUE_GLASS.get())
				.requires(ItemRegistry.LUNAR_GOO.get())
				.group("celestialexploration").unlockedBy("moon_dust", InventoryChangeTrigger.TriggerInstance.hasItems(ItemRegistry.MOON_DUST.get())).save(consumer);

		ShapedRecipeBuilder.shaped(ItemRegistry.LUMINOUS_BLUE_GLASS_PANE.get(), 16)
				.pattern("XXX")
				.pattern("XXX")
				.define('X', ItemRegistry.LUMINOUS_BLUE_GLASS.get())
				.group("celestialexploration").unlockedBy("moon_dust", InventoryChangeTrigger.TriggerInstance.hasItems(ItemRegistry.MOON_DUST.get())).save(consumer);

		ShapedRecipeBuilder.shaped(ItemRegistry.LUMINOUS_WHITE_GLASS_PANE.get(), 16)
				.pattern("XXX")
				.pattern("XXX")
				.define('X', ItemRegistry.LUMINOUS_WHITE_GLASS.get())
				.group("celestialexploration").unlockedBy("moon_dust", InventoryChangeTrigger.TriggerInstance.hasItems(ItemRegistry.MOON_DUST.get())).save(consumer);

		ShapedRecipeBuilder.shaped(BlockRegistry.REINFORCED_GLASS.get(), 4)
				.pattern(" X ")
				.pattern("XCX")
				.pattern(" X ")
				.define('X', Blocks.GLASS)
				.define('C', Items.IRON_INGOT)
				.group("celestialexploration").unlockedBy("glass", InventoryChangeTrigger.TriggerInstance.hasItems(Blocks.GLASS)).save(consumer);

		ShapedRecipeBuilder.shaped(BlockRegistry.REINFORCED_GLASS_PANE.get(), 16)
				.pattern("XXX")
				.pattern("XXX")
				.define('X', ItemRegistry.REINFORCED_GLASS.get())
				.group("celestialexploration").unlockedBy("glass", InventoryChangeTrigger.TriggerInstance.hasItems(Blocks.GLASS)).save(consumer);

		ShapedRecipeBuilder.shaped(BlockRegistry.CERAMIC_TILE.get(), 16)
				.pattern("XXX")
				.pattern("XXX")
				.define('X', BlockRegistry.CERAMIC.get())
				.group("celestialexploration").unlockedBy("clay", InventoryChangeTrigger.TriggerInstance.hasItems(Items.CLAY)).save(consumer);
//		SingleItemRecipeBuilder.stonecutting(Ingredient.of(ItemRegistry.CERAMIC.get()), BlockRegistry.CERAMIC_TILE.get())
//				.unlockedBy("clay", InventoryChangeTrigger.TriggerInstance.hasItems(Items.CLAY)).save(consumer, "ceramic_tile_stonecutting");

		SimpleCookingRecipeBuilder.smelting(Ingredient.of(Items.BRICK), BlockRegistry.CERAMIC.get(), 1.0F, 100)
				.unlockedBy("has_brick", has(Items.BRICK)).save(consumer, "ceramic");

		ShapedRecipeBuilder.shaped(BlockRegistry.COMPRESSED_COBBLESTONE.get())
				.pattern("XXX")
				.pattern("XXX")
				.pattern("XXX")
				.define('X', Blocks.COBBLESTONE)
				.group("celestialexploration").unlockedBy("has_cobblestone", InventoryChangeTrigger.TriggerInstance.hasItems(Blocks.COBBLESTONE)).save(consumer);

		ShapelessRecipeBuilder.shapeless(Blocks.COBBLESTONE, 9)
				.requires(BlockRegistry.COMPRESSED_COBBLESTONE.get())
				.group("celestialexploration").unlockedBy("has_cobblestone", InventoryChangeTrigger.TriggerInstance.hasItems(Blocks.COBBLESTONE)).save(consumer);

		ShapedRecipeBuilder.shaped(BlockRegistry.COMPRESSED_COBBLED_DEEPSLATE.get())
				.pattern("XXX")
				.pattern("XXX")
				.pattern("XXX")
				.define('X', Blocks.COBBLED_DEEPSLATE)
				.group("celestialexploration").unlockedBy("has_cobbled_deepslate", InventoryChangeTrigger.TriggerInstance.hasItems(Blocks.COBBLED_DEEPSLATE)).save(consumer);

		ShapelessRecipeBuilder.shapeless(Blocks.COBBLED_DEEPSLATE, 9)
				.requires(BlockRegistry.COMPRESSED_COBBLED_DEEPSLATE.get())
				.group("celestialexploration").unlockedBy("has_cobbled_deepslate", InventoryChangeTrigger.TriggerInstance.hasItems(Blocks.COBBLED_DEEPSLATE)).save(consumer);


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


		/**
		 * FOOD
		 */
		ShapedRecipeBuilder.shaped(ItemRegistry.MARSHMALLOW.get())
				.pattern("XX")
				.pattern("XX")
				.define('X', ItemRegistry.MARSHMALLOW_GOO.get())
				.group("celestialexploration").unlockedBy("marshmallow_goo", InventoryChangeTrigger.TriggerInstance.hasItems(ItemRegistry.MARSHMALLOW_GOO.get())).save(consumer, "marshmallow_from_marshmallow_goo");
		ShapelessRecipeBuilder.shapeless(ItemRegistry.MARSHMALLOW.get(), 2)
				.requires(Items.SUGAR)
				.requires(Items.MILK_BUCKET)
				.requires(Items.SUGAR)
				.requires(Items.SUGAR)
				.group("celestialexploration").unlockedBy("sugar", InventoryChangeTrigger.TriggerInstance.hasItems(Items.SUGAR)).save(consumer);
		ShapelessRecipeBuilder.shapeless(ItemRegistry.CHOCOLATE.get())
				.requires(Items.SUGAR)
				.requires(Items.MILK_BUCKET)
				.requires(Items.COCOA_BEANS)
				.group("celestialexploration").unlockedBy("cocoa_beans", InventoryChangeTrigger.TriggerInstance.hasItems(Items.COCOA_BEANS)).save(consumer);
		ShapedRecipeBuilder.shaped(ItemRegistry.CRACKER.get(), 4)
				.pattern("X")
				.pattern("X")
				.define('X', Items.WHEAT)
				.group("celestialexploration").unlockedBy("wheat", InventoryChangeTrigger.TriggerInstance.hasItems(Items.WHEAT)).save(consumer);

		SimpleCookingRecipeBuilder.smelting(Ingredient.of(ItemRegistry.MARSHMALLOW.get()), ItemRegistry.ROASTED_MARSHMALLOW.get(), 1.0F, 30)
				.unlockedBy("marshmallow", has(ItemRegistry.MARSHMALLOW_GOO.get())).group("celestialexploration").save(consumer);


		ShapelessRecipeBuilder.shapeless(ItemRegistry.SMORES.get())
				.requires(ItemRegistry.ROASTED_MARSHMALLOW.get())
				.requires(ItemRegistry.CHOCOLATE.get())
				.requires(ItemRegistry.CRACKER.get())
				.requires(ItemRegistry.CRACKER.get())
				.group("celestialexploration").unlockedBy("marshmallow_goo", InventoryChangeTrigger.TriggerInstance.hasItems(ItemRegistry.MARSHMALLOW_GOO.get())).save(consumer);



		ShapelessRecipeBuilder.shapeless(Items.IRON_NUGGET)
				.requires(ItemRegistry.RUSTED_IRON_NUGGET.get())
				.group("celestialexploration")
				.unlockedBy("rusted_iron_nugget", InventoryChangeTrigger.TriggerInstance.hasItems(ItemRegistry.RUSTED_IRON_NUGGET.get())).save(consumer, "iron_nugget_from_rusted_iron_nugget");

		SimpleCookingRecipeBuilder.smelting(Ingredient.of(ItemRegistry.RUSTED_IRON_NUGGET.get()), Items.IRON_NUGGET, 1.0F, 30)
				.unlockedBy("has_rusted_iron_nugget", has(ItemRegistry.RUSTED_IRON_NUGGET.get())).group("celestialexploration").save(consumer, "smelting_rusted_iron_nugget");


		ShapelessRecipeBuilder.shapeless(Items.IRON_NUGGET)
				.requires(ItemRegistry.IRON_DUST.get())
				.requires(ItemRegistry.IRON_DUST.get())
				.group("celestialexploration")
				.unlockedBy("iron_dust", InventoryChangeTrigger.TriggerInstance.hasItems(ItemRegistry.IRON_DUST.get())).save(consumer, "iron_nugget_from_iron_dust");

		ShapelessRecipeBuilder.shapeless(ItemRegistry.LUNAR_CHEESE.get())
				.requires(ItemRegistry.LUNAR_GOO.get())
				.requires(Items.MILK_BUCKET)
				.group("celestialexploration")
				.unlockedBy("lunar_goo", InventoryChangeTrigger.TriggerInstance.hasItems(ItemRegistry.LUNAR_GOO.get())).save(consumer);

		ShapelessRecipeBuilder.shapeless(ItemRegistry.CHEESE.get())
				.requires(Items.MILK_BUCKET)
				.requires(Items.MILK_BUCKET)
				.group("celestialexploration")
				.unlockedBy("milk", InventoryChangeTrigger.TriggerInstance.hasItems(Items.MILK_BUCKET)).save(consumer);

	}
}
