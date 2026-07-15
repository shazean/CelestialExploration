package com.shim.celestialexploration.util;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestialexploration.config.CelestialClientConfig;
import com.shim.celestialexploration.entity.vehicle.Spaceship;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.gui.ForgeIngameGui;
import net.minecraftforge.client.gui.IIngameOverlay;

@OnlyIn(Dist.CLIENT)
public class SpaceshipGui extends ForgeIngameGui implements IIngameOverlay {

    public static final Minecraft MINECRAFT = CelestialExploration.PROXY.getMinecraft();
    public static final ResourceLocation GUI_ICONS_LOCATION = new ResourceLocation(CelestialExploration.MODID, "textures/gui/icons.png");
//    private int animationNum = 0;

    public SpaceshipGui() {
        super(MINECRAFT);
    }

    @Override
    public void render(ForgeIngameGui gui, PoseStack poseStack, float partialTick, int width, int height) {

        if (!MINECRAFT.options.hideGui && (gui.shouldDrawSurvivalElements() || CelestialClientConfig.HUD_IN_CREATIVE.get())) {
            gui.setupOverlayRenderState(true, false);
            Player player = MINECRAFT.player;
            Entity mount = player.getVehicle();
            if (!(mount instanceof Spaceship)) return;

            RenderSystem.setShaderTexture(0, GUI_ICONS_LOCATION);

            this.renderSpaceshipData((Spaceship) mount, poseStack, width, height);
        }
    }

    protected void renderSpaceshipData(Spaceship spaceship, PoseStack poseStack, int width, int height) {
        int fuel = spaceship.getFuelDataId();
        int maxFuel = 8000 * 4;
        double fuelPercent = (double) fuel / (double) maxFuel;
        int altitude = (int) spaceship.position().y;
        String xz = (int) spaceship.position().x() + "/" + (int) spaceship.position().z();
        float maxSpeed = spaceship.getMaxSpeedAllowed();
        double speed = spaceship.getDisplaySpeed() - 0.015F;

        if (spaceship.shouldBeSprinting()) speed += 0.015F;
        else speed = Math.min(speed, 0.985F);

        Level level = spaceship.getLevel();

        int xAdjustment;
        int yAdjustment;

        switch (CelestialClientConfig.HUD_LOCATION.get()) {
            case TOP_RIGHT -> {
                xAdjustment = width - 12 - 14;
                yAdjustment = 12;
            }
            case TOP_LEFT -> {
                xAdjustment = 12 + 45;
                yAdjustment = 12;
            }
            case BOTTOM_RIGHT -> {
                xAdjustment = width - 12;
                yAdjustment = height - 12 - 45 - 6;
            }
            case BOTTOM_LEFT -> {
                xAdjustment = 12 + 45;
                yAdjustment = height - 12 - 45 - 6;
            }
            default -> {
                xAdjustment = width - 12;
                yAdjustment = 12;
            }
        }

        //placement, X; placement Y, grab starting at, X; grab starting at, Y; width?; height?;

        //SPEEDOMETER
        blit(poseStack, xAdjustment - 45, yAdjustment, 0, 19, 45, 45); //SPEEDOMETER BASE

        double x = Math.floor((speed + 0.03) * 10.0) / 10 * 130; //130

        blit(poseStack, xAdjustment - 45 + 13, yAdjustment + 21 - 21 + 12, 0, 79 + (int) x, 19, 13);  //SPEEDOMETER NEEDLE


        //FUEL LEVEL
        blit(poseStack, xAdjustment - 45, yAdjustment + 45 + 1, 0, 19 + 45, 45, 7);  //EMPTY BAR
        if (spaceship.getControllingPassenger() instanceof Player player && player.isCreative()) {
            blit(poseStack, xAdjustment - 45, yAdjustment + 45 + 1, 0, 19 + 45 + 8, (int) ((double) 45), 7);  //FUEL BAR
        } else {
            blit(poseStack, xAdjustment - 45, yAdjustment + 45 + 1, 0, 19 + 45 + 8, (int) ((double) 45 * fuelPercent), 7);  //FUEL BAR
         }

        //ALTIMETER LIGHTS
        int heightInThirds = (level.getMaxBuildHeight() + Math.abs(level.getMinBuildHeight())) / 3;
        if (altitude > level.getMaxBuildHeight()) {
            blit(poseStack, xAdjustment - 45 + 22 + 10, yAdjustment + 21 + 1 + 9, 46, 22 + 16 + 12,3, 7);
        } else if (altitude > (heightInThirds * 2) + level.getMinBuildHeight()) {
            blit(poseStack, xAdjustment - 45 + 22 + 10, yAdjustment + 21 + 1 + 9 + 2, 46, 22 + 16 + 12 + 2,3, 5);
        } else if (altitude > heightInThirds + level.getMinBuildHeight()) {
            blit(poseStack, xAdjustment - 45 + 22 + 10, yAdjustment + 21 + 1 + 9 + 4, 46, 22 + 16 + 12 + 4,3, 3);
        } else if (altitude > level.getMinBuildHeight()) {
            blit(poseStack, xAdjustment - 45 + 22 + 10, yAdjustment + 21 + 1 + 9 + 6, 46, 22 + 16 + 12 + 6,3, 1);
        }

        MINECRAFT.font.draw(poseStack, String.valueOf(altitude), xAdjustment - 34, yAdjustment + 31, 0xffffff); //ALTITUDE READOUT

    }
}