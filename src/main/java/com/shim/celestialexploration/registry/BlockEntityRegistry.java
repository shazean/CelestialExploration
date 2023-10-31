package com.shim.celestialexploration.registry;

import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestialexploration.blocks.blockentities.LoxTankBlockEntity;
import com.shim.celestialexploration.blocks.blockentities.OxygenCompressorBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class BlockEntityRegistry {

    private static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES, CelestialExploration.MODID);

    public static void register(IEventBus event) {
        BLOCK_ENTITIES.register(event);
    }

//    public static final RegistryObject<BlockEntityType<SolarPanelBlockEntity>> SOLAR_PANEL_BLOCK_ENTITY = BLOCK_ENTITIES.register("solar_panel", () -> BlockEntityType.Builder.of(SolarPanelBlockEntity::new, BlockRegistry.SOLAR_PANEL.get()).build(null));
    //	public static final RegistryObject<BlockEntityType<AssemblyStationBlockEntity>> ASSEMBLY_STATION_BLOCK_ENTITY = BLOCK_ENTITIES.register("assembly_station", () -> BlockEntityType.Builder.of(AssemblyStationBlockEntity::new, BlockRegistry.ASSEMBLY_STATION.get()).build(null));
    public static final RegistryObject<BlockEntityType<OxygenCompressorBlockEntity>> OXYGEN_COMPRESSOR_BLOCK_ENTITY = BLOCK_ENTITIES.register("oxygen_compressor", () -> BlockEntityType.Builder.of(OxygenCompressorBlockEntity::new, BlockRegistry.OXYGEN_COMPRESSOR.get()).build(null));
    public static final RegistryObject<BlockEntityType<LoxTankBlockEntity>> LOX_TANK_BLOCK_ENTITY = BLOCK_ENTITIES.register("lox_tank", () -> BlockEntityType.Builder.of(LoxTankBlockEntity::new, BlockRegistry.LOX_TANK.get()).build(null));

}
