package mod.shim.celestialexploration.registry;

import mod.shim.celestialexploration.Main;
import mod.shim.celestialexploration.tileentity.AssemblyStationTileEntity;
import mod.shim.celestialexploration.tileentity.GeyserTileEntity;
import mod.shim.celestialexploration.tileentity.OxygenCompressorTileEntity;
import mod.shim.celestialexploration.tileentity.ShuttleTileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;


public class RegistryTileEntity {

	
	
	
	
	public static DeferredRegister<TileEntityType<?>> TILE_ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, Main.MODID);
	
	public static void init() {
		TILE_ENTITY_TYPES.register(FMLJavaModLoadingContext.get().getModEventBus());
	}

	
	
	public static final RegistryObject<TileEntityType<OxygenCompressorTileEntity>> OXYGEN_COMPRESSOR_TILE_ENTITY_TYPE = TILE_ENTITY_TYPES.register("oxygen_compressor", 
			() -> TileEntityType.Builder.of(OxygenCompressorTileEntity::new, RegistryBlocks.OXYGEN_COMPRESSOR.get()).build(null));
	
	public static final RegistryObject<TileEntityType<AssemblyStationTileEntity>> ASSEMBLY_STATION_TILE_ENTITY_TYPE = TILE_ENTITY_TYPES.register("assembly_station", 
			() -> TileEntityType.Builder.of(AssemblyStationTileEntity::new, RegistryBlocks.ASSEMBLY_STATION.get()).build(null));
	
//	public static final RegistryObject<TileEntityType<ShuttleTileEntity>> SHUTTLE_TILE_ENTITY_TYPE = TILE_ENTITY_TYPES.register("shuttle", 
//			() -> TileEntityType.Builder.of(ShuttleTileEntity::new, RegistryEntities.SHUTTLE.get()).build(null));


	public static final RegistryObject<TileEntityType<GeyserTileEntity>> GEYSER_TILE_ENTITY_TYPE = TILE_ENTITY_TYPES.register("geyser", 
			() -> TileEntityType.Builder.of(GeyserTileEntity::new, RegistryBlocks.GEYSER.get()).build(null));

	
}