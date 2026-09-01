package com.shim.celestialexploration.registry;

import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestialexploration.effects.CelestialEffect;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class CelestialEffects {
    public static final DeferredRegister<MobEffect> MOB_EFFECTS = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, CelestialExploration.MODID);

    public static final RegistryObject<MobEffect> STATIC_EFFECT = MOB_EFFECTS.register("static_buildup", () -> new CelestialEffect(MobEffectCategory.HARMFUL, 16050081));
    public static final RegistryObject<MobEffect> SUFFOCATION_EFFECT = MOB_EFFECTS.register("suffocation", () -> new CelestialEffect(MobEffectCategory.HARMFUL, 7443347)
            .addAttributeModifier(Attributes.MOVEMENT_SPEED, "91AEAA56-376B-4498-935B-2F7F68070635", -0.15F, AttributeModifier.Operation.MULTIPLY_TOTAL)
            .addAttributeModifier(Attributes.ATTACK_SPEED, "55FCED67-E92A-486E-9800-B47F202C4386", -0.1F, AttributeModifier.Operation.MULTIPLY_TOTAL));
    public static final RegistryObject<MobEffect> OXYGENATED_EFFECT = MOB_EFFECTS.register("oxygenated", () -> new CelestialEffect(MobEffectCategory.BENEFICIAL, 5562592));

}