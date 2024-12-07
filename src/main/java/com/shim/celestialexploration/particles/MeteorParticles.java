package com.shim.celestialexploration.particles;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.*;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.util.Mth;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class MeteorParticles extends TextureSheetParticle {
    private final SpriteSet sprites;
    private final double xStart;
    private final double yStart;
    private final double zStart;


    protected MeteorParticles(ClientLevel level, double x, double y, double z, double xd, double yd, double zd, SpriteSet sprites) {
        super(level, x, y, z);
        this.sprites = sprites;
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
//        float f = this.random.nextFloat() * 0.6F + 0.4F;
        this.rCol = 1.0F;
        this.gCol = 1.0F;
        this.bCol = 1.0F;
        this.lifetime = (int)(Math.random() * 10.0D) + 40;
        this.setSpriteFromAge(sprites);
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
        return this.quadSize * f + 0.08F;
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
            this.y = this.yStart + this.yd * (double)f2 - (double)(1.0F - f);
            this.z = this.zStart + this.zd * (double)f2 + (double)(1.0F - f);
        }
    }

    @OnlyIn(Dist.CLIENT)
    public static class Provider implements ParticleProvider<SimpleParticleType> {
        private final SpriteSet sprites;

        public Provider(SpriteSet p_107696_) {
            this.sprites = p_107696_;
        }

        public Particle createParticle(SimpleParticleType particle, ClientLevel level, double x, double y, double z, double xd, double yd, double zd) {
            return new MeteorParticles(level, x, y, z, xd, yd, zd, sprites);
        }
    }
}