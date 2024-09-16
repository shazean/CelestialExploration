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


//    TranslatableComponent("planet_chart");

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
            tooltip = Lists.newArrayList();
            this.tooltip.add(CelestialUtil.getPlanetDetail(0).name());
            this.tooltip.add(CelestialUtil.getPlanetDetail(0).location());
            this.tooltip.add(CelestialUtil.getPlanetDetail(0).resources());
            this.tooltip.add(CelestialUtil.getPlanetDetail(0).moons());
            this.renderComponentTooltip(poseStack, this.tooltip, mouseX, mouseY);
        }

        if (isHovering(x - i + 75 + 26, y - j + 73 + 12, 3, 3, mouseX, mouseY)) { //MERCURY
            tooltip = Lists.newArrayList();
            this.tooltip.add(CelestialUtil.getPlanetDetail(1).name());
            this.tooltip.add(CelestialUtil.getPlanetDetail(1).location());
            this.tooltip.add(CelestialUtil.getPlanetDetail(1).resources());
            this.tooltip.add(CelestialUtil.getPlanetDetail(1).moons());
            this.renderComponentTooltip(poseStack, this.tooltip, mouseX, mouseY);
        }

        if (isHovering(x - i + 75 + 12, y - j + 73 + 29, 4, 4, mouseX, mouseY)) { //VENUS
            tooltip = Lists.newArrayList();
            this.tooltip.add(CelestialUtil.getPlanetDetail(2).name());
            this.tooltip.add(CelestialUtil.getPlanetDetail(2).location());
            this.tooltip.add(CelestialUtil.getPlanetDetail(2).resources());
            this.tooltip.add(CelestialUtil.getPlanetDetail(2).moons());
            this.renderComponentTooltip(poseStack, this.tooltip, mouseX, mouseY);
        }
        if (isHovering(x - i + 75 - 10, y - j + 73 + 12, 4, 4, mouseX, mouseY)) { //OVERWORLD
            tooltip = Lists.newArrayList();
            this.tooltip.add(CelestialUtil.getPlanetDetail(3).name());
            this.tooltip.add(CelestialUtil.getPlanetDetail(3).location());
            this.tooltip.add(CelestialUtil.getPlanetDetail(3).resources());
            this.tooltip.add(CelestialUtil.getPlanetDetail(3).moons());
            this.renderComponentTooltip(poseStack, this.tooltip, mouseX, mouseY);
        }
        if (isHovering(x - i + 75 + 12, y - j + 73 - 19, 4, 4, mouseX, mouseY)) { //MARS
            tooltip = Lists.newArrayList();
            this.tooltip.add(CelestialUtil.getPlanetDetail(4).name());
            this.tooltip.add(CelestialUtil.getPlanetDetail(4).location());
            this.tooltip.add(CelestialUtil.getPlanetDetail(4).resources());
            this.tooltip.add(CelestialUtil.getPlanetDetail(4).moons());
            this.renderComponentTooltip(poseStack, this.tooltip, mouseX, mouseY);
        }
        if (isHovering(x - i + 75 + 56, y - j + 73 + 11, 9, 9, mouseX, mouseY)) { //JUPITER
            tooltip = Lists.newArrayList();
            this.tooltip.add(CelestialUtil.getPlanetDetail(5).name());
            this.tooltip.add(CelestialUtil.getPlanetDetail(5).location());
            this.tooltip.add(CelestialUtil.getPlanetDetail(5).resources());
            this.tooltip.add(CelestialUtil.getPlanetDetail(5).moons());
            this.renderComponentTooltip(poseStack, this.tooltip, mouseX, mouseY);
        }
        if (isHovering(x - i + 75 + 9, y - j + 73 + 67, 11, 9, mouseX, mouseY)) { //SATURN
            tooltip = Lists.newArrayList();
            this.tooltip.add(CelestialUtil.getPlanetDetail(6).name());
            this.tooltip.add(CelestialUtil.getPlanetDetail(6).location());
            this.tooltip.add(CelestialUtil.getPlanetDetail(6).resources());
            this.tooltip.add(CelestialUtil.getPlanetDetail(6).moons());
            this.renderComponentTooltip(poseStack, this.tooltip, mouseX, mouseY);
        }
        if (isHovering(x - i + 75 - 47, y - j + 73 + 11, 6, 6, mouseX, mouseY)) { //URANUS
            tooltip = Lists.newArrayList();
            this.tooltip.add(CelestialUtil.getPlanetDetail(7).name());
            this.tooltip.add(CelestialUtil.getPlanetDetail(7).location());
            this.tooltip.add(CelestialUtil.getPlanetDetail(7).resources());
            this.tooltip.add(CelestialUtil.getPlanetDetail(7).moons());
            this.renderComponentTooltip(poseStack, this.tooltip, mouseX, mouseY);
        }
        if (isHovering(x - i + 75 + 11, y - j + 73 - 54, 5, 5, mouseX, mouseY)) { //NEPTUNE
            tooltip = Lists.newArrayList();
            this.tooltip.add(CelestialUtil.getPlanetDetail(8).name());
            this.tooltip.add(CelestialUtil.getPlanetDetail(8).location());
            this.tooltip.add(CelestialUtil.getPlanetDetail(8).resources());
            this.tooltip.add(CelestialUtil.getPlanetDetail(8).moons());
            this.renderComponentTooltip(poseStack, this.tooltip, mouseX, mouseY);
        }

    }
}