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
public abstract class AbstractGlowLayer<T extends Entity> extends AzAutoGlowingLayer<T> {
    public AbstractGlowLayer() {
        super();
    }

    private static final RenderStateShard.ShaderStateShard SHADER_STATE = new RenderStateShard.ShaderStateShard(GameRenderer::getRendertypeEyesShader);
    private static final RenderStateShard.TransparencyStateShard TRANSPARENCY_STATE = new RenderStateShard.TransparencyStateShard("translucent_transparency", () -> {
        RenderSystem.enableBlend();
        RenderSystem.blendFunc(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE);
    }, () -> {
        RenderSystem.disableBlend();
        RenderSystem.defaultBlendFunc();
    });
    private static final RenderStateShard.WriteMaskStateShard WRITE_MASK = new RenderStateShard.WriteMaskStateShard(true, false);

    private static final Function<ResourceLocation, RenderType> SMART_GLOW = Util.memoize(texture -> {
        RenderStateShard.TextureStateShard textureState = new RenderStateShard.TextureStateShard(texture, false, false);
        return RenderType.create("smart_glow", DefaultVertexFormat.NEW_ENTITY, VertexFormat.Mode.QUADS, 256,
                false, true, RenderType.CompositeState.builder().setShaderState(SHADER_STATE).setTextureState(textureState)
                        .setTransparencyState(TRANSPARENCY_STATE).setWriteMaskState(WRITE_MASK).createCompositeState(false));
    });

    public abstract ResourceLocation getGlowTexture(T animatable);

    public RenderType getRenderType(T animatable) {
        return SMART_GLOW.apply(getGlowTexture(animatable));
    }

    @Override
    public void render(AzRendererPipelineContext<T> context) {

        T animatable = context.animatable();
        RenderType glowingType = this.getRenderType(animatable);
        int prevPackedLight = context.packedLight();
        AzRendererPipeline<T> renderPipeline = context.rendererPipeline();
        VertexConsumer prevVertexConsumer = context.vertexConsumer();
        if (context.renderType() != null) {
            RenderType prevRenderType = context.renderType();
            context.setPackedLight(0xF00000);
            context.setRenderType(glowingType);
            context.setVertexConsumer(context.multiBufferSource().getBuffer(glowingType));
            renderPipeline.reRender(context);
            context.setRenderType(prevRenderType);
            context.setPackedLight(prevPackedLight);
            context.setVertexConsumer(prevVertexConsumer);
        }

    }
}