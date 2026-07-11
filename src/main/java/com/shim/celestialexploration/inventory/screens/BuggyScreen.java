package com.shim.celestialexploration.inventory.screens;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestialexploration.inventory.menus.BuggyMenu;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.Slot;

import java.util.List;

public class BuggyScreen extends AbstractContainerScreen<BuggyMenu> {
    private static final ResourceLocation INVENTORY = new ResourceLocation(CelestialExploration.MODID, "textures/gui/buggy.png");
    private List<Component> tooltip = Lists.newArrayList();
    public ImmutableList<Slot> originalSlots;

    public BuggyScreen(BuggyMenu menu, Inventory playerInventory, Component title) {
        super(menu, playerInventory, title);
//        this.imageWidth = 176;
//        this.imageHeight = 176;
    }

    @Override
    protected void renderBg(PoseStack poseStack, float partialTick, int mouseX, int mouseY) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);

        RenderSystem.setShaderTexture(0, INVENTORY);
        int x = (width - this.imageWidth) / 2;
        int y = (height - (this.imageHeight)) / 2;

        this.blit(poseStack, x, y, 0, 0, this.imageWidth, this.imageHeight);
    }

//    @Override
//    protected void renderLabels(PoseStack p_97808_, int p_97809_, int p_97810_) {
//        this.inventoryLabelY = this.imageHeight - 94;
//        this.font.draw(p_97808_, this.title, (float) this.titleLabelX, (float) this.titleLabelY, 4210752);
//        this.font.draw(p_97808_, this.playerInventoryTitle, (float) this.inventoryLabelX, (float) this.inventoryLabelY, 4210752);
//    }

    @Override
    public void render(PoseStack poseStack, int mouseX, int mouseY, float delta) {
        renderBackground(poseStack);
        super.render(poseStack, mouseX, mouseY, delta);
        renderTooltip(poseStack, mouseX, mouseY);

    }
}