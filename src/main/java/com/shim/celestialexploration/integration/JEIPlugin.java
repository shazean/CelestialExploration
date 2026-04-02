package com.shim.celestialexploration.integration;

import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestialexploration.recipes.MechaCrowCraftingRecipe;
import com.shim.celestialexploration.recipes.WorkbenchCraftingRecipe;
import com.shim.celestialexploration.recipes.WorkbenchSmeltingRecipe;
import com.shim.celestialexploration.registry.CelestialBlocks;
import com.shim.celestialexploration.registry.CelestialItems;
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
    RecipeType<MechaCrowCraftingRecipe> mechacrowRecipeType = new RecipeType<>(MechaCrowRecipeCategory.UID, MechaCrowCraftingRecipe.class);

    @Override
    public ResourceLocation getPluginUid() {
        return new ResourceLocation(CelestialExploration.MODID, "jei_plugin");
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        registration.addRecipeCategories(new WorkbenchCraftingRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
        registration.addRecipeCategories(new WorkbenchSmeltingRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
        registration.addRecipeCategories(new MechaCrowRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
    }

    @Override
    public void registerRecipeCatalysts(IRecipeCatalystRegistration registration) {
        IModPlugin.super.registerRecipeCatalysts(registration);
        registration.addRecipeCatalyst(new ItemStack(CelestialBlocks.WORKBENCH.get()), workbenchCraftingRecipeType, workbenchSmeltingRecipeType);
        registration.addRecipeCatalyst(new ItemStack(CelestialItems.BLACK_MECHACROW.get()), mechacrowRecipeType);

    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        RecipeManager manager = Objects.requireNonNull(CelestialExploration.PROXY.getMinecraft().level).getRecipeManager();

        registration.addRecipes(workbenchCraftingRecipeType, manager.getAllRecipesFor(WorkbenchCraftingRecipe.Type.INSTANCE));
        registration.addRecipes(workbenchSmeltingRecipeType, manager.getAllRecipesFor(WorkbenchSmeltingRecipe.Type.INSTANCE));
        registration.addRecipes(mechacrowRecipeType, manager.getAllRecipesFor(MechaCrowCraftingRecipe.Type.INSTANCE));
    }

//    public void registerRecipeTransferHandlers(IRecipeTransferRegistration registration) {
//        registration.addRecipeTransferHandler(WorkbenchMenu.class, workbenchCraftingRecipeType, 2, 9, 11, 36);
//    }
}