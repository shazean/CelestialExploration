package com.shim.celestialexploration.registry;

import com.shim.celestialexploration.CelestialExploration;
import net.minecraft.world.entity.decoration.Motive;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class PaintingRegistry {

    public static final DeferredRegister<Motive> PAINTING_MOTIVES = DeferredRegister.create(ForgeRegistries.PAINTING_TYPES, CelestialExploration.MODID);

    public static final RegistryObject<Motive> JUPITER = PAINTING_MOTIVES.register("jupiter", () -> new Motive(16, 16));
    public static final RegistryObject<Motive> ANDROMEDA = PAINTING_MOTIVES.register("andromeda", () -> new Motive(32, 32));
    public static final RegistryObject<Motive> MOONRISE = PAINTING_MOTIVES.register("moonrise", () -> new Motive(32, 16));
    public static final RegistryObject<Motive> MILKY_WAY = PAINTING_MOTIVES.register("milky_way", () -> new Motive(64, 64));
    public static final RegistryObject<Motive> MARS_SUNSET = PAINTING_MOTIVES.register("mars_sunset", () -> new Motive(32, 16));
    public static final RegistryObject<Motive> SOLAR_SYSTEM = PAINTING_MOTIVES.register("solar_system", () -> new Motive(64, 64));
    public static final RegistryObject<Motive> SPACE_MAN = PAINTING_MOTIVES.register("spaceman", () -> new Motive(16, 32));
    public static final RegistryObject<Motive> CONTROL_PANEL_1 = PAINTING_MOTIVES.register("control_panel_1", () -> new Motive(32, 16));
    public static final RegistryObject<Motive> CONTROL_PANEL_2 = PAINTING_MOTIVES.register("control_panel_2", () -> new Motive(32, 16));
    public static final RegistryObject<Motive> SPACESHIP = PAINTING_MOTIVES.register("spaceship", () -> new Motive(64, 32));
    public static final RegistryObject<Motive> SPACESHIP_BLUEPRINT = PAINTING_MOTIVES.register("spaceship_blueprint", () -> new Motive(16, 16));

}