package com.shim.celestialexploration.entity.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestialexploration.entity.CelestialTrader;
import net.minecraft.client.model.VillagerModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.CrossedArmsItemLayer;
import net.minecraft.client.renderer.entity.layers.CustomHeadLayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.Nullable;

@OnlyIn(Dist.CLIENT)
public class CelestialTraderRenderer extends MobRenderer<CelestialTrader, VillagerModel<CelestialTrader>> {
    private static final ResourceLocation VILLAGER_BASE_SKIN = new ResourceLocation(CelestialExploration.MODID, "textures/entity/celestial_trader.png");

    public CelestialTraderRenderer(EntityRendererProvider.Context p_174441_) {
        super(p_174441_, new VillagerModel<>(p_174441_.bakeLayer(ModelLayers.WANDERING_TRADER)), 0.5F);
        this.addLayer(new CustomHeadLayer<>(this, p_174441_.getModelSet()));
        this.addLayer(new CrossedArmsItemLayer<>(this));
    }

    public ResourceLocation getTextureLocation(CelestialTrader trader) {
        return VILLAGER_BASE_SKIN;
    }

    @Override
    protected @Nullable RenderType getRenderType(CelestialTrader p_115322_, boolean p_115323_, boolean p_115324_, boolean p_115325_) {
        return RenderType.entityTranslucent(this.getTextureLocation(p_115322_));
//        return super.getRenderType(p_115322_, p_115323_, p_115324_, p_115325_);
    }

    protected void scale(CelestialTrader trader, PoseStack poseStack, float p_116377_) {
        float scale = 0.9375F;
        poseStack.scale(scale, scale, scale);
    }
}