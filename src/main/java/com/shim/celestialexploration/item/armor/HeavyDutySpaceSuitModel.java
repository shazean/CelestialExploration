package com.shim.celestialexploration.item.armor;

import com.shim.celestialexploration.CelestialExploration;
import mod.azure.azurelib.model.GeoModel;
import net.minecraft.resources.ResourceLocation;

public class HeavyDutySpaceSuitModel extends GeoModel<HeavyDutySpaceSuitArmorItem> {
    @Override
    public ResourceLocation getModelResource(HeavyDutySpaceSuitArmorItem object) {
        return new ResourceLocation(CelestialExploration.MODID, "geo/spacesuit.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(HeavyDutySpaceSuitArmorItem object) {
        return new ResourceLocation(CelestialExploration.MODID, "textures/models/armor/heavy_duty_spacesuit.png");
    }

    @Override
    public ResourceLocation getAnimationResource(HeavyDutySpaceSuitArmorItem animatable) {
        return new ResourceLocation(CelestialExploration.MODID, "animations/spacesuit.animation.json");
    }
}