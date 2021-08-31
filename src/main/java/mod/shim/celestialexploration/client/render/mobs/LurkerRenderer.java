package mod.shim.celestialexploration.client.render.mobs;

import com.mojang.blaze3d.matrix.MatrixStack;

import mod.shim.celestialexploration.Main;
import mod.shim.celestialexploration.client.model.mobs.LurkerModel;
import mod.shim.celestialexploration.client.render.mobs.layers.LurkerChargeLayer;
import mod.shim.celestialexploration.client.render.mobs.layers.LurkerHelmetLayer;
import mod.shim.celestialexploration.entity.mobs.LurkerEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;

public class LurkerRenderer extends MobRenderer<LurkerEntity, LurkerModel<LurkerEntity>> {
	   private static final ResourceLocation LURKER_LOCATION = new ResourceLocation(Main.MODID, "textures/entity/lurker/lurker.png");

	   public LurkerRenderer(EntityRendererManager p_i46186_1_) {
	      super(p_i46186_1_, new LurkerModel<>(), 0.5F);
	      this.addLayer(new LurkerChargeLayer(this));
	      this.addLayer(new LurkerHelmetLayer(this));
	   }

	   protected void scale(LurkerEntity p_225620_1_, MatrixStack p_225620_2_, float p_225620_3_) {
	      float f = p_225620_1_.getSwelling(p_225620_3_);
	      float f1 = 1.0F + MathHelper.sin(f * 100.0F) * f * 0.01F;
	      f = MathHelper.clamp(f, 0.0F, 1.0F);
	      f = f * f;
	      f = f * f;
	      float f2 = (1.0F + f * 0.4F) * f1;
	      float f3 = (1.0F + f * 0.1F) / f1;
	      p_225620_2_.scale(f2, f3, f2);
	   }

	   protected float getWhiteOverlayProgress(LurkerEntity p_225625_1_, float p_225625_2_) {
	      float f = p_225625_1_.getSwelling(p_225625_2_);
	      return (int)(f * 10.0F) % 2 == 0 ? 0.0F : MathHelper.clamp(f, 0.5F, 1.0F);
	   }

	   public ResourceLocation getTextureLocation(LurkerEntity p_110775_1_) {
	      return LURKER_LOCATION;
	   }
	}