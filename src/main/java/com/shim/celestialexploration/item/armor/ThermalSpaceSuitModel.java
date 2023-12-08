package com.shim.celestialexploration.item.armor;

import com.shim.celestialexploration.CelestialExploration;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class ThermalSpaceSuitModel extends AnimatedGeoModel<ThermalSpaceSuitArmorItem> {
    @Override
    public ResourceLocation getModelLocation(ThermalSpaceSuitArmorItem object) {
        return new ResourceLocation(CelestialExploration.MODID, "geo/space_suit.geo.json");
    }

    @Override
    public ResourceLocation getTextureLocation(ThermalSpaceSuitArmorItem object) {
        return new ResourceLocation(CelestialExploration.MODID, "textures/models/armor/thermal_space_suit.png");
    }

    @Override
    public ResourceLocation getAnimationFileLocation(ThermalSpaceSuitArmorItem animatable) {
        return new ResourceLocation(CelestialExploration.MODID, "animations/space_suit.animation.json");
    }
}