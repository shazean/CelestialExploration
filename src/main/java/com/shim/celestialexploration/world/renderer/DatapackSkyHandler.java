package com.shim.celestialexploration.world.renderer;

import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.*;
import com.mojang.math.Matrix4f;
import com.mojang.math.Vector3f;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.FogRenderer;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.phys.Vec3;

import javax.annotation.Nullable;

public class DatapackSkyHandler extends AbstractSkyHandler {
    final String stars;
    final String milkyway;
    @Nullable final CelestialObject sun1;
    @Nullable final CelestialObject sun2;
    final String ringColor;
    @Nullable final CelestialObject moon1;
    @Nullable final CelestialObject moon2;
    @Nullable final CelestialObject moon3;
    @Nullable final CelestialObject moon4;

    public DatapackSkyHandler(String stars, String milkyway, @Nullable CelestialObject sun1, @Nullable CelestialObject sun2, String ringColor, @Nullable CelestialObject moon1, @Nullable CelestialObject moon2, @Nullable CelestialObject moon3, @Nullable CelestialObject moon4) {
        this.stars = stars;
        this.milkyway = milkyway;
        this.sun1 = sun1;
        this.sun2 = sun2;
        this.ringColor = ringColor;
        this.moon1 = moon1;
        this.moon2 = moon2;
        this.moon3 = moon3;
        this.moon4 = moon4;
    }

    @Override
    public void render(int ticks, float partialTick, PoseStack poseStack, ClientLevel level, Minecraft minecraft) {
        RenderSystem.disableTexture();
        Vec3 vec3 = level.getSkyColor(minecraft.gameRenderer.getMainCamera().getPosition(), partialTick);
        float x = (float) vec3.x;
        float y = (float) vec3.y;
        float z = (float) vec3.z;
        FogRenderer.levelFogColor();

        BufferBuilder bufferbuilder = Tesselator.getInstance().getBuilder();
        RenderSystem.depthMask(false);
        RenderSystem.setShaderColor(x, y, z, 1.0F);
        RenderSystem.enableBlend();
        RenderSystem.defaultBlendFunc();
        float[] sunriseColor = level.effects().getSunriseColor(level.getTimeOfDay(partialTick), partialTick);
        if (sunriseColor != null) {
            RenderSystem.setShader(GameRenderer::getPositionColorShader);
            RenderSystem.disableTexture();
            RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
            poseStack.pushPose();
            poseStack.mulPose(Vector3f.XP.rotationDegrees(90.0F));
            float f2 = Mth.sin(level.getSunAngle(partialTick)) < 0.0F ? 180.0F : 0.0F;
            poseStack.mulPose(Vector3f.ZP.rotationDegrees(f2));
            poseStack.mulPose(Vector3f.ZP.rotationDegrees(90.0F));
            float f3 = sunriseColor[0];
            float f4 = sunriseColor[1];
            float f5 = sunriseColor[2];
            Matrix4f matrix4f = poseStack.last().pose();
            bufferbuilder.begin(VertexFormat.Mode.TRIANGLE_FAN, DefaultVertexFormat.POSITION_COLOR);
            bufferbuilder.vertex(matrix4f, 0.0F, 100.0F, 0.0F).color(f3, f4, f5, sunriseColor[3]).endVertex();

            for (int j = 0; j <= 16; ++j) {
                float f6 = (float) j * ((float) Math.PI * 2F) / 16.0F;
                float f7 = Mth.sin(f6);
                float f8 = Mth.cos(f6);
                bufferbuilder.vertex(matrix4f, f7 * 120.0F, f8 * 120.0F, -f8 * 40.0F * sunriseColor[3]).color(sunriseColor[0], sunriseColor[1], sunriseColor[2], 0.0F).endVertex();
            }

            bufferbuilder.end();
            BufferUploader.end(bufferbuilder);
            poseStack.popPose();
        }

        RenderSystem.enableTexture();
        RenderSystem.blendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);

//        RenderSystem.depthMask(false);
//        RenderSystem.setShaderColor(x, y, z, 1.0F);
//        RenderSystem.enableBlend();
//        RenderSystem.defaultBlendFunc();
//        RenderSystem.enableTexture();
//        RenderSystem.blendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
//

        if (!stars.equalsIgnoreCase("none")) {
//            RenderSystem.depthMask(false);
//            RenderSystem.setShaderColor(x, y, z, 1.0F);
//            RenderSystem.enableBlend();
//            RenderSystem.defaultBlendFunc();
//            RenderSystem.enableTexture();
//            RenderSystem.blendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);

            if (stars.equalsIgnoreCase("always")) {

                renderStars(poseStack, level, partialTick, true);
            } else if (stars.equalsIgnoreCase("night")) {
                renderStars(poseStack, level, partialTick, false);
            }
        }
        if (!milkyway.equalsIgnoreCase("none")) {
            RenderSystem.depthMask(false);
            RenderSystem.setShaderColor(x, y, z, 1.0F);
            RenderSystem.enableBlend();
            RenderSystem.defaultBlendFunc();
            RenderSystem.enableTexture();
            RenderSystem.blendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);

            if (milkyway.equalsIgnoreCase("always")) {
                renderMilkyWay(poseStack, level, partialTick, true);
            } else if (milkyway.equalsIgnoreCase("night")) {
                renderMilkyWay(poseStack, level, partialTick, false);
            }
        }

        if (sun2 != null) {
            RenderSystem.depthMask(false);
            RenderSystem.setShaderColor(x, y, z, 1.0F);
            RenderSystem.enableBlend();
            RenderSystem.defaultBlendFunc();
            RenderSystem.enableTexture();
            RenderSystem.blendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);

            renderSun(poseStack, level, partialTick, 20.0F, 20.0F, sun2.texture(), sun2.size());
        }

        if (sun1 != null) {
            RenderSystem.depthMask(false);
            RenderSystem.setShaderColor(x, y, z, 1.0F);
            RenderSystem.enableBlend();
            RenderSystem.defaultBlendFunc();
            RenderSystem.enableTexture();
            RenderSystem.blendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);

            renderSun(poseStack, level, partialTick, 0.0F, 0.0F, sun1.texture(), sun1.size());
        }

        if (moon1 != null) {
            RenderSystem.depthMask(false);
            RenderSystem.setShaderColor(x, y, z, 1.0F);
            RenderSystem.enableBlend();
            RenderSystem.defaultBlendFunc();
            RenderSystem.enableTexture();
            RenderSystem.blendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);

//            poseStack.mulPose(Vector3f.XP.rotationDegrees(level.getTimeOfDay(partialTick) * 360.0F));
            renderMoon(poseStack, level, partialTick, 0.0F, 0.0F, moon1.texture(), moon1.size());
        }
        if (moon2 != null) {
            RenderSystem.depthMask(false);
            RenderSystem.setShaderColor(x, y, z, 1.0F);
            RenderSystem.enableBlend();
            RenderSystem.defaultBlendFunc();
            RenderSystem.enableTexture();
            RenderSystem.blendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
            renderMoon(poseStack, level, partialTick, 10.0F, 10.0F, moon2.texture(), moon2.size());
        }
        if (moon3 != null) {
            RenderSystem.depthMask(false);
            RenderSystem.setShaderColor(x, y, z, 1.0F);
            RenderSystem.enableBlend();
            RenderSystem.defaultBlendFunc();
            RenderSystem.enableTexture();
            RenderSystem.blendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
            renderMoon(poseStack, level, partialTick, -20.0F, -20.0F, moon3.texture(), moon3.size());
        }
        if (moon4 != null) {
            RenderSystem.depthMask(false);
            RenderSystem.setShaderColor(x, y, z, 1.0F);
            RenderSystem.enableBlend();
            RenderSystem.defaultBlendFunc();
            RenderSystem.enableTexture();
            RenderSystem.blendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);

            renderMoon(poseStack, level, partialTick, 30.0F, -30.0F, moon4.texture(), moon4.size());
        }
        if (ringColor != null) {
            //TODO color overlay for rings?

            RenderSystem.disableBlend();

            renderRings(poseStack, level, partialTick, this.ringColor);
        }
    }

    public record CelestialObject(ResourceLocation texture, float size) {}
}
