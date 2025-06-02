package com.shim.celestialexploration.entity.client.renderer;

import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestialexploration.entity.client.animators.OrbiterAnimator;
import com.shim.celestialexploration.entity.mob.Orbiter;
import com.shim.celestialexploration.util.CelestialUtil;
import mod.azure.azurelib.rewrite.render.entity.AzEntityRenderer;
import mod.azure.azurelib.rewrite.render.entity.AzEntityRendererConfig;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class OrbiterRenderer extends AzEntityRenderer<Orbiter> {
    private static final ResourceLocation GEO = CelestialUtil.getModLoc("geo/orbiter.geo.json");

    private static final ResourceLocation TEX = CelestialUtil.getModLoc("textures/entity/orbiter.png");

    public OrbiterRenderer(EntityRendererProvider.Context context) {
        super(AzEntityRendererConfig.<Orbiter>builder(GEO, TEX).setAnimatorProvider(OrbiterAnimator::new).build(), context);
    }
}