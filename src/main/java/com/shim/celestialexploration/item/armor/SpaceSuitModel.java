package com.shim.celestialexploration.item.armor;

import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestialexploration.item.SpaceSuitArmorItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.geo.render.built.GeoModel;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class SpaceSuitModel extends AnimatedGeoModel<SpaceSuitArmorItem> {
    @Override
    public ResourceLocation getModelLocation(SpaceSuitArmorItem object) {
        return new ResourceLocation(CelestialExploration.MODID, "geo/space_suit.geo.json");
    }

    @Override
    public ResourceLocation getTextureLocation(SpaceSuitArmorItem object) {
        return new ResourceLocation(CelestialExploration.MODID, "textures/models/armor/space_suit.png");
    }

    @Override
    public ResourceLocation getAnimationFileLocation(SpaceSuitArmorItem animatable) {
        return new ResourceLocation(CelestialExploration.MODID, "animations/space_suit.animation.json");
    }
}