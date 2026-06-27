package com.shim.celestialexploration.entity.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Vector3f;
import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestialexploration.entity.client.animators.BuggyAnimator;
import com.shim.celestialexploration.entity.client.layers.SimpleGlowLayer;
import com.shim.celestialexploration.entity.vehicle.Buggy;
import com.shim.celestialexploration.entity.vehicle.Spaceship;
import com.shim.celestialexploration.util.CelestialUtil;
import mod.azure.azurelib.render.entity.AzEntityRenderer;
import mod.azure.azurelib.render.entity.AzEntityRendererConfig;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;

@OnlyIn(Dist.CLIENT)
public class BuggyRenderer extends AzEntityRenderer<Buggy> {

    public BuggyRenderer(EntityRendererProvider.Context context) {
        super(AzEntityRendererConfig.builder(BuggyRenderer::getModel, BuggyRenderer::getTexture).setAnimatorProvider(BuggyAnimator::new)
                .setScale(1.7F)
                .addRenderLayer(new SimpleGlowLayer<>())
                .build(), context);
    }

    public static ResourceLocation getModel(Buggy buggy) {
        return CelestialUtil.getModLoc("geo/buggy.geo.json");
    }

    public static ResourceLocation getTexture(Buggy buggy) {
        return CelestialUtil.getModLoc("textures/entity/buggy/buggy.png");
    }

    @Override
    public void render(@NotNull Buggy entity, float entityYaw, float partialTick, @NotNull PoseStack poseStack, @NotNull MultiBufferSource bufferSource, int packedLight) {

        entity.setJankyRotationFix(partialTick);

        super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
    }

}