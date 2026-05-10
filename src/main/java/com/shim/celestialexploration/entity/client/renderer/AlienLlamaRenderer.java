//package com.shim.celestialexploration.entity.client.renderer;
//
//import com.shim.celestialexploration.CelestialExploration;
//import com.shim.celestialexploration.entity.client.layers.AlienLlamaDecorLayer;
//import com.shim.celestialexploration.entity.client.layers.LlamaHelmetLayer;
//import com.shim.celestialexploration.entity.client.layers.SpaceLlamaDecorLayer;
//import com.shim.celestialexploration.entity.creatures.AlienTraderLlama;
//import com.shim.celestialexploration.entity.creatures.SpaceTraderLlama;
//import net.minecraft.client.model.LlamaModel;
//import net.minecraft.client.model.geom.ModelLayers;
//import net.minecraft.client.renderer.entity.EntityRendererProvider;
//import net.minecraft.client.renderer.entity.MobRenderer;
//import net.minecraft.resources.ResourceLocation;
//import net.minecraftforge.api.distmarker.Dist;
//import net.minecraftforge.api.distmarker.OnlyIn;
//
//@OnlyIn(Dist.CLIENT)
//public class AlienLlamaRenderer extends MobRenderer<AlienTraderLlama, LlamaModel<AlienTraderLlama>> {
//        private static final ResourceLocation[] LLAMA_LOCATIONS = new ResourceLocation[]{
//                new ResourceLocation(CelestialExploration.MODID, "textures/entity/llama/alien/green.png")};
//
//        public AlienLlamaRenderer(EntityRendererProvider.Context context) {
//            super(context, new LlamaModel<>(context.bakeLayer(ModelLayers.TRADER_LLAMA)), 0.7F);
//            this.addLayer(new AlienLlamaDecorLayer(this, context.getModelSet()));
//        }
//
//        public ResourceLocation getTextureLocation(AlienTraderLlama llama) {
//            return LLAMA_LOCATIONS[llama.getVariant()];
//        }
//    }