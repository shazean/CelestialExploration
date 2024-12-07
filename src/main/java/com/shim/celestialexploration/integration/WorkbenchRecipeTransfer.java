package com.shim.celestialexploration.integration;

import com.shim.celestialexploration.inventory.menus.WorkbenchMenu;
import com.shim.celestialexploration.recipes.WorkbenchCraftingRecipe;
import mezz.jei.api.gui.ingredient.IRecipeSlotsView;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.transfer.IRecipeTransferError;
import mezz.jei.api.recipe.transfer.IRecipeTransferHandler;
import mezz.jei.api.recipe.transfer.IRecipeTransferInfo;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.Slot;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class WorkbenchRecipeTransfer<C extends AbstractContainerMenu, WorkbenchCraftingRecipe> implements IRecipeTransferHandler<C, WorkbenchCraftingRecipe> {
    private final Class<C> containerClass;
    private final RecipeType<WorkbenchCraftingRecipe> recipeType;
    private final int recipeSlotStart;
    private final int recipeSlotCount;
    private final int inventorySlotStart;
    private final int inventorySlotCount;

    public WorkbenchRecipeTransfer(Class<C> containerClass, RecipeType<WorkbenchCraftingRecipe> recipeType, int recipeSlotStart, int recipeSlotCount, int inventorySlotStart, int inventorySlotCount) {
        this.containerClass = containerClass;
        this.recipeType = recipeType;
        this.recipeSlotStart = recipeSlotStart;
        this.recipeSlotCount = recipeSlotCount;
        this.inventorySlotStart = inventorySlotStart;
        this.inventorySlotCount = inventorySlotCount;
    }

    @Override
    public Class<C> getContainerClass() {
        return containerClass;
    }

    @Override
    public Class<WorkbenchCraftingRecipe> getRecipeClass() {
        @SuppressWarnings("unchecked")
        Class<WorkbenchCraftingRecipe> cast = (Class<WorkbenchCraftingRecipe>) recipeType.getRecipeClass();
        return cast;
    }

    @Override
    public @Nullable IRecipeTransferError transferRecipe(C container, WorkbenchCraftingRecipe recipe, IRecipeSlotsView recipeSlots, Player player, boolean maxTransfer, boolean doTransfer) {


        return IRecipeTransferHandler.super.transferRecipe(container, recipe, recipeSlots, player, maxTransfer, doTransfer);
    }
}
