package mod.shim.celestialexploration.world.renderer;

import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.SortedSet;

import javax.annotation.Nullable;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.systems.RenderSystem;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import it.unimi.dsi.fastutil.longs.Long2ObjectMap;
import it.unimi.dsi.fastutil.longs.Long2ObjectOpenHashMap;
import mod.shim.celestialexploration.Main;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.CampfireBlock;
import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.ISound;
import net.minecraft.client.renderer.ActiveRenderInfo;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.DestroyBlockProgress;
import net.minecraft.client.renderer.FogRenderer;
import net.minecraft.client.renderer.LightTexture;
import net.minecraft.client.renderer.RenderTimeManager;
import net.minecraft.client.renderer.RenderTypeBuffers;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.WorldVertexBufferUploader;
import net.minecraft.client.renderer.culling.ClippingHelper;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.client.renderer.vertex.VertexBuffer;
import net.minecraft.client.renderer.vertex.VertexFormat;
import net.minecraft.client.settings.CloudOption;
import net.minecraft.client.settings.ParticleStatus;
import net.minecraft.client.shader.Framebuffer;
import net.minecraft.client.shader.ShaderGroup;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.client.world.DimensionRenderInfo;
import net.minecraft.fluid.FluidState;
import net.minecraft.particles.IParticleData;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.tags.FluidTags;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Tuple3d;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.vector.Matrix4f;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.math.vector.Vector3f;
import net.minecraft.world.IBlockDisplayReader;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.LightType;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.Heightmap;

public class CelestialWorldRenderer extends WorldRenderer {
		   private static final Logger LOGGER = LogManager.getLogger();
		   private static final ResourceLocation MOON_LOCATION = new ResourceLocation("textures/environment/moon_phases.png");
		   private static final ResourceLocation SUN_LOCATION = new ResourceLocation("textures/environment/sun.png");
		   private static final ResourceLocation SOLAR_SUN_LOCATION = new ResourceLocation(Main.MODID +  ":textures/environment/sun.png");
		   private static final ResourceLocation EARTH_LOCATION = new ResourceLocation(Main.MODID +  ":textures/environment/earth.png");

		   private static final ResourceLocation CLOUDS_LOCATION = new ResourceLocation("textures/environment/clouds.png");
		   
		   private static final ResourceLocation END_SKY_LOCATION = new ResourceLocation("textures/environment/end_sky.png");
		   private static final ResourceLocation FORCEFIELD_LOCATION = new ResourceLocation("textures/misc/forcefield.png");
		   private static final ResourceLocation RAIN_LOCATION = new ResourceLocation("textures/environment/rain.png");
		   private static final ResourceLocation SULFUR_RAIN_LOCATION = new ResourceLocation(Main.MODID + ":textures/environment/sulfur_rain.png");

		   
		   private static final ResourceLocation SNOW_LOCATION = new ResourceLocation("textures/environment/snow.png");
		   public static final Direction[] DIRECTIONS = Direction.values();
		   private final Minecraft minecraft;
		   private final TextureManager textureManager;
		   private final EntityRendererManager entityRenderDispatcher;
		   private ClientWorld level;
//		   private final ObjectList<CelestialWorldRenderer.LocalRenderInformationContainer> renderChunks = new ObjectArrayList<>(69696);
		   private final Set<TileEntity> globalBlockEntities = Sets.newHashSet();
		   private final VertexFormat skyFormat = DefaultVertexFormats.POSITION;
		   @Nullable
		   private VertexBuffer starBuffer;
		   @Nullable
		   private VertexBuffer skyBuffer;
		   @Nullable
		   private VertexBuffer darkBuffer;
		   private boolean generateClouds = true;
		   @Nullable
		   private VertexBuffer cloudBuffer;
		   private final RenderTimeManager frameTimes = new RenderTimeManager(100);
		   private int ticks;
		   private final Int2ObjectMap<DestroyBlockProgress> destroyingBlocks = new Int2ObjectOpenHashMap<>();
		   private final Long2ObjectMap<SortedSet<DestroyBlockProgress>> destructionProgress = new Long2ObjectOpenHashMap<>();
		   private final Map<BlockPos, ISound> playingRecords = Maps.newHashMap();
		   @Nullable
		   private Framebuffer entityTarget;
		   @Nullable
		   private ShaderGroup entityEffect;
		   @Nullable
		   private Framebuffer translucentTarget;
		   @Nullable
		   private Framebuffer itemEntityTarget;
		   @Nullable
		   private Framebuffer particlesTarget;
		   @Nullable
		   private Framebuffer weatherTarget;
		   @Nullable
		   private Framebuffer cloudsTarget;
		   @Nullable
		   private ShaderGroup transparencyChain;
		   private int prevCloudX = Integer.MIN_VALUE;
		   private int prevCloudY = Integer.MIN_VALUE;
		   private int prevCloudZ = Integer.MIN_VALUE;
		   private Vector3d prevCloudColor = Vector3d.ZERO;
		   private CloudOption prevCloudsType;
		   @Nullable
		   private ClippingHelper capturedFrustum;
		   private final Tuple3d frustumPos = new Tuple3d(0.0D, 0.0D, 0.0D);
		   private int rainSoundTime;
		   private final float[] rainSizeX = new float[1024];
		   private final float[] rainSizeZ = new float[1024];

		   public CelestialWorldRenderer(Minecraft p_i225967_1_, RenderTypeBuffers p_i225967_2_) {
			   super(p_i225967_1_, p_i225967_2_);
		      this.minecraft = p_i225967_1_;
		      this.entityRenderDispatcher = p_i225967_1_.getEntityRenderDispatcher();
		      this.textureManager = p_i225967_1_.getTextureManager();

		      for(int i = 0; i < 32; ++i) {
		         for(int j = 0; j < 32; ++j) {
		            float f = (float)(j - 16);
		            float f1 = (float)(i - 16);
		            float f2 = MathHelper.sqrt(f * f + f1 * f1);
		            this.rainSizeX[i << 5 | j] = -f1 / f2;
		            this.rainSizeZ[i << 5 | j] = f / f2;
		         }
		      }

		      this.createStars();
		      this.createLightSky();
		      this.createDarkSky();
		   }

		   private void renderSnowAndRain(LightTexture p_228438_1_, float p_228438_2_, double p_228438_3_, double p_228438_5_, double p_228438_7_) {
		      net.minecraftforge.client.IWeatherRenderHandler renderHandler = level.effects().getWeatherRenderHandler();
		      if (renderHandler != null) {
		         renderHandler.render(ticks, p_228438_2_, level, minecraft, p_228438_1_, p_228438_3_, p_228438_5_, p_228438_7_);
		         return;
		      }
		      float f = this.minecraft.level.getRainLevel(p_228438_2_);
		      if (!(f <= 0.0F)) {
		         p_228438_1_.turnOnLightLayer();
		         World world = this.minecraft.level;
		         int i = MathHelper.floor(p_228438_3_);
		         int j = MathHelper.floor(p_228438_5_);
		         int k = MathHelper.floor(p_228438_7_);
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
		         float f1 = (float)this.ticks + p_228438_2_;
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
		                           this.minecraft.getTextureManager().bind(RAIN_LOCATION);
		                           bufferbuilder.begin(7, DefaultVertexFormats.PARTICLE);
		                        }

		                        int i3 = this.ticks + k1 * k1 * 3121 + k1 * 45238971 + j1 * j1 * 418711 + j1 * 13761 & 31;
		                        float f3 = -((float)i3 + p_228438_2_) / 32.0F * (3.0F + random.nextFloat());
		                        double d2 = (double)((float)k1 + 0.5F) - p_228438_3_;
		                        double d4 = (double)((float)j1 + 0.5F) - p_228438_7_;
		                        float f4 = MathHelper.sqrt(d2 * d2 + d4 * d4) / (float)l;
		                        float f5 = ((1.0F - f4 * f4) * 0.5F + 0.5F) * f;
		                        blockpos$mutable.set(k1, l2, j1);
		                        int j3 = getLightColor(world, blockpos$mutable);
		                        bufferbuilder.vertex((double)k1 - p_228438_3_ - d0 + 0.5D, (double)k2 - p_228438_5_, (double)j1 - p_228438_7_ - d1 + 0.5D).uv(0.0F, (float)j2 * 0.25F + f3).color(1.0F, 1.0F, 1.0F, f5).uv2(j3).endVertex();
		                        bufferbuilder.vertex((double)k1 - p_228438_3_ + d0 + 0.5D, (double)k2 - p_228438_5_, (double)j1 - p_228438_7_ + d1 + 0.5D).uv(1.0F, (float)j2 * 0.25F + f3).color(1.0F, 1.0F, 1.0F, f5).uv2(j3).endVertex();
		                        bufferbuilder.vertex((double)k1 - p_228438_3_ + d0 + 0.5D, (double)j2 - p_228438_5_, (double)j1 - p_228438_7_ + d1 + 0.5D).uv(1.0F, (float)k2 * 0.25F + f3).color(1.0F, 1.0F, 1.0F, f5).uv2(j3).endVertex();
		                        bufferbuilder.vertex((double)k1 - p_228438_3_ - d0 + 0.5D, (double)j2 - p_228438_5_, (double)j1 - p_228438_7_ - d1 + 0.5D).uv(0.0F, (float)k2 * 0.25F + f3).color(1.0F, 1.0F, 1.0F, f5).uv2(j3).endVertex();
		                     } else {
		                        if (i1 != 1) {
		                           if (i1 >= 0) {
		                              tessellator.end();
		                           }

		                           i1 = 1;
		                           this.minecraft.getTextureManager().bind(SNOW_LOCATION);
		                           bufferbuilder.begin(7, DefaultVertexFormats.PARTICLE);
		                        }

		                        float f6 = -((float)(this.ticks & 511) + p_228438_2_) / 512.0F;
		                        float f7 = (float)(random.nextDouble() + (double)f1 * 0.01D * (double)((float)random.nextGaussian()));
		                        float f8 = (float)(random.nextDouble() + (double)(f1 * (float)random.nextGaussian()) * 0.001D);
		                        double d3 = (double)((float)k1 + 0.5F) - p_228438_3_;
		                        double d5 = (double)((float)j1 + 0.5F) - p_228438_7_;
		                        float f9 = MathHelper.sqrt(d3 * d3 + d5 * d5) / (float)l;
		                        float f10 = ((1.0F - f9 * f9) * 0.3F + 0.5F) * f;
		                        blockpos$mutable.set(k1, l2, j1);
		                        int k3 = getLightColor(world, blockpos$mutable);
		                        int l3 = k3 >> 16 & '\uffff';
		                        int i4 = (k3 & '\uffff') * 3;
		                        int j4 = (l3 * 3 + 240) / 4;
		                        int k4 = (i4 * 3 + 240) / 4;
		                        bufferbuilder.vertex((double)k1 - p_228438_3_ - d0 + 0.5D, (double)k2 - p_228438_5_, (double)j1 - p_228438_7_ - d1 + 0.5D).uv(0.0F + f7, (float)j2 * 0.25F + f6 + f8).color(1.0F, 1.0F, 1.0F, f10).uv2(k4, j4).endVertex();
		                        bufferbuilder.vertex((double)k1 - p_228438_3_ + d0 + 0.5D, (double)k2 - p_228438_5_, (double)j1 - p_228438_7_ + d1 + 0.5D).uv(1.0F + f7, (float)j2 * 0.25F + f6 + f8).color(1.0F, 1.0F, 1.0F, f10).uv2(k4, j4).endVertex();
		                        bufferbuilder.vertex((double)k1 - p_228438_3_ + d0 + 0.5D, (double)j2 - p_228438_5_, (double)j1 - p_228438_7_ + d1 + 0.5D).uv(1.0F + f7, (float)k2 * 0.25F + f6 + f8).color(1.0F, 1.0F, 1.0F, f10).uv2(k4, j4).endVertex();
		                        bufferbuilder.vertex((double)k1 - p_228438_3_ - d0 + 0.5D, (double)j2 - p_228438_5_, (double)j1 - p_228438_7_ - d1 + 0.5D).uv(0.0F + f7, (float)k2 * 0.25F + f6 + f8).color(1.0F, 1.0F, 1.0F, f10).uv2(k4, j4).endVertex();
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
		         p_228438_1_.turnOffLightLayer();
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

	

		   private void createDarkSky() {
		      Tessellator tessellator = Tessellator.getInstance();
		      BufferBuilder bufferbuilder = tessellator.getBuilder();
		      if (this.darkBuffer != null) {
		         this.darkBuffer.close();
		      }

		      this.darkBuffer = new VertexBuffer(this.skyFormat);
		      this.drawSkyHemisphere(bufferbuilder, -16.0F, true);
		      bufferbuilder.end();
		      this.darkBuffer.upload(bufferbuilder);
		   }

		   private void createLightSky() {
		      Tessellator tessellator = Tessellator.getInstance();
		      BufferBuilder bufferbuilder = tessellator.getBuilder();
		      if (this.skyBuffer != null) {
		         this.skyBuffer.close();
		      }

		      this.skyBuffer = new VertexBuffer(this.skyFormat);
		      this.drawSkyHemisphere(bufferbuilder, 16.0F, false);
		      bufferbuilder.end();
		      this.skyBuffer.upload(bufferbuilder);
		   }

		   private void drawSkyHemisphere(BufferBuilder p_174968_1_, float p_174968_2_, boolean p_174968_3_) {
		      p_174968_1_.begin(7, DefaultVertexFormats.POSITION);

		      for(int k = -384; k <= 384; k += 64) {
		         for(int l = -384; l <= 384; l += 64) {
		            float f = (float)k;
		            float f1 = (float)(k + 64);
		            if (p_174968_3_) {
		               f1 = (float)k;
		               f = (float)(k + 64);
		            }

		            p_174968_1_.vertex((double)f, (double)p_174968_2_, (double)l).endVertex();
		            p_174968_1_.vertex((double)f1, (double)p_174968_2_, (double)l).endVertex();
		            p_174968_1_.vertex((double)f1, (double)p_174968_2_, (double)(l + 64)).endVertex();
		            p_174968_1_.vertex((double)f, (double)p_174968_2_, (double)(l + 64)).endVertex();
		         }
		      }

		   }

		   private void createStars() {
		      Tessellator tessellator = Tessellator.getInstance();
		      BufferBuilder bufferbuilder = tessellator.getBuilder();
		      if (this.starBuffer != null) {
		         this.starBuffer.close();
		      }

		      this.starBuffer = new VertexBuffer(this.skyFormat);
		      this.drawStars(bufferbuilder);
		      bufferbuilder.end();
		      this.starBuffer.upload(bufferbuilder);
		   }

		   private void drawStars(BufferBuilder p_180444_1_) {
		      Random random = new Random(10842L);
		      p_180444_1_.begin(7, DefaultVertexFormats.POSITION);

		      for(int i = 0; i < 1500; ++i) {
		         double d0 = (double)(random.nextFloat() * 2.0F - 1.0F);
		         double d1 = (double)(random.nextFloat() * 2.0F - 1.0F);
		         double d2 = (double)(random.nextFloat() * 2.0F - 1.0F);
		         double d3 = (double)(0.15F + random.nextFloat() * 0.1F);
		         double d4 = d0 * d0 + d1 * d1 + d2 * d2;
		         if (d4 < 1.0D && d4 > 0.01D) {
		            d4 = 1.0D / Math.sqrt(d4);
		            d0 = d0 * d4;
		            d1 = d1 * d4;
		            d2 = d2 * d4;
		            double d5 = d0 * 100.0D;
		            double d6 = d1 * 100.0D;
		            double d7 = d2 * 100.0D;
		            double d8 = Math.atan2(d0, d2);
		            double d9 = Math.sin(d8);
		            double d10 = Math.cos(d8);
		            double d11 = Math.atan2(Math.sqrt(d0 * d0 + d2 * d2), d1);
		            double d12 = Math.sin(d11);
		            double d13 = Math.cos(d11);
		            double d14 = random.nextDouble() * Math.PI * 2.0D;
		            double d15 = Math.sin(d14);
		            double d16 = Math.cos(d14);

		            for(int j = 0; j < 4; ++j) {
		               double d18 = (double)((j & 2) - 1) * d3;
		               double d19 = (double)((j + 1 & 2) - 1) * d3;
		               double d21 = d18 * d16 - d19 * d15;
		               double d22 = d19 * d16 + d18 * d15;
		               double d23 = d21 * d12 + 0.0D * d13;
		               double d24 = 0.0D * d12 - d21 * d13;
		               double d25 = d24 * d9 - d22 * d10;
		               double d26 = d22 * d9 + d24 * d10;
		               p_180444_1_.vertex(d5 + d25, d6 + d23, d7 + d26).endVertex();
		            }
		         }
		      }

		   }
		   
		   @Override
		   public void renderSky(MatrixStack p_228424_1_, float p_228424_2_) {
//			   if (World.dimension().location().toString() == "celestialexploration:moon") {
				   
//			   }
		      net.minecraftforge.client.ISkyRenderHandler renderHandler = level.effects().getSkyRenderHandler();
		      if (renderHandler != null) {
		         renderHandler.render(ticks, p_228424_2_, p_228424_1_, level, minecraft);
		         return;
		      }
		      if (this.minecraft.level.effects().skyType() == DimensionRenderInfo.FogType.NORMAL) {
		         RenderSystem.disableTexture();
		         Vector3d vector3d = this.level.getSkyColor(this.minecraft.gameRenderer.getMainCamera().getBlockPosition(), p_228424_2_);
		         float f = (float)vector3d.x;
		         float f1 = (float)vector3d.y;
		         float f2 = (float)vector3d.z;
		         FogRenderer.levelFogColor();
		         BufferBuilder bufferbuilder = Tessellator.getInstance().getBuilder();
		         RenderSystem.depthMask(false);
		         RenderSystem.enableFog();
		         RenderSystem.color3f(f, f1, f2);
		         this.skyBuffer.bind();
		         this.skyFormat.setupBufferState(0L);
		         this.skyBuffer.draw(p_228424_1_.last().pose(), 7);
		         VertexBuffer.unbind();
		         this.skyFormat.clearBufferState();
		         RenderSystem.disableFog();
		         RenderSystem.disableAlphaTest();
		         RenderSystem.enableBlend();
		         RenderSystem.defaultBlendFunc();
		         float[] afloat = this.level.effects().getSunriseColor(this.level.getTimeOfDay(p_228424_2_), p_228424_2_);
		         if (afloat != null) {
		            RenderSystem.disableTexture();
		            RenderSystem.shadeModel(7425);
		            p_228424_1_.pushPose();
		            p_228424_1_.mulPose(Vector3f.XP.rotationDegrees(90.0F));
		            float f3 = MathHelper.sin(this.level.getSunAngle(p_228424_2_)) < 0.0F ? 180.0F : 0.0F;
		            p_228424_1_.mulPose(Vector3f.ZP.rotationDegrees(f3));
		            p_228424_1_.mulPose(Vector3f.ZP.rotationDegrees(90.0F));
		            float f4 = afloat[0];
		            float f5 = afloat[1];
		            float f6 = afloat[2];
		            Matrix4f matrix4f = p_228424_1_.last().pose();
		            bufferbuilder.begin(6, DefaultVertexFormats.POSITION_COLOR);
		            bufferbuilder.vertex(matrix4f, 0.0F, 100.0F, 0.0F).color(f4, f5, f6, afloat[3]).endVertex();
		            int i = 16;

		            for(int j = 0; j <= 16; ++j) {
		               float f7 = (float)j * ((float)Math.PI * 2F) / 16.0F;
		               float f8 = MathHelper.sin(f7);
		               float f9 = MathHelper.cos(f7);
		               bufferbuilder.vertex(matrix4f, f8 * 120.0F, f9 * 120.0F, -f9 * 40.0F * afloat[3]).color(afloat[0], afloat[1], afloat[2], 0.0F).endVertex();
		            }

		            bufferbuilder.end();
		            WorldVertexBufferUploader.end(bufferbuilder);
		            p_228424_1_.popPose();
		            RenderSystem.shadeModel(7424);
		         }

		         RenderSystem.enableTexture();
		         RenderSystem.blendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
		         p_228424_1_.pushPose();
		         float f11 = 1.0F - this.level.getRainLevel(p_228424_2_);
		         RenderSystem.color4f(1.0F, 1.0F, 1.0F, f11);
		         p_228424_1_.mulPose(Vector3f.YP.rotationDegrees(-90.0F));
		         p_228424_1_.mulPose(Vector3f.XP.rotationDegrees(this.level.getTimeOfDay(p_228424_2_) * 360.0F));
		         Matrix4f matrix4f1 = p_228424_1_.last().pose();
		         float f12 = 30.0F;
		         this.textureManager.bind(SUN_LOCATION);
		         bufferbuilder.begin(7, DefaultVertexFormats.POSITION_TEX);
		         bufferbuilder.vertex(matrix4f1, -f12, 100.0F, -f12).uv(0.0F, 0.0F).endVertex();
		         bufferbuilder.vertex(matrix4f1, f12, 100.0F, -f12).uv(1.0F, 0.0F).endVertex();
		         bufferbuilder.vertex(matrix4f1, f12, 100.0F, f12).uv(1.0F, 1.0F).endVertex();
		         bufferbuilder.vertex(matrix4f1, -f12, 100.0F, f12).uv(0.0F, 1.0F).endVertex();
		         bufferbuilder.end();
		         WorldVertexBufferUploader.end(bufferbuilder);
		         f12 = 20.0F;
		         this.textureManager.bind(MOON_LOCATION);
		         int k = this.level.getMoonPhase();
		         int l = k % 4;
		         int i1 = k / 4 % 2;
		         float f13 = (float)(l + 0) / 4.0F;
		         float f14 = (float)(i1 + 0) / 2.0F;
		         float f15 = (float)(l + 1) / 4.0F;
		         float f16 = (float)(i1 + 1) / 2.0F;
		         bufferbuilder.begin(7, DefaultVertexFormats.POSITION_TEX);
		         bufferbuilder.vertex(matrix4f1, -f12, -100.0F, f12).uv(f15, f16).endVertex();
		         bufferbuilder.vertex(matrix4f1, f12, -100.0F, f12).uv(f13, f16).endVertex();
		         bufferbuilder.vertex(matrix4f1, f12, -100.0F, -f12).uv(f13, f14).endVertex();
		         bufferbuilder.vertex(matrix4f1, -f12, -100.0F, -f12).uv(f15, f14).endVertex();
		         bufferbuilder.end();
		         WorldVertexBufferUploader.end(bufferbuilder);
		         RenderSystem.disableTexture();
		         float f10 = this.level.getStarBrightness(p_228424_2_) * f11;
		         if (f10 > 0.0F) {
		            RenderSystem.color4f(f10, f10, f10, f10);
		            this.starBuffer.bind();
		            this.skyFormat.setupBufferState(0L);
		            this.starBuffer.draw(p_228424_1_.last().pose(), 7);
		            VertexBuffer.unbind();
		            this.skyFormat.clearBufferState();
		         }

		         RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
		         RenderSystem.disableBlend();
		         RenderSystem.enableAlphaTest();
		         RenderSystem.enableFog();
		         p_228424_1_.popPose();
		         RenderSystem.disableTexture();
		         RenderSystem.color3f(0.0F, 0.0F, 0.0F);
		         double d0 = this.minecraft.player.getEyePosition(p_228424_2_).y - this.level.getLevelData().getHorizonHeight();
		         if (d0 < 0.0D) {
		            p_228424_1_.pushPose();
		            p_228424_1_.translate(0.0D, 12.0D, 0.0D);
		            this.darkBuffer.bind();
		            this.skyFormat.setupBufferState(0L);
		            this.darkBuffer.draw(p_228424_1_.last().pose(), 7);
		            VertexBuffer.unbind();
		            this.skyFormat.clearBufferState();
		            p_228424_1_.popPose();
		         }

		         if (this.level.effects().hasGround()) {
		            RenderSystem.color3f(f * 0.2F + 0.04F, f1 * 0.2F + 0.04F, f2 * 0.6F + 0.1F);
		         } else {
		            RenderSystem.color3f(f, f1, f2);
		         }

		         RenderSystem.enableTexture();
		         RenderSystem.depthMask(true);
		         RenderSystem.disableFog();
		      }
		   }

		   public void renderClouds(MatrixStack p_228425_1_, float p_228425_2_, double p_228425_3_, double p_228425_5_, double p_228425_7_) {
		      net.minecraftforge.client.ICloudRenderHandler renderHandler = level.effects().getCloudRenderHandler();
		      if (renderHandler != null) {
		         renderHandler.render(ticks, p_228425_2_, p_228425_1_, level, minecraft, p_228425_3_, p_228425_5_, p_228425_7_);
		         return;
		      }
		      float f = this.level.effects().getCloudHeight();
		      if (!Float.isNaN(f)) {
		         RenderSystem.disableCull();
		         RenderSystem.enableBlend();
		         RenderSystem.enableAlphaTest();
		         RenderSystem.enableDepthTest();
		         RenderSystem.defaultAlphaFunc();
		         RenderSystem.blendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA);
		         RenderSystem.enableFog();
		         RenderSystem.depthMask(true);
		         double d1 = (double)(((float)this.ticks + p_228425_2_) * 0.03F);
		         double d2 = (p_228425_3_ + d1) / 12.0D;
		         double d3 = (double)(f - (float)p_228425_5_ + 0.33F);
		         double d4 = p_228425_7_ / 12.0D + (double)0.33F;
		         d2 = d2 - (double)(MathHelper.floor(d2 / 2048.0D) * 2048);
		         d4 = d4 - (double)(MathHelper.floor(d4 / 2048.0D) * 2048);
		         float f3 = (float)(d2 - (double)MathHelper.floor(d2));
		         float f4 = (float)(d3 / 4.0D - (double)MathHelper.floor(d3 / 4.0D)) * 4.0F;
		         float f5 = (float)(d4 - (double)MathHelper.floor(d4));
		         Vector3d vector3d = this.level.getCloudColor(p_228425_2_);
		         int i = (int)Math.floor(d2);
		         int j = (int)Math.floor(d3 / 4.0D);
		         int k = (int)Math.floor(d4);
		         if (i != this.prevCloudX || j != this.prevCloudY || k != this.prevCloudZ || this.minecraft.options.getCloudsType() != this.prevCloudsType || this.prevCloudColor.distanceToSqr(vector3d) > 2.0E-4D) {
		            this.prevCloudX = i;
		            this.prevCloudY = j;
		            this.prevCloudZ = k;
		            this.prevCloudColor = vector3d;
		            this.prevCloudsType = this.minecraft.options.getCloudsType();
		            this.generateClouds = true;
		         }

		         if (this.generateClouds) {
		            this.generateClouds = false;
		            BufferBuilder bufferbuilder = Tessellator.getInstance().getBuilder();
		            if (this.cloudBuffer != null) {
		               this.cloudBuffer.close();
		            }

		            this.cloudBuffer = new VertexBuffer(DefaultVertexFormats.POSITION_TEX_COLOR_NORMAL);
		            this.buildClouds(bufferbuilder, d2, d3, d4, vector3d);
		            bufferbuilder.end();
		            this.cloudBuffer.upload(bufferbuilder);
		         }

		         this.textureManager.bind(CLOUDS_LOCATION);
		         p_228425_1_.pushPose();
		         p_228425_1_.scale(12.0F, 1.0F, 12.0F);
		         p_228425_1_.translate((double)(-f3), (double)f4, (double)(-f5));
		         if (this.cloudBuffer != null) {
		            this.cloudBuffer.bind();
		            DefaultVertexFormats.POSITION_TEX_COLOR_NORMAL.setupBufferState(0L);
		            int i1 = this.prevCloudsType == CloudOption.FANCY ? 0 : 1;

		            for(int l = i1; l < 2; ++l) {
		               if (l == 0) {
		                  RenderSystem.colorMask(false, false, false, false);
		               } else {
		                  RenderSystem.colorMask(true, true, true, true);
		               }

		               this.cloudBuffer.draw(p_228425_1_.last().pose(), 7);
		            }

		            VertexBuffer.unbind();
		            DefaultVertexFormats.POSITION_TEX_COLOR_NORMAL.clearBufferState();
		         }

		         p_228425_1_.popPose();
		         RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
		         RenderSystem.disableAlphaTest();
		         RenderSystem.enableCull();
		         RenderSystem.disableBlend();
		         RenderSystem.disableFog();
		      }
		   }

		   private void buildClouds(BufferBuilder p_204600_1_, double p_204600_2_, double p_204600_4_, double p_204600_6_, Vector3d p_204600_8_) {
		      float f3 = (float)MathHelper.floor(p_204600_2_) * 0.00390625F;
		      float f4 = (float)MathHelper.floor(p_204600_6_) * 0.00390625F;
		      float f5 = (float)p_204600_8_.x;
		      float f6 = (float)p_204600_8_.y;
		      float f7 = (float)p_204600_8_.z;
		      float f8 = f5 * 0.9F;
		      float f9 = f6 * 0.9F;
		      float f10 = f7 * 0.9F;
		      float f11 = f5 * 0.7F;
		      float f12 = f6 * 0.7F;
		      float f13 = f7 * 0.7F;
		      float f14 = f5 * 0.8F;
		      float f15 = f6 * 0.8F;
		      float f16 = f7 * 0.8F;
		      p_204600_1_.begin(7, DefaultVertexFormats.POSITION_TEX_COLOR_NORMAL);
		      float f17 = (float)Math.floor(p_204600_4_ / 4.0D) * 4.0F;
		      if (this.prevCloudsType == CloudOption.FANCY) {
		         for(int k = -3; k <= 4; ++k) {
		            for(int l = -3; l <= 4; ++l) {
		               float f18 = (float)(k * 8);
		               float f19 = (float)(l * 8);
		               if (f17 > -5.0F) {
		                  p_204600_1_.vertex((double)(f18 + 0.0F), (double)(f17 + 0.0F), (double)(f19 + 8.0F)).uv((f18 + 0.0F) * 0.00390625F + f3, (f19 + 8.0F) * 0.00390625F + f4).color(f11, f12, f13, 0.8F).normal(0.0F, -1.0F, 0.0F).endVertex();
		                  p_204600_1_.vertex((double)(f18 + 8.0F), (double)(f17 + 0.0F), (double)(f19 + 8.0F)).uv((f18 + 8.0F) * 0.00390625F + f3, (f19 + 8.0F) * 0.00390625F + f4).color(f11, f12, f13, 0.8F).normal(0.0F, -1.0F, 0.0F).endVertex();
		                  p_204600_1_.vertex((double)(f18 + 8.0F), (double)(f17 + 0.0F), (double)(f19 + 0.0F)).uv((f18 + 8.0F) * 0.00390625F + f3, (f19 + 0.0F) * 0.00390625F + f4).color(f11, f12, f13, 0.8F).normal(0.0F, -1.0F, 0.0F).endVertex();
		                  p_204600_1_.vertex((double)(f18 + 0.0F), (double)(f17 + 0.0F), (double)(f19 + 0.0F)).uv((f18 + 0.0F) * 0.00390625F + f3, (f19 + 0.0F) * 0.00390625F + f4).color(f11, f12, f13, 0.8F).normal(0.0F, -1.0F, 0.0F).endVertex();
		               }

		               if (f17 <= 5.0F) {
		                  p_204600_1_.vertex((double)(f18 + 0.0F), (double)(f17 + 4.0F - 9.765625E-4F), (double)(f19 + 8.0F)).uv((f18 + 0.0F) * 0.00390625F + f3, (f19 + 8.0F) * 0.00390625F + f4).color(f5, f6, f7, 0.8F).normal(0.0F, 1.0F, 0.0F).endVertex();
		                  p_204600_1_.vertex((double)(f18 + 8.0F), (double)(f17 + 4.0F - 9.765625E-4F), (double)(f19 + 8.0F)).uv((f18 + 8.0F) * 0.00390625F + f3, (f19 + 8.0F) * 0.00390625F + f4).color(f5, f6, f7, 0.8F).normal(0.0F, 1.0F, 0.0F).endVertex();
		                  p_204600_1_.vertex((double)(f18 + 8.0F), (double)(f17 + 4.0F - 9.765625E-4F), (double)(f19 + 0.0F)).uv((f18 + 8.0F) * 0.00390625F + f3, (f19 + 0.0F) * 0.00390625F + f4).color(f5, f6, f7, 0.8F).normal(0.0F, 1.0F, 0.0F).endVertex();
		                  p_204600_1_.vertex((double)(f18 + 0.0F), (double)(f17 + 4.0F - 9.765625E-4F), (double)(f19 + 0.0F)).uv((f18 + 0.0F) * 0.00390625F + f3, (f19 + 0.0F) * 0.00390625F + f4).color(f5, f6, f7, 0.8F).normal(0.0F, 1.0F, 0.0F).endVertex();
		               }

		               if (k > -1) {
		                  for(int i1 = 0; i1 < 8; ++i1) {
		                     p_204600_1_.vertex((double)(f18 + (float)i1 + 0.0F), (double)(f17 + 0.0F), (double)(f19 + 8.0F)).uv((f18 + (float)i1 + 0.5F) * 0.00390625F + f3, (f19 + 8.0F) * 0.00390625F + f4).color(f8, f9, f10, 0.8F).normal(-1.0F, 0.0F, 0.0F).endVertex();
		                     p_204600_1_.vertex((double)(f18 + (float)i1 + 0.0F), (double)(f17 + 4.0F), (double)(f19 + 8.0F)).uv((f18 + (float)i1 + 0.5F) * 0.00390625F + f3, (f19 + 8.0F) * 0.00390625F + f4).color(f8, f9, f10, 0.8F).normal(-1.0F, 0.0F, 0.0F).endVertex();
		                     p_204600_1_.vertex((double)(f18 + (float)i1 + 0.0F), (double)(f17 + 4.0F), (double)(f19 + 0.0F)).uv((f18 + (float)i1 + 0.5F) * 0.00390625F + f3, (f19 + 0.0F) * 0.00390625F + f4).color(f8, f9, f10, 0.8F).normal(-1.0F, 0.0F, 0.0F).endVertex();
		                     p_204600_1_.vertex((double)(f18 + (float)i1 + 0.0F), (double)(f17 + 0.0F), (double)(f19 + 0.0F)).uv((f18 + (float)i1 + 0.5F) * 0.00390625F + f3, (f19 + 0.0F) * 0.00390625F + f4).color(f8, f9, f10, 0.8F).normal(-1.0F, 0.0F, 0.0F).endVertex();
		                  }
		               }

		               if (k <= 1) {
		                  for(int j2 = 0; j2 < 8; ++j2) {
		                     p_204600_1_.vertex((double)(f18 + (float)j2 + 1.0F - 9.765625E-4F), (double)(f17 + 0.0F), (double)(f19 + 8.0F)).uv((f18 + (float)j2 + 0.5F) * 0.00390625F + f3, (f19 + 8.0F) * 0.00390625F + f4).color(f8, f9, f10, 0.8F).normal(1.0F, 0.0F, 0.0F).endVertex();
		                     p_204600_1_.vertex((double)(f18 + (float)j2 + 1.0F - 9.765625E-4F), (double)(f17 + 4.0F), (double)(f19 + 8.0F)).uv((f18 + (float)j2 + 0.5F) * 0.00390625F + f3, (f19 + 8.0F) * 0.00390625F + f4).color(f8, f9, f10, 0.8F).normal(1.0F, 0.0F, 0.0F).endVertex();
		                     p_204600_1_.vertex((double)(f18 + (float)j2 + 1.0F - 9.765625E-4F), (double)(f17 + 4.0F), (double)(f19 + 0.0F)).uv((f18 + (float)j2 + 0.5F) * 0.00390625F + f3, (f19 + 0.0F) * 0.00390625F + f4).color(f8, f9, f10, 0.8F).normal(1.0F, 0.0F, 0.0F).endVertex();
		                     p_204600_1_.vertex((double)(f18 + (float)j2 + 1.0F - 9.765625E-4F), (double)(f17 + 0.0F), (double)(f19 + 0.0F)).uv((f18 + (float)j2 + 0.5F) * 0.00390625F + f3, (f19 + 0.0F) * 0.00390625F + f4).color(f8, f9, f10, 0.8F).normal(1.0F, 0.0F, 0.0F).endVertex();
		                  }
		               }

		               if (l > -1) {
		                  for(int k2 = 0; k2 < 8; ++k2) {
		                     p_204600_1_.vertex((double)(f18 + 0.0F), (double)(f17 + 4.0F), (double)(f19 + (float)k2 + 0.0F)).uv((f18 + 0.0F) * 0.00390625F + f3, (f19 + (float)k2 + 0.5F) * 0.00390625F + f4).color(f14, f15, f16, 0.8F).normal(0.0F, 0.0F, -1.0F).endVertex();
		                     p_204600_1_.vertex((double)(f18 + 8.0F), (double)(f17 + 4.0F), (double)(f19 + (float)k2 + 0.0F)).uv((f18 + 8.0F) * 0.00390625F + f3, (f19 + (float)k2 + 0.5F) * 0.00390625F + f4).color(f14, f15, f16, 0.8F).normal(0.0F, 0.0F, -1.0F).endVertex();
		                     p_204600_1_.vertex((double)(f18 + 8.0F), (double)(f17 + 0.0F), (double)(f19 + (float)k2 + 0.0F)).uv((f18 + 8.0F) * 0.00390625F + f3, (f19 + (float)k2 + 0.5F) * 0.00390625F + f4).color(f14, f15, f16, 0.8F).normal(0.0F, 0.0F, -1.0F).endVertex();
		                     p_204600_1_.vertex((double)(f18 + 0.0F), (double)(f17 + 0.0F), (double)(f19 + (float)k2 + 0.0F)).uv((f18 + 0.0F) * 0.00390625F + f3, (f19 + (float)k2 + 0.5F) * 0.00390625F + f4).color(f14, f15, f16, 0.8F).normal(0.0F, 0.0F, -1.0F).endVertex();
		                  }
		               }

		               if (l <= 1) {
		                  for(int l2 = 0; l2 < 8; ++l2) {
		                     p_204600_1_.vertex((double)(f18 + 0.0F), (double)(f17 + 4.0F), (double)(f19 + (float)l2 + 1.0F - 9.765625E-4F)).uv((f18 + 0.0F) * 0.00390625F + f3, (f19 + (float)l2 + 0.5F) * 0.00390625F + f4).color(f14, f15, f16, 0.8F).normal(0.0F, 0.0F, 1.0F).endVertex();
		                     p_204600_1_.vertex((double)(f18 + 8.0F), (double)(f17 + 4.0F), (double)(f19 + (float)l2 + 1.0F - 9.765625E-4F)).uv((f18 + 8.0F) * 0.00390625F + f3, (f19 + (float)l2 + 0.5F) * 0.00390625F + f4).color(f14, f15, f16, 0.8F).normal(0.0F, 0.0F, 1.0F).endVertex();
		                     p_204600_1_.vertex((double)(f18 + 8.0F), (double)(f17 + 0.0F), (double)(f19 + (float)l2 + 1.0F - 9.765625E-4F)).uv((f18 + 8.0F) * 0.00390625F + f3, (f19 + (float)l2 + 0.5F) * 0.00390625F + f4).color(f14, f15, f16, 0.8F).normal(0.0F, 0.0F, 1.0F).endVertex();
		                     p_204600_1_.vertex((double)(f18 + 0.0F), (double)(f17 + 0.0F), (double)(f19 + (float)l2 + 1.0F - 9.765625E-4F)).uv((f18 + 0.0F) * 0.00390625F + f3, (f19 + (float)l2 + 0.5F) * 0.00390625F + f4).color(f14, f15, f16, 0.8F).normal(0.0F, 0.0F, 1.0F).endVertex();
		                  }
		               }
		            }
		         }
		      } else {
		         for(int l1 = -32; l1 < 32; l1 += 32) {
		            for(int i2 = -32; i2 < 32; i2 += 32) {
		               p_204600_1_.vertex((double)(l1 + 0), (double)f17, (double)(i2 + 32)).uv((float)(l1 + 0) * 0.00390625F + f3, (float)(i2 + 32) * 0.00390625F + f4).color(f5, f6, f7, 0.8F).normal(0.0F, -1.0F, 0.0F).endVertex();
		               p_204600_1_.vertex((double)(l1 + 32), (double)f17, (double)(i2 + 32)).uv((float)(l1 + 32) * 0.00390625F + f3, (float)(i2 + 32) * 0.00390625F + f4).color(f5, f6, f7, 0.8F).normal(0.0F, -1.0F, 0.0F).endVertex();
		               p_204600_1_.vertex((double)(l1 + 32), (double)f17, (double)(i2 + 0)).uv((float)(l1 + 32) * 0.00390625F + f3, (float)(i2 + 0) * 0.00390625F + f4).color(f5, f6, f7, 0.8F).normal(0.0F, -1.0F, 0.0F).endVertex();
		               p_204600_1_.vertex((double)(l1 + 0), (double)f17, (double)(i2 + 0)).uv((float)(l1 + 0) * 0.00390625F + f3, (float)(i2 + 0) * 0.00390625F + f4).color(f5, f6, f7, 0.8F).normal(0.0F, -1.0F, 0.0F).endVertex();
		            }
		         }
		      }

		   }

//		   private void renderWorldBounds(ActiveRenderInfo p_228447_1_) {
//		      BufferBuilder bufferbuilder = Tessellator.getInstance().getBuilder();
//		      WorldBorder worldborder = this.level.getWorldBorder();
//		      double d0 = (double)(this.minecraft.options.renderDistance * 16);
//		      if (!(p_228447_1_.getPosition().x < worldborder.getMaxX() - d0) || !(p_228447_1_.getPosition().x > worldborder.getMinX() + d0) || !(p_228447_1_.getPosition().z < worldborder.getMaxZ() - d0) || !(p_228447_1_.getPosition().z > worldborder.getMinZ() + d0)) {
//		         double d1 = 1.0D - worldborder.getDistanceToBorder(p_228447_1_.getPosition().x, p_228447_1_.getPosition().z) / d0;
//		         d1 = Math.pow(d1, 4.0D);
//		         double d2 = p_228447_1_.getPosition().x;
//		         double d3 = p_228447_1_.getPosition().y;
//		         double d4 = p_228447_1_.getPosition().z;
//		         RenderSystem.enableBlend();
//		         RenderSystem.enableDepthTest();
//		         RenderSystem.blendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
//		         this.textureManager.bind(FORCEFIELD_LOCATION);
//		         RenderSystem.depthMask(Minecraft.useShaderTransparency());
//		         RenderSystem.pushMatrix();
//		         int i = worldborder.getStatus().getColor();
//		         float f = (float)(i >> 16 & 255) / 255.0F;
//		         float f1 = (float)(i >> 8 & 255) / 255.0F;
//		         float f2 = (float)(i & 255) / 255.0F;
//		         RenderSystem.color4f(f, f1, f2, (float)d1);
//		         RenderSystem.polygonOffset(-3.0F, -3.0F);
//		         RenderSystem.enablePolygonOffset();
//		         RenderSystem.defaultAlphaFunc();
//		         RenderSystem.enableAlphaTest();
//		         RenderSystem.disableCull();
//		         float f3 = (float)(Util.getMillis() % 3000L) / 3000.0F;
//		         float f4 = 0.0F;
//		         float f5 = 0.0F;
//		         float f6 = 128.0F;
//		         bufferbuilder.begin(7, DefaultVertexFormats.POSITION_TEX);
//		         double d5 = Math.max((double)MathHelper.floor(d4 - d0), worldborder.getMinZ());
//		         double d6 = Math.min((double)MathHelper.ceil(d4 + d0), worldborder.getMaxZ());
//		         if (d2 > worldborder.getMaxX() - d0) {
//		            float f7 = 0.0F;
//
//		            for(double d7 = d5; d7 < d6; f7 += 0.5F) {
//		               double d8 = Math.min(1.0D, d6 - d7);
//		               float f8 = (float)d8 * 0.5F;
//		               this.vertex(bufferbuilder, d2, d3, d4, worldborder.getMaxX(), 256, d7, f3 + f7, f3 + 0.0F);
//		               this.vertex(bufferbuilder, d2, d3, d4, worldborder.getMaxX(), 256, d7 + d8, f3 + f8 + f7, f3 + 0.0F);
//		               this.vertex(bufferbuilder, d2, d3, d4, worldborder.getMaxX(), 0, d7 + d8, f3 + f8 + f7, f3 + 128.0F);
//		               this.vertex(bufferbuilder, d2, d3, d4, worldborder.getMaxX(), 0, d7, f3 + f7, f3 + 128.0F);
//		               ++d7;
//		            }
//		         }
//
//		         if (d2 < worldborder.getMinX() + d0) {
//		            float f9 = 0.0F;
//
//		            for(double d9 = d5; d9 < d6; f9 += 0.5F) {
//		               double d12 = Math.min(1.0D, d6 - d9);
//		               float f12 = (float)d12 * 0.5F;
//		               this.vertex(bufferbuilder, d2, d3, d4, worldborder.getMinX(), 256, d9, f3 + f9, f3 + 0.0F);
//		               this.vertex(bufferbuilder, d2, d3, d4, worldborder.getMinX(), 256, d9 + d12, f3 + f12 + f9, f3 + 0.0F);
//		               this.vertex(bufferbuilder, d2, d3, d4, worldborder.getMinX(), 0, d9 + d12, f3 + f12 + f9, f3 + 128.0F);
//		               this.vertex(bufferbuilder, d2, d3, d4, worldborder.getMinX(), 0, d9, f3 + f9, f3 + 128.0F);
//		               ++d9;
//		            }
//		         }
//
//		         d5 = Math.max((double)MathHelper.floor(d2 - d0), worldborder.getMinX());
//		         d6 = Math.min((double)MathHelper.ceil(d2 + d0), worldborder.getMaxX());
//		         if (d4 > worldborder.getMaxZ() - d0) {
//		            float f10 = 0.0F;
//
//		            for(double d10 = d5; d10 < d6; f10 += 0.5F) {
//		               double d13 = Math.min(1.0D, d6 - d10);
//		               float f13 = (float)d13 * 0.5F;
//		               this.vertex(bufferbuilder, d2, d3, d4, d10, 256, worldborder.getMaxZ(), f3 + f10, f3 + 0.0F);
//		               this.vertex(bufferbuilder, d2, d3, d4, d10 + d13, 256, worldborder.getMaxZ(), f3 + f13 + f10, f3 + 0.0F);
//		               this.vertex(bufferbuilder, d2, d3, d4, d10 + d13, 0, worldborder.getMaxZ(), f3 + f13 + f10, f3 + 128.0F);
//		               this.vertex(bufferbuilder, d2, d3, d4, d10, 0, worldborder.getMaxZ(), f3 + f10, f3 + 128.0F);
//		               ++d10;
//		            }
//		         }
//
//		         if (d4 < worldborder.getMinZ() + d0) {
//		            float f11 = 0.0F;
//
//		            for(double d11 = d5; d11 < d6; f11 += 0.5F) {
//		               double d14 = Math.min(1.0D, d6 - d11);
//		               float f14 = (float)d14 * 0.5F;
//		               this.vertex(bufferbuilder, d2, d3, d4, d11, 256, worldborder.getMinZ(), f3 + f11, f3 + 0.0F);
//		               this.vertex(bufferbuilder, d2, d3, d4, d11 + d14, 256, worldborder.getMinZ(), f3 + f14 + f11, f3 + 0.0F);
//		               this.vertex(bufferbuilder, d2, d3, d4, d11 + d14, 0, worldborder.getMinZ(), f3 + f14 + f11, f3 + 128.0F);
//		               this.vertex(bufferbuilder, d2, d3, d4, d11, 0, worldborder.getMinZ(), f3 + f11, f3 + 128.0F);
//		               ++d11;
//		            }
//		         }
//
//		         bufferbuilder.end();
//		         WorldVertexBufferUploader.end(bufferbuilder);
//		         RenderSystem.enableCull();
//		         RenderSystem.disableAlphaTest();
//		         RenderSystem.polygonOffset(0.0F, 0.0F);
//		         RenderSystem.disablePolygonOffset();
//		         RenderSystem.enableAlphaTest();
//		         RenderSystem.disableBlend();
//		         RenderSystem.popMatrix();
//		         RenderSystem.depthMask(true);
//		      }
//		   }




		   public static int getLightColor(IBlockDisplayReader p_228421_0_, BlockPos p_228421_1_) {
		      return getLightColor(p_228421_0_, p_228421_0_.getBlockState(p_228421_1_), p_228421_1_);
		   }

		   public static int getLightColor(IBlockDisplayReader p_228420_0_, BlockState p_228420_1_, BlockPos p_228420_2_) {
		      if (p_228420_1_.emissiveRendering(p_228420_0_, p_228420_2_)) {
		         return 15728880;
		      } else {
		         int i = p_228420_0_.getBrightness(LightType.SKY, p_228420_2_);
		         int j = p_228420_0_.getBrightness(LightType.BLOCK, p_228420_2_);
		         int k = p_228420_1_.getLightValue(p_228420_0_, p_228420_2_);
		         if (j < k) {
		            j = k;
		         }

		         return i << 20 | j << 4;
		      }
		   }

		}
