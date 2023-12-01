package com.shim.celestialexploration.integration;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.mojang.blaze3d.vertex.PoseStack;
import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestialexploration.recipes.WorkbenchSmeltingRecipe;
import com.shim.celestialexploration.registry.BlockRegistry;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.forge.ForgeTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.drawable.IDrawableAnimated;
import mezz.jei.api.gui.drawable.IDrawableStatic;
import mezz.jei.api.gui.ingredient.IRecipeSlotsView;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.fluids.FluidAttributes;
import net.minecraftforge.fluids.FluidStack;

import javax.annotation.Nonnull;

public class WorkbenchSmeltingRecipeCategory implements IRecipeCategory<WorkbenchSmeltingRecipe> {
    public final static ResourceLocation UID = new ResourceLocation(CelestialExploration.MODID, "workbench_smelting");
    public final static ResourceLocation TEXTURE = new ResourceLocation(CelestialExploration.MODID, "textures/gui/workbench.png");

    private final IDrawable background;
    private final IDrawable icon;
    protected final IDrawableStatic staticFlame;
    protected final IDrawableAnimated animatedFlame;
    private final LoadingCache<Integer, IDrawableAnimated> cachedArrows;


    public WorkbenchSmeltingRecipeCategory(IGuiHelper helper) {
        this.background = helper.createDrawable(TEXTURE, 0, 0, 176, 80);
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(BlockRegistry.WORKBENCH.get()));
        this.staticFlame = helper.createDrawable(TEXTURE, 176, 0, 14, 14);
        this.animatedFlame = helper.createAnimatedDrawable(staticFlame, 300, IDrawableAnimated.StartDirection.TOP, true);
        this.cachedArrows = CacheBuilder.newBuilder()
                .maximumSize(25)
                .build(new CacheLoader<>() {
                    @Override
                    public IDrawableAnimated load(Integer cookTime) {
                        return helper.drawableBuilder(TEXTURE, 176, 14, 19, 14)
                                .buildAnimated(cookTime, IDrawableAnimated.StartDirection.LEFT, false);
                    }
                });
    }

    @Override
    @SuppressWarnings("deprecated")
    public ResourceLocation getUid() {
        return UID;
    }

    @Override
    @SuppressWarnings("deprecated")
    public Class<? extends WorkbenchSmeltingRecipe> getRecipeClass() {
        return WorkbenchSmeltingRecipe.class;
    }

    @Override
    public RecipeType<WorkbenchSmeltingRecipe> getRecipeType() {
        return IRecipeCategory.super.getRecipeType();
    }

    @Override
    public Component getTitle() {
        return new TextComponent("Workbench Smelting");
    }

    @Override
    public IDrawable getBackground() {
        return this.background;
    }

    @Override
    public IDrawable getIcon() {
        return this.icon;
    }

    protected IDrawableAnimated getArrow(WorkbenchSmeltingRecipe recipe) {
        int cookTime = recipe.getCookingTime();
        if (cookTime <= 0) {
            cookTime = 100;
//            cookTime = regularCookTime;
        }
        return this.cachedArrows.getUnchecked(cookTime);
    }

    @Override
    public void draw(WorkbenchSmeltingRecipe recipe, IRecipeSlotsView recipeSlotsView, PoseStack poseStack, double mouseX, double mouseY) {
        animatedFlame.draw(poseStack, 14, 36);

        IDrawableAnimated arrow = getArrow(recipe);
        arrow.draw(poseStack, 30, 36);

//        drawExperience(recipe, poseStack, 18);
        drawCookTime(recipe, poseStack, 58);
    }

    protected void drawExperience(WorkbenchSmeltingRecipe recipe, PoseStack poseStack, int y) {
        float experience = recipe.getExperience();
        if (experience > 0) {
            TranslatableComponent experienceString = new TranslatableComponent("gui.jei.category.smelting.experience", experience);
            Minecraft minecraft = Minecraft.getInstance();
            Font fontRenderer = minecraft.font;
            int stringWidth = fontRenderer.width(experienceString);
            fontRenderer.draw(poseStack, experienceString, background.getWidth() - stringWidth - 12, y, 0xFF808080);
        }
    }

    protected void drawCookTime(WorkbenchSmeltingRecipe recipe, PoseStack poseStack, int y) {
        int cookTime = recipe.getCookingTime();
        if (cookTime > 0) {
            int cookTimeSeconds = cookTime / 20;
            TranslatableComponent timeString = new TranslatableComponent("gui.jei.category.smelting.time.seconds", cookTimeSeconds);
            Minecraft minecraft = Minecraft.getInstance();
            Font fontRenderer = minecraft.font;
            int stringWidth = fontRenderer.width(timeString);
            fontRenderer.draw(poseStack, timeString, background.getWidth() - stringWidth - 12, y, 0xFF808080);
        }
    }

    @Override
    public void setRecipe(@Nonnull IRecipeLayoutBuilder builder, @Nonnull WorkbenchSmeltingRecipe recipe, @Nonnull IFocusGroup focusGroup) {

        builder.addSlot(RecipeIngredientRole.INPUT, 13, 17).addIngredients(recipe.getIngredients().get(0));

//        builder.addSlot(RecipeIngredientRole.CATALYST, 13, 53).addIngredients(Ingredient.of(ItemTags.));

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
//            Ingredient item = recipe.getIngredients().get(i);
//            if (i + 1 > (width * (j + 1))) j++;
//
//            builder.addSlot(RecipeIngredientRole.INPUT, 66 + xOffset + (i % width) * 18, 17 + j * 18).addIngredients(item);
//        }
//
//        if (size == 1) {
//            builder.setShapeless();
//        }
//
//        builder.addSlot(RecipeIngredientRole.OUTPUT, 144, 35).addItemStack(recipe.getResultItem());

        FluidStack fluid = new FluidStack(recipe.getResultFluid(), FluidAttributes.BUCKET_VOLUME * 8);
        builder.addSlot(RecipeIngredientRole.OUTPUT, 52, 17).setFluidRenderer(FluidAttributes.BUCKET_VOLUME * 8, true, 9, 52).addIngredient(ForgeTypes.FLUID_STACK, fluid);

//        this.addSlot(new SlotItemHandler(handler, 0, 13, 17)); //smelting slot
//        this.addSlot(new FuelSlot(handler, 1, 13, 53)); //fuel slot


    }
}