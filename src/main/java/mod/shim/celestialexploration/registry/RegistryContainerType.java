package mod.shim.celestialexploration.registry;

import mod.shim.celestialexploration.Main;
import mod.shim.celestialexploration.inventory.container.AssemblyStationContainer;
import mod.shim.celestialexploration.inventory.container.OxygenCompressorContainer;
import mod.shim.celestialexploration.inventory.container.ShuttleContainer;
import net.minecraft.inventory.container.ContainerType;
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

	public static final RegistryObject<ContainerType<ShuttleContainer>> SHUTTLE = CONTAINER_TYPES.register("shuttle",
			() -> IForgeContainerType.create(ShuttleContainer::new));


}
