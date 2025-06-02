package com.shim.celestialexploration.entity.ambient;

import com.shim.celestialexploration.entity.client.dispatchers.EurekaDispatcher;
import com.shim.celestialexploration.registry.CelestialItems;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.animal.AbstractFish;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;

import java.util.Random;

public class Eureka extends AbstractFish {
    public final EurekaDispatcher dispatcher;

    public Eureka(EntityType<? extends AbstractFish> p_27461_, Level p_27462_) {
        super(p_27461_, p_27462_);
        this.dispatcher = new EurekaDispatcher(this);
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 3.0D).add(Attributes.MOVEMENT_SPEED, 0.2F);
    }

    @Override
    protected SoundEvent getFlopSound() {
        return SoundEvents.TROPICAL_FISH_FLOP;    }

    @Override
    public ItemStack getBucketItemStack() {
        return new ItemStack(CelestialItems.EUREKA_BUCKET.get());
    }

    public static boolean checkEurekaSpawnRules(EntityType<? extends Entity> p_27578_, LevelAccessor p_27579_, MobSpawnType p_27580_, BlockPos p_27581_, Random p_27582_) {
        return true;
    }

    @Override
    public void tick() {
        super.tick();

        if (this.level.isClientSide) {
            dispatcher.idle();
        }
    }
}