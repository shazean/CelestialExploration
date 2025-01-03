package com.shim.celestialexploration.entity.layers;

import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestialexploration.entity.entity.robots.AbstractCerberus;
import mod.azure.azurelib.renderer.GeoRenderer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;

public class MechaCerberusGlowLayer extends GlowLayer<AbstractCerberus> {
//    private static final RenderType SPIDER_EYES = RenderType.eyes(new ResourceLocation("textures/entity/spider_eyes.png"));

//    public MechaDogGlowLayer(GeoRenderer<T> entityRendererIn) {
//        super(entityRendererIn);
//    }

    private static final ResourceLocation[] MECHACERBERUS_TEXTURE_LOCATIONS = new ResourceLocation[]{
            new ResourceLocation(CelestialExploration.MODID, "textures/entity/mechacerberus/mechacerberus_black_glow.png"),  new ResourceLocation(CelestialExploration.MODID, "textures/entity/mechacerberus/mechacerberus_grey_glow.png"),
            new ResourceLocation(CelestialExploration.MODID, "textures/entity/mechacerberus/mechacerberus_light_grey_glow.png"), new ResourceLocation(CelestialExploration.MODID, "textures/entity/mechacerberus/mechacerberus_white_glow.png"),
            new ResourceLocation(CelestialExploration.MODID, "textures/entity/mechacerberus/mechacerberus_pink_glow.png"), new ResourceLocation(CelestialExploration.MODID, "textures/entity/mechacerberus/mechacerberus_magenta_glow.png"),
            new ResourceLocation(CelestialExploration.MODID, "textures/entity/mechacerberus/mechacerberus_red_glow.png"), new ResourceLocation(CelestialExploration.MODID, "textures/entity/mechacerberus/mechacerberus_brown_glow.png"),
            new ResourceLocation(CelestialExploration.MODID, "textures/entity/mechacerberus/mechacerberus_orange_glow.png"), new ResourceLocation(CelestialExploration.MODID, "textures/entity/mechacerberus/mechacerberus_yellow_glow.png"),
            new ResourceLocation(CelestialExploration.MODID, "textures/entity/mechacerberus/mechacerberus_lime_glow.png"), new ResourceLocation(CelestialExploration.MODID, "textures/entity/mechacerberus/mechacerberus_green_glow.png"),
            new ResourceLocation(CelestialExploration.MODID, "textures/entity/mechacerberus/mechacerberus_cyan_glow.png"), new ResourceLocation(CelestialExploration.MODID, "textures/entity/mechacerberus/mechacerberus_light_blue_glow.png"),
            new ResourceLocation(CelestialExploration.MODID, "textures/entity/mechacerberus/mechacerberus_blue_glow.png"), new ResourceLocation(CelestialExploration.MODID, "textures/entity/mechacerberus/mechacerberus_purple_glow.png")};

    public MechaCerberusGlowLayer(GeoRenderer<AbstractCerberus> entityRendererIn) {
        super(entityRendererIn);
    }
    
    @Override
    public RenderType renderType(AbstractCerberus animatable) {
        return RenderType.eyes(MECHACERBERUS_TEXTURE_LOCATIONS[animatable.getDyeType().ordinal()]);
    }
}