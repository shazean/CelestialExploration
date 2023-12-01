package com.shim.celestialexploration.recipes;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestialexploration.util.CelestialJsonHelper;
import net.minecraft.core.NonNullList;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;
import net.minecraftforge.fluids.FluidStack;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;

public class WorkbenchSmeltingRecipe implements Recipe<SimpleContainer> {
    private final ResourceLocation id;
    private final FluidStack fluidResult;
    private final Ingredient ingredient;
    private final float experience;
    private final int cookingTime;
    private final float buckets;

    public WorkbenchSmeltingRecipe(ResourceLocation id, FluidStack fluidResult, Ingredient ingredient, float experience, int cookingTime, float buckets) {
        this.id = id;
        this.fluidResult = fluidResult;
        this.ingredient = ingredient;
        this.experience = experience;
        this.cookingTime = cookingTime;
        this.buckets = buckets;
    }

    @Override
    public boolean matches(SimpleContainer container, Level level) {
        return ingredient.test(container.getItem(0));
    }

    @Override
    public ItemStack assemble(SimpleContainer container) {
        return ItemStack.EMPTY;
    }

    @Override
    public boolean canCraftInDimensions(int p_43999_, int p_44000_) {
        return true;
    }

    @Override
    public ItemStack getResultItem() {
        return ItemStack.EMPTY.copy();
    }

    public FluidStack getResultFluid() {
        return fluidResult.copy();
    }

    public int getCookingTime() {
        return cookingTime;
    }

    public float getExperience() {
        return experience;
    }

    public float getBuckets() {
        return buckets;
    }

    @Override
    public NonNullList<Ingredient> getIngredients() {
        NonNullList<Ingredient> nonnulllist = NonNullList.create();
        nonnulllist.add(this.ingredient);
        return nonnulllist;
    }

    @Override
    public @NotNull ResourceLocation getId() {
        return id;
    }

    @Override
    public @NotNull RecipeSerializer<?> getSerializer() {
        return WorkbenchSmeltingRecipe.Serializer.INSTANCE;
    }

    @Override
    public @NotNull RecipeType<?> getType() {
        return WorkbenchSmeltingRecipe.Type.INSTANCE;
    }

    public static class Type implements RecipeType<WorkbenchSmeltingRecipe> {
        private Type() { }
        public static final WorkbenchSmeltingRecipe.Type INSTANCE = new WorkbenchSmeltingRecipe.Type();
        public static final String ID = CelestialExploration.MODID + ":workbench_smelting";
    }

    public static class Serializer implements RecipeSerializer<WorkbenchSmeltingRecipe> {
        public static final WorkbenchSmeltingRecipe.Serializer INSTANCE = new WorkbenchSmeltingRecipe.Serializer();
        public static final ResourceLocation ID = new ResourceLocation(CelestialExploration.MODID,"workbench_smelting");

        @Override
        public WorkbenchSmeltingRecipe fromJson(ResourceLocation id, JsonObject json) {
            FluidStack fluidResult = CelestialJsonHelper.getFluidStackFromJson(json, true, true, "result");

            JsonElement jsonelement = GsonHelper.isArrayNode(json, "ingredient") ? GsonHelper.getAsJsonArray(json, "ingredient") : GsonHelper.getAsJsonObject(json, "ingredient");
            Ingredient ingredient = Ingredient.fromJson(jsonelement);

            float experience = GsonHelper.getAsFloat(json, "experience", 0.0F);
            int cookingTime = GsonHelper.getAsInt(json, "cookingtime", 100);
            float buckets = GsonHelper.getAsFloat(json, "buckets", 0.0F);
            return new WorkbenchSmeltingRecipe(id, fluidResult, ingredient, experience, cookingTime, buckets);
        }

        @Override
        public WorkbenchSmeltingRecipe fromNetwork(ResourceLocation id, FriendlyByteBuf buf) {
            Ingredient ingredient = Ingredient.fromNetwork(buf);

            FluidStack fluidResult = buf.readFluidStack();
            float experience = buf.readFloat();
            int cookingTime = buf.readVarInt();
            float buckets = buf.readFloat();
            return new WorkbenchSmeltingRecipe(id, fluidResult, ingredient, experience, cookingTime, buckets);
        }

        @Override
        public void toNetwork(FriendlyByteBuf buf, WorkbenchSmeltingRecipe recipe) {
            recipe.ingredient.toNetwork(buf);

            buf.writeFluidStack(recipe.getResultFluid());
            buf.writeFloat(recipe.experience);
            buf.writeVarInt(recipe.cookingTime);
            buf.writeFloat(recipe.buckets);
        }

        @Override
        public RecipeSerializer<?> setRegistryName(ResourceLocation name) {
            return INSTANCE;
        }

        @Nullable
        @Override
        public ResourceLocation getRegistryName() {
            return ID;
        }

        @Override
        public Class<RecipeSerializer<?>> getRegistryType() {
            return WorkbenchSmeltingRecipe.Serializer.castClass(RecipeSerializer.class);
        }

        @SuppressWarnings("unchecked") // Need this wrapper, because generics
        private static <G> Class<G> castClass(Class<?> cls) {
            return (Class<G>)cls;
        }
    }
}