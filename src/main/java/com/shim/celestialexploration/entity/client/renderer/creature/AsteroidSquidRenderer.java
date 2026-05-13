//package com.shim.celestialexploration.entity.client.renderer;
//
//import com.mojang.blaze3d.vertex.PoseStack;
//import com.mojang.math.Vector3f;
//import com.shim.celestialexploration.CelestialExploration;
//import com.shim.celestialexploration.entity.creatures.CelestialSquid;
//import net.minecraft.client.model.SquidModel;
//import net.minecraft.client.model.geom.ModelLayers;
//import net.minecraft.client.renderer.entity.EntityRendererProvider;
//import net.minecraft.client.renderer.entity.MobRenderer;
//import net.minecraft.resources.ResourceLocation;
//import net.minecraft.util.Mth;
//import net.minecraftforge.api.distmarker.Dist;
//import net.minecraftforge.api.distmarker.OnlyIn;
//
//@OnlyIn(Dist.CLIENT)
//public class AsteroidSquidRenderer extends MobRenderer<CelestialSquid, SquidModel<CelestialSquid>> {
//    private static final ResourceLocation TEXTURE = new ResourceLocation(CelestialExploration.MODID, "textures/entity/squid/asteroid_squid.png");
//
//    public AsteroidSquidRenderer(EntityRendererProvider.Context p_173958_) {
//        super(p_173958_, new SquidModel<>(p_173958_.bakeLayer(ModelLayers.SQUID)), 0.5F);
//    }
//
//    public ResourceLocation getTextureLocation(CelestialSquid squid) {
//        return TEXTURE;
//    }
//
//    protected void setupRotations(CelestialSquid p_116035_, PoseStack p_116036_, float p_116037_, float p_116038_, float p_116039_) {
//        float f = Mth.lerp(p_116039_, p_116035_.xBodyRotO, p_116035_.xBodyRot);
//        float f1 = Mth.lerp(p_116039_, p_116035_.zBodyRotO, p_116035_.zBodyRot);
//        p_116036_.translate(0.0D, 0.5D, 0.0D);
//        p_116036_.mulPose(Vector3f.YP.rotationDegrees(180.0F - p_116038_));
//        p_116036_.mulPose(Vector3f.XP.rotationDegrees(f));
//        p_116036_.mulPose(Vector3f.YP.rotationDegrees(f1));
//        p_116036_.translate(0.0D, (double)-1.2F, 0.0D);
//    }
//
//    protected float getBob(CelestialSquid p_116032_, float p_116033_) {
//        return Mth.lerp(p_116033_, p_116032_.oldTentacleAngle, p_116032_.tentacleAngle);
//    }
//
//}