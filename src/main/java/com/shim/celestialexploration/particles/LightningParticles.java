package com.shim.celestialexploration.particles;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.*;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class LightningParticles extends TextureSheetParticle {
    private final SpriteSet sprites;

    protected LightningParticles(ClientLevel p_108484_, double p_108485_, double p_108486_, double p_108487_, SpriteSet sprites) {
        super(p_108484_, p_108485_, p_108486_, p_108487_, 0.0D, 0.0D, 0.0D);
        this.xd *= 3.7F; //0.3F;
        this.yd = Math.random() * (double) 0.2F + (double) 0.15F;
        this.zd *= 3.7F; //0.3F;
        this.setSize(0.01F, 0.01F);
        this.gravity = 0.0F; //0.01F;
        this.lifetime = (int) (8.0D / (Math.random() * 0.8D + 0.2D));
        this.sprites = sprites;
        this.setSpriteFromAge(sprites);

    }

    public ParticleRenderType getRenderType() {
        return ParticleRenderType.PARTICLE_SHEET_OPAQUE;
    }

    public void tick() {
        this.xo = this.x;
        this.yo = this.y;
        this.zo = this.z;
        if (this.age++ >= this.lifetime) {
            this.remove();
        } else {
            this.setSpriteFromAge(this.sprites);
        }

//        this.xo = this.x;
//        this.yo = this.y;
//        this.zo = this.z;
//        if (this.lifetime-- <= 0) {
//            this.remove();
//        } else {
//            this.yd -= this.gravity;
//            this.move(this.xd, this.yd, this.zd);
//            this.xd *= 0.98F;
//            this.yd *= 0.98F;
//            this.zd *= 0.98F;
//            if (this.onGround) {
//                if (Math.random() < 0.5D) {
//                    this.remove();
//                }
//
//                this.xd *= 0.7F;
//                this.zd *= 0.7F;
//            }
//
//            BlockPos blockpos = new BlockPos(this.x, this.y, this.z);
//            double d0 = Math.max(this.level.getBlockState(blockpos).getCollisionShape(this.level, blockpos).max(Direction.Axis.Y, this.x - (double) blockpos.getX(), this.z - (double) blockpos.getZ()), this.level.getFluidState(blockpos).getHeight(this.level, blockpos));
//            if (d0 > 0.0D && this.y < (double) blockpos.getY() + d0) {
//                this.remove();
//            }
//
//        }
    }

    @OnlyIn(Dist.CLIENT)
    public static class Provider implements ParticleProvider<SimpleParticleType> {
        private final SpriteSet sprite;

        public Provider(SpriteSet p_108492_) {
            this.sprite = p_108492_;
        }

        public Particle createParticle(SimpleParticleType p_108503_, ClientLevel p_108504_, double p_108505_, double p_108506_, double p_108507_, double p_108508_, double p_108509_, double p_108510_) {
            LightningParticles lightningParticle = new LightningParticles(p_108504_, p_108505_, p_108506_, p_108507_, this.sprite);
            lightningParticle.pickSprite(this.sprite);
            return lightningParticle;
        }
    }
}