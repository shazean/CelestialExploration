package com.shim.celestialexploration.entity.creatures;

import com.shim.celestialexploration.registry.CelestialEntities;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.animal.horse.Llama;
import net.minecraft.world.level.Level;

public class SpaceTraderLlama extends AbstractSpaceTraderLlama {

    public SpaceTraderLlama(EntityType<? extends AbstractSpaceTraderLlama> p_30939_, Level p_30940_) {
        super(p_30939_, p_30940_);
    }

    protected Llama makeBabyLlama() {
        return CelestialEntities.SPACE_LLAMA.get().create(this.level);
    }
}