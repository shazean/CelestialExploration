package com.shim.celestialexploration.item.armor;


import com.shim.celestialexploration.CelestialExploration;
import mod.azure.azurelib.renderer.GeoArmorRenderer;
import mod.azure.azurelib.rewrite.render.armor.AzArmorRenderer;
import mod.azure.azurelib.rewrite.render.armor.AzArmorRendererConfig;
import net.minecraft.resources.ResourceLocation;

public class BasicSpacesuitRenderer extends AzArmorRenderer {
    private static final ResourceLocation GEO = ResourceLocation.fromNamespaceAndPath(
            CelestialExploration.MODID, "geo/spacesuit.geo.json");

    private static final ResourceLocation TEX = ResourceLocation.fromNamespaceAndPath(
            CelestialExploration.MODID, "textures/models/armor/basic_spacesuit.png");

    public BasicSpacesuitRenderer() {
        super(AzArmorRendererConfig.builder(GEO, TEX).setAnimatorProvider(SpacesuitAnimator::new).build());
    }
}