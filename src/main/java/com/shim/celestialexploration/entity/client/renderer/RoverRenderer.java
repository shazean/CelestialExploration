package com.shim.celestialexploration.entity.client.renderer;

import com.shim.celestialexploration.entity.client.animators.RoverAnimator;
import com.shim.celestialexploration.entity.robots.Rover;
import com.shim.celestialexploration.entity.client.layers.RoverCarriedBlockLayer;
import com.shim.celestialexploration.util.CelestialUtil;
import mod.azure.azurelib.render.entity.AzEntityRenderer;
import mod.azure.azurelib.render.entity.AzEntityRendererConfig;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class RoverRenderer extends AzEntityRenderer<Rover> {
    private static final ResourceLocation GEO = CelestialUtil.getModLoc("geo/rover.geo.json");

    private static final ResourceLocation TEX = CelestialUtil.getModLoc("textures/entity/rover.png");

    public RoverRenderer(EntityRendererProvider.Context context) {
        super(AzEntityRendererConfig.<Rover>builder(GEO, TEX).setAnimatorProvider(RoverAnimator::new)
                .addRenderLayer(new RoverCarriedBlockLayer()).build(), context);
    }
}