package com.shim.celestialexploration.datagen.util;

import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.data.recipes.*;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.FlowingFluid;

import java.util.function.Consumer;

public class RecipeGenHelper {

    private static InventoryChangeTrigger.TriggerInstance has(ItemLike item) {
        return InventoryChangeTrigger.TriggerInstance.hasItems(item);
    }

    public static void smelting(Item itemToSmelt, Item result, float experience, int cookingTime, Item unlockedBy, Consumer<FinishedRecipe> consumer) {
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(itemToSmelt), result, experience, cookingTime).group("celestialexploration").unlockedBy("has_" + unlockedBy.getRegistryName().getPath(), has(unlockedBy)).save(consumer);
    }

    public static void smelting(Block itemToSmelt, Item result, float experience, int cookingTime, Block unlockedBy, Consumer<FinishedRecipe> consumer) {
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(itemToSmelt), result, experience, cookingTime).group("celestialexploration").unlockedBy("has_" + unlockedBy.getRegistryName().getPath(), has(unlockedBy)).save(consumer);
    }

    public static void smelting(Block itemToSmelt, Block result, float experience, int cookingTime, Block unlockedBy, Consumer<FinishedRecipe> consumer) {
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(itemToSmelt), result, experience, cookingTime).group("celestialexploration").unlockedBy("has_" + unlockedBy.getRegistryName().getPath(), has(unlockedBy)).save(consumer);
    }

    public static void smeltingAndBlasting(Block itemToSmelt, Item result, float experience, int smeltingTime, int blastingTime, Block unlockedBy, Consumer<FinishedRecipe> consumer) {
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(itemToSmelt), result, experience, smeltingTime).group("celestialexploration").unlockedBy("has_" + unlockedBy.getRegistryName().getPath(), has(unlockedBy)).save(consumer, itemToSmelt.getRegistryName().getPath() + "_smelting");
        SimpleCookingRecipeBuilder.blasting(Ingredient.of(itemToSmelt), result, experience, blastingTime).group("celestialexploration").unlockedBy("has_" + unlockedBy.getRegistryName().getPath(), has(unlockedBy)).save(consumer, itemToSmelt.getRegistryName().getPath() + "_blasting");
    }

    public static void smeltingAndBlasting(Item itemToSmelt, Item result, float experience, int smeltingTime, int blastingTime, Item unlockedBy, Consumer<FinishedRecipe> consumer) {
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(itemToSmelt), result, experience, smeltingTime).group("celestialexploration").unlockedBy("has_" + unlockedBy.getRegistryName().getPath(), has(unlockedBy)).save(consumer, itemToSmelt.getRegistryName().getPath() + "_smelting");
        SimpleCookingRecipeBuilder.blasting(Ingredient.of(itemToSmelt), result, experience, blastingTime).group("celestialexploration").unlockedBy("has_" + unlockedBy.getRegistryName().getPath(), has(unlockedBy)).save(consumer, itemToSmelt.getRegistryName().getPath() + "_blasting");
    }


    public static void workbenchSmelting(FlowingFluid fluidResult, Item itemToSmelt, float experience, int cookingTime, float buckets, Item unlockedBy, Consumer<FinishedRecipe> consumer) {
        WorkbenchSmeltingRecipeBuilder.smelting(fluidResult, Ingredient.of(itemToSmelt), experience, cookingTime, buckets).group("celestialexploration").unlockedBy("has_" + unlockedBy.getRegistryName().getPath(), has(unlockedBy)).save(consumer, fluidResult.getRegistryName().getPath() + "_from_" + itemToSmelt.getRegistryName().getPath() + "_workbench");
    }

    public static void workbenchSmelting(FlowingFluid fluidResult, Item itemToSmelt, float experience, int cookingTime, float buckets, Block unlockedBy, Consumer<FinishedRecipe> consumer) {
        WorkbenchSmeltingRecipeBuilder.smelting(fluidResult, Ingredient.of(itemToSmelt), experience, cookingTime, buckets).group("celestialexploration").unlockedBy("has_" + unlockedBy.getRegistryName().getPath(), has(unlockedBy)).save(consumer, fluidResult.getRegistryName().getPath() + "_from_" + itemToSmelt.getRegistryName().getPath() + "_workbench");
    }

    public static void workbenchSmelting(FlowingFluid fluidResult, Block itemToSmelt, float experience, int cookingTime, float buckets, Block unlockedBy, Consumer<FinishedRecipe> consumer) {
        WorkbenchSmeltingRecipeBuilder.smelting(fluidResult, Ingredient.of(itemToSmelt), experience, cookingTime, buckets).group("celestialexploration").unlockedBy("has_" + unlockedBy.getRegistryName().getPath(), has(unlockedBy)).save(consumer, fluidResult.getRegistryName().getPath() + "_from_" + itemToSmelt.getRegistryName().getPath() + "_workbench");
    }

    public static void workbenchSmelting(FlowingFluid fluidResult, Block itemToSmelt, float experience, int cookingTime, float buckets, Item unlockedBy, Consumer<FinishedRecipe> consumer) {
        WorkbenchSmeltingRecipeBuilder.smelting(fluidResult, Ingredient.of(itemToSmelt), experience, cookingTime, buckets).group("celestialexploration").unlockedBy("has_" + unlockedBy.getRegistryName().getPath(), has(unlockedBy)).save(consumer, fluidResult.getRegistryName().getPath() + "_from_" + itemToSmelt.getRegistryName().getPath() + "_workbench");
    }

    public static void stairsCraftAndStonecutting(Block item, Block stairsItem, Block unlockedBy, Consumer<FinishedRecipe> consumer) {
        ShapedRecipeBuilder.shaped(stairsItem, 4).pattern("X  ").pattern("XX ").pattern("XXX").define('X', item).group("celestialexploration").unlockedBy("has_" + unlockedBy.getRegistryName().getPath(), has(unlockedBy)).save(consumer);
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(item), stairsItem, 1).unlockedBy("has_" + unlockedBy.getRegistryName().getPath(), has(unlockedBy)).save(consumer, stairsItem.getRegistryName().getPath() + "_stonecutting");
    }

    public static void stairsCraftAndStonecutting(Block craftItem, TagKey<Item> stonecuttingTag, Block stairsItem, Block unlockedBy, Consumer<FinishedRecipe> consumer) {
        ShapedRecipeBuilder.shaped(stairsItem, 4).pattern("X  ").pattern("XX ").pattern("XXX").define('X', craftItem).group("celestialexploration").unlockedBy("has_" + unlockedBy.getRegistryName().getPath(), has(unlockedBy)).save(consumer);
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(stonecuttingTag), stairsItem, 1).unlockedBy("has_" + unlockedBy.getRegistryName().getPath(), has(unlockedBy)).save(consumer, stairsItem.getRegistryName().getPath() + "_stonecutting");
    }

    public static void slabCraftAndStonecutting(Block item, Block slabItem, Block unlockedBy, Consumer<FinishedRecipe> consumer) {
        ShapedRecipeBuilder.shaped(slabItem, 6).pattern("XXX").define('X', item).group("celestialexploration").unlockedBy("has_" + unlockedBy.getRegistryName().getPath(), has(unlockedBy)).save(consumer);
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(item), slabItem, 2).unlockedBy("has_" + unlockedBy.getRegistryName().getPath(), has(unlockedBy)).save(consumer, slabItem.getRegistryName().getPath() + "_stonecutting");
    }

    public static void slabCraftAndStonecutting(Block craftItem, TagKey<Item> stonecuttingTag, Block slabItem, Block unlockedBy, Consumer<FinishedRecipe> consumer) {
        ShapedRecipeBuilder.shaped(slabItem, 6).pattern("XXX").define('X', craftItem).group("celestialexploration").unlockedBy("has_" + unlockedBy.getRegistryName().getPath(), has(unlockedBy)).save(consumer);
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(stonecuttingTag), slabItem, 2).unlockedBy("has_" + unlockedBy.getRegistryName().getPath(), has(unlockedBy)).save(consumer, slabItem.getRegistryName().getPath() + "_stonecutting");
    }

    public static void wallCraftAndStonecutting(Block craftItem, TagKey<Item> stonecuttingTag, Block result, Block unlockedBy, Consumer<FinishedRecipe> consumer) {
        ShapedRecipeBuilder.shaped(result, 6).pattern("XXX").pattern("XXX").define('X', craftItem).group("celestialexploration").unlockedBy("has_" + unlockedBy.getRegistryName().getPath(), has(unlockedBy)).save(consumer);
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(stonecuttingTag), result).unlockedBy("has_" + unlockedBy.getRegistryName().getPath(), has(unlockedBy)).save(consumer, result.getRegistryName().getPath() + "_stonecutting");
    }

    public static void wallCraftAndStonecutting(Block craftItem, Block result, Block unlockedBy, Consumer<FinishedRecipe> consumer) {
        ShapedRecipeBuilder.shaped(result, 6).pattern("XXX").pattern("XXX").define('X', craftItem).group("celestialexploration").unlockedBy("has_" + unlockedBy.getRegistryName().getPath(), has(unlockedBy)).save(consumer);
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(craftItem), result).unlockedBy("has_" + unlockedBy.getRegistryName().getPath(), has(unlockedBy)).save(consumer, result.getRegistryName().getPath() + "_stonecutting");
    }

    public static void pane(Block item, Block pane, Block unlockedBy, Consumer<FinishedRecipe> consumer) {
        ShapedRecipeBuilder.shaped(pane, 16).pattern("XXX").pattern("XXX").define('X', item).group("celestialexploration").unlockedBy("has_" + unlockedBy.getRegistryName().getPath(), has(unlockedBy)).save(consumer);
    }

    public static void stairsSlabWallCraftStonecutting(Block craftItem, TagKey<Item> stonecuttingItem, Block stairResult, Block slabResult, Block wallResult, Block unlockedBy, Consumer<FinishedRecipe> consumer) {
        stairsCraftAndStonecutting(craftItem, stonecuttingItem, stairResult, unlockedBy, consumer);
        slabCraftAndStonecutting(craftItem, stonecuttingItem, slabResult, unlockedBy, consumer);
        wallCraftAndStonecutting(craftItem, stonecuttingItem, wallResult, unlockedBy, consumer);
    }

    public static void stairsSlabWallCraftStonecutting(Block craftItem, Block stairResult, Block slabResult, Block wallResult, Block unlockedBy, Consumer<FinishedRecipe> consumer) {
        stairsCraftAndStonecutting(craftItem, stairResult, unlockedBy, consumer);
        slabCraftAndStonecutting(craftItem, slabResult, unlockedBy, consumer);
        wallCraftAndStonecutting(craftItem, wallResult, unlockedBy, consumer);
    }

    public static void singleItem(Item item, Item result, int quantity, Item unlockedBy, Consumer<FinishedRecipe> consumer) {
        ShapelessRecipeBuilder.shapeless(result, quantity).requires(item).group("celestialexploration").unlockedBy("has_" + unlockedBy.getRegistryName().getPath(), has(unlockedBy)).save(consumer);
    }

    public static void singleItem(Block item, Block result, int quantity, Block unlockedBy, Consumer<FinishedRecipe> consumer) {
        ShapelessRecipeBuilder.shapeless(result, quantity).requires(item).group("celestialexploration").unlockedBy("has_" + unlockedBy.getRegistryName().getPath(), has(unlockedBy)).save(consumer);
    }

    public static void stonecutting(Block item, Block result, int quantity, Block unlockedBy, Consumer<FinishedRecipe> consumer) {
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(item), result, quantity).group("celestialexploration").unlockedBy("has_" + unlockedBy.getRegistryName().getPath(), has(unlockedBy)).save(consumer, result.getRegistryName().getPath() + "_stonecutting");
    }

    public static void stonecutting(TagKey<Item> item, Block result, int quantity, Block unlockedBy, Consumer<FinishedRecipe> consumer) {
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(item), result, quantity).group("celestialexploration").unlockedBy("has_" + unlockedBy.getRegistryName().getPath(), has(unlockedBy)).save(consumer, result.getRegistryName().getPath() + "_stonecutting");
    }

    public static void bricksCraftAndStonecutting(Block item, Block result, Block unlockedBy, Consumer<FinishedRecipe> consumer) {
        ShapedRecipeBuilder.shaped(result, 4).pattern("XX").pattern("XX").define('X', item).group("celestialexploration").unlockedBy("has_" + unlockedBy.getRegistryName().getPath(), has(unlockedBy)).save(consumer);
        stonecutting(item, result, 1, unlockedBy, consumer);
    }

    public static void ingotAndBlock(Item ingot, Item blockItem, Item unlockedBy, Consumer<FinishedRecipe> consumer) {
        ShapedRecipeBuilder.shaped(blockItem).pattern("XXX").pattern("XXX").pattern("XXX").define('X', ingot).group("celestialexploration").unlockedBy("has_" + unlockedBy.getRegistryName().getPath(), has(unlockedBy)).save(consumer);
        ShapelessRecipeBuilder.shapeless(ingot, 9).requires(blockItem).group("celestialexploration").unlockedBy("has_" + unlockedBy.getRegistryName().getPath(), has(unlockedBy)).save(consumer, ingot.getRegistryName().getPath() + "_from_block");
    }

    public static void ingotAndBlock(Item ingot, Block blockItem, Item unlockedBy, Consumer<FinishedRecipe> consumer) {
        ShapedRecipeBuilder.shaped(blockItem).pattern("XXX").pattern("XXX").pattern("XXX").define('X', ingot).group("celestialexploration").unlockedBy("has_" + unlockedBy.getRegistryName().getPath(), has(unlockedBy)).save(consumer);
        ShapelessRecipeBuilder.shapeless(ingot, 9).requires(blockItem).group("celestialexploration").unlockedBy("has_" + unlockedBy.getRegistryName().getPath(), has(unlockedBy)).save(consumer, ingot.getRegistryName().getPath() + "_from_block");
    }

    public static void ingotAndBlock(Block ingot, Block blockItem, Block unlockedBy, Consumer<FinishedRecipe> consumer) {
        ShapedRecipeBuilder.shaped(blockItem).pattern("XXX").pattern("XXX").pattern("XXX").define('X', ingot).group("celestialexploration").unlockedBy("has_" + unlockedBy.getRegistryName().getPath(), has(unlockedBy)).save(consumer);
        ShapelessRecipeBuilder.shapeless(ingot, 9).requires(blockItem).group("celestialexploration").unlockedBy("has_" + unlockedBy.getRegistryName().getPath(), has(unlockedBy)).save(consumer, ingot.getRegistryName().getPath() + "_from_block");
    }

    public static void polishedDeepslate(Block cobbled, Block polished, Block polishedStairs, Block polishedSlab, Block polishedWall, Block unlockedBy, Consumer<FinishedRecipe> consumer) {
        ShapedRecipeBuilder.shaped(polished, 4).pattern("XX").pattern("XX").define('X', cobbled).group("celestialexploration").unlockedBy("has_" + unlockedBy.getRegistryName().getPath(), has(unlockedBy)).save(consumer);
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(cobbled), polished, 1).group("celestialexploration").unlockedBy("has_" + unlockedBy.getRegistryName().getPath(), has(unlockedBy)).save(consumer, polished.getRegistryName().getPath() + "_stonecutting");
        ShapedRecipeBuilder.shaped(polishedSlab, 6).pattern("XXX").define('X', polished).group("celestialexploration").unlockedBy("has_" + unlockedBy.getRegistryName().getPath(), has(unlockedBy)).save(consumer);
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(cobbled), polishedSlab, 2).group("celestialexploration").unlockedBy("has_" + unlockedBy.getRegistryName().getPath(), has(unlockedBy)).save(consumer, polishedSlab.getRegistryName().getPath() + "_from_" + cobbled.getRegistryName().getPath() + "_stonecutting");
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(polished), polishedSlab, 2).group("celestialexploration").unlockedBy("has_" + unlockedBy.getRegistryName().getPath(), has(unlockedBy)).save(consumer, polishedSlab.getRegistryName().getPath() + "_from_" + polished.getRegistryName().getPath() + "_stonecutting");
        ShapedRecipeBuilder.shaped(polishedStairs, 4).pattern("X  ").pattern("XX ").pattern("XXX").define('X', polished).group("celestialexploration").unlockedBy("has_" + unlockedBy.getRegistryName().getPath(), has(unlockedBy)).save(consumer);
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(cobbled), polishedStairs, 1).group("celestialexploration").unlockedBy("has_" + unlockedBy.getRegistryName().getPath(), has(unlockedBy)).save(consumer, polishedStairs.getRegistryName().getPath() + "_from_" + cobbled.getRegistryName().getPath() + "_stonecutting");
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(polished), polishedStairs, 1).group("celestialexploration").unlockedBy("has_" + unlockedBy.getRegistryName().getPath(), has(unlockedBy)).save(consumer, polishedStairs.getRegistryName().getPath() + "_from_" + polished.getRegistryName().getPath() + "_stonecutting");
        ShapedRecipeBuilder.shaped(polishedWall, 6).pattern("XXX").pattern("XXX").define('X', polished).group("celestialexploration").unlockedBy("has_" + unlockedBy.getRegistryName().getPath(), has(unlockedBy)).save(consumer);
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(cobbled), polishedWall, 1).group("celestialexploration").unlockedBy("has_" + unlockedBy.getRegistryName().getPath(), has(unlockedBy)).save(consumer, polishedWall.getRegistryName().getPath() + "_from_" + cobbled.getRegistryName().getPath() + "_stonecutting");
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(polished), polishedWall, 1).group("celestialexploration").unlockedBy("has_" + unlockedBy.getRegistryName().getPath(), has(unlockedBy)).save(consumer, polishedWall.getRegistryName().getPath() + "_from_" + polished.getRegistryName().getPath() + "_stonecutting");
    }

    public static void deepslateBricks(Block cobbled, Block polished, Block bricks, Block brickStairs, Block brickSlab, Block brickWall, Block unlockedBy, Consumer<FinishedRecipe> consumer) {
        ShapedRecipeBuilder.shaped(bricks, 4).pattern("XX").pattern("XX").define('X', polished).group("celestialexploration").unlockedBy("has_" + unlockedBy.getRegistryName().getPath(), has(unlockedBy)).save(consumer);
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(cobbled), bricks, 1).group("celestialexploration").unlockedBy("has_" + unlockedBy.getRegistryName().getPath(), has(unlockedBy)).save(consumer, bricks.getRegistryName().getPath() + "_from_" + cobbled.getRegistryName().getPath() + "_stonecutting");
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(polished), bricks, 1).group("celestialexploration").unlockedBy("has_" + unlockedBy.getRegistryName().getPath(), has(unlockedBy)).save(consumer, bricks.getRegistryName().getPath() + "_from_" + polished.getRegistryName().getPath() + "_stonecutting");
        ShapedRecipeBuilder.shaped(brickSlab, 6).pattern("XXX").define('X', bricks).group("celestialexploration").unlockedBy("has_" + unlockedBy.getRegistryName().getPath(), has(unlockedBy)).save(consumer);
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(cobbled),brickSlab, 2).group("celestialexploration").unlockedBy("has_" + unlockedBy.getRegistryName().getPath(), has(unlockedBy)).save(consumer, brickSlab.getRegistryName().getPath() + "_from_" + cobbled.getRegistryName().getPath() + "_stonecutting");
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(polished), brickSlab, 2).group("celestialexploration").unlockedBy("has_" + unlockedBy.getRegistryName().getPath(), has(unlockedBy)).save(consumer, brickSlab.getRegistryName().getPath() + "_from_" + polished.getRegistryName().getPath() + "_stonecutting");
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(bricks), brickSlab, 2).group("celestialexploration").unlockedBy("has_" + unlockedBy.getRegistryName().getPath(), has(unlockedBy)).save(consumer, brickSlab.getRegistryName().getPath() + "_from_" + bricks.getRegistryName().getPath() + "_stonecutting");
        ShapedRecipeBuilder.shaped(brickStairs, 4).pattern("X  ").pattern("XX ").pattern("XXX").define('X', bricks).group("celestialexploration").unlockedBy("has_" + unlockedBy.getRegistryName().getPath(), has(unlockedBy)).save(consumer);
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(cobbled), brickStairs, 1).group("celestialexploration").unlockedBy("has_" + unlockedBy.getRegistryName().getPath(), has(unlockedBy)).save(consumer, brickStairs.getRegistryName().getPath() + "_from_" + cobbled.getRegistryName().getPath() + "_stonecutting");
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(polished), brickStairs, 1).group("celestialexploration").unlockedBy("has_" + unlockedBy.getRegistryName().getPath(), has(unlockedBy)).save(consumer, brickStairs.getRegistryName().getPath() + "_from_" + polished.getRegistryName().getPath() + "_stonecutting");
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(bricks), brickStairs, 1).group("celestialexploration").unlockedBy("has_" + unlockedBy.getRegistryName().getPath(), has(unlockedBy)).save(consumer, brickStairs.getRegistryName().getPath() + "_from_" + bricks.getRegistryName().getPath() + "_stonecutting");
        ShapedRecipeBuilder.shaped(brickWall, 6).pattern("XXX").pattern("XXX").define('X', bricks).group("celestialexploration").unlockedBy("has_" + unlockedBy.getRegistryName().getPath(), has(unlockedBy)).save(consumer);
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(cobbled), brickWall, 1).group("celestialexploration").unlockedBy("has_" + unlockedBy.getRegistryName().getPath(), has(unlockedBy)).save(consumer, brickWall.getRegistryName().getPath() + "_from_" + cobbled.getRegistryName().getPath() + "_stonecutting");
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(polished), brickWall, 1).group("celestialexploration").unlockedBy("has_" + unlockedBy.getRegistryName().getPath(), has(unlockedBy)).save(consumer, brickWall.getRegistryName().getPath() + "_from_" + polished.getRegistryName().getPath() + "_stonecutting");
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(bricks), brickWall, 1).group("celestialexploration").unlockedBy("has_" + unlockedBy.getRegistryName().getPath(), has(unlockedBy)).save(consumer, brickWall.getRegistryName().getPath() + "_from_" + bricks.getRegistryName().getPath() + "_stonecutting");
    }

    public static void deepslateTiles(Block cobbled, Block polished, Block bricks, Block tiles, Block tileStairs, Block tileSlab, Block tileWall, Block unlockedBy, Consumer<FinishedRecipe> consumer) {
        ShapedRecipeBuilder.shaped(tiles, 4).pattern("XX").pattern("XX").define('X', bricks).group("celestialexploration").unlockedBy("has_" + unlockedBy.getRegistryName().getPath(), has(unlockedBy)).save(consumer);
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(cobbled), tiles, 1).group("celestialexploration").unlockedBy("has_" + unlockedBy.getRegistryName().getPath(), has(unlockedBy)).save(consumer, tiles.getRegistryName().getPath() + "_from_" + cobbled.getRegistryName().getPath() + "_stonecutting");
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(polished),tiles, 1).group("celestialexploration").unlockedBy("has_" + unlockedBy.getRegistryName().getPath(), has(unlockedBy)).save(consumer, tiles.getRegistryName().getPath() + "_from_" + polished.getRegistryName().getPath() + "_stonecutting");
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(bricks), tiles, 1).group("celestialexploration").unlockedBy("has_" + unlockedBy.getRegistryName().getPath(), has(unlockedBy)).save(consumer, tiles.getRegistryName().getPath() + "_from_" + bricks.getRegistryName().getPath() + "_stonecutting");

        ShapedRecipeBuilder.shaped(tileSlab, 6).pattern("XXX").define('X',tiles).group("celestialexploration").unlockedBy("has_" + unlockedBy.getRegistryName().getPath(), has(unlockedBy)).save(consumer);
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(cobbled), tileSlab, 2).group("celestialexploration").unlockedBy("has_" + unlockedBy.getRegistryName().getPath(), has(unlockedBy)).save(consumer, tileSlab.getRegistryName().getPath() + "_from_" + cobbled.getRegistryName().getPath() + "_stonecutting");
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(polished), tileSlab, 2).group("celestialexploration").unlockedBy("has_" + unlockedBy.getRegistryName().getPath(), has(unlockedBy)).save(consumer, tileSlab.getRegistryName().getPath() + "_from_" + polished.getRegistryName().getPath() + "_stonecutting");
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(bricks), tileSlab, 2).group("celestialexploration").unlockedBy("has_" + unlockedBy.getRegistryName().getPath(), has(unlockedBy)).save(consumer, tileSlab.getRegistryName().getPath() + "_from_" + bricks.getRegistryName().getPath() + "_stonecutting");
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(tiles), tileSlab, 2).group("celestialexploration").unlockedBy("has_" + unlockedBy.getRegistryName().getPath(), has(unlockedBy)).save(consumer, tileSlab.getRegistryName().getPath() + "_from_" + tiles.getRegistryName().getPath() + "_stonecutting");

        ShapedRecipeBuilder.shaped(tileStairs, 4).pattern("X  ").pattern("XX ").pattern("XXX").define('X', tiles).group("celestialexploration").unlockedBy("has_" + unlockedBy.getRegistryName().getPath(), has(unlockedBy)).save(consumer);
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(cobbled), tileStairs, 1).group("celestialexploration").unlockedBy("has_" + unlockedBy.getRegistryName().getPath(), has(unlockedBy)).save(consumer, tileStairs.getRegistryName().getPath() + "_from_" + cobbled.getRegistryName().getPath() + "_stonecutting");
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(polished), tileStairs, 1).group("celestialexploration").unlockedBy("has_" + unlockedBy.getRegistryName().getPath(), has(unlockedBy)).save(consumer, tileStairs.getRegistryName().getPath() + "_from_" + polished.getRegistryName().getPath() + "_stonecutting");
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(bricks), tileStairs, 1).group("celestialexploration").unlockedBy("has_" + unlockedBy.getRegistryName().getPath(), has(unlockedBy)).save(consumer, tileStairs.getRegistryName().getPath() + "_from_" + bricks.getRegistryName().getPath() + "_stonecutting");
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(tiles), tileStairs, 1).group("celestialexploration").unlockedBy("has_" + unlockedBy.getRegistryName().getPath(), has(unlockedBy)).save(consumer, tileStairs.getRegistryName().getPath() + "_from_" + tiles.getRegistryName().getPath() + "_stonecutting");

        ShapedRecipeBuilder.shaped(tileWall, 6).pattern("XXX").pattern("XXX").define('X', tiles).group("celestialexploration").unlockedBy("has_" + unlockedBy.getRegistryName().getPath(), has(unlockedBy)).save(consumer);
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(cobbled), tileWall, 1).group("celestialexploration").unlockedBy("has_" + unlockedBy.getRegistryName().getPath(), has(unlockedBy)).save(consumer, tileWall.getRegistryName().getPath() + "_from_" + cobbled.getRegistryName().getPath() + "_stonecutting");
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(polished), tileWall, 1).group("celestialexploration").unlockedBy("has_" + unlockedBy.getRegistryName().getPath(), has(unlockedBy)).save(consumer, tileWall.getRegistryName().getPath() + "_from_" + polished.getRegistryName().getPath() + "_stonecutting");
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(bricks), tileWall, 1).group("celestialexploration").unlockedBy("has_" + unlockedBy.getRegistryName().getPath(), has(unlockedBy)).save(consumer, tileWall.getRegistryName().getPath() + "_from_" + bricks.getRegistryName().getPath() + "_stonecutting");
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(tiles), tileWall, 1).group("celestialexploration").unlockedBy("has_" + unlockedBy.getRegistryName().getPath(), has(unlockedBy)).save(consumer, tileWall.getRegistryName().getPath() + "_from_" + tiles.getRegistryName().getPath() + "_stonecutting");
    }

}
