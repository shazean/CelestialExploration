package com.shim.celestialexploration.entity.layers;

import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestialexploration.entity.mob.Lurker;
import net.minecraft.client.model.CreeperModel;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.EnergySwirlLayer;
import net.minecraft.resources.ResourceLocation;


public class LurkerPowerLayer extends EnergySwirlLayer<Lurker, CreeperModel<Lurker>> {
    private static final ResourceLocation POWER_LOCATION = new ResourceLocation(CelestialExploration.MODID, "textures/entity/lurker/lurker_armor.png");
    private final CreeperModel<Lurker> model;

    public LurkerPowerLayer(RenderLayerParent<Lurker, CreeperModel<Lurker>> p_174471_, EntityModelSet p_174472_) {
        super(p_174471_);
        this.model = new CreeperModel<>(p_174472_.bakeLayer(ModelLayers.CREEPER_ARMOR));
    }

    protected float xOffset(float p_116683_) {
        return p_116683_ * 0.01F;
    }

    protected ResourceLocation getTextureLocation() {
        return POWER_LOCATION;
    }

    protected EntityModel<Lurker> model() {
        return this.model;
    }
}