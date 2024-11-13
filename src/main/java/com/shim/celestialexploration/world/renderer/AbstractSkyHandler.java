package com.shim.celestialexploration.world.renderer;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.*;
import com.mojang.math.Matrix4f;
import com.mojang.math.Vector3f;
import com.shim.celestialexploration.CelestialExploration;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.ISkyRenderHandler;

public abstract class AbstractSkyHandler implements ISkyRenderHandler {
    ResourceLocation STAR_LOCATION = new ResourceLocation(CelestialExploration.MODID, "textures/environment/stars.png");
    ResourceLocation SUN_LOCATION = new ResourceLocation(CelestialExploration.MODID, "textures/environment/sun.png");
    ResourceLocation VANILLA_SUN_LOCATION = new ResourceLocation("textures/environment/sun.png");


    protected void renderStars(PoseStack p_109781_, ClientLevel level, float partialTick) {
        RenderSystem.depthMask(false);
        RenderSystem.setShader(GameRenderer::getPositionTexColorShader);
//        float f9 = level.getStarBrightness(partialTick) * 2.0F;
//        RenderSystem.setShaderColor(f9, f9, f9, f9);

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
