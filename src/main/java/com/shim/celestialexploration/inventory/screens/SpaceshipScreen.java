package com.shim.celestialexploration.inventory.screens;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.mojang.blaze3d.platform.InputConstants;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestialexploration.capabilities.LightTravelCapability;
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
    private boolean isInventoryScreen = true;
    private List<Component> tooltip = Lists.newArrayList();
    public ImmutableList<Slot> originalSlots;
    public boolean lightTravelAllowed = false;
    public ResourceKey<Level> hoveredDimension = null;


    public SpaceshipScreen(SpaceshipMenu menu, Inventory playerInventory, Component title) {
        super(menu, playerInventory, title);
        this.imageWidth = 176;
        this.imageHeight = 176;
    }

    @Override
    protected void renderBg(PoseStack poseStack, float partialTick, int mouseX, int mouseY) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);

        if (isInventoryScreen) {
            RenderSystem.setShaderTexture(0, INVENTORY);
            int x = (width - imageWidth) / 2;
            int y = (height - (this.imageHeight)) / 2;

            this.blit(poseStack, x, y, 0, 0, imageWidth, this.imageHeight);

        } else {
            this.inventoryLabelY = 0;
            RenderSystem.setShaderTexture(0, LIGHT_TRAVEL);

            int x = (width - imageWidth) / 2;
            int y = (height - (this.imageHeight)) / 2;
            this.blit(poseStack, x, y, 0, 0, imageWidth, this.imageHeight);

            Player player = CelestialExploration.PROXY.getPlayer();

            LightTravelCapability.ILightTravel travelCap = CelestialExploration.getCapability(player, CelestialCapabilities.LIGHT_TRAVEL_CAPABILITY);

            if (travelCap != null) {
                if (travelCap.hasBeenToMercury())
                    this.blit(poseStack, x + 75 + 26, y + 73 + 12, 177, 0, 3, 3); //MERCURY
                if (travelCap.hasBeenToVenus())
                    this.blit(poseStack, x + 75 + 12, y + 73 + 29, 177, 4, 4, 4); //VENUS
                if (travelCap.hasBeenToSpace())
                    this.blit(poseStack, x + 75 - 10, y + 73 + 12, 177, 9, 4, 4); //OVERWORLD
                if (travelCap.hasBeenToMars())
                    this.blit(poseStack, x + 75 + 12, y + 73 - 19, 177, 14, 4, 4); //MARS
                if (travelCap.hasBeenToJupiter())
                    this.blit(poseStack, x + 75 + 56, y + 73 + 11, 177, 19, 9, 9); //JUPITER
//                this.blit(poseStack, x + 75 + 9, y + 73 + 67, 177, 29, 14, 7); //SATURN
//                this.blit(poseStack, x + 75 - 47, y + 73 + 11, 177, 29 + 8, 5, 5); //URANUS
//                this.blit(poseStack, x + 75 + 11, y + 73 - 54, 177, 29 + 8 + 6, 5, 5); //NEPTUNE
            }
        }
        renderTabs(poseStack, mouseX, mouseY);
    }

    private void renderTabs(PoseStack poseStack, int mouseX, int mouseY) {
        if (isInventoryScreen) {
            RenderSystem.setShaderTexture(0, TABS);
            int x = (width - imageWidth) / 2;
            int y = (height - (this.imageHeight)) / 2;

            RenderSystem.enableBlend();
            this.blit(poseStack, x - 32 + 4, y, 0, 64 + 28, 32, 28);
            this.blit(poseStack, x - 32 + 4, y + 29, 0, 64, 28, 28);

            this.itemRenderer.renderAndDecorateItem(new ItemStack(Items.CHEST), x - 32 + 13, y + 6);
            this.itemRenderer.renderAndDecorateItem(new ItemStack(Items.MAP), x - 32 + 13, y + 29 + 6);
        } else {
            RenderSystem.setShaderTexture(0, TABS);
            int x = (width - imageWidth) / 2;
            int y = (height - (this.imageHeight)) / 2;

            RenderSystem.enableBlend();
            this.blit(poseStack, x - 32 + 4, y, 0, 64, 28, 29);
            this.blit(poseStack, x - 32 + 4, y + 29, 64, 64 + 28, 31, 28);

            this.itemRenderer.renderAndDecorateItem(new ItemStack(Items.CHEST), x - 32 + 13, y + 6);
            this.itemRenderer.renderAndDecorateItem(new ItemStack(Items.MAP), x - 32 + 13, y + 29 + 6);
        }
    }

    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int p_97750_) {
        if (lightTravelAllowed && checkTabClicked(mouseX, mouseY)) return true;
        return super.mouseClicked(mouseX, mouseY, p_97750_);
    }

    @Override
    public boolean mouseReleased(double mouseX, double mouseY, int p_97814_) {
        if (lightTravelAllowed && checkTabClicked(mouseX, mouseY)) {
            changeTab();
            return true;
        }
        return super.mouseReleased(mouseX, mouseY, p_97814_);
    }

    private boolean checkTabClicked(double mouseX, double mouseY) {
        int x = (width - imageWidth) / 2;
        int y = (height - (this.imageHeight)) / 2;

        int i = this.leftPos;
        int j = this.topPos;

        int topTabWidth = isInventoryScreen ? 32 : 28;
        int bottomTabWidth = isInventoryScreen ? 28 : 32;

        if (isHovering(x - i - 32 + 4, y - j, topTabWidth, 28, mouseX, mouseY)) {
            return true;
        } else return isHovering(x - i - 32 + 4, y - j + 29, bottomTabWidth, 28, mouseX, mouseY);
    }

    private void changeTab() {
        if (isInventoryScreen) {
            isInventoryScreen = false;
            if (this.originalSlots == null) {
                this.originalSlots = ImmutableList.copyOf(this.menu.slots);
            }
            this.menu.slots.clear();
        } else {
            isInventoryScreen = true;
            this.menu.slots.addAll(this.originalSlots);
            this.originalSlots = null;
        }
    }

    private void renderTabTooltips(PoseStack poseStack, int mouseX, int mouseY) {
        int x = (width - imageWidth) / 2;
        int y = (height - (this.imageHeight)) / 2;

        int i = this.leftPos;
        int j = this.topPos;

        int topTabWidth = isInventoryScreen ? 32 : 28;
        int bottomTabWidth = isInventoryScreen ? 28 : 32;
        int topStart = isInventoryScreen ? 0 : 4;
        int bottomStart = isInventoryScreen ? 4 : 0;

        if (isHovering(x - i - 32 + 4 + topStart, y - j, topTabWidth, 28, mouseX, mouseY)) {
            tooltip = Lists.newArrayList();
            this.tooltip.add(new TranslatableComponent("celestialexploration.spaceship.tab.inventory"));
            this.renderComponentTooltip(poseStack, this.tooltip, mouseX, mouseY);
        } else if (isHovering(x - i - 32 + 4 + bottomStart, y - j + 29, bottomTabWidth, 28, mouseX, mouseY)) {
            tooltip = Lists.newArrayList();
            if (!lightTravelAllowed) {
                this.tooltip.add(new TranslatableComponent("celestialexploration.spaceship.tab.light_travel").withStyle(ChatFormatting.GRAY));
                this.tooltip.add(new TranslatableComponent("celestialexploration.spaceship.tab.light_travel_hint").withStyle(ChatFormatting.GRAY));
            } else {
                this.tooltip.add(new TranslatableComponent("celestialexploration.spaceship.tab.light_travel"));
            }
            this.renderComponentTooltip(poseStack, this.tooltip, mouseX, mouseY);
        }
    }

    @Override
    protected void renderLabels(PoseStack p_97808_, int p_97809_, int p_97810_) {
        if (isInventoryScreen) {
            this.inventoryLabelY = this.imageHeight - 94;
            this.font.draw(p_97808_, this.title, (float) this.titleLabelX, (float) this.titleLabelY, 4210752);
            this.font.draw(p_97808_, this.playerInventoryTitle, (float) this.inventoryLabelX, (float) this.inventoryLabelY, 4210752);
        }
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
    public boolean keyReleased(int key, int p_94716_, int p_94717_) {
        if (Keybinds.SPACESHIP_LIGHT_TRAVEL.isActiveAndMatches(InputConstants.getKey(key, p_94716_))) {
            CelestialExploration.LOGGER.debug("keyReleased, hoveredDimension: " + hoveredDimension);
            if (this.hoveredDimension != null) {
                if (this.minecraft != null && this.minecraft.player != null)
                    this.menu.doLightTravel(hoveredDimension, this.minecraft.player);
            }
        }
//        if (Keybinds.OPEN_SPACESHIP_INVENTORY.isActiveAndMatches(InputConstants.getKey(key, p_94716_))) {
//            this.minecraft.player.closeContainer();
//        }
        return super.keyReleased(key, p_94716_, p_94717_);
    }

    @Override
    public void render(PoseStack poseStack, int mouseX, int mouseY, float delta) {
        renderBackground(poseStack);
        super.render(poseStack, mouseX, mouseY, delta);
        renderTooltip(poseStack, mouseX, mouseY);
        renderTabTooltips(poseStack, mouseX, mouseY);

        if (this.minecraft != null && this.minecraft.player != null)
            lightTravelAllowed = this.minecraft.player.level.dimension().equals(CelestialDimensions.SPACE);

        renderLightTravelTooltips(poseStack, mouseX, mouseY);
    }

    private void renderLightTravelTooltips(PoseStack poseStack, int mouseX, int mouseY) {
        if (isInventoryScreen) return;

        int x = (width - imageWidth) / 2;
        int y = (height - (this.imageHeight)) / 2;

        int i = this.leftPos;
        int j = this.topPos;

        if (this.minecraft != null) {
            Player player = this.minecraft.player;
            LightTravelCapability.ILightTravel travelCap = CelestialExploration.getCapability(player, CelestialCapabilities.LIGHT_TRAVEL_CAPABILITY);

            if (travelCap != null) {
                TextComponent travelTooltip = new TextComponent(new TranslatableComponent("celestialexploration.spaceship.travel.message_1").getString() + Keybinds.SPACESHIP_LIGHT_TRAVEL.getTranslatedKeyMessage().getString() + new TranslatableComponent("celestialexploration.spaceship.travel.message_2").getString());
                TranslatableComponent travelUnavailable = new TranslatableComponent("celestialexploration.spaceship.travel_unavailable");

                if (!travelCap.hasBeenToMercury() && isHovering(x - i + 75 + 26 - 1, y - j + 73 + 12 - 1, 5, 5, mouseX, mouseY)) {
                    tooltip = Lists.newArrayList();
                    this.tooltip.add(CelestialUtil.getPlanetDetail(1).name());
                    this.tooltip.add(travelUnavailable);
                    this.tooltip.add(CelestialUtil.getPlanetDetail(1).location());
                    this.renderComponentTooltip(poseStack, this.tooltip, mouseX, mouseY);
                } else if (!travelCap.hasBeenToVenus() && isHovering(x - i + 75 + 12 - 1, y - j + 73 + 29 - 1, 6, 6, mouseX, mouseY)) {
                    tooltip = Lists.newArrayList();
                    this.tooltip.add(CelestialUtil.getPlanetDetail(2).name());
                    this.tooltip.add(travelUnavailable);
                    this.tooltip.add(CelestialUtil.getPlanetDetail(2).location());
                    this.renderComponentTooltip(poseStack, this.tooltip, mouseX, mouseY);
                } else if (!travelCap.hasBeenToSpace() && isHovering(x - i + 75 - 10 - 1, y - j + 73 + 12 - 1, 6, 6, mouseX, mouseY)) {
                    tooltip = Lists.newArrayList();
                    this.tooltip.add(CelestialUtil.getPlanetDetail(3).name());
                    this.tooltip.add(travelUnavailable);
                    this.tooltip.add(CelestialUtil.getPlanetDetail(3).location());
                    this.renderComponentTooltip(poseStack, this.tooltip, mouseX, mouseY);
                } else if (!travelCap.hasBeenToMars() && isHovering(x - i + 75 + 12 - 1, y - j + 73 - 19 - 1, 6, 6, mouseX, mouseY)) {
                    tooltip = Lists.newArrayList();
                    this.tooltip.add(CelestialUtil.getPlanetDetail(4).name());
                    this.tooltip.add(travelUnavailable);
                    this.tooltip.add(CelestialUtil.getPlanetDetail(4).location());
                    this.renderComponentTooltip(poseStack, this.tooltip, mouseX, mouseY);
                } else if (!travelCap.hasBeenToJupiter() && isHovering(x - i + 75 + 56, y - j + 73 + 11, 9, 9, mouseX, mouseY)) {
                    tooltip = Lists.newArrayList();
                    this.tooltip.add(CelestialUtil.getPlanetDetail(5).name());
                    this.tooltip.add(travelUnavailable);
                    this.tooltip.add(CelestialUtil.getPlanetDetail(5).location());
                    this.renderComponentTooltip(poseStack, this.tooltip, mouseX, mouseY);
                }

                if (travelCap.hasBeenToMercury() && isHovering(x - i + 75 + 26 - 1, y - j + 73 + 12 - 1, 5, 5, mouseX, mouseY)) {
                    tooltip = Lists.newArrayList();
                    this.tooltip.add(new TranslatableComponent("celestialexploration.spaceship.travel.mercury"));
                    if (travelCap.getMercuryCooldown().isCooldownEnded()) {
                        this.tooltip.add(travelTooltip);
                    } else {
                        this.tooltip.add(new TextComponent(new TranslatableComponent("celestialexploration.spaceship.travel.cooldown").getString() + travelCap.getMercuryCooldown().getFormattedCooldown()));
                    }
                    this.renderComponentTooltip(poseStack, this.tooltip, mouseX, mouseY);
                    this.hoveredDimension = CelestialDimensions.MERCURY;
                } else if (travelCap.hasBeenToVenus() && isHovering(x - i + 75 + 12 - 1, y - j + 73 + 29 - 1, 6, 6, mouseX, mouseY)) {
                    tooltip = Lists.newArrayList();
                    this.tooltip.add(new TranslatableComponent("celestialexploration.spaceship.travel.venus"));
                    if (travelCap.getVenusCooldown().isCooldownEnded()) {
                        this.tooltip.add(travelTooltip);
                    } else {
                        this.tooltip.add(new TextComponent(new TranslatableComponent("celestialexploration.spaceship.travel.cooldown").getString() + travelCap.getVenusCooldown().getFormattedCooldown()));
                    }
                    this.renderComponentTooltip(poseStack, this.tooltip, mouseX, mouseY);
                    this.hoveredDimension = CelestialDimensions.VENUS;

                } else if (travelCap.hasBeenToSpace() && isHovering(x - i + 75 - 10 - 1, y - j + 73 + 12 - 1, 6, 6, mouseX, mouseY)) {
                    tooltip = Lists.newArrayList();
                    this.tooltip.add(new TranslatableComponent("celestialexploration.spaceship.travel.overworld"));
                    if (travelCap.getOverworldCooldown().isCooldownEnded()) {
                        this.tooltip.add(travelTooltip);
                    } else {
                        this.tooltip.add(new TextComponent(new TranslatableComponent("celestialexploration.spaceship.travel.cooldown").getString() + travelCap.getOverworldCooldown().getFormattedCooldown()));
                    }
                    this.renderComponentTooltip(poseStack, this.tooltip, mouseX, mouseY);
                    this.hoveredDimension = Level.OVERWORLD;
                } else if (travelCap.hasBeenToMars() && isHovering(x - i + 75 + 12 - 1, y - j + 73 - 19 - 1, 6, 6, mouseX, mouseY)) {
                    tooltip = Lists.newArrayList();
                    this.tooltip.add(new TranslatableComponent("celestialexploration.spaceship.travel.mars"));
                    if (travelCap.getMarsCooldown().isCooldownEnded()) {
                        this.tooltip.add(travelTooltip);
                    } else {
                        this.tooltip.add(new TextComponent(new TranslatableComponent("celestialexploration.spaceship.travel.cooldown").getString() + travelCap.getMarsCooldown().getFormattedCooldown()));
                    }
                    this.renderComponentTooltip(poseStack, this.tooltip, mouseX, mouseY);
                    this.hoveredDimension = CelestialDimensions.MARS;
                } else if (travelCap.hasBeenToJupiter() && isHovering(x - i + 75 + 56, y - j + 73 + 11, 9, 9, mouseX, mouseY)) {
                    tooltip = Lists.newArrayList();
                    this.tooltip.add(new TranslatableComponent("celestialexploration.spaceship.travel.jupiter"));
                    if (travelCap.getJupiterCooldown().isCooldownEnded()) {
                        this.tooltip.add(travelTooltip);
                    } else {
                        this.tooltip.add(new TextComponent(new TranslatableComponent("celestialexploration.spaceship.travel.cooldown").getString() + travelCap.getJupiterCooldown().getFormattedCooldown()));
                    }

                    this.renderComponentTooltip(poseStack, this.tooltip, mouseX, mouseY);
                    this.hoveredDimension = CelestialDimensions.JUPITER;
                } else {
                    this.hoveredDimension = null;
                }
            }
        }
    }
}