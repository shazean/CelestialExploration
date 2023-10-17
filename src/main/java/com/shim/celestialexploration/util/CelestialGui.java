package com.shim.celestialexploration.util;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestialexploration.entity.Shuttle;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.gui.ForgeIngameGui;
import net.minecraftforge.client.gui.IIngameOverlay;
import net.minecraftforge.client.gui.OverlayRegistry;

@OnlyIn(Dist.CLIENT)
public class CelestialGui extends ForgeIngameGui implements IIngameOverlay {

    public static final Minecraft MINECRAFT = Minecraft.getInstance();
    public static final ResourceLocation GUI_ICONS_LOCATION = new ResourceLocation(CelestialExploration.MODID, "textures/gui/icons.png");

    public CelestialGui() {
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

            if (((Shuttle) mount).isTeleportHeight()) {
                this.renderShuttleTeleportData((Shuttle) mount, poseStack, width, height);
            }
        }
//        if (!MINECRAFT.options.hideGui) {
//            gui.setupOverlayRenderState(true, false);
//            Player player = MINECRAFT.player;
//            Entity mount = player.getVehicle();
//            if (!(mount instanceof Shuttle)) return;
//
//            RenderSystem.setShaderTexture(0, GUI_ICONS_LOCATION);
//
//            this.renderShuttlePosition((Shuttle) mount, poseStack, width, height);
//        }
    }

//    protected void renderShuttleFuel(Shuttle shuttle, PoseStack poseStack, int width, int height) {
//        int fuel = shuttle.getFuel();
//        int maxFuel = 16000;
//
//        double fuelPercent = (double) fuel / (double) maxFuel;
//
//
//        String fuelReadout = "Fuel: " + fuel + "/" + maxFuel + "mb";
//
//        //placement, X; placement Y, grab starting at, X; grab starting at, Y; width?; height?;
////       MINECRAFT.font.draw(poseStack, fuelReadout, width + 46 - (MINECRAFT.font.width(fuelReadout) / 2), height - 50, 1118481);
//        MINECRAFT.font.draw(poseStack, fuelReadout, 15, 15, 1118481);
//
//        //TODO change to icons instead of text?
////        blit(poseStack, width + 34, width - 26, (int) (56 * fuelPercent), 0,56 - (int) (56 * fuelPercent), 16);
////        blit(poseStack, width + 34, width - 26, 0, 16,56, 16); //the outlines part of the texture
//
//    }
//
//    protected void renderShuttlePosition(Shuttle shuttle, PoseStack poseStack, int width, int height) {
//        int altitude = (int) shuttle.position().y;
//
//        String fuelReadout = "Altitude: " + altitude;
//
//        //placement, X; placement Y, grab starting at, X; grab starting at, Y; width?; height?;
//        MINECRAFT.font.draw(poseStack, fuelReadout, 15, 30, 1118481);
//
//
//    }

    protected void renderShuttleData(Shuttle shuttle, PoseStack poseStack, int width, int height) {
        int fuel = shuttle.getFuel();
        int maxFuel = 16000;
        double fuelPercent = (double) fuel / (double) maxFuel;
        int altitude = (int) shuttle.position().y;
        float speed = shuttle.getCurrentSpeed();

        String fuelReadout = "Fuel: " + fuel + "/" + maxFuel + "mb";
        String altitudeReadout = "Altitude: " + altitude;
        String speedReadout = "Speed: " + speed;

        //placement, X; placement Y, grab starting at, X; grab starting at, Y; width?; height?;
        MINECRAFT.font.draw(poseStack, fuelReadout, 12, 12, 1118481); //FUEL READOUT
        MINECRAFT.font.draw(poseStack, altitudeReadout, 12, 24, 1118481); //ALTITUDE READOUT
        MINECRAFT.font.draw(poseStack, speedReadout, 12, 36, 1118481); //SPEED READOUT

    }

    protected void renderShuttleTeleportData(Shuttle shuttle, PoseStack poseStack, int width, int height) {
        int teleportationCooldown = shuttle.getTelportationCooldown();

        String teleportationReadout = "Teleport height reached!";
        String cooldownReadout = "Teleportation cooldown: " + teleportationCooldown / 60 + "seconds (" + teleportationCooldown + " ticks)" ;

        //placement, X; placement Y, grab starting at, X; grab starting at, Y; width?; height?;
        MINECRAFT.font.draw(poseStack, teleportationReadout, 12, 48, 1118481); //FUEL READOUT
        MINECRAFT.font.draw(poseStack, cooldownReadout, 12, 60, 1118481); //ALTITUDE READOUT

    }
}