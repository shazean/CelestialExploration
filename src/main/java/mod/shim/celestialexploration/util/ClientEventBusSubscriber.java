package mod.shim.celestialexploration.util;

import mod.shim.celestialexploration.Main;

import mod.shim.celestialexploration.client.gui.screen.AssemblyStationScreen;
//import mod.shim.celestialexploration.client.gui.screen.OxygenCompressorScreen;
import mod.shim.celestialexploration.client.render.RoverRenderer;
import mod.shim.celestialexploration.client.render.ShuttleRenderer;
import mod.shim.celestialexploration.client.render.mobs.LurkerRenderer;
import mod.shim.celestialexploration.client.render.mobs.slimes.RustSlimeRenderer;
import mod.shim.celestialexploration.client.render.mobs.slimes.SulfuricSlimeRenderer;
import mod.shim.celestialexploration.client.render.mobs.slimes.WhiteSlimeRenderer;
import mod.shim.celestialexploration.registry.RegistryBlocks;
import mod.shim.celestialexploration.registry.RegistryContainerType;
import mod.shim.celestialexploration.registry.RegistryEntities;
import net.minecraft.client.gui.ScreenManager;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
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
//		RenderingRegistry.registerEntityRenderingHandler(RegistryEntities.SHUTTLE.get(), ShuttleRenderer::new); //NEW LINE FOR EACH ENTITY
		
	}
	
	@SubscribeEvent 
	public static void onRegisterEntities(final RegistryEvent.Register<EntityType<?>> event) {
	}
	
	@SubscribeEvent
	public static void clientSetup(FMLClientSetupEvent event) {
//		ScreenManager.register(RegistryContainerType.OXYGEN_COMPRESSOR.get(), OxygenCompressorScreen::new);
		ScreenManager.register(RegistryContainerType.ASSEMBLY_STATION.get(), AssemblyStationScreen::new);
		
		
		RenderTypeLookup.setRenderLayer(RegistryBlocks.THICK_CARBON_AIR.get(), RenderType.cutout());

		RenderingRegistry.registerEntityRenderingHandler(RegistryEntities.ROVER.get(), RoverRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(RegistryEntities.SHUTTLE.get(), ShuttleRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(RegistryEntities.LURKER.get(), LurkerRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(RegistryEntities.RUST_SLIME.get(), RustSlimeRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(RegistryEntities.WHITE_SLIME.get(), WhiteSlimeRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(RegistryEntities.SULFURIC_SLIME.get(), SulfuricSlimeRenderer::new);


				
	}

}
