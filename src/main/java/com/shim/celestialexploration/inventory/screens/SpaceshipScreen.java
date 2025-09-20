package com.shim.celestialexploration.inventory.screens;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.mojang.blaze3d.platform.InputConstants;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestialexploration.inventory.menus.SpaceshipMenu;
import com.shim.celestialexploration.registry.CelestialCapabilities;
import com.shim.celestialexploration.registry.CelestialDimensions;
import com.shim.celestialexploration.util.CelestialUtil;
import com.shim.celestialexploration.util.Keybinds;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;

import java.util.List;

public class SpaceshipScreen extends AbstractContainerScreen<SpaceshipMenu> {
    private static final ResourceLocation INVENTORY = new ResourceLocation(CelestialExploration.MODID, "textures/gui/spaceship.png");
    private static final ResourceLocation LIGHT_TRAVEL = new ResourceLocation(CelestialExploration.MODID, "textures/gui/light_travel.png");
    private static final ResourceLocation TABS = new ResourceLocation("textures/gui/advancements/tabs.png");
    private List<Component> tooltip = Lists.newArrayList();
    public ImmutableList<Slot> originalSlots;

    public SpaceshipScreen(SpaceshipMenu menu, Inventory playerInventory, Component title) {
        super(menu, playerInventory, title);
        this.imageWidth = 176;
        this.imageHeight = 176;
    }

    @Override
    protected void renderBg(PoseStack poseStack, float partialTick, int mouseX, int mouseY) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);

        RenderSystem.setShaderTexture(0, INVENTORY);
        int x = (width - imageWidth) / 2;
        int y = (height - (this.imageHeight)) / 2;

        this.blit(poseStack, x, y, 0, 0, imageWidth, this.imageHeight);
    }

    @Override
    protected void renderLabels(PoseStack p_97808_, int p_97809_, int p_97810_) {
        this.inventoryLabelY = this.imageHeight - 94;
        this.font.draw(p_97808_, this.title, (float) this.titleLabelX, (float) this.titleLabelY, 4210752);
        this.font.draw(p_97808_, this.playerInventoryTitle, (float) this.inventoryLabelX, (float) this.inventoryLabelY, 4210752);
    }

    @Override
    public boolean keyPressed(int key, int p_97766_, int p_97767_) {
//        if (Keybinds.SPACESHIP_LIGHT_TRAVEL.isActiveAndMatches(InputConstants.getKey(key, p_97766_))) {
//            travelKeyPressed = true;
//        }
//        if (Keybinds.OPEN_SPACESHIP_INVENTORY.isActiveAndMatches(InputConstants.getKey(key, p_97766_))) {
//            this.minecraft.player.closeContainer();
//        }
        return super.keyPressed(key, p_97766_, p_97767_);
    }

    @Override
    public void render(PoseStack poseStack, int mouseX, int mouseY, float delta) {
        renderBackground(poseStack);
        super.render(poseStack, mouseX, mouseY, delta);
        renderTooltip(poseStack, mouseX, mouseY);

    }
}