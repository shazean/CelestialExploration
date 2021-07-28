package mod.shim.celestialexploration.client.render;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import mod.shim.celestialexploration.client.model.ShuttleModel;
import mod.shim.celestialexploration.entity.item.ShuttleEntity;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.model.BoatModel;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.entity.item.BoatEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Quaternion;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.math.vector.Vector3f;

public class ShuttleRenderer extends EntityRenderer<ShuttleEntity> {
	   private static final ResourceLocation[] SHUTTLE_TEXTURE_LOCATIONS = new ResourceLocation[]{new ResourceLocation("textures/entity/shuttle/spruce.png"), new ResourceLocation("textures/entity/shuttle/oak.png")};
	   //FIXME ^^^ add all resource locations
	   protected final ShuttleModel model = new ShuttleModel();

	   public ShuttleRenderer(EntityRendererManager p_i46190_1_) {
	      super(p_i46190_1_);
	      this.shadowRadius = 0.8F;
	   }

	   public void render(ShuttleEntity p_225623_1_, float p_225623_2_, float p_225623_3_, MatrixStack p_225623_4_, IRenderTypeBuffer p_225623_5_, int p_225623_6_) {
		   		System.out.println("ShuttleRenderer: render START");
		      p_225623_4_.pushPose();
		      p_225623_4_.translate(0.0D, 0.375D, 0.0D);
		      p_225623_4_.mulPose(Vector3f.YP.rotationDegrees(180.0F - p_225623_2_));
		      float f = (float)p_225623_1_.getHurtTime() - p_225623_3_;
		      float f1 = p_225623_1_.getDamage() - p_225623_3_;
		      if (f1 < 0.0F) {
		         f1 = 0.0F;
		      }

		      if (f > 0.0F) {
		         p_225623_4_.mulPose(Vector3f.XP.rotationDegrees(MathHelper.sin(f) * f * f1 / 10.0F * (float)p_225623_1_.getHurtDir()));
		      }

//		      float f2 = p_225623_1_.getBubbleAngle(p_225623_3_);
//		      if (!MathHelper.equal(f2, 0.0F)) {
//		         p_225623_4_.mulPose(new Quaternion(new Vector3f(1.0F, 0.0F, 1.0F), f1, true));
//		      }

		      p_225623_4_.scale(-1.0F, -1.0F, 1.0F);
		      p_225623_4_.mulPose(Vector3f.YP.rotationDegrees(90.0F));
		      this.model.setupAnim(p_225623_1_, p_225623_3_, 0.0F, -0.1F, 0.0F, 0.0F);
		      IVertexBuilder ivertexbuilder = p_225623_5_.getBuffer(this.model.renderType(this.getTextureLocation(p_225623_1_)));
		      this.model.renderToBuffer(p_225623_4_, ivertexbuilder, p_225623_6_, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
		      if (!p_225623_1_.isUnderWater()) {
		         IVertexBuilder ivertexbuilder1 = p_225623_5_.getBuffer(RenderType.waterMask());
//		         this.model.waterPatch().render(p_225623_4_, ivertexbuilder1, p_225623_6_, OverlayTexture.NO_OVERLAY);
		      }

		      p_225623_4_.popPose();
		      super.render(p_225623_1_, p_225623_2_, p_225623_3_, p_225623_4_, p_225623_5_, p_225623_6_);
		   		System.out.println("ShuttleRenderer: render END");


	   }

	   public ResourceLocation getTextureLocation(ShuttleEntity p_110775_1_) {
	      return SHUTTLE_TEXTURE_LOCATIONS[p_110775_1_.getShuttleType().ordinal()];
	   }
}