package mod.shim.celestialexploration.client.render.mobs.slimes;

import com.mojang.blaze3d.matrix.MatrixStack;

import mod.shim.celestialexploration.Main;
import mod.shim.celestialexploration.client.model.mobs.slimes.MarsMallowModel;
import mod.shim.celestialexploration.client.render.mobs.layers.MarsMallowGelLayer;
import mod.shim.celestialexploration.entity.mobs.slimes.MarsMallowEntity;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;

public class MarsMallowRenderer extends MobRenderer<MarsMallowEntity, MarsMallowModel<MarsMallowEntity>> {
	   private static final ResourceLocation SLIME_LOCATION = new ResourceLocation(Main.MODID, "textures/entity/slime/mars_mallow.png");

	   public MarsMallowRenderer(EntityRendererManager p_i47193_1_) {
	      super(p_i47193_1_, new MarsMallowModel<>(16), 0.25F);
	      this.addLayer(new MarsMallowGelLayer<>(this));
	   }

	   public void render(MarsMallowEntity p_225623_1_, float p_225623_2_, float p_225623_3_, MatrixStack p_225623_4_, IRenderTypeBuffer p_225623_5_, int p_225623_6_) {
	      this.shadowRadius = 0.25F * (float)p_225623_1_.getSize();
	      super.render(p_225623_1_, p_225623_2_, p_225623_3_, p_225623_4_, p_225623_5_, p_225623_6_);
	   }

	   protected void scale(MarsMallowEntity p_225620_1_, MatrixStack p_225620_2_, float p_225620_3_) {
	      float f = 0.999F;
	      p_225620_2_.scale(0.999F, 0.999F, 0.999F);
	      p_225620_2_.translate(0.0D, (double)0.001F, 0.0D);
	      float f1 = (float)p_225620_1_.getSize();
	      float f2 = MathHelper.lerp(p_225620_3_, p_225620_1_.oSquish, p_225620_1_.squish) / (f1 * 0.5F + 1.0F);
	      float f3 = 1.0F / (f2 + 1.0F);
	      p_225620_2_.scale(f3 * f1, 1.0F / f3 * f1, f3 * f1);
	   }

	   public ResourceLocation getTextureLocation(MarsMallowEntity p_110775_1_) {
	      return SLIME_LOCATION;
	   }
	}