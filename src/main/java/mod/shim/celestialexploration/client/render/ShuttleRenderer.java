package mod.shim.celestialexploration.client.render;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import mod.shim.celestialexploration.Main;
import mod.shim.celestialexploration.client.model.ShuttleModel;
import mod.shim.celestialexploration.entity.item.ShuttleEntity;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Quaternion;
import net.minecraft.util.math.vector.Vector3f;

public class ShuttleRenderer<T extends ShuttleEntity> extends EntityRenderer<T> {
	
	   private static final ResourceLocation[] SHUTTLE_TEXTURE_LOCATIONS = new ResourceLocation[]{new ResourceLocation(Main.MODID, "textures/entity/shuttle/white.png"), new ResourceLocation(Main.MODID, "textures/entity/shuttle/red.png"), new ResourceLocation(Main.MODID, "textures/entity/shuttle/orange.png"), new ResourceLocation(Main.MODID, "textures/entity/shuttle/yellow.png"), new ResourceLocation(Main.MODID, "textures/entity/shuttle/green.png"), new ResourceLocation(Main.MODID, "textures/entity/shuttle/blue.png"), new ResourceLocation(Main.MODID, "textures/entity/shuttle/purle.png"), new ResourceLocation(Main.MODID, "textures/entity/shuttle/black.png")};

	   protected final ShuttleModel<?> model = new ShuttleModel<>();

	
	public ShuttleRenderer(EntityRendererManager manager) {
		super(manager);
	}
	
	
	@Override
	public void render(T p_225623_1_, float p_225623_2_, float p_225623_3_, MatrixStack p_225623_4_,
			IRenderTypeBuffer p_225623_5_, int p_225623_6_) {

			p_225623_4_.pushPose();
	      p_225623_4_.translate(0.0D, 0.375D, 0.0D);
	      p_225623_4_.mulPose(Vector3f.YP.rotationDegrees(180.0F - p_225623_2_));
	      p_225623_4_.scale(-1.0F, -1.0F, 1.0F);
	      p_225623_4_.mulPose(Vector3f.YP.rotationDegrees(90.0F));
	      this.model.setupAnim(p_225623_1_, p_225623_3_, 0.0F, -0.1F, 0.0F, 0.0F);
	      IVertexBuilder ivertexbuilder = p_225623_5_.getBuffer(this.model.renderType(this.getTextureLocation(p_225623_1_)));
	      this.model.renderToBuffer(p_225623_4_, ivertexbuilder, p_225623_6_, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
	      p_225623_4_.popPose();
	      super.render(p_225623_1_, p_225623_2_, p_225623_3_, p_225623_4_, p_225623_5_, p_225623_6_);
	      
	      
	}

	@Override
	public ResourceLocation getTextureLocation(T p_110775_1_) {
	      return SHUTTLE_TEXTURE_LOCATIONS[p_110775_1_.getShuttleColor().ordinal()];
	}

}