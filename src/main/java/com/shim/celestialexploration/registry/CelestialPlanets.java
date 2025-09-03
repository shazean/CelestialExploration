package com.shim.celestialexploration.registry;

import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestiallib.api.world.planet.Moon;
import com.shim.celestiallib.api.world.planet.Planet;
import com.shim.celestiallib.world.celestials.planet.Planets;
import net.minecraft.world.level.Level;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class CelestialPlanets {


    public static final DeferredRegister<Planet> PLANETS = DeferredRegister.create(Planets.PLANETS.getRegistryName(), CelestialExploration.MODID);

    public static final RegistryObject<Planet> OVERWORLD = PLANETS.register("overworld", () -> new Planet(Level.OVERWORLD, CelestialGalaxies.MILKY_WAY_GALAXY.get()));

    public static final RegistryObject<Planet> MOON = PLANETS.register("moon", () -> new Moon(CelestialDimensions.MOON, OVERWORLD.get()));

    public static final RegistryObject<Planet> MARS = PLANETS.register("mars", () -> new Planet(CelestialDimensions.MARS, CelestialGalaxies.MILKY_WAY_GALAXY.get()));
    public static final RegistryObject<Planet> MERCURY = PLANETS.register("mercury", () -> new Planet(CelestialDimensions.MERCURY, CelestialGalaxies.MILKY_WAY_GALAXY.get()));
    public static final RegistryObject<Planet> VENUS = PLANETS.register("venus", () -> new Planet(CelestialDimensions.VENUS, CelestialGalaxies.MILKY_WAY_GALAXY.get()));

    public static final RegistryObject<Planet> JUPITER = PLANETS.register("jupiter", () -> new Planet(CelestialDimensions.JUPITER, CelestialGalaxies.MILKY_WAY_GALAXY.get()));
    public static final RegistryObject<Planet> EUROPA = PLANETS.register("europa", () -> new Moon(CelestialDimensions.EUROPA, JUPITER.get()));
    public static final RegistryObject<Planet> IO = PLANETS.register("io", () -> new Moon(CelestialDimensions.IO, JUPITER.get()));
    public static final RegistryObject<Planet> CALLISTO = PLANETS.register("callisto", () -> new Moon(CelestialDimensions.CALLISTO, JUPITER.get()));
    public static final RegistryObject<Planet> GANYMEDE = PLANETS.register("ganymede", () -> new Moon(CelestialDimensions.GANYMEDE, JUPITER.get()));


}