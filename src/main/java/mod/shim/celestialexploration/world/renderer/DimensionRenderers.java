package mod.shim.celestialexploration.world.renderer;

import mod.shim.celestialexploration.registry.RegistryDimensions;
import net.minecraft.client.world.DimensionRenderInfo;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraftforge.client.IWeatherRenderHandler;

public class DimensionRenderers {

	public static void setDimensionEffects() {
		DimensionRenderInfo.EFFECTS.put(RegistryDimensions.MARS_DIMENSION.location(),
				new DimensionRenderInfo(Float.NaN, true, DimensionRenderInfo.FogType.NORMAL, false, false) {

			private final float[] sunriseCol = new float[4];

			@Override
			public Vector3d getBrightnessDependentFogColor(Vector3d color, float brightness) {
				return color.multiply(brightness * 0.94F + 0.06F, brightness * 0.94F + 0.06F, brightness * 0.91F + 0.09F);
			}

			@Override
			public boolean isFoggyAt(int x, int z) {
				return false;
			}

			@Override
			public float[] getSunriseColor(float p_230492_1_, float p_230492_2_) {
				// TODO Auto-generated method stub
				//				return super.getSunriseColor(p_230492_1_, p_230492_2_);

				float f = 0.4F;
				float f1 = MathHelper.cos(p_230492_1_ * ((float)Math.PI * 2F)) - 0.0F;
				float f2 = -0.0F;
				if (f1 >= -0.4F && f1 <= 0.4F) { //0.4F
					float f3 = (f1 - -0.0F) / 0.4F * 0.5F + 0.5F; //0.0, 0.4, 0.5, 0.5
					float f4 = 1.0F - (1.0F - MathHelper.sin(f3 * (float)Math.PI)) * 0.99F;
					f4 = f4 * f4;
					this.sunriseCol[0] = f3 * 0.3F - 5.7F; //0.3, +0.7 //-5.2
					this.sunriseCol[1] = f3 * f3 * 0.7F + 3.2F; //0.7, +0.2
					this.sunriseCol[2] = f3 * f3 * 0.0F + 3.2F; //0.0, 0.2
					this.sunriseCol[3] = f4; //none
					return this.sunriseCol;
				} else {
					return null;
				}
			}
		});

		DimensionRenderInfo.EFFECTS.put(RegistryDimensions.MOON_DIMENSION.location(),
				new DimensionRenderInfo(Float.NaN, true, DimensionRenderInfo.FogType.NORMAL, false, false) {

			@Override
			public Vector3d getBrightnessDependentFogColor(Vector3d color, float brightness) {
				return color.multiply(brightness * 0.94F + 0.06F, brightness * 0.94F + 0.06F, brightness * 0.91F + 0.09F);
			}

			@Override
			public boolean isFoggyAt(int x, int z) {
				return false;
			}

			@Override
			public float[] getSunriseColor(float p_230492_1_, float p_230492_2_) {
				return null;
			}
		});

		DimensionRenderInfo.EFFECTS.put(RegistryDimensions.VENUS_DIMENSION.location(),
				new DimensionRenderInfo(128.0F, true, DimensionRenderInfo.FogType.NORMAL, false, false) {

			private final float[] sunriseCol = new float[4];

			@Override
			public Vector3d getBrightnessDependentFogColor(Vector3d color, float brightness) {
				return color.multiply(brightness * 0.94F + 0.06F, brightness * 0.94F + 0.06F, brightness * 0.91F + 0.09F);
			}

			@Override
			public boolean isFoggyAt(int x, int z) {
				return true;
			}

			//			@Override
			//			public float[] getSunriseColor(float p_230492_1_, float p_230492_2_) {
			//				float f = 0.4F;
			//				float f1 = MathHelper.cos(p_230492_1_ * ((float)Math.PI * 2F)) - 0.0F;
			//				float f2 = -0.0F;
			//				if (f1 >= -0.4F && f1 <= 0.4F) {
			//					float f3 = (f1 - -0.0F) / 0.4F * 0.5F + 0.5F;
			//					float f4 = 1.0F - (1.0F - MathHelper.sin(f3 * (float)Math.PI)) * 0.99F;
			//					f4 = f4 * f4;
			//					this.sunriseCol[0] = f3 * 0.3F - 4.7F;
			//					this.sunriseCol[1] = f3 * f3 * 0.7F + 1.2F;
			//					this.sunriseCol[2] = f3 * f3 * 0.0F + 1.2F;
			//					this.sunriseCol[3] = f4;
			//					return this.sunriseCol;
			//				} else {
			//					return null;
			//				}
			//			}
			
			CelestialWeatherRenderer weatherHandler = new CelestialWeatherRenderer();

			@Override
			public void setWeatherRenderHandler(IWeatherRenderHandler weatherRenderHandler) {
				// TODO Auto-generated method stub
				super.setWeatherRenderHandler(this.weatherHandler);
			}

		});








	}




}
