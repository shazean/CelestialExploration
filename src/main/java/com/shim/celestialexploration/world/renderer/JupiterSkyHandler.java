package com.shim.celestialexploration.world.renderer;

import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.*;
import com.mojang.math.Matrix4f;
import com.mojang.math.Vector3f;
import com.shim.celestialexploration.CelestialExploration;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.FogRenderer;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.client.ISkyRenderHandler;

public class JupiterSkyHandler implements ISkyRenderHandler {
    ResourceLocation VANILLA_SUN_LOCATION = new ResourceLocation("textures/environment/sun.png");
//    ResourceLocation FADED_SUN_LOCATION = new ResourceLocation(CelestialExploration.MODID, "textures/environment/faded_sun.png");
    ResourceLocation EUROPA_LOCATION = new ResourceLocation(CelestialExploration.MODID, "textures/environment/europa_phases.png");
    ResourceLocation IO_LOCATION = new ResourceLocation(CelestialExploration.MODID, "textures/environment/io_phases.png");
    ResourceLocation CALLISTO_LOCATION = new ResourceLocation(CelestialExploration.MODID, "textures/environment/callisto_phases.png");
    ResourceLocation GANYMEDE_LOCATION = new ResourceLocation(CelestialExploration.MODID, "textures/environment/ganymede_phases.png");
    ResourceLocation STAR_LOCATION = new ResourceLocation(CelestialExploration.MODID, "textures/environment/stars.png");

    @Override
    public void render(int ticks, float partialTick, PoseStack poseStack, ClientLevel level, Minecraft minecraft) {
        RenderSystem.disableTexture();
        Vec3 vec3 = level.getSkyColor(minecraft.gameRenderer.getMainCamera().getPosition(), partialTick);
        float x = (float) vec3.x;
        float y = (float) vec3.y;
        float z = (float) vec3.z;
        FogRenderer.levelFogColor();

//        FogRenderer.setupFog(minecraft.gameRenderer.getMainCamera(), FogRenderer.FogMode.FOG_SKY, minecraft.gameRenderer.getRenderDistance() - 3, level.isRaining(), partialTick);

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
            int i = 16;

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


        poseStack.pushPose();
        if (level.isRaining()) {
            RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 0.3F);
        } else {
            RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 0.5F);
        }
        poseStack.mulPose(Vector3f.YP.rotationDegrees(-90.0F));
        poseStack.mulPose(Vector3f.XP.rotationDegrees(level.getTimeOfDay(partialTick) * 360.0F));
        Matrix4f matrix4f1 = poseStack.last().pose();
        float f12 = 30.0F;
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderTexture(0, VANILLA_SUN_LOCATION);
        bufferbuilder.begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION_TEX);
        bufferbuilder.vertex(matrix4f1, -f12, 100.0F, -f12).uv(0.0F, 0.0F).endVertex();
        bufferbuilder.vertex(matrix4f1, f12, 100.0F, -f12).uv(1.0F, 0.0F).endVertex();
        bufferbuilder.vertex(matrix4f1, f12, 100.0F, f12).uv(1.0F, 1.0F).endVertex();
        bufferbuilder.vertex(matrix4f1, -f12, 100.0F, f12).uv(0.0F, 1.0F).endVertex();
        bufferbuilder.end();
        BufferUploader.end(bufferbuilder);


        renderMoon(poseStack, level, partialTick, 0.0F, 0.0F, EUROPA_LOCATION);
        renderMoon(poseStack, level, partialTick, 10.0F, 10.0F, IO_LOCATION);
        renderMoon(poseStack, level, partialTick, -20.0F, 20.0F, CALLISTO_LOCATION);
        renderMoon(poseStack, level, partialTick, 30.0F, -30.0F, GANYMEDE_LOCATION);

//        poseStack.pushPose();
//        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
//        RenderSystem.setShader(GameRenderer::getPositionTexShader);
//
//        poseStack.mulPose(Vector3f.XP.rotationDegrees(level.getTimeOfDay(partialTick) * 360.0F));
//
//        f12 = 18.0F;
//        RenderSystem.setShaderTexture(0, EUROPA_LOCATION);
//        int k = level.getMoonPhase();
//        int l = k % 4;
//        int i1 = k / 4 % 2;
//        float f13 = (float) (l) / 4.0F;
//        float f14 = (float) (i1) / 2.0F;
//        float f15 = (float) (l + 1) / 4.0F;
//        float f16 = (float) (i1 + 1) / 2.0F;
//        bufferbuilder.begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION_TEX);
//        bufferbuilder.vertex(matrix4f1, -f12, -100.0F, f12).uv(f15, f16).endVertex();
//        bufferbuilder.vertex(matrix4f1, f12, -100.0F, f12).uv(f13, f16).endVertex();
//        bufferbuilder.vertex(matrix4f1, f12, -100.0F, -f12).uv(f13, f14).endVertex();
//        bufferbuilder.vertex(matrix4f1, -f12, -100.0F, -f12).uv(f15, f14).endVertex();
//        bufferbuilder.end();
//        BufferUploader.end(bufferbuilder);
//
//        poseStack.popPose();

//        poseStack.pushPose();
//        poseStack.mulPose(Vector3f.XP.rotationDegrees(level.getTimeOfDay(partialTick) * 360.0F - 10.0F));
//
//        RenderSystem.setShaderTexture(0, IO_LOCATION);
//        k = level.getMoonPhase();
//        l = k % 4;
//        i1 = k / 4 % 2;
//        f13 = (float) (l) / 4.0F;
//        f14 = (float) (i1) / 2.0F;
//        f15 = (float) (l + 1) / 4.0F;
//        f16 = (float) (i1 + 1) / 2.0F;
//        bufferbuilder.begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION_TEX);
//        bufferbuilder.vertex(matrix4f1, -f12, -100.0F, f12).uv(f15, f16).endVertex();
//        bufferbuilder.vertex(matrix4f1, f12, -100.0F, f12).uv(f13, f16).endVertex();
//        bufferbuilder.vertex(matrix4f1, f12, -100.0F, -f12).uv(f13, f14).endVertex();
//        bufferbuilder.vertex(matrix4f1, -f12, -100.0F, -f12).uv(f15, f14).endVertex();
//        bufferbuilder.end();
//        BufferUploader.end(bufferbuilder);
//
//        poseStack.popPose();

//        poseStack.pushPose();
//        poseStack.mulPose(Vector3f.XP.rotationDegrees(level.getTimeOfDay(partialTick) * 360.0F - 5.0F));
//
//
//        RenderSystem.setShaderTexture(0, CALLISTO_LOCATION);
//        k = level.getMoonPhase();
//        l = k % 4;
//        i1 = k / 4 % 2;
//        f13 = (float) (l) / 4.0F;
//        f14 = (float) (i1) / 2.0F;
//        f15 = (float) (l + 1) / 4.0F;
//        f16 = (float) (i1 + 1) / 2.0F;
//        bufferbuilder.begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION_TEX);
//        bufferbuilder.vertex(matrix4f1, -f12, -100.0F, f12).uv(f15, f16).endVertex();
//        bufferbuilder.vertex(matrix4f1, f12, -100.0F, f12).uv(f13, f16).endVertex();
//        bufferbuilder.vertex(matrix4f1, f12, -100.0F, -f12).uv(f13, f14).endVertex();
//        bufferbuilder.vertex(matrix4f1, -f12, -100.0F, -f12).uv(f15, f14).endVertex();
//        bufferbuilder.end();
//        BufferUploader.end(bufferbuilder);
//
//        poseStack.popPose();
//
//        poseStack.pushPose();
//        poseStack.mulPose(Vector3f.XP.rotationDegrees(level.getTimeOfDay(partialTick) * 360.0F - 7.0F));
//        poseStack.mulPose(Vector3f.ZP.rotationDegrees(-10.0F));
//
//        RenderSystem.setShaderTexture(0, GANYMEDE_LOCATION);
//        k = level.getMoonPhase() + 7;
//        l = k % 4;
//        i1 = k / 4 % 2;
//        f13 = (float) (l) / 4.0F;
//        f14 = (float) (i1) / 2.0F;
//        f15 = (float) (l + 1) / 4.0F;
//        f16 = (float) (i1 + 1) / 2.0F;
//        bufferbuilder.begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION_TEX);
//        bufferbuilder.vertex(matrix4f1, -f12, -100.0F, f12).uv(f15, f16).endVertex();
//        bufferbuilder.vertex(matrix4f1, f12, -100.0F, f12).uv(f13, f16).endVertex();
//        bufferbuilder.vertex(matrix4f1, f12, -100.0F, -f12).uv(f13, f14).endVertex();
//        bufferbuilder.vertex(matrix4f1, -f12, -100.0F, -f12).uv(f15, f14).endVertex();
//
//        bufferbuilder.end();
//        BufferUploader.end(bufferbuilder);
//
//        poseStack.popPose();

        poseStack.popPose();

        renderStars(poseStack, level, partialTick);
        RenderSystem.depthMask(true);
    }

    private void renderMoon(PoseStack poseStack, ClientLevel level, float partialTick, float xRotation, float zRotation, ResourceLocation moonTexture) {
        poseStack.pushPose();
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        Tesselator tesselator = Tesselator.getInstance();
        BufferBuilder bufferbuilder = tesselator.getBuilder();
        Matrix4f matrix4f = poseStack.last().pose();

        poseStack.mulPose(Vector3f.ZP.rotationDegrees(zRotation));

        float xRot = level.getTimeOfDay(partialTick) * 360.0F / 180.F;
//        if (xRot > 360.0F) xRot = xRot - 360.0F;
        poseStack.mulPose(Vector3f.XP.rotationDegrees(xRot));
        poseStack.mulPose(Vector3f.XP.rotationDegrees(xRotation));

        float size = 18.0F;
        RenderSystem.setShaderTexture(0, moonTexture);
        int k = level.getMoonPhase();
        int l = k % 4;
        int i1 = k / 4 % 2;
        float f13 = (float) (l) / 4.0F;
        float f14 = (float) (i1) / 2.0F;
        float f15 = (float) (l + 1) / 4.0F;
        float f16 = (float) (i1 + 1) / 2.0F;
        bufferbuilder.begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION_TEX);
        bufferbuilder.vertex(matrix4f, -size, -100.0F, size).uv(f15, f16).endVertex();
        bufferbuilder.vertex(matrix4f, size, -100.0F, size).uv(f13, f16).endVertex();
        bufferbuilder.vertex(matrix4f, size, -100.0F, -size).uv(f13, f14).endVertex();
        bufferbuilder.vertex(matrix4f, -size, -100.0F, -size).uv(f15, f14).endVertex();
        bufferbuilder.end();
        BufferUploader.end(bufferbuilder);

        poseStack.popPose();
    }

    private void renderStars(PoseStack p_109781_, ClientLevel level, float partialTick) {
        RenderSystem.depthMask(false);
        RenderSystem.setShader(GameRenderer::getPositionTexColorShader);
        float f9 = level.getStarBrightness(partialTick) * 2.0F;
        RenderSystem.setShaderColor(f9, f9, f9, f9);

        RenderSystem.setShaderTexture(0, STAR_LOCATION);
        Tesselator tesselator = Tesselator.getInstance();
        BufferBuilder bufferbuilder = tesselator.getBuilder();

        for(int i = 0; i < 6; ++i) {
            p_109781_.pushPose();
            if (i == 1) {
                p_109781_.mulPose(Vector3f.XP.rotationDegrees(90.0F));
            }

            if (i == 2) {
                p_109781_.mulPose(Vector3f.XP.rotationDegrees(-90.0F));
            }

            if (i == 3) {
                p_109781_.mulPose(Vector3f.XP.rotationDegrees(180.0F));
            }

            if (i == 4) {
                p_109781_.mulPose(Vector3f.ZP.rotationDegrees(90.0F));
            }

            if (i == 5) {
                p_109781_.mulPose(Vector3f.ZP.rotationDegrees(-90.0F));
            }

            Matrix4f matrix4f = p_109781_.last().pose();
            bufferbuilder.begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION_TEX_COLOR);
            bufferbuilder.vertex(matrix4f, -100.0F, -100.0F, -100.0F).uv(0.0F, 0.0F).color(100, 100, 100, 255).endVertex();
            bufferbuilder.vertex(matrix4f, -100.0F, -100.0F, 100.0F).uv(0.0F, 2.0F).color(100, 100, 100, 255).endVertex();
            bufferbuilder.vertex(matrix4f, 100.0F, -100.0F, 100.0F).uv(2.0F, 2.0F).color(100, 100, 100, 255).endVertex();
            bufferbuilder.vertex(matrix4f, 100.0F, -100.0F, -100.0F).uv(2.0F, 0.0F).color(100, 100, 100, 255).endVertex();
            tesselator.end();
            p_109781_.popPose();
        }

        RenderSystem.depthMask(true);
        RenderSystem.enableTexture();
        RenderSystem.disableBlend();
    }
}