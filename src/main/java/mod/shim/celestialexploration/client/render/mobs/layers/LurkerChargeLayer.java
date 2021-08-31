package mod.shim.celestialexploration.client.render.mobs.layers;

import mod.shim.celestialexploration.client.model.mobs.LurkerModel;
import mod.shim.celestialexploration.entity.mobs.LurkerEntity;
import net.minecraft.client.renderer.entity.IEntityRenderer;
import net.minecraft.client.renderer.entity.layers.EnergyLayer;
import net.minecraft.client.renderer.entity.model.CreeperModel;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.entity.monster.CreeperEntity;
import net.minecraft.util.ResourceLocation;

public class LurkerChargeLayer extends EnergyLayer<LurkerEntity, LurkerModel<LurkerEntity>> {
	   private static final ResourceLocation POWER_LOCATION = new ResourceLocation("textures/entity/lurker/lurker_armor.png");
	   private final LurkerModel<LurkerEntity> model = new LurkerModel<>(2.0F);

	   public LurkerChargeLayer(IEntityRenderer<LurkerEntity, LurkerModel<LurkerEntity>> p_i50947_1_) {
	      super(p_i50947_1_);
	   }

	   protected float xOffset(float p_225634_1_) {
	      return p_225634_1_ * 0.01F;
	   }

	   protected ResourceLocation getTextureLocation() {
	      return POWER_LOCATION;
	   }

	   protected EntityModel<LurkerEntity> model() {
	      return this.model;
	   }
	}