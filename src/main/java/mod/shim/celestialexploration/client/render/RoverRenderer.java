package mod.shim.celestialexploration.client.render;

import mod.shim.celestialexploration.Main;
import mod.shim.celestialexploration.client.model.RoverModel;
import mod.shim.celestialexploration.entity.RoverEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class RoverRenderer extends MobRenderer<RoverEntity, RoverModel<RoverEntity>> {

//	public RoverRenderer(EntityRendererManager p_i50965_1_, RoverModel<RoverEntity> p_i50965_2_, float p_i50965_3_) {
//		super(p_i50965_1_, p_i50965_2_, p_i50965_3_);
//		// TODO Auto-generated constructor stub
//	}
	
	public static final ResourceLocation TEXTURE = new ResourceLocation(Main.MODID, "textures/entity/rover/rover.png");
	
	public RoverRenderer(EntityRendererManager manager) {
		super(manager, new RoverModel<>(), 0.7f);
	}

	@Override
	public ResourceLocation getTextureLocation(RoverEntity p_110775_1_) {
		// TODO Auto-generated method stub
		return TEXTURE;
	}

}
