package mod.shim.celestialexploration.client.render.mobs.layers;

import com.mojang.blaze3d.matrix.MatrixStack;

import mod.shim.celestialexploration.client.model.RoverModel;
import mod.shim.celestialexploration.entity.RoverEntity;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.IEntityRenderer;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.entity.monster.EndermanEntity;
import net.minecraft.util.math.vector.Vector3f;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)

public class RoverHeldBlockLayer extends LayerRenderer<RoverEntity, RoverModel<RoverEntity>> {
	public RoverHeldBlockLayer(IEntityRenderer<RoverEntity, RoverModel<RoverEntity>> p_i50949_1_) {
		super(p_i50949_1_);
	}

	@SuppressWarnings("deprecation")
	public void render(MatrixStack p_225628_1_, IRenderTypeBuffer p_225628_2_, int p_225628_3_, RoverEntity p_225628_4_, float p_225628_5_, float p_225628_6_, float p_225628_7_, float p_225628_8_, float p_225628_9_, float p_225628_10_) {
		BlockState blockstate = p_225628_4_.getCarriedBlock();
//		   BlockState blockstate2 = Blocks.GLASS.defaultBlockState();

		if (blockstate != null) {
			p_225628_1_.pushPose();
			p_225628_1_.translate(0.3D, 0.8D, -1.6D);
			p_225628_1_.mulPose(Vector3f.XP.rotationDegrees(20.0F));
			p_225628_1_.mulPose(Vector3f.YP.rotationDegrees(45.0F));
			p_225628_1_.translate(0.25D, 0.1875D, 0.25D);
			float f = 0.5F;
			p_225628_1_.scale(-0.6F, -0.6F, 0.6F);
			p_225628_1_.mulPose(Vector3f.YP.rotationDegrees(90.0F));
			Minecraft.getInstance().getBlockRenderer().renderSingleBlock(blockstate, p_225628_1_, p_225628_2_, p_225628_3_, OverlayTexture.NO_OVERLAY);
			p_225628_1_.popPose();
		}
	}

}