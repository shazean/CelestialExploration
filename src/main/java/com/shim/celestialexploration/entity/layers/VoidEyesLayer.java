package com.shim.celestialexploration.entity.layers;

import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestialexploration.entity.model.VoidFellowModel;
import net.minecraft.client.model.EndermanModel;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.EyesLayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;

public class VoidEyesLayer<T extends LivingEntity> extends EyesLayer<T, EndermanModel<T>> {
    private static final RenderType ENDERMAN_EYES = RenderType.eyes(new ResourceLocation(CelestialExploration.MODID, "textures/entity/voidfellow/voidfellow_eyes.png"));

    public VoidEyesLayer(RenderLayerParent<T, EndermanModel<T>> p_116964_) {
        super(p_116964_);
    }

    public RenderType renderType() {
        return ENDERMAN_EYES;
    }
}