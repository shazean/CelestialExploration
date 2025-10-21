package com.shim.celestialexploration.entity.client.renderer;

import com.shim.celestialexploration.entity.client.animators.MechaCrowAnimator;
import com.shim.celestialexploration.entity.robots.MechaCrow;
import com.shim.celestialexploration.util.CelestialUtil;
import mod.azure.azurelib.render.entity.AzEntityRenderer;
import mod.azure.azurelib.render.entity.AzEntityRendererConfig;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class MechaCrowRenderer extends AzEntityRenderer<MechaCrow> {
    private static final ResourceLocation GEO = CelestialUtil.getModLoc("geo/mechacrow.geo.json");

    private static final ResourceLocation TEX = CelestialUtil.getModLoc("textures/entity/mechacrow.png");

    public MechaCrowRenderer(EntityRendererProvider.Context context) {
        super(AzEntityRendererConfig.<MechaCrow>builder(GEO, TEX).setAnimatorProvider(MechaCrowAnimator::new).setScale(0.4F).build(), context);
    }
}
