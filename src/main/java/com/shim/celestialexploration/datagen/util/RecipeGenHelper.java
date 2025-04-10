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

    private static String name(ItemLike item) {
        return item.asItem().getRegistryName().getPath();
    }

    private static String name(FlowingFluid fluid) {
        return fluid.getRegistryName().getPath();
    }

    public static void smelting(ItemLike itemToSmelt, ItemLike result, float experience, int cookingTime, ItemLike unlockedBy, Consumer<FinishedRecipe> consumer) {
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(itemToSmelt), result, experience, cookingTime).unlockedBy("has_" + name(unlockedBy), has(unlockedBy)).save(consumer);
    }

    public static void smeltingAndBlasting(ItemLike itemToSmelt, ItemLike result, float experience, int smeltingTime, int blastingTime, ItemLike unlockedBy, Consumer<FinishedRecipe> consumer) {
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(itemToSmelt), result, experience, smeltingTime).unlockedBy("has_" + name(unlockedBy), has(unlockedBy)).save(consumer, name(itemToSmelt) + "_smelting");
        SimpleCookingRecipeBuilder.blasting(Ingredient.of(itemToSmelt), result, experience, blastingTime).unlockedBy("has_" + name(unlockedBy), has(unlockedBy)).save(consumer, name(itemToSmelt) + "_blasting");
    }

    public static void smeltingAndBlasting(TagKey<Item> tagItem, Item result, float experience, int smeltingTime, int blastingTime, Block unlockedBy, Consumer<FinishedRecipe> consumer) {
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(tagItem), result, experience, smeltingTime).unlockedBy("has_" + name(unlockedBy), has(unlockedBy)).save(consumer, tagItem.registry().getRegistryName().getPath() + "_smelting");
        SimpleCookingRecipeBuilder.blasting(Ingredient.of(tagItem), result, experience, blastingTime).unlockedBy("has_" + name(unlockedBy), has(unlockedBy)).save(consumer, tagItem.registry().getRegistryName().getPath() + "_blasting");
    }

    public static void workbenchSmelting(FlowingFluid fluidResult, ItemLike itemToSmelt, float experience, int cookingTime, float buckets, ItemLike unlockedBy, Consumer<FinishedRecipe> consumer) {
        WorkbenchSmeltingRecipeBuilder.smelting(fluidResult, Ingredient.of(itemToSmelt), experience, cookingTime, buckets).unlockedBy("has_" + name(unlockedBy), has(unlockedBy)).save(consumer, name(fluidResult) + "_from_" + name(itemToSmelt) + "_workbench");
    }

    public static void stairsCraftAndStonecutting(ItemLike item, ItemLike stairsItem, ItemLike unlockedBy, Consumer<FinishedRecipe> consumer) {
        ShapedRecipeBuilder.shaped(stairsItem, 4).pattern("X  ").pattern("XX ").pattern("XXX").define('X', item).unlockedBy("has_" + name(unlockedBy), has(unlockedBy)).save(consumer);
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(item), stairsItem, 1).unlockedBy("has_" + name(unlockedBy), has(unlockedBy)).save(consumer, name(stairsItem) + "_stonecutting");
    }

    public static void stairsCraftAndStonecutting(ItemLike craftItem, TagKey<Item> stonecuttingTag, ItemLike stairsItem, ItemLike unlockedBy, Consumer<FinishedRecipe> consumer) {
        ShapedRecipeBuilder.shaped(stairsItem, 4).pattern("X  ").pattern("XX ").pattern("XXX").define('X', craftItem).unlockedBy("has_" + name(unlockedBy), has(unlockedBy)).save(consumer);
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(stonecuttingTag), stairsItem, 1).unlockedBy("has_" + name(unlockedBy), has(unlockedBy)).save(consumer, name(stairsItem) + "_stonecutting");
    }

    public static void slabCraftAndStonecutting(ItemLike item, ItemLike slabItem, ItemLike unlockedBy, Consumer<FinishedRecipe> consumer) {
        ShapedRecipeBuilder.shaped(slabItem, 6).pattern("XXX").define('X', item).unlockedBy("has_" + name(unlockedBy), has(unlockedBy)).save(consumer);
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(item), slabItem, 2).unlockedBy("has_" + name(unlockedBy), has(unlockedBy)).save(consumer, name(slabItem) + "_stonecutting");
    }

    public static void slabCraftAndStonecutting(ItemLike craftItem, TagKey<Item> stonecuttingTag, ItemLike slabItem, ItemLike unlockedBy, Consumer<FinishedRecipe> consumer) {
        ShapedRecipeBuilder.shaped(slabItem, 6).pattern("XXX").define('X', craftItem).unlockedBy("has_" + name(unlockedBy), has(unlockedBy)).save(consumer);
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(stonecuttingTag), slabItem, 2).unlockedBy("has_" + name(unlockedBy), has(unlockedBy)).save(consumer, name(slabItem) + "_stonecutting");
    }

    public static void wallCraftAndStonecutting(ItemLike craftItem, TagKey<Item> stonecuttingTag, ItemLike result, ItemLike unlockedBy, Consumer<FinishedRecipe> consumer) {
        ShapedRecipeBuilder.shaped(result, 6).pattern("XXX").pattern("XXX").define('X', craftItem).unlockedBy("has_" + name(unlockedBy), has(unlockedBy)).save(consumer);
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(stonecuttingTag), result).unlockedBy("has_" + name(unlockedBy), has(unlockedBy)).save(consumer, name(result) + "_stonecutting");
    }

    public static void wallCraftAndStonecutting(ItemLike craftItem, ItemLike result, ItemLike unlockedBy, Consumer<FinishedRecipe> consumer) {
        ShapedRecipeBuilder.shaped(result, 6).pattern("XXX").pattern("XXX").define('X', craftItem).unlockedBy("has_" + name(unlockedBy), has(unlockedBy)).save(consumer);
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(craftItem), result).unlockedBy("has_" + name(unlockedBy), has(unlockedBy)).save(consumer, name(result) + "_stonecutting");
    }

    public static void pane(ItemLike item, ItemLike pane, ItemLike unlockedBy, Consumer<FinishedRecipe> consumer) {
        ShapedRecipeBuilder.shaped(pane, 16).pattern("XXX").pattern("XXX").define('X', item).unlockedBy("has_" + name(unlockedBy), has(unlockedBy)).save(consumer);
    }

    public static void stairsSlabWallCraftStonecutting(ItemLike craftItem, TagKey<Item> stonecuttingItem, ItemLike stairResult, ItemLike slabResult, ItemLike wallResult, ItemLike unlockedBy, Consumer<FinishedRecipe> consumer) {
        stairsCraftAndStonecutting(craftItem, stonecuttingItem, stairResult, unlockedBy, consumer);
        slabCraftAndStonecutting(craftItem, stonecuttingItem, slabResult, unlockedBy, consumer);
        wallCraftAndStonecutting(craftItem, stonecuttingItem, wallResult, unlockedBy, consumer);
    }

    public static void stairsSlabWallCraftStonecutting(ItemLike craftItem, ItemLike stairResult, ItemLike slabResult, ItemLike wallResult, ItemLike unlockedBy, Consumer<FinishedRecipe> consumer) {
        stairsCraftAndStonecutting(craftItem, stairResult, unlockedBy, consumer);
        slabCraftAndStonecutting(craftItem, slabResult, unlockedBy, consumer);
        wallCraftAndStonecutting(craftItem, wallResult, unlockedBy, consumer);
    }

    public static void singleItem(Item item, Item result, int quantity, Item unlockedBy, Consumer<FinishedRecipe> consumer) {
        ShapelessRecipeBuilder.shapeless(result, quantity).requires(item).unlockedBy("has_" + name(unlockedBy), has(unlockedBy)).save(consumer);
    }

    public static void singleItem(ItemLike item, ItemLike result, int quantity, ItemLike unlockedBy, Consumer<FinishedRecipe> consumer) {
        ShapelessRecipeBuilder.shapeless(result, quantity).requires(item).unlockedBy("has_" + name(unlockedBy), has(unlockedBy)).save(consumer);
    }

    public static void stonecutting(ItemLike item, ItemLike result, int quantity, ItemLike unlockedBy, Consumer<FinishedRecipe> consumer) {
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(item), result, quantity).unlockedBy("has_" + name(unlockedBy), has(unlockedBy)).save(consumer, name(result) + "_stonecutting");
    }

    public static void stonecutting(TagKey<Item> item, ItemLike result, int quantity, ItemLike unlockedBy, Consumer<FinishedRecipe> consumer) {
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(item), result, quantity).unlockedBy("has_" + name(unlockedBy), has(unlockedBy)).save(consumer, name(result) + "_stonecutting");
    }

    public static void bricksCraftAndStonecutting(ItemLike item, ItemLike result, ItemLike unlockedBy, Consumer<FinishedRecipe> consumer) {
        ShapedRecipeBuilder.shaped(result, 4).pattern("XX").pattern("XX").define('X', item).unlockedBy("has_" + name(unlockedBy), has(unlockedBy)).save(consumer);
        stonecutting(item, result, 1, unlockedBy, consumer);
    }

    public static void ingotAndBlock(Item ingot, Item blockItem, Item unlockedBy, Consumer<FinishedRecipe> consumer) {
        ShapedRecipeBuilder.shaped(blockItem).pattern("XXX").pattern("XXX").pattern("XXX").define('X', ingot).unlockedBy("has_" + name(unlockedBy), has(unlockedBy)).save(consumer);
        ShapelessRecipeBuilder.shapeless(ingot, 9).requires(blockItem).unlockedBy("has_" + name(unlockedBy), has(unlockedBy)).save(consumer, name(ingot) + "_from_block");
    }

    public static void ingotAndBlock(Item ingot, Block blockItem, Item unlockedBy, Consumer<FinishedRecipe> consumer) {
        ShapedRecipeBuilder.shaped(blockItem).pattern("XXX").pattern("XXX").pattern("XXX").define('X', ingot).unlockedBy("has_" + name(unlockedBy), has(unlockedBy)).save(consumer);
        ShapelessRecipeBuilder.shapeless(ingot, 9).requires(blockItem).unlockedBy("has_" + name(unlockedBy), has(unlockedBy)).save(consumer, name(ingot) + "_from_block");
    }

    public static void ingotAndBlock(Block ingot, Block blockItem, Block unlockedBy, Consumer<FinishedRecipe> consumer) {
        ShapedRecipeBuilder.shaped(blockItem).pattern("XXX").pattern("XXX").pattern("XXX").define('X', ingot).unlockedBy("has_" + name(unlockedBy), has(unlockedBy)).save(consumer);
        ShapelessRecipeBuilder.shapeless(ingot, 9).requires(blockItem).unlockedBy("has_" + name(unlockedBy), has(unlockedBy)).save(consumer, name(ingot) + "_from_block");
    }

    public static void polishedDeepslate(Block cobbled, Block polished, Block polishedStairs, Block polishedSlab, Block polishedWall, Block unlockedBy, Consumer<FinishedRecipe> consumer) {
        ShapedRecipeBuilder.shaped(polished, 4).pattern("XX").pattern("XX").define('X', cobbled).unlockedBy("has_" + name(unlockedBy), has(unlockedBy)).save(consumer);
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(cobbled), polished, 1).unlockedBy("has_" + name(unlockedBy), has(unlockedBy)).save(consumer, name(polished) + "_stonecutting");
        ShapedRecipeBuilder.shaped(polishedSlab, 6).pattern("XXX").define('X', polished).unlockedBy("has_" + name(unlockedBy), has(unlockedBy)).save(consumer);
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(cobbled), polishedSlab, 2).unlockedBy("has_" + name(unlockedBy), has(unlockedBy)).save(consumer, name(polishedSlab) + "_from_" + name(cobbled) + "_stonecutting");
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(polished), polishedSlab, 2).unlockedBy("has_" + name(unlockedBy), has(unlockedBy)).save(consumer, name(polishedSlab) + "_from_" + name(polished) + "_stonecutting");
        ShapedRecipeBuilder.shaped(polishedStairs, 4).pattern("X  ").pattern("XX ").pattern("XXX").define('X', polished).unlockedBy("has_" + name(unlockedBy), has(unlockedBy)).save(consumer);
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(cobbled), polishedStairs, 1).unlockedBy("has_" + name(unlockedBy), has(unlockedBy)).save(consumer, name(polishedStairs) + "_from_" + name(cobbled) + "_stonecutting");
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(polished), polishedStairs, 1).unlockedBy("has_" + name(unlockedBy), has(unlockedBy)).save(consumer, name(polishedStairs) + "_from_" + name(polished) + "_stonecutting");
        ShapedRecipeBuilder.shaped(polishedWall, 6).pattern("XXX").pattern("XXX").define('X', polished).unlockedBy("has_" + name(unlockedBy), has(unlockedBy)).save(consumer);
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(cobbled), polishedWall, 1).unlockedBy("has_" + name(unlockedBy), has(unlockedBy)).save(consumer, name(polishedWall) + "_from_" + name(cobbled) + "_stonecutting");
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(polished), polishedWall, 1).unlockedBy("has_" + name(unlockedBy), has(unlockedBy)).save(consumer, name(polishedWall) + "_from_" + name(polished) + "_stonecutting");
    }

    public static void deepslateBricks(Block cobbled, Block polished, Block bricks, Block brickStairs, Block brickSlab, Block brickWall, Block unlockedBy, Consumer<FinishedRecipe> consumer) {
        ShapedRecipeBuilder.shaped(bricks, 4).pattern("XX").pattern("XX").define('X', polished).unlockedBy("has_" + name(unlockedBy), has(unlockedBy)).save(consumer);
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(cobbled), bricks, 1).unlockedBy("has_" + name(unlockedBy), has(unlockedBy)).save(consumer, name(bricks) + "_from_" + name(cobbled) + "_stonecutting");
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(polished), bricks, 1).unlockedBy("has_" + name(unlockedBy), has(unlockedBy)).save(consumer, name(bricks) + "_from_" + name(polished) + "_stonecutting");
        ShapedRecipeBuilder.shaped(brickSlab, 6).pattern("XXX").define('X', bricks).unlockedBy("has_" + name(unlockedBy), has(unlockedBy)).save(consumer);
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(cobbled),brickSlab, 2).unlockedBy("has_" + name(unlockedBy), has(unlockedBy)).save(consumer, name(brickSlab) + "_from_" + name(cobbled) + "_stonecutting");
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(polished), brickSlab, 2).unlockedBy("has_" + name(unlockedBy), has(unlockedBy)).save(consumer, name(brickSlab) + "_from_" + name(polished) + "_stonecutting");
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(bricks), brickSlab, 2).unlockedBy("has_" + name(unlockedBy), has(unlockedBy)).save(consumer, name(brickSlab) + "_from_" + name(bricks) + "_stonecutting");
        ShapedRecipeBuilder.shaped(brickStairs, 4).pattern("X  ").pattern("XX ").pattern("XXX").define('X', bricks).unlockedBy("has_" + name(unlockedBy), has(unlockedBy)).save(consumer);
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(cobbled), brickStairs, 1).unlockedBy("has_" + name(unlockedBy), has(unlockedBy)).save(consumer, name(brickStairs) + "_from_" + name(cobbled) + "_stonecutting");
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(polished), brickStairs, 1).unlockedBy("has_" + name(unlockedBy), has(unlockedBy)).save(consumer, name(brickStairs) + "_from_" + name(polished) + "_stonecutting");
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(bricks), brickStairs, 1).unlockedBy("has_" + name(unlockedBy), has(unlockedBy)).save(consumer, name(brickStairs) + "_from_" + name(bricks) + "_stonecutting");
        ShapedRecipeBuilder.shaped(brickWall, 6).pattern("XXX").pattern("XXX").define('X', bricks).unlockedBy("has_" + name(unlockedBy), has(unlockedBy)).save(consumer);
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(cobbled), brickWall, 1).unlockedBy("has_" + name(unlockedBy), has(unlockedBy)).save(consumer, name(brickWall) + "_from_" + name(cobbled) + "_stonecutting");
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(polished), brickWall, 1).unlockedBy("has_" + name(unlockedBy), has(unlockedBy)).save(consumer, name(brickWall) + "_from_" + name(polished) + "_stonecutting");
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(bricks), brickWall, 1).unlockedBy("has_" + name(unlockedBy), has(unlockedBy)).save(consumer, name(brickWall) + "_from_" + name(bricks) + "_stonecutting");
    }

    public static void deepslateTiles(Block cobbled, Block polished, Block bricks, Block tiles, Block tileStairs, Block tileSlab, Block tileWall, Block unlockedBy, Consumer<FinishedRecipe> consumer) {
        ShapedRecipeBuilder.shaped(tiles, 4).pattern("XX").pattern("XX").define('X', bricks).unlockedBy("has_" + name(unlockedBy), has(unlockedBy)).save(consumer);
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(cobbled), tiles, 1).unlockedBy("has_" + name(unlockedBy), has(unlockedBy)).save(consumer, name(tiles) + "_from_" + name(cobbled) + "_stonecutting");
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(polished),tiles, 1).unlockedBy("has_" + name(unlockedBy), has(unlockedBy)).save(consumer, name(tiles) + "_from_" + name(polished) + "_stonecutting");
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(bricks), tiles, 1).unlockedBy("has_" + name(unlockedBy), has(unlockedBy)).save(consumer, name(tiles) + "_from_" + name(bricks) + "_stonecutting");

        ShapedRecipeBuilder.shaped(tileSlab, 6).pattern("XXX").define('X',tiles).unlockedBy("has_" + name(unlockedBy), has(unlockedBy)).save(consumer);
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(cobbled), tileSlab, 2).unlockedBy("has_" + name(unlockedBy), has(unlockedBy)).save(consumer, name(tileSlab) + "_from_" + name(cobbled) + "_stonecutting");
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(polished), tileSlab, 2).unlockedBy("has_" + name(unlockedBy), has(unlockedBy)).save(consumer, name(tileSlab) + "_from_" + name(polished) + "_stonecutting");
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(bricks), tileSlab, 2).unlockedBy("has_" + name(unlockedBy), has(unlockedBy)).save(consumer, name(tileSlab) + "_from_" + name(bricks) + "_stonecutting");
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(tiles), tileSlab, 2).unlockedBy("has_" + name(unlockedBy), has(unlockedBy)).save(consumer, name(tileSlab) + "_from_" + name(tiles) + "_stonecutting");

        ShapedRecipeBuilder.shaped(tileStairs, 4).pattern("X  ").pattern("XX ").pattern("XXX").define('X', tiles).unlockedBy("has_" + name(unlockedBy), has(unlockedBy)).save(consumer);
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(cobbled), tileStairs, 1).unlockedBy("has_" + name(unlockedBy), has(unlockedBy)).save(consumer, name(tileStairs) + "_from_" + name(cobbled) + "_stonecutting");
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(polished), tileStairs, 1).unlockedBy("has_" + name(unlockedBy), has(unlockedBy)).save(consumer, name(tileStairs) + "_from_" + name(polished) + "_stonecutting");
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(bricks), tileStairs, 1).unlockedBy("has_" + name(unlockedBy), has(unlockedBy)).save(consumer, name(tileStairs) + "_from_" + name(bricks) + "_stonecutting");
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(tiles), tileStairs, 1).unlockedBy("has_" + name(unlockedBy), has(unlockedBy)).save(consumer, name(tileStairs) + "_from_" + name(tiles) + "_stonecutting");

        ShapedRecipeBuilder.shaped(tileWall, 6).pattern("XXX").pattern("XXX").define('X', tiles).unlockedBy("has_" + name(unlockedBy), has(unlockedBy)).save(consumer);
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(cobbled), tileWall, 1).unlockedBy("has_" + name(unlockedBy), has(unlockedBy)).save(consumer, name(tileWall) + "_from_" + name(cobbled) + "_stonecutting");
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(polished), tileWall, 1).unlockedBy("has_" + name(unlockedBy), has(unlockedBy)).save(consumer, name(tileWall) + "_from_" + name(polished) + "_stonecutting");
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(bricks), tileWall, 1).unlockedBy("has_" + name(unlockedBy), has(unlockedBy)).save(consumer, name(tileWall) + "_from_" + name(bricks) + "_stonecutting");
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(tiles), tileWall, 1).unlockedBy("has_" + name(unlockedBy), has(unlockedBy)).save(consumer, name(tileWall) + "_from_" + name(tiles) + "_stonecutting");
    }
}