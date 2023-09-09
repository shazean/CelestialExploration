package com.shim.celestialexploration.inventory.screens;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestialexploration.inventory.menus.OxygenCompressorMenu;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class OxygenCompressorScreen extends AbstractContainerScreen<OxygenCompressorMenu> {
    private static final ResourceLocation TEXTURE =
            new ResourceLocation(CelestialExploration.MODID, "textures/gui/oxygen_compressor.png");

    public OxygenCompressorScreen(OxygenCompressorMenu menu, Inventory playerInventory, Component title) {
        super(menu, playerInventory, title);
    }

    @Override
    protected void renderBg(PoseStack poseStack, float partialTick, int mouseX, int mouseY) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, TEXTURE);
        int x = (width - imageWidth) / 2;
        int y = (height - imageHeight) / 2;

        this.blit(poseStack, x, y, 0, 0, imageWidth, imageHeight);

        int i = this.leftPos;
        int j = this.topPos;
        //FIXME?
//        this.blit(p_97853_, i, j, 0, 0, this.imageWidth, this.imageHeight);
//        if (this.menu.isLit()) {
//            int k = this.menu.getBurnProgress();
//            this.blit(poseStack, i + 31, j + 35 + 12 - k, 176, 12 - k, 14, k + 1);
//        }
//
//        int l = this.menu.getLitProgress(); //placement, X; placement Y, grab starting at, X; grab starting at, Y; width?; height?;
//        this.blit(poseStack, i + 79, j + 34, 196, 14, 45 - l, 16);
////        this.blit(poseStack, i + 31, j + 35, 176,  10 + -l + 25, 16, 20 - l);


    }

    @Override
    public void render(PoseStack poseStack, int mouseX, int mouseY, float delta) {
        renderBackground(poseStack);
        super.render(poseStack, mouseX, mouseY, delta);
        renderTooltip(poseStack, mouseX, mouseY);
    }
}