//package com.shim.celestialexploration.inventory.screens;
//
//import com.mojang.blaze3d.systems.RenderSystem;
//import com.mojang.blaze3d.vertex.PoseStack;
//import com.shim.celestialexploration.CelestialExploration;
//import com.shim.celestialexploration.inventory.menus.TaxiStationMenu;
//import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
//import net.minecraft.client.renderer.GameRenderer;
//import net.minecraft.network.chat.Component;
//import net.minecraft.resources.ResourceLocation;
//import net.minecraft.world.entity.player.Inventory;
//import net.minecraftforge.api.distmarker.Dist;
//import net.minecraftforge.api.distmarker.OnlyIn;
//
//@OnlyIn(Dist.CLIENT)
//public class TaxiStationScreen extends AbstractContainerScreen<TaxiStationMenu> {
//    private static final ResourceLocation TEXTURE = new ResourceLocation(CelestialExploration.MODID, "textures/gui/taxi_station.png");
//
//    public TaxiStationScreen(TaxiStationMenu menu, Inventory playerInventory, Component title) {
//        super(menu, playerInventory, title);
//    }
//
//    @Override
//    protected void renderBg(PoseStack poseStack, float partialTick, int mouseX, int mouseY) {
//        RenderSystem.setShader(GameRenderer::getPositionTexShader);
//        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
//        RenderSystem.setShaderTexture(0, TEXTURE);
//        int x = (width - imageWidth) / 2;
//        int y = (height - imageHeight) / 2;
//
//        this.blit(poseStack, x, y, 0, 0, imageWidth, imageHeight);
//
//        int i = this.leftPos;
//        int j = this.topPos;
//    }
//
//    @Override
//    public void render(PoseStack poseStack, int mouseX, int mouseY, float delta) {
//        renderBackground(poseStack);
//        super.render(poseStack, mouseX, mouseY, delta);
//
//        renderTooltip(poseStack, mouseX, mouseY);
//    }
//}