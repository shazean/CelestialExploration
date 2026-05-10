//package com.shim.celestialexploration.entity.client.renderer;
//
//import com.mojang.blaze3d.vertex.PoseStack;
//import com.shim.celestialexploration.CelestialExploration;
//import com.shim.celestialexploration.entity.CelestialTrader;
//import net.minecraft.client.model.VillagerModel;
//import net.minecraft.client.model.geom.ModelLayers;
//import net.minecraft.client.renderer.entity.EntityRendererProvider;
//import net.minecraft.client.renderer.entity.MobRenderer;
//import net.minecraft.client.renderer.entity.layers.CrossedArmsItemLayer;
//import net.minecraft.client.renderer.entity.layers.CustomHeadLayer;
//import net.minecraft.resources.ResourceLocation;
//import net.minecraftforge.api.distmarker.Dist;
//import net.minecraftforge.api.distmarker.OnlyIn;
//
//@OnlyIn(Dist.CLIENT)
//public class CelestialTraderRenderer extends MobRenderer<CelestialTrader, VillagerModel<CelestialTrader>> {
//    private static final ResourceLocation VILLAGER_BASE_SKIN = new ResourceLocation(CelestialExploration.MODID, "textures/entity/celestial_trader.png");
//
//    public CelestialTraderRenderer(EntityRendererProvider.Context p_174441_) {
//        super(p_174441_, new VillagerModel<>(p_174441_.bakeLayer(ModelLayers.WANDERING_TRADER)), 0.5F);
//        this.addLayer(new CustomHeadLayer<>(this, p_174441_.getModelSet()));
//        this.addLayer(new CrossedArmsItemLayer<>(this));
//    }
//
//    public ResourceLocation getTextureLocation(CelestialTrader trader) {
//        return VILLAGER_BASE_SKIN;
//    }
//
//    protected void scale(CelestialTrader trader, PoseStack poseStack, float p_116377_) {
//        float scale = 0.9375F;
//        poseStack.scale(scale, scale, scale);
//    }
//}