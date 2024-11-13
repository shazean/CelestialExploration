package com.shim.celestialexploration.entity.renderer;

import com.shim.celestialexploration.entity.Eureka;
import com.shim.celestialexploration.entity.model.EurekaModel;
import mod.azure.azurelib.renderer.GeoEntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class EurekaRenderer extends GeoEntityRenderer<Eureka> {

    public EurekaRenderer(EntityRendererProvider.Context context) {
        super(context, new EurekaModel());
    }
}