package com.shim.celestialexploration.world.renderer;

import com.shim.celestialexploration.registry.CelestialDimensions;
import net.minecraft.client.renderer.DimensionSpecialEffects;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.ISkyRenderHandler;
import net.minecraftforge.client.IWeatherParticleRenderHandler;
import net.minecraftforge.client.IWeatherRenderHandler;

import javax.annotation.Nullable;

@OnlyIn(Dist.CLIENT)
public class DimensionRenderers {

    public static void setDimensionEffects() {
        DimensionSpecialEffects.EFFECTS.put(CelestialDimensions.MARS.location(), new MarsEffects());
        DimensionSpecialEffects.EFFECTS.put(CelestialDimensions.MOON.location(), new MoonEffects());
        DimensionSpecialEffects.EFFECTS.put(CelestialDimensions.SPACE.location(), new SpaceEffects());
        DimensionSpecialEffects.EFFECTS.put(CelestialDimensions.VENUS.location(), new VenusEffects());
        DimensionSpecialEffects.EFFECTS.put(CelestialDimensions.MERCURY.location(), new MercuryEffects());
        DimensionSpecialEffects.EFFECTS.put(CelestialDimensions.JUPITER.location(), new JupiterEffects());
        DimensionSpecialEffects.EFFECTS.put(CelestialDimensions.EUROPA.location(), new EuropaEffects());
        DimensionSpecialEffects.EFFECTS.put(CelestialDimensions.CALLISTO.location(), new CallistoEffects());
        DimensionSpecialEffects.EFFECTS.put(CelestialDimensions.IO.location(), new IoEffects());
        DimensionSpecialEffects.EFFECTS.put(CelestialDimensions.GANYMEDE.location(), new GanymedeEffects());

    }

    @OnlyIn(Dist.CLIENT)
    public abstract static class PlanetEffects extends DimensionSpecialEffects {

        public PlanetEffects(@Nullable ISkyRenderHandler skyHandler, @Nullable IWeatherRenderHandler weatherHandler, @Nullable IWeatherParticleRenderHandler particleHandler) {
            this(Float.NaN, true, SkyType.NORMAL, false, false, skyHandler, weatherHandler, particleHandler);
        }

        public PlanetEffects(float cloudLevel, boolean hasGround, SkyType sky, boolean forceBrightLightmap, boolean constantAmbientLight, @Nullable ISkyRenderHandler skyHandler, @Nullable IWeatherRenderHandler weatherHandler, @Nullable IWeatherParticleRenderHandler particleHandler) {
            super(cloudLevel, hasGround, sky, forceBrightLightmap, constantAmbientLight);

            if (skyHandler != null)
                setSkyRenderHandler(skyHandler);
            if (weatherHandler != null)
                setWeatherRenderHandler(weatherHandler);
            if (particleHandler != null)
                setWeatherParticleRenderHandler(particleHandler);
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
    }

    @OnlyIn(Dist.CLIENT)
    public static class MarsEffects extends PlanetEffects {
        public MarsEffects() {
            super(new MarsSkyHandler(), new StormWeatherHandler(), new StormWeatherParticleHandler());
        }

        private final float[] sunriseCol = new float[4];

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
    }

    @OnlyIn(Dist.CLIENT)
    public static class MoonEffects extends PlanetEffects {
        public MoonEffects() {
            super(new MoonSkyHandler(), null, null);
        }
    }

    @OnlyIn(Dist.CLIENT)
    public static class SpaceEffects extends PlanetEffects {
        public SpaceEffects() {
            super(Float.NaN, false, SkyType.NONE, true, false, new SpaceSkyHandler(), null, null);
        }
        ISkyRenderHandler skyHandler = new SpaceSkyHandler();

        @Override
        public Vec3 getBrightnessDependentFogColor(Vec3 color, float brightness) {
            return color;
        }
    }

    @OnlyIn(Dist.CLIENT)
    public static class VenusEffects extends PlanetEffects {
        public VenusEffects() {
            super(Float.NaN, true, SkyType.NORMAL, false, true, new VenusSkyHandler(), new VenusWeatherHandler(), new VenusWeatherParticleHandler());
        }

        @Override
        public Vec3 getBrightnessDependentFogColor(Vec3 p_108901_, float p_108902_) {
            return p_108901_;
        }

        @Override
        public boolean isFoggyAt(int x, int z) {
            return true;
        }
    }

    @OnlyIn(Dist.CLIENT)
    public static class MercuryEffects extends PlanetEffects {
        public MercuryEffects() {
            super(new MercurySkyHandler(), null, null); //new MeteorShowerParticleHandler());
        }
    }

    @OnlyIn(Dist.CLIENT)
    public static class JupiterEffects extends PlanetEffects {
        public JupiterEffects() {
            super(416, true, SkyType.NORMAL, false, false, new JupiterSkyHandler(), new StormWeatherHandler(), new StormWeatherParticleHandler());
        }

        @Override
        public boolean isFoggyAt(int x, int z) {
            return true;
        }
    }

    @OnlyIn(Dist.CLIENT)
    public static class EuropaEffects extends PlanetEffects {
        public EuropaEffects() {
            super(new EuropaSkyHandler(), null, null);
        }
    }

    @OnlyIn(Dist.CLIENT)
    public static class CallistoEffects extends PlanetEffects {
        public CallistoEffects() {
            super(new CallistoSkyHandler(), null, null);
        }
    }

    @OnlyIn(Dist.CLIENT)
    public static class IoEffects extends PlanetEffects {
        public IoEffects() {
            super(new IoSkyHandler(), null, null);
        }
    }

    @OnlyIn(Dist.CLIENT)
    public static class GanymedeEffects extends PlanetEffects {
        public GanymedeEffects() {
            super(new GanymedeSkyHandler(), null, null);
        }
    }
}