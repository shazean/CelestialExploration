package com.shim.celestialexploration.entity.renderer;

import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestialexploration.entity.mob.Flare;
import net.minecraft.client.model.BlazeModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class FlareRenderer extends MobRenderer<Flare, BlazeModel<Flare>> {
    private static final ResourceLocation BLAZE_LOCATION = new ResourceLocation(CelestialExploration.MODID, "textures/entity/flare.png");

    public FlareRenderer(EntityRendererProvider.Context p_173933_) {
        super(p_173933_, new BlazeModel<>(p_173933_.bakeLayer(ModelLayers.BLAZE)), 0.5F);
    }

    protected int getBlockLightLevel(Flare p_113910_, BlockPos p_113911_) {
        return 15;
    }

    public ResourceLocation getTextureLocation(Flare p_113908_) {
        return BLAZE_LOCATION;
    }
}