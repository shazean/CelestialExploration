package com.shim.celestialexploration.particles;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.*;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class CelestialPortalParticle extends TextureSheetParticle {
    private final double xStart;
    private final double yStart;
    private final double zStart;

    protected CelestialPortalParticle(ClientLevel level, double x, double y, double z, double xd, double yd, double zd, float rCol, float gCol, float bCol) {
        super(level, x, y, z);
        this.xd = xd;
        this.yd = yd;
        this.zd = zd;
        this.x = x;
        this.y = y;
        this.z = z;
        this.xStart = this.x;
        this.yStart = this.y;
        this.zStart = this.z;
        this.quadSize = 0.1F * (this.random.nextFloat() * 0.2F + 0.5F);
        float f = this.random.nextFloat() * 0.6F + 0.4F;
        this.rCol = f * rCol;
        this.gCol = f * gCol;
        this.bCol = f * bCol;
        this.lifetime = (int)(Math.random() * 10.0D) + 40;
    }

    public ParticleRenderType getRenderType() {
        return ParticleRenderType.PARTICLE_SHEET_OPAQUE;
    }

    public void move(double p_107560_, double p_107561_, double p_107562_) {
        this.setBoundingBox(this.getBoundingBox().move(p_107560_, p_107561_, p_107562_));
        this.setLocationFromBoundingbox();
    }

    public float getQuadSize(float p_107567_) {
        float f = ((float)this.age + p_107567_) / (float)this.lifetime;
        f = 1.0F - f;
        f *= f;
        f = 1.0F - f;
        return this.quadSize * f;
    }

    public int getLightColor(float p_107564_) {
        int i = super.getLightColor(p_107564_);
        float f = (float)this.age / (float)this.lifetime;
        f *= f;
        f *= f;
        int j = i & 255;
        int k = i >> 16 & 255;
        k += (int)(f * 15.0F * 16.0F);
        if (k > 240) {
            k = 240;
        }

        return j | k << 16;
    }

    public void tick() {
        this.xo = this.x;
        this.yo = this.y;
        this.zo = this.z;
        if (this.age++ >= this.lifetime) {
            this.remove();
        } else {
            float f = (float)this.age / (float)this.lifetime;
            float f1 = -f + f * f * 2.0F;
            float f2 = 1.0F - f1;
            this.x = this.xStart + this.xd * (double)f2;
            this.y = this.yStart + this.yd * (double)f2 + (double)(1.0F - f);
            this.z = this.zStart + this.zd * (double)f2;
        }
    }

    @OnlyIn(Dist.CLIENT)
    public static abstract class BaseProvider implements ParticleProvider<SimpleParticleType> {
        private final SpriteSet sprite;
        protected float red;
        protected float green;
        protected float blue;

        public BaseProvider(SpriteSet p_107570_, float red, float green, float blue) {
            this.sprite = p_107570_;
            this.red = red;
            this.green = green;
            this.blue = blue;
        }

        public Particle createParticle(SimpleParticleType particle, ClientLevel level, double x, double y, double z, double xd, double yd, double zd) {
            CelestialPortalParticle portalparticle = new CelestialPortalParticle(level, x, y, z, xd, yd, zd, red, green, blue);
            portalparticle.pickSprite(this.sprite);
            return portalparticle;
        }
    }

    @OnlyIn(Dist.CLIENT)
    public static class MarsProvider extends BaseProvider {
        public MarsProvider(SpriteSet sprite) {
            super(sprite, 0.9F, 0.3F, 0.2F);
        }
    }

    @OnlyIn(Dist.CLIENT)
    public static class MoonProvider extends BaseProvider {
        public MoonProvider(SpriteSet sprite) {
            super(sprite, 0.7F, 0.8F, 1.0F);
        }
    }

    @OnlyIn(Dist.CLIENT)
    public static class VenusProvider extends BaseProvider {
        public VenusProvider(SpriteSet sprite) {
            super(sprite, 0.7F, 0.7F, 0.3F);
        }
    }

    @OnlyIn(Dist.CLIENT)
    public static class MercuryProvider extends BaseProvider {
        public MercuryProvider(SpriteSet sprite) {
            super(sprite, 0.7F, 0.4F, 0.3F);
        }
    }

    @OnlyIn(Dist.CLIENT)
    public static class JupiterProvider extends BaseProvider {
        public JupiterProvider(SpriteSet sprite) {
            super(sprite, 0.5F, 0.3F, 0.2F);
        }
    }

    @OnlyIn(Dist.CLIENT)
    public static class EuropaProvider extends BaseProvider {
        public EuropaProvider(SpriteSet sprite) {
            super(sprite, 0.1F, 0.8F, 0.8F);
        }
    }

    @OnlyIn(Dist.CLIENT)
    public static class CallistoProvider extends BaseProvider {
        public CallistoProvider(SpriteSet sprite) {
            super(sprite, 0.9F, 0.3F, 0.7F);
        }
    }

    @OnlyIn(Dist.CLIENT)
    public static class IoProvider extends BaseProvider {
        public IoProvider(SpriteSet sprite) {
            super(sprite,  0.6F,0.8F,0.3F);
        }
    }

    @OnlyIn(Dist.CLIENT)
    public static class GanymedeProvider extends BaseProvider {
        public GanymedeProvider(SpriteSet sprite) {
            super(sprite,  1.0F,0.1F,0.1F);
        }
    }
}