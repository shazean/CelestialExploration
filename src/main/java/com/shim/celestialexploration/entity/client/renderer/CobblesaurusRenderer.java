package com.shim.celestialexploration.entity.client.renderer;

import com.shim.celestialexploration.entity.client.animators.CobblesaurusAnimator;
import com.shim.celestialexploration.entity.creatures.Cobblesaurus;
import com.shim.celestialexploration.util.CelestialUtil;
import mod.azure.azurelib.render.entity.AzEntityRenderer;
import mod.azure.azurelib.render.entity.AzEntityRendererConfig;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class CobblesaurusRenderer extends AzEntityRenderer<Cobblesaurus> {
    private static final ResourceLocation GEO = CelestialUtil.getModLoc("geo/cobblesaurus.geo.json");

    private static final ResourceLocation TEX = CelestialUtil.getModLoc("textures/entity/cobblesaurus.png");

    public CobblesaurusRenderer(EntityRendererProvider.Context context) {
        super(AzEntityRendererConfig.<Cobblesaurus>builder(GEO, TEX).setAnimatorProvider(CobblesaurusAnimator::new).build(), context);
    }
}