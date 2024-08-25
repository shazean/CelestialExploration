package com.shim.celestialexploration.item.armor;

import com.shim.celestialexploration.CelestialExploration;
import mod.azure.azurelib.model.GeoModel;
import net.minecraft.resources.ResourceLocation;

public class AdvancedSpaceSuitModel extends GeoModel<AdvancedSpaceSuitArmorItem> {
    @Override
    public ResourceLocation getModelResource(AdvancedSpaceSuitArmorItem object) {
        return new ResourceLocation(CelestialExploration.MODID, "geo/spacesuit.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(AdvancedSpaceSuitArmorItem object) {
        return new ResourceLocation(CelestialExploration.MODID, "textures/models/armor/advanced_spacesuit.png");
    }

    @Override
    public ResourceLocation getAnimationResource(AdvancedSpaceSuitArmorItem animatable) {
        return new ResourceLocation(CelestialExploration.MODID, "animations/spacesuit.animation.json");
    }
}