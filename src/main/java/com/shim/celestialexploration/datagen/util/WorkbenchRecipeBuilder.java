package com.shim.celestialexploration.datagen.util;

import com.google.gson.JsonObject;
import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestialexploration.recipes.WorkbenchSmeltingRecipe;
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
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;

import javax.annotation.Nullable;
import java.util.function.Consumer;

public class WorkbenchRecipeBuilder implements RecipeBuilder {
    private final Fluid result;
    private final Ingredient ingredient;
    private final float experience;
    private final int cookingTime;
    private final float buckets;
    private final Advancement.Builder advancement = Advancement.Builder.advancement();
    @Nullable
    private String group;
    private final WorkbenchSmeltingRecipe.Serializer serializer;


    private WorkbenchRecipeBuilder(FlowingFluid p_126243_, Ingredient p_126244_, float experience, int cookingTime, float buckets, WorkbenchSmeltingRecipe.Serializer p_126247_) {
        this.result = p_126243_;
        this.ingredient = p_126244_;
        this.experience = experience;
        this.cookingTime = cookingTime;
        this.buckets = buckets;
        this.serializer = p_126247_;
    }

    public static WorkbenchRecipeBuilder smelting(FlowingFluid fluid, Ingredient item, float experience, int cookingTime, float buckets) {
        return new WorkbenchRecipeBuilder(fluid, item, experience, cookingTime, buckets, (WorkbenchSmeltingRecipe.Serializer) RecipeRegistry.WORKBENCH_SMELTING_SERIALIZER.get());
    }

    @Override
    public RecipeBuilder unlockedBy(String p_176496_, CriterionTriggerInstance p_176497_) {
        this.advancement.addCriterion(p_176496_, p_176497_);
        return this;
    }

    @Override
    public RecipeBuilder group(@org.jetbrains.annotations.Nullable String p_176495_) {
        this.group = p_176495_;
        return this;
    }

    @Override
    public Item getResult() {
        return ItemStack.EMPTY.getItem();
    }

    public Fluid getFluidResult() {
        return this.result;
    }

    public float getBuckets() {
        return this.buckets;
    }


    @Override
    public void save(Consumer<FinishedRecipe> p_176503_, ResourceLocation p_176504_) {
        this.ensureValid(p_176504_);
        this.advancement.parent(new ResourceLocation("recipes/root")).addCriterion("has_the_recipe", RecipeUnlockedTrigger.unlocked(p_176504_)).rewards(AdvancementRewards.Builder.recipe(p_176504_)).requirements(RequirementsStrategy.OR);
        p_176503_.accept(new WorkbenchRecipeBuilder.Result(p_176504_,
                this.group == null ? "" : this.group, this.ingredient, this.result, this.experience, this.cookingTime, this.buckets, this.advancement, new ResourceLocation(CelestialExploration.MODID, "recipes/" + p_176504_.getPath()), this.serializer));
    }

    private void ensureValid(ResourceLocation p_126266_) {
        if (this.advancement.getCriteria().isEmpty()) {
            throw new IllegalStateException("No way of obtaining recipe " + p_126266_);
        }
    }

    public static class Result implements FinishedRecipe {
        private final ResourceLocation id;
        private final String group;
        private final Ingredient ingredient;
        private final Fluid result;
        private final float experience;
        private final int cookingTime;
        private final float buckets;
        private final Advancement.Builder advancement;
        private final ResourceLocation advancementId;
        private final WorkbenchSmeltingRecipe.Serializer serializer;

        public Result(ResourceLocation p_126287_, String p_126288_, Ingredient ingredient, Fluid p_126290_, float experience, int cookingTime, float buckets, Advancement.Builder p_126293_, ResourceLocation p_126294_, WorkbenchSmeltingRecipe.Serializer p_126295_) {
            this.id = p_126287_;
            this.group = p_126288_;
            this.ingredient = ingredient;
            this.result = p_126290_;
            this.experience = experience;
            this.cookingTime = cookingTime;
            this.buckets = buckets;
            this.advancement = p_126293_;
            this.advancementId = p_126294_;
            this.serializer = p_126295_;
        }

        public void serializeRecipeData(JsonObject json) {
            if (!this.group.isEmpty()) {
                json.addProperty("group", this.group);
            }

            json.add("ingredient", this.ingredient.toJson());
            json.addProperty("result", Registry.FLUID.getKey(this.result).toString());
            json.addProperty("experience", this.experience);
            json.addProperty("cookingtime", this.cookingTime);
            json.addProperty("buckets", this.buckets);

        }

        public RecipeSerializer<?> getType() {
            return this.serializer;
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
