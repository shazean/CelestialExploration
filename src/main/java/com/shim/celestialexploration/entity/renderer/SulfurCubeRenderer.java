package com.shim.celestialexploration.entity.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestialexploration.entity.SulfurCube;
import net.minecraft.client.model.LavaSlimeModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

public class SulfurCubeRenderer extends MobRenderer<SulfurCube, LavaSlimeModel<SulfurCube>> {
    private static final ResourceLocation SULFURCUBE_LOCATION = new ResourceLocation(CelestialExploration.MODID, "textures/entity/slime/sulfurcube.png");

    public SulfurCubeRenderer(EntityRendererProvider.Context p_174298_) {
        super(p_174298_, new LavaSlimeModel<>(p_174298_.bakeLayer(ModelLayers.MAGMA_CUBE)), 0.25F);
    }

    protected int getBlockLightLevel(SulfurCube p_115399_, BlockPos p_115400_) {
        return 15;
    }

    public ResourceLocation getTextureLocation(SulfurCube p_115393_) {
        return SULFURCUBE_LOCATION;
    }

    protected void scale(SulfurCube p_115395_, PoseStack p_115396_, float p_115397_) {
        int i = p_115395_.getSize();
        float f = Mth.lerp(p_115397_, p_115395_.oSquish, p_115395_.squish) / ((float)i * 0.5F + 1.0F);
        float f1 = 1.0F / (f + 1.0F);
        p_115396_.scale(f1 * (float)i, 1.0F / f1 * (float)i, f1 * (float)i);
    }
}