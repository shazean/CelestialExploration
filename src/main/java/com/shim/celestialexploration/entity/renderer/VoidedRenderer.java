package com.shim.celestialexploration.entity.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestialexploration.entity.mob.Voided;
import com.shim.celestialexploration.entity.model.VoidedModel;
import com.shim.celestialexploration.registry.CelestialModelLayers;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.entity.AbstractZombieRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class VoidedRenderer extends AbstractZombieRenderer<Voided, VoidedModel<Voided>> {
    private static final ResourceLocation VOIDED_LOCATION = new ResourceLocation(CelestialExploration.MODID, "textures/entity/voided.png");

    public VoidedRenderer(EntityRendererProvider.Context context) {
//        super(context, ModelLayers.ZOMBIE, ModelLayers.ZOMBIE_INNER_ARMOR, ModelLayers.ZOMBIE_OUTER_ARMOR);

        this(context, ModelLayers.ZOMBIE, CelestialModelLayers.VOIDED_INNER_ARMOR, CelestialModelLayers.VOIDED_OUTER_ARMOR);
    }

//    public ZombieRenderer(EntityRendererProvider.Context p_174456_) {
//        this(p_174456_, ModelLayers.ZOMBIE, ModelLayers.ZOMBIE_INNER_ARMOR, ModelLayers.ZOMBIE_OUTER_ARMOR);
//    }

    public VoidedRenderer(EntityRendererProvider.Context p_174458_, ModelLayerLocation p_174459_, ModelLayerLocation p_174460_, ModelLayerLocation p_174461_) {
        super(p_174458_, new VoidedModel<>(p_174458_.bakeLayer(p_174459_)), new VoidedModel<>(p_174458_.bakeLayer(p_174460_)), new VoidedModel<>(p_174458_.bakeLayer(p_174461_)));
    }


    protected void scale(Voided p_114907_, PoseStack p_114908_, float p_114909_) {
        float f = 1.0625F;
        p_114908_.scale(1.0625F, 1.0625F, 1.0625F);
        super.scale(p_114907_, p_114908_, p_114909_);
    }

    public ResourceLocation getTextureLocation(Voided p_114905_) {
        return VOIDED_LOCATION;
    }
}