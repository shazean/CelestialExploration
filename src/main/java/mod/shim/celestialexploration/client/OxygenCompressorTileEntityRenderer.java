//package mod.shim.celestialexploration.client;
//
//import com.mojang.blaze3d.matrix.MatrixStack;
//
//import mod.shim.celestialexploration.tileentity.OxygenCompressorTileEntity;
//import net.minecraft.client.Minecraft;
//import net.minecraft.client.entity.player.ClientPlayerEntity;
//import net.minecraft.client.gui.FontRenderer;
//import net.minecraft.client.renderer.IRenderTypeBuffer;
//import net.minecraft.client.renderer.LightTexture;
//import net.minecraft.client.renderer.model.IBakedModel;
//import net.minecraft.client.renderer.model.ItemCameraTransforms;
//import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
//import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
//import net.minecraft.item.ItemStack;
//import net.minecraft.util.math.BlockPos;
//import net.minecraft.util.math.vector.Matrix4f;
//import net.minecraft.util.math.vector.Quaternion;
//import net.minecraft.util.math.vector.Vector3f;
//import net.minecraft.util.text.ITextComponent;
//import net.minecraft.util.text.StringTextComponent;
//import net.minecraft.util.text.TranslationTextComponent;
//import net.minecraft.world.LightType;
//import net.minecraft.world.World;
//
//public class OxygenCompressorTileEntityRenderer extends TileEntityRenderer<OxygenCompressorTileEntity> {
//
//	private Minecraft mc = Minecraft.getInstance();
//	
//	
//	public OxygenCompressorTileEntityRenderer(TileEntityRendererDispatcher p_i226006_1_) {
//		super(p_i226006_1_);
//		// TODO Auto-generated constructor stub
//	}
//
//	@Override
//	public void render(OxygenCompressorTileEntity tileEntity, float partialTicks, MatrixStack matrixStackIn,
//			IRenderTypeBuffer bufferIn, int combinedLightIn, int combinedOverlayIn) {
//		
//
//		if (tileEntity.getItem().equals(ItemStack.EMPTY)) {
//			return;
//		}
//		
//		ClientPlayerEntity player = mc.player;
//		
//		int lightLevel = getLightLevel(tileEntity.getLevel(), tileEntity.getBlockPos().above());
//		
//		
//		renderItem(tileEntity.getItem(), new double[] {0.5d, 1d, 0.5d}, Vector3f.YP.rotationDegrees(180f - player.yRot), matrixStackIn, bufferIn, partialTicks,
//				combinedOverlayIn, lightLevel, 0.8f);
//		
//		//FIXME maybe?
//		ITextComponent label = tileEntity.getItem().hasCustomHoverName() ? tileEntity.getItem().getDisplayName() : new TranslationTextComponent(tileEntity.getItem().toString());
//		
//		renderLabel(matrixStackIn, bufferIn, lightLevel, new double[] {.5d, 1.3d, .5d}, label, 0xffffff);
//		
//		
//	}
//	
//	private void renderItem(ItemStack stack, double[] translation, Quaternion rotation, MatrixStack matrixStack, IRenderTypeBuffer buffer, float partialTicks, int combinedOverlay, int lightLevel, float scale) {
//		matrixStack.pushPose();
//		matrixStack.translate(translation[0], translation[1], translation[2]);
//		matrixStack.mulPose(rotation);
//		matrixStack.scale(scale, scale, scale);
//		
//		
//		IBakedModel model = mc.getItemRenderer().getModel(stack, null, null);
//		
//		mc.getItemRenderer().render(stack, ItemCameraTransforms.TransformType.GROUND, true, matrixStack, buffer, lightLevel, combinedOverlay, model);;
//		
//		matrixStack.popPose();
//		
//	}
//	
//	private void renderLabel(MatrixStack stack, IRenderTypeBuffer buffer, int lightLevel, double[] corner, ITextComponent text, int color) {
//
//		FontRenderer font = mc.font;
//		
//		stack.pushPose();
//		float scale = 0.01f;
//		int opacity = (int) (.4f * 255.0f) << 24;
//		float offset = (float) (-font.width(text) / 2);
//		Matrix4f matrix = stack.last().pose();
//		
//		stack.translate(corner[0], corner[1] + .4f, corner[2]);
//		stack.scale(scale, scale, scale);
////		stack.mulPose(mc.getRenderManager().getCameraOrientation());
//		stack.mulPose(Vector3f.ZP.rotationDegrees(180f));
//		
//		font.drawInBatch(text, offset, 0, color, false, matrix, buffer, false, opacity, lightLevel);
//		stack.popPose();
//	}
//	
////	2:40 FIXME	
//	private int getLightLevel(World world, BlockPos pos) {
//		int blockLight = world.getBrightness(LightType.BLOCK, pos);
//		int skyLight = world.getBrightness(LightType.SKY, pos);
//		return LightTexture.pack(blockLight, skyLight);
//		
//	}
//
//}
