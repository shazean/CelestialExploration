package com.shim.celestialexploration.registry;

import com.shim.celestialexploration.CelestialExploration;

import com.shim.celestialexploration.blocks.containers.SolarPanelContainer;
import net.minecraft.core.BlockPos;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ContainerRegistry {

	public static final DeferredRegister<MenuType<?>> CONTAINERS = DeferredRegister.create(ForgeRegistries.CONTAINERS, CelestialExploration.MODID);

	public static void init() {
		CONTAINERS.register(FMLJavaModLoadingContext.get().getModEventBus());
	}

	public static final RegistryObject<MenuType<SolarPanelContainer>> SOLAR_PANEL_CONTAINER = CONTAINERS.register("solar_panel", () -> IForgeMenuType.create((windowId, inv, data) -> {
		BlockPos pos = data.readBlockPos();
		Level world = inv.player.getCommandSenderWorld();
		return new SolarPanelContainer(windowId, world, pos, inv, inv.player);
	}));


}
