package com.shim.celestialexploration.item.armor;

import com.shim.celestialexploration.CelestialExploration;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class AdvancedSpaceSuitModel extends AnimatedGeoModel<AdvancedSpaceSuitArmorItem> {
    @Override
    public ResourceLocation getModelLocation(AdvancedSpaceSuitArmorItem object) {
        return new ResourceLocation(CelestialExploration.MODID, "geo/space_suit.geo.json");
    }

    @Override
    public ResourceLocation getTextureLocation(AdvancedSpaceSuitArmorItem object) {
        return new ResourceLocation(CelestialExploration.MODID, "textures/models/armor/advanced_space_suit.png");
    }

    @Override
    public ResourceLocation getAnimationFileLocation(AdvancedSpaceSuitArmorItem animatable) {
        return new ResourceLocation(CelestialExploration.MODID, "animations/space_suit.animation.json");
    }
}