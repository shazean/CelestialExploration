package com.shim.celestialexploration.inventory.screens;

import com.google.common.collect.Lists;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.*;
import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestialexploration.inventory.menus.WorkbenchMenu;
import com.shim.celestialexploration.util.CelestialUtil;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.client.renderer.texture.MissingTextureAtlasSprite;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.network.chat.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.FormattedCharSequence;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.InventoryMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.material.Fluids;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fluids.FluidStack;

import java.util.Collections;
import java.util.List;

@OnlyIn(Dist.CLIENT)
public class WorkbenchScreen extends AbstractContainerScreen<WorkbenchMenu> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(CelestialExploration.MODID, "textures/gui/workbench.png");
    private List<Component> tooltip = Lists.newArrayList();
    int animationTick = 0;
    int animationLoc = 0;

    public WorkbenchScreen(WorkbenchMenu menu, Inventory playerInventory, Component title) {
        super(menu, playerInventory, title);
//        this.tooltip = new TranslatableComponent(menu.getFluidLevel() + " / 4000 mb");
    }

    @Override
    protected void renderBg(PoseStack poseStack, float partialTick, int mouseX, int mouseY) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, TEXTURE);

        int x = (width - imageWidth) / 2;
        int y = (height - imageHeight) / 2;

        //placement, X; placement Y, grab starting at, X; grab starting at, Y; width?; height?;
        this.blit(poseStack, x, y, 0, 0, imageWidth, imageHeight);

        int i = this.leftPos;
        int j = this.topPos;


        int k = this.menu.getFluidLevel();
//        int l = this.menu.getFluidType();
//        blit(poseStack, x + 52, y + 17 + 52 - k, 176 - 9 + (l * 9), 29, 9, k); //FLUID LEVEL OLD

        blit(poseStack, x + 31, y + 36, 177, 14, menu.getScaledProgress(), 14); //SMELTING ARROW

        int m = this.menu.getLitProgress();
        if(menu.isLit()) {
            blit(poseStack, x + 14, y + 36 + 12 - m, 176, 12 - m, 14, m + 1); //FLAME
        }

        if (!this.menu.getFluid().isEmpty()) {
            RenderSystem.resetTextureMatrix();
            RenderSystem.setShader(GameRenderer::getPositionTexShader);
            poseStack.pushPose();

            ResourceLocation tex = new ResourceLocation(this.menu.getFluid().getFluid().getAttributes().getStillTexture().getNamespace(),
                    "textures/" + this.menu.getFluid().getFluid().getAttributes().getStillTexture().getPath() + ".png");
            int color = this.menu.getFluid().getFluid().getAttributes().getColor();
            setGLColorFromInt(color, 1.0F);

            RenderSystem.setShaderTexture(0, tex);
            if (animationTick % 16 == 0) animationLoc += 16;
            int texLength = (this.menu.getFluid().getFluid().isSame(Fluids.LAVA)) ? 320 : 512;
            blit(poseStack, x + 52, y + 17 + 52 - k, 0, animationLoc, 9, k, 16, texLength); //FLUID LEVEL

            poseStack.popPose();
            animationTick++;
            if (animationTick > (texLength)) {
                animationTick = 0;
            animationLoc = 0;
            }
        }
    }

    //credit JEI
    private static void setGLColorFromInt(int color, float alpha) {
        float red = (color >> 16 & 0xFF) / 255.0F;
        float green = (color >> 8 & 0xFF) / 255.0F;
        float blue = (color & 0xFF) / 255.0F;

        RenderSystem.setShaderColor(red, green, blue, alpha);
    }

    @Override
    public void render(PoseStack poseStack, int mouseX, int mouseY, float delta) {
        renderBackground(poseStack);
        super.render(poseStack, mouseX, mouseY, delta);
        renderTooltip(poseStack, mouseX, mouseY);

        int x = (width - imageWidth) / 2;
        int y = (height - imageHeight) / 2;
        int i = this.leftPos;
        int j = this.topPos;

        if (isHovering(x - i + 52, y - j + 17, 9, 52, mouseX, mouseY)) {
            renderFluidSlotHighlight(poseStack, x + 52, y + 17, 9, 52, 400, slotColor, slotColor);
            if (!menu.getFluid().isEmpty()) {
                tooltip = Lists.newArrayList();
                this.tooltip.add(menu.getFluid().getDisplayName());
                this.tooltip.add(new TranslatableComponent(menu.getFluid().getAmount() + " / " + menu.getMaxFluidAmount()));
                this.renderComponentTooltip(poseStack, this.tooltip, mouseX, mouseY);
            }
        }
    }

    public static void renderFluidSlotHighlight(PoseStack poseStack, int pX, int pY, int width, int height, int pBlitOffset, int slotColor, int slotColor2) {
        RenderSystem.disableDepthTest();
        RenderSystem.colorMask(true, true, true, false);
        fillGradient(poseStack, pX, pY, pX + width, pY + height, slotColor, slotColor2, pBlitOffset);
        RenderSystem.colorMask(true, true, true, true);
        RenderSystem.enableDepthTest();
    }
}