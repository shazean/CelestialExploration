package com.shim.celestialexploration.entity.renderer;


import com.mojang.blaze3d.vertex.PoseStack;
import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestialexploration.entity.VoidFellow;
import com.shim.celestialexploration.entity.layers.VoidCarriedBlockLayer;
import com.shim.celestialexploration.entity.layers.VoidEyesLayer;
import com.shim.celestialexploration.entity.model.VoidFellowModel;
import net.minecraft.client.model.EndermanModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.CarriedBlockLayer;
import net.minecraft.client.renderer.entity.layers.EnderEyesLayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.monster.EnderMan;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;

import java.util.Random;

public class VoidFellowRenderer extends MobRenderer<VoidFellow, VoidFellowModel<VoidFellow>> {
    private static final ResourceLocation VOIDFELLOW_LOCATION = new ResourceLocation(CelestialExploration.MODID, "textures/entity/voidfellow/voidfellow.png");
    private final Random random = new Random();

    public VoidFellowRenderer(EntityRendererProvider.Context p_173992_) {
        super(p_173992_, new VoidFellowModel(p_173992_.bakeLayer(ModelLayers.ENDERMAN)), 0.5F);
        this.addLayer(new VoidEyesLayer<>(this));
        this.addLayer(new VoidCarriedBlockLayer(this));
    }

    public void render(VoidFellow p_114339_, float p_114340_, float p_114341_, PoseStack p_114342_, MultiBufferSource p_114343_, int p_114344_) {
        BlockState blockstate = p_114339_.getCarriedBlock();
        VoidFellowModel<VoidFellow> voidfellowmodel = this.getModel();
        voidfellowmodel.carrying = blockstate != null;
        voidfellowmodel.creepy = p_114339_.isCreepy();
        super.render(p_114339_, p_114340_, p_114341_, p_114342_, p_114343_, p_114344_);
    }

    public Vec3 getRenderOffset(VoidFellow p_114336_, float p_114337_) {
        if (p_114336_.isCreepy()) {
            double d0 = 0.02D;
            return new Vec3(this.random.nextGaussian() * 0.02D, 0.0D, this.random.nextGaussian() * 0.02D);
        } else {
            return super.getRenderOffset(p_114336_, p_114337_);
        }
    }

    public ResourceLocation getTextureLocation(VoidFellow p_114334_) {
        return VOIDFELLOW_LOCATION;
    }
}