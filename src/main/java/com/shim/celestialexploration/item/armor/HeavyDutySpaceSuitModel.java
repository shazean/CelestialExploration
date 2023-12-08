package com.shim.celestialexploration.item.armor;

import com.shim.celestialexploration.CelestialExploration;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class HeavyDutySpaceSuitModel extends AnimatedGeoModel<HeavyDutySpaceSuitArmorItem> {
    @Override
    public ResourceLocation getModelLocation(HeavyDutySpaceSuitArmorItem object) {
        return new ResourceLocation(CelestialExploration.MODID, "geo/space_suit.geo.json");
    }

    @Override
    public ResourceLocation getTextureLocation(HeavyDutySpaceSuitArmorItem object) {
        return new ResourceLocation(CelestialExploration.MODID, "textures/models/armor/heavy_duty_space_suit.png");
    }

    @Override
    public ResourceLocation getAnimationFileLocation(HeavyDutySpaceSuitArmorItem animatable) {
        return new ResourceLocation(CelestialExploration.MODID, "animations/space_suit.animation.json");
    }
}