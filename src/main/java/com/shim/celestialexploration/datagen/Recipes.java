package com.shim.celestialexploration.datagen;

import java.util.function.Consumer;

import com.shim.celestialexploration.datagen.util.RecipeGenHelper;
import com.shim.celestialexploration.datagen.util.WorkbenchCraftingRecipeBuilder;
import com.shim.celestialexploration.registry.BlockRegistry;

import com.shim.celestialexploration.registry.FluidRegistry;
import com.shim.celestialexploration.registry.ItemRegistry;
import com.shim.celestialexploration.registry.TagRegistry;
import mezz.jei.api.ingredients.IIngredientHelper;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.*;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.material.Fluids;
import net.minecraftforge.common.Tags;

import static com.shim.celestialexploration.datagen.util.RecipeGenHelper.*;


public class Recipes extends RecipeProvider {

	public Recipes(DataGenerator generatorIn) {
		super(generatorIn);
	}
	
	@Override
	protected void buildCraftingRecipes(Consumer<FinishedRecipe> consumer) {

		//---- MOON -------------------------------------------------------------------------------
		//STONE
		bricksCraftAndStonecutting(BlockRegistry.MOON_STONE.get(), BlockRegistry.MOON_BRICKS.get(), BlockRegistry.MOON_STONE.get(), consumer);
		stairsSlabWallCraftStonecutting(BlockRegistry.MOON_BRICKS.get(), TagRegistry.Items.MOON_STONE, BlockRegistry.MOON_BRICK_STAIRS.get(), BlockRegistry.MOON_BRICK_SLAB.get(), BlockRegistry.MOON_BRICK_WALL.get(), BlockRegistry.MOON_STONE.get(), consumer);
		ShapedRecipeBuilder.shaped(BlockRegistry.CHISELED_MOON_BRICKS.get()).pattern("X").pattern("X").define('X', BlockRegistry.MOON_BRICK_SLAB.get()).group(modGroup()).unlockedBy("moon_stone", has(BlockRegistry.MOON_STONE.get())).save(consumer);
		smelting(BlockRegistry.MOON_BRICKS.get(), BlockRegistry.CRACKED_MOON_BRICKS.get(), 0.1F, 200, BlockRegistry.MOON_BRICKS.get(), consumer);

		stonecutting(BlockRegistry.MOON_STONE.get(), BlockRegistry.CHISELED_MOON_BRICKS.get(), 1, BlockRegistry.MOON_BRICKS.get(), consumer);
		ShapedRecipeBuilder.shaped(BlockRegistry.MOON_BRICK_PILLAR.get(), 4).pattern("X").pattern("X").define('X', BlockRegistry.MOON_BRICKS.get()).group(modGroup()).unlockedBy("moon_stone", has(BlockRegistry.MOON_STONE.get())).save(consumer);
		stonecutting(BlockRegistry.MOON_STONE.get(), BlockRegistry.MOON_BRICK_PILLAR.get(), 1, BlockRegistry.MOON_STONE.get(), consumer);
		smelting(BlockRegistry.MOON_COBBLESTONE.get(), BlockRegistry.MOON_STONE.get(), 0.1F, 200, BlockRegistry.MOON_COBBLESTONE.get(), consumer);
		smelting(BlockRegistry.MOON_COBBLED_DEEPSLATE.get(), BlockRegistry.MOON_DEEPSLATE.get(), 0.1F, 200, BlockRegistry.MOON_COBBLED_DEEPSLATE.get(), consumer);
		stairsCraftAndStonecutting(BlockRegistry.MOON_STONE.get(), BlockRegistry.MOON_STONE_STAIRS.get(), BlockRegistry.MOON_STONE.get(), consumer);
		slabCraftAndStonecutting(BlockRegistry.MOON_STONE.get(), BlockRegistry.MOON_STONE_SLAB.get(), BlockRegistry.MOON_STONE.get(), consumer);
		stairsSlabWallCraftStonecutting(BlockRegistry.MOON_COBBLESTONE.get(), TagRegistry.Items.MOON_COBBLESTONE, BlockRegistry.MOON_COBBLESTONE_STAIRS.get(), BlockRegistry.MOON_COBBLESTONE_SLAB.get(), BlockRegistry.MOON_COBBLESTONE_WALL.get(), BlockRegistry.MOON_COBBLESTONE.get(), consumer);
		smelting(BlockRegistry.MOON_STONE.get(), BlockRegistry.MOON_SMOOTH_STONE.get(), 0.1F, 200, BlockRegistry.MOON_STONE.get(), consumer);
		ShapedRecipeBuilder.shaped(BlockRegistry.MOON_SMOOTH_STONE_SLAB.get(), 6).pattern("XXX").define('X', BlockRegistry.MOON_SMOOTH_STONE.get()).group(modGroup()).unlockedBy("has_moon_smooth_stone", has(BlockRegistry.MOON_STONE.get())).save(consumer);
		stonecutting(BlockRegistry.MOON_SMOOTH_STONE.get(), BlockRegistry.MOON_SMOOTH_STONE_SLAB.get(), 2, BlockRegistry.MOON_SMOOTH_STONE.get(), consumer);
		singleItem(BlockRegistry.MOON_STONE.get(), BlockRegistry.MOON_STONE_BUTTON.get(), 1, BlockRegistry.MOON_STONE.get(), consumer);
		ShapedRecipeBuilder.shaped(BlockRegistry.MOON_STONE_PRESSURE_PLATE.get()).pattern("XX").define('X', BlockRegistry.MOON_STONE.get()).group(modGroup()).unlockedBy("moon_stone", has(BlockRegistry.MOON_STONE.get())).save(consumer);
		singleItem(BlockRegistry.MOON_DEEPSLATE.get(), BlockRegistry.MOON_DEEPSLATE_BUTTON.get(), 1, BlockRegistry.MOON_STONE.get(), consumer);
		ShapedRecipeBuilder.shaped(BlockRegistry.MOON_DEEPSLATE_PRESSURE_PLATE.get()).pattern("XX").define('X', BlockRegistry.MOON_DEEPSLATE.get()).group(modGroup()).unlockedBy("moon_deepslate", has(BlockRegistry.MOON_DEEPSLATE.get())).save(consumer);
		ingotAndBlock(BlockRegistry.MOON_COBBLESTONE.get(), BlockRegistry.COMPRESSED_MOON_COBBLESTONE.get(), BlockRegistry.MOON_COBBLESTONE.get(), consumer);
		ingotAndBlock(BlockRegistry.COMPRESSED_MOON_COBBLESTONE.get(), BlockRegistry.SUPER_COMPRESSED_MOON_COBBLESTONE.get(), BlockRegistry.COMPRESSED_MOON_COBBLESTONE.get(), consumer);

		//DEEPSLATE
		stairsSlabWallCraftStonecutting(BlockRegistry.MOON_COBBLED_DEEPSLATE.get(), BlockRegistry.MOON_COBBLED_DEEPSLATE_STAIRS.get(), BlockRegistry.MOON_COBBLED_DEEPSLATE_SLAB.get(), BlockRegistry.MOON_COBBLED_DEEPSLATE_WALL.get(), BlockRegistry.MOON_COBBLED_DEEPSLATE.get(), consumer);
		deepslateBricks(BlockRegistry.MOON_COBBLED_DEEPSLATE.get(), BlockRegistry.MOON_POLISHED_DEEPSLATE.get(), BlockRegistry.MOON_DEEPSLATE_BRICKS.get(), BlockRegistry.MOON_DEEPSLATE_BRICK_STAIRS.get(), BlockRegistry.MOON_DEEPSLATE_BRICK_SLAB.get(), BlockRegistry.MOON_DEEPSLATE_BRICK_WALL.get(), BlockRegistry.MOON_COBBLED_DEEPSLATE.get(), consumer);
		deepslateTiles(BlockRegistry.MOON_COBBLED_DEEPSLATE.get(), BlockRegistry.MOON_POLISHED_DEEPSLATE.get(), BlockRegistry.MOON_DEEPSLATE_BRICKS.get(), BlockRegistry.MOON_DEEPSLATE_TILES.get(), BlockRegistry.MOON_DEEPSLATE_TILE_STAIRS.get(), BlockRegistry.MOON_DEEPSLATE_TILE_SLAB.get(), BlockRegistry.MOON_DEEPSLATE_TILE_WALL.get(), BlockRegistry.MOON_COBBLED_DEEPSLATE.get(), consumer);
		polishedDeepslate(BlockRegistry.MOON_COBBLED_DEEPSLATE.get(), BlockRegistry.MOON_POLISHED_DEEPSLATE.get(), BlockRegistry.MOON_POLISHED_DEEPSLATE_STAIRS.get(), BlockRegistry.MOON_POLISHED_DEEPSLATE_SLAB.get(), BlockRegistry.MOON_POLISHED_DEEPSLATE_WALL.get(), BlockRegistry.MOON_COBBLED_DEEPSLATE.get(), consumer);
		ShapedRecipeBuilder.shaped(BlockRegistry.CHISELED_MOON_DEEPSLATE_BRICKS.get()).pattern("X").pattern("X").define('X', BlockRegistry.MOON_COBBLED_DEEPSLATE_SLAB.get()).group(modGroup()).unlockedBy("has_moon_cobbled_deepslate", has(BlockRegistry.MOON_COBBLED_DEEPSLATE.get())).save(consumer);
		stonecutting(TagRegistry.Items.MOON_COBBLED_DEEPSLATE, BlockRegistry.CHISELED_MOON_DEEPSLATE_BRICKS.get(), 1, BlockRegistry.MOON_COBBLED_DEEPSLATE.get(), consumer);
		smelting(BlockRegistry.MOON_DEEPSLATE_BRICKS.get(), BlockRegistry.CRACKED_MOON_DEEPSLATE_BRICKS.get(), 0.1F, 200, BlockRegistry.MOON_DEEPSLATE_BRICKS.get(), consumer);
		smelting(BlockRegistry.MOON_DEEPSLATE_TILES.get(), BlockRegistry.CRACKED_MOON_DEEPSLATE_TILES.get(), 0.1F, 200, BlockRegistry.MOON_DEEPSLATE_TILES.get(), consumer);
		ingotAndBlock(BlockRegistry.MOON_COBBLED_DEEPSLATE.get(), BlockRegistry.COMPRESSED_MOON_COBBLED_DEEPSLATE.get(), BlockRegistry.MOON_COBBLED_DEEPSLATE.get(), consumer);
		ingotAndBlock(BlockRegistry.COMPRESSED_MOON_COBBLED_DEEPSLATE.get(), BlockRegistry.SUPER_COMPRESSED_MOON_COBBLED_DEEPSLATE.get(), BlockRegistry.COMPRESSED_MOON_COBBLED_DEEPSLATE.get(), consumer);

		//OTHER
		smelting(BlockRegistry.MOON_SAND.get(), Items.WHITE_STAINED_GLASS, 0.1F, 200, BlockRegistry.MOON_SAND.get(), consumer);
		ShapedRecipeBuilder.shaped(BlockRegistry.LUNAR_LANTERN.get()).pattern("XCX").pattern("C#C").pattern("XCX").define('X', BlockRegistry.MOON_STONE.get()).define('#', Items.IRON_INGOT).define('C', ItemRegistry.MOON_DUST.get()).group(modGroup()).unlockedBy("has_moon_dust", has(ItemRegistry.MOON_DUST.get())).save(consumer);

		//---- MARS -------------------------------------------------------------------------------
		//STONE
		bricksCraftAndStonecutting(BlockRegistry.MARS_STONE.get(), BlockRegistry.MARS_BRICKS.get(), BlockRegistry.MARS_STONE.get(), consumer);
		stairsSlabWallCraftStonecutting(BlockRegistry.MARS_BRICKS.get(), TagRegistry.Items.MARS_STONE, BlockRegistry.MARS_BRICK_STAIRS.get(), BlockRegistry.MARS_BRICK_SLAB.get(), BlockRegistry.MARS_BRICK_WALL.get(), BlockRegistry.MARS_STONE.get(), consumer);
		ShapedRecipeBuilder.shaped(BlockRegistry.CHISELED_MARS_BRICKS.get()).pattern("X").pattern("X").define('X', BlockRegistry.MARS_BRICK_SLAB.get()).group(modGroup()).unlockedBy("mars_stone", has(BlockRegistry.MARS_STONE.get())).save(consumer);
		smelting(BlockRegistry.MARS_BRICKS.get(), BlockRegistry.CRACKED_MARS_BRICKS.get(), 0.1F, 200, BlockRegistry.MARS_BRICKS.get(), consumer);
		stonecutting(BlockRegistry.MARS_STONE.get(), BlockRegistry.CHISELED_MARS_BRICKS.get(), 1, BlockRegistry.MARS_BRICKS.get(), consumer);
		ShapedRecipeBuilder.shaped(BlockRegistry.MARS_BRICK_PILLAR.get(), 4).pattern("X").pattern("X").define('X', BlockRegistry.MARS_BRICKS.get()).group(modGroup()).unlockedBy("mars_stone", has(BlockRegistry.MARS_STONE.get())).save(consumer);
		stonecutting(BlockRegistry.MARS_STONE.get(), BlockRegistry.MARS_BRICK_PILLAR.get(), 1, BlockRegistry.MARS_STONE.get(), consumer);
		smelting(BlockRegistry.MARS_COBBLESTONE.get(), BlockRegistry.MARS_STONE.get(), 0.1F, 200, BlockRegistry.MARS_COBBLESTONE.get(), consumer);
		smelting(BlockRegistry.MARS_COBBLED_DEEPSLATE.get(), BlockRegistry.MARS_DEEPSLATE.get(), 0.1F, 200, BlockRegistry.MARS_COBBLED_DEEPSLATE.get(), consumer);
		stairsCraftAndStonecutting(BlockRegistry.MARS_STONE.get(), BlockRegistry.MARS_STONE_STAIRS.get(), BlockRegistry.MARS_STONE.get(), consumer);
		slabCraftAndStonecutting(BlockRegistry.MARS_STONE.get(), BlockRegistry.MARS_STONE_SLAB.get(), BlockRegistry.MARS_STONE.get(), consumer);
		stairsSlabWallCraftStonecutting(BlockRegistry.MARS_COBBLESTONE.get(), TagRegistry.Items.MARS_COBBLESTONE, BlockRegistry.MARS_COBBLESTONE_STAIRS.get(), BlockRegistry.MARS_COBBLESTONE_SLAB.get(), BlockRegistry.MARS_COBBLESTONE_WALL.get(), BlockRegistry.MARS_COBBLESTONE.get(), consumer);
		smelting(BlockRegistry.MARS_STONE.get(), BlockRegistry.MARS_SMOOTH_STONE.get(), 0.1F, 200, BlockRegistry.MARS_STONE.get(), consumer);
		ShapedRecipeBuilder.shaped(BlockRegistry.MARS_SMOOTH_STONE_SLAB.get(), 6).pattern("XXX").define('X', BlockRegistry.MARS_SMOOTH_STONE.get()).group(modGroup()).unlockedBy("has_mars_smooth_stone", has(BlockRegistry.MARS_STONE.get())).save(consumer);
		stonecutting(BlockRegistry.MARS_SMOOTH_STONE.get(), BlockRegistry.MARS_SMOOTH_STONE_SLAB.get(), 2, BlockRegistry.MARS_SMOOTH_STONE.get(), consumer);
		singleItem(BlockRegistry.MARS_STONE.get(), BlockRegistry.MARS_STONE_BUTTON.get(), 1, BlockRegistry.MARS_STONE.get(), consumer);
		ShapedRecipeBuilder.shaped(BlockRegistry.MARS_STONE_PRESSURE_PLATE.get()).pattern("XX").define('X', BlockRegistry.MARS_STONE.get()).group(modGroup()).unlockedBy("mars_stone", has(BlockRegistry.MARS_STONE.get())).save(consumer);
		singleItem(BlockRegistry.MARS_DEEPSLATE.get(), BlockRegistry.MARS_DEEPSLATE_BUTTON.get(), 1, BlockRegistry.MARS_STONE.get(), consumer);
		ShapedRecipeBuilder.shaped(BlockRegistry.MARS_DEEPSLATE_PRESSURE_PLATE.get()).pattern("XX").define('X', BlockRegistry.MARS_DEEPSLATE.get()).group(modGroup()).unlockedBy("mars_deepslate", has(BlockRegistry.MARS_DEEPSLATE.get())).save(consumer);
		ingotAndBlock(BlockRegistry.MARS_COBBLESTONE.get(), BlockRegistry.COMPRESSED_MARS_COBBLESTONE.get(), BlockRegistry.MARS_COBBLESTONE.get(), consumer);
		ingotAndBlock(BlockRegistry.COMPRESSED_MARS_COBBLESTONE.get(), BlockRegistry.SUPER_COMPRESSED_MARS_COBBLESTONE.get(), BlockRegistry.COMPRESSED_MARS_COBBLESTONE.get(), consumer);

		//DEEPSLATE
		stairsSlabWallCraftStonecutting(BlockRegistry.MARS_COBBLED_DEEPSLATE.get(), BlockRegistry.MARS_COBBLED_DEEPSLATE_STAIRS.get(), BlockRegistry.MARS_COBBLED_DEEPSLATE_SLAB.get(), BlockRegistry.MARS_COBBLED_DEEPSLATE_WALL.get(), BlockRegistry.MARS_COBBLED_DEEPSLATE.get(), consumer);
		deepslateBricks(BlockRegistry.MARS_COBBLED_DEEPSLATE.get(), BlockRegistry.MARS_POLISHED_DEEPSLATE.get(), BlockRegistry.MARS_DEEPSLATE_BRICKS.get(), BlockRegistry.MARS_DEEPSLATE_BRICK_STAIRS.get(), BlockRegistry.MARS_DEEPSLATE_BRICK_SLAB.get(), BlockRegistry.MARS_DEEPSLATE_BRICK_WALL.get(), BlockRegistry.MARS_COBBLED_DEEPSLATE.get(), consumer);
		deepslateTiles(BlockRegistry.MARS_COBBLED_DEEPSLATE.get(), BlockRegistry.MARS_POLISHED_DEEPSLATE.get(), BlockRegistry.MARS_DEEPSLATE_BRICKS.get(), BlockRegistry.MARS_DEEPSLATE_TILES.get(), BlockRegistry.MARS_DEEPSLATE_TILE_STAIRS.get(), BlockRegistry.MARS_DEEPSLATE_TILE_SLAB.get(), BlockRegistry.MARS_DEEPSLATE_TILE_WALL.get(), BlockRegistry.MARS_COBBLED_DEEPSLATE.get(), consumer);
		polishedDeepslate(BlockRegistry.MARS_COBBLED_DEEPSLATE.get(), BlockRegistry.MARS_POLISHED_DEEPSLATE.get(), BlockRegistry.MARS_POLISHED_DEEPSLATE_STAIRS.get(), BlockRegistry.MARS_POLISHED_DEEPSLATE_SLAB.get(), BlockRegistry.MARS_POLISHED_DEEPSLATE_WALL.get(), BlockRegistry.MARS_COBBLED_DEEPSLATE.get(), consumer);
		ShapedRecipeBuilder.shaped(BlockRegistry.CHISELED_MARS_DEEPSLATE_BRICKS.get()).pattern("X").pattern("X").define('X', BlockRegistry.MARS_COBBLED_DEEPSLATE_SLAB.get()).group(modGroup()).unlockedBy("has_mars_cobbled_deepslate", has(BlockRegistry.MARS_COBBLED_DEEPSLATE.get())).save(consumer);
		stonecutting(TagRegistry.Items.MARS_COBBLED_DEEPSLATE, BlockRegistry.CHISELED_MARS_DEEPSLATE_BRICKS.get(), 1, BlockRegistry.MARS_COBBLED_DEEPSLATE.get(), consumer);
		smelting(BlockRegistry.MARS_DEEPSLATE_BRICKS.get(), BlockRegistry.CRACKED_MARS_DEEPSLATE_BRICKS.get(), 0.1F, 200, BlockRegistry.MARS_DEEPSLATE_BRICKS.get(), consumer);
		smelting(BlockRegistry.MARS_DEEPSLATE_TILES.get(), BlockRegistry.CRACKED_MARS_DEEPSLATE_TILES.get(), 0.1F, 200, BlockRegistry.MARS_DEEPSLATE_TILES.get(), consumer);
		ingotAndBlock(BlockRegistry.MARS_COBBLED_DEEPSLATE.get(), BlockRegistry.COMPRESSED_MARS_COBBLED_DEEPSLATE.get(), BlockRegistry.MARS_COBBLED_DEEPSLATE.get(), consumer);
		ingotAndBlock(BlockRegistry.COMPRESSED_MARS_COBBLED_DEEPSLATE.get(), BlockRegistry.SUPER_COMPRESSED_MARS_COBBLED_DEEPSLATE.get(), BlockRegistry.COMPRESSED_MARS_COBBLED_DEEPSLATE.get(), consumer);

		smelting(BlockRegistry.MARS_SAND.get(), Items.ORANGE_STAINED_GLASS, 0.1F, 200, BlockRegistry.MARS_SAND.get(), consumer);
		ShapedRecipeBuilder.shaped(BlockRegistry.MARS_LANTERN.get()).pattern("XCX").pattern("C#C").pattern("XCX").define('X', BlockRegistry.MARS_STONE.get()).define('C', Items.IRON_INGOT).define('#', Items.TORCH).group(modGroup()).unlockedBy("has_iron", has(Items.IRON_INGOT)).save(consumer);

		//---- VENUS -------------------------------------------------------------------------------
		//STONE
		bricksCraftAndStonecutting(BlockRegistry.VENUS_STONE.get(), BlockRegistry.VENUS_BRICKS.get(), BlockRegistry.VENUS_STONE.get(), consumer);
		stairsSlabWallCraftStonecutting(BlockRegistry.VENUS_BRICKS.get(), TagRegistry.Items.VENUS_STONE, BlockRegistry.VENUS_BRICK_STAIRS.get(), BlockRegistry.VENUS_BRICK_SLAB.get(), BlockRegistry.VENUS_BRICK_WALL.get(), BlockRegistry.VENUS_STONE.get(), consumer);
		ShapedRecipeBuilder.shaped(BlockRegistry.CHISELED_VENUS_BRICKS.get()).pattern("X").pattern("X").define('X', BlockRegistry.VENUS_BRICK_SLAB.get()).group(modGroup()).unlockedBy("venus_stone", has(BlockRegistry.VENUS_STONE.get())).save(consumer);
		stonecutting(BlockRegistry.VENUS_STONE.get(), BlockRegistry.CHISELED_VENUS_BRICKS.get(), 1, BlockRegistry.VENUS_BRICKS.get(), consumer);
		smelting(BlockRegistry.VENUS_BRICKS.get(), BlockRegistry.CRACKED_VENUS_BRICKS.get(), 0.1F, 200, BlockRegistry.VENUS_BRICKS.get(), consumer);

		ShapedRecipeBuilder.shaped(BlockRegistry.VENUS_BRICK_PILLAR.get(), 4).pattern("X").pattern("X").define('X', BlockRegistry.VENUS_BRICKS.get()).group(modGroup()).unlockedBy("venus_stone", has(BlockRegistry.VENUS_STONE.get())).save(consumer);

		stonecutting(BlockRegistry.VENUS_BRICKS.get(), BlockRegistry.SMALL_VENUS_BRICKS.get(), 1, BlockRegistry.VENUS_COBBLESTONE.get(), consumer);
		stairsSlabWallCraftStonecutting(BlockRegistry.SMALL_VENUS_BRICKS.get(), BlockRegistry.SMALL_VENUS_BRICK_STAIRS.get(), BlockRegistry.SMALL_VENUS_BRICK_SLAB.get(), BlockRegistry.SMALL_VENUS_BRICK_WALL.get(), BlockRegistry.VENUS_COBBLESTONE.get(), consumer);

		stonecutting(BlockRegistry.VENUS_STONE.get(), BlockRegistry.VENUS_BRICK_PILLAR.get(), 1, BlockRegistry.VENUS_STONE.get(), consumer);
		smelting(BlockRegistry.VENUS_COBBLESTONE.get(), BlockRegistry.VENUS_STONE.get(), 0.1F, 200, BlockRegistry.VENUS_COBBLESTONE.get(), consumer);
		smelting(BlockRegistry.VENUS_COBBLED_DEEPSLATE.get(), BlockRegistry.VENUS_DEEPSLATE.get(), 0.1F, 200, BlockRegistry.VENUS_COBBLED_DEEPSLATE.get(), consumer);
		stairsCraftAndStonecutting(BlockRegistry.VENUS_STONE.get(), BlockRegistry.VENUS_STONE_STAIRS.get(), BlockRegistry.VENUS_STONE.get(), consumer);
		slabCraftAndStonecutting(BlockRegistry.VENUS_STONE.get(), BlockRegistry.VENUS_STONE_SLAB.get(), BlockRegistry.VENUS_STONE.get(), consumer);
		stairsSlabWallCraftStonecutting(BlockRegistry.VENUS_COBBLESTONE.get(), TagRegistry.Items.VENUS_COBBLESTONE, BlockRegistry.VENUS_COBBLESTONE_STAIRS.get(), BlockRegistry.VENUS_COBBLESTONE_SLAB.get(), BlockRegistry.VENUS_COBBLESTONE_WALL.get(), BlockRegistry.VENUS_COBBLESTONE.get(), consumer);
		smelting(BlockRegistry.VENUS_STONE.get(), BlockRegistry.VENUS_SMOOTH_STONE.get(), 0.1F, 200, BlockRegistry.VENUS_STONE.get(), consumer);
		ShapedRecipeBuilder.shaped(BlockRegistry.VENUS_SMOOTH_STONE_SLAB.get(), 6).pattern("XXX").define('X', BlockRegistry.VENUS_SMOOTH_STONE.get()).group(modGroup()).unlockedBy("has_venus_smooth_stone", has(BlockRegistry.VENUS_STONE.get())).save(consumer);
		stonecutting(BlockRegistry.VENUS_SMOOTH_STONE.get(), BlockRegistry.VENUS_SMOOTH_STONE_SLAB.get(), 2, BlockRegistry.VENUS_SMOOTH_STONE.get(), consumer);
		singleItem(BlockRegistry.VENUS_STONE.get(), BlockRegistry.VENUS_STONE_BUTTON.get(), 1, BlockRegistry.VENUS_STONE.get(), consumer);
		ShapedRecipeBuilder.shaped(BlockRegistry.VENUS_STONE_PRESSURE_PLATE.get()).pattern("XX").define('X', BlockRegistry.VENUS_STONE.get()).group(modGroup()).unlockedBy("venus_stone", has(BlockRegistry.VENUS_STONE.get())).save(consumer);
		singleItem(BlockRegistry.VENUS_DEEPSLATE.get(), BlockRegistry.VENUS_DEEPSLATE_BUTTON.get(), 1, BlockRegistry.VENUS_STONE.get(), consumer);
		ShapedRecipeBuilder.shaped(BlockRegistry.VENUS_DEEPSLATE_PRESSURE_PLATE.get()).pattern("XX").define('X', BlockRegistry.VENUS_DEEPSLATE.get()).group(modGroup()).unlockedBy("venus_deepslate", has(BlockRegistry.VENUS_DEEPSLATE.get())).save(consumer);
		ingotAndBlock(BlockRegistry.VENUS_COBBLESTONE.get(), BlockRegistry.COMPRESSED_VENUS_COBBLESTONE.get(), BlockRegistry.VENUS_COBBLESTONE.get(), consumer);
		ingotAndBlock(BlockRegistry.COMPRESSED_VENUS_COBBLESTONE.get(), BlockRegistry.SUPER_COMPRESSED_VENUS_COBBLESTONE.get(), BlockRegistry.COMPRESSED_VENUS_COBBLESTONE.get(), consumer);

		//DEEPSLATE
		stairsSlabWallCraftStonecutting(BlockRegistry.VENUS_COBBLED_DEEPSLATE.get(), BlockRegistry.VENUS_COBBLED_DEEPSLATE_STAIRS.get(), BlockRegistry.VENUS_COBBLED_DEEPSLATE_SLAB.get(), BlockRegistry.VENUS_COBBLED_DEEPSLATE_WALL.get(), BlockRegistry.VENUS_COBBLED_DEEPSLATE.get(), consumer);
		deepslateBricks(BlockRegistry.VENUS_COBBLED_DEEPSLATE.get(), BlockRegistry.VENUS_POLISHED_DEEPSLATE.get(), BlockRegistry.VENUS_DEEPSLATE_BRICKS.get(), BlockRegistry.VENUS_DEEPSLATE_BRICK_STAIRS.get(), BlockRegistry.VENUS_DEEPSLATE_BRICK_SLAB.get(), BlockRegistry.VENUS_DEEPSLATE_BRICK_WALL.get(), BlockRegistry.VENUS_COBBLED_DEEPSLATE.get(), consumer);
		deepslateTiles(BlockRegistry.VENUS_COBBLED_DEEPSLATE.get(), BlockRegistry.VENUS_POLISHED_DEEPSLATE.get(), BlockRegistry.VENUS_DEEPSLATE_BRICKS.get(), BlockRegistry.VENUS_DEEPSLATE_TILES.get(), BlockRegistry.VENUS_DEEPSLATE_TILE_STAIRS.get(), BlockRegistry.VENUS_DEEPSLATE_TILE_SLAB.get(), BlockRegistry.VENUS_DEEPSLATE_TILE_WALL.get(), BlockRegistry.VENUS_COBBLED_DEEPSLATE.get(), consumer);
		polishedDeepslate(BlockRegistry.VENUS_COBBLED_DEEPSLATE.get(), BlockRegistry.VENUS_POLISHED_DEEPSLATE.get(), BlockRegistry.VENUS_POLISHED_DEEPSLATE_STAIRS.get(), BlockRegistry.VENUS_POLISHED_DEEPSLATE_SLAB.get(), BlockRegistry.VENUS_POLISHED_DEEPSLATE_WALL.get(), BlockRegistry.VENUS_COBBLED_DEEPSLATE.get(), consumer);
		ShapedRecipeBuilder.shaped(BlockRegistry.CHISELED_VENUS_DEEPSLATE_BRICKS.get()).pattern("X").pattern("X").define('X', BlockRegistry.VENUS_COBBLED_DEEPSLATE_SLAB.get()).group(modGroup()).unlockedBy("has_venus_cobbled_deepslate", has(BlockRegistry.VENUS_COBBLED_DEEPSLATE.get())).save(consumer);
		stonecutting(TagRegistry.Items.VENUS_COBBLED_DEEPSLATE, BlockRegistry.CHISELED_VENUS_DEEPSLATE_BRICKS.get(), 1, BlockRegistry.VENUS_COBBLED_DEEPSLATE.get(), consumer);
		smelting(BlockRegistry.VENUS_DEEPSLATE_BRICKS.get(), BlockRegistry.CRACKED_VENUS_DEEPSLATE_BRICKS.get(), 0.1F, 200, BlockRegistry.VENUS_DEEPSLATE_BRICKS.get(), consumer);
		smelting(BlockRegistry.VENUS_DEEPSLATE_TILES.get(), BlockRegistry.CRACKED_VENUS_DEEPSLATE_TILES.get(), 0.1F, 200, BlockRegistry.VENUS_DEEPSLATE_TILES.get(), consumer);
		ingotAndBlock(BlockRegistry.VENUS_COBBLED_DEEPSLATE.get(), BlockRegistry.COMPRESSED_VENUS_COBBLED_DEEPSLATE.get(), BlockRegistry.VENUS_COBBLED_DEEPSLATE.get(), consumer);
		ingotAndBlock(BlockRegistry.COMPRESSED_VENUS_COBBLED_DEEPSLATE.get(), BlockRegistry.SUPER_COMPRESSED_VENUS_COBBLED_DEEPSLATE.get(), BlockRegistry.COMPRESSED_VENUS_COBBLED_DEEPSLATE.get(), consumer);

		smelting(BlockRegistry.VENUS_SAND.get(), Items.YELLOW_STAINED_GLASS, 0.1F, 200, BlockRegistry.VENUS_SAND.get(), consumer);
		ShapedRecipeBuilder.shaped(BlockRegistry.VENUS_LANTERN.get()).pattern("XCX").pattern("C#C").pattern("XCX").define('X', BlockRegistry.VENUS_STONE.get()).define('#', Items.IRON_INGOT).define('C', ItemRegistry.SULFUR_CRYSTAL.get()).group(modGroup()).unlockedBy("has_sulfur_crystal", has(ItemRegistry.SULFUR_CRYSTAL.get())).save(consumer);

		//---- METEOR -------------------------------------------------------------------------------
		ShapedRecipeBuilder.shaped(BlockRegistry.METEOR_BRICKS.get(), 4).pattern("XX").pattern("XX").define('X', BlockRegistry.METEOR.get()).group(modGroup()).unlockedBy("meteor", has(BlockRegistry.METEOR.get())).save(consumer);
		SingleItemRecipeBuilder.stonecutting(Ingredient.of(TagRegistry.Items.METEOR), BlockRegistry.METEOR_BRICKS.get(), 1).unlockedBy("meteor", has(BlockRegistry.METEOR.get())).save(consumer, "meteor_bricks_stonecutting");
		ShapedRecipeBuilder.shaped(BlockRegistry.METEOR_BRICK_SLAB.get(), 6).pattern("XXX").define('X', BlockRegistry.METEOR_BRICKS.get()).group(modGroup()).unlockedBy("meteor", has(BlockRegistry.METEOR.get())).save(consumer);
		SingleItemRecipeBuilder.stonecutting(Ingredient.of(TagRegistry.Items.METEOR), BlockRegistry.METEOR_BRICK_SLAB.get(), 2).unlockedBy("meteor", has(BlockRegistry.METEOR.get())).save(consumer, "meteor_brick_slab_stonecutting");
		ShapedRecipeBuilder.shaped(BlockRegistry.METEOR_BRICK_STAIRS.get(), 4).pattern("X  ").pattern("XX ").pattern("XXX").define('X', BlockRegistry.METEOR_BRICKS.get()).group(modGroup()).unlockedBy("meteor", has(BlockRegistry.METEOR.get())).save(consumer);
		SingleItemRecipeBuilder.stonecutting(Ingredient.of(TagRegistry.Items.METEOR), BlockRegistry.METEOR_BRICK_STAIRS.get(), 1).unlockedBy("meteor", has(BlockRegistry.METEOR.get())).save(consumer, "meteor_brick_stairs_stonecutting");
		ShapedRecipeBuilder.shaped(BlockRegistry.METEOR_BRICK_WALL.get(), 6).pattern("XXX").pattern("XXX").define('X', BlockRegistry.METEOR_BRICKS.get()).group(modGroup()).unlockedBy("meteor", has(BlockRegistry.METEOR.get())).save(consumer);
		SingleItemRecipeBuilder.stonecutting(Ingredient.of(TagRegistry.Items.METEOR), BlockRegistry.METEOR_BRICK_WALL.get(), 1).unlockedBy("meteor", has(BlockRegistry.METEOR.get())).save(consumer, "meteor_brick_wall_stonecutting");
		ShapedRecipeBuilder.shaped(BlockRegistry.CHISELED_METEOR_BRICKS.get()).pattern("X").pattern("X").define('X', BlockRegistry.METEOR_BRICK_SLAB.get()).group(modGroup()).unlockedBy("meteor", has(BlockRegistry.METEOR.get())).save(consumer);
		SingleItemRecipeBuilder.stonecutting(Ingredient.of(TagRegistry.Items.METEOR), BlockRegistry.CHISELED_METEOR_BRICKS.get(), 1).unlockedBy("meteor", has(BlockRegistry.METEOR_BRICKS.get())).save(consumer, "chiseled_meteor_bricks_stonecutting");
		ShapelessRecipeBuilder.shapeless(BlockRegistry.METEOR_BUTTON.get()).requires(BlockRegistry.METEOR.get()).group(modGroup()).unlockedBy("meteor", has(BlockRegistry.METEOR.get())).save(consumer);
		ShapedRecipeBuilder.shaped(BlockRegistry.METEOR_PRESSURE_PLATE.get()).pattern("XX").define('X', BlockRegistry.METEOR.get()).group(modGroup()).unlockedBy("meteor", has(BlockRegistry.METEOR.get())).save(consumer);

		//---- MERCURY -------------------------------------------------------------------------------
		//STONE
		bricksCraftAndStonecutting(BlockRegistry.MERCURY_STONE.get(), BlockRegistry.MERCURY_BRICKS.get(), BlockRegistry.MERCURY_STONE.get(), consumer);
		stairsSlabWallCraftStonecutting(BlockRegistry.MERCURY_BRICKS.get(), TagRegistry.Items.MERCURY_STONE, BlockRegistry.MERCURY_BRICK_STAIRS.get(), BlockRegistry.MERCURY_BRICK_SLAB.get(), BlockRegistry.MERCURY_BRICK_WALL.get(), BlockRegistry.MERCURY_STONE.get(), consumer);
		ShapedRecipeBuilder.shaped(BlockRegistry.CHISELED_MERCURY_BRICKS.get()).pattern("X").pattern("X").define('X', BlockRegistry.MERCURY_BRICK_SLAB.get()).group(modGroup()).unlockedBy("mercury_stone", has(BlockRegistry.MERCURY_STONE.get())).save(consumer);
		smelting(BlockRegistry.MERCURY_BRICKS.get(), BlockRegistry.CRACKED_MERCURY_BRICKS.get(), 0.1F, 200, BlockRegistry.MERCURY_BRICKS.get(), consumer);

		stonecutting(BlockRegistry.MERCURY_STONE.get(), BlockRegistry.CHISELED_MERCURY_BRICKS.get(), 1, BlockRegistry.MERCURY_BRICKS.get(), consumer);
		ShapedRecipeBuilder.shaped(BlockRegistry.MERCURY_BRICK_PILLAR.get(), 4).pattern("X").pattern("X").define('X', BlockRegistry.MERCURY_BRICKS.get()).group(modGroup()).unlockedBy("mercury_stone", has(BlockRegistry.MERCURY_STONE.get())).save(consumer);
		stonecutting(BlockRegistry.MERCURY_STONE.get(), BlockRegistry.MERCURY_BRICK_PILLAR.get(), 1, BlockRegistry.MERCURY_STONE.get(), consumer);
		smelting(BlockRegistry.MERCURY_COBBLESTONE.get(), BlockRegistry.MERCURY_STONE.get(), 0.1F, 200, BlockRegistry.MERCURY_COBBLESTONE.get(), consumer);
		smelting(BlockRegistry.MERCURY_COBBLED_DEEPSLATE.get(), BlockRegistry.MERCURY_DEEPSLATE.get(), 0.1F, 200, BlockRegistry.MERCURY_COBBLED_DEEPSLATE.get(), consumer);
		stairsCraftAndStonecutting(BlockRegistry.MERCURY_STONE.get(), BlockRegistry.MERCURY_STONE_STAIRS.get(), BlockRegistry.MERCURY_STONE.get(), consumer);
		slabCraftAndStonecutting(BlockRegistry.MERCURY_STONE.get(), BlockRegistry.MERCURY_STONE_SLAB.get(), BlockRegistry.MERCURY_STONE.get(), consumer);
		stairsSlabWallCraftStonecutting(BlockRegistry.MERCURY_COBBLESTONE.get(), TagRegistry.Items.MERCURY_COBBLESTONE, BlockRegistry.MERCURY_COBBLESTONE_STAIRS.get(), BlockRegistry.MERCURY_COBBLESTONE_SLAB.get(), BlockRegistry.MERCURY_COBBLESTONE_WALL.get(), BlockRegistry.MERCURY_COBBLESTONE.get(), consumer);
		smelting(BlockRegistry.MERCURY_STONE.get(), BlockRegistry.MERCURY_SMOOTH_STONE.get(), 0.1F, 200, BlockRegistry.MERCURY_STONE.get(), consumer);
		ShapedRecipeBuilder.shaped(BlockRegistry.MERCURY_SMOOTH_STONE_SLAB.get(), 6).pattern("XXX").define('X', BlockRegistry.MERCURY_SMOOTH_STONE.get()).group(modGroup()).unlockedBy("has_mercury_smooth_stone", has(BlockRegistry.MERCURY_STONE.get())).save(consumer);
		stonecutting(BlockRegistry.MERCURY_SMOOTH_STONE.get(), BlockRegistry.MERCURY_SMOOTH_STONE_SLAB.get(), 2, BlockRegistry.MERCURY_SMOOTH_STONE.get(), consumer);
		singleItem(BlockRegistry.MERCURY_STONE.get(), BlockRegistry.MERCURY_STONE_BUTTON.get(), 1, BlockRegistry.MERCURY_STONE.get(), consumer);
		ShapedRecipeBuilder.shaped(BlockRegistry.MERCURY_STONE_PRESSURE_PLATE.get()).pattern("XX").define('X', BlockRegistry.MERCURY_STONE.get()).group(modGroup()).unlockedBy("mercury_stone", has(BlockRegistry.MERCURY_STONE.get())).save(consumer);
		singleItem(BlockRegistry.MERCURY_DEEPSLATE.get(), BlockRegistry.MERCURY_DEEPSLATE_BUTTON.get(), 1, BlockRegistry.MERCURY_STONE.get(), consumer);
		ShapedRecipeBuilder.shaped(BlockRegistry.MERCURY_DEEPSLATE_PRESSURE_PLATE.get()).pattern("XX").define('X', BlockRegistry.MERCURY_DEEPSLATE.get()).group(modGroup()).unlockedBy("mercury_deepslate", has(BlockRegistry.MERCURY_DEEPSLATE.get())).save(consumer);
		ingotAndBlock(BlockRegistry.MERCURY_COBBLESTONE.get(), BlockRegistry.COMPRESSED_MERCURY_COBBLESTONE.get(), BlockRegistry.MERCURY_COBBLESTONE.get(), consumer);
		ingotAndBlock(BlockRegistry.COMPRESSED_MERCURY_COBBLESTONE.get(), BlockRegistry.SUPER_COMPRESSED_MERCURY_COBBLESTONE.get(), BlockRegistry.COMPRESSED_MERCURY_COBBLESTONE.get(), consumer);

		//DEEPSLATE
		stairsSlabWallCraftStonecutting(BlockRegistry.MERCURY_COBBLED_DEEPSLATE.get(), BlockRegistry.MERCURY_COBBLED_DEEPSLATE_STAIRS.get(), BlockRegistry.MERCURY_COBBLED_DEEPSLATE_SLAB.get(), BlockRegistry.MERCURY_COBBLED_DEEPSLATE_WALL.get(), BlockRegistry.MERCURY_COBBLED_DEEPSLATE.get(), consumer);
		deepslateBricks(BlockRegistry.MERCURY_COBBLED_DEEPSLATE.get(), BlockRegistry.MERCURY_POLISHED_DEEPSLATE.get(), BlockRegistry.MERCURY_DEEPSLATE_BRICKS.get(), BlockRegistry.MERCURY_DEEPSLATE_BRICK_STAIRS.get(), BlockRegistry.MERCURY_DEEPSLATE_BRICK_SLAB.get(), BlockRegistry.MERCURY_DEEPSLATE_BRICK_WALL.get(), BlockRegistry.MERCURY_COBBLED_DEEPSLATE.get(), consumer);
		deepslateTiles(BlockRegistry.MERCURY_COBBLED_DEEPSLATE.get(), BlockRegistry.MERCURY_POLISHED_DEEPSLATE.get(), BlockRegistry.MERCURY_DEEPSLATE_BRICKS.get(), BlockRegistry.MERCURY_DEEPSLATE_TILES.get(), BlockRegistry.MERCURY_DEEPSLATE_TILE_STAIRS.get(), BlockRegistry.MERCURY_DEEPSLATE_TILE_SLAB.get(), BlockRegistry.MERCURY_DEEPSLATE_TILE_WALL.get(), BlockRegistry.MERCURY_COBBLED_DEEPSLATE.get(), consumer);
		polishedDeepslate(BlockRegistry.MERCURY_COBBLED_DEEPSLATE.get(), BlockRegistry.MERCURY_POLISHED_DEEPSLATE.get(), BlockRegistry.MERCURY_POLISHED_DEEPSLATE_STAIRS.get(), BlockRegistry.MERCURY_POLISHED_DEEPSLATE_SLAB.get(), BlockRegistry.MERCURY_POLISHED_DEEPSLATE_WALL.get(), BlockRegistry.MERCURY_COBBLED_DEEPSLATE.get(), consumer);
		ShapedRecipeBuilder.shaped(BlockRegistry.CHISELED_MERCURY_DEEPSLATE_BRICKS.get()).pattern("X").pattern("X").define('X', BlockRegistry.MERCURY_COBBLED_DEEPSLATE_SLAB.get()).group(modGroup()).unlockedBy("has_mercury_cobbled_deepslate", has(BlockRegistry.MERCURY_COBBLED_DEEPSLATE.get())).save(consumer);
		stonecutting(TagRegistry.Items.MERCURY_COBBLED_DEEPSLATE, BlockRegistry.CHISELED_MERCURY_DEEPSLATE_BRICKS.get(), 1, BlockRegistry.MERCURY_COBBLED_DEEPSLATE.get(), consumer);
		smelting(BlockRegistry.MERCURY_DEEPSLATE_BRICKS.get(), BlockRegistry.CRACKED_MERCURY_DEEPSLATE_BRICKS.get(), 0.1F, 200, BlockRegistry.MERCURY_DEEPSLATE_BRICKS.get(), consumer);
		smelting(BlockRegistry.MERCURY_DEEPSLATE_TILES.get(), BlockRegistry.CRACKED_MERCURY_DEEPSLATE_TILES.get(), 0.1F, 200, BlockRegistry.MERCURY_DEEPSLATE_TILES.get(), consumer);
		ingotAndBlock(BlockRegistry.MERCURY_COBBLED_DEEPSLATE.get(), BlockRegistry.COMPRESSED_MERCURY_COBBLED_DEEPSLATE.get(), BlockRegistry.MERCURY_COBBLED_DEEPSLATE.get(), consumer);
		ingotAndBlock(BlockRegistry.COMPRESSED_MERCURY_COBBLED_DEEPSLATE.get(), BlockRegistry.SUPER_COMPRESSED_MERCURY_COBBLED_DEEPSLATE.get(), BlockRegistry.COMPRESSED_MERCURY_COBBLED_DEEPSLATE.get(), consumer);

		//OTHER
		smelting(BlockRegistry.MERCURY_SAND.get(), Items.BROWN_STAINED_GLASS, 0.1F, 200, BlockRegistry.MERCURY_SAND.get(), consumer);
		ShapedRecipeBuilder.shaped(BlockRegistry.MERCURY_LANTERN.get()).pattern("XCX").pattern("C#C").pattern("XCX").define('X', ItemRegistry.CINNABAR.get()).define('C', Items.IRON_INGOT).define('#', Items.TORCH).group(modGroup()).unlockedBy("has_cinnabar", has(ItemRegistry.CINNABAR.get())).save(consumer);

		//---- JUPITER -------------------------------------------------------------------------------

		//DEEPSLATE
		stairsSlabWallCraftStonecutting(BlockRegistry.JUPITER_COBBLED_DEEPSLATE.get(), BlockRegistry.JUPITER_COBBLED_DEEPSLATE_STAIRS.get(), BlockRegistry.JUPITER_COBBLED_DEEPSLATE_SLAB.get(), BlockRegistry.JUPITER_COBBLED_DEEPSLATE_WALL.get(), BlockRegistry.JUPITER_COBBLED_DEEPSLATE.get(), consumer);
		deepslateBricks(BlockRegistry.JUPITER_COBBLED_DEEPSLATE.get(), BlockRegistry.JUPITER_POLISHED_DEEPSLATE.get(), BlockRegistry.JUPITER_DEEPSLATE_BRICKS.get(), BlockRegistry.JUPITER_DEEPSLATE_BRICK_STAIRS.get(), BlockRegistry.JUPITER_DEEPSLATE_BRICK_SLAB.get(), BlockRegistry.JUPITER_DEEPSLATE_BRICK_WALL.get(), BlockRegistry.JUPITER_COBBLED_DEEPSLATE.get(), consumer);
		deepslateTiles(BlockRegistry.JUPITER_COBBLED_DEEPSLATE.get(), BlockRegistry.JUPITER_POLISHED_DEEPSLATE.get(), BlockRegistry.JUPITER_DEEPSLATE_BRICKS.get(), BlockRegistry.JUPITER_DEEPSLATE_TILES.get(), BlockRegistry.JUPITER_DEEPSLATE_TILE_STAIRS.get(), BlockRegistry.JUPITER_DEEPSLATE_TILE_SLAB.get(), BlockRegistry.JUPITER_DEEPSLATE_TILE_WALL.get(), BlockRegistry.JUPITER_COBBLED_DEEPSLATE.get(), consumer);
		polishedDeepslate(BlockRegistry.JUPITER_COBBLED_DEEPSLATE.get(), BlockRegistry.JUPITER_POLISHED_DEEPSLATE.get(), BlockRegistry.JUPITER_POLISHED_DEEPSLATE_STAIRS.get(), BlockRegistry.JUPITER_POLISHED_DEEPSLATE_SLAB.get(), BlockRegistry.JUPITER_POLISHED_DEEPSLATE_WALL.get(), BlockRegistry.JUPITER_COBBLED_DEEPSLATE.get(), consumer);
		ShapedRecipeBuilder.shaped(BlockRegistry.CHISELED_JUPITER_DEEPSLATE_BRICKS.get()).pattern("X").pattern("X").define('X', BlockRegistry.JUPITER_COBBLED_DEEPSLATE_SLAB.get()).group(modGroup()).unlockedBy("has_jupiter_cobbled_deepslate", has(BlockRegistry.JUPITER_COBBLED_DEEPSLATE.get())).save(consumer);
		stonecutting(TagRegistry.Items.JUPITER_COBBLED_DEEPSLATE, BlockRegistry.CHISELED_JUPITER_DEEPSLATE_BRICKS.get(), 1, BlockRegistry.JUPITER_COBBLED_DEEPSLATE.get(), consumer);
		smelting(BlockRegistry.JUPITER_DEEPSLATE_BRICKS.get(), BlockRegistry.CRACKED_JUPITER_DEEPSLATE_BRICKS.get(), 0.1F, 200, BlockRegistry.JUPITER_DEEPSLATE_BRICKS.get(), consumer);
		smelting(BlockRegistry.JUPITER_DEEPSLATE_TILES.get(), BlockRegistry.CRACKED_JUPITER_DEEPSLATE_TILES.get(), 0.1F, 200, BlockRegistry.JUPITER_DEEPSLATE_TILES.get(), consumer);
		ingotAndBlock(BlockRegistry.JUPITER_COBBLED_DEEPSLATE.get(), BlockRegistry.COMPRESSED_JUPITER_COBBLED_DEEPSLATE.get(), BlockRegistry.JUPITER_COBBLED_DEEPSLATE.get(), consumer);
		ingotAndBlock(BlockRegistry.COMPRESSED_JUPITER_COBBLED_DEEPSLATE.get(), BlockRegistry.SUPER_COMPRESSED_JUPITER_COBBLED_DEEPSLATE.get(), BlockRegistry.COMPRESSED_JUPITER_COBBLED_DEEPSLATE.get(), consumer);
		smelting(BlockRegistry.JUPITER_COBBLED_DEEPSLATE.get(), BlockRegistry.JUPITER_DEEPSLATE.get(), 0.1F, 200, BlockRegistry.JUPITER_COBBLED_DEEPSLATE.get(), consumer);
		singleItem(BlockRegistry.JUPITER_DEEPSLATE.get(), BlockRegistry.JUPITER_DEEPSLATE_BUTTON.get(), 1, BlockRegistry.JUPITER_DEEPSLATE.get(), consumer);
		ShapedRecipeBuilder.shaped(BlockRegistry.JUPITER_DEEPSLATE_PRESSURE_PLATE.get()).pattern("XX").define('X', BlockRegistry.JUPITER_DEEPSLATE.get()).group(modGroup()).unlockedBy("jupiter_deepslate", has(BlockRegistry.JUPITER_DEEPSLATE.get())).save(consumer);

		//OTHER
		ShapedRecipeBuilder.shaped(BlockRegistry.JUPITER_LANTERN.get()).pattern("XCX").pattern("C#C").pattern("XCX").define('X', BlockRegistry.JUPITER_ATMOSPHERE.get()).define('C', Items.IRON_INGOT).define('#', Items.TORCH).group(modGroup()).unlockedBy("has_jupiter_deepslate", has(BlockRegistry.JUPITER_LANTERN.get())).save(consumer);

		//---- EUROPA -------------------------------------------------------------------------------
		//STONE
		ShapedRecipeBuilder.shaped(BlockRegistry.EUROPA_BRICKS.get(), 4).pattern("XY").pattern("YX").define('X', BlockRegistry.MOON_STONE.get()).define('Y', BlockRegistry.EUROPA_HYDRATE.get()).group(modGroup()).unlockedBy(name(BlockRegistry.EUROPA_HYDRATE.get()), has(BlockRegistry.EUROPA_HYDRATE.get())).save(consumer);
		stairsSlabWallCraftStonecutting(BlockRegistry.EUROPA_BRICKS.get(), TagRegistry.Items.EUROPA_BRICKS, BlockRegistry.EUROPA_BRICK_STAIRS.get(), BlockRegistry.EUROPA_BRICK_SLAB.get(), BlockRegistry.EUROPA_BRICK_WALL.get(), BlockRegistry.EUROPA_HYDRATE.get(), consumer);

		ShapedRecipeBuilder.shaped(BlockRegistry.EUROPA_LANTERN.get()).pattern("XCX").pattern("C#C").pattern("XCX").define('X', BlockRegistry.MOON_STONE.get()).define('#', Items.IRON_INGOT).define('C', ItemRegistry.EUROPA_DUST.get()).group(modGroup()).unlockedBy("has_europa_dust", has(ItemRegistry.EUROPA_DUST.get())).save(consumer);


		//---- ORES/ALLOYS -------------------------------------------------------------------------------
		//BAUXITE/ALUMINUM
		smeltingAndBlasting(ItemRegistry.RAW_BAUXITE.get(), ItemRegistry.BAUXITE_INGOT.get(), 0.7F, 200, 100, ItemRegistry.RAW_BAUXITE.get(), consumer);
		ShapelessRecipeBuilder.shapeless(ItemRegistry.ALUMINUM_INGOT.get(), 3).requires(Items.IRON_INGOT).requires(ItemRegistry.BAUXITE_INGOT.get()).requires(ItemRegistry.BAUXITE_INGOT.get()).group(modGroup()).unlockedBy("has_raw_bauxite", has(ItemRegistry.RAW_BAUXITE.get())).save(consumer);
		ShapelessRecipeBuilder.shapeless(ItemRegistry.ALUMINUM_INGOT.get(), 3).requires(Items.COPPER_INGOT).requires(ItemRegistry.BAUXITE_INGOT.get()).requires(ItemRegistry.BAUXITE_INGOT.get()).group(modGroup()).unlockedBy("has_raw_bauxite", has(ItemRegistry.RAW_BAUXITE.get())).save(consumer, "aluminum_from_copper");
		ingotAndBlock(ItemRegistry.ALUMINUM_INGOT.get(), BlockRegistry.ALUMINUM_BLOCK.get(), ItemRegistry.ALUMINUM_INGOT.get(), consumer);

		smeltingAndBlasting(TagRegistry.Items.BAUXITE_ORE, ItemRegistry.BAUXITE_INGOT.get(), 0.7F, 200, 100, BlockRegistry.BAUXITE_ORE.get(), consumer);
//		smeltingAndBlasting(BlockRegistry.MARS_BAUXITE_ORE.get(), ItemRegistry.BAUXITE_INGOT.get(), 0.7F, 200, 100, BlockRegistry.MARS_BAUXITE_ORE.get(), consumer);
//		smeltingAndBlasting(BlockRegistry.VENUS_BAUXITE_ORE.get(), ItemRegistry.BAUXITE_INGOT.get(), 0.7F, 200, 100, BlockRegistry.VENUS_BAUXITE_ORE.get(), consumer);
//		smeltingAndBlasting(BlockRegistry.MERCURY_BAUXITE_ORE.get(), ItemRegistry.BAUXITE_INGOT.get(), 0.7F, 200, 100, BlockRegistry.MERCURY_BAUXITE_ORE.get(), consumer);
//		smeltingAndBlasting(BlockRegistry.BAUXITE_ORE.get(), ItemRegistry.BAUXITE_INGOT.get(), 0.7F, 200, 100, BlockRegistry.BAUXITE_ORE.get(), consumer);
//		smeltingAndBlasting(BlockRegistry.METEOR_BAUXITE_ORE.get(), ItemRegistry.BAUXITE_INGOT.get(), 0.7F, 200, 100, BlockRegistry.BAUXITE_ORE.get(), consumer);

		//STEEL
		WorkbenchCraftingRecipeBuilder.shaped(ItemRegistry.STEEL_INGOT.get(), 2, FluidRegistry.MOLTEN_IRON.get(), 0.1111F, 0.7F).pattern("X").define('X', Items.COAL).group(modGroup()).unlockedBy("has_iron", has(Items.IRON_INGOT)).save(consumer, "steel_ingot_from_workbench");
		ingotAndBlock(ItemRegistry.STEEL_INGOT.get(), BlockRegistry.STEEL_BLOCK.get(), ItemRegistry.STEEL_INGOT.get(), consumer);
		ingotAndBlock(ItemRegistry.STEEL_NUGGET.get(), ItemRegistry.STEEL_INGOT.get(), ItemRegistry.STEEL_INGOT.get(), consumer);

		//ASSORTED
		ShapelessRecipeBuilder.shapeless(Items.IRON_NUGGET).requires(ItemRegistry.RUSTED_IRON_NUGGET.get()).group(modGroup()).unlockedBy("rusted_iron_nugget", has(ItemRegistry.RUSTED_IRON_NUGGET.get())).save(consumer, "iron_nugget_from_rusted_iron_nugget");
		SimpleCookingRecipeBuilder.smelting(Ingredient.of(ItemRegistry.RUSTED_IRON_NUGGET.get()), Items.IRON_NUGGET, 1.0F, 30).unlockedBy("has_rusted_iron_nugget", has(ItemRegistry.RUSTED_IRON_NUGGET.get())).group(modGroup()).save(consumer, "smelting_rusted_iron_nugget");
		singleItem(ItemRegistry.CINNABAR.get(), Items.RED_DYE, 1, ItemRegistry.CINNABAR.get(), consumer);

		ShapelessRecipeBuilder.shapeless(ItemRegistry.STEEL_INGOT.get(), 2).requires(Items.COAL).requires(Items.IRON_INGOT).requires(Items.IRON_INGOT).group(modGroup()).unlockedBy("iron", has(Items.IRON_INGOT)).save(consumer, "steel_ingot_crafted");
		ShapedRecipeBuilder.shaped(ItemRegistry.STEEL_ROD.get(), 8).pattern("X").pattern("X").pattern("X").define('X', ItemRegistry.STEEL_INGOT.get()).group(modGroup()).unlockedBy("steel", has(ItemRegistry.STEEL_INGOT.get())).save(consumer);
		ShapedRecipeBuilder.shaped(ItemRegistry.STEEL_WOOL.get(), 4).pattern(" X ").pattern("XSX").pattern(" X ").define('X', ItemRegistry.STEEL_NUGGET.get()).define('S', Items.STRING).group(modGroup()).unlockedBy("steel", has(ItemRegistry.STEEL_INGOT.get())).save(consumer);

//		smeltingAndBlasting(BlockRegistry.MOON_IRON_ORE.get(), Items.IRON_INGOT, 0.7F, 200, 100, BlockRegistry.MOON_IRON_ORE.get(), consumer);
//		smeltingAndBlasting(BlockRegistry.MOON_DEEPSLATE_IRON_ORE.get(), Items.IRON_INGOT, 0.7F, 200, 100, BlockRegistry.MOON_DEEPSLATE_IRON_ORE.get(), consumer);
		smeltingAndBlasting(BlockRegistry.MARS_IRON_ORE.get(), Items.IRON_INGOT, 0.7F, 200, 100, BlockRegistry.MARS_IRON_ORE.get(), consumer);
		smeltingAndBlasting(BlockRegistry.MARS_DEEPSLATE_IRON_ORE.get(), Items.IRON_INGOT, 0.7F, 200, 100, BlockRegistry.MARS_DEEPSLATE_IRON_ORE.get(), consumer);
		smeltingAndBlasting(BlockRegistry.VENUS_IRON_ORE.get(), Items.IRON_INGOT, 0.7F, 200, 100, BlockRegistry.VENUS_IRON_ORE.get(), consumer);
		smeltingAndBlasting(BlockRegistry.VENUS_DEEPSLATE_IRON_ORE.get(), Items.IRON_INGOT, 0.7F, 200, 100, BlockRegistry.VENUS_DEEPSLATE_IRON_ORE.get(), consumer);
		smeltingAndBlasting(BlockRegistry.METEOR_IRON_ORE.get(), Items.IRON_INGOT, 0.7F, 200, 100, BlockRegistry.METEOR_IRON_ORE.get(), consumer);
		smeltingAndBlasting(BlockRegistry.METEOR_GOLD_ORE.get(), Items.GOLD_INGOT, 0.7F, 200, 100, BlockRegistry.METEOR_GOLD_ORE.get(), consumer);
		smeltingAndBlasting(BlockRegistry.METEOR_COPPER_ORE.get(), Items.COPPER_INGOT, 0.7F, 200, 100, BlockRegistry.METEOR_COPPER_ORE.get(), consumer);
		smeltingAndBlasting(BlockRegistry.MERCURY_DEEPSLATE_IRON_ORE.get(), Items.IRON_INGOT, 0.7F, 200, 100, BlockRegistry.MERCURY_DEEPSLATE_IRON_ORE.get(), consumer);

		//---- SPACESHIP -------------------------------------------------------------------------------
		ShapedRecipeBuilder.shaped(BlockRegistry.WORKBENCH.get()).pattern("XXX").pattern("X X").pattern("CCC").define('X', ItemTags.PLANKS).define('C', Blocks.COBBLESTONE).group(modGroup()).unlockedBy("has_cobblestone", has(Blocks.COBBLESTONE)).save(consumer);

		ShapedRecipeBuilder.shaped(ItemRegistry.LOX_TANK.get()).pattern("SsS").pattern("G G").pattern("SsS").define('S', ItemRegistry.STEEL_INGOT.get()).define('s', ItemRegistry.ALUMINUM_INGOT.get()).define('G', Tags.Items.GLASS).group(modGroup()).unlockedBy("steel", has(ItemRegistry.STEEL_INGOT.get())).save(consumer);
		WorkbenchCraftingRecipeBuilder.shaped(ItemRegistry.LOX_TANK.get(), FluidRegistry.MOLTEN_STEEL.get(), 0.444F, 2.8F).pattern("AGA").pattern("G G").pattern("AGA").define('A', ItemRegistry.ALUMINUM_INGOT.get()).define('G', Tags.Items.GLASS).group(modGroup()).unlockedBy("has_iron", has(Items.IRON_INGOT)).save(consumer, "lox_tank_from_workbench");

		ShapedRecipeBuilder.shaped(BlockRegistry.OXYGEN_COMPRESSOR.get()).pattern("SSS").pattern("CGC").pattern("CRC").define('S', ItemRegistry.STEEL_INGOT.get()).define('C', ItemRegistry.ALUMINUM_INGOT.get()).define('G', Tags.Items.GLASS).define('R', Items.REDSTONE).group(modGroup()).unlockedBy("steel_ingot", has(ItemRegistry.STEEL_INGOT.get())).save(consumer);
		WorkbenchCraftingRecipeBuilder.shaped(BlockRegistry.OXYGEN_COMPRESSOR.get(), FluidRegistry.MOLTEN_STEEL.get(), 0.222F, 1.4F).pattern("XXX").pattern("XGX").pattern("XRX").define('X', Tags.Items.COBBLESTONE).define('G', Tags.Items.GLASS).define('R', Items.REDSTONE).group(modGroup()).unlockedBy("has_iron", has(Items.IRON_INGOT)).save(consumer, "oxygen_compressor_from_workbench");

		WorkbenchCraftingRecipeBuilder.shaped(BlockRegistry.STEEL_FRAME.get(), 4, FluidRegistry.MOLTEN_STEEL.get(), 0.222F, 1.4F).pattern("X").define('X', Items.SCAFFOLDING).group(modGroup()).unlockedBy("has_steel", has(ItemRegistry.STEEL_INGOT.get())).save(consumer, "steel_frame_from_workbench");
		WorkbenchCraftingRecipeBuilder.shaped(ItemRegistry.SPACESHIP_FRAME.get(), FluidRegistry.MOLTEN_STEEL.get(), 0.333F, 2.1F).pattern("C C").pattern(" X ").pattern("C C").define('X', BlockRegistry.STEEL_FRAME.get()).define('C', BlockRegistry.CERAMIC_TILE.get()).group(modGroup()).unlockedBy("has_steel", has(ItemRegistry.STEEL_INGOT.get())).save(consumer, "spaceship_frame_from_workbench");
		WorkbenchCraftingRecipeBuilder.shaped(ItemRegistry.SPACESHIP_CABIN.get(), FluidRegistry.MOLTEN_ALUMINUM.get(), 0.444F, 2.8F).pattern(" C ").pattern("CGC").pattern("X X").define('C', BlockRegistry.CERAMIC_TILE.get()).define('G', Tags.Items.GLASS).define('X', Tags.Items.CHESTS).group(modGroup()).unlockedBy("has_steel", has(ItemRegistry.STEEL_INGOT.get())).save(consumer, "spaceship_cabin_from_workbench");
		WorkbenchCraftingRecipeBuilder.shaped(ItemRegistry.SPACESHIP_ENGINE.get(), FluidRegistry.MOLTEN_STEEL.get(), 0.555F, 3.1F).pattern("CRC").pattern("TTT").define('R', Items.REDSTONE).define('C', Items.COPPER_INGOT).define('T', Items.REDSTONE_TORCH).group(modGroup()).unlockedBy("has_steel", has(ItemRegistry.STEEL_INGOT.get())).save(consumer, "spaceship_engine_from_workbench");
		WorkbenchCraftingRecipeBuilder.shaped(ItemRegistry.WHITE_SPACESHIP.get(), FluidRegistry.MOLTEN_ALUMINUM.get(), 0.333F, 1.7F).pattern("C").pattern("F").pattern("E").define('C', ItemRegistry.SPACESHIP_CABIN.get()).define('F', ItemRegistry.SPACESHIP_FRAME.get()).define('E', ItemRegistry.SPACESHIP_ENGINE.get()).group(modGroup()).unlockedBy("has_steel", has(ItemRegistry.STEEL_INGOT.get())).save(consumer, "spaceship_from_workbench");

		ShapelessRecipeBuilder.shapeless(ItemRegistry.BLACK_SPACESHIP.get()).requires(ItemRegistry.WHITE_SPACESHIP.get()).requires(Items.BLACK_DYE).group(modGroup()).unlockedBy("spaceship", has(ItemRegistry.WHITE_SPACESHIP.get())).save(consumer);
		ShapelessRecipeBuilder.shapeless(ItemRegistry.GREY_SPACESHIP.get()).requires(ItemRegistry.WHITE_SPACESHIP.get()).requires(Items.GRAY_DYE).group(modGroup()).unlockedBy("spaceship", has(ItemRegistry.WHITE_SPACESHIP.get())).save(consumer);
		ShapelessRecipeBuilder.shapeless(ItemRegistry.LIGHT_GREY_SPACESHIP.get()).requires(ItemRegistry.WHITE_SPACESHIP.get()).requires(Items.LIGHT_GRAY_DYE).group(modGroup()).unlockedBy("spaceship", has(ItemRegistry.WHITE_SPACESHIP.get())).save(consumer);
		ShapelessRecipeBuilder.shapeless(ItemRegistry.PINK_SPACESHIP.get()).requires(ItemRegistry.WHITE_SPACESHIP.get()).requires(Items.PINK_DYE).group(modGroup()).unlockedBy("spaceship", has(ItemRegistry.WHITE_SPACESHIP.get())).save(consumer);
		ShapelessRecipeBuilder.shapeless(ItemRegistry.RED_SPACESHIP.get()).requires(ItemRegistry.WHITE_SPACESHIP.get()).requires(Items.RED_DYE).group(modGroup()).unlockedBy("spaceship", has(ItemRegistry.WHITE_SPACESHIP.get())).save(consumer);
		ShapelessRecipeBuilder.shapeless(ItemRegistry.ORANGE_SPACESHIP.get()).requires(ItemRegistry.WHITE_SPACESHIP.get()).requires(Items.ORANGE_DYE).group(modGroup()).unlockedBy("spaceship", has(ItemRegistry.WHITE_SPACESHIP.get())).save(consumer);
		ShapelessRecipeBuilder.shapeless(ItemRegistry.YELLOW_SPACESHIP.get()).requires(ItemRegistry.WHITE_SPACESHIP.get()).requires(Items.YELLOW_DYE).group(modGroup()).unlockedBy("spaceship", has(ItemRegistry.WHITE_SPACESHIP.get())).save(consumer);
		ShapelessRecipeBuilder.shapeless(ItemRegistry.LIME_SPACESHIP.get()).requires(ItemRegistry.WHITE_SPACESHIP.get()).requires(Items.LIME_DYE).group(modGroup()).unlockedBy("spaceship", has(ItemRegistry.WHITE_SPACESHIP.get())).save(consumer);
		ShapelessRecipeBuilder.shapeless(ItemRegistry.GREEN_SPACESHIP.get()).requires(ItemRegistry.WHITE_SPACESHIP.get()).requires(Items.GREEN_DYE).group(modGroup()).unlockedBy("spaceship", has(ItemRegistry.WHITE_SPACESHIP.get())).save(consumer);
		ShapelessRecipeBuilder.shapeless(ItemRegistry.CYAN_SPACESHIP.get()).requires(ItemRegistry.WHITE_SPACESHIP.get()).requires(Items.CYAN_DYE).group(modGroup()).unlockedBy("spaceship", has(ItemRegistry.WHITE_SPACESHIP.get())).save(consumer);
		ShapelessRecipeBuilder.shapeless(ItemRegistry.BLUE_SPACESHIP.get()).requires(ItemRegistry.WHITE_SPACESHIP.get()).requires(Items.BLUE_DYE).group(modGroup()).unlockedBy("spaceship", has(ItemRegistry.WHITE_SPACESHIP.get())).save(consumer);
		ShapelessRecipeBuilder.shapeless(ItemRegistry.LIGHT_BLUE_SPACESHIP.get()).requires(ItemRegistry.WHITE_SPACESHIP.get()).requires(Items.LIGHT_BLUE_DYE).group(modGroup()).unlockedBy("spaceship", has(ItemRegistry.WHITE_SPACESHIP.get())).save(consumer);
		ShapelessRecipeBuilder.shapeless(ItemRegistry.PURPLE_SPACESHIP.get()).requires(ItemRegistry.WHITE_SPACESHIP.get()).requires(Items.PURPLE_DYE).group(modGroup()).unlockedBy("spaceship", has(ItemRegistry.WHITE_SPACESHIP.get())).save(consumer);
		ShapelessRecipeBuilder.shapeless(ItemRegistry.MAGENTA_SPACESHIP.get()).requires(ItemRegistry.WHITE_SPACESHIP.get()).requires(Items.MAGENTA_DYE).group(modGroup()).unlockedBy("spaceship", has(ItemRegistry.WHITE_SPACESHIP.get())).save(consumer);
		ShapelessRecipeBuilder.shapeless(ItemRegistry.BROWN_SPACESHIP.get()).requires(ItemRegistry.WHITE_SPACESHIP.get()).requires(Items.BROWN_DYE).group(modGroup()).unlockedBy("spaceship", has(ItemRegistry.WHITE_SPACESHIP.get())).save(consumer);

		//---- SPACE STATION -------------------------------------------------------------------------------
		ShapedRecipeBuilder.shaped(BlockRegistry.INSULATED_PANEL.get(), 4).pattern("XC").pattern("XC").define('X', ItemRegistry.ALUMINUM_INGOT.get()).define('C', BlockRegistry.WHITE_CERAMIC.get()).group(modGroup()).unlockedBy("aluminum", has(ItemRegistry.ALUMINUM_INGOT.get())).save(consumer);
		ShapedRecipeBuilder.shaped(BlockRegistry.PATHWAY_LIGHT.get(), 4).pattern("XXX").pattern(" T ").define('X', ItemRegistry.ALUMINUM_INGOT.get()).define('T', Items.REDSTONE_TORCH).group(modGroup()).unlockedBy("aluminum", has(ItemRegistry.ALUMINUM_INGOT.get())).save(consumer);
		SingleItemRecipeBuilder.stonecutting(Ingredient.of(BlockRegistry.INSULATED_PANEL.get()), BlockRegistry.INSULATED_PANEL_CORNER.get(), 1).group(modGroup()).unlockedBy("aluminum", has(ItemRegistry.ALUMINUM_INGOT.get())).save(consumer);
		SingleItemRecipeBuilder.stonecutting(Ingredient.of(BlockRegistry.INSULATED_PANEL_CORNER.get()), BlockRegistry.INSULATED_PANEL.get(), 1).group(modGroup()).unlockedBy("aluminum", has(ItemRegistry.ALUMINUM_INGOT.get())).save(consumer, "insulated_panel_stonecutting");
		ShapedRecipeBuilder.shaped(BlockRegistry.PANEL.get()).pattern("XX").pattern("XX").define('X', ItemRegistry.ALUMINUM_INGOT.get()).group(modGroup()).unlockedBy("meteor", has(ItemRegistry.ALUMINUM_INGOT.get())).save(consumer);
		stairsSlabWallCraftStonecutting(BlockRegistry.PANEL.get(), BlockRegistry.PANEL_STAIRS.get(), BlockRegistry.PANEL_SLAB.get(), BlockRegistry.PANEL_WALL.get(), BlockRegistry.PANEL.get(), consumer);

		ShapedRecipeBuilder.shaped(BlockRegistry.THIN_PANEL.get()).pattern("XX").pattern("XX").define('X', BlockRegistry.PANEL.get()).group(modGroup()).unlockedBy("aluminum", has(ItemRegistry.ALUMINUM_INGOT.get())).save(consumer);

//		pane(BlockRegistry.PANEL.get(), BlockRegistry.THIN_PANEL.get(), BlockRegistry.PANEL.get(), consumer);
		ShapedRecipeBuilder.shaped(BlockRegistry.STEEL_LADDER.get()).pattern("X X").pattern("XXX").pattern("X X").define('X', ItemRegistry.STEEL_INGOT.get()).group(modGroup()).unlockedBy("steel", has(ItemRegistry.STEEL_INGOT.get())).save(consumer);

		ShapedRecipeBuilder.shaped(BlockRegistry.AIRLOCK_DOOR.get()).pattern("GX").pattern("DX").define('X', ItemRegistry.ALUMINUM_INGOT.get()).define('G', Tags.Items.GLASS_COLORLESS).define('D', BlockRegistry.STEEL_DOOR.get()).group(modGroup()).unlockedBy("aluminum", has(ItemRegistry.ALUMINUM_INGOT.get())).save(consumer);
		ShapedRecipeBuilder.shaped(BlockRegistry.AIRLOCK_DOOR.get()).pattern("GX").pattern("DX").define('X', ItemRegistry.ALUMINUM_INGOT.get()).define('G', Tags.Items.GLASS_COLORLESS).define('D', Items.IRON_DOOR).group(modGroup()).unlockedBy("aluminum", has(ItemRegistry.ALUMINUM_INGOT.get())).save(consumer, "airlock_door_from_iron_door");

		ShapedRecipeBuilder.shaped(BlockRegistry.AIRLOCK_PANEL_DOOR.get(), 8).pattern("XX ").pattern("XXR").pattern("XX ").define('X', ItemRegistry.ALUMINUM_INGOT.get()).define('R', Items.REDSTONE).group(modGroup()).unlockedBy("aluminum", has(ItemRegistry.ALUMINUM_INGOT.get())).save(consumer);
		ShapedRecipeBuilder.shaped(BlockRegistry.AIRLOCK_PANEL_DOOR_WINDOW.get(), 8).pattern("XX ").pattern("XGR").pattern("XX ").define('X', ItemRegistry.ALUMINUM_INGOT.get()).define('G', Tags.Items.GLASS).define('R', Items.REDSTONE).group(modGroup()).unlockedBy("aluminum", has(ItemRegistry.ALUMINUM_INGOT.get())).save(consumer);
		ShapedRecipeBuilder.shaped(BlockRegistry.HANGAR_DOOR.get(), 8).pattern("XX ").pattern("XXR").pattern("XX ").define('X', ItemRegistry.STEEL_INGOT.get()).define('R', Items.REDSTONE).group(modGroup()).unlockedBy("steel", has(ItemRegistry.STEEL_INGOT.get())).save(consumer);
		ShapedRecipeBuilder.shaped(BlockRegistry.HANGAR_DOOR_WINDOW.get(), 8).pattern("XX ").pattern("XGR").pattern("XX ").define('X', ItemRegistry.STEEL_INGOT.get()).define('G', Tags.Items.GLASS).define('R', Items.REDSTONE).group(modGroup()).unlockedBy("steel", has(ItemRegistry.STEEL_INGOT.get())).save(consumer);

		ShapedRecipeBuilder.shaped(BlockRegistry.AIRLOCK_TRAPDOOR.get(), 2).pattern("XGX").pattern("XXX").define('G', Tags.Items.GLASS_COLORLESS).define('X', ItemRegistry.ALUMINUM_INGOT.get()).group(modGroup()).unlockedBy("steel", has(ItemRegistry.STEEL_INGOT.get())).save(consumer);

		ShapedRecipeBuilder.shaped(BlockRegistry.STEEL_DOOR.get(), 3).pattern("XX").pattern("XX").pattern("XX").define('X', ItemRegistry.STEEL_INGOT.get()).group(modGroup()).unlockedBy("steel", has(ItemRegistry.STEEL_INGOT.get())).save(consumer);
		ShapedRecipeBuilder.shaped(BlockRegistry.STEEL_TRAPDOOR.get(), 2).pattern("XXX").pattern("XXX").define('X', ItemRegistry.STEEL_INGOT.get()).group(modGroup()).unlockedBy("steel", has(ItemRegistry.STEEL_INGOT.get())).save(consumer);
		ShapedRecipeBuilder.shaped(BlockRegistry.STEEL_BUTTON.get()).pattern("XX").pattern("XX").define('X', ItemRegistry.STEEL_NUGGET.get()).group(modGroup()).unlockedBy("steel", has(ItemRegistry.STEEL_INGOT.get())).save(consumer);

		ShapedRecipeBuilder.shaped(BlockRegistry.SOLAR_PANEL.get()).pattern("GGG").pattern("QQQ").pattern("SSS").define('G', Items.GLASS).define('Q', Items.QUARTZ_BLOCK).define('S', ItemRegistry.ALUMINUM_INGOT.get()).group(modGroup()).unlockedBy("steel", has(ItemRegistry.STEEL_INGOT.get())).save(consumer);

		ShapelessRecipeBuilder.shapeless(BlockRegistry.GLOW_STRIP.get()).requires(Items.TORCH).requires(Items.IRON_NUGGET).group(modGroup()).unlockedBy("torch", has(Items.TORCH)).save(consumer, "glow_strip_from_iron");
		ShapelessRecipeBuilder.shapeless(BlockRegistry.GLOW_STRIP.get()).requires(Items.TORCH).requires(ItemRegistry.STEEL_NUGGET.get()).group(modGroup()).unlockedBy("torch", has(Items.TORCH)).save(consumer, "glow_strip_from_steel");
		singleItem(BlockRegistry.GLOW_STRIP.get(), BlockRegistry.HORIZONTAL_GLOW_STRIP.get(), 1, Blocks.TORCH, consumer);
		singleItem(BlockRegistry.HORIZONTAL_GLOW_STRIP.get(), BlockRegistry.GLOW_STRIP.get(), 1, Blocks.TORCH, consumer);

		singleItem(Blocks.RED_STAINED_GLASS, BlockRegistry.RED_BUTTON.get(), 1, Blocks.RED_STAINED_GLASS, consumer);
		singleItem(Blocks.YELLOW_STAINED_GLASS, BlockRegistry.YELLOW_BUTTON.get(), 1, Blocks.YELLOW_STAINED_GLASS, consumer);
		singleItem(Blocks.BLUE_STAINED_GLASS, BlockRegistry.BLUE_BUTTON.get(), 1, Blocks.BLUE_STAINED_GLASS, consumer);
		singleItem(Blocks.GREEN_STAINED_GLASS, BlockRegistry.GREEN_BUTTON.get(), 1, Blocks.GREEN_STAINED_GLASS, consumer);
		singleItem(Blocks.WHITE_STAINED_GLASS, BlockRegistry.WHITE_BUTTON.get(), 1, Blocks.WHITE_STAINED_GLASS, consumer);
		singleItem(Blocks.BLACK_STAINED_GLASS, BlockRegistry.BLACK_BUTTON.get(), 1, Blocks.BLACK_STAINED_GLASS, consumer);

		//---- MAG LEV -------------------------------------------------------------------------------
		ShapedRecipeBuilder.shaped(BlockRegistry.MAG_RAIL.get(), 16).pattern("X X").pattern("X#X").pattern("X X").define('X', ItemRegistry.STEEL_INGOT.get()).define('#', ItemRegistry.STEEL_ROD.get()).group(modGroup()).unlockedBy("steel", has(ItemRegistry.STEEL_INGOT.get())).save(consumer);
		ShapedRecipeBuilder.shaped(BlockRegistry.POWERED_MAG_RAIL.get(), 6).pattern("X X").pattern("X#X").pattern("XRX").define('X', ItemRegistry.STEEL_INGOT.get()).define('#', ItemRegistry.STEEL_ROD.get()).define('R', Items.REDSTONE).group(modGroup()).unlockedBy("steel", has(ItemRegistry.STEEL_INGOT.get())).save(consumer);
		ShapedRecipeBuilder.shaped(BlockRegistry.DETECTOR_MAG_RAIL.get(), 6).pattern("X X").pattern("X#X").pattern("XRX").define('X', ItemRegistry.STEEL_INGOT.get()).define('#', TagRegistry.Items.STONE_PRESSURE_PLATE).define('R', Items.REDSTONE).group(modGroup()).unlockedBy("steel", has(ItemRegistry.STEEL_INGOT.get())).save(consumer);
		ShapedRecipeBuilder.shaped(BlockRegistry.ACTIVATOR_MAG_RAIL.get(), 6).pattern("X#X").pattern("XRX").pattern("X#X").define('X', ItemRegistry.STEEL_INGOT.get()).define('#', ItemRegistry.STEEL_ROD.get()).define('R', Items.REDSTONE_TORCH).group(modGroup()).unlockedBy("steel", has(ItemRegistry.STEEL_INGOT.get())).save(consumer);
		ShapedRecipeBuilder.shaped(ItemRegistry.MAGCART.get()).pattern("X X").pattern("XXX").define('X', ItemRegistry.STEEL_INGOT.get()).group(modGroup()).unlockedBy("steel", has(ItemRegistry.STEEL_INGOT.get())).save(consumer);
		ShapedRecipeBuilder.shaped(ItemRegistry.CHEST_MAGCART.get()).pattern("#").pattern("X").define('#', Tags.Items.CHESTS).define('X', ItemRegistry.MAGCART.get()).group(modGroup()).unlockedBy("steel", has(ItemRegistry.STEEL_INGOT.get())).save(consumer);
		ShapedRecipeBuilder.shaped(ItemRegistry.CHEST_MAGCART.get()).pattern("X#X").pattern("XXX").define('#', Tags.Items.CHESTS).define('X', ItemRegistry.STEEL_INGOT.get()).group(modGroup()).unlockedBy("steel", has(ItemRegistry.STEEL_INGOT.get())).save(consumer, "chest_magcart_from_steel_ingots");
		ShapedRecipeBuilder.shaped(ItemRegistry.FURNACE_MAGCART.get()).pattern("#").pattern("X").define('#', Items.FURNACE).define('X', ItemRegistry.MAGCART.get()).group(modGroup()).unlockedBy("steel", has(ItemRegistry.STEEL_INGOT.get())).save(consumer);
		ShapedRecipeBuilder.shaped(ItemRegistry.FURNACE_MAGCART.get()).pattern("X#X").pattern("XXX").define('#', Items.FURNACE).define('X', ItemRegistry.STEEL_INGOT.get()).group(modGroup()).unlockedBy("steel", has(ItemRegistry.STEEL_INGOT.get())).save(consumer, "furnace_magcart_from_steel_ingots");
		ShapedRecipeBuilder.shaped(ItemRegistry.HOPPER_MAGCART.get()).pattern("#").pattern("X").define('#', Items.HOPPER).define('X', ItemRegistry.MAGCART.get()).group(modGroup()).unlockedBy("steel", has(ItemRegistry.STEEL_INGOT.get())).save(consumer);
		ShapedRecipeBuilder.shaped(ItemRegistry.HOPPER_MAGCART.get()).pattern("X#X").pattern("XXX").define('#', Items.HOPPER).define('X', ItemRegistry.STEEL_INGOT.get()).group(modGroup()).unlockedBy("steel", has(ItemRegistry.STEEL_INGOT.get())).save(consumer, "hopper_magcart_from_steel_ingots");
		ShapedRecipeBuilder.shaped(ItemRegistry.TNT_MAGCART.get()).pattern("#").pattern("X").define('#', Items.TNT).define('X', ItemRegistry.MAGCART.get()).group(modGroup()).unlockedBy("steel", has(ItemRegistry.STEEL_INGOT.get())).save(consumer);
		ShapedRecipeBuilder.shaped(ItemRegistry.TNT_MAGCART.get()).pattern("X#X").pattern("XXX").define('#', Items.TNT).define('X', ItemRegistry.STEEL_INGOT.get()).group(modGroup()).unlockedBy("steel", has(ItemRegistry.STEEL_INGOT.get())).save(consumer, "tnt_magcart_from_steel_ingots");

		//---- ARMOR -------------------------------------------------------------------------------
		//STEEL
		ShapedRecipeBuilder.shaped(ItemRegistry.STEEL_HELMET.get()).pattern("XXX").pattern("X X").define('X', ItemRegistry.STEEL_INGOT.get()).group(modGroup()).unlockedBy("steel_ingot", has(ItemRegistry.STEEL_INGOT.get())).save(consumer);
		ShapedRecipeBuilder.shaped(ItemRegistry.STEEL_CHESTPLATE.get()).pattern("X X").pattern("XXX").pattern("XXX").define('X', ItemRegistry.STEEL_INGOT.get()).group(modGroup()).unlockedBy("steel_ingot", has(ItemRegistry.STEEL_INGOT.get())).save(consumer);
		ShapedRecipeBuilder.shaped(ItemRegistry.STEEL_LEGGINGS.get()).pattern("XXX").pattern("X X").pattern("X X").define('X', ItemRegistry.STEEL_INGOT.get()).group(modGroup()).unlockedBy("steel_ingot", has(ItemRegistry.STEEL_INGOT.get())).save(consumer);
		ShapedRecipeBuilder.shaped(ItemRegistry.STEEL_BOOTS.get()).pattern("X X").pattern("X X").define('X', ItemRegistry.STEEL_INGOT.get()).group(modGroup()).unlockedBy("steel_ingot", has(ItemRegistry.STEEL_INGOT.get())).save(consumer);

		//SPACE SUITS
		WorkbenchCraftingRecipeBuilder.shaped(ItemRegistry.BASIC_SPACESUIT_HELMET.get(), FluidRegistry.MOLTEN_STEEL.get(), 0.333F, 2.1F).pattern("LLL").pattern("WGW").define('L', Items.LEATHER).define('W', ItemTags.WOOL).define('G', Tags.Items.GLASS).group(modGroup()).group(modGroup()).unlockedBy("has_leather", has(Items.LEATHER)).save(consumer, "basic_space_suit_helmet");
		WorkbenchCraftingRecipeBuilder.shaped(ItemRegistry.BASIC_SPACESUIT_CHESTPLATE.get(), FluidRegistry.MOLTEN_STEEL.get(), 0.666F, 4.2F).pattern("L L").pattern("WWW").pattern("LLL").define('W', ItemTags.WOOL).define('L', Items.LEATHER).group(modGroup()).unlockedBy("has_leather", has(Items.LEATHER)).save(consumer, "basic_space_suit_chestplate");
		WorkbenchCraftingRecipeBuilder.shaped(ItemRegistry.BASIC_SPACESUIT_LEGGINGS.get(), FluidRegistry.MOLTEN_STEEL.get(), 0.555F, 3.5F).pattern("LLL").pattern("L L").pattern("W W").define('W', ItemTags.WOOL).define('L', Items.LEATHER).group(modGroup()).unlockedBy("has_leather", has(Items.LEATHER)).save(consumer, "basic_space_suit_leggings");
		WorkbenchCraftingRecipeBuilder.shaped(ItemRegistry.BASIC_SPACESUIT_BOOTS.get(), FluidRegistry.MOLTEN_STEEL.get(), 0.222F, 1.4F).pattern("W W").pattern("L L").define('L', Items.LEATHER).define('W', ItemTags.WOOL).group(modGroup()).unlockedBy("has_leather", has(Items.LEATHER)).save(consumer, "basic_space_suit_boots");

		WorkbenchCraftingRecipeBuilder.shaped(ItemRegistry.HEAVY_DUTY_SPACESUIT_HELMET.get(), FluidRegistry.MOLTEN_STEEL.get(), 0.444F, 2.8F).pattern("DDD").pattern("LGL").define('L', Items.LEATHER).define('G', Tags.Items.GLASS).define('D', Tags.Items.GEMS_DIAMOND).group(modGroup()).group(modGroup()).unlockedBy("has_diamond", has(Items.DIAMOND)).save(consumer, "heavy_duty_space_suit_helmet");
		WorkbenchCraftingRecipeBuilder.shaped(ItemRegistry.HEAVY_DUTY_SPACESUIT_CHESTPLATE.get(), FluidRegistry.MOLTEN_STEEL.get(), 0.777F, 4.9F).pattern("L L").pattern("DDD").pattern("GMG").define('L', Items.LEATHER).define('G', Tags.Items.INGOTS_GOLD).define('D', Tags.Items.GEMS_DIAMOND).define('M', Items.MAGMA_CREAM).group(modGroup()).unlockedBy("has_diamond", has(Items.DIAMOND)).save(consumer, "heavy_duty_space_suit_chestplate");
		WorkbenchCraftingRecipeBuilder.shaped(ItemRegistry.HEAVY_DUTY_SPACESUIT_LEGGINGS.get(), FluidRegistry.MOLTEN_STEEL.get(), 0.666F, 4.2F).pattern("LLL").pattern("D D").pattern("L L").define('L', Items.LEATHER).define('D', Tags.Items.GEMS_DIAMOND).group(modGroup()).unlockedBy("has_diamond", has(Items.DIAMOND)).save(consumer, "heavy_duty_space_suit_leggings");
		WorkbenchCraftingRecipeBuilder.shaped(ItemRegistry.HEAVY_DUTY_SPACESUIT_BOOTS.get(), FluidRegistry.MOLTEN_STEEL.get(), 0.333F, 2.1F).pattern("R R").pattern("D D").define('D', Tags.Items.GEMS_DIAMOND).define('R', Items.RABBIT_HIDE).group(modGroup()).unlockedBy("has_diamond", has(Items.DIAMOND)).save(consumer, "heavy_duty_space_suit_boots");

		WorkbenchCraftingRecipeBuilder.shaped(ItemRegistry.THERMAL_SPACESUIT_HELMET.get(), FluidRegistry.MOLTEN_STEEL.get(), 0.444F, 2.8F).pattern("DDD").pattern("WGW").define('W', ItemTags.WOOL).define('G', Tags.Items.GLASS).define('D', Tags.Items.GEMS_DIAMOND).group(modGroup()).group(modGroup()).unlockedBy("has_diamond", has(Items.DIAMOND)).save(consumer, "thermal_space_suit_helmet");
		WorkbenchCraftingRecipeBuilder.shaped(ItemRegistry.THERMAL_SPACESUIT_CHESTPLATE.get(), FluidRegistry.MOLTEN_STEEL.get(), 0.777F, 4.9F).pattern("L L").pattern("DDD").pattern("WWW").define('L', Items.LEATHER).define('D', Tags.Items.GEMS_DIAMOND).define('W', ItemTags.WOOL).group(modGroup()).unlockedBy("has_diamond", has(Items.DIAMOND)).save(consumer, "thermal_space_suit_chestplate");
		WorkbenchCraftingRecipeBuilder.shaped(ItemRegistry.THERMAL_SPACESUIT_LEGGINGS.get(), FluidRegistry.MOLTEN_STEEL.get(), 0.666F, 4.2F).pattern("WWW").pattern("D D").pattern("W W").define('W', ItemTags.WOOL).define('D', Tags.Items.GEMS_DIAMOND).group(modGroup()).unlockedBy("has_diamond", has(Items.DIAMOND)).save(consumer, "thermal_space_suit_leggings");
		WorkbenchCraftingRecipeBuilder.shaped(ItemRegistry.THERMAL_SPACESUIT_BOOTS.get(), FluidRegistry.MOLTEN_STEEL.get(), 0.333F, 2.1F).pattern("L L").pattern("D D").define('D', Tags.Items.GEMS_DIAMOND).define('L', Items.LEATHER).group(modGroup()).unlockedBy("has_diamond", has(Items.DIAMOND)).save(consumer, "thermal_space_suit_boots");

		WorkbenchCraftingRecipeBuilder.shaped(ItemRegistry.ADVANCED_SPACESUIT_HELMET.get(), FluidRegistry.MOLTEN_STEEL.get(), 0.444F, 2.8F).pattern("OOO").pattern("DGD").define('O', Items.OBSIDIAN).define('G', Tags.Items.GLASS).define('D', Tags.Items.GEMS_DIAMOND).group(modGroup()).group(modGroup()).unlockedBy("has_obsidian", has(Items.OBSIDIAN)).save(consumer, "advanced_space_suit_helmet");
		WorkbenchCraftingRecipeBuilder.shaped(ItemRegistry.ADVANCED_SPACESUIT_CHESTPLATE.get(), FluidRegistry.MOLTEN_STEEL.get(), 0.777F, 4.9F).pattern("L L").pattern("DDD").pattern("OOO").define('L', Items.LEATHER).define('D', Tags.Items.GEMS_DIAMOND).define('O', Items.OBSIDIAN).group(modGroup()).unlockedBy("has_obsidian", has(Items.OBSIDIAN)).save(consumer, "advanced_space_suit_chestplate");
		WorkbenchCraftingRecipeBuilder.shaped(ItemRegistry.ADVANCED_SPACESUIT_LEGGINGS.get(), FluidRegistry.MOLTEN_STEEL.get(), 0.666F, 4.2F).pattern("DDD").pattern("O O").pattern("L L").define('O', Items.OBSIDIAN).define('L', Items.LEATHER).define('D', Tags.Items.GEMS_DIAMOND).group(modGroup()).unlockedBy("has_obsidian", has(Items.OBSIDIAN)).save(consumer, "advanced_space_suit_leggings");
		WorkbenchCraftingRecipeBuilder.shaped(ItemRegistry.ADVANCED_SPACESUIT_BOOTS.get(), FluidRegistry.MOLTEN_STEEL.get(), 0.333F, 2.1F).pattern("L L").pattern("O O").define('O', Items.OBSIDIAN).define('L', Items.LEATHER).group(modGroup()).unlockedBy("has_obsidian", has(Items.OBSIDIAN)).save(consumer, "advanced_space_suit_boots");

		//---- WORKBENCH SMELTING -------------------------------------------------------------------------------
		workbenchSmelting(Fluids.WATER, Items.WATER_BUCKET, 0.0F, 1, 1.0F, BlockRegistry.WORKBENCH.get(), consumer);
		workbenchSmelting(Fluids.LAVA, Items.LAVA_BUCKET, 0.0F, 1, 1.0F, BlockRegistry.WORKBENCH.get(), consumer);

		//IRON
		workbenchSmelting(FluidRegistry.MOLTEN_IRON.get(), Items.IRON_INGOT, 0.7F, 100, 0.1111F, Items.IRON_INGOT, consumer);
		workbenchSmelting(FluidRegistry.MOLTEN_IRON.get(), Items.RAW_IRON, 0.7F, 100, 0.1111F, Items.RAW_IRON, consumer);
		workbenchSmelting(FluidRegistry.MOLTEN_IRON.get(), Items.IRON_ORE, 0.1F, 100, 0.1111F, Items.IRON_ORE, consumer);
		workbenchSmelting(FluidRegistry.MOLTEN_IRON.get(), Items.DEEPSLATE_IRON_ORE, 0.1F, 100, 0.1111F, Items.DEEPSLATE_IRON_ORE, consumer);
		workbenchSmelting(FluidRegistry.MOLTEN_IRON.get(), BlockRegistry.MARS_IRON_ORE.get(), 0.1F, 100, 0.1111F, BlockRegistry.MARS_IRON_ORE.get(), consumer);
		workbenchSmelting(FluidRegistry.MOLTEN_IRON.get(), BlockRegistry.MARS_DEEPSLATE_IRON_ORE.get(), 0.1F, 100, 0.1111F, BlockRegistry.MARS_DEEPSLATE_IRON_ORE.get(), consumer);
//		workbenchSmelting(FluidRegistry.MOLTEN_IRON.get(), BlockRegistry.MOON_IRON_ORE.get(), 0.1F, 100, 0.1111F, BlockRegistry.MOON_IRON_ORE.get(), consumer);
//		workbenchSmelting(FluidRegistry.MOLTEN_IRON.get(), BlockRegistry.MOON_DEEPSLATE_IRON_ORE.get(), 0.1F, 100, 0.1111F, BlockRegistry.MOON_DEEPSLATE_IRON_ORE.get(), consumer);
		workbenchSmelting(FluidRegistry.MOLTEN_IRON.get(), BlockRegistry.VENUS_IRON_ORE.get(), 0.1F, 100, 0.1111F, BlockRegistry.VENUS_IRON_ORE.get(), consumer);
		workbenchSmelting(FluidRegistry.MOLTEN_IRON.get(), BlockRegistry.VENUS_DEEPSLATE_IRON_ORE.get(), 0.1F, 100, 0.1111F, BlockRegistry.VENUS_DEEPSLATE_IRON_ORE.get(), consumer);
		workbenchSmelting(FluidRegistry.MOLTEN_IRON.get(), BlockRegistry.MERCURY_DEEPSLATE_IRON_ORE.get(), 0.1F, 100, 0.1111F, BlockRegistry.VENUS_DEEPSLATE_IRON_ORE.get(), consumer);
		workbenchSmelting(FluidRegistry.MOLTEN_IRON.get(), BlockRegistry.METEOR_IRON_ORE.get(), 0.1F, 100, 0.1111F, BlockRegistry.METEOR_IRON_ORE.get(), consumer);
		workbenchSmelting(FluidRegistry.MOLTEN_IRON.get(), Items.IRON_BLOCK, 0.7F, 150, 1.0F, Items.IRON_INGOT, consumer);

		//COPPER
		workbenchSmelting(FluidRegistry.MOLTEN_COPPER.get(), Items.COPPER_INGOT, 0.7F, 100, .1111F, Items.COPPER_INGOT, consumer);
		workbenchSmelting(FluidRegistry.MOLTEN_COPPER.get(), Items.RAW_COPPER, 0.7F, 100, 0.1111F, Items.RAW_COPPER, consumer);
		workbenchSmelting(FluidRegistry.MOLTEN_COPPER.get(), Items.COPPER_ORE, 0.1F, 100, 0.1111F, Items.IRON_ORE, consumer);
		workbenchSmelting(FluidRegistry.MOLTEN_COPPER.get(), Items.DEEPSLATE_COPPER_ORE, 0.1F, 100, 0.1111F, Items.DEEPSLATE_COPPER_ORE, consumer);
		workbenchSmelting(FluidRegistry.MOLTEN_COPPER.get(), BlockRegistry.METEOR_COPPER_ORE.get(), 0.1F, 100, 0.1111F, BlockRegistry.METEOR_COPPER_ORE.get(), consumer);
		workbenchSmelting(FluidRegistry.MOLTEN_COPPER.get(), Items.COPPER_BLOCK, 0.7F, 150, 1.0F, Items.COPPER_BLOCK, consumer);
		workbenchSmelting(FluidRegistry.MOLTEN_COPPER.get(), Items.EXPOSED_COPPER, 0.7F, 150, 1.0F, Items.COPPER_BLOCK, consumer);
		workbenchSmelting(FluidRegistry.MOLTEN_COPPER.get(), Items.OXIDIZED_COPPER, 0.7F, 150, 1.0F, Items.COPPER_BLOCK, consumer);
		workbenchSmelting(FluidRegistry.MOLTEN_COPPER.get(), Items.WEATHERED_COPPER, 0.7F, 150, 1.0F, Items.COPPER_BLOCK, consumer);

		//GOLD
		workbenchSmelting(FluidRegistry.MOLTEN_GOLD.get(), Items.GOLD_INGOT, 0.7F, 100, 0.1111F, Items.GOLD_INGOT, consumer);
		workbenchSmelting(FluidRegistry.MOLTEN_GOLD.get(), Items.RAW_GOLD, 0.7F, 100, 0.1111F, Items.RAW_GOLD, consumer);
		workbenchSmelting(FluidRegistry.MOLTEN_GOLD.get(), Items.GOLD_ORE, 0.1F, 100, 0.1111F, Items.GOLD_ORE, consumer);
		workbenchSmelting(FluidRegistry.MOLTEN_GOLD.get(), Items.DEEPSLATE_GOLD_ORE, 0.1F, 100, 0.111F, Items.DEEPSLATE_GOLD_ORE, consumer);
		workbenchSmelting(FluidRegistry.MOLTEN_GOLD.get(), BlockRegistry.METEOR_GOLD_ORE.get(), 0.1F, 100, 0.1111F, BlockRegistry.METEOR_IRON_ORE.get(), consumer);
		workbenchSmelting(FluidRegistry.MOLTEN_GOLD.get(), Items.GOLD_BLOCK, 0.7F, 150, 1.0F, Items.GOLD_INGOT, consumer);

		//STEEL
		workbenchSmelting(FluidRegistry.MOLTEN_STEEL.get(), ItemRegistry.STEEL_INGOT.get(), 0.7F, 100, 0.1111F, ItemRegistry.STEEL_INGOT.get(), consumer);
		workbenchSmelting(FluidRegistry.MOLTEN_STEEL.get(), BlockRegistry.STEEL_BLOCK.get(), 0.7F, 150, 1.0F, ItemRegistry.STEEL_INGOT.get(), consumer);

		//ALUMINUM
		workbenchSmelting(FluidRegistry.MOLTEN_ALUMINUM.get(), ItemRegistry.ALUMINUM_INGOT.get(), 0.7F, 100, 0.111F, ItemRegistry.ALUMINUM_INGOT.get(), consumer);
		workbenchSmelting(FluidRegistry.MOLTEN_ALUMINUM.get(), BlockRegistry.ALUMINUM_BLOCK.get(), 0.7F, 150, 1.0F, ItemRegistry.ALUMINUM_INGOT.get(), consumer);

		//REMOVAL
		WorkbenchCraftingRecipeBuilder.shaped(Items.WATER_BUCKET, Fluids.WATER, 1.0F, 0.0F).pattern("X").define('X', Items.BUCKET).group(modGroup()).unlockedBy("has_iron", has(Items.IRON_INGOT)).save(consumer, "water_bucket_from_workbench");
		WorkbenchCraftingRecipeBuilder.shaped(Items.LAVA_BUCKET, Fluids.LAVA, 1.0F, 0.0F).pattern("X").define('X', Items.BUCKET).group(modGroup()).unlockedBy("has_iron", has(Items.IRON_INGOT)).save(consumer, "lava_bucket_from_workbench");

		ShapedRecipeBuilder.shaped(ItemRegistry.BLOCK_MOLD.get(), 8).pattern("XXX").pattern("XCX").pattern("XXX").define('C', Items.STONE).define('X', Tags.Items.COBBLESTONE).group(modGroup()).unlockedBy("has_iron_ingot", has(Items.IRON_INGOT)).save(consumer);
		ShapedRecipeBuilder.shaped(ItemRegistry.INGOT_MOLD.get(), 8).pattern("XXX").pattern("XCX").pattern("XXX").define('C', Tags.Items.INGOTS).define('X', Tags.Items.COBBLESTONE).group(modGroup()).unlockedBy("has_iron_ingot", has(Items.IRON_INGOT)).save(consumer);

		WorkbenchCraftingRecipeBuilder.shaped(Items.IRON_INGOT, FluidRegistry.MOLTEN_IRON.get(), 0.1111F, 0.0F).pattern("X").define('X', ItemRegistry.INGOT_MOLD.get()).group(modGroup()).unlockedBy("has_iron", has(Items.IRON_INGOT)).save(consumer, "iron_ingot_from_molten_iron");
		WorkbenchCraftingRecipeBuilder.shaped(Items.IRON_BLOCK, FluidRegistry.MOLTEN_IRON.get(), 1.0F, 0.0F).pattern("X").define('X', ItemRegistry.BLOCK_MOLD.get()).group(modGroup()).unlockedBy("has_iron", has(Items.IRON_INGOT)).save(consumer, "iron_block_from_molten_iron");
		WorkbenchCraftingRecipeBuilder.shaped(ItemRegistry.STEEL_INGOT.get(), FluidRegistry.MOLTEN_STEEL.get(), 0.1111F, 0.0F).pattern("X").define('X', ItemRegistry.INGOT_MOLD.get()).group(modGroup()).unlockedBy("has_steel", has(ItemRegistry.STEEL_INGOT.get())).save(consumer, "steel_ingot_from_molten_steel");
		WorkbenchCraftingRecipeBuilder.shaped(BlockRegistry.STEEL_BLOCK.get(), FluidRegistry.MOLTEN_STEEL.get(), 1.0F, 0.0F).pattern("X").define('X', ItemRegistry.BLOCK_MOLD.get()).group(modGroup()).unlockedBy("has_steel", has(ItemRegistry.STEEL_INGOT.get())).save(consumer, "steel_block_from_molten_steel");
		WorkbenchCraftingRecipeBuilder.shaped(Items.COPPER_INGOT, FluidRegistry.MOLTEN_COPPER.get(), 0.11F, 0.0F).pattern("X").define('X', ItemRegistry.INGOT_MOLD.get()).group(modGroup()).unlockedBy("has_copper", has(Items.COPPER_INGOT)).save(consumer, "copper_ingot_from_molten_copper");
		WorkbenchCraftingRecipeBuilder.shaped(Items.COPPER_BLOCK, FluidRegistry.MOLTEN_COPPER.get(), 1.0F, 0.0F).pattern("X").define('X', ItemRegistry.BLOCK_MOLD.get()).group(modGroup()).unlockedBy("has_copper", has(Items.COPPER_INGOT)).save(consumer, "copper_block_from_molten_copper");
		WorkbenchCraftingRecipeBuilder.shaped(Items.GOLD_INGOT, FluidRegistry.MOLTEN_GOLD.get(), 0.1111F, 0.0F).pattern("X").define('X', ItemRegistry.INGOT_MOLD.get()).group(modGroup()).unlockedBy("has_gold", has(Items.GOLD_INGOT)).save(consumer, "gold_ingot_from_molten_gold");
		WorkbenchCraftingRecipeBuilder.shaped(Items.GOLD_BLOCK, FluidRegistry.MOLTEN_GOLD.get(), 1.0F, 0.0F).pattern("X").define('X', ItemRegistry.BLOCK_MOLD.get()).group(modGroup()).unlockedBy("has_gold", has(Items.GOLD_INGOT)).save(consumer, "gold_block_from_molten_gold");
		WorkbenchCraftingRecipeBuilder.shaped(ItemRegistry.ALUMINUM_INGOT.get(), FluidRegistry.MOLTEN_ALUMINUM.get(), 0.1111F, 0.0F).pattern("X").define('X', ItemRegistry.INGOT_MOLD.get()).group(modGroup()).unlockedBy("has_aluminum", has(ItemRegistry.ALUMINUM_INGOT.get())).save(consumer, "aluminum_ingot_from_molten_aluminum");
		WorkbenchCraftingRecipeBuilder.shaped(BlockRegistry.ALUMINUM_BLOCK.get(), FluidRegistry.MOLTEN_ALUMINUM.get(), 1.0F, 0.0F).pattern("X").define('X', ItemRegistry.BLOCK_MOLD.get()).group(modGroup()).unlockedBy("has_aluminum", has(BlockRegistry.ALUMINUM_BLOCK.get())).save(consumer, "aluminum_block_from_molten_aluminum");


		//---- GLASS/CERAMICS -------------------------------------------------------------------------------
		//GLASS
		ShapelessRecipeBuilder.shapeless(BlockRegistry.LUMINOUS_BLUE_GLASS.get()).requires(Tags.Items.GLASS).requires(ItemRegistry.MOON_DUST.get()).group(modGroup()).unlockedBy("moon_dust", has(ItemRegistry.MOON_DUST.get())).save(consumer);
		ShapelessRecipeBuilder.shapeless(BlockRegistry.LUMINOUS_WHITE_GLASS.get()).requires(BlockRegistry.LUMINOUS_BLUE_GLASS.get()).requires(ItemRegistry.LUNAR_GOO.get()).group(modGroup()).unlockedBy("moon_dust", has(ItemRegistry.MOON_DUST.get())).save(consumer, "luminous_white_from_blue");
		ShapelessRecipeBuilder.shapeless(BlockRegistry.LUMINOUS_CYAN_GLASS.get()).requires(Tags.Items.GLASS).requires(ItemRegistry.EUROPA_DUST.get()).group(modGroup()).unlockedBy("europa_dust", has(ItemRegistry.EUROPA_DUST.get())).save(consumer);
		ShapelessRecipeBuilder.shapeless(BlockRegistry.LUMINOUS_WHITE_GLASS.get()).requires(BlockRegistry.LUMINOUS_CYAN_GLASS.get()).requires(ItemRegistry.LUNAR_GOO.get()).group(modGroup()).unlockedBy("europa_dust", has(ItemRegistry.EUROPA_DUST.get())).save(consumer, "luminous_white_from_cyan");


		ShapedRecipeBuilder.shaped(BlockRegistry.LUMINOUS_BLUE_GLASS_PANE.get(), 16).pattern("XXX").pattern("XXX").define('X', BlockRegistry.LUMINOUS_BLUE_GLASS.get()).group(modGroup()).unlockedBy("moon_dust", has(ItemRegistry.MOON_DUST.get())).save(consumer);
		ShapedRecipeBuilder.shaped(BlockRegistry.LUMINOUS_WHITE_GLASS_PANE.get(), 16).pattern("XXX").pattern("XXX").define('X', BlockRegistry.LUMINOUS_WHITE_GLASS.get()).group(modGroup()).unlockedBy("moon_dust", has(ItemRegistry.MOON_DUST.get())).save(consumer);
		ShapedRecipeBuilder.shaped(BlockRegistry.LUMINOUS_CYAN_GLASS_PANE.get(), 16).pattern("XXX").pattern("XXX").define('X', BlockRegistry.LUMINOUS_CYAN_GLASS.get()).group(modGroup()).unlockedBy("europa_dust", has(ItemRegistry.EUROPA_DUST.get())).save(consumer);

		ShapedRecipeBuilder.shaped(BlockRegistry.REINFORCED_GLASS.get(), 4).pattern(" X ").pattern("XCX").pattern(" X ").define('X', Blocks.GLASS).define('C', Items.IRON_INGOT).group(modGroup()).unlockedBy("glass", has(Blocks.GLASS)).save(consumer);
		ShapedRecipeBuilder.shaped(BlockRegistry.REINFORCED_GLASS_PANE.get(), 16).pattern("XXX").pattern("XXX").define('X', BlockRegistry.REINFORCED_GLASS.get()).group(modGroup()).unlockedBy("glass", has(Blocks.GLASS)).save(consumer);

		ShapedRecipeBuilder.shaped(Items.GLASS, 8).pattern("GGG").pattern("GXG").pattern("GGG").define('X', ItemRegistry.STEEL_WOOL.get()).define('G', Tags.Items.STAINED_GLASS).group(modGroup()).unlockedBy("glass", has(Items.GLASS)).save(consumer, "glass_from_steel_wool");
		ShapedRecipeBuilder.shaped(Items.GLASS_PANE, 8).pattern("GGG").pattern("GXG").pattern("GGG").define('X', ItemRegistry.STEEL_WOOL.get()).define('G', Tags.Items.STAINED_GLASS_PANES).group(modGroup()).unlockedBy("glass", has(Items.GLASS)).save(consumer, "glass_pane_from_steel_wool");

		//CERAMIC
		WorkbenchCraftingRecipeBuilder.shaped(BlockRegistry.SILICA.get(), 4, Fluids.WATER, 0.25F, 0.0F).pattern("SS").pattern("SS").define('S', Tags.Items.SAND).group(modGroup()).unlockedBy("has_sand", has(Items.SAND)).save(consumer, "silica_from_workbench");
		smelting(BlockRegistry.SILICA.get(), BlockRegistry.CERAMIC.get(), 1.05F, 100, Blocks.SAND, consumer);

		ShapedRecipeBuilder.shaped(BlockRegistry.CERAMIC.get(), 8).pattern("GGG").pattern("GXG").pattern("GGG").define('X', ItemRegistry.STEEL_WOOL.get()).define('G', TagRegistry.Items.DYED_CERAMIC).group(modGroup()).unlockedBy("ceramic", has(BlockRegistry.CERAMIC.get())).save(consumer, "ceramic_from_steel_wool");
		ShapedRecipeBuilder.shaped(BlockRegistry.CERAMIC_TILE.get(), 8).pattern("GGG").pattern("GXG").pattern("GGG").define('X', ItemRegistry.STEEL_WOOL.get()).define('G', TagRegistry.Items.DYED_CERAMIC_TILE).group(modGroup()).unlockedBy("ceramic", has(BlockRegistry.CERAMIC.get())).save(consumer, "ceramic_tile_from_steel_wool");

		ShapedRecipeBuilder.shaped(BlockRegistry.WHITE_CERAMIC.get(), 8).pattern("XXX").pattern("X#X").pattern("XXX").define('X', BlockRegistry.CERAMIC.get()).define('#', Items.WHITE_DYE).group(modGroup()).unlockedBy("ceramic", has(BlockRegistry.CERAMIC.get())).save(consumer);
		ShapedRecipeBuilder.shaped(BlockRegistry.LIGHT_GREY_CERAMIC.get(), 8).pattern("XXX").pattern("X#X").pattern("XXX").define('X', BlockRegistry.CERAMIC.get()).define('#', Items.LIGHT_GRAY_DYE).group(modGroup()).unlockedBy("ceramic", has(BlockRegistry.CERAMIC.get())).save(consumer);
		ShapedRecipeBuilder.shaped(BlockRegistry.GREY_CERAMIC.get(), 8).pattern("XXX").pattern("X#X").pattern("XXX").define('X', BlockRegistry.CERAMIC.get()).define('#', Items.GRAY_DYE).group(modGroup()).unlockedBy("ceramic", has(BlockRegistry.CERAMIC.get())).save(consumer);
		ShapedRecipeBuilder.shaped(BlockRegistry.BLACK_CERAMIC.get(), 8).pattern("XXX").pattern("X#X").pattern("XXX").define('X', BlockRegistry.CERAMIC.get()).define('#', Items.BLACK_DYE).group(modGroup()).unlockedBy("ceramic", has(BlockRegistry.CERAMIC.get())).save(consumer);
		ShapedRecipeBuilder.shaped(BlockRegistry.PURPLE_CERAMIC.get(), 8).pattern("XXX").pattern("X#X").pattern("XXX").define('X', BlockRegistry.CERAMIC.get()).define('#', Items.PURPLE_DYE).group(modGroup()).unlockedBy("ceramic", has(BlockRegistry.CERAMIC.get())).save(consumer);
		ShapedRecipeBuilder.shaped(BlockRegistry.MAGENTA_CERAMIC.get(), 8).pattern("XXX").pattern("X#X").pattern("XXX").define('X', BlockRegistry.CERAMIC.get()).define('#', Items.MAGENTA_DYE).group(modGroup()).unlockedBy("ceramic", has(BlockRegistry.CERAMIC.get())).save(consumer);
		ShapedRecipeBuilder.shaped(BlockRegistry.BLUE_CERAMIC.get(), 8).pattern("XXX").pattern("X#X").pattern("XXX").define('X', BlockRegistry.CERAMIC.get()).define('#', Items.BLUE_DYE).group(modGroup()).unlockedBy("ceramic", has(BlockRegistry.CERAMIC.get())).save(consumer);
		ShapedRecipeBuilder.shaped(BlockRegistry.LIGHT_BLUE_CERAMIC.get(), 8).pattern("XXX").pattern("X#X").pattern("XXX").define('X', BlockRegistry.CERAMIC.get()).define('#', Items.LIGHT_BLUE_DYE).group(modGroup()).unlockedBy("ceramic", has(BlockRegistry.CERAMIC.get())).save(consumer);
		ShapedRecipeBuilder.shaped(BlockRegistry.CYAN_CERAMIC.get(), 8).pattern("XXX").pattern("X#X").pattern("XXX").define('X', BlockRegistry.CERAMIC.get()).define('#', Items.CYAN_DYE).group(modGroup()).unlockedBy("ceramic", has(BlockRegistry.CERAMIC.get())).save(consumer);
		ShapedRecipeBuilder.shaped(BlockRegistry.GREEN_CERAMIC.get(), 8).pattern("XXX").pattern("X#X").pattern("XXX").define('X', BlockRegistry.CERAMIC.get()).define('#', Items.GREEN_DYE).group(modGroup()).unlockedBy("ceramic", has(BlockRegistry.CERAMIC.get())).save(consumer);
		ShapedRecipeBuilder.shaped(BlockRegistry.LIME_CERAMIC.get(), 8).pattern("XXX").pattern("X#X").pattern("XXX").define('X', BlockRegistry.CERAMIC.get()).define('#', Items.LIME_DYE).group(modGroup()).unlockedBy("ceramic", has(BlockRegistry.CERAMIC.get())).save(consumer);
		ShapedRecipeBuilder.shaped(BlockRegistry.YELLOW_CERAMIC.get(), 8).pattern("XXX").pattern("X#X").pattern("XXX").define('X', BlockRegistry.CERAMIC.get()).define('#', Items.YELLOW_DYE).group(modGroup()).unlockedBy("ceramic", has(BlockRegistry.CERAMIC.get())).save(consumer);
		ShapedRecipeBuilder.shaped(BlockRegistry.ORANGE_CERAMIC.get(), 8).pattern("XXX").pattern("X#X").pattern("XXX").define('X', BlockRegistry.CERAMIC.get()).define('#', Items.ORANGE_DYE).group(modGroup()).unlockedBy("ceramic", has(BlockRegistry.CERAMIC.get())).save(consumer);
		ShapedRecipeBuilder.shaped(BlockRegistry.BROWN_CERAMIC.get(), 8).pattern("XXX").pattern("X#X").pattern("XXX").define('X', BlockRegistry.CERAMIC.get()).define('#', Items.BROWN_DYE).group(modGroup()).unlockedBy("ceramic", has(BlockRegistry.CERAMIC.get())).save(consumer);
		ShapedRecipeBuilder.shaped(BlockRegistry.RED_CERAMIC.get(), 8).pattern("XXX").pattern("X#X").pattern("XXX").define('X', BlockRegistry.CERAMIC.get()).define('#', Items.RED_DYE).group(modGroup()).unlockedBy("ceramic", has(BlockRegistry.CERAMIC.get())).save(consumer);
		ShapedRecipeBuilder.shaped(BlockRegistry.PINK_CERAMIC.get(), 8).pattern("XXX").pattern("X#X").pattern("XXX").define('X', BlockRegistry.CERAMIC.get()).define('#', Items.PINK_DYE).group(modGroup()).unlockedBy("ceramic", has(BlockRegistry.CERAMIC.get())).save(consumer);

		pane(BlockRegistry.CERAMIC.get(), BlockRegistry.CERAMIC_TILE.get(), BlockRegistry.CERAMIC.get(), consumer);
		pane(BlockRegistry.WHITE_CERAMIC.get(), BlockRegistry.WHITE_CERAMIC_TILE.get(), BlockRegistry.CERAMIC.get(), consumer);
		pane(BlockRegistry.LIGHT_GREY_CERAMIC.get(), BlockRegistry.LIGHT_GREY_CERAMIC_TILE.get(), BlockRegistry.CERAMIC.get(), consumer);
		pane(BlockRegistry.GREY_CERAMIC.get(), BlockRegistry.GREY_CERAMIC_TILE.get(), BlockRegistry.CERAMIC.get(), consumer);
		pane(BlockRegistry.BLACK_CERAMIC.get(), BlockRegistry.BLACK_CERAMIC_TILE.get(), BlockRegistry.CERAMIC.get(), consumer);
		pane(BlockRegistry.PURPLE_CERAMIC.get(), BlockRegistry.PURPLE_CERAMIC_TILE.get(), BlockRegistry.CERAMIC.get(), consumer);
		pane(BlockRegistry.MAGENTA_CERAMIC.get(), BlockRegistry.MAGENTA_CERAMIC_TILE.get(), BlockRegistry.CERAMIC.get(), consumer);
		pane(BlockRegistry.BLUE_CERAMIC.get(), BlockRegistry.BLUE_CERAMIC_TILE.get(), BlockRegistry.CERAMIC.get(), consumer);
		pane(BlockRegistry.LIGHT_BLUE_CERAMIC.get(), BlockRegistry.LIGHT_BLUE_CERAMIC_TILE.get(), BlockRegistry.CERAMIC.get(), consumer);
		pane(BlockRegistry.CYAN_CERAMIC.get(), BlockRegistry.CYAN_CERAMIC_TILE.get(), BlockRegistry.CERAMIC.get(), consumer);
		pane(BlockRegistry.GREEN_CERAMIC.get(), BlockRegistry.GREEN_CERAMIC_TILE.get(), BlockRegistry.CERAMIC.get(), consumer);
		pane(BlockRegistry.LIME_CERAMIC.get(), BlockRegistry.LIME_CERAMIC_TILE.get(), BlockRegistry.CERAMIC.get(), consumer);
		pane(BlockRegistry.YELLOW_CERAMIC.get(), BlockRegistry.YELLOW_CERAMIC_TILE.get(), BlockRegistry.CERAMIC.get(), consumer);
		pane(BlockRegistry.ORANGE_CERAMIC.get(), BlockRegistry.ORANGE_CERAMIC_TILE.get(), BlockRegistry.CERAMIC.get(), consumer);
		pane(BlockRegistry.BROWN_CERAMIC.get(), BlockRegistry.BROWN_CERAMIC_TILE.get(), BlockRegistry.CERAMIC.get(), consumer);
		pane(BlockRegistry.RED_CERAMIC.get(), BlockRegistry.RED_CERAMIC_TILE.get(), BlockRegistry.CERAMIC.get(), consumer);
		pane(BlockRegistry.PINK_CERAMIC.get(), BlockRegistry.PINK_CERAMIC_TILE.get(), BlockRegistry.CERAMIC.get(), consumer);

		smelting(BlockRegistry.WHITE_CERAMIC.get(), BlockRegistry.PAINTED_WHITE_CERAMIC.get(), 1.0F, 100, BlockRegistry.CERAMIC.get(), consumer);
		smelting(BlockRegistry.LIGHT_GREY_CERAMIC.get(), BlockRegistry.PAINTED_LIGHT_GREY_CERAMIC.get(), 1.0F, 100, BlockRegistry.CERAMIC.get(), consumer);
		smelting(BlockRegistry.GREY_CERAMIC.get(), BlockRegistry.PAINTED_GREY_CERAMIC.get(), 1.0F, 100, BlockRegistry.CERAMIC.get(), consumer);
		smelting(BlockRegistry.BLACK_CERAMIC.get(), BlockRegistry.PAINTED_BLACK_CERAMIC.get(), 1.0F, 100, BlockRegistry.CERAMIC.get(), consumer);
		smelting(BlockRegistry.PURPLE_CERAMIC.get(), BlockRegistry.PAINTED_PURPLE_CERAMIC.get(), 1.0F, 100, BlockRegistry.CERAMIC.get(), consumer);
		smelting(BlockRegistry.MAGENTA_CERAMIC.get(), BlockRegistry.PAINTED_MAGENTA_CERAMIC.get(), 1.0F, 100, BlockRegistry.CERAMIC.get(), consumer);
		smelting(BlockRegistry.BLUE_CERAMIC.get(), BlockRegistry.PAINTED_BLUE_CERAMIC.get(), 1.0F, 100, BlockRegistry.CERAMIC.get(), consumer);
		smelting(BlockRegistry.LIGHT_BLUE_CERAMIC.get(), BlockRegistry.PAINTED_LIGHT_BLUE_CERAMIC.get(), 1.0F, 100, BlockRegistry.CERAMIC.get(), consumer);
		smelting(BlockRegistry.CYAN_CERAMIC.get(), BlockRegistry.PAINTED_CYAN_CERAMIC.get(), 1.0F, 100, BlockRegistry.CERAMIC.get(), consumer);
		smelting(BlockRegistry.GREEN_CERAMIC.get(), BlockRegistry.PAINTED_GREEN_CERAMIC.get(), 1.0F, 100, BlockRegistry.CERAMIC.get(), consumer);
		smelting(BlockRegistry.LIME_CERAMIC.get(), BlockRegistry.PAINTED_LIME_CERAMIC.get(), 1.0F, 100, BlockRegistry.CERAMIC.get(), consumer);
		smelting(BlockRegistry.YELLOW_CERAMIC.get(), BlockRegistry.PAINTED_YELLOW_CERAMIC.get(), 1.0F, 100, BlockRegistry.CERAMIC.get(), consumer);
		smelting(BlockRegistry.ORANGE_CERAMIC.get(), BlockRegistry.PAINTED_ORANGE_CERAMIC.get(), 1.0F, 100, BlockRegistry.CERAMIC.get(), consumer);
		smelting(BlockRegistry.BROWN_CERAMIC.get(), BlockRegistry.PAINTED_BROWN_CERAMIC.get(), 1.0F, 100, BlockRegistry.CERAMIC.get(), consumer);
		smelting(BlockRegistry.RED_CERAMIC.get(), BlockRegistry.PAINTED_RED_CERAMIC.get(), 1.0F, 100, BlockRegistry.CERAMIC.get(), consumer);
		smelting(BlockRegistry.PINK_CERAMIC.get(), BlockRegistry.PAINTED_PINK_CERAMIC.get(), 1.0F, 100, BlockRegistry.CERAMIC.get(), consumer);

		//---- FOOD -------------------------------------------------------------------------------
		ShapedRecipeBuilder.shaped(ItemRegistry.MARSHMALLOW.get()).pattern("XX").pattern("XX").define('X', ItemRegistry.MARSHMALLOW_GOO.get()).group(modGroup()).unlockedBy("marshmallow_goo", has(ItemRegistry.MARSHMALLOW_GOO.get())).save(consumer, "marshmallow_from_marshmallow_goo");
		ShapelessRecipeBuilder.shapeless(ItemRegistry.MARSHMALLOW.get(), 2).requires(Items.SUGAR).requires(Items.MILK_BUCKET).requires(Items.SUGAR).requires(Items.SUGAR).group(modGroup()).unlockedBy("sugar", has(Items.SUGAR)).save(consumer);
		ShapelessRecipeBuilder.shapeless(ItemRegistry.CHOCOLATE.get()).requires(Items.SUGAR).requires(Items.MILK_BUCKET).requires(Items.COCOA_BEANS).group(modGroup()).unlockedBy("cocoa_beans", has(Items.COCOA_BEANS)).save(consumer);
		ShapedRecipeBuilder.shaped(ItemRegistry.CRACKER.get(), 4).pattern("X").pattern("X").define('X', Items.WHEAT).group(modGroup()).unlockedBy("wheat", has(Items.WHEAT)).save(consumer);
		smelting(ItemRegistry.MARSHMALLOW.get(), ItemRegistry.ROASTED_MARSHMALLOW.get(), 0.1F, 100, ItemRegistry.MARSHMALLOW_GOO.get(), consumer);
		ShapelessRecipeBuilder.shapeless(ItemRegistry.SMORES.get()).requires(ItemRegistry.ROASTED_MARSHMALLOW.get()).requires(ItemRegistry.CHOCOLATE.get()).requires(ItemRegistry.CRACKER.get()).requires(ItemRegistry.CRACKER.get()).group(modGroup()).unlockedBy("marshmallow_goo", has(ItemRegistry.MARSHMALLOW_GOO.get())).save(consumer);
		ShapelessRecipeBuilder.shapeless(ItemRegistry.LUNAR_CHEESE.get()).requires(ItemRegistry.LUNAR_GOO.get()).requires(Items.MILK_BUCKET).group(modGroup()).unlockedBy("lunar_goo", has(ItemRegistry.LUNAR_GOO.get())).save(consumer);
		ShapelessRecipeBuilder.shapeless(ItemRegistry.CHEESE.get()).requires(Items.MILK_BUCKET).requires(Items.MILK_BUCKET).group(modGroup()).unlockedBy("milk", has(Items.MILK_BUCKET)).save(consumer);
		ShapelessRecipeBuilder.shapeless(ItemRegistry.SUSPICIOUS_JELLO.get()).requires(TagRegistry.Items.SLIME_DROPS).requires(Items.SUGAR).group("celestialquests").unlockedBy("slime_ball", has(Items.SLIME_BALL)).save(consumer);

		//---- MISC -------------------------------------------------------------------------------
		ingotAndBlock(Items.COBBLESTONE, BlockRegistry.COMPRESSED_COBBLESTONE.get(), Items.COBBLESTONE, consumer);
		ingotAndBlock(Items.COBBLED_DEEPSLATE, BlockRegistry.COMPRESSED_COBBLED_DEEPSLATE.get(), Items.COBBLED_DEEPSLATE, consumer);
		ingotAndBlock(Items.NETHERRACK, BlockRegistry.COMPRESSED_NETHERRACK.get(), Items.NETHERRACK, consumer);
		ingotAndBlock(BlockRegistry.COMPRESSED_COBBLESTONE.get(), BlockRegistry.SUPER_COMPRESSED_COBBLESTONE.get(), BlockRegistry.COMPRESSED_COBBLESTONE.get(), consumer);
		ingotAndBlock(BlockRegistry.COMPRESSED_COBBLED_DEEPSLATE.get(), BlockRegistry.SUPER_COMPRESSED_COBBLED_DEEPSLATE.get(), BlockRegistry.COMPRESSED_COBBLED_DEEPSLATE.get(), consumer);
		ingotAndBlock(BlockRegistry.COMPRESSED_NETHERRACK.get(), BlockRegistry.SUPER_COMPRESSED_NETHERRACK.get(), BlockRegistry.COMPRESSED_NETHERRACK.get(), consumer);

		ShapelessRecipeBuilder.shapeless(BlockRegistry.PLANET_CHART.get()).requires(ItemTags.PLANKS).requires(Items.PAPER).requires(Items.BLACK_DYE).group(modGroup()).unlockedBy("crafting_table", has(Items.CRAFTING_TABLE)).save(consumer);

	}

	private static String name(Item item) {
		return item.getRegistryName().getPath();
	}

	private static String name(Block block) {
		return block.getRegistryName().getPath();
	}


	private static String modGroup() {
		return "celestialexploration";
	}
}