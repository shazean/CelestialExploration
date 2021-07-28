package mod.shim.celestialexploration.registry;

import java.util.Set;

import java.util.function.Supplier;

import javax.annotation.Nullable;

import com.google.common.collect.ImmutableSet;
import com.mojang.datafixers.types.Type;

import mod.shim.celestialexploration.Main;
import mod.shim.celestialexploration.entity.item.ShuttleEntity;
import mod.shim.celestialexploration.tileentity.AssemblyStationTileEntity;
import mod.shim.celestialexploration.tileentity.OxygenCompressorTileEntity;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.tileentity.FurnaceTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Util;
import net.minecraft.util.datafix.TypeReferences;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class RegistryTileEntity {

	
	
	
	
	public static DeferredRegister<TileEntityType<?>> TILE_ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, Main.MODID);
	
	public static void init() {
		TILE_ENTITY_TYPES.register(FMLJavaModLoadingContext.get().getModEventBus());
	}

	
	
	public static final RegistryObject<TileEntityType<OxygenCompressorTileEntity>> OXYGEN_COMPRESSOR_TILE_ENTITY_TYPE = TILE_ENTITY_TYPES.register("oxygen_compressor", 
			() -> TileEntityType.Builder.of(OxygenCompressorTileEntity::new, RegistryBlocks.OXYGEN_COMPRESSOR.get()).build(null));
	
	public static final RegistryObject<TileEntityType<AssemblyStationTileEntity>> ASSEMBLY_STATION_TILE_ENTITY_TYPE = TILE_ENTITY_TYPES.register("assembly_station", 
			() -> TileEntityType.Builder.of(AssemblyStationTileEntity::new, RegistryBlocks.ASSEMBLY_STATION.get()).build(null));

	
}