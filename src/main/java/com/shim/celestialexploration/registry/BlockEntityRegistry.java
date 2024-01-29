package com.shim.celestialexploration.registry;

import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestialexploration.blocks.blockentities.*;
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
    public static final RegistryObject<BlockEntityType<OxygenCompressorBlockEntity>> OXYGEN_COMPRESSOR_BLOCK_ENTITY = BLOCK_ENTITIES.register("oxygen_compressor", () -> BlockEntityType.Builder.of(OxygenCompressorBlockEntity::new, BlockRegistry.OXYGEN_COMPRESSOR.get()).build(null));
    public static final RegistryObject<BlockEntityType<LoxTankBlockEntity>> LOX_TANK_BLOCK_ENTITY = BLOCK_ENTITIES.register("lox_tank", () -> BlockEntityType.Builder.of(LoxTankBlockEntity::new, BlockRegistry.LOX_TANK.get()).build(null));
    public static final RegistryObject<BlockEntityType<WorkbenchBlockEntity>> WORKBENCH_BLOCK_ENTITY = BLOCK_ENTITIES.register("workbench", () -> BlockEntityType.Builder.of(WorkbenchBlockEntity::new, BlockRegistry.WORKBENCH.get()).build(null));
    public static final RegistryObject<BlockEntityType<GeyserBlockEntity>> GEYSER_BLOCK_ENTITY = BLOCK_ENTITIES.register("geyser", () -> BlockEntityType.Builder.of(GeyserBlockEntity::new, BlockRegistry.GEYSER.get()).build(null));
    public static final RegistryObject<BlockEntityType<PathwayLightBlockEntity>> PATHWAY_LIGHT_BLOCK_ENTITY = BLOCK_ENTITIES.register("pathway_light", () -> BlockEntityType.Builder.of(PathwayLightBlockEntity::new, BlockRegistry.PATHWAY_LIGHT.get()).build(null));

}
