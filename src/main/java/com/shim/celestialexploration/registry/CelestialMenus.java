package com.shim.celestialexploration.registry;

import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestialexploration.inventory.menus.*;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class CelestialMenus {

    public static final DeferredRegister<MenuType<?>> MENUS = DeferredRegister.create(ForgeRegistries.CONTAINERS, CelestialExploration.MODID);

    public static final RegistryObject<MenuType<OxygenCompressorMenu>> OXYGEN_COMPRESSOR_MENU = MENUS.register("oxygen_compressor", () -> IForgeMenuType.create(OxygenCompressorMenu::new));
    public static final RegistryObject<MenuType<SpaceshipMenu>> SPACESHIP_MENU = MENUS.register("spaceship", () -> IForgeMenuType.create(SpaceshipMenu::new));
    public static final RegistryObject<MenuType<WorkbenchMenu>> WORKBENCH_MENU = MENUS.register("workbench", () -> IForgeMenuType.create(WorkbenchMenu::new));
    public static final RegistryObject<MenuType<PlanetChartMenu>> PLANET_CHART_MENU = MENUS.register("planet_chart_menu", () -> IForgeMenuType.create(PlanetChartMenu::new));
//    public static final RegistryObject<MenuType<SpaceTaxiMenu>> SPACE_TAXI_MENU = MENUS.register("space_taxi_menu", () -> IForgeMenuType.create(SpaceTaxiMenu::new));
//    public static final RegistryObject<MenuType<TaxiStationMenu>> TAXI_STATION_MENU = MENUS.register("taxi_station_menu", () -> IForgeMenuType.create(TaxiStationMenu::new));
public static final RegistryObject<MenuType<BuggyMenu>> BUGGY_MENU = MENUS.register("buggy", () -> IForgeMenuType.create(BuggyMenu::new));

}