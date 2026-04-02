package com.shim.celestialexploration.datagen;

import java.util.function.Consumer;

import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestialexploration.datagen.util.WorkbenchCraftingRecipeBuilder;
import com.shim.celestialexploration.datagen.util.WorkbenchSmeltingRecipeBuilder;
import com.shim.celestialexploration.registry.CelestialBlocks;

import com.shim.celestialexploration.registry.CelestialFluids;
import com.shim.celestialexploration.registry.CelestialItems;
import com.shim.celestialexploration.registry.CelestialTags;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.*;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluids;
import net.minecraftforge.common.Tags;

import static com.shim.celestiallib.api.datagen.base.RecipeGenHelper.*;


public class CelestialRecipeGen extends RecipeProvider {

	public CelestialRecipeGen(DataGenerator generatorIn) {
		super(generatorIn);
	}
	
	@Override
	protected void buildCraftingRecipes(Consumer<FinishedRecipe> consumer) {

		//---- MOON -------------------------------------------------------------------------------
		//STONE
		bricksCraftAndStonecutting(CelestialBlocks.MOON_STONE.get(), CelestialBlocks.MOON_BRICKS.get(), CelestialBlocks.MOON_STONE.get(), consumer);
		stairsSlabWallCraftStonecutting(CelestialBlocks.MOON_BRICKS.get(), CelestialTags.Items.MOON_STONE, CelestialBlocks.MOON_BRICK_STAIRS.get(), CelestialBlocks.MOON_BRICK_SLAB.get(), CelestialBlocks.MOON_BRICK_WALL.get(), CelestialBlocks.MOON_STONE.get(), consumer);
		ShapedRecipeBuilder.shaped(CelestialBlocks.CHISELED_MOON_BRICKS.get()).pattern("X").pattern("X").define('X', CelestialBlocks.MOON_BRICK_SLAB.get()).unlockedBy("moon_stone", has(CelestialBlocks.MOON_STONE.get())).save(consumer);
		smelting(CelestialBlocks.MOON_BRICKS.get(), CelestialBlocks.CRACKED_MOON_BRICKS.get(), 0.1F, 200, CelestialBlocks.MOON_BRICKS.get(), consumer);

		stonecutting(CelestialBlocks.MOON_STONE.get(), CelestialBlocks.CHISELED_MOON_BRICKS.get(), 1, CelestialBlocks.MOON_BRICKS.get(), consumer);
		ShapedRecipeBuilder.shaped(CelestialBlocks.MOON_BRICK_PILLAR.get(), 4).pattern("X").pattern("X").define('X', CelestialBlocks.MOON_BRICKS.get()).unlockedBy("moon_stone", has(CelestialBlocks.MOON_STONE.get())).save(consumer);
		stonecutting(CelestialBlocks.MOON_STONE.get(), CelestialBlocks.MOON_BRICK_PILLAR.get(), 1, CelestialBlocks.MOON_STONE.get(), consumer);
		smelting(CelestialBlocks.MOON_COBBLESTONE.get(), CelestialBlocks.MOON_STONE.get(), 0.1F, 200, CelestialBlocks.MOON_COBBLESTONE.get(), consumer);
		smelting(CelestialBlocks.MOON_COBBLED_DEEPSLATE.get(), CelestialBlocks.MOON_DEEPSLATE.get(), 0.1F, 200, CelestialBlocks.MOON_COBBLED_DEEPSLATE.get(), consumer);
		stairsCraftAndStonecutting(CelestialBlocks.MOON_STONE.get(), CelestialBlocks.MOON_STONE_STAIRS.get(), CelestialBlocks.MOON_STONE.get(), consumer);
		slabCraftAndStonecutting(CelestialBlocks.MOON_STONE.get(), CelestialBlocks.MOON_STONE_SLAB.get(), CelestialBlocks.MOON_STONE.get(), consumer);
		stairsSlabWallCraftStonecutting(CelestialBlocks.MOON_COBBLESTONE.get(), CelestialTags.Items.MOON_COBBLESTONE, CelestialBlocks.MOON_COBBLESTONE_STAIRS.get(), CelestialBlocks.MOON_COBBLESTONE_SLAB.get(), CelestialBlocks.MOON_COBBLESTONE_WALL.get(), CelestialBlocks.MOON_COBBLESTONE.get(), consumer);
		smelting(CelestialBlocks.MOON_STONE.get(), CelestialBlocks.MOON_SMOOTH_STONE.get(), 0.1F, 200, CelestialBlocks.MOON_STONE.get(), consumer);
		ShapedRecipeBuilder.shaped(CelestialBlocks.MOON_SMOOTH_STONE_SLAB.get(), 6).pattern("XXX").define('X', CelestialBlocks.MOON_SMOOTH_STONE.get()).unlockedBy("has_moon_smooth_stone", has(CelestialBlocks.MOON_STONE.get())).save(consumer);
		stonecutting(CelestialBlocks.MOON_SMOOTH_STONE.get(), CelestialBlocks.MOON_SMOOTH_STONE_SLAB.get(), 2, CelestialBlocks.MOON_SMOOTH_STONE.get(), consumer);
		singleItem(CelestialBlocks.MOON_STONE.get(), CelestialBlocks.MOON_STONE_BUTTON.get(), 1, CelestialBlocks.MOON_STONE.get(), consumer);
		ShapedRecipeBuilder.shaped(CelestialBlocks.MOON_STONE_PRESSURE_PLATE.get()).pattern("XX").define('X', CelestialBlocks.MOON_STONE.get()).unlockedBy("moon_stone", has(CelestialBlocks.MOON_STONE.get())).save(consumer);
		singleItem(CelestialBlocks.MOON_DEEPSLATE.get(), CelestialBlocks.MOON_DEEPSLATE_BUTTON.get(), 1, CelestialBlocks.MOON_STONE.get(), consumer);
		ShapedRecipeBuilder.shaped(CelestialBlocks.MOON_DEEPSLATE_PRESSURE_PLATE.get()).pattern("XX").define('X', CelestialBlocks.MOON_DEEPSLATE.get()).unlockedBy("moon_deepslate", has(CelestialBlocks.MOON_DEEPSLATE.get())).save(consumer);
		ingotAndBlock(CelestialBlocks.MOON_COBBLESTONE.get(), CelestialBlocks.COMPRESSED_MOON_COBBLESTONE.get(), CelestialBlocks.MOON_COBBLESTONE.get(), consumer);
		ingotAndBlock(CelestialBlocks.COMPRESSED_MOON_COBBLESTONE.get(), CelestialBlocks.SUPER_COMPRESSED_MOON_COBBLESTONE.get(), CelestialBlocks.COMPRESSED_MOON_COBBLESTONE.get(), consumer);

		//DEEPSLATE
		stairsSlabWallCraftStonecutting(CelestialBlocks.MOON_COBBLED_DEEPSLATE.get(), CelestialBlocks.MOON_COBBLED_DEEPSLATE_STAIRS.get(), CelestialBlocks.MOON_COBBLED_DEEPSLATE_SLAB.get(), CelestialBlocks.MOON_COBBLED_DEEPSLATE_WALL.get(), CelestialBlocks.MOON_COBBLED_DEEPSLATE.get(), consumer);
		deepslateBricks(CelestialBlocks.MOON_COBBLED_DEEPSLATE.get(), CelestialBlocks.MOON_POLISHED_DEEPSLATE.get(), CelestialBlocks.MOON_DEEPSLATE_BRICKS.get(), CelestialBlocks.MOON_DEEPSLATE_BRICK_STAIRS.get(), CelestialBlocks.MOON_DEEPSLATE_BRICK_SLAB.get(), CelestialBlocks.MOON_DEEPSLATE_BRICK_WALL.get(), CelestialBlocks.MOON_COBBLED_DEEPSLATE.get(), consumer);
		deepslateTiles(CelestialBlocks.MOON_COBBLED_DEEPSLATE.get(), CelestialBlocks.MOON_POLISHED_DEEPSLATE.get(), CelestialBlocks.MOON_DEEPSLATE_BRICKS.get(), CelestialBlocks.MOON_DEEPSLATE_TILES.get(), CelestialBlocks.MOON_DEEPSLATE_TILE_STAIRS.get(), CelestialBlocks.MOON_DEEPSLATE_TILE_SLAB.get(), CelestialBlocks.MOON_DEEPSLATE_TILE_WALL.get(), CelestialBlocks.MOON_COBBLED_DEEPSLATE.get(), consumer);
		polishedDeepslate(CelestialBlocks.MOON_COBBLED_DEEPSLATE.get(), CelestialBlocks.MOON_POLISHED_DEEPSLATE.get(), CelestialBlocks.MOON_POLISHED_DEEPSLATE_STAIRS.get(), CelestialBlocks.MOON_POLISHED_DEEPSLATE_SLAB.get(), CelestialBlocks.MOON_POLISHED_DEEPSLATE_WALL.get(), CelestialBlocks.MOON_COBBLED_DEEPSLATE.get(), consumer);
		ShapedRecipeBuilder.shaped(CelestialBlocks.CHISELED_MOON_DEEPSLATE_BRICKS.get()).pattern("X").pattern("X").define('X', CelestialBlocks.MOON_COBBLED_DEEPSLATE_SLAB.get()).unlockedBy("has_moon_cobbled_deepslate", has(CelestialBlocks.MOON_COBBLED_DEEPSLATE.get())).save(consumer);
		stonecutting(CelestialTags.Items.MOON_COBBLED_DEEPSLATE, CelestialBlocks.CHISELED_MOON_DEEPSLATE_BRICKS.get(), 1, CelestialBlocks.MOON_COBBLED_DEEPSLATE.get(), consumer);
		smelting(CelestialBlocks.MOON_DEEPSLATE_BRICKS.get(), CelestialBlocks.CRACKED_MOON_DEEPSLATE_BRICKS.get(), 0.1F, 200, CelestialBlocks.MOON_DEEPSLATE_BRICKS.get(), consumer);
		smelting(CelestialBlocks.MOON_DEEPSLATE_TILES.get(), CelestialBlocks.CRACKED_MOON_DEEPSLATE_TILES.get(), 0.1F, 200, CelestialBlocks.MOON_DEEPSLATE_TILES.get(), consumer);
		ingotAndBlock(CelestialBlocks.MOON_COBBLED_DEEPSLATE.get(), CelestialBlocks.COMPRESSED_MOON_COBBLED_DEEPSLATE.get(), CelestialBlocks.MOON_COBBLED_DEEPSLATE.get(), consumer);
		ingotAndBlock(CelestialBlocks.COMPRESSED_MOON_COBBLED_DEEPSLATE.get(), CelestialBlocks.SUPER_COMPRESSED_MOON_COBBLED_DEEPSLATE.get(), CelestialBlocks.COMPRESSED_MOON_COBBLED_DEEPSLATE.get(), consumer);

		//OTHER
		smelting(CelestialBlocks.MOON_SAND.get(), Items.WHITE_STAINED_GLASS, 0.1F, 200, CelestialBlocks.MOON_SAND.get(), consumer);
		ShapedRecipeBuilder.shaped(CelestialBlocks.LUNAR_LANTERN.get()).pattern("XCX").pattern("C#C").pattern("XCX").define('X', CelestialBlocks.MOON_STONE.get()).define('#', Items.IRON_INGOT).define('C', CelestialItems.MOON_DUST.get()).unlockedBy("has_moon_dust", has(CelestialItems.MOON_DUST.get())).save(consumer);

		ShapedRecipeBuilder.shaped(CelestialBlocks.MOON_CHEST.get()).pattern("XXX").pattern("X X").pattern("XXX").define('X', CelestialBlocks.MOON_STONE.get()).unlockedBy("has_moon_cobblestone", has(CelestialBlocks.MOON_COBBLESTONE.get())).save(consumer);

		ShapedRecipeBuilder.shaped(CelestialBlocks.MOON_FARMLAND.get(), 4).pattern("XBX").pattern("XCX").define('X', CelestialBlocks.MOON_SAND.get()).define('B', Items.BONE_MEAL).define('C', Items.COAL).unlockedBy("has_moon_sand", has(CelestialBlocks.MOON_SAND.get())).save(consumer);


		//---- MARS -------------------------------------------------------------------------------
		//STONE
		bricksCraftAndStonecutting(CelestialBlocks.MARS_STONE.get(), CelestialBlocks.MARS_BRICKS.get(), CelestialBlocks.MARS_STONE.get(), consumer);
		stairsSlabWallCraftStonecutting(CelestialBlocks.MARS_BRICKS.get(), CelestialTags.Items.MARS_STONE, CelestialBlocks.MARS_BRICK_STAIRS.get(), CelestialBlocks.MARS_BRICK_SLAB.get(), CelestialBlocks.MARS_BRICK_WALL.get(), CelestialBlocks.MARS_STONE.get(), consumer);
		ShapedRecipeBuilder.shaped(CelestialBlocks.CHISELED_MARS_BRICKS.get()).pattern("X").pattern("X").define('X', CelestialBlocks.MARS_BRICK_SLAB.get()).unlockedBy("mars_stone", has(CelestialBlocks.MARS_STONE.get())).save(consumer);
		smelting(CelestialBlocks.MARS_BRICKS.get(), CelestialBlocks.CRACKED_MARS_BRICKS.get(), 0.1F, 200, CelestialBlocks.MARS_BRICKS.get(), consumer);
		stonecutting(CelestialBlocks.MARS_STONE.get(), CelestialBlocks.CHISELED_MARS_BRICKS.get(), 1, CelestialBlocks.MARS_BRICKS.get(), consumer);
		ShapedRecipeBuilder.shaped(CelestialBlocks.MARS_BRICK_PILLAR.get(), 4).pattern("X").pattern("X").define('X', CelestialBlocks.MARS_BRICKS.get()).unlockedBy("mars_stone", has(CelestialBlocks.MARS_STONE.get())).save(consumer);
		stonecutting(CelestialBlocks.MARS_STONE.get(), CelestialBlocks.MARS_BRICK_PILLAR.get(), 1, CelestialBlocks.MARS_STONE.get(), consumer);
		smelting(CelestialBlocks.MARS_COBBLESTONE.get(), CelestialBlocks.MARS_STONE.get(), 0.1F, 200, CelestialBlocks.MARS_COBBLESTONE.get(), consumer);
		smelting(CelestialBlocks.MARS_COBBLED_DEEPSLATE.get(), CelestialBlocks.MARS_DEEPSLATE.get(), 0.1F, 200, CelestialBlocks.MARS_COBBLED_DEEPSLATE.get(), consumer);
		stairsCraftAndStonecutting(CelestialBlocks.MARS_STONE.get(), CelestialBlocks.MARS_STONE_STAIRS.get(), CelestialBlocks.MARS_STONE.get(), consumer);
		slabCraftAndStonecutting(CelestialBlocks.MARS_STONE.get(), CelestialBlocks.MARS_STONE_SLAB.get(), CelestialBlocks.MARS_STONE.get(), consumer);
		stairsSlabWallCraftStonecutting(CelestialBlocks.MARS_COBBLESTONE.get(), CelestialTags.Items.MARS_COBBLESTONE, CelestialBlocks.MARS_COBBLESTONE_STAIRS.get(), CelestialBlocks.MARS_COBBLESTONE_SLAB.get(), CelestialBlocks.MARS_COBBLESTONE_WALL.get(), CelestialBlocks.MARS_COBBLESTONE.get(), consumer);
		smelting(CelestialBlocks.MARS_STONE.get(), CelestialBlocks.MARS_SMOOTH_STONE.get(), 0.1F, 200, CelestialBlocks.MARS_STONE.get(), consumer);
		ShapedRecipeBuilder.shaped(CelestialBlocks.MARS_SMOOTH_STONE_SLAB.get(), 6).pattern("XXX").define('X', CelestialBlocks.MARS_SMOOTH_STONE.get()).unlockedBy("has_mars_smooth_stone", has(CelestialBlocks.MARS_STONE.get())).save(consumer);
		stonecutting(CelestialBlocks.MARS_SMOOTH_STONE.get(), CelestialBlocks.MARS_SMOOTH_STONE_SLAB.get(), 2, CelestialBlocks.MARS_SMOOTH_STONE.get(), consumer);
		singleItem(CelestialBlocks.MARS_STONE.get(), CelestialBlocks.MARS_STONE_BUTTON.get(), 1, CelestialBlocks.MARS_STONE.get(), consumer);
		ShapedRecipeBuilder.shaped(CelestialBlocks.MARS_STONE_PRESSURE_PLATE.get()).pattern("XX").define('X', CelestialBlocks.MARS_STONE.get()).unlockedBy("mars_stone", has(CelestialBlocks.MARS_STONE.get())).save(consumer);
		singleItem(CelestialBlocks.MARS_DEEPSLATE.get(), CelestialBlocks.MARS_DEEPSLATE_BUTTON.get(), 1, CelestialBlocks.MARS_STONE.get(), consumer);
		ShapedRecipeBuilder.shaped(CelestialBlocks.MARS_DEEPSLATE_PRESSURE_PLATE.get()).pattern("XX").define('X', CelestialBlocks.MARS_DEEPSLATE.get()).unlockedBy("mars_deepslate", has(CelestialBlocks.MARS_DEEPSLATE.get())).save(consumer);
		ingotAndBlock(CelestialBlocks.MARS_COBBLESTONE.get(), CelestialBlocks.COMPRESSED_MARS_COBBLESTONE.get(), CelestialBlocks.MARS_COBBLESTONE.get(), consumer);
		ingotAndBlock(CelestialBlocks.COMPRESSED_MARS_COBBLESTONE.get(), CelestialBlocks.SUPER_COMPRESSED_MARS_COBBLESTONE.get(), CelestialBlocks.COMPRESSED_MARS_COBBLESTONE.get(), consumer);

		//DEEPSLATE
		stairsSlabWallCraftStonecutting(CelestialBlocks.MARS_COBBLED_DEEPSLATE.get(), CelestialBlocks.MARS_COBBLED_DEEPSLATE_STAIRS.get(), CelestialBlocks.MARS_COBBLED_DEEPSLATE_SLAB.get(), CelestialBlocks.MARS_COBBLED_DEEPSLATE_WALL.get(), CelestialBlocks.MARS_COBBLED_DEEPSLATE.get(), consumer);
		deepslateBricks(CelestialBlocks.MARS_COBBLED_DEEPSLATE.get(), CelestialBlocks.MARS_POLISHED_DEEPSLATE.get(), CelestialBlocks.MARS_DEEPSLATE_BRICKS.get(), CelestialBlocks.MARS_DEEPSLATE_BRICK_STAIRS.get(), CelestialBlocks.MARS_DEEPSLATE_BRICK_SLAB.get(), CelestialBlocks.MARS_DEEPSLATE_BRICK_WALL.get(), CelestialBlocks.MARS_COBBLED_DEEPSLATE.get(), consumer);
		deepslateTiles(CelestialBlocks.MARS_COBBLED_DEEPSLATE.get(), CelestialBlocks.MARS_POLISHED_DEEPSLATE.get(), CelestialBlocks.MARS_DEEPSLATE_BRICKS.get(), CelestialBlocks.MARS_DEEPSLATE_TILES.get(), CelestialBlocks.MARS_DEEPSLATE_TILE_STAIRS.get(), CelestialBlocks.MARS_DEEPSLATE_TILE_SLAB.get(), CelestialBlocks.MARS_DEEPSLATE_TILE_WALL.get(), CelestialBlocks.MARS_COBBLED_DEEPSLATE.get(), consumer);
		polishedDeepslate(CelestialBlocks.MARS_COBBLED_DEEPSLATE.get(), CelestialBlocks.MARS_POLISHED_DEEPSLATE.get(), CelestialBlocks.MARS_POLISHED_DEEPSLATE_STAIRS.get(), CelestialBlocks.MARS_POLISHED_DEEPSLATE_SLAB.get(), CelestialBlocks.MARS_POLISHED_DEEPSLATE_WALL.get(), CelestialBlocks.MARS_COBBLED_DEEPSLATE.get(), consumer);
		ShapedRecipeBuilder.shaped(CelestialBlocks.CHISELED_MARS_DEEPSLATE_BRICKS.get()).pattern("X").pattern("X").define('X', CelestialBlocks.MARS_COBBLED_DEEPSLATE_SLAB.get()).unlockedBy("has_mars_cobbled_deepslate", has(CelestialBlocks.MARS_COBBLED_DEEPSLATE.get())).save(consumer);
		stonecutting(CelestialTags.Items.MARS_COBBLED_DEEPSLATE, CelestialBlocks.CHISELED_MARS_DEEPSLATE_BRICKS.get(), 1, CelestialBlocks.MARS_COBBLED_DEEPSLATE.get(), consumer);
		smelting(CelestialBlocks.MARS_DEEPSLATE_BRICKS.get(), CelestialBlocks.CRACKED_MARS_DEEPSLATE_BRICKS.get(), 0.1F, 200, CelestialBlocks.MARS_DEEPSLATE_BRICKS.get(), consumer);
		smelting(CelestialBlocks.MARS_DEEPSLATE_TILES.get(), CelestialBlocks.CRACKED_MARS_DEEPSLATE_TILES.get(), 0.1F, 200, CelestialBlocks.MARS_DEEPSLATE_TILES.get(), consumer);
		ingotAndBlock(CelestialBlocks.MARS_COBBLED_DEEPSLATE.get(), CelestialBlocks.COMPRESSED_MARS_COBBLED_DEEPSLATE.get(), CelestialBlocks.MARS_COBBLED_DEEPSLATE.get(), consumer);
		ingotAndBlock(CelestialBlocks.COMPRESSED_MARS_COBBLED_DEEPSLATE.get(), CelestialBlocks.SUPER_COMPRESSED_MARS_COBBLED_DEEPSLATE.get(), CelestialBlocks.COMPRESSED_MARS_COBBLED_DEEPSLATE.get(), consumer);

		smelting(CelestialBlocks.MARS_SAND.get(), Items.ORANGE_STAINED_GLASS, 0.1F, 200, CelestialBlocks.MARS_SAND.get(), consumer);
		ShapedRecipeBuilder.shaped(CelestialBlocks.MARS_LANTERN.get()).pattern("XCX").pattern("C#C").pattern("XCX").define('X', CelestialBlocks.MARS_STONE.get()).define('C', Items.IRON_INGOT).define('#', Items.TORCH).unlockedBy("has_iron", has(Items.IRON_INGOT)).save(consumer);
		ShapedRecipeBuilder.shaped(CelestialBlocks.MARS_CHEST.get()).pattern("XXX").pattern("X X").pattern("XXX").define('X', CelestialBlocks.MARS_STONE.get()).unlockedBy("has_mars_cobblestone", has(CelestialBlocks.MARS_COBBLESTONE.get())).save(consumer);

		ShapedRecipeBuilder.shaped(CelestialBlocks.MARS_FARMLAND.get(), 4).pattern("XBX").pattern("XCX").define('X', CelestialBlocks.MARS_SAND.get()).define('B', Items.BONE_MEAL).define('C', Items.COAL).unlockedBy("has_mars_sand", has(CelestialBlocks.MARS_SAND.get())).save(consumer);


		//---- VENUS -------------------------------------------------------------------------------
		//STONE
		bricksCraftAndStonecutting(CelestialBlocks.VENUS_STONE.get(), CelestialBlocks.VENUS_BRICKS.get(), CelestialBlocks.VENUS_STONE.get(), consumer);
		stairsSlabWallCraftStonecutting(CelestialBlocks.VENUS_BRICKS.get(), CelestialTags.Items.VENUS_STONE, CelestialBlocks.VENUS_BRICK_STAIRS.get(), CelestialBlocks.VENUS_BRICK_SLAB.get(), CelestialBlocks.VENUS_BRICK_WALL.get(), CelestialBlocks.VENUS_STONE.get(), consumer);
		ShapedRecipeBuilder.shaped(CelestialBlocks.CHISELED_VENUS_BRICKS.get()).pattern("X").pattern("X").define('X', CelestialBlocks.VENUS_BRICK_SLAB.get()).unlockedBy("venus_stone", has(CelestialBlocks.VENUS_STONE.get())).save(consumer);
		stonecutting(CelestialBlocks.VENUS_STONE.get(), CelestialBlocks.CHISELED_VENUS_BRICKS.get(), 1, CelestialBlocks.VENUS_BRICKS.get(), consumer);
		smelting(CelestialBlocks.VENUS_BRICKS.get(), CelestialBlocks.CRACKED_VENUS_BRICKS.get(), 0.1F, 200, CelestialBlocks.VENUS_BRICKS.get(), consumer);

		ShapedRecipeBuilder.shaped(CelestialBlocks.VENUS_BRICK_PILLAR.get(), 4).pattern("X").pattern("X").define('X', CelestialBlocks.VENUS_BRICKS.get()).unlockedBy("venus_stone", has(CelestialBlocks.VENUS_STONE.get())).save(consumer);

		stonecutting(CelestialBlocks.VENUS_BRICKS.get(), CelestialBlocks.SMALL_VENUS_BRICKS.get(), 1, CelestialBlocks.VENUS_COBBLESTONE.get(), consumer);
		stairsSlabWallCraftStonecutting(CelestialBlocks.SMALL_VENUS_BRICKS.get(), CelestialBlocks.SMALL_VENUS_BRICK_STAIRS.get(), CelestialBlocks.SMALL_VENUS_BRICK_SLAB.get(), CelestialBlocks.SMALL_VENUS_BRICK_WALL.get(), CelestialBlocks.VENUS_COBBLESTONE.get(), consumer);

		stonecutting(CelestialBlocks.VENUS_STONE.get(), CelestialBlocks.VENUS_BRICK_PILLAR.get(), 1, CelestialBlocks.VENUS_STONE.get(), consumer);
		smelting(CelestialBlocks.VENUS_COBBLESTONE.get(), CelestialBlocks.VENUS_STONE.get(), 0.1F, 200, CelestialBlocks.VENUS_COBBLESTONE.get(), consumer);
		smelting(CelestialBlocks.VENUS_COBBLED_DEEPSLATE.get(), CelestialBlocks.VENUS_DEEPSLATE.get(), 0.1F, 200, CelestialBlocks.VENUS_COBBLED_DEEPSLATE.get(), consumer);
		stairsCraftAndStonecutting(CelestialBlocks.VENUS_STONE.get(), CelestialBlocks.VENUS_STONE_STAIRS.get(), CelestialBlocks.VENUS_STONE.get(), consumer);
		slabCraftAndStonecutting(CelestialBlocks.VENUS_STONE.get(), CelestialBlocks.VENUS_STONE_SLAB.get(), CelestialBlocks.VENUS_STONE.get(), consumer);
		stairsSlabWallCraftStonecutting(CelestialBlocks.VENUS_COBBLESTONE.get(), CelestialTags.Items.VENUS_COBBLESTONE, CelestialBlocks.VENUS_COBBLESTONE_STAIRS.get(), CelestialBlocks.VENUS_COBBLESTONE_SLAB.get(), CelestialBlocks.VENUS_COBBLESTONE_WALL.get(), CelestialBlocks.VENUS_COBBLESTONE.get(), consumer);
		smelting(CelestialBlocks.VENUS_STONE.get(), CelestialBlocks.VENUS_SMOOTH_STONE.get(), 0.1F, 200, CelestialBlocks.VENUS_STONE.get(), consumer);
		ShapedRecipeBuilder.shaped(CelestialBlocks.VENUS_SMOOTH_STONE_SLAB.get(), 6).pattern("XXX").define('X', CelestialBlocks.VENUS_SMOOTH_STONE.get()).unlockedBy("has_venus_smooth_stone", has(CelestialBlocks.VENUS_STONE.get())).save(consumer);
		stonecutting(CelestialBlocks.VENUS_SMOOTH_STONE.get(), CelestialBlocks.VENUS_SMOOTH_STONE_SLAB.get(), 2, CelestialBlocks.VENUS_SMOOTH_STONE.get(), consumer);
		singleItem(CelestialBlocks.VENUS_STONE.get(), CelestialBlocks.VENUS_STONE_BUTTON.get(), 1, CelestialBlocks.VENUS_STONE.get(), consumer);
		ShapedRecipeBuilder.shaped(CelestialBlocks.VENUS_STONE_PRESSURE_PLATE.get()).pattern("XX").define('X', CelestialBlocks.VENUS_STONE.get()).unlockedBy("venus_stone", has(CelestialBlocks.VENUS_STONE.get())).save(consumer);
		singleItem(CelestialBlocks.VENUS_DEEPSLATE.get(), CelestialBlocks.VENUS_DEEPSLATE_BUTTON.get(), 1, CelestialBlocks.VENUS_STONE.get(), consumer);
		ShapedRecipeBuilder.shaped(CelestialBlocks.VENUS_DEEPSLATE_PRESSURE_PLATE.get()).pattern("XX").define('X', CelestialBlocks.VENUS_DEEPSLATE.get()).unlockedBy("venus_deepslate", has(CelestialBlocks.VENUS_DEEPSLATE.get())).save(consumer);
		ingotAndBlock(CelestialBlocks.VENUS_COBBLESTONE.get(), CelestialBlocks.COMPRESSED_VENUS_COBBLESTONE.get(), CelestialBlocks.VENUS_COBBLESTONE.get(), consumer);
		ingotAndBlock(CelestialBlocks.COMPRESSED_VENUS_COBBLESTONE.get(), CelestialBlocks.SUPER_COMPRESSED_VENUS_COBBLESTONE.get(), CelestialBlocks.COMPRESSED_VENUS_COBBLESTONE.get(), consumer);

		//DEEPSLATE
		stairsSlabWallCraftStonecutting(CelestialBlocks.VENUS_COBBLED_DEEPSLATE.get(), CelestialBlocks.VENUS_COBBLED_DEEPSLATE_STAIRS.get(), CelestialBlocks.VENUS_COBBLED_DEEPSLATE_SLAB.get(), CelestialBlocks.VENUS_COBBLED_DEEPSLATE_WALL.get(), CelestialBlocks.VENUS_COBBLED_DEEPSLATE.get(), consumer);
		deepslateBricks(CelestialBlocks.VENUS_COBBLED_DEEPSLATE.get(), CelestialBlocks.VENUS_POLISHED_DEEPSLATE.get(), CelestialBlocks.VENUS_DEEPSLATE_BRICKS.get(), CelestialBlocks.VENUS_DEEPSLATE_BRICK_STAIRS.get(), CelestialBlocks.VENUS_DEEPSLATE_BRICK_SLAB.get(), CelestialBlocks.VENUS_DEEPSLATE_BRICK_WALL.get(), CelestialBlocks.VENUS_COBBLED_DEEPSLATE.get(), consumer);
		deepslateTiles(CelestialBlocks.VENUS_COBBLED_DEEPSLATE.get(), CelestialBlocks.VENUS_POLISHED_DEEPSLATE.get(), CelestialBlocks.VENUS_DEEPSLATE_BRICKS.get(), CelestialBlocks.VENUS_DEEPSLATE_TILES.get(), CelestialBlocks.VENUS_DEEPSLATE_TILE_STAIRS.get(), CelestialBlocks.VENUS_DEEPSLATE_TILE_SLAB.get(), CelestialBlocks.VENUS_DEEPSLATE_TILE_WALL.get(), CelestialBlocks.VENUS_COBBLED_DEEPSLATE.get(), consumer);
		polishedDeepslate(CelestialBlocks.VENUS_COBBLED_DEEPSLATE.get(), CelestialBlocks.VENUS_POLISHED_DEEPSLATE.get(), CelestialBlocks.VENUS_POLISHED_DEEPSLATE_STAIRS.get(), CelestialBlocks.VENUS_POLISHED_DEEPSLATE_SLAB.get(), CelestialBlocks.VENUS_POLISHED_DEEPSLATE_WALL.get(), CelestialBlocks.VENUS_COBBLED_DEEPSLATE.get(), consumer);
		ShapedRecipeBuilder.shaped(CelestialBlocks.CHISELED_VENUS_DEEPSLATE_BRICKS.get()).pattern("X").pattern("X").define('X', CelestialBlocks.VENUS_COBBLED_DEEPSLATE_SLAB.get()).unlockedBy("has_venus_cobbled_deepslate", has(CelestialBlocks.VENUS_COBBLED_DEEPSLATE.get())).save(consumer);
		stonecutting(CelestialTags.Items.VENUS_COBBLED_DEEPSLATE, CelestialBlocks.CHISELED_VENUS_DEEPSLATE_BRICKS.get(), 1, CelestialBlocks.VENUS_COBBLED_DEEPSLATE.get(), consumer);
		smelting(CelestialBlocks.VENUS_DEEPSLATE_BRICKS.get(), CelestialBlocks.CRACKED_VENUS_DEEPSLATE_BRICKS.get(), 0.1F, 200, CelestialBlocks.VENUS_DEEPSLATE_BRICKS.get(), consumer);
		smelting(CelestialBlocks.VENUS_DEEPSLATE_TILES.get(), CelestialBlocks.CRACKED_VENUS_DEEPSLATE_TILES.get(), 0.1F, 200, CelestialBlocks.VENUS_DEEPSLATE_TILES.get(), consumer);
		ingotAndBlock(CelestialBlocks.VENUS_COBBLED_DEEPSLATE.get(), CelestialBlocks.COMPRESSED_VENUS_COBBLED_DEEPSLATE.get(), CelestialBlocks.VENUS_COBBLED_DEEPSLATE.get(), consumer);
		ingotAndBlock(CelestialBlocks.COMPRESSED_VENUS_COBBLED_DEEPSLATE.get(), CelestialBlocks.SUPER_COMPRESSED_VENUS_COBBLED_DEEPSLATE.get(), CelestialBlocks.COMPRESSED_VENUS_COBBLED_DEEPSLATE.get(), consumer);

		smelting(CelestialBlocks.VENUS_SAND.get(), Items.YELLOW_STAINED_GLASS, 0.1F, 200, CelestialBlocks.VENUS_SAND.get(), consumer);
		ShapedRecipeBuilder.shaped(CelestialBlocks.VENUS_LANTERN.get()).pattern("XCX").pattern("C#C").pattern("XCX").define('X', CelestialBlocks.VENUS_STONE.get()).define('#', Items.IRON_INGOT).define('C', CelestialItems.SULFUR_CRYSTAL.get()).unlockedBy("has_sulfur_crystal", has(CelestialItems.SULFUR_CRYSTAL.get())).save(consumer);
		ShapedRecipeBuilder.shaped(CelestialBlocks.VENUS_CHEST.get()).pattern("XXX").pattern("X X").pattern("XXX").define('X', CelestialBlocks.VENUS_STONE.get()).unlockedBy("has_venus_cobblestone", has(CelestialBlocks.VENUS_COBBLESTONE.get())).save(consumer);

		//---- METEOR -------------------------------------------------------------------------------
		ShapedRecipeBuilder.shaped(CelestialBlocks.METEOR_BRICKS.get(), 4).pattern("XX").pattern("XX").define('X', CelestialBlocks.METEOR.get()).unlockedBy("meteor", has(CelestialBlocks.METEOR.get())).save(consumer);
		SingleItemRecipeBuilder.stonecutting(Ingredient.of(CelestialTags.Items.METEOR), CelestialBlocks.METEOR_BRICKS.get(), 1).unlockedBy("meteor", has(CelestialBlocks.METEOR.get())).save(consumer, saveName(CelestialBlocks.METEOR_BRICKS.get(), "stonecutting"));
		ShapedRecipeBuilder.shaped(CelestialBlocks.METEOR_BRICK_SLAB.get(), 6).pattern("XXX").define('X', CelestialBlocks.METEOR_BRICKS.get()).unlockedBy("meteor", has(CelestialBlocks.METEOR.get())).save(consumer);
		SingleItemRecipeBuilder.stonecutting(Ingredient.of(CelestialTags.Items.METEOR), CelestialBlocks.METEOR_BRICK_SLAB.get(), 2).unlockedBy("meteor", has(CelestialBlocks.METEOR.get())).save(consumer, saveName(CelestialBlocks.METEOR_BRICK_SLAB.get(), "stonecutting"));
		ShapedRecipeBuilder.shaped(CelestialBlocks.METEOR_BRICK_STAIRS.get(), 4).pattern("X  ").pattern("XX ").pattern("XXX").define('X', CelestialBlocks.METEOR_BRICKS.get()).unlockedBy("meteor", has(CelestialBlocks.METEOR.get())).save(consumer);
		SingleItemRecipeBuilder.stonecutting(Ingredient.of(CelestialTags.Items.METEOR), CelestialBlocks.METEOR_BRICK_STAIRS.get(), 1).unlockedBy("meteor", has(CelestialBlocks.METEOR.get())).save(consumer, saveName(CelestialBlocks.METEOR_BRICK_STAIRS.get(), "stonecutting"));
		ShapedRecipeBuilder.shaped(CelestialBlocks.METEOR_BRICK_WALL.get(), 6).pattern("XXX").pattern("XXX").define('X', CelestialBlocks.METEOR_BRICKS.get()).unlockedBy("meteor", has(CelestialBlocks.METEOR.get())).save(consumer);
		SingleItemRecipeBuilder.stonecutting(Ingredient.of(CelestialTags.Items.METEOR), CelestialBlocks.METEOR_BRICK_WALL.get(), 1).unlockedBy("meteor", has(CelestialBlocks.METEOR.get())).save(consumer, saveName(CelestialBlocks.METEOR_BRICK_WALL.get(), "stonecutting"));
		ShapedRecipeBuilder.shaped(CelestialBlocks.CHISELED_METEOR_BRICKS.get()).pattern("X").pattern("X").define('X', CelestialBlocks.METEOR_BRICK_SLAB.get()).unlockedBy("meteor", has(CelestialBlocks.METEOR.get())).save(consumer);
		SingleItemRecipeBuilder.stonecutting(Ingredient.of(CelestialTags.Items.METEOR), CelestialBlocks.CHISELED_METEOR_BRICKS.get(), 1).unlockedBy("meteor", has(CelestialBlocks.METEOR_BRICKS.get())).save(consumer, saveName(CelestialBlocks.CHISELED_METEOR_BRICKS.get(), "stonecutting"));
		ShapelessRecipeBuilder.shapeless(CelestialBlocks.METEOR_BUTTON.get()).requires(CelestialBlocks.METEOR.get()).unlockedBy("meteor", has(CelestialBlocks.METEOR.get())).save(consumer);
		ShapedRecipeBuilder.shaped(CelestialBlocks.METEOR_PRESSURE_PLATE.get()).pattern("XX").define('X', CelestialBlocks.METEOR.get()).unlockedBy("meteor", has(CelestialBlocks.METEOR.get())).save(consumer);

		//---- MERCURY -------------------------------------------------------------------------------
		//STONE
		bricksCraftAndStonecutting(CelestialBlocks.MERCURY_STONE.get(), CelestialBlocks.MERCURY_BRICKS.get(), CelestialBlocks.MERCURY_STONE.get(), consumer);
		stairsSlabWallCraftStonecutting(CelestialBlocks.MERCURY_BRICKS.get(), CelestialTags.Items.MERCURY_STONE, CelestialBlocks.MERCURY_BRICK_STAIRS.get(), CelestialBlocks.MERCURY_BRICK_SLAB.get(), CelestialBlocks.MERCURY_BRICK_WALL.get(), CelestialBlocks.MERCURY_STONE.get(), consumer);
		ShapedRecipeBuilder.shaped(CelestialBlocks.CHISELED_MERCURY_BRICKS.get()).pattern("X").pattern("X").define('X', CelestialBlocks.MERCURY_BRICK_SLAB.get()).unlockedBy("mercury_stone", has(CelestialBlocks.MERCURY_STONE.get())).save(consumer);
		smelting(CelestialBlocks.MERCURY_BRICKS.get(), CelestialBlocks.CRACKED_MERCURY_BRICKS.get(), 0.1F, 200, CelestialBlocks.MERCURY_BRICKS.get(), consumer);

		stonecutting(CelestialBlocks.MERCURY_STONE.get(), CelestialBlocks.CHISELED_MERCURY_BRICKS.get(), 1, CelestialBlocks.MERCURY_BRICKS.get(), consumer);
		ShapedRecipeBuilder.shaped(CelestialBlocks.MERCURY_BRICK_PILLAR.get(), 4).pattern("X").pattern("X").define('X', CelestialBlocks.MERCURY_BRICKS.get()).unlockedBy("mercury_stone", has(CelestialBlocks.MERCURY_STONE.get())).save(consumer);
		stonecutting(CelestialBlocks.MERCURY_STONE.get(), CelestialBlocks.MERCURY_BRICK_PILLAR.get(), 1, CelestialBlocks.MERCURY_STONE.get(), consumer);
		smelting(CelestialBlocks.MERCURY_COBBLESTONE.get(), CelestialBlocks.MERCURY_STONE.get(), 0.1F, 200, CelestialBlocks.MERCURY_COBBLESTONE.get(), consumer);
		smelting(CelestialBlocks.MERCURY_COBBLED_DEEPSLATE.get(), CelestialBlocks.MERCURY_DEEPSLATE.get(), 0.1F, 200, CelestialBlocks.MERCURY_COBBLED_DEEPSLATE.get(), consumer);
		stairsCraftAndStonecutting(CelestialBlocks.MERCURY_STONE.get(), CelestialBlocks.MERCURY_STONE_STAIRS.get(), CelestialBlocks.MERCURY_STONE.get(), consumer);
		slabCraftAndStonecutting(CelestialBlocks.MERCURY_STONE.get(), CelestialBlocks.MERCURY_STONE_SLAB.get(), CelestialBlocks.MERCURY_STONE.get(), consumer);
		stairsSlabWallCraftStonecutting(CelestialBlocks.MERCURY_COBBLESTONE.get(), CelestialTags.Items.MERCURY_COBBLESTONE, CelestialBlocks.MERCURY_COBBLESTONE_STAIRS.get(), CelestialBlocks.MERCURY_COBBLESTONE_SLAB.get(), CelestialBlocks.MERCURY_COBBLESTONE_WALL.get(), CelestialBlocks.MERCURY_COBBLESTONE.get(), consumer);
		smelting(CelestialBlocks.MERCURY_STONE.get(), CelestialBlocks.MERCURY_SMOOTH_STONE.get(), 0.1F, 200, CelestialBlocks.MERCURY_STONE.get(), consumer);
		ShapedRecipeBuilder.shaped(CelestialBlocks.MERCURY_SMOOTH_STONE_SLAB.get(), 6).pattern("XXX").define('X', CelestialBlocks.MERCURY_SMOOTH_STONE.get()).unlockedBy("has_mercury_smooth_stone", has(CelestialBlocks.MERCURY_STONE.get())).save(consumer);
		stonecutting(CelestialBlocks.MERCURY_SMOOTH_STONE.get(), CelestialBlocks.MERCURY_SMOOTH_STONE_SLAB.get(), 2, CelestialBlocks.MERCURY_SMOOTH_STONE.get(), consumer);
		singleItem(CelestialBlocks.MERCURY_STONE.get(), CelestialBlocks.MERCURY_STONE_BUTTON.get(), 1, CelestialBlocks.MERCURY_STONE.get(), consumer);
		ShapedRecipeBuilder.shaped(CelestialBlocks.MERCURY_STONE_PRESSURE_PLATE.get()).pattern("XX").define('X', CelestialBlocks.MERCURY_STONE.get()).unlockedBy("mercury_stone", has(CelestialBlocks.MERCURY_STONE.get())).save(consumer);
		singleItem(CelestialBlocks.MERCURY_DEEPSLATE.get(), CelestialBlocks.MERCURY_DEEPSLATE_BUTTON.get(), 1, CelestialBlocks.MERCURY_STONE.get(), consumer);
		ShapedRecipeBuilder.shaped(CelestialBlocks.MERCURY_DEEPSLATE_PRESSURE_PLATE.get()).pattern("XX").define('X', CelestialBlocks.MERCURY_DEEPSLATE.get()).unlockedBy("mercury_deepslate", has(CelestialBlocks.MERCURY_DEEPSLATE.get())).save(consumer);
		ingotAndBlock(CelestialBlocks.MERCURY_COBBLESTONE.get(), CelestialBlocks.COMPRESSED_MERCURY_COBBLESTONE.get(), CelestialBlocks.MERCURY_COBBLESTONE.get(), consumer);
		ingotAndBlock(CelestialBlocks.COMPRESSED_MERCURY_COBBLESTONE.get(), CelestialBlocks.SUPER_COMPRESSED_MERCURY_COBBLESTONE.get(), CelestialBlocks.COMPRESSED_MERCURY_COBBLESTONE.get(), consumer);

		//DEEPSLATE
		stairsSlabWallCraftStonecutting(CelestialBlocks.MERCURY_COBBLED_DEEPSLATE.get(), CelestialBlocks.MERCURY_COBBLED_DEEPSLATE_STAIRS.get(), CelestialBlocks.MERCURY_COBBLED_DEEPSLATE_SLAB.get(), CelestialBlocks.MERCURY_COBBLED_DEEPSLATE_WALL.get(), CelestialBlocks.MERCURY_COBBLED_DEEPSLATE.get(), consumer);
		deepslateBricks(CelestialBlocks.MERCURY_COBBLED_DEEPSLATE.get(), CelestialBlocks.MERCURY_POLISHED_DEEPSLATE.get(), CelestialBlocks.MERCURY_DEEPSLATE_BRICKS.get(), CelestialBlocks.MERCURY_DEEPSLATE_BRICK_STAIRS.get(), CelestialBlocks.MERCURY_DEEPSLATE_BRICK_SLAB.get(), CelestialBlocks.MERCURY_DEEPSLATE_BRICK_WALL.get(), CelestialBlocks.MERCURY_COBBLED_DEEPSLATE.get(), consumer);
		deepslateTiles(CelestialBlocks.MERCURY_COBBLED_DEEPSLATE.get(), CelestialBlocks.MERCURY_POLISHED_DEEPSLATE.get(), CelestialBlocks.MERCURY_DEEPSLATE_BRICKS.get(), CelestialBlocks.MERCURY_DEEPSLATE_TILES.get(), CelestialBlocks.MERCURY_DEEPSLATE_TILE_STAIRS.get(), CelestialBlocks.MERCURY_DEEPSLATE_TILE_SLAB.get(), CelestialBlocks.MERCURY_DEEPSLATE_TILE_WALL.get(), CelestialBlocks.MERCURY_COBBLED_DEEPSLATE.get(), consumer);
		polishedDeepslate(CelestialBlocks.MERCURY_COBBLED_DEEPSLATE.get(), CelestialBlocks.MERCURY_POLISHED_DEEPSLATE.get(), CelestialBlocks.MERCURY_POLISHED_DEEPSLATE_STAIRS.get(), CelestialBlocks.MERCURY_POLISHED_DEEPSLATE_SLAB.get(), CelestialBlocks.MERCURY_POLISHED_DEEPSLATE_WALL.get(), CelestialBlocks.MERCURY_COBBLED_DEEPSLATE.get(), consumer);
		ShapedRecipeBuilder.shaped(CelestialBlocks.CHISELED_MERCURY_DEEPSLATE_BRICKS.get()).pattern("X").pattern("X").define('X', CelestialBlocks.MERCURY_COBBLED_DEEPSLATE_SLAB.get()).unlockedBy("has_mercury_cobbled_deepslate", has(CelestialBlocks.MERCURY_COBBLED_DEEPSLATE.get())).save(consumer);
		stonecutting(CelestialTags.Items.MERCURY_COBBLED_DEEPSLATE, CelestialBlocks.CHISELED_MERCURY_DEEPSLATE_BRICKS.get(), 1, CelestialBlocks.MERCURY_COBBLED_DEEPSLATE.get(), consumer);
		smelting(CelestialBlocks.MERCURY_DEEPSLATE_BRICKS.get(), CelestialBlocks.CRACKED_MERCURY_DEEPSLATE_BRICKS.get(), 0.1F, 200, CelestialBlocks.MERCURY_DEEPSLATE_BRICKS.get(), consumer);
		smelting(CelestialBlocks.MERCURY_DEEPSLATE_TILES.get(), CelestialBlocks.CRACKED_MERCURY_DEEPSLATE_TILES.get(), 0.1F, 200, CelestialBlocks.MERCURY_DEEPSLATE_TILES.get(), consumer);
		ingotAndBlock(CelestialBlocks.MERCURY_COBBLED_DEEPSLATE.get(), CelestialBlocks.COMPRESSED_MERCURY_COBBLED_DEEPSLATE.get(), CelestialBlocks.MERCURY_COBBLED_DEEPSLATE.get(), consumer);
		ingotAndBlock(CelestialBlocks.COMPRESSED_MERCURY_COBBLED_DEEPSLATE.get(), CelestialBlocks.SUPER_COMPRESSED_MERCURY_COBBLED_DEEPSLATE.get(), CelestialBlocks.COMPRESSED_MERCURY_COBBLED_DEEPSLATE.get(), consumer);

		//OTHER
		smelting(CelestialBlocks.MERCURY_SAND.get(), Items.BROWN_STAINED_GLASS, 0.1F, 200, CelestialBlocks.MERCURY_SAND.get(), consumer);
		ShapedRecipeBuilder.shaped(CelestialBlocks.MERCURY_LANTERN.get()).pattern("XCX").pattern("C#C").pattern("XCX").define('X', CelestialItems.CINNABAR.get()).define('C', Items.IRON_INGOT).define('#', Items.TORCH).unlockedBy("has_cinnabar", has(CelestialItems.CINNABAR.get())).save(consumer);
		ShapedRecipeBuilder.shaped(CelestialBlocks.MERCURY_CHEST.get()).pattern("XXX").pattern("X X").pattern("XXX").define('X', CelestialBlocks.MERCURY_STONE.get()).unlockedBy("has_mercury_cobblestone", has(CelestialBlocks.MERCURY_COBBLESTONE.get())).save(consumer);

		ShapedRecipeBuilder.shaped(CelestialBlocks.MERCURY_FARMLAND.get(), 4).pattern("XBX").pattern("XCX").define('X', CelestialBlocks.MERCURY_SAND.get()).define('B', Items.BONE_MEAL).define('C', Items.COAL).unlockedBy("has_mercury_sand", has(CelestialBlocks.MERCURY_SAND.get())).save(consumer);


		//---- JUPITER -------------------------------------------------------------------------------

		//DEEPSLATE
		stairsSlabWallCraftStonecutting(CelestialBlocks.JUPITER_COBBLED_DEEPSLATE.get(), CelestialBlocks.JUPITER_COBBLED_DEEPSLATE_STAIRS.get(), CelestialBlocks.JUPITER_COBBLED_DEEPSLATE_SLAB.get(), CelestialBlocks.JUPITER_COBBLED_DEEPSLATE_WALL.get(), CelestialBlocks.JUPITER_COBBLED_DEEPSLATE.get(), consumer);
		deepslateBricks(CelestialBlocks.JUPITER_COBBLED_DEEPSLATE.get(), CelestialBlocks.JUPITER_POLISHED_DEEPSLATE.get(), CelestialBlocks.JUPITER_DEEPSLATE_BRICKS.get(), CelestialBlocks.JUPITER_DEEPSLATE_BRICK_STAIRS.get(), CelestialBlocks.JUPITER_DEEPSLATE_BRICK_SLAB.get(), CelestialBlocks.JUPITER_DEEPSLATE_BRICK_WALL.get(), CelestialBlocks.JUPITER_COBBLED_DEEPSLATE.get(), consumer);
		deepslateTiles(CelestialBlocks.JUPITER_COBBLED_DEEPSLATE.get(), CelestialBlocks.JUPITER_POLISHED_DEEPSLATE.get(), CelestialBlocks.JUPITER_DEEPSLATE_BRICKS.get(), CelestialBlocks.JUPITER_DEEPSLATE_TILES.get(), CelestialBlocks.JUPITER_DEEPSLATE_TILE_STAIRS.get(), CelestialBlocks.JUPITER_DEEPSLATE_TILE_SLAB.get(), CelestialBlocks.JUPITER_DEEPSLATE_TILE_WALL.get(), CelestialBlocks.JUPITER_COBBLED_DEEPSLATE.get(), consumer);
		polishedDeepslate(CelestialBlocks.JUPITER_COBBLED_DEEPSLATE.get(), CelestialBlocks.JUPITER_POLISHED_DEEPSLATE.get(), CelestialBlocks.JUPITER_POLISHED_DEEPSLATE_STAIRS.get(), CelestialBlocks.JUPITER_POLISHED_DEEPSLATE_SLAB.get(), CelestialBlocks.JUPITER_POLISHED_DEEPSLATE_WALL.get(), CelestialBlocks.JUPITER_COBBLED_DEEPSLATE.get(), consumer);
		ShapedRecipeBuilder.shaped(CelestialBlocks.CHISELED_JUPITER_DEEPSLATE_BRICKS.get()).pattern("X").pattern("X").define('X', CelestialBlocks.JUPITER_COBBLED_DEEPSLATE_SLAB.get()).unlockedBy("has_jupiter_cobbled_deepslate", has(CelestialBlocks.JUPITER_COBBLED_DEEPSLATE.get())).save(consumer);
		stonecutting(CelestialTags.Items.JUPITER_COBBLED_DEEPSLATE, CelestialBlocks.CHISELED_JUPITER_DEEPSLATE_BRICKS.get(), 1, CelestialBlocks.JUPITER_COBBLED_DEEPSLATE.get(), consumer);
		smelting(CelestialBlocks.JUPITER_DEEPSLATE_BRICKS.get(), CelestialBlocks.CRACKED_JUPITER_DEEPSLATE_BRICKS.get(), 0.1F, 200, CelestialBlocks.JUPITER_DEEPSLATE_BRICKS.get(), consumer);
		smelting(CelestialBlocks.JUPITER_DEEPSLATE_TILES.get(), CelestialBlocks.CRACKED_JUPITER_DEEPSLATE_TILES.get(), 0.1F, 200, CelestialBlocks.JUPITER_DEEPSLATE_TILES.get(), consumer);
		ingotAndBlock(CelestialBlocks.JUPITER_COBBLED_DEEPSLATE.get(), CelestialBlocks.COMPRESSED_JUPITER_COBBLED_DEEPSLATE.get(), CelestialBlocks.JUPITER_COBBLED_DEEPSLATE.get(), consumer);
		ingotAndBlock(CelestialBlocks.COMPRESSED_JUPITER_COBBLED_DEEPSLATE.get(), CelestialBlocks.SUPER_COMPRESSED_JUPITER_COBBLED_DEEPSLATE.get(), CelestialBlocks.COMPRESSED_JUPITER_COBBLED_DEEPSLATE.get(), consumer);
		smelting(CelestialBlocks.JUPITER_COBBLED_DEEPSLATE.get(), CelestialBlocks.JUPITER_DEEPSLATE.get(), 0.1F, 200, CelestialBlocks.JUPITER_COBBLED_DEEPSLATE.get(), consumer);
		singleItem(CelestialBlocks.JUPITER_DEEPSLATE.get(), CelestialBlocks.JUPITER_DEEPSLATE_BUTTON.get(), 1, CelestialBlocks.JUPITER_DEEPSLATE.get(), consumer);
		ShapedRecipeBuilder.shaped(CelestialBlocks.JUPITER_DEEPSLATE_PRESSURE_PLATE.get()).pattern("XX").define('X', CelestialBlocks.JUPITER_DEEPSLATE.get()).unlockedBy("jupiter_deepslate", has(CelestialBlocks.JUPITER_DEEPSLATE.get())).save(consumer);

		//OTHER
		ShapedRecipeBuilder.shaped(CelestialBlocks.JUPITER_LANTERN.get()).pattern("XCX").pattern("C#C").pattern("XCX").define('X', CelestialBlocks.JUPITER_ATMOSPHERE.get()).define('C', Items.IRON_INGOT).define('#', Items.TORCH).unlockedBy("has_jupiter_deepslate", has(CelestialBlocks.JUPITER_LANTERN.get())).save(consumer);
		ShapedRecipeBuilder.shaped(CelestialBlocks.JUPITER_CHEST.get()).pattern("XXX").pattern("X X").pattern("XXX").define('X', CelestialBlocks.JUPITER_DEEPSLATE.get()).unlockedBy("has_jupiter_deepslate", has(CelestialBlocks.JUPITER_DEEPSLATE.get())).save(consumer);


		//---- IO -------------------------------------------------------------------------------
		//STONE
		bricksCraftAndStonecutting(CelestialBlocks.IO_STONE.get(), CelestialBlocks.IO_BRICKS.get(), CelestialBlocks.IO_STONE.get(), consumer);
		stairsSlabWallCraftStonecutting(CelestialBlocks.IO_BRICKS.get(), CelestialTags.Items.IO_STONE, CelestialBlocks.IO_BRICK_STAIRS.get(), CelestialBlocks.IO_BRICK_SLAB.get(), CelestialBlocks.IO_BRICK_WALL.get(), CelestialBlocks.IO_STONE.get(), consumer);
		ShapedRecipeBuilder.shaped(CelestialBlocks.CHISELED_IO_BRICKS.get()).pattern("X").pattern("X").define('X', CelestialBlocks.IO_BRICK_SLAB.get()).unlockedBy("io_stone", has(CelestialBlocks.IO_STONE.get())).save(consumer);
		smelting(CelestialBlocks.IO_BRICKS.get(), CelestialBlocks.CRACKED_IO_BRICKS.get(), 0.1F, 200, CelestialBlocks.IO_BRICKS.get(), consumer);

		stonecutting(CelestialBlocks.IO_STONE.get(), CelestialBlocks.CHISELED_IO_BRICKS.get(), 1, CelestialBlocks.IO_BRICKS.get(), consumer);
		ShapedRecipeBuilder.shaped(CelestialBlocks.IO_BRICK_PILLAR.get(), 4).pattern("X").pattern("X").define('X', CelestialBlocks.IO_BRICKS.get()).unlockedBy("io_stone", has(CelestialBlocks.IO_STONE.get())).save(consumer);
		stonecutting(CelestialBlocks.IO_STONE.get(), CelestialBlocks.IO_BRICK_PILLAR.get(), 1, CelestialBlocks.IO_STONE.get(), consumer);
		smelting(CelestialBlocks.IO_COBBLESTONE.get(), CelestialBlocks.IO_STONE.get(), 0.1F, 200, CelestialBlocks.IO_COBBLESTONE.get(), consumer);
		smelting(CelestialBlocks.IO_COBBLED_DEEPSLATE.get(), CelestialBlocks.IO_DEEPSLATE.get(), 0.1F, 200, CelestialBlocks.IO_COBBLED_DEEPSLATE.get(), consumer);
		stairsCraftAndStonecutting(CelestialBlocks.IO_STONE.get(), CelestialBlocks.IO_STONE_STAIRS.get(), CelestialBlocks.IO_STONE.get(), consumer);
		slabCraftAndStonecutting(CelestialBlocks.IO_STONE.get(), CelestialBlocks.IO_STONE_SLAB.get(), CelestialBlocks.IO_STONE.get(), consumer);
		stairsSlabWallCraftStonecutting(CelestialBlocks.IO_COBBLESTONE.get(), CelestialTags.Items.IO_COBBLESTONE, CelestialBlocks.IO_COBBLESTONE_STAIRS.get(), CelestialBlocks.IO_COBBLESTONE_SLAB.get(), CelestialBlocks.IO_COBBLESTONE_WALL.get(), CelestialBlocks.IO_COBBLESTONE.get(), consumer);
		smelting(CelestialBlocks.IO_STONE.get(), CelestialBlocks.IO_SMOOTH_STONE.get(), 0.1F, 200, CelestialBlocks.IO_STONE.get(), consumer);
		ShapedRecipeBuilder.shaped(CelestialBlocks.IO_SMOOTH_STONE_SLAB.get(), 6).pattern("XXX").define('X', CelestialBlocks.IO_SMOOTH_STONE.get()).unlockedBy("has_io_smooth_stone", has(CelestialBlocks.IO_STONE.get())).save(consumer);
		stonecutting(CelestialBlocks.IO_SMOOTH_STONE.get(), CelestialBlocks.IO_SMOOTH_STONE_SLAB.get(), 2, CelestialBlocks.IO_SMOOTH_STONE.get(), consumer);
		singleItem(CelestialBlocks.IO_STONE.get(), CelestialBlocks.IO_STONE_BUTTON.get(), 1, CelestialBlocks.IO_STONE.get(), consumer);
		ShapedRecipeBuilder.shaped(CelestialBlocks.IO_STONE_PRESSURE_PLATE.get()).pattern("XX").define('X', CelestialBlocks.IO_STONE.get()).unlockedBy("io_stone", has(CelestialBlocks.IO_STONE.get())).save(consumer);
		singleItem(CelestialBlocks.IO_DEEPSLATE.get(), CelestialBlocks.IO_DEEPSLATE_BUTTON.get(), 1, CelestialBlocks.IO_STONE.get(), consumer);
		ShapedRecipeBuilder.shaped(CelestialBlocks.IO_DEEPSLATE_PRESSURE_PLATE.get()).pattern("XX").define('X', CelestialBlocks.IO_DEEPSLATE.get()).unlockedBy("io_deepslate", has(CelestialBlocks.IO_DEEPSLATE.get())).save(consumer);
		ingotAndBlock(CelestialBlocks.IO_COBBLESTONE.get(), CelestialBlocks.COMPRESSED_IO_COBBLESTONE.get(), CelestialBlocks.IO_COBBLESTONE.get(), consumer);
		ingotAndBlock(CelestialBlocks.COMPRESSED_IO_COBBLESTONE.get(), CelestialBlocks.SUPER_COMPRESSED_IO_COBBLESTONE.get(), CelestialBlocks.COMPRESSED_IO_COBBLESTONE.get(), consumer);

		//DEEPSLATE
		stairsSlabWallCraftStonecutting(CelestialBlocks.IO_COBBLED_DEEPSLATE.get(), CelestialBlocks.IO_COBBLED_DEEPSLATE_STAIRS.get(), CelestialBlocks.IO_COBBLED_DEEPSLATE_SLAB.get(), CelestialBlocks.IO_COBBLED_DEEPSLATE_WALL.get(), CelestialBlocks.IO_COBBLED_DEEPSLATE.get(), consumer);
		deepslateBricks(CelestialBlocks.IO_COBBLED_DEEPSLATE.get(), CelestialBlocks.IO_POLISHED_DEEPSLATE.get(), CelestialBlocks.IO_DEEPSLATE_BRICKS.get(), CelestialBlocks.IO_DEEPSLATE_BRICK_STAIRS.get(), CelestialBlocks.IO_DEEPSLATE_BRICK_SLAB.get(), CelestialBlocks.IO_DEEPSLATE_BRICK_WALL.get(), CelestialBlocks.IO_COBBLED_DEEPSLATE.get(), consumer);
		deepslateTiles(CelestialBlocks.IO_COBBLED_DEEPSLATE.get(), CelestialBlocks.IO_POLISHED_DEEPSLATE.get(), CelestialBlocks.IO_DEEPSLATE_BRICKS.get(), CelestialBlocks.IO_DEEPSLATE_TILES.get(), CelestialBlocks.IO_DEEPSLATE_TILE_STAIRS.get(), CelestialBlocks.IO_DEEPSLATE_TILE_SLAB.get(), CelestialBlocks.IO_DEEPSLATE_TILE_WALL.get(), CelestialBlocks.IO_COBBLED_DEEPSLATE.get(), consumer);
		polishedDeepslate(CelestialBlocks.IO_COBBLED_DEEPSLATE.get(), CelestialBlocks.IO_POLISHED_DEEPSLATE.get(), CelestialBlocks.IO_POLISHED_DEEPSLATE_STAIRS.get(), CelestialBlocks.IO_POLISHED_DEEPSLATE_SLAB.get(), CelestialBlocks.IO_POLISHED_DEEPSLATE_WALL.get(), CelestialBlocks.IO_COBBLED_DEEPSLATE.get(), consumer);
		ShapedRecipeBuilder.shaped(CelestialBlocks.CHISELED_IO_DEEPSLATE_BRICKS.get()).pattern("X").pattern("X").define('X', CelestialBlocks.IO_COBBLED_DEEPSLATE_SLAB.get()).unlockedBy("has_io_cobbled_deepslate", has(CelestialBlocks.IO_COBBLED_DEEPSLATE.get())).save(consumer);
		stonecutting(CelestialTags.Items.IO_COBBLED_DEEPSLATE, CelestialBlocks.CHISELED_IO_DEEPSLATE_BRICKS.get(), 1, CelestialBlocks.IO_COBBLED_DEEPSLATE.get(), consumer);
		smelting(CelestialBlocks.IO_DEEPSLATE_BRICKS.get(), CelestialBlocks.CRACKED_IO_DEEPSLATE_BRICKS.get(), 0.1F, 200, CelestialBlocks.IO_DEEPSLATE_BRICKS.get(), consumer);
		smelting(CelestialBlocks.IO_DEEPSLATE_TILES.get(), CelestialBlocks.CRACKED_IO_DEEPSLATE_TILES.get(), 0.1F, 200, CelestialBlocks.IO_DEEPSLATE_TILES.get(), consumer);
		ingotAndBlock(CelestialBlocks.IO_COBBLED_DEEPSLATE.get(), CelestialBlocks.COMPRESSED_IO_COBBLED_DEEPSLATE.get(), CelestialBlocks.IO_COBBLED_DEEPSLATE.get(), consumer);
		ingotAndBlock(CelestialBlocks.COMPRESSED_IO_COBBLED_DEEPSLATE.get(), CelestialBlocks.SUPER_COMPRESSED_IO_COBBLED_DEEPSLATE.get(), CelestialBlocks.COMPRESSED_IO_COBBLED_DEEPSLATE.get(), consumer);

		//OTHER
		smelting(CelestialBlocks.IO_SAND.get(), Items.YELLOW_STAINED_GLASS, 0.1F, 200, CelestialBlocks.IO_SAND.get(), consumer, saveName(Blocks.YELLOW_STAINED_GLASS, "from_io_sand"));
		ShapedRecipeBuilder.shaped(CelestialBlocks.IO_LANTERN.get()).pattern("XCX").pattern("C#C").pattern("XCX").define('X', CelestialBlocks.IO_STONE.get()).define('#', Items.IRON_INGOT).define('C', CelestialItems.IO_DUST.get()).unlockedBy("has_io_dust", has(CelestialItems.IO_DUST.get())).save(consumer);
		ShapedRecipeBuilder.shaped(CelestialBlocks.IO_CHEST.get()).pattern("XXX").pattern("X X").pattern("XXX").define('X', CelestialBlocks.IO_STONE.get()).unlockedBy("has_io_cobblestone", has(CelestialBlocks.IO_COBBLESTONE.get())).save(consumer);

		//---- EUROPA -------------------------------------------------------------------------------
		//STONE
		ShapedRecipeBuilder.shaped(CelestialBlocks.EUROPA_BRICKS.get(), 4).pattern("XY").pattern("YX").define('X', CelestialBlocks.MOON_STONE.get()).define('Y', CelestialBlocks.EUROPA_HYDRATE.get()).unlockedBy(name(CelestialBlocks.EUROPA_HYDRATE.get()), has(CelestialBlocks.EUROPA_HYDRATE.get())).save(consumer);
		stairsSlabWallCraftStonecutting(CelestialBlocks.EUROPA_BRICKS.get(), CelestialBlocks.EUROPA_BRICK_STAIRS.get(), CelestialBlocks.EUROPA_BRICK_SLAB.get(), CelestialBlocks.EUROPA_BRICK_WALL.get(), CelestialBlocks.EUROPA_HYDRATE.get(), consumer);
		ShapedRecipeBuilder.shaped(CelestialBlocks.CHISELED_EUROPA_BRICKS.get()).pattern("X").pattern("X").define('X', CelestialBlocks.EUROPA_BRICK_SLAB.get()).unlockedBy("europa_stone", has(CelestialBlocks.EUROPA_BRICKS.get())).save(consumer);

		ShapedRecipeBuilder.shaped(CelestialBlocks.EUROPA_LANTERN.get()).pattern("XCX").pattern("C#C").pattern("XCX").define('X', CelestialBlocks.MOON_STONE.get()).define('#', Items.IRON_INGOT).define('C', CelestialItems.EUROPA_DUST.get()).unlockedBy("has_europa_dust", has(CelestialItems.EUROPA_DUST.get())).save(consumer);

		//---- CALLISTO -------------------------------------------------------------------------------
		//STONE
		ShapedRecipeBuilder.shaped(CelestialBlocks.CALLISTO_BRICKS.get(), 4).pattern("XXY").pattern("XX ").define('X', CelestialBlocks.MOON_DEEPSLATE.get()).define('Y', CelestialItems.CALLISTO_DUST.get()).unlockedBy(name(CelestialItems.CALLISTO_DUST.get()), has(CelestialItems.CALLISTO_DUST.get())).save(consumer);
		stairsSlabWallCraftStonecutting(CelestialBlocks.CALLISTO_BRICKS.get(), CelestialBlocks.CALLISTO_BRICK_STAIRS.get(), CelestialBlocks.CALLISTO_BRICK_SLAB.get(), CelestialBlocks.CALLISTO_BRICK_WALL.get(), Block.byItem(CelestialItems.CALLISTO_DUST.get()), consumer);
		ShapedRecipeBuilder.shaped(CelestialBlocks.CHISELED_CALLISTO_BRICKS.get()).pattern("X").pattern("X").define('X', CelestialBlocks.CALLISTO_BRICK_SLAB.get()).unlockedBy("callisto_stone", has(CelestialBlocks.CALLISTO_BRICKS.get())).save(consumer);

		ShapedRecipeBuilder.shaped(CelestialBlocks.CALLISTO_LANTERN.get()).pattern("XCX").pattern("C#C").pattern("XCX").define('X', CelestialBlocks.MOON_DEEPSLATE.get()).define('#', Items.IRON_INGOT).define('C', CelestialItems.CALLISTO_DUST.get()).unlockedBy("has_callisto_dust", has(CelestialItems.CALLISTO_DUST.get())).save(consumer);

		//---- GANYMEDE -------------------------------------------------------------------------------
		//STONE
		ShapedRecipeBuilder.shaped(CelestialBlocks.GANYMEDE_BRICKS.get(), 4).pattern("XXY").pattern("XX ").define('X', CelestialBlocks.MOON_DEEPSLATE.get()).define('Y', CelestialItems.GANYMEDE_DUST.get()).unlockedBy(name(CelestialItems.GANYMEDE_DUST.get()), has(CelestialItems.GANYMEDE_DUST.get())).save(consumer);
		stairsSlabWallCraftStonecutting(CelestialBlocks.GANYMEDE_BRICKS.get(), CelestialBlocks.GANYMEDE_BRICK_STAIRS.get(), CelestialBlocks.GANYMEDE_BRICK_SLAB.get(), CelestialBlocks.GANYMEDE_BRICK_WALL.get(), Block.byItem(CelestialItems.GANYMEDE_DUST.get()), consumer);
		ShapedRecipeBuilder.shaped(CelestialBlocks.CHISELED_GANYMEDE_BRICKS.get()).pattern("X").pattern("X").define('X', CelestialBlocks.GANYMEDE_BRICK_SLAB.get()).unlockedBy(name(CelestialBlocks.GANYMEDE_BRICKS.get()), has(CelestialBlocks.GANYMEDE_BRICKS.get())).save(consumer);

		ShapedRecipeBuilder.shaped(CelestialBlocks.GANYMEDE_LANTERN.get()).pattern("XCX").pattern("C#C").pattern("XCX").define('X', CelestialBlocks.MOON_DEEPSLATE.get()).define('#', Items.IRON_INGOT).define('C', CelestialItems.GANYMEDE_DUST.get()).unlockedBy("has_ganymede_dust", has(CelestialItems.GANYMEDE_DUST.get())).save(consumer);

		//---- ORES/ALLOYS -------------------------------------------------------------------------------
		//BAUXITE/ALUMINUM
		smeltingAndBlasting(CelestialItems.RAW_BAUXITE.get(), CelestialItems.BAUXITE_INGOT.get(), 0.7F, 200, 100, CelestialItems.RAW_BAUXITE.get(), consumer);
		ShapelessRecipeBuilder.shapeless(CelestialItems.ALUMINUM_INGOT.get(), 3).requires(Items.IRON_INGOT).requires(CelestialItems.BAUXITE_INGOT.get()).requires(CelestialItems.BAUXITE_INGOT.get()).unlockedBy("has_raw_bauxite", has(CelestialItems.RAW_BAUXITE.get())).save(consumer);
		ShapelessRecipeBuilder.shapeless(CelestialItems.ALUMINUM_INGOT.get(), 3).requires(Items.COPPER_INGOT).requires(CelestialItems.BAUXITE_INGOT.get()).requires(CelestialItems.BAUXITE_INGOT.get()).unlockedBy("has_raw_bauxite", has(CelestialItems.RAW_BAUXITE.get())).save(consumer,  saveName(CelestialItems.ALUMINUM_INGOT.get(), "from_copper"));
		ingotAndBlock(CelestialItems.ALUMINUM_INGOT.get(), CelestialBlocks.ALUMINUM_BLOCK.get(), CelestialItems.ALUMINUM_INGOT.get(), consumer);

		WorkbenchCraftingRecipeBuilder.shaped(CelestialItems.ALUMINUM_INGOT.get(), 3, CelestialFluids.MOLTEN_IRON.get(), 0.1111F, 0.7F).pattern("X").define('X', CelestialItems.BAUXITE_INGOT.get()).unlockedBy("has_bauxite", has(CelestialItems.BAUXITE_INGOT.get())).save(consumer, saveName(CelestialItems.ALUMINUM_INGOT.get(), "from_workbench"));
		WorkbenchCraftingRecipeBuilder.shaped(CelestialItems.ALUMINUM_INGOT.get(), 3, CelestialFluids.MOLTEN_COPPER.get(), 0.1111F, 0.7F).pattern("X").define('X', CelestialItems.BAUXITE_INGOT.get()).unlockedBy("has_bauxite", has(CelestialItems.BAUXITE_INGOT.get())).save(consumer, saveName(CelestialItems.ALUMINUM_INGOT.get(), "from_copper_workbench"));


		smeltingAndBlasting(CelestialTags.Items.BAUXITE_ORE, CelestialItems.BAUXITE_INGOT.get(), 0.7F, 200, 100, CelestialBlocks.BAUXITE_ORE.get(), consumer);
//		smeltingAndBlasting(BlockRegistry.MARS_BAUXITE_ORE.get(), ItemRegistry.BAUXITE_INGOT.get(), 0.7F, 200, 100, BlockRegistry.MARS_BAUXITE_ORE.get(), consumer);
//		smeltingAndBlasting(BlockRegistry.VENUS_BAUXITE_ORE.get(), ItemRegistry.BAUXITE_INGOT.get(), 0.7F, 200, 100, BlockRegistry.VENUS_BAUXITE_ORE.get(), consumer);
//		smeltingAndBlasting(BlockRegistry.MERCURY_BAUXITE_ORE.get(), ItemRegistry.BAUXITE_INGOT.get(), 0.7F, 200, 100, BlockRegistry.MERCURY_BAUXITE_ORE.get(), consumer);
//		smeltingAndBlasting(BlockRegistry.BAUXITE_ORE.get(), ItemRegistry.BAUXITE_INGOT.get(), 0.7F, 200, 100, BlockRegistry.BAUXITE_ORE.get(), consumer);
//		smeltingAndBlasting(BlockRegistry.METEOR_BAUXITE_ORE.get(), ItemRegistry.BAUXITE_INGOT.get(), 0.7F, 200, 100, BlockRegistry.BAUXITE_ORE.get(), consumer);

		//STEEL
		WorkbenchCraftingRecipeBuilder.shaped(CelestialItems.STEEL_INGOT.get(), 2, CelestialFluids.MOLTEN_IRON.get(), 0.1111F, 0.7F).pattern("X").define('X', Items.COAL).unlockedBy("has_iron", has(Items.IRON_INGOT)).save(consumer, saveName(CelestialItems.STEEL_INGOT.get(), "from_workbench"));
		ingotAndBlock(CelestialItems.STEEL_INGOT.get(), CelestialBlocks.STEEL_BLOCK.get(), CelestialItems.STEEL_INGOT.get(), consumer);
		ingotAndBlock(CelestialItems.STEEL_NUGGET.get(), CelestialItems.STEEL_INGOT.get(), CelestialItems.STEEL_INGOT.get(), consumer);

		//ASSORTED
		ShapelessRecipeBuilder.shapeless(Items.IRON_NUGGET).requires(CelestialItems.RUSTED_IRON_NUGGET.get()).unlockedBy("rusted_iron_nugget", has(CelestialItems.RUSTED_IRON_NUGGET.get())).save(consumer, saveName(Items.IRON_NUGGET, "from_rusted_iron_nugget"));
		SimpleCookingRecipeBuilder.smelting(Ingredient.of(CelestialItems.RUSTED_IRON_NUGGET.get()), Items.IRON_NUGGET, 1.0F, 30).unlockedBy("has_rusted_iron_nugget", has(CelestialItems.RUSTED_IRON_NUGGET.get())).save(consumer, saveName(Items.IRON_NUGGET, "from_smeling_rusted_iron_nugget"));
		singleItem(CelestialItems.CINNABAR.get(), Items.RED_DYE, 1, CelestialItems.CINNABAR.get(), consumer);

		ShapelessRecipeBuilder.shapeless(CelestialItems.STEEL_INGOT.get(), 2).requires(Items.COAL).requires(Items.IRON_INGOT).requires(Items.IRON_INGOT).unlockedBy("iron", has(Items.IRON_INGOT)).save(consumer, saveName(CelestialItems.STEEL_INGOT.get(), "crafted"));
		ShapedRecipeBuilder.shaped(CelestialItems.STEEL_ROD.get(), 8).pattern("X").pattern("X").pattern("X").define('X', CelestialItems.STEEL_INGOT.get()).unlockedBy("steel", has(CelestialItems.STEEL_INGOT.get())).save(consumer);
		ShapedRecipeBuilder.shaped(CelestialItems.STEEL_WOOL.get(), 4).pattern(" X ").pattern("XSX").pattern(" X ").define('X', CelestialItems.STEEL_NUGGET.get()).define('S', Items.STRING).unlockedBy("steel", has(CelestialItems.STEEL_INGOT.get())).save(consumer);

//		smeltingAndBlasting(BlockRegistry.MOON_IRON_ORE.get(), Items.IRON_INGOT, 0.7F, 200, 100, BlockRegistry.MOON_IRON_ORE.get(), consumer);
//		smeltingAndBlasting(BlockRegistry.MOON_DEEPSLATE_IRON_ORE.get(), Items.IRON_INGOT, 0.7F, 200, 100, BlockRegistry.MOON_DEEPSLATE_IRON_ORE.get(), consumer);
		smeltingAndBlasting(CelestialBlocks.MARS_IRON_ORE.get(), Items.IRON_INGOT, 0.7F, 200, 100, CelestialBlocks.MARS_IRON_ORE.get(), consumer);
		smeltingAndBlasting(CelestialBlocks.MARS_DEEPSLATE_IRON_ORE.get(), Items.IRON_INGOT, 0.7F, 200, 100, CelestialBlocks.MARS_DEEPSLATE_IRON_ORE.get(), consumer);
		smeltingAndBlasting(CelestialBlocks.VENUS_IRON_ORE.get(), Items.IRON_INGOT, 0.7F, 200, 100, CelestialBlocks.VENUS_IRON_ORE.get(), consumer);
		smeltingAndBlasting(CelestialBlocks.VENUS_DEEPSLATE_IRON_ORE.get(), Items.IRON_INGOT, 0.7F, 200, 100, CelestialBlocks.VENUS_DEEPSLATE_IRON_ORE.get(), consumer);
		smeltingAndBlasting(CelestialBlocks.METEOR_IRON_ORE.get(), Items.IRON_INGOT, 0.7F, 200, 100, CelestialBlocks.METEOR_IRON_ORE.get(), consumer);
		smeltingAndBlasting(CelestialBlocks.METEOR_GOLD_ORE.get(), Items.GOLD_INGOT, 0.7F, 200, 100, CelestialBlocks.METEOR_GOLD_ORE.get(), consumer);
		smeltingAndBlasting(CelestialBlocks.METEOR_COPPER_ORE.get(), Items.COPPER_INGOT, 0.7F, 200, 100, CelestialBlocks.METEOR_COPPER_ORE.get(), consumer);
		smeltingAndBlasting(CelestialBlocks.MERCURY_DEEPSLATE_IRON_ORE.get(), Items.IRON_INGOT, 0.7F, 200, 100, CelestialBlocks.MERCURY_DEEPSLATE_IRON_ORE.get(), consumer);

		//---- SPACESHIP -------------------------------------------------------------------------------
		ShapedRecipeBuilder.shaped(CelestialBlocks.WORKBENCH.get()).pattern("XXX").pattern("X X").pattern("CCC").define('X', ItemTags.PLANKS).define('C', Blocks.COBBLESTONE).unlockedBy("has_cobblestone", has(Blocks.COBBLESTONE)).save(consumer);

		ShapedRecipeBuilder.shaped(CelestialItems.LOX_TANK.get()).pattern("SsS").pattern("G G").pattern("SsS").define('S', CelestialItems.STEEL_INGOT.get()).define('s', CelestialItems.ALUMINUM_INGOT.get()).define('G', Tags.Items.GLASS).unlockedBy("steel", has(CelestialItems.STEEL_INGOT.get())).save(consumer);
		WorkbenchCraftingRecipeBuilder.shaped(CelestialItems.LOX_TANK.get(), 2, CelestialFluids.MOLTEN_STEEL.get(), 0.444F, 2.8F).pattern("AGA").pattern("G G").pattern("AGA").define('A', CelestialItems.ALUMINUM_INGOT.get()).define('G', Tags.Items.GLASS).unlockedBy("has_iron", has(Items.IRON_INGOT)).save(consumer, saveName(CelestialItems.LOX_TANK.get(), "from_workbench"));

		ShapedRecipeBuilder.shaped(CelestialBlocks.OXYGEN_COMPRESSOR.get()).pattern("SSS").pattern("CGC").pattern("CRC").define('S', CelestialItems.STEEL_INGOT.get()).define('C', CelestialItems.ALUMINUM_INGOT.get()).define('G', Tags.Items.GLASS).define('R', Items.REDSTONE).unlockedBy("steel_ingot", has(CelestialItems.STEEL_INGOT.get())).save(consumer);
		WorkbenchCraftingRecipeBuilder.shaped(CelestialBlocks.OXYGEN_COMPRESSOR.get(), CelestialFluids.MOLTEN_STEEL.get(), 0.222F, 1.4F).pattern("XXX").pattern("XGX").pattern("XRX").define('X', Tags.Items.COBBLESTONE).define('G', Tags.Items.GLASS).define('R', Items.REDSTONE).unlockedBy("has_iron", has(Items.IRON_INGOT)).save(consumer, saveName(CelestialBlocks.OXYGEN_COMPRESSOR.get(), "from_workbench"));

		WorkbenchCraftingRecipeBuilder.shaped(CelestialBlocks.STEEL_FRAME.get(), 4, CelestialFluids.MOLTEN_STEEL.get(), 0.222F, 1.4F).pattern("X").define('X', Items.SCAFFOLDING).unlockedBy("has_steel", has(CelestialItems.STEEL_INGOT.get())).save(consumer, saveName(CelestialBlocks.STEEL_FRAME.get(), "from_workbench"));
		WorkbenchCraftingRecipeBuilder.shaped(CelestialBlocks.STEEL_FRAME.get(), 1, CelestialFluids.MOLTEN_STEEL.get(), 0.111F, 0.4F).pattern("X X").pattern("XXX").pattern("X X").define('X', Items.STICK).unlockedBy("has_steel", has(CelestialItems.STEEL_INGOT.get())).save(consumer, saveName(CelestialBlocks.STEEL_FRAME.get(), "from_sticks_from_workbench"));

		WorkbenchCraftingRecipeBuilder.shaped(CelestialItems.SPACESHIP_FRAME.get(), CelestialFluids.MOLTEN_STEEL.get(), 0.333F, 2.1F).pattern("C C").pattern(" X ").pattern("C C").define('X', CelestialBlocks.STEEL_FRAME.get()).define('C', CelestialBlocks.CERAMIC_TILE.get()).unlockedBy("has_steel", has(CelestialItems.STEEL_INGOT.get())).save(consumer, saveName(CelestialItems.SPACESHIP_FRAME.get(), "from_workbench"));
		WorkbenchCraftingRecipeBuilder.shaped(CelestialItems.SPACESHIP_CABIN.get(), CelestialFluids.MOLTEN_ALUMINUM.get(), 0.444F, 2.8F).pattern(" C ").pattern("CGC").pattern("X X").define('C', CelestialBlocks.CERAMIC_TILE.get()).define('G', Tags.Items.GLASS).define('X', Tags.Items.CHESTS).unlockedBy("has_steel", has(CelestialItems.STEEL_INGOT.get())).save(consumer, saveName(CelestialItems.SPACESHIP_CABIN.get(), "from_workbench"));
		WorkbenchCraftingRecipeBuilder.shaped(CelestialItems.SPACESHIP_ENGINE.get(), CelestialFluids.MOLTEN_STEEL.get(), 0.555F, 3.1F).pattern("CRC").pattern("TTT").define('R', Items.REDSTONE).define('C', Items.COPPER_INGOT).define('T', Items.REDSTONE_TORCH).unlockedBy("has_steel", has(CelestialItems.STEEL_INGOT.get())).save(consumer, saveName(CelestialItems.SPACESHIP_ENGINE.get(), "from_workbench"));
		WorkbenchCraftingRecipeBuilder.shaped(CelestialItems.WHITE_SPACESHIP.get(), CelestialFluids.MOLTEN_ALUMINUM.get(), 0.333F, 1.7F).pattern("C").pattern("F").pattern("E").define('C', CelestialItems.SPACESHIP_CABIN.get()).define('F', CelestialItems.SPACESHIP_FRAME.get()).define('E', CelestialItems.SPACESHIP_ENGINE.get()).unlockedBy("has_steel", has(CelestialItems.STEEL_INGOT.get())).save(consumer, saveName(CelestialItems.WHITE_SPACESHIP.get(), "from_workbench"));

		ShapelessRecipeBuilder.shapeless(CelestialItems.BLACK_SPACESHIP.get()).requires(CelestialItems.WHITE_SPACESHIP.get()).requires(Items.BLACK_DYE).unlockedBy("spaceship", has(CelestialItems.WHITE_SPACESHIP.get())).save(consumer);
		ShapelessRecipeBuilder.shapeless(CelestialItems.GREY_SPACESHIP.get()).requires(CelestialItems.WHITE_SPACESHIP.get()).requires(Items.GRAY_DYE).unlockedBy("spaceship", has(CelestialItems.WHITE_SPACESHIP.get())).save(consumer);
		ShapelessRecipeBuilder.shapeless(CelestialItems.LIGHT_GREY_SPACESHIP.get()).requires(CelestialItems.WHITE_SPACESHIP.get()).requires(Items.LIGHT_GRAY_DYE).unlockedBy("spaceship", has(CelestialItems.WHITE_SPACESHIP.get())).save(consumer);
		ShapelessRecipeBuilder.shapeless(CelestialItems.PINK_SPACESHIP.get()).requires(CelestialItems.WHITE_SPACESHIP.get()).requires(Items.PINK_DYE).unlockedBy("spaceship", has(CelestialItems.WHITE_SPACESHIP.get())).save(consumer);
		ShapelessRecipeBuilder.shapeless(CelestialItems.RED_SPACESHIP.get()).requires(CelestialItems.WHITE_SPACESHIP.get()).requires(Items.RED_DYE).unlockedBy("spaceship", has(CelestialItems.WHITE_SPACESHIP.get())).save(consumer);
		ShapelessRecipeBuilder.shapeless(CelestialItems.ORANGE_SPACESHIP.get()).requires(CelestialItems.WHITE_SPACESHIP.get()).requires(Items.ORANGE_DYE).unlockedBy("spaceship", has(CelestialItems.WHITE_SPACESHIP.get())).save(consumer);
		ShapelessRecipeBuilder.shapeless(CelestialItems.YELLOW_SPACESHIP.get()).requires(CelestialItems.WHITE_SPACESHIP.get()).requires(Items.YELLOW_DYE).unlockedBy("spaceship", has(CelestialItems.WHITE_SPACESHIP.get())).save(consumer);
		ShapelessRecipeBuilder.shapeless(CelestialItems.LIME_SPACESHIP.get()).requires(CelestialItems.WHITE_SPACESHIP.get()).requires(Items.LIME_DYE).unlockedBy("spaceship", has(CelestialItems.WHITE_SPACESHIP.get())).save(consumer);
		ShapelessRecipeBuilder.shapeless(CelestialItems.GREEN_SPACESHIP.get()).requires(CelestialItems.WHITE_SPACESHIP.get()).requires(Items.GREEN_DYE).unlockedBy("spaceship", has(CelestialItems.WHITE_SPACESHIP.get())).save(consumer);
		ShapelessRecipeBuilder.shapeless(CelestialItems.CYAN_SPACESHIP.get()).requires(CelestialItems.WHITE_SPACESHIP.get()).requires(Items.CYAN_DYE).unlockedBy("spaceship", has(CelestialItems.WHITE_SPACESHIP.get())).save(consumer);
		ShapelessRecipeBuilder.shapeless(CelestialItems.BLUE_SPACESHIP.get()).requires(CelestialItems.WHITE_SPACESHIP.get()).requires(Items.BLUE_DYE).unlockedBy("spaceship", has(CelestialItems.WHITE_SPACESHIP.get())).save(consumer);
		ShapelessRecipeBuilder.shapeless(CelestialItems.LIGHT_BLUE_SPACESHIP.get()).requires(CelestialItems.WHITE_SPACESHIP.get()).requires(Items.LIGHT_BLUE_DYE).unlockedBy("spaceship", has(CelestialItems.WHITE_SPACESHIP.get())).save(consumer);
		ShapelessRecipeBuilder.shapeless(CelestialItems.PURPLE_SPACESHIP.get()).requires(CelestialItems.WHITE_SPACESHIP.get()).requires(Items.PURPLE_DYE).unlockedBy("spaceship", has(CelestialItems.WHITE_SPACESHIP.get())).save(consumer);
		ShapelessRecipeBuilder.shapeless(CelestialItems.MAGENTA_SPACESHIP.get()).requires(CelestialItems.WHITE_SPACESHIP.get()).requires(Items.MAGENTA_DYE).unlockedBy("spaceship", has(CelestialItems.WHITE_SPACESHIP.get())).save(consumer);
		ShapelessRecipeBuilder.shapeless(CelestialItems.BROWN_SPACESHIP.get()).requires(CelestialItems.WHITE_SPACESHIP.get()).requires(Items.BROWN_DYE).unlockedBy("spaceship", has(CelestialItems.WHITE_SPACESHIP.get())).save(consumer);

		//---- SPACE STATION -------------------------------------------------------------------------------
		ShapedRecipeBuilder.shaped(CelestialBlocks.INSULATED_PANEL.get(), 4).pattern("XC").pattern("XC").define('X', CelestialItems.ALUMINUM_INGOT.get()).define('C', CelestialBlocks.WHITE_CERAMIC.get()).unlockedBy("aluminum", has(CelestialItems.ALUMINUM_INGOT.get())).save(consumer);
		ShapedRecipeBuilder.shaped(CelestialBlocks.PATHWAY_LIGHT.get(), 4).pattern("XXX").pattern(" T ").define('X', CelestialItems.ALUMINUM_INGOT.get()).define('T', Items.REDSTONE_TORCH).unlockedBy("aluminum", has(CelestialItems.ALUMINUM_INGOT.get())).save(consumer);
		SingleItemRecipeBuilder.stonecutting(Ingredient.of(CelestialBlocks.INSULATED_PANEL.get()), CelestialBlocks.INSULATED_PANEL_CORNER.get(), 1).unlockedBy("aluminum", has(CelestialItems.ALUMINUM_INGOT.get())).save(consumer);
		SingleItemRecipeBuilder.stonecutting(Ingredient.of(CelestialBlocks.INSULATED_PANEL_CORNER.get()), CelestialBlocks.INSULATED_PANEL.get(), 1).unlockedBy("aluminum", has(CelestialItems.ALUMINUM_INGOT.get())).save(consumer, saveName(CelestialBlocks.INSULATED_PANEL.get(),"stonecutting"));
		ShapedRecipeBuilder.shaped(CelestialBlocks.PANEL.get()).pattern("XX").pattern("XX").define('X', CelestialItems.ALUMINUM_INGOT.get()).unlockedBy("meteor", has(CelestialItems.ALUMINUM_INGOT.get())).save(consumer);
		stairsSlabWallCraftStonecutting(CelestialBlocks.PANEL.get(), CelestialBlocks.PANEL_STAIRS.get(), CelestialBlocks.PANEL_SLAB.get(), CelestialBlocks.PANEL_WALL.get(), CelestialBlocks.PANEL.get(), consumer);

		ShapedRecipeBuilder.shaped(CelestialBlocks.THIN_PANEL.get()).pattern("XX").pattern("XX").define('X', CelestialBlocks.PANEL.get()).unlockedBy("aluminum", has(CelestialItems.ALUMINUM_INGOT.get())).save(consumer);

//		pane(BlockRegistry.PANEL.get(), BlockRegistry.THIN_PANEL.get(), BlockRegistry.PANEL.get(), consumer);
		ShapedRecipeBuilder.shaped(CelestialBlocks.STEEL_LADDER.get()).pattern("X X").pattern("XXX").pattern("X X").define('X', CelestialItems.STEEL_INGOT.get()).unlockedBy("steel", has(CelestialItems.STEEL_INGOT.get())).save(consumer);

		ShapedRecipeBuilder.shaped(CelestialBlocks.AIRLOCK_DOOR.get()).pattern("GX").pattern("DX").define('X', CelestialItems.ALUMINUM_INGOT.get()).define('G', Tags.Items.GLASS_COLORLESS).define('D', CelestialBlocks.STEEL_DOOR.get()).unlockedBy("aluminum", has(CelestialItems.ALUMINUM_INGOT.get())).save(consumer);
		ShapedRecipeBuilder.shaped(CelestialBlocks.AIRLOCK_DOOR.get()).pattern("GX").pattern("DX").define('X', CelestialItems.ALUMINUM_INGOT.get()).define('G', Tags.Items.GLASS_COLORLESS).define('D', Items.IRON_DOOR).unlockedBy("aluminum", has(CelestialItems.ALUMINUM_INGOT.get())).save(consumer, saveName(CelestialBlocks.AIRLOCK_DOOR.get(), "from_iron_door"));

		ShapedRecipeBuilder.shaped(CelestialBlocks.AIRLOCK_PANEL_DOOR.get(), 8).pattern("XX ").pattern("XXR").pattern("XX ").define('X', CelestialItems.ALUMINUM_INGOT.get()).define('R', Items.REDSTONE).unlockedBy("aluminum", has(CelestialItems.ALUMINUM_INGOT.get())).save(consumer);
		ShapedRecipeBuilder.shaped(CelestialBlocks.AIRLOCK_PANEL_DOOR_WINDOW.get(), 8).pattern("XX ").pattern("XGR").pattern("XX ").define('X', CelestialItems.ALUMINUM_INGOT.get()).define('G', Tags.Items.GLASS).define('R', Items.REDSTONE).unlockedBy("aluminum", has(CelestialItems.ALUMINUM_INGOT.get())).save(consumer);
		ShapedRecipeBuilder.shaped(CelestialBlocks.HANGAR_DOOR.get(), 8).pattern("XX ").pattern("XXR").pattern("XX ").define('X', CelestialItems.STEEL_INGOT.get()).define('R', Items.REDSTONE).unlockedBy("steel", has(CelestialItems.STEEL_INGOT.get())).save(consumer);
		ShapedRecipeBuilder.shaped(CelestialBlocks.HANGAR_DOOR_WINDOW.get(), 8).pattern("XX ").pattern("XGR").pattern("XX ").define('X', CelestialItems.STEEL_INGOT.get()).define('G', Tags.Items.GLASS).define('R', Items.REDSTONE).unlockedBy("steel", has(CelestialItems.STEEL_INGOT.get())).save(consumer);

		ShapedRecipeBuilder.shaped(CelestialBlocks.AIRLOCK_TRAPDOOR.get(), 2).pattern("XGX").pattern("XXX").define('G', Tags.Items.GLASS_COLORLESS).define('X', CelestialItems.ALUMINUM_INGOT.get()).unlockedBy("steel", has(CelestialItems.STEEL_INGOT.get())).save(consumer);

		ShapedRecipeBuilder.shaped(CelestialBlocks.STEEL_DOOR.get(), 3).pattern("XX").pattern("XX").pattern("XX").define('X', CelestialItems.STEEL_INGOT.get()).unlockedBy("steel", has(CelestialItems.STEEL_INGOT.get())).save(consumer);
		ShapedRecipeBuilder.shaped(CelestialBlocks.STEEL_TRAPDOOR.get(), 2).pattern("XXX").pattern("XXX").define('X', CelestialItems.STEEL_INGOT.get()).unlockedBy("steel", has(CelestialItems.STEEL_INGOT.get())).save(consumer);
		ShapedRecipeBuilder.shaped(CelestialBlocks.STEEL_BUTTON.get()).pattern("XX").pattern("XX").define('X', CelestialItems.STEEL_NUGGET.get()).unlockedBy("steel", has(CelestialItems.STEEL_INGOT.get())).save(consumer);

		ShapedRecipeBuilder.shaped(CelestialBlocks.SOLAR_PANEL.get()).pattern("GGG").pattern("QQQ").pattern("SSS").define('G', Items.GLASS).define('Q', Items.QUARTZ_BLOCK).define('S', CelestialItems.ALUMINUM_INGOT.get()).unlockedBy("steel", has(CelestialItems.STEEL_INGOT.get())).save(consumer);

		ShapelessRecipeBuilder.shapeless(CelestialBlocks.GLOW_STRIP.get()).requires(Items.TORCH).requires(Items.IRON_NUGGET).unlockedBy("torch", has(Items.TORCH)).save(consumer, saveName(CelestialBlocks.GLOW_STRIP.get(), "from_iron"));
		ShapelessRecipeBuilder.shapeless(CelestialBlocks.GLOW_STRIP.get()).requires(Items.TORCH).requires(CelestialItems.STEEL_NUGGET.get()).unlockedBy("torch", has(Items.TORCH)).save(consumer, saveName(CelestialBlocks.GLOW_STRIP.get(), "from_steel"));
		singleItem(CelestialBlocks.GLOW_STRIP.get(), CelestialBlocks.HORIZONTAL_GLOW_STRIP.get(), 1, Blocks.TORCH, consumer);
		singleItem(CelestialBlocks.HORIZONTAL_GLOW_STRIP.get(), CelestialBlocks.GLOW_STRIP.get(), 1, Blocks.TORCH, consumer);

		singleItem(Blocks.RED_STAINED_GLASS, CelestialBlocks.RED_BUTTON.get(), 1, Blocks.RED_STAINED_GLASS, consumer);
		singleItem(Blocks.YELLOW_STAINED_GLASS, CelestialBlocks.YELLOW_BUTTON.get(), 1, Blocks.YELLOW_STAINED_GLASS, consumer);
		singleItem(Blocks.BLUE_STAINED_GLASS, CelestialBlocks.BLUE_BUTTON.get(), 1, Blocks.BLUE_STAINED_GLASS, consumer);
		singleItem(Blocks.GREEN_STAINED_GLASS, CelestialBlocks.GREEN_BUTTON.get(), 1, Blocks.GREEN_STAINED_GLASS, consumer);
		singleItem(Blocks.WHITE_STAINED_GLASS, CelestialBlocks.WHITE_BUTTON.get(), 1, Blocks.WHITE_STAINED_GLASS, consumer);
		singleItem(Blocks.BLACK_STAINED_GLASS, CelestialBlocks.BLACK_BUTTON.get(), 1, Blocks.BLACK_STAINED_GLASS, consumer);

		ShapedRecipeBuilder.shaped(CelestialBlocks.BLACK_DISPLAY_BOARD.get(), 2).pattern("XXR").pattern("XXD").define('X', CelestialItems.STEEL_NUGGET.get()).define('R', Items.REDSTONE).define('D', Items.BLACK_DYE).unlockedBy("steel", has(CelestialItems.STEEL_INGOT.get())).save(consumer);
		ShapedRecipeBuilder.shaped(CelestialBlocks.RED_DISPLAY_BOARD.get(), 2).pattern("XXR").pattern("XXD").define('X', CelestialItems.STEEL_NUGGET.get()).define('R', Items.REDSTONE).define('D', Items.RED_DYE).unlockedBy("steel", has(CelestialItems.STEEL_INGOT.get())).save(consumer);
		ShapedRecipeBuilder.shaped(CelestialBlocks.BLUE_DISPLAY_BOARD.get(), 2).pattern("XXR").pattern("XXD").define('X', CelestialItems.STEEL_NUGGET.get()).define('R', Items.REDSTONE).define('D', Items.BLUE_DYE).unlockedBy("steel", has(CelestialItems.STEEL_INGOT.get())).save(consumer);
		ShapedRecipeBuilder.shaped(CelestialBlocks.WHITE_DISPLAY_BOARD.get(), 2).pattern("XXR").pattern("XXD").define('X', CelestialItems.STEEL_NUGGET.get()).define('R', Items.REDSTONE).define('D', Items.WHITE_DYE).unlockedBy("steel", has(CelestialItems.STEEL_INGOT.get())).save(consumer);


		//---- MAG LEV -------------------------------------------------------------------------------
		ShapedRecipeBuilder.shaped(CelestialBlocks.MAGRAIL.get(), 16).pattern("X X").pattern("X#X").pattern("X X").define('X', CelestialItems.STEEL_INGOT.get()).define('#', CelestialItems.STEEL_ROD.get()).unlockedBy("steel", has(CelestialItems.STEEL_INGOT.get())).save(consumer);
		ShapedRecipeBuilder.shaped(CelestialBlocks.POWERED_MAGRAIL.get(), 6).pattern("X X").pattern("X#X").pattern("XRX").define('X', CelestialItems.STEEL_INGOT.get()).define('#', CelestialItems.STEEL_ROD.get()).define('R', Items.REDSTONE).unlockedBy("steel", has(CelestialItems.STEEL_INGOT.get())).save(consumer);
		ShapedRecipeBuilder.shaped(CelestialBlocks.DETECTOR_MAGRAIL.get(), 6).pattern("X X").pattern("X#X").pattern("XRX").define('X', CelestialItems.STEEL_INGOT.get()).define('#', CelestialTags.Items.STONE_PRESSURE_PLATE).define('R', Items.REDSTONE).unlockedBy("steel", has(CelestialItems.STEEL_INGOT.get())).save(consumer);
		ShapedRecipeBuilder.shaped(CelestialBlocks.ACTIVATOR_MAGRAIL.get(), 6).pattern("X#X").pattern("XRX").pattern("X#X").define('X', CelestialItems.STEEL_INGOT.get()).define('#', CelestialItems.STEEL_ROD.get()).define('R', Items.REDSTONE_TORCH).unlockedBy("steel", has(CelestialItems.STEEL_INGOT.get())).save(consumer);
		ShapedRecipeBuilder.shaped(CelestialItems.MAGCART.get()).pattern("X X").pattern("XXX").define('X', CelestialItems.STEEL_INGOT.get()).unlockedBy("steel", has(CelestialItems.STEEL_INGOT.get())).save(consumer);
		ShapedRecipeBuilder.shaped(CelestialItems.CHEST_MAGCART.get()).pattern("#").pattern("X").define('#', Tags.Items.CHESTS).define('X', CelestialItems.MAGCART.get()).unlockedBy("steel", has(CelestialItems.STEEL_INGOT.get())).save(consumer);
		ShapedRecipeBuilder.shaped(CelestialItems.CHEST_MAGCART.get()).pattern("X#X").pattern("XXX").define('#', Tags.Items.CHESTS).define('X', CelestialItems.STEEL_INGOT.get()).unlockedBy("steel", has(CelestialItems.STEEL_INGOT.get())).save(consumer, saveName(CelestialItems.CHEST_MAGCART.get(), "from_steel_ingots"));
		ShapedRecipeBuilder.shaped(CelestialItems.FURNACE_MAGCART.get()).pattern("#").pattern("X").define('#', Items.FURNACE).define('X', CelestialItems.MAGCART.get()).unlockedBy("steel", has(CelestialItems.STEEL_INGOT.get())).save(consumer);
		ShapedRecipeBuilder.shaped(CelestialItems.FURNACE_MAGCART.get()).pattern("X#X").pattern("XXX").define('#', Items.FURNACE).define('X', CelestialItems.STEEL_INGOT.get()).unlockedBy("steel", has(CelestialItems.STEEL_INGOT.get())).save(consumer, saveName(CelestialItems.FURNACE_MAGCART.get(), "from_steel_ingots"));
		ShapedRecipeBuilder.shaped(CelestialItems.HOPPER_MAGCART.get()).pattern("#").pattern("X").define('#', Items.HOPPER).define('X', CelestialItems.MAGCART.get()).unlockedBy("steel", has(CelestialItems.STEEL_INGOT.get())).save(consumer);
		ShapedRecipeBuilder.shaped(CelestialItems.HOPPER_MAGCART.get()).pattern("X#X").pattern("XXX").define('#', Items.HOPPER).define('X', CelestialItems.STEEL_INGOT.get()).unlockedBy("steel", has(CelestialItems.STEEL_INGOT.get())).save(consumer, saveName(CelestialItems.HOPPER_MAGCART.get(), "from_steel_ingots"));
		ShapedRecipeBuilder.shaped(CelestialItems.TNT_MAGCART.get()).pattern("#").pattern("X").define('#', Items.TNT).define('X', CelestialItems.MAGCART.get()).unlockedBy("steel", has(CelestialItems.STEEL_INGOT.get())).save(consumer);
		ShapedRecipeBuilder.shaped(CelestialItems.TNT_MAGCART.get()).pattern("X#X").pattern("XXX").define('#', Items.TNT).define('X', CelestialItems.STEEL_INGOT.get()).unlockedBy("steel", has(CelestialItems.STEEL_INGOT.get())).save(consumer, saveName(CelestialItems.TNT_MAGCART.get(),"from_steel_ingots"));

		//---- ARMOR -------------------------------------------------------------------------------
		//STEEL
		ShapedRecipeBuilder.shaped(CelestialItems.STEEL_HELMET.get()).pattern("XXX").pattern("X X").define('X', CelestialItems.STEEL_INGOT.get()).unlockedBy("steel_ingot", has(CelestialItems.STEEL_INGOT.get())).save(consumer);
		ShapedRecipeBuilder.shaped(CelestialItems.STEEL_CHESTPLATE.get()).pattern("X X").pattern("XXX").pattern("XXX").define('X', CelestialItems.STEEL_INGOT.get()).unlockedBy("steel_ingot", has(CelestialItems.STEEL_INGOT.get())).save(consumer);
		ShapedRecipeBuilder.shaped(CelestialItems.STEEL_LEGGINGS.get()).pattern("XXX").pattern("X X").pattern("X X").define('X', CelestialItems.STEEL_INGOT.get()).unlockedBy("steel_ingot", has(CelestialItems.STEEL_INGOT.get())).save(consumer);
		ShapedRecipeBuilder.shaped(CelestialItems.STEEL_BOOTS.get()).pattern("X X").pattern("X X").define('X', CelestialItems.STEEL_INGOT.get()).unlockedBy("steel_ingot", has(CelestialItems.STEEL_INGOT.get())).save(consumer);

		//SPACE SUITS
		WorkbenchCraftingRecipeBuilder.shaped(CelestialItems.BASIC_SPACESUIT_HELMET.get(), CelestialFluids.MOLTEN_STEEL.get(), 0.333F, 2.1F).pattern("LLL").pattern("WGW").define('L', Items.LEATHER).define('W', ItemTags.WOOL).define('G', Tags.Items.GLASS).unlockedBy("has_leather", has(Items.LEATHER)).save(consumer, saveName(CelestialItems.BASIC_SPACESUIT_HELMET.get(), ""));
		WorkbenchCraftingRecipeBuilder.shaped(CelestialItems.BASIC_SPACESUIT_CHESTPLATE.get(), CelestialFluids.MOLTEN_STEEL.get(), 0.666F, 4.2F).pattern("L L").pattern("WWW").pattern("LLL").define('W', ItemTags.WOOL).define('L', Items.LEATHER).unlockedBy("has_leather", has(Items.LEATHER)).save(consumer, saveName(CelestialItems.BASIC_SPACESUIT_CHESTPLATE.get(), ""));
		WorkbenchCraftingRecipeBuilder.shaped(CelestialItems.BASIC_SPACESUIT_LEGGINGS.get(), CelestialFluids.MOLTEN_STEEL.get(), 0.555F, 3.5F).pattern("LLL").pattern("L L").pattern("W W").define('W', ItemTags.WOOL).define('L', Items.LEATHER).unlockedBy("has_leather", has(Items.LEATHER)).save(consumer, saveName(CelestialItems.BASIC_SPACESUIT_LEGGINGS.get(), ""));
		WorkbenchCraftingRecipeBuilder.shaped(CelestialItems.BASIC_SPACESUIT_BOOTS.get(), CelestialFluids.MOLTEN_STEEL.get(), 0.222F, 1.4F).pattern("W W").pattern("L L").define('L', Items.LEATHER).define('W', ItemTags.WOOL).unlockedBy("has_leather", has(Items.LEATHER)).save(consumer, saveName(CelestialItems.BASIC_SPACESUIT_BOOTS.get(), ""));

		WorkbenchCraftingRecipeBuilder.shaped(CelestialItems.HEAVY_DUTY_SPACESUIT_HELMET.get(), CelestialFluids.MOLTEN_STEEL.get(), 0.444F, 2.8F).pattern("DDD").pattern("LGL").define('L', Items.LEATHER).define('G', Tags.Items.GLASS).define('D', Tags.Items.GEMS_DIAMOND).unlockedBy("has_diamond", has(Items.DIAMOND)).save(consumer, saveName(CelestialItems.HEAVY_DUTY_SPACESUIT_HELMET.get(), ""));
		WorkbenchCraftingRecipeBuilder.shaped(CelestialItems.HEAVY_DUTY_SPACESUIT_CHESTPLATE.get(), CelestialFluids.MOLTEN_STEEL.get(), 0.777F, 4.9F).pattern("L L").pattern("DDD").pattern("GMG").define('L', Items.LEATHER).define('G', Tags.Items.INGOTS_GOLD).define('D', Tags.Items.GEMS_DIAMOND).define('M', Items.MAGMA_CREAM).unlockedBy("has_diamond", has(Items.DIAMOND)).save(consumer, saveName(CelestialItems.HEAVY_DUTY_SPACESUIT_CHESTPLATE.get(), ""));
		WorkbenchCraftingRecipeBuilder.shaped(CelestialItems.HEAVY_DUTY_SPACESUIT_LEGGINGS.get(), CelestialFluids.MOLTEN_STEEL.get(), 0.666F, 4.2F).pattern("LLL").pattern("D D").pattern("L L").define('L', Items.LEATHER).define('D', Tags.Items.GEMS_DIAMOND).unlockedBy("has_diamond", has(Items.DIAMOND)).save(consumer, saveName(CelestialItems.HEAVY_DUTY_SPACESUIT_LEGGINGS.get(), ""));
		WorkbenchCraftingRecipeBuilder.shaped(CelestialItems.HEAVY_DUTY_SPACESUIT_BOOTS.get(), CelestialFluids.MOLTEN_STEEL.get(), 0.333F, 2.1F).pattern("R R").pattern("D D").define('D', Tags.Items.GEMS_DIAMOND).define('R', Items.RABBIT_HIDE).unlockedBy("has_diamond", has(Items.DIAMOND)).save(consumer, saveName(CelestialItems.HEAVY_DUTY_SPACESUIT_BOOTS.get(), ""));

		WorkbenchCraftingRecipeBuilder.shaped(CelestialItems.THERMAL_SPACESUIT_HELMET.get(), CelestialFluids.MOLTEN_STEEL.get(), 0.444F, 2.8F).pattern("DDD").pattern("WGW").define('W', ItemTags.WOOL).define('G', Tags.Items.GLASS).define('D', Tags.Items.GEMS_DIAMOND).unlockedBy("has_diamond", has(Items.DIAMOND)).save(consumer, saveName(CelestialItems.THERMAL_SPACESUIT_HELMET.get(), ""));
		WorkbenchCraftingRecipeBuilder.shaped(CelestialItems.THERMAL_SPACESUIT_CHESTPLATE.get(), CelestialFluids.MOLTEN_STEEL.get(), 0.777F, 4.9F).pattern("L L").pattern("DDD").pattern("WWW").define('L', Items.LEATHER).define('D', Tags.Items.GEMS_DIAMOND).define('W', ItemTags.WOOL).unlockedBy("has_diamond", has(Items.DIAMOND)).save(consumer, saveName(CelestialItems.THERMAL_SPACESUIT_CHESTPLATE.get(), ""));
		WorkbenchCraftingRecipeBuilder.shaped(CelestialItems.THERMAL_SPACESUIT_LEGGINGS.get(), CelestialFluids.MOLTEN_STEEL.get(), 0.666F, 4.2F).pattern("WWW").pattern("D D").pattern("W W").define('W', ItemTags.WOOL).define('D', Tags.Items.GEMS_DIAMOND).unlockedBy("has_diamond", has(Items.DIAMOND)).save(consumer, saveName(CelestialItems.THERMAL_SPACESUIT_LEGGINGS.get(), ""));
		WorkbenchCraftingRecipeBuilder.shaped(CelestialItems.THERMAL_SPACESUIT_BOOTS.get(), CelestialFluids.MOLTEN_STEEL.get(), 0.333F, 2.1F).pattern("L L").pattern("D D").define('D', Tags.Items.GEMS_DIAMOND).define('L', Items.LEATHER).unlockedBy("has_diamond", has(Items.DIAMOND)).save(consumer, saveName(CelestialItems.THERMAL_SPACESUIT_BOOTS.get(), ""));

		WorkbenchCraftingRecipeBuilder.shaped(CelestialItems.ADVANCED_SPACESUIT_HELMET.get(), CelestialFluids.MOLTEN_STEEL.get(), 0.444F, 2.8F).pattern("OOO").pattern("DGD").define('O', Items.OBSIDIAN).define('G', Tags.Items.GLASS).define('D', Tags.Items.GEMS_DIAMOND).unlockedBy("has_obsidian", has(Items.OBSIDIAN)).save(consumer, saveName(CelestialItems.ADVANCED_SPACESUIT_HELMET.get(), ""));
		WorkbenchCraftingRecipeBuilder.shaped(CelestialItems.ADVANCED_SPACESUIT_CHESTPLATE.get(), CelestialFluids.MOLTEN_STEEL.get(), 0.777F, 4.9F).pattern("L L").pattern("DDD").pattern("OOO").define('L', Items.LEATHER).define('D', Tags.Items.GEMS_DIAMOND).define('O', Items.OBSIDIAN).unlockedBy("has_obsidian", has(Items.OBSIDIAN)).save(consumer, saveName(CelestialItems.ADVANCED_SPACESUIT_CHESTPLATE.get(), ""));
		WorkbenchCraftingRecipeBuilder.shaped(CelestialItems.ADVANCED_SPACESUIT_LEGGINGS.get(), CelestialFluids.MOLTEN_STEEL.get(), 0.666F, 4.2F).pattern("DDD").pattern("O O").pattern("L L").define('O', Items.OBSIDIAN).define('L', Items.LEATHER).define('D', Tags.Items.GEMS_DIAMOND).unlockedBy("has_obsidian", has(Items.OBSIDIAN)).save(consumer, saveName(CelestialItems.ADVANCED_SPACESUIT_LEGGINGS.get(), ""));
		WorkbenchCraftingRecipeBuilder.shaped(CelestialItems.ADVANCED_SPACESUIT_BOOTS.get(), CelestialFluids.MOLTEN_STEEL.get(), 0.333F, 2.1F).pattern("L L").pattern("O O").define('O', Items.OBSIDIAN).define('L', Items.LEATHER).unlockedBy("has_obsidian", has(Items.OBSIDIAN)).save(consumer, saveName(CelestialItems.ADVANCED_SPACESUIT_BOOTS.get(), ""));

		//---- WORKBENCH SMELTING -------------------------------------------------------------------------------
		workbenchSmelting(Fluids.WATER, Items.WATER_BUCKET, 0.0F, 1, 1.0F, CelestialBlocks.WORKBENCH.get(), consumer);
		workbenchSmelting(Fluids.LAVA, Items.LAVA_BUCKET, 0.0F, 1, 1.0F, CelestialBlocks.WORKBENCH.get(), consumer);

		//IRON
		workbenchSmelting(CelestialFluids.MOLTEN_IRON.get(), Items.IRON_INGOT, 0.7F, 100, 0.1111F, Items.IRON_INGOT, consumer);
		workbenchSmelting(CelestialFluids.MOLTEN_IRON.get(), Items.RAW_IRON, 0.7F, 100, 0.1111F, Items.RAW_IRON, consumer);
		workbenchSmelting(CelestialFluids.MOLTEN_IRON.get(), Items.IRON_ORE, 0.1F, 100, 0.1111F, Items.IRON_ORE, consumer);
		workbenchSmelting(CelestialFluids.MOLTEN_IRON.get(), Items.DEEPSLATE_IRON_ORE, 0.1F, 100, 0.1111F, Items.DEEPSLATE_IRON_ORE, consumer);
		workbenchSmelting(CelestialFluids.MOLTEN_IRON.get(), CelestialBlocks.MARS_IRON_ORE.get(), 0.1F, 100, 0.1111F, CelestialBlocks.MARS_IRON_ORE.get(), consumer);
		workbenchSmelting(CelestialFluids.MOLTEN_IRON.get(), CelestialBlocks.MARS_DEEPSLATE_IRON_ORE.get(), 0.1F, 100, 0.1111F, CelestialBlocks.MARS_DEEPSLATE_IRON_ORE.get(), consumer);
//		workbenchSmelting(FluidRegistry.MOLTEN_IRON.get(), BlockRegistry.MOON_IRON_ORE.get(), 0.1F, 100, 0.1111F, BlockRegistry.MOON_IRON_ORE.get(), consumer);
//		workbenchSmelting(FluidRegistry.MOLTEN_IRON.get(), BlockRegistry.MOON_DEEPSLATE_IRON_ORE.get(), 0.1F, 100, 0.1111F, BlockRegistry.MOON_DEEPSLATE_IRON_ORE.get(), consumer);
		workbenchSmelting(CelestialFluids.MOLTEN_IRON.get(), CelestialBlocks.VENUS_IRON_ORE.get(), 0.1F, 100, 0.1111F, CelestialBlocks.VENUS_IRON_ORE.get(), consumer);
		workbenchSmelting(CelestialFluids.MOLTEN_IRON.get(), CelestialBlocks.VENUS_DEEPSLATE_IRON_ORE.get(), 0.1F, 100, 0.1111F, CelestialBlocks.VENUS_DEEPSLATE_IRON_ORE.get(), consumer);
		workbenchSmelting(CelestialFluids.MOLTEN_IRON.get(), CelestialBlocks.MERCURY_DEEPSLATE_IRON_ORE.get(), 0.1F, 100, 0.1111F, CelestialBlocks.VENUS_DEEPSLATE_IRON_ORE.get(), consumer);
		workbenchSmelting(CelestialFluids.MOLTEN_IRON.get(), CelestialBlocks.METEOR_IRON_ORE.get(), 0.1F, 100, 0.1111F, CelestialBlocks.METEOR_IRON_ORE.get(), consumer);
		workbenchSmelting(CelestialFluids.MOLTEN_IRON.get(), Items.IRON_BLOCK, 0.7F, 150, 1.0F, Items.IRON_INGOT, consumer);

		//COPPER
		workbenchSmelting(CelestialFluids.MOLTEN_COPPER.get(), Items.COPPER_INGOT, 0.7F, 100, .1111F, Items.COPPER_INGOT, consumer);
		workbenchSmelting(CelestialFluids.MOLTEN_COPPER.get(), Items.RAW_COPPER, 0.7F, 100, 0.1111F, Items.RAW_COPPER, consumer);
		workbenchSmelting(CelestialFluids.MOLTEN_COPPER.get(), Items.COPPER_ORE, 0.1F, 100, 0.1111F, Items.IRON_ORE, consumer);
		workbenchSmelting(CelestialFluids.MOLTEN_COPPER.get(), Items.DEEPSLATE_COPPER_ORE, 0.1F, 100, 0.1111F, Items.DEEPSLATE_COPPER_ORE, consumer);
		workbenchSmelting(CelestialFluids.MOLTEN_COPPER.get(), CelestialBlocks.METEOR_COPPER_ORE.get(), 0.1F, 100, 0.1111F, CelestialBlocks.METEOR_COPPER_ORE.get(), consumer);
		workbenchSmelting(CelestialFluids.MOLTEN_COPPER.get(), Items.COPPER_BLOCK, 0.7F, 150, 1.0F, Items.COPPER_BLOCK, consumer);
		workbenchSmelting(CelestialFluids.MOLTEN_COPPER.get(), Items.EXPOSED_COPPER, 0.7F, 150, 1.0F, Items.COPPER_BLOCK, consumer);
		workbenchSmelting(CelestialFluids.MOLTEN_COPPER.get(), Items.OXIDIZED_COPPER, 0.7F, 150, 1.0F, Items.COPPER_BLOCK, consumer);
		workbenchSmelting(CelestialFluids.MOLTEN_COPPER.get(), Items.WEATHERED_COPPER, 0.7F, 150, 1.0F, Items.COPPER_BLOCK, consumer);

		//GOLD
		workbenchSmelting(CelestialFluids.MOLTEN_GOLD.get(), Items.GOLD_INGOT, 0.7F, 100, 0.1111F, Items.GOLD_INGOT, consumer);
		workbenchSmelting(CelestialFluids.MOLTEN_GOLD.get(), Items.RAW_GOLD, 0.7F, 100, 0.1111F, Items.RAW_GOLD, consumer);
		workbenchSmelting(CelestialFluids.MOLTEN_GOLD.get(), Items.GOLD_ORE, 0.1F, 100, 0.1111F, Items.GOLD_ORE, consumer);
		workbenchSmelting(CelestialFluids.MOLTEN_GOLD.get(), Items.DEEPSLATE_GOLD_ORE, 0.1F, 100, 0.111F, Items.DEEPSLATE_GOLD_ORE, consumer);
		workbenchSmelting(CelestialFluids.MOLTEN_GOLD.get(), CelestialBlocks.METEOR_GOLD_ORE.get(), 0.1F, 100, 0.1111F, CelestialBlocks.METEOR_IRON_ORE.get(), consumer);
		workbenchSmelting(CelestialFluids.MOLTEN_GOLD.get(), Items.GOLD_BLOCK, 0.7F, 150, 1.0F, Items.GOLD_INGOT, consumer);

		//STEEL
		workbenchSmelting(CelestialFluids.MOLTEN_STEEL.get(), CelestialItems.STEEL_INGOT.get(), 0.7F, 100, 0.1111F, CelestialItems.STEEL_INGOT.get(), consumer);
		workbenchSmelting(CelestialFluids.MOLTEN_STEEL.get(), CelestialBlocks.STEEL_BLOCK.get(), 0.7F, 150, 1.0F, CelestialItems.STEEL_INGOT.get(), consumer);

		//ALUMINUM
		workbenchSmelting(CelestialFluids.MOLTEN_ALUMINUM.get(), CelestialItems.ALUMINUM_INGOT.get(), 0.7F, 100, 0.111F, CelestialItems.ALUMINUM_INGOT.get(), consumer);
		workbenchSmelting(CelestialFluids.MOLTEN_ALUMINUM.get(), CelestialBlocks.ALUMINUM_BLOCK.get(), 0.7F, 150, 1.0F, CelestialItems.ALUMINUM_INGOT.get(), consumer);

		//REMOVAL
		WorkbenchCraftingRecipeBuilder.shaped(Items.WATER_BUCKET, Fluids.WATER, 1.0F, 0.0F).pattern("X").define('X', Items.BUCKET).unlockedBy("has_iron", has(Items.IRON_INGOT)).save(consumer, saveName(Items.WATER_BUCKET, "from_workbench"));
		WorkbenchCraftingRecipeBuilder.shaped(Items.LAVA_BUCKET, Fluids.LAVA, 1.0F, 0.0F).pattern("X").define('X', Items.BUCKET).unlockedBy("has_iron", has(Items.IRON_INGOT)).save(consumer, saveName(Items.LAVA_BUCKET, "from_workbench"));

//		ShapedRecipeBuilder.shaped(ItemRegistry.BLOCK_MOLD.get(), 8).pattern("XXX").pattern("XCX").pattern("XXX").define('C', Items.STONE).define('X', Tags.Items.COBBLESTONE).unlockedBy("has_iron_ingot", has(Items.IRON_INGOT)).save(consumer);
//		ShapedRecipeBuilder.shaped(ItemRegistry.INGOT_MOLD.get(), 8).pattern("XXX").pattern("XCX").pattern("XXX").define('C', Tags.Items.INGOTS).define('X', Tags.Items.COBBLESTONE).unlockedBy("has_iron_ingot", has(Items.IRON_INGOT)).save(consumer);

		ShapedRecipeBuilder.shaped(CelestialItems.FLUID_BASIN.get(), 1).pattern("XGX").pattern("X X").pattern(" X ").define('G', Tags.Items.GLASS).define('X', Tags.Items.INGOTS_IRON).unlockedBy("has_iron_ingot", has(Items.IRON_INGOT)).save(consumer);
		ShapedRecipeBuilder.shaped(CelestialItems.FLUID_BASIN.get(), 1).pattern("XGX").pattern("X X").pattern(" X ").define('G', Tags.Items.GLASS).define('X', CelestialItems.STEEL_INGOT.get()).unlockedBy("has_steel_ingot", has(CelestialItems.STEEL_INGOT.get())).save(consumer, saveName(CelestialItems.FLUID_BASIN.get(), "from_steel"));

//		WorkbenchCraftingRecipeBuilder.shaped(Items.IRON_INGOT, FluidRegistry.MOLTEN_IRON.get(), 0.1111F, 0.0F).pattern("X").define('X', ItemRegistry.INGOT_MOLD.get()).unlockedBy("has_iron", has(Items.IRON_INGOT)).save(consumer, "iron_ingot_from_molten_iron");
//		WorkbenchCraftingRecipeBuilder.shaped(Items.IRON_BLOCK, FluidRegistry.MOLTEN_IRON.get(), 1.0F, 0.0F).pattern("X").define('X', ItemRegistry.BLOCK_MOLD.get()).unlockedBy("has_iron", has(Items.IRON_INGOT)).save(consumer, "iron_block_from_molten_iron");
//		WorkbenchCraftingRecipeBuilder.shaped(ItemRegistry.STEEL_INGOT.get(), FluidRegistry.MOLTEN_STEEL.get(), 0.1111F, 0.0F).pattern("X").define('X', ItemRegistry.INGOT_MOLD.get()).unlockedBy("has_steel", has(ItemRegistry.STEEL_INGOT.get())).save(consumer, "steel_ingot_from_molten_steel");
//		WorkbenchCraftingRecipeBuilder.shaped(BlockRegistry.STEEL_BLOCK.get(), FluidRegistry.MOLTEN_STEEL.get(), 1.0F, 0.0F).pattern("X").define('X', ItemRegistry.BLOCK_MOLD.get()).unlockedBy("has_steel", has(ItemRegistry.STEEL_INGOT.get())).save(consumer, "steel_block_from_molten_steel");
//		WorkbenchCraftingRecipeBuilder.shaped(Items.COPPER_INGOT, FluidRegistry.MOLTEN_COPPER.get(), 0.11F, 0.0F).pattern("X").define('X', ItemRegistry.INGOT_MOLD.get()).unlockedBy("has_copper", has(Items.COPPER_INGOT)).save(consumer, "copper_ingot_from_molten_copper");
//		WorkbenchCraftingRecipeBuilder.shaped(Items.COPPER_BLOCK, FluidRegistry.MOLTEN_COPPER.get(), 1.0F, 0.0F).pattern("X").define('X', ItemRegistry.BLOCK_MOLD.get()).unlockedBy("has_copper", has(Items.COPPER_INGOT)).save(consumer, "copper_block_from_molten_copper");
//		WorkbenchCraftingRecipeBuilder.shaped(Items.GOLD_INGOT, FluidRegistry.MOLTEN_GOLD.get(), 0.1111F, 0.0F).pattern("X").define('X', ItemRegistry.INGOT_MOLD.get()).unlockedBy("has_gold", has(Items.GOLD_INGOT)).save(consumer, "gold_ingot_from_molten_gold");
//		WorkbenchCraftingRecipeBuilder.shaped(Items.GOLD_BLOCK, FluidRegistry.MOLTEN_GOLD.get(), 1.0F, 0.0F).pattern("X").define('X', ItemRegistry.BLOCK_MOLD.get()).unlockedBy("has_gold", has(Items.GOLD_INGOT)).save(consumer, "gold_block_from_molten_gold");
//		WorkbenchCraftingRecipeBuilder.shaped(ItemRegistry.ALUMINUM_INGOT.get(), FluidRegistry.MOLTEN_ALUMINUM.get(), 0.1111F, 0.0F).pattern("X").define('X', ItemRegistry.INGOT_MOLD.get()).unlockedBy("has_aluminum", has(ItemRegistry.ALUMINUM_INGOT.get())).save(consumer, "aluminum_ingot_from_molten_aluminum");
//		WorkbenchCraftingRecipeBuilder.shaped(BlockRegistry.ALUMINUM_BLOCK.get(), FluidRegistry.MOLTEN_ALUMINUM.get(), 1.0F, 0.0F).pattern("X").define('X', ItemRegistry.BLOCK_MOLD.get()).unlockedBy("has_aluminum", has(BlockRegistry.ALUMINUM_BLOCK.get())).save(consumer, "aluminum_block_from_molten_aluminum");

		//---- GLASS/CERAMICS -------------------------------------------------------------------------------
		//GLASS
		ShapelessRecipeBuilder.shapeless(CelestialBlocks.LUMINOUS_BLUE_GLASS.get()).requires(Tags.Items.GLASS).requires(CelestialItems.MOON_DUST.get()).unlockedBy("moon_dust", has(CelestialItems.MOON_DUST.get())).save(consumer);
		ShapelessRecipeBuilder.shapeless(CelestialBlocks.LUMINOUS_WHITE_GLASS.get()).requires(Tags.Items.GLASS).requires(CelestialItems.WHITE_MOON_DUST.get()).unlockedBy("white_moon_dust", has(CelestialItems.WHITE_MOON_DUST.get())).save(consumer);
		ShapelessRecipeBuilder.shapeless(CelestialBlocks.LUMINOUS_CYAN_GLASS.get()).requires(Tags.Items.GLASS).requires(CelestialItems.EUROPA_DUST.get()).unlockedBy("europa_dust", has(CelestialItems.EUROPA_DUST.get())).save(consumer);
		ShapelessRecipeBuilder.shapeless(CelestialBlocks.LUMINOUS_MAGENTA_GLASS.get()).requires(Tags.Items.GLASS).requires(CelestialItems.CALLISTO_DUST.get()).unlockedBy("callisto_dust", has(CelestialItems.CALLISTO_DUST.get())).save(consumer);
		ShapelessRecipeBuilder.shapeless(CelestialBlocks.LUMINOUS_YELLOW_GLASS.get()).requires(Tags.Items.GLASS).requires(CelestialItems.IO_DUST.get()).unlockedBy("io_dust", has(CelestialItems.IO_DUST.get())).save(consumer);
		ShapelessRecipeBuilder.shapeless(CelestialBlocks.LUMINOUS_RED_GLASS.get()).requires(Tags.Items.GLASS).requires(CelestialItems.GANYMEDE_DUST.get()).unlockedBy("ganymede_dust", has(CelestialItems.GANYMEDE_DUST.get())).save(consumer);

		ShapedRecipeBuilder.shaped(CelestialBlocks.LUMINOUS_BLUE_GLASS_PANE.get(), 16).pattern("XXX").pattern("XXX").define('X', CelestialBlocks.LUMINOUS_BLUE_GLASS.get()).unlockedBy("moon_dust", has(CelestialItems.MOON_DUST.get())).save(consumer);
		ShapedRecipeBuilder.shaped(CelestialBlocks.LUMINOUS_WHITE_GLASS_PANE.get(), 16).pattern("XXX").pattern("XXX").define('X', CelestialBlocks.LUMINOUS_WHITE_GLASS.get()).unlockedBy("moon_dust", has(CelestialItems.MOON_DUST.get())).save(consumer);
		ShapedRecipeBuilder.shaped(CelestialBlocks.LUMINOUS_CYAN_GLASS_PANE.get(), 16).pattern("XXX").pattern("XXX").define('X', CelestialBlocks.LUMINOUS_CYAN_GLASS.get()).unlockedBy("europa_dust", has(CelestialItems.EUROPA_DUST.get())).save(consumer);
		ShapedRecipeBuilder.shaped(CelestialBlocks.LUMINOUS_MAGENTA_GLASS_PANE.get(), 16).pattern("XXX").pattern("XXX").define('X', CelestialBlocks.LUMINOUS_MAGENTA_GLASS.get()).unlockedBy("callisto_dust", has(CelestialItems.CALLISTO_DUST.get())).save(consumer);
		ShapedRecipeBuilder.shaped(CelestialBlocks.LUMINOUS_YELLOW_GLASS_PANE.get(), 16).pattern("XXX").pattern("XXX").define('X', CelestialBlocks.LUMINOUS_YELLOW_GLASS.get()).unlockedBy("io_dust", has(CelestialItems.IO_DUST.get())).save(consumer);
		ShapedRecipeBuilder.shaped(CelestialBlocks.LUMINOUS_RED_GLASS_PANE.get(), 16).pattern("XXX").pattern("XXX").define('X', CelestialBlocks.LUMINOUS_RED_GLASS.get()).unlockedBy("ganymede_dust", has(CelestialItems.GANYMEDE_DUST.get())).save(consumer);

		ShapedRecipeBuilder.shaped(CelestialBlocks.REINFORCED_GLASS.get(), 4).pattern(" X ").pattern("XCX").pattern(" X ").define('X', Blocks.GLASS).define('C', Items.IRON_INGOT).unlockedBy("glass", has(Blocks.GLASS)).save(consumer);
		ShapedRecipeBuilder.shaped(CelestialBlocks.REINFORCED_GLASS_PANE.get(), 16).pattern("XXX").pattern("XXX").define('X', CelestialBlocks.REINFORCED_GLASS.get()).unlockedBy("glass", has(Blocks.GLASS)).save(consumer);

		ShapedRecipeBuilder.shaped(Items.GLASS, 8).pattern("GGG").pattern("GXG").pattern("GGG").define('X', CelestialItems.STEEL_WOOL.get()).define('G', Tags.Items.STAINED_GLASS).unlockedBy("glass", has(Items.GLASS)).save(consumer, saveName(Items.GLASS, "steel_wool"));
		ShapedRecipeBuilder.shaped(Items.GLASS_PANE, 8).pattern("GGG").pattern("GXG").pattern("GGG").define('X', CelestialItems.STEEL_WOOL.get()).define('G', Tags.Items.STAINED_GLASS_PANES).unlockedBy("glass", has(Items.GLASS)).save(consumer, saveName(Items.GLASS_PANE, "from_steel_wool"));

		//CERAMIC
		WorkbenchCraftingRecipeBuilder.shaped(CelestialBlocks.SILICA.get(), 4, Fluids.WATER, 0.25F, 0.0F).pattern("SS").pattern("SS").define('S', Tags.Items.SAND).unlockedBy("has_sand", has(Items.SAND)).save(consumer, saveName(CelestialBlocks.SILICA.get(), "from_workbench"));
		smelting(CelestialBlocks.SILICA.get(), CelestialBlocks.CERAMIC.get(), 1.05F, 100, Blocks.SAND, consumer);

		ShapedRecipeBuilder.shaped(CelestialBlocks.CERAMIC.get(), 8).pattern("GGG").pattern("GXG").pattern("GGG").define('X', CelestialItems.STEEL_WOOL.get()).define('G', CelestialTags.Items.DYED_CERAMIC).unlockedBy("ceramic", has(CelestialBlocks.CERAMIC.get())).save(consumer, saveName(CelestialBlocks.CERAMIC.get(), "from_steel_wool"));
		ShapedRecipeBuilder.shaped(CelestialBlocks.CERAMIC_TILE.get(), 8).pattern("GGG").pattern("GXG").pattern("GGG").define('X', CelestialItems.STEEL_WOOL.get()).define('G', CelestialTags.Items.DYED_CERAMIC_TILE).unlockedBy("ceramic", has(CelestialBlocks.CERAMIC.get())).save(consumer, saveName(CelestialBlocks.CERAMIC_TILE.get(), "from_steel_wool"));

		ShapedRecipeBuilder.shaped(CelestialBlocks.WHITE_CERAMIC.get(), 8).pattern("XXX").pattern("X#X").pattern("XXX").define('X', CelestialBlocks.CERAMIC.get()).define('#', Items.WHITE_DYE).unlockedBy("ceramic", has(CelestialBlocks.CERAMIC.get())).save(consumer);
		ShapedRecipeBuilder.shaped(CelestialBlocks.LIGHT_GREY_CERAMIC.get(), 8).pattern("XXX").pattern("X#X").pattern("XXX").define('X', CelestialBlocks.CERAMIC.get()).define('#', Items.LIGHT_GRAY_DYE).unlockedBy("ceramic", has(CelestialBlocks.CERAMIC.get())).save(consumer);
		ShapedRecipeBuilder.shaped(CelestialBlocks.GREY_CERAMIC.get(), 8).pattern("XXX").pattern("X#X").pattern("XXX").define('X', CelestialBlocks.CERAMIC.get()).define('#', Items.GRAY_DYE).unlockedBy("ceramic", has(CelestialBlocks.CERAMIC.get())).save(consumer);
		ShapedRecipeBuilder.shaped(CelestialBlocks.BLACK_CERAMIC.get(), 8).pattern("XXX").pattern("X#X").pattern("XXX").define('X', CelestialBlocks.CERAMIC.get()).define('#', Items.BLACK_DYE).unlockedBy("ceramic", has(CelestialBlocks.CERAMIC.get())).save(consumer);
		ShapedRecipeBuilder.shaped(CelestialBlocks.PURPLE_CERAMIC.get(), 8).pattern("XXX").pattern("X#X").pattern("XXX").define('X', CelestialBlocks.CERAMIC.get()).define('#', Items.PURPLE_DYE).unlockedBy("ceramic", has(CelestialBlocks.CERAMIC.get())).save(consumer);
		ShapedRecipeBuilder.shaped(CelestialBlocks.MAGENTA_CERAMIC.get(), 8).pattern("XXX").pattern("X#X").pattern("XXX").define('X', CelestialBlocks.CERAMIC.get()).define('#', Items.MAGENTA_DYE).unlockedBy("ceramic", has(CelestialBlocks.CERAMIC.get())).save(consumer);
		ShapedRecipeBuilder.shaped(CelestialBlocks.BLUE_CERAMIC.get(), 8).pattern("XXX").pattern("X#X").pattern("XXX").define('X', CelestialBlocks.CERAMIC.get()).define('#', Items.BLUE_DYE).unlockedBy("ceramic", has(CelestialBlocks.CERAMIC.get())).save(consumer);
		ShapedRecipeBuilder.shaped(CelestialBlocks.LIGHT_BLUE_CERAMIC.get(), 8).pattern("XXX").pattern("X#X").pattern("XXX").define('X', CelestialBlocks.CERAMIC.get()).define('#', Items.LIGHT_BLUE_DYE).unlockedBy("ceramic", has(CelestialBlocks.CERAMIC.get())).save(consumer);
		ShapedRecipeBuilder.shaped(CelestialBlocks.CYAN_CERAMIC.get(), 8).pattern("XXX").pattern("X#X").pattern("XXX").define('X', CelestialBlocks.CERAMIC.get()).define('#', Items.CYAN_DYE).unlockedBy("ceramic", has(CelestialBlocks.CERAMIC.get())).save(consumer);
		ShapedRecipeBuilder.shaped(CelestialBlocks.GREEN_CERAMIC.get(), 8).pattern("XXX").pattern("X#X").pattern("XXX").define('X', CelestialBlocks.CERAMIC.get()).define('#', Items.GREEN_DYE).unlockedBy("ceramic", has(CelestialBlocks.CERAMIC.get())).save(consumer);
		ShapedRecipeBuilder.shaped(CelestialBlocks.LIME_CERAMIC.get(), 8).pattern("XXX").pattern("X#X").pattern("XXX").define('X', CelestialBlocks.CERAMIC.get()).define('#', Items.LIME_DYE).unlockedBy("ceramic", has(CelestialBlocks.CERAMIC.get())).save(consumer);
		ShapedRecipeBuilder.shaped(CelestialBlocks.YELLOW_CERAMIC.get(), 8).pattern("XXX").pattern("X#X").pattern("XXX").define('X', CelestialBlocks.CERAMIC.get()).define('#', Items.YELLOW_DYE).unlockedBy("ceramic", has(CelestialBlocks.CERAMIC.get())).save(consumer);
		ShapedRecipeBuilder.shaped(CelestialBlocks.ORANGE_CERAMIC.get(), 8).pattern("XXX").pattern("X#X").pattern("XXX").define('X', CelestialBlocks.CERAMIC.get()).define('#', Items.ORANGE_DYE).unlockedBy("ceramic", has(CelestialBlocks.CERAMIC.get())).save(consumer);
		ShapedRecipeBuilder.shaped(CelestialBlocks.BROWN_CERAMIC.get(), 8).pattern("XXX").pattern("X#X").pattern("XXX").define('X', CelestialBlocks.CERAMIC.get()).define('#', Items.BROWN_DYE).unlockedBy("ceramic", has(CelestialBlocks.CERAMIC.get())).save(consumer);
		ShapedRecipeBuilder.shaped(CelestialBlocks.RED_CERAMIC.get(), 8).pattern("XXX").pattern("X#X").pattern("XXX").define('X', CelestialBlocks.CERAMIC.get()).define('#', Items.RED_DYE).unlockedBy("ceramic", has(CelestialBlocks.CERAMIC.get())).save(consumer);
		ShapedRecipeBuilder.shaped(CelestialBlocks.PINK_CERAMIC.get(), 8).pattern("XXX").pattern("X#X").pattern("XXX").define('X', CelestialBlocks.CERAMIC.get()).define('#', Items.PINK_DYE).unlockedBy("ceramic", has(CelestialBlocks.CERAMIC.get())).save(consumer);

		pane(CelestialBlocks.CERAMIC.get(), CelestialBlocks.CERAMIC_TILE.get(), CelestialBlocks.CERAMIC.get(), consumer);
		pane(CelestialBlocks.WHITE_CERAMIC.get(), CelestialBlocks.WHITE_CERAMIC_TILE.get(), CelestialBlocks.CERAMIC.get(), consumer);
		pane(CelestialBlocks.LIGHT_GREY_CERAMIC.get(), CelestialBlocks.LIGHT_GREY_CERAMIC_TILE.get(), CelestialBlocks.CERAMIC.get(), consumer);
		pane(CelestialBlocks.GREY_CERAMIC.get(), CelestialBlocks.GREY_CERAMIC_TILE.get(), CelestialBlocks.CERAMIC.get(), consumer);
		pane(CelestialBlocks.BLACK_CERAMIC.get(), CelestialBlocks.BLACK_CERAMIC_TILE.get(), CelestialBlocks.CERAMIC.get(), consumer);
		pane(CelestialBlocks.PURPLE_CERAMIC.get(), CelestialBlocks.PURPLE_CERAMIC_TILE.get(), CelestialBlocks.CERAMIC.get(), consumer);
		pane(CelestialBlocks.MAGENTA_CERAMIC.get(), CelestialBlocks.MAGENTA_CERAMIC_TILE.get(), CelestialBlocks.CERAMIC.get(), consumer);
		pane(CelestialBlocks.BLUE_CERAMIC.get(), CelestialBlocks.BLUE_CERAMIC_TILE.get(), CelestialBlocks.CERAMIC.get(), consumer);
		pane(CelestialBlocks.LIGHT_BLUE_CERAMIC.get(), CelestialBlocks.LIGHT_BLUE_CERAMIC_TILE.get(), CelestialBlocks.CERAMIC.get(), consumer);
		pane(CelestialBlocks.CYAN_CERAMIC.get(), CelestialBlocks.CYAN_CERAMIC_TILE.get(), CelestialBlocks.CERAMIC.get(), consumer);
		pane(CelestialBlocks.GREEN_CERAMIC.get(), CelestialBlocks.GREEN_CERAMIC_TILE.get(), CelestialBlocks.CERAMIC.get(), consumer);
		pane(CelestialBlocks.LIME_CERAMIC.get(), CelestialBlocks.LIME_CERAMIC_TILE.get(), CelestialBlocks.CERAMIC.get(), consumer);
		pane(CelestialBlocks.YELLOW_CERAMIC.get(), CelestialBlocks.YELLOW_CERAMIC_TILE.get(), CelestialBlocks.CERAMIC.get(), consumer);
		pane(CelestialBlocks.ORANGE_CERAMIC.get(), CelestialBlocks.ORANGE_CERAMIC_TILE.get(), CelestialBlocks.CERAMIC.get(), consumer);
		pane(CelestialBlocks.BROWN_CERAMIC.get(), CelestialBlocks.BROWN_CERAMIC_TILE.get(), CelestialBlocks.CERAMIC.get(), consumer);
		pane(CelestialBlocks.RED_CERAMIC.get(), CelestialBlocks.RED_CERAMIC_TILE.get(), CelestialBlocks.CERAMIC.get(), consumer);
		pane(CelestialBlocks.PINK_CERAMIC.get(), CelestialBlocks.PINK_CERAMIC_TILE.get(), CelestialBlocks.CERAMIC.get(), consumer);

		smelting(CelestialBlocks.WHITE_CERAMIC.get(), CelestialBlocks.PAINTED_WHITE_CERAMIC.get(), 1.0F, 100, CelestialBlocks.CERAMIC.get(), consumer);
		smelting(CelestialBlocks.LIGHT_GREY_CERAMIC.get(), CelestialBlocks.PAINTED_LIGHT_GREY_CERAMIC.get(), 1.0F, 100, CelestialBlocks.CERAMIC.get(), consumer);
		smelting(CelestialBlocks.GREY_CERAMIC.get(), CelestialBlocks.PAINTED_GREY_CERAMIC.get(), 1.0F, 100, CelestialBlocks.CERAMIC.get(), consumer);
		smelting(CelestialBlocks.BLACK_CERAMIC.get(), CelestialBlocks.PAINTED_BLACK_CERAMIC.get(), 1.0F, 100, CelestialBlocks.CERAMIC.get(), consumer);
		smelting(CelestialBlocks.PURPLE_CERAMIC.get(), CelestialBlocks.PAINTED_PURPLE_CERAMIC.get(), 1.0F, 100, CelestialBlocks.CERAMIC.get(), consumer);
		smelting(CelestialBlocks.MAGENTA_CERAMIC.get(), CelestialBlocks.PAINTED_MAGENTA_CERAMIC.get(), 1.0F, 100, CelestialBlocks.CERAMIC.get(), consumer);
		smelting(CelestialBlocks.BLUE_CERAMIC.get(), CelestialBlocks.PAINTED_BLUE_CERAMIC.get(), 1.0F, 100, CelestialBlocks.CERAMIC.get(), consumer);
		smelting(CelestialBlocks.LIGHT_BLUE_CERAMIC.get(), CelestialBlocks.PAINTED_LIGHT_BLUE_CERAMIC.get(), 1.0F, 100, CelestialBlocks.CERAMIC.get(), consumer);
		smelting(CelestialBlocks.CYAN_CERAMIC.get(), CelestialBlocks.PAINTED_CYAN_CERAMIC.get(), 1.0F, 100, CelestialBlocks.CERAMIC.get(), consumer);
		smelting(CelestialBlocks.GREEN_CERAMIC.get(), CelestialBlocks.PAINTED_GREEN_CERAMIC.get(), 1.0F, 100, CelestialBlocks.CERAMIC.get(), consumer);
		smelting(CelestialBlocks.LIME_CERAMIC.get(), CelestialBlocks.PAINTED_LIME_CERAMIC.get(), 1.0F, 100, CelestialBlocks.CERAMIC.get(), consumer);
		smelting(CelestialBlocks.YELLOW_CERAMIC.get(), CelestialBlocks.PAINTED_YELLOW_CERAMIC.get(), 1.0F, 100, CelestialBlocks.CERAMIC.get(), consumer);
		smelting(CelestialBlocks.ORANGE_CERAMIC.get(), CelestialBlocks.PAINTED_ORANGE_CERAMIC.get(), 1.0F, 100, CelestialBlocks.CERAMIC.get(), consumer);
		smelting(CelestialBlocks.BROWN_CERAMIC.get(), CelestialBlocks.PAINTED_BROWN_CERAMIC.get(), 1.0F, 100, CelestialBlocks.CERAMIC.get(), consumer);
		smelting(CelestialBlocks.RED_CERAMIC.get(), CelestialBlocks.PAINTED_RED_CERAMIC.get(), 1.0F, 100, CelestialBlocks.CERAMIC.get(), consumer);
		smelting(CelestialBlocks.PINK_CERAMIC.get(), CelestialBlocks.PAINTED_PINK_CERAMIC.get(), 1.0F, 100, CelestialBlocks.CERAMIC.get(), consumer);

		//---- FOOD -------------------------------------------------------------------------------
		ShapedRecipeBuilder.shaped(CelestialItems.MARSHMALLOW.get()).pattern("XX").pattern("XX").define('X', CelestialItems.MARSHMALLOW_GOO.get()).unlockedBy("marshmallow_goo", has(CelestialItems.MARSHMALLOW_GOO.get())).save(consumer, saveName(CelestialItems.MARSHMALLOW.get(), "from_marshmallow_goo"));
		ShapelessRecipeBuilder.shapeless(CelestialItems.MARSHMALLOW.get(), 2).requires(Items.SUGAR).requires(Items.MILK_BUCKET).requires(Items.SUGAR).requires(Items.SUGAR).unlockedBy("sugar", has(Items.SUGAR)).save(consumer);
		ShapelessRecipeBuilder.shapeless(CelestialItems.CHOCOLATE.get()).requires(Items.SUGAR).requires(Items.MILK_BUCKET).requires(Items.COCOA_BEANS).unlockedBy("cocoa_beans", has(Items.COCOA_BEANS)).save(consumer);
		ShapedRecipeBuilder.shaped(CelestialItems.CRACKER.get(), 4).pattern("X").pattern("X").define('X', Items.WHEAT).unlockedBy("wheat", has(Items.WHEAT)).save(consumer);
		smelting(CelestialItems.MARSHMALLOW.get(), CelestialItems.ROASTED_MARSHMALLOW.get(), 0.1F, 100, CelestialItems.MARSHMALLOW_GOO.get(), consumer);
		ShapelessRecipeBuilder.shapeless(CelestialItems.SMORES.get()).requires(CelestialItems.ROASTED_MARSHMALLOW.get()).requires(CelestialItems.CHOCOLATE.get()).requires(CelestialItems.CRACKER.get()).requires(CelestialItems.CRACKER.get()).unlockedBy("marshmallow_goo", has(CelestialItems.MARSHMALLOW_GOO.get())).save(consumer);
		ShapelessRecipeBuilder.shapeless(CelestialItems.LUNAR_CHEESE.get()).requires(CelestialItems.MOON_MILK_BUCKET.get()).unlockedBy("moon_milk", has(CelestialItems.MOON_MILK_BUCKET.get())).save(consumer);
		ShapelessRecipeBuilder.shapeless(CelestialItems.CHEESE.get()).requires(Items.MILK_BUCKET).requires(Items.MILK_BUCKET).unlockedBy("milk", has(Items.MILK_BUCKET)).save(consumer);
		ShapelessRecipeBuilder.shapeless(CelestialItems.SUSPICIOUS_JELLO.get()).requires(CelestialTags.Items.SLIME_DROPS).requires(Items.SUGAR).unlockedBy("slime_ball", has(Items.SLIME_BALL)).save(consumer);

		//---- MISC -------------------------------------------------------------------------------
		ingotAndBlock(Items.COBBLESTONE, CelestialBlocks.COMPRESSED_COBBLESTONE.get(), Items.COBBLESTONE, consumer);
		ingotAndBlock(Items.COBBLED_DEEPSLATE, CelestialBlocks.COMPRESSED_COBBLED_DEEPSLATE.get(), Items.COBBLED_DEEPSLATE, consumer);
		ingotAndBlock(Items.NETHERRACK, CelestialBlocks.COMPRESSED_NETHERRACK.get(), Items.NETHERRACK, consumer);
		ingotAndBlock(CelestialBlocks.COMPRESSED_COBBLESTONE.get(), CelestialBlocks.SUPER_COMPRESSED_COBBLESTONE.get(), CelestialBlocks.COMPRESSED_COBBLESTONE.get(), consumer);
		ingotAndBlock(CelestialBlocks.COMPRESSED_COBBLED_DEEPSLATE.get(), CelestialBlocks.SUPER_COMPRESSED_COBBLED_DEEPSLATE.get(), CelestialBlocks.COMPRESSED_COBBLED_DEEPSLATE.get(), consumer);
		ingotAndBlock(CelestialBlocks.COMPRESSED_NETHERRACK.get(), CelestialBlocks.SUPER_COMPRESSED_NETHERRACK.get(), CelestialBlocks.COMPRESSED_NETHERRACK.get(), consumer);

		ShapelessRecipeBuilder.shapeless(CelestialBlocks.PLANET_CHART.get()).requires(ItemTags.PLANKS).requires(Items.PAPER).requires(Items.BLACK_DYE).unlockedBy("crafting_table", has(Items.CRAFTING_TABLE)).save(consumer);
		ShapelessRecipeBuilder.shapeless(CelestialItems.WHITE_MOON_DUST.get()).requires(CelestialTags.Items.LUNAR_DUSTS).requires(CelestialItems.LUNAR_GOO.get()).unlockedBy("lunar_goo", has(CelestialItems.LUNAR_GOO.get())).save(consumer);

		ShapedRecipeBuilder.shaped(Blocks.FURNACE).pattern("XXX").pattern("X X").pattern("XXX").define('X', CelestialTags.Items.CELESTIAL_COBBLESTONE).unlockedBy("has_moon_cobblestone", has(CelestialBlocks.MOON_COBBLESTONE.get())).save(consumer, saveName(Items.FURNACE, "from_celestial_cobblestone"));

		WorkbenchCraftingRecipeBuilder.shaped(CelestialItems.WHITE_MECHADOG.get(), CelestialFluids.MOLTEN_STEEL.get(), 0.333F, 1.4F)
				.pattern("  E")
				.pattern("FRF")
				.pattern("R R")
				.define('E', CelestialBlocks.MECHADOG_HEAD.get())
				.define('F', CelestialBlocks.STEEL_FRAME.get())
				.define('R', Items.REDSTONE).unlockedBy("has_head", has(CelestialBlocks.MECHADOG_HEAD.get())).save(consumer, saveName(CelestialItems.WHITE_MECHADOG.get(), ""));

		WorkbenchCraftingRecipeBuilder.shaped(CelestialItems.WHITE_MECHACERBERUS.get(), CelestialFluids.MOLTEN_STEEL.get(), 0.666F, 2.0F)
				.pattern("HHH")
				.pattern("FCF")
				.pattern("R R")
				.define('C', CelestialItems.MECHACERBERUS_CORE.get())
				.define('H', CelestialBlocks.MECHADOG_HEAD.get())
				.define('F', CelestialBlocks.STEEL_FRAME.get())
				.define('R', Items.REDSTONE).unlockedBy("has_core", has(CelestialItems.MECHACERBERUS_CORE.get())).save(consumer, saveName(CelestialItems.WHITE_MECHACERBERUS.get(), ""));

		ShapelessRecipeBuilder.shapeless(CelestialItems.BLACK_MECHADOG.get()).requires(CelestialItems.WHITE_MECHADOG.get()).requires(Items.BLACK_DYE).unlockedBy("mechadog", has(CelestialItems.WHITE_MECHADOG.get())).save(consumer);
		ShapelessRecipeBuilder.shapeless(CelestialItems.GREY_MECHADOG.get()).requires(CelestialItems.WHITE_MECHADOG.get()).requires(Items.GRAY_DYE).unlockedBy("mechadog", has(CelestialItems.WHITE_MECHADOG.get())).save(consumer);
		ShapelessRecipeBuilder.shapeless(CelestialItems.LIGHT_GREY_MECHADOG.get()).requires(CelestialItems.WHITE_MECHADOG.get()).requires(Items.LIGHT_GRAY_DYE).unlockedBy("mechadog", has(CelestialItems.WHITE_MECHADOG.get())).save(consumer);
		ShapelessRecipeBuilder.shapeless(CelestialItems.PINK_MECHADOG.get()).requires(CelestialItems.WHITE_MECHADOG.get()).requires(Items.PINK_DYE).unlockedBy("mechadog", has(CelestialItems.WHITE_MECHADOG.get())).save(consumer);
		ShapelessRecipeBuilder.shapeless(CelestialItems.RED_MECHADOG.get()).requires(CelestialItems.WHITE_MECHADOG.get()).requires(Items.RED_DYE).unlockedBy("mechadog", has(CelestialItems.WHITE_MECHADOG.get())).save(consumer);
		ShapelessRecipeBuilder.shapeless(CelestialItems.ORANGE_MECHADOG.get()).requires(CelestialItems.WHITE_MECHADOG.get()).requires(Items.ORANGE_DYE).unlockedBy("mechadog", has(CelestialItems.WHITE_MECHADOG.get())).save(consumer);
		ShapelessRecipeBuilder.shapeless(CelestialItems.YELLOW_MECHADOG.get()).requires(CelestialItems.WHITE_MECHADOG.get()).requires(Items.YELLOW_DYE).unlockedBy("mechadog", has(CelestialItems.WHITE_MECHADOG.get())).save(consumer);
		ShapelessRecipeBuilder.shapeless(CelestialItems.LIME_MECHADOG.get()).requires(CelestialItems.WHITE_MECHADOG.get()).requires(Items.LIME_DYE).unlockedBy("mechadog", has(CelestialItems.WHITE_MECHADOG.get())).save(consumer);
		ShapelessRecipeBuilder.shapeless(CelestialItems.GREEN_MECHADOG.get()).requires(CelestialItems.WHITE_MECHADOG.get()).requires(Items.GREEN_DYE).unlockedBy("mechadog", has(CelestialItems.WHITE_MECHADOG.get())).save(consumer);
		ShapelessRecipeBuilder.shapeless(CelestialItems.CYAN_MECHADOG.get()).requires(CelestialItems.WHITE_MECHADOG.get()).requires(Items.CYAN_DYE).unlockedBy("mechadog", has(CelestialItems.WHITE_MECHADOG.get())).save(consumer);
		ShapelessRecipeBuilder.shapeless(CelestialItems.BLUE_MECHADOG.get()).requires(CelestialItems.WHITE_MECHADOG.get()).requires(Items.BLUE_DYE).unlockedBy("mechadog", has(CelestialItems.WHITE_MECHADOG.get())).save(consumer);
		ShapelessRecipeBuilder.shapeless(CelestialItems.LIGHT_BLUE_MECHADOG.get()).requires(CelestialItems.WHITE_MECHADOG.get()).requires(Items.LIGHT_BLUE_DYE).unlockedBy("mechadog", has(CelestialItems.WHITE_MECHADOG.get())).save(consumer);
		ShapelessRecipeBuilder.shapeless(CelestialItems.PURPLE_MECHADOG.get()).requires(CelestialItems.WHITE_MECHADOG.get()).requires(Items.PURPLE_DYE).unlockedBy("mechadog", has(CelestialItems.WHITE_MECHADOG.get())).save(consumer);
		ShapelessRecipeBuilder.shapeless(CelestialItems.MAGENTA_MECHADOG.get()).requires(CelestialItems.WHITE_MECHADOG.get()).requires(Items.MAGENTA_DYE).unlockedBy("mechadog", has(CelestialItems.WHITE_MECHADOG.get())).save(consumer);
		ShapelessRecipeBuilder.shapeless(CelestialItems.BROWN_MECHADOG.get()).requires(CelestialItems.WHITE_MECHADOG.get()).requires(Items.BROWN_DYE).unlockedBy("mechadog", has(CelestialItems.WHITE_MECHADOG.get())).save(consumer);

		ShapelessRecipeBuilder.shapeless(CelestialItems.BLACK_MECHACERBERUS.get()).requires(CelestialItems.WHITE_MECHACERBERUS.get()).requires(Items.BLACK_DYE).unlockedBy("mechacerberus", has(CelestialItems.WHITE_MECHACERBERUS.get())).save(consumer);
		ShapelessRecipeBuilder.shapeless(CelestialItems.GREY_MECHACERBERUS.get()).requires(CelestialItems.WHITE_MECHACERBERUS.get()).requires(Items.GRAY_DYE).unlockedBy("mechacerberus", has(CelestialItems.WHITE_MECHACERBERUS.get())).save(consumer);
		ShapelessRecipeBuilder.shapeless(CelestialItems.LIGHT_GREY_MECHACERBERUS.get()).requires(CelestialItems.WHITE_MECHACERBERUS.get()).requires(Items.LIGHT_GRAY_DYE).unlockedBy("mechacerberus", has(CelestialItems.WHITE_MECHACERBERUS.get())).save(consumer);
		ShapelessRecipeBuilder.shapeless(CelestialItems.PINK_MECHACERBERUS.get()).requires(CelestialItems.WHITE_MECHACERBERUS.get()).requires(Items.PINK_DYE).unlockedBy("mechacerberus", has(CelestialItems.WHITE_MECHACERBERUS.get())).save(consumer);
		ShapelessRecipeBuilder.shapeless(CelestialItems.RED_MECHACERBERUS.get()).requires(CelestialItems.WHITE_MECHACERBERUS.get()).requires(Items.RED_DYE).unlockedBy("mechacerberus", has(CelestialItems.WHITE_MECHACERBERUS.get())).save(consumer);
		ShapelessRecipeBuilder.shapeless(CelestialItems.ORANGE_MECHACERBERUS.get()).requires(CelestialItems.WHITE_MECHACERBERUS.get()).requires(Items.ORANGE_DYE).unlockedBy("mechacerberus", has(CelestialItems.WHITE_MECHACERBERUS.get())).save(consumer);
		ShapelessRecipeBuilder.shapeless(CelestialItems.YELLOW_MECHACERBERUS.get()).requires(CelestialItems.WHITE_MECHACERBERUS.get()).requires(Items.YELLOW_DYE).unlockedBy("mechacerberus", has(CelestialItems.WHITE_MECHACERBERUS.get())).save(consumer);
		ShapelessRecipeBuilder.shapeless(CelestialItems.LIME_MECHACERBERUS.get()).requires(CelestialItems.WHITE_MECHACERBERUS.get()).requires(Items.LIME_DYE).unlockedBy("mechacerberus", has(CelestialItems.WHITE_MECHACERBERUS.get())).save(consumer);
		ShapelessRecipeBuilder.shapeless(CelestialItems.GREEN_MECHACERBERUS.get()).requires(CelestialItems.WHITE_MECHACERBERUS.get()).requires(Items.GREEN_DYE).unlockedBy("mechacerberus", has(CelestialItems.WHITE_MECHACERBERUS.get())).save(consumer);
		ShapelessRecipeBuilder.shapeless(CelestialItems.CYAN_MECHACERBERUS.get()).requires(CelestialItems.WHITE_MECHACERBERUS.get()).requires(Items.CYAN_DYE).unlockedBy("mechacerberus", has(CelestialItems.WHITE_MECHACERBERUS.get())).save(consumer);
		ShapelessRecipeBuilder.shapeless(CelestialItems.BLUE_MECHACERBERUS.get()).requires(CelestialItems.WHITE_MECHACERBERUS.get()).requires(Items.BLUE_DYE).unlockedBy("mechacerberus", has(CelestialItems.WHITE_MECHACERBERUS.get())).save(consumer);
		ShapelessRecipeBuilder.shapeless(CelestialItems.LIGHT_BLUE_MECHACERBERUS.get()).requires(CelestialItems.WHITE_MECHACERBERUS.get()).requires(Items.LIGHT_BLUE_DYE).unlockedBy("mechacerberus", has(CelestialItems.WHITE_MECHACERBERUS.get())).save(consumer);
		ShapelessRecipeBuilder.shapeless(CelestialItems.PURPLE_MECHACERBERUS.get()).requires(CelestialItems.WHITE_MECHACERBERUS.get()).requires(Items.PURPLE_DYE).unlockedBy("mechacerberus", has(CelestialItems.WHITE_MECHACERBERUS.get())).save(consumer);
		ShapelessRecipeBuilder.shapeless(CelestialItems.MAGENTA_MECHACERBERUS.get()).requires(CelestialItems.WHITE_MECHACERBERUS.get()).requires(Items.MAGENTA_DYE).unlockedBy("mechacerberus", has(CelestialItems.WHITE_MECHACERBERUS.get())).save(consumer);
		ShapelessRecipeBuilder.shapeless(CelestialItems.BROWN_MECHACERBERUS.get()).requires(CelestialItems.WHITE_MECHACERBERUS.get()).requires(Items.BROWN_DYE).unlockedBy("mechacerberus", has(CelestialItems.WHITE_MECHACERBERUS.get())).save(consumer);

		//TOOLS
		ShapedRecipeBuilder.shaped(Items.DIAMOND_AXE).define('#', CelestialItems.STONE_ROD.get()).define('X', Items.DIAMOND).pattern("XX").pattern("X#").pattern(" #").unlockedBy("has_diamond", has(Items.DIAMOND)).save(consumer, "diamond_axe_from_stone_rod");
		ShapedRecipeBuilder.shaped(Items.DIAMOND_HOE).define('#', CelestialItems.STONE_ROD.get()).define('X', Items.DIAMOND).pattern("XX").pattern(" #").pattern(" #").unlockedBy("has_diamond", has(Items.DIAMOND)).save(consumer, "diamond_hoe_from_stone_rod");
		ShapedRecipeBuilder.shaped(Items.DIAMOND_PICKAXE).define('#', CelestialItems.STONE_ROD.get()).define('X', Items.DIAMOND).pattern("XXX").pattern(" # ").pattern(" # ").unlockedBy("has_diamond", has(Items.DIAMOND)).save(consumer, "diamond_pickaxe_from_stone_rod");
		ShapedRecipeBuilder.shaped(Items.DIAMOND_SHOVEL).define('#', CelestialItems.STONE_ROD.get()).define('X', Items.DIAMOND).pattern("X").pattern("#").pattern("#").unlockedBy("has_diamond", has(Items.DIAMOND)).save(consumer, "diamond_shovel_from_stone_rod");
		ShapedRecipeBuilder.shaped(Items.DIAMOND_SWORD).define('#', CelestialItems.STONE_ROD.get()).define('X', Items.DIAMOND).pattern("X").pattern("X").pattern("#").unlockedBy("has_diamond", has(Items.DIAMOND)).save(consumer, "diamond_sword_from_stone_rod");

		ShapedRecipeBuilder.shaped(Items.GOLDEN_AXE).define('#', CelestialItems.STONE_ROD.get()).define('X', Items.GOLD_INGOT).pattern("XX").pattern("X#").pattern(" #").unlockedBy("has_gold_ingot", has(Items.GOLD_INGOT)).save(consumer, "gold_axe_from_stone_rod");
		ShapedRecipeBuilder.shaped(Items.GOLDEN_HOE).define('#', CelestialItems.STONE_ROD.get()).define('X', Items.GOLD_INGOT).pattern("XX").pattern(" #").pattern(" #").unlockedBy("has_gold_ingot", has(Items.GOLD_INGOT)).save(consumer, "gold_hoe_from_stone_rod");
		ShapedRecipeBuilder.shaped(Items.GOLDEN_PICKAXE).define('#', CelestialItems.STONE_ROD.get()).define('X', Items.GOLD_INGOT).pattern("XXX").pattern(" # ").pattern(" # ").unlockedBy("has_gold_ingot", has(Items.GOLD_INGOT)).save(consumer, "gold_pickaxe_from_stone_rod");
		ShapedRecipeBuilder.shaped(Items.GOLDEN_SHOVEL).define('#', CelestialItems.STONE_ROD.get()).define('X', Items.GOLD_INGOT).pattern("X").pattern("#").pattern("#").unlockedBy("has_gold_ingot", has(Items.GOLD_INGOT)).save(consumer, "gold_shovel_from_stone_rod");
		ShapedRecipeBuilder.shaped(Items.GOLDEN_SWORD).define('#', CelestialItems.STONE_ROD.get()).define('X', Items.GOLD_INGOT).pattern("X").pattern("X").pattern("#").unlockedBy("has_gold_ingot", has(Items.GOLD_INGOT)).save(consumer, "gold_sword_from_stone_rod");

		ShapedRecipeBuilder.shaped(Items.IRON_AXE).define('#', CelestialItems.STONE_ROD.get()).define('X', Items.IRON_INGOT).pattern("XX").pattern("X#").pattern(" #").unlockedBy("has_iron_ingot", has(Items.IRON_INGOT)).save(consumer, "iron_axe_from_stone_rod");
		ShapedRecipeBuilder.shaped(Items.IRON_HOE).define('#', CelestialItems.STONE_ROD.get()).define('X', Items.IRON_INGOT).pattern("XX").pattern(" #").pattern(" #").unlockedBy("has_iron_ingot", has(Items.IRON_INGOT)).save(consumer, "iron_hoe_from_stone_rod");
		ShapedRecipeBuilder.shaped(Items.IRON_PICKAXE).define('#', CelestialItems.STONE_ROD.get()).define('X', Items.IRON_INGOT).pattern("XXX").pattern(" # ").pattern(" # ").unlockedBy("has_iron_ingot", has(Items.IRON_INGOT)).save(consumer, "iron_pickaxe_from_stone_rod");
		ShapedRecipeBuilder.shaped(Items.IRON_SHOVEL).define('#', CelestialItems.STONE_ROD.get()).define('X', Items.IRON_INGOT).pattern("X").pattern("#").pattern("#").unlockedBy("has_iron_ingot", has(Items.IRON_INGOT)).save(consumer, "iron_shovel_from_stone_rod");
		ShapedRecipeBuilder.shaped(Items.IRON_SWORD).define('#', CelestialItems.STONE_ROD.get()).define('X', Items.IRON_INGOT).pattern("X").pattern("X").pattern("#").unlockedBy("has_iron_ingot", has(Items.IRON_INGOT)).save(consumer, "iron_sword_from_stone_rod");

		ShapedRecipeBuilder.shaped(Items.STONE_AXE).define('#', CelestialItems.STONE_ROD.get()).define('X', ItemTags.STONE_TOOL_MATERIALS).pattern("XX").pattern("X#").pattern(" #").unlockedBy("has_cobblestone", has(ItemTags.STONE_TOOL_MATERIALS)).save(consumer, "stone_axe_from_stone_rod");
		ShapedRecipeBuilder.shaped(Items.STONE_HOE).define('#', CelestialItems.STONE_ROD.get()).define('X', ItemTags.STONE_TOOL_MATERIALS).pattern("XX").pattern(" #").pattern(" #").unlockedBy("has_cobblestone", has(ItemTags.STONE_TOOL_MATERIALS)).save(consumer, "stone_hoe_from_stone_rod");
		ShapedRecipeBuilder.shaped(Items.STONE_PICKAXE).define('#', CelestialItems.STONE_ROD.get()).define('X', ItemTags.STONE_TOOL_MATERIALS).pattern("XXX").pattern(" # ").pattern(" # ").unlockedBy("has_cobblestone", has(ItemTags.STONE_TOOL_MATERIALS)).save(consumer, "stone_pickaxe_from_stone_rod");
		ShapedRecipeBuilder.shaped(Items.STONE_SHOVEL).define('#', CelestialItems.STONE_ROD.get()).define('X', ItemTags.STONE_TOOL_MATERIALS).pattern("X").pattern("#").pattern("#").unlockedBy("has_cobblestone", has(ItemTags.STONE_TOOL_MATERIALS)).save(consumer, "stone_shovel_from_stone_rod");
		ShapedRecipeBuilder.shaped(Items.STONE_SWORD).define('#', CelestialItems.STONE_ROD.get()).define('X', ItemTags.STONE_TOOL_MATERIALS).pattern("X").pattern("X").pattern("#").unlockedBy("has_cobblestone", has(ItemTags.STONE_TOOL_MATERIALS)).save(consumer, "stone_sword_from_stone_rod");



	}

	private static String name(ItemLike item) {
		return item.asItem().getRegistryName().getPath();
	}

	private static String saveName(ItemLike item, String suffix) {
		return CelestialExploration.MODID + ":" + item.asItem().getRegistryName().getPath() + "_" + suffix;
	}

	private static String saveName(FlowingFluid fluid, String suffix) {
		return CelestialExploration.MODID + ":" + fluid.getRegistryName().getPath() + "_" + suffix;
	}

	public static void workbenchSmelting(FlowingFluid fluidResult, ItemLike itemToSmelt, float experience, int cookingTime, float buckets, ItemLike unlockedBy, Consumer<FinishedRecipe> consumer) {
		WorkbenchSmeltingRecipeBuilder.smelting(fluidResult, Ingredient.of(itemToSmelt), experience, cookingTime, buckets).unlockedBy("has_" + name(unlockedBy), has(unlockedBy)).save(consumer, saveName(fluidResult, "from_" + name(itemToSmelt) + "_workbench"));
	}
}