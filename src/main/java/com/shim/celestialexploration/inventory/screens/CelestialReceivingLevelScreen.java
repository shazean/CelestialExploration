package com.shim.celestialexploration.inventory.screens;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.*;
import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestialexploration.registry.CelestialDimensions;
import com.shim.celestialexploration.util.CelestialUtil;
import net.minecraft.Util;
import net.minecraft.client.gui.chat.NarratorChatListener;
import net.minecraft.client.gui.screens.ReceivingLevelScreen;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.Resource;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.HashMap;
import java.util.Map;

@OnlyIn(Dist.CLIENT)
public class CelestialReceivingLevelScreen extends ReceivingLevelScreen {
    private static final Component DOWNLOADING_TERRAIN_TEXT = new TranslatableComponent("multiplayer.downloadingTerrain");
    private static final long CHUNK_LOADING_START_WAIT_LIMIT_MS = 2000L;
    private boolean loadingPacketsReceived = false;
    private boolean oneTickSkipped = false;
    private final long createdAt = System.currentTimeMillis();
    private final ResourceKey<Level> dimension;
    private static final Map<ResourceKey<Level>, ResourceLocation> BG_LOCATIONS = Util.make(new HashMap<>(), (map) -> {
       map.put(CelestialDimensions.MILKY_WAY, textureLoc("milky_way"));
       map.put(CelestialDimensions.MOON, textureLoc("moon"));
       map.put(Level.OVERWORLD, new ResourceLocation("textures/gui/options_background.png"));

    });

    public CelestialReceivingLevelScreen(ResourceKey<Level> destinationDimension) {
        super();
        this.dimension = destinationDimension;
    }

    private static ResourceLocation textureLoc(String texture) {
        return new ResourceLocation(CelestialExploration.MODID, "textures/gui/background/" + texture + ".png");
    }

    private static ResourceLocation getTexture(ResourceKey<Level> dimension) {
        ResourceLocation texture = BG_LOCATIONS.get(dimension);
        if (texture != null) return texture;
        else return BACKGROUND_LOCATION;
    }

    public boolean shouldCloseOnEsc() {
        return false;
    }

    public void render(PoseStack poseStack, int p_96531_, int p_96532_, float p_96533_) {
        this.renderBackground(0);
        drawCenteredString(poseStack, this.font, DOWNLOADING_TERRAIN_TEXT, this.width / 2, this.height / 2 - 50, 16777215);
        super.render(poseStack, p_96531_, p_96532_, p_96533_);
    }

    public void tick() {
        boolean flag = this.oneTickSkipped || System.currentTimeMillis() > this.createdAt + 2000L;
        if (flag && this.minecraft != null && this.minecraft.player != null) {
            BlockPos blockpos = this.minecraft.player.blockPosition();
            boolean flag1 = this.minecraft.level != null && this.minecraft.level.isOutsideBuildHeight(blockpos.getY());
            if (flag1 || this.minecraft.levelRenderer.isChunkCompiled(blockpos)) {
                this.onClose();
            }

            if (this.loadingPacketsReceived) {
                this.oneTickSkipped = true;
            }
        }
    }

    public void renderBackground(int partialTick) {
        Tesselator tesselator = Tesselator.getInstance();
        BufferBuilder bufferbuilder = tesselator.getBuilder();
        RenderSystem.setShader(GameRenderer::getPositionTexColorShader);

        RenderSystem.setShaderTexture(0, getTexture(this.dimension));
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        float f = 32.0F;
        bufferbuilder.begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION_TEX_COLOR);
        bufferbuilder.vertex(0.0D, (double)this.height, 0.0D).uv(0.0F, (float)this.height / 32.0F + (float)partialTick).color(64, 64, 64, 255).endVertex();
        bufferbuilder.vertex((double)this.width, (double)this.height, 0.0D).uv((float)this.width / 32.0F, (float)this.height / 32.0F + (float)partialTick).color(64, 64, 64, 255).endVertex();
        bufferbuilder.vertex((double)this.width, 0.0D, 0.0D).uv((float)this.width / 32.0F, (float)partialTick).color(64, 64, 64, 255).endVertex();
        bufferbuilder.vertex(0.0D, 0.0D, 0.0D).uv(0.0F, (float)partialTick).color(64, 64, 64, 255).endVertex();
        tesselator.end();
        net.minecraftforge.common.MinecraftForge.EVENT_BUS.post(new net.minecraftforge.client.event.ScreenEvent.BackgroundDrawnEvent(this, new PoseStack()));
    }

    public void loadingPacketsReceived() {
        this.loadingPacketsReceived = true;
    }

    public boolean isPauseScreen() {
        return false;
    }
}
