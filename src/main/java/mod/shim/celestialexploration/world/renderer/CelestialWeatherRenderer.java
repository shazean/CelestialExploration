package mod.shim.celestialexploration.world.renderer;

import java.util.Random;
import javax.annotation.Nullable;

import com.mojang.blaze3d.systems.RenderSystem;

import mod.shim.celestialexploration.Main;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.CampfireBlock;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ActiveRenderInfo;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.LightTexture;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.culling.ClippingHelper;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.client.renderer.vertex.VertexBuffer;
import net.minecraft.client.settings.ParticleStatus;
import net.minecraft.client.shader.Framebuffer;
import net.minecraft.client.shader.ShaderGroup;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.fluid.FluidState;
import net.minecraft.particles.IParticleData;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.Direction;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.Heightmap;
import net.minecraftforge.client.IWeatherRenderHandler;

public class CelestialWeatherRenderer implements IWeatherRenderHandler {

	private static final ResourceLocation SULFUR_RAIN_LOCATION = new ResourceLocation(Main.MODID, "textures/environment/sulfur_rain.png");
	   private Minecraft minecraft;
	   private ClientWorld level;
	   private int ticks;
	   private int rainSoundTime;

	private final float[] rainSizeX = new float[1024];
	private final float[] rainSizeZ = new float[1024];


	@Override
	public void render(int ticks, float partialTicks, ClientWorld clientWorld, Minecraft mc, LightTexture lightmapIn,
			double xIn, double yIn, double zIn) {

//		renderRain(ticks, partialTicks, clientWorld, mc, lightmapIn, xIn, yIn, zIn);
//		this.minecraft = mc;
		

	}
	
	public void renderRain(int ticks, float partialTicks, ClientWorld clientWorld, Minecraft mc, LightTexture lightmapIn,
			double xIn, double yIn, double zIn) {
//		   private void renderSnowAndRain(LightTexture p_228438_1_, float p_228438_2_, double p_228438_3_, double p_228438_5_, double p_228438_7_) {


		float f = mc.level.getRainLevel(partialTicks);
		if (!(f <= 0.0F)) {
			lightmapIn.turnOnLightLayer();
			World world = mc.level;
			int i = MathHelper.floor(xIn);
			int j = MathHelper.floor(yIn);
			int k = MathHelper.floor(zIn);
			Tessellator tessellator = Tessellator.getInstance();
			BufferBuilder bufferbuilder = tessellator.getBuilder();
			RenderSystem.enableAlphaTest();
			RenderSystem.disableCull();
			RenderSystem.normal3f(0.0F, 1.0F, 0.0F);
			RenderSystem.enableBlend();
			RenderSystem.defaultBlendFunc();
			RenderSystem.defaultAlphaFunc();
			RenderSystem.enableDepthTest();
			int l = 5;
			if (Minecraft.useFancyGraphics()) {
				l = 10;
			}

			RenderSystem.depthMask(Minecraft.useShaderTransparency());
			int i1 = -1;
			RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
			BlockPos.Mutable blockpos$mutable = new BlockPos.Mutable();

			for(int j1 = k - l; j1 <= k + l; ++j1) {
				for(int k1 = i - l; k1 <= i + l; ++k1) {
					int l1 = (j1 - k + 16) * 32 + k1 - i + 16;
					double d0 = (double)this.rainSizeX[l1] * 0.5D;
					double d1 = (double)this.rainSizeZ[l1] * 0.5D;
					blockpos$mutable.set(k1, 0, j1);
					Biome biome = world.getBiome(blockpos$mutable);
					if (biome.getPrecipitation() != Biome.RainType.NONE) {
						int i2 = world.getHeightmapPos(Heightmap.Type.MOTION_BLOCKING, blockpos$mutable).getY();
						int j2 = j - l;
						int k2 = j + l;
						if (j2 < i2) {
							j2 = i2;
						}

						if (k2 < i2) {
							k2 = i2;
						}

						int l2 = i2;
						if (i2 < j) {
							l2 = j;
						}

						if (j2 != k2) {
							Random random = new Random((long)(k1 * k1 * 3121 + k1 * 45238971 ^ j1 * j1 * 418711 + j1 * 13761));
							blockpos$mutable.set(k1, j2, j1);
							float f2 = biome.getTemperature(blockpos$mutable);
							if (f2 >= 0.15F) {
								if (i1 != 0) {
									if (i1 >= 0) {
										tessellator.end();
									}

									i1 = 0;
									mc.getTextureManager().bind(SULFUR_RAIN_LOCATION);
									bufferbuilder.begin(7, DefaultVertexFormats.PARTICLE);
								}

								int i3 = ticks + k1 * k1 * 3121 + k1 * 45238971 + j1 * j1 * 418711 + j1 * 13761 & 31;
								float f3 = -((float)i3 + partialTicks) / 32.0F * (3.0F + random.nextFloat());
								double d2 = (double)((float)k1 + 0.5F) - xIn;
								double d4 = (double)((float)j1 + 0.5F) - zIn;
								float f4 = MathHelper.sqrt(d2 * d2 + d4 * d4) / (float)l;
								float f5 = ((1.0F - f4 * f4) * 0.5F + 0.5F) * f;
								blockpos$mutable.set(k1, l2, j1);
								int j3 = WorldRenderer.getLightColor(world, blockpos$mutable);
								bufferbuilder.vertex((double)k1 - xIn - d0 + 0.5D, (double)k2 - yIn, (double)j1 - zIn - d1 + 0.5D).uv(0.0F, (float)j2 * 0.25F + f3).color(1.0F, 1.0F, 1.0F, f5).uv2(j3).endVertex();
								bufferbuilder.vertex((double)k1 - xIn + d0 + 0.5D, (double)k2 - yIn, (double)j1 - zIn + d1 + 0.5D).uv(1.0F, (float)j2 * 0.25F + f3).color(1.0F, 1.0F, 1.0F, f5).uv2(j3).endVertex();
								bufferbuilder.vertex((double)k1 - xIn + d0 + 0.5D, (double)j2 - yIn, (double)j1 - zIn + d1 + 0.5D).uv(1.0F, (float)k2 * 0.25F + f3).color(1.0F, 1.0F, 1.0F, f5).uv2(j3).endVertex();
								bufferbuilder.vertex((double)k1 - xIn - d0 + 0.5D, (double)j2 - yIn, (double)j1 - zIn - d1 + 0.5D).uv(0.0F, (float)k2 * 0.25F + f3).color(1.0F, 1.0F, 1.0F, f5).uv2(j3).endVertex();
							} 
						}
					}
				}
			}

			if (i1 >= 0) {
				tessellator.end();
			}

			RenderSystem.enableCull();
			RenderSystem.disableBlend();
			RenderSystem.defaultAlphaFunc();
			RenderSystem.disableAlphaTest();
			lightmapIn.turnOffLightLayer();
		}
		
	}
	
	
	public void tickRain(ActiveRenderInfo p_228436_1_) {
	      net.minecraftforge.client.IWeatherParticleRenderHandler renderHandler = level.effects().getWeatherParticleRenderHandler();
	      if (renderHandler != null) {
	         renderHandler.render(ticks, level, minecraft, p_228436_1_);
	         return;
	      }
	      float f = this.minecraft.level.getRainLevel(1.0F) / (Minecraft.useFancyGraphics() ? 1.0F : 2.0F);
	      if (!(f <= 0.0F)) {
	         Random random = new Random((long)this.ticks * 312987231L);
	         IWorldReader iworldreader = this.minecraft.level;
	         BlockPos blockpos = new BlockPos(p_228436_1_.getPosition());
	         BlockPos blockpos1 = null;
	         int i = (int)(100.0F * f * f) / (this.minecraft.options.particles == ParticleStatus.DECREASED ? 2 : 1);

	         for(int j = 0; j < i; ++j) {
	            int k = random.nextInt(21) - 10;
	            int l = random.nextInt(21) - 10;
	            BlockPos blockpos2 = iworldreader.getHeightmapPos(Heightmap.Type.MOTION_BLOCKING, blockpos.offset(k, 0, l)).below();
	            Biome biome = iworldreader.getBiome(blockpos2);
	            if (blockpos2.getY() > 0 && blockpos2.getY() <= blockpos.getY() + 10 && blockpos2.getY() >= blockpos.getY() - 10 && biome.getPrecipitation() == Biome.RainType.RAIN && biome.getTemperature(blockpos2) >= 0.15F) {
	               blockpos1 = blockpos2;
	               if (this.minecraft.options.particles == ParticleStatus.MINIMAL) {
	                  break;
	               }

	               double d0 = random.nextDouble();
	               double d1 = random.nextDouble();
	               BlockState blockstate = iworldreader.getBlockState(blockpos2);
	               FluidState fluidstate = iworldreader.getFluidState(blockpos2);
	               VoxelShape voxelshape = blockstate.getCollisionShape(iworldreader, blockpos2);
	               double d2 = voxelshape.max(Direction.Axis.Y, d0, d1);
	               double d3 = (double)fluidstate.getHeight(iworldreader, blockpos2);
	               double d4 = Math.max(d2, d3);
	               IParticleData iparticledata = !fluidstate.is(FluidTags.LAVA) && !blockstate.is(Blocks.MAGMA_BLOCK) && !CampfireBlock.isLitCampfire(blockstate) ? ParticleTypes.RAIN : ParticleTypes.SMOKE;
	               this.minecraft.level.addParticle(iparticledata, (double)blockpos2.getX() + d0, (double)blockpos2.getY() + d4, (double)blockpos2.getZ() + d1, 0.0D, 0.0D, 0.0D);
	            }
	         }

	         if (blockpos1 != null && random.nextInt(3) < this.rainSoundTime++) {
	            this.rainSoundTime = 0;
	            if (blockpos1.getY() > blockpos.getY() + 1 && iworldreader.getHeightmapPos(Heightmap.Type.MOTION_BLOCKING, blockpos).getY() > MathHelper.floor((float)blockpos.getY())) {
	               this.minecraft.level.playLocalSound(blockpos1, SoundEvents.WEATHER_RAIN_ABOVE, SoundCategory.WEATHER, 0.1F, 0.5F, false);
	            } else {
	               this.minecraft.level.playLocalSound(blockpos1, SoundEvents.WEATHER_RAIN, SoundCategory.WEATHER, 0.2F, 1.0F, false);
	            }
	         }

	      }
	   }

}
