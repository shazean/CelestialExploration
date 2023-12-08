package com.shim.celestialexploration.registry;

import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestialexploration.effects.GravityEffect;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraftforge.common.ForgeMod;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class EffectRegistry {
    public static final DeferredRegister<MobEffect> MOB_EFFECTS = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, CelestialExploration.MODID);

    public static final RegistryObject<MobEffect> LOW_GRAVITY = MOB_EFFECTS.register("low_gravity", () -> new GravityEffect(MobEffectCategory.NEUTRAL, 5926017).addAttributeModifier(ForgeMod.ENTITY_GRAVITY.get(), "503FE595-3498-8478-234A-3EC09BF892EF", -0.045D, AttributeModifier.Operation.ADDITION));
    public static final RegistryObject<MobEffect> HIGH_GRAVITY = MOB_EFFECTS.register("high_gravity", () -> new GravityEffect(MobEffectCategory.NEUTRAL, 5926017).addAttributeModifier(ForgeMod.ENTITY_GRAVITY.get(), "503FE595-3498-8478-234A-3EC09BF892EF", 0.0286D, AttributeModifier.Operation.ADDITION));
    public static final RegistryObject<MobEffect> EXTRA_LOW_GRAVITY = MOB_EFFECTS.register("extra_low_gravity", () -> new GravityEffect(MobEffectCategory.NEUTRAL, 5926017).addAttributeModifier(ForgeMod.ENTITY_GRAVITY.get(), "503FE595-3498-8478-234A-3EC09BF892EF", -0.065D, AttributeModifier.Operation.ADDITION));

    public static void register(IEventBus eventBus) {
        MOB_EFFECTS.register(eventBus);
    }
}