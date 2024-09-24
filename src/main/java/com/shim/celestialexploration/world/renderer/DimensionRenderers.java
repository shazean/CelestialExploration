package com.shim.celestialexploration.world.renderer;

import com.shim.celestialexploration.registry.DimensionRegistry;
import net.minecraft.client.renderer.DimensionSpecialEffects;
import net.minecraft.core.BlockPos;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.ISkyRenderHandler;
import net.minecraftforge.client.IWeatherParticleRenderHandler;
import net.minecraftforge.client.IWeatherRenderHandler;

@OnlyIn(Dist.CLIENT)
public class DimensionRenderers {

    public static void setDimensionEffects() {
        DimensionSpecialEffects.EFFECTS.put(DimensionRegistry.MARS.location(), new MarsEffects());
        DimensionSpecialEffects.EFFECTS.put(DimensionRegistry.MOON.location(), new MoonEffects());
        DimensionSpecialEffects.EFFECTS.put(DimensionRegistry.SPACE.location(), new SpaceEffects());
        DimensionSpecialEffects.EFFECTS.put(DimensionRegistry.VENUS.location(), new VenusEffects());
        DimensionSpecialEffects.EFFECTS.put(DimensionRegistry.MERCURY.location(), new MercuryEffects());
        DimensionSpecialEffects.EFFECTS.put(DimensionRegistry.JUPITER.location(), new JupiterEffects());
    }

    @OnlyIn(Dist.CLIENT)
    public static class MarsEffects extends DimensionSpecialEffects {
        ISkyRenderHandler skyHandler = new MarsSkyHandler();
        IWeatherRenderHandler weatherHandler = new StormWeatherHandler();
        IWeatherParticleRenderHandler particleHandler = new StormWeatherParticleHandler();

        public MarsEffects() {
            super(Float.NaN, true, SkyType.NORMAL, false, false);
            setSkyRenderHandler(skyHandler);
            setWeatherRenderHandler(weatherHandler);
            setWeatherParticleRenderHandler(particleHandler);
        }

        private final float[] sunriseCol = new float[4];

        @Override
        public boolean isFoggyAt(int x, int z) {
//            return true;
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
    }

    @OnlyIn(Dist.CLIENT)
    public static class MoonEffects extends DimensionSpecialEffects {
        public MoonEffects() {
            super(Float.NaN, true, SkyType.NORMAL, false, false);
            setSkyRenderHandler(skyHandler);
        }

        @Override
        public Vec3 getBrightnessDependentFogColor(Vec3 color, float brightness) {
            return color.multiply(brightness * 0.94F + 0.06F, brightness * 0.94F + 0.06F, brightness * 0.91F + 0.09F);
        }

        @Override
        public boolean isFoggyAt(int x, int z) {
            BlockPos pos = new BlockPos(x, 0, z);


            return false;
        }

        @Override
        public float[] getSunriseColor(float p_230492_1_, float p_230492_2_) {
            return null;
        }

        ISkyRenderHandler skyHandler = new MoonSkyHandler();
    }

    @OnlyIn(Dist.CLIENT)
    public static class SpaceEffects extends DimensionSpecialEffects {
        public SpaceEffects() {
            super(Float.NaN, false, SkyType.NONE, true, false);
            setSkyRenderHandler(skyHandler);
        }
        ISkyRenderHandler skyHandler = new SpaceSkyHandler();

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
    }

    @OnlyIn(Dist.CLIENT)
    public static class VenusEffects extends DimensionSpecialEffects {
        VenusWeatherHandler weatherHandler = new VenusWeatherHandler();
        VenusWeatherParticleHandler particleHandler = new VenusWeatherParticleHandler();

        public VenusEffects() {
            super(Float.NaN, true, SkyType.NORMAL, false, true);
            setWeatherRenderHandler(weatherHandler);
            setWeatherParticleRenderHandler(particleHandler);
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
    }

    @OnlyIn(Dist.CLIENT)
    public static class MercuryEffects extends DimensionSpecialEffects {
        public MercuryEffects() {
            super(Float.NaN, true, SkyType.NORMAL, false, false);
            setSkyRenderHandler(skyHandler);
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

        ISkyRenderHandler skyHandler = new MercurySkyHandler();
    }

    @OnlyIn(Dist.CLIENT)
    public static class JupiterEffects extends DimensionSpecialEffects {
        ISkyRenderHandler skyHandler = new JupiterSkyHandler();
        IWeatherRenderHandler weatherHandler = new StormWeatherHandler();
        IWeatherParticleRenderHandler particleHandler = new StormWeatherParticleHandler();

        public JupiterEffects() {
            super(416, true, SkyType.NORMAL, false, false);
            setSkyRenderHandler(skyHandler);
            setWeatherRenderHandler(weatherHandler);
            setWeatherParticleRenderHandler(particleHandler);
        }

        @Override
        public Vec3 getBrightnessDependentFogColor(Vec3 color, float brightness) {
            return color.multiply(brightness * 0.94F + 0.06F, brightness * 0.94F + 0.06F, brightness * 0.91F + 0.09F);
        }

        @Override
        public boolean isFoggyAt(int x, int z) {
            return true;
        }

        @Override
        public float[] getSunriseColor(float p_230492_1_, float p_230492_2_) {
            return null;
        }
    }

}