package com.shim.celestialexploration.entity.model;

import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestialexploration.entity.entity.vehicle.SpaceTaxi;
import mod.azure.azurelib.model.GeoModel;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class SpaceTaxiModel extends GeoModel<SpaceTaxi> {
    // Models must be stored in assets/<modid>/geo with subfolders supported inside the geo folder
    private static final ResourceLocation model = new ResourceLocation(CelestialExploration.MODID, "geo/spaceship.geo.json");
    // Textures must be stored in assets/<modid>/geo with subfolders supported inside the textures folder
    private static final ResourceLocation texture = new ResourceLocation(CelestialExploration.MODID, "textures/entity/spaceship/taxi.png");
    // Animations must be stored in assets/<modid>/animations with subfolders supported inside the animations folder
    private static final ResourceLocation animation = new ResourceLocation(CelestialExploration.MODID, "animations/spaceship.animation.json");

    private static final ResourceLocation[] SPACESHIP_TEXTURE_LOCATIONS = new ResourceLocation[]{
            new ResourceLocation(CelestialExploration.MODID, "textures/entity/spaceship/black.png"),  new ResourceLocation(CelestialExploration.MODID, "textures/entity/spaceship/grey.png"),
            new ResourceLocation(CelestialExploration.MODID, "textures/entity/spaceship/light_grey.png"), new ResourceLocation(CelestialExploration.MODID, "textures/entity/spaceship/white.png"),
            new ResourceLocation(CelestialExploration.MODID, "textures/entity/spaceship/pink.png"), new ResourceLocation(CelestialExploration.MODID, "textures/entity/spaceship/magenta.png"),
            new ResourceLocation(CelestialExploration.MODID, "textures/entity/spaceship/red.png"), new ResourceLocation(CelestialExploration.MODID, "textures/entity/spaceship/brown.png"),
            new ResourceLocation(CelestialExploration.MODID, "textures/entity/spaceship/orange.png"), new ResourceLocation(CelestialExploration.MODID, "textures/entity/spaceship/yellow.png"),
            new ResourceLocation(CelestialExploration.MODID, "textures/entity/spaceship/lime.png"), new ResourceLocation(CelestialExploration.MODID, "textures/entity/spaceship/green.png"),
            new ResourceLocation(CelestialExploration.MODID, "textures/entity/spaceship/cyan.png"), new ResourceLocation(CelestialExploration.MODID, "textures/entity/spaceship/light_blue.png"),
            new ResourceLocation(CelestialExploration.MODID, "textures/entity/spaceship/blue.png"), new ResourceLocation(CelestialExploration.MODID, "textures/entity/spaceship/purple.png")};


    @Override
    public ResourceLocation getModelResource(SpaceTaxi spaceship) {
        return model;
    }

    @Override
    public ResourceLocation getTextureResource(SpaceTaxi spaceship) {
        return texture;
    }

    @Override
    public ResourceLocation getAnimationResource(SpaceTaxi spaceship) {
        return animation;
    }
}