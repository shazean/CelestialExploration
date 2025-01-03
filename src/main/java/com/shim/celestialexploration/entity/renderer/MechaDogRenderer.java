package com.shim.celestialexploration.entity.renderer;

import com.shim.celestialexploration.entity.entity.robots.MechaDog;
import com.shim.celestialexploration.entity.layers.MechaDogGlowLayer;
import com.shim.celestialexploration.entity.model.MechaDogModel;
import mod.azure.azurelib.renderer.GeoEntityRenderer;
import mod.azure.azurelib.renderer.layer.AutoGlowingGeoLayer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class MechaDogRenderer extends GeoEntityRenderer<MechaDog> {

    public MechaDogRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new MechaDogModel());
//        addRenderLayer(new AutoGlowingGeoLayer<>(this));
        addRenderLayer(new MechaDogGlowLayer(this));

    }
}