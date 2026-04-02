package com.shim.celestialexploration.entity.client.layers;

import com.mojang.blaze3d.vertex.PoseStack;
import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestialexploration.entity.client.model.CelestialAxolotlModel;
import com.shim.celestialexploration.entity.creatures.CelestialAxolotl;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.EyesLayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class StardustAxolotlGlowLayer<T extends CelestialAxolotl, M extends CelestialAxolotlModel<T>> extends EyesLayer<T, M> {
    private static final RenderType TEXTURE = RenderType.eyes(new ResourceLocation(CelestialExploration.MODID, "textures/entity/axolotl/axolotl_stardust_glow.png"));

    public StardustAxolotlGlowLayer(RenderLayerParent<T, M> renderLayerParent) {
        super(renderLayerParent);
    }

    @Override
    public void render(PoseStack poseStack, MultiBufferSource bufferSource, int p_116985_, T entity, float p_116987_, float p_116988_, float p_116989_, float p_116990_, float p_116991_, float p_116992_) {
        if (entity.getVariant() == CelestialAxolotl.Variant.STARDUST) {
            super.render(poseStack, bufferSource, p_116985_, entity, p_116987_, p_116988_, p_116989_, p_116990_, p_116991_, p_116992_);
        }
    }

    public RenderType renderType() {
        return TEXTURE;
    }
}
