package com.shim.celestialexploration.entity.client.renderer;

import com.shim.celestialexploration.entity.client.animators.MechaCrowAnimator;
import com.shim.celestialexploration.entity.client.layers.DyedGlowLayer;
import com.shim.celestialexploration.entity.robots.MechaCrow;
import com.shim.celestialexploration.entity.robots.MechaDog;
import com.shim.celestialexploration.util.CelestialUtil;
import mod.azure.azurelib.render.entity.AzEntityRenderer;
import mod.azure.azurelib.render.entity.AzEntityRendererConfig;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class MechaCrowRenderer extends AzEntityRenderer<MechaCrow> {

    public static ResourceLocation getModel(MechaCrow animatable) {
        return CelestialUtil.getModLoc("geo/mechacrow.geo.json");
    }
    public static ResourceLocation getTexture(MechaCrow animatable) {
        return CelestialUtil.getModLoc("textures/entity/mechacrow/mechacrow_" + animatable.getDyeType().getName() + ".png");
    }

    public MechaCrowRenderer(EntityRendererProvider.Context context) {
        super(AzEntityRendererConfig.<MechaCrow>builder(MechaCrowRenderer::getModel, MechaCrowRenderer::getTexture).setAnimatorProvider(MechaCrowAnimator::new)
                .setScale(0.5F)
                .addRenderLayer(new DyedGlowLayer<>())
                .build(), context);
    }
}
