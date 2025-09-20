package com.shim.celestialexploration.inventory.screens;

import com.google.common.collect.Lists;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestialexploration.inventory.menus.PlanetChartMenu;
import com.shim.celestialexploration.util.CelestialUtil;
import net.minecraft.Util;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.phys.Vec2;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.ArrayList;
import java.util.List;

@OnlyIn(Dist.CLIENT)
public class PlanetChartScreen extends AbstractContainerScreen<PlanetChartMenu> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(CelestialExploration.MODID, "textures/gui/planet_chart.png");

    private List<Component> tooltip = Lists.newArrayList();

    public PlanetChartScreen(PlanetChartMenu menu, Inventory playerInventory, Component title) {
        super(menu, playerInventory, title);
    }

    @Override
    protected void renderBg(PoseStack poseStack, float partialTick, int mouseX, int mouseY) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, TEXTURE);
        this.imageWidth = 176;
        this.imageHeight = 176;

        int x = (width - imageWidth) / 2;
        int y = (height - imageHeight) / 2;

        this.blit(poseStack, x, y, 0, 0, imageWidth, imageHeight);
    }

    protected static Component coordinatesString = new TranslatableComponent("celestialexploration.planet_details.location");

    @Override
    public void render(PoseStack poseStack, int mouseX, int mouseY, float delta) {
        renderBackground(poseStack);
        int i = this.leftPos;
        int j = this.topPos;
        this.renderBg(poseStack, delta, mouseX, mouseY);
//        super.render(poseStack, mouseX, mouseY, delta);
        renderTooltip(poseStack, mouseX, mouseY);

        int x = (width - imageWidth) / 2;
        int y = (height - imageHeight) / 2;

        //sun 75 + 6, 73 + 5, x + 23, y + 22
        if (isHovering(x - i + 75 + 6, y - j + 73 + 5, 18, 18, mouseX, mouseY)) { //SUN
            getPlanetDataTooltip(poseStack, 0, mouseX, mouseY);
        }

        if (isHovering(x - i + 75 + 26, y - j + 73 + 12, 3, 3, mouseX, mouseY)) { //MERCURY
            getPlanetDataTooltip(poseStack, 1, mouseX, mouseY);
        }

        if (isHovering(x - i + 75 + 12, y - j + 73 + 29, 4, 4, mouseX, mouseY)) { //VENUS
            getPlanetDataTooltip(poseStack, 2, mouseX, mouseY);

        }
        if (isHovering(x - i + 75 - 10, y - j + 73 + 12, 4, 4, mouseX, mouseY)) { //OVERWORLD
            getPlanetDataTooltip(poseStack, 3, mouseX, mouseY);

        }
        if (isHovering(x - i + 75 + 12, y - j + 73 - 19, 4, 4, mouseX, mouseY)) { //MARS
            getPlanetDataTooltip(poseStack, 4, mouseX, mouseY);

        }
        if (isHovering(x - i + 75 + 56, y - j + 73 + 11, 9, 9, mouseX, mouseY)) { //JUPITER
            getPlanetDataTooltip(poseStack, 5, mouseX, mouseY);

        }
        if (isHovering(x - i + 75 + 9, y - j + 73 + 67, 11, 9, mouseX, mouseY)) { //SATURN
            getPlanetDataTooltip(poseStack, 6, mouseX, mouseY);

        }
        if (isHovering(x - i + 75 - 47, y - j + 73 + 11, 6, 6, mouseX, mouseY)) { //URANUS
            getPlanetDataTooltip(poseStack, 7, mouseX, mouseY);
        }
        if (isHovering(x - i + 75 + 11, y - j + 73 - 54, 5, 5, mouseX, mouseY)) { //NEPTUNE
            getPlanetDataTooltip(poseStack, 8, mouseX, mouseY);
        }

    }

    public void getPlanetDataTooltip(PoseStack poseStack, int index, int mouseX, int mouseY) {
        tooltip = Lists.newArrayList();
        this.tooltip.add(CelestialUtil.getPlanetDetail(index).name());
        this.tooltip.add(CelestialUtil.getPlanetDetail(index).location());
        this.tooltip.add(CelestialUtil.getPlanetDetail(index).resources());
        this.tooltip.add(CelestialUtil.getPlanetDetail(index).moons());
        this.renderComponentTooltip(poseStack, this.tooltip, mouseX, mouseY);

    }

}