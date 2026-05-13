package com.shim.celestialexploration.entity.client.renderer.robot;

import com.shim.celestialexploration.entity.client.animators.MechaDogAnimator;
import com.shim.celestialexploration.entity.client.layers.DyedGlowLayer;
import com.shim.celestialexploration.entity.robots.MechaDog;
import com.shim.celestialexploration.util.CelestialUtil;
import mod.azure.azurelib.render.entity.AzEntityRenderer;
import mod.azure.azurelib.render.entity.AzEntityRendererConfig;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class MechaDogRenderer extends AzEntityRenderer<MechaDog> {

    public MechaDogRenderer(EntityRendererProvider.Context context) {
        super(AzEntityRendererConfig.builder(MechaDogRenderer::getModel, MechaDogRenderer::getTexture).setAnimatorProvider(MechaDogAnimator::new)
                .addRenderLayer(new DyedGlowLayer<>())
                .build(), context);
    }

    public static ResourceLocation getModel(MechaDog animatable) {
        return CelestialUtil.getModLoc("geo/mechadog.geo.json");
    }

    public static ResourceLocation getTexture(MechaDog animatable) {
        return CelestialUtil.getModLoc("textures/entity/mechadog/mechadog_" + animatable.getDyeType().getName() + ".png");
    }
}