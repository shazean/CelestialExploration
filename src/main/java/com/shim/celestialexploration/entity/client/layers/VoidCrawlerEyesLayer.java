package com.shim.celestialexploration.entity.client.layers;

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
public class VoidCrawlerEyesLayer<T extends Entity, M extends SpiderModel<T>> extends EyesLayer<T, M> {
    private static final RenderType VOID_EYES = RenderType.eyes(new ResourceLocation(CelestialExploration.MODID, "textures/entity/spiderlike/void_crawler_eyes.png"));

    public VoidCrawlerEyesLayer(RenderLayerParent<T, M> p_117507_) {
        super(p_117507_);
    }

    public RenderType renderType() {
        return VOID_EYES;
    }
}