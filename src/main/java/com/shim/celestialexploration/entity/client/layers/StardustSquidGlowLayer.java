package com.shim.celestialexploration.entity.client.layers;

import com.shim.celestialexploration.CelestialExploration;
import net.minecraft.client.model.SpiderModel;
import net.minecraft.client.model.SquidModel;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.EyesLayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class StardustSquidGlowLayer<T extends Entity, M extends SquidModel<T>> extends EyesLayer<T, M> {
    private static final RenderType TEXTURE = RenderType.eyes(new ResourceLocation(CelestialExploration.MODID, "textures/entity/squid/stardust_squid_glow.png"));

    public StardustSquidGlowLayer(RenderLayerParent<T, M> renderLayerParent) {
        super(renderLayerParent);
    }

    public RenderType renderType() {
        return TEXTURE;
    }
}