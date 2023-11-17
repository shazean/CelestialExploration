package com.shim.celestialexploration.util;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestialexploration.entity.Shuttle;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.gui.ForgeIngameGui;
import net.minecraftforge.client.gui.IIngameOverlay;

@OnlyIn(Dist.CLIENT)
public class ShuttleGui extends ForgeIngameGui implements IIngameOverlay {

    public static final Minecraft MINECRAFT = Minecraft.getInstance();
    public static final ResourceLocation GUI_ICONS_LOCATION = new ResourceLocation(CelestialExploration.MODID, "textures/gui/icons.png");
//    private int animationNum = 0;

    public ShuttleGui() {
        super(MINECRAFT);
    }

    @Override
    public void render(ForgeIngameGui gui, PoseStack poseStack, float partialTick, int width, int height) {

        if (!MINECRAFT.options.hideGui && gui.shouldDrawSurvivalElements()) {
            gui.setupOverlayRenderState(true, false);
            Player player = MINECRAFT.player;
            Entity mount = player.getVehicle();
            if (!(mount instanceof Shuttle)) return;

            RenderSystem.setShaderTexture(0, GUI_ICONS_LOCATION);

            this.renderShuttleData((Shuttle) mount, poseStack, width, height);
        }
    }

    protected void renderShuttleData(Shuttle shuttle, PoseStack poseStack, int width, int height) {
        int fuel = shuttle.getFuel();
        int maxFuel = 8000 * 4;
        double fuelPercent = (double) fuel / (double) maxFuel;
        int altitude = (int) shuttle.position().y;
        float maxSpeed = shuttle.getMaxSpeed();
        double speed = shuttle.getCurrentSpeed();
        Level level = shuttle.getLevel();

        //placement, X; placement Y, grab starting at, X; grab starting at, Y; width?; height?;
        blit(poseStack, width - 12 - 45, 12, 0, 19,45, 45); //SPEEDOMETER BASE

        //SPEED
        if (speed == 0) {
            blit(poseStack, width - 12 - 45 + 11, 12 + 21, 46, 22,12, 4);  //NO MOVEMENT
        } else if (!shuttle.hasFuel()) {
            blit(poseStack, width - 12 - 45 + 11, 12 + 21 - 3, 46, 22 + 4,12, 4); //NO FUEL, LOW SPEED
        } else if (shuttle.hasLowFuel()) {
            blit(poseStack, width - 12 - 45 + 22, 12 + 21 - 9, 46 + 2, 22 + 8,10, 8); //LOW FUEL, MEDIUM SPEED
        } else {
            blit(poseStack, width - 12 - 45 + 22, 12 + 21, 46, 22 + 16,12, 4); //HAS FUEL, FULL SPEED
        }

        //FUEL LEVEL
        blit(poseStack, width - 12 - 45, 12 + 45 + 1, 0, 19 + 45, 45, 7);  //EMPTY BAR
        blit(poseStack, width - 12 - 45, 12 + 45 + 1, 0, 19 + 45 + 8, (int) ((double) 45 * fuelPercent), 7);  //EMPTY BAR

        //ALTIMETER LIGHTS
        int heightInThirds = (level.getMaxBuildHeight() + Math.abs(level.getMinBuildHeight())) / 3;
        if (altitude > level.getMaxBuildHeight()) {
            blit(poseStack, width - 12 - 45 + 22 + 10, 12 + 21 + 1 + 9, 46, 22 + 16 + 12,3, 7);
        } else if (altitude > (heightInThirds * 2) + level.getMinBuildHeight()) {
            blit(poseStack, width - 12 - 45 + 22 + 10, 12 + 21 + 1 + 9 + 2, 46, 22 + 16 + 12 + 2,3, 5);
        } else if (altitude > heightInThirds + level.getMinBuildHeight()) {
            blit(poseStack, width - 12 - 45 + 22 + 10, 12 + 21 + 1 + 9 + 4, 46, 22 + 16 + 12 + 4,3, 3);
        } else if (altitude > level.getMinBuildHeight()) {
            blit(poseStack, width - 12 - 45 + 22 + 10, 12 + 21 + 1 + 9 + 6, 46, 22 + 16 + 12 + 6,3, 1);
        }

        MINECRAFT.font.draw(poseStack, String.valueOf(altitude), width - 12 - 34, 12 + 31, 0xffffff); //ALTITUDE READOUT
    }
}