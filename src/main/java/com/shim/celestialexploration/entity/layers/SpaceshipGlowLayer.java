package com.shim.celestialexploration.entity.layers;

import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestialexploration.entity.entity.robots.MechaDog;
import com.shim.celestialexploration.entity.entity.vehicle.Spaceship;
import mod.azure.azurelib.renderer.GeoRenderer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;

public class SpaceshipGlowLayer extends GlowLayer<Spaceship> {
    public SpaceshipGlowLayer(GeoRenderer<Spaceship> entityRendererIn) {
        super(entityRendererIn);
    }

    private static final ResourceLocation[] SPACESHIP_TEXTURE_LOCATIONS = new ResourceLocation[]{
            new ResourceLocation(CelestialExploration.MODID, "textures/entity/spaceship/black_glow.png"),  new ResourceLocation(CelestialExploration.MODID, "textures/entity/spaceship/grey_glow.png"),
            new ResourceLocation(CelestialExploration.MODID, "textures/entity/spaceship/light_grey_glow.png"), new ResourceLocation(CelestialExploration.MODID, "textures/entity/spaceship/white_glow.png"),
            new ResourceLocation(CelestialExploration.MODID, "textures/entity/spaceship/pink_glow.png"), new ResourceLocation(CelestialExploration.MODID, "textures/entity/spaceship/magenta_glow.png"),
            new ResourceLocation(CelestialExploration.MODID, "textures/entity/spaceship/red_glow.png"), new ResourceLocation(CelestialExploration.MODID, "textures/entity/spaceship/brown_glow.png"),
            new ResourceLocation(CelestialExploration.MODID, "textures/entity/spaceship/orange_glow.png"), new ResourceLocation(CelestialExploration.MODID, "textures/entity/spaceship/yellow_glow.png"),
            new ResourceLocation(CelestialExploration.MODID, "textures/entity/spaceship/lime_glow.png"), new ResourceLocation(CelestialExploration.MODID, "textures/entity/spaceship/green_glow.png"),
            new ResourceLocation(CelestialExploration.MODID, "textures/entity/spaceship/cyan_glow.png"), new ResourceLocation(CelestialExploration.MODID, "textures/entity/spaceship/light_blue_glow.png"),
            new ResourceLocation(CelestialExploration.MODID, "textures/entity/spaceship/blue_glow.png"), new ResourceLocation(CelestialExploration.MODID, "textures/entity/spaceship/purple_glow.png")};


    @Override
    public RenderType renderType(Spaceship animatable) {
        return RenderType.eyes(SPACESHIP_TEXTURE_LOCATIONS[animatable.getDyeType().ordinal()]);
    }
}