package com.shim.celestialexploration.registry;

import com.shim.celestialexploration.CelestialExploration;

import com.shim.celestialexploration.blocks.blockentities.SolarPanelBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class BlockEntityRegistry {

	private static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES, CelestialExploration.MODID);
	
	public static void init() {
		BLOCK_ENTITIES.register(FMLJavaModLoadingContext.get().getModEventBus());
	}
	
	public static final RegistryObject<BlockEntityType<SolarPanelBlockEntity>> SOLAR_PANEL_BLOCK_ENTITY = BLOCK_ENTITIES.register("solar_panel", () -> BlockEntityType.Builder.of(SolarPanelBlockEntity::new, BlockRegistry.SOLAR_PANEL.get()).build(null));
	
}
