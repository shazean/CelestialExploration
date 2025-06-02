package com.shim.celestialexploration.entity.client.renderer;

import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestialexploration.entity.client.layers.MeteorCrawlerEyesLayer;
import com.shim.celestialexploration.entity.mob.MeteorCrawler;
import net.minecraft.client.model.SpiderModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class MeteorCrawlerRenderer extends MobRenderer<MeteorCrawler, SpiderModel<MeteorCrawler>> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(CelestialExploration.MODID, "textures/entity/spiderlike/meteor_crawler.png");

    public MeteorCrawlerRenderer(EntityRendererProvider.Context p_174401_) {
        this(p_174401_, ModelLayers.SPIDER);
    }

    public MeteorCrawlerRenderer(EntityRendererProvider.Context context, ModelLayerLocation model) {
        super(context, new SpiderModel<>(context.bakeLayer(model)), 0.8F);
        this.addLayer(new MeteorCrawlerEyesLayer<>(this));
    }

    @Override
    public ResourceLocation getTextureLocation(MeteorCrawler entity) {
        return TEXTURE;
    }
}
