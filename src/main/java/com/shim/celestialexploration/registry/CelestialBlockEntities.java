package com.shim.celestialexploration.registry;

import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestialexploration.blocks.blockentities.*;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.SkullBlockEntity;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class CelestialBlockEntities {

    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES, CelestialExploration.MODID);

    public static final RegistryObject<BlockEntityType<OxygenCompressorBlockEntity>> OXYGEN_COMPRESSOR_BLOCK_ENTITY = BLOCK_ENTITIES.register("oxygen_compressor", () -> BlockEntityType.Builder.of(OxygenCompressorBlockEntity::new, CelestialBlocks.OXYGEN_COMPRESSOR.get()).build(null));
    public static final RegistryObject<BlockEntityType<LoxTankBlockEntity>> LOX_TANK_BLOCK_ENTITY = BLOCK_ENTITIES.register("lox_tank", () -> BlockEntityType.Builder.of(LoxTankBlockEntity::new, CelestialBlocks.LOX_TANK.get()).build(null));
    public static final RegistryObject<BlockEntityType<WorkbenchBlockEntity>> WORKBENCH_BLOCK_ENTITY = BLOCK_ENTITIES.register("workbench", () -> BlockEntityType.Builder.of(WorkbenchBlockEntity::new, CelestialBlocks.WORKBENCH.get()).build(null));
    public static final RegistryObject<BlockEntityType<GeyserBlockEntity>> GEYSER_BLOCK_ENTITY = BLOCK_ENTITIES.register("geyser", () -> BlockEntityType.Builder.of(GeyserBlockEntity::new, CelestialBlocks.GEYSER.get(), CelestialBlocks.IO_GEYSER.get()).build(null));
    public static final RegistryObject<BlockEntityType<PathwayLightBlockEntity>> PATHWAY_LIGHT_BLOCK_ENTITY = BLOCK_ENTITIES.register("pathway_light", () -> BlockEntityType.Builder.of(PathwayLightBlockEntity::new, CelestialBlocks.PATHWAY_LIGHT.get()).build(null));
    public static final RegistryObject<BlockEntityType<SolarPanelBlockEntity>> SOLAR_PANEL_BLOCK_ENTITY = BLOCK_ENTITIES.register("solar_panel", () -> BlockEntityType.Builder.of(SolarPanelBlockEntity::new, CelestialBlocks.SOLAR_PANEL.get()).build(null));

//    public static final RegistryObject<BlockEntityType<DisplayBoardBlockEntity>> DISPLAY_BOARD_BLOCK_ENTITY = BLOCK_ENTITIES.register("display_board", () -> BlockEntityType.Builder.of(DisplayBoardBlockEntity::new, BlockRegistry.RED_DISPLAY_BOARD.get(), BlockRegistry.BLACK_DISPLAY_BOARD.get(), BlockRegistry.BLUE_DISPLAY_BOARD.get(), BlockRegistry.WHITE_DISPLAY_BOARD.get(), BlockRegistry.RED_WALL_DISPLAY_BOARD.get(), BlockRegistry.BLACK_WALL_DISPLAY_BOARD.get(), BlockRegistry.BLUE_WALL_DISPLAY_BOARD.get(), BlockRegistry.WHITE_WALL_DISPLAY_BOARD.get()).build(null));


    public static final RegistryObject<BlockEntityType<SkullBlockEntity>> CELESTIAL_SKULLS_BLOCK_ENTITY = BLOCK_ENTITIES.register("celestial_skulls", () -> BlockEntityType.Builder.of(SkullBlockEntity::new, CelestialBlocks.LURKER_HEAD.get(), CelestialBlocks.LURKER_WALL_HEAD.get(), CelestialBlocks.VOIDED_HEAD.get(), CelestialBlocks.VOIDED_WALL_HEAD.get()
//            , BlockRegistry.MECHADOG_HEAD.get(), BlockRegistry.MECHADOG_WALL_HEAD.get()
    ).build(null));


    public static final RegistryObject<BlockEntityType<TaxiStationBlockEntity>> TAXI_STATION_BLOCK_ENTITY = BLOCK_ENTITIES.register("taxi_station", () -> BlockEntityType.Builder.of(TaxiStationBlockEntity::new, CelestialBlocks.TAXI_STATION.get()).build(null));

}
