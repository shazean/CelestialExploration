package com.shim.celestialexploration.world.renderer;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.BufferBuilder;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.Tesselator;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.FogRenderer;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.client.ISkyRenderHandler;

public class VenusSkyHandler implements ISkyRenderHandler {
    @Override
    public void render(int ticks, float partialTick, PoseStack poseStack, ClientLevel level, Minecraft minecraft) {
//        RenderSystem.disableTexture();
//        Vec3 vec3 = level.getSkyColor(minecraft.gameRenderer.getMainCamera().getPosition(), partialTick);
//        float f10 = (float) vec3.x;
//        float f = (float) vec3.y;
//        float f1 = (float) vec3.z;
//        FogRenderer.levelFogColor();
//        BufferBuilder bufferbuilder = Tesselator.getInstance().getBuilder();
//        RenderSystem.depthMask(false);
//        RenderSystem.setShaderColor(f10, f, f1, 1.0F);
//        RenderSystem.enableBlend();
//        RenderSystem.defaultBlendFunc();

    }
}
