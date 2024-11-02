package com.shim.celestialexploration.entity.renderer;

import com.shim.celestialexploration.entity.CelestialCat;
import com.shim.celestialexploration.entity.layers.CatHelmetLayer;
import com.shim.celestialexploration.entity.layers.CelestialCatCollarLayer;
import net.minecraft.client.model.CatModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.CatCollarLayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.animal.Cat;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class CelestialCatRenderer extends MobRenderer<CelestialCat, CatModel<CelestialCat>> {
    public CelestialCatRenderer(EntityRendererProvider.Context p_173943_) {
        super(p_173943_, new CatModel<>(p_173943_.bakeLayer(ModelLayers.CAT)), 0.4F);
        this.addLayer(new CelestialCatCollarLayer(this, p_173943_.getModelSet()));
        this.addLayer(new CatHelmetLayer(this));
    }

    public ResourceLocation getTextureLocation(CelestialCat p_113950_) {
        return p_113950_.getResourceLocation();
    }
}