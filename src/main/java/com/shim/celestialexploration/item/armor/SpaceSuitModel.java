package com.shim.celestialexploration.item.armor;

import com.shim.celestialexploration.CelestialExploration;
import mod.azure.azurelib.model.GeoModel;
import net.minecraft.resources.ResourceLocation;

public class SpaceSuitModel extends GeoModel<SpaceSuitArmorItem> {
    @Override
    public ResourceLocation getModelResource(SpaceSuitArmorItem object) {
        return new ResourceLocation(CelestialExploration.MODID, "geo/spacesuit.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(SpaceSuitArmorItem object) {
        return new ResourceLocation(CelestialExploration.MODID, "textures/models/armor/basic_spacesuit.png");
    }

    @Override
    public ResourceLocation getAnimationResource(SpaceSuitArmorItem animatable) {
        return new ResourceLocation(CelestialExploration.MODID, "animations/spacesuit.animation.json");
    }
}