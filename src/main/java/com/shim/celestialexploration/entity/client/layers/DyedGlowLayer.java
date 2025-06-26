package com.shim.celestialexploration.entity.client.layers;

import com.shim.celestialexploration.util.CelestialUtil;
import com.shim.celestialexploration.entity.IDyeable;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class DyedGlowLayer<T extends Entity & IDyeable> extends AbstractGlowLayer<T> {
    public String texture;

    public DyedGlowLayer() {
        super();
    }

    public DyedGlowLayer(String texture) {
        super();
        this.texture = texture;
    }

    @Override
    public ResourceLocation getGlowTexture(T animatable) {
        if (this.texture != null) {
            return CelestialUtil.getModLoc("textures/entity/" + this.texture + "_" + animatable.getDyeType().getName() + "_glow.png");
        } else {
            String tex = animatable.getType().getRegistryName().getPath();
            return CelestialUtil.getModLoc("textures/entity/" + tex + "/" + tex + "_" + animatable.getDyeType().getName() + "_glow.png");
        }
    }
}