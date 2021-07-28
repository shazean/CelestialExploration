package mod.shim.celestialexploration.events;

import mod.shim.celestialexploration.Main;
import net.minecraft.world.World;
import net.minecraftforge.event.TickEvent.WorldTickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@EventBusSubscriber(modid = Main.MODID, bus = Bus.FORGE)
public class Events {
	
	@SubscribeEvent
	public static void onWorldTick(WorldTickEvent event) {
		World world = event.world;
//		System.out.println(world.dimensionType().toString());
		
		if (world.dimensionType().toString().equals("mars")) {

		
		
		}
		
	}

}
