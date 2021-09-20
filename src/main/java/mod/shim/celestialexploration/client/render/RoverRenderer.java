package mod.shim.celestialexploration.client.render;

import mod.shim.celestialexploration.Main;
import mod.shim.celestialexploration.client.model.RoverModel;
import mod.shim.celestialexploration.client.render.mobs.layers.RoverHeldBlockLayer;
import mod.shim.celestialexploration.entity.RoverEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class RoverRenderer extends MobRenderer<RoverEntity, RoverModel<RoverEntity>> {

	public static final ResourceLocation TEXTURE = new ResourceLocation(Main.MODID, "textures/entity/rover/rover.png");

	public RoverRenderer(EntityRendererManager manager) {
		super(manager, new RoverModel<>(), 0.7f);
		this.addLayer(new RoverHeldBlockLayer(this));

	}

	@Override
	public ResourceLocation getTextureLocation(RoverEntity p_110775_1_) {
		//		System.out.println("RoverRenderer getTextureLocation");
		return TEXTURE;
	}

}
