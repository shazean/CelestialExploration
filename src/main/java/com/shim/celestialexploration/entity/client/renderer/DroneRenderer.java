package com.shim.celestialexploration.entity.client.renderer;

import com.shim.celestialexploration.entity.client.animators.DroneAnimator;
import com.shim.celestialexploration.entity.robots.Drone;
import com.shim.celestialexploration.util.CelestialUtil;
import mod.azure.azurelib.render.entity.AzEntityRenderer;
import mod.azure.azurelib.render.entity.AzEntityRendererConfig;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class DroneRenderer extends AzEntityRenderer<Drone> {
    private static final ResourceLocation GEO = CelestialUtil.getModLoc("geo/drone.geo.json");

    private static final ResourceLocation TEX = CelestialUtil.getModLoc("textures/entity/drone.png");

    public DroneRenderer(EntityRendererProvider.Context context) {
        super(AzEntityRendererConfig.<Drone>builder(GEO, TEX).setAnimatorProvider(DroneAnimator::new).build(), context);
    }
}