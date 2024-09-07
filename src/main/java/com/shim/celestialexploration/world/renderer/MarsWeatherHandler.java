package com.shim.celestialexploration.world.renderer;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.BufferBuilder;
import com.mojang.blaze3d.vertex.DefaultVertexFormat;
import com.mojang.blaze3d.vertex.Tesselator;
import com.mojang.blaze3d.vertex.VertexFormat;
import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestialexploration.config.CelestialCommonConfig;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.LightTexture;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.client.IWeatherRenderHandler;

import java.util.Random;

import static net.minecraft.client.renderer.LevelRenderer.getLightColor;

public class MarsWeatherHandler implements IWeatherRenderHandler {
    ResourceLocation DUST_LOCATION = new ResourceLocation(CelestialExploration.MODID,"textures/environment/dust.png");
    private final float[] rainSizeX = new float[1024];
    private final float[] rainSizeZ = new float[1024];

    MarsWeatherHandler() {
        for(int i = 0; i < 32; ++i) {
            for(int j = 0; j < 32; ++j) {
                float f = (float)(j - 16);
                float f1 = (float)(i - 16);
                float f2 = Mth.sqrt(f * f + f1 * f1);
                this.rainSizeX[i << 5 | j] = -f1 / f2;
                this.rainSizeZ[i << 5 | j] = f / f2;
            }
        }
    }

    @Override
    public void render(int ticks, float partialTick, ClientLevel level, Minecraft minecraft, LightTexture lightTexture, double camX, double camY, double camZ) {

        if (!CelestialCommonConfig.STORMS.get()) return;

        float f = level.getRainLevel(partialTick);
        if (!(f <= 0.0F)) {
            lightTexture.turnOnLightLayer();
            int i = Mth.floor(camX);
            int j = Mth.floor(camY);
            int k = Mth.floor(camZ);
            Tesselator tesselator = Tesselator.getInstance();
            BufferBuilder bufferbuilder = tesselator.getBuilder();
            RenderSystem.disableCull();
            RenderSystem.enableBlend();
            RenderSystem.defaultBlendFunc();
            RenderSystem.enableDepthTest();
            int l = Minecraft.useFancyGraphics() ? 8 : 3;
            RenderSystem.depthMask(Minecraft.useShaderTransparency());
            int i1 = -1;
            float f1 = (float)ticks + partialTick;
//            RenderSystem.setShader(GameRenderer::getParticleShader);
//            RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
            BlockPos.MutableBlockPos blockpos$mutableblockpos = new BlockPos.MutableBlockPos();
            for(int j1 = k - l; j1 <= k + l; ++j1) {
                for(int k1 = i - l; k1 <= i + l; ++k1) {

                    int l1 = (j1 - k + 16) * 32 + k1 - i + 16;
                    double d0 = (double)this.rainSizeX[l1] * 0.5D;
                    double d1 = (double)this.rainSizeZ[l1] * 0.5D;
                    blockpos$mutableblockpos.set((double)k1, camY, (double)j1);
//                    Biome biome = level.getBiome(blockpos$mutableblockpos).value();
//                    if (biome.getPrecipitation() != Biome.Precipitation.NONE) {
                        int i2 = level.getHeight(Heightmap.Types.MOTION_BLOCKING, k1, j1);
                        int j2 = j - l;
                        int k2 = j + l;
                        if (j2 < i2) { j2 = i2; }
                        if (k2 < i2) { k2 = i2; }
                        int l2 = Math.max(i2, j);
                        if (j2 != k2) {
                            Random random = new Random(((long) k1 * k1 * 3121 + k1 * 45238971L ^ (long) j1 * j1 * 418711 + j1 * 13761L));
                            blockpos$mutableblockpos.set(k1, j2, j1);
//                            if (biome.warmEnoughToRain(blockpos$mutableblockpos)) {
                                if (i1 != 0) {
                                    if (i1 >= 0) { tesselator.end(); }
                                    i1 = 0;
                                    RenderSystem.setShaderTexture(0, DUST_LOCATION);
                                    bufferbuilder.begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.PARTICLE);
                                }
                                int i3 = ticks + k1 * k1 * 3121 + k1 * 45238971 + j1 * j1 * 418711 + j1 * 13761 & 31;
                                float f2 = -((float)i3 + partialTick) / 32.0F * (3.0F + random.nextFloat());
                                double d2 = (double)k1 + 0.5D - camX;
                                double d4 = (double)j1 + 0.5D - camZ;
                                float f3 = (float)Math.sqrt(d2 * d2 + d4 * d4) / (float)l;
                                float f4 = ((1.0F - f3 * f3) * 0.5F + 0.5F) * f;
                                blockpos$mutableblockpos.set(k1, l2, j1);
                                int j3 = getLightColor(level, blockpos$mutableblockpos);
//                                bufferbuilder.vertex((double)k1 - camX - d0 + 0.5D, (double)k2 - camY, (double)j1 - camZ - d1 + 0.5D).uv(0.0F, (float)j2 * 0.25F + f2).color(1.0F, 1.0F, 1.0F, f4).uv2(j3).endVertex();
//                                bufferbuilder.vertex((double)k1 - camX + d0 + 0.5D, (double)k2 - camY, (double)j1 - camZ + d1 + 0.5D).uv(1.0F, (float)j2 * 0.25F + f2).color(1.0F, 1.0F, 1.0F, f4).uv2(j3).endVertex();
//                                bufferbuilder.vertex((double)k1 - camX + d0 + 0.5D, (double)j2 - camY, (double)j1 - camZ + d1 + 0.5D).uv(1.0F, (float)k2 * 0.25F + f2).color(1.0F, 1.0F, 1.0F, f4).uv2(j3).endVertex();
//                                bufferbuilder.vertex((double)k1 - camX - d0 + 0.5D, (double)j2 - camY, (double)j1 - camZ - d1 + 0.5D).uv(0.0F, (float)k2 * 0.25F + f2).color(1.0F, 1.0F, 1.0F, f4).uv2(j3).endVertex();
//                            }
                            if (i1 != 1) {
                                if (i1 >= 0) {
                                    tesselator.end();
                                }

                                i1 = 1;
                                RenderSystem.setShaderTexture(0, DUST_LOCATION);
                                bufferbuilder.begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.PARTICLE);
                            }

                            float f5 = -((float)(ticks & 511) + partialTick) / 512.0F;
                            float f6 = (float)(random.nextDouble() + (double)f1 * 0.01D * (double)((float)random.nextGaussian()));
                            float f7 = (float)(random.nextDouble() + (double)(f1 * (float)random.nextGaussian()) * 0.001D);
                            double d3 = (double)k1 + 0.5D - camX;
                            double d5 = (double)j1 + 0.5D - camZ;
                            float f8 = (float)Math.sqrt(d3 * d3 + d5 * d5) / (float)l;
                            float f9 = ((1.0F - f8 * f8) * 0.3F + 0.5F) * f;
                            blockpos$mutableblockpos.set(k1, l2, j1);
                            int k3 = getLightColor(level, blockpos$mutableblockpos);
                            int l3 = k3 >> 16 & '\uffff';
                            int i4 = k3 & '\uffff';
                            int j4 = (l3 * 3 + 240) / 4;
                            int k4 = (i4 * 3 + 240) / 4;
                            double d6 = 0.5D; //0.5D
                            bufferbuilder.vertex((double)k1 - camX - d0 + d6, (double)k2 - camY, (double)j1 - camZ - d1 + d6).uv(0.0F + f6, (float)j2 * 0.25F + f5 + f7).color(1.0F, 1.0F, 1.0F, f9).uv2(k4, j4).endVertex();
                            bufferbuilder.vertex((double)k1 - camX + d0 + d6, (double)k2 - camY, (double)j1 - camZ + d1 + d6).uv(1.0F + f6, (float)j2 * 0.25F + f5 + f7).color(1.0F, 1.0F, 1.0F, f9).uv2(k4, j4).endVertex();
//                            bufferbuilder.vertex((double)k1 - camX + d0 + d6, (double)j2 - camY, (double)j1 - camZ + d1 + d6).uv(1.0F + f6, (float)k2 * 0.25F + f5 + f7).color(1.0F, 1.0F, 1.0F, f9).uv2(k4, j4).endVertex();
//                            bufferbuilder.vertex((double)k1 - camX - d0 + d6, (double)j2 - camY, (double)j1 - camZ - d1 + d6).uv(0.0F + f6, (float)k2 * 0.25F + f5 + f7).color(1.0F, 1.0F, 1.0F, f9).uv2(k4, j4).endVertex();

//                            bufferbuilder.vertex((double)k1 - camX - d0 + 0.5D, (double)k2 - camY, (double)j1 - camZ - d1 + 0.5D).uv(0.0F, (float)j2 * 0.25F + f2).color(1.0F, 1.0F, 1.0F, f4).uv2(j3).endVertex();
//                            bufferbuilder.vertex((double)k1 - camX + d0 + 0.5D, (double)k2 - camY, (double)j1 - camZ + d1 + 0.5D).uv(1.0F, (float)j2 * 0.25F + f2).color(1.0F, 1.0F, 1.0F, f4).uv2(j3).endVertex();
                            bufferbuilder.vertex((double)k1 - camX + d0 + 0.5D, (double)j2 - camY, (double)j1 - camZ + d1 + 0.5D).uv(1.0F, (float)k2 * 0.25F + f2).color(1.0F, 1.0F, 1.0F, f4).uv2(j3).endVertex();
                            bufferbuilder.vertex((double)k1 - camX - d0 + 0.5D, (double)j2 - camY, (double)j1 - camZ - d1 + 0.5D).uv(0.0F, (float)k2 * 0.25F + f2).color(1.0F, 1.0F, 1.0F, f4).uv2(j3).endVertex();



                        }
//                    }
                }
            }
            if (i1 >= 0) { tesselator.end(); }
            RenderSystem.enableCull();
            RenderSystem.disableBlend();
            lightTexture.turnOffLightLayer();
        }
    }
}