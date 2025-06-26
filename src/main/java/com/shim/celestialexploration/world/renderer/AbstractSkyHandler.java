package com.shim.celestialexploration.world.renderer;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.*;
import com.mojang.math.Matrix4f;
import com.mojang.math.Vector3f;
import com.shim.celestialexploration.CelestialExploration;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.client.ISkyRenderHandler;

import java.awt.*;
import java.util.Random;

public abstract class AbstractSkyHandler implements ISkyRenderHandler {
    protected static final ResourceLocation STAR_LOCATION = new ResourceLocation(CelestialExploration.MODID, "textures/environment/stars.png");
    protected static final ResourceLocation SUN_LOCATION = new ResourceLocation(CelestialExploration.MODID, "textures/environment/sun.png");
    protected static final ResourceLocation VANILLA_SUN_LOCATION = new ResourceLocation("textures/environment/sun.png");
    protected static final ResourceLocation MILKY_WAY_LOCATION = new ResourceLocation(CelestialExploration.MODID, "textures/environment/milky_way.png");
    protected static final ResourceLocation RINGS_LOCATION = new ResourceLocation(CelestialExploration.MODID, "textures/environment/rings.png");

    protected void renderStars(PoseStack poseStack, ClientLevel level, float partialTick) {
        renderStars(poseStack, level, partialTick, true);
    }

    protected void renderSun(PoseStack poseStack, ClientLevel level, float partialTick, float xRotation, float zRotation, ResourceLocation sun, float size) {
        poseStack.pushPose();
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        poseStack.mulPose(Vector3f.YP.rotationDegrees(-90.0F));
        poseStack.mulPose(Vector3f.XP.rotationDegrees(level.getTimeOfDay(partialTick) * 360.0F));
        poseStack.mulPose(Vector3f.XP.rotationDegrees(xRotation));
        poseStack.mulPose(Vector3f.ZP.rotationDegrees(zRotation));


        Matrix4f matrix4f1 = poseStack.last().pose();
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderTexture(0, sun);
        Tesselator tesselator = Tesselator.getInstance();
        BufferBuilder bufferbuilder = tesselator.getBuilder();

        bufferbuilder.begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION_TEX);
        bufferbuilder.vertex(matrix4f1, -size, 100.0F, -size).uv(0.0F, 0.0F).endVertex();
        bufferbuilder.vertex(matrix4f1, size, 100.0F, -size).uv(1.0F, 0.0F).endVertex();
        bufferbuilder.vertex(matrix4f1, size, 100.0F, size).uv(1.0F, 1.0F).endVertex();
        bufferbuilder.vertex(matrix4f1, -size, 100.0F, size).uv(0.0F, 1.0F).endVertex();
        bufferbuilder.end();
        BufferUploader.end(bufferbuilder);
        poseStack.popPose();
    }

    protected void renderStars(PoseStack p_109781_, ClientLevel level, float partialTick, boolean displayDuringDay) {
        RenderSystem.depthMask(false);
        RenderSystem.setShader(GameRenderer::getPositionTexColorShader);

        if (!displayDuringDay) {
            float f9 = level.getStarBrightness(partialTick) * 2.0F;
            RenderSystem.setShaderColor(f9, f9, f9, f9);
        } else {
            RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        }

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

            int color = 150; //100;

            bufferbuilder.begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION_TEX_COLOR);
            bufferbuilder.vertex(matrix4f, -100.0F, -100.0F, -100.0F).uv(0.0F, 0.0F).color(color, color, color, 255).endVertex();
            bufferbuilder.vertex(matrix4f, -100.0F, -100.0F, 100.0F).uv(0.0F, 2.0F).color(color, color, color, 255).endVertex();
            bufferbuilder.vertex(matrix4f, 100.0F, -100.0F, 100.0F).uv(2.0F, 2.0F).color(color, color, color, 255).endVertex();
            bufferbuilder.vertex(matrix4f, 100.0F, -100.0F, -100.0F).uv(2.0F, 0.0F).color(color, color, color, 255).endVertex();
            tesselator.end();
            p_109781_.popPose();
        }

        RenderSystem.depthMask(true);
        RenderSystem.enableTexture();
        RenderSystem.disableBlend();
    }

    protected void renderMoon(PoseStack poseStack, ClientLevel level, float partialTick, float xRotation, float zRotation, ResourceLocation moonTexture) {
        renderMoon(poseStack, level, partialTick, xRotation, zRotation, moonTexture, 18.0F);
    }

    protected void renderMoon(PoseStack poseStack, ClientLevel level, float partialTick, float xRotation, float zRotation, ResourceLocation moonTexture, float size) {
        poseStack.pushPose();
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        Tesselator tesselator = Tesselator.getInstance();
        BufferBuilder bufferbuilder = tesselator.getBuilder();
        Matrix4f matrix4f = poseStack.last().pose();

//        Vec3 vec3 = level.getSkyColor(minecraft.gameRenderer.getMainCamera().getPosition(), partialTick);
//        float x = (float) vec3.x;
//        float y = (float) vec3.y;
//        float z = (float) vec3.z;
//
//        RenderSystem.depthMask(false);
//        RenderSystem.setShaderColor(x, y, z, 1.0F);
//        RenderSystem.enableBlend();
//        RenderSystem.defaultBlendFunc();


        poseStack.mulPose(Vector3f.YP.rotationDegrees(-90.0F));
        poseStack.mulPose(Vector3f.XP.rotationDegrees(level.getTimeOfDay(partialTick) * 360.0F));
        float xRot = level.getTimeOfDay(partialTick) * 360.0F / 180.F;
//        if (xRot > 360.0F) xRot = xRot - 360.0F;
//        poseStack.mulPose(Vector3f.XP.rotationDegrees(xRot));
        poseStack.mulPose(Vector3f.XP.rotationDegrees(xRotation));
        poseStack.mulPose(Vector3f.ZP.rotationDegrees(zRotation));

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

    protected void renderMilkyWay(PoseStack poseStack, ClientLevel level, float partialTick, boolean displayDuringDay) {
        RenderSystem.depthMask(false);
        RenderSystem.setShader(GameRenderer::getPositionTexColorShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);

        if (!displayDuringDay) {
            float f9 = level.getStarBrightness(partialTick) * 2.0F;
            RenderSystem.setShaderColor(f9, f9, f9, f9);
        }

        RenderSystem.setShaderTexture(0, MILKY_WAY_LOCATION);
        Tesselator tesselator = Tesselator.getInstance();
        BufferBuilder bufferbuilder = tesselator.getBuilder();

        for(int i = 0; i < 9; ++i) {
            poseStack.pushPose();

            poseStack.mulPose(Vector3f.ZP.rotationDegrees(30.0F));

            switch (i) {
                case 0: poseStack.mulPose(Vector3f.XP.rotationDegrees(45.0F));
                case 1: poseStack.mulPose(Vector3f.XP.rotationDegrees(45.0F));
                case 2: poseStack.mulPose(Vector3f.XP.rotationDegrees(45.0F));
                case 3: poseStack.mulPose(Vector3f.XP.rotationDegrees(45.0F));
                case 4: poseStack.mulPose(Vector3f.XP.rotationDegrees(45.0F));
                case 5: poseStack.mulPose(Vector3f.XP.rotationDegrees(45.0F));
                case 6: poseStack.mulPose(Vector3f.XP.rotationDegrees(45.0F));
                case 7: poseStack.mulPose(Vector3f.XP.rotationDegrees(45.0F));
                case 8: poseStack.mulPose(Vector3f.XP.rotationDegrees(45.0F));
            }

            float scale = 42.0F;
            int color = 180;
            int opacity = 80;

            int k = i;
//            int l = k % 4;
            int i1 = i % 8; //k / 4 % 2;
            float f13 = (float) (i);// / 4.0F;
            float f14 = (float) (i1) / 8.0F;//2.0F;
            float f15 = (float) (i + 1);// / 4.0F;
            float f16 = (float) (i1 + 1) / 8.0F;//2.0F;

            float f = 1.0F / 9.0F;

            Matrix4f matrix4f = poseStack.last().pose();
            bufferbuilder.begin(VertexFormat.Mode.TRIANGLE_FAN, DefaultVertexFormat.POSITION_TEX_COLOR); //DefaultVertexFormat.POSITION_TEX_COLOR);
            bufferbuilder.vertex(matrix4f, -scale, -100.0F, scale).uv(f15, f16).color(color, color, color, opacity).endVertex();
            bufferbuilder.vertex(matrix4f, scale, -100.0F, scale).uv(f13, f16).color(color, color, color, opacity).endVertex();
            bufferbuilder.vertex(matrix4f, scale, -100.0F, -scale).uv(f13, f14).color(color, color, color, opacity).endVertex();
            bufferbuilder.vertex(matrix4f, -scale, -100.0F, -scale).uv(f15, f14).color(color, color, color, opacity).endVertex();
            tesselator.end();
            poseStack.popPose();
        }

        RenderSystem.depthMask(true);
        RenderSystem.enableTexture();
        RenderSystem.disableBlend();
    }

    protected void renderRings(PoseStack poseStack, ClientLevel level, float partialTick, String hexColor) {
        RenderSystem.depthMask(false);
        RenderSystem.setShader(GameRenderer::getPositionTexColorShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.enableBlend();
        RenderSystem.defaultBlendFunc();

        RenderSystem.setShaderTexture(0, RINGS_LOCATION);
        Tesselator tesselator = Tesselator.getInstance();
        BufferBuilder bufferbuilder = tesselator.getBuilder();

        for(int i = 0; i < 9; ++i) {
            poseStack.pushPose();

            poseStack.mulPose(Vector3f.ZP.rotationDegrees(-55.0F));

            switch (i) {
                case 0:
                    poseStack.mulPose(Vector3f.XP.rotationDegrees(45.0F));
                case 1: poseStack.mulPose(Vector3f.XP.rotationDegrees(45.0F));
                case 2: poseStack.mulPose(Vector3f.XP.rotationDegrees(45.0F));
                case 3: poseStack.mulPose(Vector3f.XP.rotationDegrees(45.0F));
                case 4: poseStack.mulPose(Vector3f.XP.rotationDegrees(45.0F));
                case 5: poseStack.mulPose(Vector3f.XP.rotationDegrees(45.0F));
                case 6: poseStack.mulPose(Vector3f.XP.rotationDegrees(45.0F));
                case 7: poseStack.mulPose(Vector3f.XP.rotationDegrees(45.0F));
                case 8: poseStack.mulPose(Vector3f.XP.rotationDegrees(45.0F));
            }

            Color color = Color.decode(hexColor);

            float scale = 42.0F;
            int r = color.getRed();
            int g = color.getGreen();
            int b = color.getBlue();
            int opacity = 255;

            Matrix4f matrix4f = poseStack.last().pose();
            bufferbuilder.begin(VertexFormat.Mode.TRIANGLE_FAN, DefaultVertexFormat.POSITION_TEX_COLOR);
            bufferbuilder.vertex(matrix4f, -scale, -100.0F, scale).uv(0.0F, 0.0F).color(r, g, b, opacity).endVertex();
            bufferbuilder.vertex(matrix4f, scale, -100.0F, scale).uv(1.0F, 0.0F).color(r, g, b, opacity).endVertex();
            bufferbuilder.vertex(matrix4f, scale, -100.0F, -scale).uv(1.0F, 1.0F).color(r, g, b, opacity).endVertex();
            bufferbuilder.vertex(matrix4f, -scale, -100.0F, -scale).uv(0.0F, 1.0F).color(r, g, b, opacity).endVertex();
            tesselator.end();
            poseStack.popPose();
        }

        RenderSystem.depthMask(true);
        RenderSystem.enableTexture();
        RenderSystem.disableBlend();
    }

}
