package com.shim.celestialexploration.integration;

import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestialexploration.recipes.WorkbenchCraftingRecipe;
import com.shim.celestialexploration.recipes.WorkbenchSmeltingRecipe;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeManager;

import java.util.List;
import java.util.Objects;

@JeiPlugin
public class JEIPlugin implements IModPlugin {

    @Override
    public ResourceLocation getPluginUid() {
        return new ResourceLocation(CelestialExploration.MODID, "jei_plugin");
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        registration.addRecipeCategories(new WorkbenchCraftingRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
        registration.addRecipeCategories(new WorkbenchSmeltingRecipeCategory(registration.getJeiHelpers().getGuiHelper()));

    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        RecipeManager rm = Objects.requireNonNull(Minecraft.getInstance().level).getRecipeManager();
        List<WorkbenchCraftingRecipe> craftingRecipes = rm.getAllRecipesFor(WorkbenchCraftingRecipe.Type.INSTANCE);
        List<WorkbenchSmeltingRecipe> smeltingRecipes = rm.getAllRecipesFor(WorkbenchSmeltingRecipe.Type.INSTANCE);

        registration.addRecipes(new RecipeType<>(WorkbenchCraftingRecipeCategory.UID, WorkbenchCraftingRecipe.class), craftingRecipes);
        registration.addRecipes(new RecipeType<>(WorkbenchSmeltingRecipeCategory.UID, WorkbenchSmeltingRecipe.class), smeltingRecipes);

    }
}