package com.shim.celestialexploration.entity.client.renderer;

import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestialexploration.entity.creatures.CelestialSquid;
import com.shim.celestialexploration.entity.client.layers.StardustSquidGlowLayer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class StardustSquidRenderer extends AsteroidSquidRenderer {
    private static final ResourceLocation TEXTURE = new ResourceLocation(CelestialExploration.MODID, "textures/entity/squid/stardust_squid.png");

    public StardustSquidRenderer(EntityRendererProvider.Context p_173958_) {
        super(p_173958_);
        this.addLayer(new StardustSquidGlowLayer<>(this));
    }

    public ResourceLocation getTextureLocation(CelestialSquid squid) {
        return TEXTURE;
    }
}