package com.shim.celestialexploration.world.renderer;

import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.*;
import com.mojang.math.Matrix4f;
import com.mojang.math.Vector3f;
import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestiallib.api.world.renderer.AbstractSkyHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.FogRenderer;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.client.ISkyRenderHandler;

public class MercurySkyHandler extends AbstractSkyHandler {

    @Override
    public void render(int ticks, float partialTick, PoseStack poseStack, ClientLevel level, Minecraft minecraft) {
        RenderSystem.disableTexture();
        Vec3 vec3 = level.getSkyColor(minecraft.gameRenderer.getMainCamera().getPosition(), partialTick);
        float f10 = (float) vec3.x;
        float f = (float) vec3.y;
        float f1 = (float) vec3.z;
        FogRenderer.levelFogColor();
        BufferBuilder bufferbuilder = Tesselator.getInstance().getBuilder();
        RenderSystem.depthMask(false);
        RenderSystem.setShaderColor(f10, f, f1, 1.0F);
        RenderSystem.enableBlend();
        RenderSystem.defaultBlendFunc();
        float[] afloat = level.effects().getSunriseColor(level.getTimeOfDay(partialTick), partialTick);
        if (afloat != null) {
            RenderSystem.setShader(GameRenderer::getPositionColorShader);
            RenderSystem.disableTexture();
            RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
            poseStack.pushPose();
            poseStack.mulPose(Vector3f.XP.rotationDegrees(90.0F));
            float f2 = Mth.sin(level.getSunAngle(partialTick)) < 0.0F ? 180.0F : 0.0F;
            poseStack.mulPose(Vector3f.ZP.rotationDegrees(f2));
            poseStack.mulPose(Vector3f.ZP.rotationDegrees(90.0F));
            float f3 = afloat[0];
            float f4 = afloat[1];
            float f5 = afloat[2];
            Matrix4f matrix4f = poseStack.last().pose();
            bufferbuilder.begin(VertexFormat.Mode.TRIANGLE_FAN, DefaultVertexFormat.POSITION_COLOR);
            bufferbuilder.vertex(matrix4f, 0.0F, 100.0F, 0.0F).color(f3, f4, f5, afloat[3]).endVertex();
            int i = 16;

            for (int j = 0; j <= 16; ++j) {
                float f6 = (float) j * ((float) Math.PI * 2F) / 16.0F;
                float f7 = Mth.sin(f6);
                float f8 = Mth.cos(f6);
                bufferbuilder.vertex(matrix4f, f7 * 120.0F, f8 * 120.0F, -f8 * 40.0F * afloat[3]).color(afloat[0], afloat[1], afloat[2], 0.0F).endVertex();
            }

            bufferbuilder.end();
            BufferUploader.end(bufferbuilder);
            poseStack.popPose();
        }

        RenderSystem.enableTexture();
        RenderSystem.blendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);

        poseStack.scale(0.5F, 0.5F, 0.5F);
        poseStack.pushPose();

        renderSun(poseStack, level, partialTick, 0, 0, SUN_LOCATION, 25.0F);

//
//        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
//        poseStack.mulPose(Vector3f.YP.rotationDegrees(-90.0F));
//        poseStack.mulPose(Vector3f.XP.rotationDegrees(level.getTimeOfDay(partialTick) * 360.0F));
//
//        Matrix4f matrix4f1 = poseStack.last().pose();
//        float f12 = 55.0F; //30.0F
//        RenderSystem.setShader(GameRenderer::getPositionTexShader);
////        poseStack.scale(0.8F, 0.8F, 0.8F);
//        RenderSystem.setShaderTexture(0, SUN_LOCATION);
//        bufferbuilder.begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION_TEX);
//        bufferbuilder.vertex(matrix4f1, -f12, 100.0F, -f12).uv(0.0F, 0.0F).endVertex();
//        bufferbuilder.vertex(matrix4f1, f12, 100.0F, -f12).uv(1.0F, 0.0F).endVertex();
//        bufferbuilder.vertex(matrix4f1, f12, 100.0F, f12).uv(1.0F, 1.0F).endVertex();
//        bufferbuilder.vertex(matrix4f1, -f12, 100.0F, f12).uv(0.0F, 1.0F).endVertex();
//        bufferbuilder.end();
//        BufferUploader.end(bufferbuilder);

        poseStack.popPose();

        renderStars(poseStack, level, partialTick);
        RenderSystem.depthMask(true);
    }
}