package com.shim.celestialexploration.particles;

import com.shim.celestialexploration.CelestialExploration;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.*;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;

public class StunParticle extends TextureSheetParticle {
    private final double xStart;
    private final double zStart;
    final static float radius = .5F;
    final static int divisions = 24;

    protected StunParticle(ClientLevel level, double x, double y, double z, double xd, double yd, double zd) {
        super(level, x, y, z);
        this.xd = xd;
        this.yd = yd;
        this.zd = zd;

        this.x = x + radius * Math.cos(Math.toRadians(0));
        this.z = x + radius * Math.sin(Math.toRadians(0));
        this.y = y;

        this.xStart = x;
        this.zStart = z;

        this.lifetime = 25;
    }

    public ParticleRenderType getRenderType() {
        return ParticleRenderType.PARTICLE_SHEET_OPAQUE;
    }

    public void tick() {
        this.age++;
        if (this.age >= this.lifetime) {
            this.remove();
        } else {
            this.xo = this.x;
            this.yo = this.y;
            this.zo = this.z;

            double angle = (age % divisions) * (360.0 / divisions);

            this.x = this.xStart + radius * Math.cos(Math.toRadians(angle));
            this.z = this.zStart + radius * Math.sin(Math.toRadians(angle));
        }
    }

    @OnlyIn(Dist.CLIENT)
    public static class Provider implements ParticleProvider<SimpleParticleType> {
        private final SpriteSet sprite;

        public Provider(SpriteSet p_107570_) {
            this.sprite = p_107570_;
        }

        public Particle createParticle(SimpleParticleType particle, ClientLevel level, double x, double y, double z, double xd, double yd, double zd) {
            StunParticle portalParticle = new StunParticle(level, x, y, z, xd, yd, zd);
            portalParticle.pickSprite(this.sprite);
            return portalParticle;
        }
    }
}