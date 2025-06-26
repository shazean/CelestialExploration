package com.shim.celestialexploration.inventory.screens;

import com.google.common.collect.Lists;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestialexploration.capabilities.TaxiCapability;
import com.shim.celestialexploration.inventory.menus.SpaceTaxiMenu;
import com.shim.celestialexploration.registry.CelestialDimensions;
import com.shim.celestialexploration.registry.CelestialTags;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec2;

import javax.annotation.Nullable;
import java.util.List;

public class SpaceTaxiScreen extends AbstractContainerScreen<SpaceTaxiMenu> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(CelestialExploration.MODID, "textures/gui/space_taxi.png");
    private List<Component> tooltip = Lists.newArrayList();
    private boolean isFirstEntitySelected = false;
    Vec2 firstEntityLoc;
    Entity firstEntity;
    private boolean isSecondEntitySelected = false;
    Vec2 secondEntityLoc;
    Entity secondEntity;
    private boolean isLocationSelected = false;
    Vec2 location;

    public SpaceTaxiScreen(SpaceTaxiMenu menu, Inventory playerInventory, Component title) {
        super(menu, playerInventory, title);
        this.imageWidth = 276;
        this.inventoryLabelX = 107;
    }

    @Override
    protected void renderBg(PoseStack poseStack, float partialTick, int mouseX, int mouseY) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, TEXTURE);

        int x = (this.width - this.imageWidth) / 2;
        int y = (this.height - this.imageHeight) / 2;

        //placement, X; placement Y, grab starting at, X; grab starting at, Y; width; height
        blit(poseStack, x, y, this.getBlitOffset(), 0.0F, 0.0F, this.imageWidth, this.imageHeight, 512, 256);

        if (isFirstEntitySelected && firstEntityLoc != null) {
            blit(poseStack, x + (int) firstEntityLoc.x - 1, y + (int) firstEntityLoc.y - 1, this.getBlitOffset(), this.imageWidth + 1, 64, 18, 18, 512, 256);
        }
        if (isSecondEntitySelected && secondEntityLoc != null) {
            blit(poseStack, x + (int) secondEntityLoc.x - 1, y + (int) secondEntityLoc.y - 1, this.getBlitOffset(), this.imageWidth + 1, 64 + 19, 18, 18, 512, 256);
        }

        if (isLocationSelected && location != null) {
            blit(poseStack, x + (int) location.x - 1, y + (int) location.y - 1, this.getBlitOffset(), this.imageWidth + 1, 64, 18, 18, 512, 256);
        }

//        CelestialExploration.LOGGER.debug("menu.hasEmeralds: " + this.menu.hasEmeralds());
        if (isFirstEntitySelected && isLocationSelected && this.menu.hasEmeralds()) {
            blit(poseStack, x + 213, y + 64 - 19 - 4, this.getBlitOffset(), this.imageWidth + 1, 64 - 19, 18, 18, 512, 256);
        }

        for (int i = 0; i < Math.min(this.menu.getNearbyEntites().size(), 20); i++) {
            Entity entity = this.menu.getNearbyEntites().get(i);
            int yPos;
            if (i < 5) yPos = 0;
            else if (i < 10) yPos = 18;
            else if (i < 15) yPos = 36;
            else yPos = 54;

            int xPos;
            if (i % 5 == 0) xPos = 0;
            else if (i % 5 == 1) xPos = 18;
            else if (i % 5 == 2) xPos = 36;
            else if (i % 5 == 3) xPos = 54;
            else xPos = 72;

            if (entity instanceof Villager) {
                blit(poseStack, x + 12 + xPos, y + 22 + yPos, this.getBlitOffset(), this.imageWidth + 1, 28 + 9, 8, 8, 512, 256);
            } else if (entity.getType().is(CelestialTags.Entities.FARM_ANIMALS)) {
                blit(poseStack, x + 12 + xPos, y + 22 + yPos, this.getBlitOffset(), this.imageWidth + 10, 28 + 9, 8, 8, 512, 256);
            } else if (entity instanceof Mob) {
                blit(poseStack, x + 12 + xPos, y + 22 + yPos, this.getBlitOffset(), this.imageWidth + 10 + 18, 28 + 9, 8, 8, 512, 256);
            } else {
                blit(poseStack, x + 12 + xPos, y + 22 + yPos, this.getBlitOffset(), this.imageWidth + 19, 28 + 9, 8, 8, 512, 256);
            }
        }

        for (int i = 0; i < Math.min(this.menu.getTaxiStations().size(), 20); i++) {
            ResourceKey<Level> dimension = this.menu.getTaxiStations().get(i).dimension();
            int yPos;
            if (i < 5) yPos = 0;
            else if (i < 10) yPos = 18;
            else if (i < 15) yPos = 36;
            else yPos = 54;

            int xPos;
            if (i % 5 == 0) xPos = 0;
            else if (i % 5 == 1) xPos = 18;
            else if (i % 5 == 2) xPos = 36;
            else if (i % 5 == 3) xPos = 54;
            else xPos = 72;

            int dimOffset;
            if (dimension.equals(CelestialDimensions.MERCURY)) dimOffset = 0;
            else if (dimension.equals(CelestialDimensions.VENUS)) dimOffset = 9;
            else if (dimension.equals(Level.OVERWORLD)) dimOffset = 18;
            else if (dimension.equals(CelestialDimensions.MOON)) dimOffset = 27;
            else if (dimension.equals(CelestialDimensions.MARS)) dimOffset = 36;
            else if (dimension.equals(CelestialDimensions.JUPITER)) dimOffset = 45;
            else dimOffset = 81;

            blit(poseStack, x + 12 + xPos, y + 110 + yPos, this.getBlitOffset(), this.imageWidth + 1 + dimOffset, 27 + 1, 8, 8, 512, 256);
        }
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


        for (int k = 0; k < Math.min(this.menu.getNearbyEntites().size(), 20); k++) {
            Entity entity = this.menu.getNearbyEntites().get(k);

            int yPos;
            if (k < 5) yPos = 0;
            else if (k < 10) yPos = 18;
            else if (k < 15) yPos = 36;
            else yPos = 54;

            int xPos;
            if (k % 5 == 0) xPos = 0;
            else if (k % 5 == 1) xPos = 18;
            else if (k % 5 == 2) xPos = 36;
            else if (k % 5 == 3) xPos = 54;
            else xPos = 72;

            if (isHovering(x - i + 12 + xPos - 4, y - j + 22 + yPos - 4, 16, 16, mouseX, mouseY)) {
                renderHighlight(poseStack, i + 12 + xPos - 4, j + 22 + yPos - 4, 16, 16, this.getBlitOffset(), slotColor, slotColor);
                tooltip = Lists.newArrayList();
                if (entity instanceof Villager villager) {
                    if (villager.getName().getString().equalsIgnoreCase(getTypeName(villager).getString())) {
                        this.tooltip.add(new TextComponent(villager.getName().getString()));
                    } else {
                        this.tooltip.add(new TextComponent(villager.getName().getString() + " (" + getTypeName(villager).getString() + ")"));
                    }
                    this.tooltip.add(new TextComponent("Lvl: " + villager.getVillagerData().getLevel()));
                } else {
                    this.tooltip.add(entity.getDisplayName());
                }
                this.tooltip.add(new TextComponent("XYZ: " + entity.getBlockX() + " / " + entity.getBlockY() + " / " + entity.getBlockZ()));
                this.renderComponentTooltip(poseStack, this.tooltip, mouseX, mouseY);
            }
        }

        for (int k = 0; k < Math.min(this.menu.getTaxiStations().size(), 15); k++) {
            String dimension = this.menu.getTaxiStations().get(k).dimension().location().getPath();
            int yPos;
            if (k < 5) yPos = 0;
            else if (k < 10) yPos = 18;
            else yPos = 36;

            int xPos;
            if (k % 5 == 0) xPos = 0;
            else if (k % 5 == 1) xPos = 18;
            else if (k % 5 == 2) xPos = 36;
            else if (k % 5 == 3) xPos = 54;
            else xPos = 72;

            if (isHovering(x - i + 12 + xPos - 4, y - j + 110 + yPos - 4, 16, 16, mouseX, mouseY)) {
                renderHighlight(poseStack, i + 12 + xPos - 4, j + 110 + yPos - 4, 16, 16, this.getBlitOffset(), slotColor, slotColor);
                tooltip = Lists.newArrayList();
                tooltip.add(this.menu.getTaxiStations().get(k).name());
                BlockPos pos = this.menu.getTaxiStations().get(k).pos();
                tooltip.add(new TextComponent("XYZ: " + pos.getX() + " / " + pos.getY() + " / " + pos.getZ()));
                tooltip.add(new TranslatableComponent("dimension.celestialexploration." + dimension));
                this.renderComponentTooltip(poseStack, this.tooltip, mouseX, mouseY);

            }
        }

        if (isHovering(x - i + 213, y - j + 41, 16, 16, mouseX, mouseY)) {
            tooltip = Lists.newArrayList();
            tooltip.add(new TranslatableComponent("entity.spacetaxi.sendoff"));
            this.renderComponentTooltip(poseStack, this.tooltip, mouseX, mouseY);
        }
    }

    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int p_97777_) {
        if (checkEntityClicked(mouseX, mouseY, false)) return true;
        else if (checkLocationClicked(mouseX, mouseY, false)) return true;
        else if (checkSendOffButton(mouseX, mouseY)) return true;
        return super.mouseClicked(mouseX, mouseY, p_97777_);
    }

    @Override
    public boolean mouseReleased(double mouseX, double mouseY, int p_97814_) {
        if (checkEntityClicked(mouseX, mouseY, true)) return true;
        else if (checkLocationClicked(mouseX, mouseY, true)) return true;
        else if (checkSendOffButton(mouseX, mouseY)) {
            CelestialExploration.LOGGER.debug("clicked and released button");
            this.menu.setButtonClicked();
            return true;
        }
        return super.mouseReleased(mouseX, mouseY, p_97814_);
    }

    private boolean checkEntityClicked(double mouseX, double mouseY, boolean isClickReleased) {
        Slot slot = this.findSlot(mouseX, mouseY);
        if (slot != null) return false;
        int x = (width - imageWidth) / 2;
        int y = (height - imageHeight) / 2;

        int i = this.leftPos;
        int j = this.topPos;

        for (int k = 0; k < Math.min(this.menu.getNearbyEntites().size(), 20); k++) {
            Entity entity = this.menu.getNearbyEntites().get(k);

            int yPos;
            if (k < 5) yPos = 0;
            else if (k < 10) yPos = 18;
            else if (k < 15) yPos = 36;
            else yPos = 54;

            int xPos;
            if (k % 5 == 0) xPos = 0;
            else if (k % 5 == 1) xPos = 18;
            else if (k % 5 == 2) xPos = 36;
            else if (k % 5 == 3) xPos = 54;
            else xPos = 72;

            if (isHovering(x - i + 12 + xPos - 4, y - j + 22 + yPos - 4, 16, 16, mouseX, mouseY)) {
                if (isClickReleased) {
                    toggleEntitySelection(x - i + 12 + xPos - 4, y - j + 22 + yPos - 4, entity);
                }

                return true;
            }
        }
        return false;
    }

    private void toggleEntitySelection(double x, double y, Entity entity) {
        if (!isFirstEntitySelected) {
            isFirstEntitySelected = true;
            firstEntityLoc = new Vec2((float) x, (float) y);
            firstEntity = entity;
            this.menu.setSelectedEntity(entity, 1);
        } else if (x == firstEntityLoc.x && y == firstEntityLoc.y) { //toggle first entity
            isFirstEntitySelected = false;
            firstEntityLoc = null;
            if (isSecondEntitySelected) { //shift second entity into first entity
                isFirstEntitySelected = true;
                isSecondEntitySelected = false;
                firstEntityLoc = secondEntityLoc;
                secondEntityLoc = null;
                firstEntity = secondEntity;
                secondEntity = null;
                this.menu.setSelectedEntity(entity, 1);
            }
        } else if (!isSecondEntitySelected) {
            isSecondEntitySelected = true;
            secondEntityLoc = new Vec2((float) x, (float) y);
            secondEntity = entity;
            this.menu.setSelectedEntity(entity, 2);
        } else if (x == secondEntityLoc.x && y == secondEntityLoc.y) {
            isSecondEntitySelected = false;
            secondEntityLoc = null;
            secondEntity = null;
        }
    }

    private boolean checkLocationClicked(double mouseX, double mouseY, boolean isClickReleased) {
        Slot slot = this.findSlot(mouseX, mouseY);
        if (slot != null) return false;

        int x = (width - imageWidth) / 2;
        int y = (height - imageHeight) / 2;

        int i = this.leftPos;
        int j = this.topPos;

        for (int k = 0; k < Math.min(this.menu.getTaxiStations().size(), 20); k++) {
            TaxiCapability.TaxiStationData station = this.menu.getTaxiStations().get(k);

            int yPos;
            if (k < 5) yPos = 0;
            else if (k < 10) yPos = 18;
            else if (k < 15) yPos = 36;
            else yPos = 54;

            int xPos;
            if (k % 5 == 0) xPos = 0;
            else if (k % 5 == 1) xPos = 18;
            else if (k % 5 == 2) xPos = 36;
            else if (k % 5 == 3) xPos = 54;
            else xPos = 72;

            if (isHovering(x - i + 12 + xPos - 4, y - j + 110 + yPos - 4, 16, 16, mouseX, mouseY)) {
                if (isClickReleased) {
                    toggleLocationSelection(x - i + 12 + xPos - 4, y - j + 110 + yPos - 4, station);
                }

                return true;
            }
        }
        return false;
    }

    private void toggleLocationSelection(double x, double y, TaxiCapability.TaxiStationData station) {
        if (!isLocationSelected) {
            isLocationSelected = true;
            location = new Vec2((float) x, (float) y);
            this.menu.setSelectedLocation(station);
        } else {
            isLocationSelected = false;
            location = null;
        }
    }

    private boolean checkSendOffButton(double mouseX, double mouseY) {
        int x = (width - imageWidth) / 2;
        int y = (height - imageHeight) / 2;

        int i = this.leftPos;
        int j = this.topPos;

        if (isFirstEntitySelected && isLocationSelected && this.menu.hasEmeralds())
            return isHovering(x - i + 213, y - j + 41, 16, 16, mouseX, mouseY);

        return false;
    }

    @Nullable
    private Slot findSlot(double x, double y) {
        for (int i = 0; i < this.menu.slots.size(); ++i) {
            Slot slot = this.menu.slots.get(i);
            if (this.isHovering(slot, x, y) && slot.isActive()) {
                return slot;
            }
        }
        return null;
    }

    private boolean isHovering(Slot slot, double x, double y) {
        return this.isHovering(slot.x, slot.y, 16, 16, x, y);
    }

    protected static Component getTypeName(Villager villager) {
        ResourceLocation profName = villager.getVillagerData().getProfession().getRegistryName();
        return new TranslatableComponent(villager.getType().getDescriptionId() + '.' + (!"minecraft".equals(profName.getNamespace()) ? profName.getNamespace() + '.' : "") + profName.getPath());
    }

    public static void renderHighlight(PoseStack poseStack, int pX, int pY, int width, int height, int pBlitOffset, int slotColor, int slotColor2) {
        RenderSystem.disableDepthTest();
        RenderSystem.colorMask(true, true, true, false);
        fillGradient(poseStack, pX, pY, pX + width, pY + height, slotColor, slotColor2, pBlitOffset);
        RenderSystem.colorMask(true, true, true, true);
        RenderSystem.enableDepthTest();
    }
}