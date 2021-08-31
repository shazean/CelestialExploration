package mod.shim.celestialexploration.client.render.mobs.slimes;

import com.mojang.blaze3d.matrix.MatrixStack;

import mod.shim.celestialexploration.Main;
import mod.shim.celestialexploration.client.model.mobs.slimes.SulfuricSlimeModel;
import mod.shim.celestialexploration.client.render.mobs.layers.SulfuricSlimeGelLayer;
import mod.shim.celestialexploration.entity.mobs.slimes.RustSlimeEntity;
import mod.shim.celestialexploration.entity.mobs.slimes.SulfuricSlimeEntity;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class SulfuricSlimeRenderer extends MobRenderer<SulfuricSlimeEntity, SulfuricSlimeModel<SulfuricSlimeEntity>> {
	   private static final ResourceLocation SLIME_LOCATION = new ResourceLocation(Main.MODID, "textures/entity/slime/sulfur.png");

	   public SulfuricSlimeRenderer(EntityRendererManager p_i47193_1_) {
	      super(p_i47193_1_, new SulfuricSlimeModel<>(16), 0.25F);
	      this.addLayer(new SulfuricSlimeGelLayer<>(this));
	   }

	   public void render(SulfuricSlimeEntity p_225623_1_, float p_225623_2_, float p_225623_3_, MatrixStack p_225623_4_, IRenderTypeBuffer p_225623_5_, int p_225623_6_) {
	      this.shadowRadius = 0.25F * (float)p_225623_1_.getSize();
	      super.render(p_225623_1_, p_225623_2_, p_225623_3_, p_225623_4_, p_225623_5_, p_225623_6_);
	   }

	   protected void scale(SulfuricSlimeEntity p_225620_1_, MatrixStack p_225620_2_, float p_225620_3_) {
	      float f = 0.999F;
	      p_225620_2_.scale(0.999F, 0.999F, 0.999F);
	      p_225620_2_.translate(0.0D, (double)0.001F, 0.0D);
	      float f1 = (float)p_225620_1_.getSize();
	      float f2 = MathHelper.lerp(p_225620_3_, p_225620_1_.oSquish, p_225620_1_.squish) / (f1 * 0.5F + 1.0F);
	      float f3 = 1.0F / (f2 + 1.0F);
	      p_225620_2_.scale(f3 * f1, 1.0F / f3 * f1, f3 * f1);
	   }

	   public ResourceLocation getTextureLocation(SulfuricSlimeEntity p_110775_1_) {
	      return SLIME_LOCATION;
	   }
	}