package com.shim.celestialexploration.entity.model;

import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestialexploration.entity.entity.robots.MechaDog;
import com.shim.celestialexploration.entity.entity.robots.Rover;
import mod.azure.azurelib.model.GeoModel;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class MechaDogModel extends GeoModel<MechaDog> {
    // Models must be stored in assets/<modid>/geo with subfolders supported inside the geo folder
    private static final ResourceLocation model = new ResourceLocation(CelestialExploration.MODID, "geo/mechadog.geo.json");
    // Textures must be stored in assets/<modid>/geo with subfolders supported inside the textures folder
    private static final ResourceLocation texture = new ResourceLocation(CelestialExploration.MODID, "textures/entity/mechadog/mechadog_red.png");
    // Animations must be stored in assets/<modid>/animations with subfolders supported inside the animations folder
    private static final ResourceLocation animation = new ResourceLocation(CelestialExploration.MODID, "animations/mechadog.animation.json");

    private static final ResourceLocation[] MECHADOG_TEXTURE_LOCATIONS = new ResourceLocation[]{
            new ResourceLocation(CelestialExploration.MODID, "textures/entity/mechadog/mechadog_black.png"),  new ResourceLocation(CelestialExploration.MODID, "textures/entity/mechadog/mechadog_grey.png"),
            new ResourceLocation(CelestialExploration.MODID, "textures/entity/mechadog/mechadog_light_grey.png"), new ResourceLocation(CelestialExploration.MODID, "textures/entity/mechadog/mechadog_white.png"),
            new ResourceLocation(CelestialExploration.MODID, "textures/entity/mechadog/mechadog_pink.png"), new ResourceLocation(CelestialExploration.MODID, "textures/entity/mechadog/mechadog_magenta.png"),
            new ResourceLocation(CelestialExploration.MODID, "textures/entity/mechadog/mechadog_red.png"), new ResourceLocation(CelestialExploration.MODID, "textures/entity/mechadog/mechadog_brown.png"),
            new ResourceLocation(CelestialExploration.MODID, "textures/entity/mechadog/mechadog_orange.png"), new ResourceLocation(CelestialExploration.MODID, "textures/entity/mechadog/mechadog_yellow.png"),
            new ResourceLocation(CelestialExploration.MODID, "textures/entity/mechadog/mechadog_lime.png"), new ResourceLocation(CelestialExploration.MODID, "textures/entity/mechadog/mechadog_green.png"),
            new ResourceLocation(CelestialExploration.MODID, "textures/entity/mechadog/mechadog_cyan.png"), new ResourceLocation(CelestialExploration.MODID, "textures/entity/mechadog/mechadog_light_blue.png"),
            new ResourceLocation(CelestialExploration.MODID, "textures/entity/mechadog/mechadog_blue.png"), new ResourceLocation(CelestialExploration.MODID, "textures/entity/mechadog/mechadog_purple.png")};


    @Override
    public ResourceLocation getModelResource(MechaDog mechadog) {
        return model;
    }

    @Override
    public ResourceLocation getTextureResource(MechaDog mechadog) {
        return MECHADOG_TEXTURE_LOCATIONS[mechadog.getDyeType().ordinal()];
    }

    @Override
    public ResourceLocation getAnimationResource(MechaDog mechadog) {
        return animation;
    }
}