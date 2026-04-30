package com.shim.celestialexploration.particles;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.*;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class VolcanicSmokeParticle extends TextureSheetParticle {
    VolcanicSmokeParticle(ClientLevel p_105856_, double p_105857_, double p_105858_, double p_105859_, double p_105860_, double p_105861_, double p_105862_) {
        super(p_105856_, p_105857_, p_105858_, p_105859_);
        this.scale(8.0F);
//        this.setSize(1.25F, 1.25F);
            this.lifetime = this.random.nextInt(200) + 280 + 500;

        this.gravity = 3.0E-6F;
        this.xd = p_105860_;
        this.yd = p_105861_ + (double)(this.random.nextFloat() / 500.0F);
        this.zd = p_105862_;
    }

    public void tick() {
        this.xo = this.x;
        this.yo = this.y;
        this.zo = this.z;
        if (this.age++ < this.lifetime && !(this.alpha <= 0.0F)) {
            this.xd += (double)(this.random.nextFloat() / 5000.0F * (float)(this.random.nextBoolean() ? 1 : -1)) + ((this.random.nextFloat() - 0.5F) / 200.0F);
            this.zd += (double)(this.random.nextFloat() / 5000.0F * (float)(this.random.nextBoolean() ? 1 : -1)) + ((this.random.nextFloat() - 0.5F) / 200.0F);
            this.yd -= (double)this.gravity;
            this.move(this.xd, this.yd, this.zd);
            if (this.age >= this.lifetime - 60 && this.alpha > 0.01F) {
                this.alpha -= 0.015F;
            }

        } else {
            this.remove();
        }
    }

    public ParticleRenderType getRenderType() {
        return ParticleRenderType.PARTICLE_SHEET_TRANSLUCENT;
    }

    @OnlyIn(Dist.CLIENT)
    public static class Provider implements ParticleProvider<SimpleParticleType> {
        private final SpriteSet sprites;

        public Provider(SpriteSet p_105878_) {
            this.sprites = p_105878_;
        }

        public Particle createParticle(SimpleParticleType particleType, ClientLevel level, double p_105891_, double p_105892_, double p_105893_, double p_105894_, double p_105895_, double p_105896_) {
            VolcanicSmokeParticle particle = new VolcanicSmokeParticle(level, p_105891_, p_105892_, p_105893_, p_105894_, p_105895_, p_105896_);
            particle.setAlpha(0.9F);
            particle.pickSprite(this.sprites);
            return particle;
        }
    }
}