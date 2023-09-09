//package com.shim.celestialexploration.blocks.screens;
//
//import com.mojang.blaze3d.systems.RenderSystem;
//import com.mojang.blaze3d.vertex.PoseStack;
//import com.shim.celestialexploration.CelestialExploration;
//import com.shim.celestialexploration.blocks.menus.AssemblyStationMenu;
//import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
//import net.minecraft.client.renderer.GameRenderer;
//import net.minecraft.network.chat.Component;
//import net.minecraft.resources.ResourceLocation;
//import net.minecraft.world.entity.player.Inventory;
//
//public class AssemblyStationScreen extends AbstractContainerScreen<AssemblyStationMenu> {
//    private static final ResourceLocation TEXTURE =
//            new ResourceLocation(CelestialExploration.MODID, "textures/gui/gem_cutting_station_gui.png");
//
//    public AssemblyStationScreen(AssemblyStationMenu pMenu, Inventory pPlayerInventory, Component pTitle) {
//        super(pMenu, pPlayerInventory, pTitle);
//    }
//
//    @Override
//    protected void renderBg(PoseStack pPoseStack, float pPartialTick, int pMouseX, int pMouseY) {
//        RenderSystem.setShader(GameRenderer::getPositionTexShader);
//        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
//        RenderSystem.setShaderTexture(0, TEXTURE);
//        int x = (width - imageWidth) / 2;
//        int y = (height - imageHeight) / 2;
//
//        this.blit(pPoseStack, x, y, 0, 0, imageWidth, imageHeight);
//    }
//
//    @Override
//    public void render(PoseStack pPoseStack, int mouseX, int mouseY, float delta) {
//        renderBackground(pPoseStack);
//        super.render(pPoseStack, mouseX, mouseY, delta);
//        renderTooltip(pPoseStack, mouseX, mouseY);
//    }
//}