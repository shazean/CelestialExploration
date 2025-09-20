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

public class CallistoSkyHandler extends AbstractSkyHandler {
    ResourceLocation JUPITER_LOCATION = new ResourceLocation(CelestialExploration.MODID, "textures/environment/jupiter_phases.png");
    ResourceLocation IO_LOCATION = new ResourceLocation(CelestialExploration.MODID, "textures/environment/io_phases.png");
    ResourceLocation EUROPA_LOCATION = new ResourceLocation(CelestialExploration.MODID, "textures/environment/europa_phases.png");
    ResourceLocation GANYMEDE_LOCATION = new ResourceLocation(CelestialExploration.MODID, "textures/environment/ganymede_phases.png");

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

        poseStack.pushPose();
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);

        renderSun(poseStack, level, partialTick, 0, 0, SUN_LOCATION, 25.0F);
        renderMoon(poseStack, level, partialTick, 0, 0, JUPITER_LOCATION, 60.0F);

        poseStack.mulPose(Vector3f.ZP.rotationDegrees(-30.0F));
        poseStack.mulPose(Vector3f.XP.rotationDegrees(20.0F));

        renderMoon(poseStack, level, partialTick, 0.0F, 0.0F, IO_LOCATION);
        renderMoon(poseStack, level, partialTick, 10.0F, 10.0F, EUROPA_LOCATION);
        renderMoon(poseStack, level, partialTick, 5.0F, -80.0F, GANYMEDE_LOCATION);

        poseStack.popPose();

        renderStars(poseStack, level, partialTick);
        RenderSystem.depthMask(true);
    }
}