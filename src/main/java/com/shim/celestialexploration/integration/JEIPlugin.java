package com.shim.celestialexploration.integration;

import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestialexploration.recipes.WorkbenchCraftingRecipe;
import com.shim.celestialexploration.recipes.WorkbenchSmeltingRecipe;
import com.shim.celestialexploration.registry.CelestialBlocks;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeManager;

import java.util.List;
import java.util.Objects;

@JeiPlugin
public class JEIPlugin implements IModPlugin {
    RecipeType<WorkbenchCraftingRecipe> workbenchCraftingRecipeType = new RecipeType<>(WorkbenchCraftingRecipeCategory.UID, WorkbenchCraftingRecipe.class);
    RecipeType<WorkbenchSmeltingRecipe> workbenchSmeltingRecipeType = new RecipeType<>(WorkbenchSmeltingRecipeCategory.UID, WorkbenchSmeltingRecipe.class);

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
    public void registerRecipeCatalysts(IRecipeCatalystRegistration registration) {
        IModPlugin.super.registerRecipeCatalysts(registration);
        registration.addRecipeCatalyst(new ItemStack(CelestialBlocks.WORKBENCH.get()), workbenchCraftingRecipeType, workbenchSmeltingRecipeType);
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        RecipeManager rm = Objects.requireNonNull(CelestialExploration.PROXY.getMinecraft().level).getRecipeManager();
        List<WorkbenchCraftingRecipe> craftingRecipes = rm.getAllRecipesFor(WorkbenchCraftingRecipe.Type.INSTANCE);
        List<WorkbenchSmeltingRecipe> smeltingRecipes = rm.getAllRecipesFor(WorkbenchSmeltingRecipe.Type.INSTANCE);

        registration.addRecipes(workbenchCraftingRecipeType, craftingRecipes);
        registration.addRecipes(workbenchSmeltingRecipeType, smeltingRecipes);
    }

//    public void registerRecipeTransferHandlers(IRecipeTransferRegistration registration) {
//        registration.addRecipeTransferHandler(WorkbenchMenu.class, workbenchCraftingRecipeType, 2, 9, 11, 36);
//    }
}