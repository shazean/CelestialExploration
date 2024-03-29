package com.shim.celestialexploration.registry;

import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestialexploration.inventory.menus.OxygenCompressorMenu;
import com.shim.celestialexploration.inventory.menus.SpaceshipMenu;
import com.shim.celestialexploration.inventory.menus.WorkbenchMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class MenuRegistry {

    private static final DeferredRegister<MenuType<?>> MENUS = DeferredRegister.create(ForgeRegistries.CONTAINERS, CelestialExploration.MODID);

    public static void register(IEventBus event) {
        MENUS.register(event);
    }

    public static final RegistryObject<MenuType<OxygenCompressorMenu>> OXYGEN_COMPRESSOR_MENU = MENUS.register("oxygen_compressor", () -> IForgeMenuType.create(OxygenCompressorMenu::new));
    public static final RegistryObject<MenuType<SpaceshipMenu>> SPACESHIP_MENU = MENUS.register("spaceship", () -> IForgeMenuType.create(SpaceshipMenu::new));
    //    public static final RegistryObject<MenuType<AssemblyStationMenu>> ASSEMBLY_MENU = MENUS.register("assembly_menu", () -> IForgeMenuType.create(AssemblyStationMenu::new));
    public static final RegistryObject<MenuType<WorkbenchMenu>> WORKBENCH_MENU = MENUS.register("workbench", () -> IForgeMenuType.create(WorkbenchMenu::new));

}