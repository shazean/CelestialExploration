package mod.shim.celestialexploration.registry;

import mod.shim.celestialexploration.Main;

import mod.shim.celestialexploration.inventory.container.AssemblyStationContainer;
import mod.shim.celestialexploration.inventory.container.OxygenCompressorContainer;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.inventory.container.FurnaceContainer;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class RegistryContainerType {


	public static DeferredRegister<ContainerType<?>> CONTAINER_TYPES = DeferredRegister.create(ForgeRegistries.CONTAINERS, Main.MODID);
	
	
	public static void init() {
		CONTAINER_TYPES.register(FMLJavaModLoadingContext.get().getModEventBus());
	}

	//Entity types
	public static final RegistryObject<ContainerType<OxygenCompressorContainer>> OXYGEN_COMPRESSOR = CONTAINER_TYPES.register("oxygen_compressor",
			() -> IForgeContainerType.create(OxygenCompressorContainer::new));
	
	public static final RegistryObject<ContainerType<AssemblyStationContainer>> ASSEMBLY_STATION = CONTAINER_TYPES.register("assembly_station",
			() -> IForgeContainerType.create(AssemblyStationContainer::new));



}
