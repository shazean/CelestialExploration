package com.shim.celestialexploration.entity.client.layers;

import com.shim.celestialexploration.util.CelestialUtil;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

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