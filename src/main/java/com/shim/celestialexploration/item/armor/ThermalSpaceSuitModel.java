package com.shim.celestialexploration.item.armor;

import com.shim.celestialexploration.CelestialExploration;
import mod.azure.azurelib.model.GeoModel;
import net.minecraft.resources.ResourceLocation;

public class ThermalSpaceSuitModel extends GeoModel<ThermalSpaceSuitArmorItem> {
    @Override
    public ResourceLocation getModelResource(ThermalSpaceSuitArmorItem object) {
        return new ResourceLocation(CelestialExploration.MODID, "geo/spacesuit.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(ThermalSpaceSuitArmorItem object) {
        return new ResourceLocation(CelestialExploration.MODID, "textures/models/armor/thermal_spacesuit.png");
    }

    @Override
    public ResourceLocation getAnimationResource(ThermalSpaceSuitArmorItem animatable) {
        return new ResourceLocation(CelestialExploration.MODID, "animations/spacesuit.animation.json");
    }
}