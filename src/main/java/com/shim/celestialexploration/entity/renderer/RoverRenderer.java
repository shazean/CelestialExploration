package com.shim.celestialexploration.entity.renderer;

import com.shim.celestialexploration.entity.entity.robots.Rover;
import com.shim.celestialexploration.entity.layers.RoverCarriedBlockLayer;
import com.shim.celestialexploration.entity.model.RoverModel;
import mod.azure.azurelib.renderer.GeoEntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class RoverRenderer extends GeoEntityRenderer<Rover> {

    public RoverRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new RoverModel());
        addRenderLayer(new RoverCarriedBlockLayer(this));
    }
}