package com.shim.celestialexploration.entity.client.renderer.creature;

import com.shim.celestialexploration.entity.ambient.Eureka;
import com.shim.celestialexploration.entity.client.animators.EurekaAnimator;
import com.shim.celestialexploration.util.CelestialUtil;
import mod.azure.azurelib.render.entity.AzEntityRenderer;
import mod.azure.azurelib.render.entity.AzEntityRendererConfig;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class EurekaRenderer extends AzEntityRenderer<Eureka> {
    private static final ResourceLocation GEO = CelestialUtil.getModLoc("geo/eureka.geo.json");

    private static final ResourceLocation TEX = CelestialUtil.getModLoc("textures/entity/eureka.png");

    public EurekaRenderer(EntityRendererProvider.Context context) {
        super(AzEntityRendererConfig.<Eureka>builder(GEO, TEX).setAnimatorProvider(EurekaAnimator::new).build(), context);
    }
}