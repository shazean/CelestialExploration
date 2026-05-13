package com.shim.celestialexploration.entity.client.renderer.creature;

import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestialexploration.entity.client.layers.AlienLlamaDecorLayer;
import com.shim.celestialexploration.entity.client.model.AlienLlamaModel;
import com.shim.celestialexploration.entity.creatures.AlienTraderLlama;
import com.shim.celestialexploration.registry.CelestialModelLayers;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class AlienLlamaRenderer extends MobRenderer<AlienTraderLlama, AlienLlamaModel<AlienTraderLlama>> {
    //base Llama class is looking for 4 possible options, and it was easier to just have duplicate textures here than figure out how to override that cleanly
    //may fix later
    private static final ResourceLocation[] LLAMA_LOCATIONS = new ResourceLocation[]{
            new ResourceLocation(CelestialExploration.MODID, "textures/entity/llama/alien/green.png"),
            new ResourceLocation(CelestialExploration.MODID, "textures/entity/llama/alien/green.png"),
            new ResourceLocation(CelestialExploration.MODID, "textures/entity/llama/alien/green.png"),
            new ResourceLocation(CelestialExploration.MODID, "textures/entity/llama/alien/green.png")};

    public AlienLlamaRenderer(EntityRendererProvider.Context context) {
        super(context, new AlienLlamaModel<>(context.bakeLayer(CelestialModelLayers.ALIEN_LLAMA)), 0.7F);
        this.addLayer(new AlienLlamaDecorLayer(this, context.getModelSet()));
    }

    public ResourceLocation getTextureLocation(AlienTraderLlama llama) {
        return LLAMA_LOCATIONS[llama.getVariant()];
    }
}