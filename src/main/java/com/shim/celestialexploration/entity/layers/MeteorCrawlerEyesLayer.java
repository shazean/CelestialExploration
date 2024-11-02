package com.shim.celestialexploration.entity.layers;

import com.shim.celestialexploration.CelestialExploration;
import net.minecraft.client.model.SpiderModel;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.EyesLayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class MeteorCrawlerEyesLayer<T extends Entity, M extends SpiderModel<T>> extends EyesLayer<T, M> {
    private static final RenderType METEOR_EYES = RenderType.eyes(new ResourceLocation(CelestialExploration.MODID, "textures/entity/spiderlike/meteor_crawler_eyes.png"));

    public MeteorCrawlerEyesLayer(RenderLayerParent<T, M> p_117507_) {
        super(p_117507_);
    }


    public RenderType renderType() {
        return METEOR_EYES;
    }
}