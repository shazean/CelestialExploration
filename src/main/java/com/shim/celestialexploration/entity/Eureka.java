package com.shim.celestialexploration.entity;

import com.shim.celestialexploration.registry.ItemRegistry;
import mod.azure.azurelib.core.animatable.GeoAnimatable;
import mod.azure.azurelib.core.animatable.instance.AnimatableInstanceCache;
import mod.azure.azurelib.core.animation.AnimatableManager;
import mod.azure.azurelib.core.animation.AnimationController;
import mod.azure.azurelib.core.animation.RawAnimation;
import mod.azure.azurelib.util.AzureLibUtil;
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
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;

import java.util.Random;

public class Eureka extends AbstractFish implements GeoAnimatable {
    private final AnimatableInstanceCache cache = AzureLibUtil.createInstanceCache(this);

    public Eureka(EntityType<? extends AbstractFish> p_27461_, Level p_27462_) {
        super(p_27461_, p_27462_);
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 3.0D).add(Attributes.MOVEMENT_SPEED, 0.2F);
    }


    @Override
    protected SoundEvent getFlopSound() {
        return SoundEvents.TROPICAL_FISH_FLOP;    }

    @Override
    public ItemStack getBucketItemStack() {
        return new ItemStack(ItemRegistry.EUREKA_BUCKET.get());
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }

    private static final RawAnimation animation = RawAnimation.begin().thenLoop("animation");

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
        controllers.add(new AnimationController<>(this, "eureka", 0, event -> event.setAndContinue(animation)));
    }

    @Override
    public double getTick(Object o) {
        return 0;
    }

    public static boolean checkEurekaSpawnRules(EntityType<? extends Entity> p_27578_, LevelAccessor p_27579_, MobSpawnType p_27580_, BlockPos p_27581_, Random p_27582_) {
        return true;
    }
}