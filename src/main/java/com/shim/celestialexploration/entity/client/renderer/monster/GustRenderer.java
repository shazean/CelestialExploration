package com.shim.celestialexploration.entity.client.renderer.monster;

import com.mojang.blaze3d.vertex.PoseStack;
import com.shim.celestialexploration.entity.client.animators.GustAnimator;
import com.shim.celestialexploration.entity.monster.Gust;
import com.shim.celestialexploration.util.CelestialUtil;
import mod.azure.azurelib.render.entity.AzEntityRenderer;
import mod.azure.azurelib.render.entity.AzEntityRendererConfig;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;

@OnlyIn(Dist.CLIENT)
public class GustRenderer extends AzEntityRenderer<Gust> {
    private static final ResourceLocation GEO = CelestialUtil.getModLoc("geo/gust.geo.json");

    private static final ResourceLocation TEX = CelestialUtil.getModLoc("textures/entity/gust.png");

    public GustRenderer(EntityRendererProvider.Context context) {
        super(AzEntityRendererConfig.<Gust>builder(GEO, TEX).setAnimatorProvider(GustAnimator::new).build(), context);
    }

    @Override
    public void render(@NotNull Gust entity, float entityYaw, float partialTick, @NotNull PoseStack poseStack, @NotNull MultiBufferSource bufferSource, int packedLight) {
        this.scale(entity, poseStack, partialTick);
        poseStack.translate(0, 0.3F, 0);

        super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
    }

    protected void scale(Gust p_114046_, PoseStack p_114047_, float p_114048_) {
        float f = p_114046_.getSwelling(p_114048_);
        float f1 = 1.0F + Mth.sin(f * 100.0F) * f * 0.01F;
        f = Mth.clamp(f, 0.0F, 1.0F);
        f *= f;
        f *= f;
        float f2 = (1.0F + f * 0.4F) * f1;
        float f3 = (1.0F + f * 0.1F) / f1;
        p_114047_.scale(f2, f3, f2);
    }

    protected float getWhiteOverlayProgress(Gust p_114043_, float p_114044_) {
        float f = p_114043_.getSwelling(p_114044_);
        return (int)(f * 10.0F) % 2 == 0 ? 0.0F : Mth.clamp(f, 0.5F, 1.0F);
    }
}