package com.shim.celestialexploration.datagen.util;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestialexploration.registry.RecipeRegistry;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementRewards;
import net.minecraft.advancements.CriterionTriggerInstance;
import net.minecraft.advancements.RequirementsStrategy;
import net.minecraft.advancements.critereon.RecipeUnlockedTrigger;
import net.minecraft.core.Registry;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.material.Fluid;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

public class WorkbenchCraftingRecipeBuilder implements RecipeBuilder {
    private final Item result;
    private final int count;
    private final List<String> rows = Lists.newArrayList();
    private final Map<Character, Ingredient> key = Maps.newLinkedHashMap();
    private final Fluid fluid;
    private final float buckets;
    private final Advancement.Builder advancement = Advancement.Builder.advancement();
    @Nullable
    private String group;
//    private final WorkbenchCraftingRecipe.Serializer serializer;

    private WorkbenchCraftingRecipeBuilder(ItemLike item, int count, Fluid fluid, float buckets) {
        this.result = item.asItem();
        this.count = count;
        this.fluid = fluid;
        this.buckets = buckets;
    }

    public static WorkbenchCraftingRecipeBuilder shaped(ItemLike item, Fluid fluid) {
        return shaped(item, 1, fluid);
    }

    public static WorkbenchCraftingRecipeBuilder shaped(ItemLike item, int count, Fluid fluid) {
        return shaped(item, count, fluid, 1.0F);
    }

    public static WorkbenchCraftingRecipeBuilder shaped(ItemLike item, Fluid fluid, float buckets) {
        return shaped(item, 1, fluid, buckets);
    }

    public static WorkbenchCraftingRecipeBuilder shaped(ItemLike item, int count, Fluid fluid, float buckets) {
        return new WorkbenchCraftingRecipeBuilder(item, count, fluid, buckets);
    }


    @Override
    public RecipeBuilder unlockedBy(String p_176496_, CriterionTriggerInstance p_176497_) {
        this.advancement.addCriterion(p_176496_, p_176497_);
        return this;
    }

    @Override
    public RecipeBuilder group(@org.jetbrains.annotations.Nullable String group) {
        this.group = group;
        return this;
    }

    @Override
    public Item getResult() {
        return ItemStack.EMPTY.getItem();
    }

//    public Fluid getFluidResult() {
//        return this.result;
//    }

    public float getBuckets() {
        return this.buckets;
    }

    public WorkbenchCraftingRecipeBuilder define(Character p_206417_, TagKey<Item> p_206418_) {
        return this.define(p_206417_, Ingredient.of(p_206418_));
    }

    public WorkbenchCraftingRecipeBuilder define(Character p_126128_, ItemLike p_126129_) {
        return this.define(p_126128_, Ingredient.of(p_126129_));
    }

    public WorkbenchCraftingRecipeBuilder define(Character p_126125_, Ingredient p_126126_) {
        if (this.key.containsKey(p_126125_)) {
            throw new IllegalArgumentException("Symbol '" + p_126125_ + "' is already defined!");
        } else if (p_126125_ == ' ') {
            throw new IllegalArgumentException("Symbol ' ' (whitespace) is reserved and cannot be defined");
        } else {
            this.key.put(p_126125_, p_126126_);
            return this;
        }
    }

    public WorkbenchCraftingRecipeBuilder pattern(String p_126131_) {
        if (!this.rows.isEmpty() && p_126131_.length() != this.rows.get(0).length()) {
            throw new IllegalArgumentException("Pattern must be the same width on every line!");
        } else {
            this.rows.add(p_126131_);
            return this;
        }
    }

    @Override
    public void save(Consumer<FinishedRecipe> p_176503_, ResourceLocation p_176504_) {
        this.ensureValid(p_176504_);
        this.advancement.parent(new ResourceLocation("recipes/root")).addCriterion("has_the_recipe", RecipeUnlockedTrigger.unlocked(p_176504_)).rewards(AdvancementRewards.Builder.recipe(p_176504_)).requirements(RequirementsStrategy.OR);
        p_176503_.accept(new WorkbenchCraftingRecipeBuilder.Result(p_176504_,
                this.group == null ? "" : this.group, this.result, this.count, this.rows, this.key, this.fluid, this.buckets, this.advancement,
                new ResourceLocation(CelestialExploration.MODID, "recipes/" + p_176504_.getPath())));
    }

    private void ensureValid(ResourceLocation p_126266_) {
        if (this.advancement.getCriteria().isEmpty()) {
            throw new IllegalStateException("No way of obtaining recipe " + p_126266_);
        }
    }

    public static class Result implements FinishedRecipe {
        private final ResourceLocation id;
        private final String group;
        private final Item result;
        private final int count;
        private final List<String> pattern;
        private final Map<Character, Ingredient> key;
        private final Fluid fluid;
        private final float buckets;
        private final Advancement.Builder advancement;
        private final ResourceLocation advancementId;

        public Result(ResourceLocation id, String group, Item result, int count, List<String> pattern, Map<Character, Ingredient> key, Fluid fluid, float buckets, Advancement.Builder advancement, ResourceLocation advancementId) {
            this.id = id;
            this.group = group;
            this.result = result;
            this.count = count;
            this.pattern = pattern;
            this.key = key;
            this.fluid = fluid;
            this.buckets = buckets;
            this.advancement = advancement;
            this.advancementId = advancementId;
        }

        public void serializeRecipeData(JsonObject json) {
            if (!this.group.isEmpty()) {
                json.addProperty("group", this.group);
            }

            JsonArray jsonarray = new JsonArray();

            for(String s : this.pattern) {
                jsonarray.add(s);
            }

            json.add("pattern", jsonarray);
            JsonObject jsonobject = new JsonObject();

            for(Map.Entry<Character, Ingredient> entry : this.key.entrySet()) {
                jsonobject.add(String.valueOf(entry.getKey()), entry.getValue().toJson());
            }

            json.add("key", jsonobject);
            JsonObject jsonobject1 = new JsonObject();
            jsonobject1.addProperty("item", Registry.ITEM.getKey(this.result).toString());
            if (this.count > 1) {
                jsonobject1.addProperty("count", this.count);
            }

            json.add("result", jsonobject1);
//
//            json.add("ingredient", this.ingredient.toJson());
            json.addProperty("fluid", Registry.FLUID.getKey(this.fluid).toString());
//            json.addProperty("experience", this.experience);
//            json.addProperty("cookingtime", this.cookingTime);
            json.addProperty("buckets", this.buckets);

        }

        public RecipeSerializer<?> getType() {
            return RecipeRegistry.WORKBENCH_CRAFTING_SERIALIZER.get();
        }

        public ResourceLocation getId() {
            return this.id;
        }

        @Nullable
        public JsonObject serializeAdvancement() {
            return this.advancement.serializeToJson();
        }

        @Nullable
        public ResourceLocation getAdvancementId() {
            return this.advancementId;
        }
    }
}
