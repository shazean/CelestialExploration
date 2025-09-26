package com.shim.celestialexploration.entity.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Vector3f;
import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestialexploration.entity.client.model.MagCartModel;
import com.shim.celestialexploration.entity.vehicle.AbstractMagCart;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class MagCartRenderer<T extends AbstractMagCart> extends EntityRenderer<T> {
    private static final ResourceLocation MAGCART = new ResourceLocation(CelestialExploration.MODID, "textures/entity/magcart.png");
    protected final EntityModel<T> model;

//    public MagCartRenderer(EntityRendererProvider.Context manager) {
//        this(manager, MINECART_LOCATION);
//    }

    public MagCartRenderer(EntityRendererProvider.Context p_174300_, ModelLayerLocation p_174301_) {
        super(p_174300_);
        this.shadowRadius = 0.7F;
        this.model = new MagCartModel<>(p_174300_.bakeLayer(p_174301_));
    }


    public void render(T magcart, float p_115419_, float p_115420_, PoseStack poseStack, MultiBufferSource bufferSource, int p_115423_) {
        super.render(magcart, p_115419_, p_115420_, poseStack, bufferSource, p_115423_);
        poseStack.pushPose();

        poseStack.mulPose(Vector3f.YP.rotationDegrees(90.0F));
//        poseStack.mulPose(Vector3f.ZP.rotationDegrees(180.0F));
        poseStack.translate(0, 1.5, 0);

        long i = (long)magcart.getId() * 493286711L;
        i = i * i * 4392167121L + i * 98761L;
        float f = (((float)(i >> 16 & 7L) + 0.5F) / 8.0F - 0.5F) * 0.004F;
        float f1 = (((float)(i >> 20 & 7L) + 0.5F) / 8.0F - 0.5F) * 0.004F;
        float f2 = (((float)(i >> 24 & 7L) + 0.5F) / 8.0F - 0.5F) * 0.004F;
        poseStack.translate((double)f, (double)f1, (double)f2);
        double d0 = Mth.lerp((double)p_115420_, magcart.xOld, magcart.getX());
        double d1 = Mth.lerp((double)p_115420_, magcart.yOld, magcart.getY());
        double d2 = Mth.lerp((double)p_115420_, magcart.zOld, magcart.getZ());
        double d3 = (double)0.3F;
        Vec3 vec3 = magcart.getPos(d0, d1, d2);
        float f3 = Mth.lerp(p_115420_, magcart.xRotO, magcart.getXRot());
        if (vec3 != null) {
            Vec3 vec31 = magcart.getPosOffs(d0, d1, d2, (double)0.3F);
            Vec3 vec32 = magcart.getPosOffs(d0, d1, d2, (double)-0.3F);
            if (vec31 == null) {
                vec31 = vec3;
            }

            if (vec32 == null) {
                vec32 = vec3;
            }

            poseStack.translate(vec3.x - d0, (vec31.y + vec32.y) / 2.0D - d1, vec3.z - d2);
            Vec3 vec33 = vec32.add(-vec31.x, -vec31.y, -vec31.z);
            if (vec33.length() != 0.0D) {
                vec33 = vec33.normalize();
                p_115419_ = (float)(Math.atan2(vec33.z, vec33.x) * 180.0D / Math.PI);
                f3 = (float)(Math.atan(vec33.y) * 73.0D);
            }
        }

        poseStack.translate(0.0D, 0.375D, 0.0D);
        poseStack.mulPose(Vector3f.YP.rotationDegrees(180.0F - p_115419_)); //YP
        poseStack.mulPose(Vector3f.XP.rotationDegrees(f3)); //ZP
        float f5 = (float)magcart.getHurtTime() - p_115420_;
        float f6 = magcart.getDamage() - p_115420_;
        if (f6 < 0.0F) {
            f6 = 0.0F;
        }

        if (f5 > 0.0F) {
            poseStack.mulPose(Vector3f.XP.rotationDegrees(Mth.sin(f5) * f5 * f6 / 10.0F * (float)magcart.getHurtDir()));
        }

        int j = magcart.getDisplayOffset();
        BlockState blockstate = magcart.getDisplayBlockState();
        if (blockstate.getRenderShape() != RenderShape.INVISIBLE) {
            poseStack.pushPose();
            float f4 = 0.75F;
            poseStack.scale(0.75F, 0.75F, 0.75F);
            poseStack.translate(-0.5D, (double)((float)(j - 8) / 16.0F), 0.5D);
            poseStack.translate(0, -1.5, 0);
            poseStack.mulPose(Vector3f.YP.rotationDegrees(90.0F));
            this.renderMinecartContents(magcart, p_115420_, blockstate, poseStack, bufferSource, p_115423_);
            poseStack.popPose();
        }

        poseStack.scale(-1.0F, -1.0F, 1.0F);
        this.model.setupAnim(magcart, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
        VertexConsumer vertexconsumer = bufferSource.getBuffer(this.model.renderType(this.getTextureLocation(magcart)));
        this.model.renderToBuffer(poseStack, vertexconsumer, p_115423_, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
        poseStack.popPose();
    }

    public ResourceLocation getTextureLocation(T p_115416_) {
        return MAGCART;
    }

    protected void renderMinecartContents(T p_115424_, float p_115425_, BlockState p_115426_, PoseStack p_115427_, MultiBufferSource p_115428_, int p_115429_) {
        CelestialExploration.PROXY.getMinecraft().getBlockRenderer().renderSingleBlock(p_115426_, p_115427_, p_115428_, p_115429_, OverlayTexture.NO_OVERLAY);
    }
}