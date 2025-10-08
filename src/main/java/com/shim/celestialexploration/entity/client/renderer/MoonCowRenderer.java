package com.shim.celestialexploration.entity.client.renderer;

import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestialexploration.entity.friendlies.MoonCow;
import net.minecraft.client.model.CowModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class MoonCowRenderer extends MobRenderer<MoonCow, CowModel<MoonCow>> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(CelestialExploration.MODID, "textures/entity/moon_cow.png");

    public MoonCowRenderer(EntityRendererProvider.Context context) {
        super(context, new CowModel<>(context.bakeLayer(ModelLayers.COW)), 0.7F);
    }

    @Override
    public ResourceLocation getTextureLocation(MoonCow p_114482_) {
        return TEXTURE;
    }
}
