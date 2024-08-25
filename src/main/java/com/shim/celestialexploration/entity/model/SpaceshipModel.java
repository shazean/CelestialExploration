package com.shim.celestialexploration.entity.model;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestialexploration.entity.Spaceship;
import mod.azure.azurelib.model.GeoModel;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class SpaceshipModel extends GeoModel<Spaceship> {
    // Models must be stored in assets/<modid>/geo with subfolders supported inside the geo folder
    private static final ResourceLocation model = new ResourceLocation(CelestialExploration.MODID, "geo/spaceship.geo.json");
    // Textures must be stored in assets/<modid>/geo with subfolders supported inside the textures folder
    private static final ResourceLocation texture = new ResourceLocation(CelestialExploration.MODID, "textures/spaceship/white.png");
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
    public ResourceLocation getModelResource(Spaceship spaceship) {
        return model;
    }

    @Override
    public ResourceLocation getTextureResource(Spaceship spaceship) {
        return SPACESHIP_TEXTURE_LOCATIONS[spaceship.getSpaceshipType().ordinal()];
    }

    @Override
    public ResourceLocation getAnimationResource(Spaceship spaceship) {
        return animation;
    }
}