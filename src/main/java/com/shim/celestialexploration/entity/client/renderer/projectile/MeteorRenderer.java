package com.shim.celestialexploration.entity.client.renderer.projectile;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Vector3f;
import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestialexploration.entity.projectile.MeteorProjectile;
import com.shim.celestialexploration.util.CelestialUtil;
import mod.azure.azurelib.rewrite.render.entity.AzEntityRenderer;
import mod.azure.azurelib.rewrite.render.entity.AzEntityRendererConfig;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;

@OnlyIn(Dist.CLIENT)
public class MeteorRenderer extends AzEntityRenderer<MeteorProjectile> {
    private static final ResourceLocation GEO = CelestialUtil.getModLoc("geo/meteor.geo.json");

    private static final ResourceLocation TEX = CelestialUtil.getModLoc("textures/entity/meteor.png");

    public MeteorRenderer(EntityRendererProvider.Context context) {
        super(AzEntityRendererConfig.<MeteorProjectile>builder(GEO, TEX).setScale(1.25F).build(), context);
    }

    @Override
    public void render(@NotNull MeteorProjectile entity, float entityYaw, float partialTick, @NotNull PoseStack poseStack, @NotNull MultiBufferSource bufferSource, int packedLight) {
        poseStack.mulPose(Vector3f.XP.rotationDegrees(35));

        super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
    }
}