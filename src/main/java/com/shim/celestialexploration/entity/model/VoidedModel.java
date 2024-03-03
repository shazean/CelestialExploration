package com.shim.celestialexploration.entity.model;

import com.shim.celestialexploration.entity.mob.Voided;
import net.minecraft.client.model.ZombieModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class VoidedModel<V extends Zombie> extends ZombieModel<Voided> {
    public VoidedModel(ModelPart p_170337_) {
        super(p_170337_);
    }


}