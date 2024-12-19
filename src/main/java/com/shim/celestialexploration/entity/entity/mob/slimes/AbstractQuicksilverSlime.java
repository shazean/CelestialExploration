package com.shim.celestialexploration.entity.entity.mob.slimes;

import com.shim.celestialexploration.registry.ParticleRegistry;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Slime;
import net.minecraft.world.level.Level;

public abstract class AbstractQuicksilverSlime extends Slime {
    protected static final int CONVERSION_TIME = 180;
    protected int currentConversionTime = 300;

    public AbstractQuicksilverSlime(EntityType<? extends Slime> p_33588_, Level p_33589_) {
        super(p_33588_, p_33589_);
    }

    public static AttributeSupplier setAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.ATTACK_DAMAGE, 3.0f).build();
    }

    @Override
    protected ParticleOptions getParticleType() {
        return ParticleRegistry.QUICKSILVER_SLIME_PARTICLES.get();
    }

    protected void setSize(int size) {
        super.setSize(size, true);
    }

    protected abstract void convertSlime();

}
