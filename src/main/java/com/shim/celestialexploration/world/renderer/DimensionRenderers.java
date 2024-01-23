package com.shim.celestialexploration.world.renderer;

import com.shim.celestialexploration.registry.DimensionRegistry;
import net.minecraft.client.renderer.DimensionSpecialEffects;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.ISkyRenderHandler;
import org.jetbrains.annotations.Nullable;

@OnlyIn(Dist.CLIENT)
public class DimensionRenderers {

    public static void setDimensionEffects() {

        DimensionSpecialEffects.EFFECTS.put(DimensionRegistry.MARS_EFFECTS, new MarsEffects());
        DimensionSpecialEffects.EFFECTS.put(DimensionRegistry.MOON.location(), new MoonEffects());
        DimensionSpecialEffects.EFFECTS.put(DimensionRegistry.SPACE.location(), new SpaceEffects());
        DimensionSpecialEffects.EFFECTS.put(DimensionRegistry.VENUS.location(), new VenusEffects());


//        DimensionRenderInfo.EFFECTS.put(RegistryDimensions.VENUS_DIMENSION.location(),
//                new DimensionRenderInfo(128.0F, true, DimensionRenderInfo.FogType.NORMAL, false, false) {
//
//                    private final float[] sunriseCol = new float[4];
//
//                    @Override
//                    public Vector3d getBrightnessDependentFogColor(Vector3d color, float brightness) {
//                        return color.multiply(brightness * 0.94F + 0.06F, brightness * 0.94F + 0.06F, brightness * 0.91F + 0.09F);
//                    }
//
//                    @Override
//                    public boolean isFoggyAt(int x, int z) {
//                        return true;
//                    }
//
//                    //			@Override
//                    //			public float[] getSunriseColor(float p_230492_1_, float p_230492_2_) {
//                    //				float f = 0.4F;
//                    //				float f1 = MathHelper.cos(p_230492_1_ * ((float)Math.PI * 2F)) - 0.0F;
//                    //				float f2 = -0.0F;
//                    //				if (f1 >= -0.4F && f1 <= 0.4F) {
//                    //					float f3 = (f1 - -0.0F) / 0.4F * 0.5F + 0.5F;
//                    //					float f4 = 1.0F - (1.0F - MathHelper.sin(f3 * (float)Math.PI)) * 0.99F;
//                    //					f4 = f4 * f4;
//                    //					this.sunriseCol[0] = f3 * 0.3F - 4.7F;
//                    //					this.sunriseCol[1] = f3 * f3 * 0.7F + 1.2F;
//                    //					this.sunriseCol[2] = f3 * f3 * 0.0F + 1.2F;
//                    //					this.sunriseCol[3] = f4;
//                    //					return this.sunriseCol;
//                    //				} else {
//                    //					return null;
//                    //				}
//                    //			}
//
//                    CelestialWeatherRenderer weatherHandler = new CelestialWeatherRenderer();
//
//                    @Override
//                    public void setWeatherRenderHandler(IWeatherRenderHandler weatherRenderHandler) {
//                        // TODO Auto-generated method stub
//                        super.setWeatherRenderHandler(this.weatherHandler);
//                    }
//
//                });
    }

    @OnlyIn(Dist.CLIENT)
    public static class MarsEffects extends DimensionSpecialEffects {
        public MarsEffects() {
            super(Float.NaN, true, SkyType.NORMAL, false, false);
        }

        private final float[] sunriseCol = new float[4];

        @Override
        public boolean isFoggyAt(int x, int z) {
            return false;
        }

        @Override
        public float[] getSunriseColor(float p_230492_1_, float p_230492_2_) {
            float f = 0.4F;
            float f1 = (float) (Math.cos(p_230492_1_ * ((float)Math.PI * 2F)) - 0.0F);
            float f2 = -0.0F;
            if (f1 >= -0.4F && f1 <= 0.4F) { //0.4F
                float f3 = (f1 - -0.0F) / 0.4F * 0.5F + 0.5F; //0.0, 0.4, 0.5, 0.5
                float f4 = (float) (1.0F - (1.0F - Math.sin(f3 * (float)Math.PI)) * 0.99F);
                f4 = f4 * f4;
                this.sunriseCol[0] = f3 * 0.3F - 5.7F; //0.3, +0.7 //0.3, -5.7
                this.sunriseCol[1] = f3 * f3 * 0.7F + 3.2F; //0.7, +0.2
                this.sunriseCol[2] = f3 * f3 * 0.0F + 3.2F; //0.0, 0.2 //0.0, 3.2
                this.sunriseCol[3] = f4; //none
                return this.sunriseCol;
            } else {
                return null;
            }
        }

        @Override
        public Vec3 getBrightnessDependentFogColor(Vec3 color, float brightness) {
            return color.multiply(brightness * 0.94F + 0.06F, brightness * 0.94F + 0.06F, brightness * 0.91F + 0.09F);
        }

        MarsSkyHandler skyHandler = new MarsSkyHandler();

        @Override
        public void setSkyRenderHandler(ISkyRenderHandler skyRenderHandler) {
            super.setSkyRenderHandler(skyHandler);
        }

        @Nullable
        @Override
        public ISkyRenderHandler getSkyRenderHandler() {
            return skyHandler;
        }
    }

    @OnlyIn(Dist.CLIENT)
    public static class MoonEffects extends DimensionSpecialEffects {
        public MoonEffects() {
            super(Float.NaN, true, SkyType.NORMAL, false, false);
        }

        @Override
        public Vec3 getBrightnessDependentFogColor(Vec3 color, float brightness) {
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

        MoonSkyHandler skyHandler = new MoonSkyHandler();

        @Override
        public void setSkyRenderHandler(ISkyRenderHandler skyRenderHandler) {
            super.setSkyRenderHandler(skyHandler);
        }

        @Nullable
        @Override
        public ISkyRenderHandler getSkyRenderHandler() {
            return skyHandler;
        }
    }

    @OnlyIn(Dist.CLIENT)
    public static class SpaceEffects extends DimensionSpecialEffects {
        public SpaceEffects() {
            super(Float.NaN, false, SkyType.NONE, true, false);
        }
        SpaceSkyHandler skyHandler = new SpaceSkyHandler();

        @Override
        public boolean isFoggyAt(int x, int z) {
            return false;
        }

        @Override
        public float[] getSunriseColor(float p_230492_1_, float p_230492_2_) {
            return null;
        }

        @Override
        public Vec3 getBrightnessDependentFogColor(Vec3 color, float brightness) {
            return color;
        }

        @Override
        public void setSkyRenderHandler(ISkyRenderHandler skyRenderHandler) {
            super.setSkyRenderHandler(skyHandler);
        }

        @Nullable
        @Override
        public ISkyRenderHandler getSkyRenderHandler() {
            return skyHandler;
        }
    }

    @OnlyIn(Dist.CLIENT)
    public static class VenusEffects extends DimensionSpecialEffects {
        public VenusEffects() {
            super(Float.NaN, true, SkyType.NORMAL, false, true);
        }

//        @Override
//        public Vec3 getBrightnessDependentFogColor(Vec3 color, float brightness) {
//            return color.multiply(brightness * 0.94F + 0.06F, brightness * 0.94F + 0.06F, brightness * 0.91F + 0.09F);
//        }

        public Vec3 getBrightnessDependentFogColor(Vec3 p_108901_, float p_108902_) {
            return p_108901_;
        }

        @Override
        public boolean isFoggyAt(int x, int z) {
            return true;
        }

//        VenusSkyHandler skyHandler = new VenusSkyHandler();
//
//        @Override
//        public void setSkyRenderHandler(ISkyRenderHandler skyRenderHandler) {
//            super.setSkyRenderHandler(skyHandler);
//        }
//
//        @Nullable
//        @Override
//        public ISkyRenderHandler getSkyRenderHandler() {
//            return skyHandler;
//        }
    }
}