//package com.shim.celestialexploration.entity.client.renderer;
//
//import com.google.common.collect.Maps;
//import com.shim.celestialexploration.CelestialExploration;
//import com.shim.celestialexploration.entity.client.layers.StardustAxolotlGlowLayer;
//import com.shim.celestialexploration.entity.client.layers.StardustSquidGlowLayer;
//import com.shim.celestialexploration.entity.client.model.CelestialAxolotlModel;
//import com.shim.celestialexploration.entity.creatures.CelestialAxolotl;
//import net.minecraft.Util;
//import net.minecraft.client.model.geom.ModelLayers;
//import net.minecraft.client.renderer.entity.EntityRendererProvider;
//import net.minecraft.client.renderer.entity.MobRenderer;
//import net.minecraft.resources.ResourceLocation;
//import net.minecraftforge.api.distmarker.Dist;
//import net.minecraftforge.api.distmarker.OnlyIn;
//
//import java.util.Map;
//
//@OnlyIn(Dist.CLIENT)
//public class CelestialAxolotlRenderer extends MobRenderer<CelestialAxolotl, CelestialAxolotlModel<CelestialAxolotl>> {
//    private static final Map<CelestialAxolotl.Variant, ResourceLocation> TEXTURE_BY_TYPE = Util.make(Maps.newHashMap(), (map) -> {
//        for(CelestialAxolotl.Variant axolotl$variant : CelestialAxolotl.Variant.BY_ID) {
//            map.put(axolotl$variant, new ResourceLocation(CelestialExploration.MODID, String.format("textures/entity/axolotl/axolotl_%s.png", axolotl$variant.getName())));
//        }
//    });
//
//    public CelestialAxolotlRenderer(EntityRendererProvider.Context context) {
//        super(context, new CelestialAxolotlModel<>(context.bakeLayer(ModelLayers.AXOLOTL)), 0.5F);
//        this.addLayer(new StardustAxolotlGlowLayer<>(this));
//    }
//
//    public ResourceLocation getTextureLocation(CelestialAxolotl axolotl) {
//        return TEXTURE_BY_TYPE.get(axolotl.getVariant());
//    }
//}