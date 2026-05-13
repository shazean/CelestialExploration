package com.shim.celestialexploration.entity.monster.slimes;

import com.shim.celestialexploration.registry.CelestialParticles;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.Slime;
import net.minecraft.world.level.Level;

public abstract class AbstractQuicksilverSlime extends AbstractCelestialSlime {
    protected static final int CONVERSION_TIME = 120; //180;
    protected int currentConversionTime = 300;

    public AbstractQuicksilverSlime(EntityType<? extends Slime> p_33588_, Level p_33589_) {
        super(p_33588_, p_33589_, CelestialParticles.QUICKSILVER_SLIME_PARTICLES.get());
    }

    protected void setSize(int size) {
        super.setSize(size, true);
    }

    protected abstract void convertSlime();

}