package com.shim.celestialexploration.item.armor;


import com.shim.celestialexploration.CelestialExploration;
import mod.azure.azurelib.rewrite.render.armor.AzArmorRenderer;
import mod.azure.azurelib.rewrite.render.armor.AzArmorRendererConfig;
import net.minecraft.resources.ResourceLocation;

public class HeavyDutySpacesuitRenderer extends AzArmorRenderer {
    private static final ResourceLocation GEO = ResourceLocation.fromNamespaceAndPath(
            CelestialExploration.MODID, "geo/spacesuit.geo.json");

    private static final ResourceLocation TEX = ResourceLocation.fromNamespaceAndPath(
            CelestialExploration.MODID, "textures/models/armor/heavy_duty_spacesuit.png");

    public HeavyDutySpacesuitRenderer() {
        super(AzArmorRendererConfig.builder(GEO, TEX).setAnimatorProvider(SpacesuitAnimator::new).build());
    }
}