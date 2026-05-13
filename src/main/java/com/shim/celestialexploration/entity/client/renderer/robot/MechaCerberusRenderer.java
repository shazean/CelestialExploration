package com.shim.celestialexploration.entity.client.renderer.robot;

import com.shim.celestialexploration.entity.client.animators.MechaCerberusAnimator;
import com.shim.celestialexploration.entity.client.layers.DyedGlowLayer;
import com.shim.celestialexploration.entity.robots.AbstractCerberus;
import com.shim.celestialexploration.util.CelestialUtil;
import mod.azure.azurelib.render.entity.AzEntityRenderer;
import mod.azure.azurelib.render.entity.AzEntityRendererConfig;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;

public class MechaCerberusRenderer extends AzEntityRenderer<AbstractCerberus> {

    public MechaCerberusRenderer(EntityRendererProvider.Context context, float scale) {
        super(AzEntityRendererConfig.builder(MechaCerberusRenderer::getModel, MechaCerberusRenderer::getTexture).setAnimatorProvider(MechaCerberusAnimator::new)
                .setScale(scale)
                .addRenderLayer(new DyedGlowLayer<>("mechacerberus/mechacerberus"))
                .build(), context);
    }

    public static ResourceLocation getModel(AbstractCerberus animatable) {
        return CelestialUtil.getModLoc("geo/mechacerberus.geo.json");
    }

    public static ResourceLocation getTexture(AbstractCerberus animatable) {
        return CelestialUtil.getModLoc("textures/entity/mechacerberus/mechacerberus_" + animatable.getDyeType().getName() + ".png");
    }
}