package com.shim.celestialexploration.recipes;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestialexploration.util.CelestialJsonHelper;
import net.minecraft.core.NonNullList;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
import net.minecraftforge.fluids.FluidStack;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;

public class OxygenCompressorRecipe implements Recipe<SimpleContainer> {
    private final ResourceLocation id;
    private final Ingredient ingredient;
    private final float experience;
    private final int cookingTime;

    public OxygenCompressorRecipe(ResourceLocation id, Ingredient ingredient, float experience, int cookingTime) {
        this.id = id;
        this.ingredient = ingredient;
        this.experience = experience;
        this.cookingTime = cookingTime;
    }

    @Override
    public boolean matches(SimpleContainer container, Level level) {
        return ingredient.test(container.getItem(0)) || ingredient.test(container.getItem(1)) || ingredient.test(container.getItem(2)) || ingredient.test(container.getItem(3));
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

    public int getCookingTime() {
        return cookingTime;
    }

    public float getExperience() {
        return experience;
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
        return OxygenCompressorRecipe.Serializer.INSTANCE;
    }

    @Override
    public @NotNull RecipeType<?> getType() {
        return OxygenCompressorRecipe.Type.INSTANCE;
    }

    public static class Type implements RecipeType<OxygenCompressorRecipe> {
        private Type() { }
        public static final OxygenCompressorRecipe.Type INSTANCE = new OxygenCompressorRecipe.Type();
        public static final String ID = CelestialExploration.MODID + ":oxygen_compressor";
    }

    public static class Serializer implements RecipeSerializer<OxygenCompressorRecipe> {
        public static final OxygenCompressorRecipe.Serializer INSTANCE = new OxygenCompressorRecipe.Serializer();
        public static final ResourceLocation ID = new ResourceLocation(CelestialExploration.MODID,"oxygen_compressor");

        @Override
        public OxygenCompressorRecipe fromJson(ResourceLocation id, JsonObject json) {
            JsonElement jsonelement = GsonHelper.isArrayNode(json, "ingredient") ? GsonHelper.getAsJsonArray(json, "ingredient") : GsonHelper.getAsJsonObject(json, "ingredient");
            Ingredient ingredient = Ingredient.fromJson(jsonelement);

            float experience = GsonHelper.getAsFloat(json, "experience", 0.0F);
            int cookingTime = GsonHelper.getAsInt(json, "cookingtime", 100);
            return new OxygenCompressorRecipe(id, ingredient, experience, cookingTime);
        }

        @Override
        public OxygenCompressorRecipe fromNetwork(ResourceLocation id, FriendlyByteBuf buf) {
            Ingredient ingredient = Ingredient.fromNetwork(buf);

            float experience = buf.readFloat();
            int cookingTime = buf.readVarInt();
            return new OxygenCompressorRecipe(id, ingredient, experience, cookingTime);
        }

        @Override
        public void toNetwork(FriendlyByteBuf buf, OxygenCompressorRecipe recipe) {
            recipe.ingredient.toNetwork(buf);

            buf.writeFloat(recipe.experience);
            buf.writeVarInt(recipe.cookingTime);
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
            return OxygenCompressorRecipe.Serializer.castClass(RecipeSerializer.class);
        }

        @SuppressWarnings("unchecked") // Need this wrapper, because generics
        private static <G> Class<G> castClass(Class<?> cls) {
            return (Class<G>)cls;
        }
    }
}