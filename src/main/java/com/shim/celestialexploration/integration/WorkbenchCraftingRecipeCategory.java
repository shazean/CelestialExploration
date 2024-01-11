package com.shim.celestialexploration.integration;

import com.ibm.icu.impl.Pair;
import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestialexploration.blocks.blockentities.WorkbenchBlockEntity;
import com.shim.celestialexploration.recipes.WorkbenchCraftingRecipe;
import com.shim.celestialexploration.registry.BlockRegistry;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.forge.ForgeTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.material.Fluids;
import net.minecraftforge.fluids.FluidAttributes;
import net.minecraftforge.fluids.FluidStack;
import org.antlr.v4.misc.MutableInt;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.List;

public class WorkbenchCraftingRecipeCategory implements IRecipeCategory<WorkbenchCraftingRecipe> {
    public final static ResourceLocation UID = new ResourceLocation(CelestialExploration.MODID, "workbench_crafting");
    public final static ResourceLocation TEXTURE = new ResourceLocation(CelestialExploration.MODID, "textures/gui/workbench.png");

    private final IDrawable background;
    private final IDrawable icon;

    public WorkbenchCraftingRecipeCategory(IGuiHelper helper) {
        this.background = helper.createDrawable(TEXTURE, 0, 0, 176, 80);
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(BlockRegistry.WORKBENCH.get()));
    }

    @Override
    @SuppressWarnings("deprecated")
    public ResourceLocation getUid() {
        return UID;
    }

    @Override
    @SuppressWarnings("deprecated")
    public Class<? extends WorkbenchCraftingRecipe> getRecipeClass() {
        return WorkbenchCraftingRecipe.class;
    }

    @Override
    public RecipeType<WorkbenchCraftingRecipe> getRecipeType() {
        return IRecipeCategory.super.getRecipeType();
    }

    @Override
    public Component getTitle() {
        return new TextComponent("Workbench Crafting");
    }

    @Override
    public IDrawable getBackground() {
        return this.background;
    }

    @Override
    public IDrawable getIcon() {
        return this.icon;
    }


    @Override
    public void setRecipe(@Nonnull IRecipeLayoutBuilder builder, @Nonnull WorkbenchCraftingRecipe recipe, @Nonnull IFocusGroup focusGroup) {
        FluidStack fluid = new FluidStack(recipe.getFluid(), (int) (recipe.getBuckets() * FluidAttributes.BUCKET_VOLUME));
        builder.addSlot(RecipeIngredientRole.INPUT, 52, 17).setFluidRenderer(WorkbenchBlockEntity.maxFluidLevel, true, 9, 52).addIngredient(ForgeTypes.FLUID_STACK, fluid);

        int height = recipe.getHeight();
        int width = recipe.getWidth();

        int size = recipe.getIngredients().size();
        int xOffset = size < 3 ? (3 - size) * 18 / 2 : 0;
        int i;
        int j = 0;

        for (i = 0; i < size; i++) {
            Ingredient item = recipe.getIngredients().get(i);
            if (i + 1 > (width * (j + 1))) j++;

            builder.addSlot(RecipeIngredientRole.INPUT, 66 + xOffset + (i % width) * 18, 17 + j * 18).addIngredients(item);
        }

        if (size == 1) {
            builder.setShapeless();
        }

        builder.addSlot(RecipeIngredientRole.OUTPUT, 144, 35).addItemStack(recipe.getResultItem());

    }
}