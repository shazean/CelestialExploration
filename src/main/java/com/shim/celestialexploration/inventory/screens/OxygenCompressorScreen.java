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
    private static final ResourceLocation TEXTURE = new ResourceLocation(CelestialExploration.MODID, "textures/gui/oxygen_compressor.png");

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
//        CelestialExploration.LOGGER.debug("screen isLit is: " + this.menu.isLit());


//      if (this.menu.isLit()) {
//           int l = (int) (this.menu.getLitProgress() * 1.25); //placement, X; placement Y, grab starting at, X; grab starting at, Y; width?; height?;
//           this.blit(poseStack, i + 32, j + 35 + l, 176, 0 + l, 16, 14 - l);
//      }

        int m = this.menu.getLitProgress();
//        CelestialExploration.LOGGER.debug("m: " + m);
        if(menu.isLit()) {
            blit(poseStack, x + 32, y + 36 + 10 - m, 176, 12 - m, 14, m + 1); //FLAME
        }

        if (menu.isBurning()) {
            //compression tube
            int k = this.menu.getScaledProgress(19);
            this.blit(poseStack, i + 79, j + 55, 192, 0, k, 6);

            //snowflakes
            int l = this.menu.getScaledProgress(33);
            this.blit(poseStack, i + 76, j + 20, 211, 0, 24, 1 + l); //32
        }
    }

    @Override
    public void render(PoseStack poseStack, int mouseX, int mouseY, float delta) {
        renderBackground(poseStack);
        super.render(poseStack, mouseX, mouseY, delta);



        renderTooltip(poseStack, mouseX, mouseY);
    }
}