package com.shim.celestialexploration.integration;

import mezz.jei.api.gui.ingredient.IRecipeSlotTooltipCallback;
import mezz.jei.api.gui.ingredient.IRecipeSlotView;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.TranslatableComponent;

import java.util.List;

public class WorkbenchTooltip implements IRecipeSlotTooltipCallback {
    private final int millibuckets;

    public WorkbenchTooltip(int mb) {
        this.millibuckets = mb;
    }

    @Override
    public void onTooltip(IRecipeSlotView recipeSlotView, List<Component> tooltip) {
        tooltip.add(new TextComponent((this.millibuckets / 1000) + " " + new TranslatableComponent("recipe.celestialexploration.workbench.blocks").getString() + ", " + (this.millibuckets % 1000 / 111) + " " + new TranslatableComponent("recipe.celestialexploration.workbench.ingots").getString()));

    }
}
