package com.shim.celestialexploration.registry;

import com.shim.celestialexploration.CelestialExploration;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ParticleRegistry {

    public static final DeferredRegister<ParticleType<?>> PARTICLES = DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, CelestialExploration.MODID);

    //MOB PARTICLES
    public static final RegistryObject<SimpleParticleType> RUST_SLIME_PARTICLES = PARTICLES.register("rust_slime_particles", () -> new SimpleParticleType(false));
    public static final RegistryObject<SimpleParticleType> LUNAR_SLIME_PARTICLES = PARTICLES.register("lunar_slime_particles", () -> new SimpleParticleType(false));
    public static final RegistryObject<SimpleParticleType> MARS_MALLOW_SLIME_PARTICLES = PARTICLES.register("mars_mallow_slime_particles", () -> new SimpleParticleType(false));
    public static final RegistryObject<SimpleParticleType> SULFUR_CUBE_PARTICLES = PARTICLES.register("sulfur_cube_particles", () -> new SimpleParticleType(false));

    //OTHER PARTICLES
    public static final RegistryObject<SimpleParticleType> SULFUR_PARTICLE = PARTICLES.register("sulfur_particle", () -> new SimpleParticleType(false));
    public static final RegistryObject<SimpleParticleType> SULFUR_FIRE_FLAME = PARTICLES.register("sulfur_fire_flame_particle", () -> new SimpleParticleType(false));

    public static void register(IEventBus eventBus) {
        PARTICLES.register(eventBus);
    }

}

