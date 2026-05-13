package com.shim.celestialexploration.entity.client.renderer.creature;

import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestialexploration.entity.client.layers.LlamaHelmetLayer;
import com.shim.celestialexploration.entity.client.layers.SpaceLlamaDecorLayer;
import com.shim.celestialexploration.entity.client.model.SpaceLlamaModel;
import com.shim.celestialexploration.entity.creatures.SpaceTraderLlama;
import com.shim.celestialexploration.registry.CelestialModelLayers;
import net.minecraft.client.model.LlamaModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class SpaceLlamaRenderer extends MobRenderer<SpaceTraderLlama, SpaceLlamaModel<SpaceTraderLlama>> {
    private static final ResourceLocation[] LLAMA_LOCATIONS = new ResourceLocation[]{
            new ResourceLocation(CelestialExploration.MODID, "textures/entity/llama/creamy.png"),
            new ResourceLocation(CelestialExploration.MODID, "textures/entity/llama/white.png"),
            new ResourceLocation(CelestialExploration.MODID, "textures/entity/llama/brown.png"),
            new ResourceLocation(CelestialExploration.MODID, "textures/entity/llama/gray.png")};

    public SpaceLlamaRenderer(EntityRendererProvider.Context context) {
        super(context, new SpaceLlamaModel<>(context.bakeLayer(CelestialModelLayers.SPACE_LLAMA)), 0.7F);
        this.addLayer(new SpaceLlamaDecorLayer(this, context.getModelSet()));
//        this.addLayer(new LlamaHelmetLayer(this));
    }

    public ResourceLocation getTextureLocation(SpaceTraderLlama llama) {
        return LLAMA_LOCATIONS[llama.getVariant()];
    }
}