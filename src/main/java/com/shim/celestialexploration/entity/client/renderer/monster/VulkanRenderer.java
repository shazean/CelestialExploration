package com.shim.celestialexploration.entity.client.renderer.monster;

import com.mojang.blaze3d.vertex.PoseStack;
import com.shim.celestialexploration.entity.client.animators.VulkanAnimator;
import com.shim.celestialexploration.entity.client.layers.VulkanSoulfireLayer;
import com.shim.celestialexploration.entity.monster.Vulkan;
import com.shim.celestialexploration.util.CelestialUtil;
import mod.azure.azurelib.render.entity.AzEntityRenderer;
import mod.azure.azurelib.render.entity.AzEntityRendererConfig;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;

@OnlyIn(Dist.CLIENT)
public class VulkanRenderer extends AzEntityRenderer<Vulkan> {
    private static final ResourceLocation GEO = CelestialUtil.getModLoc("geo/vulkan.geo.json");

    private static final ResourceLocation TEX = CelestialUtil.getModLoc("textures/entity/vulkan.png");

    public VulkanRenderer(EntityRendererProvider.Context context) {
        super(AzEntityRendererConfig.<Vulkan>builder(GEO, TEX)
                .setAnimatorProvider(VulkanAnimator::new)
                .addRenderLayer(new VulkanSoulfireLayer())
                .setScale(1.15F).build(), context);
    }

    @Override
    public void render(@NotNull Vulkan entity, float entityYaw, float partialTick, @NotNull PoseStack poseStack, @NotNull MultiBufferSource bufferSource, int packedLight) {
//        poseStack.translate(0, 0.3F, 0);

//        int scale = 1.1F;
//        poseStack.scale(scale, scale, scale);

        super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
    }
}