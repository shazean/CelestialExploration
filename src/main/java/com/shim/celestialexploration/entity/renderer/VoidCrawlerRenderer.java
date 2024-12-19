package com.shim.celestialexploration.entity.renderer;

import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestialexploration.entity.layers.VoidCrawlerEyesLayer;
import com.shim.celestialexploration.entity.entity.mob.VoidCrawler;
import net.minecraft.client.model.SpiderModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class VoidCrawlerRenderer extends MobRenderer<VoidCrawler, SpiderModel<VoidCrawler>> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(CelestialExploration.MODID, "textures/entity/spiderlike/void_crawler.png");

    public VoidCrawlerRenderer(EntityRendererProvider.Context p_174401_) {
        this(p_174401_, ModelLayers.SPIDER);
    }

    public VoidCrawlerRenderer(EntityRendererProvider.Context context, ModelLayerLocation model) {
        super(context, new SpiderModel<>(context.bakeLayer(model)), 0.8F);
        this.addLayer(new VoidCrawlerEyesLayer<>(this));
    }

    @Override
    public ResourceLocation getTextureLocation(VoidCrawler p_114482_) {
        return TEXTURE;
    }
}
