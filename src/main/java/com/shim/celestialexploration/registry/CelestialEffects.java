package com.shim.celestialexploration.registry;

import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestialexploration.effects.StaticBuildupEffect;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class CelestialEffects {
    public static final DeferredRegister<MobEffect> MOB_EFFECTS = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, CelestialExploration.MODID);

    public static final RegistryObject<MobEffect> STATIC_EFFECT = MOB_EFFECTS.register("static_buildup", () -> new StaticBuildupEffect(MobEffectCategory.HARMFUL, 5926017));
}