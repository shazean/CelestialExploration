package com.shim.celestialexploration.item;

import com.shim.celestialexploration.CelestialExploration;
import mod.azure.azurelib.rewrite.render.item.AzItemRenderer;
import mod.azure.azurelib.rewrite.render.item.AzItemRendererConfig;
import net.minecraft.resources.ResourceLocation;

public class TestItemRenderer extends AzItemRenderer {
    private static final ResourceLocation GEO = ResourceLocation.fromNamespaceAndPath(
            CelestialExploration.MODID,
            "geo/testitem.geo.json"
    );

    private static final ResourceLocation TEX = ResourceLocation.fromNamespaceAndPath(
            CelestialExploration.MODID,
            "textures/item/testitem.png"
    );

    public TestItemRenderer() {
        super(AzItemRendererConfig.builder(GEO, TEX)
                        .setAnimatorProvider(TestItemAnimator::new).useNewOffset(true).build());
    }
}