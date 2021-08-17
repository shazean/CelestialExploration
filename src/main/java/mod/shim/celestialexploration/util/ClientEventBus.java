package mod.shim.celestialexploration.util;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.systems.RenderSystem;

import mod.shim.celestialexploration.Main;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.FogRenderer;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldVertexBufferUploader;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.client.renderer.vertex.VertexBuffer;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.client.world.DimensionRenderInfo;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Matrix4f;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.math.vector.Vector3f;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.ISkyRenderHandler;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = Main.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientEventBus {

	private static final ResourceLocation SUN_TEXTURES = new ResourceLocation("textures/environment/sun.png");
	private static final ResourceLocation MOON_PHASES_TEXTURES = new ResourceLocation( "textures/environment/moon_phases.png");
//	private static final ResourceLocation SKY_TEXTURE = new ResourceLocation(Main.MODID,
//			"textures/environment/sky.png");

	
	
	 @OnlyIn(Dist.CLIENT)
	   public static class Mars extends DimensionRenderInfo {
	      public Mars() {
	         super(128, true, DimensionRenderInfo.FogType.NORMAL, true, false);
	      }

	      public Vector3d getBrightnessDependentFogColor(Vector3d fogColor, float partialTicks) {
	         return fogColor;
	      }

	      public boolean isFoggyAt(int p_230493_1_, int p_230493_2_) {
	         return true;
	      }
	      
	      
	      
	 	 @OnlyIn(Dist.CLIENT)
	     public ISkyRenderHandler setSkyRenderHandler() {
	 		return new ISkyRenderHandler() {
	 		 
				@Override
				public void render(int ticks, float partialTicks, MatrixStack matrixStack,
						ClientWorld world, Minecraft mc) {
			
					
				
						}
	 				};
					
				}

	 		};
	    	  
		
	   
	
	
	@SubscribeEvent(priority = EventPriority.HIGHEST)
	public static void clientSetup(FMLClientSetupEvent event) {
		// public net.minecraft.client.world.DimensionRenderInfo field_239208_a_ #
		// field_239208_a_
		// public net.minecraft.client.renderer.Minecraft.getInstance().worldRenderer
		// field_175012_t # skyVBO
		// public net.minecraft.client.renderer.Minecraft.getInstance().worldRenderer
		// field_175014_r # skyVertexFormat
		// public net.minecraft.client.renderer.Minecraft.getInstance().worldRenderer
		// field_175013_s # starVBO
		// public net.minecraft.client.renderer.Minecraft.getInstance().worldRenderer
		// field_175011_u # sky2VBO

		
		
		
		
//		DimensionRenderInfo.field_239208_a_.put(DIM_RENDER_INFO,
//				// cloudHeight, alternate sky color, fog type, render sky, diffuse lighting
//				new DimensionRenderInfo(128, true, DimensionRenderInfo.FogType.NORMAL, true, false) {
//
//					@Override
//					public Vector3d getBrightnessDependentFogColor(Vector3d fogColor, float partialTicks) {
//						// TODO Auto-generated method stub
//						return fogColor;
//					}
//
//					@Override
//					public boolean isFoggyAt(int posX, int posY) {
//						// TODO Auto-generated method stub
//						return false;
//					}

//					@Override
//					public ISkyRenderHandler getSkyRenderHandler() {
//						return new ISkyRenderHandler() {
//
//							@SuppressWarnings({ "resource", "deprecation" })
//							@Override
//							public void render(int ticks, float partialTicks, MatrixStack matrixStack,
//									ClientWorld world, Minecraft mc) {
//								RenderSystem.disableTexture();
//								Vector3d vector3d = world.getSkyColor(
//										Minecraft.getInstance().gameRenderer.getActiveRenderInfo().getBlockPos(),
//										partialTicks);
//								float f = (float) vector3d.x;
//								float f1 = (float) vector3d.y;
//								float f2 = (float) vector3d.z;
//								FogRenderer.applyFog();
//								BufferBuilder bufferbuilder = Tessellator.getInstance().getBuffer();
//								RenderSystem.depthMask(false);
//								RenderSystem.enableFog();
//								RenderSystem.color3f(f, f1, f2);
//
//								Minecraft.getInstance().worldRenderer.skyVBO.bindBuffer();
//								Minecraft.getInstance().worldRenderer.skyVertexFormat.setupBufferState(0L);
//								Minecraft.getInstance().worldRenderer.skyVBO.draw(matrixStack.last().getMatrix(), 7);
//								VertexBuffer.unbind();
//								Minecraft.getInstance().worldRenderer.skyVertexFormat.clearBufferState();
//								RenderSystem.disableFog();
//								RenderSystem.disableAlphaTest();
//								RenderSystem.enableBlend();
//								RenderSystem.defaultBlendFunc();
//								float[] afloat = world.func_239132_a_()
//										.func_230492_a_(world.func_242415_f(partialTicks), partialTicks);
//								if (afloat != null) {
//									RenderSystem.disableTexture();
//									RenderSystem.shadeModel(7425);
//									matrixStack.pushPose();
//									matrixStack.rotate(Vector3f.XP.rotationDegrees(90.0F));
//									float f3 = MathHelper.sin(world.getCelestialAngleRadians(partialTicks)) < 0.0F
//											? 180.0F
//											: 0.0F;
//									matrixStack.rotate(Vector3f.ZP.rotationDegrees(f3));
//									matrixStack.rotate(Vector3f.ZP.rotationDegrees(90.0F));
//									float f4 = afloat[0];
//									float f5 = afloat[1];
//									float f6 = afloat[2];
//									Matrix4f matrix4f = matrixStack.last().getMatrix();
//									bufferbuilder.begin(6, DefaultVertexFormats.POSITION_COLOR);
//									bufferbuilder.pos(matrix4f, 0.0F, 100.0F, 0.0F).color(f4, f5, f6, afloat[3])
//											.endVertex();
//
//									for (int j = 0; j <= 16; ++j) {
//										float f7 = (float) j * ((float) Math.PI * 2F) / 16.0F;
//										float f8 = MathHelper.sin(f7);
//										float f9 = MathHelper.cos(f7);
//										bufferbuilder.pos(matrix4f, f8 * 120.0F, f9 * 120.0F, -f9 * 40.0F * afloat[3])
//												.color(afloat[0], afloat[1], afloat[2], 0.0F).endVertex();
//									}
//
//									bufferbuilder.finishDrawing();
//									WorldVertexBufferUploader.draw(bufferbuilder);
//									matrixStack.popPose();
//									RenderSystem.shadeModel(7424);
//								}
//
//								RenderSystem.enableTexture();
//								RenderSystem.blendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA,
//										GlStateManager.DestFactor.ONE, GlStateManager.SourceFactor.ONE,
//										GlStateManager.DestFactor.ZERO);
//								matrixStack.pushPose();
//								float f11 = 1.0F - world.getRainStrength(partialTicks);
//								RenderSystem.color4f(1.0F, 1.0F, 1.0F, f11);
//								matrixStack.rotate(Vector3f.YP.rotationDegrees(-90.0F));
//								matrixStack.rotate(
//										Vector3f.XP.rotationDegrees(world.func_242415_f(partialTicks) * 360.0F));
//								Matrix4f matrix4f1 = matrixStack.last().getMatrix();
//								float f12 = 30.0F;
//								Minecraft.getInstance().getTextureManager().getTexture(SUN_TEXTURES);
//								bufferbuilder.begin(7, DefaultVertexFormats.POSITION_TEX);
//								bufferbuilder.pos(matrix4f1, -f12, 100.0F, -f12).tex(0.0F, 0.0F).endVertex();
//								bufferbuilder.pos(matrix4f1, f12, 100.0F, -f12).tex(1.0F, 0.0F).endVertex();
//								bufferbuilder.pos(matrix4f1, f12, 100.0F, f12).tex(1.0F, 1.0F).endVertex();
//								bufferbuilder.pos(matrix4f1, -f12, 100.0F, f12).tex(0.0F, 1.0F).endVertex();
//								bufferbuilder.finishDrawing();
//								WorldVertexBufferUploader.draw(bufferbuilder);
//								f12 = 20.0F;
//								Minecraft.getInstance().getTextureManager().getTexture(MOON_PHASES_TEXTURES);
//								int k = world.getMoonPhase();
//								int l = k % 4;
//								int i1 = k / 4 % 2;
//								float f13 = (float) (l + 0) / 4.0F;
//								float f14 = (float) (i1 + 0) / 2.0F;
//								float f15 = (float) (l + 1) / 4.0F;
//								float f16 = (float) (i1 + 1) / 2.0F;
//								bufferbuilder.begin(7, DefaultVertexFormats.POSITION_TEX);
//								bufferbuilder.pos(matrix4f1, -f12, -100.0F, f12).tex(f15, f16).endVertex();
//								bufferbuilder.pos(matrix4f1, f12, -100.0F, f12).tex(f13, f16).endVertex();
//								bufferbuilder.pos(matrix4f1, f12, -100.0F, -f12).tex(f13, f14).endVertex();
//								bufferbuilder.pos(matrix4f1, -f12, -100.0F, -f12).tex(f15, f14).endVertex();
//								bufferbuilder.finishDrawing();
//								WorldVertexBufferUploader.draw(bufferbuilder);
//								RenderSystem.disableTexture();
//								float f10 = world.getStarBrightness(partialTicks) * f11;
//								if (f10 > 0.0F) {
//									RenderSystem.color4f(f10, f10, f10, f10);
//									Minecraft.getInstance().worldRenderer.starVBO.bindBuffer();
//									Minecraft.getInstance().worldRenderer.skyVertexFormat.setupBufferState(0L);
//									Minecraft.getInstance().worldRenderer.starVBO
//											.draw(matrixStack.last().getMatrix(), 7);
//									VertexBuffer.unbind();
//									Minecraft.getInstance().worldRenderer.skyVertexFormat.clearBufferState();
//								}
//
//								RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
//								RenderSystem.disableBlend();
//								RenderSystem.enableAlphaTest();
//								RenderSystem.enableFog();
//  							    matrixStack.popPose();
//								RenderSystem.disableTexture();
//								RenderSystem.color3f(0.0F, 0.0F, 0.0F);
//								double d0 = Minecraft.getInstance().player.getEyePosition(partialTicks).y
//										- world.getWorldInfo().getVoidFogHeight();
//								if (d0 < 0.0D) {
//									matrixStack.pushPose();
//									matrixStack.translate(0.0D, 12.0D, 0.0D);
//									Minecraft.getInstance().worldRenderer.sky2VBO.bindBuffer();
//									Minecraft.getInstance().worldRenderer.skyVertexFormat.setupBufferState(0L);
//									Minecraft.getInstance().worldRenderer.sky2VBO
//											.draw(matrixStack.last().getMatrix(), 7);
//									VertexBuffer.unbind();
//									Minecraft.getInstance().worldRenderer.skyVertexFormat.clearBufferState();
//									matrixStack.pop();
//								}
//
//								if (world.func_239132_a_().func_239216_b_()) {
//									RenderSystem.color3f(f * 0.2F + 0.04F, f1 * 0.2F + 0.04F, f2 * 0.6F + 0.1F);
//								} else {
//									RenderSystem.color3f(f, f1, f2);
//								}
//								
//								Minecraft.getInstance().worldRenderer.skyVBO.bindBuffer();
//								Minecraft.getInstance().worldRenderer.skyVertexFormat.setupBufferState(0L);
//								Minecraft.getInstance().worldRenderer.skyVBO.draw(matrixStack.last().getMatrix(), 7);
//								VertexBuffer.unbind();
//								Minecraft.getInstance().worldRenderer.skyVertexFormat.clearBufferState();
//								
//								RenderSystem.enableTexture();
//								RenderSystem.blendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA,
//										GlStateManager.DestFactor.ONE, GlStateManager.SourceFactor.ONE,
//										GlStateManager.DestFactor.ZERO);
//								RenderSystem.color4f(0.8F, 0.8F, 0.8F, 0.2F);
//								Minecraft.getInstance().getTextureManager().getTexture(SKY_TEXTURE);
//								bufferbuilder.begin(7, DefaultVertexFormats.POSITION_TEX);
//								bufferbuilder.pos(64, 16, 64).tex(0.0F, 0.0F).endVertex();
//								bufferbuilder.pos(-64, 16, 64).tex(1.0F, 0.0F).endVertex();
//								bufferbuilder.pos(-64, 16, -64).tex(1.0F, 1.0F).endVertex();
//								bufferbuilder.pos(64, 16, -64).tex(0.0F, 1.0F).endVertex();
//								bufferbuilder.finishDrawing();
//								WorldVertexBufferUploader.draw(bufferbuilder);
//								RenderSystem.disableTexture();
//
//								RenderSystem.enableTexture();
//								RenderSystem.depthMask(true);
//								RenderSystem.disableFog();
//							}
//						};
//					}
//				});
	}
}