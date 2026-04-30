package com.shim.celestialexploration.registry;

import com.shim.celestialexploration.CelestialExploration;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class CelestialParticles {

    public static final DeferredRegister<ParticleType<?>> PARTICLES = DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, CelestialExploration.MODID);

    //MOB PARTICLES
    public static final RegistryObject<SimpleParticleType> RUST_SLIME_PARTICLES = PARTICLES.register("rust_slime_particles", () -> new SimpleParticleType(false));
    public static final RegistryObject<SimpleParticleType> LUNAR_SLIME_PARTICLES = PARTICLES.register("lunar_slime_particles", () -> new SimpleParticleType(false));
    public static final RegistryObject<SimpleParticleType> MARS_MALLOW_SLIME_PARTICLES = PARTICLES.register("mars_mallow_slime_particles", () -> new SimpleParticleType(false));
    public static final RegistryObject<SimpleParticleType> SULFUR_CUBE_PARTICLES = PARTICLES.register("sulfur_cube_particles", () -> new SimpleParticleType(false));
    public static final RegistryObject<SimpleParticleType> QUICKSILVER_SLIME_PARTICLES = PARTICLES.register("quicksilver_slime_particles", () -> new SimpleParticleType(false));

    //OTHER PARTICLES
    public static final RegistryObject<SimpleParticleType> SULFUR_PARTICLE = PARTICLES.register("sulfur_particle", () -> new SimpleParticleType(false));
    public static final RegistryObject<SimpleParticleType> SULFUR_FIRE_FLAME = PARTICLES.register("sulfur_fire_flame_particle", () -> new SimpleParticleType(false));
    public static final RegistryObject<SimpleParticleType> SULFUR_SPLASH_PARTICLE = PARTICLES.register("sulfur_splash_particle", () -> new SimpleParticleType(false));

    public static final RegistryObject<SimpleParticleType> DUST_PARTICLE = PARTICLES.register("dust_particle", () -> new SimpleParticleType(false));
    public static final RegistryObject<SimpleParticleType> LIGHTNING_PARTICLE = PARTICLES.register("lightning_particle", () -> new SimpleParticleType(false));
    public static final RegistryObject<SimpleParticleType> SHOOTING_STAR_PARTICLE = PARTICLES.register("shooting_star_particle", () -> new SimpleParticleType(false));
    public static final RegistryObject<SimpleParticleType> STUN_PARTICLE = PARTICLES.register("stun_particle", () -> new SimpleParticleType(false));

    //PORTAL PARTICLES
    public static final RegistryObject<SimpleParticleType> MARS_PORTAL_PARTICLES = PARTICLES.register("mars_portal_particles", () -> new SimpleParticleType(false));
    public static final RegistryObject<SimpleParticleType> MOON_PORTAL_PARTICLES = PARTICLES.register("moon_portal_particles", () -> new SimpleParticleType(false));
    public static final RegistryObject<SimpleParticleType> VENUS_PORTAL_PARTICLES = PARTICLES.register("venus_portal_particles", () -> new SimpleParticleType(false));
    public static final RegistryObject<SimpleParticleType> MERCURY_PORTAL_PARTICLES = PARTICLES.register("mercury_portal_particles", () -> new SimpleParticleType(false));
    public static final RegistryObject<SimpleParticleType> JUPITER_PORTAL_PARTICLES = PARTICLES.register("jupiter_portal_particles", () -> new SimpleParticleType(false));
    public static final RegistryObject<SimpleParticleType> EUROPA_PORTAL_PARTICLES = PARTICLES.register("europa_portal_particles", () -> new SimpleParticleType(false));
    public static final RegistryObject<SimpleParticleType> CALLISTO_PORTAL_PARTICLES = PARTICLES.register("callisto_portal_particles", () -> new SimpleParticleType(false));
    public static final RegistryObject<SimpleParticleType> IO_PORTAL_PARTICLES = PARTICLES.register("io_portal_particles", () -> new SimpleParticleType(false));
    public static final RegistryObject<SimpleParticleType> GANYMEDE_PORTAL_PARTICLES = PARTICLES.register("ganymede_portal_particles", () -> new SimpleParticleType(false));

    public static final RegistryObject<SimpleParticleType> SPACESHIP_PARTICLES = PARTICLES.register("spaceship_particles", () -> new SimpleParticleType(false));

    public static final RegistryObject<SimpleParticleType> VOLCANIC_SMOKE_PARTICLES = PARTICLES.register("volcanic_smoke_particles", () -> new SimpleParticleType(false));

}

