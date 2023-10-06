package com.shim.celestialexploration.registry;

import com.shim.celestialexploration.CelestialExploration;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ContainerRegistry {

	public static final DeferredRegister<MenuType<?>> CONTAINERS = DeferredRegister.create(ForgeRegistries.CONTAINERS, CelestialExploration.MODID);

	public static void register(IEventBus event) {
		CONTAINERS.register(event);
	}

//	public static final RegistryObject<MenuType<SolarPanelContainer>> SOLAR_PANEL_CONTAINER = CONTAINERS.register("solar_panel", () -> IForgeMenuType.create((windowId, inv, data) -> {
//		BlockPos pos = data.readBlockPos();
//		Level world = inv.player.getCommandSenderWorld();
//		return new SolarPanelContainer(windowId, world, pos, inv, inv.player);
//	}));


}
