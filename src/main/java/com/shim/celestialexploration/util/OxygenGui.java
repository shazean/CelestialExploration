package com.shim.celestialexploration.util;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestialexploration.capabilities.OxygenHandler;
import com.shim.celestialexploration.config.CelestialClientConfig;
import com.shim.celestialexploration.config.CelestialCommonConfig;
import com.shim.celestialexploration.entity.vehicle.Spaceship;
import com.shim.celestialexploration.registry.CelestialCapabilities;
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
public class OxygenGui extends ForgeIngameGui implements IIngameOverlay {

    public static final Minecraft MINECRAFT = CelestialExploration.PROXY.getMinecraft();
    public static final ResourceLocation GUI_ICONS_LOCATION = new ResourceLocation(CelestialExploration.MODID, "textures/gui/icons.png");
//    private int animationNum = 0;

    public OxygenGui() {
        super(MINECRAFT);
    }

    @Override
    public void render(ForgeIngameGui gui, PoseStack poseStack, float partialTick, int width, int height) {

        if (CelestialCommonConfig.OXYGEN_MECHANIC_ENABLED.get()) {
            if (!MINECRAFT.options.hideGui && (gui.shouldDrawSurvivalElements())) {
                gui.setupOverlayRenderState(true, false);
                Player player = MINECRAFT.player;

                OxygenHandler oxygenHandler = CelestialExploration.getCapability(player, CelestialCapabilities.OXYGEN_CAPABILITY);
                if (oxygenHandler != null) {
                    if (oxygenHandler.inLocationWithoutOxygen(player)) {
                        RenderSystem.setShaderTexture(0, GUI_ICONS_LOCATION);

                        this.renderOxygenData(oxygenHandler, poseStack, width, height);

                    }
                }
            }
        }
    }

    protected void renderOxygenData(OxygenHandler oxygenHandler, PoseStack poseStack, int width, int height) {

        int totalOxygen = oxygenHandler.getOxygen();
        int totalSeconds = totalOxygen / 20;
        int fullMinutes = totalSeconds / 60; //convert to seconds, then minutes
        int remainingSeconds = totalOxygen == 0 ? 0 : totalSeconds % 60; //should just be whatever's left over?


//            CelestialExploration.LOGGER.debug("rendering oxygen data. total ticks: {}, totalSeconds: {}, fullMinutes: {}, remainingSecs: {})", totalOxygen, (totalOxygen / 20), fullMinutes, remainingSeconds);
        //TODO allow multiple placements
        int displayOffset = CelestialClientConfig.OXYGEN_LOCATION.get() == CelestialClientConfig.OxygenDisplay.RIGHT ? 92 : -114;

        //display number of bubbles for each full minute
        for (int i = 0; i < fullMinutes; i++) {
            if (i <= 4) {
                blit(poseStack, width / 2 + displayOffset, height - 12 - (i * 12), 60, 0, 11, 11);
            } else {
                blit(poseStack, width / 2 + displayOffset + 12, height - 12 - ((i - 5) * 12), 60, 0, 11, 11);
            }
        }

        //display bubbles for remaining seconds
        //if over at least 1 full minute…
        if (fullMinutes >= 1 && remainingSeconds != 0) {
            int xOffset = fullMinutes > 4 ? 12 : 0;
            int yOffset = fullMinutes > 4 ? 5 : 0;
            if (remainingSeconds > 40) //display full size bubble
                blit(poseStack, width / 2 + displayOffset + xOffset, height - 12 - ((fullMinutes - yOffset) * 12), 60, 0, 11, 11);
            else if (remainingSeconds > 21) //display medium size bubble
                blit(poseStack, width / 2 + displayOffset + 1 + xOffset, height - 11 - ((fullMinutes - yOffset) * 12), 71, 0, 9, 9);
            else if (remainingSeconds > 1) //display small size bubble
                blit(poseStack, width / 2 + displayOffset + 2 + xOffset, height - 10 - ((fullMinutes - yOffset) * 12), 80, 0, 7, 7);
            else //display popped bubble
                blit(poseStack, width / 2 + displayOffset + 2 + xOffset, height - 11 - ((fullMinutes - yOffset) * 12), 87, 0, 9, 9);
        }

        //if oxygen is running out, aka less than a minute left
        if (fullMinutes == 0 && totalOxygen != 0) {
            int yOffset = 0;
            if (remainingSeconds < 45 && remainingSeconds % 2 == 1)
                yOffset = 13;
            if (remainingSeconds > 40) //display full size bubble
                blit(poseStack, width / 2 + displayOffset, height - 12, 60, yOffset, 11, 11);
            else if (remainingSeconds > 21) //display medium size bubble
                blit(poseStack, width / 2 + displayOffset + 1, height - 10, 71, yOffset, 9, 9);
            else if (remainingSeconds > 1) //display small size bubble
                blit(poseStack, width / 2 + displayOffset + 2, height - 9, 80, yOffset, 7, 7);
            else //display popped bubble
                blit(poseStack, width / 2 + displayOffset + 2, height - 10, 87, 0, 9, 9);
        }
    }
}
