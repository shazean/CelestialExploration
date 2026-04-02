package com.shim.celestialexploration.integration;

import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestialexploration.recipes.MechaCrowCraftingRecipe;
import com.shim.celestialexploration.registry.CelestialItems;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;

import javax.annotation.Nonnull;

public class MechaCrowRecipeCategory implements IRecipeCategory<MechaCrowCraftingRecipe> {
    public final static ResourceLocation UID = new ResourceLocation(CelestialExploration.MODID, "mechacrow_crafting");
    public final static ResourceLocation TEXTURE = new ResourceLocation(CelestialExploration.MODID, "textures/gui/jei/mechacrow.png");

    private final IDrawable background;
    private final IDrawable icon;

    public MechaCrowRecipeCategory(IGuiHelper helper) {
        this.background = helper.createDrawable(TEXTURE, 0, 0, 176, 80);
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(CelestialItems.BLACK_MECHACROW.get()));
    }

    @Override
    @SuppressWarnings("deprecated")
    public ResourceLocation getUid() {
        return UID;
    }

    @Override
    @SuppressWarnings("deprecated")
    public Class<? extends MechaCrowCraftingRecipe> getRecipeClass() {
        return MechaCrowCraftingRecipe.class;
    }

    @Override
    public RecipeType<MechaCrowCraftingRecipe> getRecipeType() {
        return IRecipeCategory.super.getRecipeType();
    }

    @Override
    public Component getTitle() {
        return new TranslatableComponent("recipe.celestialexploration.mechacrow.crafting");
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
    public void setRecipe(@Nonnull IRecipeLayoutBuilder builder, @Nonnull MechaCrowCraftingRecipe recipe, @Nonnull IFocusGroup focusGroup) {
//        FluidStack fluid = new FluidStack(recipe.getFluid(), (int) (recipe.getBuckets() * FluidAttributes.BUCKET_VOLUME));
//        builder.addSlot(RecipeIngredientRole.INPUT, 52, 17)
//                .addTooltipCallback(new WorkbenchTooltip(fluid.getAmount()))
//                .setFluidRenderer(WorkbenchBlockEntity.maxFluidLevel,
//                true, 9, 52).addIngredient(ForgeTypes.FLUID_STACK, fluid);
//
//        int height = recipe.getHeight();
//        int width = recipe.getWidth();
//
//        int size = recipe.getIngredients().size();
//        int xOffset = size < 3 ? (3 - size) * 18 / 2 : 0;
//        int i;
//        int j = 0;
//
//        for (i = 0; i < size; i++) {
            Ingredient item = recipe.getIngredients().get(0);
//            if (i + 1 > (width * (j + 1))) j++;
//
            builder.addSlot(RecipeIngredientRole.INPUT, 27, 35).addIngredients(item);
//        }
//
//        if (size == 1) {
            builder.setShapeless();
//        }
//
        builder.addSlot(RecipeIngredientRole.OUTPUT, 130, 35).addItemStack(recipe.getResultItem());

    }
}