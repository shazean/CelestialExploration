package com.shim.celestialexploration.recipes;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestialexploration.registry.CelestialRecipes;
import com.shim.celestialexploration.util.CelestialJsonHelper;
import net.minecraft.core.Registry;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.Container;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.fluids.FluidStack;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;

public class MechaCrowCraftingRecipe extends SingleItemRecipe {
    public MechaCrowCraftingRecipe(ResourceLocation p_44478_, String p_44479_, Ingredient p_44480_, ItemStack p_44481_) {
        super(MechaCrowCraftingRecipe.Type.INSTANCE, CelestialRecipes.MECHACROW_CRAFTING_SERIALIZER.get(), p_44478_, p_44479_, p_44480_, p_44481_);
    }

    public boolean matches(Container p_44483_, Level p_44484_) {
        return this.ingredient.test(p_44483_.getItem(0));
    }

    public ItemStack getToastSymbol() {
        return new ItemStack(Blocks.REDSTONE_BLOCK);
    }

    @Override
    public @NotNull RecipeType<?> getType() {
        return MechaCrowCraftingRecipe.Type.INSTANCE;
    }

    public static class Type implements RecipeType<MechaCrowCraftingRecipe> {
        private Type() { }
        public static final MechaCrowCraftingRecipe.Type INSTANCE = new MechaCrowCraftingRecipe.Type();
        public static final String ID = new ResourceLocation(CelestialExploration.MODID,"mechacrow_crafting").toString();
    }

    public static class Serializer implements RecipeSerializer<MechaCrowCraftingRecipe> {
        public static final MechaCrowCraftingRecipe.Serializer INSTANCE = new MechaCrowCraftingRecipe.Serializer();
        public static final ResourceLocation ID = new ResourceLocation(CelestialExploration.MODID,"mechacrow_crafting");

        public MechaCrowCraftingRecipe fromJson(ResourceLocation id, JsonObject json) {
            String group = GsonHelper.getAsString(json, "group", "");
            Ingredient ingredient;
            if (GsonHelper.isArrayNode(json, "ingredient")) {
                ingredient = Ingredient.fromJson(GsonHelper.getAsJsonArray(json, "ingredient"));
            } else {
                ingredient = Ingredient.fromJson(GsonHelper.getAsJsonObject(json, "ingredient"));
            }

            String result = GsonHelper.getAsString(json, "result");
            int count = GsonHelper.getAsInt(json, "count");
            ItemStack itemstack = new ItemStack(Registry.ITEM.get(new ResourceLocation(result)), count);
            return new MechaCrowCraftingRecipe(id, group, ingredient, itemstack);
        }

        public MechaCrowCraftingRecipe fromNetwork(ResourceLocation id, FriendlyByteBuf buf) {
            String s = buf.readUtf();
            Ingredient ingredient = Ingredient.fromNetwork(buf);
            ItemStack itemstack = buf.readItem();
            return new MechaCrowCraftingRecipe(id, s, ingredient, itemstack);
        }

        public void toNetwork(FriendlyByteBuf buf, MechaCrowCraftingRecipe recipe) {
            buf.writeUtf(recipe.group);
            recipe.ingredient.toNetwork(buf);
            buf.writeItem(recipe.result);
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
            return MechaCrowCraftingRecipe.Serializer.castClass(RecipeSerializer.class);
        }

        @SuppressWarnings("unchecked") // Need this wrapper, because generics
        private static <G> Class<G> castClass(Class<?> cls) {
            return (Class<G>)cls;
        }    }
}