package com.shim.celestialexploration.particles;

import com.shim.celestialexploration.registry.ItemRegistry;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.*;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class CelestialSlimeParticles extends TextureSheetParticle {
    private final float uo;
    private final float vo;

    CelestialSlimeParticles(ClientLevel p_105646_, double p_105647_, double p_105648_, double p_105649_, double p_105650_, double p_105651_, double p_105652_, ItemStack p_105653_) {
        this(p_105646_, p_105647_, p_105648_, p_105649_, p_105653_);
        this.xd *= (double)0.1F;
        this.yd *= (double)0.1F;
        this.zd *= (double)0.1F;
        this.xd += p_105650_;
        this.yd += p_105651_;
        this.zd += p_105652_;
    }

    public ParticleRenderType getRenderType() {
        return ParticleRenderType.TERRAIN_SHEET;
    }

    protected CelestialSlimeParticles(ClientLevel p_105665_, double p_105666_, double p_105667_, double p_105668_, ItemStack p_105669_) {
        super(p_105665_, p_105666_, p_105667_, p_105668_, 0.0D, 0.0D, 0.0D);
        var model = Minecraft.getInstance().getItemRenderer().getModel(p_105669_, p_105665_, (LivingEntity)null, 0);
        this.setSprite(model.getOverrides().resolve(model, p_105669_, p_105665_, null, 0).getParticleIcon(net.minecraftforge.client.model.data.EmptyModelData.INSTANCE));
        this.gravity = 1.0F;
        this.quadSize /= 2.0F;
        this.uo = this.random.nextFloat() * 3.0F;
        this.vo = this.random.nextFloat() * 3.0F;
    }

    protected float getU0() {
        return this.sprite.getU((double)((this.uo + 1.0F) / 4.0F * 16.0F));
    }

    protected float getU1() {
        return this.sprite.getU((double)(this.uo / 4.0F * 16.0F));
    }

    protected float getV0() {
        return this.sprite.getV((double)(this.vo / 4.0F * 16.0F));
    }

    protected float getV1() {
        return this.sprite.getV((double)((this.vo + 1.0F) / 4.0F * 16.0F));
    }

    @OnlyIn(Dist.CLIENT)
    public static class RustProvider implements ParticleProvider<SimpleParticleType> {

        public RustProvider(SpriteSet spriteSet) {}

        public Particle createParticle(SimpleParticleType p_105705_, ClientLevel p_105706_, double p_105707_, double p_105708_, double p_105709_, double p_105710_, double p_105711_, double p_105712_) {
            return new CelestialSlimeParticles(p_105706_, p_105707_, p_105708_, p_105709_, new ItemStack(ItemRegistry.RUSTED_IRON_NUGGET.get()));
        }

    }

    @OnlyIn(Dist.CLIENT)
    public static class LunarProvider implements ParticleProvider<SimpleParticleType> {

        public LunarProvider(SpriteSet spriteSet) {}

        public Particle createParticle(SimpleParticleType p_105705_, ClientLevel p_105706_, double p_105707_, double p_105708_, double p_105709_, double p_105710_, double p_105711_, double p_105712_) {
            return new CelestialSlimeParticles(p_105706_, p_105707_, p_105708_, p_105709_, new ItemStack(ItemRegistry.LUNAR_GOO.get()));
        }

    }

    @OnlyIn(Dist.CLIENT)
    public static class MallowProvider implements ParticleProvider<SimpleParticleType> {

        public MallowProvider(SpriteSet spriteSet) {}

        public Particle createParticle(SimpleParticleType p_105705_, ClientLevel p_105706_, double p_105707_, double p_105708_, double p_105709_, double p_105710_, double p_105711_, double p_105712_) {
            return new CelestialSlimeParticles(p_105706_, p_105707_, p_105708_, p_105709_, new ItemStack(ItemRegistry.MARSHMALLOW_GOO.get()));
        }
    }
}