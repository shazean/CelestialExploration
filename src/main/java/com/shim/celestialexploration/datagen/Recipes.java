package com.shim.celestialexploration.datagen;

import java.util.function.Consumer;

import com.shim.celestialexploration.datagen.util.WorkbenchCraftingRecipeBuilder;
import com.shim.celestialexploration.datagen.util.WorkbenchRecipeBuilder;
import com.shim.celestialexploration.registry.BlockRegistry;

import com.shim.celestialexploration.registry.FluidRegistry;
import com.shim.celestialexploration.registry.ItemRegistry;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.*;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.Fluids;
import net.minecraftforge.common.Tags;
import org.lwjgl.system.CallbackI;

import static com.shim.celestialexploration.datagen.util.RecipeGenHelper.*;


public class Recipes extends RecipeProvider {

	public Recipes(DataGenerator generatorIn) {
		super(generatorIn);
	}
	
	@Override
	protected void buildCraftingRecipes(Consumer<FinishedRecipe> consumer) {

		//---- MOON -------------------------------------------------------------------------------
		//STONE
		bricksCraftAndStonecutting(ItemRegistry.MOON_STONE.get(), ItemRegistry.MOON_BRICKS.get(), ItemRegistry.MOON_STONE.get(), consumer);
		stairsSlabWallCraftStonecutting(ItemRegistry.MOON_BRICKS.get(), ItemRegistry.MOON_STONE_TAG, ItemRegistry.MOON_BRICK_STAIRS.get(), ItemRegistry.MOON_BRICK_SLAB.get(), ItemRegistry.MOON_BRICK_WALL.get(), ItemRegistry.MOON_STONE.get(), consumer);
		ShapedRecipeBuilder.shaped(BlockRegistry.CHISELED_MOON_BRICKS.get()).pattern("X").pattern("X").define('X', BlockRegistry.MOON_BRICK_SLAB.get()).group("celestialexploration").unlockedBy("moon_stone", has(BlockRegistry.MOON_STONE.get())).save(consumer);
		smelting(ItemRegistry.MOON_BRICKS.get(), ItemRegistry.CRACKED_MOON_BRICKS.get(), 0.1F, 200, ItemRegistry.MOON_BRICKS.get(), consumer);

		stonecutting(ItemRegistry.MOON_STONE.get(), ItemRegistry.CHISELED_MOON_BRICKS.get(), 1, ItemRegistry.MOON_BRICKS.get(), consumer);
		ShapedRecipeBuilder.shaped(BlockRegistry.MOON_BRICK_PILLAR.get(), 4).pattern("X").pattern("X").define('X', BlockRegistry.MOON_BRICKS.get()).group("celestialexploration").unlockedBy("moon_stone", has(BlockRegistry.MOON_STONE.get())).save(consumer);
		stonecutting(ItemRegistry.MOON_STONE.get(), ItemRegistry.MOON_BRICK_PILLAR.get(), 1, ItemRegistry.MOON_STONE.get(), consumer);
		smelting(ItemRegistry.MOON_COBBLESTONE.get(), ItemRegistry.MOON_STONE.get(), 0.1F, 200, ItemRegistry.MOON_COBBLESTONE.get(), consumer);
		smelting(ItemRegistry.MOON_COBBLED_DEEPSLATE.get(), ItemRegistry.MOON_DEEPSLATE.get(), 0.1F, 200, ItemRegistry.MOON_COBBLED_DEEPSLATE.get(), consumer);
		stairsCraftAndStonecutting(ItemRegistry.MOON_STONE.get(), ItemRegistry.MOON_STONE_STAIRS.get(), ItemRegistry.MOON_STONE.get(), consumer);
		slabCraftAndStonecutting(ItemRegistry.MOON_STONE.get(), ItemRegistry.MOON_STONE_SLAB.get(), ItemRegistry.MOON_STONE.get(), consumer);
		stairsSlabWallCraftStonecutting(ItemRegistry.MOON_COBBLESTONE.get(), ItemRegistry.MOON_COBBLESTONE_TAG, ItemRegistry.MOON_COBBLESTONE_STAIRS.get(), ItemRegistry.MOON_COBBLESTONE_SLAB.get(), ItemRegistry.MOON_COBBLESTONE_WALL.get(), ItemRegistry.MOON_COBBLESTONE.get(), consumer);
		smelting(ItemRegistry.MOON_STONE.get(), ItemRegistry.MOON_SMOOTH_STONE.get(), 0.1F, 200, ItemRegistry.MOON_STONE.get(), consumer);
		ShapedRecipeBuilder.shaped(BlockRegistry.MOON_SMOOTH_STONE_SLAB.get(), 6).pattern("XXX").define('X', BlockRegistry.MOON_SMOOTH_STONE.get()).group("celestialexploration").unlockedBy("has_moon_smooth_stone", has(BlockRegistry.MOON_STONE.get())).save(consumer);
		stonecutting(ItemRegistry.MOON_SMOOTH_STONE.get(), ItemRegistry.MOON_SMOOTH_STONE_SLAB.get(), 2, ItemRegistry.MOON_SMOOTH_STONE.get(), consumer);
		singleItem(ItemRegistry.MOON_STONE.get(), ItemRegistry.MOON_STONE_BUTTON.get(), 1, ItemRegistry.MOON_STONE.get(), consumer);
		ShapedRecipeBuilder.shaped(BlockRegistry.MOON_STONE_PRESSURE_PLATE.get()).pattern("XX").define('X', BlockRegistry.MOON_STONE.get()).group("celestialexploration").unlockedBy("moon_stone", has(BlockRegistry.MOON_STONE.get())).save(consumer);
		singleItem(ItemRegistry.MOON_DEEPSLATE.get(), ItemRegistry.MOON_DEEPSLATE_BUTTON.get(), 1, ItemRegistry.MOON_STONE.get(), consumer);
		ShapedRecipeBuilder.shaped(BlockRegistry.MOON_DEEPSLATE_PRESSURE_PLATE.get()).pattern("XX").define('X', BlockRegistry.MOON_DEEPSLATE.get()).group("celestialexploration").unlockedBy("moon_deepslate", has(BlockRegistry.MOON_DEEPSLATE.get())).save(consumer);
		ingotAndBlock(ItemRegistry.MOON_COBBLESTONE.get(), ItemRegistry.COMPRESSED_MOON_COBBLESTONE.get(), ItemRegistry.MOON_COBBLESTONE.get(), consumer);

		//DEEPSLATE
		stairsSlabWallCraftStonecutting(ItemRegistry.MOON_COBBLED_DEEPSLATE.get(), ItemRegistry.MOON_COBBLED_DEEPSLATE_STAIRS.get(), ItemRegistry.MOON_COBBLED_DEEPSLATE_SLAB.get(), ItemRegistry.MOON_COBBLED_DEEPSLATE_WALL.get(), ItemRegistry.MOON_COBBLED_DEEPSLATE.get(), consumer);
		deepslateBricks(ItemRegistry.MOON_COBBLED_DEEPSLATE.get(), ItemRegistry.MOON_POLISHED_DEEPSLATE.get(), ItemRegistry.MOON_DEEPSLATE_BRICKS.get(), ItemRegistry.MOON_DEEPSLATE_BRICK_STAIRS.get(), ItemRegistry.MOON_DEEPSLATE_BRICK_SLAB.get(), ItemRegistry.MOON_DEEPSLATE_BRICK_WALL.get(), ItemRegistry.MOON_COBBLED_DEEPSLATE.get(), consumer);
		deepslateTiles(ItemRegistry.MOON_COBBLED_DEEPSLATE.get(), ItemRegistry.MOON_POLISHED_DEEPSLATE.get(), ItemRegistry.MOON_DEEPSLATE_BRICKS.get(), ItemRegistry.MOON_DEEPSLATE_TILES.get(), ItemRegistry.MOON_DEEPSLATE_TILE_STAIRS.get(), ItemRegistry.MOON_DEEPSLATE_TILE_SLAB.get(), ItemRegistry.MOON_DEEPSLATE_TILE_WALL.get(), ItemRegistry.MOON_COBBLED_DEEPSLATE.get(), consumer);
		polishedDeepslate(ItemRegistry.MOON_COBBLED_DEEPSLATE.get(), ItemRegistry.MOON_POLISHED_DEEPSLATE.get(), ItemRegistry.MOON_POLISHED_DEEPSLATE_STAIRS.get(), ItemRegistry.MOON_POLISHED_DEEPSLATE_SLAB.get(), ItemRegistry.MOON_POLISHED_DEEPSLATE_WALL.get(), ItemRegistry.MOON_COBBLED_DEEPSLATE.get(), consumer);
		ShapedRecipeBuilder.shaped(BlockRegistry.CHISELED_MOON_DEEPSLATE_BRICKS.get()).pattern("X").pattern("X").define('X', BlockRegistry.MOON_COBBLED_DEEPSLATE_SLAB.get()).group("celestialexploration").unlockedBy("has_moon_cobbled_deepslate", has(BlockRegistry.MOON_COBBLED_DEEPSLATE.get())).save(consumer);
		stonecutting(ItemRegistry.MOON_COBBLED_DEEPSLATE_TAG, ItemRegistry.CHISELED_MOON_DEEPSLATE_BRICKS.get(), 1, ItemRegistry.MOON_COBBLED_DEEPSLATE.get(), consumer);
		smelting(ItemRegistry.MOON_DEEPSLATE_BRICKS.get(), ItemRegistry.CRACKED_MOON_DEEPSLATE_BRICKS.get(), 0.1F, 200, ItemRegistry.MOON_DEEPSLATE_BRICKS.get(), consumer);
		smelting(ItemRegistry.MOON_DEEPSLATE_TILES.get(), ItemRegistry.CRACKED_MOON_DEEPSLATE_TILES.get(), 0.1F, 200, ItemRegistry.MOON_DEEPSLATE_TILES.get(), consumer);
		ingotAndBlock(ItemRegistry.MOON_COBBLED_DEEPSLATE.get(), ItemRegistry.COMPRESSED_MOON_COBBLED_DEEPSLATE.get(), ItemRegistry.MOON_COBBLED_DEEPSLATE.get(), consumer);

		//OTHER
		smelting(ItemRegistry.MOON_SAND.get(), Items.WHITE_STAINED_GLASS, 0.1F, 200, ItemRegistry.MOON_SAND.get(), consumer);
		ShapedRecipeBuilder.shaped(BlockRegistry.LUNAR_LANTERN.get()).pattern("XCX").pattern("C#C").pattern("XCX").define('X', ItemRegistry.MOON_STONE.get()).define('#', Items.IRON_INGOT).define('C', ItemRegistry.MOON_DUST.get()).group("celestialexploration").unlockedBy("has_moon_dust", has(ItemRegistry.MOON_DUST.get())).save(consumer);

		//---- MARS -------------------------------------------------------------------------------
		//STONE
		bricksCraftAndStonecutting(ItemRegistry.MARS_STONE.get(), ItemRegistry.MARS_BRICKS.get(), ItemRegistry.MARS_STONE.get(), consumer);
		stairsSlabWallCraftStonecutting(ItemRegistry.MARS_BRICKS.get(), ItemRegistry.MARS_STONE_TAG, ItemRegistry.MARS_BRICK_STAIRS.get(), ItemRegistry.MARS_BRICK_SLAB.get(), ItemRegistry.MARS_BRICK_WALL.get(), ItemRegistry.MARS_STONE.get(), consumer);
		ShapedRecipeBuilder.shaped(BlockRegistry.CHISELED_MARS_BRICKS.get()).pattern("X").pattern("X").define('X', BlockRegistry.MARS_BRICK_SLAB.get()).group("celestialexploration").unlockedBy("mars_stone", has(BlockRegistry.MARS_STONE.get())).save(consumer);
		smelting(ItemRegistry.MARS_BRICKS.get(), ItemRegistry.CRACKED_MARS_BRICKS.get(), 0.1F, 200, ItemRegistry.MARS_BRICKS.get(), consumer);
		stonecutting(ItemRegistry.MARS_STONE.get(), ItemRegistry.CHISELED_MARS_BRICKS.get(), 1, ItemRegistry.MARS_BRICKS.get(), consumer);
		ShapedRecipeBuilder.shaped(BlockRegistry.MARS_BRICK_PILLAR.get(), 4).pattern("X").pattern("X").define('X', BlockRegistry.MARS_BRICKS.get()).group("celestialexploration").unlockedBy("mars_stone", has(BlockRegistry.MARS_STONE.get())).save(consumer);
		stonecutting(ItemRegistry.MARS_STONE.get(), ItemRegistry.MARS_BRICK_PILLAR.get(), 1, ItemRegistry.MARS_STONE.get(), consumer);
		smelting(ItemRegistry.MARS_COBBLESTONE.get(), ItemRegistry.MARS_STONE.get(), 0.1F, 200, ItemRegistry.MARS_COBBLESTONE.get(), consumer);
		smelting(ItemRegistry.MARS_COBBLED_DEEPSLATE.get(), ItemRegistry.MARS_DEEPSLATE.get(), 0.1F, 200, ItemRegistry.MARS_COBBLED_DEEPSLATE.get(), consumer);
		stairsCraftAndStonecutting(ItemRegistry.MARS_STONE.get(), ItemRegistry.MARS_STONE_STAIRS.get(), ItemRegistry.MARS_STONE.get(), consumer);
		slabCraftAndStonecutting(ItemRegistry.MARS_STONE.get(), ItemRegistry.MARS_STONE_SLAB.get(), ItemRegistry.MARS_STONE.get(), consumer);
		stairsSlabWallCraftStonecutting(ItemRegistry.MARS_COBBLESTONE.get(), ItemRegistry.MARS_COBBLESTONE_TAG, ItemRegistry.MARS_COBBLESTONE_STAIRS.get(), ItemRegistry.MARS_COBBLESTONE_SLAB.get(), ItemRegistry.MARS_COBBLESTONE_WALL.get(), ItemRegistry.MARS_COBBLESTONE.get(), consumer);
		smelting(ItemRegistry.MARS_STONE.get(), ItemRegistry.MARS_SMOOTH_STONE.get(), 0.1F, 200, ItemRegistry.MARS_STONE.get(), consumer);
		ShapedRecipeBuilder.shaped(BlockRegistry.MARS_SMOOTH_STONE_SLAB.get(), 6).pattern("XXX").define('X', BlockRegistry.MARS_SMOOTH_STONE.get()).group("celestialexploration").unlockedBy("has_mars_smooth_stone", has(BlockRegistry.MARS_STONE.get())).save(consumer);
		stonecutting(ItemRegistry.MARS_SMOOTH_STONE.get(), ItemRegistry.MARS_SMOOTH_STONE_SLAB.get(), 2, ItemRegistry.MARS_SMOOTH_STONE.get(), consumer);
		singleItem(ItemRegistry.MARS_STONE.get(), ItemRegistry.MARS_STONE_BUTTON.get(), 1, ItemRegistry.MARS_STONE.get(), consumer);
		ShapedRecipeBuilder.shaped(BlockRegistry.MARS_STONE_PRESSURE_PLATE.get()).pattern("XX").define('X', BlockRegistry.MARS_STONE.get()).group("celestialexploration").unlockedBy("mars_stone", has(BlockRegistry.MARS_STONE.get())).save(consumer);
		singleItem(ItemRegistry.MARS_DEEPSLATE.get(), ItemRegistry.MARS_DEEPSLATE_BUTTON.get(), 1, ItemRegistry.MARS_STONE.get(), consumer);
		ShapedRecipeBuilder.shaped(BlockRegistry.MARS_DEEPSLATE_PRESSURE_PLATE.get()).pattern("XX").define('X', BlockRegistry.MARS_DEEPSLATE.get()).group("celestialexploration").unlockedBy("mars_deepslate", has(BlockRegistry.MARS_DEEPSLATE.get())).save(consumer);
		ingotAndBlock(ItemRegistry.MARS_COBBLESTONE.get(), ItemRegistry.COMPRESSED_MARS_COBBLESTONE.get(), ItemRegistry.MARS_COBBLESTONE.get(), consumer);

		//DEEPSLATE
		stairsSlabWallCraftStonecutting(ItemRegistry.MARS_COBBLED_DEEPSLATE.get(), ItemRegistry.MARS_COBBLED_DEEPSLATE_STAIRS.get(), ItemRegistry.MARS_COBBLED_DEEPSLATE_SLAB.get(), ItemRegistry.MARS_COBBLED_DEEPSLATE_WALL.get(), ItemRegistry.MARS_COBBLED_DEEPSLATE.get(), consumer);
		deepslateBricks(ItemRegistry.MARS_COBBLED_DEEPSLATE.get(), ItemRegistry.MARS_POLISHED_DEEPSLATE.get(), ItemRegistry.MARS_DEEPSLATE_BRICKS.get(), ItemRegistry.MARS_DEEPSLATE_BRICK_STAIRS.get(), ItemRegistry.MARS_DEEPSLATE_BRICK_SLAB.get(), ItemRegistry.MARS_DEEPSLATE_BRICK_WALL.get(), ItemRegistry.MARS_COBBLED_DEEPSLATE.get(), consumer);
		deepslateTiles(ItemRegistry.MARS_COBBLED_DEEPSLATE.get(), ItemRegistry.MARS_POLISHED_DEEPSLATE.get(), ItemRegistry.MARS_DEEPSLATE_BRICKS.get(), ItemRegistry.MARS_DEEPSLATE_TILES.get(), ItemRegistry.MARS_DEEPSLATE_TILE_STAIRS.get(), ItemRegistry.MARS_DEEPSLATE_TILE_SLAB.get(), ItemRegistry.MARS_DEEPSLATE_TILE_WALL.get(), ItemRegistry.MARS_COBBLED_DEEPSLATE.get(), consumer);
		polishedDeepslate(ItemRegistry.MARS_COBBLED_DEEPSLATE.get(), ItemRegistry.MARS_POLISHED_DEEPSLATE.get(), ItemRegistry.MARS_POLISHED_DEEPSLATE_STAIRS.get(), ItemRegistry.MARS_POLISHED_DEEPSLATE_SLAB.get(), ItemRegistry.MARS_POLISHED_DEEPSLATE_WALL.get(), ItemRegistry.MARS_COBBLED_DEEPSLATE.get(), consumer);
		ShapedRecipeBuilder.shaped(BlockRegistry.CHISELED_MARS_DEEPSLATE_BRICKS.get()).pattern("X").pattern("X").define('X', BlockRegistry.MARS_COBBLED_DEEPSLATE_SLAB.get()).group("celestialexploration").unlockedBy("has_mars_cobbled_deepslate", has(BlockRegistry.MARS_COBBLED_DEEPSLATE.get())).save(consumer);
		stonecutting(ItemRegistry.MARS_COBBLED_DEEPSLATE_TAG, ItemRegistry.CHISELED_MARS_DEEPSLATE_BRICKS.get(), 1, ItemRegistry.MARS_COBBLED_DEEPSLATE.get(), consumer);
		smelting(ItemRegistry.MARS_DEEPSLATE_BRICKS.get(), ItemRegistry.CRACKED_MARS_DEEPSLATE_BRICKS.get(), 0.1F, 200, ItemRegistry.MARS_DEEPSLATE_BRICKS.get(), consumer);
		smelting(ItemRegistry.MARS_DEEPSLATE_TILES.get(), ItemRegistry.CRACKED_MARS_DEEPSLATE_TILES.get(), 0.1F, 200, ItemRegistry.MARS_DEEPSLATE_TILES.get(), consumer);
		ingotAndBlock(ItemRegistry.MARS_COBBLED_DEEPSLATE.get(), ItemRegistry.COMPRESSED_MARS_COBBLED_DEEPSLATE.get(), ItemRegistry.MARS_COBBLED_DEEPSLATE.get(), consumer);

		smelting(ItemRegistry.MARS_SAND.get(), Items.BROWN_STAINED_GLASS, 0.1F, 200, ItemRegistry.MARS_SAND.get(), consumer);
		ShapedRecipeBuilder.shaped(BlockRegistry.MARS_LANTERN.get()).pattern("XCX").pattern("C#C").pattern("XCX").define('X', ItemRegistry.MARS_STONE.get()).define('C', Items.IRON_INGOT).define('#', Items.TORCH).group("celestialexploration").unlockedBy("has_iron", has(Items.IRON_INGOT)).save(consumer);

		//---- VENUS -------------------------------------------------------------------------------
		//STONE
		bricksCraftAndStonecutting(ItemRegistry.VENUS_STONE.get(), ItemRegistry.VENUS_BRICKS.get(), ItemRegistry.VENUS_STONE.get(), consumer);
		stairsSlabWallCraftStonecutting(ItemRegistry.VENUS_BRICKS.get(), ItemRegistry.VENUS_STONE_TAG, ItemRegistry.VENUS_BRICK_STAIRS.get(), ItemRegistry.VENUS_BRICK_SLAB.get(), ItemRegistry.VENUS_BRICK_WALL.get(), ItemRegistry.VENUS_STONE.get(), consumer);
		ShapedRecipeBuilder.shaped(BlockRegistry.CHISELED_VENUS_BRICKS.get()).pattern("X").pattern("X").define('X', BlockRegistry.VENUS_BRICK_SLAB.get()).group("celestialexploration").unlockedBy("venus_stone", has(BlockRegistry.VENUS_STONE.get())).save(consumer);
		stonecutting(ItemRegistry.VENUS_STONE.get(), ItemRegistry.CHISELED_VENUS_BRICKS.get(), 1, ItemRegistry.VENUS_BRICKS.get(), consumer);
		smelting(ItemRegistry.VENUS_BRICKS.get(), ItemRegistry.CRACKED_VENUS_BRICKS.get(), 0.1F, 200, ItemRegistry.VENUS_BRICKS.get(), consumer);

		ShapedRecipeBuilder.shaped(BlockRegistry.VENUS_BRICK_PILLAR.get(), 4).pattern("X").pattern("X").define('X', BlockRegistry.VENUS_BRICKS.get()).group("celestialexploration").unlockedBy("venus_stone", has(BlockRegistry.VENUS_STONE.get())).save(consumer);

		stonecutting(ItemRegistry.VENUS_BRICKS.get(), ItemRegistry.SMALL_VENUS_BRICKS.get(), 1, ItemRegistry.VENUS_COBBLESTONE.get(), consumer);
		stairsSlabWallCraftStonecutting(ItemRegistry.SMALL_VENUS_BRICKS.get(), ItemRegistry.SMALL_VENUS_BRICK_STAIRS.get(), ItemRegistry.SMALL_VENUS_BRICK_SLAB.get(), ItemRegistry.SMALL_VENUS_BRICK_WALL.get(), ItemRegistry.VENUS_COBBLESTONE.get(), consumer);

		stonecutting(ItemRegistry.VENUS_STONE.get(), ItemRegistry.VENUS_BRICK_PILLAR.get(), 1, ItemRegistry.VENUS_STONE.get(), consumer);
		smelting(ItemRegistry.VENUS_COBBLESTONE.get(), ItemRegistry.VENUS_STONE.get(), 0.1F, 200, ItemRegistry.VENUS_COBBLESTONE.get(), consumer);
		smelting(ItemRegistry.VENUS_COBBLED_DEEPSLATE.get(), ItemRegistry.VENUS_DEEPSLATE.get(), 0.1F, 200, ItemRegistry.VENUS_COBBLED_DEEPSLATE.get(), consumer);
		stairsCraftAndStonecutting(ItemRegistry.VENUS_STONE.get(), ItemRegistry.VENUS_STONE_STAIRS.get(), ItemRegistry.VENUS_STONE.get(), consumer);
		slabCraftAndStonecutting(ItemRegistry.VENUS_STONE.get(), ItemRegistry.VENUS_STONE_SLAB.get(), ItemRegistry.VENUS_STONE.get(), consumer);
		stairsSlabWallCraftStonecutting(ItemRegistry.VENUS_COBBLESTONE.get(), ItemRegistry.VENUS_COBBLESTONE_TAG, ItemRegistry.VENUS_COBBLESTONE_STAIRS.get(), ItemRegistry.VENUS_COBBLESTONE_SLAB.get(), ItemRegistry.VENUS_COBBLESTONE_WALL.get(), ItemRegistry.VENUS_COBBLESTONE.get(), consumer);
		smelting(ItemRegistry.VENUS_STONE.get(), ItemRegistry.VENUS_SMOOTH_STONE.get(), 0.1F, 200, ItemRegistry.VENUS_STONE.get(), consumer);
		ShapedRecipeBuilder.shaped(BlockRegistry.VENUS_SMOOTH_STONE_SLAB.get(), 6).pattern("XXX").define('X', BlockRegistry.VENUS_SMOOTH_STONE.get()).group("celestialexploration").unlockedBy("has_venus_smooth_stone", has(BlockRegistry.VENUS_STONE.get())).save(consumer);
		stonecutting(ItemRegistry.VENUS_SMOOTH_STONE.get(), ItemRegistry.VENUS_SMOOTH_STONE_SLAB.get(), 2, ItemRegistry.VENUS_SMOOTH_STONE.get(), consumer);
		singleItem(ItemRegistry.VENUS_STONE.get(), ItemRegistry.VENUS_STONE_BUTTON.get(), 1, ItemRegistry.VENUS_STONE.get(), consumer);
		ShapedRecipeBuilder.shaped(BlockRegistry.VENUS_STONE_PRESSURE_PLATE.get()).pattern("XX").define('X', BlockRegistry.VENUS_STONE.get()).group("celestialexploration").unlockedBy("venus_stone", has(BlockRegistry.VENUS_STONE.get())).save(consumer);
		singleItem(ItemRegistry.VENUS_DEEPSLATE.get(), ItemRegistry.VENUS_DEEPSLATE_BUTTON.get(), 1, ItemRegistry.VENUS_STONE.get(), consumer);
		ShapedRecipeBuilder.shaped(BlockRegistry.VENUS_DEEPSLATE_PRESSURE_PLATE.get()).pattern("XX").define('X', BlockRegistry.VENUS_DEEPSLATE.get()).group("celestialexploration").unlockedBy("venus_deepslate", has(BlockRegistry.VENUS_DEEPSLATE.get())).save(consumer);
		ingotAndBlock(ItemRegistry.VENUS_COBBLESTONE.get(), ItemRegistry.COMPRESSED_VENUS_COBBLESTONE.get(), ItemRegistry.VENUS_COBBLESTONE.get(), consumer);

		//DEEPSLATE
		stairsSlabWallCraftStonecutting(ItemRegistry.VENUS_COBBLED_DEEPSLATE.get(), ItemRegistry.VENUS_COBBLED_DEEPSLATE_STAIRS.get(), ItemRegistry.VENUS_COBBLED_DEEPSLATE_SLAB.get(), ItemRegistry.VENUS_COBBLED_DEEPSLATE_WALL.get(), ItemRegistry.VENUS_COBBLED_DEEPSLATE.get(), consumer);
		deepslateBricks(ItemRegistry.VENUS_COBBLED_DEEPSLATE.get(), ItemRegistry.VENUS_POLISHED_DEEPSLATE.get(), ItemRegistry.VENUS_DEEPSLATE_BRICKS.get(), ItemRegistry.VENUS_DEEPSLATE_BRICK_STAIRS.get(), ItemRegistry.VENUS_DEEPSLATE_BRICK_SLAB.get(), ItemRegistry.VENUS_DEEPSLATE_BRICK_WALL.get(), ItemRegistry.VENUS_COBBLED_DEEPSLATE.get(), consumer);
		deepslateTiles(ItemRegistry.VENUS_COBBLED_DEEPSLATE.get(), ItemRegistry.VENUS_POLISHED_DEEPSLATE.get(), ItemRegistry.VENUS_DEEPSLATE_BRICKS.get(), ItemRegistry.VENUS_DEEPSLATE_TILES.get(), ItemRegistry.VENUS_DEEPSLATE_TILE_STAIRS.get(), ItemRegistry.VENUS_DEEPSLATE_TILE_SLAB.get(), ItemRegistry.VENUS_DEEPSLATE_TILE_WALL.get(), ItemRegistry.VENUS_COBBLED_DEEPSLATE.get(), consumer);
		polishedDeepslate(ItemRegistry.VENUS_COBBLED_DEEPSLATE.get(), ItemRegistry.VENUS_POLISHED_DEEPSLATE.get(), ItemRegistry.VENUS_POLISHED_DEEPSLATE_STAIRS.get(), ItemRegistry.VENUS_POLISHED_DEEPSLATE_SLAB.get(), ItemRegistry.VENUS_POLISHED_DEEPSLATE_WALL.get(), ItemRegistry.VENUS_COBBLED_DEEPSLATE.get(), consumer);
		ShapedRecipeBuilder.shaped(BlockRegistry.CHISELED_VENUS_DEEPSLATE_BRICKS.get()).pattern("X").pattern("X").define('X', BlockRegistry.VENUS_COBBLED_DEEPSLATE_SLAB.get()).group("celestialexploration").unlockedBy("has_venus_cobbled_deepslate", has(BlockRegistry.VENUS_COBBLED_DEEPSLATE.get())).save(consumer);
		stonecutting(ItemRegistry.VENUS_COBBLED_DEEPSLATE_TAG, ItemRegistry.CHISELED_VENUS_DEEPSLATE_BRICKS.get(), 1, ItemRegistry.VENUS_COBBLED_DEEPSLATE.get(), consumer);
		smelting(ItemRegistry.VENUS_DEEPSLATE_BRICKS.get(), ItemRegistry.CRACKED_VENUS_DEEPSLATE_BRICKS.get(), 0.1F, 200, ItemRegistry.VENUS_DEEPSLATE_BRICKS.get(), consumer);
		smelting(ItemRegistry.VENUS_DEEPSLATE_TILES.get(), ItemRegistry.CRACKED_VENUS_DEEPSLATE_TILES.get(), 0.1F, 200, ItemRegistry.VENUS_DEEPSLATE_TILES.get(), consumer);
		ingotAndBlock(ItemRegistry.VENUS_COBBLED_DEEPSLATE.get(), ItemRegistry.COMPRESSED_VENUS_COBBLED_DEEPSLATE.get(), ItemRegistry.VENUS_COBBLED_DEEPSLATE.get(), consumer);

		smelting(ItemRegistry.VENUS_SAND.get(), Items.YELLOW_STAINED_GLASS, 0.1F, 200, ItemRegistry.VENUS_SAND.get(), consumer);
		ShapedRecipeBuilder.shaped(BlockRegistry.VENUS_LANTERN.get()).pattern("XCX").pattern("C#C").pattern("XCX").define('X', ItemRegistry.VENUS_STONE.get()).define('#', Items.IRON_INGOT).define('C', ItemRegistry.SULFUR_CRYSTAL.get()).group("celestialexploration").unlockedBy("has_sulfur_crystal", has(ItemRegistry.SULFUR_CRYSTAL.get())).save(consumer);

		//---- METEOR -------------------------------------------------------------------------------
		ShapedRecipeBuilder.shaped(BlockRegistry.METEOR_BRICKS.get(), 4).pattern("XX").pattern("XX").define('X', ItemRegistry.METEOR.get()).group("celestialexploration").unlockedBy("meteor", has(BlockRegistry.METEOR.get())).save(consumer);
		SingleItemRecipeBuilder.stonecutting(Ingredient.of(ItemRegistry.METEOR_TAG), BlockRegistry.METEOR_BRICKS.get(), 1).unlockedBy("meteor", has(BlockRegistry.METEOR.get())).save(consumer, "meteor_bricks_stonecutting");
		ShapedRecipeBuilder.shaped(BlockRegistry.METEOR_BRICK_SLAB.get(), 6).pattern("XXX").define('X', ItemRegistry.METEOR_BRICKS.get()).group("celestialexploration").unlockedBy("meteor", has(BlockRegistry.METEOR.get())).save(consumer);
		SingleItemRecipeBuilder.stonecutting(Ingredient.of(ItemRegistry.METEOR_TAG), BlockRegistry.METEOR_BRICK_SLAB.get(), 2).unlockedBy("meteor", has(BlockRegistry.METEOR.get())).save(consumer, "meteor_brick_slab_stonecutting");
		ShapedRecipeBuilder.shaped(BlockRegistry.METEOR_BRICK_STAIRS.get(), 4).pattern("X  ").pattern("XX ").pattern("XXX").define('X', ItemRegistry.METEOR_BRICKS.get()).group("celestialexploration").unlockedBy("meteor", has(BlockRegistry.METEOR.get())).save(consumer);
		SingleItemRecipeBuilder.stonecutting(Ingredient.of(ItemRegistry.METEOR_TAG), BlockRegistry.METEOR_BRICK_STAIRS.get(), 1).unlockedBy("meteor", has(BlockRegistry.METEOR.get())).save(consumer, "meteor_brick_stairs_stonecutting");
		ShapedRecipeBuilder.shaped(BlockRegistry.METEOR_BRICK_WALL.get(), 6).pattern("XXX").pattern("XXX").define('X', BlockRegistry.METEOR_BRICKS.get()).group("celestialexploration").unlockedBy("meteor", has(BlockRegistry.METEOR.get())).save(consumer);
		SingleItemRecipeBuilder.stonecutting(Ingredient.of(ItemRegistry.METEOR_TAG), BlockRegistry.METEOR_BRICK_WALL.get(), 1).unlockedBy("meteor", has(BlockRegistry.METEOR.get())).save(consumer, "meteor_brick_wall_stonecutting");
		ShapedRecipeBuilder.shaped(BlockRegistry.CHISELED_METEOR_BRICKS.get()).pattern("X").pattern("X").define('X', BlockRegistry.METEOR_BRICK_SLAB.get()).group("celestialexploration").unlockedBy("meteor", has(BlockRegistry.METEOR.get())).save(consumer);
		SingleItemRecipeBuilder.stonecutting(Ingredient.of(ItemRegistry.METEOR_TAG), BlockRegistry.CHISELED_METEOR_BRICKS.get(), 1).unlockedBy("meteor", has(BlockRegistry.METEOR_BRICKS.get())).save(consumer, "chiseled_meteor_bricks_stonecutting");
		ShapelessRecipeBuilder.shapeless(ItemRegistry.METEOR_BUTTON.get()).requires(ItemRegistry.METEOR.get()).group("celestialexploration").unlockedBy("meteor", has(ItemRegistry.METEOR.get())).save(consumer);
		ShapedRecipeBuilder.shaped(BlockRegistry.METEOR_PRESSURE_PLATE.get()).pattern("XX").define('X', BlockRegistry.METEOR.get()).group("celestialexploration").unlockedBy("meteor", has(BlockRegistry.METEOR.get())).save(consumer);

		//---- ORES/ALLOYS -------------------------------------------------------------------------------
		//BAUXITE/ALUMINUM
		smeltingAndBlasting(ItemRegistry.RAW_BAUXITE.get(), ItemRegistry.BAUXITE_INGOT.get(), 0.7F, 200, 100, ItemRegistry.RAW_BAUXITE.get(), consumer);
		ShapelessRecipeBuilder.shapeless(ItemRegistry.ALUMINUM_INGOT.get(), 3).requires(Items.IRON_INGOT).requires(ItemRegistry.BAUXITE_INGOT.get()).requires(ItemRegistry.BAUXITE_INGOT.get()).group("celestialexploration").unlockedBy("has_raw_bauxite", has(ItemRegistry.RAW_BAUXITE.get())).save(consumer);
		ShapelessRecipeBuilder.shapeless(ItemRegistry.ALUMINUM_INGOT.get(), 3).requires(Items.COPPER_INGOT).requires(ItemRegistry.BAUXITE_INGOT.get()).requires(ItemRegistry.BAUXITE_INGOT.get()).group("celestialexploration").unlockedBy("has_raw_bauxite", has(ItemRegistry.RAW_BAUXITE.get())).save(consumer, "aluminum_from_copper");
		ingotAndBlock(ItemRegistry.ALUMINUM_INGOT.get(), ItemRegistry.ALUMINUM_BLOCK.get(), ItemRegistry.ALUMINUM_INGOT.get(), consumer);
		smeltingAndBlasting(ItemRegistry.MOON_BAUXITE_ORE.get(), ItemRegistry.BAUXITE_INGOT.get(), 0.7F, 200, 100, ItemRegistry.MOON_BAUXITE_ORE.get(), consumer);
		smeltingAndBlasting(ItemRegistry.MARS_BAUXITE_ORE.get(), ItemRegistry.BAUXITE_INGOT.get(), 0.7F, 200, 100, ItemRegistry.MARS_BAUXITE_ORE.get(), consumer);
		smeltingAndBlasting(ItemRegistry.VENUS_BAUXITE_ORE.get(), ItemRegistry.BAUXITE_INGOT.get(), 0.7F, 200, 100, ItemRegistry.VENUS_BAUXITE_ORE.get(), consumer);
		smeltingAndBlasting(ItemRegistry.BAUXITE_ORE.get(), ItemRegistry.BAUXITE_INGOT.get(), 0.7F, 200, 100, ItemRegistry.BAUXITE_ORE.get(), consumer);

		//STEEL
		WorkbenchCraftingRecipeBuilder.shaped(ItemRegistry.STEEL_INGOT.get(), 2, FluidRegistry.MOLTEN_IRON.get(), 0.11F).pattern("X").define('X', Items.COAL).group("celestialexploration").unlockedBy("has_iron", has(Items.IRON_INGOT)).save(consumer, "steel_ingot_from_workbench");
		ingotAndBlock(ItemRegistry.STEEL_INGOT.get(), ItemRegistry.STEEL_BLOCK.get(), ItemRegistry.STEEL_INGOT.get(), consumer);
		ingotAndBlock(ItemRegistry.STEEL_NUGGET.get(), ItemRegistry.STEEL_INGOT.get(), ItemRegistry.STEEL_INGOT.get(), consumer);

		//ASSORTED
		ShapelessRecipeBuilder.shapeless(Items.IRON_NUGGET).requires(ItemRegistry.RUSTED_IRON_NUGGET.get()).group("celestialexploration").unlockedBy("rusted_iron_nugget", has(ItemRegistry.RUSTED_IRON_NUGGET.get())).save(consumer, "iron_nugget_from_rusted_iron_nugget");
		SimpleCookingRecipeBuilder.smelting(Ingredient.of(ItemRegistry.RUSTED_IRON_NUGGET.get()), Items.IRON_NUGGET, 1.0F, 30).unlockedBy("has_rusted_iron_nugget", has(ItemRegistry.RUSTED_IRON_NUGGET.get())).group("celestialexploration").save(consumer, "smelting_rusted_iron_nugget");

		ShapelessRecipeBuilder.shapeless(ItemRegistry.STEEL_INGOT.get(), 2).requires(Items.COAL).requires(Items.IRON_INGOT).requires(Items.IRON_INGOT).group("celestialexploration").unlockedBy("iron", has(Items.IRON_INGOT)).save(consumer, "steel_ingot_crafted");
		ShapedRecipeBuilder.shaped(ItemRegistry.STEEL_ROD.get(), 8).pattern("X").pattern("X").pattern("X").define('X', ItemRegistry.STEEL_INGOT.get()).group("celestialexploration").unlockedBy("steel", has(ItemRegistry.STEEL_INGOT.get())).save(consumer);
		ShapedRecipeBuilder.shaped(ItemRegistry.STEEL_WOOL.get(), 4).pattern(" X ").pattern("XSX").pattern(" X ").define('X', ItemRegistry.STEEL_NUGGET.get()).define('S', Items.STRING).group("celestialexploration").unlockedBy("steel", has(ItemRegistry.STEEL_INGOT.get())).save(consumer);

		smeltingAndBlasting(ItemRegistry.MOON_IRON_ORE.get(), Items.IRON_INGOT, 0.7F, 200, 100, ItemRegistry.MOON_IRON_ORE.get(), consumer);
		smeltingAndBlasting(ItemRegistry.MOON_DEEPSLATE_IRON_ORE.get(), Items.IRON_INGOT, 0.7F, 200, 100, ItemRegistry.MOON_DEEPSLATE_IRON_ORE.get(), consumer);
		smeltingAndBlasting(ItemRegistry.MARS_IRON_ORE.get(), Items.IRON_INGOT, 0.7F, 200, 100, ItemRegistry.MARS_IRON_ORE.get(), consumer);
		smeltingAndBlasting(ItemRegistry.MARS_DEEPSLATE_IRON_ORE.get(), Items.IRON_INGOT, 0.7F, 200, 100, ItemRegistry.MARS_DEEPSLATE_IRON_ORE.get(), consumer);
		smeltingAndBlasting(ItemRegistry.VENUS_IRON_ORE.get(), Items.IRON_INGOT, 0.7F, 200, 100, ItemRegistry.VENUS_IRON_ORE.get(), consumer);
		smeltingAndBlasting(ItemRegistry.VENUS_DEEPSLATE_IRON_ORE.get(), Items.IRON_INGOT, 0.7F, 200, 100, ItemRegistry.VENUS_DEEPSLATE_IRON_ORE.get(), consumer);
		smeltingAndBlasting(ItemRegistry.METEOR_IRON_ORE.get(), Items.IRON_INGOT, 0.7F, 200, 100, ItemRegistry.METEOR_IRON_ORE.get(), consumer);
		smeltingAndBlasting(ItemRegistry.METEOR_GOLD_ORE.get(), Items.GOLD_INGOT, 0.7F, 200, 100, ItemRegistry.METEOR_GOLD_ORE.get(), consumer);
		smeltingAndBlasting(ItemRegistry.METEOR_COPPER_ORE.get(), Items.COPPER_INGOT, 0.7F, 200, 100, ItemRegistry.METEOR_COPPER_ORE.get(), consumer);

		//---- SPACESHIP -------------------------------------------------------------------------------
		ShapedRecipeBuilder.shaped(BlockRegistry.WORKBENCH.get()).pattern("XXX").pattern("X X").pattern("CCC").define('X', ItemTags.PLANKS).define('C', Blocks.COBBLESTONE).group("celestialexploration").unlockedBy("has_cobblestone", has(Blocks.COBBLESTONE)).save(consumer);

		ShapedRecipeBuilder.shaped(ItemRegistry.LOX_TANK.get()).pattern("SsS").pattern("G G").pattern("SsS").define('S', ItemRegistry.STEEL_INGOT.get()).define('s', ItemRegistry.ALUMINUM_INGOT.get()).define('G', Tags.Items.GLASS).group("celestialexploration").unlockedBy("steel", has(ItemRegistry.STEEL_INGOT.get())).save(consumer);
		WorkbenchCraftingRecipeBuilder.shaped(ItemRegistry.LOX_TANK.get(), FluidRegistry.MOLTEN_STEEL.get(), 0.44F).pattern("AGA").pattern("G G").pattern("AGA").define('A', ItemRegistry.ALUMINUM_INGOT.get()).define('G', Tags.Items.GLASS).group("celestialexploration").unlockedBy("has_iron", has(Items.IRON_INGOT)).save(consumer, "lox_tank_from_workbench");

		ShapedRecipeBuilder.shaped(ItemRegistry.OXYGEN_COMPRESSOR.get()).pattern("SSS").pattern("CGC").pattern("CRC").define('S', ItemRegistry.STEEL_INGOT.get()).define('C', ItemRegistry.ALUMINUM_INGOT.get()).define('G', Tags.Items.GLASS).define('R', Items.REDSTONE).group("celestialexploration").unlockedBy("steel_ingot", has(ItemRegistry.STEEL_INGOT.get())).save(consumer);
		WorkbenchCraftingRecipeBuilder.shaped(ItemRegistry.OXYGEN_COMPRESSOR.get(), FluidRegistry.MOLTEN_STEEL.get(), 0.22F).pattern("XXX").pattern("XGX").pattern("XRX").define('X', Tags.Items.COBBLESTONE).define('G', Tags.Items.GLASS).define('R', Items.REDSTONE).group("celestialexploration").unlockedBy("has_iron", has(Items.IRON_INGOT)).save(consumer, "oxygen_compressor_from_workbench");

		WorkbenchCraftingRecipeBuilder.shaped(BlockRegistry.STEEL_FRAME.get(), 4, FluidRegistry.MOLTEN_STEEL.get(), 0.22F).pattern("X").define('X', Items.SCAFFOLDING).group("celestialexploration").unlockedBy("has_steel", has(ItemRegistry.STEEL_INGOT.get())).save(consumer, "steel_frame_from_workbench");
		WorkbenchCraftingRecipeBuilder.shaped(ItemRegistry.SPACESHIP_FRAME.get(), FluidRegistry.MOLTEN_STEEL.get(), 0.33F).pattern("C C").pattern(" X ").pattern("C C").define('X', ItemRegistry.STEEL_FRAME.get()).define('C', ItemRegistry.CERAMIC_TILE.get()).group("celestialexploration").unlockedBy("has_steel", has(ItemRegistry.STEEL_INGOT.get())).save(consumer, "spaceship_frame_from_workbench");
		WorkbenchCraftingRecipeBuilder.shaped(ItemRegistry.SPACESHIP_CABIN.get(), FluidRegistry.MOLTEN_ALUMINUM.get(), 0.44F).pattern(" C ").pattern("CGC").pattern("X X").define('C', ItemRegistry.CERAMIC_TILE.get()).define('G', Tags.Items.GLASS).define('X', Tags.Items.CHESTS).group("celestialexploration").unlockedBy("has_steel", has(ItemRegistry.STEEL_INGOT.get())).save(consumer, "spaceship_cabin_from_workbench");
		WorkbenchCraftingRecipeBuilder.shaped(ItemRegistry.SPACESHIP_ENGINE.get(), FluidRegistry.MOLTEN_STEEL.get(), 0.495F).pattern("CRC").pattern("TTT").define('R', Items.REDSTONE).define('C', Items.COPPER_INGOT).define('T', Items.REDSTONE_TORCH).group("celestialexploration").unlockedBy("has_steel", has(ItemRegistry.STEEL_INGOT.get())).save(consumer, "spaceship_engine_from_workbench");
		WorkbenchCraftingRecipeBuilder.shaped(ItemRegistry.WHITE_SPACESHIP.get(), FluidRegistry.MOLTEN_ALUMINUM.get(), .275F).pattern("C").pattern("F").pattern("E").define('C', ItemRegistry.SPACESHIP_CABIN.get()).define('F', ItemRegistry.SPACESHIP_FRAME.get()).define('E', ItemRegistry.SPACESHIP_ENGINE.get()).group("celestialexploration").unlockedBy("has_steel", has(ItemRegistry.STEEL_INGOT.get())).save(consumer, "spaceship_from_workbench");

		ShapelessRecipeBuilder.shapeless(ItemRegistry.BLACK_SPACESHIP.get()).requires(ItemRegistry.WHITE_SPACESHIP.get()).requires(Items.BLACK_DYE).group("celestialexploration").unlockedBy("spaceship", has(ItemRegistry.WHITE_SPACESHIP.get())).save(consumer);
		ShapelessRecipeBuilder.shapeless(ItemRegistry.GREY_SPACESHIP.get()).requires(ItemRegistry.WHITE_SPACESHIP.get()).requires(Items.GRAY_DYE).group("celestialexploration").unlockedBy("spaceship", has(ItemRegistry.WHITE_SPACESHIP.get())).save(consumer);
		ShapelessRecipeBuilder.shapeless(ItemRegistry.LIGHT_GREY_SPACESHIP.get()).requires(ItemRegistry.WHITE_SPACESHIP.get()).requires(Items.LIGHT_GRAY_DYE).group("celestialexploration").unlockedBy("spaceship", has(ItemRegistry.WHITE_SPACESHIP.get())).save(consumer);
		ShapelessRecipeBuilder.shapeless(ItemRegistry.PINK_SPACESHIP.get()).requires(ItemRegistry.WHITE_SPACESHIP.get()).requires(Items.PINK_DYE).group("celestialexploration").unlockedBy("spaceship", has(ItemRegistry.WHITE_SPACESHIP.get())).save(consumer);
		ShapelessRecipeBuilder.shapeless(ItemRegistry.RED_SPACESHIP.get()).requires(ItemRegistry.WHITE_SPACESHIP.get()).requires(Items.RED_DYE).group("celestialexploration").unlockedBy("spaceship", has(ItemRegistry.WHITE_SPACESHIP.get())).save(consumer);
		ShapelessRecipeBuilder.shapeless(ItemRegistry.ORANGE_SPACESHIP.get()).requires(ItemRegistry.WHITE_SPACESHIP.get()).requires(Items.ORANGE_DYE).group("celestialexploration").unlockedBy("spaceship", has(ItemRegistry.WHITE_SPACESHIP.get())).save(consumer);
		ShapelessRecipeBuilder.shapeless(ItemRegistry.YELLOW_SPACESHIP.get()).requires(ItemRegistry.WHITE_SPACESHIP.get()).requires(Items.YELLOW_DYE).group("celestialexploration").unlockedBy("spaceship", has(ItemRegistry.WHITE_SPACESHIP.get())).save(consumer);
		ShapelessRecipeBuilder.shapeless(ItemRegistry.LIME_SPACESHIP.get()).requires(ItemRegistry.WHITE_SPACESHIP.get()).requires(Items.LIME_DYE).group("celestialexploration").unlockedBy("spaceship", has(ItemRegistry.WHITE_SPACESHIP.get())).save(consumer);
		ShapelessRecipeBuilder.shapeless(ItemRegistry.GREEN_SPACESHIP.get()).requires(ItemRegistry.WHITE_SPACESHIP.get()).requires(Items.GREEN_DYE).group("celestialexploration").unlockedBy("spaceship", has(ItemRegistry.WHITE_SPACESHIP.get())).save(consumer);
		ShapelessRecipeBuilder.shapeless(ItemRegistry.CYAN_SPACESHIP.get()).requires(ItemRegistry.WHITE_SPACESHIP.get()).requires(Items.CYAN_DYE).group("celestialexploration").unlockedBy("spaceship", has(ItemRegistry.WHITE_SPACESHIP.get())).save(consumer);
		ShapelessRecipeBuilder.shapeless(ItemRegistry.BLUE_SPACESHIP.get()).requires(ItemRegistry.WHITE_SPACESHIP.get()).requires(Items.BLUE_DYE).group("celestialexploration").unlockedBy("spaceship", has(ItemRegistry.WHITE_SPACESHIP.get())).save(consumer);
		ShapelessRecipeBuilder.shapeless(ItemRegistry.LIGHT_BLUE_SPACESHIP.get()).requires(ItemRegistry.WHITE_SPACESHIP.get()).requires(Items.LIGHT_BLUE_DYE).group("celestialexploration").unlockedBy("spaceship", has(ItemRegistry.WHITE_SPACESHIP.get())).save(consumer);
		ShapelessRecipeBuilder.shapeless(ItemRegistry.PURPLE_SPACESHIP.get()).requires(ItemRegistry.WHITE_SPACESHIP.get()).requires(Items.PURPLE_DYE).group("celestialexploration").unlockedBy("spaceship", has(ItemRegistry.WHITE_SPACESHIP.get())).save(consumer);
		ShapelessRecipeBuilder.shapeless(ItemRegistry.MAGENTA_SPACESHIP.get()).requires(ItemRegistry.WHITE_SPACESHIP.get()).requires(Items.MAGENTA_DYE).group("celestialexploration").unlockedBy("spaceship", has(ItemRegistry.WHITE_SPACESHIP.get())).save(consumer);
		ShapelessRecipeBuilder.shapeless(ItemRegistry.BROWN_SPACESHIP.get()).requires(ItemRegistry.WHITE_SPACESHIP.get()).requires(Items.BROWN_DYE).group("celestialexploration").unlockedBy("spaceship", has(ItemRegistry.WHITE_SPACESHIP.get())).save(consumer);

		//---- SPACE STATION -------------------------------------------------------------------------------
		ShapedRecipeBuilder.shaped(BlockRegistry.INSULATED_PANEL.get(), 4).pattern("XC").pattern("XC").define('X', ItemRegistry.ALUMINUM_INGOT.get()).define('C', ItemRegistry.WHITE_CERAMIC.get()).group("celestialexploration").unlockedBy("aluminum", has(ItemRegistry.ALUMINUM_INGOT.get())).save(consumer);
		ShapedRecipeBuilder.shaped(BlockRegistry.PATHWAY_LIGHT.get(), 4).pattern("XXX").pattern(" T ").define('X', ItemRegistry.ALUMINUM_INGOT.get()).define('T', Items.REDSTONE_TORCH).group("celestialexploration").unlockedBy("aluminum", has(ItemRegistry.ALUMINUM_INGOT.get())).save(consumer);
		SingleItemRecipeBuilder.stonecutting(Ingredient.of(ItemRegistry.INSULATED_PANEL.get()), BlockRegistry.INSULATED_PANEL_CORNER.get(), 1).group("celestialexploration").unlockedBy("aluminum", has(ItemRegistry.ALUMINUM_INGOT.get())).save(consumer);
		SingleItemRecipeBuilder.stonecutting(Ingredient.of(ItemRegistry.INSULATED_PANEL_CORNER.get()), BlockRegistry.INSULATED_PANEL.get(), 1).group("celestialexploration").unlockedBy("aluminum", has(ItemRegistry.ALUMINUM_INGOT.get())).save(consumer, "insulated_panel_stonecutting");
		ShapedRecipeBuilder.shaped(BlockRegistry.PANEL.get()).pattern("XX").pattern("XX").define('X', ItemRegistry.ALUMINUM_INGOT.get()).group("celestialexploration").unlockedBy("meteor", has(ItemRegistry.ALUMINUM_INGOT.get())).save(consumer);
		stairsSlabWallCraftStonecutting(ItemRegistry.PANEL.get(), ItemRegistry.PANEL_STAIRS.get(), ItemRegistry.PANEL_SLAB.get(), ItemRegistry.PANEL_WALL.get(), ItemRegistry.PANEL.get(), consumer);
		pane(ItemRegistry.PANEL.get(), ItemRegistry.THIN_PANEL.get(), ItemRegistry.PANEL.get(), consumer);

		ShapedRecipeBuilder.shaped(ItemRegistry.AIRLOCK_DOOR.get()).pattern("GX").pattern("DX").define('X', ItemRegistry.STEEL_INGOT.get()).define('G', Tags.Items.GLASS_COLORLESS).define('D', ItemRegistry.STEEL_DOOR.get()).group("celestialexploration").unlockedBy("steel", has(ItemRegistry.STEEL_INGOT.get())).save(consumer);
		ShapedRecipeBuilder.shaped(ItemRegistry.AIRLOCK_DOOR.get()).pattern("GX").pattern("DX").define('X', ItemRegistry.STEEL_INGOT.get()).define('G', Tags.Items.GLASS_COLORLESS).define('D', Items.IRON_DOOR).group("celestialexploration").unlockedBy("steel", has(ItemRegistry.STEEL_INGOT.get())).save(consumer, "airlock_door_from_iron_door");
		ShapedRecipeBuilder.shaped(ItemRegistry.STEEL_DOOR.get(), 3).pattern("XX").pattern("XX").pattern("XX").define('X', ItemRegistry.STEEL_INGOT.get()).group("celestialexploration").unlockedBy("steel", has(ItemRegistry.STEEL_INGOT.get())).save(consumer);
		ShapedRecipeBuilder.shaped(ItemRegistry.STEEL_TRAPDOOR.get(), 2).pattern("XXX").pattern("XXX").define('X', ItemRegistry.STEEL_INGOT.get()).group("celestialexploration").unlockedBy("steel", has(ItemRegistry.STEEL_INGOT.get())).save(consumer);
		ShapedRecipeBuilder.shaped(ItemRegistry.STEEL_BUTTON.get()).pattern("XX").pattern("XX").define('X', ItemRegistry.STEEL_NUGGET.get()).group("celestialexploration").unlockedBy("steel", has(ItemRegistry.STEEL_INGOT.get())).save(consumer);

		singleItem(Items.RED_STAINED_GLASS, ItemRegistry.RED_BUTTON.get(), 1, Items.RED_STAINED_GLASS, consumer);
		singleItem(Items.YELLOW_STAINED_GLASS, ItemRegistry.YELLOW_BUTTON.get(), 1, Items.YELLOW_STAINED_GLASS, consumer);
		singleItem(Items.BLUE_STAINED_GLASS, ItemRegistry.BLUE_BUTTON.get(), 1, Items.BLUE_STAINED_GLASS, consumer);
		singleItem(Items.GREEN_STAINED_GLASS, ItemRegistry.GREEN_BUTTON.get(), 1, Items.GREEN_STAINED_GLASS, consumer);
		singleItem(Items.WHITE_STAINED_GLASS, ItemRegistry.WHITE_BUTTON.get(), 1, Items.WHITE_STAINED_GLASS, consumer);
		singleItem(Items.BLACK_STAINED_GLASS, ItemRegistry.BLACK_BUTTON.get(), 1, Items.BLACK_STAINED_GLASS, consumer);

		//---- MAG LEV -------------------------------------------------------------------------------
		ShapedRecipeBuilder.shaped(BlockRegistry.MAG_RAIL.get(), 16).pattern("X X").pattern("X#X").pattern("X X").define('X', ItemRegistry.STEEL_INGOT.get()).define('#', ItemRegistry.STEEL_ROD.get()).group("celestialexploration").unlockedBy("steel", has(ItemRegistry.STEEL_INGOT.get())).save(consumer);
		ShapedRecipeBuilder.shaped(BlockRegistry.POWERED_MAG_RAIL.get(), 6).pattern("X X").pattern("X#X").pattern("XRX").define('X', ItemRegistry.STEEL_INGOT.get()).define('#', ItemRegistry.STEEL_ROD.get()).define('R', Items.REDSTONE).group("celestialexploration").unlockedBy("steel", has(ItemRegistry.STEEL_INGOT.get())).save(consumer);
		ShapedRecipeBuilder.shaped(BlockRegistry.DETECTOR_MAG_RAIL.get(), 6).pattern("X X").pattern("X#X").pattern("XRX").define('X', ItemRegistry.STEEL_INGOT.get()).define('#', ItemRegistry.STONE_PRESSURE_PLATE_TAG).define('R', Items.REDSTONE).group("celestialexploration").unlockedBy("steel", has(ItemRegistry.STEEL_INGOT.get())).save(consumer);
		ShapedRecipeBuilder.shaped(BlockRegistry.ACTIVATOR_MAG_RAIL.get(), 6).pattern("X#X").pattern("XRX").pattern("X#X").define('X', ItemRegistry.STEEL_INGOT.get()).define('#', ItemRegistry.STEEL_ROD.get()).define('R', Items.REDSTONE_TORCH).group("celestialexploration").unlockedBy("steel", has(ItemRegistry.STEEL_INGOT.get())).save(consumer);
		ShapedRecipeBuilder.shaped(ItemRegistry.MAGCART.get()).pattern("X X").pattern("XXX").define('X', ItemRegistry.STEEL_INGOT.get()).group("celestialexploration").unlockedBy("steel", has(ItemRegistry.STEEL_INGOT.get())).save(consumer);
		ShapedRecipeBuilder.shaped(ItemRegistry.CHEST_MAGCART.get()).pattern("#").pattern("X").define('#', Tags.Items.CHESTS).define('X', ItemRegistry.MAGCART.get()).group("celestialexploration").unlockedBy("steel", has(ItemRegistry.STEEL_INGOT.get())).save(consumer);
		ShapedRecipeBuilder.shaped(ItemRegistry.CHEST_MAGCART.get()).pattern("X#X").pattern("XXX").define('#', Tags.Items.CHESTS).define('X', ItemRegistry.STEEL_INGOT.get()).group("celestialexploration").unlockedBy("steel", has(ItemRegistry.STEEL_INGOT.get())).save(consumer, "chest_magcart_from_steel_ingots");
		ShapedRecipeBuilder.shaped(ItemRegistry.FURNACE_MAGCART.get()).pattern("#").pattern("X").define('#', Items.FURNACE).define('X', ItemRegistry.MAGCART.get()).group("celestialexploration").unlockedBy("steel", has(ItemRegistry.STEEL_INGOT.get())).save(consumer);
		ShapedRecipeBuilder.shaped(ItemRegistry.FURNACE_MAGCART.get()).pattern("X#X").pattern("XXX").define('#', Items.FURNACE).define('X', ItemRegistry.STEEL_INGOT.get()).group("celestialexploration").unlockedBy("steel", has(ItemRegistry.STEEL_INGOT.get())).save(consumer, "furnace_magcart_from_steel_ingots");
		ShapedRecipeBuilder.shaped(ItemRegistry.HOPPER_MAGCART.get()).pattern("#").pattern("X").define('#', Items.HOPPER).define('X', ItemRegistry.MAGCART.get()).group("celestialexploration").unlockedBy("steel", has(ItemRegistry.STEEL_INGOT.get())).save(consumer);
		ShapedRecipeBuilder.shaped(ItemRegistry.HOPPER_MAGCART.get()).pattern("X#X").pattern("XXX").define('#', Items.HOPPER).define('X', ItemRegistry.STEEL_INGOT.get()).group("celestialexploration").unlockedBy("steel", has(ItemRegistry.STEEL_INGOT.get())).save(consumer, "hopper_magcart_from_steel_ingots");
		ShapedRecipeBuilder.shaped(ItemRegistry.TNT_MAGCART.get()).pattern("#").pattern("X").define('#', Items.TNT).define('X', ItemRegistry.MAGCART.get()).group("celestialexploration").unlockedBy("steel", has(ItemRegistry.STEEL_INGOT.get())).save(consumer);
		ShapedRecipeBuilder.shaped(ItemRegistry.TNT_MAGCART.get()).pattern("X#X").pattern("XXX").define('#', Items.TNT).define('X', ItemRegistry.STEEL_INGOT.get()).group("celestialexploration").unlockedBy("steel", has(ItemRegistry.STEEL_INGOT.get())).save(consumer, "tnt_magcart_from_steel_ingots");

		//---- ARMOR -------------------------------------------------------------------------------
		//STEEL
		ShapedRecipeBuilder.shaped(ItemRegistry.STEEL_HELMET.get()).pattern("XXX").pattern("X X").define('X', ItemRegistry.STEEL_INGOT.get()).group("celestialexploration").unlockedBy("steel_ingot", has(ItemRegistry.STEEL_INGOT.get())).save(consumer);
		ShapedRecipeBuilder.shaped(ItemRegistry.STEEL_CHESTPLATE.get()).pattern("X X").pattern("XXX").pattern("XXX").define('X', ItemRegistry.STEEL_INGOT.get()).group("celestialexploration").unlockedBy("steel_ingot", has(ItemRegistry.STEEL_INGOT.get())).save(consumer);
		ShapedRecipeBuilder.shaped(ItemRegistry.STEEL_LEGGINGS.get()).pattern("XXX").pattern("X X").pattern("X X").define('X', ItemRegistry.STEEL_INGOT.get()).group("celestialexploration").unlockedBy("steel_ingot", has(ItemRegistry.STEEL_INGOT.get())).save(consumer);
		ShapedRecipeBuilder.shaped(ItemRegistry.STEEL_BOOTS.get()).pattern("X X").pattern("X X").define('X', ItemRegistry.STEEL_INGOT.get()).group("celestialexploration").unlockedBy("steel_ingot", has(ItemRegistry.STEEL_INGOT.get())).save(consumer);

		//SPACE SUITS
		WorkbenchCraftingRecipeBuilder.shaped(ItemRegistry.BASIC_SPACE_SUIT_HELMET.get(), FluidRegistry.MOLTEN_STEEL.get(), 0.33F).pattern("LLL").pattern("WGW").define('L', Items.LEATHER).define('W', Items.WHITE_WOOL).define('G', Tags.Items.GLASS).group("celestialexploration").group("celestialexploration").unlockedBy("has_leather", has(Items.LEATHER)).save(consumer, "basic_space_suit_helmet");
		WorkbenchCraftingRecipeBuilder.shaped(ItemRegistry.BASIC_SPACE_SUIT_CHESTPLATE.get(), FluidRegistry.MOLTEN_STEEL.get(), 0.66F).pattern("L L").pattern("WWW").pattern("LLL").define('W', Items.WHITE_WOOL).define('L', Items.LEATHER).group("celestialexploration").unlockedBy("has_leather", has(Items.LEATHER)).save(consumer, "basic_space_suit_chestplate");
		WorkbenchCraftingRecipeBuilder.shaped(ItemRegistry.BASIC_SPACE_SUIT_LEGGINGS.get(), FluidRegistry.MOLTEN_STEEL.get(), 0.55F).pattern("LLL").pattern("L L").pattern("W W").define('W', Items.WHITE_WOOL).define('L', Items.LEATHER).group("celestialexploration").unlockedBy("has_leather", has(Items.LEATHER)).save(consumer, "basic_space_suit_leggings");
		WorkbenchCraftingRecipeBuilder.shaped(ItemRegistry.BASIC_SPACE_SUIT_BOOTS.get(), FluidRegistry.MOLTEN_STEEL.get(), 0.22F).pattern("W W").pattern("L L").define('L', Items.LEATHER).define('W', Items.WHITE_WOOL).group("celestialexploration").unlockedBy("has_leather", has(Items.LEATHER)).save(consumer, "basic_space_suit_boots");

		WorkbenchCraftingRecipeBuilder.shaped(ItemRegistry.HEAVY_DUTY_SPACE_SUIT_HELMET.get(), FluidRegistry.MOLTEN_STEEL.get(), 0.44F).pattern("DDD").pattern("LGL").define('L', Items.LEATHER).define('G', Tags.Items.GLASS).define('D', Tags.Items.GEMS_DIAMOND).group("celestialexploration").group("celestialexploration").unlockedBy("has_diamond", has(Items.DIAMOND)).save(consumer, "heavy_duty_space_suit_helmet");
		WorkbenchCraftingRecipeBuilder.shaped(ItemRegistry.HEAVY_DUTY_SPACE_SUIT_CHESTPLATE.get(), FluidRegistry.MOLTEN_STEEL.get(), 0.77F).pattern("L L").pattern("DDD").pattern("GMG").define('L', Items.LEATHER).define('G', Tags.Items.INGOTS_GOLD).define('D', Tags.Items.GEMS_DIAMOND).define('M', Items.MAGMA_CREAM).group("celestialexploration").unlockedBy("has_diamond", has(Items.DIAMOND)).save(consumer, "heavy_duty_space_suit_chestplate");
		WorkbenchCraftingRecipeBuilder.shaped(ItemRegistry.HEAVY_DUTY_SPACE_SUIT_LEGGINGS.get(), FluidRegistry.MOLTEN_STEEL.get(), 0.66F).pattern("LLL").pattern("D D").pattern("L L").define('L', Items.LEATHER).define('D', Tags.Items.GEMS_DIAMOND).group("celestialexploration").unlockedBy("has_diamond", has(Items.DIAMOND)).save(consumer, "heavy_duty_space_suit_leggings");
		WorkbenchCraftingRecipeBuilder.shaped(ItemRegistry.HEAVY_DUTY_SPACE_SUIT_BOOTS.get(), FluidRegistry.MOLTEN_STEEL.get(), 0.33F).pattern("R R").pattern("D D").define('D', Tags.Items.GEMS_DIAMOND).define('R', Items.RABBIT_HIDE).group("celestialexploration").unlockedBy("has_diamond", has(Items.DIAMOND)).save(consumer, "heavy_duty_space_suit_boots");

		WorkbenchCraftingRecipeBuilder.shaped(ItemRegistry.THERMAL_SPACE_SUIT_HELMET.get(), FluidRegistry.MOLTEN_STEEL.get(), 0.44F).pattern("DDD").pattern("WGW").define('W', Items.WHITE_WOOL).define('G', Tags.Items.GLASS).define('D', Tags.Items.GEMS_DIAMOND).group("celestialexploration").group("celestialexploration").unlockedBy("has_diamond", has(Items.DIAMOND)).save(consumer, "thermal_space_suit_helmet");
		WorkbenchCraftingRecipeBuilder.shaped(ItemRegistry.THERMAL_SPACE_SUIT_CHESTPLATE.get(), FluidRegistry.MOLTEN_STEEL.get(), 0.77F).pattern("L L").pattern("DDD").pattern("WWW").define('L', Items.LEATHER).define('D', Tags.Items.GEMS_DIAMOND).define('W', Items.WHITE_WOOL).group("celestialexploration").unlockedBy("has_diamond", has(Items.DIAMOND)).save(consumer, "thermal_space_suit_chestplate");
		WorkbenchCraftingRecipeBuilder.shaped(ItemRegistry.THERMAL_SPACE_SUIT_LEGGINGS.get(), FluidRegistry.MOLTEN_STEEL.get(), 0.66F).pattern("WWW").pattern("D D").pattern("W W").define('W', Items.WHITE_WOOL).define('D', Tags.Items.GEMS_DIAMOND).group("celestialexploration").unlockedBy("has_diamond", has(Items.DIAMOND)).save(consumer, "thermal_space_suit_leggings");
		WorkbenchCraftingRecipeBuilder.shaped(ItemRegistry.THERMAL_SPACE_SUIT_BOOTS.get(), FluidRegistry.MOLTEN_STEEL.get(), 0.33F).pattern("L L").pattern("D D").define('D', Tags.Items.GEMS_DIAMOND).define('L', Items.LEATHER).group("celestialexploration").unlockedBy("has_diamond", has(Items.DIAMOND)).save(consumer, "thermal_space_suit_boots");

		WorkbenchCraftingRecipeBuilder.shaped(ItemRegistry.ADVANCED_SPACE_SUIT_HELMET.get(), FluidRegistry.MOLTEN_STEEL.get(), 0.44F).pattern("OOO").pattern("DGD").define('O', Items.OBSIDIAN).define('G', Tags.Items.GLASS).define('D', Tags.Items.GEMS_DIAMOND).group("celestialexploration").group("celestialexploration").unlockedBy("has_obsidian", has(Items.OBSIDIAN)).save(consumer, "advanced_space_suit_helmet");
		WorkbenchCraftingRecipeBuilder.shaped(ItemRegistry.ADVANCED_SPACE_SUIT_CHESTPLATE.get(), FluidRegistry.MOLTEN_STEEL.get(), 0.77F).pattern("L L").pattern("DDD").pattern("OOO").define('L', Items.LEATHER).define('D', Tags.Items.GEMS_DIAMOND).define('O', Items.OBSIDIAN).group("celestialexploration").unlockedBy("has_obsidian", has(Items.OBSIDIAN)).save(consumer, "advanced_space_suit_chestplate");
		WorkbenchCraftingRecipeBuilder.shaped(ItemRegistry.ADVANCED_SPACE_SUIT_LEGGINGS.get(), FluidRegistry.MOLTEN_STEEL.get(), 0.66F).pattern("DDD").pattern("O O").pattern("L L").define('O', Items.OBSIDIAN).define('L', Items.LEATHER).define('D', Tags.Items.GEMS_DIAMOND).group("celestialexploration").unlockedBy("has_obsidian", has(Items.OBSIDIAN)).save(consumer, "advanced_space_suit_leggings");
		WorkbenchCraftingRecipeBuilder.shaped(ItemRegistry.ADVANCED_SPACE_SUIT_BOOTS.get(), FluidRegistry.MOLTEN_STEEL.get(), 0.33F).pattern("L L").pattern("O O").define('O', Items.OBSIDIAN).define('L', Items.LEATHER).group("celestialexploration").unlockedBy("has_obsidian", has(Items.OBSIDIAN)).save(consumer, "advanced_space_suit_boots");

		//---- WORKBENCH SMELTING -------------------------------------------------------------------------------
		workbenchSmelting(Fluids.WATER, Items.WATER_BUCKET, 0.0F, 1, 1.0F, ItemRegistry.WORKBENCH.get(), consumer);
		workbenchSmelting(Fluids.LAVA, Items.LAVA_BUCKET, 0.0F, 1, 1.0F, ItemRegistry.WORKBENCH.get(), consumer);

		//IRON
		workbenchSmelting(FluidRegistry.MOLTEN_IRON.get(), Items.IRON_INGOT, 0.7F, 100, 0.11F, Items.IRON_INGOT, consumer);
		workbenchSmelting(FluidRegistry.MOLTEN_IRON.get(), Items.RAW_IRON, 0.7F, 100, 0.11F, Items.RAW_IRON, consumer);
		workbenchSmelting(FluidRegistry.MOLTEN_IRON.get(), Items.IRON_ORE, 0.1F, 100, 0.11F, Items.IRON_ORE, consumer);
		workbenchSmelting(FluidRegistry.MOLTEN_IRON.get(), Items.DEEPSLATE_IRON_ORE, 0.1F, 100, 0.11F, Items.DEEPSLATE_IRON_ORE, consumer);
		workbenchSmelting(FluidRegistry.MOLTEN_IRON.get(), ItemRegistry.MARS_IRON_ORE.get(), 0.1F, 100, 0.11F, ItemRegistry.MARS_IRON_ORE.get(), consumer);
		workbenchSmelting(FluidRegistry.MOLTEN_IRON.get(), ItemRegistry.MARS_DEEPSLATE_IRON_ORE.get(), 0.1F, 100, 0.11F, ItemRegistry.MARS_DEEPSLATE_IRON_ORE.get(), consumer);
		workbenchSmelting(FluidRegistry.MOLTEN_IRON.get(), ItemRegistry.MOON_IRON_ORE.get(), 0.1F, 100, 0.11F, ItemRegistry.MOON_IRON_ORE.get(), consumer);
		workbenchSmelting(FluidRegistry.MOLTEN_IRON.get(), ItemRegistry.MOON_DEEPSLATE_IRON_ORE.get(), 0.1F, 100, 0.11F, ItemRegistry.MOON_DEEPSLATE_IRON_ORE.get(), consumer);
		workbenchSmelting(FluidRegistry.MOLTEN_IRON.get(), ItemRegistry.METEOR_IRON_ORE.get(), 0.1F, 100, 0.11F, ItemRegistry.METEOR_IRON_ORE.get(), consumer);
		workbenchSmelting(FluidRegistry.MOLTEN_IRON.get(), Items.IRON_BLOCK, 0.7F, 150, 1.0F, Items.IRON_INGOT, consumer);

		//COPPER
		workbenchSmelting(FluidRegistry.MOLTEN_COPPER.get(), Items.COPPER_INGOT, 0.7F, 100, .11F, Items.COPPER_INGOT, consumer);
		workbenchSmelting(FluidRegistry.MOLTEN_COPPER.get(), Items.RAW_COPPER, 0.7F, 100, 0.11F, Items.RAW_COPPER, consumer);
		workbenchSmelting(FluidRegistry.MOLTEN_COPPER.get(), Items.COPPER_ORE, 0.1F, 100, 0.11F, Items.IRON_ORE, consumer);
		workbenchSmelting(FluidRegistry.MOLTEN_COPPER.get(), Items.DEEPSLATE_COPPER_ORE, 0.1F, 100, 0.11F, Items.DEEPSLATE_COPPER_ORE, consumer);
		workbenchSmelting(FluidRegistry.MOLTEN_COPPER.get(), ItemRegistry.METEOR_COPPER_ORE.get(), 0.1F, 100, 0.11F, ItemRegistry.METEOR_COPPER_ORE.get(), consumer);
		workbenchSmelting(FluidRegistry.MOLTEN_COPPER.get(), Items.COPPER_BLOCK, 0.7F, 150, 1.0F, Items.COPPER_BLOCK, consumer);
		workbenchSmelting(FluidRegistry.MOLTEN_COPPER.get(), Items.EXPOSED_COPPER, 0.7F, 150, 1.0F, Items.COPPER_BLOCK, consumer);
		workbenchSmelting(FluidRegistry.MOLTEN_COPPER.get(), Items.OXIDIZED_COPPER, 0.7F, 150, 1.0F, Items.COPPER_BLOCK, consumer);
		workbenchSmelting(FluidRegistry.MOLTEN_COPPER.get(), Items.WEATHERED_COPPER, 0.7F, 150, 1.0F, Items.COPPER_BLOCK, consumer);

		//GOLD
		workbenchSmelting(FluidRegistry.MOLTEN_GOLD.get(), Items.GOLD_INGOT, 0.7F, 100, 0.11F, Items.GOLD_INGOT, consumer);
		workbenchSmelting(FluidRegistry.MOLTEN_GOLD.get(), Items.RAW_GOLD, 0.7F, 100, 0.11F, Items.RAW_GOLD, consumer);
		workbenchSmelting(FluidRegistry.MOLTEN_GOLD.get(), Items.GOLD_ORE, 0.1F, 100, 0.11F, Items.GOLD_ORE, consumer);
		workbenchSmelting(FluidRegistry.MOLTEN_GOLD.get(), Items.DEEPSLATE_GOLD_ORE, 0.1F, 100, 0.11F, Items.DEEPSLATE_GOLD_ORE, consumer);
		workbenchSmelting(FluidRegistry.MOLTEN_GOLD.get(), ItemRegistry.METEOR_GOLD_ORE.get(), 0.1F, 100, 0.11F, ItemRegistry.METEOR_IRON_ORE.get(), consumer);
		workbenchSmelting(FluidRegistry.MOLTEN_GOLD.get(), Items.GOLD_BLOCK, 0.7F, 150, 1.0F, Items.GOLD_INGOT, consumer);

		//STEEL
		workbenchSmelting(FluidRegistry.MOLTEN_STEEL.get(), ItemRegistry.STEEL_INGOT.get(), 0.7F, 100, 0.11F, ItemRegistry.STEEL_INGOT.get(), consumer);
		workbenchSmelting(FluidRegistry.MOLTEN_STEEL.get(), ItemRegistry.STEEL_BLOCK.get(), 0.7F, 150, 1.0F, ItemRegistry.STEEL_INGOT.get(), consumer);

		//ALUMINUM
		workbenchSmelting(FluidRegistry.MOLTEN_ALUMINUM.get(), ItemRegistry.ALUMINUM_INGOT.get(), 0.7F, 100, 0.11F, ItemRegistry.ALUMINUM_INGOT.get(), consumer);
		workbenchSmelting(FluidRegistry.MOLTEN_ALUMINUM.get(), ItemRegistry.ALUMINUM_BLOCK.get(), 0.7F, 150, 1.0F, ItemRegistry.ALUMINUM_INGOT.get(), consumer);

		//REMOVAL
		WorkbenchCraftingRecipeBuilder.shaped(Items.WATER_BUCKET, Fluids.WATER, 1.0F).pattern("X").define('X', Items.BUCKET).group("celestialexploration").unlockedBy("has_iron", has(Items.IRON_INGOT)).save(consumer, "water_bucket_from_workbench");
		WorkbenchCraftingRecipeBuilder.shaped(Items.LAVA_BUCKET, Fluids.LAVA, 1.0F).pattern("X").define('X', Items.BUCKET).group("celestialexploration").unlockedBy("has_iron", has(Items.IRON_INGOT)).save(consumer, "lava_bucket_from_workbench");

		ShapedRecipeBuilder.shaped(ItemRegistry.BLOCK_MOLD.get(), 8).pattern("XXX").pattern("XCX").pattern("XXX").define('C', Items.STONE).define('X', Tags.Items.COBBLESTONE).group("celestialexploration").unlockedBy("has_iron_ingot", has(Items.IRON_INGOT)).save(consumer);
		ShapedRecipeBuilder.shaped(ItemRegistry.INGOT_MOLD.get(), 8).pattern("XXX").pattern("XCX").pattern("XXX").define('C', Tags.Items.INGOTS).define('X', Tags.Items.COBBLESTONE).group("celestialexploration").unlockedBy("has_iron_ingot", has(Items.IRON_INGOT)).save(consumer);

		WorkbenchCraftingRecipeBuilder.shaped(Items.IRON_INGOT, FluidRegistry.MOLTEN_IRON.get(), 0.11F).pattern("X").define('X', ItemRegistry.INGOT_MOLD.get()).group("celestialexploration").unlockedBy("has_iron", has(Items.IRON_INGOT)).save(consumer, "iron_ingot_from_molten_iron");
		WorkbenchCraftingRecipeBuilder.shaped(Items.IRON_BLOCK, FluidRegistry.MOLTEN_IRON.get(), 1.0F).pattern("X").define('X', ItemRegistry.BLOCK_MOLD.get()).group("celestialexploration").unlockedBy("has_iron", has(Items.IRON_INGOT)).save(consumer, "iron_block_from_molten_iron");
		WorkbenchCraftingRecipeBuilder.shaped(ItemRegistry.STEEL_INGOT.get(), FluidRegistry.MOLTEN_STEEL.get(), 0.11F).pattern("X").define('X', ItemRegistry.INGOT_MOLD.get()).group("celestialexploration").unlockedBy("has_steel", has(ItemRegistry.STEEL_INGOT.get())).save(consumer, "steel_ingot_from_molten_steel");
		WorkbenchCraftingRecipeBuilder.shaped(ItemRegistry.STEEL_BLOCK.get(), FluidRegistry.MOLTEN_STEEL.get(), 1.0F).pattern("X").define('X', ItemRegistry.BLOCK_MOLD.get()).group("celestialexploration").unlockedBy("has_steel", has(ItemRegistry.STEEL_INGOT.get())).save(consumer, "steel_block_from_molten_steel");
		WorkbenchCraftingRecipeBuilder.shaped(Items.COPPER_INGOT, FluidRegistry.MOLTEN_COPPER.get(), 0.11F).pattern("X").define('X', ItemRegistry.INGOT_MOLD.get()).group("celestialexploration").unlockedBy("has_copper", has(Items.COPPER_INGOT)).save(consumer, "copper_ingot_from_molten_copper");
		WorkbenchCraftingRecipeBuilder.shaped(Items.COPPER_BLOCK, FluidRegistry.MOLTEN_COPPER.get(), 1.0F).pattern("X").define('X', ItemRegistry.BLOCK_MOLD.get()).group("celestialexploration").unlockedBy("has_copper", has(Items.COPPER_INGOT)).save(consumer, "copper_block_from_molten_copper");
		WorkbenchCraftingRecipeBuilder.shaped(Items.GOLD_INGOT, FluidRegistry.MOLTEN_GOLD.get(), 0.11F).pattern("X").define('X', ItemRegistry.INGOT_MOLD.get()).group("celestialexploration").unlockedBy("has_gold", has(Items.GOLD_INGOT)).save(consumer, "gold_ingot_from_molten_gold");
		WorkbenchCraftingRecipeBuilder.shaped(Items.GOLD_BLOCK, FluidRegistry.MOLTEN_GOLD.get(), 1.0F).pattern("X").define('X', ItemRegistry.BLOCK_MOLD.get()).group("celestialexploration").unlockedBy("has_gold", has(Items.GOLD_INGOT)).save(consumer, "gold_block_from_molten_gold");

		//---- GLASS/CERAMICS -------------------------------------------------------------------------------
		//GLASS
		ShapelessRecipeBuilder.shapeless(ItemRegistry.LUMINOUS_BLUE_GLASS.get()).requires(Tags.Items.GLASS).requires(ItemRegistry.MOON_DUST.get()).group("celestialexploration").unlockedBy("moon_dust", has(ItemRegistry.MOON_DUST.get())).save(consumer);
		ShapelessRecipeBuilder.shapeless(ItemRegistry.LUMINOUS_WHITE_GLASS.get()).requires(ItemRegistry.LUMINOUS_BLUE_GLASS.get()).requires(ItemRegistry.LUNAR_GOO.get()).group("celestialexploration").unlockedBy("moon_dust", has(ItemRegistry.MOON_DUST.get())).save(consumer);
		ShapedRecipeBuilder.shaped(ItemRegistry.LUMINOUS_BLUE_GLASS_PANE.get(), 16).pattern("XXX").pattern("XXX").define('X', ItemRegistry.LUMINOUS_BLUE_GLASS.get()).group("celestialexploration").unlockedBy("moon_dust", has(ItemRegistry.MOON_DUST.get())).save(consumer);
		ShapedRecipeBuilder.shaped(ItemRegistry.LUMINOUS_WHITE_GLASS_PANE.get(), 16).pattern("XXX").pattern("XXX").define('X', ItemRegistry.LUMINOUS_WHITE_GLASS.get()).group("celestialexploration").unlockedBy("moon_dust", has(ItemRegistry.MOON_DUST.get())).save(consumer);
		ShapedRecipeBuilder.shaped(BlockRegistry.REINFORCED_GLASS.get(), 4).pattern(" X ").pattern("XCX").pattern(" X ").define('X', Blocks.GLASS).define('C', Items.IRON_INGOT).group("celestialexploration").unlockedBy("glass", has(Blocks.GLASS)).save(consumer);
		ShapedRecipeBuilder.shaped(BlockRegistry.REINFORCED_GLASS_PANE.get(), 16).pattern("XXX").pattern("XXX").define('X', ItemRegistry.REINFORCED_GLASS.get()).group("celestialexploration").unlockedBy("glass", has(Blocks.GLASS)).save(consumer);

		ShapedRecipeBuilder.shaped(Items.GLASS, 8).pattern("GGG").pattern("GXG").pattern("GGG").define('X', ItemRegistry.STEEL_WOOL.get()).define('G', Tags.Items.STAINED_GLASS).group("celestialexploration").unlockedBy("glass", has(Items.GLASS)).save(consumer, "glass_from_steel_wool");
		ShapedRecipeBuilder.shaped(Items.GLASS_PANE, 8).pattern("GGG").pattern("GXG").pattern("GGG").define('X', ItemRegistry.STEEL_WOOL.get()).define('G', Tags.Items.STAINED_GLASS_PANES).group("celestialexploration").unlockedBy("glass", has(Items.GLASS)).save(consumer, "glass_pane_from_steel_wool");

		//CERAMIC
		WorkbenchCraftingRecipeBuilder.shaped(ItemRegistry.SILICA.get(), 4, Fluids.WATER, 0.25F).pattern("SS").pattern("SS").define('S', Tags.Items.SAND).group("celestialexploration").unlockedBy("has_sand", has(Items.SAND)).save(consumer, "silica_from_workbench");
		smelting(ItemRegistry.SILICA.get(), ItemRegistry.CERAMIC.get(), 1.05F, 100, Items.SAND, consumer);

		ShapedRecipeBuilder.shaped(ItemRegistry.CERAMIC.get(), 8).pattern("GGG").pattern("GXG").pattern("GGG").define('X', ItemRegistry.STEEL_WOOL.get()).define('G', ItemRegistry.DYED_CERAMIC_TAG).group("celestialexploration").unlockedBy("ceramic", has(ItemRegistry.CERAMIC.get())).save(consumer, "ceramic_from_steel_wool");
		ShapedRecipeBuilder.shaped(ItemRegistry.CERAMIC_TILE.get(), 8).pattern("GGG").pattern("GXG").pattern("GGG").define('X', ItemRegistry.STEEL_WOOL.get()).define('G', ItemRegistry.DYED_CERAMIC_TILE_TAG).group("celestialexploration").unlockedBy("ceramic", has(ItemRegistry.CERAMIC.get())).save(consumer, "ceramic_tile_from_steel_wool");

		ShapedRecipeBuilder.shaped(BlockRegistry.WHITE_CERAMIC.get(), 8).pattern("XXX").pattern("X#X").pattern("XXX").define('X', BlockRegistry.CERAMIC.get()).define('#', Items.WHITE_DYE).group("celestialexploration").unlockedBy("ceramic", has(ItemRegistry.CERAMIC.get())).save(consumer);
		ShapedRecipeBuilder.shaped(BlockRegistry.LIGHT_GREY_CERAMIC.get(), 8).pattern("XXX").pattern("X#X").pattern("XXX").define('X', BlockRegistry.CERAMIC.get()).define('#', Items.LIGHT_GRAY_DYE).group("celestialexploration").unlockedBy("ceramic", has(ItemRegistry.CERAMIC.get())).save(consumer);
		ShapedRecipeBuilder.shaped(BlockRegistry.GREY_CERAMIC.get(), 8).pattern("XXX").pattern("X#X").pattern("XXX").define('X', BlockRegistry.CERAMIC.get()).define('#', Items.GRAY_DYE).group("celestialexploration").unlockedBy("ceramic", has(ItemRegistry.CERAMIC.get())).save(consumer);
		ShapedRecipeBuilder.shaped(BlockRegistry.BLACK_CERAMIC.get(), 8).pattern("XXX").pattern("X#X").pattern("XXX").define('X', BlockRegistry.CERAMIC.get()).define('#', Items.BLACK_DYE).group("celestialexploration").unlockedBy("ceramic", has(ItemRegistry.CERAMIC.get())).save(consumer);
		ShapedRecipeBuilder.shaped(BlockRegistry.PURPLE_CERAMIC.get(), 8).pattern("XXX").pattern("X#X").pattern("XXX").define('X', BlockRegistry.CERAMIC.get()).define('#', Items.PURPLE_DYE).group("celestialexploration").unlockedBy("ceramic", has(ItemRegistry.CERAMIC.get())).save(consumer);
		ShapedRecipeBuilder.shaped(BlockRegistry.MAGENTA_CERAMIC.get(), 8).pattern("XXX").pattern("X#X").pattern("XXX").define('X', BlockRegistry.CERAMIC.get()).define('#', Items.MAGENTA_DYE).group("celestialexploration").unlockedBy("ceramic", has(ItemRegistry.CERAMIC.get())).save(consumer);
		ShapedRecipeBuilder.shaped(BlockRegistry.BLUE_CERAMIC.get(), 8).pattern("XXX").pattern("X#X").pattern("XXX").define('X', BlockRegistry.CERAMIC.get()).define('#', Items.BLUE_DYE).group("celestialexploration").unlockedBy("ceramic", has(ItemRegistry.CERAMIC.get())).save(consumer);
		ShapedRecipeBuilder.shaped(BlockRegistry.LIGHT_BLUE_CERAMIC.get(), 8).pattern("XXX").pattern("X#X").pattern("XXX").define('X', BlockRegistry.CERAMIC.get()).define('#', Items.LIGHT_BLUE_DYE).group("celestialexploration").unlockedBy("ceramic", has(ItemRegistry.CERAMIC.get())).save(consumer);
		ShapedRecipeBuilder.shaped(BlockRegistry.CYAN_CERAMIC.get(), 8).pattern("XXX").pattern("X#X").pattern("XXX").define('X', BlockRegistry.CERAMIC.get()).define('#', Items.CYAN_DYE).group("celestialexploration").unlockedBy("ceramic", has(ItemRegistry.CERAMIC.get())).save(consumer);
		ShapedRecipeBuilder.shaped(BlockRegistry.GREEN_CERAMIC.get(), 8).pattern("XXX").pattern("X#X").pattern("XXX").define('X', BlockRegistry.CERAMIC.get()).define('#', Items.GREEN_DYE).group("celestialexploration").unlockedBy("ceramic", has(ItemRegistry.CERAMIC.get())).save(consumer);
		ShapedRecipeBuilder.shaped(BlockRegistry.LIME_CERAMIC.get(), 8).pattern("XXX").pattern("X#X").pattern("XXX").define('X', BlockRegistry.CERAMIC.get()).define('#', Items.LIME_DYE).group("celestialexploration").unlockedBy("ceramic", has(ItemRegistry.CERAMIC.get())).save(consumer);
		ShapedRecipeBuilder.shaped(BlockRegistry.YELLOW_CERAMIC.get(), 8).pattern("XXX").pattern("X#X").pattern("XXX").define('X', BlockRegistry.CERAMIC.get()).define('#', Items.YELLOW_DYE).group("celestialexploration").unlockedBy("ceramic", has(ItemRegistry.CERAMIC.get())).save(consumer);
		ShapedRecipeBuilder.shaped(BlockRegistry.ORANGE_CERAMIC.get(), 8).pattern("XXX").pattern("X#X").pattern("XXX").define('X', BlockRegistry.CERAMIC.get()).define('#', Items.ORANGE_DYE).group("celestialexploration").unlockedBy("ceramic", has(ItemRegistry.CERAMIC.get())).save(consumer);
		ShapedRecipeBuilder.shaped(BlockRegistry.BROWN_CERAMIC.get(), 8).pattern("XXX").pattern("X#X").pattern("XXX").define('X', BlockRegistry.CERAMIC.get()).define('#', Items.BROWN_DYE).group("celestialexploration").unlockedBy("ceramic", has(ItemRegistry.CERAMIC.get())).save(consumer);
		ShapedRecipeBuilder.shaped(BlockRegistry.RED_CERAMIC.get(), 8).pattern("XXX").pattern("X#X").pattern("XXX").define('X', BlockRegistry.CERAMIC.get()).define('#', Items.RED_DYE).group("celestialexploration").unlockedBy("ceramic", has(ItemRegistry.CERAMIC.get())).save(consumer);
		ShapedRecipeBuilder.shaped(BlockRegistry.PINK_CERAMIC.get(), 8).pattern("XXX").pattern("X#X").pattern("XXX").define('X', BlockRegistry.CERAMIC.get()).define('#', Items.PINK_DYE).group("celestialexploration").unlockedBy("ceramic", has(ItemRegistry.CERAMIC.get())).save(consumer);

		pane(ItemRegistry.CERAMIC.get(), ItemRegistry.CERAMIC_TILE.get(), ItemRegistry.CERAMIC.get(), consumer);
		pane(ItemRegistry.WHITE_CERAMIC.get(), ItemRegistry.WHITE_CERAMIC_TILE.get(), ItemRegistry.CERAMIC.get(), consumer);
		pane(ItemRegistry.LIGHT_GREY_CERAMIC.get(), ItemRegistry.LIGHT_GREY_CERAMIC_TILE.get(), ItemRegistry.CERAMIC.get(), consumer);
		pane(ItemRegistry.GREY_CERAMIC.get(), ItemRegistry.GREY_CERAMIC_TILE.get(), ItemRegistry.CERAMIC.get(), consumer);
		pane(ItemRegistry.BLACK_CERAMIC.get(), ItemRegistry.BLACK_CERAMIC_TILE.get(), ItemRegistry.CERAMIC.get(), consumer);
		pane(ItemRegistry.PURPLE_CERAMIC.get(), ItemRegistry.PURPLE_CERAMIC_TILE.get(), ItemRegistry.CERAMIC.get(), consumer);
		pane(ItemRegistry.MAGENTA_CERAMIC.get(), ItemRegistry.MAGENTA_CERAMIC_TILE.get(), ItemRegistry.CERAMIC.get(), consumer);
		pane(ItemRegistry.BLUE_CERAMIC.get(), ItemRegistry.BLUE_CERAMIC_TILE.get(), ItemRegistry.CERAMIC.get(), consumer);
		pane(ItemRegistry.LIGHT_BLUE_CERAMIC.get(), ItemRegistry.LIGHT_BLUE_CERAMIC_TILE.get(), ItemRegistry.CERAMIC.get(), consumer);
		pane(ItemRegistry.CYAN_CERAMIC.get(), ItemRegistry.CYAN_CERAMIC_TILE.get(), ItemRegistry.CERAMIC.get(), consumer);
		pane(ItemRegistry.GREEN_CERAMIC.get(), ItemRegistry.GREEN_CERAMIC_TILE.get(), ItemRegistry.CERAMIC.get(), consumer);
		pane(ItemRegistry.LIME_CERAMIC.get(), ItemRegistry.LIME_CERAMIC_TILE.get(), ItemRegistry.CERAMIC.get(), consumer);
		pane(ItemRegistry.YELLOW_CERAMIC.get(), ItemRegistry.YELLOW_CERAMIC_TILE.get(), ItemRegistry.CERAMIC.get(), consumer);
		pane(ItemRegistry.ORANGE_CERAMIC.get(), ItemRegistry.ORANGE_CERAMIC_TILE.get(), ItemRegistry.CERAMIC.get(), consumer);
		pane(ItemRegistry.BROWN_CERAMIC.get(), ItemRegistry.BROWN_CERAMIC_TILE.get(), ItemRegistry.CERAMIC.get(), consumer);
		pane(ItemRegistry.RED_CERAMIC.get(), ItemRegistry.RED_CERAMIC_TILE.get(), ItemRegistry.CERAMIC.get(), consumer);
		pane(ItemRegistry.PINK_CERAMIC.get(), ItemRegistry.PINK_CERAMIC_TILE.get(), ItemRegistry.CERAMIC.get(), consumer);

		smelting(ItemRegistry.WHITE_CERAMIC.get(), ItemRegistry.PAINTED_WHITE_CERAMIC.get(), 1.0F, 100, ItemRegistry.CERAMIC.get(), consumer);
		smelting(ItemRegistry.LIGHT_GREY_CERAMIC.get(), ItemRegistry.PAINTED_LIGHT_GREY_CERAMIC.get(), 1.0F, 100, ItemRegistry.CERAMIC.get(), consumer);
		smelting(ItemRegistry.GREY_CERAMIC.get(), ItemRegistry.PAINTED_GREY_CERAMIC.get(), 1.0F, 100, ItemRegistry.CERAMIC.get(), consumer);
		smelting(ItemRegistry.BLACK_CERAMIC.get(), ItemRegistry.PAINTED_BLACK_CERAMIC.get(), 1.0F, 100, ItemRegistry.CERAMIC.get(), consumer);
		smelting(ItemRegistry.PURPLE_CERAMIC.get(), ItemRegistry.PAINTED_PURPLE_CERAMIC.get(), 1.0F, 100, ItemRegistry.CERAMIC.get(), consumer);
		smelting(ItemRegistry.MAGENTA_CERAMIC.get(), ItemRegistry.PAINTED_MAGENTA_CERAMIC.get(), 1.0F, 100, ItemRegistry.CERAMIC.get(), consumer);
		smelting(ItemRegistry.BLUE_CERAMIC.get(), ItemRegistry.PAINTED_BLUE_CERAMIC.get(), 1.0F, 100, ItemRegistry.CERAMIC.get(), consumer);
		smelting(ItemRegistry.LIGHT_BLUE_CERAMIC.get(), ItemRegistry.PAINTED_LIGHT_BLUE_CERAMIC.get(), 1.0F, 100, ItemRegistry.CERAMIC.get(), consumer);
		smelting(ItemRegistry.CYAN_CERAMIC.get(), ItemRegistry.PAINTED_CYAN_CERAMIC.get(), 1.0F, 100, ItemRegistry.CERAMIC.get(), consumer);
		smelting(ItemRegistry.GREEN_CERAMIC.get(), ItemRegistry.PAINTED_GREEN_CERAMIC.get(), 1.0F, 100, ItemRegistry.CERAMIC.get(), consumer);
		smelting(ItemRegistry.LIME_CERAMIC.get(), ItemRegistry.PAINTED_LIME_CERAMIC.get(), 1.0F, 100, ItemRegistry.CERAMIC.get(), consumer);
		smelting(ItemRegistry.YELLOW_CERAMIC.get(), ItemRegistry.PAINTED_YELLOW_CERAMIC.get(), 1.0F, 100, ItemRegistry.CERAMIC.get(), consumer);
		smelting(ItemRegistry.ORANGE_CERAMIC.get(), ItemRegistry.PAINTED_ORANGE_CERAMIC.get(), 1.0F, 100, ItemRegistry.CERAMIC.get(), consumer);
		smelting(ItemRegistry.BROWN_CERAMIC.get(), ItemRegistry.PAINTED_BROWN_CERAMIC.get(), 1.0F, 100, ItemRegistry.CERAMIC.get(), consumer);
		smelting(ItemRegistry.RED_CERAMIC.get(), ItemRegistry.PAINTED_RED_CERAMIC.get(), 1.0F, 100, ItemRegistry.CERAMIC.get(), consumer);
		smelting(ItemRegistry.PINK_CERAMIC.get(), ItemRegistry.PAINTED_PINK_CERAMIC.get(), 1.0F, 100, ItemRegistry.CERAMIC.get(), consumer);

		//---- FOOD -------------------------------------------------------------------------------
		ShapedRecipeBuilder.shaped(ItemRegistry.MARSHMALLOW.get()).pattern("XX").pattern("XX").define('X', ItemRegistry.MARSHMALLOW_GOO.get()).group("celestialexploration").unlockedBy("marshmallow_goo", has(ItemRegistry.MARSHMALLOW_GOO.get())).save(consumer, "marshmallow_from_marshmallow_goo");
		ShapelessRecipeBuilder.shapeless(ItemRegistry.MARSHMALLOW.get(), 2).requires(Items.SUGAR).requires(Items.MILK_BUCKET).requires(Items.SUGAR).requires(Items.SUGAR).group("celestialexploration").unlockedBy("sugar", has(Items.SUGAR)).save(consumer);
		ShapelessRecipeBuilder.shapeless(ItemRegistry.CHOCOLATE.get()).requires(Items.SUGAR).requires(Items.MILK_BUCKET).requires(Items.COCOA_BEANS).group("celestialexploration").unlockedBy("cocoa_beans", has(Items.COCOA_BEANS)).save(consumer);
		ShapedRecipeBuilder.shaped(ItemRegistry.CRACKER.get(), 4).pattern("X").pattern("X").define('X', Items.WHEAT).group("celestialexploration").unlockedBy("wheat", has(Items.WHEAT)).save(consumer);
		smelting(ItemRegistry.MARSHMALLOW.get(), ItemRegistry.ROASTED_MARSHMALLOW.get(), 0.1F, 100, ItemRegistry.MARSHMALLOW_GOO.get(), consumer);
		ShapelessRecipeBuilder.shapeless(ItemRegistry.SMORES.get()).requires(ItemRegistry.ROASTED_MARSHMALLOW.get()).requires(ItemRegistry.CHOCOLATE.get()).requires(ItemRegistry.CRACKER.get()).requires(ItemRegistry.CRACKER.get()).group("celestialexploration").unlockedBy("marshmallow_goo", has(ItemRegistry.MARSHMALLOW_GOO.get())).save(consumer);
		ShapelessRecipeBuilder.shapeless(ItemRegistry.LUNAR_CHEESE.get()).requires(ItemRegistry.LUNAR_GOO.get()).requires(Items.MILK_BUCKET).group("celestialexploration").unlockedBy("lunar_goo", has(ItemRegistry.LUNAR_GOO.get())).save(consumer);
		ShapelessRecipeBuilder.shapeless(ItemRegistry.CHEESE.get()).requires(Items.MILK_BUCKET).requires(Items.MILK_BUCKET).group("celestialexploration").unlockedBy("milk", has(Items.MILK_BUCKET)).save(consumer);

		//---- MISC -------------------------------------------------------------------------------
		ingotAndBlock(Items.COBBLESTONE, ItemRegistry.COMPRESSED_COBBLESTONE.get(), Items.COBBLESTONE, consumer);
		ingotAndBlock(Items.COBBLED_DEEPSLATE, ItemRegistry.COMPRESSED_COBBLED_DEEPSLATE.get(), Items.COBBLED_DEEPSLATE, consumer);
		ingotAndBlock(Items.NETHERRACK, ItemRegistry.COMPRESSED_NETHERRACK.get(), Items.NETHERRACK, consumer);
	}
}