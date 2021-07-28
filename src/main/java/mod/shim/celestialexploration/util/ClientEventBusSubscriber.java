package mod.shim.celestialexploration.util;

import mod.shim.celestialexploration.Main;
import mod.shim.celestialexploration.client.gui.screen.AssemblyStationScreen;
import mod.shim.celestialexploration.client.gui.screen.OxygenCompressorScreen;
import mod.shim.celestialexploration.client.render.ShuttleRenderer;
import mod.shim.celestialexploration.registry.RegistryContainerType;
import mod.shim.celestialexploration.registry.RegistryEntities;
import net.minecraft.client.gui.ScreenManager;
import net.minecraft.entity.EntityType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = Main.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientEventBusSubscriber {
	
	@SubscribeEvent
	public static void onClientSetup(FMLClientSetupEvent event) {
		RenderingRegistry.registerEntityRenderingHandler(RegistryEntities.SHUTTLE.get(), ShuttleRenderer::new); //NEW LINE FOR EACH ENTITY
		
	}
	
	@SubscribeEvent
	public static void onRegisterEntities(final RegistryEvent.Register<EntityType<?>> event) {
	}
	
	@SubscribeEvent
	public static void clientSetup(FMLClientSetupEvent event) {
		ScreenManager.register(RegistryContainerType.OXYGEN_COMPRESSOR.get(), OxygenCompressorScreen::new);
		ScreenManager.register(RegistryContainerType.ASSEMBLY_STATION.get(), AssemblyStationScreen::new);

		
		
//		ClientRegistry.bindTileEntityRenderer(RegistryTileEntity.OXYGEN_COMPRESSOR_TILE_ENTITY_TYPE.get(), OxygenCompressorTileEntityRenderer::new);
		
	}

}
