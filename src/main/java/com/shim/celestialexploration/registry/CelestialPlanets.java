package com.shim.celestialexploration.registry;

import com.shim.celestialexploration.config.CelestialCommonConfig;
import com.shim.celestiallib.CelestialLib;
import com.shim.celestiallib.api.world.galaxy.Galaxy;
import com.shim.celestiallib.world.celestials.galaxy.Galaxies;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class CelestialPlanets {

    public static final DeferredRegister<Galaxy> GALAXIES = DeferredRegister.create(Galaxies.GALAXY_REGISTRY.getRegistryName(), CelestialLib.MODID);

    public static final RegistryObject<Galaxy> MILKY_WAY_GALAXY = GALAXIES.register("milky_way_galaxy", () ->
            new Galaxy(CelestialDimensions.MILKY_WAY).guiScale(2)
                    .enableCooldowns(CelestialCommonConfig.SPACESHIP_LIGHT_TRAVEL_MAX_COOLDOWN, CelestialCommonConfig.SPACESHIP_LIGHT_TRAVEL_MIN_COOLDOWN, CelestialCommonConfig.SPACESHIP_LIGHT_TRAVEL_COOLDOWN_DECREMENT));


}
