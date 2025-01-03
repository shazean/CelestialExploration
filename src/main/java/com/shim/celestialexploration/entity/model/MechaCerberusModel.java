package com.shim.celestialexploration.entity.model;

import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestialexploration.entity.entity.robots.AbstractCerberus;
import mod.azure.azurelib.model.GeoModel;
import net.minecraft.resources.ResourceLocation;

public class MechaCerberusModel extends GeoModel<AbstractCerberus> {
    // Models must be stored in assets/<modid>/geo with subfolders supported inside the geo folder
    private static final ResourceLocation model = new ResourceLocation(CelestialExploration.MODID, "geo/mechacerberus.geo.json");
    // Textures must be stored in assets/<modid>/geo with subfolders supported inside the textures folder
    private static final ResourceLocation texture = new ResourceLocation(CelestialExploration.MODID, "textures/entity/mechacerberus/mechacerberus_red.png");
    // Animations must be stored in assets/<modid>/animations with subfolders supported inside the animations folder
    private static final ResourceLocation animation = new ResourceLocation(CelestialExploration.MODID, "animations/mechacerberus.animation.json");

    private static final ResourceLocation[] MECHACERBERUS_TEXTURE_LOCATIONS = new ResourceLocation[]{
            new ResourceLocation(CelestialExploration.MODID, "textures/entity/mechacerberus/mechacerberus_black.png"),  new ResourceLocation(CelestialExploration.MODID, "textures/entity/mechacerberus/mechacerberus_grey.png"),
            new ResourceLocation(CelestialExploration.MODID, "textures/entity/mechacerberus/mechacerberus_light_grey.png"), new ResourceLocation(CelestialExploration.MODID, "textures/entity/mechacerberus/mechacerberus_white.png"),
            new ResourceLocation(CelestialExploration.MODID, "textures/entity/mechacerberus/mechacerberus_pink.png"), new ResourceLocation(CelestialExploration.MODID, "textures/entity/mechacerberus/mechacerberus_magenta.png"),
            new ResourceLocation(CelestialExploration.MODID, "textures/entity/mechacerberus/mechacerberus_red.png"), new ResourceLocation(CelestialExploration.MODID, "textures/entity/mechacerberus/mechacerberus_brown.png"),
            new ResourceLocation(CelestialExploration.MODID, "textures/entity/mechacerberus/mechacerberus_orange.png"), new ResourceLocation(CelestialExploration.MODID, "textures/entity/mechacerberus/mechacerberus_yellow.png"),
            new ResourceLocation(CelestialExploration.MODID, "textures/entity/mechacerberus/mechacerberus_lime.png"), new ResourceLocation(CelestialExploration.MODID, "textures/entity/mechacerberus/mechacerberus_green.png"),
            new ResourceLocation(CelestialExploration.MODID, "textures/entity/mechacerberus/mechacerberus_cyan.png"), new ResourceLocation(CelestialExploration.MODID, "textures/entity/mechacerberus/mechacerberus_light_blue.png"),
            new ResourceLocation(CelestialExploration.MODID, "textures/entity/mechacerberus/mechacerberus_blue.png"), new ResourceLocation(CelestialExploration.MODID, "textures/entity/mechacerberus/mechacerberus_purple.png")};


    @Override
    public ResourceLocation getModelResource(AbstractCerberus mechacerberus) {
        return model;
    }

    @Override
    public ResourceLocation getTextureResource(AbstractCerberus mechacerberus) {
        return MECHACERBERUS_TEXTURE_LOCATIONS[mechacerberus.getDyeType().ordinal()];
    }

    @Override
    public ResourceLocation getAnimationResource(AbstractCerberus mechacerberus) {
        return animation;
    }
}