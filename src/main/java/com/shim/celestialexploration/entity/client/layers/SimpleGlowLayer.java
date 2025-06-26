package com.shim.celestialexploration.entity.client.layers;

import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.DefaultVertexFormat;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.VertexFormat;
import com.shim.celestialexploration.util.CelestialUtil;
import mod.azure.azurelib.rewrite.render.AzRendererPipeline;
import mod.azure.azurelib.rewrite.render.AzRendererPipelineContext;
import mod.azure.azurelib.rewrite.render.layer.AzAutoGlowingLayer;
import net.minecraft.Util;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.client.renderer.RenderStateShard;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.function.Function;

@OnlyIn(Dist.CLIENT)
public class SimpleGlowLayer<T extends Entity> extends AbstractGlowLayer<T> {
    public SimpleGlowLayer() {
        super();
    }

    @Override
    public ResourceLocation getGlowTexture(T animatable) {
        String tex = animatable.getType().getRegistryName().getPath();
        return CelestialUtil.getModLoc("textures/entity/" + tex + "/" + tex + "_glow.png");
    }
}