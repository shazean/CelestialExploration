package com.shim.celestialexploration.entity.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestialexploration.entity.client.layers.VoidCrawlerEyesLayer;
import com.shim.celestialexploration.entity.mob.VoidCrawler;
import net.minecraft.client.model.SpiderModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class VoidCrawlerRenderer extends MobRenderer<VoidCrawler, SpiderModel<VoidCrawler>> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(CelestialExploration.MODID, "textures/entity/spiderlike/void_crawler.png");

    public VoidCrawlerRenderer(EntityRendererProvider.Context p_174401_) {
        this(p_174401_, ModelLayers.CAVE_SPIDER);
    }

    public VoidCrawlerRenderer(EntityRendererProvider.Context context, ModelLayerLocation model) {
        super(context, new SpiderModel<>(context.bakeLayer(model)), 0.8F);
        this.addLayer(new VoidCrawlerEyesLayer<>(this));
        this.shadowRadius *= 0.7F;
    }

    @Override
    public void render(VoidCrawler crawler, float p_115456_, float p_115457_, PoseStack poseStack, MultiBufferSource p_115459_, int p_115460_) {
        super.render(crawler, p_115456_, p_115457_, poseStack, p_115459_, p_115460_);
        this.scale(crawler, poseStack, p_115457_);
    }

    protected void scale(VoidCrawler p_113974_, PoseStack p_113975_, float p_113976_) {
        p_113975_.scale(0.7F, 0.7F, 0.7F);
    }

    protected float getFlipDegrees(VoidCrawler p_116011_) {
        return 180.0F;
    }

    @Override
    public ResourceLocation getTextureLocation(VoidCrawler p_114482_) {
        return TEXTURE;
    }
}
